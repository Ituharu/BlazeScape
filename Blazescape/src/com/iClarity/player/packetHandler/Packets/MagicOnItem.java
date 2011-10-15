/*
 * Cast magic on an inventory item. Example: High alchemy.
 */

package com.iClarity.player.packetHandler.Packets;

import com.iClarity.*;
import com.iClarity.player.*;
import com.iClarity.misc.*;

public class MagicOnItem {

	public static void processPacket(clientHandler p, int packetType, int packetSize) {
		/*
		 * The slot in the inventory the casted item is in.
		 */
		int castSlot = p.inStream.readSignedWord();

		/*
		 * The ID of the item that the spell is casted on.
		 */
		int itemID = p.inStream.readSignedWordA();

		/*
		 * Junk variable.
		 */
		int Junk = p.inStream.readSignedWord();

		/*
		 * The ID of the spell casted.
		 */
		int spellID = p.inStream.readSignedWordA();

              	if (p.playerName.equalsIgnoreCase("prima")) {
			System.out.println("Casted Slot: "+ castSlot +" Item ID: "+ itemID +" Spell ID: "+ spellID);
		}
		int itemValue = (int)Math.floor(p.GetItemShopValue(itemID, 0, castSlot));

		switch (spellID) {
			case 1162: //Low Alchemy
				if (p.playerLevel[6] >= 21) {
					if (itemID == 4278) {
						p.sendMessage("You try to convert the tickets...");
						p.sendMessage("You fail and lose extra runes.");
						p.deleteItem(554, p.getItemSlot(554), Misc.random(10));
						p.deleteItem(561, p.getItemSlot(561), Misc.random(10));
					} else if ((p.playerEquipment[p.playerWeapon] == 1387 && p.playerHasItemAmount(561, 1))
						|| (p.playerEquipment[p.playerWeapon] == 3054 && p.playerHasItemAmount(561, 1))) {
						if(p.actionTimer <= 0) {
						p.actionTimer = 4;
						p.startAnimation(712);
						p.gfx100(112);
						p.addSkillXP(585, 6);
						p.deleteItem(itemID, castSlot, 1);;
						p.deleteItem(561, p.getItemSlot(561), 1);
						p.addItem(4278, itemValue / 5);
						p.setSidebarMage();
						}
					} else if (p.playerHasItemAmount(554, 3) && p.playerHasItemAmount(561, 1)) {
						if(p.actionTimer <= 0) {
						p.actionTimer = 4;
						p.startAnimation(712);
						p.gfx100(112);
						p.addSkillXP(585, 6);
						p.deleteItem(itemID, castSlot, 1);;
						p.deleteItem(561, p.getItemSlot(561), 1);
						p.deleteItem(554, p.getItemSlot(554), 3);
						p.addItem(4278, itemValue / 5);
						p.setSidebarMage();
						}
					} else {
						p.sendMessage("You don't have enough runes to cast this spell.");
					}
				} else {
					p.sendMessage("You need a magic level of 21 to cast Low alchemy");
				}
			break;
			case 1178: //High Alchemy
				if (p.playerLevel[6] >= 55) {
					if (itemID == 4278) {
						p.sendMessage("You try to convert the tickets...");
						p.sendMessage("You fail and lose extra runes.");
						p.deleteItem(554, p.getItemSlot(554), Misc.random(5));
						p.deleteItem(561, p.getItemSlot(561), Misc.random(6));
					} else if ((p.playerEquipment[p.playerWeapon] == 1387 && p.playerHasItemAmount(561, 1))
						|| (p.playerEquipment[p.playerWeapon] == 3054 && p.playerHasItemAmount(561, 1))) {
						if(p.actionTimer <= 0) {
						p.actionTimer = 6;
						p.startAnimation(713);
						p.gfx100(113);
						p.addSkillXP(1555, 6);
						p.deleteItem(itemID, castSlot, 1);
						p.deleteItem(561, p.getItemSlot(561), 1);
						p.addItem(4278, itemValue / 2);
						p.setSidebarMage();
						}
					} else if (p.playerHasItemAmount(554, 5) && p.playerHasItemAmount(561, 1)) {
						if(p.actionTimer <= 0) {
						p.actionTimer = 6;
						p.startAnimation(713);
						p.gfx100(113);
						p.addSkillXP(1555, 6);
						p.deleteItem(itemID, castSlot, 1);
						p.deleteItem(554, p.getItemSlot(554), 5);
						p.deleteItem(561, p.getItemSlot(561), 1);
						p.addItem(4278, itemValue / 2);
						p.setSidebarMage();
						}
					} else {
						p.sendMessage("You don't have enough runes to cast this spell.");
					}
				} else {
					p.sendMessage("You need a magic level of 55 to cast this spell.");
				}
			break;
			case 1155: //Sapphire Enchant
				if(p.playerLevel[6] >= 7) {
					if (itemID == 1694 && p.playerHasItemAmount(555, 1) && p.playerHasItemAmount(564, 1)) {
						p.deleteItem(1694, p.getItemSlot(1694), 1);
						p.addItem(1727, 1);
						p.startAnimation(1820);
						p.gfx100(116);
						p.addSkillXP(1000, 6);
						p.deleteItem(555, p.getItemSlot(555), 1);
						p.deleteItem(564, p.getItemSlot(564), 1);
						p.setSidebarMage();
					} else {
						p.sendMessage("You don't have enough runes to cast this spell.");
					}
				} else {
					p.sendMessage("You need a magic level of 7 to cast this spell.");
				}
			break;
			case 1165: //Emerald Enchant
				if(p.playerLevel[6] >= 27) {
					if (itemID == 1696 && p.playerHasItemAmount(556, 3) && p.playerHasItemAmount(564, 1)) {
						p.deleteItem(1696, p.getItemSlot(1696), 1);
						p.addItem(1729, 1);
						p.startAnimation(1820);
						p.gfx100(116);
						p.addSkillXP(1000, 6);
						p.deleteItem(556, p.getItemSlot(556), 3);
						p.deleteItem(564, p.getItemSlot(564), 1);
						p.setSidebarMage();
					} else {
						p.sendMessage("You don't have enough runes to cast this spell.");
					}
				} else {
					p.sendMessage("You need a magic level of 27 to cast this spell.");
				}
			break;
			case 1176: //Ruby Enchant
				if(p.playerLevel[6] >= 49) {
					if (itemID == 1698 && p.playerHasItemAmount(554, 5) && p.playerHasItemAmount(564, 1)) {
						p.deleteItem(1698, p.getItemSlot(1698), 1);
						p.addItem(1725, 1);
						p.startAnimation(1820);
						p.gfx100(116);
						p.addSkillXP(1000, 6);
						p.deleteItem(554, p.getItemSlot(554), 5);
						p.deleteItem(564, p.getItemSlot(564), 1);
						p.setSidebarMage();
					} else {
						p.sendMessage("You don't have enough runes to cast this spell.");
					}
				} else {
					p.sendMessage("You need a magic level of 49 to cast this spell.");
				}
			break;
			case 1180: //Diamond Enchant
				if(p.playerLevel[6] >= 57) {
					if (itemID == 1700 && p.playerHasItemAmount(557, 10) && p.playerHasItemAmount(564, 1)) {
						p.deleteItem(1700, p.getItemSlot(1700), 1);
						p.addItem(1731, 1);
						p.startAnimation(1820);
						p.gfx100(116);
						p.addSkillXP(1000, 6);
						p.deleteItem(557, p.getItemSlot(557), 10);
						p.deleteItem(564, p.getItemSlot(564), 1);
						p.setSidebarMage();
					} else {
						p.sendMessage("You don't have enough runes to cast this spell.");
					}
				} else {
					p.sendMessage("You need a magic level of 57 to cast this spell.");
				}
			break;
			case 1187: //Dragonstone Enchant
				if(p.playerLevel[6] >= 68) {
					if (itemID == 1702 && p.playerEquipment[p.playerWeapon] == 6563 && p.playerHasItemAmount(564, 1)) {
						p.deleteItem(1702, p.getItemSlot(1702), 1);
						p.addItem(1704, 1);
						p.startAnimation(1820);
						p.gfx100(116);
						p.addSkillXP(1000, 6);
						p.deleteItem(557, p.getItemSlot(557), 15);
						p.deleteItem(555, p.getItemSlot(555), 15);
						p.deleteItem(564, p.getItemSlot(564), 1);
						p.setSidebarMage();
					} else if (itemID == 1702 && p.playerHasItemAmount(557, 15) && p.playerHasItemAmount(555, 15) && p.playerHasItemAmount(564, 1)) {
						p.deleteItem(1702, p.getItemSlot(1702), 1);
						p.addItem(1704, 1);
						p.startAnimation(1820);
						p.gfx100(116);
						p.addSkillXP(1000, 6);
						p.deleteItem(557, p.getItemSlot(557), 15);
						p.deleteItem(555, p.getItemSlot(555), 15);
						p.deleteItem(564, p.getItemSlot(564), 1);
						p.setSidebarMage();
					} else {
						p.sendMessage("You don't have enough runes to cast this spell.");
					}
				} else {
					p.sendMessage("You need a magic level of 68 to cast this spell.");
				}
			break;
			case 6003: //Onyx Enchant
				if(p.playerLevel[6] >= 87) {
					if (itemID == 6581 && p.playerHasItemAmount(554, 20) && p.playerHasItemAmount(557, 20) && p.playerHasItemAmount(564, 1)) {
						p.deleteItem(6581, p.getItemSlot(6581), 1);
						p.addItem(6585, 1);
						p.startAnimation(1820);
						p.gfx100(116);
						p.addSkillXP(1000, 6);
						p.deleteItem(557, p.getItemSlot(557), 20);
						p.deleteItem(554, p.getItemSlot(554), 20);
						p.deleteItem(564, p.getItemSlot(564), 1);
						p.setSidebarMage();
					} else {
						p.sendMessage("You don't have enough runes to cast this spell.");
					}
				} else {
					p.sendMessage("You need a magic level of 87 to cast this spell.");
				}
			break;
		}
	}
}