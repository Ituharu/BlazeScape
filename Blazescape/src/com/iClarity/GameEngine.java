/*
 * Class GameEngine.
 *
 * Version 1.0
 *
 * Created 8th January 2009.
 *
 * @Author Primadude
 */

package com.iClarity;

import java.net.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.*;
import com.iClarity.misc.Misc;
import com.iClarity.event.*;
import com.iClarity.npcs.NPCHandler;
import com.iClarity.player.*;
import com.iClarity.player.Skills.*;
import com.iClarity.player.Minigames.*;
import com.iClarity.world.*;
import com.iClarity.player.packetHandler.*;
import com.iClarity.world.items.ItemHandler;

public class GameEngine implements Runnable {


public static boolean moleHasTeleported = false;
public static int moleTeleports = 0;

public static ArrayList<String> connectedList = new ArrayList<String>();


    public static int Trees = 0;
    public static int[] TREEX = new int[100000];
    public static int[] TREEY = new int[100000];
    public static int[] TREESPAWN = new int[100000];
    public static int[] LOGSLEFT = new int[100000];
    public static int[] LOGS = new int[100000];
    public static int[] TREEID = new int[100000];
    public static int[] TREESTUMP = new int[100000];


    public static int Rocks = 0;
    public static int[] RockX = new int[100000];
    public static int[] RockY = new int[100000];
    public static int[] RockSPAWN = new int[100000];
    public static int[] RockSLEFT = new int[100000];
    public static int[] RockSS = new int[100000];
    public static int[] RockID = new int[100000];
    public static int[] RockSTUMP = new int[100000];

	/*
	 * The port the server is connected to.
	 */
	public static int SERVER_PORT = 43594;

	/*
	 * The time in between each time the main method is called.
	 */
	public static final int cycleTime = 500;

	/*
	 * If the server is updating or not..
	 */
	public static boolean updateServer = false;

	/*
	 * The time in which the server is updated.
	 */
	public static int updateSeconds = 180;

	/*
	 * The time that the server is initialized.
	 */
	public static long startTime;

	/*
	 * The maximum number of connections allowed.
	 */
	public static int MaxConnections;

	/*
	 * The current number of connections.
	 */
	public static String Connections[];

	/*
	 * The current number of connections.
	 */
	public static int ConnectionCount[];

	/*
	 * If the server is shut down.
	 */
	public static boolean ShutDown = false;

	/*
	 * If this exceeds 100, the server shuts down.
	 */
	public static int ShutDownCounter = 0;

	public static Connection conn;

	/*
	 * MYSQL Connection data.
	 */
	public static String MySQLURL = "jdbc:mysql://iclarity.ulmb.com/forums/12976_vbforum";
	public static String MySQLUser = "12976_vbforum";
	public static String MySQLPassword = "rsftw";

	/*
	 * Class variables.
	 */
	public static GameEngine clientHandler = null;
	public static ServerSocket clientListener = null;
	public static boolean shutdownServer = false;
	public static boolean shutdownClientHandler;
	public static PlayerHandler playerHandler = null;
	public static NPCHandler npcHandler = null;
	public static ItemHandler itemHandler = null;
	public static ShopHandler shopHandler = null;
	public static WorldMap WorldMap = null;

	/*
	 * Constructor
	 */
	public GameEngine() {
		/**/
	}

	/*
	 * Main method. This is initialized as soon as server is started.
	 */
	public static void main(String args[]) {
		WorldMap = new WorldMap();
		WorldMap.loadWorldMap();
		EventManager.initialise();
		clientHandler = new GameEngine();
		(new Thread(clientHandler)).start();
		playerHandler = new PlayerHandler();
		npcHandler = new NPCHandler();
		itemHandler = new ItemHandler();
		try {
			WalkingHandler.getSingleton().initialize();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		shopHandler = new ShopHandler();
		int i = 0;
		long l = System.currentTimeMillis();
		long l1 = 0L;
		int j = 0;

		do {
			if (shutdownServer) {
				break;
			}
			if (updateServer) {
				calcTime();
			}

			/*
			 * Processed methods. These are called every 500ms.
			 */
			playerHandler.process();
			Firemaking.process();
			npcHandler.process();
			itemHandler.process();
			shopHandler.process();

			/*
			 * Runs the System's garbage cleaner - cleans any unused data.
			 */
			System.gc();

			long l2 = System.currentTimeMillis() - l;
			l1 += l2;

			if (l2 >= 500L) {
				l2 = 500L;
			}
			try {
				Thread.sleep(500L - l2);
			} catch(Exception exception) {

			}
			l = System.currentTimeMillis();
			float f;

			if (++j % 100 == 0) {
				f = (float)l1 / (float)j;
			}
			if (j % 3600 == 0) {
				System.gc();
			}
			if (ShutDown) {
				if (ShutDownCounter >= 100) {
 					shutdownServer = true;
				}
				ShutDownCounter++;
			}
		} while(true);

		/*
		 * Close down the server.
		 */
		playerHandler.destruct();
		clientHandler.killServer();
		EventManager.getSingleton().shutdown();
		clientHandler = null;
	}

	public Socket acceptSocketSafe(ServerSocket serversocket) {
		boolean flag = false;
		Socket socket = null;

		do {
			try {
				socket = serversocket.accept();
				int i = socket.getInputStream().read();

				if ((i & 0xff) == 14) {
					flag = true;
				}
			} catch(Exception exception) {

			}
		} while(!flag);
        	return socket;
    	}

	public static void calcTime() {
		long l = System.currentTimeMillis();
		updateSeconds = 180 - (int)(l - startTime) / 1000;

		if (updateSeconds == 0) {
			shutdownServer = true;
		}
	}

	/*
	 * Allows connections from clients.
	 */
	public void run() {
		try {
			shutdownClientHandler = false;
			clientListener = new ServerSocket(SERVER_PORT, 1, null);
			Misc.println("Blazescape Reborn running on port " + SERVER_PORT);

			do {
				Socket socket = acceptSocketSafe(clientListener);
				socket.setTcpNoDelay(true);
				String s = socket.getInetAddress().getHostName();
				int i = -1;
				int j = 0;

				do {
					if (j >= MaxConnections) {
						break;
					}
					if (Connections[j] == s) {
						i = ConnectionCount[j];
						break;
					}
					j++;
				} while(true);
				if (i < 1) {
			if (!connectedList.contains(s)) {
					playerHandler.newPlayerClient(socket, s);
					connectedList.add(s);
			} else {
				socket.close();
			}
				} else {
						socket.close();
				}

			} while(true);
		} catch(IOException ioexception) {

		}
		if (!shutdownClientHandler) {
			Misc.println("Port already in use?");
		} else {
			Misc.println("ClientHandler was shut down.");
		}
	}

	/*
	 * Close down the server
	 */
	public void killServer() {
		try {
			shutdownClientHandler = true;

			if (clientListener != null) {
				clientListener.close();
			}
			clientListener = null;
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	static  {
		MaxConnections = 0x186a0;
		Connections = new String[MaxConnections];
		ConnectionCount = new int[MaxConnections];
	}
}
