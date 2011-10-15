package com.iClarity.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;
import com.iClarity.*;

/**
 * Represents a client that has connected but has not yet logged in.

 *
 */
public class IOClient {
	
	/**
	 * When the client connected.
	 */
	private long connectedAt;
	
	/**
	 * The timeout value in seconds.
	 */
	private static final int TIMEOUT = 1;
	
	/**
	 * The client's current state.
	 * @author Graham
	 *
	 */
	private static enum State {
		LOGIN_START,
		LOGIN_READ1,
		LOGIN_READ2,
	}
	
	private State state = State.LOGIN_START;

	private Socket socket;
	private String connectedFrom;
	
	private stream outStream = new stream(new byte[client.bufferSize]);
	private stream inStream = new stream(new byte[client.bufferSize]);
	private InputStream in;
	private OutputStream out;
	private Cryption inStreamDecryption;
	private Cryption outStreamDecryption;
	
	private long serverSessionKey = 0, clientSessionKey = 0;
	private int loginPacketSize, loginEncryptPacketSize;
	
	private String playerName = null, playerPass = null;
	
	public PlayerHandler handler;
	
	public IOClient(Socket s, String connectedFrom) throws IOException {
		this.socket = s;
		this.connectedFrom = connectedFrom;
		this.outStream.currentOffset = 0;
		this.inStream.currentOffset = 0;
		this.in = s.getInputStream();
		this.out = s.getOutputStream();
		this.serverSessionKey = ((long)(java.lang.Math.random() * 99999999D) << 32) + (long)(java.lang.Math.random() * 99999999D);
		this.connectedAt = System.currentTimeMillis();
		IOHostList.add(connectedFrom);
	}
	
	public void destruct(boolean close) {
		if (close && this.socket != null) {
			IOHostList.remove(connectedFrom);

			try {
				this.socket.close();
			} catch(Exception e) {}
		}
		this.socket = null;
		this.outStream = null;
		this.inStream = null;
		this.in = null;
		this.out = null;
	}
	
