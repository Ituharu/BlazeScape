
package com.iClarity.player.Skills;

import java.util.ArrayList;
import java.io.*;
import com.iClarity.misc.*;
import com.iClarity.player.*;
import com.iClarity.GameEngine;



public class Firemaking
{
	private static ArrayList<Fire> fires = new ArrayList<Fire>(50); // list of fires
	
	// add a fire to the list
	public static void addFire(clientHandler c, int logID)
	{
		if (c.playerLevel[11] >= findLvl(logID))
		{
			fires.add(new Fire(findTime(logID), ((int)(findTime(logID)+(c.getLevelForXP(c.playerXP[11])*.42))), c.absX, c.absY, c.playerId));
			c.addSkillXP(findXP(logID), 11);
			fire(2732, fires.size()-1);
			c.sendMessage("You light the "+c.getItemName(logID)+".");
			c.deleteItem(logID, c.getItemSlot(logID), 1);
			c.startAnimation(733);
		}
		else
			c.sendMessage("You need level "+findLvl(logID)+"+ firemaking to burn "+c.getItemName(logID)+".");
	}
	
	// processing of the fires
	public static void process()
	{
		for (int i = 0; i < fires.size(); i++)
		{
			if (fires.get(i).fireDie())
			{
				fire(6951, i);
				GameEngine.itemHandler.addItem(592, fires.get(i).getCoords()[0], fires.get(i).getCoords()[1], 1, fires.get(i).getController(), false);
				fires.remove(i);
			}
		}
	}
	
	// handles actual fire object
	private static void fire(int fireID, int position)
	{
		for (Player p : GameEngine.playerHandler.players)
		{
			if (p != null)
			{
				clientHandler person = (clientHandler)p;
				if (person.playerName != null || person.playerName != "null")
				{
					if (person.distanceToPoint(fires.get(position).getCoords()[0], fires.get(position).getCoords()[1]) <= 60)
						person.createNewTileObject(fires.get(position).getCoords()[0], fires.get(position).getCoords()[1], fireID, 1, 10);
				}
			}
		}
	}
	
	// find base time for given log
	private static int findTime(int logID)
	{
		switch (logID)
		{
			case 1511:
				return 15;
			case 1521:
				return 17;
			case 1519:
				return 19;
			case 1517:
				return 21;
			case 1515:
				return 23;
			case 1513:
				return 25;
			default:
				return 0;
		}
	}
	
	// find amount of XP to add for making specific fire
	private static int findXP(int logID)
	{
		switch (logID)
		{
			case 1511:
				return 80;
			case 1521:
				return 120;
			case 1519:
				return 180;
			case 1517:
				return 270;
			case 1515:
				return 405;
			case 1513:
				return 607;
			default:
				return 0;
		}
	}
	
	// find the level req for making specific fire
	private static int findLvl(int logID)
	{
		switch (logID)
		{
			case 1511:
				return 1;
			case 1521:
				return 15;
			case 1519:
				return 30;
			case 1517:
				return 47;
			case 1515:
				return 64;
			case 1513:
				return 83;
			default:
				return 0;
		}
	}
}