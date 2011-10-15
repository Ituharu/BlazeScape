/*
 * Item used on an Object.
 */

package com.iClarity.player.packetHandler.Packets;

import com.iClarity.player.*;
import com.iClarity.player.Skills.*;
import com.iClarity.player.packetHandler.*;
import com.iClarity.misc.*;

public class ItemOnObject {


	public static void processPacket(clientHandler p, int packetType, int packetSize) {
		int junk = p.inStream.readUnsignedWordA();
		int objectID = p.inStream.readSignedWordBigEndian();
		int objectY = p.inStream.readUnsignedWordBigEndianA();
		int itemSlot = p.inStream.readUnsignedWordBigEndian();
		int objectX = p.inStream.readUnsignedWordBigEndianA();
		int useItemID = p.inStream.readUnsignedWord();

			if (objectID == 2783) {
				// anvil
				int Type = p.CheckSmithing(useItemID, itemSlot);

				if (Type != -1) {
					p.skillX = objectX;
					p.skillY = objectY;
					p.OpenSmithingFrame(Type);
				}
			}



		switch(useItemID) {

case 1919:
	if(objectID == 13568) {
		p.deleteItem(1919, p.GetItemSlot(1919), 1);
		p.addItem(1917, 1);
		p.sendMessage("You fill the glass with beer.");
	}
break;
			case 534: //Baby Blue Dragon Bones
			if(objectID == 409) {
				p.stillgfx(624, objectY, objectX);
				p.deleteItem(useItemID, p.GetItemSlot(useItemID), 1);
				p.addSkillXP(45, 5);
				p.sendMessage("The gods accept your gift.");
				
			}
				break;
			case 536: //Dragon Bones
			if(objectID == 409) {
				p.stillgfx(624, objectY, objectX);
				p.deleteItem(useItemID, p.GetItemSlot(useItemID), 1);
				p.addSkillXP(2250, 5);
				p.sendMessage("The gods accept your gift.");
			}
				break;
			case 526: //Bones
			case 528: //Burnt Bones
			case 2859: //Wolf Bones
			if(objectID == 409) {
				p.stillgfx(624, objectY, objectX);
				p.deleteItem(useItemID, p.GetItemSlot(useItemID), 1);
				p.addSkillXP(225, 5);
				p.sendMessage("The gods accept your gift.");
			}
				break;
			case 530: //Bat Bones
			if(objectID == 409) {
				p.stillgfx(624, objectY, objectX);
				p.deleteItem(useItemID, p.GetItemSlot(useItemID), 1);
				p.addSkillXP(225, 5);
				p.sendMessage("The gods accept your gift.");
			}
				break;
			case 532: //Big Bones
			case 3125: //Jogre Bones
			if(objectID == 409) {
				p.stillgfx(624, objectY, objectX);
				p.deleteItem(useItemID, p.GetItemSlot(useItemID), 1);
				p.addSkillXP(750, 5);
				p.sendMessage("The gods accept your gift.");
			}
				break;
			case 3179: //Monkey Bones
			if(objectID == 409) {
				p.stillgfx(624, objectY, objectX);
				p.deleteItem(useItemID, p.GetItemSlot(useItemID), 1);
				p.addSkillXP(7, 5);
				p.sendMessage("The gods accept your gift.");
			}
				break;
			case 4812: //Zogre Bones
			if(objectID == 409) {
				p.stillgfx(624, objectY, objectX);
				p.deleteItem(useItemID, p.GetItemSlot(useItemID), 1);
				p.addSkillXP(1125, 5);
				p.sendMessage("The gods accept your gift.");
			}
				break;
			case 4830: //Fayrg Bones
			if(objectID == 409) {
				p.stillgfx(624, objectY, objectX);
				p.deleteItem(useItemID, p.GetItemSlot(useItemID), 1);
				p.addSkillXP(2400, 5);
				p.sendMessage("The gods accept your gift.");
			}
				break;
			case 4832: //Raurg Bones
			if(objectID == 409) {
				p.stillgfx(624, objectY, objectX);
				p.deleteItem(useItemID, p.GetItemSlot(useItemID), 1);
				p.addSkillXP(2850, 5);
				p.sendMessage("The gods accept your gift.");
			}
				break;				
		}

		switch (objectID) {

		case 114:
			if (p.GoodDistance(p.absX, p.absY, objectX, objectY, 1)) {
				p.TurnPlayerTo(objectX, objectY);
				if (p.getCooking().isCookable(useItemID)) {
					p.getCooking().cookingItem = useItemID;
					p.sendFrame246(13716, 200, useItemID);
					p.sendFrame164(1743);
					p.cookAnim = 2;
				}
			}
		break;
		case 4266:
			if (p.GoodDistance(p.absX, p.absY, objectX, objectY, 1)) {
				p.TurnPlayerTo(objectX, objectY);
				if (p.getCooking().isCookable(useItemID)) {
					p.getCooking().cookingItem = useItemID;
					p.sendFrame246(13716, 200, useItemID);
					p.sendFrame164(1743);
					p.cookAnim = 1;
				}
			}
		break;
		case 2732:
			if (p.GoodDistance(p.absX, p.absY, objectX, objectY, 1)) {
				p.TurnPlayerTo(objectX, objectY);
				if (p.getCooking().isCookable(useItemID)) {
					p.getCooking().cookingItem = useItemID;
					p.sendFrame246(13716, 200, useItemID);
					p.sendFrame164(1743);
					p.cookAnim = 1;
				}
			}
		break;
		


		case 5126:
			if(useItemID == 2418 && objectID == 5126) {
				if (p.playerHasItem2(2418)) {
					p.deleteItem(2418, p.getItemSlot(2418), 1);
					p.teleportToX = 3445;
					p.teleportToY = 3555;
					p.heightLevel = 2;
				}
			}
		break;

		case 9263: //New Years Tree
			if(useItemID == 962 && objectID == 9263) {
				if (p.playerHasItem2(962)) {
					p.sendMessage("You break the cracker on the tree...");
					p.sendMessage("You get an item! Enjoy the holidays!");
					p.sendMessage("- The BlazeScape Reborn Team");
					p.deleteItem(962, p.getItemSlot(962), 1);
					int randomRare = Misc.random(8);
						if(randomRare == 0) {
							p.addItem(6856, 1);
						}
						if(randomRare == 1) {
							p.addItem(6857, 1);
						}
						if(randomRare == 2) {
							p.addItem(6858, 1);
						}
						if(randomRare == 3) {
							p.addItem(6859, 1);
						}
						if(randomRare == 4) {
							p.addItem(6860, 1);
						}
						if(randomRare == 5) {
							p.addItem(6861, 1);
						}
						if(randomRare == 6) {
							p.addItem(6862, 1);
						}
						if(randomRare == 7) {
							p.addItem(6863, 1);
						}
						if(randomRare == 8) {
							p.addItem(1050, 1);
						}

				}
			}
		break;

		case 2142://cauldron of thunder
			if(useItemID == 6163 && objectID == 2142) {
				if (p.playerHasItem2(6163)) {
					p.TurnPlayerTo(objectX, objectY);
					p.deleteItem(6163, p.getItemSlot(6163), 1);
					int randomSkull = Misc.random(5);
						if(randomSkull == 0) {
							p.addItem(4278, 5000);
						}
						if(randomSkull == 1) {
							p.addItem(4278, 10000);
						}
						if(randomSkull == 2) {
							p.addItem(7325, 10);
						}
						if(randomSkull == 5) {
							p.addItem(7327, 10);
						}
						if(randomSkull == 3) {
							p.addItem(7319, 10);
						}
						if(randomSkull == 4) {
							p.addItem(892, 100);
						}
				}
			}

			if(useItemID == 989 && objectID == 2142) {
				if (p.playerHasItem2(989)) {
					p.TurnPlayerTo(objectX, objectY);
					p.deleteItem(989, p.getItemSlot(989), 1);
					int randomKey = Misc.random(10);
						if(randomKey == 0) {
							p.addItem(2661, 1);
						}
						if(randomKey == 1) {
							p.addItem(2663, 1);
						}
						if(randomKey == 2) {
							p.addItem(2665, 1);
						}
						if(randomKey == 3) {
							p.addItem(2667, 1);
						}
						if(randomKey == 4) {
							p.addItem(7671, 1);
						}
						if(randomKey == 5) {
							p.addItem(2633, 1);
						}
						if(randomKey == 6) {
							p.addItem(2635, 1);
						}
						if(randomKey == 7) {
							p.addItem(2637, 1);
						}
						if(randomKey == 8) {
							p.addItem(2639, 1);
						}
						if(randomKey == 9) {
							p.addItem(2641, 1);
						}
						if(randomKey == 10) {
							p.addItem(2643, 1);
						}
				}
			}
		break;

			default:
				p.sendMessage("Nothing interesting happens.");
				p.destinationRange = 1;
				break;
		}
		if (p.GoodDistance(p.absX, p.absY, objectX, objectY, p.destinationRange)) {
			p.itemOnObject(objectID, objectX, objectY);
		} else {
			p.ActionType = 4;
			p.destinationX = objectX;
			p.destinationY = objectY;
			p.destinationID = objectID;
		}
	}
}