	public boolean process() throws Exception, IOException {
		long diff = System.currentTimeMillis() - connectedAt;

		if (diff > (TIMEOUT*1000)) {
			throw new Exception("Timeout.");
		}
		if (state == State.LOGIN_START) {
			if (fillinStream(2)) {
				if (inStream.readUnsignedByte() != 14) {
					throw new Exception("Expect login byte 14 from client.");
				}
				@SuppressWarnings("unused")
				int namePart = inStream.readUnsignedByte();

				for(int i = 0; i < 8; i++) {
					out.write(0);
				}
				out.write(0);
				outStream.writeQWord(serverSessionKey);
				directFlushoutStream();
				state = State.LOGIN_READ1;
			}
		} else if (state == State.LOGIN_READ1) {
			if (fillinStream(2)) {
				int loginType = inStream.readUnsignedByte();

				if (loginType != 16 && loginType != 18) {
					throw new Exception("Unexpected login type "+loginType);
				}
				loginPacketSize = inStream.readUnsignedByte();
				loginEncryptPacketSize = loginPacketSize-(36+1+1+2);
				Misc.println_debug("LoginPacket size: "+loginPacketSize+", RSA packet size: "+loginEncryptPacketSize);

				if (loginEncryptPacketSize <= 0) {
					throw new Exception("Zero RSA packet size");
				}
				state = State.LOGIN_READ2;
			}
		} else if (state == State.LOGIN_READ2) {
			if (fillinStream(loginPacketSize)) {
				if (inStream.readUnsignedByte() != 255 || inStream.readUnsignedWord() != 317) {
					throw new Exception("Wrong login packet magic ID (expected 255, 317)");
				}
				int lowMemoryVersion = inStream.readUnsignedByte();
				Misc.println_debug("Client type: "+((lowMemoryVersion==1) ? "low" : "high")+" memory version");

				for (int i = 0; i < 9; i++) {
					Misc.println_debug("dataFileVersion["+i+"]: 0x"+Integer.toHexString(inStream.readDWord()));
				}
				loginEncryptPacketSize--;
				int tmp = inStream.readUnsignedByte();
				if(loginEncryptPacketSize != tmp) {
					throw new Exception("Encrypted packet data length ("+loginEncryptPacketSize+") different from length byte thereof ("+tmp+")");
				}
				tmp = inStream.readUnsignedByte();
				if(tmp != 10) {
					throw new Exception("Encrypted packet Id was "+tmp+" but expected 10");
				}
				clientSessionKey = inStream.readQWord();
				serverSessionKey = inStream.readQWord();
				Misc.println("UserId: "+inStream.readDWord());
				playerName = inStream.readString();

				if (playerName == null || playerName.length() == 0) {
					throw new Exception("Blank username.");
				}
				playerPass = inStream.readString();
				Misc.println("Ident: "+playerName+":"+playerPass);

				int sessionKey[] = new int[4];
				sessionKey[0] = (int)(clientSessionKey >> 32);
				sessionKey[1] = (int)clientSessionKey;
				sessionKey[2] = (int)(serverSessionKey >> 32);
				sessionKey[3] = (int)serverSessionKey;

				for(int i = 0; i < 4; i++) {
					Misc.println_debug("inStreamSessionKey["+i+"]: 0x"+Integer.toHexString(sessionKey[i]));
				}
				inStreamDecryption = new Cryption(sessionKey);

				for (int i = 0; i < 4; i++) {
					sessionKey[i] += 50;
				}
				for (int i = 0; i < 4; i++) {
					Misc.println_debug("outStreamSessionKey["+i+"]: 0x"+Integer.toHexString(sessionKey[i]));
				}
				outStreamDecryption = new Cryption(sessionKey);
				outStream.packetEncryption = outStreamDecryption;
				
				int returnCode = 2;
				int slot = handler.getFreeSlot();
				client c = null;

				if (GameEngine.playerHandler.updateRunning) {
					returnCode = 14;
				} else if (slot == -1) {
					returnCode = 7;
				} else if(handler.isPlayerOn(playerName)) {
					returnCode = 5;
				} else {
					PlayerSave loadgame = loadGame(playerName, playerPass);
					if (loadgame != null) {
						if (!playerPass.equals(loadgame.playerPass)) {
							returnCode = 3;
						} else {
							c = new client(socket, slot);
							c.connectedFrom = connectedFrom;
							c.heightLevel = loadgame.playerHeight;

							if (loadgame.playerPosX > 0 && loadgame.playerPosY > 0) {
								c.teleportToX = loadgame.playerPosX;
								c.teleportToY = loadgame.playerPosY;
								c.heightLevel = 0;
							}
							c.playerRights = loadgame.playerRights;
							c.playerItems = loadgame.playerItem;
							c.playerItemsN = loadgame.playerItemN;
							c.playerEquipment = loadgame.playerEquipment;
							c.playerEquipmentN = loadgame.playerEquipmentN;
							c.bankItems = loadgame.bankItems;
							c.bankItemsN = loadgame.bankItemsN;
							c.playerLevel = loadgame.playerLevel;
							c.playerXP = loadgame.playerXP;
						}
					} else {
						c = new client(socket, slot);
					}
				}
				if (c != null) {
					c.playerName = playerName;
					c.playerPass = playerPass;
					c.inStreamDecryption = inStreamDecryption;
					c.outStreamDecryption = outStreamDecryption;
					c.inStream = inStream;
					c.outStream = outStream;
					c.in = in;
					c.out = out;
					c.packetSize = 0;
					c.packetType = -1;
					c.readPtr = 0;
					c.writePtr = 0;
					c.handler = handler;
					c.isActive = true;
				}
				
				// CHANGE ADMINS HERE
				if (playerName.equals("name") && c != null) {
					c.playerRights = 2;
				}
				out.write(returnCode);

				if (returnCode == 2) {
					handler.addClient(slot, c);
					out.write(c.playerRights);
					out.write(0);
					this.socket = null;
				} else {
					out.write(0);
					out.write(0);
				}
				directFlushoutStream();
				return true;
			}
		}
		return false;
	}
	
	public PlayerSave loadGame(String playerName, String playerPass) {
		PlayerSave tempPlayer;


		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("./savedGames/"+playerName+".dat"));
			tempPlayer = (PlayerSave) in.readObject();
			in.close();
		}
		catch(Exception e){
			return null;
		}
		return tempPlayer;
	}
	
	private void directFlushoutStream() throws java.io.IOException {
		out.write(outStream.buffer, 0, outStream.currentOffset);
		outStream.currentOffset = 0;
		out.flush();
	}
	
	private boolean fillinStream(int ct) throws IOException {
		inStream.currentOffset = 0;

		if (in.available() >= ct) {
			inStream.currentOffset = 0;
			in.read(inStream.buffer, 0, ct);
			return true;
		}
		return false;
	}

}