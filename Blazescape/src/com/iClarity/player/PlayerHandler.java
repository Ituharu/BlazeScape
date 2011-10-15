package com.iClarity.player;

import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import com.iClarity.misc.*;
import com.iClarity.npcs.*;
import com.iClarity.GameEngine;

public class PlayerHandler {

	public static final int maxPlayers = 200;
	public static Player players[] = new Player[maxPlayers];
	public int playerSlotSearchStart = 1;			// where we start searching at when adding a new player
	public static String kickNick = "";
	public static boolean kickAllPlayers = false;
	public static String messageToAll = "";
	public static int playerCount=0;
	public static String playersCurrentlyOn[] = new String[maxPlayers];
	public static boolean updateAnnounced;
	public static boolean updateRunning;
	public static int updateSeconds;
	public static long updateStartTime;

	public PlayerHandler() {
		for(int i = 0; i < maxPlayers; i++) {
			players[i] = null;
		}
	}

	public void newPlayerClient(java.net.Socket s, String connectedFrom) {
		int slot = -1, i = 1;
		do {
			if(players[i] == null) {
				slot = i;
				break;
			}
			i++;
			if(i >= maxPlayers) i = 0;		// wrap around
		} while(i <= maxPlayers);

		clientHandler newClient = new clientHandler(s, slot);
		newClient.handler = this;
		(new Thread(newClient)).start();
		if(slot == -1) return;		// no free slot found - world is full
		players[slot] = newClient;
		players[slot].connectedFrom = connectedFrom;
                updatePlayerNames();

		playerSlotSearchStart = slot + 1;

		if (playerSlotSearchStart > maxPlayers) {
			playerSlotSearchStart = 1;
		}
	}

	public void destruct() {
		for(int i = 0; i < maxPlayers; i++) {
			if(players[i] == null) continue;
			players[i].destruct();
			players[i] = null;
		}
	}

	public static int getPlayerCount() {
		return playerCount;
	}

	public void updatePlayerNames(){
		playerCount=0;
		for(int i = 0; i < maxPlayers; i++) {
			if(players[i] != null) {
				playersCurrentlyOn[i] = players[i].playerName;
                                playerCount++;
			}
			else {
				playersCurrentlyOn[i] = "";
                        }
		}
	}

	public static boolean isPlayerOn(String playerName) {
		for(int i = 0; i < maxPlayers; i++) {
			if(playersCurrentlyOn[i] != null){
				if(playersCurrentlyOn[i].equalsIgnoreCase(playerName)) return true;
			}
		}
		return false;
	}

	public static int getPlayerID(String playerName) 
{
		for(int i = 0; i < maxPlayers; i++) 
{
			if(playersCurrentlyOn[i] != null)
 {
				if(playersCurrentlyOn[i].equalsIgnoreCase(playerName)) return i;
			}
		}
		return -1;
	}
	public void process() {
		if (messageToAll.length() > 0) {
			int msgTo=1
;
			do {
				if (players[msgTo] != null) {
					players[msgTo].globalMessage=messageToAll;
				}
				msgTo++;
			} while(msgTo < maxPlayers);
			messageToAll="";
		}
		if (kickAllPlayers == true) {
			int kickID = 1;

			do {
				if (players[kickID] != null) {
					players[kickID].isKicked = true;
				}
				kickID++;
			} while(kickID < maxPlayers);
			kickAllPlayers = false;
		}

		for (int i = 0; i < maxPlayers; i++) {
			if (players[i] == null || !players[i].isActive) {
				continue;
			}
			players[i].actionAmount--;
			players[i].preProcessing();
			while(players[i].packetSending());
			players[i].process();
			players[i].postProcessing();
			players[i].getNextPlayerMovement();

			if (players[i].playerName.equalsIgnoreCase(kickNick)) {
				players[i].kick();
				kickNick="";
			}			
			if (players[i].disconnected) {
						clientHandler p = (clientHandler) players[i];
						if (p.tradeStatus > 0) {
							clientHandler p2 = (clientHandler) players[p.tradeWith];
							p2.DeclineTrade();
							p.RemoveAllWindows();
						}
				if(players[i].LogoutDelay == 0) {
                          	for (int i2 = 0; i2 < GameEngine.npcHandler.maxNPCs; i2++) {
					if (GameEngine.npcHandler.npcs[i2] != null && players[i] != null) {
						if (GameEngine.npcHandler.npcs[i2].followPlayer == players[i].playerId && GameEngine.npcHandler.npcs[i2] != null) {
							GameEngine.npcHandler.npcs[i2].IsDead = true;
						}
					} 
				}
				removePlayer(players[i]);
				players[i] = null;
				}
			}
		}
		for (int i = 0; i < maxPlayers; i++) {
			if (players[i] == null || !players[i].isActive) continue;

			Calendar cal = new GregorianCalendar();
			int day = cal.get(Calendar.DAY_OF_MONTH);
			int month = cal.get(Calendar.MONTH);
			int year = cal.get(Calendar.YEAR);
			int calc = ((year * 10000) + (month * 100) + day);
			players[i].playerLastLogin = calc;

			if (players[i].disconnected  && players[i].LogoutDelay == 0) {
                          	for (int i3 = 0; i3 < GameEngine.npcHandler.maxNPCs; i3++) {
					if (GameEngine.npcHandler.npcs[i3] != null && players[i] != null) {
						if (GameEngine.npcHandler.npcs[i3].followPlayer == players[i].playerId) {
							GameEngine.npcHandler.npcs[i3].IsDead = true;
						}
					} 
				}
				removePlayer(players[i]);
				players[i] = null;
			} else {
				if (!players[i].initialized) {
					players[i].initialize();
					players[i].initialized = true;
				} else {
					players[i].update();
				}
			}
		}
		if (updateRunning && !updateAnnounced) {
			updateAnnounced = true;
		}
		if (updateRunning && System.currentTimeMillis() - updateStartTime > (updateSeconds*1000)) {
			kickAllPlayers = true;
			GameEngine.ShutDown = true;
		}
		for(int i = 0; i < maxPlayers; i++) {
			if (players[i] == null || !players[i].isActive) {
				continue;
			}
			players[i].clearUpdateFlags();
		}
	}

