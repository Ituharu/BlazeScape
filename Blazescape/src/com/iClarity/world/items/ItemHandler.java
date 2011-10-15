package com.iClarity.world.items;

import java.io.*;
import com.iClarity.misc.*;
import com.iClarity.player.*;
import com.iClarity.GameEngine;

public class ItemHandler {

	public static int[] globalItemController = new int[5001];
	public static int[] globalItemID = new int[5001];
	public static int[] globalItemX = new int[5001];
	public static int[] globalItemY = new int[5001];
	public static int[] globalItemAmount = new int[5001];
	public static int[] globalItemTicks = new int[5001];
	public static int[] DroppedBy = new int[5001];
	public static int[] heightLvl = new int[5001];
	public static String[] DroppedByName = new String[5001];
	public static boolean[] globalItemStatic  = new boolean[5001];
	public ItemList ItemList[] = new ItemList[MaxListedItems];
	public static int showItemTimer = 120;
	public static int hideItemTimer = 120;
	public static int DropItemCount = 0;
	public static int MaxDropItems = 100000;
	public static int MaxListedItems = 10000;
	public static int MaxDropShowDelay = 120;
	public static int SDID = 90;

	public static int[] DroppedItemsID = new int[MaxDropItems];
	public static int[] DroppedItemsX = new int[MaxDropItems];
	public static int[] DroppedItemsY = new int[MaxDropItems];
	public static int[] DroppedItemsN = new int[MaxDropItems];
	public static int[] DroppedItemsH = new int[MaxDropItems];
	public static int[] DroppedItemsDDelay = new int[MaxDropItems];
	public static int[] DroppedItemsSDelay = new int[MaxDropItems];
	public static int[] DroppedItemsDropper = new int[MaxDropItems];
	public static int[] DroppedItemsDeletecount = new int[MaxDropItems];

	public static boolean[] DroppedItemsAlwaysDrop = new boolean[MaxDropItems];

	public ItemHandler() {			
		for (int i = 0; i <= 5000; i++) {
			globalItemController[i] = 0;
			globalItemID[i] = 0;
			globalItemX[i] = 0;
			globalItemY[i] = 0;
			globalItemAmount[i] = 0;
			globalItemTicks[i] = 0;
			globalItemStatic[i]  =	false;
			//DroppedByName[i] = "";
			//DroppedBy[i] = 0;
		}
		for(int i = 0; i < MaxDropItems; i++) {
			ResetItem(i);
		}
		for(int i = 0; i < MaxListedItems; i++) {
			ItemList[i] = null;
		}
		loadItemList("Data/CFG/item.cfg");
	}

	public void process() {
		for (int i = 0; i <= 5000; i++) {
			if (globalItemID[i] != 0) {
				globalItemTicks[i]++;
			}

			if ((hideItemTimer + showItemTimer) == globalItemTicks[i]) {
				if (!globalItemStatic[i]) {
					removeItemAll(globalItemID[i], globalItemX[i], globalItemY[i]);
				}
			}

			if (showItemTimer == globalItemTicks[i]) {	// Phate: Item has expired, show to all
				if(!globalItemStatic[i]) {
					createItemAll(globalItemID[i], globalItemX[i], globalItemY[i], globalItemAmount[i], globalItemController[i]);
				} else
					Misc.println("Item is static");
			}
		}
	}

	public static boolean itemExists(int itemID, int itemX, int itemY) {
		for (int i = 0; i <= 5000; i++) {
			if (globalItemID[i] == itemID && globalItemX[i] == itemX && globalItemY[i] == itemY) {
				return true;
			}
		}
	 	return false;
	}

	public static int itemAmount(int itemID, int itemX, int itemY) {
		for (int i = 0; i <= 5000; i++) {
			if (globalItemID[i] == itemID && globalItemX[i] == itemX && globalItemY[i] == itemY) {
				return globalItemAmount[i];
			}
		}
	 	return 0;
	}

	public static void addItem(int itemID, int itemX, int itemY, int itemAmount, int itemController, boolean itemStatic) {
		for (int i = 0; i <= 5000; i++) {
			if(globalItemID[i] == 0) {
				globalItemController[i] = itemController;
				globalItemID[i] = itemID;
				globalItemX[i] = itemX;
				globalItemY[i] = itemY;
				globalItemAmount[i] = itemAmount;
				globalItemStatic[i] = itemStatic;
				globalItemTicks[i] = 0;

				if (globalItemController[i] != -1 && globalItemController[i] != 0)
					spawnItem(globalItemID[i], globalItemX[i], globalItemY[i], globalItemAmount[i], globalItemController[i]);
				break;
			}
		}
	}

