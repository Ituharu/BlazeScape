package com.iClarity.world;

import java.io.*;
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import com.iClarity.misc.*;

public class WorldMap {

	private static String worldMapDir = "Data/WorldMap/worldmap";

	public static final int maxObjects = 2000000;
	public static int[] objectId = new int [maxObjects];
	public static int[] objectX = new int [maxObjects];
	public static int[] objectY = new int [maxObjects];
	public static int[] objectHeight = new int [maxObjects];
	public static int[] objectType = new int [maxObjects];
	public static int[] objectFace = new int [maxObjects];
	private static int cWorldMap = 0;
	private static int cWorldMap2 = 0;

	private static String worldMapFiles[] = {
		"World1.xml", "World2.xml", "World3.xml",
		"World4.xml", "World5.xml", "World6.xml",
		"World7.xml", "World8.xml", "World9.xml",
		"World10.xml", "World11.xml", "World12.xml",
		"World13.xml", "World14.xml", "World15.xml",
		"World16.xml", "World17.xml", "World18.xml",
		"World19.xml", "World20.xml", "World21.xml",
		"World22.xml", "World23.xml", "World24.xml",
		"World25.xml"
	};

	private static String worldMapNames[] = new String[worldMapFiles.length];
	private static Document worldMaps[] = new Document[worldMapFiles.length];

	public static void reset() {
		for (int i = 0; i < maxObjects; i++) {
			objectId[i] = -1;
			objectX[i] = -1;
			objectY[i] = -1;
			objectHeight[i] = -1;
			objectType[i] = -1;
			objectFace[i] = -1;
		}
	}

