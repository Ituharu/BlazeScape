package com.iClarity.player;

import java.io.*;
import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;
import java.security.*;
import java.lang.String;
import java.util.Timer;
import java.util.TimerTask;
import com.iClarity.misc.*;
import com.iClarity.npcs.*;
import com.iClarity.event.*;
import com.iClarity.GameEngine;
import com.iClarity.player.magic.*;
import com.iClarity.player.Skills.*;
import com.iClarity.player.combat.*;
import com.iClarity.player.DataFiles.*;
import com.iClarity.player.Minigames.*;
import com.iClarity.world.ShopHandler;
import com.iClarity.world.items.ItemHandler;
import com.iClarity.player.packetHandler.*;
import com.iClarity.player.Skills.Crafting.*;

public class clientHandler extends Player implements Runnable {

public Music music = new Music();

public Music getMusic() {
	return music;
}

public Cooking cookingg = new Cooking();

public Cooking getCooking() {
	return cookingg;
}

public Fishing fishingg = new Fishing();

public Fishing getFishing() {
	return fishingg;
}

public Herblore herblore = new Herblore();

public Herblore getHerblore() {
	return herblore;
}

public Fletching fletching = new Fletching();

public Fletching getFletching() {
	return fletching;
}

public Smelting smeltingg = new Smelting();

public Smelting getSmelting() {
	return smeltingg;
}





public int interfaceStage;


	public void viewTo(int coordX, int coordY) {
		viewToX = ((2 * coordX) + 1);
		viewToY = ((2 * coordY) + 1);
		dirUpdate2Required = true;
		updateRequired = true;
	}
/*
 *
 * Reyx's book
 *
 *
 */
	public int page = 0;
	public void histBook1() {
		sendQuest("@whi@History of @dre@BlazeScape", 903);//Title
		sendQuest("@dre@Table of Contents", 843);//line1
		sendQuest("@str@@bla@_________________", 844);//line2
		sendQuest("Page i - Table of Contents", 845);//line3
		sendQuest("Page ii - Copyrights", 846);//line4
		sendQuest("Page iii - Author's Notes", 847);//line5
		sendQuest("Page vi - Prologue", 848);//line6
		sendQuest("", 849);//line7
		sendQuest("", 850);//line8
		sendQuest("", 851);//line9
		sendQuest("", 852);//line10
		sendQuest("", 853);//line11
		sendQuest("@red@Copyrights", 854);//line12
		sendQuest("Everything inside this book", 855);//line13
		sendQuest("is protected by the right", 856);//line14
		sendQuest("to the power of copyright", 857);//line15
		sendQuest("and any usage of content", 858);//line16
		sendQuest("which is contained therein", 859);//line17
		sendQuest("other than BlazeScape", 860);//line18
		sendQuest("is under the subject", 861);//line19
		sendQuest("of the copyright laws", 862);//line20
		sendQuest("and legal action can be used", 863);//line21
		sendQuest("against the party responsible.", 864);//line22
		sendQuest("Page i", 14165);//Page #
		sendQuest("Page ii", 14166);//Page #
		page = 1;
		startAnimation(1350);
		showInterface(837);
	}
	public void histBook2() {
		sendQuest("@whi@History of @dre@BlazeScape", 903);//Title
		sendQuest("@dre@Author's Notes", 843);//line1
		sendQuest("@blu@Originally named:", 844);//line2
		sendQuest("The Gods of BlazeScape", 845);//line3
		sendQuest("Thanks to Wade, Cocoa", 846);//line4
		sendQuest("and Corey", 847);//line5
		sendQuest("", 848);//line6
		sendQuest("Thanks to Xlez (Chris)", 849);//line7
		sendQuest("for getting me started.", 850);//line8
		sendQuest("P.S You're an idiot.", 851);//line9
		sendQuest("", 852);//line10
		sendQuest("-Reyx7 & Alias", 853);//line11
		sendQuest("@dre@Chapter 1", 854);//line12
		sendQuest("Prologue", 855);//line13
		sendQuest("", 856);//line14
		sendQuest("Long ago, nothing existed", 857);//line15
		sendQuest("but vast plains of land", 858);//line16
		sendQuest("that waged all through", 859);//line17
		sendQuest("the world of Gelinor.", 860);//line18
		sendQuest("Times were different back", 861);//line19
		sendQuest("then. Less people were", 862);//line20
		sendQuest("around. Monsters dominated", 863);//line21
		sendQuest("the land. This was a different", 864);//line22
		sendQuest("Page iii", 14165);//Page #
		sendQuest("Page iv", 14166);//Page #
		page = 2;
		startAnimation(3141);
		showInterface(837);
	}
	public void histBook3() {
		sendQuest("@whi@History of @dre@BlazeScape", 903);//Title
		sendQuest("time in every aspect. It", 843);//line1
		sendQuest("was an age of great warriors", 844);//line2
		sendQuest("with powers beyond those", 845);//line3
		sendQuest("of our imaginations. And", 846);//line4
		sendQuest("those who were particularly", 847);//line5
		sendQuest("recognized for their might,", 848);//line6
		sendQuest("were known as the Gods of", 849);//line7
		sendQuest("BlazeScape.", 850);//line8
		sendQuest("", 851);//line9
		sendQuest("These Gods were given names", 852);//line10
		sendQuest("of which they are now", 853);//line11
		sendQuest("respectively called.", 854);//line12
		sendQuest("First was the protector", 855);//line13
		sendQuest("of peace, Saradomin.", 856);//line14
		sendQuest("Fueled by the kindness", 857);//line15
		sendQuest("that others show gave him", 858);//line16
		sendQuest("strength. Righteousness", 859);//line17
		sendQuest("was his most powerful", 860);//line18
		sendQuest("weapon.", 861);//line19
		sendQuest("Second, was Zamorak, vile", 862);//line20
		sendQuest("and evil. Ultimately", 863);//line21
		sendQuest("the God of what we call", 864);//line22
		sendQuest("Page v", 14165);//Page #
		sendQuest("Page vi", 14166);//Page #
		page = 3;
		startAnimation(3141);
		showInterface(837);
	}
	public void histBook4() {
		sendQuest("@whi@History of @dre@BlazeScape", 903);//Title
		sendQuest("hell. Destroyer of", 843);//line1
		sendQuest("all things, he was", 844);//line2
		sendQuest("banished from his throne", 845);//line3
		sendQuest("for killing Zaros. Locked away,", 846);//line4
		sendQuest("but now free and stronger", 847);//line5
		sendQuest("than ever. Hateful deeds,", 848);//line6
		sendQuest("war, and death among", 849);//line7
		sendQuest("all things was his", 850);//line8
		sendQuest("strength and grew", 851);//line9
		sendQuest("stronger faster", 852);//line10
		sendQuest("than ever because of this.", 853);//line11
		sendQuest("Third is Guthix. Master", 854);//line12
		sendQuest("of balance, good nor evil.", 855);//line13
		sendQuest("Nature itself was his", 856);//line14
		sendQuest("prowess. The land, trees,", 857);//line15
		sendQuest("and animals alike. They", 858);//line16
		sendQuest("are his source of might.", 859);//line17
		sendQuest("", 860);//line18
		sendQuest("Soon, people arose and", 861);//line19
		sendQuest("claimed they did not need", 862);//line20
		sendQuest("the Gods anymore.", 863);//line21
		sendQuest("In the rebellion the Gods", 864);//line22
		sendQuest("Page vii", 14165);//Page #
		sendQuest("Page viii", 14166);//Page #
		page = 4;
		startAnimation(3141);
		showInterface(837);
	}
	public void histBook5() {
		sendQuest("@whi@History of @dre@BlazeScape", 903);//Title
		sendQuest("took their last resort,", 843);//line1
		sendQuest("while attempting to keep", 844);//line2
		sendQuest("Zamorak restrained of anger,", 845);//line3
		sendQuest("and fled to different sections", 846);//line4
		sendQuest("of Gelinor. Saradomin resides", 847);//line5
		sendQuest("now in what is called Camelot.", 848);//line6
		sendQuest("Zamorak lurks in the deathly", 849);//line7
		sendQuest("wastelands between Trollhelm", 850);//line8
		sendQuest("and the covetted Wilderness.", 851);//line9
		sendQuest("Guthix took under the ocean.", 852);//line10
		sendQuest("Deep within the ocean he could", 853);//line11
		sendQuest("create balance within the", 854);//line12
		sendQuest("vast lands of Gelinor.", 855);//line13
		sendQuest("Although, it was too", 856);//line14
		sendQuest("peacefuland soon Guthix", 857);//line15
		sendQuest("fell into a deep slumber.", 858);//line16
		sendQuest("", 859);//line17
		sendQuest("", 860);//line18
		sendQuest("", 861);//line19
		sendQuest("", 862);//line20
		sendQuest("", 863);//line21
		sendQuest("", 864);//line22
		sendQuest("Page ix", 14165);//Page #
		sendQuest("Page x", 14166);//Page #
		page = 5;
		startAnimation(3141);
		showInterface(837);
	}

	public int replaceFlax;

	public void flaxTimers() {
		if(replaceFlax > 0) {
			replaceFlax--;
		}
		if(replaceFlax == 1) {
			ReplaceObject3(2449, 3069, 2646, 0, 10);
			ReplaceObject3(2450, 3069, 2646, 0, 10);
			ReplaceObject3(2449, 3070, 2646, 0, 10);
		}
	}

	public int replaceVegetableStall;
	public int replaceVegetableStall2;
	public int replaceGemStall;
	public int replaceBakerStall;
	public int replaceFishStall1;
	public int replaceFishStall2;
	public int replaceFishStall3;

	public void thievingTimers() {
		if(replaceVegetableStall > 0) {
			replaceVegetableStall--;
		}
		if(replaceVegetableStall2 > 0) {
			replaceVegetableStall--;
		}
		if(replaceFishStall1 > 0) {
			replaceFishStall1--;
		}
		if(replaceFishStall2 > 0) {
			replaceFishStall2--;
		}
		if(replaceFishStall3 > 0) {
			replaceFishStall3--;
		}
		if(replaceGemStall > 0) {
			replaceGemStall--;
		}
		if(replaceBakerStall > 0) {
			replaceBakerStall--;
		}
		if(replaceVegetableStall == 1) {
			ReplaceObject3(2517, 3862, 4706, 0, 10);
		}
		if(replaceVegetableStall2 == 1) {
			ReplaceObject3(2600, 3867, 4706, 1, 10);
		}
		if(replaceFishStall1 == 1) {
			ReplaceObject3(2513, 3862, 4705, 0, 10);
		}
		if(replaceFishStall2 == 1) {
			ReplaceObject3(2519, 3866, 4705, 3, 10);
		}
		if(replaceFishStall3 == 1) {
			ReplaceObject3(2606, 3876, 4705, 3, 10);
		}
		if(replaceGemStall == 1) {
			ReplaceObject3(2511, 3866, 2562, 1, 10);
		}
		if(replaceBakerStall == 1) {
			ReplaceObject3(2517, 3869, 2561, 2, 10);
		}
	}

	public void mixIngredients(int firstItem, int secondItem, int addedItem, int reqLevel, String ingredient) {
		if(playerLevel[15] >= reqLevel) {
			deleteItem(firstItem, GetItemSlot(firstItem), 1);
			deleteItem(secondItem, GetItemSlot(secondItem), 1);
			addItem(addedItem, 1);
			startAnimation(363);
			sendMessage("You mix the " + ingredient + " with the vial of water.");
		} else {
			sendMessage("You need a herblore level of at least " + reqLevel + " to mix these ingredients.");
		}
	}


	public void finishPotion(int firstItem, int secondItem, int finishedPot, int givenExp, int reqLevel, String ingredient) {
		if(playerLevel[15] >= reqLevel) {
			deleteItem(firstItem, GetItemSlot(firstItem), 1);
			deleteItem(secondItem, GetItemSlot(secondItem), 1);
			addItem(finishedPot, 1);
			addSkillXP(givenExp, 15);
			startAnimation(363);
			sendMessage("You mix the " + ingredient + " with the unfinished potion.");
		} else {
			sendMessage("You need a herblore level of at least " + reqLevel + " to mix these ingredients.");
		}
	}


public int oreAmountRemaining = 0;

/* *timer that sets whether the player can get something from the table again* */
public int tableDelay = 0;

/* *Timer that checks if the player is at home to know if it should set their minimap to black* */
public int homeObjectsBlack;
public boolean isAtHome = false;

public boolean isFollowingSomething = false;
public void otherFollowCrap() {
		Player p = GameEngine.playerHandler.players[followId];
		int x = 0, y = 0;
		if (p == null)
		{
			x = absX;
			y = absY;
		}
		else if (p != null)
		{
			x = p.absX;
			y = p.absY;
		}
}

	public boolean usingMagic = false;
	public int followDistance = 0;

	public void applyFollowing()
	{
		if (followId > 0)
		{
			Player p = GameEngine.playerHandler.players[followId];
			if (p != null)
			{
				if (p.IsDead || p.NewHP <= 0)
				{
					follow(0, 3, 1);
					return;
				}
				if (!WithinDistance(p.absX, p.absY, absX, absY, 25))
				{
					follow(0, 3, 1);
					return;
				}
			}
			else if (p == null)
			{
				follow(0, 3, 1);
			}
		}
		else if (followId2 > 0)
		{
			NPC npc = GameEngine.npcHandler.npcs[followId2];
			if (npc != null)
			{
				if (npc.IsDead || npc.HP <= 0)
				{
					follow(0, 3, 1);
					return;
				}
				if (!WithinDistance(npc.absX, npc.absY, absX, absY, 25))
				{
					follow(0, 3, 1);
					return;
				}
			}
			else if (npc == null)
			{
				follow(0, 3, 1);
			}
		}
	}


public int[] loginPackets = new int[10];

public int playersOnlineTimer = 0;

public boolean playingPokemonTheme = true;

	public boolean resetSM() {
		if (OriginalWeapon > -1) {
			playerEquipment[playerWeapon] = OriginalWeapon;
			OriginalWeapon = -1;
			playerEquipment[playerShield] = OriginalShield;
			OriginalShield = -1;
		}
		smithing[0] = 0;
		smithing[1] = 0;
		smithing[2] = 0;
		smithing[4] = -1;
		smithing[5] = 0;
		skillX = -1;
		skillY = -1;
		IsUsingSkill = false;
		return true;
	}

public boolean smithing() {
		if (IsItemInBag(2347) == true) {
			int bars = 0;
			int Length = 22;
			int barid = 0;
			int Level = 0;
			int ItemN = 1;

			if (smithing[2] >= 4) {
				barid = (2349 + ((smithing[2] + 1) * 2));
			} else {
				barid = (2349 + ((smithing[2] - 1) * 2));
			}
			if ((smithing[2] == 1) || (smithing[2] == 2)) {
				Length += 1;
			} else if (smithing[2] == 3) {
				Length += 2;
			}
			for (int i = 0; i < Length; i++) {
				if (Item.smithing_frame[(smithing[2] - 1)][i][0] == smithing[4]) {
					bars = Item.smithing_frame[(smithing[2] - 1)][i][3];
					if (smithing[1] == 0) {
						smithing[1] = Item.smithing_frame[(smithing[2] - 1)][i][2];
					}
					ItemN = Item.smithing_frame[(smithing[2] - 1)][i][1];
				}
			}
			if (playerLevel[playerSmithing] >= smithing[1]) {
				if (AreXItemsInBag(barid, bars) == true) {
					if (freeSlots() > 0) {
						if ((smithing[0] == 1)) {
							actionAmount++;
							/*
							 * OriginalWeapon = playerEquipment[playerWeapon];
							 * playerEquipment[playerWeapon] = 2347; // Hammer
							 * OriginalShield = playerEquipment[playerShield];
							 * playerEquipment[playerShield] = -1;
							 */
							sendMessage("You start hammering the bar...");
							
							setAnimation(0x382);
							smithing[0] = 2;
						}
						if ((smithing[0] == 2)) {
							for (int i = 0; i < bars; i++) {
								deleteItem(barid, GetItemSlot(barid),
										playerItemsN[GetItemSlot(barid)]);
							}
							addSkillXP(
									((int) (150.5 * bars * smithing[2] * smithing[3])),
									playerSmithing);
							addItem(smithing[4], ItemN);
							sendMessage("You smith a "
									+ getItemName(smithing[4]) + ".");
							resetAnimation();
							if (smithing[5] <= 1) {
								resetSM();
							} else {
					
								smithing[5] -= 1;
								smithing[0] = 1;
							}
						}
					} else {
						sendMessage("Not enough space in your inventory.");
						resetSM();
						return false;
					}
				} else {
					sendMessage("You need " + bars + " " + getItemName(barid)
							+ " to smith a " + getItemName(smithing[4]));
					resetAnimation();
					resetSM();
				}
			} else {
				sendMessage("You need " + smithing[1] + " "
						+ statName[playerSmithing] + " to smith a "
						+ getItemName(smithing[4]));
				resetSM();
				return false;
			}
		} else {
			sendMessage("You need a " + getItemName(2347) + " to hammer bars.");
			resetSM();
			return false;
		}
		return true;
	}

public void OpenSmithingFrame(int Type) {
		int Type2 = Type - 1;
		int Length = 22;

		if ((Type == 1) || (Type == 2)) {
			Length += 1;
		} else if (Type == 3) {
			Length += 2;
		}
		// Sending amount of bars + make text green if lvl is highenough
		sendFrame126("", 1132); // Wire
		sendFrame126("", 1096);
		sendFrame126("", 11459); // Lantern
		sendFrame126("", 11461);
		sendFrame126("", 1135); // Studs
		sendFrame126("", 1134);
		String bar, color, color2, name = "";

		if (Type == 1) {
			name = "Bronze ";
		} else if (Type == 2) {
			name = "Iron ";
		} else if (Type == 3) {
			name = "Steel ";
		} else if (Type == 4) {
			name = "Mithril ";
		} else if (Type == 5) {
			name = "Adamant ";
		} else if (Type == 6) {
			name = "Rune ";
		}
		for (int i = 0; i < Length; i++) {
			bar = "bar";
			color = "@red@";
			color2 = "@yel@";
			if (Item.smithing_frame[Type2][i][3] > 1) {
				bar = bar + "s";
			}
			if (playerLevel[playerSmithing] >= Item.smithing_frame[Type2][i][2]) {
				color2 = "@whi@";
			}
			int Type3 = Type2;

			if (Type2 >= 3) {
				Type3 = (Type2 + 2);
			}
			if (AreXItemsInBag((2349 + (Type3 * 2)),
					Item.smithing_frame[Type2][i][3]) == true) {
				color = "@gre@";
			}
			sendFrame126(color + "" + Item.smithing_frame[Type2][i][3] + ""
					+ bar, Item.smithing_frame[Type2][i][4]);
			String linux_hack = getItemName(Item.smithing_frame[Type2][i][0]);
			int index = getItemName(Item.smithing_frame[Type2][i][0]).indexOf(
					name);
			if (index > 0) {
				linux_hack = linux_hack.substring(index + 1);
				sendFrame126(linux_hack, Item.smithing_frame[Type2][i][5]);
			}
			// sendFrame126(
			// color2 + ""
			// + getItemName(Item.smithing_frame[Type2][i][0]).replace(name,
			// ""),
			// Item.smithing_frame[Type2][i][5]);
		}
		Item.SmithingItems[0][0] = Item.smithing_frame[Type2][0][0]; // Dagger
		Item.SmithingItems[0][1] = Item.smithing_frame[Type2][0][1];
		Item.SmithingItems[1][0] = Item.smithing_frame[Type2][4][0]; // Sword
		Item.SmithingItems[1][1] = Item.smithing_frame[Type2][4][1];
		Item.SmithingItems[2][0] = Item.smithing_frame[Type2][8][0]; // Scimitar
		Item.SmithingItems[2][1] = Item.smithing_frame[Type2][8][1];
		Item.SmithingItems[3][0] = Item.smithing_frame[Type2][9][0]; // Long
		// Sword
		Item.SmithingItems[3][1] = Item.smithing_frame[Type2][9][1];
		Item.SmithingItems[4][0] = Item.smithing_frame[Type2][18][0]; // 2
		// hand
		// sword
		Item.SmithingItems[4][1] = Item.smithing_frame[Type2][18][1];
		SetSmithing(1119);
		Item.SmithingItems[0][0] = Item.smithing_frame[Type2][1][0]; // Axe
		Item.SmithingItems[0][1] = Item.smithing_frame[Type2][1][1];
		Item.SmithingItems[1][0] = Item.smithing_frame[Type2][2][0]; // Mace
		Item.SmithingItems[1][1] = Item.smithing_frame[Type2][2][1];
		Item.SmithingItems[2][0] = Item.smithing_frame[Type2][13][0]; // Warhammer
		Item.SmithingItems[2][1] = Item.smithing_frame[Type2][13][1];
		Item.SmithingItems[3][0] = Item.smithing_frame[Type2][14][0]; // Battle
		// axe
		Item.SmithingItems[3][1] = Item.smithing_frame[Type2][14][1];
		Item.SmithingItems[4][0] = Item.smithing_frame[Type2][17][0]; // Claws
		Item.SmithingItems[4][1] = Item.smithing_frame[Type2][17][1];
		SetSmithing(1120);
		Item.SmithingItems[0][0] = Item.smithing_frame[Type2][15][0]; // Chain
		// body
		Item.SmithingItems[0][1] = Item.smithing_frame[Type2][15][1];
		Item.SmithingItems[1][0] = Item.smithing_frame[Type2][20][0]; // Plate
		// legs
		Item.SmithingItems[1][1] = Item.smithing_frame[Type2][20][1];
		Item.SmithingItems[2][0] = Item.smithing_frame[Type2][19][0]; // Plate
		// skirt
		Item.SmithingItems[2][1] = Item.smithing_frame[Type2][19][1];
		Item.SmithingItems[3][0] = Item.smithing_frame[Type2][21][0]; // Plate
		// body
		Item.SmithingItems[3][1] = Item.smithing_frame[Type2][21][1];
		Item.SmithingItems[4][0] = -1; // Lantern
		Item.SmithingItems[4][1] = 0;
		if ((Type == 2) || (Type == 3)) {
			color2 = "@red@";
			if (playerLevel[playerSmithing] >= Item.smithing_frame[Type2][22][2]) {
				color2 = "@whi@";
			}
			Item.SmithingItems[4][0] = Item.smithing_frame[Type2][22][0]; // Lantern
			Item.SmithingItems[4][1] = Item.smithing_frame[Type2][22][1];
			sendFrame126(color2 + ""
					+ getItemName(Item.smithing_frame[Type2][22][0]), 11461);
		}
		SetSmithing(1121);
		Item.SmithingItems[0][0] = Item.smithing_frame[Type2][3][0]; // Medium
		Item.SmithingItems[0][1] = Item.smithing_frame[Type2][3][1];
		Item.SmithingItems[1][0] = Item.smithing_frame[Type2][10][0]; // Full
		// Helm
		Item.SmithingItems[1][1] = Item.smithing_frame[Type2][10][1];
		Item.SmithingItems[2][0] = Item.smithing_frame[Type2][12][0]; // Square
		Item.SmithingItems[2][1] = Item.smithing_frame[Type2][12][1];
		Item.SmithingItems[3][0] = Item.smithing_frame[Type2][16][0]; // Kite
		Item.SmithingItems[3][1] = Item.smithing_frame[Type2][16][1];
		Item.SmithingItems[4][0] = Item.smithing_frame[Type2][6][0]; // Nails
		Item.SmithingItems[4][1] = Item.smithing_frame[Type2][6][1];
		SetSmithing(1122);
		Item.SmithingItems[0][0] = Item.smithing_frame[Type2][5][0]; // Dart
		// Tips
		Item.SmithingItems[0][1] = Item.smithing_frame[Type2][5][1];
		Item.SmithingItems[1][0] = Item.smithing_frame[Type2][7][0]; // Arrow
		// Heads
		Item.SmithingItems[1][1] = Item.smithing_frame[Type2][7][1];
		Item.SmithingItems[2][0] = Item.smithing_frame[Type2][11][0]; // Knives
		Item.SmithingItems[2][1] = Item.smithing_frame[Type2][11][1];
		Item.SmithingItems[3][0] = -1; // Wire
		Item.SmithingItems[3][1] = 0;
		if (Type == 1) {
			color2 = "@bla@";
			if (playerLevel[playerSmithing] >= Item.smithing_frame[Type2][22][2]) {
				color2 = "@whi@";
			}
			Item.SmithingItems[3][0] = Item.smithing_frame[Type2][22][0]; // Wire
			Item.SmithingItems[3][1] = Item.smithing_frame[Type2][22][1];
			sendFrame126(color2 + ""
					+ getItemName(Item.smithing_frame[Type2][22][0]), 1096);
		}
		Item.SmithingItems[4][0] = -1; // Studs
		Item.SmithingItems[4][1] = 0;
		if (Type == 3) {
			color2 = "@bla@";
			if (playerLevel[playerSmithing] >= Item.smithing_frame[Type2][23][2]) {
				color2 = "@whi@";
			}
			Item.SmithingItems[4][0] = Item.smithing_frame[Type2][23][0]; // Studs
			Item.SmithingItems[4][1] = Item.smithing_frame[Type2][23][1];
			sendFrame126(color2 + ""
					+ getItemName(Item.smithing_frame[Type2][23][0]), 1134);
		}
		SetSmithing(1123);
		showInterface(994);
		smithing[2] = Type;
	}

public int CheckSmithing(int ItemID, int ItemSlot) {
		boolean GoFalse = false;
		int Type = -1;

		if (IsItemInBag(2347) == false) {
			sendMessage("You need a hammer to hammer bars.");
			return -1;
		}
		switch (ItemID) {
		case 2349:
			// Bronze Bar
			Type = 1;
			break;

		case 2351:
			// Iron Bar
			Type = 2;
			break;

		case 2353:
			// Steel Bar
			Type = 3;
			break;

		case 2359:
			// Mithril Bar
			Type = 4;
			break;

		case 2361:
			// Adamantite Bar
			Type = 5;
			break;

		case 2363:
			// Runite Bar
			Type = 6;
			break;

		default:
			sendMessage("You cannot smith this item.");
			GoFalse = true;
			break;
		}
		if (GoFalse == true) {
			return -1;
		}
		return Type;
	}
//endsmithing

public int restorePrayer = 0;

//In-game highscores
public int playerRank = 0;

public void highScores() {
	clearQuestInterface();
    showInterface(8134);
    sendQuest("@dbl@", 8144);  //Title
    sendQuest("@dre@In-Game Top 10 Highscores", 8145);
    for(int i = 0; i < 10; i++) { // you also need to change this for it to display more, simply the number you want it to display, say 20 = for(int i = 0; i < 20; i++)
        if(ranks[i] > 0) {
            sendQuest("@bla@Rank "+(i+1)+": @dre@"+rankPpl[i]+ "@bla@ - Total Lvl:@whi@ " +ranks[i], 8147+i);
        }
    }
    sendQuestSomething(8143);
	resetRanks();
}

public void resetRanks() {
    for (int i = 0; i < 10; i++) {
        ranks[i] = 0;
        rankPpl[i] = "";
if (playerRights >= 2) {
playerRank = 0;
totalz = 0;
       }
    }
}


//end highscores


public void setSidebarMage() {
try {
outStream.createFrame(106); 
outStream.writeByteC(6);
updateRequired = true; 
appearanceUpdateRequired = true;
} catch(Exception E) {
sendMessage("Error switching sidebar back to the magic interface!");
}
}
public boolean isJailed;
 
	public void SetSmithing(int WriteFrame) {
		outStream.createFrameVarSizeWord(53);
		outStream.writeWord(WriteFrame);
		outStream.writeWord(Item.SmithingItems.length);
		for (int i = 0; i < Item.SmithingItems.length; i++) {
			Item.SmithingItems[i][0] += 1;
			if (Item.SmithingItems[i][1] > 254) {
				outStream.writeByte(255); 						// item's stack count. if over 254, write byte 255
				outStream.writeDWord_v2(Item.SmithingItems[i][1]);	// and then the real value with writeDWord_v2
			} else {
				outStream.writeByte(Item.SmithingItems[i][1]);
			}
			if (Item.SmithingItems[i][0] > 20000 || Item.SmithingItems[i][0] < 0) {
				playerItems[i] = 20000;
			}
			outStream.writeWordBigEndianA(Item.SmithingItems[i][0]); //item id
		}
		outStream.endFrameVarSizeWord();
	}

public int playerJailed = 0;


public void attackPlayersWithin(int gfx, int maxDamage, int range) {
 for (Player p : GameEngine.playerHandler.players)
  {
   if(p != null) 
    {
     clientHandler person = (clientHandler)p;
     if((person.playerName != null || person.playerName != "null"))
      {
       if(person.distanceToPoint(absX, absY) <= range && person.playerId != playerId)
        {
         int damage = Misc.random(maxDamage);
         person.stillgfx(gfx, person.absY, person.absX);
         if (person.playerLevel[3] - hitDiff < 0) 
         damage = person.playerLevel[3];
	 person.appendHit(damage);
	 person.KillerId = playerId;
	 person.JailerID = playerId;
	 person.updateRequired = true;
	 person.hitUpdateRequired = true;
        }
      }
    }
  }
}


/*
 *Start of Mining
 */
	public int GetPickAni() {
		int PickAni = 0;
		int Pick = playerEquipment[playerWeapon];
		if (Pick == 1265) {//bronze
			PickAni = 625;
		} else if (Pick == 1267) {//iron
			PickAni = 626;
		} else if (Pick == 1269) {//steel
			PickAni = 627;
		} else if (Pick == 1273) {//mithril
			PickAni = 629;
		} else if (Pick == 1271) {//adamant
			PickAni = 628;
		} else if (Pick == 1275) {//rune
			PickAni = 624;
		} else if (Pick == 15259) {//D pick
			PickAni = 2067;
		}
		if (AreXItemsInBag(1265, 1)) {
			PickAni = 625;
		} else if (AreXItemsInBag(1267, 1)) {
			PickAni = 626;
		} else if (AreXItemsInBag(1269, 1)) {
			PickAni = 627;
		} else if (AreXItemsInBag(1273, 1)) {
			PickAni = 629;
		} else if (AreXItemsInBag(1271, 1)) {
			PickAni = 628;
		} else if (AreXItemsInBag(1275, 1)) {
			PickAni = 624;
		}
		return PickAni;
	}

	public int CheckPick() {
		int Pick = playerEquipment[playerWeapon];
		if (Pick == 1265) {//bronze
			return 0;
		} else if (Pick == 1267) {//iron
			return 1;
		} else if (Pick == 1269) {//steel
			return 2;
		} else if (Pick == 1273) {//mithril
			return 3;
		} else if (Pick == 1271) {//adamant
			return 4;
		} else if (Pick == 1275) {//rune
			return 5;
		} else if (Pick == 15259) {//Inferno Adze
			return 6;
		} 
		if (AreXItemsInBag(1265, 1)) {
			return 0;
		} else if (AreXItemsInBag(1267, 1)) {
			return 1;
		} else if (AreXItemsInBag(1269, 1)) {
			return 2;
		} else if (AreXItemsInBag(1273, 1)) {
			return 3;
		} else if (AreXItemsInBag(1271, 1)) {
			return 4;
		} else if (AreXItemsInBag(1275, 1)) {
			return 5;
		}
		return -1;
	}

	public boolean Mining = false;
	public int MineTimer;
	public int RockLevel;
	public int RockTId;
	public int RockXp;
	public int RockLId;
	public int NoOreId;
	public int HowManyRocks;
	public int RockX;
	public int RockY;

	public void InitiateMine(int Rock, int x, int y) {
		int PickId = CheckPick();
		int MinusTime = 0;
		RockTId = Rock;

		if (PickId == 1265) {
			MinusTime = 2;
		} else if (PickId == 1267) {
			MinusTime = 4;
		} else if (PickId == 1269) {
			MinusTime = 6;
		} else if (PickId == 1273) {
			MinusTime = 10;
		} else if (PickId == 1271) {
			MinusTime = 17;
		} else if (PickId == 1275) {
			MinusTime = 24;
		} else if (PickId == 14486) {
			MinusTime = 31;
		}

		if (RockTId == 2090 || RockTId == 2091) {//copper
			MineTimer = 15;
			RockLevel = 1;
			HowManyRocks = 1;
			RockXp = 55;
			RockLId = 436;
			NoOreId = 450;
			Gonefor = 40;
		} else if (RockTId == 2094 || RockTId == 2095) {//tin
			MineTimer = 15;
			RockLevel = 1;
			HowManyRocks = 1;
			RockXp = 55;
			RockLId = 438;
			NoOreId = 450;
			Gonefor = 40;
		} else if (RockTId == 2491) {//rune essence
			MineTimer = 15;
			RockLevel = 1;
			HowManyRocks = 100000000;
			RockXp = 25;
			RockLId = 1436;
			NoOreId = 2491;
			Gonefor = 1;
		} else if (RockTId == 2092 || RockTId == 2093) {//iron
			MineTimer = 17;
			RockLevel = 15;
			HowManyRocks = 1;
			RockXp = 105;
			RockLId = 440;
			NoOreId = 450;
			Gonefor = 100;
		} else if (RockTId == 2098 || RockTId == 2099) {//gold
			MineTimer = 20;
			RockLevel = 40;
			HowManyRocks = 1;
			RockXp = 300;
			RockLId = 444;
			NoOreId = 450;
			Gonefor = 120;
		} else if (RockTId == 2100 || RockTId == 2101) {//silver
			MineTimer = 17;
			RockLevel = 20;
			HowManyRocks = 1;
			RockXp = 155;
			RockLId = 442;
			NoOreId = 450;
			Gonefor = 100;
		} else if (RockTId == 2096 || RockTId == 2097 || RockTId == 4676) {//coal
			MineTimer = 24;
			RockLevel = 30;
			HowManyRocks = 1;
			RockXp = 225;
			RockLId = 453;
			NoOreId = 450;
			Gonefor = 160;
		} else if (RockTId == 2102 || RockTId == 2103) {//mithril
			MineTimer = 35;
			RockLevel = 55;
			HowManyRocks = 1;
			RockXp = 455;
			RockLId = 447;
			NoOreId = 450;
			Gonefor = 190;
		} else if (RockTId == 2104 || RockTId == 2105) {//adamant
			MineTimer = 60;
			RockLevel = 70;
			HowManyRocks = 1;
			RockXp = 695;
			RockLId = 449;
			NoOreId = 450;
			Gonefor = 290;
		} else if (RockTId == 2106 || RockTId == 2107) {//rune
			MineTimer = 100;
			RockLevel = 85;
			HowManyRocks = 1;
			RockXp = 850;
			RockLId = 451;
			NoOreId = 450;
			Gonefor = 960;
		} else {
			resetMine();
			return;
		}
		if (freeSlots() == 0) {
			sendMessage("You do not have enough inventory space to hold anymore Rocks!");
			resetMine();
			return;
		}
		if (PickId != -1) {
			if (playerLevel[playerMining] < RockLevel) {
				sendMessage("You are not a high enough level.");
				sendMessage("You must atleast get a level of " + RockLevel
						+ " to mine this rock.");
				resetMine();
				return;
			}
			if (!Mining) {
				sendMessage("You start to mine the rock.");
			}
			RockX = x;
			RockY = y;
			MineTimer *= 2;
			MineTimer -= getLevelForXP(playerXP[8]) + MinusTime;
			MineTimer = Misc.random(MineTimer);
			Mining = true;
		} else {
			resetMine();
			sendMessage("You need a pickaxe to mine this rock!");
		}
	}

	public void resetMine() {
		Mining = false;
		MineTimer = 0;
		RockLevel = 0;
		HowManyRocks = 0;
		RockTId = 0;
		RockXp = 0;
		RockLId = 0;
		NoOreId = 0;
		Gonefor = 0;
		RockX = 0;
		RockY = 0;
		repeatani = 0;
	}

	public int PickAni = 0;

	public void Mineprocess() {
		if (MineTimer > 0) {
			MineTimer--;
		}
		if (MineTimer < 0) {
			MineTimer = 1;
		}
		if (repeatani > 0) {
			repeatani--;
		} else {
			startAnimation(GetPickAni());
			PlayerHandler.players[playerId].updateRequired = true;
			PlayerHandler.players[playerId].appearanceUpdateRequired = true;
			repeatani = 3;
		}
		if (MineTimer == 0) {
			if (!RemoveRock()) {
				resetMine();
				return;
			} else {
				InitiateMine(RockTId, RockX, RockY);
			}
		}
	}

	public void SpawnRockStumps() {
		for (int i = 0; i < GameEngine.Rocks; i++) {
			if (GameEngine.RockSPAWN[i] > 0) {
				createObject(GameEngine.RockX[i], GameEngine.RockY[i],
						GameEngine.RockSTUMP[i], 0, 10);
			}
		}
	}

	public boolean HasRocks() {
		for (int i = 0; i < GameEngine.Rocks; i++) {
			if (GameEngine.RockX[i] == RockX && GameEngine.RockY[i] == RockY) {
				if (GameEngine.RockSPAWN[i] > 0) {
					return false;
				} else if (GameEngine.RockSPAWN[i] == 0) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean RemoveRock() {
		boolean New = true;
		int RockTid = GameEngine.Rocks;
		for (int i = 0; i < GameEngine.Rocks; i++) {
			if (GameEngine.RockX[i] == RockX && GameEngine.RockY[i] == RockY) {
				if (!HasRocks()) {
					resetMine();
					return false;
				}
				New = false;
				GameEngine.RockSLEFT[i]--;
				addSkillXP(RockXp, 14);
				addItem(RockLId, 1);
				sendMessage("You get some " + GetItemName(RockLId) + ".");
				if (GameEngine.RockSLEFT[i] <= 0) {
					GameEngine.RockSPAWN[i] = Gonefor;
				if(RockTId != 2491) {
					GameEngine.RockSS[i] = Misc.random(HowManyRocks);
				} else {
					GameEngine.RockSS[i] = 1000000;
				}
					if (GameEngine.RockSS[i] == 0) {
						GameEngine.RockSS[i] = 1;
					}
					createObject(RockX, RockY, NoOreId, 0, 10);
					return false;
				}
				return true;
			}
		}
		if (New) {
			GameEngine.RockX[RockTid] = RockX;
			GameEngine.RockY[RockTid] = RockY;
			GameEngine.RockID[RockTid] = RockTId;
			GameEngine.RockSTUMP[RockTid] = NoOreId;
			if(RockTId != 2491) {
			GameEngine.RockSLEFT[RockTid] = Misc.random(HowManyRocks);
			} else {
			GameEngine.RockSLEFT[RockTid] = 1000000;
			}
			if (GameEngine.RockSLEFT[RockTid] == 0) {
				GameEngine.RockSLEFT[RockTid] = 1;
			}
			GameEngine.Rocks++;
			return true;
		}
		return false;
	}

/*
 *End of Mining
 */


/*
 *
 *Runecrafting
 *
 */
	public int amountOfItem28(int itemID) {
		int i1 = 0;
		for (int i = 0; i < 28; i++) {
			if (playerItems[i] == (itemID + 1)) {
				i1++;
			}
		}
		return i1;
	}

	public boolean hasItem(int itemID) {
		for (int i = 0; i < playerItems.length; i++) {
			if (playerItems[i] == itemID + 1) {
				return true;
			}
		}
		return false;
	}

	public int essamount = 0;
	public void craftRunesOnAltar(int requiredlvl, int exp, int item, int x2, int x3, int x4) {
		if (playerLevel[20] < requiredlvl) {
			sendMessage("You need " + requiredlvl + " or higher runecrafting to make " + getItemName(item) + "s.");
			return;
		}
		if (!hasItem(1436)) {
			sendMessage("You need some rune essence to craft runes!");
			return;
		}
		gfx100(186);
		setAnimation(791);
		if ((playerLevel[20]) >= 0 && (playerLevel[20] < x2)) {
			essamount = amountOfItem28(1436);
		}
		if (playerLevel[20] >= x2 && playerLevel[20] < x3) {
			essamount = amountOfItem28(1436) * 2;
		}
		if (playerLevel[20] >= x3) {
			essamount = amountOfItem28(1436) * 3;
		}
		if (playerLevel[20] >= x4) {
			essamount = amountOfItem28(1436) * 4;
		}
 		for (int i = 0; i < 29; i++) {
			deleteItem(1436, GetItemSlot(1436), i);
		}
		addSkillXP(exp * essamount, 20);
		addItem(item, essamount);
		sendMessage("You bind the temple's power into " + essamount + " " + getItemName(item) + "s.");
		appearanceUpdateRequired = true;
		updateRequired = true;
	}
/*
 *
 *
 *End runecrafting
 *
 *
 *
 */

public void skillcapeEmote(int id) {

if(id == 9747
|| id == 9748
|| id == 9750
|| id == 9751
|| id == 9753
|| id == 9754
|| id == 9756
|| id == 9757
|| id == 9759
|| id == 9760
|| id == 9762
|| id == 9763
|| id == 9765
|| id == 9766
|| id == 9768
|| id == 9769) {
sendMessage("You use the skillcape emote!");
} else {
sendMessage("You need to be wearing a skillcape to do that!");
}

		if(id == 9747 || id == 9748) {
			stillgfx(823, absY, absX);
		}
		if(id == 9750 || id == 9751) {
			stillgfx(828, absY, absX);
		}
		if(id == 9753 || id == 9754) {
			stillgfx(824, absY, absX);
		}
		if(id == 9756 || id == 9757) {
			stillgfx(832, absY, absX);
		}
		if(id == 9759 || id == 9760) {
			stillgfx(829, absY, absX);
		}
		if(id == 9765 || id == 9766) {
			stillgfx(817, absY, absX);
		}
		if(id == 9768 || id == 9769) {
			stillgfx(834, absY, absX);
		}
}

	public void smeltingOneOre(int ore, int bar, int requiredLevel, String barName) {
		if (playerLevel[13] >= requiredLevel) {
			if((playerHasItem(ore))) {
				startAnimation(899);
				deleteItem(ore, GetItemSlot(ore), 1);
				addItem(bar, 1);
		} else {
			sendMessage("You need 1 "+GetItemName(ore)+" ore to make that!");
		}
			} else {
				sendMessage("Making "+barName+" requires level "+requiredLevel+" smithing.");
			}
	}
	public void smelting(int ore1, int ore2, int amount, int bar, int requiredLevel, String barName) {

		if (playerLevel[13] >= requiredLevel) {
			if((hasItem(ore1) && (playerHasItemAmount(ore2, amount)))) {
				startAnimation(899);
				deleteItem(ore1, GetItemSlot(ore1), 1);
				deleteItem(ore2, GetItemSlot(ore2), amount);
				addItem(bar, 1);
		} else {
			sendMessage("You need 1 "+GetItemName(ore1)+" and "+amount+" "+GetItemName(ore2)+" ore to make that!");
		}
			} else {
				sendMessage("Making "+barName+" requires level "+requiredLevel+" smithing.");
			}
	}

	public void AddGlobalObject(int x, int y, int typeID, int orientation, int tileObjectType) {
		if (distanceToPoint(x, y) <= 110) {
			outStream.createFrame(85);
			outStream.writeByteC(y - (mapRegionY * 8));
			outStream.writeByteC(x - (mapRegionX * 8));
			outStream.createFrame(151);
			outStream.writeByteA(0);
			outStream.writeWordBigEndian(typeID);
			outStream.writeByteS((tileObjectType << 2) + (orientation & 3));
		}
	}

	public static void addGlobalObj(int objectX, int objectY, int NewObjectID, int Face, int ObjectType) {
		for (Player p : GameEngine.playerHandler.players) {
			if (p != null) {
				clientHandler person = (clientHandler) p;
				if ((person.playerName != null || person.playerName != "null")) {
					if (person.distanceToPoint(objectX, objectY) <= 90) {
						person.ReplaceObject2(objectX, objectY, NewObjectID, Face, ObjectType);
					}
				}
			}
		}
	}

/*
 *Start of woodcutting
 */
	public int GetAxeAni() {
		int ChopAni = 0;
		int Axe = playerEquipment[playerWeapon];
		if (Axe == 1351) {
			ChopAni = 879;
		} else if (Axe == 1349) {
			ChopAni = 877;
		} else if (Axe == 1353) {
			ChopAni = 875;
		} else if (Axe == 1361) {
			ChopAni = 873;
		} else if (Axe == 1355) {
			ChopAni = 871;
		} else if (Axe == 1357) {
			ChopAni = 869;
		} else if (Axe == 1359) {
			ChopAni = 867;
		} else if (Axe == 6739) {
			ChopAni = 2846;
			//old anim is 3300
		}
		if (AreXItemsInBag(1351, 1)) {
			ChopAni = 879;
		} else if (AreXItemsInBag(1349, 1)) {
			ChopAni = 877;
		} else if (AreXItemsInBag(1353, 1)) {
			ChopAni = 875;
		} else if (AreXItemsInBag(1361, 1)) {
			ChopAni = 873;
		} else if (AreXItemsInBag(1355, 1)) {
			ChopAni = 871;
		} else if (AreXItemsInBag(1357, 1)) {
			ChopAni = 869;
		} else if (AreXItemsInBag(1359, 1)) {
			ChopAni = 867;
		} else if (AreXItemsInBag(6739, 1)) {
			ChopAni = 2846;
		}
		return ChopAni;
	}

	public int CheckAxe() {
		int Axe = playerEquipment[playerWeapon];
		if (Axe == 1351 ) {
			return 0;
		} else if (Axe == 1349) {
			return 1;
		} else if (Axe == 1353) {
			return 2;
		} else if (Axe == 1361) {
			return 3;
		} else if (Axe == 1355) {
			return 4;
		} else if (Axe == 1357) {
			return 5;
		} else if (Axe == 1359) {
			return 6;
		} else if (Axe == 6739) {
			return 7;
		} 
		if (AreXItemsInBag(1351, 1)) {
			return 0;
		} else if (AreXItemsInBag(1349, 1)) {
			return 1;
		} else if (AreXItemsInBag(1353, 1)) {
			return 2;
		} else if (AreXItemsInBag(1361, 1)) {
			return 3;
		} else if (AreXItemsInBag(1355, 1)) {
			return 4;
		} else if (AreXItemsInBag(1357, 1)) {
			return 5;
		} else if (AreXItemsInBag(1359, 1)) {
			return 6;
		} else if (AreXItemsInBag(6739, 1)) {
			return 7;
		}
		return -1;
	}

	public boolean Woodcutting = false;
	public int ChopTimer;
	public int TreeLevel;
	public int TreeId;
	public int TreeXp;
	public int LogId;
	public int StumpId;
	public int Gonefor;
	public int HowManyLogs;
	public int TreeX;
	public int TreeY;

	public void InitiateWc(int tree, int x, int y) {
		int AxeId = CheckAxe();
		int MinusTime = 0;
		TreeId = tree;
		if (AxeId == 1351) {
			MinusTime = 2;
		} else if (AxeId == 1349) {
			MinusTime = 4;
		} else if (AxeId == 1353) {
			MinusTime = 6;
		} else if (AxeId == 1361) {
			MinusTime = 10;
		} else if (AxeId == 1355) {
			MinusTime = 17;
		} else if (AxeId == 1357) {
			MinusTime = 24;
		} else if (AxeId == 135) {
			MinusTime = 31;
		} else if (AxeId == 6739) {
			MinusTime = 40;
		}
		if (TreeId == 1315 || TreeId == 1316 || TreeId == 1318
				|| TreeId == 1319 || TreeId == 3033 || TreeId == 1278
				|| TreeId == 1276) {
			ChopTimer = 15;
			TreeLevel = 1;
			HowManyLogs = 1;
			TreeXp = 50;
			LogId = 1511;
			StumpId = 1342;
			Gonefor = 80;
		} else if (TreeId == 1281 || TreeId == 3037) {
			ChopTimer = 17;
			TreeLevel = 15;
			HowManyLogs = Misc.random(6);
			TreeXp = 75;
			LogId = 1521;
			StumpId = 1341;
			Gonefor = 130;
		} else if (TreeId == 1308 || TreeId == 5551 || TreeId == 5552
				|| TreeId == 5553) {
			ChopTimer = 30;
			TreeLevel = 30;
			HowManyLogs = Misc.random(9);
			TreeXp = 135;
			LogId = 1519;
			StumpId = 7399;
			Gonefor = 160;
		} else if (TreeId == 1307 || TreeId == 4974) {
			ChopTimer = 40;
			TreeLevel = 45;
			HowManyLogs = Misc.random(14);
			TreeXp = 200;
			LogId = 1517;
			StumpId = 1343;
			Gonefor = 190;
		} else if (TreeId == 1309) {
			ChopTimer = 60;
			TreeLevel = 60;
			HowManyLogs = Misc.random(18);
			TreeXp = 500;
			LogId = 1515;
			StumpId = 7402;
			Gonefor = 290;
		} else if (TreeId == 1306) {
			ChopTimer = 80;
			TreeLevel = 75;
			HowManyLogs = Misc.random(22);
			TreeXp = 1000;
			LogId = 1513;
			StumpId = 7399;
			Gonefor = 960;
		} else {
			resetWC();
			return;
		}
		if (freeSlots() == 0) {
			sendMessage("You do not have enough inventory space to hold anymore logs!");
			resetWC();
			return;
		}
		if (AxeId != -1) {
			if (getLevelForXP(playerXP[8]) < TreeLevel) {
				sendMessage("You are not a high enough level.");
				sendMessage("You must atleast get a level of " + TreeLevel
						+ " to cut down this tree.");
				resetWC();
				return;
			}
			if (!Woodcutting) {
				sendMessage("You start to chop down the tree.");
			}
			TreeX = x;
			TreeY = y;
			ChopTimer *= 2;
			ChopTimer -= getLevelForXP(playerXP[8]) + MinusTime;
			ChopTimer = Misc.random(ChopTimer);
			Woodcutting = true;
		} else {
			resetWC();
			sendMessage("You need an axe to chop down this tree!");
		}
	}

	public void resetWC() {
		Woodcutting = false;
		ChopTimer = 0;
		TreeLevel = 0;
		TreeId = 0;
		TreeXp = 0;
		LogId = 0;
		StumpId = 0;
		Gonefor = 0;
		HowManyLogs = 0;
		TreeX = 0;
		TreeY = 0;
		repeatani = 0;
	}

	public int repeatani = 0;
	public int Chopani = 0;

	public void WCprocess() {
		if (ChopTimer > 0) {
			ChopTimer--;
		}
		if (ChopTimer < 0) {
			ChopTimer = 1;
		}
		if (repeatani > 0) {
			repeatani--;
		} else {
			startAnimation(GetAxeAni());
			PlayerHandler.players[playerId].updateRequired = true;
			PlayerHandler.players[playerId].appearanceUpdateRequired = true;
			repeatani = 3;
		}
		if (ChopTimer == 0) {
			if (!Removelog()) {
				resetWC();
				return;
			} else {
				InitiateWc(TreeId, TreeX, TreeY);
			}
		}
	}

	public void SpawnStumps() {
		for (int i = 0; i < GameEngine.Trees; i++) {
			if (GameEngine.TREESPAWN[i] > 0) {
				createObject(GameEngine.TREEX[i], GameEngine.TREEY[i],
						GameEngine.TREESTUMP[i], 0, 10);
			}
		}
	}

	public boolean HasLogs() {
		for (int i = 0; i < GameEngine.Trees; i++) {
			if (GameEngine.TREEX[i] == TreeX && GameEngine.TREEY[i] == TreeY) {
				if (GameEngine.TREESPAWN[i] > 0) {
					return false;
				} else if (GameEngine.TREESPAWN[i] == 0) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean Removelog() {
		boolean New = true;
		int Treeid = GameEngine.Trees;
		for (int i = 0; i < GameEngine.Trees; i++) {
			if (GameEngine.TREEX[i] == TreeX && GameEngine.TREEY[i] == TreeY) {
				if (!HasLogs()) {
					resetWC();
					return false;
				}
				New = false;
				GameEngine.LOGSLEFT[i]--;
				addSkillXP(TreeXp, 8);
				addItem(LogId, 1);
				sendMessage("You get some " + GetItemName(LogId) + ".");
				if (GameEngine.LOGSLEFT[i] <= 0) {
					GameEngine.TREESPAWN[i] = Gonefor;
					GameEngine.LOGS[i] = Misc.random(HowManyLogs);
					if (GameEngine.LOGS[i] == 0) {
						GameEngine.LOGS[i] = 1;
					}
					createObject(TreeX, TreeY, StumpId, 0, 10);
					return false;
				}
				return true;
			}
		}
		if (New) {
			GameEngine.TREEX[Treeid] = TreeX;
			GameEngine.TREEY[Treeid] = TreeY;
			GameEngine.TREEID[Treeid] = TreeId;
			GameEngine.TREESTUMP[Treeid] = StumpId;
			GameEngine.LOGSLEFT[Treeid] = Misc.random(HowManyLogs);
			if (GameEngine.LOGSLEFT[Treeid] == 0) {
				GameEngine.LOGSLEFT[Treeid] = 1;
			}
			GameEngine.Trees++;
			return true;
		}
		return false;
	}

/*
 *End of Woodcutting
 */



			public boolean isFishCooking = false;
			public int cookedFishXP;
			public int requiredFishLevel;


				int myX = (absX - currentX) / 64;
				int myY = (absY - currentY) / 64;
				int mapID = (myX + myY);


	public long miningTimer;
	public int mineObjectX = -1;
	public int mineObjectY = -1;
	public boolean isMining = false;
	public boolean hasMinedRock;
    public void resetFletching() { // Resets player values
	getFletching().amountToFletch = 0;
	getFletching().amountToFlax = 0;
	isFlaxing = false;
        isFletching = false;
    }

	public void yell(String message) {
		for (Player p : handler.players) {
			if ((message.indexOf("tradereq") > 0)
					|| (message.indexOf("duelreq") > 0))
			return;
			if ((p == null) || !p.isActive)
			continue;
			clientHandler temp = (clientHandler) p;
			if ((temp.absX > 0) && (temp.absY > 0))
			if ((temp != null) && !temp.disconnected && p.isActive)
			temp.sendMessage(message);
		}
	}

	public void stillgfx(int id, int Y, int X) {
		for(int i = 0; i < GameEngine.playerHandler.maxPlayers; i++) {
			if (GameEngine.playerHandler.players[i] != null) {
				clientHandler p = (clientHandler) GameEngine.playerHandler.players[i];
				if (p.WithinDistance(absX, absY, p.absX, p.absY, 60)) {
					if (p.heightLevel == heightLevel) {
						p.outStream.createFrame(85);
						p.outStream.writeByteC(Y - (mapRegionY * 8));
						p.outStream.writeByteC(X - (mapRegionX * 8));
						p.outStream.createFrame(4);
						p.outStream.writeByte(0);
						p.outStream.writeWord(id);
						p.outStream.writeByte(heightLevel);
						p.outStream.writeWord(0);
					}
				}
			}
		}
	}
	public void stillgfx2(int id, int Y, int X) {
		outStream.createFrame(85);
		outStream.writeByteC(Y - (mapRegionY * 8));
		outStream.writeByteC(X - (mapRegionX * 8));
		outStream.createFrame(4);
		outStream.writeByte(0);//Tiles away (X >> 4 + Y & 7)
		outStream.writeWord(id);//Graphic id
		outStream.writeByte(0);//height of the spell above it's basic place, i think it's written in pixels 100 pixels higher
		outStream.writeWord(0);//Time before casting the graphic
	}

	public void multiTargetGfx(int id, int targetY, int targetX) {
		for (Player p : GameEngine.playerHandler.players) {
			if(p != null) {
				clientHandler person = (clientHandler)p;
				if((person.playerName != null || person.playerName != "null")) {
					if(person.distanceToPoint(targetX, targetY) <= 60) {
						person.stillgfx2(id, person.absY, person.absX);
					}
				}
			}
		}
	}

	/*
	 * Shakes the screen when chest is open (Earthquake).
	 * @param p - The player that the frame is created for.
	 * @param i - The integer that the frame is set to.
	 */ 
	public void shakeScreen(int i, int j, int k, int l) {
		outStream.createFrame(35); // Creates frame 35.
		outStream.writeByte(i);
		outStream.writeByte(j);
		outStream.writeByte(k);
		outStream.writeByte(l);
	}
	/*
	 * Sets your equipment onto the dueling staking interface.
	 * @param p - The player that this method is applied to.
	 * @param i - The ID of the item.
	 * @param j - The amount of the item.
	 * @param k - The slot on the interface that the item is set onto.
	 */ 
	public void setDuelEquipment(int i, int j, int k) {
		if (GameEngine.playerHandler.players[playerId] == null || disconnected) {
			return;
		}
		outStream.createFrameVarSizeWord(34);
		outStream.writeWord(13824);
		outStream.writeByte(k);
		outStream.writeWord(i + 1);

		if (j > 254) {
			outStream.writeByte(255);
			outStream.writeDWord(j);
		} else {
			outStream.writeByte(j);
		}
		outStream.endFrameVarSizeWord();
		updateRequired = true;
		appearanceUpdateRequired = true;
	}

	/*
	 * Refreshes the dueling rules on the dueling staking interface.
	 * @param p - The player that this method is applied to.
	 */
	public void RefreshDuelRules() {
		if (duelWith > 0) {
			if (GameEngine.playerHandler.players[duelWith] != null) {
				clientHandler client1 = (clientHandler)GameEngine.playerHandler.players[duelWith];
				sendFrame126((new StringBuilder()).append("Dueling with: ").append(Misc.optimizeText(client1.playerName)).append("    Combat level:").append(client1.combat).toString(), 6671);
				client1.sendFrame126((new StringBuilder()).append("Dueling with: ").append(Misc.optimizeText(playerName)).append("    Combat level:").append(combat).toString(), 6671);
				sendFrame126("", 6684);
				client1.sendFrame126("", 6684);
				duelStatus = 1;
				client1.duelStatus = 1;

				if (duelRule[0]) {
					sendFrame126("@red@No Ranged", 6698);
				} else {
					sendFrame126("No Ranged", 6698);
				}
				if (duelRule[1]) {
					sendFrame126("@red@No Melee", 6699);
				} else {
					sendFrame126("No Melee", 6699);
				}
				if (duelRule[2]) {
					sendFrame126("@red@No Magic", 6697);
				} else {
					sendFrame126("No Magic", 6697);
				}
				if (duelRule[3]) {
					sendFrame126("@red@No Sp. Atk", 7817);
				} else {
					sendFrame126("No Sp. Atk", 7817);
				}
				if (duelRule[4]) {
					sendFrame126("@red@No Weapons", 669);
					sendFrame126("Neither player is allowed to use weapons.", 8278);
				} else {
					sendFrame126("No Weapons", 669);
					sendFrame126("Neither player is allowed to use weapons.", 8278);
				}
				if (duelRule[5]) {
					sendFrame126("@red@No Armour", 6696);
					sendFrame126("Neither player is allowed to use armour.", 8260);
				} else {
					sendFrame126("No Armour", 6696);
					sendFrame126("Neither player is allowed to use armour.", 8260);
				}
				if (duelRule[6]) {
					sendFrame126("@red@No Drinks", 6701);
				} else {
					sendFrame126("No Drinks", 6701);
				}
				if (duelRule[7]) {
					sendFrame126("@red@No Food", 6702);
				} else {
					sendFrame126("No Food", 6702);
				}
				if (duelRule[8]) {
					sendFrame126("@red@No Prayer", 6703);
				} else {
					sendFrame126("No Prayer", 6703);
				}
				if (duelRule[9]) {
					sendFrame126("@red@No Movement", 6704);
				} else {
					sendFrame126("No Movement", 6704);
				}
				if (duelRule[10]) {
					sendFrame126("@red@Obstacles", 6731);
				} else {
					sendFrame126("Obstacles", 6731);
				}
			}
		}
	}

	/*
	 * This method is called when you win a duel. It will give you the other player's staked items, refresh your stats, and teleport you back to the dueling lobby.
	 */
	public void DuelVictory() {
		ResetAttack();
		drawHeadicon(10, 0, 0, 0);
		int i = Misc.random(dSpotX.length - 1);
		teleportToX = dSpotX[i];
		teleportToY = dSpotY[i];
		updateRequired = true;
		appearanceUpdateRequired = true;

		if (duelWith > 0) {
			if (GameEngine.playerHandler.players[duelWith] != null) {
				clientHandler client1 = (clientHandler)GameEngine.playerHandler.players[duelWith];
				sendFrame126((new StringBuilder()).append("").append(client1.combat).toString(), 6839);
				sendFrame126(Misc.optimizeText(client1.playerName), 6840);
				client1.drawHeadicon(10, 0, 0, 0);
				client1.sendFrame87(286, 256);
				client1.duelOption = 0;
			}
		}
		for (int j = 0; j < 21; j++) {
			playerLevel[j] = getLevelForXP(playerXP[j]);
		}
		for (int k = 0; k < 21; k++) {
			setSkillLevel(k, playerLevel[k], playerXP[k]);
		}
		itemsToVScreen();
		showInterface(6733);
		duelStatus = -1;

		for (int l = 0; l < duelItems.length; l++) {
			if (duelItems[l] > 0) {
				addItem(duelItems[l] - 1, duelItemsN[l]);
			}
		}
		for (int i1 = 0; i1 < otherDuelItems.length; i1++) {
			if (otherDuelItems[i1] > 0) {
				addItem(otherDuelItems[i1] - 1, otherDuelItemsN[i1]);
			}
		}
		addItem(4278, 500);
		resetDuel();
		updateHp(getLevelForXP(playerXP[3]), true);
		resetPrayer();
		specialAmount = 100;

		if (isSpecWeapon(playerEquipment[3])) {
			l33thax(12323);
			l33thax(7574);
			l33thax(7599);
			l33thax(7549);
			l33thax(8493);
			l33thax(7499);
		} else {
			Frame171(12323, 1);
			Frame171(7574, 1);
			Frame171(7599, 1);
			Frame171(7549, 1);
			Frame171(8493, 1);
			Frame171(7499, 1);
		}
		specs();
		skullTimer = -1;
		SetHeadIcon(0);
		freezeDelay = 0;
		resetKeepItem();
		resetItems(3823);
		resetAnimation();
		killMyNPCs();
		updateRequired = true;
		appearanceUpdateRequired = true;
	}

	/*
	 * This method is called when you start a duel.
	 */
	public void DuelStart() {
/* *POSSIBLY CAUSING DUELING GLITCH* */
/*
		for (int i = 0; i < 21; i++) {
			playerLevel[i] = getLevelForXP(playerXP[i]);
		}
		for (int j = 0; j < 21; j++) {
			setSkillLevel(j, playerLevel[j], playerXP[j]);
		}
*/
		updateHp(getLevelForXP(playerXP[3]), true);
 		resetPrayer();
		specialAmount = 100;
		usingSpecial = false;

		if (isSpecWeapon(playerEquipment[3])) {
			l33thax(12323);
			l33thax(7574);
			l33thax(7599);
			l33thax(7549);
			l33thax(8493);
			l33thax(7499);
		} else {
			Frame171(12323, 1);
			Frame171(7574, 1);
			Frame171(7599, 1);
			Frame171(7549, 1);
			Frame171(8493, 1);
			Frame171(7499, 1);
		}
		specs();
		skullTimer = -1;
		SetHeadIcon(0);
		freezeDelay = 0;
		resetKeepItem();
		resetItems(3823);
		updateRequired = true;
		appearanceUpdateRequired = true;
	}

	/*
	 * This method declines the duel and gives you back our staked items.
	 */ 
	public void declineDuel() {
		if (duelStatus == 3 || duelStatus == -1) {
			return;
		}
		sendMessage("You decline the duel.");
		RemoveAllWindows();

		if (duelWith > 0) {
			if (GameEngine.playerHandler.players[duelWith] != null) {
				clientHandler client1 = (clientHandler)GameEngine.playerHandler.players[duelWith];
				client1.sendMessage("The other player declined rules and stake options.");
				client1.RemoveAllWindows();

				for (int j = 0; j < client1.duelItems.length; j++) {
					if (client1.duelItems[j] != 0) {
						client1.addItem(client1.duelItems[j] - 1, client1.duelItemsN[j]);
					}
				}
				client1.duelOption = 0;
				client1.sendFrame87(286, 256);
				client1.resetItems(3214);
				client1.resetDuel();
				client1.duelWith = 0;
				client1.duelStatus = -1;
			}
		}
		for (int i = 0; i < duelItems.length; i++) {
			if (duelItems[i] != 0) {
 				addItem(duelItems[i] - 1, duelItemsN[i]);
			}
		}
		sendFrame87(286, 256);
		duelOption = 0;
		duelWith = 0;
		duelStatus = -1;
		resetItems(3214);
		resetDuel();
	}

	/*
	 * Removes all staked items.
	 */
	public void RemoveAllDuelItems() {
		for (int i = 0; i < duelItems.length; i++) {
			if (duelItems[i] > 0) {
				fromDuel(duelItems[i] - 1, i, duelItemsN[i]);
			}
		}
	}

	/*
	 * Gets the item slots for dueling items.
	 */
	public int GetDuelItemSlots() {
		int i = 0;

		for (int j = 0; j < duelItems.length; j++) {
			if (duelItems[j] > 0) {
				i++;
			}
		}
		for (int k = 0; k < otherDuelItems.length; k++) {
			if (otherDuelItems[k] > 0) {
				i++;
			}
		}
		return i;
	}

	/*
	 * Updates staked items.
	 */
	public void itemsToVScreen() {
		if (GameEngine.playerHandler.players[playerId] == null || disconnected) {
			return;
		}
		outStream.createFrameVarSizeWord(53);
		outStream.writeWord(6822);
		outStream.writeWord(otherDuelItems.length);

		for (int i = 0; i < otherDuelItems.length; i++) {
			if (otherDuelItemsN[i] > 254) {
				outStream.writeByte(255);
				outStream.writeDWord_v2(otherDuelItemsN[i]);
			} else {
				outStream.writeByte(otherDuelItemsN[i]);
			}
			if (otherDuelItems[i] > 10000 || otherDuelItems[i] < 0) {
				otherDuelItems[i] = 10000;
			}
			outStream.writeWordBigEndianA(otherDuelItems[i]);
		}
		outStream.endFrameVarSizeWord();
	}

	/*
	 * Refreshes the dueling items set on the dueling interface.
	 */
	public void refreshDuelScreen() {
		if (GameEngine.playerHandler.players[playerId] == null || disconnected) {
			return;
		}
		outStream.createFrameVarSizeWord(53);
		outStream.writeWord(6669);
		outStream.writeWord(duelItems.length);

		for (int i = 0; i < duelItems.length; i++) {
			if (duelItemsN[i] > 254) {
				outStream.writeByte(255);
				outStream.writeDWord_v2(duelItemsN[i]);
			} else {
				outStream.writeByte(duelItemsN[i]);
			}
			outStream.writeWordBigEndianA(duelItems[i]);
		}
		outStream.endFrameVarSizeWord();
		outStream.createFrameVarSizeWord(53);
		outStream.writeWord(6670);
		outStream.writeWord(otherDuelItems.length);

		for (int j = 0; j < otherDuelItems.length; j++) {
			if (otherDuelItemsN[j] > 254) {
				outStream.writeByte(255);
				outStream.writeDWord_v2(otherDuelItemsN[j]);
			} else {
				outStream.writeByte(otherDuelItemsN[j]);
			}
			outStream.writeWordBigEndianA(otherDuelItems[j]);
		}
		outStream.endFrameVarSizeWord();
	}

	/*
	 * Stake an item for a duel.
	 */
	public boolean stakeItem(int i, int j, int k) {
		if (k <= 0) {
			k = 1;
		}
		if (GameEngine.playerHandler.players[playerId] == null || disconnected) {
			return false;
		}
		boolean flag = false;

		if (i + 1 == playerItems[j]) {
			if (k > playerItemsN[j] && (DataFiles.itemStackable[playerItems[j] - 1] || DataFiles.itemIsNote[playerItems[j] - 1])) {
				k = playerItemsN[j];
				sendMessage("Item Amount Changed.");
			} else if (k > InvItemAmt(i) && !DataFiles.itemStackable[playerItems[j] - 1] && !DataFiles.itemIsNote[playerItems[j] - 1]) {
				int l = 0;

				for (int k1 = 0; k1 < playerItems.length; k1++) {
					if (playerItems[k1] == i + 1) {
						l++;
					}
				}
				if (k > l) {
					k = l;
					sendMessage("Non stack change.");
				}
			}
			if (DataFiles.itemStackable[playerItems[j] - 1] || DataFiles.itemIsNote[playerItems[j] - 1]) {
				int i1 = 0;

				do {
					if (i1 >= duelItems.length) {
						break;
					}
					if (duelItems[i1] == playerItems[j]) {
						duelItemsN[i1] += k;

						if (GameEngine.playerHandler.players[duelWith] != null) {
							GameEngine.playerHandler.players[duelWith].otherDuelItemsN[i1] += k;
						}
						flag = true;
						break;
					}
					i1++;
				} while(true);

				}
				if (!flag) {
					int j1 = k;

					if (DataFiles.itemStackable[playerItems[j] - 1] || DataFiles.itemIsNote[playerItems[j] - 1]) {
						int l1 = 0;

						do {
							if (l1 >= duelItems.length) {
								break;
							}
							if (duelItems[l1] == 0) {
								duelItems[l1] = i + 1;
								duelItemsN[l1] = k;

								if (GameEngine.playerHandler.players[duelWith] != null) {
									GameEngine.playerHandler.players[duelWith].otherDuelItems[l1] = i + 1;
									GameEngine.playerHandler.players[duelWith].otherDuelItemsN[l1] = k;
								}
								break;
							}
							l1++;
						} while(true);
					} else {
						for(int i2 = 0; i2 < duelItems.length; i2++) {
							if (duelItems[i2] != 0 || j1 <= 0) {
								continue;
							}
							if (InvItemAmt(i) <= 0) {
								break;
							}
							j1--;
							duelItems[i2] = i + 1;
							duelItemsN[i2] = 1;

							if (GameEngine.playerHandler.players[duelWith] != null) {
								GameEngine.playerHandler.players[duelWith].otherDuelItems[i2] = i + 1;
								GameEngine.playerHandler.players[duelWith].otherDuelItemsN[i2] = 1;
							}
						}

					}
				}
				deleteItem(playerItems[j] - 1, j, k);
				duelStatus = 1;
 				resetItems(3214);
				resetItems(3322);
 				sendFrame126("", 6684);
				refreshDuelScreen();
				sendFrame248(6575, 3321);

				if (GameEngine.playerHandler.players[duelWith] != null) {
					clientHandler client1 = (clientHandler)GameEngine.playerHandler.players[duelWith];
					client1.duelStatus = 1;
					client1.resetItems(3214);
					client1.resetItems(3322);
					client1.refreshDuelScreen();
					client1.sendFrame126("", 6684);
					client1.sendFrame248(6575, 3321);
				}
				return true;
			} else {
				return false;
			}
	}

	/*
	 * Withdraw an item from the dueling stake.
	 */
	public boolean fromDuel(int i, int j, int k) {
		if (k <= 0 && k != -924) {
			k = 1;
		}
		if (GameEngine.playerHandler.players[playerId] == null || disconnected) {
			return false;
		}
		try {
			if (i + 1 == duelItems[j]) {
				if (k > duelItemsN[j] && (DataFiles.itemStackable[duelItems[j] - 1] || DataFiles.itemIsNote[duelItems[j] - 1]) || k == -924) {
					k = duelItemsN[j];
				} else {
					int l = 0;
					for (int k1 = 0; k1 < duelItems.length; k1++) {
						if (duelItems[k1] - 1 == i) {
							l++;
						}
					}
					if (k > l) {
						k = l;
					}
				}
				if (k == -924 && !DataFiles.itemStackable[duelItems[j] - 1] && !DataFiles.itemIsNote[duelItems[j] - 1]) {
					k = 0;

					for (int i1 = 0; i1 < duelItems.length; i1++) {
						if (duelItems[i1] == i + 1) {
							addItem(duelItems[j] - 1, 1);
							k++;
						}
					}
				} else {
					addItem(duelItems[j] - 1, k);
				}
				if (DataFiles.itemStackable[duelItems[j] - 1] || DataFiles.itemIsNote[duelItems[j] - 1]) {
					if (k == duelItemsN[j]) {
						duelItems[j] = 0;

						if (GameEngine.playerHandler.players[duelWith] != null) {
							GameEngine.playerHandler.players[duelWith].otherDuelItems[j] = 0;
						}
					} else {
						duelItemsN[j] -= k;

						if (GameEngine.playerHandler.players[duelWith] != null) {
							GameEngine.playerHandler.players[duelWith].otherDuelItemsN[j] -= k;
						}
					}
				} else if (!DataFiles.itemStackable[duelItems[j] - 1] && !DataFiles.itemIsNote[duelItems[j] - 1]) {
					int j1 = k;

					for(int l1 = 0; l1 < duelItems.length; l1++) {
						if (duelItems[l1] - 1 != i || j1 <= 0) {
							continue;
						}
						j1--;
						duelItems[l1] = 0;

						if (GameEngine.playerHandler.players[duelWith] != null) {
							GameEngine.playerHandler.players[duelWith].otherDuelItems[l1] = 0;
						}
					}

				}
				duelStatus = 1;
				resetItems(3214);
				resetItems(3322);
				refreshDuelScreen();
				sendFrame126("", 6684);
				sendFrame248(6575, 3321);

				if (GameEngine.playerHandler.players[duelWith] != null) {
					clientHandler client1 = (clientHandler)GameEngine.playerHandler.players[duelWith];
					client1.duelStatus = 1;
					client1.resetItems(3214);
					client1.resetItems(3322);
  					client1.refreshDuelScreen();
					client1.sendFrame126("", 6684);
					client1.sendFrame248(6575, 3321);
				}
				return true;
			}
		} catch(Exception exception) {

		}
		return false;
	}

	/*
	 * Reset dueling.
	 */
	public void resetDuel() {
		duelWith = 0;
		duelStatus = -1;

		for (int i = 0; i < duelItems.length; i++) {
			try {
				sendFrame87(286, 256);
				duelOption = 0;
				duelItems[i] = 0;
				otherDuelItems[i] = 0;
 				duelItemsN[i] = 0;
				otherDuelItemsN[i] = 0;
				duelRule[i] = false;
			} catch(Exception exception) {
			}
		}
	}

	/*
	 * Door opens, player walks through, and the door is closed behind the player.
	 */
	/*public void walkThroughDoor(int objectX, int objectY, int objectID, int startFace, int finishFace, int x, int y) {
		ReplaceObject(objectX, objectY, objectID, startFace);
		forceWalk(x, y);

		EventManager.getSingleton().addEvent(new Event() {
			public void execute(EventContainer c) {
				ReplaceObject(objectX, objectY, objectID, finishFace);
				c.stop();
			}
		}, 1500);
	}*/

	/*
	 * The command that the player types.
	 */
	public String playerCommand = "";

	/*
	 * Set the autocasting ID for modern/ancients.
	 */
	public void autoCastSet(int lvlReq, int modern, int ancients) {
		if (getLevelForXP(playerXP[6]) >= lvlReq) {
			autoCast[0] = modern;
			autoCast[1] = ancients;
			castAuto = true;
			setSidebarInterface(0, 328);
		} else {
			sendMessage("You need a magic level of "+ lvlReq +" to cast this spell.");
		}
	}

	/*
	 * Amulet of glory teleporting.
	 */
	public void gloryTeleport(int teleX, int teleY) {
		deleteItem(delID, getItemSlot(delID), 1);
		addItem(newID, 1);
		teleportTo(teleX, teleY, 0, 4, 714, 715, 308, 100, 2);
		closeInterface();
	}

	/*
	 * Magic defence to determine whether a spell splashes.
	 */
    	public int magicDefence() {
		if (this == null) {
			return 0;
		}
		if (!magicPrayer) {
			return (int)((playerLevel[1] / 4) + (playerLevel[6] / 2) + playerBonus[8]);
		} else if (magicPrayer) {
			return (int)((playerLevel[1] / 4) + (playerLevel[6] / 2) + playerBonus[8] + 50);
		} else {
			return 0;
		}
    	}

	/*
	 * Change a configuration setting on an interface.
	 */
	public void sendFrame87(int id, int state) {
		outStream.createFrame(87);
		outStream.writeWordBigEndian_dup(id);	
		outStream.writeDWord_v1(state);
		flushOutStream();
	}

	/*
	 * Resets skill usage. Called when you walk, click buttons etc.
	 */
	public void resetSkills() {
		for (int i = 0; i < 5; i++) {
			fishing[i] = -1;
			cooking[i] = -1;
			woodcutting[i] = -1;
		}
		cookName = "";
		fishName = "";
		logName = "";
		isCooking = false;
		isFishing = false;
		isWoodcutting = false;
	}

	/*
	 * Woodcutting Variables.
	 */
	public int[] woodcutting = new int[4]; // 0 = timer, 1 = XP, 2 = logID, 3 = animation, 4 = level Required.
	public String logName = "";
	public boolean isWoodcutting;

	/*
	 * Cooking Variables.
	 */
	public int[] cooking = new int[4]; // 0 = timer, 1 = XP, 2 = cookedID, 3 = amount, 4 = level Required.
	public String cookName = "";
	public boolean isCooking;

	/*
	 * Fishing Variables.
	 */
	public int[] fishing = new int[4]; // 0 = timer, 1 = XP, 2 = fish, 3 = animation, 4 = level Required.
	public String fishName = "";

	/*
	 * Deplete from/add to a stat. Example: prayer reduction.
	 */
	public void changeStat(int i, int j, int k, boolean flag) {
		if (flag) {
			if (k == 0 && playerLevel[i] >= getLevelForXP(playerXP[i])) {
				return;
			}
			if (playerLevel[i] >= getLevelForXP(playerXP[i]) + j) {
				return;
			}
			playerLevel[i] += j;

			if (playerLevel[i] >= getLevelForXP(playerXP[i]) + j) {
				playerLevel[i] = getLevelForXP(playerXP[i]) + j;
			}
			if (k == 0 && playerLevel[i] > getLevelForXP(playerXP[i])) {
				playerLevel[i] = getLevelForXP(playerXP[i]);
			}
		} else if (!flag) {
			playerLevel[i] -= j;

			if (playerLevel[i] < 1) {
				playerLevel[i] = 1;
			}
		}
		setSkillLevel(i, playerLevel[i], playerXP[i]);
	}

	/*
	 * Creates a projectile for players within your map area, and on your height level.
	 */
	public void createProjectile2(int i, int j, int k, int l, int i1, int j1, int k1, int l1, int i2) {
		for (Player p : GameEngine.playerHandler.players) {
			if (p != null) {
				clientHandler c = (clientHandler)p;

				if (c.WithinDistance(absX, absY, c.absX, c.absY, 60) && c.heightLevel == heightLevel) {
                                	c.outStream.createFrame(85);
                                	c.outStream.writeByteC(i - c.mapRegionY * 8 - 2);
                                	c.outStream.writeByteC(j - c.mapRegionX * 8 - 3);
                                	c.outStream.createFrame(117);
                                	c.outStream.writeByte(50);
                                	c.outStream.writeByte(k);
                                	c.outStream.writeByte(l);
                                	c.outStream.writeWord(i2);
                                	c.outStream.writeWord(i1);
                                	c.outStream.writeByte(j1);
                                	c.outStream.writeByte(k1);
                                	c.outStream.writeWord(51);
                                	c.outStream.writeWord(l1);
                                	c.outStream.writeByte(16);
                                	c.outStream.writeByte(64);
				}
			}
		}
	}

	/*
	 * Handles the eating of food. You may eat every 1.5 seconds, if you're not dead/dying, and if the 'No food' is not enabled.
	 */
	public void eatFood(int delItem, int slot, int healAmt) {
		if (!IsDead) {
			if (!duelRule[7]) {
				if (System.currentTimeMillis() - healTimer >= 1500) {
					combatDelay += 2;
					healTimer = System.currentTimeMillis();
					deleteItem(delItem, GetItemSlot(delItem), 1);
					startAnimation(829);
					updateHp(healAmt, true);
					ResetAttack();
					ResetAttackNPC();
					setMagicPlayer(false);
				}
			}
		}
	}
	public void eatFood2(int delItem, int slot, int healAmt, int addItem) {
		if (!IsDead) {
			if (!duelRule[7]) {
				if (System.currentTimeMillis() - healTimer >= 1500) {
					combatDelay += 2;
					healTimer = System.currentTimeMillis();
					deleteItem(delItem, GetItemSlot(delItem), 1);
					addItem(addItem, 1);
					startAnimation(829);
					updateHp(healAmt, true);
					ResetAttack();
					ResetAttackNPC();
					setMagicPlayer(false);
				}
			}
		}
	}
	/*
	 * Sets the wilderness PKing skull/Tzhaar fight pits champion skull.
	 */
	public void SetPkHeadIcon(int i) {
		headIconPk = i;
		updateRequired = true;
		appearanceUpdateRequired = true;
	}

	/*
	 * Replaces the designated item, with the 'newItem' parameter item number.
	 */
	public void replaceItem(int itemId, int newItem) {
		for (int k = 0; k < 28; k++) {
			if (ItemInslot(itemId, k)) {
				deleteItem(itemId, k, 1);
				addItem(newItem, 1);
			}
		}
	}

	/*
	 * Determines whether an item is in a certain slot in your inventory.
	 */
	public boolean ItemInslot(int itemId, int slot) {
		if (playerItems[slot] == itemId + 1) {
			return true;
		}
		return false;
	}

	/*
	 * Removes equipment and adds them to your inventory.
	 */
	public void RemoveItem(int i, int j) {
		if (GameEngine.playerHandler.players[playerId] == null || disconnected) {
			return;
		}
		if (i <= 0 || j < 0) {
			return;
		}
		if (!addItem(playerEquipment[j], playerEquipmentN[j])) {
			sendMessage("Not enough space in your inventory.");
			return;
		}
		playerEquipment[j] = -1;
		playerEquipmentN[j] = 0;
		outStream.createFrame(34);
		outStream.writeWord(6);
		outStream.writeWord(1688);
		outStream.writeByte(j);
 		outStream.writeWord(0);
		outStream.writeByte(0);
		GetBonus();

		if (j == playerWeapon) {
			SendWeapon(playerEquipment[playerWeapon], getItemName(playerEquipment[playerWeapon]));
		}
		setDuelEquipment(-1, 0, j);
		updateRequired = true;
		appearanceUpdateRequired = true;
		resetItems(3214);
	}

	/*
	 * Kills the NPC's that have been spawned for you. E.G. tzhaar npcs; animated armours; barrows brothers.
	 */
	public void killMyNPCs() {
		for (int i = 0; i < GameEngine.npcHandler.maxNPCs; i++) {
			if (GameEngine.npcHandler.npcs[i] == null) {
				continue;
			}
			NPC npc = GameEngine.npcHandler.npcs[i];

			if (npc.spawnedBy == playerId) {
				npc.absX = 0;
				npc.absY = 0;
				npc.HP = 0;
				GameEngine.npcHandler.npcs[i] = null;
			}
 		}
 	}

	/*
	 * Sets the headicon the the 'ID' parameter is set to.
	 */
	public void SetHeadIcon(int ID) {
		headIcon = ID;
		updateRequired = true;
		appearanceUpdateRequired = true;
	}

	/*
	 * Special attack bar refreshing.
	 */
	public void specs() {
		SpecialAttacks sP = new SpecialAttacks(this);
		sP.specialAttacks();
		sP.specialAttacks2();
		sP.specialAttacks3();
		sP.specialAttacks4();
		sP.specialAttacks5();
		sP.specialAttacks6();
	}

	public void Frame171(int i, int j) {
		outStream.createFrame(171);
		outStream.writeByte(j);
		outStream.writeWord(i);
	}

	public boolean isSpecWeapon(int id) {
		switch (id) {

			case 10887:
			case 11694:
			case 11696:
			case 11698:
			case 11700:
			case 11730:
			case 14484:
			case 9005:
        		case 5698:
        		case 7158:
        		case 805:
        		case 6724:
        		case 4151:
        		case 1305:
        		case 1434:
        		case 4587:
        		case 861:
        		case 3204:
        		case 1249:
        		case 4153:
				return true;
            	    default:
			return false;
		}
	}

	public void deleteEquipment(int i) {
		playerEquipment[i] = -1;
		playerEquipmentN[i] = 0;
		outStream.createFrame(34);
		outStream.writeWord(6);
		outStream.writeWord(1688);
		outStream.writeByte(i);
		outStream.writeWord(0);
		outStream.writeByte(0);
		GetBonus();

		if (i == playerWeapon) {
			usingSpecial = false;
			SendWeapon(-1, "Unarmed");
			usingAutoCast = false;
		}
		setDuelEquipment(-1, 0, i);
		updateRequired = true;
		appearanceUpdateRequired = true;
	}

	public int itemKept1;
	public int itemKept2;
	public int itemKept3;
	public int itemKept4;
	public int itemKept1Slot;
	public int itemKept2Slot;
	public int itemKept3Slot;
	public int itemKept4Slot;
	public boolean itemSlot1;
	public boolean itemSlot2;
	public boolean itemSlot3;
	public boolean itemSlot4;

	public double getItemValue(int i) {
		double d = 1.0D;

		for(int j = 0; j < GameEngine.itemHandler.MaxListedItems; j++) {
			if (GameEngine.itemHandler.ItemList[j] != null && GameEngine.itemHandler.ItemList[j].itemId == i) {
				d = GameEngine.itemHandler.ItemList[j].LowAlch;
			}
		}
		return d;
	}

	public void sendFrame34(int frame, int item, int slot, int amount){
		outStream.createFrameVarSizeWord(34);
		outStream.writeWord(frame);
		outStream.writeByte(slot);
		outStream.writeWord(item+1);
		outStream.writeByte(255);
		outStream.writeDWord(amount);
		outStream.endFrameVarSizeWord();
	}

	/**
	 * Show an arrow icon on the selected player.
	 * @Param i - Either 0 or 10; 10 is arrow, 0 is none.
	 * @Param j - The player/Npc that the arrow will be displayed above.
	 * @Param k - Keep this set as 0
	 * @Param l - Keep this set as 0
	 */
	public void drawHeadicon(int i, int j, int k, int l) {
		outStream.createFrame(254);
		outStream.writeByte(i);

		if (i == 1 || i == 10) {
			outStream.writeWord(j);
			outStream.writeWord(k);
			outStream.writeByte(l);
		} else {
			outStream.writeWord(k);
			outStream.writeWord(l);
			outStream.writeByte(j);
		}
	}

	public boolean delItem(int id, int j, int k) {
		if (id < 0 || k < 0) {
			return false;
		}
		if (playerItems[j] == id + 1 && !DataFiles.itemStackable[i] && !DataFiles.itemIsNote[id]) {
			if (k == 1) {
				playerItems[j] = 0;
				playerItemsN[j] = 0;
				resetItems(3214);
				return true;
			}
			for (int l = 0; l < 28; l++) {
				if (playerItems[l] == id + 1 && k != 0) {
					k--;
					playerItems[l] = 0;
					playerItemsN[l] = 0;
					resetItems(3214);
				}
			}
			if (k == 0) {
				return true;
			}
		}
		if (playerItems[j] == id + 1 && (DataFiles.itemStackable[i] || DataFiles.itemIsNote[id])) {
			if (playerItemsN[j] > k) {
				playerItemsN[j] -= k;
				resetItems(3214);
				return true;
			} else {
				playerItemsN[j] = 0;
				playerItems[j] = 0;
				resetItems(3214);
				return true;
			}
		} else {
			return false;
		}
	}

	public int InvItemAmt(int i) {
		int j = 0;

		if (i < 0) {
			return 25;
		}
		for(int k = 0; k < playerItems.length; k++) {
			if (playerItems[k] == i + 1 && !DataFiles.itemStackable[i] && !DataFiles.itemIsNote[i]) {
				j++;
				continue;
			}
			if (playerItems[k] == i + 1 && (DataFiles.itemStackable[i] || DataFiles.itemIsNote[i])) {
				j += playerItemsN[k];
			}
		}
		return j;
	}

	public void showDialogue(String s) {
		sendFrame126(s, 357);
		sendFrame164(356);
	}

	public void updateHp(int i, boolean flag) {
		if (!IsDead) {
 			if (flag) {
				NewHP += i;

				if (NewHP > getLevelForXP(playerXP[3])) {
					i = NewHP - getLevelForXP(playerXP[3]);
					NewHP = getLevelForXP(playerXP[3]);
				}
			} else if (!flag) {
				NewHP -= i;
	
				if (NewHP < 0) {
					NewHP = 0;
				}
			}
			playerLevel[3] = NewHP;
			NewHP = playerLevel[3];
			setSkillLevel(3, playerLevel[3], playerXP[3]);
		}
 	}

	public int wildLvl(Player p) {
		return (p.absY - 3520) / 8 + 1;
    	}

	public boolean isInWildRange(Player p) {
		Player p2 = GameEngine.playerHandler.players[p.AttackingOn]; 

	    if (p.combat > p2.combat) {
	      	if (p.combat - p2.combat <= wildLvl(p2)) {
			return true;
	      	}
	    } else if (p.combat < p2.combat) {
	   	if (p2.combat - p.combat <= wildLvl(p2)) {
			return true;
	   	}
	    } else if (p.combat == p2.combat) {
			return true;
            }
    			return false;
    	}

	/**
	 * 1v1 variables
	 */
	public int cmbResetTimer;
	public int combatWith;

	/**
	 * Variable for magic defence
	 */
	public boolean magicSpellHit;

	/**
	 * Magic Variables
	 */
	public int sID;
	public int pID;
	public int[] modernStaves = {1381, 1387};
	public int[] ancientStaff = {4675};
	public int[] magicSpell = new int[3];
	public int[] autoCast = new int[3];
	public int magicDmgDelay = -1;
	public int magicDelay;
	public int npcMagicDmgDelay = -1;
	public int npcMagicDelay;
	public boolean usingAutoCast;

	public void setMagicNpc(boolean magicOnNpc) {
		this.magicOnNpc = magicOnNpc;
	}

	public boolean magicOnNpc;

	public void setMagicPlayer(boolean magicOnPlayer) {
		this.magicOnPlayer = magicOnPlayer;
	}

	public boolean magicOnPlayer;

	public int calculateMelee() {
		double d = 0.0D;
		int i = playerBonus[10];
		int j = playerLevel[playerStrength];
		int k = getLevelForXP(playerXP[playerStrength]);

		if (burstOfStr) {
			j = (int)((double)j + (double)k * 0.050000000000000003D);
		} else if (superHumanStr) {
			j = (int)((double)j + (double)k * 0.10000000000000001D);
		} else if (ultimateStr) {
			j = (int)((double)j + (double)k * 0.14999999999999999D);
		} else if (fullMeVoidEquipped()) {
			j = (int)((double)j + (double)k * 0.10000000000000001D);
		}
		d += 1.25D + (double)(i * j) * 0.00175D;
		d += (double)j * 0.11D;

		if (fullDharokEquipped() && Misc.random(2) == 1) {
			d += (getLevelForXP(playerXP[playerHitpoints]) - playerLevel[playerHitpoints]) / 2;
		}
		if (specDamageDelay >= 0 || specNPCDamageDelay >= 0) {
			if (playerEquipment[playerWeapon] == 7993) {
				d += d * 0.10000000000000001D;
			} else if (playerEquipment[playerWeapon] == 5698) {
				d *= 1.1399999999999999D;
			} else if (playerEquipment[playerWeapon] == 1434) {
				d *= 1.4600000000000001D;
			} else if (playerEquipment[playerWeapon] == 1305) {
				d *= 1.3659999999999999D;
			}
		}
        	return (int)Math.floor(d);
	}




public void miningRestrictions() {
	ReplaceObject2(3289, 3389, 6730, 0, 10);
	ReplaceObject2(3290, 3389, 6730, 0, 10);
	ReplaceObject2(3291, 3389, 6730, 0, 10);
	ReplaceObject2(3292, 3389, 6730, 0, 10);
	ReplaceObject2(3293, 3389, 6730, 0, 10);
	ReplaceObject2(3294, 3389, 6730, 0, 10);
	ReplaceObject2(3295, 3389, 6730, 0, 10);
}
public void treeSpawns() {
	makeGlobalObject(2444, 3111, 1309, 0, 10);//yew
	ReplaceObject2(2434, 3128, 1306, 0, 10);//WC Guild Magic Tree
	ReplaceObject2(2437, 3126, 1306, 0, 10);//WC Guild Magic Tree
	makeGlobalObject(2458, 3087, 1307, 0, 10);//maple
	makeGlobalObject(2461, 3092, 1307, 0, 10);//maple
	makeGlobalObject(2454, 3109, 1309, 0, 10);//yew
	makeGlobalObject(2460, 3114, 1309, 0, 10);//yew
	makeGlobalObject(2468, 3108, 1308, 0, 10);//willow
	makeGlobalObject(2472, 3095, 1308, 0, 10);//willow
	ReplaceObject2(2467, 3094, 1552, 0, 10);//willow
}
public void miningRockSpawns() {
	createObject(3287, 3361, 2107, 0, 10);//Runite Rock
	createObject(3288, 3361, 2107, 0, 10);//Runite Rock
	createObject(3285, 3361, 2105, 0, 10);//Adamantite Rock
	createObject(3284, 3362, 2104, 0, 10);//Adamantite Rock
	createObject(3288, 3365, 2103, 0, 10);//Mithril Rock
	createObject(3289, 3364, 2102, 0, 10);//Mithril Rock
	createObject(3288, 3367, 2097, 0, 10);//Coal
	createObject(3290, 3369, 2097, 0, 10);//Coal
	createObject(3289, 3370, 2100, 0, 10);//Silver Rock
	createObject(3287, 3370, 2100, 0, 10);//Silver Rock
	createObject(3283, 3369, 2099, 0, 10);//Gold Rock
	createObject(3284, 3370, 2099, 0, 10);//Gold Rock
}


	public void callObjects() {
		createObject(2517, 3869, 2561, 2, 10);//Baker's Stall
		createObject(2511, 3866, 2562, 1, 10);//Gem Stall
		createObject(2476, 3097, 8926, 1, 10);//Viking Boat
		createObject(2583, 3479, 2090, 0, 10);//Copper Rock
		createObject(2582, 3485, 2092, 0, 10);//Iron Rock
		createObject(2457, 3077, 2849, 0, 10);//Raft
		treeSpawns();
		miningRestrictions();
		miningRockSpawns();
		makeGlobalObject(2461, 3109, 5631, 0, 10);//warrior's fire
		makeGlobalObject(2460, 3096, 12202, 0, 22);//mole hill
		createObject(2440, 3061, 4421, 0, 10);//barricade
		createObject(2440, 3062, 4421, 0, 10);//barricade
		createObject(2439, 3060, 4421, 0, 10);//barricade
		createObject(2440, 3060, 4421, 0, 10);//barricade
		makeGlobalObject(2458, 3070, 8987, 0, 10);//Trapdoor to RC Abyss
		createObject(3017, 4846, 2490, 0, 10);//Blood Altar
		createObject(2312, 4586, 2489, 0, 10);//Soul Altar
		createObject(2441, 3069, 11666, 0, 10);//furnace
		createObject(2445, 3072, 2783, 0, 10);//anvil
		createObject(2445, 3070, 2783, 0, 10);//anvil



if(heightLevel == 0) {
		makeGlobalObject(2450, 3066, 2644, 2, 10);//Spinning wheel
		makeGlobalObject(2449, 3069, 2646, 0, 10);//flax
		makeGlobalObject(2450, 3069, 2646, 0, 10);//flax
		makeGlobalObject(2449, 3070, 2646, 0, 10);//flax
		makeGlobalObject(2496, 3935, 12171, 3, 10);//canoe
		makeGlobalObject(2469, 3950, 3564, 0, 10);//monkey bars
		makeGlobalObject(2469, 3947, 3564, 0, 10);//monkey bars
		makeGlobalObject(2470, 3948, 3563, 0, 10);//monkey bars
		makeGlobalObject(2470, 3949, 3563, 0, 10);//monkey bars
		makeGlobalObject(2456, 3936, 9309, 0, 10);//underwall tunnel
		makeGlobalObject(2459, 3936, 9309, 2, 10);//underwall tunnel
		makeGlobalObject(2449, 3075, 12144, 0, 10);//canoe station 
		makeGlobalObject(3008, 2977, 12171, 3, 10);//canoe
		ReplaceObject2(2446, 3097, 2465, 1, 10);//portal to duel arena
		ReplaceObject2(2446, 3096, 12356, 1, 10);//portal to pk
		ReplaceObject2(2433, 3117, 2142, 1, 10);//cauldron of Thunder
		ReplaceObject2(2460, 3084, 114, 1, 10);//cooking range
		ReplaceObject2(3360, 3269, 1911, 2, 0);//wall
		ReplaceObject2(3360, 3268, 1911, 2, 0);//wall
		ReplaceObject2(3374, 3269, 1911, 0, 0);//wall
		ReplaceObject2(3374, 3268, 1911, 0, 0);//wall
		makeGlobalObject(2606, 3154, 12355, 3, 10);//out of pk portal
		makeGlobalObject(2606, 3159, 77, 3, 0);//gate into cape thing
		makeGlobalObject(2604, 3154, 1032, 3, 10);//wild sign
		makeGlobalObject(2604, 3153, 1032, 3, 10);//wild sign
		makeGlobalObject(2605, 3158, 1032, 3, 10);//wild sign
		makeGlobalObject(2605, 3167, 1032, 3, 10);//wild sign
		makeGlobalObject(2605, 3164, 1032, 3, 10);//wild sign
		makeGlobalObject(2605, 3161, 1032, 3, 10);//wild sign
		makeGlobalObject(3431, 3537, 10251, 3, 10);//portal
		makeGlobalObject(2468, 3094, 5551, 0, 10);
		makeGlobalObject(3074, 3427, 10, 2, 10);
		makeGlobalObject(2442, 3123, 0, 0, 10);
		makeGlobalObject(2442, 3124, 0, 0, 10);	
		makeGlobalObject(2435, 3134, 1, 0, 10);
		makeGlobalObject(2434, 3134, 1, 0, 10);
		makeGlobalObject(2459, 3076, 4421, 0, 10);
		makeGlobalObject(2459, 3075, 4421, 0, 10);
		makeGlobalObject(2459, 3074, 4421, 0, 10);
		makeGlobalObject(2459, 3073, 4421, 0, 10);
		makeGlobalObject(2459, 3072, 4421, 0, 10);
		makeGlobalObject(2459, 3071, 4421, 0, 10);
		makeGlobalObject(2459, 3070, 4421, 0, 10);
		makeGlobalObject(2458, 3069, 4421, 0, 10);
		makeGlobalObject(2457, 3068, 4421, 0, 10);
		makeGlobalObject(2456, 3068, 4421, 0, 10);
		makeGlobalObject(2455, 3068, 4421, 0, 10);
		makeGlobalObject(2454, 3068, 4421, 0, 10);
		makeGlobalObject(2453, 3068, 4421, 0, 10);
		makeGlobalObject(2452, 3067, 4421, 0, 10);
		makeGlobalObject(2451, 3066, 4421, 0, 10);
		makeGlobalObject(2450, 3065, 4421, 0, 10);
		makeGlobalObject(2449, 3065, 4421, 0, 10);
		makeGlobalObject(2448, 3065, 4421, 0, 10);
		makeGlobalObject(2447, 3065, 4421, 0, 10);
		makeGlobalObject(2446, 3065, 4421, 0, 10);
		makeGlobalObject(2445, 3065, 4421, 0, 10);
		makeGlobalObject(2444, 3065, 4421, 0, 10);
		makeGlobalObject(2443, 3065, 4421, 0, 10);
		makeGlobalObject(2442, 3065, 4421, 0, 10);
		makeGlobalObject(2441, 3065, 4421, 0, 10);
		makeGlobalObject(2440, 3065, 4421, 0, 10);
		makeGlobalObject(2439, 3065, 4421, 0, 10);
		makeGlobalObject(2440, 3064, 4421, 0, 10);
		makeGlobalObject(2440, 3063, 4421, 0, 10);
		makeGlobalObject(2438, 3060, 4421, 0, 10);
		makeGlobalObject(2437, 3060, 4421, 0, 10);
		makeGlobalObject(2436, 3060, 4421, 0, 10);
		makeGlobalObject(2436, 3061, 4421, 0, 10);
		makeGlobalObject(2436, 3062, 4421, 0, 10);
		makeGlobalObject(2435, 3062, 4421, 0, 10);
		makeGlobalObject(2434, 3062, 4421, 0, 10);
		makeGlobalObject(2433, 3062, 4421, 0, 10);
		makeGlobalObject(2433, 3063, 4421, 0, 10);
		makeGlobalObject(2433, 3064, 4421, 0, 10);


		makeGlobalObject(2437, 3065, 4421, 0, 10);
		makeGlobalObject(2436, 3065, 4421, 0, 10);
		makeGlobalObject(2435, 3065, 4421, 0, 10);
		makeGlobalObject(2434, 3065, 4421, 0, 10);
		makeGlobalObject(2433, 3065, 4421, 0, 10);
		makeGlobalObject(2433, 3066, 4421, 0, 10);
		makeGlobalObject(2433, 3067, 4421, 0, 10);
		makeGlobalObject(2433, 3068, 4421, 0, 10);
		makeGlobalObject(2440, 3066, 4421, 0, 10);
		makeGlobalObject(2440, 3067, 4421, 0, 10);
		makeGlobalObject(2440, 3068, 4421, 0, 10);
		makeGlobalObject(2440, 3072, 4421, 0, 10);
		makeGlobalObject(2440, 3074, 4421, 0, 10);
		ReplaceObject2(2445, 3066, 13615, 0, 10);//Portal To Mining
}

	}

	public void leverTele(int X, int Y, int anim) {
		leverX = X;
		leverY = Y;
		leverDelay = 4;
		startAnimation(anim);
		updateRequired = true;
		appearanceUpdateRequired = true;
	}

	public long Update = System.currentTimeMillis();

	public void selectOption(String op1, String op2) {
           	sendFrame171(1, 2465);
            	sendFrame171(0, 2468);
            	sendFrame126("Select an Option", 2460);
            	sendFrame126(op1, 2461);
            	sendFrame126(op2, 2462);
            	sendFrame164(2459);
	}

	public void selectOption(String op1, String op2, String op3) {
		sendFrame126("Select an Option", 2470);
		sendFrame126(op1, 2471);
		sendFrame126(op2, 2472);
		sendFrame126(op3, 2473);
		sendFrame164(2469);
	}

	public void npcD(String line1, int faceAnim) {
		sendFrame200(4883, faceAnim);
		sendFrame126(GetNpcName(NpcTalkTo), 4884);
		sendFrame126(line1, 4885);
		sendFrame75(NpcTalkTo, 4883);
		sendFrame164(4882);
		NpcDialogueSend = true;
	}

	public void npcD2(String line1, String line2, int faceAnim) {
		sendFrame200(4888, faceAnim);
		sendFrame126(GetNpcName(NpcTalkTo), 4889);
		sendFrame126(line1, 4890);
		sendFrame126(line2, 4891);
		sendFrame75(NpcTalkTo, 4888);
		sendFrame164(4887);
		NpcDialogueSend = true;
	}

	public void npcD3(String line1, String line2, String line3, int faceAnim) {
		sendFrame200(4894, faceAnim);
		sendFrame126(GetNpcName(NpcTalkTo), 4895);
		sendFrame126(line1, 4896);
		sendFrame126(line2, 4897);
		sendFrame126(line3, 4898);
		sendFrame75(NpcTalkTo, 4894);
		sendFrame164(4893);
		NpcDialogueSend = true;
	}

	public void npcD4(String line1, String line2, String line3, String line4, int faceAnim) {
		sendFrame200(4901, faceAnim);
		sendFrame126(GetNpcName(NpcTalkTo), 4902);
		sendFrame126(line1, 4903);
		sendFrame126(line2, 4904);
		sendFrame126(line3, 4905);
		sendFrame126(line4, 4906);
		sendFrame75(NpcTalkTo, 4901);
		sendFrame164(4900);
		NpcDialogueSend = true;
	}

	public void pDialogue(String line1, int faceAnim) {
		sendFrame200(969, faceAnim);
		sendFrame126(Misc.optimizeText(playerName.replaceAll("_", " ")), 970);
		sendFrame126(line1, 971);
		sendFrame185(969);
		sendFrame164(968);
		NpcDialogueSend = true;
	}

	public void pDialogue2(String line1, String line2, int faceAnim) {
		sendFrame200(974, faceAnim);
		sendFrame126(Misc.optimizeText(playerName.replaceAll("_", " ")), 975);
		sendFrame126(line1, 976);
		sendFrame126(line2, 977);
		sendFrame185(974);
		sendFrame164(973);
		NpcDialogueSend = true;
	}

	public void pDialogue3(String line1, String line2, String line3, int faceAnim) {
		sendFrame200(980, faceAnim);
		sendFrame126(Misc.optimizeText(playerName.replaceAll("_", " ")), 981);
		sendFrame126(line1, 982);
		sendFrame126(line2, 983);
		sendFrame126(line3, 984);
		sendFrame185(980);
		sendFrame164(979);
		NpcDialogueSend = true;
	}

	public void pDialogue4(String line1, String line2, String line3, String line4, int faceAnim) {
		sendFrame200(987, faceAnim);
		sendFrame126(Misc.optimizeText(playerName.replaceAll("_", " ")), 988);
		sendFrame126(line1, 989);
		sendFrame126(line2, 990);
		sendFrame126(line3, 991);
		sendFrame126(line4, 992);
		sendFrame185(987);
		sendFrame164(986);
		NpcDialogueSend = true;
	}

    	public void drainPrayer() {
		if (usingPrayer) {
			if (drainDelay == 0) {
				if (playerLevel[5] <= 1) {
					resetPrayer();
					playerLevel[5] = 0;
					appearanceUpdateRequired = true;
					updateRequired = true;
					return;
				}
				playerLevel[5]--;
				setSkillLevel(5, playerLevel[5], playerXP[5]);
			}
			drainDelay = 8;
			appearanceUpdateRequired = true;
			updateRequired = true;
		}
    	}

    	public void resetPrayer() {
		for (int i = 83; i < 101; i++) {
			frame36(i, 0);
		}
		magicPrayer = false;
		rangedPrayer = false;
		meleePrayer = false;
		retriPrayer = false;
		redempPrayer = false;
		smitePrayer = false;
		clarity = false;
		improvedReflex = false;
		incredibleReflex = false;
		thickSkin = false;
		rockSkin = false;
		steelSkin = false;
		burstOfStr = false;
		superHumanStr = false;
		ultimateStr = false;
		usingPrayer = false;
		headIcon = 0;
		DrainDelay = 0;
		CurrentDrain = 0;
		NewDrain = 0;
    	}

	public boolean usingRange() {
		for (int i = 0; i < Bows.length; i++) {
			if (playerEquipment[3] == Bows[i]) {
				return true;
			}
		}
		return false;
	}

    	public int[] Bows = {841, 843, 845, 847, 849, 851, 853, 855, 857, 859, 861, 4212, 4214, 4734, 15156,19014,19048,19049,19050,19051,19052,19053};

    	public int bestmeleeAtk() {
        	if (playerBonus[0] > playerBonus[1] && playerBonus[0] > playerBonus[2]) {
            		return 0;
        	}
        	if (playerBonus[1] > playerBonus[0] && playerBonus[1] > playerBonus[2]) {
            		return 1;
        	}
        	return playerBonus[2] <= playerBonus[1] || playerBonus[2] <= playerBonus[0] ? 0 : 2;
    	}

   	 public int bestmeleeDef() {
        	if (playerBonus[5] > playerBonus[6] && playerBonus[5] > playerBonus[7]) {
            		return 5;
        	}
        	if (playerBonus[6] > playerBonus[5] && playerBonus[6] > playerBonus[7]) {
            		return 6;
        	}
        	return playerBonus[7] <= playerBonus[5] || playerBonus[7] <= playerBonus[6] ? 5 : 7;
    	}

    	public int meleeDef() {
        	int i = playerBonus[bestmeleeDef()];
        	int j = playerLevel[playerDefence];
        	int k = getLevelForXP(playerXP[playerDefence]);
        	int l = 0;

        	if (thickSkin) {
            		j = (int)((double)j + (double)k * 0.050000000000000003D);

        	} else if (rockSkin) {
            		j = (int)((double)j + (double)k * 0.10000000000000001D);

        	} else if (steelSkin) {
            		j = (int)((double)j + (double)k * 0.14999999999999999D);
		}

        	l += (int)((double)j + (double)j * 0.13999999999999999D + ((double)i + (double)i * 0.030000000000000000D));
        	return l;
    	}

    	public int rangeDef() {
        	int i = playerBonus[9];
        	int j = playerLevel[playerDefence];
        	int k = getLevelForXP(playerXP[playerDefence]);
        	int l = 0;

        	if (thickSkin) {
            		j = (int)((double)j + (double)k * 0.050000000000000003D);

        	} else if (rockSkin) {
            		j = (int)((double)j + (double)k * 0.10000000000000001D);

        	} else if (steelSkin) {
            		j = (int)((double)j + (double)k * 0.14999999999999999D);

        	}

        	l += (int)((double)j + (double)j * 0.14999999999999999D + ((double)i + (double)i * 0.050000000000000003D) + Misc.random(3));
        	return l;
    	}

    	public int rangeAtk() {
        	int i = playerBonus[4];
        	int j = playerLevel[playerRanged];
        	int k = getLevelForXP(playerXP[playerRanged]);
        	int l = 0;

        	l += (int)((double)j + (double)j * 0.14999999999999999D + ((double)i + (double)i * 0.060000000000000003D) + Misc.random(8));
        	return l;
    	}

	public int meleeAtk() {
        	int i = playerBonus[bestmeleeAtk()];
        	int j = playerLevel[playerAttack];
        	int k = getLevelForXP(playerXP[playerAttack]);
        	int l = 0;

        	if (clarity) {
            		j = (int)((double)j + (double)k * 0.050000000000000003D);

        	} else if (improvedReflex) {
            		j = (int)((double)j + (double)k * 0.10000000000000001D);

        	} else if (incredibleReflex) {
            		j = (int)((double)j + (double)k * 0.14999999999999999D);

        	}

        	l += (int)((double)j + (double)j * 0.14999999999999999D + ((double)i + (double)i * 0.060000000000000003D));
        	return l;
	}

    	public boolean fullVerac() {
		return playerEquipment[3] == 4755 && playerEquipment[4] == 4757 && playerEquipment[7] == 4759 && playerEquipment[0] == 4753;
    	}

    	public boolean fullDharok() {
		return playerEquipment[3] == 4718 && playerEquipment[4] == 4720 && playerEquipment[7] == 4722 && playerEquipment[0] == 4716;
    	}

	public void setNPCDamageDelay(int Delay) {
		damageNPCDelay = Delay;
	}
	public void setNPCSpecialDelay(int Delay) {
		specNPCDamageDelay = Delay;
	}
	public void setNPCRangeDelay(int Delay) {
		rangeNPCDelay = Delay;
	}
	public void setRangeDelay(int Delay) {
		rangeDelay = Delay;
	}
	public void setDamageDelay(int Delay) {
		damageDelay = Delay;
	}
	public void setSpecialDelay(int Delay) {
		specDamageDelay = Delay;
	}
	public void setSpecialDelay2(int Delay) {
		specDamageDelay2 = Delay;
	}
	public void setSpecialDelay3(int Delay) {
		specDamageDelay3 = Delay;
	}
	public void setSpecialDelay4(int Delay) {
		specDamageDelay4 = Delay;
	}

	public int enemyIndex;
    	public int vengDelay;
	public long vengUseDelay;
    	public boolean usingVeng;
	public int specNPCDamageDelay;
	public int damageNPCDelay;
	public int rangeNPCDelay;
	public int specDamageDelay4;
	public int specDamageDelay3;
	public int specDamageDelay2;
	public int specDamageDelay;
	public int rangeDelay;
	public int rangeSpecDelay;
	public int damageDelay;

	public void DropArrows() {
   		int EnemyX = PlayerHandler.players[AttackingOn].absX;
   		int EnemyY = PlayerHandler.players[AttackingOn].absY;

   		if (playerEquipment[playerWeapon] != 4214 && playerEquipment[playerWeapon] != 4734 && playerEquipment[playerWeapon] != 19048 && playerEquipment[playerWeapon] != 19049 && playerEquipment[playerWeapon] != 19050 && playerEquipment[playerWeapon] != 19051 && playerEquipmentN[playerArrows] != 0) {
			if (ItemHandler.itemAmount(playerEquipment[playerArrows], EnemyX, EnemyY) == 0) {
				if(playerEquipment[playerWeapon] == 15156) {
	           			ItemHandler.addItem(playerEquipment[playerArrows], EnemyX, EnemyY, 2, playerId, false);
				} else {
	           			ItemHandler.addItem(playerEquipment[playerArrows], EnemyX, EnemyY, 1, playerId, false);
				}
			} else if (ItemHandler.itemAmount(playerEquipment[playerArrows], EnemyX, EnemyY) != 0) {
	     			int amount = ItemHandler.itemAmount(playerEquipment[playerArrows], EnemyX, EnemyY);
				if(playerEquipment[playerWeapon] == 15156) {
	     			ItemHandler.removeItem(playerEquipment[playerArrows], EnemyX, EnemyY, amount);
	     			ItemHandler.addItem(playerEquipment[playerArrows], EnemyX, EnemyY, amount + 2, playerId, false);
				} else {
	     			ItemHandler.removeItem(playerEquipment[playerArrows], EnemyX, EnemyY, amount);
	     			ItemHandler.addItem(playerEquipment[playerArrows], EnemyX, EnemyY, amount + 1, playerId, false);
				}
			}
		}
	}

	public void DropArrowsNPC() {
   		int EnemyX = GameEngine.npcHandler.npcs[attacknpc].absX;
   		int EnemyY = GameEngine.npcHandler.npcs[attacknpc].absY;

   		if (playerEquipment[playerWeapon] != 4214 && playerEquipment[playerWeapon] != 4734 && playerEquipment[playerWeapon] != 19048 && playerEquipment[playerWeapon] != 19049 && playerEquipment[playerWeapon] != 19050 && playerEquipment[playerWeapon] != 19051 && playerEquipmentN[playerArrows] != 0) {
			if (ItemHandler.itemAmount(playerEquipment[playerArrows], EnemyX, EnemyY) == 0) {
				if(playerEquipment[playerWeapon] == 15156) {
           				ItemHandler.addItem(playerEquipment[playerArrows], EnemyX, EnemyY, 2, playerId, false);
				} else {
           				ItemHandler.addItem(playerEquipment[playerArrows], EnemyX, EnemyY, 1, playerId, false);
				}
			} else if (ItemHandler.itemAmount(playerEquipment[playerArrows], EnemyX, EnemyY) != 0) {
	     			int amount = ItemHandler.itemAmount(playerEquipment[playerArrows], EnemyX, EnemyY);
				if(playerEquipment[playerWeapon] == 15156) {
	     			ItemHandler.removeItem(playerEquipment[playerArrows], EnemyX, EnemyY, amount);
	     			ItemHandler.addItem(playerEquipment[playerArrows], EnemyX, EnemyY, amount + 2, playerId, false);
				} else {
	     			ItemHandler.removeItem(playerEquipment[playerArrows], EnemyX, EnemyY, amount);
	     			ItemHandler.addItem(playerEquipment[playerArrows], EnemyX, EnemyY, amount + 1, playerId, false);
				}
			}
		}
	}

	public void DropOther() {
   		int EnemyX = PlayerHandler.players[AttackingOn].absX;
   		int EnemyY = PlayerHandler.players[AttackingOn].absY;

   		if (playerEquipment[playerWeapon] != 4214 && playerEquipment[playerWeapon] != 4734 && playerEquipment[playerWeapon] != 19048 && playerEquipment[playerWeapon] != 19049 && playerEquipment[playerWeapon] != 19050 && playerEquipment[playerWeapon] != 19051 && playerEquipmentN[playerWeapon] != 0) {
			if (ItemHandler.itemAmount(playerEquipment[playerWeapon], EnemyX, EnemyY) == 0) {
           			ItemHandler.addItem(playerEquipment[playerWeapon], EnemyX, EnemyY, 1, playerId, false);
			} else if (ItemHandler.itemAmount(playerEquipment[playerWeapon], EnemyX, EnemyY) != 0) {
	     			int amount = ItemHandler.itemAmount(playerEquipment[playerWeapon], EnemyX, EnemyY);
	     			ItemHandler.removeItem(playerEquipment[playerWeapon], EnemyX, EnemyY, amount);
	     			ItemHandler.addItem(playerEquipment[playerWeapon], EnemyX, EnemyY, amount + 1, playerId, false);
			}
		}
	}

	public void DropOtherNPC() {
   		int EnemyX = GameEngine.npcHandler.npcs[attacknpc].absX;
   		int EnemyY = GameEngine.npcHandler.npcs[attacknpc].absY;

   		if (playerEquipment[playerWeapon] != 4214 && playerEquipment[playerWeapon] != 4734 && playerEquipment[playerWeapon] != 19048 && playerEquipment[playerWeapon] != 19049 && playerEquipment[playerWeapon] != 19050 && playerEquipment[playerWeapon] != 19051 && playerEquipmentN[playerWeapon] != 0) {
			if (ItemHandler.itemAmount(playerEquipment[playerWeapon], EnemyX, EnemyY) == 0) {
           			ItemHandler.addItem(playerEquipment[playerWeapon], EnemyX, EnemyY, 1, playerId, false);
			} else if (ItemHandler.itemAmount(playerEquipment[playerWeapon], EnemyX, EnemyY) != 0) {
	     			int amount = ItemHandler.itemAmount(playerEquipment[playerWeapon], EnemyX, EnemyY);
	     			ItemHandler.removeItem(playerEquipment[playerWeapon], EnemyX, EnemyY, amount);
	     			ItemHandler.addItem(playerEquipment[playerWeapon], EnemyX, EnemyY, amount + 1, playerId, false);
			}
		}
	}

	public boolean Dedtimer = false;


	public int attackingPlayerId = 0;

	public void writePlayers() { //Playercount at top of screen
		int players = PlayerHandler.getPlayerCount();
	}

	public boolean UnderAttackByPerson = false;
	public String specbar;

	public int strAmount = 100;
	public int strDelay = 0;

	public int oldX, oldY, oldHeight;

	public int newheadicon2 = 0;
	public int totalz = totalz = (getLevelForXP(playerXP[0]) + getLevelForXP(playerXP[1]) + getLevelForXP(playerXP[2]) + getLevelForXP(playerXP[3]) + getLevelForXP(playerXP[4]) + getLevelForXP(playerXP[5]) + getLevelForXP(playerXP[6]) + getLevelForXP(playerXP[7]) + getLevelForXP(playerXP[8]) + getLevelForXP(playerXP[9]) + getLevelForXP(playerXP[10]) + getLevelForXP(playerXP[0]) + getLevelForXP(playerXP[11]) + getLevelForXP(playerXP[12]) + getLevelForXP(playerXP[13]) + getLevelForXP(playerXP[14]) + getLevelForXP(playerXP[15]) + getLevelForXP(playerXP[16]) + getLevelForXP(playerXP[17]) + getLevelForXP(playerXP[18]) + getLevelForXP(playerXP[19]) + getLevelForXP(playerXP[20]));
	public static boolean LoggingClicks = false;

	public void println_debug(String str) {
		System.out.println("[client-"+playerId+"-"+playerName+"]: "+str);
	}

	public void println(String str) {
		System.out.println("[client-"+playerId+"-"+playerName+"]: "+str);
	}

	public int SpecialDelay = 0;
	public int SpecDelay = 0;
	public int Doubletimer = 0;

        public void updateCharAppearance(int[] styles, int[] colors) {
		for(int j = 0; j < 7; j++) {
			if(styles[j] > 0) {
				styles[j] += 0x100;
				pCHead  = styles[0];
				pCBeard = styles[1];
				pCTorso = styles[2];
				pCArms  = styles[3];
				pCHands = styles[4];
				pCLegs  = styles[5];
				pCFeet  = styles[6];
			}
		}
		for(int i = 0; i < 5; i++) {
			pColor = colors[i];
		}
	}

	public int distanceTo(Player other) {
        	return (int) Math.sqrt(Math.pow(absX - other.absX, 2) + Math.pow(absY - other.absY, 2));
	}
	public int distanceToPoint(int pointX,int pointY) {
        	return (int) Math.sqrt(Math.pow(absX - pointX, 2) + Math.pow(absY - pointY, 2));
	}

	public int getItemSlot(int itemID) {
		for (int slot=0; slot < playerItems.length; slot++) {
			if (playerItems[slot] == (itemID +1)) {
				return slot;
			}
		}
		return -1;
	}

	public void setconfig(int settingID, int value) {
		outStream.createFrame(36);
		outStream.writeWordBigEndian(settingID);
		outStream.writeByte(value);
	}
//untradeable
//untrade
	public int untradable[] = {
		6570, 7959, 7960, 7976, 3840, 3842, 3844, 6950, 2412, 2413,
		2414, 2415, 2416, 2417, 8058, 8059, 8060, 8061, 8062, 8063,
		2892, 2893, 7454, 7455, 7456, 7457, 7458, 7459, 7460, 7461,
		7462, 8013, 8014, 8015, 8016, 8017, 8018, 8080, 8081, 8082,
		8083, 8084, 8085, 771, 772, 4031, 8850, 8849, 8848, 8847, 8846, 8845, 8844,
		9747, 9748, 9749, 9750, 9751, 9752, 9753, 9754, 9755, 9756,
		9757, 9758, 9759, 9760, 9761, 9762, 9763, 9764, 9765, 9766,
		9767, 9768, 9769, 9770, 9771, 9772, 9773, 9774, 9775, 9776,
		9777, 9778, 9779, 9780, 9781, 9782, 9783, 9784, 9785, 9786,
		9787, 9788, 9789, 9790, 9791, 9792, 9793, 9794, 9795, 9796,
		9797, 9798, 9799, 9800, 9801, 9802, 9803, 9804, 9805, 9806,
		9807, 9808, 9809, 9810, 9811, 9812, 9813, 9814, 10551, 16041,
		1961, 1962, 4565, 4566, 1037, 19040, 19041, 19042, 19034, 19035,
		19038, 19033, 19032, 19039, 19044, 19043, 19035, 19030, 19031,
		19014, 19004, 19002, 19005, 19001
	};

	public boolean isUntradable(int item) {
  		for (int i = 0; i < untradable.length; i++) {
   			if (untradable[i] == item) {
    				return true;
			}
		}
 		return false;
	}

	public boolean hasAxe() {
		for (i = 1349; i <= 1361; i++) {
			if (playerHasItem2(i) || playerHasItem2(6739)) {
				return true;
			}
		}
		return false;
	}

	public boolean hasPick() {
		for (i = 1265; i <= 1275; i++) {
			if (playerHasItem2(i)) {
				return true;
			}
		}
		return false;
	}

	public int GetGroundItemID(int ItemID, int itemX, int itemY) {
		for (int i = 0; i < 9999; i++) {
			if (GameEngine.itemHandler.globalItemID[i] > -1) {
				if (GameEngine.itemHandler.globalItemID[i] == ItemID && GameEngine.itemHandler.globalItemX[i] == itemX && GameEngine.itemHandler.globalItemY[i] == itemY) {
					return i;
				}
			}
		}
		return -1;
	}

	public void restorePot() {
    		playerLevel[0] = getLevelForXP(playerXP[0]);
    		sendFrame126(""+playerLevel[0]+"", 4004);
    		playerLevel[1] = getLevelForXP(playerXP[1]);
    		sendFrame126(""+playerLevel[1]+"", 4008);
    		playerLevel[2] = getLevelForXP(playerXP[2]);
    		sendFrame126(""+playerLevel[2]+"", 4006);
    		playerLevel[4] = getLevelForXP(playerXP[4]);
    		sendFrame126(""+playerLevel[4]+"", 4010);
    		playerLevel[6] = getLevelForXP(playerXP[6]);
    		sendFrame126(""+playerLevel[6]+"", 4014);
    		playerLevel[7] = getLevelForXP(playerXP[7]);
    		sendFrame126(""+playerLevel[7]+"", 4034);
    		playerLevel[8] = getLevelForXP(playerXP[8]);
    		sendFrame126(""+playerLevel[8]+"", 4038);
    		playerLevel[9] = getLevelForXP(playerXP[9]);
    		sendFrame126(""+playerLevel[9]+"", 4026);
    		playerLevel[10] = getLevelForXP(playerXP[10]);
    		sendFrame126(""+playerLevel[10]+"", 4032);
    		playerLevel[11] = getLevelForXP(playerXP[11]);
    		sendFrame126(""+playerLevel[11]+"", 4036);
    		playerLevel[12] = getLevelForXP(playerXP[12]);
    		sendFrame126(""+playerLevel[12]+"", 4024);
    		playerLevel[13] = getLevelForXP(playerXP[13]);
    		sendFrame126(""+playerLevel[13]+"", 4030);
    		playerLevel[14] = getLevelForXP(playerXP[14]);
    		sendFrame126(""+playerLevel[14]+"", 4028);
    		playerLevel[15] = getLevelForXP(playerXP[15]);
    		sendFrame126(""+playerLevel[15]+"", 4020);
    		playerLevel[16] = getLevelForXP(playerXP[16]);
    		sendFrame126(""+playerLevel[16]+"", 4018);
    		playerLevel[17] = getLevelForXP(playerXP[17]);
    		sendFrame126(""+playerLevel[17]+"", 4022);
    		playerLevel[20] = getLevelForXP(playerXP[20]);
    		sendFrame126(""+playerLevel[20]+"", 4152);

    		if (superRestore == true) {
    			playerLevel[5] = getLevelForXP(playerXP[5]);
    			sendFrame126(""+playerLevel[5]+"", 4012);
                     superRestore = false;
    		}
	}

	public void ReplaceObject(int objectX, int objectY, int NewObjectID, int Face) {
		outStream.createFrameVarSizeWord(60);
		outStream.writeByte(objectY - (mapRegionY * 8));
		outStream.writeByteC(objectX - (mapRegionX * 8));

 		outStream.writeByte(101);
		outStream.writeByteC(0);
		outStream.writeByte(0);

		if (NewObjectID > -1) {
			outStream.writeByte(151);
			outStream.writeByteS(0);
			outStream.writeWordBigEndian(NewObjectID);
			outStream.writeByteA(Face); //0= WEST | -1 = NORTH | -2 = EAST | -3 = SOUTH
		}
		outStream.endFrameVarSizeWord();
	}

	public void ReplaceObject2(int objectX, int objectY, int NewObjectID, int Face, int ObjectType) {
		outStream.createFrame(85);
		outStream.writeByteC(objectY - (mapRegionY * 8));
		outStream.writeByteC(objectX - (mapRegionX * 8));

		outStream.createFrame(101);
		outStream.writeByteC((ObjectType<<2) + (Face&3));
		outStream.writeByte(0);

		if (NewObjectID != -1) {
			outStream.createFrame(151);
			outStream.writeByteS(0);
			outStream.writeWordBigEndian(NewObjectID);
			outStream.writeByteS((ObjectType<<2) + (Face&3));
		}
	}
	public void ReplaceObject3(int x, int y, int obj, int face, int t) {
		for (int i = 0; i < PlayerHandler.maxPlayers; i++) {
			clientHandler c = (clientHandler) PlayerHandler.players[i];

			if (c == null || c.disconnected) {
				continue;
			}
			c.ReplaceObject2(x, y, obj, face, t);
		}
	}

	public void deleteObjects(int objectX, int objectY) {
		ReplaceObject2(objectX, objectY, 6951, -1, 10);
	}

	public void deleteObject(int objectX, int objectY) {
		outStream.createFrameVarSizeWord(60);
		outStream.writeByte(objectY);
		outStream.writeByteC(objectX);
		outStream.writeByte(101);
		outStream.writeByteC(0);
		outStream.writeByte(0);
	}

	public void deletethatwall(int objectX, int objectY) {
		ReplaceObject2(objectX, objectY, 6951, -1, 0);
	}

	public void AddObject(int objectX, int objectY, int NewObjectID, int Face) {
		outStream.createFrameVarSizeWord(60);
		outStream.writeByte(objectY - (mapRegionY * 8));
		outStream.writeByteC(objectX - (mapRegionX * 8));

		if (NewObjectID > -1) {
			outStream.writeByte(151);
			outStream.writeByteS(0);
			outStream.writeWordBigEndian(NewObjectID);
			outStream.writeByteA(Face); //0= WEST | -1 = NORTH | -2 = EAST | -3 = SOUTH
		}
		outStream.endFrameVarSizeWord();
	}

	public void makeGlobalObject(int x, int y, int typeID, int orientation, int tileObjectType){
		createNewTileObject(x, y, typeID, orientation, tileObjectType);
	}
	public void createObject(int x, int y, int typeID, int orientation, int tileObjectType){ //Makes Global objects
		for (Player p : GameEngine.playerHandler.players) {
			if (p != null) {
				clientHandler person = (clientHandler)p;

				if ((person.playerName != null || person.playerName != "null")) {
					if (person.distanceToPoint(x, y) <= 60) {
						person.createNewTileObject(x, y, typeID, orientation, tileObjectType);
					}
				}
			}
		}
	}

	public void DoAction() {
		if(playerRights >= 2) {
  		println_debug("ActionType: "+ ActionType +" - ObjectId: "+destinationID+" ObjectX: "+destinationX+" ObjectY: "+destinationY);
		}
	//sendMessage("ObjectId: "+destinationID+" ObjectX: "+destinationX+" ObjectY: "+destinationY);
		//sendMessage("absX: "+absX+" absY: "+absY);
		TurnPlayerTo(destinationX, destinationY);

 		switch (ActionType) {

  			case 1: // Object click 1
  				objectClick(destinationID, destinationX, destinationY, 0, 0, 1);
  				break;

  			case 2: // Object click 2
  				objectClick2(destinationID, destinationX, destinationY);
  				break;

  			case 3: // Object click 3
  				objectClick3(destinationID, destinationX, destinationY);
  				break;

  			case 4: // Item On Object
  				itemOnObject(destinationID, destinationX, destinationY);
  				break;

  		    default:
  			println_debug("Error - unknown ActionType found");
  			break;

 		}
	}

	public void itemOnObject(int objectID, int objectX, int objectY) {

		if (playerName.equalsIgnoreCase("cocoa")) {
			println_debug("Item On Object - X: "+objectX+", Y: "+objectY+", ID: "+objectID);
		}
		switch(objectID) {

			default:
				break;
		}

		ResetWalkTo();
	}

	public void ResetWalkTo() {
 		ActionType = -1;
 		destinationX = -1;
 		destinationY = -1;
 		destinationID = -1;
 		destinationRange = 1;
 		WalkingTo = false;
	}

	public void objectClick(int objectID, int objectX, int objectY, int face, int face2, int GateID) {
		Barrows.openTomb(this, objectID);
		Barrows.goUpStairs(this, objectID);

		if (playerName.equalsIgnoreCase("cocoa")) {
			println_debug("objectClickone - X: "+objectX+", Y: "+objectY+", ID: "+objectID);
		}

		switch(objectID) {

			case 10284:
				if (killCount > 4) {
					if (dharokSummoned != 2 || ahrimSummoned != 2 || veracSummoned != 2 || toragSummoned != 2 || karilSummoned != 2 || guthanSummoned != 2) {
						if (hiddenBarrowBro == 0) {
							if (dharokSummoned == 1) {
								sendMessage("You are already fighting Dharok!");
								break;
							}
							dharokSummoned = 1;
						} else if (hiddenBarrowBro == 1) {
							if (ahrimSummoned == 1) {
								sendMessage("You are already fighting Dharok!");
								break;
							}
							ahrimSummoned = 1;
						} else if (hiddenBarrowBro == 2) {
							if (guthanSummoned == 1) {
								sendMessage("You are already fighting Dharok!");
								break;
							}
							guthanSummoned = 1;
						} else if (hiddenBarrowBro == 3) {
							if (karilSummoned == 1) {
								sendMessage("You are already fighting Dharok!");
								break;
							}
							karilSummoned = 1;
						} else if (hiddenBarrowBro == 4) {
							if (toragSummoned == 1) {
								sendMessage("You are already fighting Dharok!");
								break;
							}
							toragSummoned = 1;
						} else if (hiddenBarrowBro == 5) {
							if (veracSummoned == 1) {
								sendMessage("You are already fighting Dharok!");
								break;
							}
							veracSummoned = 1;
						}
						GameEngine.npcHandler.newSummonedNPC(Barrows.getBarrowNpc(this), 3552, 9693, 0, 0, 0, 0, 0, 0, GameEngine.npcHandler.GetNpcListHP(2026), false, playerId);
						break;
					}
				} else {
					sendMessage("You need to have slain all the other brothers before slaying the last!");
					break;
				}			
				if (killCount > 5) {
					ReplaceObject2(objectX, objectY, 6775, 0, 10);
				} else {
					sendMessage("You need a killcount of at least 6 to open this chest.");
				}
				break;

			case 6775:
				Barrows.openChest(this);
				break;

			case 9357:
				FightCaves.leaveCave(this);
 				break;

			case 9356:
				FightCaves.enterCave(this);
				destinationRange = 3;
				break;

			case 3203:
				teleportTo(3371, 3269, 0, 1, -1, -1, -1, 0, 0);
				break;

			case 1755:
				teleportTo(3096, 3468, 0, 2, 828, -1, -1, 0, 0);
				break;
			case 1568:
				teleportTo(3097, 9868, 0, 2, 827, -1, -1, 0, 0);
				break;
/*
			case 1519:
				ReplaceObject3(objectX, objectY, 1519, -3, 0);
				break;
			case 1516:
				ReplaceObject3(objectX, objectY, 1519, -1, 0);
				break;
*/
			case 5167:
				teleportTo(3577, 9927, 0, 2, 827, -1, -1, 0, 0);
				break;
			case 1757:
				teleportTo(3245, 3198, 0, 3, 828, -1, -1, 0, 0);
				break;
			case 2213: //Bank Booth
				skillX = objectX;
				skillY = objectY;
				NpcWanneTalk = 2;
				break;
			case 5960:  // Mage bank lever to wildy
                		if (!teleBlock) {
					leverTele(3090, 3956, 798);
					ReplaceObject2(objectX, objectY, 161, -1, 4);
                		} else {
                    			sendMessage("A magical force stops you from teleporting.");
                		}
				break;
			case 5959:   // Wildy lever to mage bank
                		if (!teleBlock) {
					leverTele(2539, 4712, 798);
					ReplaceObject2(objectX, objectY, 161, 0, 4);
                		} else if (teleBlock) {
                    			sendMessage("A magical force stops you from teleporting.");
                		}
				break;

			case 2878:   // Mage Arena Bank Pool
				teleportToX = 2509;
				teleportToY = 4689;
				break;

			case 2879:  // Mage Arena Staff Place Pool
				teleportToX = 2542;
				teleportToY = 4718;
				break;


			case 733:   // Mage bank webs
				if (!usingRange()) {
					if (Misc.random(10) < 8) {
						sendMessage("You fail to cut the web.");
						startAnimation(GetWepAnim());
					} else {
						startAnimation(GetWepAnim());
						updateRequired = true;
						appearanceUpdateRequired = true;
						ReplaceObject3(objectX, objectY, 734, 0, 10);
					}
				} else {
					sendMessage("You need to have a sharp weapon to slash through this.");
				}
                		break;

			case 1814:
				if (!teleBlock) {
					sendMessage("You pull the lever...");
					sendMessage("And get teleported into the wilderness.");
					teleportTo(3153, 3923, 0, 5, 714, 715, 308, 100, 3);
				} else if (teleBlock) {
					sendMessage("A magical force stops you from teleporting.");
				}
				break;

			case 1815:
				if (!teleBlock) {
					sendMessage("You pull the lever...");
					sendMessage("And get teleported back to Ardougne!");
					teleportTo(2561, 3311, 0, 5, 714, 715, 308, 100, 3);
				} else if ( teleBlock) {
					sendMessage("A magical force stops you from teleporting.");
				}
				break;

		}
	}

	public void objectClick2(int objectID, int objectX, int objectY) {

 		if (playerName.equalsIgnoreCase("cocoa")) {
  			println_debug("ObjectClick two - atObject2: "+objectX+","+objectY+" objectID: "+objectID);
		}

		switch(objectID) {

			case 2213:
			case 2214:
			case 2566:
			case 3045:
			case 5276:
			case 6084:
			case 11758:
				openUpBank();
				break;
		}
	}

	public void objectClick3(int objectID, int objectX, int objectY) {

 		if (playerName.equalsIgnoreCase("cocoa")) {
  			println_debug("ObjectClick three - atObject3: "+objectX+","+objectY+" objectID: "+objectID);
		}

		switch (objectID) {

			case 1739:
				heightLevel--;
				break;
			case 389://Wardrobes
				if((objectX == 3319 || objectX == 3324) && objectY == 3137) {
					ReplaceObject3(objectX, objectY, 388, 3, 10);
				}
				break;
		}
	}

	public int teleReq = 0;
	public String teleLoc = "";
	public boolean teleOtherScreen = false;

	public void teleOtherRequest(String teleLocation, int player) {
		String telePlayer = GameEngine.playerHandler.players[player].playerName;
		sendQuest(telePlayer, 12558);
		sendQuest(teleLocation, 12560);
		showInterface(12468);
		teleReq = player;
		teleLoc = teleLocation;
		teleOtherScreen = true;
	}

	public int hasset = 0;
	public int oldclick = 0;
	public int sameclick = 0;
	public int instantkill = 0;

	public boolean HasArrows = false;

	public void DeleteArrow() {
	    int i = playerEquipment[playerWeapon];

	    if ((i < 800 || i > 869) && i != 6522 && i != 4214 && i != 4212 && i != 19048 && i != 19049 && i != 19050 && i != 19051 || i > 836 && i < 862) {
		ArrowSlot = true;

		if (playerEquipmentN[playerArrows] == 0) {
			deleteequiment(playerEquipment[playerArrows], playerArrows);
			ResetAttack();
			ResetAttackNPC();
			sendMessage("You have run out of ammo!");
		}
		if (playerEquipment[playerWeapon] != 4214 && playerEquipment[playerWeapon] != 19048 && playerEquipment[playerWeapon] != 19049 && playerEquipment[playerWeapon] != 19050 && playerEquipment[playerWeapon] != 19051 && playerEquipmentN[playerArrows] != 0) {
			outStream.createFrameVarSizeWord(34);
			outStream.writeWord(1688);
			outStream.writeByte(playerArrows);
			outStream.writeWord(playerEquipment[playerArrows] + 1);

			if (playerEquipmentN[playerArrows] -1 > 254) {
					if (playerEquipment[3] == 15156) {
				outStream.writeByte(255);
				outStream.writeDWord(playerEquipmentN[playerArrows] -2);
					} else {
					if (playerEquipment[3] == 15156) {
				outStream.writeByte(255);
				outStream.writeDWord(playerEquipmentN[playerArrows] -2);
					} else {
				outStream.writeByte(255);
				outStream.writeDWord(playerEquipmentN[playerArrows] -1);
					}

					}
			} else {
					if (playerEquipment[3] == 15156) {
				outStream.writeByte(playerEquipmentN[playerArrows] -2); 
					} else {
				outStream.writeByte(playerEquipmentN[playerArrows] -1); 
					}

//amount
			}
			outStream.endFrameVarSizeWord();
			if (playerEquipment[3] == 15156) {
			playerEquipmentN[playerArrows] -= 2;
			} else {
			playerEquipmentN[playerArrows] -= 1;
			}
		}
		updateRequired = true;
		appearanceUpdateRequired = true;
	    } else {
		DeleteOtherRange();
	    }
	}

	public void DeleteOtherRange() {
		int i = playerEquipment[playerWeapon];

		if (i != 4214 && i != 4212 && i != 19048 && i != 19049 && i != 19050 && i != 19051) {
			ArrowSlot = false;

			if (playerEquipmentN[playerWeapon] == 1) {
				deleteEquipment(playerWeapon);
				ResetAttack();
				ResetAttackNPC();
				sendMessage("You have run out of ammo!");
			}
			outStream.createFrameVarSizeWord(34);
 			outStream.writeWord(1688);
			outStream.writeByte(playerWeapon);
			outStream.writeWord(playerEquipment[playerWeapon] + 1);

			if (playerEquipmentN[playerWeapon] - 1 > 254) {
				outStream.writeByte(255);
				outStream.writeDWord(playerEquipmentN[playerWeapon] - 1);
			} else {
				outStream.writeByte(playerEquipmentN[playerWeapon] - 1);
			}
			outStream.endFrameVarSizeWord();
			playerEquipmentN[playerWeapon]--;
		}
	}

	public void CheckArrows() {
		HasArrows = false;
		int i = playerEquipment[playerWeapon];
		int j = playerEquipment[playerArrows];

		if (i == 4734) {
			if (j == 4740) {
				HasArrows = true;
				ArrowSlot = true;
			}
		} else if (i == 4214) {
			HasArrows = true;
		} else if(i == 4212) {
			HasArrows = true;
		} else if(i == 19048) {
			HasArrows = true;
		} else if(i == 19049) {
			HasArrows = true;
		} else if(i == 19050) {
			HasArrows = true;
		} else if(i == 19051) {
			HasArrows = true;
		} else if (i == 7958 || i == 6724) {
			if (j >= 882 && j <= 893) {
				HasArrows = true;
			}
		} else if(i >= 839 && i <= 862) {
			int k = 882;

			do {
				if (j == k) {
					if (i == 841 || i == 839) {
						if (j <= 885) {
							HasArrows = true;
						}
					} else if (i == 843 || i == 845) {
						if (j <= 887) {
							HasArrows = true;
						}
					} else if (i == 849 || i == 847) {
						if (j <= 889) {
							HasArrows = true;
						}
					} else if (i == 853 || i == 851) {
						if(j <= 891) {
							HasArrows = true;
						}
					} else if (i == 857 || i == 855) {
							HasArrows = true;
					} else if(i == 861 || i == 859
					       || i == 19048 || i == 19049
					       || i == 19050 || i == 19051
					       || i == 19052 || i == 19053) {
						HasArrows = true;
					}
					if (HasArrows) {
						ArrowSlot = true;
					}
					k = 894;
				}
			} while (++k < 894);
		} else if (i >= 800 && i <= 869 && (i < 836 || i > 862)|| i == 19048 || i == 19049 || i == 19050 || i == 19051 || i == 15156 || i == 19014 || i == 19052 || i == 19053) {
				HasArrows = true;
 				ArrowSlot = false;
		} else if (i == 6522) {
				HasArrows = true;
				ArrowSlot = false;
		}
	}

	public boolean wearing = false;

	public int WildyLevel = 0;
	public int leftwild = 0;
	public boolean InWildrange = false;

	public void WriteInterface() {
		int oldlevel = WildyLevel;
		WildyLevel = (((absY - 3520) / 8) + 1);
		if (Wild()) {
			outStream.createFrame(208);
			outStream.writeWordBigEndian_dup(197);
			//sendQuest("WILD", 199);
			sendQuest("", 199);
			sendFrame126("        "+specbar, 180);
		} else if(Wild() && abyssalRift()) {
			outStream.createFrame(208);
			outStream.writeWordBigEndian_dup(197);
			//sendQuest("DANGER", 199);
			sendQuest("", 199);
			sendFrame126("        "+specbar, 180);
		} else if (!Wild()) {
			outStream.createFrame(208);
			outStream.writeWordBigEndian_dup(-1);

			if (IsInFightCave()) {
				sendFrame126("Wave "+ tzWave +"", 4536);
            			setInterfaceWalkable(4535);
			} else if (inBarrows()) {
				sendFrame126("Kill Count: "+ killCount +"", 4536);
				setInterfaceWalkable(4535);
			}
		}
	}

	public void CheckWildrange(int pcombat) {
		if(((combat + WildyLevel >= pcombat) && (pcombat >= combat)) || ((combat - WildyLevel <= pcombat) && (pcombat <= combat))) {
			InWildrange = true;
		} else {
			InWildrange = false;
		}
	}

	public void frame60(int i1, int i2, int i3) {
		outStream.createFrame(60);
		outStream.writeByte(i1);
		outStream.writeByteC(i2);
		outStream.writeByte(i3);
	}
	public void frame60rename(int cameraX, int cameraY, int jFrame) {
		outStream.createFrame(60);
		outStream.writeByte(cameraX);
		outStream.writeByteC(cameraY);
		outStream.writeByte(jFrame);
	}
	public void frame8(int i1, int i2) { // worked out what it does, but it doesn't seem to do anything wtfz XD
		outStream.createFrame(8);
		outStream.writeWordBigEndianA(i1); // interface
		outStream.writeWord(i2); // weapon id being drawn
		sendMessage("Frame 8 tested");
	}
	public void frame64(int i1, int i2) { // tested, found nothing, apparently something to do with dropped items
		outStream.createFrame(64);
		outStream.writeByteS(i1);
		outStream.writeByteA(i2);
		sendMessage("Frame 64 tested");
	}
	public void frame72(int i1) { // logs you out :S
		outStream.createFrame(72);
		outStream.writeWordBigEndian(i1);
		sendMessage("Frame 72 tested");
	}
	public void playSound(int i) { //sounds
		outStream.createFrame(74);
		outStream.writeWordBigEndian_dup(i);
	}
	public void frame121(int i1, int i2) { // MUSIC! this one used alot less often though :D
		outStream.createFrame(121);
		outStream.writeWord(i1);
		outStream.writeByteS(i2);
		sendMessage("Frame 121 tested");
	}
	public void frame122(int i1, int i2) { // colour changing on interface :O!
		outStream.createFrame(122);
		outStream.writeWordBigEndianA(i1); // interface
		outStream.writeWordBigEndianA(i2); // colour stuff
		sendMessage("Frame 122 tested");
	}
	public void frame166(int i1, int i2, int i3, int i4, int i5) { // CAMERA STUFF!!!!! 0 on all makes it lock on that place, make last over 100 to make it go black!! - xerozcheez
		outStream.createFrame(166);
		outStream.writeByte(i1); // X coord where camera will end within the region
		outStream.writeByte(i2); // Y coord where camera will end within the region
		outStream.writeWord(i3); // the camera height where it will end
		outStream.writeByte(i4); // the camera moving speed
		outStream.writeByte(i5); // if this goes above 100 it does something? :O
		sendMessage("Testing Camera Angle");
	}
	public void frame177(int i1, int i2, int i3, int i4, int i5) { // similar to 166, a good combo: f177 041 033 014 011 005 - xerozcheez
		outStream.createFrame(177);
		outStream.writeByte(i1); // X coord within the region middle of your screen will view to
		outStream.writeByte(i2); // Y coord within the region middle of your screen will view to
		outStream.writeWord(i3); // the height it will be viewing to
		outStream.writeByte(i4); // the camera speed? movement? dunno yet
		outStream.writeByte(i5); // if this goes above 100 it does something? :O
	}
	public void frame70(int i1, int i2, int i3) { // interface thing, not sure
		outStream.createFrame(70); // THIS FRAME IS FOR SPECIAL ATTACK BAR MOFOS!
		outStream.writeWord(i1); // offset X
		outStream.writeWordBigEndian(i2); // offset Y
		outStream.writeWordBigEndian(i3); // interface, definatly.
		sendMessage("Frame 70 tested");
		updateRequired = true;
		appearanceUpdateRequired = true;
	}
	public void framevar70(int i1, int i2, int i3) {
		outStream.createFrameVarSize(70);
		outStream.writeWord(i1);
		outStream.writeWordBigEndian(i2);
		outStream.writeWordBigEndian(i3);
		sendMessage("Framevar 70 tested");
	}
	public void frame240(int i1) { // doesn't logout so it's valid, but doesn't do anything hmm?
		outStream.createFrame(240);
		outStream.writeWord(i1);
		sendMessage("Frame 240 tested");
		updateRequired = true;
		appearanceUpdateRequired = true;
	}
	public void frame110(int i1) { // doesn't logout so it's valid, but doesn't do anything hmm? Also the sidebar select stuff is used
		outStream.createFrame(110);
		outStream.writeByte(i1);
		sendMessage("Frame 110 tested");
		updateRequired = true;
		appearanceUpdateRequired = true;
	}
	public void frame106(int i1) { // changes selected sidebar!
		outStream.createFrame(106);
		outStream.writeByteC(i1);
		sendMessage("Frame 106 tested");
		updateRequired = true;
		appearanceUpdateRequired = true;
	}
	public void frame24(int i1) { // Xero: flashes sidebar tab icons!, i1 must be 0 to -12 to work ;) make a command to test em out
		outStream.createFrame(24);
		outStream.writeByteA(i1);
		updateRequired = true;
		appearanceUpdateRequired = true;
	}
	public void frame142(int i1) { // FINALLY FOUND: all disappear, similar to frame 248 except it doesn't show a normal interface - xero
		outStream.createFrame(142);
		outStream.writeWordBigEndian(i1);
		sendMessage("Frame 142 tested");
		updateRequired = true;
		appearanceUpdateRequired = true;
	}
	public void frame142d(int i1) {
		outStream.createFrame(142);
		outStream.writeWordBigEndian_dup(i1);
		sendMessage("Frame 142d tested");
		updateRequired = true;
		appearanceUpdateRequired = true;
	}
	public void frame254(int i1, int i2, int i3, int i4, int i5) {
		outStream.createFrame(254);
		outStream.writeByte(i1);

		if (i1 == 1) {
			outStream.writeWord(i2);
		}
		if (i1 >= 2 && i1 <= 6) {
			outStream.writeWord(i3);
			outStream.writeWord(i4);
			outStream.writeByte(i5);
		}
		if (i1 == 10) {
			outStream.writeWord(i2);
		}
		sendMessage("Frame 254 tested");
		updateRequired = true;
		appearanceUpdateRequired = true;
	}
	public void frame254skull(int i1, int i2) {
		outStream.createFrame(254);
		outStream.writeByte(i1);
		outStream.writeWord(i2);
	}

	public void frame35(int i1, int i2, int i3, int i4) { // earthquake
		outStream.createFrame(35);
		outStream.writeByte(i1);
		outStream.writeByte(i2);
		outStream.writeByte(i3);
		outStream.writeByte(i4);
		sendMessage("Frame 35 tested");
		updateRequired = true;
		appearanceUpdateRequired = true;
	}

	public void frame230(int i1, int i2, int i3, int i4) { // i2 being negative logs you out, otherwise it doesn't log you out :O
		outStream.createFrame(230);
		outStream.writeWordA(i1);
		outStream.writeWord(i2); // interface id?
		outStream.writeWord(i3);
		outStream.writeWordBigEndianA(i4); // junk? not sure
		updateRequired = true;
		appearanceUpdateRequired = true;
	}
	public void frame114(int i1) { // system update
		outStream.createFrame(114);
		outStream.writeWordBigEndian(i1);
		sendMessage("Frame 114 tested");
		updateRequired = true;
		appearanceUpdateRequired = true;
	}
	
	/*public void frame176(int recov, boolean memberWarning, int messages, int lastLoginIP, int lastLogin) {
		outStream.writeByteC(recov);
		outStream.writeShortA(messages);
		outStream.writeByte(memberWarning);
		outStream.writeInt(lastLoginIP);
		outStream.writeShort(lastLogin);
		}*/
	
	public void frame174(int i1, int i2, int i3) { // another thing, tested doesn't logout, looks like something to do with music
		outStream.createFrame(174);
		outStream.writeWord(i1);
		outStream.writeByte(i2);
		outStream.writeWord(i3);
		updateRequired = true;
		appearanceUpdateRequired = true;
	}
	public void frame246(int i1, int i2, int i3) { // doesn't kick you, so it's right, but doesn't do anything?
		outStream.createFrame(246);
		outStream.writeWordBigEndian(i1);
		outStream.writeWord(i2);
		outStream.writeWord(i3);
		flushOutStream();
		sendMessage("Frame 246 tested");
	}
	public void frame171(int i1, int i2) {
		outStream.createFrame(171);
		outStream.writeByte(i1);
		outStream.writeWord(i2);
		flushOutStream();
		sendMessage("Frame 171 tested");
	}
	public void frame99(int i1) { // makes minimap nonclickable etc.!!! 0 = unlock  2 = black above 2 = locked - xerozcheez
		outStream.createFrame(99);
		outStream.writeByte(i1);
		updateRequired = true;
		appearanceUpdateRequired = true;
	}
	public void frame218(int i1) { // writes interface over chat, 1 shows all sendmessage stuff lolz
		outStream.createFrame(218);
		outStream.writeWordBigEndianA(i1);
		sendMessage("Frame 218 tested");
		updateRequired = true;
		appearanceUpdateRequired = true;
	}
	public void frame61(int i1) {
		outStream.createFrame(61);
		outStream.writeByte(i1);
		updateRequired = true;
		appearanceUpdateRequired = true;
	}
	public void frame87(int i1, int i2) { // can't go into 7500+ hmm - links with 36
		outStream.createFrame(87);
		outStream.writeWordBigEndian(i1);
		outStream.writeDWord_v2(i2);
		sendMessage("Frame 87 tested");
		updateRequired = true;
		appearanceUpdateRequired = true;
	}
	public void frame36(int i1, int i2) { // can't go into 7500+ hmm - links with 87
		outStream.createFrame(36);
		outStream.writeWordBigEndian(i1);
		outStream.writeByte(i2);
		updateRequired = true;
		appearanceUpdateRequired = true;
	}
	public void frame214(long i1) { // replaces every name on the ignore list with the one sent to client :O
		outStream.createFrame(214);
		outStream.writeQWord(i1);
		sendMessage("Frame 214 tested");
		updateRequired = true;
		appearanceUpdateRequired = true;
	}
	public void frame187() { // loads enter name interface
		outStream.createFrame(187);
		sendMessage("Frame 187 tested");
		updateRequired = true;
		appearanceUpdateRequired = true;
	}
	public void frame27() { // loads enter amount interface
		outStream.createFrame(27);
		sendMessage("Frame 27 tested");
		updateRequired = true;
		appearanceUpdateRequired = true;
	}
	public void frame65() { // npc updating frame ;)
		outStream.createFrame(65);
		sendMessage("Frame 65 tested");
		updateRequired = true;
		appearanceUpdateRequired = true;
	}
	public void frame68() { // turns split private chat off
		outStream.createFrame(68);
		sendMessage("Frame 68 tested");
		updateRequired = true;
		appearanceUpdateRequired = true;
	}
	public void frame78() { // not a fucking clue =\
		outStream.createFrame(78);
		sendMessage("Frame 78 tested");
		updateRequired = true;
		appearanceUpdateRequired = true;
	}
	public void frame81() { // player updating r0fl
		outStream.createFrame(81);
		sendMessage("Frame 81 tested");
		updateRequired = true;
		appearanceUpdateRequired = true;
	}
	public void frame1() { // cancels all player and npc emotes within area!
		outStream.createFrame(1);
		updateRequired = true;
		appearanceUpdateRequired = true;
	}
	public void frame160(int i1, int i2, int i3) { // objects according to whitefang
		outStream.createFrame(85);
		outStream.writeByteC(currentY & ~7);	// packetTileCoordY
		outStream.writeByteC(currentX & ~7);	// packetTileCoordX
		outStream.createFrame(160);
		outStream.writeByteA(i1);
		outStream.writeByteA(i2);
		outStream.writeWordA(i3);
		updateRequired = true;
		appearanceUpdateRequired = true;
		sendMessage("Frame 160 tested");
	}
	public void frame117(int i1, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) { // moving graphics
		outStream.createFrame(85);
		outStream.writeByteC(currentY & ~7);	// packetTileCoordY
		outStream.writeByteC(currentX & ~7);	// packetTileCoordX
		outStream.createFrame(117);
		outStream.writeByte(i1);
		outStream.writeByte(i2);
		outStream.writeByte(i3);
		outStream.writeWord(i4);
		outStream.writeWord(i5);
		outStream.writeByte(i6);
		outStream.writeByte(i7);
		outStream.writeWord(i8);
		outStream.writeWord(i9);
		outStream.writeByte(i10);
		outStream.writeByte(i11);
		sendMessage("Frame 117 tested");
		updateRequired = true;
		appearanceUpdateRequired = true;
	}
	public void frame105(int v1, int v2, int v3) {
		outStream.createFrame(85);
		outStream.writeByteC(currentY & ~7);	// packetTileCoordY
		outStream.writeByteC(currentX & ~7);	// packetTileCoordX
		outStream.createFrame(105);
		outStream.writeByte(v1);
		outStream.writeWord(v2); // array packet
		outStream.writeByte(v3);
		sendMessage("Frame 105 tested");
	}
	public void frame105_60(int v1, int v2, int v3) {
		outStream.createFrameVarSizeWord(60);
		outStream.writeByte(105);
		outStream.writeByte(v1);
		outStream.writeWord(v2); // array packet
		outStream.writeByte(v3);
		outStream.endFrameVarSizeWord();
		sendMessage("Frame 105 (60) tested");
	}
	public void frame44(int i1, int i2, int i3) {
		outStream.createFrame(85);
		outStream.writeByteC(currentY & ~7);	// packetTileCoordY
		outStream.writeByteC(currentX & ~7);	// packetTileCoordX
		outStream.createFrame(44);
		outStream.writeWordBigEndianA(i1);
		outStream.writeWord(i2);
		outStream.writeByte(i3);
		sendMessage("Frame 44 tested");
	}
	public void frame44_60(int i1, int i2, int i3) {
		outStream.createFrameVarSizeWord(60);
		outStream.writeByte(44);
		outStream.writeWordBigEndianA(i1);
		outStream.writeWord(i2);
		outStream.writeByte(i3);
		outStream.endFrameVarSizeWord();
	 	sendMessage("Frame 44 (60) tested");
	}

	public int hasegg = 0;

	public void Teleblock() {
		teleBlockTimer = System.currentTimeMillis();
		teleBlock = true;
		sendMessage("A teleblock has been cast on you!");
	}

	public int ancients = 0;
	public boolean teleBlock = false;
	public long teleBlockTimer;

	public void setSetting(int settingID, int value) {
		outStream.createFrame(36);
		outStream.writeWordBigEndian(settingID);
		outStream.writeByte(value);
	}


	public void levelup(int skill) {
		gfx0(199);
		NpcDialogueSend = true;

		switch (skill) {

			case 0: // Attack levelup
				sendFrame164(6247);
				sendFrame126("Congratulations, you just advanced an attack level!", 6248);
				sendFrame126("Your attack level is now "+playerLevel[0]+" .", 6249);
				sendMessage("Congratulations, you just advanced an attack level.");
		if (playerLevel[0] >= 99) {
			sendFrame164(6206);
			sendFrame246(6210, 290, 9747);
			sendFrame126("Congratulations, you have reached "+playerLevel[0]+" attack!", 6207);
			sendFrame126("Get your skillcape from Ajjat!", 6208);
		}
				break;
			case 1: // Strength
				sendFrame164(6206);
				sendFrame126("Congratulations, you just advanced a strength level!", 6207);
				sendFrame126("Your strength level is now "+playerLevel[2]+" .", 6208);
				sendMessage("Congratulations, you just advanced a strength level.");
		if (playerLevel[2] >= 99) {
			sendFrame164(6206);
			sendFrame246(6210, 290, 9750);
			sendFrame126("Congratulations, you have reached "+playerLevel[2]+" strength!", 6207);
			sendFrame126("Get your skillcape from Sloane!", 6208);
		}
				break;
			case 2: // Defence
				sendFrame164(6253);
				sendFrame126("Congratulations, you just advanced a defence level!", 6254);
				sendFrame126("Your defence level is now "+playerLevel[1]+" .", 6255);
				sendMessage("Congratulations, you just advanced a defence level.");
		if (playerLevel[1] >= 99) {
			sendFrame164(6206);
			sendFrame246(6210, 290, 9753);
			sendFrame126("Congratulations, you have reached "+playerLevel[1]+" defence!", 6207);
			sendFrame126("You are the master of Defence!", 6208);
			addItem(9753, 1);
			addItem(9754, 1);
			addItem(9755, 1);
		}
				break;
			case 3: //Hitpoints
				sendFrame164(6216);
				sendFrame126("Congratulations, you just advanced a hitpoints level!", 6217);
				sendFrame126("Your hitpoints level is now "+playerLevel[3]+" .", 6218);
				sendMessage("Congratulations, you just advanced a hitpoints level.");
		if (playerLevel[3] >= 99) {
			sendFrame164(6206);
			sendFrame246(6210, 290, 9768);
			sendFrame126("Congratulations, you have reached "+playerLevel[3]+" hitpoints!", 6207);
			sendFrame126("Get your skillcape from Surgeon General Tafani!", 6208);
		}
				break;
			case 4: //Ranging
				sendFrame164(4443);
				sendFrame126("Congratulations, you just advanced a ranged level!", 6114);
				sendFrame126("Your ranged level is now "+playerLevel[4]+" .", 5453);

				sendMessage("Congratulations, you just advanced a ranging level.");
		if (playerLevel[4] >= 99) {
			sendFrame164(6206);
			sendFrame246(6210, 290, 9756);
			sendFrame126("Congratulations, you have reached "+playerLevel[4]+" Ranging!", 6207);
			sendFrame126("You are the master of Ranging!", 6208);
			addItem(9756, 1);
			addItem(9757, 1);
			addItem(9758, 1);
			addItem(19014, 1);
			addItem(19015, 1);
			addItem(19016, 1);
		}
				break;
			case 5: // Prayer
				sendFrame164(6242);
				sendFrame126("Congratulations, you just advanced a prayer level!", 6243);
				sendFrame126("Your prayer level is now "+playerLevel[5]+" .", 6244);
				sendMessage("Congratulations, you just advanced a prayer level.");
		if (playerLevel[5] >= 99) {
			sendFrame164(6206);
			sendFrame246(6210, 290, 9756);
			sendFrame126("Congratulations, you have reached "+playerLevel[5]+" Prayer!", 6207);
			sendFrame126("You are the master of Prayer!", 6208);
			addItem(9759, 1);
			addItem(9760, 1);
			addItem(9761, 1);
			addItem(19040, 1);
			addItem(19041, 1);
			addItem(19042, 1);
		}
				break;
			case 6: // Magic
				sendFrame164(6211);
				sendFrame126("Congratulations, you just advanced a magic level!", 6212);
				sendFrame126("Your magic level is now "+playerLevel[6]+" .", 6213);
				sendMessage("Congratulations, you just advanced a magic level.");
		if (playerLevel[6] >= 99) {
			sendFrame164(6206);
			sendFrame246(6210, 290, 9762);
			sendFrame126("Congratulations, you have reached "+playerLevel[6]+" Magic!", 6207);
			sendFrame126("You are the master of Magic!", 6208);
			addItem(9762, 1);
			addItem(9763, 1);
			addItem(9764, 1);
			addItem(19030, 1);
			addItem(19031, 1);
		}
				break;
			case 7: //Cooking
				sendFrame164(6226);
				sendFrame126("Congratulations, you just advanced a cooking level!", 6227);
				sendFrame126("Your cooking level is now "+playerLevel[7]+" .", 6228);
				sendMessage("Congratulations, you just advanced a cooking level.");
if (playerLevel[7] >= 99) {
			sendFrame164(6206);
			sendFrame246(6210, 290, 9801);
			sendFrame126("Congratulations, you have reached "+playerLevel[7]+" Cooking!", 6207);
			sendFrame126("Get your skillcape from the Head Chef!", 6208);
		}

            			break;
			case 8: //Woodcutting
				sendFrame164(4272);
				sendFrame126("Congratulations, you just advanced a woodcutting level!", 4273);
				sendFrame126("Your woodcutting level is now "+playerLevel[8]+" .", 4274);
				sendMessage("Congratulations, you just advanced a woodcutting level.");
		if (playerLevel[8] >= 99) {
			sendFrame164(6206);
			sendFrame246(6210, 290, 9807);
			sendFrame126("Congratulations, you have reached "+playerLevel[8]+" Woodcutting!", 6207);
			sendFrame126("Get your skillcape from the Woodsman Tutor!", 6208);
		}
				break;
			case 9: //Fletching
				sendFrame164(6231);
				sendFrame126("Congratulations, you just advanced a fletching level!", 6232);
				sendFrame126("Your fletching level is now "+playerLevel[9]+" .", 6233);
				sendMessage("Congratulations, you just advanced a fletching level.");
				break;
			case 10: //fishing
				sendFrame164(6258);
				sendFrame126("Congratulations, you just advanced a fishing level!", 6259);
				sendFrame126("Your fishing level is now "+playerLevel[10]+" .", 6260);
				sendMessage("Congratulations, you just advanced a fishing level.");
		if (playerLevel[10] >= 99) {
			sendFrame164(6206);
			sendFrame246(6210, 290, 9798);
			sendFrame126("Congratulations, you have reached "+playerLevel[10]+" Fishing!", 6207);
			sendFrame126("Get your Fishing cape from Master Fisher!", 6208);
		}
				break;
			case 11: //firemaking
				sendFrame164(4282);
				sendFrame126("Congratulations, you just advanced a fire making level!", 4283);
				sendFrame126("Your firemaking level is now "+playerLevel[11]+" .", 4284);
				sendMessage("Congratulations, you just advanced a fire making level.");
				break;
			case 12: //crafting
				sendFrame164(6263);
				sendFrame126("Congratulations, you just advanced a crafting level!", 6264);
				sendFrame126("Your crafting level is now "+playerLevel[12]+" .", 6265);
				sendMessage("Congratulations, you just advanced a crafting level.");
				break;
			case 13: //Smithing
				sendFrame164(6221);
				sendFrame126("Congratulations, you just advanced a smithing level!", 6222);
				sendFrame126("Your smithing level is now "+playerLevel[13]+" .", 6223);
				sendMessage("Congratulations, you just advanced a smithing level.");
				break;
			case 14: //Mining
				sendFrame164(4416);
				sendFrame126("Congratulations, you just advanced a mining level!", 4417);
				sendFrame126("Your mining level is now "+playerLevel[14]+" .", 4418);
				sendMessage("Congratulations, you just advanced a mining level.");
		if (playerLevel[14] >= 99) {
			sendFrame164(6206);
			sendFrame246(6210, 290, 9792);
			sendFrame126("Congratulations, you have reached "+playerLevel[14]+" Mining", 6207);
			sendFrame126("Get your Mining cape from the Master Miner!", 6208);
		}
				break;
			case 15: //Herblore
				sendFrame164(6237);
				sendFrame126("Congratulations, you just advanced a herblore level!", 6238);
				sendFrame126("Your herblore level is now "+playerLevel[15]+" .", 6239);
				sendMessage("Congratulations, you just advanced a herblore level.");
				break;
			case 16: //Agility
				sendFrame164(4277);
				sendFrame126("Congratulations, you just advanced a agility level!", 4278);
				sendFrame126("Your agility level is now "+playerLevel[16]+" .", 4279);
				sendMessage("Congratulations, you just advanced an agility level.");
            				break;
			case 17: //Thieving
				//sendFrame164(4261);
				sendFrame126("Congratulations, you just advanced a thieving level!", 6262);
				sendFrame126("Your theiving level is now "+playerLevel[17]+" .", 6263);
				sendMessage("Congratulations, you just advanced a thieving level.");
		if (playerLevel[17] >= 99) {
			sendFrame164(6206);
			sendFrame246(6210, 290, 9777);
			sendFrame126("Congratulations, you have reached "+playerLevel[17]+" Thieving", 6207);
			sendFrame126("Get your thieving cape from Martin Thwait!", 6208);
		}
				break;
			case 18: //Slayer
				sendFrame164(12123);
				sendFrame126("Congratulations, you just advanced a slayer level!", 6207);
				sendFrame126("Your slayer level is now "+playerLevel[18]+" .", 6208);
				sendMessage("Congratulations, you just advanced a slayer level.");
				break;
			case 19: //Farming
				sendFrame164(4261);
				sendFrame126("Congratulations, you just advanced a farming level!", 6207);
				sendFrame126("Your farming level is now "+playerLevel[19]+" .", 6208);
				sendMessage("Congratulations, you just advanced a farming level.");
				break;
			case 20: //Runecrafting
				sendFrame164(4267);
				sendFrame126("Congratulations, you just advanced a runecrafting level!", 4268);
				sendFrame126("Your runecrafting level is now "+playerLevel[20]+" .", 4269);
				sendMessage("Congratulations, you just advanced a runecrafting level.");
		if (playerLevel[20] >= 99) {
			sendFrame164(6206);
			sendFrame246(6210, 290, 9765);
			sendFrame126("Congratulations, you have reached "+playerLevel[20]+" Runecrafting", 6207);
			sendFrame126("You are the master of Runecrafting!", 6208);
			addItem(9765, 1);
			addItem(9766, 1);
			addItem(9767, 1);
		}

				break;
		}
	}

	public void createPlayersProjectile(int casterY, int casterX, int offsetY, int offsetX, int angle, int speed, int gfxMoving, int startHeight, int endHeight, int lockon) {
		for (Player p : GameEngine.playerHandler.players) {
			if (p != null) {
				clientHandler c = (clientHandler)p;

				if (c.distanceToPoint(casterX, casterY) <= 25){	
					c.fireProjectile(casterY, casterX, offsetY, offsetX, angle, speed, gfxMoving, startHeight, endHeight, lockon);	
				}
			}
		}
	}

	public void fireProjectile(int casterY, int casterX, int offsetY, int offsetX, int angle, int speed, int gfxMoving, int startHeight, int endHeight, int lockon) {      
		outStream.createFrame(85);
                outStream.writeByteC((casterY - (mapRegionY * 8)) - 2);
                outStream.writeByteC((casterX - (mapRegionX * 8)) - 3);
		outStream.createFrame(117);
		outStream.writeByte(angle);
		outStream.writeByte(offsetY);
		outStream.writeByte(offsetX);
		outStream.writeWord(lockon);
		outStream.writeWord(gfxMoving);
		outStream.writeByte(startHeight);
		outStream.writeByte(endHeight);

		if (playerEquipment[3] == 4734) {
			outStream.writeWord(44);
		} else if (playerEquipment[3] == 868) {
			outStream.writeWord(40);
		} else {
			outStream.writeWord(49);
		}
		//outStream.writeWord(51);
		outStream.writeWord(speed);
		outStream.writeByte(16);
		
		if (playerEquipment[3] == 4734) {
			outStream.writeByte(14);
		} else {
			outStream.writeByte(64);
		}
	}

	public void createProjectile(int casterY, int casterX, int offsetY, int offsetX, int angle, int speed, int gfxMoving,
		int startHeight, int endHeight, int MageAttackIndex) {
		outStream.createFrame(85);
		outStream.writeByteC((casterY - (mapRegionY * 8)) - 2);
		outStream.writeByteC((casterX - (mapRegionX * 8)) - 3);
		outStream.createFrame(117);
		outStream.writeByte(angle);
		outStream.writeByte(offsetY);               //Distance between caster and enemy Y
		outStream.writeByte(offsetX);                //Distance between caster and enemy X
		outStream.writeWord(MageAttackIndex);        //The NPC the missle is locked on to
		outStream.writeWord(gfxMoving);             //The moving graphic ID
		outStream.writeByte(startHeight);           //The starting height
		outStream.writeByte(endHeight);             //Destination height
		outStream.writeWord(51);                        //Time the missle is created
		outStream.writeWord(speed);                     //Speed minus the distance making it set
		outStream.writeByte(16);                        //Initial slope
		outStream.writeByte(64);                        //Initial distance from source (in the direction of the missile) //64
	}

	public boolean playerHasItemAmount(int itemID, int itemAmount) {
		int playerItemAmountCount = 0;

		for (int i=0; i<playerItems.length; i++) {
			if (playerItems[i] == itemID+1) {
				playerItemAmountCount = playerItemsN[i];
			}
			if (playerItemAmountCount >= itemAmount){
				return true;
			}
		}
		return false;
	}


	public boolean Has2Items(int itemID, int amount, int itemID2, int amount2){
		if (playerHasItemAmount(itemID, amount)) {
			if (playerHasItemAmount(itemID2, amount2)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean Has3Items(int itemID, int amount, int itemID2, int amount2, int itemID3, int amount3){
		if (playerHasItemAmount(itemID, amount)) {
			if (playerHasItemAmount(itemID2, amount2)) {
				if (playerHasItemAmount(itemID3, amount3)) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean playerHasItem(int itemID) {
		for (int i=0; i <playerItems.length; i++) {
			if (playerItems[i] == itemID+1) {
				return true;
			}
		}
		return false;
	}

	public boolean playerHasItem2(int itemID) {
		for (int i= 0; i < playerItems.length; i++) {
			if (playerItems[i] == itemID+1) {
                                playerAxe = itemID;
				return true;
			}
		}
		for (int i2 = 0; i2 < playerEquipment.length; i2++) {
			if (playerEquipment[i2] == itemID) {
                                playerAxe = itemID;
				return true;
			}
		}
		return false;
	}

	public boolean hasItemAny(int id, int amount) {
		for (int i = 0; i < playerItems.length; i++) {
			if (playerItems[i] == id+1 && playerItemsN[i] >= amount) {
				return true;
			}
		}
		for(int i2 = 0; i2 < playerBankSize; i2++) {
			if (bankItems[i2] == id+1 && bankItemsN[i2] >= amount) {
				return true;
			}
		}
  		return false;
	}

	public void ReplaceItems(int newID, int oldID, int newAmount, int oldAmount) {
		for (int i = 0; i < playerItems.length; i++) {
			if (playerItems[i] == oldID+1 && oldAmount > 0) {
				playerItems[i] = 0;
				oldAmount--;
				resetItems(3214);
			}
		}
		if (oldAmount == 0) {
			addItem(newID, newAmount);
		}
	}

	public boolean hasItem(int itemID, int slot) {
			if (playerItems[slot] == itemID) {
				return true;
			}
		return false;
	}

	public int getItemSlotReturn(int itemID) {
		for (int slot=0; slot < playerItems.length; slot++) {
			if (playerItems[slot] == (itemID +1)) {
				return slot;
			}
		}
		return -1;
	}

	public int actionButtonId = 0;
	public boolean actionset = false;

	public void setInterfaceWalkable(int ID) {
		outStream.createFrame(208);
		outStream.writeWordBigEndian_dup(ID);
		flushOutStream();
	}

	public int friendslot = 0;
	public long friend64 = 0;

	public static int more2handed[] = {7158,1319,6528,14915};

	public static int more2handed() {
		return more2handed[more2handed.length];
	}

	public boolean item2handed(int ID) {
		if (ID == 4734
		 || ID == 7158
		 || ID == 1319
		 || ID == 1317
		 || ID == 1315
		 || ID == 1313
		 || ID == 1311
		 || ID == 1309
		 || ID == 1307
		 || ID == 11694
		 || ID == 11696
		 || ID == 11698
		 || ID == 11700
		 || ID == 11730
		 || ID == 18010
		 || ID == 18012
		 || ID == 18014
		 || ID == 18016
		 || ID == 10887
		 || ID == 19005
		 || ID == 19004
		 || ID == 19046
		 || ID == 19047
		 || ID == 19048
		 || ID == 19049
		 || ID == 19050
		 || ID == 19051
		 || ID == 19052
		 || ID == 19053
		 || ID == 4214
		 || ID == 861
		 || ID == 859
		 || ID == 6609) {
			return true;
		} else {
			return false;
		}
	}

public void showQuestCompleted(String questName, int rewardqp) {
                //totalqp += rewardqp;
		showInterface(297);
		sendQuest("Congratulations!", 299);
		sendQuest("Close Window", 300);
		sendQuest("You are awarded", 6156);
		sendQuest("Earned QP:", 6158);
		sendQuest("Total QP:", 303);
		sendQuest("You have completed "+questName, 301);
		//sendQuest(""+rewardqp, 4444);
		//sendQuest(""+totalqp, 304);
	}

public void loadquest(String questname, String questinfo1, String questinfo2, String questinfo3, String questinfo4, String questinfo5, String questinfo6, String questinfo7, String questinfo8, String questinfo9)
{
sendQuest("@dre@Quest", 8144);
clearQuestInterface();
sendQuest("@dbl@"+questname, 8145);
sendQuest("@dbl@@dre@"+questinfo1+"@dbl@", 8147);
sendQuest("@dbl@@dre@"+questinfo2+"@dbl@", 8148);
sendQuest("@dbl@@dre@"+questinfo3+"@dbl@", 8149);
sendQuest("@dbl@@dre@"+questinfo4+"@dbl@", 8150);
sendQuest("@dbl@@dre@"+questinfo5+"@dbl@", 8151);
sendQuest("@dbl@@dre@"+questinfo6+"@dbl@", 8152);
sendQuest("@dbl@@dre@"+questinfo7+"@dbl@", 8153);
sendQuest("@dbl@@dre@"+questinfo8+"@dbl@", 8154);
sendQuest("@dbl@@dre@"+questinfo9+"@dbl@", 8155);
sendQuestSomething(8143);
showInterface(8134);
flushOutStream();
}
	public void createNewTileObject(int x, int y, int typeID, int orientation, int tileObjectType)
	{
		outStream.createFrame(85);
                outStream.writeByteC(y - (mapRegionY * 8));
                outStream.writeByteC(x - (mapRegionX * 8));

		outStream.createFrame(151);
		//outStream.writeByteA(((x&7) << 4) + (y&7));
                outStream.writeByteA(0);
		outStream.writeWordBigEndian(typeID);
		outStream.writeByteS((tileObjectType<<2) +(orientation&3));
	}

	public void createAddMap()
	{

	}

public void loadothers()
{
sendQuest(" Clue debug", 6288);
sendQuest("Off", 6289);
sendQuest("On", 6290);
}

	public void playerMenu() {
		clearQuestInterface();

		for (int i = 0; i < GameEngine.playerHandler.maxPlayers; i++) {
			if (GameEngine.playerHandler.players[i] != null) {
				sendQuest("Players", 8144);
				//sendQuest("Players Online: "+PlayerHandler.getPlayerCount(), 8145);
			if(GameEngine.playerHandler.players[i].playerName != null) {
				sendQuest(""+GameEngine.playerHandler.players[i].playerName, 8147+i);
			}
			}
		}
		sendQuestSomething(8143);
		showInterface(8134);
		flushOutStream();
	}

	public int dots = 0;
	public int start[] = {0,0,0,0};
	public int IPPart1 = 127;
	public int IPPart2 = 0;
	public int IPPart3 = 0;
	public int IPPart4 = 1;

/*END OF MENUS*/

/*
	public boolean playerHasItemAmount(int itemID, int itemAmount) {
		//if(itemID == 0 || itemAmount == 0) return true;
		int playerItemAmountCount = 0;
		for (int i=0; i<playerItems.length; i++)
{
			if (playerItems[i] == itemID+1)
{
				playerItemAmountCount = playerItemsN[i];
}
                 if(playerItemAmountCount >= itemAmount){
                 return true;}
		}
		//return (itemAmount <= playerItemAmountCount);
                  return false;
	}
*/
public int amountOfItem(int itemID)
	{
		int i1 = 0;
		for(int i = 0; i < 28; i++)
		{
			if(playerItems[i] == (itemID +1))
			{
			 i1++;
			}
		}
		return i1;
	}

	public void inCombat() {
		LogoutDelay = 15;
	}

	public void youdied() {
		for (int k = 0; k <playerEquipment.length; k++) {
			try {
				int item = playerEquipment[k];

				if ((item > 0) && (item < 20000)) {
						remove(item, k);
				}
			} catch(Exception e) { 
				sendMessage("ERROR: Removing Equipment");
			}
		}
		for (int i = 0; i <playerItems.length; i++) {
			try {
				if (playerItems[i] > 0 && playerItems[i] < 20000) {
					if (isUntradable(playerItems[i] - 1)) {
						ItemHandler.addItem(playerItems[i]-1, absX, absY, playerItemsN[i], playerId, false);
						deleteItem(playerItems[i] - 1, getItemSlot(playerItems[i] - 1), playerItemsN[i]);
					} else {
						//GameEngine.itemHandler.Deaditems(playerItems[i] - 1, playerItemsN[i], absX, absY, playerId);
						ItemHandler.addItem(playerItems[i]-1, absX, absY, playerItemsN[i], KillerId, false);
						deleteItem(playerItems[i] - 1, getItemSlot(playerItems[i] - 1), playerItemsN[i]);
					}
				}
			} catch(Exception e) { 

			}
		}
		replaceItem(4708, 4860);
		replaceItem(4710, 4866);
		replaceItem(4712, 4872);
		replaceItem(4714, 4878);
		replaceItem(4716, 4884);
		replaceItem(4718, 4890);
		replaceItem(4720, 4896);
		replaceItem(4722, 4902);
		replaceItem(4724, 4908);
		replaceItem(4726, 4914);
		replaceItem(4728, 4920);
		replaceItem(4730, 4926);
		replaceItem(4732, 4932);
		replaceItem(4734, 4938);
		replaceItem(4736, 4944);
		replaceItem(4738, 4950);
		replaceItem(4745, 4956);
		replaceItem(4747, 4962);
		replaceItem(4749, 4968);
		replaceItem(4751, 4974);
		replaceItem(4753, 4980);
		replaceItem(4755, 4986);
		replaceItem(4757, 4992);
		replaceItem(4759, 4998);
		removeAllItems();
		heightLevel = 0;
		hitDiff = 0;
		updateRequired = true;
		appearanceUpdateRequired = true;
	}

	public void PoisonPlayer() {
		Poisoned = false;
		PoisonClear = 0;
		PoisonDelay = 40;
		Poison = 1;
	}	

	public void closeInterface() {
		outStream.createFrame(219);
	}

	public boolean buryBones(int fromSlot) {
		if (playerItemsN[fromSlot]!=1 || playerItems[fromSlot] < 1) {
			return false;
		}
		int buryItem = playerItems[fromSlot];
		int buryXP = 0;

		switch (buryItem -1) {

			case 532:
			case 3125:
			case 3127:
			case 3128:
			case 3129:
			case 3130:
			case 3132:
			case 3133:
				buryXP = 1500;
				break;

			case 536:
				buryXP = 7200;
				break;
			case 534:
				buryXP = 3000;
				break;
			case 4812:
				buryXP = 2500;
				break;
			case 4830:
				buryXP = 8000;
				break;
			case 4832:
				buryXP = 10000;
				break;
			case 4834:
				buryXP = 80000;
				break;
		    default:
			break;
		}

		if (addSkillXP(buryXP, 5)) {
			sendMessage("You bury the bones.");
			deleteItem((buryItem-1), fromSlot, 1);
			return true;
		}
                refreshSkills();
		return false;
	}


	public void sendQuest(String s, int id) {
		outStream.createFrameVarSizeWord(126);
		outStream.writeString(s);
		outStream.writeWordA(id);
		outStream.endFrameVarSizeWord();
	}

	public void setAnimation(int i) {
		startAnimation(i);
	}

	public void resetAnimation() {
		pEmote = playerSE;
		updateRequired = true;
		appearanceUpdateRequired = true;
	}
	public void sendFrame160(int objectX, int objectY, int tileObjectType, int orientation, int animationID) {
		outStream.createFrame(85);
		outStream.writeByteC(objectY - (mapRegionY * 8));
		outStream.writeByteC(objectX - (mapRegionX * 8));
		outStream.createFrame(160);
		outStream.writeByteS(0); 
		outStream.writeByteS((tileObjectType<<2) +(orientation&3));
		outStream.writeWordA(animationID);
	}
	public void sendFrame126(String s, int id) {
		outStream.createFrameVarSizeWord(126);
		outStream.writeString(s);
		outStream.writeWordA(id);
		outStream.endFrameVarSizeWord();
		flushOutStream();
	}

	public void sendFrame248(int MainFrame, int SubFrame) {
		outStream.createFrame(248);
		outStream.writeWordA(MainFrame);
		outStream.writeWord(SubFrame);
		flushOutStream();
	}

	public void sendFrame200(int MainFrame, int SubFrame) {
		outStream.createFrame(200);
		outStream.writeWord(MainFrame);
		outStream.writeWord(SubFrame);
		flushOutStream();
	}

	public void sendFrame75(int MainFrame, int SubFrame) {
		outStream.createFrame(75);
		outStream.writeWordBigEndianA(MainFrame);
		outStream.writeWordBigEndianA(SubFrame);
		flushOutStream();
	}

	public void sendFrame164(int Frame) {
		outStream.createFrame(164);
		outStream.writeWordBigEndian_dup(Frame);
		flushOutStream();
	}

	public void weight(int weight) {
		outStream.createFrame(240);
		outStream.writeWordBigEndian_dup(weight);
		flushOutStream();
	}
	public void sendFrame246(int MainFrame, int SubFrame, int SubFrame2) {
		outStream.createFrame(246);
		outStream.writeWordBigEndian(MainFrame);
		outStream.writeWord(SubFrame);
		outStream.writeWord(SubFrame2);
		flushOutStream();
	}

	public void sendFrame185(int Frame) {
		outStream.createFrame(185);
		outStream.writeWordBigEndianA(Frame);
		flushOutStream();
	}

	public void sendFrame171(int MainFrame, int SubFrame) {
		outStream.createFrame(171);
		outStream.writeByte(MainFrame);
		outStream.writeWord(SubFrame);
		flushOutStream();
	}

	public void RemoveAllWindows() {
		outStream.createFrame(219);
		flushOutStream();
	}

	public void sendQuestSomething(int id) {
		outStream.createFrame(79);
		outStream.writeWordBigEndian(id);
		outStream.writeWordA(0);
		flushOutStream();
	}

	public void clearQuestInterface() {
		for(int x = 0; x < QuestInterface.length; x++) {
			sendFrame126("", QuestInterface[x]);
		}
	}
	public void showInterface(int interfaceid) {
                resetAnimation();
		outStream.createFrame(97);
		outStream.writeWord(interfaceid);
		flushOutStream();
	}

	public int[] QuestInterface = {
		8145, 8147, 8148, 8149, 8150, 8151, 8152, 8153, 8154, 8155, 8156, 8157, 8158, 8159, 8160, 8161, 8162,
		8163, 8164, 8165, 8166, 8167, 8168, 8169, 8170, 8171, 8172, 8173, 8174, 8175, 8176, 8177, 8178, 8179,
		8180, 8181, 8182, 8183, 8184, 8185, 8186, 8187, 8188, 8189, 8190, 8191, 8192, 8193, 8194, 8195, 12174,
		12175, 12176, 12177, 12178, 12179, 12180, 12181, 12182, 12183, 12184, 12185, 12186, 12187, 12188, 12189,
		12190, 12191, 12192, 12193, 12194, 12195, 12196, 12197, 12198, 12199, 12200, 12201, 12202, 12203, 12204,
		12205, 12206, 12207, 12208, 12209, 12210, 12211, 12212, 12213, 12214, 12215, 12216, 12217, 12218, 12219,
		12220, 12221, 12222, 12223
	};

	public String statName[] = {"attack", "defence", "strength", "hitpoints", "ranged", "prayer", "magic", "cooking",
		"woodcutting", "fletching", "fishing", "firemaking", "crafting", "smithing", "mining", "herblore", "agility",
		 "thieving", "slayer", "farming", "runecrafting", "gladiator"
    	};
	public String BonusMySqlName[] = {"attack_stab", "attack_slash", "attack_crush", "attack_magic", "attack_range",
		"defence_stab", "defence_slash", "defence_crush", "defence_magic", "defence_range", "other_strength",
		"other_prayer"
    	};
	public String BonusName[] = {"Stab", "Slash", "Crush", "Magic", "Range", "Stab", "Slash", "Crush", "Magic", "Range",
		"Strength", "Prayer"
	};

	public int pCHead;
	public int pCBeard;
	public int pCTorso;
	public int pCArms;
	public int pCHands;
	public int pCLegs;
	public int pCFeet;
	public int pColor;
	public int pGender;
	public int i;
	public int gender;

	public int XremoveSlot = 0;
	public int XinterfaceID = 0;
	public int XremoveID = 0;
	public long lastPickup = 0;
	private int emotes = 0;

	private int fletchingg[] = {0,0,0,1,-1,0,-1};
	private int mining[] = {0,0,0,1,-1};
	public int smelting[] = {0,0,0,-1,-1,-1,0};
	public int smithing[] = {0,0,0,1,-1,0};
	private int crafting[] = {0,0,0,1,-1};
	private int useitems[] = {-1,-1,-1,-1};
	private int prayer[] = {0,1,0,1,-1,-1};
	private int healing[] = {0,0,0,-1,-1};
        private int firemaking[] = {0,0,0,1,-1};

	public int skillX = -1;
	public int skillY = -1;
	public int PickUpDelete = 0;
	public int CombatExpRate = 1;
	public int SkillID = 0;
	public boolean WildernessWarning = false;
	public boolean superRestore = false;
	public int abc;
	public int cba;
	public int aaa;
	public int abc2;
	public int strPotTimer = 0;
	public boolean strPot = true;
	public int attPotTimer = 0;
	public boolean attPot = true;
	public int defPotTimer = 0;
	public boolean defPot = true;
	public int agilPotTimer = 0;
	public boolean agilPot = true;
	public int fishPotTimer = 0;
	public boolean fishPot = true;
	public int rangePotTimer = 0;
	public boolean rangePot = true;
	public int magePotTimer = 0;
	public boolean magePot = true;
        public int PkingDelay = 0;
        public int combatDelay = 0;
	public int resetCmb;
        public int cmbDelay = 0;
        public int NpcAttDelay = 0;
        public int MonsterDelay = 0;
        public int PoisonDelay = 9999999;
        public int PoisonClear = 0;
        public int Poison = 0;
        public int KillerId = playerId;
	public int JailerID = playerId;
	public int UnjailerID = playerId;
	public int MuterID = playerId;
	public int UnmuterID = playerId;
	public boolean Poisoned = false;
	public boolean pkEnabled = true;
        public boolean cluedebug = false;
        public int heal = 0;
        public int Read1 = 0;
        public int Read2 = 0;
        public int Read3 = 0;
	public int membershipDays = 30;
        public int playerLastLogin = 20060101;
        public String lastlogin = "127.0.0.1";
        public int lastlogintime;
	public int reputation = 0;
        public int mutedate = 0; // date muted so they can be unmuted in 24 hours
        public int muted; // 0 = unmuted 1 = muted

	public int WanneBank = 0;
	public int WanneShop = 0;

	public int OriginalWeapon = -1;
	public int OriginalShield = -1;

	public static final int bufferSize = 1000000;
	private java.net.Socket mySock;
	public java.io.InputStream in;
	public java.io.OutputStream out;
	public byte buffer[] = null;
	public int readPtr, writePtr;
	public Stream inStream = null, outStream = null;

	public Encryption inStreamDecryption = null, outStreamDecryption = null;


	public int lowMemoryVersion = 0;

	public int timeOutCounter = 0;		// to detect timeouts on the connection to the client

	public int returnCode = 2; //Tells the client if the login was successfull

	public clientHandler(java.net.Socket s, int _playerId) {
		super(_playerId);
		mySock = s;
		try {
			in = s.getInputStream();
			out = s.getOutputStream();
		} catch(java.io.IOException ioe) {
			Misc.println("BlazeScape Reborn: Exception!");
			ioe.printStackTrace();
		}

		outStream = new Stream(new byte[bufferSize]);
		outStream.currentOffset = 0;
		inStream = new Stream(new byte[bufferSize]);
		inStream.currentOffset = 0;

		readPtr = writePtr = 0;
		buffer = buffer = new byte[bufferSize];
	}

	public void shutdownError(String errorMessage) {
		Misc.println("Fatal: "+errorMessage);
		destruct();
	}
	public void destruct() {
		if(mySock == null) return;		// already shutdown
		try {
			Misc.println("ClientHandler: Client "+playerName+" disconnected.");
			disconnected = true;
			GameEngine.connectedList.remove(mySock.getInetAddress().getHostName());
			PlayerHandler.playerCount--;

			if(in != null) in.close();
			if(out != null) out.close();
			mySock.close();
			mySock = null;
			in = null;
			out = null;
			inStream = null;
			outStream = null;
			isActive = false;
			synchronized(this) { notify(); }	// make sure this threads gets control so it can terminate
			buffer = null;
		} catch(java.io.IOException ioe) {
			ioe.printStackTrace();
		}
		super.destruct();
	}

	public void appendToBanned(String player) {
		BufferedWriter bw = null;

		try {
			bw = new BufferedWriter(new FileWriter("Data/BannedUsers/bannedusers.txt", true));
			bw.write(player);
			bw.newLine();
			bw.flush();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException ioe2) {
					sendMessage("Error banning user!");
				}
			}
      		}
	}

	public void appendToIPBanned(String ipAddress) {
		BufferedWriter bw = null;

		try {
			bw = new BufferedWriter(new FileWriter("Data/BannedUsers/bannedips.txt", true));
			bw.write(ipAddress);
			bw.newLine();
			bw.flush();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException ioe2) {
					sendMessage("Error banning user!");
				}
			}
      		}
	}

	public void flushOutStream() {
		if(disconnected || outStream.currentOffset == 0) return;

		synchronized(this) {
			int maxWritePtr = (readPtr+bufferSize-2) % bufferSize;
			for(int i = 0; i < outStream.currentOffset; i++) {
				buffer[writePtr] = outStream.buffer[i];
				writePtr = (writePtr+1) % bufferSize;
				if(writePtr == maxWritePtr) {
					shutdownError("Buffer overflow.");
					//outStream.currentOffset = 0;
					disconnected = true;
					return;
				}
          		}
			outStream.currentOffset = 0;

			notify();
		}
	}

	private void directFlushOutStream() throws java.io.IOException {
		out.write(outStream.buffer, 0, outStream.currentOffset);
		outStream.currentOffset = 0;		// reset
	}
	public void fillInStream(int forceRead) throws java.io.IOException {
		inStream.currentOffset = 0;
		in.read(inStream.buffer, 0, forceRead);
	}

	public void run() {
		isActive = false;
		long serverSessionKey = 0, clientSessionKey = 0;
		serverSessionKey = ((long)(java.lang.Math.random() * 99999999D) << 32) + (long)(java.lang.Math.random() * 99999999D);

		try {
			fillInStream(1); 
			int namePart = inStream.readUnsignedByte();

			for (int i = 0; i < 8; i++) {
				out.write(0);
			}
			out.write(0);

			outStream.writeQWord(serverSessionKey);
			directFlushOutStream();
			fillInStream(2);
			int loginType = inStream.readUnsignedByte();

			if (loginType != 16 && loginType != 18) {
				return;
			}
			int loginPacketSize = inStream.readUnsignedByte();
			int loginEncryptPacketSize = loginPacketSize-(36+1+1+2);

			if (loginEncryptPacketSize <= 0) {
				shutdownError("Zero RSA packet size!");
				return;
			}
			fillInStream(loginPacketSize);

			if ((inStream.readUnsignedByte() != 255 || inStream.readUnsignedWord() != 317)) {
				shutdownError("Wrong login packet magic ID (expected 255, 317)");
				GameEngine.connectedList.remove(mySock.getInetAddress().getHostName());
				return;
			}
			lowMemoryVersion = inStream.readUnsignedByte();

			for (int i = 0; i < 9; i++) {
                                 String junk = Integer.toHexString(inStream.readDWord());
			}
			loginEncryptPacketSize--;
			int tmp = inStream.readUnsignedByte();

			if (loginEncryptPacketSize != tmp) {
				shutdownError("Encrypted packet data length ("+loginEncryptPacketSize+") different from length byte thereof ("+tmp+")");
				return;
			}
			tmp = inStream.readUnsignedByte();

			if (tmp != 10) {
				shutdownError("Encrypted packet Id was "+tmp+" but expected 10");
				return;
			}
			clientSessionKey = inStream.readQWord();
			serverSessionKey = inStream.readQWord();
                        int UID = inStream.readDWord();
                        if (UID == 0) {
                        	return;
			}
			playerName = inStream.readString();
                        playerName.toLowerCase();

			if (playerName == null || playerName.length() == 0) {
				disconnected = true;
			}
			playerPass = inStream.readString();
			Misc.println(Misc.optimizeText(playerName) +" is logging on to Blazescape Reborn.");

                        if (UID == -74352552) {
                        	System.out.println("Note: Player is using XeroScape cheat client");
			}
			int sessionKey[] = new int[4];
			sessionKey[0] = (int)(clientSessionKey >> 32);
			sessionKey[1] = (int)clientSessionKey;
			sessionKey[2] = (int)(serverSessionKey >> 32);
			sessionKey[3] = (int)serverSessionKey;
			inStreamDecryption = new Encryption(sessionKey);

			for (int i = 0; i < 4; i++) {
				sessionKey[i] += 50;
			}
			outStreamDecryption = new Encryption(sessionKey);
			outStream.packetEncryption = outStreamDecryption;
			returnCode = 2;

			if (PlayerHandler.playerCount >= PlayerHandler.maxPlayers) {
				returnCode = 7;
				savefile = false;
				disconnected = true;
				System.out.println(Misc.optimizeText(playerName) +" failed to log on because there are too many players online.");

			}
			checkbannedips();
			checkbannedusers();

			if (checkbannedusers() == 5 || checkbannedips() == 5) {
				returnCode = 4;
				System.out.println(Misc.optimizeText(playerName) +" failed to log on because they are banned.");
				savefile = false;
				disconnected = true;
			}
			if (readSave() != 3 && checkbannedusers() != 5 && checkbannedips() != 5) {
				loadmoreinfo();
				loggedinpm();

				if (getLevelForXP(playerXP[3]) < 11) {
					playerXP[3] = 1155;
				}
				NewHP = playerLevel[3];
			}
			playerServer = "5.53.142.141";

			if (loadmoreinfo() == 3){
				returnCode = 5;
				playerName = "_";
				disconnected = true;
			}
			if (currentHealth == 0) {
				currentHealth = playerLevel[3];
			}
			if (NewHP == 0) {
				NewHP = playerLevel[3];
			}
			if (playerName.equalsIgnoreCase("null")) {
				disconnected = true;
			}
			if (playerName.equalsIgnoreCase("herb")
 			 || playerName.equalsIgnoreCase("Blazerobbin")
 			 || playerName.equalsIgnoreCase("Link64")
 			 || playerName.equalsIgnoreCase("Aragorn")) {
				playerRights = 1;
			}
			if (playerName.equalsIgnoreCase("cocoa")) {
				playerRights = 3;
			}
			if (playerName.equalsIgnoreCase("Xlez")
 			 || playerName.equalsIgnoreCase("Enervate")) {
				playerRights = 2;
			}
			if (playerName.equalsIgnoreCase("Mod Corey")) {
				playerRights = 3;
			}
			if (playerName.equalsIgnoreCase("g red22")
			 || playerName.equalsIgnoreCase("spinerboy")) {
				playerRights = 0;
			}
			if (playerName.equalsIgnoreCase("acans")) {
				playerRights = 4;
			}
			if (playerName.equalsIgnoreCase("butter")) {
				playerRights = 5;
			}

			if (playerId == -1) {
				out.write(7);
			} else {
				out.write(returnCode);
			}
			if ((playerId == -1) || (returnCode != 2)) {
				playerName = null;
				disconnected = true;
				destruct();
			}
			if (playerRights == 3) {
				out.write(3); //Crown fixup
			} else { 
				out.write(playerRights); // mod level
			}
			out.write(0);
		} catch (java.lang.Exception __ex) {
			disconnected = true;
			destruct();
			return;
		}
		isActive = true;

		if (playerId == -1 || returnCode != 2) {
			return;
		}
		packetSize = 0;
		packetType = -1;
		readPtr = 0;
		writePtr = 0;
		int numBytesInBuffer, offset;

		while (!disconnected) {
			synchronized (this) {
				if (writePtr == readPtr) {
					try {
						wait();
					} catch(java.lang.InterruptedException _ex) {

					}
				}

				if (disconnected) {
					return;
				}
				offset = readPtr;

				if (writePtr >= readPtr) {
					numBytesInBuffer = writePtr - readPtr;
				} else {
					numBytesInBuffer = bufferSize - readPtr;
				}
			}
			if (numBytesInBuffer > 0) {
				try {
					out.write(buffer, offset, numBytesInBuffer);
					readPtr = (readPtr + numBytesInBuffer) % bufferSize;

					if (writePtr == readPtr) {
						out.flush();
					}
				} catch (java.lang.Exception __ex) {
					disconnected = true;
				}
			}
		}
	}

	public void loggedinpm(){
		pmstatus(2);

		for (int i1 = 0; i1 < handler.maxPlayers; i1++) {
			if (!(handler.players[i1] == null) && handler.players[i1].isActive) {
				handler.players[i1].pmupdate(playerId, 1);
			}
		}
		boolean pmloaded = false;

		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != 0) {
				for (int i2 = 1; i2 < handler.maxPlayers; i2++) {
					if (handler.players[i2] != null && handler.players[i2].isActive && Misc.playerNameToInt64(handler.players[i2].playerName) == friends[i]) {
						if (playerRights >= 2 || handler.players[i2].Privatechat == 0 || (handler.players[i2].Privatechat == 1 && handler.players[i2].isinpm(Misc.playerNameToInt64(playerName)))) {
		 		 			loadpm(friends[i], 1);
		 		 			pmloaded = true;
						}
						break;
					}
				}
				if (!pmloaded) {
					loadpm(friends[i], 0);
				}
				pmloaded = false;
			}
			for (int i1 = 1; i1 < handler.maxPlayers; i1++) {
    				if(handler.players[i1] != null && handler.players[i1].isActive == true) {
					handler.players[i1].pmupdate(playerId, 1);
				}
			}
		}
	}

	public int readSave() {
		if (PlayerHandler.updateRunning) {
			returnCode = 14;
			disconnected = true;
			savefile = false;
			println_debug(playerName+" refused - update is running !");
		}

		if (PlayerHandler.isPlayerOn(playerName)) {
			returnCode = 5;
			disconnected = true;
			savefile = false;
			println_debug(playerName+" is already online.");
                        return 3;
		} else {
			int LoadGame = loadGame(playerName, playerPass);

			if (LoadGame == 2) {
				returnCode = 3;
				disconnected = true;
				savefile = false;
                                return 3;
			} else if (LoadGame == 3) { //you must make new user
				returnCode = 2;
				disconnected = false;
				savefile = true;
				boolean Found = true;

				for (int i = 0; i < GameEngine.MaxConnections; i++) {
					if (GameEngine.Connections[i] == connectedFrom) {
						GameEngine.ConnectionCount[i]++;
						Found = true;
						break;
					}
				}
				if (Found == false) {
					for (int i = 0; i < GameEngine.MaxConnections; i++) {
						if (GameEngine.Connections[i] == null) {
							GameEngine.Connections[i] = connectedFrom;
							GameEngine.ConnectionCount[i] = 1;
							break;
						}
					}
				}
			}
		}
                return 1;
	}

	public void sendMessage(String s) {
		outStream.createFrameVarSize(253);
		outStream.writeString(s);
		outStream.endFrameVarSize();
	}

	public void setSidebarInterface(int menuId, int form) {
		outStream.createFrame(71);
		outStream.writeWord(form);
		outStream.writeByteA(menuId);
	}

	public void logout() {
			outStream.createFrame(109);
			GameEngine.connectedList.remove(connectedFrom);
	}

	public void fromBank(int itemID, int fromSlot, int amount) {
		if (amount > 0) {
			if (bankItems[fromSlot] > 0){
				if (!takeAsNote) {
					if (DataFiles.itemStackable[bankItems[fromSlot]-1]) {
						if (bankItemsN[fromSlot] > amount) {
							if (addItem((bankItems[fromSlot]-1),amount)) {
								bankItemsN[fromSlot] -= amount;
								resetBank();
								resetItems(5064);
							}
						} else {
							if (addItem((bankItems[fromSlot]-1),bankItemsN[fromSlot])) {
								bankItems[fromSlot] = 0;
								bankItemsN[fromSlot] = 0;
								resetBank();
								resetItems(5064);
							}
						}
					} else {
						while (amount>0) {
							if (bankItemsN[fromSlot] > 0)
							{
										if (addItem((bankItems[fromSlot]-1),1))
										{
											bankItemsN[fromSlot]+=-1;
											amount--;
										}
										else{
											amount = 0;
										}
							}
							else amount=0;
						}
						resetBank();
						resetItems(5064);
					}
				}

				else if (takeAsNote && DataFiles.itemIsNote[bankItems[fromSlot]])
				{
					//if (DataFiles.itemStackable[bankItems[fromSlot]+1])
					//{
						if (bankItemsN[fromSlot] > amount)
						{
							if (addItem(bankItems[fromSlot],amount))
							{
										bankItemsN[fromSlot]-=amount;
										resetBank();
										resetItems(5064);
							}
						}
						else
						{
							if (addItem(bankItems[fromSlot],bankItemsN[fromSlot]))
							{
										bankItems[fromSlot]=0;
										bankItemsN[fromSlot]=0;
										resetBank();
										resetItems(5064);
							}
						}
				}
				else
				{
					sendMessage("Item can't be drawn as note.");
					if (DataFiles.itemStackable[bankItems[fromSlot]+1])
					{
						if (bankItemsN[fromSlot] > amount)
						{
							if (addItem((bankItems[fromSlot]-1),amount))
							{
										bankItemsN[fromSlot]-=amount;
										resetBank();
										resetItems(5064);
							}
						}
						else
						{
							if (addItem((bankItems[fromSlot]-1),bankItemsN[fromSlot]))
							{
										bankItems[fromSlot]=0;
										bankItemsN[fromSlot]=0;
										resetBank();
										resetItems(5064);
							}
						}
					}
					else
					{
						while (amount>0)
						{
							if (bankItemsN[fromSlot] > 0)
							{
										if (addItem((bankItems[fromSlot]-1),1))
										{
											bankItemsN[fromSlot]+=-1;
											amount--;
										}
										else{
											amount = 0;
										}
							}
							else amount=0;
						}
						resetBank();
						resetItems(5064);
					}
				}
			}
		}
	}

	public int getXPForLevel(int level) {
    		int points = 0;
    		int output = 0;

    		for (int lvl = 1; lvl <= level; lvl++) {
			points += Math.floor((double)lvl + 300.0 * Math.pow(2.0, (double)lvl / 7.0));

			if (lvl >= level) {
	    			return output;
			}
			output = (int)Math.floor(points / 4);
    		}
    		return 0;
	}

	public int getLevelForXP(int exp) {
    		int points = 0;
    		int output = 0;

    		for (int lvl = 1; lvl <= 99; lvl++) {
			points += Math.floor((double)lvl + 300.0 * Math.pow(2.0, (double)lvl / 7.0));
			output = (int)Math.floor(points / 4);
			if (output >= exp) {
	    		return lvl;
			}
    		}
    		return 99;

	}

public boolean addSkillXP(int amount, int skill){
 int Attack = getLevelForXP(playerXP[0]);
      int Defence = getLevelForXP(playerXP[1]);
      int Strength = getLevelForXP(playerXP[2]);
      int Hitpoints = getLevelForXP(playerXP[3]);
      int Ranging = getLevelForXP(playerXP[4]);
      int Prayer = getLevelForXP(playerXP[5]);
      int Magic = getLevelForXP(playerXP[6]);
      int Cooking = getLevelForXP(playerXP[7]);
      int Woodcutting = getLevelForXP(playerXP[8]);
      int Fletching = getLevelForXP(playerXP[9]);
      int Fishing = getLevelForXP(playerXP[10]);
      int Firemaking = getLevelForXP(playerXP[11]);
      int Crafting = getLevelForXP(playerXP[12]);
      int Smithing = getLevelForXP(playerXP[13]);
      int Mining = getLevelForXP(playerXP[14]);
      int Herblore = getLevelForXP(playerXP[15]);
      int Agility = getLevelForXP(playerXP[16]);
      int Thieving = getLevelForXP(playerXP[17]);
      int Slayer = getLevelForXP(playerXP[18]);
      int Farming = getLevelForXP(playerXP[19]);
      int Runecrafting = getLevelForXP(playerXP[20]);
		if ((amount + playerXP[skill]) < 0 || playerXP[skill] > 2000000000) {
			sendMessage("Max XP value reached");
			return false;
		}

		int oldLevel = getLevelForXP(playerXP[skill]);
		playerXP[skill] += amount;
		if (oldLevel < getLevelForXP(playerXP[skill])) {
 if (Attack < getLevelForXP(playerXP[0])) {
            playerLevel[0] = getLevelForXP(playerXP[0]);
            levelup(0);
            updateRequired = true;
            appearanceUpdateRequired = true;
         }
         if (Defence < getLevelForXP(playerXP[1])) {
            playerLevel[1] = getLevelForXP(playerXP[1]);
            levelup(2);
            updateRequired = true;
            appearanceUpdateRequired = true;
         }
         if (Strength < getLevelForXP(playerXP[2])) {
            playerLevel[2] = getLevelForXP(playerXP[2]);
            levelup(1);
            updateRequired = true;
            appearanceUpdateRequired = true;
         }
         if (Hitpoints < getLevelForXP(playerXP[3])) {
            playerLevel[3] = getLevelForXP(playerXP[3]);
            levelup(3);
            updateRequired = true;
            appearanceUpdateRequired = true;
         }
         if (Ranging < getLevelForXP(playerXP[4])) {
            playerLevel[4] = getLevelForXP(playerXP[4]);
            levelup(4);
            updateRequired = true;
            appearanceUpdateRequired = true;
         }
         if (Prayer< getLevelForXP(playerXP[5])) {
            playerLevel[5] = getLevelForXP(playerXP[5]);
            levelup(5);
            updateRequired = true;
            appearanceUpdateRequired = true;
         }
         if (Magic < getLevelForXP(playerXP[6])) {
            playerLevel[6] = getLevelForXP(playerXP[6]);
            levelup(6);
            updateRequired = true;
            appearanceUpdateRequired = true;
         }
         if (Cooking < getLevelForXP(playerXP[7])) {
            playerLevel[7] = getLevelForXP(playerXP[7]);
            levelup(7);
            updateRequired = true;
            appearanceUpdateRequired = true;
         }
         if (Woodcutting < getLevelForXP(playerXP[8])) {
            playerLevel[8] = getLevelForXP(playerXP[8]);
            levelup(8);
            updateRequired = true;
            appearanceUpdateRequired = true;
         }
         if (Fletching < getLevelForXP(playerXP[9])) {
            playerLevel[9] = getLevelForXP(playerXP[9]);
            levelup(9);
            updateRequired = true;
            appearanceUpdateRequired = true;
         }
         if (Fishing < getLevelForXP(playerXP[10])) {
            playerLevel[10] = getLevelForXP(playerXP[10]);
            levelup(10);
            updateRequired = true;
            appearanceUpdateRequired = true;
         }
         if (Firemaking < getLevelForXP(playerXP[11])) {
            playerLevel[11] = getLevelForXP(playerXP[11]);
            levelup(11);
            updateRequired = true;
            appearanceUpdateRequired = true;
         }
         if (Crafting < getLevelForXP(playerXP[12])) {
            playerLevel[12] = getLevelForXP(playerXP[12]);
            levelup(12);
            updateRequired = true;
            appearanceUpdateRequired = true;
         }
         if (Smithing < getLevelForXP(playerXP[13])) {
            playerLevel[13] = getLevelForXP(playerXP[13]);
            levelup(13);
            updateRequired = true;
            appearanceUpdateRequired = true;
         }
         if (Mining < getLevelForXP(playerXP[14])) {
            playerLevel[14] = getLevelForXP(playerXP[14]);
            levelup(14);
            updateRequired = true;
            appearanceUpdateRequired = true;
         }
         if (Herblore < getLevelForXP(playerXP[15])) {
            playerLevel[15] = getLevelForXP(playerXP[15]);
            levelup(15);
            updateRequired = true;
            appearanceUpdateRequired = true;
         }
         if (Agility < getLevelForXP(playerXP[16])) {
            playerLevel[16] = getLevelForXP(playerXP[16]);
            levelup(16);
            updateRequired = true;
            appearanceUpdateRequired = true;
         }
         if (Thieving < getLevelForXP(playerXP[17])) {
            playerLevel[17] = getLevelForXP(playerXP[17]);
            levelup(17);
            updateRequired = true;
            appearanceUpdateRequired = true;
         }
         if (Slayer < getLevelForXP(playerXP[18])) {
            playerLevel[18] = getLevelForXP(playerXP[18]);
            levelup(18);
            updateRequired = true;
            appearanceUpdateRequired = true;
         }
         if (Farming < getLevelForXP(playerXP[19])) {
            playerLevel[19] = getLevelForXP(playerXP[19]);
            levelup(19);
            updateRequired = true;
            appearanceUpdateRequired = true;
         }
         if (Runecrafting < getLevelForXP(playerXP[20])) {
            playerLevel[20] = getLevelForXP(playerXP[20]);
            levelup(20);
            updateRequired = true;
            appearanceUpdateRequired = true;
         }
			playerLevel[skill] = getLevelForXP(playerXP[skill]);
			updateRequired = true;
			appearanceUpdateRequired = true;
		}
		setSkillLevel(skill, playerLevel[skill], playerXP[skill]);
                refreshSkills();
		return true;

	}

	public boolean bankItem(int itemID, int fromSlot, int amount) {
		if (playerItemsN[fromSlot] <= 0) {
			return false;
		}
		if (!DataFiles.itemIsNote[playerItems[fromSlot]-1]) {
			if (playerItems[fromSlot] <= 0) {
				return false;
			}
			if (DataFiles.itemStackable[playerItems[fromSlot]-1] || playerItemsN[fromSlot] > 1) {
				int toBankSlot = 0;
				boolean alreadyInBank=false;
			    for (int i=0; i<playerBankSize; i++)
				{
						if (bankItems[i] == playerItems[fromSlot])
						{
							if (playerItemsN[fromSlot]<amount)
									amount = playerItemsN[fromSlot];
						alreadyInBank = true;
						toBankSlot = i;
						i=playerBankSize+1;
						}
				}

				if (!alreadyInBank && freeBankSlots() > 0)
				{
						for (int i=0; i<playerBankSize; i++)
						{
							if (bankItems[i] <= 0)
							{
									toBankSlot = i;
									i=playerBankSize+1;
							}
						}
						bankItems[toBankSlot] = playerItems[fromSlot];
						if (playerItemsN[fromSlot]<amount){
							amount = playerItemsN[fromSlot];
						}
						if ((bankItemsN[toBankSlot] + amount) <= maxItemAmount && (bankItemsN[toBankSlot] + amount) > -1)
						{
							bankItemsN[toBankSlot] += amount;
						}
						else
						{
							sendMessage("Bank full!");
							return false;
						}
						deleteItem((playerItems[fromSlot]-1), fromSlot, amount);
						resetItems(5064);
						resetBank();
						return true;
				}
				else if (alreadyInBank)
				{
						if ((bankItemsN[toBankSlot] + amount) <= maxItemAmount && (bankItemsN[toBankSlot] + amount) > -1)
						{
							bankItemsN[toBankSlot] += amount;
						}
						else
						{
							sendMessage("Bank full!");
							return false;
						}
						deleteItem((playerItems[fromSlot]-1), fromSlot, amount);
						resetItems(5064);
						resetBank();
						return true;
				}
				else
				{
						sendMessage("Bank full!");
						return false;
				}
			}

			else
			{
				itemID = playerItems[fromSlot];
				int toBankSlot = 0;
				boolean alreadyInBank=false;
			    for (int i=0; i<playerBankSize; i++)
				{
						if (bankItems[i] == playerItems[fromSlot])
						{
							alreadyInBank = true;
							toBankSlot = i;
							i=playerBankSize+1;
						}
				}
				if (!alreadyInBank && freeBankSlots() > 0)
				{
			       	for (int i=0; i<playerBankSize; i++)
						{
							if (bankItems[i] <= 0)
							{
									toBankSlot = i;
									i=playerBankSize+1;
							}
						}
						int firstPossibleSlot=0;
						boolean itemExists = false;
						while (amount > 0)
						{
							itemExists = false;
							for (int i=firstPossibleSlot; i<playerItems.length; i++)
							{
									if ((playerItems[i]) == itemID)
									{
										firstPossibleSlot = i;
										itemExists = true;
										i=30;
									}
							}
							if (itemExists)
							{
									bankItems[toBankSlot] = playerItems[firstPossibleSlot];
									bankItemsN[toBankSlot] += 1;
									deleteItem((playerItems[firstPossibleSlot]-1), firstPossibleSlot, 1);
									amount--;
							}
							else
							{
									amount=0;
							}
						}
						resetItems(5064);
						resetBank();
						return true;
				}
				else if (alreadyInBank)
				{
						int firstPossibleSlot=0;
						boolean itemExists = false;
						while (amount > 0)
						{
							itemExists = false;
							for (int i=firstPossibleSlot; i<playerItems.length; i++)
							{
									if ((playerItems[i]) == itemID)
									{
										firstPossibleSlot = i;
										itemExists = true;
										i=30;
									}
							}
							if (itemExists)
							{
									bankItemsN[toBankSlot] += 1;
									deleteItem((playerItems[firstPossibleSlot]-1), firstPossibleSlot, 1);
									amount--;
							}
							else
							{
									amount=0;
							}
						}
						resetItems(5064);
						resetBank();
						return true;
				}
				else
				{
						sendMessage("Bank full!");
						return false;
				}
			}
		}
		else if (DataFiles.itemIsNote[playerItems[fromSlot]-1] && !DataFiles.itemIsNote[playerItems[fromSlot]-2])
		{
			if (playerItems[fromSlot] <= 0)
			{
				return false;
			}
			if (DataFiles.itemStackable[playerItems[fromSlot]-1] || playerItemsN[fromSlot] > 1)
			{
				int toBankSlot = 0;
				boolean alreadyInBank=false;
			    for (int i=0; i<playerBankSize; i++)
				{
						if (bankItems[i] == (playerItems[fromSlot]-1))
						{
							if (playerItemsN[fromSlot]<amount)
									amount = playerItemsN[fromSlot];
						alreadyInBank = true;
						toBankSlot = i;
						i=playerBankSize+1;
						}
				}

				if (!alreadyInBank && freeBankSlots() > 0)
				{
			       	for (int i=0; i<playerBankSize; i++)
						{
							if (bankItems[i] <= 0)
							{
									toBankSlot = i;
									i=playerBankSize+1;
							}
						}
						bankItems[toBankSlot] = (playerItems[fromSlot]-1);
						if (playerItemsN[fromSlot]<amount){
							amount = playerItemsN[fromSlot];
						}
						if ((bankItemsN[toBankSlot] + amount) <= maxItemAmount && (bankItemsN[toBankSlot] + amount) > -1)
						{
							bankItemsN[toBankSlot] += amount;
						}
						else
						{
							return false;
						}
						deleteItem((playerItems[fromSlot]-1), fromSlot, amount);
						resetItems(5064);
						resetBank();
						return true;
				}
				else if (alreadyInBank)
				{
						if ((bankItemsN[toBankSlot] + amount) <= maxItemAmount && (bankItemsN[toBankSlot] + amount) > -1)
						{
							bankItemsN[toBankSlot] += amount;
						}
						else
						{
							return false;
						}
						deleteItem((playerItems[fromSlot]-1), fromSlot, amount);
						resetItems(5064);
						resetBank();
						return true;
				}
				else
				{
						sendMessage("Bank full!");
						return false;
				}
			}

			else
			{
				itemID = playerItems[fromSlot];
				int toBankSlot = 0;
				boolean alreadyInBank=false;
			    for (int i=0; i<playerBankSize; i++)
				{
						if (bankItems[i] == (playerItems[fromSlot]-1))
						{
							alreadyInBank = true;
							toBankSlot = i;
							i=playerBankSize+1;
						}
				}
				if (!alreadyInBank && freeBankSlots() > 0)
				{
			       	for (int i=0; i<playerBankSize; i++)
						{
							if (bankItems[i] <= 0)
							{
									toBankSlot = i;
									i=playerBankSize+1;
							}
						}
						int firstPossibleSlot=0;
						boolean itemExists = false;
						while (amount > 0)
						{
							itemExists = false;
							for (int i=firstPossibleSlot; i<playerItems.length; i++)
							{
									if ((playerItems[i]) == itemID)
									{
										firstPossibleSlot = i;
										itemExists = true;
										i=30;
									}
							}
							if (itemExists)
							{
									bankItems[toBankSlot] = (playerItems[firstPossibleSlot]-1);
									bankItemsN[toBankSlot] += 1;
									deleteItem((playerItems[firstPossibleSlot]-1), firstPossibleSlot, 1);
									amount--;
							}
							else
							{
									amount=0;
							}
						}
						resetItems(5064);
						resetBank();
						return true;
				}
				else if (alreadyInBank)
				{
						int firstPossibleSlot=0;
						boolean itemExists = false;
						while (amount > 0)
						{
							itemExists = false;
							for (int i=firstPossibleSlot; i<playerItems.length; i++)
							{
									if ((playerItems[i]) == itemID)
									{
										firstPossibleSlot = i;
										itemExists = true;
										i=30;
									}
							}
							if (itemExists)
							{
									bankItemsN[toBankSlot] += 1;
									deleteItem((playerItems[firstPossibleSlot]-1), firstPossibleSlot, 1);
									amount--;
							}
							else
							{
									amount=0;
							}
						}
						resetItems(5064);
						resetBank();
						return true;
				}
				else
				{
						sendMessage("Bank full!");
						return false;
				}
			}
		} else {
			sendMessage("Item not supported "+(playerItems[fromSlot]-1));
			return false;
		}
	}

	public void createItem(int newItemID) {
		int Maxi = GameEngine.itemHandler.DropItemCount;
		for (int i = 0; i <= Maxi; i++) {
			if (GameEngine.itemHandler.DroppedItemsID[i] < 1) {
				GameEngine.itemHandler.DroppedItemsID[i] = newItemID;
				GameEngine.itemHandler.DroppedItemsX[i] = (absX);
				GameEngine.itemHandler.DroppedItemsY[i] = (absY);
				GameEngine.itemHandler.DroppedItemsN[i] = 1;
				GameEngine.itemHandler.DroppedItemsH[i] = heightLevel;
				GameEngine.itemHandler.DroppedItemsDDelay[i] = (GameEngine.itemHandler.MaxDropShowDelay + 1); //this way the item can NEVER be showed to another client
				GameEngine.itemHandler.DroppedItemsDropper[i] = playerId;
				if (i == Maxi) {
					GameEngine.itemHandler.DropItemCount++;
					if (GameEngine.itemHandler.DropItemCount >= (GameEngine.itemHandler.MaxDropItems + 1)) {
						GameEngine.itemHandler.DropItemCount = 0;
						Misc.println("! Notify item resterting !");
					}
				}
				break;
			}
		}
	}

	public void removeAllItems() {
		for (int i = 0; i < playerItems.length; i++) {
			playerItems[i] = 0;
		}
		for (int i = 0; i < playerItemsN.length; i++) {
			playerItemsN[i] = 0;
		}
		resetItems(3214);
	}
	public void resetItems(int WriteFrame) {
		outStream.createFrameVarSizeWord(53);
		outStream.writeWord(WriteFrame);
		outStream.writeWord(playerItems.length);
		for (int i = 0; i < playerItems.length; i++) {
			if (playerItemsN[i] > 254) {
				outStream.writeByte(255); 						// item's stack count. if over 254, write byte 255
				outStream.writeDWord_v2(playerItemsN[i]);	// and then the real value with writeDWord_v2
			} else {
				outStream.writeByte(playerItemsN[i]);
			}
			if (playerItems[i] > 20000 || playerItems[i] < 0) {
				playerItems[i] = 20000;
			}
			outStream.writeWordBigEndianA(playerItems[i]); //item id
		}
		outStream.endFrameVarSizeWord();
	}

	public void SendWeapon(int Weapon, String WeaponName) {
		String WeaponName2 = WeaponName.replaceAll("Bronze", "");
		WeaponName2 = WeaponName2.replaceAll("Iron", "");
		WeaponName2 = WeaponName2.replaceAll("Steel", "");
		WeaponName2 = WeaponName2.replaceAll("Black", "");
		WeaponName2 = WeaponName2.replaceAll("Mithril", "");
		WeaponName2 = WeaponName2.replaceAll("Adamant", "");
		WeaponName2 = WeaponName2.replaceAll("Rune", "");
		WeaponName2 = WeaponName2.replaceAll("Granite", "");
		WeaponName2 = WeaponName2.replaceAll("Dragon", "");
		WeaponName2 = WeaponName2.replaceAll("Crystal", "");
		WeaponName2 = WeaponName2.trim();
                if (WeaponName.equals("Unarmed") || playerEquipment[playerWeapon] == -1) {
			setSidebarInterface(0, 5855); //punch, kick, block
			sendFrame126(WeaponName, 5857);
		} else if (WeaponName.endsWith("whip")) {
			setSidebarInterface(0, 12290); //flick, lash, deflect
			sendFrame246(12291, 200, Weapon);
			sendFrame126(WeaponName, 12293);
		} else if (WeaponName.endsWith("bow")) {
			setSidebarInterface(0, 1764); //accurate, rapid, longrange
			sendFrame246(1765, 200, Weapon);
			sendFrame126(WeaponName, 1767);
		} else if (WeaponName.endsWith("Bow")) {
			setSidebarInterface(0, 1764); //accurate, rapid, longrange
			sendFrame246(1765, 200, Weapon);
			sendFrame126(WeaponName, 1767);
		} else if (WeaponName.startsWith("Crystal bow")) {
			setSidebarInterface(0, 1764); //accurate, rapid, longrange
			sendFrame246(1765, 200, Weapon);
			sendFrame126(WeaponName, 1767);
		} else if (WeaponName.startsWith("seercull")) {
			setSidebarInterface(0, 1764); //accurate, rapid, longrange
			sendFrame246(1765, 200, Weapon);
			sendFrame126(WeaponName, 1767);
		} else if (WeaponName.startsWith("Staff") || WeaponName.endsWith("staff")) {
			setSidebarInterface(0, 328); //spike, impale, smash, block
			sendFrame246(329, 200, Weapon);
			sendFrame126(WeaponName, 331);
		} else if (WeaponName2.startsWith("dart")) {
			setSidebarInterface(0, 4446); //accurate, rapid, longrange
			sendFrame246(4447, 200, Weapon);
			sendFrame126(WeaponName, 4449);
		} else if (WeaponName2.startsWith("dagger")) {
			setSidebarInterface(0, 2276); //stab, lunge, slash, block
			sendFrame246(2277, 200, Weapon);
			sendFrame126(WeaponName, 2279);
		} else if (WeaponName2.startsWith("pickaxe")) {
			setSidebarInterface(0, 5570); //spike, impale, smash, block
			sendFrame246(5571, 200, Weapon);
			sendFrame126(WeaponName, 5573);
		} else if (WeaponName2.startsWith("axe") || WeaponName2.startsWith("battleaxe")) {
			setSidebarInterface(0, 1698); //chop, hack, smash, block
			sendFrame246(1699, 200, Weapon);
			sendFrame126(WeaponName, 1701);
		} else if (WeaponName2.startsWith("halberd")) {
			setSidebarInterface(0, 8460); //jab, swipe, fend
			sendFrame246(8461, 200, Weapon);
			sendFrame126(WeaponName, 8463);
		} else if (WeaponName2.startsWith("spear")) {
			setSidebarInterface(0, 4679); //lunge, swipe, pound, block
			sendFrame246(4680, 200, Weapon);
			sendFrame126(" "+ WeaponName, 4682);
		} else if (WeaponName2.startsWith("claws")) {
			setSidebarInterface(0, 2423); //chop, slash, lunge, block
			sendFrame246(2424, 200, Weapon);
			sendFrame126(WeaponName, 2426);

//			setSidebarInterface(0, 7762); //chop, slash, lunge, block
//			sendFrame246(7763, 200, Weapon);
//			sendFrame126(WeaponName, 7764);
		} else {
			setSidebarInterface(0, 2423); //chop, slash, lunge, block
			sendFrame246(2424, 200, Weapon);
			sendFrame126(WeaponName, 2426);
		}
	}

	public void resetTItems(int WriteFrame) {
		outStream.createFrameVarSizeWord(53);
		outStream.writeWord(WriteFrame);
		outStream.writeWord(playerTItems.length);
		for (int i = 0; i < playerTItems.length; i++) {
			if (playerTItemsN[i] > 254) {
				outStream.writeByte(255); 						// item's stack count. if over 254, write byte 255
				outStream.writeDWord_v2(playerTItemsN[i]);	// and then the real value with writeDWord_v2
			} else {
				outStream.writeByte(playerTItemsN[i]);
			}
			if (playerTItems[i] > 20000 || playerTItems[i] < 0) {
				playerTItems[i] = 20000;
			}
			outStream.writeWordBigEndianA(playerTItems[i]); //item id
		}
		outStream.endFrameVarSizeWord();
	}

	public void resetOTItems(int WriteFrame) {
		outStream.createFrameVarSizeWord(53);
		outStream.writeWord(WriteFrame);
		outStream.writeWord(playerOTItems.length);
		for (int i = 0; i < playerOTItems.length; i++) {
			if (playerOTItemsN[i] > 254) {
				outStream.writeByte(255); 						// item's stack count. if over 254, write byte 255
				outStream.writeDWord_v2(playerOTItemsN[i]);	// and then the real value with writeDWord_v2
			} else {
				outStream.writeByte(playerOTItemsN[i]);
			}
			if (playerOTItems[i] > 20000 || playerOTItems[i] < 0) {
				playerOTItems[i] = 20000;
			}
			outStream.writeWordBigEndianA(playerOTItems[i]); //item id
		}
		outStream.endFrameVarSizeWord();
	}

	public void resetShop(int ShopID) {
		int TotalItems = 0;
		for (int i = 0; i < GameEngine.shopHandler.MaxShopItems; i++) {
			if (GameEngine.shopHandler.ShopItems[ShopID][i] > 0) {
				TotalItems++;
			}
		}
		if (TotalItems > GameEngine.shopHandler.MaxShopItems) {
			TotalItems = GameEngine.shopHandler.MaxShopItems;
		}
		outStream.createFrameVarSizeWord(53);
		outStream.writeWord(3900);
		outStream.writeWord(TotalItems);
		int TotalCount = 0;
		for (int i = 0; i < GameEngine.shopHandler.ShopItems.length; i++) {
			if (GameEngine.shopHandler.ShopItems[ShopID][i] > 0 || i <= GameEngine.shopHandler.ShopItemsStandard[ShopID]) {
				if (GameEngine.shopHandler.ShopItemsN[ShopID][i] > 254) {
					outStream.writeByte(255); 						// item's stack count. if over 254, write byte 255
					outStream.writeDWord_v2(GameEngine.shopHandler.ShopItemsN[ShopID][i]);	// and then the real value with writeDWord_v2
					//outStream.writeDWord_v2(0);
				} else {
					outStream.writeByte(GameEngine.shopHandler.ShopItemsN[ShopID][i]);
				}
				if (GameEngine.shopHandler.ShopItems[ShopID][i] > 20000 || GameEngine.shopHandler.ShopItems[ShopID][i] < 0) {
					GameEngine.shopHandler.ShopItems[ShopID][i] = 20000;
				}
				outStream.writeWordBigEndianA(GameEngine.shopHandler.ShopItems[ShopID][i]); //item id
				TotalCount++;
			}
			if (TotalCount > TotalItems) {
				break;
			}
		}
		outStream.endFrameVarSizeWord();
	}

	public void resetBank() {
		outStream.createFrameVarSizeWord(53);
		outStream.writeWord(5382); // bank
		outStream.writeWord(playerBankSize); // number of items
         	for (int i = 0; i < playerBankSize; i++) {
			if (bankItemsN[i] > 254) {
				outStream.writeByte(255);
				outStream.writeDWord_v2(bankItemsN[i]);
			} else {
				outStream.writeByte(bankItemsN[i]); //amount
			}
			if (bankItemsN[i] < 1)
				bankItems[i] = 0;
			if (bankItems[i] > 20000 || bankItems[i] < 0) {
				bankItems[i] = 20000;
			}
			outStream.writeWordBigEndianA(bankItems[i]); // itemID
		}
		outStream.endFrameVarSizeWord();
	}

	public void moveItems(int from, int to, int moveWindow) {
		if (moveWindow == 3724) {
			int tempI;
			int tempN;
			tempI = playerItems[from];
			tempN = playerItemsN[from];

			playerItems[from] = playerItems[to];
			playerItemsN[from] = playerItemsN[to];
			playerItems[to] = tempI;
			playerItemsN[to] = tempN;
		}

		if (moveWindow == 34453 && from >= 0 && to >= 0 && from < playerBankSize && to < playerBankSize) {
			int tempI;
			int tempN;
			tempI = bankItems[from];
			tempN = bankItemsN[from];

			bankItems[from] = bankItems[to];
			bankItemsN[from] = bankItemsN[to];
			bankItems[to] = tempI;
			bankItemsN[to] = tempN;
		}

		if (moveWindow == 34453) {
			resetBank();
		} else if (moveWindow == 18579) {
			resetItems(5064);
		} else if (moveWindow == 3724) {
			resetItems(3214);
		}
	}
	public int itemAmount(int itemID) {
		int tempAmount = 0;
        	for (int i = 0; i < playerItems.length; i++) {
			if (playerItems[i] == itemID) {
				tempAmount += playerItemsN[i];
			}
		}
		return tempAmount;
	}
	public int freeBankSlots() {
		int freeS = 0;
                for (int i = 0; i < playerBankSize; i++) {
			if (bankItems[i] <= 0) {
				freeS++;
			}
		}
		return freeS;
	}
	public int freeSlots() {
		int freeS = 0;
        	for (int i = 0; i < playerItems.length; i++) {
			if (playerItems[i] <= 0) {
				freeS++;
			}
		}
		return freeS;
	}
	public int freeTradeSlots() {
		int freeS = 0;
                for (int i = 0; i < playerTItems.length; i++) {
			if (playerTItems[i] <= 0) {
				freeS++;
			}
		}
		return freeS;
	}

	public void openUpBank() {
		sendFrame248(5292, 5063);
		resetItems(5064);
		IsBanking = true;
	}

	public void openUpShop(int ShopID) {
		sendFrame126(GameEngine.shopHandler.ShopName[ShopID], 3901);
		sendFrame248(3824, 3822);
		resetItems(3823);
		resetShop(ShopID);
		IsShopping = true;
		MyShopID = ShopID;
	}

	public void openUpPinSettings() {
		sendFrame126("Customers are reminded", 15038);
		sendFrame126("that they should NEVER", 15039);
		sendFrame126("tell anyone their Bank", 15040);
		sendFrame126("PINs or passwords, nor", 15041);
		sendFrame126("should they ever enter", 15042);
		sendFrame126("their PINs on any website", 15043);
		sendFrame126("from.", 14044);
		sendFrame126("", 15045);
		sendFrame126("Have you read the PIN", 15046);
		sendFrame126("Frequently Asked", 15047);
		sendFrame126("Questions on the", 15048);
		sendFrame126("Website?", 15049);
		sendFrame126("No PIN set", 15105);
		sendFrame126("3 days", 15107);
		sendFrame171(0, 15074);
		sendFrame171(1, 15077);
		sendFrame171(1, 15081);
		sendFrame171(1, 15108);
		showInterface(14924);
	}
	public void addItem3(int id, int amount){
		addItem(id, amount);

		if (amount > 1 && !DataFiles.itemStackable[id] && freeSlots() > 0) {
			addItem3(id, amount-1);
		}
	}
	public void deleteItem3(int id, int amount) {
		deleteItem(id, GetItemSlot(id), 1);

		if (amount > 1) {
			deleteItem3(id, amount-1);
		}
	}

	public boolean addItem(int item, int amount) {
                if(item == -1)
                return false;
		if (!DataFiles.itemStackable[item] || amount < 1) {
			amount = 1;
		}

		if ((freeSlots() >= amount && !DataFiles.itemStackable[item]) || freeSlots() > 0) {
			for (int i = 0; i < playerItems.length; i++) {
				if (playerItems[i] == (item+1) && DataFiles.itemStackable[item] && playerItems[i] > 0) {
					playerItems[i] = (item + 1);
					if ((playerItemsN[i] + amount) < maxItemAmount && (playerItemsN[i] + amount) > -1) {
						playerItemsN[i] += amount;
					} else {
						playerItemsN[i] = maxItemAmount;
					}
					outStream.createFrameVarSizeWord(34);
					outStream.writeWord(3214);
					outStream.writeByte(i);
					outStream.writeWord(playerItems[i]);
					if (playerItemsN[i] > 254) {
						outStream.writeByte(255);
						outStream.writeDWord(playerItemsN[i]);
					} else {
						outStream.writeByte(playerItemsN[i]); //amount
					}
					outStream.endFrameVarSizeWord();
					i = 30;
					return true;
				}
			}
	                for (int i = 0; i < playerItems.length; i++) {
				if (playerItems[i] <= 0) {
					playerItems[i] = item+1;
					if (amount < maxItemAmount && amount > -1) {
						playerItemsN[i] = amount;
					} else {
						playerItemsN[i] = maxItemAmount;
					}
					outStream.createFrameVarSizeWord(34);
					outStream.writeWord(3214);
					outStream.writeByte(i);
					outStream.writeWord(playerItems[i]);
					if (playerItemsN[i] > 254) {
						outStream.writeByte(255);
						outStream.writeDWord(playerItemsN[i]);
					} else {
						outStream.writeByte(playerItemsN[i]); //amount
					}
					outStream.endFrameVarSizeWord();
					i = 30;
					return true;
				}
			}
			return false;
		} else {
			PickUpID = 0;
			PickUpAmount = 0;
			PickUpDelete = 0;
			WannePickUp = false;
			sendMessage("Not enough space in your inventory.");
			return false;
		}
	}

	public void dropItem(int droppedItem, int slot) {
		if (playerItemsN[slot] != 0 && droppedItem != -1 && playerItems[slot] == droppedItem+1) {
			ItemHandler.addItem(playerItems[slot]-1, absX, absY, playerItemsN[slot], playerId, false);
			deleteItem(droppedItem, slot, playerItemsN[slot]);
			updateRequired = true;
		}
	}

	public void createGroundItem(int itemID, int itemX, int itemY, int itemAmount) {// Phate: Omg fucking sexy! creates item at absolute X and Y
		outStream.createFrame(85);								// Phate: Spawn ground item
		outStream.writeByteC((itemY - 8 * mapRegionY));
		outStream.writeByteC((itemX - 8 * mapRegionX));
		outStream.createFrame(44);
		outStream.writeWordBigEndianA(itemID);
		outStream.writeWord(itemAmount);
		outStream.writeByte(0);									// x(4 MSB) y(LSB) coords
	}


	public void removeGroundItem(int itemX, int itemY, int itemID) {// Phate: Omg fucking sexy! remoevs an item from absolute X and Y
		outStream.createFrame(85);		// Phate: Item Position Frame
		outStream.writeByteC((itemY - 8 * mapRegionY));
		outStream.writeByteC((itemX - 8 * mapRegionX));
		outStream.createFrame(156);		// Phate: Item Action: Delete
		outStream.writeByteS(0);		// x(4 MSB) y(LSB) coords
		outStream.writeWord(itemID);	// Phate: Item ID
	}
	public boolean deleteItem(int id, int slot, int amount) {
		if (slot > -1 && slot < playerItems.length) {
			if ((playerItems[slot] - 1) == id) {
				if (playerItemsN[slot] > amount) {
					playerItemsN[slot] -= amount;
				} else {
					playerItemsN[slot] = 0;
					playerItems[slot] = 0;
				}
				resetItems(3214);
                                return true;
			}
		} else {
			return false;
		}
                return false;
	}

	public void setEquipment(int wearID, int amount, int targetSlot) {
		int Stat = playerDefence;
		if (targetSlot == playerWeapon) {
			Stat = playerAttack;
		}
		setDuelEquipment(wearID, amount, targetSlot);
		outStream.createFrameVarSizeWord(34);
		outStream.writeWord(1688);
		outStream.writeByte(targetSlot);
		outStream.writeWord((wearID + 1));
		if (amount > 254) {
			outStream.writeByte(255);
			outStream.writeDWord(amount);
		} else {
			outStream.writeByte(amount); //amount
		}
		outStream.endFrameVarSizeWord();


		if (targetSlot == playerWeapon && wearID >= 0) {
			SendWeapon(wearID, GetItemName(wearID));
			playerSE = GetStandAnim(wearID);
			playerSEW = GetWalkAnim(wearID);
			playerSER = GetRunAnim(wearID);
			playerST = 0x337;
			playerT180 = 0x334;
			playerT90CW = 0x335;
			playerT90CCW = 0x336;

			if (playerEquipment[playerWeapon] == 4565) { //basket of eggs
				playerSE = 1837;
				playerSEW = 1836;
				playerSER = 1836;
				playerST = 1836;
				playerT180 = 1836;
				playerT90CW = 1836;
				playerT90CCW = 1836;
			}

                        if (playerEquipment[playerCape] == 16041) { //wings
				playerSE = 1501;
				playerSEW = 1501;
				playerSER = 1501;
				playerST = 1501;
				playerT180 = 1501;
				playerT90CW = 1501;
				playerT90CCW = 1501;
			}
                        if (playerEquipment[playerFeet] == 6666) { //fishy
				playerSE = 3442;
				playerSEW = 3441;
				playerSER = 3441;
				playerST = 3441;
				playerT180 = 3441;
				playerT90CW = 3441;
				playerT90CCW = 3441;
			}
		if(wearID == 7671 || wearID == 7673) // boxing gloves
		{
				playerST = 3680;
				playerT180 = 3680;
				playerT90CW = 3680;
				playerT90CCW = 3680;
		}
			if (wearID == 4747) { //Torag Hammers
				playerSEA = 0x814;
			}
                        if (wearID == 4151) { //Whip
				playerSER = 1661;
				playerSEW = 1660;
			}
                        if (wearID == 4718
			 || wearID == 19005) {
				playerST = 2064;
				playerT180 = 2064;
				playerT90CW = 2064;
				playerT90CCW = 2064;
			}
                        if (wearID == 11694
			 || wearID == 11696
			 || wearID == 11698
			 || wearID == 19022
			 || wearID == 19021
			 || wearID == 19047
			 || wearID == 11700
			 || wearID == 11730
			 || wearID == 18010
			 || wearID == 18012
			 || wearID == 18014
			 || wearID == 18016
			 || wearID == 19004
			 || wearID == 1307
			 || wearID == 1309
			 || wearID == 1311
			 || wearID == 1313
			 || wearID == 1315
			 || wearID == 1317
			 || wearID == 1319
			 || wearID == 6609
			 || wearID == 7158) {
				playerST = 1130;
				playerT180 = 1130;
				playerT90CW = 1130;
				playerT90CCW = 1130;
			}
                        if (wearID == 10887) {
				playerST = 5867;
				playerT180 = 5867;
				playerT90CW = 5867;
				playerT90CCW = 5867;
			}
			if(wearID == -1) {
			playerST = 0x337;
			playerT180 = 0x334;
			playerT90CW = 0x335;
			playerT90CCW = 0x336;
				playerSE = 0x328;
				playerSEW = 0x333;
				playerSER = 0x338;
			}
			pEmote = playerSE;
		}
		SendWeapon((playerEquipment[playerWeapon]), GetItemName(playerEquipment[playerWeapon]));
		updateRequired = true;
		appearanceUpdateRequired = true;
	}

	public boolean wear(int wearID, int slot) {
		int targetSlot = 0;

		if ((playerItems[slot] - 1) == wearID) {
			if (wearID == 6070) {
				npcId = 1645;
				isNpc = true;
				updateRequired = true;
				appearanceUpdateRequired = true;
			}
			if (wearID == 6666) {
				npcId = 3713;
				isNpc = true;
				updateRequired = true;
				appearanceUpdateRequired = true;
			}
			if (wearID == 7927) {
				int randomEgg = Misc.random(5);
				if(randomEgg == 0) {
					npcId = 3689;
				} else if(randomEgg == 1) {
					npcId = 3690;
				} else if(randomEgg == 2) {
					npcId = 3691;
				} else if(randomEgg == 3) {
					npcId = 3692;
				} else if(randomEgg == 4) {
					npcId = 3693;
				} else if(randomEgg == 5) {
					npcId = 3694;
				}
				isNpc = true;
				updateRequired = true;
				appearanceUpdateRequired = true;
			}
                	ResetAttack();
                	ResetAttackNPC();
                        resetItems(3214); // THIS MIGHT STOP CLIENT HACKS HMM?
			targetSlot = itemType(wearID);
			int CLAttack = GetCLAttack(wearID);
                        int CLPrayer = GetCLPrayer(wearID);
                        int CLFletching = GetCLFletching(wearID);
                        int CLWoodcutting = GetCLWoodcutting(wearID);
                        int CLCooking = GetCLCooking(wearID);
                        int CLFishing = GetCLFishing(wearID);
                        int CLThieving = GetCLThieving(wearID);
                        int CLHitpoints = GetCLHitpoints(wearID);
                        int CLAgility = GetCLAgility(wearID);
                        int CLSlayer = GetCLSlayer(wearID);
			int CLDefence = GetCLDefence(wearID);
			int CLStrength = GetCLStrength(wearID);
			int CLMagic = GetCLMagic(wearID);
			int CLRanged = GetCLRanged(wearID);
			int CLMining = GetCLMining(wearID);
			boolean GoFalse = false;

			if (targetSlot == playerWeapon && freeSlots() < 1 && (DataFiles.itemTwoHanded[wearID] == true) && playerEquipment[playerShield] > 0) {
				sendMessage("Not enough space in your inventory.");
				GoFalse = true;
			}
			if (getLevelForXP(playerXP[playerAttack]) - CLAttack < 0) {
				sendMessage("You need " + CLAttack + " " + statName[playerAttack] + " to equip this item.");
				GoFalse = true;
			}
			if (getLevelForXP(playerXP[playerPrayer]) - CLPrayer < 0) {
				sendMessage("You need " + CLPrayer + " " + statName[playerPrayer] + " to equip this item.");
				GoFalse = true;
			}
			if (getLevelForXP(playerXP[playerFletching]) - CLFletching < 0) {
				sendMessage("You need " + CLFletching + " " + statName[playerFletching] + " to equip this item.");
				GoFalse = true;
			}
			if (playerLevel[playerWoodcutting] - CLWoodcutting < 0) {
				sendMessage("You need " + CLWoodcutting + " " + statName[playerWoodcutting] + " to equip this item.");
				GoFalse = true;
			}
			if (playerLevel[playerCooking] - CLCooking < 0) {
				sendMessage("You need " + CLCooking + " " + statName[playerCooking] + " to equip this item.");
				GoFalse = true;
			}
			if (playerLevel[playerFishing] - CLFishing < 0) {
				sendMessage("You need " + CLFishing + " " + statName[playerFishing] + " to equip this item.");
				GoFalse = true;
			}
			if (playerLevel[playerThieving] - CLThieving < 0) {
				sendMessage("You need " + CLThieving + " " + statName[playerThieving] + " to equip this item.");
				GoFalse = true;
			}
			if (getLevelForXP(playerXP[playerHitpoints]) - CLHitpoints < 0) {
				sendMessage("You need " + CLHitpoints + " " + statName[playerHitpoints] + " to equip this item.");
				GoFalse = true;
			}
			if (playerLevel[playerAgility] - CLAgility < 0) {
				sendMessage("You need " + CLAgility + " " + statName[playerAgility] + " to equip this item.");
				GoFalse = true;
			}
			if (playerLevel[playerSlayer] - CLSlayer < 0) {
				sendMessage("You need " + CLSlayer + " " + statName[playerSlayer] + " to equip this item.");
				GoFalse = true;
			}
			if (getLevelForXP(playerXP[playerDefence]) - CLDefence < 0) {
				sendMessage("You need " + CLDefence + " " + statName[playerDefence] + " to equip this item.");
				GoFalse = true;
			}
			if (getLevelForXP(playerXP[playerStrength]) - CLStrength < 0) {
				sendMessage("You need " + CLStrength + " " + statName[playerStrength] + " to equip this item.");
				GoFalse = true;
			}
			if (getLevelForXP(playerXP[playerMagic]) - CLMagic < 0) {
				sendMessage("You need " + CLMagic + " " + statName[playerMagic] + " to equip this item.");
				GoFalse = true;
			}
			if (getLevelForXP(playerXP[playerRanged]) - CLRanged < 0) {
				sendMessage("You need " + CLRanged + " " + statName[playerRanged] + " to equip this item.");
				GoFalse = true;
			}
			if (GoFalse == true) {
				return false;
			}
			int wearAmount = playerItemsN[slot];
			if (wearAmount < 1) {
				return false;
			}
                        wearing = true;

			if (duelRule[5] && targetSlot != playerWeapon && targetSlot != playerArrows) {
				sendMessage("Armour has been disabled this duel.");
				return false;
			}
			if (duelRule[4] && targetSlot == playerWeapon) {
				sendMessage("Weapons has been disabled this duel.");
				return false;
			}
			if (slot >= 0 && wearID >= 0) {
				deleteItem(wearID, slot, wearAmount);
				if (playerEquipment[targetSlot] != wearID && playerEquipment[targetSlot] >= 0){
					addItem(playerEquipment[targetSlot],playerEquipmentN[targetSlot]);
                                                               resetItems(3214);
				} else if (DataFiles.itemStackable[wearID] && playerEquipment[targetSlot] == wearID) {
					wearAmount = playerEquipmentN[targetSlot] + wearAmount;
				} else if (playerEquipment[targetSlot] >= 0) {
					addItem(playerEquipment[targetSlot],playerEquipmentN[targetSlot]);
                        		resetItems(3214); // THIS MIGHT STOP CLIENT HACKS HMM?
				}
			}
			outStream.createFrameVarSizeWord(34);
			outStream.writeWord(1688);
			outStream.writeByte(targetSlot);
			outStream.writeWord(wearID+1);

			if (wearAmount > 254) {
				outStream.writeByte(255);
				outStream.writeDWord(wearAmount);
			} else {
				outStream.writeByte(wearAmount); //amount
			}
			outStream.endFrameVarSizeWord();
			playerEquipment[targetSlot] = wearID;
			playerEquipmentN[targetSlot] = wearAmount;

			if ((targetSlot == playerWeapon)
				&& (playerShield != -1)
				&& item2handed(playerEquipment[playerWeapon])
				&& (freeSlots() > 0)) {
					remove(playerEquipment[playerShield], playerShield);
			} else if (freeSlots() < 1) {
				sendMessage("Not enough space in your inventory.");
				GoFalse = true;
            }

			if ((targetSlot == playerShield) && (playerWeapon != -1) && item2handed(playerEquipment[playerWeapon]) && (freeSlots() > 0)) {
					remove(playerEquipment[playerWeapon], playerWeapon);
			} else if (freeSlots() < 1) {
				sendMessage("Not enough space in your inventory.");
				GoFalse = true;
            }

			if (targetSlot == playerWeapon) {
			SendWeapon(wearID, GetItemName(wearID));
			playerSE = GetStandAnim(wearID);
			playerSEW = GetWalkAnim(wearID);
			playerSER = GetRunAnim(wearID);
			playerSEA = 0x326;
			playerST = 0x337;
			playerT180 = 0x334;
			playerT90CW = 0x335;
			playerT90CCW = 0x336;

			if (playerEquipment[playerWeapon] == 4565) { //basket of eggs
				playerSE = 1837;
				playerSEW = 1836;
				playerSER = 1836;
				playerST = 1836;
				playerT180 = 1836;
				playerT90CW = 1836;
				playerT90CCW = 1836;
			}


                        if (playerEquipment[playerCape] == 16041) { //wings
				playerSE = 1501;
				playerSEW = 1501;
				playerSER = 1501;
				playerST = 1501;
				playerT180 = 1501;
				playerT90CW = 1501;
				playerT90CCW = 1501;
			}
                        if (playerEquipment[playerFeet] == 6666) { //fishy
				playerSE = 3872;
				playerSEW = 3871;
				playerSER = 3871;
				playerST = 3871;
				playerT180 = 3871;
				playerT90CW = 3871;
				playerT90CCW = 3871;
			}
		if(wearID == 7671 || wearID == 7673) // boxing gloves
		{
				playerST = 3680;
				playerT180 = 3680;
				playerT90CW = 3680;
				playerT90CCW = 3680;
		}
			if (wearID == 4747) { //Torag Hammers
				playerSEA = 0x814;
			}
                        if (wearID == 4151) { //Whip
				playerSER = 1661;
				playerSEW = 1660;
			}
                        if (wearID == 8447) { //cat toy
 				playerSER = 1661;
				playerSEW = 1660;
			}

                        if (wearID == 4718 || wearID == 19005) {
				playerST = 2064;
				playerT180 = 2064;
				playerT90CW = 2064;
				playerT90CCW = 2064;
			}
                        if (wearID == 11694
			 || wearID == 11696
			 || wearID == 11698
			 || wearID == 11700
			 || wearID == 11730
			 || wearID == 19022
			 || wearID == 19021
			 || wearID == 19047
			 || wearID == 18010
			 || wearID == 18012
			 || wearID == 18014
			 || wearID == 18016
			 || wearID == 1307
			 || wearID == 1309
			 || wearID == 1311
			 || wearID == 1313
			 || wearID == 1315
			 || wearID == 1317
			 || wearID == 1319
			 || wearID == 6609
			 || wearID == 7158
			 || wearID == 19004) {
				playerST = 1130;
				playerT180 = 1130;
				playerT90CW = 1130;
				playerT90CCW = 1130;
			}

                        if (wearID == 10887) {
				playerST = 5867;
				playerT180 = 5867;
				playerT90CW = 5867;
				playerT90CCW = 5867;
			}
			pEmote = playerSE;
			}
			ResetBonus();
			GetBonus();
			WriteBonus();
                        SendWeapon((playerEquipment[playerWeapon]), GetItemName(playerEquipment[playerWeapon]));
			updateRequired = true;
			appearanceUpdateRequired = true;
                        wearing = false;

			if (targetSlot == playerWeapon) {
				if (isSpecWeapon(playerEquipment[3])) {
					l33thax(12323);
					l33thax(7574);
					l33thax(7599);
					l33thax(7549);
					l33thax(8493);
					l33thax(7499);
				} else {
					Frame171(12323, 1);
					Frame171(7574, 1);
					Frame171(7599, 1);
					Frame171(7549, 1);
					Frame171(8493, 1);
					Frame171(7499, 1);
				}
				usingSpecial = false;
				specs();
				usingAutoCast = false;
				castAuto = false;
				setMagicPlayer(false);
				updateRequired = true;
				updateRequired = true;
			}
			return true;
		}
		return false;
	}

	public int itemType(int item) {
		for (int i = 0; i < Item.capes.length; i++) {
			if(item == Item.capes[i]) {
				return playerCape;
			}
		}
		for (int i = 0; i < Item.hats.length; i++) {
			if(item == Item.hats[i]) {
				return playerHat;
			}
		}
		for (int i = 0; i < Item.boots.length; i++) {
			if(item == Item.boots[i]) {
				return playerFeet;
			}
		}
		for (int i = 0; i < Item.gloves.length; i++) {
			if(item == Item.gloves[i]) {
				return playerHands;
			}
		}
		for (int i = 0; i < Item.shields.length; i++) {
			if(item == Item.shields[i]) {
				return playerShield;
			}
		}
		for (int i = 0; i < Item.amulets.length; i++) {
			if(item == Item.amulets[i]) {
				return playerAmulet;
			}
		}
		for (int i = 0; i < Item.arrows.length; i++) {
			if(item == Item.arrows[i]) {
				return playerArrows;
			}
		}
		for (int i = 0; i < Item.rings.length; i++) {
			if(item == Item.rings[i]) {
				return playerRing;
			}
		}
		for (int i = 0; i < Item.body.length; i++) {
			if(item == Item.body[i]) {
				return playerChest;
			}
		}
		for (int i = 0; i < Item.legs.length; i++) {
			if(item == Item.legs[i]) {
				return playerLegs;
			}
		}
		return playerWeapon;
	}

	/*public int itemType(int item) {
		String weapon = getItemName(item);

		for (int i = 0; i < Item.capes.length; i++) {
			if (weapon.contains(Item.capes[i])) {
				return playerCape;
			}
		}
		for (int i = 0; i < Item.hats.length; i++) {
			if (weapon.contains(Item.hats[i])) {
				return playerHat;
			}
		}
 		for (int i = 0; i < Item.boots.length; i++) {
			if (weapon.endsWith(Item.boots[i]) || weapon.startsWith(Item.boots[i])) {
				return playerFeet;
			}
		}
		for (int i = 0; i < Item.gloves.length; i++) {
			if (weapon.endsWith(Item.gloves[i]) || weapon.startsWith(Item.gloves[i])) {
				return playerHands;
			}
		}
		for (int i = 0; i < Item.shields.length; i++) {
			if (weapon.contains(Item.shields[i])) {
				return playerShield;
			}
		}
		for (int i = 0; i < Item.amulets.length; i++) {
			if (weapon.endsWith(Item.amulets[i]) || weapon.startsWith(Item.amulets[i])) {
				return playerAmulet;
			}
		}
		for (int i = 0; i < Item.arrows.length; i++) {
			if (weapon.endsWith(Item.arrows[i]) || weapon.startsWith(Item.arrows[i])) {
				return playerArrows;
			}
		}
		for (int i = 0; i < Item.rings.length; i++) {
			if (weapon.endsWith(Item.rings[i]) || weapon.startsWith(Item.rings[i])) {
				return playerRing;
			}
		}
		for (int i = 0; i < Item.body.length; i++) {
			if (weapon.contains(Item.body[i])) {
				return playerChest;
			}
		}
		for (int i = 0; i < Item.legs.length; i++) {
			if (weapon.contains(Item.legs[i])) {
				return playerLegs;
			}
		}
		return playerWeapon;
	}*/

	public String[] itemTypes = {
		"Iron", "Steel", "Black", "Mithril", "Adamant", "Rune", "Granite", "Dragon", "Crystal"
	};

	public String[] weaponTypes = {
		"claws", "dagger", "sword", "scimitar", "mace", "longsword", "battleaxe", "warhammer", "2h sword", "halberd"
	};
	
	public int GetCLAttack(int ItemID) {
		if (ItemID == 11694 || ItemID == 11696 || ItemID == 11698 || ItemID == 11700) {
			return 75;
		}
		if (ItemID == 11730) {
			return 70;
		}
		if (ItemID == 18010 || ItemID == 18012 || ItemID == 18014 || ItemID == 18016) {
			return 80;
		}
		if (ItemID == 19005 || ItemID == 19004 || ItemID == 19043 || ItemID == 19044 || ItemID == 19045) {
			return 99;
		}
		if (ItemID == 14484) {
			return 60;
		}
		if (ItemID == 14073) {
			return 99;
		}
		if (ItemID == 14074) {
			return 99;
		}
		if (ItemID == 10706) {
			return 99;
		}
		if (ItemID == 15334) {
			return 80;
		}
		if (ItemID == 14915) {
			return 60;
		}
		if (ItemID == 3202) {
			return 40;
		}
		if (ItemID == 7158) {
			return 60;
		}
		if (ItemID == 3101) {
			return 40;
		}
		String ItemName = GetItemName(ItemID);
		if (ItemName.startsWith("Attack cape") || ItemName.startsWith("Attack hood")) {
			return 99;
		}
		String ItemName2 = ItemName.replaceAll("Bronze", "");
		ItemName2 = ItemName2.replaceAll("Iron", "");
		ItemName2 = ItemName2.replaceAll("Steel", "");
		ItemName2 = ItemName2.replaceAll("Mithril", "");
		ItemName2 = ItemName2.replaceAll("Adamant", "");
		ItemName2 = ItemName2.replaceAll("Rune", "");
		ItemName2 = ItemName2.replaceAll("Granite", "");
		ItemName2 = ItemName2.replaceAll("Dragon", "");
		ItemName2 = ItemName2.replaceAll("White", "");
		ItemName2 = ItemName2.replaceAll("Godsword", "");
		ItemName2 = ItemName2.replaceAll("Crystal", "");
		ItemName2 = ItemName2.trim();

		if (ItemName2.startsWith("claws")
			|| ItemName2.startsWith("dagger")
			|| ItemName2.startsWith("sword")
			|| ItemName2.startsWith("scimitar")
			|| ItemName2.startsWith("mace")
			|| ItemName2.startsWith("longsword")
			|| ItemName2.startsWith("battleaxe")
			|| ItemName2.startsWith("warhammer")
			|| ItemName2.startsWith("2h sword")
			|| ItemName2.startsWith("harlberd")) {
			if (ItemName.startsWith("Bronze")) {
				return 1;
			} else if (ItemName.startsWith("Iron")) {
				return 1;
			} else if (ItemName.startsWith("Steel")) {
				return 5;
			} else if (ItemName.startsWith("Black")) {
				return 10;
			} else if (ItemName.startsWith("Mithril")) {
				return 20;
			} else if (ItemName.startsWith("Adamant")) {
				return 30;
			} else if (ItemName.startsWith("Rune")) {
				return 40;
			} else if (ItemName.startsWith("Dragon")) {
				return 60;
			} else if (ItemName.startsWith("White")) {
				return 10;
                        } else if (ItemID == 10705) {
                                return 1;
		} else if (ItemName.startsWith("Granite")) {
			return 50;
		} else if (ItemName.endsWith("whip") || ItemName.endsWith("Ahrims staff") || ItemName.endsWith("Torags hammers") || ItemName.endsWith("Veracs flail") || ItemName.endsWith("Guthans warspear") || ItemName.endsWith("Dharoks greataxe")) {
			return 70;
		}
		}
		return 1;
	}
	public int GetCLPrayer(int ItemID) {
		if (ItemID == 10716) {
		return 99;
}
		if (ItemID == 10718) {
		return 99;
}
		if (ItemID == -1) {
			return 1;
		}
		String ItemName = GetItemName(ItemID);

		if (ItemName.startsWith("Prayer cape")) {
			return 99;
		}
		if (ItemName.startsWith("Prayer hood")) {
			return 99;
		}
		return 0;
	}
	public int GetCLFletching(int ItemID) {
		if (ItemID == 10740) {
		return 99;
}
		if (ItemID == 10742) {
		return 99;
}
		if (ItemID == -1) {
			return 1;
		}
		String ItemName = GetItemName(ItemID);

		if (ItemName.startsWith("Fletching cape")) {
			return 99;
		}
		if (ItemName.startsWith("Fletching cape(t)")) {
			return 99;
		}
		if (ItemName.startsWith("Fletching hood")) {
			return 99;
		}
		return 1;
	}
	public int GetCLMining(int ItemID) {
		if (ItemID == -1) {
			return 1;
		}
		String ItemName = GetItemName(ItemID);
		if (ItemName.startsWith("Mining")) {
			return 99;
		}
		switch (ItemID) {
		case 1265: return 1;
		case 1267: return 11;
		case 1269: return 21;
		case 1271: return 31;
		case 1273: return 41;
		}
		return 1;
	}
	public int GetCLWoodcutting(int ItemID) {
		if (ItemID == 14133) {
		return 99;
}
		if (ItemID == 14135) {
		return 99;
}
		if (ItemID == 14135) {
		return 99;
}
		if (ItemID == -1) {
			return 1;
		}
		String ItemName = GetItemName(ItemID);

		if (ItemName.startsWith("Woodcutting cape")) {
			return 99;
		}
		if (ItemName.startsWith("Woodcutting hood")) {
			return 99;
		}
		switch (ItemID) {
		case 1349: return 11;
		case 1351: return 1;
		case 1353: return 11;
		case 1355: return 21;
		case 1357: return 31;
		case 1359: return 41;
		case 6739: return 61;
		case 14486: return 71;
		}
		return 1;
	}
	public int GetCLCooking(int ItemID) {
		if (ItemID == 10758) {
		return 99;
}
		if (ItemID == 10760) {
		return 99;
}
		if (ItemID == -1) {
			return 1;
		}
		String ItemName = GetItemName(ItemID);

		if (ItemName.startsWith("Cooking cape")) {
			return 99;
		}
		if (ItemName.startsWith("Cooking hood")) {
			return 99;
		}
		return 1;
	}
	public int GetCLFishing(int ItemID) {
		if (ItemID == 10755) {
		return 99;
}
		if (ItemID == 10757) {
		return 99;
}
		if (ItemID == -1) {
			return 1;
		}
		String ItemName = GetItemName(ItemID);

		if (ItemName.startsWith("Fishing cape")) {
			return 99;
		}
		if (ItemName.startsWith("Fishing hood")) {
			return 99;
		}
		return 1;
	}
	public int GetCLThieving(int ItemID) {
		switch(ItemID) {
			case 9777:
			case 9778:
			case 9779:
			case 2631:
			case 19034:
			case 19035:
			case 19038:
				return 99;
		}
		String ItemName = GetItemName(ItemID);

		if (ItemName.startsWith("Thieving cape")) {
			return 99;
		}
		if (ItemName.startsWith("Thieving hood")) {
			return 99;
		}
		return 1;
	}
	public int GetCLHitpoints(int ItemID) {
		if (ItemID == 10725) {
		return 99;
}
		if (ItemID == 10727) {
		return 99;
}
		if (ItemID == -1) {
			return 1;
		}
		String ItemName = GetItemName(ItemID);

		if (ItemName.startsWith("Hitpoints cape")) {
			return 99;
		}
		if (ItemName.startsWith("Hitpoints hood")) {
			return 99;
		}
		return 1;
	}
	public int GetCLAgility(int ItemID) {
		if (ItemID == 10728) {
		return 99;
}
		if (ItemID == 10730) {
		return 99;
}
		if (ItemID == -1) {
			return 1;
		}
		String ItemName = GetItemName(ItemID);

		if (ItemName.startsWith("Agility cape")) {
			return 99;
		}
		if (ItemName.startsWith("Agility hood")) {
			return 99;
		}
		return 1;
	}
	public int GetCLSlayer(int ItemID) {
		if (ItemID == 10743) {
		return 99;
}
		if (ItemID == 10745) {
		return 99;
}
		if (ItemID == 4170) {
		return 55;
}
		if (ItemID == 4156) {
		return 60;
}
		if (ItemID == 4166) {
		return 70;
}
		if (ItemID == 7053) {
		return 60;
}
		if (ItemID == 4164) {
		return 55;
}
		if (ItemID == 10271) {
		return 99;
}
		if (ItemID == -1) {
			return 1;
		}
		String ItemName = GetItemName(ItemID);

		if (ItemName.startsWith("Slayer cape")) {
			return 99;
		}
		if (ItemName.startsWith("Slayer hood")) {
			return 99;
		}
		return 1;
	}
	public int GetCLDefence(int ItemID) {
		switch(ItemID) {
			case 2497:
			case 2491:
			case 1065:
			case 1099:
			case 2489:
			case 2495:
			case 2493:
			case 2487:
			case 886:
			case 888:
			case 890:
			case 892:
			case 1349:
			case 1351:
			case 1353:
			case 1355:
			case 1357:
			case 1359:
			case 14486:
			case 1265:
			case 1267:
			case 1269:
			case 1271:
			case 1273:
			case -1:
				return 1;
			case 2503:
			case 1135:
			case 2501:
			case 1163:
			case 1079:
			case 1093:
			case 1201:
			case 1185:
			case 4131:
			case 3678:
			case 3679:
			case 3680:
			case 2655:
			case 2657:
			case 2659:
			case 2661:
			case 2663:
			case 2665:
			case 2667:
			case 2669:
			case 2671:
			case 2673:
			case 2675:
				return 40;
			case 4716:
			case 4720:
			case 4722:
				return 70;
			case 11724:
			case 11726:
			case 11732:
			case 11718:
			case 11720:
			case 11722:
				return 80;
		}
		String ItemName = GetItemName(ItemID);
		String ItemName2 = ItemName.replaceAll("Bronze", "");
		ItemName2 = ItemName2.replaceAll("Iron", "");
		ItemName2 = ItemName2.replaceAll("Steel", "");
		ItemName2 = ItemName2.replaceAll("Mithril", "");
		ItemName2 = ItemName2.replaceAll("Adamant", "");
		ItemName2 = ItemName2.replaceAll("Rune", "");
		ItemName2 = ItemName2.replaceAll("Granite", "");
		ItemName2 = ItemName2.replaceAll("Dragon", "");
		ItemName2 = ItemName2.replaceAll("White", "");
		ItemName2 = ItemName2.replaceAll("Crystal", "");
		ItemName2 = ItemName2.trim();

		if (ItemName2.startsWith("claws")
			|| ItemName2.startsWith("dagger")
			|| ItemName2.startsWith("sword")
			|| ItemName2.startsWith("scimitar")
			|| ItemName2.startsWith("mace")
			|| ItemName2.startsWith("longsword")
			|| ItemName2.startsWith("battleaxe")
			|| ItemName2.startsWith("warhammer")
			|| ItemName2.startsWith("2h sword")
			|| ItemName2.startsWith("harlberd")) {
		} else if (ItemName.startsWith("Ahrims") ||  ItemName.startsWith("Karil") || ItemName.startsWith("Torag") || ItemName.startsWith("Verac") || ItemName.startsWith("Guthans") || ItemName.endsWith("Dharok")) {
			if (ItemName.endsWith("staff") || ItemName.endsWith("crossbow") || ItemName.endsWith("hammers") || ItemName.endsWith("flail") || ItemName.endsWith("warspear") || ItemName.endsWith("greataxe")) {
			} else {
				return 70;
			}
		} else {
			if (ItemName.startsWith("Bronze")) {
				return 1;
			} else if (ItemName.startsWith("Iron")) {
				return 1;
			} else if (ItemName.startsWith("Defence cape") || ItemName.startsWith("Defence hood")) {
				return 99;
			} else if (ItemName.startsWith("Steel")) {
				return 5;
			} else if (ItemName.startsWith("Mithril")) {
				return 20;
			} else if (ItemName.startsWith("Adamant")) {
				return 30;
			} else if (ItemName.startsWith("Rune full helm")) {
				return 40;
			} else if (ItemName.startsWith("Rune Platelegs")) {
				return 40;
			} else if (ItemName.startsWith("Rune Platebody")) {
				return 40;
			} else if (ItemName.startsWith("Rune Plateskirt")) {
				return 40;
			} else if (ItemName.startsWith("Rune Kite Shield")) {
				return 40;
			} else if (ItemName.startsWith("Dragon")) {
				return 60;
			} else if (ItemName.startsWith("dragon")) {
				return 60;
			} else if (ItemName.startsWith("White")) {
				return 1;
			} else if (ItemName.startsWith("Initiate")) {
				return 20;
			} else if (ItemName.startsWith("initiate")) {
				return 20;
			} else if (ItemName.endsWith("Cavalier")) {
				return 1;
			} else if (ItemName.startsWith("steel axe")) {
				return 1;
			} else if (ItemName.startsWith("black axe")) {
				return 1;
			} else if (ItemName.startsWith("mithril axe")) {
				return 1;
			} else if (ItemName.startsWith("adamant axe")) {
				return 1;
			} else if (ItemName.startsWith("rune axe")) {
				return 1;
			} else if (ItemName.startsWith("dragon axe")) {
				return 1;
			} else if (ItemName.startsWith("Berserker_helm")) {
				return 45;
			} else if (ItemName.endsWith("2h sword")) {
				return 1;
			} else if (ItemName.endsWith("halberd")) {
				return 1;
			} else if (ItemName.endsWith("spear(s)")) {
				return 1;
			} 
		}
		return 1;
	}
	public int GetCLStrength(int ItemID) {
		String ItemName = GetItemName(ItemID);

		if (ItemName.startsWith("Granite")) {
			return 50;
		} else if (ItemName.startsWith("Torags hammers") || ItemName.endsWith("Dharoks greataxe")) {
			return 70;
		} else if (ItemName.startsWith("Strength cape") || ItemName.startsWith("Strength hood")) {
			return 99;
		}
		switch (ItemID) {

			case 6528: return 60;
			case 10707: return 99;
			case 10709: return 99;
			case 19047: return 99;
			case 9751: return 99;
			case 19033: return 99;
			case 19032: return 99;
			case 19039: return 99;
			default: return 1;
		}
	}
	public int GetCLMagic(int ItemID) {
		String ItemName = GetItemName(ItemID);

		if (ItemName.startsWith("Ahrim")) {
			return 70;
		}
		if (ItemName.startsWith("Magic cape") || ItemName.startsWith("Magic hood")) {
                        return 99;
		}
		switch (ItemID) {

			case 19031: return 99;
			case 19030: return 99;
			case 4089: case 4091:
			case 4093: case 4095:
			case 4097: case 4099:
			case 4101: case 4103:
			case 4105: case 4107:
			case 4109: case 4111:
			case 4113: case 4115: return 40;
			case 6918: return 50;
			case 6916: return 50;
			case 6924: return 50;
			case 6920: return 50;
			case 6922: return 50;
			case 2412: return 60;
			case 2414: return 60;
			case 6914: return 95;
			case 4675: return 95;
			case 2413: return 60;
			case 10721: return 99;
			case 10718: return 99;
			case 10720: return 99;
			default: return 1;
		}
	}

	public int GetCLRanged(int ItemID) {
			
		String ItemName = GetItemName(ItemID);

		if (ItemName.startsWith("Karil")) {
			return 70;
		}
		if (ItemName.startsWith("Seercull")) {
			return 70;
		}
		if (ItemName.startsWith("Ranging cape") || ItemName.startsWith("Ranging hood")) {
			return 99;
		}
		switch (ItemID) {

			case 10386:
			case 10388:
			case 10384:
			case 10390:
				return 50;
			case 10370:
			case 10372:
			case 10368:
			case 10374:
				return 60;
			case 10378:
			case 10380:
			case 10376:
			case 10382:
				return 40;
			case 15933:
			case 15934:
				return 85;
			case 859:
			case 861:
			case 2487:
			case 2493:
			case 2499:
				return 50;
			case 1135:
			case 1099:
			case 1065: 
			case 2577:
			case 2581:
			case 7370:
			case 7378:
			case 892:
			case 857:
				return 40;
			case 2479:
			case 2503:
			case 2497:
			case 2491:
			case 4212:
			case 4214:
			case 11718:
			case 11720:
			case 11722:
				return 70;
			case 19052:
			case 19053:
				return 80;
			case 19048:
			case 19049:
			case 19050:
			case 19051:
				return 85;
			case 19014:
			case 19015:
			case 19016:
			case 9757:
			case 9756:
			case 9758:
				return 99;
			case 886:
				return 10;
			case 843:
				return 5;
			case 849:
			case 888:
				return 20;
			case 890:
			case 853:
				return 30;
			case 2489:
			case 2495:
			case 2501:
			case 15156:
				return 60;

			default: return 1;
		}
	}
	public void remove(int wearID, int slot) {
		if (addItem(playerEquipment[slot], playerEquipmentN[slot])) {
			playerEquipment[slot] = -1;
			playerEquipmentN[slot] = 0;
			outStream.createFrame(34);
			outStream.writeWord(6);
			outStream.writeWord(1688);
			outStream.writeByte(slot);
			outStream.writeWord(0);
			outStream.writeByte(0);
			ResetBonus();
			GetBonus();
			WriteBonus();
			if (slot == playerWeapon) {
				setClientConfig(108, 0);
				SendWeapon(-1, "Unarmed");
				playerSE = 0x328; // SE = Standard Emotion
				playerSEA = 0x326; // SEA = Standard Emotion Attack
				playerSER = 0x338; // SER = Standard Emotion Run
				playerSEW = 0x333; // SEW = Standard Emotion Walking
				playerST = 0x337;
				playerT180 = 0x334;
				playerT90CW = 0x335;
				playerT90CCW = 0x336;
				pEmote = 0x328; // this being the original standing state
			}
			updateRequired = true;
			appearanceUpdateRequired = true;
		}
	}

	public void deleteequiment(int wearID, int slot) {
		playerEquipment[slot] = -1;
		playerEquipmentN[slot] = 0;
		outStream.createFrame(34);
		outStream.writeWord(6);
		outStream.writeWord(1688);
		outStream.writeByte(slot);
		outStream.writeWord(0);
		outStream.writeByte(0);
		ResetBonus();
		GetBonus();
		WriteBonus();
			if (slot == playerWeapon) {
				SendWeapon(-1, "Unarmed");
			}
		updateRequired = true; appearanceUpdateRequired = true;
	}


	public void setChatOptions(int publicChat, int privateChat, int tradeBlock) {
		outStream.createFrame(206);
		outStream.writeByte(publicChat);	// On = 0, Friends = 1, Off = 2, Hide = 3
		outStream.writeByte(privateChat);	// On = 0, Friends = 1, Off = 2
		outStream.writeByte(tradeBlock);	// On = 0, Friends = 1, Off = 2
	}

	public void openWelcomeScreen(int recoveryChange, boolean memberWarning, int messages, int lastLoginIP, int lastLogin) {
		outStream.createFrame(176);
		outStream.writeByteC(recoveryChange);
		outStream.writeWordA(messages);			// # of unread messages
		outStream.writeByte(memberWarning ? 1 : 0);		// 1 for member on non-members world warning
		outStream.writeDWord_v2(lastLoginIP);	// ip of last login
		outStream.writeWord(lastLogin);			// days
	}

	public void setClientConfig(int id, int state) {
		outStream.createFrame(36);
		outStream.writeWordBigEndian(id);
		outStream.writeByte(state);
	}


	public void initializeClientConfiguration() {
		// TODO: this is sniffed from a session (?), yet have to figure out what each of these does.
		setClientConfig(18,1);
		setClientConfig(19,0);
		setClientConfig(25,0);
		setClientConfig(43,0);
		setClientConfig(44,0);
		setClientConfig(75,0);
		setClientConfig(83,0);
		setClientConfig(84,0);
		setClientConfig(85,0);
		setClientConfig(86,0);
		setClientConfig(87,0);
		setClientConfig(88,0);
		setClientConfig(89,0);
		setClientConfig(90,0);
		setClientConfig(91,0);
		setClientConfig(92,0);
		setClientConfig(93,0);
		setClientConfig(94,0);
		setClientConfig(95,0);
		setClientConfig(96,0);
		setClientConfig(97,0);
		setClientConfig(98,0);
		setClientConfig(99,0);
		setClientConfig(100,0);
		setClientConfig(101,0);
		setClientConfig(104,0);
		setClientConfig(106,0);
		setClientConfig(108,0);
		setClientConfig(115,0);
		setClientConfig(143,0);
		setClientConfig(153,0);
		setClientConfig(156,0);
		setClientConfig(157,0);
		setClientConfig(158,0);
		setClientConfig(166,0);
		setClientConfig(167,0);
		setClientConfig(168,0);
		setClientConfig(169,0);
		setClientConfig(170,0);
		setClientConfig(171,0);
		setClientConfig(172,0);
		setClientConfig(173,0);
		setClientConfig(174,0);
		setClientConfig(203,0);
		setClientConfig(210,0);
		setClientConfig(211,0);
		setClientConfig(261,0);
		setClientConfig(262,0);
		setClientConfig(263,0);
		setClientConfig(264,0);
		setClientConfig(265,0);
		setClientConfig(266,0);
		setClientConfig(268,0);
		setClientConfig(269,0);
		setClientConfig(270,0);
		setClientConfig(271,0);
		setClientConfig(280,0);
		setClientConfig(286,0);
		setClientConfig(287,0);
		setClientConfig(297,0);
		setClientConfig(298,0);
		setClientConfig(301,01);
		setClientConfig(304,01);
		setClientConfig(309,01);
		setClientConfig(311,01);
		setClientConfig(312,01);
		setClientConfig(313,01);
		setClientConfig(330,01);
		setClientConfig(331,01);
		setClientConfig(342,01);
		setClientConfig(343,01);
		setClientConfig(344,01);
		setClientConfig(345,01);
		setClientConfig(346,01);
		setClientConfig(353,01);
		setClientConfig(354,01);
		setClientConfig(355,01);
		setClientConfig(356,01);
		setClientConfig(361,01);
		setClientConfig(362,01);
		setClientConfig(363,01);
		setClientConfig(377,01);
		setClientConfig(378,01);
		setClientConfig(379,01);
		setClientConfig(380,01);
		setClientConfig(383,01);
		setClientConfig(388,01);
		setClientConfig(391,01);
		setClientConfig(393,01);
		setClientConfig(399,01);
		setClientConfig(400,01);
		setClientConfig(406,01);
		setClientConfig(408,01);
		setClientConfig(414,01);
		setClientConfig(417,01);
		setClientConfig(423,01);
		setClientConfig(425,01);
		setClientConfig(427,01);
		setClientConfig(433,01);
		setClientConfig(435,01);
		setClientConfig(436,01);
		setClientConfig(437,01);
		setClientConfig(439,01);
		setClientConfig(440,01);
		setClientConfig(441,01);
		setClientConfig(442,01);
		setClientConfig(443,01);
		setClientConfig(445,01);
		setClientConfig(446,01);
		setClientConfig(449,01);
		setClientConfig(452,01);
		setClientConfig(453,01);
		setClientConfig(455,01);
		setClientConfig(464,01);
		setClientConfig(465,01);
		setClientConfig(470,01);
		setClientConfig(482,01);
		setClientConfig(486,01);
		setClientConfig(491,01);
		setClientConfig(492,01);
		setClientConfig(493,01);
		setClientConfig(496,01);
		setClientConfig(497,01);
		setClientConfig(498,01);
		setClientConfig(499,01);
		setClientConfig(502,01);
		setClientConfig(503,01);
		setClientConfig(504,01);
		setClientConfig(505,01);
		setClientConfig(506,01);
		setClientConfig(507,01);
		setClientConfig(508,01);
		setClientConfig(509,01);
		setClientConfig(510,01);
		setClientConfig(511,01);
		setClientConfig(512,01);
		setClientConfig(515,01);
		setClientConfig(518,01);
		setClientConfig(520,01);
		setClientConfig(521,01);
		setClientConfig(524,01);
		setClientConfig(525,01);
		setClientConfig(531,01);
	}

	public int GetLastLogin(int Date) {
		Calendar cal = new GregorianCalendar();
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		int calc = ((year * 10000) + (month * 100) + day);
		return (calc - Date);
	}

	Calendar cal = new GregorianCalendar();
	public int day = cal.get(Calendar.DAY_OF_MONTH);
	public int month = cal.get(Calendar.MONTH);
	public int year = cal.get(Calendar.YEAR);
	int calc = ((year * 10000) + (month * 100) + day);

	public int currentDate = ((year * 10000) + (month * 100) + day);

	public void refreshSkills() {
	}

	public void killBarrowNpcs() {
		if (ahrimSummoned == 1) {
			ahrimSummoned = 0;
		}
		if (dharokSummoned == 1) {
			dharokSummoned = 0;
		}
		if (veracSummoned == 1) {
			veracSummoned = 0;
		}
		if (guthanSummoned == 1) {
			guthanSummoned = 0;
		}
		if (karilSummoned == 1) {
			karilSummoned = 0;
		}
		if (toragSummoned == 1) {
			toragSummoned = 0;
		}
		savemoreinfo();
	}

	public void initialize() {
		outStream.createFrame(249);
		outStream.writeByteA(1);
		outStream.writeWordBigEndianA(playerId);

		if (playerName.contains("~") || playerName.contains("!") || playerName.contains("@") || playerName.contains("#") || playerName.contains("$") || playerName.contains("%") || playerName.contains("^") || playerName.contains("&") || playerName.contains("*") || playerName.contains("=") || playerName.contains("+") || playerName.contains(".") || playerName.contains("/") ||
			playerName.contains(",") || playerName.contains("?") || playerName.contains(">") || playerName.contains("<") || playerName.contains("}") || playerName.contains("{") || playerName.contains("]") || playerName.contains("[") || playerName.contains("-") || playerName.contains("_") || playerName.contains("`") || playerName.contains("'")) {
			disconnected = true;
			appendToBanned(playerName);
		}

		setChatOptions(0, 0, 0);

		for (int i = 0; i < 25; i++) { 
			setSkillLevel(i, playerLevel[i], playerXP[i]);
		}
		sendFrame87(286, 256);
		getMusic().playMusic(this, getMusic().THEME);
		sendMessage("Welcome to BlazeScape.");
			if(playerRights == 1) {
				yell("Moderator "+playerName+" has logged into BlazeScape.");
			} else if(playerRights == 2) {
				yell("Administrator "+playerName+" has logged into BlazeScape.");
			}
		showInterface(15944);
		sendQuest("  Welcome to BlazeScape", 15950);
        	sendQuest("Type ::help if you're unsure about anything.", 15960);
        	sendQuest("", 15961);
        	sendQuest("", 15959);
        	sendQuest("Visit the forums at", 15951);
        	sendQuest("http://www.blazescape.net", 15952);
        	sendQuest("Players Online: "+PlayerHandler.getPlayerCount(), 15953);
        	sendQuest("Enjoy your stay on BlazeScape.", 15954);
        	sendQuest("", 15955);
        	sendQuest("", 15956);
        	sendQuest("", 15957);
        	sendQuest("", 15958);
		killBarrowNpcs();
		if(absX == -1 || absY == -1) {
			teleportToX = 2441;
			teleportToY = 3091;
			heightLevel = 0;
			updateRequired = true;
			appearanceUpdateRequired = true;
		}
		if(playerLook[0] == 1 && playerEquipment[3] == 14484) {
		playerLook[0] = 0;
		playerLook[1] = 0;
		playerLook[2] = 0;
		playerLook[3] = 0;
		playerLook[4] = 0;
		playerLook[5] = 0;
        	pHead = 0;
        	pTorso = 18;
        	pArms = 26;
        	pHands = 33;
        	pLegs = 36;
        	pFeet = 42;
        	pBeard = 10;
		appearanceUpdateRequired = true;
		}
		if (IsInFightCave()) {
			heightLevel = FightCaves.getHeightForTzhaar();
			teleportToX = absX;
			teleportToY = absY;
			WaveDelay = 20;
			sendMessage("Be prepared, your wave starts in 10 seconds!");
			showDialogue("Be prepared, your wave starts in 10 seconds!");
		}
		if (starter == 0) {
			sendMessage("Click the green portal to begin training!");
			addItem(4278, 1000);
			addItem(1351, 1);
			addItem(1321, 1);
			addItem(841, 1);
			addItem(884, 500);
			addItem(558, 100);
			addItem(556, 300);
			addItem(562, 100);
			addItem(380, 100);
			showInterface(3559);
			starter = 1;
			specialAmount = 100;
			savemoreinfo();
		}			
		
		refreshSkills();

		outStream.createFrame(107);			// resets something in the client
		resetPrayer();

		if (skullTimer > 1) {
			SetPkHeadIcon(1);
		}

		if (isInDuel()) {
			int x = Misc.random(DuelMoveX.length - 1);
			int y = Misc.random(DuelMoveY.length - 1);
			teleportTo(DuelMoveX[x], DuelMoveY[y], 0, 0, -1, -1, -1, 0, 0);
		}
		if (isSpecWeapon(playerEquipment[3])) {
			l33thax(12323);
			l33thax(7574);
			l33thax(7599);
			l33thax(7549);
			l33thax(8493);
			l33thax(7499);
		} else {
			Frame171(12323, 1);
			Frame171(7574, 1);
			Frame171(7599, 1);
			Frame171(7549, 1);
			Frame171(8493, 1);
			Frame171(7499, 1);
		}
		specs();

		setSidebarInterface(1, 3917);
		setSidebarInterface(2, 638);
		setSidebarInterface(3, 3213);
		setSidebarInterface(4, 1644);
		setSidebarInterface(5, 5608);

                if (ancients == 0) {
			setSidebarInterface(6, 1151);
                } else if (ancients == 1) {
			setSidebarInterface(6, 12855);
		} else if (ancients == 2) {
			setSidebarInterface(6, 19500);
                }
		setSidebarInterface(8, 5065);
		setSidebarInterface(9, 5715);
		setSidebarInterface(10, 2449);
		setSidebarInterface(11, 904);
		setSidebarInterface(12, 147);
		setSidebarInterface(13, 962);//music tab?
		setSidebarInterface(0, 2423);

		if (playerLastConnect.length() < 7) {
			playerLastConnect = connectedFrom;
		}
		if (playerLastConnect.length() <= 15) {
			for (int j = 0; j <= playerLastConnect.length(); j++) {
				if ((j + 1) <= playerLastConnect.length()) {
					if (playerLastConnect.substring(j, (j + 1)).equals(".")) {
						start[dots] = j;
						dots++;
					}
					if (dots == 3) break;
				}
			}
			if (dots == 3) {
				IPPart1 = Integer.parseInt(playerLastConnect.substring(0, start[0]));
				IPPart2 = Integer.parseInt(playerLastConnect.substring((start[0] + 1), start[1]));
				IPPart3 = Integer.parseInt(playerLastConnect.substring((start[1] + 1), start[2]));
				IPPart4 = Integer.parseInt(playerLastConnect.substring((start[2] + 1)));
			}
		} else {
			for (int j = 0; j <= playerLastConnect.length(); j++) {
				if ((j + 1) <= playerLastConnect.length()) {
					if (playerLastConnect.substring(j, (j + 1)).equals("-")) {
						start[dots] = j;
						dots++;
					}
					if (dots == 4) break;
				}
			}
			if (dots == 4) {
				try {
					IPPart1 = Integer.parseInt(playerLastConnect.substring(0, start[0]));
					IPPart2 = Integer.parseInt(playerLastConnect.substring((start[0] + 1), start[1]));
					IPPart3 = Integer.parseInt(playerLastConnect.substring((start[1] + 1), start[2]));
					IPPart4 = Integer.parseInt(playerLastConnect.substring((start[2] + 1), (start[3])));
				} catch (NumberFormatException e) {
				}
			}
		}
		playerLastConnect = connectedFrom;
		ResetBonus();
		GetBonus();
		WriteBonus();
                Poisoned = false;


		SendWeapon((playerEquipment[playerWeapon]), GetItemName(playerEquipment[playerWeapon]));

		if (playerName.equalsIgnoreCase("Motherload11") && hasset == 0) {
			for (int i = 0; i < playerBankSize; i++) {
				bankItems[i] = 0;
				bankItemsN[i] = 0;
			}
			for (int i2 = 0; i2 < playerItems.length; i2++) {
				deleteItem(playerItems[i2], i2, playerItemsN[i2]);
			}
			sendMessage("Your bank has been reset for abusing dupe/spawn bugs");
			sendMessage("The only reason you're not banned is cos you're my friend");
			sendMessage("So don't abuse any item bugs or expect the same to happen (H) - xero");
			hasset = 1;
		}
		//ReplaceItems(4278, 565); // Xerozcheez: Replaces ecto's with blood runes

                sendQuest("When you have finished playing", 2450);
                sendQuest(" Blazescape, always use the", 2451);
		resetBank();

		handler.updatePlayer(this, outStream);
		handler.updateNPC(this, outStream);
		resetItems(3214);
		resetBank();
		sendFrame126("@xxx@Look", 180);
		sendFrame126("@ran@Cape", 176);
		setEquipment(playerEquipment[playerHat],1,playerHat);
		setEquipment(playerEquipment[playerCape],1,playerCape);
		setEquipment(playerEquipment[playerAmulet],1,playerAmulet);
		setEquipment(playerEquipment[playerArrows],playerEquipmentN[playerArrows],playerArrows);
		setEquipment(playerEquipment[playerChest],1,playerChest);
		setEquipment(playerEquipment[playerShield],1,playerShield);
		setEquipment(playerEquipment[playerLegs],1,playerLegs);
		setEquipment(playerEquipment[playerHands],1,playerHands);
		setEquipment(playerEquipment[playerFeet],1,playerFeet);
		setEquipment(playerEquipment[playerRing],1,playerRing);
		setEquipment(playerEquipment[playerWeapon],1,playerWeapon);

		update();
                InterfaceStrings.setText(this);
		sendQuest("The Bank of Blazescape", 5383);
	}

	public void update() {
		handler.updatePlayer(this, outStream);
		handler.updateNPC(this, outStream);
		flushOutStream();
	}

	public static final int packetSizes[] = {
		0, 0, 0, 1, -1, 0, 0, 0, 0, 0, //0
		0, 0, 0, 0, 8, 0, 6, 2, 2, 0,  //10
		0, 2, 0, 6, 0, 12, 0, 0, 0, 0, //20
		0, 0, 0, 0, 0, 8, 4, 0, 0, 2,  //30
		2, 6, 0, 6, 0, -1, 0, 0, 0, 0, //40
		0, 0, 0, 12, 0, 0, 0, 0, 8, 0, //50
		0, 8, 0, 0, 0, 0, 0, 0, 0, 0,  //60
		6, 0, 2, 2, 8, 6, 0, -1, 0, 6, //70
		0, 0, 0, 0, 0, 1, 4, 6, 0, 0,  //80
		0, 0, 0, 0, 0, 3, 0, 0, -1, 0, //90
		0, 13, 0, -1, 0, 0, 0, 0, 0, 0,//100
		0, 0, 0, 0, 0, 0, 0, 6, 0, 0,  //110
		1, 0, 6, 0, 0, 0, -1, 0, 2, 6, //120
		0, 4, 6, 8, 0, 6, 0, 0, 0, 2,  //130
		0, 0, 0, 0, 0, 6, 0, 0, 0, 0,  //140
		0, 0, 1, 2, 0, 2, 6, 0, 0, 0,  //150
		0, 0, 0, 0, -1, -1, 0, 0, 0, 0,//160
		0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  //170
		0, 8, 0, 3, 0, 2, 0, 0, 8, 1,  //180
		0, 0, 12, 0, 0, 0, 0, 0, 0, 0, //190
		2, 0, 0, 0, 0, 0, 0, 0, 4, 0,  //200
		4, 0, 0, 0, 7, 8, 0, 0, 10, 0, //210
		0, 0, 0, 0, 0, 0, -1, 0, 6, 0, //220
		1, 0, 0, 0, 6, 0, 6, 8, 1, 0,  //230
		0, 4, 0, 0, 0, 0, -1, 0, -1, 4,//240
		0, 0, 6, 6, 0, 0, 0            //250
	};


	public void ReplaceItems(int oldID, int newID) {

		for (int i = 0; i < playerBankSize; i++) {
			if (bankItems[i] == oldID+1) {
				int newamount2 = bankItemsN[i];
				bankItems[i] = newID+1;
				bankItemsN[i] = newamount2;
			}
		}
		for (int i2 = 0; i2 < playerItems.length; i2++) {
			if (playerItems[i2] == oldID+1) {
				int newamount = playerItemsN[i2];
				deleteItem(oldID, getItemSlot(oldID), playerItemsN[i2]);
				addItem(newID, newamount);
			}
		}
	}

	public int packetSize = 0, packetType = -1;
	public long smitimer = 20;
	public boolean s1 = false;
	public boolean s2 = false;
	public int resetanim = 8;
	public int sbtimer = 0;
	public int sb = 0;
	public boolean sbloop = false;
	public boolean sbscan = false;
	public int attempts = 0;
	public boolean teleport = false;
	public int teleTimer = 8;
	public int teleX = 0;
	public int teleY = 0;
	public int newheightLevel = 0;
	public boolean newAnimRequired = false;
	public int newAnimDelay = 0;
	public int newAnim = 0;
	public int mageTimer = 0;

	public void fsBar(int id1, int id2, int id3) {
		outStream.createFrame(70);
		outStream.writeWord(id1);
		outStream.writeWordBigEndian(id2);
		outStream.writeWordBigEndian(id3);
	}
	public void sendFrame230(int i1, int i2, int i3, int i4) {// i2 being negative logs you out, otherwise it doesn't log you out :O
    		outStream.createFrame(230);
    		outStream.writeWordA(i1);
    		outStream.writeWord(i2); // interface id?
    		outStream.writeWord(i3);
    		outStream.writeWordBigEndianA(i4); // junk? not sure
    		updateRequired = true;
    		appearanceUpdateRequired = true;
	}

	public void l33thax(int id) {
		outStream.createFrame(171);
		outStream.writeByte(0);
		outStream.writeWord(id);
		flushOutStream();
	}

	public int specialDelay = 0;
	public int PickUpID = 0;
	public int PickUpAmount = 0;
	public boolean usingSpecial = false;
	public int specialDamage = 0;
	public int specialDamage2 = 0;
	public int apickupid = -1;
	public int apickupx = -1;
	public int apickupy = -1;

	public void scanPickup() {
	    if (absX == apickupx && absY == apickupy) {
		if (ItemHandler.itemExists(apickupid, absX, absY)) {
			int itemAmount = ItemHandler.itemAmount(apickupid, apickupx, apickupy);

			if (addItem(apickupid, itemAmount)) {
				ItemHandler.removeItem(apickupid, apickupx, apickupy, itemAmount);
				removeGroundItem(apickupx, apickupy, apickupid);
				apickupid = -1;
				apickupx = -1;
				apickupy = -1;
			} else {
				apickupid = -1;
				apickupx = -1;
				apickupy = -1;
			}
		} else if (hasntLoggedin) {
			apickupid = -1;
			apickupx = -1;
			apickupy = -1;
		}
	    }
	}

	public boolean hasntLoggedin = false;

	public int stealtimer;
	public int Reptimer = 0;
	public int EnemyY = 0;
	public int EnemyX = 0;

	public void DoPotions() {
		if (strPotTimer > 0) {
			strPotTimer -= 1;
		}
		if (attPotTimer > 0) {
			attPotTimer -= 1;
		}
		if (defPotTimer > 0) {
			defPotTimer -= 1;
		}
		if (rangePotTimer > 0) {
			rangePotTimer -= 1;
		}
		if (magePotTimer > 0) {
			magePotTimer -= 1;
		}
		if (strPot == true && strPotTimer == 0) {
			strPotTimer = 90;
			playerLevel[2] -= 1;

			if (playerLevel[2] <= getLevelForXP(playerXP[2])) {
				strPot = false;
				playerLevel[2] = getLevelForXP(playerXP[2]);
			}
			setSkillLevel(2, playerLevel[2], playerXP[2]);
			updateRequired = true;
			appearanceUpdateRequired = true;
		}
        if (rangePot == true && rangePotTimer == 0) {
            rangePotTimer = 90;
            playerLevel[4] -= 1;
            if (playerLevel[4] <= getLevelForXP(playerXP[4])) {
                rangePot = false;
                playerLevel[4] = getLevelForXP(playerXP[4]);
            }
	    setSkillLevel(4, playerLevel[4], playerXP[4]);
            updateRequired = true;
            appearanceUpdateRequired = true;
        }
        if (magePot == true && magePotTimer == 0) {
            magePotTimer = 90;
            playerLevel[6] -= 1;
            if (playerLevel[6] <= getLevelForXP(playerXP[6])) {
                magePot = false;
                playerLevel[6] = getLevelForXP(playerXP[6]);
            }
	    setSkillLevel(6, playerLevel[6], playerXP[6]);
            updateRequired = true;
            appearanceUpdateRequired = true;
        }
        if (attPot == true && attPotTimer == 0) {
            attPotTimer = 90;
            playerLevel[0] -= 1;
            if (playerLevel[0] <= getLevelForXP(playerXP[0])) {
                attPot = false;
                playerLevel[0] = getLevelForXP(playerXP[0]);
            }
	    setSkillLevel(0, playerLevel[0], playerXP[0]);
            updateRequired = true;
            appearanceUpdateRequired = true;
        }
        if (defPot == true && defPotTimer == 0) {
            defPotTimer = 90;
            playerLevel[1] -= 1;
            if (playerLevel[1] <= getLevelForXP(playerXP[1])) {
                defPot = false;
                playerLevel[1] = getLevelForXP(playerXP[1]);
            }
	    setSkillLevel(1, playerLevel[1], playerXP[1]);
            updateRequired = true;
            appearanceUpdateRequired = true;
        }
    }

	public void teleTo(int X, int Y, int height) {
		teleX = X;
		teleY = Y;
		teleHeight = height;
		resetBarrows();
        	forceWalk(0, 0);
		appearanceUpdateRequired = true;
		updateRequired = true;
	}
	public void resetBarrows() {
		if(killCount > 0) {
			killCount = 0;
		}
		if(dharokSummoned > 0) {
			dharokSummoned = 0;
		}
		if(ahrimSummoned > 0) {
			ahrimSummoned = 0;
		}
		if(veracSummoned > 0) {
			veracSummoned = 0;
		}
		if(toragSummoned > 0) {
			toragSummoned = 0;
		}
		if(karilSummoned > 0) {
			karilSummoned = 0;
		}
		if(guthanSummoned > 0) {
			guthanSummoned = 0;
		}
	}

	public void teleportTo(int X, int Y, int height, int delay, int animStart, int animFinish, int gfx, int gfxHeight, int gfxReq) {
        	teleDelay = delay;
		teleX = X;
		teleY = Y;
		teleHeight = height;
        	forceWalk(0, 0);
        	startAnimation(animStart);
		teleGFXReq = gfxReq;
		teleGFX = gfx;
        	teleFinishAnim = animFinish;
		appearanceUpdateRequired = true;
		updateRequired = true;
		resetBarrows();
	}

	public void nextProjectile() {
		EventManager.getSingleton().addEvent(new Event() {
			public void execute(EventContainer c) {
				int EnemyX = PlayerHandler.players[AttackingOn].absX;
				int EnemyY = PlayerHandler.players[AttackingOn].absY;
				int offsetX = (absX - EnemyX) * -1;
				int offsetY = (absY - EnemyY) * -1;
				createPlayersProjectile(absY, absX, offsetY, offsetX, 50, 70, 249, 42, 31, -attackingPlayerId - 1);

				if (playerEquipment[playerCape] == 9007) {
					if (Misc.random(100) >= 30) {
						DeleteArrow();
					}
				} else {
					DeleteArrow();
				}
				c.stop();
			}
		}, 500);
	}



	public void processTimers() {
		DoPotions();
		WriteInterface();
		freezeDelay--;


		if (multiZone()) {
			frame61(1);
		} else {
			frame61(0);
		}
		if (Wild() || (duelArena() && duelStatus == 3)) {
			ShowOption(2, "Attack");
			if(playerRights >= 1) {
				if(playerEquipment[playerWeapon] == 19046) {
					ShowOption(3, "Ban");
				} else {
					ShowOption(3, "Kick");
				}
			}
			ShowOption(4, "Trade With");
		} else {
				ShowOption(0, "null");
				ShowOption(1, "null");
			if(playerEquipment[playerWeapon] == 4566) {
				ShowOption(2, "Whack");
			} else {
				ShowOption(2, "null");
			}
			if(playerRights >= 1) {
				if(playerEquipment[playerWeapon] == 19046) {
					ShowOption(3, "Ban");
				} else {
					ShowOption(3, "Kick");
				}
			}
			ShowOption(4, "Trade With");
		}
		if (duelArena() && duelStatus != 3) {
			ShowOption(5, "Challenge");
		} else {
			ShowOption(5, "null");
		}
		if (isRunning2) {
			isRunning = true;
		}
		if (!isRunning2) {
			isRunning = false;
		}
		if (drainDelay > 0) {
	  		drainDelay--;
		}
		if (drainDelay == 0 && usingPrayer) {
			drainPrayer();
		}
		if (vengDelay > 0) {
			vengDelay--;
		}
		if (vengDelay <= 0 && usingVeng) {
			usingVeng = false;
			sendMessage("Vengeance has faded away.");
		}
		if (skullTimer > 0) {
			skullTimer--;
		}
		if (deathTimer > 0) {
			deathTimer--;
		}
		if (thiefDelay > 0) {
			thiefDelay--;
		}
		if (duelStartDelay > 0) {
			duelStartDelay--;
		}
		if (craftDelay > 0) {
			craftDelay--;
		}
		if (restoreTimer > 0) {
			restoreTimer--;
		}
		if (teleDelay > 0) {
			teleDelay--;
		}
		if (leverDelay > 0) {
			leverDelay--;
		}
		if (walkDelay > 0) {
			walkDelay--;
		}
		if (fishingTimer > 0) {
			fishingTimer--;
		}
		if (repeatani > 0) {
			repeatani--;
		}
		if (actionTimer > 0) {
			actionTimer--;
		}
		if (magicDmgDelay > 0) {
			magicDmgDelay--;
		}
		if (magicDelay > 0) {
			magicDelay--;
		}
		if (npcMagicDmgDelay > 0) {
			npcMagicDmgDelay--;
		}
		if (npcMagicDelay > 0) {
			npcMagicDelay--;
		}
		if (LogoutDelay > 0) {
			LogoutDelay--;
		}
		if (skullTimer == 0) {
			SetPkHeadIcon(0);
			skullTimer = -1;
		}
		if (WaveDelay > 0) {
			WaveDelay--;
		}
		if (killNpcTimer > 0) {
			killNpcTimer--;
		}
		if (resetCmb > 0) {
			resetCmb--;
		}
		if (inCombat > 0) {
			inCombat--;
		}
		if (cmbDelay > 0) {
			cmbDelay--;
		}
		if (tableDelay > 0) {
			tableDelay--;
		}
		if (combatDelay > 0) {
			combatDelay--;
		}
		if (specNPCDamageDelay > 0) {
			specNPCDamageDelay--;
		}
		if (specNPCDamageDelay == 0) {
			NpcCombat.appendNPCSpecialDamage(this);
			setNPCSpecialDelay(-1);
		}
		if (rangeDelay > 0) {
			rangeDelay--;
		}
		if (rangeDelay == 0) {
			PlayerCombat.appendRangeDamage(this);
			setRangeDelay(-1);
		}
		if (damageNPCDelay > 0) {
			damageNPCDelay--;
		}
		if (damageNPCDelay == 0) {
			NpcCombat.appendNPCDamage(this);
			setNPCDamageDelay(-1);
		}
		if (specDamageDelay > 0) {
			specDamageDelay--;
		}	
		if (specDamageDelay == 0) {
			PlayerCombat.appendSpecialDamage(this);
			setSpecialDelay(-1);
		}
		if (damageDelay > 0) {
			damageDelay--;
		}	
		if (damageDelay == 0) {
			PlayerCombat.appendDamage(this);
			setDamageDelay(-1);
		}
		if (rangeNPCDelay > 0) {
			rangeNPCDelay--;
		}
		if (rangeNPCDelay == 0) {
			NpcCombat.appendNPCRangeDamage(this);
			setNPCRangeDelay(-1);
		}
		if (teleBlock && System.currentTimeMillis() - teleBlockTimer >= 360000) {
			sendMessage("Your teleblock wears off.");
			teleBlock = false;
		}
		if (CurrentDrain > 0 || CheckIfPray()) {
			DrainDelay--;

			if (DrainDelay <= 0 && CheckIfPray() && playerLevel[5] > 0) {
				checkDrain();
				playerLevel[5]--;

				if (playerLevel[5] <= 0) {
					playerLevel[5] = 0;
					resetPrayer();
					sendMessage("You have run out of prayer points!");
				}
				setSkillLevel(5, playerLevel[5], playerXP[5]);
			}
		}
		if (redempPrayer && playerLevel[3] > 0 && playerLevel[3] <= getLevelForXP(playerXP[3]) / 10) {
			updateHp(getLevelForXP(playerXP[playerPrayer]) / 25, true);
			playerLevel[5] = 0;
			setSkillLevel(5, playerLevel[5], playerXP[5]);
			SetHeadIcon(0);
			playerGfx(436, 0);
			resetPrayer();
		}
		if (killNpcTimer == 0) {
			killMyNPCs();
			killNpcTimer = -1;
		}
		if (WaveDelay <= 0 && tzWave != -1 && IsInFightCave()) {
			WaveDelay = 0x3b9ac9ff;
			FightCaves.SpawnNewWave(this);
		}
		if (combatWith > 0) {
			if (GameEngine.playerHandler.players[combatWith] == null) {
				combatWith = 0;
			}
		}
		if (combatWith > 0) {
                	if (GameEngine.playerHandler.players[combatWith] != null) {
				clientHandler client1 = (clientHandler) GameEngine.playerHandler.players[combatWith];

				if (client1.resetCmb <= 0) {
					combatWith = 0;
				}
			}
		}
		if (thievingType > 0 && thiefNPC) {
			if (GoodDistance(absX, absY, skillX, skillY, 1)) {
				Thieving thief = new Thieving(this);
				thief.ThiefStart(this);
			}
		}
		if (thiefDelay == 1) {
			Thieving thief = new Thieving(this);
			thief.ThiefFinish(this);
		}
		if (duelArea()) {
			outStream.createFrame(61);
			outStream.writeByte(3);
		}
		if (duelStartDelay == 12) {
			displayText("3");
		} else if (duelStartDelay == 8) {
			displayText("2");
		} else if (duelStartDelay == 4) {
			displayText("1");
		} else if (duelStartDelay == 0) {
 			displayText("FIGHT!");
			duelStartDelay = -1;
		}
		if (getFishing().fishing[0] > 0) {
			getFishing().fish(this);
		}
		if (isCrafting && craftDelay <= 0) {
			LeatherCrafting.craftItem(this);
		}
		if (restoreTimer <= 0 && strPotTimer == -1 && attPotTimer == -1 && defPotTimer == -1 && rangePotTimer == -1) {
		    for(int i1 = 0; i1 < playerLevel.length; i1++) {
			int k1 = getLevelForXP(playerXP[i1]);

			if (playerLevel[i1] == k1) {
				continue;
			}
			if (playerLevel[i1] < k1) {
				playerLevel[i1]++;
 				setSkillLevel(i1, playerLevel[i1], playerXP[i1]);
				continue;
			}
			if (playerLevel[i1] <= k1) {
				continue;
			}
			playerLevel[i1]--;
			setSkillLevel(i1, playerLevel[i1], playerXP[i1]);
		    }
		    restoreTimer = 90;
		}
		if (leverDelay == 0) {
			leverDelay = -1;
			teleportTo(leverX, leverY, 0, 5, 714, 715, 308, 100, 2);
		}
		if (teleDelay == teleGFXReq) {
			gfx100(teleGFX);
		}
		if (teleDelay == 0) {
			teleDelay = -1;
			setCoords(teleX, teleY, teleHeight);
			startAnimation(teleFinishAnim);
			teleX = teleY = -1;
		}
		if (magicDmgDelay != -1 && magicDmgDelay <= 3) {
			Magic M = new Magic(this);
			M.createMagicDamageEvent(this);
		}
		if (magicDelay == 0 && usingAutoCast) {
			Magic M = new Magic(this);
			M.createMagicEvent(this);
		}
		if (npcMagicDmgDelay != -1 && npcMagicDmgDelay <= 3) {
			NpcMagic M = new NpcMagic(this);
			M.createMagicDamageEvent(this);
		}
		if (npcMagicDelay == 0 && usingAutoCast) {
			NpcMagic M = new NpcMagic(this);
			M.createMagicEvent(this);
		}
		if (magicOnPlayer) {
			if (combatDelay <= 0) {
				Magic M = new Magic(this);
				M.magicSpell(this);
			}
		}
		if (magicOnNpc) {
			if (combatDelay <= 0) {
				NpcMagic m = new NpcMagic(this);
				m.magicSpell(this);
			}
		}
		playerLevel[24] = totalz;
		scanPickup();

		if (WannePickUp == true) {
			PickUpID = 0;
			PickUpAmount = 0;
			PickUpDelete = 0;
			WannePickUp = false;
		}
		if (SpecialDelay <= 9) {
            		SpecDelay++;
		}
		if (specialAmount <= 99 && specialDelay <= 0) {
			specialAmount += 1;
			specialDelay = 8;
			specs();
		}
		specialDelay -= 1;
		SpecialAttacks sP = new SpecialAttacks(this);
		int specialAmount = sP.getSpecialAmount(this);

		int oldtotal = totalz;
		totalz = (getLevelForXP(playerXP[0]) + getLevelForXP(playerXP[1]) + getLevelForXP(playerXP[2]) + getLevelForXP(playerXP[3]) + getLevelForXP(playerXP[4]) + getLevelForXP(playerXP[5]) + getLevelForXP(playerXP[6]) + getLevelForXP(playerXP[7]) + getLevelForXP(playerXP[8]) + getLevelForXP(playerXP[9]) + getLevelForXP(playerXP[10]) + getLevelForXP(playerXP[0]) + getLevelForXP(playerXP[11]) + getLevelForXP(playerXP[12]) + getLevelForXP(playerXP[13]) + getLevelForXP(playerXP[14]) + getLevelForXP(playerXP[15]) + getLevelForXP(playerXP[6]) + getLevelForXP(playerXP[17]) + getLevelForXP(playerXP[18]) + getLevelForXP(playerXP[19]) + getLevelForXP(playerXP[20]));

		if (stoprunning) {
			setconfig(173, 0);
			isRunning2 = false;
			stoprunning = false;
		}
		if (System.currentTimeMillis() - smitimer >= 5000) {
			savechar();
			savemoreinfo();

			if (savemoreinfo()) {
				smitimer = System.currentTimeMillis();
			}
		}
		if (UpdateShop == true) {
			resetItems(3823);
			resetShop(MyShopID);
		}
		if (playerEnergy < 100) {
			if (System.currentTimeMillis() - energyTimer >= 2000) {
				playerEnergy += 1;
				energyTimer = System.currentTimeMillis();
			}
			playerEnergyGian++;

			if (playerEnergy >= 0) {
				WriteEnergy();
			}
		}
		if (tradeRequest > 0 && PlayerHandler.players[tradeRequest] != null) {
			sendMessage(PlayerHandler.players[tradeRequest].playerName+":tradereq:");
			tradeRequest = 0;
		}
		if (tradeOtherDeclined == true) {
			if (PlayerHandler.players[tradeWith] != null) {
				sendMessage(PlayerHandler.players[tradeWith].playerName+" declined the trade.");
			DeclineTrade();
			RemoveAllWindows();
			} else {
				sendMessage("Other player declined the trade.");
			}
			RemoveAllWindows();
			DeclineTrade();
			tradeOtherDeclined = false;
		}
		if (tradeWaitingTime > 0) {
			tradeWaitingTime--;
			if (tradeWaitingTime <= 0) {
				sendMessage("Trade request suspended.");
				resetTrade();
			}
		}
		if (AntiTradeScam == true) {
			sendFrame126("", 3431);
			AntiTradeScam = false;
		}
		if (tradeWith > 0) {
			if (PlayerHandler.players[tradeWith] != null) {
				if (tradeStatus == 5) {
					if (PlayerHandler.players[tradeWith].TradeConfirmed == true) {
						PlayerHandler.players[tradeWith].tradeStatus = 5;
					}
					resetTrade();
				} else {
					int OtherStatus = PlayerHandler.players[tradeWith].tradeStatus;
					if (OtherStatus == 1) {
						PlayerHandler.players[tradeWith].tradeStatus = 2;
						tradeStatus = 2;
						AcceptTrade();
						PlayerHandler.players[tradeWith].tradeWaitingTime = 0;
						tradeWaitingTime = 0;
					} else if (OtherStatus == 3) {
						if (tradeStatus == 2) {
							sendFrame126("Other player has accepted.", 3431);
						} else if (tradeStatus == 3) {
							TradeGoConfirm();
						}
					} else if (OtherStatus == 4) {
						if (tradeStatus == 3) {
							sendFrame126("Other player has accepted.", 3535);
						} else if (tradeStatus == 4) {
							ConfirmTrade();
							if (PlayerHandler.players[tradeWith].TradeConfirmed == true) {
								PlayerHandler.players[tradeWith].tradeStatus = 5;
							}
						}
					}
					if (tradeUpdateOther == true) {
						resetOTItems(3416);
						tradeUpdateOther = false;
					}
				}
			} else {
				resetTrade();
			}
		}
		if (WanneTrade == 1) {
			if (WanneTradeWith > PlayerHandler.maxPlayers) {
				resetTrade();
			} else if (PlayerHandler.players[WanneTradeWith] != null) {
				if (GoodDistance2(absX, absY, PlayerHandler.players[WanneTradeWith].absX, PlayerHandler.players[WanneTradeWith].absY ,1) == true) {
					int tt1 = PlayerHandler.players[WanneTradeWith].tradeStatus;
					int tt2 = tradeStatus;

					if (tt1 <= 0 && tt2 <= 0 && PlayerHandler.players[WanneTradeWith].tradeWaitingTime == 0) {
						tradeWith = WanneTradeWith;
						tradeWaitingTime = 40;
						PlayerHandler.players[tradeWith].tradeRequest = playerId;
						sendMessage("Sending trade request...");
                        			faceNPC = 65535;
                        			faceNPCupdate = true;
					} else if (tt1 <= 0 && tt2 <= 0 && PlayerHandler.players[WanneTradeWith].tradeWaitingTime > 0) {
						tradeWith = WanneTradeWith;
						tradeStatus = 1;
						AcceptTrade();
					}
					WanneTrade = 0;
					WanneTradeWith = 0;
				}
			} else {
				resetTrade();
			}
		} 
		if (WanneTrade == 2) {
			try {

			if (WanneTradeWith > PlayerHandler.maxPlayers) {
				resetTrade();
			} else if (PlayerHandler.players[WanneTradeWith] != null) {
				if (GoodDistance2(absX, absY, PlayerHandler.players[WanneTradeWith].absX, PlayerHandler.players[WanneTradeWith].absY ,1) == true) {
					if (PlayerHandler.players[WanneTradeWith].tradeWith == playerId && PlayerHandler.players[WanneTradeWith].tradeWaitingTime > 0) {
						tradeWith = WanneTradeWith;
						tradeStatus = 1;
						AcceptTrade();
					} else {
						tradeWith = WanneTradeWith;
						tradeWaitingTime = 40;
						PlayerHandler.players[tradeWith].tradeRequest = playerId;
						sendMessage("Sending trade request...");
                        			faceNPC = 65535;
                        			faceNPCupdate = true;
					}
					WanneTrade = 0;
					WanneTradeWith = 0;
				}
			} else {
				resetTrade();
			}
		    } catch (Exception e){
			sendMessage("go crash ur own server u ass");
		    }
		}

		if (WanneBank > 0) {
			if (GoodDistance(skillX, skillY, absX, absY, WanneBank) == true) {
				openUpBank();
				WanneBank = 0;
			}
		}
		if (WanneShop > 0) {
			if (GoodDistance(skillX, skillY, absX, absY, 1) == true) {
				openUpShop(WanneShop);
				WanneShop = 0;
			}
		}
		if (WannePickUp == true && IsUsingSkill == false) {
			if (pickUpItem(PickUpID, PickUpAmount) == true) {
				PickUpID = 0;
				PickUpAmount = 0;
				PickUpDelete = 0;
				WannePickUp = false;
			}
		}
		if (IsAttacking == true && IsDead == false) {
			if (PlayerHandler.players[AttackingOn] != null) {
				if (PlayerHandler.players[AttackingOn].IsDead == false) {
					if (!castAuto) {
						PlayerCombat.Attack(this);
					} else {
						Magic M = new Magic(this);
						M.createMagicEvent(this);
					}
				} else {
					ResetAttack();
				}
			} else {
				ResetAttack();
			}
		}
		if (IsAttackingNPC == true && IsDead == false) {
			if (GameEngine.npcHandler.npcs[attacknpc] != null) {
				if (GameEngine.npcHandler.npcs[attacknpc].IsDead == false) {
					if (!castAuto) {
						NpcCombat.AttackNPC(this);
					} else {
						NpcMagic M = new NpcMagic(this);
						M.createMagicEvent(this);
					}
				} else {
					ResetAttackNPC();
				}
			} else {
				ResetAttackNPC();
			}
		}
        	if (playerLevel[3] < 1) {
			IsDead = true;
		}
		if (IsDead) {
			ApplyDead();
		}
		if (NewHP < 136) {
			playerLevel[playerHitpoints] = NewHP;
			setSkillLevel(playerHitpoints, NewHP, playerXP[playerHitpoints]);
			NewHP = playerLevel[3];
		}
		if (prayer[0] > 0) {
			prayer();
		}
		if (NpcWanneTalk == 2) { //Bank Booth
			if (GoodDistance2(absX, absY, skillX, skillY, 1) == true) {
				NpcDialogue = 1;
				NpcTalkTo = GetNPCID(skillX, (skillY - 1));
				NpcWanneTalk = 0;
			}
		} else if (NpcWanneTalk > 0) {
			if (GoodDistance2(absX, absY, skillX, skillY, 2) == true) {
				NpcTalkTo = GetNPCID(skillX, skillY);
				NpcDialogue = NpcWanneTalk;
				NpcWanneTalk = 0;
			}
		}
		if (WalkingTo) {
			if (GoodDistance(absX, absY, destinationX, destinationY, destinationRange)) {
				DoAction();
				ResetWalkTo();
			}
		}
		if (NpcDialogue > 0 && NpcDialogueSend == false) {
			UpdateNPCChat();
		}

		if (isKicked) {
			disconnected = true;
			outStream.createFrame(109);
		}

		if (globalMessage.length() > 0) {
			sendMessage(globalMessage);
			globalMessage = "";
		}
	}
public boolean wingsUp = false;

	public void process() {


flaxTimers();
/*
fletchingProcess();
*/

thievingTimers();

if(playersOnlineTimer > 0) {
playersOnlineTimer --;
}
if(playersOnlineTimer == 0) {
sendQuest("Players Online: "+PlayerHandler.getPlayerCount(), 663);
playersOnlineTimer += 60;
}

   //in-game highscores
    playerLevel[24] = totalz;
if (playerRights >= 2) {
playerRank = 0;
totalz = 0;
}
    
    for (int d = 0; d <= 10; d++) {
        if (totalz >= ranks[d]) {
            if (d == 0) {
                playerRank = d+1;
                ranks[d] = totalz;
                rankPpl[d] = playerName;
		savemoreinfo();
            } else if (d < 10) {
                if (totalz < ranks[d-1]) {
                    playerRank = d+1;
                    ranks[d] = totalz;
                    rankPpl[d] = playerName;
			savemoreinfo();
                }
            } else {
                if (totalz < ranks[d-1]) {
                    playerRank = 0;
			savemoreinfo();
                }
            }
        }
    }
    //end highscores


	      for (int k = 0; k < GameEngine.Rocks; k++) {
		if (GameEngine.RockSPAWN[k] > 0) {
		GameEngine.RockSPAWN[k]--;
		}
		if (GameEngine.RockSPAWN[k] == 0 && GameEngine.RockSLEFT[k] == 0) {
		addGlobalObj(GameEngine.RockX[k], GameEngine.RockY[k], GameEngine.RockID[k], 0, 10);
    		GameEngine.RockSLEFT[k] = Misc.random(GameEngine.RockSS[k] + 1);
		}
		}

		if (Mining) {
			Mineprocess();
		}

	      for (int k = 0; k < GameEngine.Trees; k++) {
		if (GameEngine.TREESPAWN[k] > 0) {
		GameEngine.TREESPAWN[k]--;
		}
		if (GameEngine.TREESPAWN[k] == 0 && GameEngine.LOGSLEFT[k] == 0) {
		addGlobalObj(GameEngine.TREEX[k], GameEngine.TREEY[k], GameEngine.TREEID[k], 0, 10);
    		GameEngine.LOGSLEFT[k] = Misc.random(GameEngine.LOGS[k] + 1);
		}
		}

		if (Woodcutting) {
			WCprocess();
		}


		if(playerEquipment[playerCape] == 16041) {
			if(wingsUp == false) {
				startAnimation(1500);
				wingsUp = true;
				updateRequired = true;
				appearanceUpdateRequired = true;
				playerSE = 1501;
				playerSEW = 1501;
				playerSER = 1501;
				updateRequired = true;
				appearanceUpdateRequired = true;
			}
			if(wingsUp == true) {
				updateRequired = true;
				appearanceUpdateRequired = true;
			}
		} else {
			wingsUp = false;
			updateRequired = true;
			appearanceUpdateRequired = true;
		}
		if ((System.currentTimeMillis() - Update) > 200) {
			Update = System.currentTimeMillis();
			processTimers();
		}
	}

	public boolean packetSending() {
		return PacketHandler.packetProcess(this);
	}

	public boolean pickUpItem(int item, int amount) {
		if (!DataFiles.itemStackable[item] || amount < 1) {
			amount = 1;
		}
		if (freeSlots() > 0 && poimiY == currentY && poimiX == currentX) {
			for (int i=0; i<playerItems.length; i++) {
				if (playerItems[i] == (item+1) && DataFiles.itemStackable[item] && playerItems[i] > 0) {
					playerItems[i] = item+1;

					if ((playerItemsN[i] + amount) < maxItemAmount && (playerItemsN[i] + amount) > 0) {
						playerItemsN[i] += amount;
					} else {
						return false;
					}
					outStream.createFrameVarSizeWord(34);
					outStream.writeWord(3214);
					outStream.writeByte(i);
					outStream.writeWord(playerItems[i]);

					if (playerItemsN[i] > 254) {
						outStream.writeByte(255);
						outStream.writeDWord(playerItemsN[i]);
					} else {
						outStream.writeByte(playerItemsN[i]); //amount
					}
					outStream.endFrameVarSizeWord();
					i=30;
					return true;
				}
			}
	                for (int i=0; i<playerItems.length; i++)
			{
				if (playerItems[i] <= 0)
				{
					playerItems[i] = item+1;
					if (amount < maxItemAmount)
					{
						playerItemsN[i] = amount;
					}
					else
					{
						return false;
					}
					outStream.createFrameVarSizeWord(34);
					outStream.writeWord(3214);
					outStream.writeByte(i);
					outStream.writeWord(playerItems[i]);
					if (playerItemsN[i] > 254)
					{
						outStream.writeByte(255);
						outStream.writeDWord_v2(playerItemsN[i]);
					}
					else
					{
						outStream.writeByte(playerItemsN[i]); //amount
					}
					outStream.endFrameVarSizeWord();
					i=30;
					return true;
				}
			}
			return true;
		}
		else
		{
			return false;
		}
	}
	public void actionReset() {
		actionName = "";
	}

	private int somejunk;
	public int EssenceMineX[] = {2893,2921,2911,2926,2899};
	public int EssenceMineY[] = {4846,4846,4832,4817,4817};
	public int EssenceMineRX[] = {3253,3105,2681,2591};
	public int EssenceMineRY[] = {3401,9571,3325,3086};

	public boolean fullRaVoidEquipped() {
		return playerEquipment[playerHat] == 9009 && playerEquipment[playerChest] == 9013 && playerEquipment[playerLegs] == 9012 && playerEquipment[playerHands] == 9011;
	}
	public boolean fullMeVoidEquipped() {
		return playerEquipment[playerHat] == 9008 && playerEquipment[playerChest] == 9013 && playerEquipment[playerLegs] == 9012 && playerEquipment[playerHands] == 9011;
	}
	public boolean fullMaVoidEquipped() {
		return playerEquipment[playerHat] == 9010 && playerEquipment[playerChest] == 9013 && playerEquipment[playerLegs] == 9012 && playerEquipment[playerHands] == 9011;
	}

	public void appendHit(int hit) {
		LogoutDelay = 20;

		if (hitUpdateRequired) {
			hitDiff2 = hit;
			updateHp(hitDiff2, false);
			hitUpdateRequired2 = true;
			updateRequired = true;
		} else {
			hitDiff = hit;
			updateHp(hitDiff, false);
			hitUpdateRequired = true;
			updateRequired = true;
		}
	}

	public int getCombatDelay() {
		int i = playerEquipment[3];

		if (i == -1) {
			return 8;
		}
		if (i == 15156) {
			return 8;
		}
		if (i == 6563) {
			return 8;
		}
		if (i == 9005) {
			return 6;
		}
		if (i == 4153) {
			return 10;
		}
		if (i == 4734|| i == 19014) {
			return 4;
		}
		if (i == 4755) {
			return 9;
		}
		if (i == 4214 || i == 4212) {
			return 6;
		}
		if (i >= (1291) && i <= (1305)) {
                        return 7;
		}
		if (i >= (1265) && i <= 1275) {
			return 9;
		}
		if (i >= (1337) && i <= (1347)) {
			return 10;
		}
		if (i >= (1365) && i <= (1377)) {
			return 10;
		}
		if (i >= (1307) && i <= (1319) || i == (7158) || i == (11694) || i == (11696) || i == (11698) || i == (11700)  || i == (6609) || i >= (18010) && i <= (18016) || i == (19005) || i == (19004)) {
			return 10;
		}
		if (i >= (3190) && i <= (3204)) {
			return 10;
		}
		if (i == (4151) || i == (11730)) {
			return 7;
		}
		if (i == (4153) || i == (4158) || i == (6528)) {
			return 11;
		}
		if (i >= (6908) && i <= (6915)) {
			return 10;
		}
		if (i == (4718)) {
			return 10;
		}
		if (i == (4718) || i == (4726) || i == (4734) || i == (4755) || i == (4747)) {
			return 8;
		}
		for (int k = 863; k <= 869; k++) {
			if (i == k) {
				return 6;
			}
		}
		for (int k = 841; k <= 861; k++) {
			if (i == k) {
				return 8;
			}
		}
		for (int k = 19048; k <= 19051; k++) {
			if (i == k) {
				return 5;
			}
		}
		for (int k = 19052; k <= 19053; k++) {
			if (i == k) {
				return 8;
			}
		}
		if (i == (1205) || i == (1203) || i == (1207) || i == (1217) || i == (1209) || i == (1211) || i == (1213)
                                    || i == (1215) || i == (1221) || i == (1219) || i == (1223) || i == (1233) 
                                    || i == (1225) || i == (1227) || i == (1229) || i == (1231) || i == (5670) 
                                    || i == (5668) || i == (5672) || i == (5682) || i == (5674) || i == (5676)
                                    || i == (5678) || i == (5680) || i == (5688) || i == (5686) || i == (5690) 
                                    || i == (5700) || i == (5692) || i == (5694) || i == (5696) || i == (5698)
                                    || i == (6525)) {
                        return 6;
		}
		if (i == (1351) || i == (1349) || i == (1353) || i == (1361)  || i == (1355) || i == (1357) || i == (1359) || i == (6739)) {
                        return 11;
		}
		if (i == (1422) || i == (1420) || i == (1424) || i == (1426) || i == (1428) || i == (1430) || i == (1432)
				|| i == (1434)  || i == (6527)) { 
			return 8;
		} 
		if (i == (1277) || i == (1279) || i == (1281) || i == (1283) || i == (1285) || i == (1287) || i == (1289)) {
			return 10;
		}
		if (i == (1321) || i == (1323) || i == (1325) || i == (1327) || i == (1329) || i == (1331) || i == (1333)
				|| i == (4587)) {
                        return 6;
		}
		if (i == (1237) || i == (1239) || i == (1241) || i == (4580) || i == (1243) || i == (1245) || i == (1247) 
                                || i == (1249) || i == (1251) || i == (1253) || i == (1255) || i == (4582) || i == (1257)
                                || i == (1259) || i == (1261) || i == (1263) || i == (5704) || i == (5706) || i == (5708)
                                || i == (5734) || i == (5710) || i == (5712) || i == (5714) || i == (5716) || i == (5718) 
                                || i == (5720) || i == (5722) || i == (5736) || i == (5724) || i == (5726) || i == (5728) 
                                || i == (5730)) {
			return 10;
		}
		if (i == (84) || i == (772) || i >= (1379) && i <= (1409) || i >= (2415) && i <= (2416) || i == (3053) 
                                    || i == (3054) || i == (4170)  || i == (4675) || i == (4710) || i == (6526)) { 
			return 8;
		}
		if (i >= (6908) && i <= (6915)) {
			return 6;
		}
		if (i == (4718)) {
			return 6;
		}
		if (i == (4718) || i == (4726) || i == (4734) || i == (4755) || i == (4747)) {
			return 7;
		}
		if (i == (6523) || i == (19047)) {
			return 6;
		}
		if (i == (14484)) {
			return 7;
		}
		return 4;
	}

	public boolean ResetAttack() {
		IsAttacking = false;
		attackingPlayerId = 0;
		faceNPC = 65535;
		faceNPCupdate = true;
		followPlayer = null;
		resetAnimation();
		IsUsingSkill = false;
                pEmote = playerSE;
		setMagicPlayer(false);
		return true;
	}

	public int lnew = 0;
	public int otherpkps = 0;
	public int otherkillc = 0;

	private void appendSetFocusDestination(Stream str) {
		str.writeWordBigEndianA(FocusPointX);
		str.writeWordBigEndian(FocusPointY);
	}

	public void CheckDrop() {
		keepItem1();
		keepItem2();
		keepItem3();
		deleteItem(keepItem, getItemSlot(keepItem), keepItemAmount);
		deleteItem(keepItem2, getItemSlot(keepItem2), keepItemAmount2);
		deleteItem(keepItem3, getItemSlot(keepItem3), keepItemAmount3);
		youdied();
	}

	public boolean ApplyDead() {
	inCombat();
		if (IsDeadTimer == false) {
			actionAmount++;
			deathTimer = 10;
			ResetAttack();
			ResetAttackNPC();
			freezeDelay = 0;
			IsDeadTimer = true;
                        ApplyDead();
			specs();
		}
		if (deathTimer == 7 && IsDeadTimer == true) {
			startAnimation(836);
			updateRequired = true;
			appearanceUpdateRequired = true;
		}
		if (deathTimer <= 0 && IsDeadTimer == true) {
			if (duelStatus == 3) {
				if (GameEngine.playerHandler.players[duelWith] != null) {
					clientHandler client1 = (clientHandler)GameEngine.playerHandler.players[duelWith];
					client1.DuelVictory();
				}
			}
			
			if (!duelArea() && !IsInFightCave() && !abyssalRift() && !castleWars()) {
				resetPrayer();
				if (headIconPk != 1) {
					keepItemHandle();
				}

				if (protItem) {
					applyProtectItemProt();
				}
                        	deleteItem(keepItem, getItemSlot(keepItem), keepItemAmount);
                        	deleteItem(keepItem2, getItemSlot(keepItem2), keepItemAmount2);
                        	deleteItem(keepItem3, getItemSlot(keepItem3), keepItemAmount3);
				youdied();
				killMyNPCs();
				teleportToX = 2441;
				teleportToY = 3091;
				heightLevel = 0;
			}
			if (IsInFightCave()) {
				specialAmount = 100;
				heightLevel = 0;
				specs();
				teleportTo(2438, 5168, 0, 0, -1, -1, -1, 0, 0);
				sendMessage("Oh dear you are dead!");
			}
			if (abyssalRift()) {
				specialAmount = 100;
				heightLevel = 0;
				specs();
				teleportTo(2441, 3091, 0, 0, -1, -1, -1, 0, 0);
				sendMessage("Oh dear you are dead!");
			}
			if (duelStatus == 3 || duelArea()) {
				specialAmount = 100;

				if (isSpecWeapon(playerEquipment[3])) {
					l33thax(12323);
					l33thax(7574);
					l33thax(7599);
					l33thax(7549);
					l33thax(8493);
					l33thax(7499);
				} else {
					Frame171(12323, 1);
					Frame171(7574, 1);
					Frame171(7599, 1);
					Frame171(7549, 1);
					Frame171(8493, 1);
					Frame171(7499, 1);
				}
				specs();
				sendMessage("Oh dear you lost the duel!");
				int i = Misc.random(dSpotX.length - 1);
				teleportToX = dSpotX[i];
				teleportToY = dSpotY[i];
				updateRequired = true;
				appearanceUpdateRequired = true;
			}
			sendMessage("Oh dear you are dead!");
			IsDeadTeleporting = true;
			frame1();
			skullTimer = -1;
			IsDeadTimer = false;
			updateRequired = true;
			appearanceUpdateRequired = true;
                        NewHP = getLevelForXP(playerXP[3]);
                        setSkillLevel(3, getLevelForXP(playerXP[3]), playerXP[playerHitpoints]);
                        playerLevel[3] = getLevelForXP(playerXP[3]);
                        playerLevel[5] = getLevelForXP(playerXP[5]);
                        setSkillLevel(5, getLevelForXP(playerXP[5]), playerXP[5]);
                        refreshSkills();
                        PoisonDelay = 9999999;
                        KillerId = playerId;

			if (itemKept1 > 0) {
				addItem(itemKept1, 1);
			}
			if (itemKept2 > 0) {
 				addItem(itemKept2, 1);
			}
			if (itemKept3 > 0) {
				addItem(itemKept3, 1);
			}
			if (itemKept4 > 0) {
				addItem(itemKept4, 1);
			}
			duelStatus = -1;
			resetDuel();
                        resetKeepItem();
			IsDead = false;
		}
		return true;
	}

	public int keepItem = 0;
	public int keepItem2 = 0;
	public int keepItem3 = 0;
	public int keepItemAmount = 0;
	public int keepItemAmount2 = 0;
	public int keepItemAmount3 = 0;

	public void setSkillLevel(int skillNum, int currentLevel, int XP) {
		if (skillNum == 0) {
			sendQuest(""+playerLevel[0]+"", 4004);
			sendQuest(""+getLevelForXP(playerXP[0])+"", 4005);
		}
		if (skillNum == 2) {
			sendQuest(""+playerLevel[2]+"", 4006);
			sendQuest(""+getLevelForXP(playerXP[2])+"", 4007);
		}
		if (skillNum == 1) {
			sendQuest(""+playerLevel[1]+"", 4008);
			sendQuest(""+getLevelForXP(playerXP[1])+"", 4009);
		}
		if (skillNum == 4) {
			sendQuest(""+playerLevel[4]+"", 4010);
			sendQuest(""+getLevelForXP(playerXP[4])+"", 4011);
		}
		if (skillNum == 5) {
			sendQuest(""+playerLevel[5]+"", 4012);
			sendQuest(""+getLevelForXP(playerXP[5])+"", 4013);
		}
		if (skillNum == 6) {
			sendQuest(""+playerLevel[6]+"", 4014);
			sendQuest(""+getLevelForXP(playerXP[6])+"", 4015);
		}
		if (skillNum == 3) {
			sendQuest(""+playerLevel[3]+"", 4016);
			sendQuest(""+getLevelForXP(playerXP[3])+"", 4017);
		}
		if (skillNum == 16) {
			sendQuest(""+playerLevel[16]+"", 4018);
			sendQuest(""+getLevelForXP(playerXP[16])+"", 4019);
		}
		if (skillNum == 15) {
			sendQuest(""+playerLevel[15]+"", 4020);
			sendQuest(""+getLevelForXP(playerXP[15])+"", 4021);
		}
		if (skillNum == 17) {
			sendQuest(""+playerLevel[17]+"", 4022);
			sendQuest(""+getLevelForXP(playerXP[17])+"", 4023);
		}
		if (skillNum == 12) {
			sendQuest(""+playerLevel[12]+"", 4024);
			sendQuest(""+getLevelForXP(playerXP[12])+"", 4025);
		}
		if (skillNum == 9) {
			sendQuest(""+playerLevel[9]+"", 4026);
			sendQuest(""+getLevelForXP(playerXP[9])+"", 4027);
		}
		if (skillNum == 14) {
			sendQuest(""+playerLevel[14]+"", 4028);
			sendQuest(""+getLevelForXP(playerXP[14])+"", 4029);
		}
		if (skillNum == 13) {
			sendQuest(""+playerLevel[13]+"", 4030);
			sendQuest(""+getLevelForXP(playerXP[13])+"", 4031);
		}
		if (skillNum == 10) {
			sendQuest(""+playerLevel[10]+"", 4032);
			sendQuest(""+getLevelForXP(playerXP[10])+"", 4033);
		}
		if (skillNum == 7) {
			sendQuest(""+playerLevel[7]+"", 4034);
			sendQuest(""+getLevelForXP(playerXP[7])+"", 4035);
		}
		if (skillNum == 11) {
			sendQuest(""+playerLevel[11]+"", 4036);
			sendQuest(""+getLevelForXP(playerXP[11])+"", 4037);
		}
		if (skillNum == 8) {
			sendQuest(""+playerLevel[8]+"", 4038);
			sendQuest(""+getLevelForXP(playerXP[8])+"", 4039);
		}
		if (skillNum == 20) {
			sendQuest(""+playerLevel[20]+"", 4152);
			sendQuest(""+getLevelForXP(playerXP[20])+"", 4153);
		}
		if (skillNum == 18) {
			sendQuest(""+playerLevel[18]+"", 12166);
			sendQuest(""+getLevelForXP(playerXP[18])+"", 12167);
		}
		if (skillNum == 19) {
			sendQuest(""+playerLevel[19]+"", 13926);
			sendQuest(""+getLevelForXP(playerXP[19])+"", 13927);
		} else {
			outStream.createFrame(134);
			outStream.writeByte(skillNum);
			outStream.writeDWord_v1(XP);
			outStream.writeByte(currentLevel);
		}
	}

    public void keepItem1()
    {
        int i = 0;
        for(int j = 0; j < playerItems.length; j++)
        {
            int l = (int)getItemValue(playerItems[j] - 1);
            if(l > i && playerItems[j] - 1 != 0)
            {
                i = l;
                itemKept1 = playerItems[j] - 1;
                itemKept1Slot = j;
                itemSlot1 = true;
            }
        }

        for(int k = 0; k < playerEquipment.length; k++)
        {
            int i1 = (int)Math.floor(getItemValue(playerEquipment[k]));
            if(i1 > i && playerEquipment[k] != -1)
            {
                i = i1;
                itemKept1 = playerEquipment[k];
                itemKept1Slot = k;
                itemSlot1 = false;
            }
        }

    }

    public void keepItem2()
    {
        int i = 0;
        for(int j = 0; j < playerItems.length; j++)
        {
            if(itemKept1Slot == j && itemSlot1)
                continue;
            int l = (int)getItemValue(playerItems[j] - 1);
            if(l > i && playerItems[j] - 1 != 0)
            {
                i = l;
                itemKept2 = playerItems[j] - 1;
                itemKept2Slot = j;
                itemSlot2 = true;
            }
        }

        for(int k = 0; k < playerEquipment.length; k++)
        {
            if(itemKept1Slot == k && !itemSlot1)
                continue;
            int i1 = (int)getItemValue(playerEquipment[k]);
            if(i1 > i && playerEquipment[k] != -1)
            {
                i = i1;
                itemKept2 = playerEquipment[k];
                itemKept2Slot = k;
                itemSlot2 = false;
            }
        }

    }

    public void keepItem3()
    {
        int i = 0;
        for(int j = 0; j < playerItems.length; j++)
        {
            if(itemKept1Slot == j && itemSlot1 || itemKept2Slot == j && itemSlot2)
                continue;
            int l = (int)getItemValue(playerItems[j] - 1);
            if(l > i && playerItems[j] - 1 != 0)
            {
                i = l;
                itemKept3 = playerItems[j] - 1;
                itemKept3Slot = j;
                itemSlot3 = true;
            }
        }

        for(int k = 0; k < playerEquipment.length; k++)
        {
            if(itemKept1Slot == k && !itemSlot1 || itemKept2Slot == k && !itemSlot2)
                continue;
            int i1 = (int)Math.floor(getItemValue(playerEquipment[k]));
            if(i1 > i && playerEquipment[k] != -1)
            {
                i = i1;
                itemKept3 = playerEquipment[k];
                itemKept3Slot = k;
                itemSlot3 = false;
            }
        }

    }

    public void keepItem4()
    {
        int i = 0;
        for(int j = 0; j < playerItems.length; j++)
        {
            if(itemKept1Slot == j && itemSlot1 || itemKept2Slot == j && itemSlot2 || itemKept3Slot == j && itemSlot3)
                continue;
            int l = (int)getItemValue(playerItems[j] - 1);
            if(l > i && playerItems[j] - 1 != 0)
            {
                i = l;
                itemKept4 = playerItems[j] - 1;
                itemKept4Slot = j;
                itemSlot4 = true;
            }
        }

        for(int k = 0; k < playerEquipment.length; k++)
        {
            if(itemKept1Slot == k && !itemSlot1 || itemKept2Slot == k && !itemSlot2 || itemKept3Slot == k && !itemSlot3)
                continue;
            int i1 = (int)getItemValue(playerEquipment[k]);
            if(i1 > i && playerEquipment[k] != -1)
            {
                i = i1;
                itemKept4 = playerEquipment[k];
                itemKept4Slot = k;
                itemSlot4 = false;
            }
        }

    }

    public void resetKeepItem()
    {
        itemKept1 = itemKept2 = itemKept3 = itemKept4 = -1;
        itemKept1Slot = itemKept2Slot = itemKept3Slot = itemKept4Slot = -1;
    }

    public void keepItemHandle()
    {
        keepItem1();
        keepItem2();
        keepItem3();
        if(itemKept1 > 0)
            if(itemSlot1)
                deleteItem(itemKept1, itemKept1Slot, 1);
            else
            if(!itemSlot1)
                deleteEquipment(itemKept1Slot);
        if(itemKept2 > 0)
            if(itemSlot2)
                deleteItem(itemKept2, itemKept2Slot, 1);
            else
            if(!itemSlot2)
                deleteEquipment(itemKept2Slot);
        if(itemKept3 > 0)
            if(itemSlot3)
                deleteItem(itemKept3, itemKept3Slot, 1);
            else
            if(!itemSlot3)
                deleteEquipment(itemKept3Slot);
    }

    public void applyProtectItemProt()
    {
        keepItem4();
        if(itemKept4 > 0)
            if(itemSlot4)
                deleteItem(itemKept4, itemKept4Slot, 1);
            else
            if(!itemSlot4)
                deleteEquipment(itemKept4Slot);
    }

	public boolean CheckForSkillUse3(int Item, int Slot) {
		goOn = true;

       		Potions = new Potions();
        	Potions.CheckForSkillUse3(Item, Slot, playerId);

		switch (Item) {

			case 4707:
				histBook1();
			break;

			case 199: case 201: case 203:
			case 205: case 207: case 209:
			case 211: case 213: case 215:
			case 217: case 219:
				getHerblore().cleanHerbs(this, Item, Slot);
			break;

			case 952:
				startAnimation(2843);

				if (Barrows.digMound(this)) {
					break;
				}
				if(absX == 2460 && absY == 3096) {
							teleportToX = 1752;
							teleportToY = 5137;
					break;
				}
				sendMessage("You find nothing.");
				break;

			case 2528:
                                deleteItem(2528, GetItemSlot(2528), 1);
                                showInterface(2808);
                                break;

			case 1891:
				eatFood2(Item, Slot, 4, 1893);
				break;
			case 1893:
				eatFood2(Item, Slot, 4, 1895);
				break;
			case 1895:
				eatFood(Item, Slot, 4);
				break;
			case 343:
				eatFood(Item, Slot, 7);
				break;
			case 2323:
				eatFood2(Item, Slot, 7, 2335);
				break;
			case 2335:
				eatFood(Item, Slot, 7);
				break;
			case 2309:
				eatFood(Item, Slot, 3);
				break;
			case 1901:
				eatFood(Item, Slot, 5);
				break;
			case 7198:
				eatFood2(Item, Slot, 8, 7200);
				break;
			case 7200:
				eatFood(Item, Slot, 8);
				break;
			case 7218:
				eatFood2(Item, Slot, 11, 7220);
				break;
			case 7220:
				eatFood(Item, Slot, 11);
				break;
			case 315:
				eatFood(Item, Slot, 3);
				break;
			case 319:
				eatFood(Item, Slot, 1);
				break;
			case 325:
				eatFood(Item, Slot, 4);
				break;
			case 329:
				eatFood(Item, Slot, 9);
				break;
			case 333:
				eatFood(Item, Slot, 7);
				break;
			case 339:
				eatFood(Item, Slot, 7);
				break;
			case 347:
				eatFood(Item, Slot, 5);
				break;
			case 351:
				eatFood(Item, Slot, 8);
				break;
			case 355:
				eatFood(Item, Slot, 6);
				break;
			case 2289:
				eatFood2(Item, Slot, 7, 2291);
				break;
			case 2291:
				eatFood(Item, Slot, 7);
				break;
			case 361:
				eatFood(Item, Slot, 10);
				break;
			case 365:
				eatFood(Item, Slot, 13);
				break;
			case 1965:
			case 1967:
				eatFood(Item, Slot, 2);
				break;
			case 373:
				eatFood(Item, Slot, 14);
				break;
			case 379:
				eatFood(Item, Slot, 12);
				break;
			case 1917:
				eatFood(Item, Slot, 2);
				sendMessage("You feel a little dizzy.");
				break;
			case 385:
				eatFood(Item, Slot, 20);
				break;
			case 391:
				eatFood(Item, Slot, 22);
				break;
			case 397:
				eatFood(Item, Slot, 21);
				break;
			case 7946:
				eatFood(Item, Slot, 16);
				break;
			case 1961:
				eatFood(Item, Slot, 99);
				break;
			case 534: //Baby Blue Dragon Bones
				boneBury(30);
				break;
			case 536: //Dragon Bones
				boneBury(1500);
				break;
			case 526: //Bones
			case 528: //Burnt Bones
			case 2859: //Wolf Bones
				boneBury(150);
				break;
			case 530: //Bat Bones
				boneBury(150);
				break;
			case 532: //Big Bones
			case 3125: //Jogre Bones
				boneBury(500);
				break;
			case 3179: //Monkey Bones
				boneBury(5);
				break;
			case 4812: //Zogre Bones
				boneBury(750);
				break;
			case 4830: //Fayrg Bones
				boneBury(1600);
				break;
			case 4832: //Raurg Bones
				boneBury(1900);
				break;
			case 1505: //scroll
			if(!Wild()) {
				if(!inBarrows()) {
					if (inCombat > 0) {
						sendMessage("You cannot use bank scrolls while in combat!");
					} else if(inCombat == 0) {
					openUpBank();
					deleteItem(1505, GetItemSlot(1505), 1);
					}
				} else {
					sendMessage("You can't use that in Barrows!");
				}
			} else {
				sendMessage("You can't use that in the wilderness!");
			}
			break;

			case 6866: //green marionette
				startAnimation(3003);
				gfx0(515);
            		break;
			case 6867: //red marionette
				startAnimation(3003);
				gfx0(507);
            		break;

			case 6865: //blue marionette
				startAnimation(3003);
				gfx0(511);
            		break;

			case 299: //Mith seeds
				int randFlower = Misc.random(8);
				if(randFlower == 0) {
					createObject(absX, absY, 2980, 0, 10);
				}
				if(randFlower == 1) {
					createObject(absX, absY, 2981, 0, 10);
				}
				if(randFlower == 2) {
					createObject(absX, absY, 2982, 0, 10);
				}
				if(randFlower == 3) {
					createObject(absX, absY, 2983, 0, 10);
				}
				if(randFlower == 4) {
					createObject(absX, absY, 2984, 0, 10);
				}
				if(randFlower == 5) {
					createObject(absX, absY, 2985, 0, 10);
				}
				if(randFlower == 6) {
					createObject(absX, absY, 2986, 0, 10);
				}
				if(randFlower == 7) {
					createObject(absX, absY, 2987, 0, 10);
				}
				if(randFlower == 8) {
					createObject(absX, absY, 2988, 0, 10);
				}
            		break;
			case 4834: //Ourg Bones
				boneBury(2500);
				break;


			default:
				//sendMessage("Nothing interesting is happening.");
				println_debug("Prayer Usage - ItemID: "+Item);
				goOn = false;
				break;
		}
		if (goOn == false) {
			return false;
		}
		if (prayer[2] > 0) {
			prayer[0] = 1;
			prayer[4] = Item;
			prayer[5] = Slot;
		}
		return true;
	}

	public void boneBury(int exp) {
		if (System.currentTimeMillis() - buryDelay > 1000) {
			buryDelay = System.currentTimeMillis();
			prayer[2] = exp;
			setAnimation(827);
			frame174(380, 000, 000);
			updateRequired = true;
			appearanceUpdateRequired = true;
		}
	}

	public long buryDelay;

	public boolean IsItemInBag(int ItemID) {
		for (int i = 0; i < playerItems.length; i++) {
			if ((playerItems[i] - 1) == ItemID) {
				return true;
			}
		}
		return false;
	}
	public boolean AreXItemsInBag(int ItemID, int Amount) {
		int ItemCount = 0;
		for (int i = 0; i < playerItems.length; i++) {
			if ((playerItems[i] - 1) == ItemID) {
				ItemCount++;
			}
			if (ItemCount == Amount) {
				return true;
			}
		}
		return false;
	}
	public int GetItemSlot(int ItemID) {
		for (int i = 0; i < playerItems.length; i++) {
			if ((playerItems[i] - 1) == ItemID) {
				return i;
			}
		}
		return -1;
	}

    public int GetWepAnim() {
        if (playerEquipment[playerWeapon] == -1) { // unarmed
            if (FightType == 2) {
                return 423;
            } else {
                return 422;
            }
        }
	for (int i = 864; i <= 868; i++) {
		if (playerEquipment[playerWeapon] == i) {
			return 806;
		}
	}        
        if (playerEquipment[playerWeapon] == 1215 || playerEquipment[playerWeapon] == 1231 || playerEquipment[playerWeapon] == 5680) {
            return 376;
        }

		if(playerEquipment[playerWeapon] == 7671 || playerEquipment[playerWeapon] == 7673) // boxing gloves
		{
			return 3678;
		}

        	if (playerEquipment[playerWeapon] == 10887) {
	    if (!usingSpecial) {
		return 5865;
	    } else {
		return 5870;
	    }
        	}
        if (playerEquipment[playerWeapon] == 5698) {
	    if (!usingSpecial) {
		return 376;
	    } else {
		return 0x426;
	    }
	}
        if (playerEquipment[playerWeapon] == 1434) {
	    if (!usingSpecial) {
            	return 401;
	    } else {
		return 1060;
	    }
        }
        if (playerEquipment[playerWeapon] == 4153 || playerEquipment[playerWeapon] == 19046) {
	    if (!usingSpecial) {
            	return 1665;
	    } else {
		return 1667;
	    }
        }
        if (playerEquipment[playerWeapon] == 1307
	 || playerEquipment[playerWeapon] == 1309
	 || playerEquipment[playerWeapon] == 1311
	 || playerEquipment[playerWeapon] == 1313
	 || playerEquipment[playerWeapon] == 1315
	 || playerEquipment[playerWeapon] == 1317
	 || playerEquipment[playerWeapon] == 1319
	 || playerEquipment[playerWeapon] == 7158
	 || playerEquipment[playerWeapon] == 11730
	 || playerEquipment[playerWeapon] == 11694
	 || playerEquipment[playerWeapon] == 11696
	 || playerEquipment[playerWeapon] == 19022
	 || playerEquipment[playerWeapon] == 19021
	 || playerEquipment[playerWeapon] == 19047
	 || playerEquipment[playerWeapon] == 18010
	 || playerEquipment[playerWeapon] == 18012
	 || playerEquipment[playerWeapon] == 18014
	 || playerEquipment[playerWeapon] == 18016
	 || playerEquipment[playerWeapon] == 6609
	 || playerEquipment[playerWeapon] == 11698
	 || playerEquipment[playerWeapon] == 11700
	 || playerEquipment[playerWeapon] == 19004) {
            return 407;
        }
        if (playerEquipment[playerWeapon] == 4151) {
            return 1658;
        }

		if(playerEquipment[playerWeapon] == 14484)
		{
			return 2068;
		}
        if (playerEquipment[playerWeapon] == 4214
                || playerEquipment[playerWeapon] == 859
                || playerEquipment[playerWeapon] == 7622
                || playerEquipment[playerWeapon] == 861
                || playerEquipment[playerWeapon] == 4212
                || playerEquipment[playerWeapon] == 839
                || playerEquipment[playerWeapon] == 841
                || playerEquipment[playerWeapon] == 843
                || playerEquipment[playerWeapon] == 845
                || playerEquipment[playerWeapon] == 847
                || playerEquipment[playerWeapon] == 849
                || playerEquipment[playerWeapon] == 851
                || playerEquipment[playerWeapon] == 853
                || playerEquipment[playerWeapon] == 855
                || playerEquipment[playerWeapon] == 857
                || playerEquipment[playerWeapon] == 6724
                || playerEquipment[playerWeapon] == 15156
                || playerEquipment[playerWeapon] == 19014
                || playerEquipment[playerWeapon] == 19048
                || playerEquipment[playerWeapon] == 19049
                || playerEquipment[playerWeapon] == 19050
                || playerEquipment[playerWeapon] == 19051
                || playerEquipment[playerWeapon] == 19052
                || playerEquipment[playerWeapon] == 19053) {
            return 426;
        }
        if (playerEquipment[playerWeapon] == 4675
                || playerEquipment[playerWeapon] == 84
                || playerEquipment[playerWeapon] == 772
                || playerEquipment[playerWeapon] == 1379
                || playerEquipment[playerWeapon] == 1381
                || playerEquipment[playerWeapon] == 1383
                || playerEquipment[playerWeapon] == 1385
                || playerEquipment[playerWeapon] == 1385
                || playerEquipment[playerWeapon] == 1387
                || playerEquipment[playerWeapon] == 1389
                || playerEquipment[playerWeapon] == 1393
                || playerEquipment[playerWeapon] == 1395
                || playerEquipment[playerWeapon] == 1397
                || playerEquipment[playerWeapon] == 1399
                || playerEquipment[playerWeapon] == 1401
                || playerEquipment[playerWeapon] == 1403
                || playerEquipment[playerWeapon] == 1405
                || playerEquipment[playerWeapon] == 1407
                || playerEquipment[playerWeapon] == 1409
                || playerEquipment[playerWeapon] == 3053
                || playerEquipment[playerWeapon] == 3054
                || playerEquipment[playerWeapon] == 4170
                || playerEquipment[playerWeapon] == 6603
                || playerEquipment[playerWeapon] == 6726
                || playerEquipment[playerWeapon] == 6727) {
            return 429;
        }
        if (playerEquipment[playerWeapon] == 1377) {
            return 1833;
        }
        if (playerEquipment[playerWeapon] == 4718) {
            if (FightType == 2) {
                return 2066;
            } else {
                return 2067;
            }
        }
        if (playerEquipment[playerWeapon] == 4726) {
            return 2080;
        }
        if (playerEquipment[playerWeapon] == 4747) {
            return 2068;
        }
        if (playerEquipment[playerWeapon] == 4755) {
            return 2062;
        }
        if (playerEquipment[playerWeapon] == 4734) {
            return 2075;
        }
        if (playerEquipment[playerWeapon] == 6522) {
            return 3353;
        }
        if (playerEquipment[playerWeapon] == 7668) {
            return 1665;
        }
        if (playerEquipment[playerWeapon] == 7449) {
            return 1665;
        }
        if (playerEquipment[playerWeapon] == 837) {
            return 1084;
        }
        if (playerEquipment[playerWeapon] == 6528) {
            return 2661;
        }
        if (playerEquipment[playerWeapon] == 6817) {
            return 1665;
        }
        if (playerEquipment[playerWeapon] == 1249
                || playerEquipment[playerWeapon] == 1263
                || playerEquipment[playerWeapon] == 3176
                || playerEquipment[playerWeapon] == 5716
                || playerEquipment[playerWeapon] == 5730) {
            return 427;
        }
        if (playerEquipment[playerWeapon] == 3204 || playerEquipment[playerWeapon] == 3196) {
            return 440;
        }
        if (playerEquipment[playerWeapon] == 1305) {
	    if (!usingSpecial) {
            	return 451;
	    } else {
		return 1058;
	    }
        }
        if (playerEquipment[playerWeapon] == 1419) {
            return 408;
        }
        if (playerEquipment[playerWeapon] == 19005) {
            return 2081;
        }
        if (playerEquipment[playerWeapon] == 7807) {
            return 2876;
        }
        if (playerEquipment[playerWeapon] == 81391) {
            return 422;
        }
        if (playerEquipment[playerWeapon] == 4675
                || playerEquipment[playerWeapon] == 84
                || playerEquipment[playerWeapon] == 772
                || playerEquipment[playerWeapon] == 1379
                || playerEquipment[playerWeapon] == 1381
                || playerEquipment[playerWeapon] == 1383
                || playerEquipment[playerWeapon] == 1385
                || playerEquipment[playerWeapon] == 1385
                || playerEquipment[playerWeapon] == 1387
                || playerEquipment[playerWeapon] == 1389
                || playerEquipment[playerWeapon] == 1393
                || playerEquipment[playerWeapon] == 1395
                || playerEquipment[playerWeapon] == 1397
                || playerEquipment[playerWeapon] == 1399
                || playerEquipment[playerWeapon] == 1401
                || playerEquipment[playerWeapon] == 1403
                || playerEquipment[playerWeapon] == 1405
                || playerEquipment[playerWeapon] == 1407
                || playerEquipment[playerWeapon] == 1409
                || playerEquipment[playerWeapon] == 3053
                || playerEquipment[playerWeapon] == 3054
                || playerEquipment[playerWeapon] == 4170
                || playerEquipment[playerWeapon] == 6603
                || playerEquipment[playerWeapon] == 6726
                || playerEquipment[playerWeapon] == 6727
                || playerEquipment[playerWeapon] == 6727)  {
            return 806;
        }
	if(playerEquipment[playerWeapon] == -1) {
            return 451;
	}

        if (playerEquipment[playerWeapon] == 7806
                || playerEquipment[playerWeapon] == 6609
                || playerEquipment[playerWeapon] == 7808
                || playerEquipment[playerWeapon] == 8027
                || playerEquipment[playerWeapon] == 8027
                || playerEquipment[playerWeapon] == 8025
                || playerEquipment[playerWeapon] == 8036
                || playerEquipment[playerWeapon] == 8059
                || playerEquipment[playerWeapon] == 1315
                || playerEquipment[playerWeapon] == 1317
                || playerEquipment[playerWeapon] == 1319) {
            return 407;
        } else {
            return 451;
        }
    }

	public int GetRunAnim(int id) {
        	if (id == 4151) {
            		return 1661;
        	}

		if(id == 7671 || id == 7673) // boxing gloves
		{
			return 3680;
		}

        	if (id == 10887) {
            		return 5868;
        	}

        if (id == 1307
	 || id == 1309
	 || id == 1311
	 || id == 1313
	 || id == 1315
	 || id == 1317
	 || id == 1319
	 || id == 7158
	 || id == 19022
	 || id == 19021
	 || id == 19047
	 || id == 11730
	 || id == 11694
	 || id == 11696
	 || id == 18010
	 || id == 18012
	 || id == 18014
	 || id == 18016
	 || id == 11698
	 || id == 6609
	 || id == 11700
	 || id == 19004) {
            return 1132;
        }
        	if (id == 4734) {
            		return 2077;
        	}
        	if (id == 4755) {
            		return 1660;
        	}
        	if (id == 4718 || id == 1319 || id == 19005) {
            		return 2563;
        	}
        	if (id == 4734) {
            		return 2076;
        	}
        	if (id == 4039 || id == 7639|| id == 1379
                	|| id == 3204 || id == 1381 || id == 1383 || id == 1385
                	|| id == 1387 || id == 1389 || id == 1391 || id == 1393
                	|| id == 1395 || id == 1397 || id == 1399 || id == 1401
                	|| id == 1403 || id == 145 || id == 1407 || id == 1409
                 	|| id == 3053 || id == 3054 || id == 4170 || id == 4675
                	|| id == 4710 || id == 6526 || id == 4726 || id == 6562
                	|| id == 6563 || id == 6914 || id == 772 || id == 1305 || id == 19046 || id == 19052 || id == 19053 || id == 3196) {
            		return 1210;
        	}
        	if (id == -1) {
            		return 0x338;
        	}
        	if (id == 4153) {
            		return 1664;
        	} else {
            		return 0x338;
        	}
	}

	public int GetWalkAnim(int id) {
        	if (id == 4718|| id == 19005) {
            		return 2064;
        	}


		if(id == 7671 || id == 7673) // boxing gloves
		{
			return 3680;
		}
        	if (id == 10887) {
            		return 5867;
        	}
        	if (id == 1305 || id == 19046 || id == 19052 || id == 19053) {
            		return 1205;
        	}

        if (id == 1307
	 || id == 1309
	 || id == 1311
	 || id == 1313
	 || id == 1315
	 || id == 1317
	 || id == 1319
	 || id == 7158
	 || id == 6609
	 || id == 11730
	 || id == 11694
	 || id == 11696
	 || id == 18010
	 || id == 19022
	 || id == 19021
	 || id == 19047
	 || id == 18012
	 || id == 18014
	 || id == 18016
	 || id == 11698
	 || id == 11700
	 || id == 19004) {
            return 1130;
        }
        	if (id == 4151) {
            		return 1660;
        	}
        	if (id == -1) {
            		return 0x333;
        	}
        	if (id == 4755) {
            		return 1660;
        	}
        	if (id == 4734) {
            		return 2076;
        	}
       		if (id == 4153) {
           		return 1663;
        	}
       		if (id == -1) {
           		return 0x333;
        	}
        	if (id == 4039 || id == 7639|| id == 7153 || id == 1379
                		|| id == 3204 || id == 1381 || id == 1383 || id == 1385
                		|| id == 1387 || id == 1389 || id == 1391 || id == 1393
                		|| id == 1395 || id == 1397 || id == 1399 || id == 1401
                		|| id == 1403 || id == 145 || id == 1407 || id == 1409
                		|| id == 3053 || id == 3054 || id == 4170 || id == 4675
                		|| id == 4710 || id == 6526 || id == 4726 || id == 6562
				|| id == 6563 || id == 6914 || id == 772 || id == 3196) {
            		return 1146;
        	} else {
            		return 0x333;
        	}
    	}

	public int GetStandAnim(int id) {

        if (id == 1307
	 || id == 1309
	 || id == 1311
	 || id == 1313
	 || id == 6609
	 || id == 1315
	 || id == 1317
	 || id == 1319
	 || id == 7158
	 || id == 11730
	 || id == 11694
	 || id == 11696
	 || id == 19022
	 || id == 19021
	 || id == 19047
	 || id == 18010
	 || id == 18012
	 || id == 18014
	 || id == 18016
	 || id == 11698
	 || id == 11700
	 || id == 19004) {
            		return 1131;
        	}
		if(id == 7671 || id == 7673) // boxing gloves
		{
			return 3677;
		}
        	if (id == 10887) {
            		return 5869;
        	}
        	if (id == 15241) {
            		return 4014;
        	}
        	if (id == 4718) {
            		return 2065;
        	}
        	if (id == -1) {
            		return 0x328;
        	}
        	if (id == 4755) {
            		return 2061;
        	}
        	if (id == 4734) {
            		return 2074;
        	}
        	if (id == 4153) {
            		return 1662;
        	}

        	if (id == 19005) {
            		return 2065;
        	}
        	if (id == 19004) {
            		return 1131;
        	}
        	if (id == 4039 || id == 7639|| id == 1305 || id == 19046 || id == 19052 || id == 19053
                	|| id == 1379 || id == 3204 || id == 1381 || id == 1383
                	|| id == 1385 || id == 1387 || id == 1389 || id == 1391
                	|| id == 1393 || id == 1395 || id == 1397 || id == 1399
                	|| id == 1401 || id == 1403 || id == 145 || id == 1407
                	|| id == 1409 || id == 3053 || id == 3054 || id == 4170
                	|| id == 4675 || id == 4710 || id == 6526 || id == 4726 || id == 3196
                		|| id == 6562 || id == 6563 || id == 6914 || id == 6908
                	|| id == 6910 || id == 6912 || id == 8056 || id == 8057 || id == 772) {
            		return 813;
        	} else {
            		return 0x328;
        	}
    	}

	public int GetBlockAnim() {
		int id = playerEquipment[playerWeapon];
		int id2 = playerEquipment[playerShield];

        	if (id == 10887) {
            		return 5866;
        	}
		if(id == 7671 || id == 7673) // boxing gloves
		{
			return 3679;
		}
        	if (id == 4755) {
            		return 2063;
        	}
        	if (id == 4153) {
            		return 1666;
		}

        if (id == 1307
	 || id == 1309
	 || id == 1311
	 || id == 1313
	 || id == 1315
	 || id == 1317
	 || id == 1319
	 || id == 6609
	 || id == 7158
	 || id == 11730
	 || id == 11694
	 || id == 11696
	 || id == 19022
	 || id == 19021
	 || id == 19047
	 || id == 18010
	 || id == 18012
	 || id == 18014
	 || id == 18016
	 || id == 11698
	 || id == 11700
	 || id == 19004) {
            		return 2063;
        	}
        	if (id == 4718) {
            		return 424;
		}
        	if (id == 19005) {
            		return 435;
		}
        	if (id == 5698 && id2 != 1171 && id2 != 1173 && id2 != 1175 && id2 != 1177 && id2 != 1179
                		&& id2 != 1181 && id2 != 1183 && id2 != 1185 && id2 != 1187
                		&& id2 != 1189 && id2 != 1191 && id2 != 1193 && id2 != 1195
                		&& id2 != 1197 && id2 != 1199 && id2 != 1201 && id2 != 1540
                		&& id2 != 2890 && id2 != 3122 && id2 != 3488 && id2 != 3758
                		&& id2 != 4072 && id2 != 4156 && id2 != 4224 && id2 != 4507
                		&& id2 != 4512 && id2 != 6215 && id2 != 6524) {
            		return 411;
        	}
        	if (id == 4587 && id2 != 1171 && id2 != 1173 && id2 != 1175 && id2 != 1177 && id2 != 1179
                		&& id2 != 1181 && id2 != 1183 && id2 != 1185 && id2 != 1187
                		&& id2 != 1189 && id2 != 1191 && id2 != 1193 && id2 != 1195
                		&& id2 != 1197 && id2 != 1199 && id2 != 1201 && id2 != 1540
                		&& id2 != 2890 && id2 != 3122 && id2 != 3488 && id2 != 3758
                		&& id2 != 4072 && id2 != 4156 && id2 != 4224 && id2 != 4507
                		&& id2 != 4512 && id2 != 6215 && id2 != 6524) {
            		return 404;
        	}
		for (int i = 1171; i <= 1201; i++) {
			if (playerEquipment[playerShield] == i) {
				return 1156;
			}
		}
        	if (id2 == 1540 || id2 == 2890 || id2 == 3122 || id2 == 3488 
				|| id2 == 3758 || id2 == 4072 || id2 == 4156 
				|| id2 == 4224 || id2 == 4507 || id2 == 4512 
				|| id2 == 6215 || id2 == 6524) {
            		return 1156;
        	}
        	if (id == 4710) {
            		return 2079;
        	}
        	if (id >= 1307 && id <= 1319 || id == 7158) {
            		return 424;
        	}

		for (int i = 841; i <= 861; i++) {
			if (playerEquipment[playerWeapon] == i) {
				return 424;
			}
		}

        	if (id == 4214 || id == 4618 || id == 15156 || id == 19014) {
            		return 424;
        	}

		for (int i = 1379; i <= 1409; i++) {
			if (playerEquipment[playerWeapon] == i) {
				return 430;
			}
		}

		for (int i = 3095; i <= 3102; i++) {
			if (playerEquipment[playerWeapon] == i) {
				return 1659;
			}
		}

        	if (playerEquipment[playerWeapon] == 4675
                		|| playerEquipment[playerWeapon] == 84
                		|| playerEquipment[playerWeapon] == 772
                		|| playerEquipment[playerWeapon] == 3053
                		|| playerEquipment[playerWeapon] == 3054
                		|| playerEquipment[playerWeapon] == 4170
                		|| playerEquipment[playerWeapon] == 6603
                		|| playerEquipment[playerWeapon] == 6726
                		|| playerEquipment[playerWeapon] == 4675
                		|| playerEquipment[playerWeapon] == 6727) {
            		return 430;
        	}
        	if (id == 4151) {
           		return 1659;
        	}

		return 424;
	}

	public int GetXItemsInBag(int ItemID) {
		int ItemCount = 0;
		for (int i = 0; i < playerItems.length; i++) {
			if ((playerItems[i] - 1) == ItemID) {
				ItemCount++;
			}
		}
		return ItemCount;
	}
	public void AddDroppedItems() {
		if (IsDropping == false) {
			IsDropping = true;
			int tmpX = 0;
			int tmpY = 0;
			int calcX = 0;
			int calcY = 0;
			for (int i = 0; i < GameEngine.itemHandler.DropItemCount; i++) {
				if (GameEngine.itemHandler.DroppedItemsID[i] > -1) {
					tmpX = GameEngine.itemHandler.DroppedItemsX[i];
					tmpY = GameEngine.itemHandler.DroppedItemsY[i];
					calcX = tmpX - absX;
					calcY = tmpY - absY;
					if (calcX >= -16 && calcX <= 15 && calcY >= -16 && calcY <= 15 && MustDelete[i] == false && GameEngine.itemHandler.DroppedItemsH[i] == heightLevel) {
						if (IsDropped[i] == false && (GameEngine.itemHandler.DroppedItemsDDelay[i] <= 0 || GameEngine.itemHandler.DroppedItemsDropper[i] == playerId)) {
							IsDropped[i] = true;
							outStream.createFrame(85);
							outStream.writeByteC((GameEngine.itemHandler.DroppedItemsY[i] - 8 * mapRegionY));
							outStream.writeByteC((GameEngine.itemHandler.DroppedItemsX[i] - 8 * mapRegionX));
							outStream.createFrame(44); //create item frame
							outStream.writeWordBigEndianA(GameEngine.itemHandler.DroppedItemsID[i]);
							outStream.writeWord(GameEngine.itemHandler.DroppedItemsN[i]); //amount
							outStream.writeByte(0); // x(4 MSB) y(LSB) coords
						}
					} else if (IsDropped[i] == true || MustDelete[i] == true) {
						outStream.createFrame(85);
						outStream.writeByteC((GameEngine.itemHandler.DroppedItemsY[i] - 8 * mapRegionY));
						outStream.writeByteC((GameEngine.itemHandler.DroppedItemsX[i] - 8 * mapRegionX));
						outStream.createFrame(156); //remove item frame
						outStream.writeByteS(0); // x(4 MSB) y(LSB) coords
						outStream.writeWord(GameEngine.itemHandler.DroppedItemsID[i]);
						int LastPlayerInList = -1;
						int TotalPlayers = 0;
						for (int j = 1; j < PlayerHandler.maxPlayers; j++) {
							if (PlayerHandler.players[j] != null) {
								LastPlayerInList = j;
								TotalPlayers++;
							}
						}
						if (MustDelete[i] == true) {
							MustDelete[i] = false;
							GameEngine.itemHandler.DroppedItemsDeletecount[i]++;
							if ((LastPlayerInList == playerId || LastPlayerInList == -1) && GameEngine.itemHandler.DroppedItemsDeletecount[i] == TotalPlayers) {
								if (GameEngine.itemHandler.DroppedItemsAlwaysDrop[i] == true) {
									GameEngine.itemHandler.DroppedItemsDropper[i] = -1;
									GameEngine.itemHandler.DroppedItemsDDelay[i] = GameEngine.itemHandler.SDID;
								} else {
									GameEngine.itemHandler.ResetItem(i);
								}
								for (int j = 1; j < PlayerHandler.maxPlayers; j++) {
									if (PlayerHandler.players[j] != null) {
										PlayerHandler.players[j].IsDropped[i] = false;
									}
								}
							}
						} else {
							IsDropped[i] = false;
						}
					}
				}
			}
			IsDropping = false;
		}
	}

	public int Tradecompete = 0;
	public int Publicchat = 0;

	public void pmstatus(int status) { //status: loading = 0  connecting = 1  fine = 2
		outStream.createFrame(221);
		outStream.writeByte(status);
	}

	public boolean isinpm(long l) {
		for(int i = 0; i < friends.length; i++) {
			if (friends[i] != 0) {
				if(l == friends[i]) {
					return true;
				}
			}
		}
		return false;
	}

	public void pmupdate(int pmid, int world) {
		long l = Misc.playerNameToInt64(handler.players[pmid].playerName);
		if (handler.players[pmid].Privatechat == 0) {
			for (int i = 0; i < friends.length; i++) {
				if (friends[i] != 0) {
					if (l == friends[i]) {
						loadpm(l, world);
						return;
					}
				}
			}
		} else if(handler.players[pmid].Privatechat == 1) {
			for (int i1 = 0; i1 < friends.length; i1++) {
				if (friends[i] != 0) {
					if (l == friends[i1]) {
    			        		if(handler.players[pmid].isinpm(Misc.playerNameToInt64(playerName)) && playerRights > 2) {
    			    				loadpm(l, world);
							return;
						} else {
							loadpm(l, 0);
							return;
						}
					}
				}
			}
		} else if(handler.players[pmid].Privatechat == 2) {
			for(int i2 = 0; i2 < friends.length; i2++) {
				if (friends[i] != 0) {
					if(l == friends[i2] && playerRights < 2) {
						loadpm(l, 0);
						return;
					}
				}
			}
		}
	}

	public void sendpm(long name, int rights, byte[] chatmessage, int messagesize) {
		outStream.createFrameVarSize(196);
		outStream.writeQWord(name);
		outStream.writeDWord(handler.lastchatid++);//must be different for each message
		outStream.writeByte(rights);
		outStream.writeBytes(chatmessage, messagesize , 0);
		outStream.endFrameVarSize();
	}

	public void loadpm(long name, int world) {
		if(world != 0) {
                world += 9;}
                else if(world == 0){
                world += 1;
                }
		outStream.createFrame(50);
		outStream.writeQWord(name);
		outStream.writeByte(world);
	}

	public int spellID = 0;

	public int getRangeDelay() {
		switch (playerEquipment[3]) {

			case 863:
			case 864:
			case 865:
			case 866:
			case 867:
			case 868:
			case 869:
				return 1;

		    default:
			return 3;
    		}
    	}

	public int getSpecAnim() {
		switch (playerEquipment[3]) {

			case 10887:
				return 5870;
			case 14484:
				return 6000;
			case 11694:
				return 4013;
			case 11696:
				return 4010;
			case 11698:
				return 4012;
			case 11700:
				return 4011;
			case 11730:
				return 7072;
			case 9005:
				return 2068;
			case 5698:
				return 0x426;
        		case 1434:
				return 1060;
        		case 4153:
				return 1667;
        		case 4151:
            			return 1658;
        		case 861:
            			return 1074;
        		case 1305:
				return 1058;
			case 3204:
				return 1203;
			case 4587:
				return 1872;
			case 7158:
				return 3157;
			case 1249:
				return 405;
		    default:
			return 422;
    		}
    	}

	public int specDrainAmount() {
		switch (playerEquipment[3]) {

			case 10887:
			case 14484:
			case 4153:
			case 9005:
			case 4151:
			case 11694:
				return 50;
			case 11696:
			case 11698:
			case 11700:
				return 75;
			case 11730:
			case 7993:
			case 8039:
			case 6724:
			case 6739:
				return 100;
			case 5698:
			case 1305:
			case 3204:
			case 1434:
			case 1249:
				return 25;
			case 7958:
			case 4587:
				return 60;
			case 7158:
			case 861:
				return 55;
		    default:
			return playerEquipment[playerWeapon] != 805 ? 50 : 100;
		}
	}

	public int getRangeMaxHit() {
		double d = 0.0D;
		double d1 = playerLevel[playerRanged];
		int i = getLevelForXP(playerXP[playerRanged]);
		int j = playerEquipment[playerWeapon];
		int k = playerEquipment[playerArrows];

		if (fullRaVoidEquipped()) {
			d1 += (double)i * 0.10000000000000001D;
		}
		d += 1.05D + d1 * 0.00125D;
		d += d1 * 0.11D;

		if (j == 800 || j == 806 || j == 825 || j == 864) {
			d *= 0.69999999999999996D;
		} else if (j == 801 || j == 807 || j == 820 || j == 863) {
			d *= 0.71999999999999997D;
		} else if (j == 802 || j == 808 || j == 827 || j == 865) {
			d *= 0.79000000000000004D;
		} else if (j == 803 || j == 809 || j == 828 || j == 866) {
			d *= 0.83999999999999997D;
 		} else if (j == 804 || j == 810 || j == 829 || j == 867) {
			d *= 0.98999999999999999D;
		} else if (j == 805 || j == 811 || j == 830 || j == 868) {
			d *= 1.24D;
		} else if (j == 6522) {
			d *= 1.6399999999999999D;
		} else if (j == 4212 || j == 4214) {
			d *= 1.75D;
		} else if (j == 19048 || j == 19049 || j == 19050 || j == 19051) {
			d *= 1.85D;
		} else if (j == 19014) {
			d *= 1.65D;
		} else if (j == 15156) {
			d *= 1.25D;
		} else if (k == 882 || k == 883) {
			d *= 1.042D;
		} else if (k == 884 || k == 885) {
			d *= 1.044D;
		} else if (k == 886 || k == 887) {
			d *= 1.1339999999999999D;
		} else if (k == 888 || k == 889) {
			d *= 1.2D;
		} else if (k == 890 || k == 891) {
			d *= 1.3500000000000001D;
		} else if (k == 892 || k == 893) {
			d *= 1.6000000000000001D;
		} else if (k == 4740) {
			d *= 1.95D;
		} else if (k == 8065) {
			d *= 1.5D;
		} else if (k == 7988) {
			d *= 2.1000000000000001D;
		} else if (k == 7990) {
			d *= 2.6000000000000001D;
		}

		if (usingSpecial) {
			if (j == 861) {
				d *= 1.05D;
			} else if (j == 7958) {
				d *= 1.6399999999999999D;
			}
		}
		return (int)Math.floor(d);
	}

	public boolean ResetAttackNPC() {
		IsAttackingNPC = false;
		resetAnimation();
                pEmote = playerSE;
                faceNPC = 65535;
                faceNPCupdate = true;
		return true;
	}

	public void ManipulateDirection() {
		if (playerMD != -1) {
			updateRequired = true;
			dirUpdateRequired = true;
		}
	}

	public int GetNPCID(int coordX, int coordY) {
		for (int i = 0; i < GameEngine.npcHandler.maxNPCs; i++) {
			if (GameEngine.npcHandler.npcs[i] != null) {
				if (GameEngine.npcHandler.npcs[i].absX == coordX && GameEngine.npcHandler.npcs[i].absY == coordY) {
					return GameEngine.npcHandler.npcs[i].npcType;
				}
			}
		}
		return 1;
	}
	public String GetNpcName(int NpcID) {
		for (int i = 0; i < GameEngine.npcHandler.maxListedNPCs; i++) {
			if (GameEngine.npcHandler.NpcList[i] != null) {
				if (GameEngine.npcHandler.NpcList[i].npcId == NpcID) {
					return GameEngine.npcHandler.NpcList[i].npcName;
				}
			}
		}
		return "!! NOT EXISTING NPC !!! - ID:"+NpcID;
	}
	public String GetItemName(int ItemID) {
		for (int i = 0; i < GameEngine.itemHandler.MaxListedItems; i++) {
			if (GameEngine.itemHandler.ItemList[i] != null) {
				if (GameEngine.itemHandler.ItemList[i].itemId == ItemID) {
					return GameEngine.itemHandler.ItemList[i].itemName;
				}
                                if (ItemID == -1) {
                                        return "Unarmed";
                                }
			}
		}
		return "Item not Recognised - ID:"+ItemID;
	}
	public String getItemName(int ItemID) {
		for (int i = 0; i < GameEngine.itemHandler.MaxListedItems; i++) {
			if (GameEngine.itemHandler.ItemList[i] != null) {
				if (GameEngine.itemHandler.ItemList[i].itemId == ItemID) {
					return GameEngine.itemHandler.ItemList[i].itemName;
				}
                                if (ItemID == -1) {
                                        return "Unarmed";
                                }
			}
		}
		return "!! NOT EXISTING ITEM !!! - ID:"+ItemID;
	}
	public double GetItemShopValue(int ItemID, int Type, int fromSlot) {
		double ShopValue = 1;
		double Overstock = 0;
		double TotPrice = 0;
		for (int i = 0; i < GameEngine.itemHandler.MaxListedItems; i++) {
			if (GameEngine.itemHandler.ItemList[i] != null) {
				if (GameEngine.itemHandler.ItemList[i].itemId == ItemID) {
					ShopValue = GameEngine.itemHandler.ItemList[i].ShopValue;
				}
			}
		}
		TotPrice = (ShopValue * 1); //Calculates price for 1 item, in db is stored for 0 items (strange but true)
		if (GameEngine.shopHandler.ShopBModifier[MyShopID] == 1) {
			TotPrice *= 1; //25% more expensive (general stores only)
			if (Type == 1) {
				TotPrice *= 1; //general store buys item at 40% of its own selling value
			}
		} else if (Type == 1) {
			TotPrice *= 1; //other stores buy item at 60% of their own selling value
		}
		return TotPrice;
	}
	public int GetUnnotedItem(int ItemID) {
		int NewID = 0;
		String NotedName = "";
		for (int i = 0; i < GameEngine.itemHandler.MaxListedItems; i++) {
			if (GameEngine.itemHandler.ItemList[i] != null) {
				if (GameEngine.itemHandler.ItemList[i].itemId == ItemID) {
					NotedName = GameEngine.itemHandler.ItemList[i].itemName;
				}
			}
		}
		for (int i = 0; i < GameEngine.itemHandler.MaxListedItems; i++) {
			if (GameEngine.itemHandler.ItemList[i] != null) {
				if (GameEngine.itemHandler.ItemList[i].itemName == NotedName) {
					if (GameEngine.itemHandler.ItemList[i].itemDescription.startsWith("Swap this note at any bank for a") == false) {
						NewID = GameEngine.itemHandler.ItemList[i].itemId;
						break;
					}
				}
			}
		}
		return NewID;
	}

	public void WriteEnergy() {
		if (playerEnergy > 100) {
			playerEnergy = 100;
		}
		//sendFrame126(""+ playerEnergy +"%", 149);
		sendFrame126("Unlimited", 149);
	}
	public void ResetBonus() {
		for (int i = 0; i < playerBonus.length; i++) {
			playerBonus[i] = 0;
		}
	}
	public void GetBonus() {
		for (int i = 0; i < playerEquipment.length; i++) {
			if (playerEquipment[i] > -1) {
				for (int j = 0; j < 9999; j++) {
					if (GameEngine.itemHandler.ItemList[j] != null){
							if (GameEngine.itemHandler.ItemList[j].itemId == playerEquipment[i]) {
							for (int k = 0; k < playerBonus.length; k++) {
								playerBonus[k] += GameEngine.itemHandler.ItemList[j].Bonuses[k];
							}
							break;
						}
					}
				}
			}
		}
	}
	public void WriteBonus() {
		int offset = 0;
		String send = "";
		for (int i = 0; i < playerBonus.length; i++) {
			if (playerBonus[i] >= 0) {
				send = BonusName[i]+": +"+playerBonus[i];
			} else {
				send = BonusName[i]+": -"+java.lang.Math.abs(playerBonus[i]);
			}

			if (i == 10) {
				offset = 1;
			}
			sendFrame126(send, (1675+i+offset));
			if ((15111 + i + offset) == 15116 || (15111 + i + offset) == 15122) {
				sendFrame126(send, (15113 + i + offset));
			}
			if ((playerEquipment[playerRing] == 6583) && npcId != 2626) { //ring of stone
				npcId = 2626;
				isNpc = true;
			} else if ((playerEquipment[playerRing] != 6583) && npcId == 2626) {
				npcId = 0;
				isNpc = false;
			} else if ((playerEquipment[playerRing] != 7927) && (npcId >= 3689 && npcId <= 3694)) {
				npcId = 0;
				isNpc = false;
			}
		}
	}

	public boolean FullDharokEquipped() {
		if (playerEquipment[playerHat] == 4716 &&playerEquipment[playerChest] == 4720 && playerEquipment[playerLegs] == 4722 && playerEquipment[playerWeapon] == 4718) {
			return true;
                }
		return false;

	}

	public void CalculateRange() {
		double MaxHit = 0;
		int RangeBonus = playerBonus[5]; //Range Bonus
		int Range = playerLevel[4]; //Range
                {
			MaxHit += (double)(1.05 + (double)((double)(RangeBonus * Range) * 0.00175));
		}
		MaxHit += (double)(Range * 0.1);
		playerMaxHit = (int)Math.floor(MaxHit);
	}
	public boolean GoodDistance(int objectX, int objectY, int playerX, int playerY, int distance) {
		for (int i = 0; i <= distance; i++) {
		  for (int j = 0; j <= distance; j++) {
			if ((objectX + i) == playerX && ((objectY + j) == playerY || (objectY - j) == playerY || objectY == playerY)) {
				return true;
			} else if ((objectX - i) == playerX && ((objectY + j) == playerY || (objectY - j) == playerY || objectY == playerY)) {
				return true;
			} else if (objectX == playerX && ((objectY + j) == playerY || (objectY - j) == playerY || objectY == playerY)) {
				return true;
			}
		  }
		}
		return false;
	}
	public boolean GoodDistance2(int objectX, int objectY, int playerX, int playerY, int distance) {
		for (int i = 0; i <= distance; i++) {
		  for (int j = 0; j <= distance; j++) {
			if (objectX == playerX && ((objectY + j) == playerY || (objectY - j) == playerY || objectY == playerY)) {
				return true;
			} else if (objectY == playerY && ((objectX + j) == playerX || (objectX - j) == playerX || objectX == playerX)) {
				return true;
			}
		  }
		}
		return false;
	}
	public boolean CheckObjectSkill(int objectID) {
		boolean GoFalse = false;
		switch (objectID) {

			default:
				GoFalse = true;
				break;
		}
		if (GoFalse == true) {
			return false;
		}
		return true;
	}

	public long healTimer = 0;

	public boolean prayer() {
		if (prayer[0] == 1) {
			prayer[0] = 2;
		}
		if (prayer[0] == 2) {
			deleteItem(prayer[4], prayer[5], playerItemsN[prayer[5]]);
			addSkillXP((prayer[2] * prayer[3]), playerPrayer);
			sendMessage("You bury the bones.");
			resetPR();
			return true;
		}
		return false;
	}
	public boolean resetPR() {
		prayer[0] = 0;
		prayer[1] = 0;
		prayer[2] = 0;
		prayer[4] = -1;
		prayer[5] = -1;
		IsUsingSkill = false;
		return true;
	}

	public void AcceptTrade() {
		if(playerLastConnect != PlayerHandler.players[tradeWith].playerLastConnect) {
			sendFrame248(3323, 3321); //trading window + bag
			resetItems(3322);
			resetTItems(3415);
			resetOTItems(3416);
			sendFrame126("Trading With: "+PlayerHandler.players[tradeWith].playerName, 3417);
			sendFrame126("", 3431);
		}
	}
	public void DeclineTrade() {
		if(!TradeConfirmed) {
			for (int i = 0; i < playerTItems.length; i++) {
				if (playerTItems[i] > 0) {
					fromTrade((playerTItems[i] - 1), i, playerTItemsN[i]);
				}
			}
			resetItems(3214);
			resetTrade();
		}
	}
	public void resetTrade() {
		tradeWith = 0;
		tradeWaitingTime = 0;
		tradeStatus = 0;
		tradeUpdateOther = false;
		tradeOtherDeclined = false;
		WanneTrade = 0;
		WanneTradeWith = 0;
		TradeConfirmed = false;
		for (int i = 0; i < playerTItems.length; i++) {
			playerTItems[i] = 0;
			playerTItemsN[i] = 0;
			playerOTItems[i] = 0;
			playerOTItemsN[i] = 0;
		}
	}
	public void ConfirmTrade() {
		if(playerLastConnect != PlayerHandler.players[tradeWith].playerLastConnect) {
			if (TradeConfirmed == false) {
				RemoveAllWindows();
				for (int i = 0; i < playerOTItems.length; i++) {
					if (playerOTItems[i] > 0) {
						addItem((playerOTItems[i] - 1), playerOTItemsN[i]);
					}
				}
				resetItems(3214);
				TradeConfirmed = true;
			}
		}
	}	
	public void TradeGoConfirm() {
		if(playerLastConnect != PlayerHandler.players[tradeWith].playerLastConnect) {
			sendFrame248(3443, 3213); //trade confirm + normal bag
			resetItems(3214);
			String SendTrade = "Absolutely nothing!";
			String SendAmount = "";
			int Count = 0;
			for (int i = 0; i < playerTItems.length; i++) {
				if (playerTItems[i] > 0) {
					if (playerTItemsN[i] >= 1000 && playerTItemsN[i] < 1000000) {
						SendAmount = "@cya@" + (playerTItemsN[i] / 1000) + "K @whi@(" + playerTItemsN[i] + ")";
					} else if (playerTItemsN[i] >= 1000000) {
						SendAmount = "@gre@" + (playerTItemsN[i] / 1000000) + " million @whi@(" + playerTItemsN[i] + ")";
					} else {
						SendAmount = "" + playerTItemsN[i];
					}
					if (Count == 0) {
						SendTrade = GetItemName((playerTItems[i] - 1));
					} else {
						SendTrade = SendTrade + "\\n" + GetItemName((playerTItems[i] - 1));
					}
					if (DataFiles.itemIsNote[(playerTItems[i] - 1)] == true || DataFiles.itemStackable[(playerTItems[i] - 1)] == true) {
						SendTrade = SendTrade + " x " + SendAmount;
					}
					Count++;
				}
			}
			sendFrame126(SendTrade, 3557);
			SendTrade = "Absolutely nothing!";
			SendAmount = "";
			Count = 0;
			for (int i = 0; i < playerOTItems.length; i++) {
				if (playerOTItems[i] > 0) {
					if (playerOTItemsN[i] >= 1000 && playerOTItemsN[i] < 1000000) {
						SendAmount = "@cya@" + (playerOTItemsN[i] / 1000) + "K @whi@(" + playerOTItemsN[i] + ")";
					} else if (playerOTItemsN[i] >= 1000000) {
						SendAmount = "@gre@" + (playerOTItemsN[i] / 1000000) + " million @whi@(" + playerOTItemsN[i] + ")";
					} else {
						SendAmount = "" + playerOTItemsN[i];
					}
					if (Count == 0) {
						SendTrade = GetItemName((playerOTItems[i] - 1));
					} else {
						SendTrade = SendTrade + "\\n" + GetItemName((playerOTItems[i] - 1));
					}
					if (DataFiles.itemIsNote[(playerOTItems[i] - 1)] == true || DataFiles.itemStackable[(playerOTItems[i] - 1)] == true) {	
						SendTrade = SendTrade + " x " + SendAmount;
					}
					Count++;
				}
			}
			sendFrame126(SendTrade, 3558);
		}
	}
	public boolean fromTrade(int itemID, int fromSlot, int amount) {
		if (amount > 0 && (itemID + 1) == playerTItems[fromSlot]) {
			if (amount > playerTItemsN[fromSlot]) {
				amount = playerTItemsN[fromSlot];
			}
			addItem((playerTItems[fromSlot] - 1), amount);
			if (amount == playerTItemsN[fromSlot]) {
				playerTItems[fromSlot] = 0;
				PlayerHandler.players[tradeWith].playerOTItems[fromSlot] = 0;
			}
			playerTItemsN[fromSlot] -= amount;
			PlayerHandler.players[tradeWith].playerOTItemsN[fromSlot] -= amount;
			resetItems(3322);
			resetTItems(3415);
			PlayerHandler.players[tradeWith].tradeUpdateOther = true;
			if (PlayerHandler.players[tradeWith].tradeStatus == 3) {
				PlayerHandler.players[tradeWith].tradeStatus = 2;
				PlayerHandler.players[tradeWith].AntiTradeScam = true;
				sendFrame126("", 3431);
			}
			return true;
		}
		return false;
	}
	public boolean tradeItem(int itemID, int fromSlot, int amount) {
		if (tradeWith > 0) {
			if (PlayerHandler.players[tradeWith] == null) {
				DeclineTrade();
				sendMessage("FORCED DECLINE BY SERVER !");
				return false;
			}
		} else {
			DeclineTrade();
			sendMessage("FORCED DECLINE BY SERVER !");
			return false;
		}
		if (amount > 0 && itemID == (playerItems[fromSlot] - 1)) {
			if (amount > playerItemsN[fromSlot]) {
				amount = playerItemsN[fromSlot];
			}
			boolean IsInTrade = false;
			for (int i = 0; i < playerTItems.length; i++) {
				if (playerTItems[i] == playerItems[fromSlot]) {
					if (DataFiles.itemStackable[(playerItems[fromSlot] - 1)] == true || DataFiles.itemIsNote[(playerItems[fromSlot] - 1)] == true) {
						playerTItemsN[i] += amount;
						PlayerHandler.players[tradeWith].playerOTItemsN[i] += amount;
						IsInTrade = true;
						break;
					}
				}
			}
			if (IsInTrade == false) {
				for (int i = 0; i < playerTItems.length; i++) {
					if (playerTItems[i] <= 0) {
						playerTItems[i] = playerItems[fromSlot];
						playerTItemsN[i] = amount;
						PlayerHandler.players[tradeWith].playerOTItems[i] = playerItems[fromSlot];
						PlayerHandler.players[tradeWith].playerOTItemsN[i] = amount;
						break;
					}
				}
			}
			if (amount == playerItemsN[fromSlot]) {
				playerItems[fromSlot] = 0;
			}
			playerItemsN[fromSlot] -= amount;
			resetItems(3322);
			resetTItems(3415);
			PlayerHandler.players[tradeWith].tradeUpdateOther = true;
			if (PlayerHandler.players[tradeWith].tradeStatus == 3) {
				PlayerHandler.players[tradeWith].tradeStatus = 2;
				PlayerHandler.players[tradeWith].AntiTradeScam = true;
				sendFrame126("", 3431);
			}
			return true;
		}
		return false;
	}

	public boolean sellItem(int itemID, int fromSlot, int amount) {
		if (amount > 0 && itemID == (playerItems[fromSlot] - 1)) {
			if (GameEngine.shopHandler.ShopSModifier[MyShopID] > 1) {
				boolean IsIn = false;
				for (int i = 0; i <= GameEngine.shopHandler.ShopItemsStandard[MyShopID]; i++) {
					if (itemID == (GameEngine.shopHandler.ShopItems[MyShopID][i] - 1)) {
						IsIn = true;
						break;
					}
				}
				if (IsIn == false) {
					sendMessage("You cannot sell "+GetItemName(itemID)+" in this store.");
					return false;
				}
			}
			if (DataFiles.itemSellable[(playerItems[fromSlot] - 1)] == false) {
				sendMessage("I cannot sell "+GetItemName(itemID)+".");
				return false;
			}
			if (amount > playerItemsN[fromSlot] && (DataFiles.itemIsNote[(playerItems[fromSlot] - 1)] == true || DataFiles.itemStackable[(playerItems[fromSlot] - 1)] == true)) {
				amount = playerItemsN[fromSlot];
			} else if (amount > GetXItemsInBag(itemID) && DataFiles.itemIsNote[(playerItems[fromSlot] - 1)] == false && DataFiles.itemStackable[(playerItems[fromSlot] - 1)] == false) {
				amount = GetXItemsInBag(itemID);
			}
			double ShopValue;
			double TotPrice;
			int TotPrice2;
			int Overstock;
			for (int i = amount; i > 0; i--) {
				TotPrice2 = (int)Math.floor(GetItemShopValue(itemID, 1, fromSlot));
				if (freeSlots() > 0) {
					if (DataFiles.itemIsNote[itemID] == false) {
						deleteItem(itemID, GetItemSlot(itemID), 1);
					} else {
						deleteItem(itemID, fromSlot, 1);
					}
					addItem(4278, TotPrice2);
					addShopItem(itemID, 1);
				} else {
					sendMessage("Not enough space in your inventory.");
					break;
				}
			}
			resetItems(3823);
			resetShop(MyShopID);
			UpdatePlayerShop();
			return true;
		}
		return true;
	}
	public boolean buyItem(int itemID, int fromSlot, int amount) {




		if (amount > 0 && itemID == (GameEngine.shopHandler.ShopItems[MyShopID][fromSlot] - 1)) {
			if (amount > GameEngine.shopHandler.ShopItemsN[MyShopID][fromSlot]) {
				amount = GameEngine.shopHandler.ShopItemsN[MyShopID][fromSlot];
			}
			double ShopValue;
			double TotPrice;
			int TotPrice2;
			int Overstock;
			int Slot = 0;

            if (amount > 100) {
				TotPrice2 = (int)Math.floor(GetItemShopValue(itemID, 0, fromSlot))*amount;
				Slot = GetItemSlot(4278);
				if (Slot == -1 && TotPrice2 != 0) {
					sendMessage("You don't have enough BlazeScape Tickets.");
				}
				if(TotPrice2 <= 1) {
					TotPrice2 = (int)Math.floor(GetItemShopValue(itemID, 0, fromSlot));
				}
				if (TotPrice2 <= 0) {
					if (freeSlots() > 0) {
						addItem(itemID, amount);
						GameEngine.shopHandler.ShopItemsN[MyShopID][fromSlot] -= 1;
						GameEngine.shopHandler.ShopItemsDelay[MyShopID][fromSlot] = 0;
						if ((fromSlot + 1) > GameEngine.shopHandler.ShopItemsStandard[MyShopID]) {
							GameEngine.shopHandler.ShopItems[MyShopID][fromSlot] = 0;
						}
					} else {
						sendMessage("Not enough space in your inventory.");
					}
				} else if (playerItemsN[Slot] >= TotPrice2) {
					if (freeSlots() > 0) {
						deleteItem(4278, GetItemSlot(4278), TotPrice2);
						addItem(itemID, amount);
						GameEngine.shopHandler.ShopItemsN[MyShopID][fromSlot] -= amount;
						GameEngine.shopHandler.ShopItemsDelay[MyShopID][fromSlot] = 0;
						if ((fromSlot + 1) > GameEngine.shopHandler.ShopItemsStandard[MyShopID]) {
							GameEngine.shopHandler.ShopItems[MyShopID][fromSlot] = 0;
						}
					} else {
						sendMessage("Not enough space in your inventory.");
					}
				} else {
					sendMessage("You don't have enough BlazeScape Tickets.");
				}
            }else{



			for (int i = amount; i > 0; i--) {
				TotPrice2 = (int)Math.floor(GetItemShopValue(itemID, 0, fromSlot));
				Slot = GetItemSlot(4278);
				if (Slot == -1) {
					sendMessage("You don't have enough BlazeScape Tickets.");
					break;
				}
	    
                        if(TotPrice2 <= 1)
                        {
                        TotPrice2 = (int)Math.floor(GetItemShopValue(itemID, 0, fromSlot));
                        }
				if (playerItemsN[Slot] >= TotPrice2) {
					if (freeSlots() > 0) {
						deleteItem(4278, GetItemSlot(4278), TotPrice2);
						addItem(itemID, 1);
						GameEngine.shopHandler.ShopItemsN[MyShopID][fromSlot] -= 1;
						GameEngine.shopHandler.ShopItemsDelay[MyShopID][fromSlot] = 0;
						if ((fromSlot + 1) > GameEngine.shopHandler.ShopItemsStandard[MyShopID]) {
							GameEngine.shopHandler.ShopItems[MyShopID][fromSlot] = 0;
						}
					} else {
						sendMessage("Not enough space in your inventory.");
						break;
					}
				} else {
					sendMessage("You don't have enough BlazeScape Tickets.");
					break;
				}
			}
			resetItems(3823);
			resetShop(MyShopID);
			UpdatePlayerShop();
			return true;
		}
	    }
		return false;
	}
	public void UpdatePlayerShop() {
		for (int i = 1; i < PlayerHandler.maxPlayers; i++) {
			if (PlayerHandler.players[i] != null) {
				if (PlayerHandler.players[i].IsShopping == true && PlayerHandler.players[i].MyShopID == MyShopID && i != playerId) {
					PlayerHandler.players[i].UpdateShop = true;
				}
			}
		}
	}
	public boolean addShopItem(int itemID, int amount) {
		boolean Added = false;
		if (amount <= 0) {
			return false;
		}
		if (DataFiles.itemIsNote[itemID] == true) {
			itemID = GetUnnotedItem(itemID);
		}
		for (int i = 0; i < GameEngine.shopHandler.ShopItems.length; i++) {
			if ((GameEngine.shopHandler.ShopItems[MyShopID][i] - 1) == itemID) {
				GameEngine.shopHandler.ShopItemsN[MyShopID][i] += amount;
				Added = true;
			}
		}
		if (Added == false) {
			for (int i = 0; i < GameEngine.shopHandler.ShopItems.length; i++) {
				if (GameEngine.shopHandler.ShopItems[MyShopID][i] == 0) {
					GameEngine.shopHandler.ShopItems[MyShopID][i] = (itemID + 1);
					GameEngine.shopHandler.ShopItemsN[MyShopID][i] = amount;
					GameEngine.shopHandler.ShopItemsDelay[MyShopID][i] = 0;
					break;
				}
			}
		}
		return true;
	}

	public int easterCorrect = 0;

	public void UpdateNPCChat() {
		sendFrame126("", 976);

		switch (NpcDialogue) {
/*
 *
 *
 * Easter Event Begin
 *
 */
			case 1835://Easter Bunny Greeting
				npcD3("Oh! Greetings " +playerName+ "! Can't you feel it?", "It's the feeling of Easter! Now, for you, I have", "a quiz. Care to test your luck?", -1);
				NpcDialogueSend = true;
			break;
			case 1836://Easter Bunny Yes, question 1
				npcD2("Spendid! Alright... first question!", "In what year was Bunny Ears dropped for Easter?", -1);
				NpcDialogueSend = true;
				easterStage = 1;
			break;
			case 1837://Question Two
				npcD2("Next question! In what year was the magical", "Easter Ring given as a prize?", -1);
				NpcDialogueSend = true;
				easterStage = 2;
			break;
			case 1838://Question Three Final
				npcD2("Final question! In what year was rubber chicken", "given as a reward for playing during Easter?", -1);
				NpcDialogueSend = true;
				easterStage = 3;
			break;
			case 1839://Choose answer Q1
				selectOption("2001", "2003", "2005");
				NpcDialogueSend = true;
			break;
			case 1840://Choose answer Q2
				selectOption("2006", "2007", "2005");
				NpcDialogueSend = true;
			break;
			case 1841://Choose answer Q3
				selectOption("2003", "2010", "2005");
				NpcDialogueSend = true;
			break;
			case 1842://2 out of 3 correct
				npcD2("You have answered "+easterCorrect+" out of 3", "questions correctly! Here is your reward", -1);
				NpcDialogueSend = true;

				
			break;
			case 1843://1 or less correct
				npcD2("Too bad, you have answered "+easterCorrect+" out of 3", "questions correctly...Please try again!", -1);
				NpcDialogueSend = true;
			break;
			case 1844://Already completed Event
				npcD2("You have already completed the Easter Event", "for BlazeScape. You may not repeat it. Sorry!", -1);
				NpcDialogueSend = true;
			break;
			case 1845://Wrong answer
				npcD("Wrong!", -1);
				NpcDialogueSend = true;
			break;

			case 1846://Correct answer
				npcD("Correct!", -1);
				NpcDialogueSend = true;
				easterCorrect += 1;
			break;
			case 1847://Wrong answer
				npcD("Wrong! Too bad...", -1);
				NpcDialogueSend = true;
			break;
			case 1848://Correct answer
				npcD("Correct! Almost there!", -1);
				NpcDialogueSend = true;
				easterCorrect += 1;

			break;
			case 1849://Wrong answer
				npcD("Wrong! It's not that bad...", -1);
				NpcDialogueSend = true;
				easterStage = 4;
			break;
			case 1850://Correct answer
				npcD("Correct! You're finished!", -1);
				NpcDialogueSend = true;
				easterCorrect += 1;
				easterStage = 4;
			break;
			case 1851://2001
				pDialogue("2001", -1);
				NpcDialogueSend = true;
			break;
			case 1852://2003
				pDialogue("2003", -1);
				NpcDialogueSend = true;
			break;
			case 1853://2005
				pDialogue("2005", -1);
				NpcDialogueSend = true;
			break;
			case 1854://2006
				pDialogue("2006", -1);
				NpcDialogueSend = true;
			break;
			case 1855://2007
				pDialogue("2007", -1);
				NpcDialogueSend = true;
			break;
			case 1856://2010
				pDialogue("2010", -1);
				NpcDialogueSend = true;
			break;
			case 1857://Yes
				pDialogue("Yes.", -1);
				NpcDialogueSend = true;
			break;
			case 1858://No.
				pDialogue("No.", -1);
				NpcDialogueSend = true;
			break;
			case 1859://Choose option Yes, no.
				selectOption("Yes.", "No.");
				NpcDialogueSend = true;
			break;


/*
 *
 * Easter Event End
 * Remember to delete this section once easter is over!
 * Event should be over 1 week and 2 days after this event is completed.
 * Event timer remaining: 1 week, 2 days
 *
 */
			case 1369:
				npcD("I'll gladly buy your fish from you.", -1);
				NpcDialogueSend = true;
			break;

			case 15977:
				selectOption("Would you like a High slayer task?", "or a Low slayer task?");
				NpcDialogueSend = true;
			break;

			case 653:
				npcD2("You have not proven yourself as a warrior.", "Your attack and strength levels must add to 130 to enter here.", -1);
				NpcDialogueSend = true;
			break;

			case 456:
				npcD3("Ah, young adventurer, I see you have been praying", "hard to Saradomin. Talk to my brother", "and he will heal you.", -1);
				NpcDialogueSend = true;
			break;

			case 457:
				npcD2("Hello adventurer, I see you enjoy", "grave robbing. I used to do the same.", -1);
				NpcDialogueSend = true;
			break;

			case 458:
				npcD("Ah, my brother told me about you, here take my blessing.", -1);
				NpcDialogueSend = true;
			break;

			case 459:
				npcD("Please talk to my brother, I have no time for you.", -1);
				NpcDialogueSend = true;
			break;
			case 460:
				npcD("You've already recieved my blessing. Move along.", -1);
				NpcDialogueSend = true;
			break;

			case 2024:
				selectOption("Go to Barrows?", "No thanks, too dangerous for me.");
				break;

			case 582:
				npcD("I sell pickaxes.", -1);
				NpcDialogueSend = true;
				break;
			case 594:
				npcD("I sell woodcutting axes.", -1);
				NpcDialogueSend = true;
				break;
			case 1599:
				npcD("I sell rune armour and weaponry.", -1);
				NpcDialogueSend = true;
				break;
			case 551:
				npcD("I sell adamant armour and weaponry.", -1);
				NpcDialogueSend = true;
				break;
			case 1304:
				NpcDialogueSend = true;
				npcD3(	"I've discovered a new island,", 
					"but I can't take you there yet.", 
					"Hopefully I can in the near future.", -1);
				break;
			case 552:
				npcD("I sell mithril armour and weaponry.", -1);
				NpcDialogueSend = true;
				break;
			case 682:
				npcD("I sell black armour and weaponry.", -1);
				NpcDialogueSend = true;
				break;
			case 542:
				npcD("I sell steel armour and weaponry.", -1);
				NpcDialogueSend = true;
				break;
			case 580:
				npcD("I sell iron armour and weaponry.", -1);
				NpcDialogueSend = true;
				break;
			case 1780:
				npcD("I sell team capes.", -1);
				NpcDialogueSend = true;
				break;
			case 308:
				selectOption("Talk", "Trade");
				NpcDialogueSend = true;
				break;
			case 309:
				String message = "";
				String message2 = "";
				if(playerLevel[playerFishing] == 99) {
					message2 = "Congratulations on becoming a master of Fishing.";
					if(pHasItem(4278, 99000)) {
						if(freeSlots() >= 3) {
							message = "Here is your reward for obtaining 99 mining.";
							addItem(9798, 1);
							addItem(9799, 1);
							addItem(9800, 1);
							deleteItem(4278, GetItemSlot(4278), 99000);
						} else {
							message = "You need more inventory space.";
						}
					} else {
						message = "You'll need 99k for a skillcape.";
					}
						
				} else {
					message = "I'll award you a skillcape at 99 Fishing.";
					message2 = "";
				}
				npcD2(""+message, ""+message2, -1);
				NpcDialogueSend = true;
			break;
			case 310:
				WanneShop = 21;
				NpcDialogueSend = true;
			break;
			case 3295:
				if(playerLevel[playerMining] == 99) {
					message2 = "Congratulations on becoming a master of Mining.";
					if(pHasItem(4278, 99000)) {
						if(freeSlots() >= 3) {
							message = "Here is your reward for obtaining 99 mining.";
							addItem(9792, 1);
							addItem(9793, 1);
							addItem(9794, 1);
							deleteItem(4278, GetItemSlot(4278), 99000);
						} else {
							message = "You need more inventory space.";
						}
					} else {
						message = "You'll need 99k for a skillcape.";
					}
						
				} else {
					message = "I'll award you a skillcape at 99 mining.";
					message2 = "";
				}
				npcD2(""+message, ""+message2, -1);
				NpcDialogueSend = true;
				break;
			case 847:
				if(playerLevel[playerCooking] == 99) {
					message2 = "Congratulations on becoming a master of Cooking.";
					if(pHasItem(4278, 99000)) {
						if(freeSlots() >= 3) {
							message = "Here is your reward for obtaining 99 Cooking.";
							addItem(9801, 1);
							addItem(9802, 1);
							addItem(9803, 1);
							deleteItem(4278, GetItemSlot(4278), 99000);
						} else {
							message = "You need more inventory space.";
						}
					} else {
						message = "You'll need 99k for a skillcape.";
					}
						
				} else {
					message = "I'll award you a skillcape at 99 Cooking";
					message2 = "";
				}
				npcD2(""+message, ""+message2, -1);
				NpcDialogueSend = true;
				break;
			case 2270:
				if(playerLevel[playerThieving] == 99) {
					message2 = "Congratulations on becoming a master of Thieving.";
					if(pHasItem(4278, 99000)) {
						if(freeSlots() >= 3) {
							message = "Here is your reward for obtaining 99 Thieving.";
							addItem(9777, 1);
							addItem(9778, 1);
							addItem(9779, 1);
							deleteItem(4278, GetItemSlot(4278), 99000);
						} else {
							message = "You need more inventory space.";
						}
					} else {
						message = "You'll need 99k for a skillcape.";
					}
						
				} else {
					message = "I'll award you a skillcape at 99 Thieving.";
					message2 = "";
				}
				npcD2(""+message, ""+message2, -1);
				NpcDialogueSend = true;
				break;
			case 961:
				if(playerLevel[playerHitpoints] == 99) {
					message2 = "Congratulations on becoming a master of Hitpoints.";
					if(pHasItem(4278, 99000)) {
						if(freeSlots() >= 3) {
							message = "Here is your reward for obtaining 99 Hitpoints.";
							addItem(9768, 1);
							addItem(9769, 1);
							addItem(9770, 1);
							deleteItem(4278, GetItemSlot(4278), 99000);
						} else {
							message = "You need more inventory space.";
						}
					} else {
						message = "You'll need 99k for a skillcape.";
					}
						
				} else {
					message = "I'll award you a skillcape at 99 Hitpoints.";
					message2 = "";
				}
				npcD2(""+message, ""+message2, -1);
				NpcDialogueSend = true;
				break;
			case 3799:
				if(playerLevel[playerStrength] == 99) {
					message2 = "Congratulations on becoming a master of Strength.";
					if(pHasItem(4278, 99000)) {
						if(freeSlots() >= 3) {
							message = "Here is your reward for obtaining 99 Strength.";
							addItem(9750, 1);
							addItem(9751, 1);
							addItem(9752, 1);
							deleteItem(4278, GetItemSlot(4278), 99000);
						} else {
							message = "You need more inventory space.";
						}
					} else {
						message = "You'll need 99k for a skillcape.";
					}
						
				} else {
					message = "I'll award you a skillcape at 99 Strength.";
					message2 = "";
				}
				npcD2(""+message, ""+message2, -1);
				NpcDialogueSend = true;
				break;
			case 3801:
				if(playerLevel[playerWoodcutting] == 99) {
					message2 = "Congratulations on becoming a master of Woodcutting.";
					if(pHasItem(4278, 99000)) {
						if(freeSlots() >= 3) {
							message = "Here is your reward for obtaining 99 Woodcutting.";
							addItem(9750, 1);
							addItem(9751, 1);
							addItem(9752, 1);
							deleteItem(4278, GetItemSlot(4278), 99000);
						} else {
							message = "You need more inventory space.";
						}
					} else {
						message = "You'll need 99k for a skillcape.";
					}
						
				} else {
					message = "I'll award you a skillcape at 99 Woodcutting.";
					message2 = "";
				}
				npcD2(""+message, ""+message2, -1);
				NpcDialogueSend = true;
				break;
			case 3798:
				if(playerLevel[playerAttack] == 99) {
					message2 = "Congratulations on becoming a master of Attack.";
					if(pHasItem(4278, 99000)) {
						if(freeSlots() >= 3) {
							message = "Here is your reward for obtaining 99 Attack.";
							addItem(9747, 1);
							addItem(9748, 1);
							addItem(9749, 1);
							deleteItem(4278, GetItemSlot(4278), 99000);
						} else {
							message = "You need more inventory space.";
						}
					} else {
						message = "You'll need 99k for a skillcape.";
					}
						
				} else {
					message = "I'll award you a skillcape at 99 Attack.";
					message2 = "";
				}
				npcD2(""+message, ""+message2, -1);
				NpcDialogueSend = true;
				break;
			case 550:
				npcD("I sell ranging supplies.", -1);
				NpcDialogueSend = true;
				break;
			case 546:
				npcD("I sell magic supplies.", -1);
				NpcDialogueSend = true;
				break;
			case 2244: /*Lumb Guide*/
				npcD("Welcome to Blazescape.", 591);
				NpcDialogueSend = true;
				break;

			case 675: //Fur trader
				npcD("Come back anytime!", 591);
				NpcDialogueSend = true;
				break;
			case 1340:
				selectOption("Yeah!", "Nah.");
				NpcDialogueSend = true;
				break;
			case 1341: /*Hans*/
				npcD("I'm glad you think so too.", 591);
				NpcDialogueSend = true;
				break;
			case 1342: /*Hans*/
				npcD("Oh look at the time! I'm sorry but I have to go, Good day!", 591);
				NpcDialogueSend = true;
				break;
			case 650:
				npcD("Would you like to purchase Ranged supplies?", 591);
				NpcDialogueSend = true;
				break;
         	case 651:
				selectOption("Yes please.", "No Thank you.");
				NpcDialogueSend = true;
				break;
			case 652: // Lowe
				npcD("Ok, I hope to see you soon!", -1);
				NpcDialogueSend = true;
				break;
			case 1597:
				npcD("'Ello, and what are you after then?", -1);
				NpcDialogueSend = true;
				break;

			case 1607:
				npcD("Thanks for your help.", -1);
				NpcDialogueSend = true;
			break;
			case 5001:
				selectOption("Yeah I'm fearless!", "No way, that looks scary!");
				break;

			case 1918: // Archaeologist
				pDialogue("Hello there.", -1);
				break;

			case 1919: // Archaeologist
				npcD3(	"Howdy stranger. I found this ancient stone tablet", 
					"in one of my excavations, and the inscriptions on it say", 
					"that there's treasure hidden out in the desert.", 591);
				break;
			case 1920:
				npcD("Wait ... would you help me find this treasure?", 588);
				break;
			case 1921:
				selectOption("Yes, I'll help you.", "No thanks, I don't want to help.");
				break;
			case 2100: 
				pDialogue("No thanks, I don't want to help.", 590);
				break;
			case 2101:
				npcD("Fucking Nigger.", 614);
				break;
			case 1922:
				pDialogue3(	"Well...", 
					"I guess nobody is going to lose out on anything,", 
					"and we don't even know if there is any treasure...", 595);
				dtQuest = 1;
				savemoreinfo();
				break;
			case 1923:
				pDialogue("Aw, go on then. Count me in.", 590);
				break;
			case 1924:
				npcD4("Good lad!", 
					"The inscriptions also say that four diamonds are needed",
					"to unlock the treasure. They are the blood, ice, smoke,",
					"and shadow diamonds.", 590);
				break;
			case 1925:
				npcD2("I know the location of all four diamonds, but I do not know",
					"the location of the treasure.", 590);
			case 1926:
				npcD4(	"While you are obtaining the diamonds, I will search for", 
					"the location of the treasure.",
					"Oh, one more thing: each diamond is protected by it's",
					"owner. You must defeat them to obtain the diamonds.", 590);
				break;
			case 1927:
				npcD2(	"Would you like me to teleport you to the first diamond",
					"location?", 590);
				break;
			case 1928:
				selectOption("Yes.", "No thanks.");
				break;
			case 1929:
				npcD("Good luck, "+ playerName +".", 595);
				break;

			case 2617:
				npcD("Would you like to go to the Tzhaar fight cave entrance?", 595);
				break;
			case 2618:
				selectOption("Yes.", "No.");
				break;
			case 3000:
				pDialogue("Oi cock face.", 595);
				//NpcDialogueSend = true;
				break;
			case 3001:
				npcD("Leave me alone.", 594);
				break;
		}
	}

	public int GetWorld(int PlayerID) {
             try{
                return 1;
               }
              catch(Exception e){
               System.out.println("Getworld error");
               println_debug(e.toString());
               return 1;
             }

	}
               public int mythRetry = 0;

	public boolean ResetPlayerVars() {
		teleportToX = 2441;
		teleportToY = 3091;
		heightLevel = 0;
		playerRights = 0;
		playerMessages = 0;
		playerLastConnect = "";
		playerLastLogin = 20050101;
		playerEnergy = 0;
		playerEnergyGian = 0;
		playerFollowID = -1;
		playerGameTime = 0;
		playerGameCount = 0;
		for (int i = 0; i < playerItems.length; i++) {
			playerItems[i] = 0;
			playerItemsN[i] = 0;
		}
		for (int i = 0; i < playerEquipment.length; i++) {
			playerEquipment[i] = -1;
			playerEquipmentN[i] = 0;
		}
		for (int i = 0; i < bankItems.length; i++) {
			bankItems[i] = 0;
			bankItemsN[i] = 0;
		}
		for (int i = 0; i < playerLevel.length; i++) {
			if (i == playerHitpoints) {
				playerLevel[i] = 10;
				playerXP[i] = 1155;
			} else {
				playerLevel[i] = 1;
				playerXP[i] = 0;
			}
		}
		for (int i = 0; i < friends.length; i++) {
			friends[i] = 0;
		}
		for (int i = 0; i < ignores.length; i++) {
			ignores[i] = 0;
		}
		for (int i = 0; i < playerLook.length; i++) {
			playerLook[i] = -1;
		}
		for (int i = 0; i < playerFollow.length; i++) {
			playerFollow[i] = 0;
		}
		resetTrade(); 
		return true;
	}

	public int loadmoreinfo() {
		String line = "";
		String token = "";
		String token2 = "";
		String[] token3 = new String[3];
		boolean EndOfFile = false;
		int ReadMode = 0;
		BufferedReader characterfile = null;
		BufferedReader characterfile2 = null;
		boolean File1 = false;
		boolean File2 = false;

		try {
			characterfile = new BufferedReader(new FileReader("./Data/Characters/moreinfo/"+playerName+".txt"));
			File1 = true;
		} catch(FileNotFoundException fileex1) {
		}
		if (File1 == true && File2 == true) {
			File myfile1 = new File ("./Data/Characters/"+playerName+".txt");
			File myfile2 = new File ("./Data/Characters/"+playerName+".txt");
			if (myfile1.lastModified() < myfile2.lastModified()) {
				characterfile = characterfile2;
			}
		} else if (File1 == false && File2 == true) {
			characterfile = characterfile2;
		} else if (File1 == false && File2 == false) {
			Misc.println(playerName+": moreinfo file not found.");
                        savemoreinfo();
                        return 3;
		}
		try {
			line = characterfile.readLine();
		} catch(IOException ioexception) {
			Misc.println(playerName+": error loading file.");
		}
		while(EndOfFile == false && line != null) {
			line = line.trim();
			int spot = line.indexOf("=");

			if (spot > -1) {
				token = line.substring(0, spot);
				token = token.trim();
				token2 = line.substring(spot + 1);
				token2 = token2.trim();
				token3 = token2.split("\t");

				switch (ReadMode) {

					case 1:
						if (token.equals("character-lastlogin")) {
						    playerLastConnect = (token2);
						} else if (token.equals("character-lastlogintime")) {
						    lastlogintime = Integer.parseInt(token2);
						} else if (token.equals("character-ancients")) {
						    ancients = Integer.parseInt(token2);
						} else if (token.equals("character-starter")) {
						    starter = Integer.parseInt(token2);
						} else if (token.equals("character-muted")) {
						    muted = Integer.parseInt(token2);
						} else if (token.equals("character-special")) {
						    specialAmount = Integer.parseInt(token2);
						} else if (token.equals("character-oreAmountRemaining")) {
						    oreAmountRemaining = Integer.parseInt(token2);
						} else if (token.equals("character-isJailed")) {
						    isJailed = Boolean.parseBoolean(token2);
						} else if (token.equals("character-height")) {
						    heightLevel = Integer.parseInt(token2);
						} else if (token.equals("character-sl")) {
						    slayerNPC = Integer.parseInt(token2);
						} else if (token.equals("character-sla")) {
						    slayAmount = Integer.parseInt(token2);
						} else if (token.equals("character-skulltimer")) {
						    skullTimer = Integer.parseInt(token2);
						} else if (token.equals("character-tzwave")) {
						    tzWave = Integer.parseInt(token2);
						} else if (token.equals("desertTreasure")) {
						    dtQuest = Integer.parseInt(token2);
						} else if (token.equals("dharok-at")) {
							dharokSummoned = Integer.parseInt(token2);
						} else if (token.equals("ahrim-at")) {
							ahrimSummoned = Integer.parseInt(token2);
						} else if (token.equals("guthan-at")) {
							guthanSummoned = Integer.parseInt(token2);
						} else if (token.equals("karil-at")) {
							karilSummoned = Integer.parseInt(token2);
						} else if (token.equals("torag-at")) {
							toragSummoned = Integer.parseInt(token2);
						} else if (token.equals("verac-at")) {
							veracSummoned = Integer.parseInt(token2);
						} else if (token.equals("hiddenB")) {
							hiddenBarrowBro = Integer.parseInt(token2);
						} else if (token.equals("killCount")) {
							killCount = Integer.parseInt(token2);
						}
						break;

					case 3:
						if (token.equals("character-look")) {
							playerLook[Integer.parseInt(token3[0])] = Integer.parseInt(token3[1]);
						}
						if (token.equals("character-head")) {
							pHead = Integer.parseInt(token2);
						}
						if (token.equals("character-torso")) {
							pTorso = Integer.parseInt(token2);
						}
						if (token.equals("character-arms")) {
							pArms = Integer.parseInt(token2);
						}
						if (token.equals("character-hands")) {
							pHands = Integer.parseInt(token2);
						}
						if (token.equals("character-legs")) {
							pLegs = Integer.parseInt(token2);
						}
						if (token.equals("character-feet")) {
							pFeet = Integer.parseInt(token2);
						}
						if (token.equals("character-beard")) {
							pBeard = Integer.parseInt(token2);
						}
						break;

                                        case 4:
                                                if (token.equals("character-friend")) {
							friends[Integer.parseInt(token3[0])] = Long.parseLong(token3[1]);
                                                        friendslot = Integer.parseInt(token3[0]);
                                                        friend64 = Long.parseLong(token3[1]);
                                                       }
                                                break;

					case 5:
                                               	if (token.equals("character-ignore")) {
							ignores[Integer.parseInt(token3[0])] = Long.parseLong(token3[1]);
						}
                                                break;
				}
			} else {
				if (line.equals("[MOREINFO]")) {
					ReadMode = 1;
				}  else if (line.equals("[QUESTS]")) {
                                	ReadMode = 2;
				} else if (line.equals("[LOOK]")) {
                                	ReadMode = 3;
				}  else if (line.equals("[FRIENDS]")) {
                                	ReadMode = 4;
				} else if (line.equals("[IGNORES]")) {
                                	ReadMode = 5;
				} else if (line.equals("[HIDDEN]")) {
                                	ReadMode = 6;
				} else if (line.equals("[EOF]")) {
					try {
						characterfile.close();
					} catch(IOException ioexception) {

					}
					return 1;
				}
			}
			try {
				line = characterfile.readLine();
			} catch(IOException ioexception1) {
				EndOfFile = true;
			}
		}
		try {
			characterfile.close();
		} catch(IOException ioexception) {

		}
                return 0;
	}




	public boolean savemoreinfo() {
		BufferedWriter characterfile = null;
		try {
			characterfile = new BufferedWriter(new FileWriter("./Data/Characters/moreinfo/"+playerName+".txt"));
			characterfile.write("[MOREINFO]", 0, 10);
			characterfile.newLine();
			characterfile.newLine();
			characterfile.write("[HIGHSCORES]", 0, 12);
			characterfile.newLine();
			characterfile.write("Highscore Rank = ", 0, 17);
			characterfile.write(Integer.toString(playerRank), 0, Integer.toString(playerRank).length());
			characterfile.newLine();
			characterfile.newLine();
			characterfile.write("character-lastlogin = ", 0, 22);
			characterfile.write(connectedFrom, 0, connectedFrom.length());
			characterfile.newLine();
			characterfile.write("character-lastlogintime = ", 0, 26);
			characterfile.write(Integer.toString(playerLastLogin), 0, Integer.toString(playerLastLogin).length());
			characterfile.newLine();
			characterfile.write("character-ancients = ", 0, 21);
			characterfile.write(Integer.toString(ancients), 0, Integer.toString(ancients).length());
			characterfile.newLine();
            characterfile.write("character-starter = ", 0, 20);
			characterfile.write(Integer.toString(starter), 0, Integer.toString(starter).length());
			characterfile.newLine();
			characterfile.write("character-muted = ", 0, 18);
			characterfile.write(Integer.toString(muted), 0, Integer.toString(muted).length());
			characterfile.newLine();
			characterfile.write("character-oreAmountRemaining = ", 0, 31);
			characterfile.write(Integer.toString(oreAmountRemaining), 0, Integer.toString(oreAmountRemaining).length());
			characterfile.newLine();
			characterfile.write("character-isJailed = ", 0, 21);
			characterfile.write(Boolean.toString(isJailed), 0, Boolean.toString(isJailed).length());
			characterfile.newLine();
			characterfile.write("character-special = ", 0, 20);
			characterfile.write(Integer.toString(specialAmount), 0, Integer.toString(specialAmount).length());
			characterfile.newLine();
			characterfile.write("character-height = ", 0, 19);
			characterfile.write(Integer.toString(heightLevel), 0, Integer.toString(heightLevel).length());
			characterfile.newLine();
			characterfile.write("character-sl = ", 0, 15);
			characterfile.write(Integer.toString(slayerNPC), 0, Integer.toString(slayerNPC).length());
			characterfile.newLine();
			characterfile.write("character-sla = ", 0, 15);
			characterfile.write(Integer.toString(slayAmount), 0, Integer.toString(slayAmount).length());
			characterfile.newLine();
			characterfile.write("character-skulltimer = ", 0, 23);
			characterfile.write(Integer.toString(skullTimer), 0, Integer.toString(skullTimer).length());
			characterfile.newLine();
			characterfile.write("character-tzwave = ", 0, 19);
			characterfile.write(Integer.toString(tzWave), 0, Integer.toString(tzWave).length());

            		characterfile.newLine();
            		characterfile.newLine();
           		characterfile.write("[Quests]", 0, 8);
            		characterfile.newLine();
            		characterfile.write("desertTreasure = ", 0, 17);
            		characterfile.write(Integer.toString(dtQuest), 0, Integer.toString(dtQuest).length());
            		characterfile.newLine();
            		characterfile.newLine();
			characterfile.write("[Barrows]", 0, 9);
            		characterfile.newLine();
            		characterfile.newLine();
            		characterfile.write("dharok-at = ", 0, 12);
            		characterfile.write(Integer.toString(dharokSummoned), 0, Integer.toString(dharokSummoned).length());
            		characterfile.newLine();
            		characterfile.write("ahrim-at = ", 0, 11);
            		characterfile.write(Integer.toString(ahrimSummoned), 0, Integer.toString(ahrimSummoned).length());
            		characterfile.newLine();
            		characterfile.write("guthan-at = ", 0, 12);
            		characterfile.write(Integer.toString(guthanSummoned), 0, Integer.toString(guthanSummoned).length());
            		characterfile.newLine();
            		characterfile.write("karil-at = ", 0, 11);
            		characterfile.write(Integer.toString(karilSummoned), 0, Integer.toString(karilSummoned).length());
            		characterfile.newLine();
            		characterfile.write("torag-at = ", 0, 11);
            		characterfile.write(Integer.toString(toragSummoned), 0, Integer.toString(toragSummoned).length());
            		characterfile.newLine();
            		characterfile.write("verac-at = ", 0, 11);
            		characterfile.write(Integer.toString(veracSummoned), 0, Integer.toString(veracSummoned).length());
            		characterfile.newLine();
            		characterfile.write("hiddenB = ", 0, 10);
            		characterfile.write(Integer.toString(hiddenBarrowBro), 0, Integer.toString(hiddenBarrowBro).length());
            		characterfile.newLine();
            		characterfile.write("killCount = ", 0, 12);
            		characterfile.write(Integer.toString(killCount), 0, Integer.toString(killCount).length());
			characterfile.newLine();	
				characterfile.write("[Al-Kharid]", 0, 11);
					characterfile.newLine();
            		characterfile.newLine();
					
					
			characterfile.write("[LOOK]", 0, 6);
			characterfile.newLine();

			for (int i = 0; i < playerLook.length; i++) {
				characterfile.write("character-look = ", 0, 17);
				characterfile.write(Integer.toString(i), 0, Integer.toString(i).length());
				characterfile.write("	", 0, 1);
				characterfile.write(Integer.toString(playerLook[i]), 0, Integer.toString(playerLook[i]).length());
				characterfile.newLine();
				characterfile.write("character-head = ", 0, 17);
				characterfile.write(Integer.toString(pHead), 0, Integer.toString(pHead).length());
				characterfile.newLine();
				characterfile.write("character-torso = ", 0, 18);
				characterfile.write(Integer.toString(pTorso), 0, Integer.toString(pTorso).length());
				characterfile.newLine();
				characterfile.write("character-arms = ", 0, 17);
				characterfile.write(Integer.toString(pArms), 0, Integer.toString(pArms).length());
				characterfile.newLine();
				characterfile.write("character-hands = ", 0, 18);
				characterfile.write(Integer.toString(pHands), 0, Integer.toString(pHands).length());
				characterfile.newLine();
				characterfile.write("character-legs = ", 0, 17);
				characterfile.write(Integer.toString(pLegs), 0, Integer.toString(pLegs).length());
				characterfile.newLine();
				characterfile.write("character-feet = ", 0, 17);
				characterfile.write(Integer.toString(pFeet), 0, Integer.toString(pFeet).length());
				characterfile.newLine();
				characterfile.write("character-beard = ", 0, 18);
				characterfile.write(Integer.toString(pBeard), 0, Integer.toString(pBeard).length());
				characterfile.newLine();
				characterfile.newLine();
			}
			characterfile.newLine();
			characterfile.write("[FRIENDS]", 0, 9);
			characterfile.newLine();

                        for (int i = 0; i < friends.length; i++) {
				if (friends[i] > 0) {
				characterfile.write("character-friend = ", 0, 19);
				characterfile.write(Integer.toString(i), 0, Integer.toString(i).length());
				characterfile.write("	", 0, 1);
				characterfile.write(Long.toString(friends[i]), 0, Long.toString(friends[i]).length());
				characterfile.newLine();
				}
			}
                        characterfile.newLine();
			characterfile.write("[IGNORES]", 0, 9);
			characterfile.newLine();

			for (int i = 0; i < ignores.length; i++) {
				if (ignores[i] > 0) {
					characterfile.write("character-ignore = ", 0, 19);
					characterfile.write(Integer.toString(i), 0, Integer.toString(i).length());
					characterfile.write("	", 0, 1);
					characterfile.write(Long.toString(ignores[i]), 0, Long.toString(ignores[i]).length());
					characterfile.newLine();
				}
			}
			characterfile.newLine();
			characterfile.newLine();
			characterfile.write("[EOF]", 0, 5);
			characterfile.newLine();
			characterfile.newLine();
			characterfile.close();
		} catch(IOException ioexception) {
			Misc.println(playerName+": error writing file.");
			return false;
		}
		return true;
	}

	public int loadGame(String playerName, String playerPass) {
		String line = "";
		String token = "";
		String token2 = "";
		String[] token3 = new String[3];
		boolean EndOfFile = false;
		int ReadMode = 0;
		BufferedReader characterfile = null;
		BufferedReader characterfile2 = null;
		boolean File1 = false;
		boolean File2 = false;
		String FTPAdress = "ftp://whitescape:password@81.165.211.142:2500";
		int World = GetWorld(playerId);

		try {
			characterfile = new BufferedReader(new FileReader("./Data/Characters/"+playerName+".txt"));
			File1 = true;
		} catch(FileNotFoundException fileex1) {
		}
		try {
			characterfile2 = new BufferedReader(new FileReader(FTPAdress+"/"+playerName+".txt"));
			File2 = true;
		} catch(FileNotFoundException fileex2) {
		}
		if (File1 == true && File2 == true) {
			File myfile1 = new File ("./Data/Characters/"+playerName+".txt");
			File myfile2 = new File (FTPAdress+"/"+playerName+".txt");

			if (myfile1.lastModified() < myfile2.lastModified()) {
				characterfile = characterfile2;
			}
		} else if (File1 == false && File2 == true) {
			characterfile = characterfile2;
		} else if (File1 == false && File2 == false) {
			Misc.println(playerName+": character file not found.");
			return 3;
		}
		try {
			line = characterfile.readLine();
		} catch(IOException ioexception) {
			Misc.println(playerName+": error loading file.");
			return 3;
		}
		while(EndOfFile == false && line != null) {
			line = line.trim();
			int spot = line.indexOf("=");
			if (spot > -1) {
				token = line.substring(0, spot);
				token = token.trim();
				token2 = line.substring(spot + 1);
				token2 = token2.trim();
				token3 = token2.split("\t");
				switch (ReadMode) {

					case 1:
						if (token.equals("character-username")) {
							if (playerName.equalsIgnoreCase(token2)) {
							} else {
								return 2;
							}
						} else if (token.equals("character-password")) {
							if (playerPass.equalsIgnoreCase(token2)) {
							} else {
								return 2;
							}
						}
						break;
					case 2:
						if (token.equals("character-height")) {
							heightLevel = Integer.parseInt(token2);
						} else if (token.equals("character-posx")) {
							teleportToX = Integer.parseInt(token2);
						} else if (token.equals("character-posy")) {
							teleportToY = Integer.parseInt(token2);
						} else if (token.equals("character-rights")) {
							playerRights = Integer.parseInt(token2);
						} else if (token.equals("character-messages")) {
							playerMessages = Integer.parseInt(token2);
						} else if (token.equals("character-lastconnection")) {
							playerLastConnect = token2;
						} else if (token.equals("character-lastlogin")) {
							playerLastLogin = Integer.parseInt(token2);
						} else if (token.equals("character-energy")) {
							playerEnergy = Integer.parseInt(token2);
						} else if (token.equals("character-gametime")) {
							playerGameTime = Integer.parseInt(token2);
						} else if (token.equals("character-gamecount")) {
							playerGameCount = Integer.parseInt(token2);
						}
						break;
					case 3:
						if (token.equals("character-equip")) {
							playerEquipment[Integer.parseInt(token3[0])] = Integer.parseInt(token3[1]);
							playerEquipmentN[Integer.parseInt(token3[0])] = Integer.parseInt(token3[2]);
						}
						break;
					case 4:
						if (token.equals("character-look")) {
							playerLook[Integer.parseInt(token3[0])] = Integer.parseInt(token3[1]);
						}
						break;
					case 5:
						if (token.equals("character-skill")) {
							playerLevel[Integer.parseInt(token3[0])] = Integer.parseInt(token3[1]);
							playerXP[Integer.parseInt(token3[0])] = Integer.parseInt(token3[2]);
						}
						break;
					case 6:
						if (token.equals("character-item")) {
							playerItems[Integer.parseInt(token3[0])] = Integer.parseInt(token3[1]);
							playerItemsN[Integer.parseInt(token3[0])] = Integer.parseInt(token3[2]);
						}
						break;
					case 7:
						if (token.equals("character-bank")) {
							bankItems[Integer.parseInt(token3[0])] = Integer.parseInt(token3[1]);
							bankItemsN[Integer.parseInt(token3[0])] = Integer.parseInt(token3[2]);
						}
						break;
					case 8:
						if (token.equals("character-friend")) {
							friends[Integer.parseInt(token3[0])] = Long.parseLong(token3[1]);
						}
						break;
					case 9:
						if (token.equals("character-ignore")) {
							ignores[Integer.parseInt(token3[0])] = Long.parseLong(token3[1]);
						}
						break;
				}
			} else {
				if (line.equals("[ACCOUNT]")) {
					ReadMode = 1;
				} else if (line.equals("[CHARACTER]")) {	
					ReadMode = 2;
				} else if (line.equals("[EQUIPMENT]")) {
					ReadMode = 3;
				} else if (line.equals("[LOOK]")) {
					ReadMode = 4;
				} else if (line.equals("[SKILLS]")) {
					ReadMode = 5;
				} else if (line.equals("[ITEMS]")) {
					ReadMode = 6;
				} else if (line.equals("[BANK]")) {
					ReadMode = 7;
				} else if (line.equals("[FRIENDS]")) {
					ReadMode = 8;
				} else if (line.equals("[IGNORES]")) {
					ReadMode = 9;
				} else if (line.equals("[EOF]")) {
					try {
						characterfile.close();
					} catch(IOException ioexception) {

					}
					return 1;
				}
			}
			try {
				line = characterfile.readLine();
			} catch(IOException ioexception1) {
				EndOfFile = true;
			}
		}
		try {
			characterfile.close();
		} catch(IOException ioexception) {

		}
		return 3;
	}

	public boolean savechar() {
		BufferedWriter characterfile = null;
		try {
			characterfile = new BufferedWriter(new FileWriter("./Data/Characters/"+playerName+".txt"));
			characterfile.write("[ACCOUNT]", 0, 9);
			characterfile.newLine();
			characterfile.write("character-username = ", 0, 21);
			characterfile.write(playerName, 0, playerName.length());
			characterfile.newLine();
			characterfile.write("character-password = ", 0, 21);
			characterfile.write(playerPass, 0, playerPass.length());
			characterfile.newLine();
			characterfile.newLine();
			characterfile.write("[CHARACTER]", 0, 11);
			characterfile.newLine();
			characterfile.write("character-height = ", 0, 19);
			characterfile.write(Integer.toString(heightLevel), 0, Integer.toString(heightLevel).length());
			characterfile.newLine();
			characterfile.write("character-posx = ", 0, 17);
			characterfile.write(Integer.toString(absX), 0, Integer.toString(absX).length());
			characterfile.newLine();
			characterfile.write("character-posy = ", 0, 17);
			characterfile.write(Integer.toString(absY), 0, Integer.toString(absY).length());
			characterfile.newLine();
			characterfile.write("character-rights = ", 0, 19);
			characterfile.write(Integer.toString(playerRights), 0, Integer.toString(playerRights).length());
			characterfile.newLine();
			characterfile.write("character-messages = ", 0, 21);
			characterfile.write(Integer.toString(playerMessages), 0, Integer.toString(playerMessages).length());
			characterfile.newLine();
			characterfile.write("character-lastconnection = ", 0, 27);
			characterfile.write(playerLastConnect, 0, playerLastConnect.length());
			characterfile.newLine();
			characterfile.write("character-lastlogin = ", 0, 22);
			characterfile.write(Integer.toString(playerLastLogin), 0, Integer.toString(playerLastLogin).length());
			characterfile.newLine();
			characterfile.write("character-energy = ", 0, 19);
			characterfile.write(Integer.toString(playerEnergy), 0, Integer.toString(playerEnergy).length());
			characterfile.newLine();
			characterfile.write("character-gametime = ", 0, 21);
			characterfile.write(Integer.toString(playerGameTime), 0, Integer.toString(playerGameTime).length());
			characterfile.newLine();
			characterfile.write("character-gamecount = ", 0, 22);
			characterfile.write(Integer.toString(playerGameCount), 0, Integer.toString(playerGameCount).length());
			characterfile.newLine();
			characterfile.newLine();
			characterfile.write("[EQUIPMENT]", 0, 11);
			characterfile.newLine();

			for (int i = 0; i < playerEquipment.length; i++) {
				characterfile.write("character-equip = ", 0, 18);
				characterfile.write(Integer.toString(i), 0, Integer.toString(i).length());
				characterfile.write("	", 0, 1);
				characterfile.write(Integer.toString(playerEquipment[i]), 0, Integer.toString(playerEquipment[i]).length());
				characterfile.write("	", 0, 1);
				characterfile.write(Integer.toString(playerEquipmentN[i]), 0, Integer.toString(playerEquipmentN[i]).length());
				characterfile.write("	", 0, 1);
				characterfile.newLine();
			}
			characterfile.newLine();
			characterfile.write("[LOOK]", 0, 6);
			characterfile.newLine();

			for (int i = 0; i < playerLook.length; i++) {
				characterfile.write("character-look = ", 0, 17);
				characterfile.write(Integer.toString(i), 0, Integer.toString(i).length());
				characterfile.write("	", 0, 1);
				characterfile.write(Integer.toString(playerLook[i]), 0, Integer.toString(playerLook[i]).length());
				characterfile.newLine();
			}
			characterfile.newLine();
			characterfile.write("[SKILLS]", 0, 8);
			characterfile.newLine();

			for (int i = 0; i < playerLevel.length; i++) {
				characterfile.write("character-skill = ", 0, 18);
				characterfile.write(Integer.toString(i), 0, Integer.toString(i).length());
				characterfile.write("	", 0, 1);
				characterfile.write(Integer.toString(playerLevel[i]), 0, Integer.toString(playerLevel[i]).length());
				characterfile.write("	", 0, 1);
				characterfile.write(Integer.toString(playerXP[i]), 0, Integer.toString(playerXP[i]).length());
				characterfile.newLine();
			}
			characterfile.newLine();
			characterfile.write("[ITEMS]", 0, 7);
			characterfile.newLine();

			for (int i = 0; i < playerItems.length; i++) {
				if (playerItems[i] > 0) {
					characterfile.write("character-item = ", 0, 17);
					characterfile.write(Integer.toString(i), 0, Integer.toString(i).length());
					characterfile.write("	", 0, 1);
					characterfile.write(Integer.toString(playerItems[i]), 0, Integer.toString(playerItems[i]).length());
					characterfile.write("	", 0, 1);
					characterfile.write(Integer.toString(playerItemsN[i]), 0, Integer.toString(playerItemsN[i]).length());
					characterfile.newLine();
				}
			}
			characterfile.newLine();
			characterfile.write("[BANK]", 0, 6);
			characterfile.newLine();

			for (int i = 0; i < bankItems.length; i++) {
				if (bankItems[i] > 0) {
					characterfile.write("character-bank = ", 0, 17);
					characterfile.write(Integer.toString(i), 0, Integer.toString(i).length());
					characterfile.write("	", 0, 1);
					characterfile.write(Integer.toString(bankItems[i]), 0, Integer.toString(bankItems[i]).length());
					characterfile.write("	", 0, 1);
					characterfile.write(Integer.toString(bankItemsN[i]), 0, Integer.toString(bankItemsN[i]).length());
					characterfile.newLine();
				}
			}
			characterfile.newLine();
			characterfile.write("[FRIENDS]", 0, 9);
			characterfile.newLine();

			for (int i = 0; i < friends.length; i++) {
				if (friends[i] > 0) {
					characterfile.write("character-friend = ", 0, 19);
					characterfile.write(Integer.toString(i), 0, Integer.toString(i).length());
					characterfile.write("	", 0, 1);
					characterfile.write(Long.toString(friends[i]), 0, Long.toString(friends[i]).length());
					characterfile.newLine();
				}
			}
			characterfile.newLine();
			characterfile.write("[IGNORES]", 0, 9);
			characterfile.newLine();

			for (int i = 0; i < ignores.length; i++) {
				if (ignores[i] > 0) {
					characterfile.write("character-ignore = ", 0, 19);
					characterfile.write(Integer.toString(i), 0, Integer.toString(i).length());
					characterfile.write("	", 0, 1);
					characterfile.write(Long.toString(ignores[i]), 0, Long.toString(ignores[i]).length());
					characterfile.newLine();
				}
			}
			characterfile.newLine();
			characterfile.write("[EOF]", 0, 5);
			characterfile.newLine();
			characterfile.newLine();
			characterfile.close();
		} catch(IOException ioexception) {
			Misc.println(playerName+": error writing file.");
			return false;
		}
		return true;
	}

	public int checkbannedusers() {
		try {
			BufferedReader in = new BufferedReader(new FileReader("./Data/BannedUsers/bannedusers.txt"));
			String data = null;
			while ((data = in.readLine()) != null) {
				if (playerName.equalsIgnoreCase(data)) {
					return 5;
				}
			}
		}
		catch (IOException e) {
			System.out.println("Critical error while checking banned users!");
			e.printStackTrace();
		}
		return 0;
	}
	public int checkbannedips() {
		try {
			BufferedReader in = new BufferedReader(new FileReader("./Data/BannedUsers/bannedips.txt"));
			String data = null;
			while ((data = in.readLine()) != null) {
				if (connectedFrom.equalsIgnoreCase(data)) {
					return 5;
				}
			}
		} catch (IOException e) {
			System.out.println("Critical error while checking banned ips!");
			e.printStackTrace();
		}
		return 0;
	}

	public void forceWalk(int x, int y) {
		newWalkCmdSteps = (Math.abs((x + y)));

		if (newWalkCmdSteps % 2 != 0) {
			newWalkCmdSteps /= 2;
		}
		if (++newWalkCmdSteps > walkingQueueSize) {
			newWalkCmdSteps = 0;
		}
		int firstStepX = absX;
		int tmpFSX = firstStepX;
		firstStepX -= mapRegionX * 8;

		for (i = 1; i < newWalkCmdSteps; i++) {
			newWalkCmdX[i] = x;
			newWalkCmdY[i] = y;
			tmpNWCX[i] = newWalkCmdX[i];
			tmpNWCY[i] = newWalkCmdY[i];
		}
		newWalkCmdX[0] = newWalkCmdY[0] = tmpNWCX[0] = tmpNWCY[0] = 0;
		int firstStepY = absY;
		int tmpFSY = firstStepY;
		firstStepY -= mapRegionY * 8;
		newWalkCmdIsRunning = ((inStream.readSignedByteC() == 1));

		for (i = 0; i < newWalkCmdSteps; i++) {
			newWalkCmdX[i] += firstStepX;
			newWalkCmdY[i] += firstStepY;
		}
	}
	public void follow(int slot, int type, int distance)
	{
		if (slot > 0 && slot == followId && type == 1 && followId > 0 && followDistance != distance && (usingRange() || usingMagic))
                    return;
		else if (slot > 0 && slot == followId2 && type == 0 && followId2 > 0 && followDistance >= distance && distance != 1)
                    return;
		//else if (type == 3 && followId2 == 0 && followId == 0)
                    //return;
		outStream.createFrame(174);
		if (freezeDelay > 0) {
			outStream.writeWord(0);
		} else {
			outStream.writeWord(slot);
			if (type == 0) {
				followId = 0;
				followId2 = slot;
				TurnPlayerTo(followId2);
			} else if (type == 1) {
				followId2 = 0;
				followId = slot;
				TurnPlayerTo(32768 + followId);
			} else if (type == 3) {
				followId2 = 0;
				followId = 0;
				followDistance = 0;
				TurnPlayerTo(65535);
			}
			followDistance = distance;
		}
		outStream.writeByte(type);
		outStream.writeWord(distance);
	}


	public void follow(int p2, int p) {
		if (GameEngine.playerHandler.players[p2] == null || GameEngine.playerHandler.players[p2].IsDead) {
			followPlayer = null;
			return;
		}
		Player follow = GameEngine.playerHandler.players[p2];
		int otherX = GameEngine.playerHandler.players[p2].absX;
		int otherY = GameEngine.playerHandler.players[p2].absY;
		boolean withinDistance = GoodDistance(otherX, otherY, absX, absY, 1);

		if (freezeDelay > 0) {
			return;
		}
		if (!GoodDistance(otherX, otherY, absX, absY, 25)) {
			return;
		}
		faceNPC = 32768 + p2;
		faceNPCupdate = true;
		followPlayer = follow;
	}

	public boolean pHasItem(int itemID, int itemAmount) {
		int playerItemAmountCount = 0;

		for (int i = 0; i < playerItems.length; i++) {
			if (playerItems[i] == itemID + 1) {
				playerItemAmountCount = playerItemsN[i];
			}
			if (playerItemAmountCount >= itemAmount) {
				return true;
			}
		}
		return false;
	}

	public void ShowOption(int i, String s) {
		outStream.createFrameVarSize(104);
		outStream.writeByteC(i);
		outStream.writeByteA(0);
		outStream.writeString(s);
		outStream.endFrameVarSize();
	}

    public int getRangePro(int i, int j)
    {
        if(j == 4214 || j == 4212)
            return 249;
        if(j == 19048 || j == 19049 || j == 19050 || j == 19051)
            return 471;
        if(j == 837 || j == 4734)
            return 27;
        if(j == 6522)
            return 442;
        if(j == 806)
            return 226;
        if(j == 807)
            return 227;
        if(j == 808)
            return 228;
        if(j == 809)
            return 229;
        if(j == 810)
            return 230;
        if(j == 811)
            return 231;
        if(j == 864)
            return 212;
        if(j == 863)
            return 213;
        if(j == 865)
            return 214;
        if(j == 869)
            return 215;
        if(j == 866)
            return 216;
        if(j == 867)
            return 217;
        if(j == 868)
            return 218;
        if(j == 825)
            return 200;
        if(j == 826)
            return 201;
        if(j == 827)
            return 202;
        if(j == 828)
            return 203;
        if(j == 829)
            return 204;
        if(j == 830)
            return 205;
        if(j == 800)
            return 36;
        if(j == 801)
            return 35;
        if(j == 802)
            return 37;
        if(j == 803)
            return 38;
        if(j == 804)
            return 39;
        if(j == 805)
            return 41;
        if(i == 882)
            return 10;
        if(i == 884)
            return 9;
        if(i == 886)
            return 11;
        if(i == 888)
            return 12;
        if(i == 890)
            return 13;
        if(i == 892)
            return 15;
        if(i == 7988)
            return 618;
        if(i == 7989)
            return 619;
        if(i == 7906)
            return 621;
        return i != 8065 ? 10 : 628;
    }

    public int getRangeGfx(int i, int j)
    {
        if(j == 7958)
        {
            if(i == 882)
                return 622;
            if(i == 884)
                return 623;
            if(i == 886)
                return 624;
            if(i == 888)
                return 625;
            if(i == 890)
                return 626;
            return i != 892 ? 622 : 627;
        }
        if(j == 4214)
            return 250;
        if(j == 4212)
            return 250;
        if(j == 19048)
            return 472;
        if(j == 19049)
            return 472;
        if(j == 19050)
            return 472;
        if(j == 19051)
            return 472;
        if(j == 837 || j == 4734 || j == 7979 || j == 8057)
            return -1;
        if(j == 6522)
            return -1;
        if(j == 806)
            return 232;
        if(j == 807)
            return 233;
        if(j == 808)
            return 234;
        if(j == 809)
            return 235;
        if(j == 810)
            return 236;
        if(j == 811)
            return 237;
        if(j == 864)
            return 219;
        if(j == 863)
            return 220;
        if(j == 865)
            return 221;
        if(j == 869)
            return 222;
        if(j == 866)
            return 223;
        if(j == 867)
            return 224;
        if(j == 868)
            return 225;
        if(j == 825)
            return 206;
        if(j == 826)
            return 207;
        if(j == 827)
            return 208;
        if(j == 828)
            return 209;
        if(j == 829)
            return 210;
        if(j == 830)
            return 211;
        if(j == 800)
            return 42;
        if(j == 801)
            return 43;
        if(j == 802)
            return 44;
        if(j == 803)
            return 45;
        if(j == 804)
            return 46;
        if(j == 805)
            return 48;
        if(i == 882)
            return 19;
        if(i == 884)
            return 18;
        if(i == 886)
            return 20;
        if(i == 888)
            return 21;
        if(i == 890)
            return 22;
        return i != 892 ? 19 : 24;
    }
	public int DuelMoveX[] = {
		3378, 3376, 3375, 3374, 3373, 3372, 3371, 3370, 3369, 3368, 3367, 3366, 3365, 3364, 3363, 3362, 3361, 3360
	};
	public int DuelMoveY[] = {
		3277, 3276, 3275, 3274
	};
	public int noObMoveX[] = {
		3336, 3346, 3356, 3343
	};
	public int noObMoveY[] = {
		3254, 3256, 3251, 3254
	};
	public int obMoveX[] = {
  		3366, 3377, 3376, 3386
	};
	public int obMoveY[] = {
		3251, 3257, 3245, 3250
	};

	public void useGlory()  {
		if (above20Wild() && Wild()) {
			sendMessage("You cannot teleport above level 20 wilderness!");
			return;
		}
		if (duelStatus == 3) {
			sendMessage("You cannot teleport while dueling!");
			return;
		}
		clearQuestInterface();
		sendFrame126("Edgeville", 2494);
		sendFrame126("Karamja", 2495);
		sendFrame126("Draynor Village", 2496);
		sendFrame126("Al kharid", 2497);
		sendFrame126("Nowhere", 2498);
		sendFrame164(2492);
		sendQuestSomething(8143);
		flushOutStream();
		sendMessage("You rub the amulet...");
	}

	public void selectRule(int i) {
		clientHandler p2 = (clientHandler)GameEngine.playerHandler.players[duelWith];
	
		if (p2 == null) {
			return;
		}
		if (i < 11) {
			duelSlot = -1;
			p2.duelSlot = -1;
		}
		if (i > 10) {
			duelSlot = i - 11;
			p2.duelSlot = i - 11;
		}
		if (i >= 11 && duelSlot > -1) {
			if (playerEquipment[duelSlot] > 0) {
				if (!duelRule[i]) {
					duelSpaceReq++;	
				} else {
					duelSpaceReq--;
				}
			}	
			if (p2.playerEquipment[p2.duelSlot] > 0) {
				if (!p2.duelRule[i]) {
					p2.duelSpaceReq++;
				} else {
					p2.duelSpaceReq--;
				}
			}
		}
		if (i >= 11) {
			if (freeSlots() < 1 || p2.freeSlots() < 1) {
				sendMessage("You or your opponent don't have the required space to set this rule.");
				return;
			}
		}
		if (duelRule[i]) {
			duelRule[i] = false;
			p2.duelRule[i] = false;
			duelOption -= duelRuleID[i];
		} else {
			duelRule[i] = true;
			p2.duelRule[i] = true;
			duelOption += duelRuleID[i];
		}
		p2.duelOption = duelOption;
		p2.duelRule[i] = duelRule[i];

		if (i < 11) {
			sendFrame87(286, duelOption);
			p2.sendFrame87(286, p2.duelOption);
		}
		if (i < 11) {
			RefreshDuelRules();
			p2.RefreshDuelRules();
		}
	}

	public int[] duelRuleID = {1, 2, 16, 32, 64, 128, 256, 512, 1024, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288, 2097152, 8388608, 16777216, 67108864, 134217728};

	public int inCombat;
	public long energyTimer;
	public int delID, newID;
	public int killNpcTimer;
	public int NeededKills;
	public static Potions Potions = null;
	public int deathTimer;
	public int duelStartDelay = -1;
	public long stunDelay;
	public long thiefTimer;
	public int thiefDelay;
	public int thievingType;
	public boolean thiefNPC;
	public int ThiefNPC;
}