	public static void spawnItem(int itemID, int itemX, int itemY, int itemAmount, int playerFor) {
		clientHandler person = (clientHandler) GameEngine.playerHandler.players[playerFor];
                if(person != null)
		person.createGroundItem(itemID, itemX, itemY, itemAmount);
	}

	public static void removeItem(int itemID, int itemX, int itemY, int itemAmount) {
		for (int i = 0; i <= 5000; i++) {	// Phate: Loop through all item spots
			if(globalItemID[i] == itemID && globalItemX[i] == itemX && globalItemY[i] == itemY && globalItemAmount[i] == itemAmount) {
				removeItemAll(globalItemID[i], globalItemX[i], globalItemY[i]);
				globalItemController[i] =	0;
				globalItemID[i] =			0;
				globalItemX[i] =			0;
				globalItemY[i] =			0;
				globalItemAmount[i] =		0;
				globalItemTicks[i] =		0;
				globalItemStatic[i] =	false;
			}
		}
	}

	public static void createItemAll(int itemID, int itemX, int itemY, int itemAmount, int itemController) {
			for (Player p : GameEngine.playerHandler.players){
				if(p != null) {
					clientHandler person = (clientHandler)p;
					if((person.playerName != null || person.playerName != "null") && !(person.playerId == itemController)) {
						if (person.distanceToPoint(itemX, itemY) <= 60) {
							person.createGroundItem(itemID, itemX, itemY, itemAmount);
						}
					}
				}
			}
	}

	public static void removeItemAll(int itemID, int itemX, int itemY) {
			for (Player p : GameEngine.playerHandler.players){
				if (p != null) {
					clientHandler person = (clientHandler)p;
					if (person.playerName != null || person.playerName != "null") {
						if (person.distanceToPoint(itemX, itemY) <= 60) {
							person.removeGroundItem(itemX, itemY, itemID);
						}
					}
				}
			}
	}

	public void ResetItem(int ArrayID) {
		DroppedItemsID[ArrayID] = -1;
		DroppedItemsX[ArrayID] = -1;
		DroppedItemsY[ArrayID] = -1;
		DroppedItemsN[ArrayID] = -1;
		DroppedItemsH[ArrayID] = -1;
		DroppedItemsDDelay[ArrayID] = -1;
		DroppedItemsSDelay[ArrayID] = 0;
		DroppedItemsDropper[ArrayID] = -1;
		DroppedItemsDeletecount[ArrayID] = 0;
		DroppedItemsAlwaysDrop[ArrayID] = false;
	}

	public boolean loadDrops(String FileName) {
		String line = "";
		String token = "";
		String token2 = "";
		String token2_2 = "";
		String[] token3 = new String[10];
		boolean EndOfFile = false;
		int ReadMode = 0;
		BufferedReader characterfile = null;
		try {
			characterfile = new BufferedReader(new FileReader("./"+FileName));
		} catch(FileNotFoundException fileex) {
			Misc.println(FileName+": file not found.");
			return false;
		}
		try {
			line = characterfile.readLine();
		} catch(IOException ioexception) {
			Misc.println(FileName+": error loading file.");
			return false;
		}
		while(EndOfFile == false && line != null) {
			line = line.trim();
			int spot = line.indexOf("=");
			if (spot > -1) {
				token = line.substring(0, spot);
				token = token.trim();
				token2 = line.substring(spot + 1);
				token2 = token2.trim();
				token2_2 = token2.replaceAll("\t\t", "\t");
				token2_2 = token2_2.replaceAll("\t\t", "\t");
				token2_2 = token2_2.replaceAll("\t\t", "\t");
				token2_2 = token2_2.replaceAll("\t\t", "\t");
				token2_2 = token2_2.replaceAll("\t\t", "\t");
				token3 = token2_2.split("\t");
				if (token.equals("drop")) {
					int id = Integer.parseInt(token3[0]);
					int x = Integer.parseInt(token3[1]);
					int y = Integer.parseInt(token3[2]);
					int amount = Integer.parseInt(token3[3]);
					int height = Integer.parseInt(token3[4]); 
                                        for (int i = 0; i < 5000; i++)
                                        {
                                        createItemAll(id, x, y, amount, globalItemController[i]);
                                        }
				}
			} else {
				if (line.equals("[ENDOFDROPLIST]")) {
					try { characterfile.close(); } catch(IOException ioexception) { }
					return true;
				}
			}
			try {
				line = characterfile.readLine();
			} catch(IOException ioexception1) { EndOfFile = true; }
		}
		try { characterfile.close(); } catch(IOException ioexception) { }
		return false;
	}