	public void updateNPC(Player plr, Stream str) {
		updateBlock.currentOffset = 0;
		
		str.createFrameVarSizeWord(65);
		str.initBitAccess();
		
		str.writeBits(8, plr.npcListSize);
		int size = plr.npcListSize;
		plr.npcListSize = 0;
		for(int i = 0; i < size; i++) {
			if(plr.RebuildNPCList == false && plr.withinDistance(plr.npcList[i]) == true) {
				plr.npcList[i].updateNPCMovement(str);
				plr.npcList[i].appendNPCUpdateBlock(updateBlock);
				plr.npcList[plr.npcListSize++] = plr.npcList[i];
			} else {
				int id = plr.npcList[i].npcId;
				plr.npcInListBitmap[id>>3] &= ~(1 << (id&7));		// clear the flag
				str.writeBits(1, 1);
				str.writeBits(2, 3);		// tells client to remove this npc from list
			}
		}

		// iterate through all npcs to check whether there's new npcs to add
		for(int i = 0; i < NPCHandler.maxNPCs; i++) {
			if(GameEngine.npcHandler.npcs[i] != null) {
				int id = GameEngine.npcHandler.npcs[i].npcId;
				if (plr.RebuildNPCList == false && (plr.npcInListBitmap[id>>3]&(1 << (id&7))) != 0) {
					// npc already in npcList
				} else if (plr.withinDistance(GameEngine.npcHandler.npcs[i]) == false) {
					// out of sight
				} else {
					plr.addNewNPC(GameEngine.npcHandler.npcs[i], str, updateBlock);
				}
			}
		}
		
		plr.RebuildNPCList = false;

		if(updateBlock.currentOffset > 0) {
			str.writeBits(14, 16383);	// magic EOF - needed only when npc updateblock follows
			str.finishBitAccess();

			// append update block
			str.writeBytes(updateBlock.buffer, updateBlock.currentOffset, 0);
		} else {
			str.finishBitAccess();
		}
		str.endFrameVarSizeWord();
	}

