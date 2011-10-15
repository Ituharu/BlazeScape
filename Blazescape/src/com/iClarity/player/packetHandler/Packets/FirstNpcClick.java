/*
 * First NPC option.
 */

package com.iClarity.player.packetHandler.Packets;

import java.io.*;
import com.iClarity.*;
import com.iClarity.misc.*;
import com.iClarity.player.*;
import com.iClarity.player.packetHandler.*;
import com.iClarity.player.Skills.*;

public class FirstNpcClick {

	public static void processPacket(clientHandler p, int packetType, int packetSize) {
		int NPCSlot = (Misc.HexToInt(p.inStream.buffer, 0, p.packetSize) / 1000);
		int NPCID = GameEngine.npcHandler.npcs[NPCSlot].npcType;
		boolean putNPCCoords = false;
		p.faceNPC(NPCSlot);

		switch (NPCID) {

case 3295://Master Miner
case 3799://Sloane
case 3798://Ajjat
case 847://Head Chef
case 2270://Martin Thwait
case 3801://Woodsman Tutor
case 1780://Larry
case 1369://Fishmonger
case 961://Surgeon General Tafani
case 682:
case 582:
case 542:
case 580:
case 594:
case 550:
case 546:
case 552:
case 551:
case 2024:
	putNPCCoords = true;
	p.NpcWanneTalk = NPCID;
break;

case 1304://Sailor
	putNPCCoords = true;
	//if(p.playerRights > 0) {
		p.teleportToX = 2512;
		p.teleportToY = 3860;
		p.sendMessage("You arrive at the island of Miscellania.");
	//} else {
	//	p.NpcWanneTalk = 1304;
	//}
break;


			case 456:
			if(p.playerLevel[5] <= 1) {
				putNPCCoords = true;
				p.NpcWanneTalk = 456;
				p.restorePrayer = 1;
			} else if(p.playerLevel[5] >= 2)  {
				putNPCCoords = true;
				p.NpcWanneTalk = 457;
			}
			break;
			
			case 458:
			if(p.playerLevel[5] <= 1 && p.restorePrayer == 1) {
				putNPCCoords = true;
				p.NpcWanneTalk = 458;
				p.resetPrayer();
				p.playerLevel[5] = p.getLevelForXP(p.playerXP[5]);
				p.sendMessage("He places his hand on your head.");
				p.sendMessage("You begin to feel better.");
				p.restorePrayer = 2;
			} else if(p.playerLevel[5] >= 2 && p.restorePrayer == 0) {
				putNPCCoords = true;
				p.NpcWanneTalk = 459;
			} else if(p.restorePrayer == 2) {
				putNPCCoords = true;
				p.NpcWanneTalk = 460;
			}
			break;

			case 804:
				p.showInterface(14670);
				p.sendFrame246(14817, 100, 1742);
				putNPCCoords = true;
			break;
			
			case 57:
			if(p.hasItem(6855)) {
				putNPCCoords = true;
				p.NpcWanneTalk = 57;
				p.deleteItem(6855, p.getItemSlot(6855), 1);
				p.addItem(7775, 1);
			} else {
				putNPCCoords = true;
				p.NpcWanneTalk = 58;
			}
			break;

			case 3082:
				putNPCCoords = true;
			if(!p.hasItem(6853, 1)) {
				p.addItem(6853, 1);
				p.NpcWanneTalk = 3082;
			}
			if(!p.hasItem(6853, 1) && !p.playerHasItemAmount(6853, 8)) {
				p.NpcWanneTalk = 3084;
				p.addItem(6853, 1);
			}
				
			break;
                        case 318:
                           //p.resetFishing();
                            putNPCCoords = true;
                            p.getFishing().fishSpots(p, NPCID, 1);
				p.getFishing().amountToFish = 28;
                            break;

                        case 316:
                           // p.resetFishing();
                            putNPCCoords = true;
                            p.getFishing().fishSpots(p, NPCID, 1);
				p.getFishing().amountToFish = 28;
                            break;

                        case 321:
                           // p.resetFishing();
                            putNPCCoords = true;
                            p.getFishing().fishSpots(p, NPCID, 1);
				p.getFishing().amountToFish = 28;
                            break;

                        case 1176:
                           // p.resetFishing();
                            putNPCCoords = true;
                            p.getFishing().fishSpots(p, NPCID, 1);
				p.getFishing().amountToFish = 28;
                            break;

                        case 1177:
                          //  p.resetFishing();
                            putNPCCoords = true;
                            p.getFishing().fishSpots(p, NPCID, 1);
				p.getFishing().amountToFish = 28;
                            break;

                        case 1178:
                            //p.resetFishing();
                            putNPCCoords = true;
                            p.getFishing().fishSpots(p, NPCID, 1);
				p.getFishing().amountToFish = 28;
                            break;

                        case 1237:
                           // p.resetFishing();
                            putNPCCoords = true;
                            p.getFishing().fishSpots(p, NPCID, 1);
				p.getFishing().amountToFish = 28;
                            break;

                        case 1238:
                           // p.resetFishing();
                            putNPCCoords = true;
                            p.getFishing().fishSpots(p, NPCID, 1);
				p.getFishing().amountToFish = 28;
                            break;



                        case 1333:
                            //p.resetFishing();
                            putNPCCoords = true;
                            p.getFishing().fishSpots(p, NPCID, 1);
				p.getFishing().amountToFish = 28;
                            break;

                        case 3848:
                            //p.resetFishing();
                            putNPCCoords = true;
                            p.getFishing().fishSpots(p, NPCID, 1);
				p.getFishing().amountToFish = 28;
                            break;
			case 290:
				p.WanneShop = 20;
				putNPCCoords = true;
			break;

			case 278:
				p.WanneShop = 23;
				putNPCCoords = true;
			break;

			case 601:
				p.WanneShop = 22;
				putNPCCoords = true;
			break;

			case 1526:
				p.WanneShop = 11;
				putNPCCoords = true;
			break;

			case 308:
				p.NpcWanneTalk = 308;
				putNPCCoords = true;
			break;

			case 1599:
				p.WanneShop = 19;
				//p.NpcWanneTalk = 1599;
				putNPCCoords = true;
			break;


			case 355:
				p.NpcWanneTalk = 3000;
				putNPCCoords = true;
				break;
		}                                                 
		if (putNPCCoords) {
			p.skillX = GameEngine.npcHandler.npcs[NPCSlot].absX;
			p.skillY = GameEngine.npcHandler.npcs[NPCSlot].absY;
		}	
	}
}