	public static void loadWorldMap() {
		RandomAccessFile in = null;
		int counter = 0;
		int toadd = 70;
		byte[] cache = null;
		int ptr = 0;
		long a = System.currentTimeMillis();

		try {
			in = new RandomAccessFile("./Data/WorldMap/worldmap.bin", "r");
			cache = new byte[(int) in.length()];
			in.read(cache, 0, (int) in.length());
			in.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		long took = System.currentTimeMillis()-a;
		System.out.println("Loaded WorldMap In ("+took+" ms)... ");

		for (int i = 0; i < 1280618; i++) {
			try {
				objectId[i] = (((cache[ptr++] & 0xFF) << 8) | (cache[ptr++] & 0xFF));
				objectX[i] = (((cache[ptr++] & 0xFF) << 8) | (cache[ptr++] & 0xFF));
				objectY[i] = (((cache[ptr++] & 0xFF) << 8) | (cache[ptr++] & 0xFF));
				objectHeight[i] = cache[ptr++] & 0xFF;
				objectType[i] = cache[ptr++] & 0xFF;
				objectFace[i] = cache[ptr++] & 0xFF;
			} catch(Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	private static boolean prepareWorldMap(String fileName){
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		File dbFile = new File("./" + worldMapDir + "/" + fileName);

		if (!dbFile.exists() || fileName.indexOf(".xml") < 0) {
			Misc.println("[ERROR]: Unable to load world map: " + fileName);
			return false;
		}
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			worldMaps[cWorldMap] = db.parse("./" + worldMapDir + "/" + fileName);
			worldMapNames[cWorldMap] = fileName.substring(0, fileName.indexOf("."));
		} catch (Exception _ex) {
			return false;
		}
		cWorldMap++;
		return true;
	}

	private static boolean releaseWorldMap(String worldMapName) {
		for (int i = 0; i < worldMapNames.length; i++) {
			if (worldMapNames[i].equalsIgnoreCase(worldMapName)) {
				worldMaps[i] = null;
				System.gc();
				return true;
			}
		}
		return false;
	}

	private static void loadWorldMap(Document worldMap) {
		if (worldMap == null) {
			Misc.println("[ERROR]: world map not found.");
			return ;
		}
		NodeList worldNl = worldMap.getElementsByTagName("worlddb");

		if (worldNl.item(0) == null) {
			return;
		}
		Element worldMaster = (Element) worldNl.item(0);
		Element worldElement = worldMap.getDocumentElement();
		NodeList nl = worldElement.getElementsByTagName("tile");

		if (nl != null && nl.getLength() > 0) {
			for (int i = 0 ; i < nl.getLength(); i++) {
				try {
					Element tile = (Element) nl.item(i);

					if (tile == null) {
						continue;
					}
					int height = Integer.parseInt(tile.getAttribute("height"));

					if (height == -1) {
						continue;
					}
					int tileX = Integer.parseInt(tile.getAttribute("x"));
					int tileY = Integer.parseInt(tile.getAttribute("y"));
					int type = getNumberValue(tile, "type");
					int object = getNumberValue(tile, "object");
					int orientation = getNumberValue(tile, "orientation");
					addObject(tileX, tileY, height, type, object, orientation);
				} catch(Exception _ex) {
					Misc.println("[ERROR]: loading worldobject(" + i + ") failed.");
					_ex.printStackTrace();
					continue;
				}
			}
		}
	}

	public static int getNumberValue(Element ele, String tagName) {
		try {
			int areturn = Integer.parseInt(getTextValue(ele, tagName));
			return areturn;
		} catch(Exception e) {
			return -1;
		}
	}

	public static String getTextValue(Element ele, String tagName) {
		String textVal = null;
		NodeList nl = ele.getElementsByTagName(tagName);

		if (nl != null && nl.getLength() > 0) {
			Element el = (Element) nl.item(0);
 			textVal = el.getFirstChild().getNodeValue();
		}
		return textVal;
	}

	private static void addObject(int tileX, int tileY, int height, int type, int object, int orientation) {
		objectId[cWorldMap2] = object;
		objectX[cWorldMap2] = tileX;
		objectY[cWorldMap2] = tileY;
		objectHeight[cWorldMap2] = height;
		objectType[cWorldMap2] = type;
		objectFace[cWorldMap2] = orientation;
		cWorldMap2++;
	}

	public static boolean isWalkAble(int height, int absX, int absY, int toAbsX, int toAbsY) {
		if (absX == toAbsX && absY == toAbsY) {
			return true;
		}
		if ((toAbsX == 2851 && toAbsY == 3537)
		|| (toAbsY >= 3234 && toAbsY <= 3311 && toAbsX >= 2813 && toAbsX <= 2865)
		|| (toAbsX >= 3431 && toAbsX <= 3449 && toAbsY >= 3562 && toAbsY <= 3579 && height == 2)
		|| (toAbsX >= 3433 && toAbsX <= 3449 && toAbsY >= 3555 && toAbsY <= 3561 && height == 2)
		|| (toAbsX == 3410 && toAbsY == 3565 && height == 1)
		|| (toAbsX == 3410 && toAbsY == 3563 && height == 1)
		|| (toAbsX == 3409 && toAbsY == 3563 && height == 1)
		|| (toAbsX == 3409 && toAbsY == 3566 && height == 1)
		|| (toAbsX == 3415 && toAbsY == 3566 && height == 1)
		|| (toAbsX == 3414 && toAbsY == 3558 && height == 1)
		|| (toAbsX == 3421 && toAbsY == 3563 && height == 1)
		|| (toAbsX == 3419 && toAbsY == 3568 && height == 1)
		|| (toAbsX == 3419 && toAbsY == 3568 && height == 1)
		|| (toAbsX >= 3409 && toAbsX <= 3413 && toAbsY >= 3543 && toAbsY <= 3546 && height == 1)) {
			return true;
		}
		if (toAbsX == 2491 && toAbsY == 3940
		|| (toAbsX == 3416 && toAbsY == 3534 && height == 1)
		|| (toAbsX == 3416 && toAbsY == 3535 && height == 1)
		|| (toAbsX == 3416 && toAbsY == 3536 && height == 1)
		|| (toAbsX == 3416 && toAbsY == 3537 && height == 1)
		|| (toAbsX == 3416 && toAbsY == 3538 && height == 1)
		|| toAbsX == 2491 && toAbsY == 3941
		|| toAbsX == 2491 && toAbsY == 3938
		|| toAbsX == 2491 && toAbsY == 3937
		|| toAbsX == 2492 && toAbsY == 3937
		|| toAbsX == 2493 && toAbsY == 3937
		|| toAbsX == 2494 && toAbsY == 3937
		|| toAbsX == 2489 && toAbsY == 3941
		|| toAbsX == 2489 && toAbsY == 3940
		|| toAbsX == 2489 && toAbsY == 3939
		|| toAbsX == 2489 && toAbsY == 3938
		|| toAbsX == 2489 && toAbsY == 3937
		|| toAbsX == 2489 && toAbsY == 3936
		|| toAbsX == 2489 && toAbsY == 3935
		|| toAbsX == 2490 && toAbsY == 3935
		|| toAbsX == 2491 && toAbsY == 3935
		|| toAbsX == 2492 && toAbsY == 3935
		|| toAbsX == 2493 && toAbsY == 3935
		|| toAbsX == 2494 && toAbsY == 3935
		|| toAbsX == 2471 && toAbsY == 3923
		|| toAbsX == 2472 && toAbsY == 3923
		|| toAbsX == 2473 && toAbsY == 3923
		|| toAbsX == 2474 && toAbsY == 3923
		|| toAbsX == 2475 && toAbsY == 3923
		|| toAbsX == 2476 && toAbsY == 3923
		|| toAbsX == 2477 && toAbsY == 3923
		|| toAbsX == 2478 && toAbsY == 3923
		|| toAbsX == 2479 && toAbsY == 3923
		|| toAbsX == 2480 && toAbsY == 3923
		|| toAbsX == 2481 && toAbsY == 3923
		|| toAbsX == 2482 && toAbsY == 3923
		|| toAbsX == 2483 && toAbsY == 3923
		|| toAbsX == 2484 && toAbsY == 3923
		|| toAbsX == 2485 && toAbsY == 3923
		|| toAbsX == 2491 && toAbsY == 3939) {
			return false;
		}
		int direction1 = getDirection(absX, absY, toAbsX, toAbsY);
		int direction2 = getOppositeDirection(absX, absY, toAbsX, toAbsY);

		if (direction1 == -1 || direction2 == -1) {
			//Misc.println("Direction Bug from(" + absX + "," + absY + ") to (" + toAbsX + "," + toAbsY + ") Height(" + height + ") abs(" + toAbsX + "," + toAbsY + ")");
			return false;
		}
		for (int i = 0; i < maxObjects; i++) {
			if (objectId[i] == -1) {
				continue;
			}
			if (objectHeight[i] != height) {
				continue;
			}
			if (objectType[i] == 22) {
				continue;
			}
			if (objectX[i] == toAbsX && objectY[i] == toAbsY && height == objectHeight[i]) {
				return false;
			}
		}
		return true;
	}

	public static boolean isWalkAble2(int height, int absX, int absY, int pAbsX, int pAbsY) {
		if (absX == pAbsX && absY == pAbsY) {
			return true;
		}
		for (int i = 0; i < maxObjects; i++) {
			if (objectId[i] == -1) {
				continue;
			}
			if (objectHeight[i] != height) {
				continue;
			}
			if (objectType[i] == 22) {
				continue;
			}
			for (int k = 0; k <= (absX - pAbsX); k++) {
				for (int j = 0; j <= (absY - pAbsY); j++) {
					if (objectX[i] == (pAbsX + k) || objectY[i] == (pAbsY + j)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	public static int getOppositeDirection(int absX, int absY, int toAbsX, int toAbsY) {
		if ((absX - 1) == toAbsX && absY == toAbsY) {
			return 2;
		}
		if ((absX + 1) == toAbsX && absY == toAbsY) {
			return 0;
		}
		if (absX == toAbsX && (absY - 1) == toAbsY) {
			return 1;
		}
		if (absX == toAbsX && (absY + 1) == toAbsY) {
			return 3;
		}
		if ((absX - 1) == toAbsX && (absY - 1) == toAbsY) {
			return 11;
		}
		if ((absX + 1) == toAbsX && (absY - 1) == toAbsY) {
			return 10;
		}
		if ((absX - 1) == toAbsX && (absY + 1) == toAbsY) {
			return 8;
		}
		if ((absX + 1) == toAbsX && (absY + 1) == toAbsY) {
			return 9;
		}
		if (absY == toAbsY && (absX - 1) == toAbsX) {
			return 12;
		}
		if (absY == toAbsY && (absX + 1) == toAbsX) {
			return 13;
		}
		return -1;
	}

	public static int getDirection(int absX, int absY, int toAbsX, int toAbsY) {
		if ((absX - 1) == toAbsX && absY == toAbsY) {
			return 0;
		}
		if ((absX + 1) == toAbsX && absY == toAbsY) {
			return 2;
		}
		if (absX == toAbsX && (absY - 1) == toAbsY) {
			return 3;
		}
		if (absX == toAbsX && (absY + 1) == toAbsY) {
			return 1;
		}
		if ((absX - 1) == toAbsX && (absY - 1) == toAbsY) {
			return 9;
		}
		if ((absX + 1) == toAbsX && (absY - 1) == toAbsY) {
			return 8;
		}
		if ((absX - 1) == toAbsX && (absY + 1) == toAbsY) {
			return 10;
		}
		if ((absX + 1) == toAbsX && (absY + 1) == toAbsY) {
			return 11;
		}
		if (absY == toAbsY && (absX - 1) == toAbsX) {
			return 12;
		}
		if (absY == toAbsY && (absX + 1) == toAbsX) {
			return 13;
		}
		return -1;
	}
}