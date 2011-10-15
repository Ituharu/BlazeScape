/*
 * Loads files with the extention .dat.
 */

package com.iClarity.player.DataFiles;

import java.io.*;

public class DataFiles {

	public DataFiles() {
		/**/
	}

	public static boolean[] itemStackable = new boolean[20000];
	public static boolean[] itemIsNote = new boolean[20000];
	public static boolean[] itemTwoHanded = new boolean[20000];
	public static boolean[] itemTradeable = new boolean[20000];
	public static boolean[] itemSellable = new boolean[20000];

	static {
		int counter = 0;
		int c;

		try {
			FileInputStream dataIn = new FileInputStream(new File("Data/DataFiles/stackable.dat"));

			while ((c = dataIn.read()) != -1) {
				itemStackable[counter] = (c == 0 ? false : true);
				counter++;
			}
			for (int i = 9000; i < 9004; i++) {
				itemStackable[i] = true;
			}
			itemStackable[6570] = false;
			itemStackable[6737] = false;
			itemStackable[6733] = false;
			itemStackable[6568] = false;
			itemStackable[8851] = true;
			itemStackable[7775] = true;
			itemStackable[7945] = true;
			itemStackable[7947] = true;
			itemStackable[8850] = false;
			itemStackable[8849] = false;
			itemStackable[8848] = false;
			itemStackable[8847] = false;
			itemStackable[8846] = false;
			itemStackable[9139] = true;
			itemStackable[9140] = true;
			itemStackable[9141] = true;
			itemStackable[9142] = true;
			itemStackable[9143] = true;
			itemStackable[9144] = true;
			itemStackable[9145] = true;
			itemStackable[8882] = true;
			itemStackable[9187] = true;
			itemStackable[9188] = true;
			itemStackable[9189] = true;
			itemStackable[9190] = true;
			itemStackable[9191] = true;
			itemStackable[9192] = true;
			itemStackable[9193] = true;
			itemStackable[9194] = true;
			itemStackable[9706] = true;
			itemStackable[11227] = true;
			itemStackable[11228] = true;
			itemStackable[11222] = true;
			itemStackable[11217] = true;
			itemStackable[11212] = true;
			dataIn.close();
		} catch (IOException e) {
			System.out.println("Critical error while loading stackabledata! Trace:");
			e.printStackTrace();
		}


		counter = 0;

		try {
			FileInputStream dataIn = new FileInputStream(new File("Data/DataFiles/notes.dat"));

			while ((c = dataIn.read()) != -1) {
				itemIsNote[counter] = (c == 0 ? true : false);
				counter++;
			}
			itemIsNote[7947] = true;
			itemIsNote[392] = true;
			itemIsNote[7945] = true;
			dataIn.close();
		} catch (IOException e) {
			System.out.println("Critical error while loading notedata! Trace:");
			e.printStackTrace();
		}

		counter = 0;

		try {
			FileInputStream dataIn = new FileInputStream(new File("Data/DataFiles/twohanded.dat"));

			while ((c = dataIn.read()) != -1) {
				itemTwoHanded[counter] = (c == 0 ? false : true);
				counter++;
			}
			itemTwoHanded[7158] = true;
			itemTwoHanded[4718] = true;
			itemTwoHanded[1319] = true;
			itemTwoHanded[1317] = true;
			itemTwoHanded[1315] = true;
			itemTwoHanded[1313] = true;
			itemTwoHanded[1311] = true;
			itemTwoHanded[1309] = true;
			itemTwoHanded[1307] = true;
			itemTwoHanded[861] = true;
			itemTwoHanded[4214] = true;
			itemTwoHanded[859] = true;
			itemTwoHanded[11694] = true;
			itemTwoHanded[11696] = true;
			itemTwoHanded[11698] = true;
			itemTwoHanded[11700] = true;
			itemTwoHanded[11730] = true;
			itemTwoHanded[14484] = true;
			itemTwoHanded[18010] = true;
			itemTwoHanded[18012] = true;
			itemTwoHanded[18014] = true;
			itemTwoHanded[18016] = true;
			itemTwoHanded[15156] = true;
			itemTwoHanded[19021] = true;
			itemTwoHanded[19022] = true;
			dataIn.close();
		} catch (IOException e) {
			System.out.println("Critical error while loading twohanded! Trace:");
			e.printStackTrace();
		}

		counter = 0;
		
		try {
			FileInputStream dataIn = new FileInputStream(new File("Data/DataFiles/tradeable.dat"));

			while ((c = dataIn.read()) != -1) {
				itemTradeable[counter] = (c == 0 ? false : true);
				counter++;
			}
			itemTradeable[8850] = false;
			itemTradeable[8849] = false;
			itemTradeable[8848] = false;
			itemTradeable[8847] = false;
			itemTradeable[8846] = false;
			itemTradeable[8845] = false;
			dataIn.close();
		} catch (IOException e) {
			System.out.println("Critical error while loading tradeable! Trace:");
			e.printStackTrace();
		}

		counter = 0;	
	
		try {
			FileInputStream dataIn = new FileInputStream(new File("Data/DataFiles/sellable.dat"));

			while ((c = dataIn.read()) != -1) {
				itemSellable[counter] = (c == 0 ? true : false);
				counter++;
			itemSellable[7386] = true;
			itemSellable[7390] = true;
			itemSellable[7394] = true;
			itemSellable[7370] = true;
			itemSellable[7378] = true;
			itemSellable[11696] = true;
			itemSellable[11694] = true;
			itemSellable[11698] = true;
			}
			dataIn.close();
		} catch (IOException e) {
			System.out.println("Critical error while loading sellable! Trace:");
			e.printStackTrace();
		}
	}
}