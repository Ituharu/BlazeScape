/*
 * Second NPC option.
 */

package com.iClarity.player.packetHandler.Packets;

import java.io.*;
import com.iClarity.*;
import com.iClarity.misc.*;
import com.iClarity.player.*;
import com.iClarity.player.packetHandler.*;

public class SecondNpcClick {

	public static void processPacket(clientHandler p, int packetType, int packetSize) {
		int NPCSlot = ((Misc.HexToInt(p.inStream.buffer, 0, p.packetSize) / 1000) - 128);
		int NPCID = GameEngine.npcHandler.npcs[NPCSlot].npcType;
		boolean putNPCCoords = false;
		p.ThiefNPC = p.inStream.readUnsignedWordBigEndianA();
		p.faceNPC(NPCSlot);

		switch (NPCID) {
			case 961:
				if(p.actionTimer == 0) {
					p.actionTimer = 3;
                        		p.setSkillLevel(3, p.getLevelForXP(p.playerXP[3]), p.playerXP[p.playerHitpoints]);
                        		p.playerLevel[3] = p.getLevelForXP(p.playerXP[3]);
                        		p.refreshSkills();
					p.sendMessage("Surgeon General Tafani refreshes you to full health.");
				}
				break;
			case 1526:
				p.WanneShop = 11;
				putNPCCoords = true;
				break;
			case 2270:
				p.WanneShop = 27;
				putNPCCoords = true;
				break;
			case 1369:
				p.WanneShop = 26;
				putNPCCoords = true;
				break;
			case 1597://VANNAKA
				p.NpcWanneTalk = 15977;
				break;
			case 2749:
				//p.addItem(8551, p.tokenAmount);
				p.NpcWanneTalk = 2749;
				putNPCCoords = true;
				//p.tokenAmount = 0;
				break;
			case 1780:
				p.WanneShop = 25;
				putNPCCoords = true;
				break;

			case 820:
				p.WanneShop = 20;
				putNPCCoords = true;
			break;

                        case 313:
                            
                            p.updateRequired = true;
                            /*p.getFishing().fish(p, );*/
                            break;

                        case 316:
                            
                            p.updateRequired = true;
                            /*p.getFishing().fish(p, );*/
                            break;

                        case 317:
                            
                            p.updateRequired = true;
                            /*p.getFishing().fish(p, );*/
                            break;

                        case 318:
                            
                            p.updateRequired = true;
                            /*p.getFishing().fish(p, );*/
                            break;

                        case 319:
                            
                            p.updateRequired = true;
                            /*p.getFishing().fish(p, );*/
                            break;

                        case 321:
                            
                            p.updateRequired = true;
                            /*p.getFishing().fish(p, );*/
                            break;

                        case 1276:
                            
                            putNPCCoords = true;
                            /*p.getFishing().fish(p, );*/
                            break;

                        case 3848:
                            
                            p.updateRequired = true;
                            /*p.getFishing().fish(p, );*/
                            break;

			case 1599:
				p.WanneShop = 19;
				putNPCCoords = true;
			break;

			case 551:
				p.WanneShop = 18;
				putNPCCoords = true;
			break;

			case 552:
				p.WanneShop = 17;
				putNPCCoords = true;
			break;

			case 682:
				p.WanneShop = 16;
				putNPCCoords = true;
			break;

			case 542:
				p.WanneShop = 15;
				putNPCCoords = true;
			break;

			case 580:
				p.WanneShop = 14;
				putNPCCoords = true;
			break;

			case 582:
				p.WanneShop = 13;
				putNPCCoords = true;
			break;

			case 594:
				p.WanneShop = 12;
				putNPCCoords = true;
			break;

			case 546:
				p.WanneShop = 2;
				putNPCCoords = true;
			break;

			case 550:
				p.WanneShop = 3;
				putNPCCoords = true;
			break;

			case 1:
				p.thievingType = 1;
				p.thiefNPC = true;
				putNPCCoords = true;
				break;
			case 494:
			case 495:
			case 2619:
				p.WanneBank = 2;
				putNPCCoords = true;
				break;


			default:
				break;
		}
		if (putNPCCoords == true) {
			p.skillX = GameEngine.npcHandler.npcs[NPCSlot].absX;
			p.skillY = GameEngine.npcHandler.npcs[NPCSlot].absY;
		}
	}
}