	public void newItemList(int ItemId, String ItemName, String ItemDescription, double ShopValue, double LowAlch, double HighAlch, int Bonuses[]) {
		int slot = -1;
		for (int i = 0; i < 9999; i++) {
			if (ItemList[i] == null) {
				slot = i;
				break;
			}
		}

		if(slot == -1) return;		// no free slot found

		ItemList newItemList = new ItemList(ItemId);
		newItemList.itemName = ItemName;
		newItemList.itemDescription = ItemDescription;
		newItemList.ShopValue = ShopValue;
		newItemList.LowAlch = LowAlch;
		newItemList.HighAlch = HighAlch;
		newItemList.Bonuses = Bonuses;
		ItemList[slot] = newItemList;
	}

	public boolean loadItemList(String FileName) {
		String line = "";
		String token = "";
		String token2 = "";
		String token2_2 = "";
		String[] token3 = new String[10];
		boolean EndOfFile = false;
		int ReadMode = 0;
		BufferedReader characterfile = null;
		try {
			characterfile = new BufferedReader(new FileReader("./"+FileName));
		} catch(FileNotFoundException fileex) {
			Misc.println(FileName+": file not found.");
			return false;
		}
		try {
			line = characterfile.readLine();
		} catch(IOException ioexception) {
			Misc.println(FileName+": error loading file.");
			return false;
		}
		while(EndOfFile == false && line != null) {
			line = line.trim();
			int spot = line.indexOf("=");
			if (spot > -1) {
				token = line.substring(0, spot);
				token = token.trim();
				token2 = line.substring(spot + 1);
				token2 = token2.trim();
				token2_2 = token2.replaceAll("\t\t", "\t");
				token2_2 = token2_2.replaceAll("\t\t", "\t");
				token2_2 = token2_2.replaceAll("\t\t", "\t");
				token2_2 = token2_2.replaceAll("\t\t", "\t");
				token2_2 = token2_2.replaceAll("\t\t", "\t");
				token3 = token2_2.split("\t");
				if (token.equals("item")) {
					int[] Bonuses = new int[12];
					for (int i = 0; i < 12; i++) {
						if (token3[(6 + i)] != null) {
							Bonuses[i] = Integer.parseInt(token3[(6 + i)]);
						} else {
							break;
						}
					}
					newItemList(Integer.parseInt(token3[0]), token3[1].replaceAll("_", " "), token3[2].replaceAll("_", " "), Double.parseDouble(token3[4]), Double.parseDouble(token3[4]), Double.parseDouble(token3[6]), Bonuses);
				}
			} else {
				if (line.equals("[ENDOFITEMLIST]")) {
					try { characterfile.close(); } catch(IOException ioexception) { }
					return true;
				}
			}
			try {
				line = characterfile.readLine();
			} catch(IOException ioexception1) { EndOfFile = true; }
		}
		try { characterfile.close(); } catch(IOException ioexception) { }
		return false;
	}


	public boolean isUntradable(int i) {
		for (int j = 0; j < untradable.length; j++) {
			if (untradable[j] == i) {
				return true;
			}
		}
		return false;
	}
	public int untradable[] = {
		6570, 7959, 7960, 7976, 3840, 3842, 3844, 6950, 2412, 2413,
		2414, 2415, 2416, 2417, 8058, 8059, 8060, 8061, 8062, 8063,
		2892, 2893, 7454, 7455, 7456, 7457, 7458, 7459, 7460, 7461,
		7462, 8013, 8014, 8015, 8016, 8017, 8018, 8080, 8081, 8082,
		8083, 8084, 8085, 771, 772, 4031, 6856, 6857, 6858, 6859,
		6860, 6861, 6862, 6863, 1052, 19040, 19041, 19043, 19044, 
		19045, 19034, 19035, 19038, 19033, 19034, 19032, 19039, 
		9747, 9748, 9749, 9750, 9751, 9752, 9753, 9754, 9755, 
		9756, 9757, 9758, 9759, 9760, 9761, 9762, 9763, 9764,
		9765, 9766, 9767, 9768, 9769, 9770, 9771, 9772, 9773,
		9774, 9775, 9776, 9777, 9778, 9779, 9780, 9781, 9782,
		9783, 9784, 9785, 9786, 9787, 9788, 9789, 9790, 9791,
		9792, 9793, 9794, 9795, 9796, 9798, 9799, 9800, 9801,
		9802, 9803, 9804, 9805, 9806, 9807, 9808, 9809, 9810, 
		9811, 9812, 9813, 9814, 19001, 19002, 19004, 19005,
		19014, 19028, 19029, 19047, 19030, 19031
	};
}
