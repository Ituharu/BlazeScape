package com.iClarity.player;

import java.io.*;
import com.iClarity.GameEngine;

public class Potions {

	public static void potionUse(clientHandler p, int k, int item, int newItem, String message) {
		if (System.currentTimeMillis() - p.potTimer >= 1500) {
	    		p.setSkillLevel(k, p.playerLevel[k], p.playerXP[k]);
            		p.ReplaceItems(newItem, item, 1, 1);
            		p.updateRequired = true;
            		p.ResetAttack();
            		p.ResetAttackNPC();
            		p.setAnimation(0x33D);
            		p.frame174(334, 000, 000);
            		p.appearanceUpdateRequired = true;
	    		p.potTimer = System.currentTimeMillis();
			p.sendMessage(message);
            		p.goOn = false;
		}
	}

	public static boolean CheckForSkillUse3(int Item, int Slot, int playerId) {
		clientHandler c = (clientHandler) GameEngine.playerHandler.players[playerId];
		c.ResetAttack();
		c.ResetAttackNPC();

		if (!c.duelRule[6]) {
        		switch (Item) {

        			case 143: // Prayer potion (1)
					c.playerLevel[5] += 19;

            				if (c.playerLevel[5] > c.getLevelForXP(c.playerXP[5])) {
                				c.playerLevel[5] = c.getLevelForXP(c.playerXP[5]);
           				}
					potionUse(c, 5, 143, 229, "You drink a dose of the prayer potion.");
            				break;


				case 141: // Prayer potion (2)
					c.playerLevel[5] += 19;

            				if (c.playerLevel[5] > c.getLevelForXP(c.playerXP[5])) {
                				c.playerLevel[5] = c.getLevelForXP(c.playerXP[5]);
            				}
					potionUse(c, 5, 141, 143, "You drink a dose of the prayer potion.");
            				break;

				case 139: // Prayer potion (3)
					c.playerLevel[5] += 19;

            				if (c.playerLevel[5] > c.getLevelForXP(c.playerXP[5])) {
                				c.playerLevel[5] = c.getLevelForXP(c.playerXP[5]);
            				}
					potionUse(c, 5, 139, 141, "You drink a dose of the prayer potion.");
            				break;

				case 2434: // Prayer potion (4)
					c.playerLevel[5] += 19;

            				if (c.playerLevel[5] > c.getLevelForXP(c.playerXP[5])) {
                				c.playerLevel[5] = c.getLevelForXP(c.playerXP[5]);
            				}
					potionUse(c, 5, 2434, 139, "You drink a dose of the prayer potion.");
            				break;

				case 131: // Restore potion (1)
					c.restorePot();
					potionUse(c, 0, 131, 229, "You drink a dose of the restore potion.");
            				break;

				case 129: // Restore potion (2)
					c.restorePot();
					potionUse(c, 0, 129, 131, "You drink a dose of the restore potion.");
            				break;

				case 127: // Restore potion (2)
					c.restorePot();
					potionUse(c, 0, 127, 129, "You drink a dose of the restore potion.");
            				break;

				case 2430: // Restore potion (4)
					c.restorePot();
					potionUse(c, 0, 2430, 127, "You drink a dose of the restore potion.");
            				break;

				case 3030: // Super Restore potion (1)
					c.restorePot();
					potionUse(c, 5, 3030, 229, "You drink a dose of the super restore potion.");
            				break;

				case 3028: // Super Restore potion (2)
					c.restorePot();
					potionUse(c, 5, 3028, 3030, "You drink a dose of the super restore potion.");
            				break;

				case 3026: // Super Restore potion (3)
					c.restorePot();
					potionUse(c, 5, 3026, 3028, "You drink a dose of the super restore potion.");
            				break;

				case 3024: // Super Restore potion (4)
					c.restorePot();
					potionUse(c, 5, 3024, 2026, "You drink a dose of the super restore potion.");
            				break;

				case 2446: // Antipoison (4)
					c.Poisoned = false;
					c.PoisonDelay = -1;
					potionUse(c, 0, 2446, 175, "You drink a dose of the antipoison.");
            				break;

				case 175: // Antipoison (3)
					c.Poisoned = false;
					c.PoisonDelay = -1;
					potionUse(c, 0, 175, 177, "You drink a dose of the antipoison.");
            				break;

				case 177: // Antipoison (2)
					c.Poisoned = false;
					c.PoisonDelay = -1;
					potionUse(c, 0, 177, 179, "You drink a dose of the antipoison.");
            				break;

				case 179: // Antipoison (1)
					c.Poisoned = false;
					c.PoisonDelay = -1;
					potionUse(c, 0, 179, 229, "You drink a dose of the antipoison.");
            				break;

				case 2448: // Super Antipoison (4)
					c.Poisoned = false;
					c.PoisonDelay = -1;
					potionUse(c, 0, 2448, 181, "You drink a dose of the super antipoison.");
            				break;

				case 181: // Super Antipoison (3)
					c.Poisoned = false;
					c.PoisonDelay = -1;
					potionUse(c, 0, 181, 183, "You drink a dose of the super antipoison.");
            				break;

				case 183: // Super Antipoison (2)
					c.Poisoned = false;
					c.PoisonDelay = -1;
					potionUse(c, 0, 183, 185, "You drink a dose of the super antipoison.");
            				break;

				case 185: // Super Antipoison (1)
					c.Poisoned = false;
					c.PoisonDelay = -1;
					potionUse(c, 0, 185, 229, "You drink a dose of the super antipoison.");
            				break;

				case 161: // Super Strength potion (1)
            				c.strPot = true;
            				c.strPotTimer = 90;
            				c.abc = c.getLevelForXP(c.playerXP[2]);
           				c.cba = c.abc / 10;
            				c.abc2 = c.cba * 2;

            				if (c.abc2 <= 1) {
                				c.abc2 = 2;
            				}
            				c.playerLevel[2] = c.getLevelForXP(c.playerXP[2]);
            				c.playerLevel[2] += c.abc2;
					potionUse(c, 2, 161, 229, "You drink a dose of the super strength potion.");
            				break;     

				case 159: // Super Strength potion (2)
            				c.strPot = true;
            				c.strPotTimer = 90;
            				c.abc = c.getLevelForXP(c.playerXP[2]);
           				c.cba = c.abc / 10;
            				c.abc2 = c.cba * 2;

            				if (c.abc2 <= 1) {
                				c.abc2 = 2;
            				}
            				c.playerLevel[2] = c.getLevelForXP(c.playerXP[2]);
            				c.playerLevel[2] += c.abc2;
					potionUse(c, 2, 159, 161, "You drink a dose of the super strength potion.");
            				break; 

				case 157: // Super Strength potion (3)
            				c.strPot = true;
            				c.strPotTimer = 90;
            				c.abc = c.getLevelForXP(c.playerXP[2]);
           				c.cba = c.abc / 10;
            				c.abc2 = c.cba * 2;

            				if (c.abc2 <= 1) {
                				c.abc2 = 2;
            				}
            				c.playerLevel[2] = c.getLevelForXP(c.playerXP[2]);
            				c.playerLevel[2] += c.abc2;
					potionUse(c, 2, 157, 159, "You drink a dose of the super strength potion.");
            				break; 

				case 2440: // Super Strength potion (4)
            				c.strPot = true;
            				c.strPotTimer = 90;
            				c.abc = c.getLevelForXP(c.playerXP[2]);
           				c.cba = c.abc / 10;
            				c.abc2 = c.cba * 2;

            				if (c.abc2 <= 1) {
                				c.abc2 = 2;
            				}
            				c.playerLevel[2] = c.getLevelForXP(c.playerXP[2]);
            				c.playerLevel[2] += c.abc2;
					potionUse(c, 2, 2440, 157, "You drink a dose of the super strength potion.");
            				break; 

				case 113: // Strength potion (4)
            				c.strPot = true;
            				c.strPotTimer = 90;
            				c.abc = c.getLevelForXP(c.playerXP[2]);
            				c.cba = c.abc / 10;
            				c.aaa = c.cba / 2;
            				c.abc2 = c.aaa + c.cba;

            				if (c.abc2 <= 1) {
                				c.abc2 = 2;
            				}
            				c.playerLevel[2] = c.getLevelForXP(c.playerXP[2]);
            				c.playerLevel[2] += c.abc2;
					potionUse(c, 2, 113, 115, "You drink a dose of the strength potion.");
            				break; 


				case 115: // Strength potion (3)
            				c.strPot = true;
            				c.strPotTimer = 90;
            				c.abc = c.getLevelForXP(c.playerXP[2]);
            				c.cba = c.abc / 10;
            				c.aaa = c.cba / 2;
            				c.abc2 = c.aaa + c.cba;

            				if (c.abc2 <= 1) {
                				c.abc2 = 2;
            				}
            				c.playerLevel[2] = c.getLevelForXP(c.playerXP[2]);
            				c.playerLevel[2] += c.abc2;
					potionUse(c, 2, 115, 117, "You drink a dose of the strength potion.");
            				break; 

				case 117: // Strength potion (2)
            				c.strPot = true;
            				c.strPotTimer = 90;
            				c.abc = c.getLevelForXP(c.playerXP[2]);
            				c.cba = c.abc / 10;
            				c.aaa = c.cba / 2;
            				c.abc2 = c.aaa + c.cba;

            				if (c.abc2 <= 1) {
                				c.abc2 = 2;
            				}
            				c.playerLevel[2] = c.getLevelForXP(c.playerXP[2]);
            				c.playerLevel[2] += c.abc2;
					potionUse(c, 2, 117, 119, "You drink a dose of the strength potion.");
            				break; 

				case 119: // Strength potion (1)
            				c.strPot = true;
            				c.strPotTimer = 90;
            				c.abc = c.getLevelForXP(c.playerXP[2]);
            				c.cba = c.abc / 10;
            				c.aaa = c.cba / 2;
            				c.abc2 = c.aaa + c.cba;

            				if (c.abc2 <= 1) {
                				c.abc2 = 2;
            				}
            				c.playerLevel[2] = c.getLevelForXP(c.playerXP[2]);
            				c.playerLevel[2] += c.abc2;
					potionUse(c, 2, 119, 229, "You drink a dose of the strength potion.");
            				break; 

				case 149: // Super attack (1)
            				c.attPot = true;
            				c.attPotTimer = 90;
             				c.abc = c.getLevelForXP(c.playerXP[0]);
            				c.cba = c.abc / 10;
            				c.abc2 = c.cba * 2;

            				if (c.abc2 <= 1) {
             					c.abc2 = 2;
            				}
            				c.playerLevel[0] = c.getLevelForXP(c.playerXP[0]);
            				c.playerLevel[0] += c.abc2;
					potionUse(c, 0, 149, 229, "You drink a dose of the super attack potion.");
            				break; 

				case 147: // Super attack (2)
            				c.attPot = true;
            				c.attPotTimer = 90;
             				c.abc = c.getLevelForXP(c.playerXP[0]);
            				c.cba = c.abc / 10;
            				c.abc2 = c.cba * 2;

            				if (c.abc2 <= 1) {
             					c.abc2 = 2;
            				}
            				c.playerLevel[0] = c.getLevelForXP(c.playerXP[0]);
            				c.playerLevel[0] += c.abc2;
					potionUse(c, 0, 147, 149, "You drink a dose of the super attack potion.");
            				break; 

				case 145: // Super attack (3)
            				c.attPot = true;
            				c.attPotTimer = 90;
             				c.abc = c.getLevelForXP(c.playerXP[0]);
            				c.cba = c.abc / 10;
            				c.abc2 = c.cba * 2;

            				if (c.abc2 <= 1) {
             					c.abc2 = 2;
            				}
            				c.playerLevel[0] = c.getLevelForXP(c.playerXP[0]);
            				c.playerLevel[0] += c.abc2;
					potionUse(c, 0, 145, 147, "You drink a dose of the super attack potion.");
            				break; 

				case 2436: // Super attack (4)
            				c.attPot = true;
            				c.attPotTimer = 90;
             				c.abc = c.getLevelForXP(c.playerXP[0]);
            				c.cba = c.abc / 10;
            				c.abc2 = c.cba * 2;

            				if (c.abc2 <= 1) {
             					c.abc2 = 2;
            				}
            				c.playerLevel[0] = c.getLevelForXP(c.playerXP[0]);
            				c.playerLevel[0] += c.abc2;
					potionUse(c, 0, 2436, 145, "You drink a dose of the super attack potion.");
            				break;

				case 2442: // Super defence (4)
            				c.defPot = true;
            				c.defPotTimer = 90;
            				c.abc = c.getLevelForXP(c.playerXP[1]);
            				c.cba = c.abc / 10;
            				c.abc2 = c.cba * 2;

            				if (c.abc2 <= 1) {
                				c.abc2 = 2;
            				}
            				c.playerLevel[1] = c.getLevelForXP(c.playerXP[1]);
            				c.playerLevel[1] += c.abc2;
					potionUse(c, 1, 2442, 163, "You drink a dose of the super defence potion.");
            				break;

				case 163: // Super defence (3)
            				c.defPot = true;
            				c.defPotTimer = 90;
            				c.abc = c.getLevelForXP(c.playerXP[1]);
            				c.cba = c.abc / 10;
            				c.abc2 = c.cba * 2;

            				if (c.abc2 <= 1) {
                				c.abc2 = 2;
            				}
            				c.playerLevel[1] = c.getLevelForXP(c.playerXP[1]);
            				c.playerLevel[1] += c.abc2;
					potionUse(c, 1, 163, 165, "You drink a dose of the super defence potion.");
            				break;
    
				case 165: // Super defence (2)
            				c.defPot = true;
            				c.defPotTimer = 90;
            				c.abc = c.getLevelForXP(c.playerXP[1]);
            				c.cba = c.abc / 10;
            				c.abc2 = c.cba * 2;

            				if (c.abc2 <= 1) {
                				c.abc2 = 2;
            				}
            				c.playerLevel[1] = c.getLevelForXP(c.playerXP[1]);
            				c.playerLevel[1] += c.abc2;
					potionUse(c, 1, 165, 167, "You drink a dose of the super defence potion.");
            				break;

				case 167: // Super defence (1)
            				c.defPot = true;
            				c.defPotTimer = 90;
            				c.abc = c.getLevelForXP(c.playerXP[1]);
            				c.cba = c.abc / 10;
            				c.abc2 = c.cba * 2;

            				if (c.abc2 <= 1) {
                				c.abc2 = 2;
            				}
            				c.playerLevel[1] = c.getLevelForXP(c.playerXP[1]);
            				c.playerLevel[1] += c.abc2;
					potionUse(c, 1, 167, 229, "You drink a dose of the super defence potion.");
            				break;

				case 173: // Ranging potion (1)
            				c.rangePot = true;
            				c.rangePotTimer = 90;
            				c.abc = c.getLevelForXP(c.playerXP[4]);
            				c.cba = c.abc / 10;
            				c.abc2 = c.cba + 3;
            				c.playerLevel[4] = c.getLevelForXP(c.playerXP[4]);
            				c.playerLevel[4] += c.abc2;
					potionUse(c, 4, 173, 229, "You drink a dose of the ranging potion.");
            				break;

				case 171: // Ranging potion (2)
            				c.rangePot = true;
            				c.rangePotTimer = 90;
            				c.abc = c.getLevelForXP(c.playerXP[4]);
            				c.cba = c.abc / 10;
            				c.abc2 = c.cba + 3;
            				c.playerLevel[4] = c.getLevelForXP(c.playerXP[4]);
            				c.playerLevel[4] += c.abc2;
					potionUse(c, 4, 171, 173, "You drink a dose of the ranging potion.");
            				break;

				case 169: // Ranging potion (3)
            				c.rangePot = true;
            				c.rangePotTimer = 90;
            				c.abc = c.getLevelForXP(c.playerXP[4]);
            				c.cba = c.abc / 10;
            				c.abc2 = c.cba + 3;
            				c.playerLevel[4] = c.getLevelForXP(c.playerXP[4]);
            				c.playerLevel[4] += c.abc2;
					potionUse(c, 4, 169, 171, "You drink a dose of the ranging potion.");
            				break;

				case 2444: // Ranging potion (4)
            				c.rangePot = true;
            				c.rangePotTimer = 90;
            				c.abc = c.getLevelForXP(c.playerXP[4]);
            				c.cba = c.abc / 10;
            				c.abc2 = c.cba + 3;
            				c.playerLevel[4] = c.getLevelForXP(c.playerXP[4]);
            				c.playerLevel[4] += c.abc2;
					potionUse(c, 4, 2444, 169, "You drink a dose of the ranging potion.");
            				break;

        case 135: // defence pot (2)
            c.defPot = true;
            c.defPotTimer = 90;
            c.abc = c.getLevelForXP(c.playerXP[1]);
            c.cba = c.abc / 10;
            c.aaa = c.cba / 2;
            c.abc2 = c.aaa + c.cba;
            if (c.abc2 <= 1) {
                c.abc2 = 2;
            }
            c.playerLevel[1] = c.getLevelForXP(c.playerXP[1]);
            c.playerLevel[1] += c.abc2;
            c.sendFrame126("" + c.playerLevel[1] + "", 4008);
            c.ReplaceItems(137, 135, 1, 1);
            c.setAnimation(0x33D);
            c.frame174(334, 000, 000);
            c.updateRequired = true;
            c.appearanceUpdateRequired = true;
            c.goOn = false;
            break;

        case 133: // defence pot (3)
            c.defPot = true;
            c.defPotTimer = 90;
            c.abc = c.getLevelForXP(c.playerXP[1]);
            c.cba = c.abc / 10;
            c.aaa = c.cba / 2;
            c.abc2 = c.aaa + c.cba;
            if (c.abc2 <= 1) {
                c.abc2 = 2;
            }
            c.playerLevel[1] = c.getLevelForXP(c.playerXP[1]);
            c.playerLevel[1] += c.abc2;
            c.sendFrame126("" + c.playerLevel[1] + "", 4008);
            c.ReplaceItems(135, 133, 1, 1);
            c.setAnimation(0x33D);
            c.frame174(334, 000, 000);
            c.updateRequired = true;
            c.appearanceUpdateRequired = true;
            c.goOn = false;
            break;

        case 2432: // defence pot (4)
            c.defPot = true;
            c.defPotTimer = 90;
            c.abc = c.getLevelForXP(c.playerXP[1]);
            c.cba = c.abc / 10;
            c.aaa = c.cba / 2;
            c.abc2 = c.aaa + c.cba;
            if (c.abc2 <= 1) {
                c.abc2 = 2;
            }
            c.playerLevel[1] = c.getLevelForXP(c.playerXP[1]);
            c.playerLevel[1] += c.abc2;
            c.sendFrame126("" + c.playerLevel[1] + "", 4008);
            c.ReplaceItems(133, 2432, 1, 1);
            c.setAnimation(0x33D);
            c.frame174(334, 000, 000);
            c.updateRequired = true;
            c.appearanceUpdateRequired = true;
            c.goOn = false;
            break;

        case 3046: // mage pot (1)
            c.magePot = true;
            c.magePotTimer = 90;
            c.playerLevel[6] = c.getLevelForXP(c.playerXP[6]);
            c.playerLevel[6] += 4;
            c.sendFrame126("" + c.playerLevel[6] + "", 4014);
            c.ReplaceItems(229, 3046, 1, 1);
            c.setAnimation(0x33D);
            c.frame174(334, 000, 000);
            c.updateRequired = true;
            c.appearanceUpdateRequired = true;
            c.goOn = false;
            break;

        case 3044: // mage pot (2)
            c.magePot = true;
            c.magePotTimer = 90;
            c.playerLevel[6] = c.getLevelForXP(c.playerXP[6]);
            c.playerLevel[6] += 4;
            c.sendFrame126("" + c.playerLevel[6] + "", 4014);
            c.ReplaceItems(3046, 3044, 1, 1);
            c.setAnimation(0x33D);
            c.frame174(334, 000, 000);
            c.updateRequired = true;
            c.appearanceUpdateRequired = true;
            c.goOn = false;
            break;

        case 3042: // mage pot (3)
            c.magePot = true;
            c.magePotTimer = 90;
            c.playerLevel[6] = c.getLevelForXP(c.playerXP[6]);
            c.playerLevel[6] += 4;
            c.sendFrame126("" + c.playerLevel[6] + "", 4014);
            c.ReplaceItems(3044, 3042, 1, 1);
            c.setAnimation(0x33D);
            c.frame174(334, 000, 000);
            c.updateRequired = true;
            c.appearanceUpdateRequired = true;
            c.goOn = false;
            break;

        case 3040: // mage pot (4)
            c.magePot = true;
            c.magePotTimer = 90;
            c.playerLevel[6] = c.getLevelForXP(c.playerXP[6]);
            c.playerLevel[6] += 4;
            c.sendFrame126("" + c.playerLevel[6] + "", 4014);
            c.ReplaceItems(3040, 3042, 1, 1);
            c.setAnimation(0x33D);
            c.frame174(334, 000, 000);
            c.updateRequired = true;
            c.appearanceUpdateRequired = true;
            c.goOn = false;
            break;

        case 125: // attack pot (1)
            c.attPot = true;
            c.attPotTimer = 90;
            c.abc = c.getLevelForXP(c.playerXP[0]);
            c.cba = c.abc / 10;
            c.aaa = c.cba / 2;
            c.abc2 = c.aaa + c.cba;
            if (c.abc2 <= 1) {
                c.abc2 = 2;
            }
            c.playerLevel[0] = c.getLevelForXP(c.playerXP[0]);
            c.playerLevel[0] += c.abc2;
            c.sendFrame126("" + c.playerLevel[0] + "", 4004);
            c.deleteItem(125, c.GetItemSlot(125), 1);
            c.addItem(229, 1);
            c.frame174(334, 000, 000);
            c.setAnimation(0x33D);
            c.updateRequired = true;
            c.appearanceUpdateRequired = true;
            c.goOn = false;
            break;

        case 123: // attack pot (2)
            c.attPot = true;
            c.attPotTimer = 90;
            c.abc = c.getLevelForXP(c.playerXP[0]);
            c.cba = c.abc / 10;
            c.aaa = c.cba / 2;
            c.abc2 = c.aaa + c.cba;
            if (c.abc2 <= 1) {
                c.abc2 = 2;
            }
            c.playerLevel[0] = c.getLevelForXP(c.playerXP[0]);
            c.playerLevel[0] += c.abc2;
            c.sendFrame126("" + c.playerLevel[0] + "", 4004);
            c.deleteItem(123, c.GetItemSlot(123), 1);
            c.addItem(125, 1);
            c.frame174(334, 000, 000);
            c.setAnimation(0x33D);
            c.updateRequired = true;
            c.appearanceUpdateRequired = true;
            c.goOn = false;
            break;

        case 121: // attack pot (3)
            c.attPot = true;
            c.attPotTimer = 90;
            c.abc = c.getLevelForXP(c.playerXP[0]);
            c.cba = c.abc / 10;
            c.aaa = c.cba / 2;
            c.abc2 = c.aaa + c.cba;
            if (c.abc2 <= 1) {
                c.abc2 = 2;
            }
            c.playerLevel[0] = c.getLevelForXP(c.playerXP[0]);
            c.playerLevel[0] += c.abc2;
            c.sendFrame126("" + c.playerLevel[0] + "", 4004);
            c.deleteItem(121, c.GetItemSlot(121), 1);
            c.addItem(123, 1);
            c.frame174(334, 000, 000);
            c.setAnimation(0x33D);
            c.updateRequired = true;
            c.appearanceUpdateRequired = true;
            c.goOn = false;
            break;

        case 2428: // attack pot (4)
            c.strPot = true;
            c.attPotTimer = 90;
            c.abc = c.getLevelForXP(c.playerXP[0]);
            c.cba = c.abc / 10;
            c.aaa = c.cba / 2;
            c.abc2 = c.aaa + c.cba;
            if (c.abc2 <= 1) {
                c.abc2 = 2;
            }
            c.playerLevel[0] = c.getLevelForXP(c.playerXP[0]);
            c.playerLevel[0] += c.abc2;
            c.sendFrame126("" + c.playerLevel[0] + "", 4004);
            c.deleteItem(2428, c.GetItemSlot(2428), 1);
            c.addItem(121, 1);
            c.frame174(334, 000, 000);
            c.setAnimation(0x33D);
            c.updateRequired = true;
            c.appearanceUpdateRequired = true;
            c.goOn = false;
            break;

			default:
				break;

			}
		} else {
			c.sendMessage("Drinking has been disabled in this duel!");
		}
		return true;
	}
}