	private static Stream updateBlock = new Stream(new byte[10000]);
/*
	public void updatePlayer(Player plr, Stream str) {
		updateBlock.currentOffset = 0;
		
		if (updateRunning && !updateAnnounced) {
			str.createFrame(114);
			str.writeWordBigEndian(updateSeconds*50/30);
		}

		plr.updateThisPlayerMovement(str);		// handles walking/running and teleporting
		boolean saveChatTextUpdate = plr.chatTextUpdateRequired;
		plr.chatTextUpdateRequired = false;
		plr.appendPlayerUpdateBlock(updateBlock);
		plr.chatTextUpdateRequired = saveChatTextUpdate;

		str.writeBits(8, plr.playerListSize);
		int size = plr.playerListSize;

		plr.playerListSize = 0;	
		for (int i = 0; i < size; i++) {

		if ((plr.playerList[i].didTeleport == false)
		&& (plr.didTeleport == false)
		&& (plr.withinDistance(plr.playerList[i]) == true)) {
				plr.playerList[i].updatePlayerMovement(str);
				plr.playerList[i].appendPlayerUpdateBlock(updateBlock);
				plr.playerList[plr.playerListSize++] = plr.playerList[i];
			} else {
				int id = plr.playerList[i].playerId;
				plr.playerInListBitmap[id >> 3] &= ~(1 << (id & 7)); // clear
				// the
				// flag
				str.writeBits(1, 1);
				str.writeBits(2, 3); // tells client to remove this char
				// from list
			}
		}


		for (int i = 0; i < maxPlayers; i++) {
			if (players[i] == null || players[i].isActive == false || players[i] == plr) {
				//not existing, not active or you are that player
			} else {
				int id = players[i].playerId;
				if(plr.didTeleport == false 
				&& ((plr.playerInListBitmap[id>>3]&(1 << (id&7))) != 0)) {
					// player already in playerList
				} else if(plr.withinDistance(players[i]) == false) {
					// out of sight
				} else {
					plr.addNewPlayer(players[i], str, updateBlock);
				}
			}
		}

		if (updateBlock.currentOffset > 0) {
			str.writeBits(11, 2047);
			str.finishBitAccess();
			str.writeBytes(updateBlock.buffer, updateBlock.currentOffset, 0);
		} else {
			str.finishBitAccess();
		}
		str.endFrameVarSizeWord();
	}*/
	public static void updatePlayer(Player plr, Stream str) {
		updateBlock.currentOffset = 0;

		if (updateRunning && !updateAnnounced) {
			str.createFrame(114);
			str.writeWordBigEndian(updateSeconds * 50 / 30);
		}

		// update thisPlayer
		plr.updateThisPlayerMovement(str); // handles walking/running and
		// teleporting
		// do NOT send chat text back to thisPlayer!
		boolean saveChatTextUpdate = plr.chatTextUpdateRequired;
		plr.chatTextUpdateRequired = false;
		plr.appendPlayerUpdateBlock(updateBlock);
		plr.chatTextUpdateRequired = saveChatTextUpdate;

		str.writeBits(8, plr.playerListSize);
		int size = plr.playerListSize;

		// update/remove players that are already in the playerList
		plr.playerListSize = 0; // we're going to rebuild the list right away
		for (int i = 0; i < size; i++) {
			// this update packet does not support teleporting of other players
			// directly
			// instead we're going to remove this player here and readd it right
			// away below
			if ((plr.playerList[i].didTeleport == false)
					&& (plr.didTeleport == false)
					&& (plr.withinDistance(plr.playerList[i]) == true)) {
				plr.playerList[i].updatePlayerMovement(str);
				plr.playerList[i].appendPlayerUpdateBlock(updateBlock);
				plr.playerList[plr.playerListSize++] = plr.playerList[i];
			} else {
				int id = plr.playerList[i].playerId;
				plr.playerInListBitmap[id >> 3] &= ~(1 << (id & 7)); // clear
				// the
				// flag
				str.writeBits(1, 1);
				str.writeBits(2, 3); // tells client to remove this char
				// from list
			}
		}

		// iterate through all players to check whether there's new players to
		// add
		for (int i = 0; i < maxPlayers; i++) {
			if ((players[i] == null) || (players[i].isActive == false)
					|| (players[i] == plr)) {
				// not existing, not active or you are that player
			} else {
				int id = players[i].playerId;
				if ((plr.didTeleport == false)
						&& ((plr.playerInListBitmap[id >> 3] & (1 << (id & 7))) != 0)) {
					// player already in playerList
				} else if (plr.withinDistance(players[i]) == false) {
					// out of sight
				} else {
					plr.addNewPlayer(players[i], str, updateBlock);
				}
			}
		}

		if (updateBlock.currentOffset > 0) {
			str.writeBits(11, 2047); // magic EOF - needed only when player
			// updateblock follows
			str.finishBitAccess();

			// append update block
			str.writeBytes(updateBlock.buffer, updateBlock.currentOffset, 0);
		} else {
			str.finishBitAccess();
		}
		str.endFrameVarSizeWord();
	}

	public int lastchatid = 1;

	private void removePlayer(Player plr) {
		if (plr.Privatechat != 2) {
			for (int i = 1; i < maxPlayers; i++) {
				if (players[i] == null || players[i].isActive == false) {
					continue;
				}
				players[i].pmupdate(plr.playerId, 0);
			}
		}
		plr.destruct();
	}

	public void println_debug(String str, int ID, String Name) {
		System.out.println("[client-"+ID+"-"+Name+"]: "+str);
	}
}
