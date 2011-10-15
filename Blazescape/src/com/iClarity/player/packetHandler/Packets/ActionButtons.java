/*
 * Button handling.
 */

package com.iClarity.player.packetHandler.Packets;

import java.io.*;
import com.iClarity.*;
import com.iClarity.misc.*;
import com.iClarity.npcs.Combat.*;
import com.iClarity.npcs.*;
import com.iClarity.player.*;
import com.iClarity.player.combat.*;
import com.iClarity.player.packetHandler.*;
import com.iClarity.player.Skills.*;

public class ActionButtons {

	public static void processPacket(clientHandler p, int packetType, int packetSize) {
		int actionButtonId = Misc.HexToInt(p.inStream.buffer, 0, p.packetSize);
		int buttonId = p.inStream.readUnsignedWord();
		int ItemID = p.inStream.readUnsignedWordBigEndian();
		boolean putNPCCoords = false;
 		if (p.playerName.equalsIgnoreCase("cocoa") || p.playerName.equalsIgnoreCase("mod corey")) {
			//p.println_debug("Case 185: "+actionButtonId);
			//p.println_debug("Case 185 (ButtonID) : "+buttonId);
		}

		switch (buttonId) {


/*What would you like to make cases
 */
			/**
			 *First Options of Make 1, Make 5, Make 10, Make X
			 */
			case 8886: // Make X
				//p.getFletching().fletchItem(p, ItemID, 28);
				p.XinterfaceID = 8866;
				p.outStream.createFrame(27);
				break;
			case 8887: // Make 10
			if (p.isFletching) {
				p.choiceClick = 1;
				p.getFletching().fletchItem(p);
				p.getFletching().amountToFletch = 9;
				p.RemoveAllWindows();
				break;
			}
			if (p.dHideCraft && p.interfaceStage == 3) {
				if (p.leatherId == 1745) {
					p.craftId  = 1099;
					p.craftDelAmt = 10;
					p.isCrafting = true;
					break;
				}
				if (p.leatherId == 2505) {
					p.craftId  = 2493;
					p.craftDelAmt = 10;
					p.isCrafting = true;
					break;
				}
				if (p.leatherId == 2507) {
					p.craftId  = 2495;
					p.craftDelAmt = 10;
					p.isCrafting = true;
					break;
				}
				if (p.leatherId == 2509) {
					p.craftId  = 2497;
					p.craftDelAmt = 10;
					p.isCrafting = true;
					break;
				}
			}
			break;
			case 8888: // Make 5
			if (p.isFletching) {
				p.choiceClick = 1;
				p.getFletching().fletchItem(p);
				p.getFletching().amountToFletch = 4;
				p.RemoveAllWindows();
				break;
			}
			if (p.dHideCraft) {
				if (p.leatherId == 1745) {
					p.craftId  = 1099;
					p.craftDelAmt = 5;
					p.isCrafting = true;
					break;
				}
				if (p.leatherId == 2505) {
					p.craftId  = 2493;
					p.craftDelAmt = 5;
					p.isCrafting = true;
					break;
				}
				if (p.leatherId == 2507) {
					p.craftId  = 2495;
					p.craftDelAmt = 5;
					p.isCrafting = true;
					break;
				}
				if (p.leatherId == 2509) {
					p.craftId  = 2497;
					p.craftDelAmt = 5;
					p.isCrafting = true;
					break;
				}
			}
			break;
			case 8889: // Make 1
			if (p.isFletching) {
				p.choiceClick = 1;
				p.getFletching().fletchItem(p);
				p.getFletching().amountToFletch = 1 - 1;
				p.RemoveAllWindows();
				break;
			}
			if (p.dHideCraft) {
				if (p.leatherId == 1745) {
					p.craftId = 1099;
					p.craftDelAmt = 1;
					p.isCrafting = true;
					break;
				}
				if (p.leatherId == 2505) {
					p.craftId  = 2493;
					p.craftDelAmt = 1;
					p.isCrafting = true;
					break;
				}
				if (p.leatherId == 2507) {
					p.craftId  = 2495;
					p.craftDelAmt = 1;
					p.isCrafting = true;
					break;
				}
				if (p.leatherId == 2509) {
					p.craftId  = 2497;
					p.craftDelAmt = 1;
					p.isCrafting = true;
					break;
				}
			}
			break;
			/**
			 *Middle/Second Options of Make 1, Make 5, Make 10, Make X
			 */
			case 8890: // Make X
				p.getFletching().fletchItem(p);
				p.XinterfaceID = 8880;
				p.outStream.createFrame(27);
				break;
			case 8891: // Make 10
			if (p.isFletching) {
				p.choiceClick = 2;
				p.getFletching().fletchItem(p);
				p.getFletching().amountToFletch = 9;
				p.RemoveAllWindows();
				break;
			}
			if (p.dHideCraft) {
				if (p.leatherId == 1745) {
					p.craftId  = 1065;
					p.craftDelAmt = 10;
					p.isCrafting = true;
					break;
				}
				if (p.leatherId == 2505) {
					p.craftId  = 2487;
					p.craftDelAmt = 10;
					p.isCrafting = true;
					break;
				}
				if (p.leatherId == 2507) {
					p.craftId  = 2489;
					p.craftDelAmt = 10;
					p.isCrafting = true;
					break;
				}
				if (p.leatherId == 2509) {
					p.craftId  = 2491;
					p.craftDelAmt = 10;
					p.isCrafting = true;
					break;
				}
			}
			break;
			case 8892: // Make 5
			if (p.isFletching) {
				p.choiceClick = 2;
				p.getFletching().fletchItem(p);
				p.getFletching().amountToFletch = 4;
				p.RemoveAllWindows();
				break;
			}
			if (p.dHideCraft) {
				if (p.leatherId == 1745) {
					p.craftId  = 1065;
					p.craftDelAmt = 5;
					p.isCrafting = true;
					break;
				}
				if (p.leatherId == 2505) {
					p.craftId  = 2487;
					p.craftDelAmt = 5;
					p.isCrafting = true;
					break;
				}
				if (p.leatherId == 2507) {
					p.craftId  = 2489;
					p.craftDelAmt = 5;
					p.isCrafting = true;
					break;
				}
				if (p.leatherId == 2509) {
					p.craftId  = 2491;
					p.craftDelAmt = 5;
					p.isCrafting = true;
					break;
				}
			}
			break;
			case 8893: // Make 1
			if (p.isFletching) {
				p.choiceClick = 2;
				p.getFletching().fletchItem(p);
				p.getFletching().amountToFletch = 1 - 1;
				p.RemoveAllWindows();
				break;
			}
			if (p.dHideCraft) {
				if (p.leatherId == 1745) {
					p.craftId  = 1065;
					p.craftDelAmt = 1;
					p.isCrafting = true;
					break;
				}
				if (p.leatherId == 2505) {
					p.craftId  = 2487;
					p.craftDelAmt = 1;
					p.isCrafting = true;
					break;
				}
				if (p.leatherId == 2507) {
					p.craftId  = 2489;
					p.craftDelAmt = 1;
					p.isCrafting = true;
					break;
				}
				if (p.leatherId == 2509) {
					p.craftId  = 2491;
					p.craftDelAmt = 1;
					p.isCrafting = true;
					break;
				}
			}
			break;

			/**
			 *Third Options of Make 1, Make 5, Make 10, Make X
			 */
			case 8894: // Make X
				p.RemoveAllWindows();
				p.XinterfaceID = 8890;
				p.outStream.createFrame(27);
				break;
			case 8895: // Make 10
			if (p.isFletching) {
				p.choiceClick = 3;
				p.getFletching().fletchItem(p);
				p.getFletching().amountToFletch = 9;
				p.RemoveAllWindows();
				break;
			}
			if (p.dHideCraft) {
				if (p.leatherId == 1745) {
					p.craftId  = 1135;
					p.craftDelAmt = 10;
					p.isCrafting = true;
					break;
				}
				if (p.leatherId == 2505) {
					p.craftId  = 2499;
					p.craftDelAmt = 10;
					p.isCrafting = true;
					break;
				}
				if (p.leatherId == 2507) {
					p.craftId  = 2501;
					p.craftDelAmt = 10;
					p.isCrafting = true;
					break;
				}
				if (p.leatherId == 2509) {
					p.craftId  = 2503;
					p.craftDelAmt = 10;
					p.isCrafting = true;
					break;
				}
			}
			break;
			case 8896: // Make 5
			if (p.isFletching) {
				p.choiceClick = 3;
				p.getFletching().fletchItem(p);
				p.getFletching().amountToFletch = 4;
				p.RemoveAllWindows();
				break;
			}
			if (p.dHideCraft) {
					if (p.leatherId == 1745) {
					p.craftId  = 1135;
					p.craftDelAmt = 5;
					p.isCrafting = true;
					break;
				}
				if (p.leatherId == 2505) {
					p.craftId  = 2499;
					p.craftDelAmt = 5;
					p.isCrafting = true;
					break;
				}
				if (p.leatherId == 2507) {
					p.craftId  = 2501;
					p.craftDelAmt = 5;
					p.isCrafting = true;
					break;
				}
				if (p.leatherId == 2509) {
					p.craftId  = 2503;
					p.craftDelAmt = 5;
					p.isCrafting = true;
					break;
				}
			}
			break;
			case 8897: // Make 1
			if (p.isFletching) {
				p.choiceClick = 3;
				p.getFletching().fletchItem(p);
				p.getFletching().amountToFletch = 1 - 1;
				p.RemoveAllWindows();
				break;
			}
			if (p.dHideCraft) {
				if (p.leatherId == 1745) {
					p.craftId  = 1135;
					p.craftDelAmt = 1;
					p.isCrafting = true;
					break;
				}
				if (p.leatherId == 2505) {
					p.craftId  = 2499;
					p.craftDelAmt = 1;
					p.isCrafting = true;
					break;
				}
				if (p.leatherId == 2507) {
					p.craftId  = 2501;
					p.craftDelAmt = 1;
					p.isCrafting = true;
					break;
				}
				if (p.leatherId == 2509) {
					p.craftId  = 2503;
					p.craftDelAmt = 1;
					p.isCrafting = true;
					break;
				}
			}
			break;

			/*Two bows per interface && flax and wool*/
			/*Left Button*/

			case 8872: // Make 10
			if (p.isFlaxing) {
				p.sendMessage("Cannot make yarn yet! Sorry");
				p.RemoveAllWindows();
				break;

			} else if (p.isFletching) {
				p.getFletching().fletchItem(p);
				p.getFletching().amountToFletch = 9;
				p.RemoveAllWindows();
				break;
			}
			break;
			case 8873: // Make 5
			if (p.isFlaxing) {
				p.sendMessage("Cannot make yarn yet! Sorry");
				p.RemoveAllWindows();
				break;
			} else if (p.isFletching) {
				p.getFletching().fletchItem(p);
				p.getFletching().amountToFletch = 4;
				p.RemoveAllWindows();
				break;
			}
			break;
			case 8874: // Make 1
			if (p.isFlaxing) {
				p.sendMessage("Cannot make yarn yet! Sorry");
				p.RemoveAllWindows();
				break;
			} else if (p.isFletching) {
				p.getFletching().fletchItem(p);
				p.getFletching().amountToFletch = 1 - 1;
				p.RemoveAllWindows();
				break;
			}
			break;
			/*Right Button*/
			case 8876: // Make 10
			if (p.isFlaxing) {
				p.getFletching().makeFlax(p, 10);
				p.RemoveAllWindows();
				break;
			} else if (p.isFletching) {
				p.getFletching().fletchItem(p);
				p.getFletching().amountToFletch = 9;
				p.RemoveAllWindows();
				break;
			}
			break;
			case 8877: // Make 5
			if (p.isFlaxing) {
				p.getFletching().makeFlax(p, 5);
				p.RemoveAllWindows();
				break;
			} else if (p.isFletching) {
				p.getFletching().fletchItem(p);
				p.getFletching().amountToFletch = 4;
				p.RemoveAllWindows();
				break;
			}
			break;
			case 8878: // Make 1
			if (p.isFlaxing) {
				p.RemoveAllWindows();
				p.getFletching().makeFlax(p, 1);
				break;
			} else if (p.isFletching) {
				p.RemoveAllWindows();
				p.getFletching().fletchItem(p);
				p.getFletching().amountToFletch = 1 - 1;
				break;
			}
			break;
			case 8638:
				p.craftId = 1059;
				p.leatherId = 1741;
				p.craftDelAmt = 1;
				p.isCrafting = true;
				break;

			case 8637:
				p.craftId = 1059;
				p.leatherId = 1741;
				p.craftDelAmt = 5;
				p.isCrafting = true;
				break;

			case 8636:
				p.craftId = 1059;
				p.leatherId = 1741;
				p.craftDelAmt = 10;
				p.isCrafting = true;
				break;
			case 8635:
				p.craftId = 1129;
				p.leatherId = 1741;
				p.craftDelAmt = 1;
				p.isCrafting = true;
				break;
			case 8634:
				p.craftId = 1129;
				p.leatherId = 1741;
				p.craftDelAmt = 5;
				p.isCrafting = true;
				break;
			case 8633:
				p.craftId = 1129;
				p.leatherId = 1741;
				p.craftDelAmt = 10;
				p.isCrafting = true;
				break;
			case 8641:
				p.craftId = 1061;
				p.leatherId = 1741;
				p.craftDelAmt = 1;
				p.isCrafting = true;
				break;
			case 8640:
				p.craftId = 1061;
				p.leatherId = 1741;
				p.craftDelAmt = 5;
				p.isCrafting = true;
				break;
			case 8639:
				p.craftId = 1061;
				p.leatherId = 1741;
				p.craftDelAmt = 10;
				p.isCrafting = true;
				break;
			case 8644:
				p.craftId = 1063;
				p.leatherId = 1741;
				p.craftDelAmt = 1;
				p.isCrafting = true;
				break;
			case 8643:
				p.craftId = 1063;
				p.leatherId = 1741;
				p.craftDelAmt = 5;
				p.isCrafting = true;
				break;
			case 8642:
				p.craftId = 1063;
				p.leatherId = 1741;
				p.craftDelAmt = 10;
				p.isCrafting = true;
				break;
			case 8647:
				p.craftId = 1095;
				p.leatherId = 1741;
				p.craftDelAmt = 1;
				p.isCrafting = true;
				break;
			case 8646:
				p.craftId = 1095;
				p.leatherId = 1741;
				p.craftDelAmt = 5;
				p.isCrafting = true;
				break;
			case 8645:
				p.craftId = 1095;
				p.leatherId = 1741;
				p.craftDelAmt = 10;
				p.isCrafting = true;
				break;
			case 8650:
				p.craftId = 1169;
				p.leatherId = 1741;
				p.craftDelAmt = 1;
				p.isCrafting = true;
				break;
			case 8649:
				p.craftId = 1169;
				p.leatherId = 1741;
				p.craftDelAmt = 5;
				p.isCrafting = true;
				break;
			case 8648:
				p.craftId = 1169;
				p.leatherId = 1741;
				p.craftDelAmt = 10;
				p.isCrafting = true;
				break;
			case 8653:
				p.craftId = 1167;
				p.leatherId = 1741;
				p.craftDelAmt = 1;
				p.isCrafting = true;
				break;
			case 8652:
				p.craftId = 1167;
				p.leatherId = 1741;
				p.craftDelAmt = 5;
				p.isCrafting = true;
				break;
			case 8651:
				p.craftId = 1167;
				p.leatherId = 1741;
				p.craftDelAmt = 10;
				p.isCrafting = true;
				break;

		

/*
 * Cooking buttons.
 */
			case 13720: p.getCooking().cookItem(p, p.getCooking().cookingItem, 1);
			break;
			case 13719: p.getCooking().cookItem(p, p.getCooking().cookingItem, 5);
			break;
			case 13718: p.outStream.createFrame(27);
			break;
			case 13717: p.getCooking().cookItem(p, p.getCooking().cookingItem, p.amountOfItem28(p.getCooking().cookingItem)); 
			break;

		case 839: //Previous Button
			if(p.page == 2) {
				p.histBook1();
			}
			if(p.page == 3) {
				p.histBook2();
			}
			if(p.page == 4) {
				p.histBook3();
			}
			if(p.page == 5) {
				p.histBook4();
			}
		break;
		case 841: //Next Button
			if(p.page == 1) {
				p.histBook2();
				break;
			}
			if(p.page == 2) {
				p.histBook3();
				break;
			}
			if(p.page == 3) {
				p.histBook4();
				break;
			}
			if(p.page == 4) {
				p.histBook5();
				break;
			}
		break;
		case 10162: //Close Window Button
			p.RemoveAllWindows();
			p.page = 0;
                    	p.outStream.createFrame(1); // Stops the animation, period
			p.updateRequired = true;
			p.appearanceUpdateRequired = true;	
		break;

		case 8843:
		case 8656:
			SkillMenus.miningInterface(p);
			break;
		case 8859:
		case 8671:
			SkillMenus.woodcuttingInterface(p);
			break;
		case 8840:
		case 8655:
			SkillMenus.hitpointInterface(p);
			break;
		case 8846:
		case 8654:
			SkillMenus.attackInterface(p);
			break;
		case 8827:
		case 8663:
			SkillMenus.rangeInterface(p);
			break;
		case 8824:
		case 8660:
			SkillMenus.defenceInterface(p);
			break;
		case 8657:
		case 8823:
			SkillMenus.strengthInterface(p);
			break;
		case 8670:
		case 8865:
			SkillMenus.fletchingInterface(p);
			break;
		case 8661:
		case 8862:
			SkillMenus.herbloreInterface(p);
			break;
		case 11941:
			p.getMusic().playMusic(p, p.getMusic().THEME);
		break;
		case 4287://place for my head
			p.getMusic().playMusic(p, p.getMusic().A_PLACE_FOR_MY_HEAD);
		break;
		case 4288://blue
			p.getMusic().playMusic(p, p.getMusic().BLUE);
		break;
		case 4289://Rhapsody - Emerald Sword
			p.getMusic().playMusic(p, p.getMusic().EMERALD_SWORD);
		break;
		case 4290://Queen-Bohemian Rhapsody
			p.getMusic().playMusic(p, p.getMusic().BOHEMIAN_RHAPSODY);
		break;
		case 11134://eye of the tiger
			p.getMusic().playMusic(p, p.getMusic().EYE_TIGER);
		break;
		case 4292://pause music
			p.getMusic().playMusic(p, p.getMusic().PAUSE);
		break;
		case 4294://resume music
			p.getMusic().playMusic(p, p.getMusic().RESUME);
		break;



		case 13760://Yes Tunnel	
		if(p.tombTalk == 1 && p.killCount == 5) {
			p.getMusic().playMusic(p, p.getMusic().CHRONO_BELL);
			p.teleportTo(3569, 9694, 0, 0, -1, -1, -1, 0, 0);
			p.sendMessage("You find yourself falling through the dirt inside the crypt.");
			p.sendMessage("You fall through the ceiling and land inside a maze.");
			p.tombTalk = 0;
			p.savemoreinfo();
			p.RemoveAllWindows();
		} else if (p.tombTalk == 1 && p.killCount <= 4) {
			p.sendMessage("You need to kill all 5 barrows brothers before going down.");
			p.RemoveAllWindows();
		} else {
			p.teleportTo(3569, 9694, 0, 0, -1, -1, -1, 0, 0);
			p.sendMessage("You find yourself falling through the dirt inside the crypt.");
			p.sendMessage("You fall through the ceiling and land inside a maze.");
			p.tombTalk = 0;
			p.savemoreinfo();
			p.RemoveAllWindows();
		}
		break;

		case 13761://No Tunnel
		p.RemoveAllWindows();
		break;


		case 8211://High Level Island
		if(!p.playerHasItem(1505)) {
			if (p.playerLevel[0] >= 70 || p.playerLevel [1] >= 70 ||p.playerLevel[2] >= 70 || p.playerLevel[4] >= 70 || p.playerLevel[6] >= 70) {
				p.getMusic().playMusic(p, p.getMusic().ISLAND);
				p.teleportTo(2851, 3238, 0, 0, -1, -1, -1, 0, 0);
				p.appearanceUpdateRequired = true;
				p.updateRequired = true;
				p.sendMessage("Beware, the monsters on this island are extremely tough");
				p.sendMessage("You land on the shore..");
				if (p.starter == 1) {
				p.addItem(1052, 1);
				p.starter = 2;
				p.savemoreinfo();
				}
				p.RemoveAllWindows();
				} else if (p.playerLevel[0] < 70) {
				p.sendMessage("You must be 70 attack, strength, defence, ranged or magic to enter this area.");
				p.RemoveAllWindows();
				} else if (p.playerLevel [1] < 70) {
				p.sendMessage("You must be 70 attack, strength, defence, ranged or magic to enter this area.");
				p.RemoveAllWindows();
				} else if (p.playerLevel[2] < 70) {
				p.sendMessage("You must be 70 attack, strength, defence, ranged or magic to enter this area.");
				p.RemoveAllWindows();
				} else if (p.playerLevel[4] < 70) {
				p.sendMessage("You must be 70 attack, strength, defence, ranged or magic to enter this area.");
				p.RemoveAllWindows();
				} else if (p.playerLevel[6] < 70) {
				p.sendMessage("You must be 70 attack, strength, defence, ranged or magic to enter this area.");
				p.RemoveAllWindows();
			}
		} else {
		p.sendMessage("You may not use this portal if you possess a bank scroll.");
		p.RemoveAllWindows();
		}
break;


case 8212:
p.RemoveAllWindows();
break;

case 8209: //click first
p.sendFrame164(368);
p.sendFrame126("Clicking 'Yes' when using the Red Portal will send you to an island", 369);
p.sendFrame126("with monsters that if, without caution, you CAN and WILL die.", 370);
p.sendFrame126("You may not enter the red portal with a bank scroll.", 371);
p.sendFrame126("@dre@If this is your first time entering, leave 1 slot open.", 372);
break;

case 8210: //disclaimer
p.sendFrame164(363);
p.sendFrame126("This disclaimer declares you agree to the terms", 364);
p.sendFrame126("of use and herby declare that any and @red@ ALL @bla@ ", 365);
p.sendFrame126("Staff are not responsible for your death. Thank you.", 366);

break;


			case 168:
				p.showInterface(3559);
				break;
				
			case 166:
				p.skillcapeEmote(p.playerEquipment[p.playerCape]);
				break;

			case 2494:
				p.gloryTeleport(3087, 3498);
				break;
			case 2495:
				p.gloryTeleport(2916, 3176);
				break;
			case 2496:
				p.gloryTeleport(3104, 3249);
				break;
			case 2497:
				p.gloryTeleport(3293, 3181);
				break;
			case 2498:
				p.RemoveAllWindows();
				p.delID = 0;
				p.newID = 0;
				break;

			case 6674:
				if (p.duelWith <= 0) {
					break;
				}
				if (GameEngine.playerHandler.players[p.duelWith] == null) {
					break;
				}
				clientHandler p2 = (clientHandler)GameEngine.playerHandler.players[p.duelWith];
							
				if (p2.duelStatus == 1) {
					p.sendFrame126("Waiting for other player...", 6684);
					p2.sendFrame126("Other player has accepted.", 6684);
					p.duelStatus = 2;
					int l6 = p.GetDuelItemSlots();

					if (p.duelRule[5]) {
						for (int j8 = 0; j8 < p.playerEquipment.length; j8++) {
							if (p.playerEquipment[j8] > 0 && j8 != p.playerWeapon && j8 != p.playerArrows) {
								l6++;
							}
						}
					}
					if (p.duelRule[4] && p.playerEquipment[p.playerWeapon] > 0) {
						l6++;
					}
					if (l6 > p.freeSlots()) {
						p.sendMessage("You do not have enough space in your inventory.");
						p2.sendMessage("Other player does not have enough inventory space.");
						p.duelStatus = 1;
						p2.duelStatus = 1;
						p.sendFrame126("", 6684);
						p2.sendFrame126("", 6684);
					}
					break;
				}
				if (p2.duelStatus != 2) {
					break;
				}
				p.duelStatus = 3;
				p2.duelStatus = 3;
				int i7 = p.GetDuelItemSlots();

				if (p.duelRule[5]) {
					for (int k8 = 0; k8 < p.playerEquipment.length; k8++) {
						if (p.playerEquipment[k8] > 0 && k8 != p.playerWeapon && k8 != p.playerArrows) {
							i7++;
						}
					}
				}
				if (i7 > p.freeSlots()) {
					p.sendMessage("You do not have enough space in your inventory.");
					p2.sendMessage("Other player does not have enough inventory space.");
					p.duelStatus = 1;
					p2.duelStatus = 1;
					p.sendFrame126("", 6684);
					p2.sendFrame126("", 6684);
					break;
				}
				if (p.freeSlots() < (p.duelSpaceReq) || p2.freeSlots() < (p2.duelSpaceReq)) {
					p.sendMessage("You or your opponent don't have the required space to set this rule.");
					p2.sendMessage("You or your opponent don't have the required space to set this rule.");
					p.duelStatus = 1;
					p2.duelStatus = 1;
					p.sendFrame126("", 6684);
					p2.sendFrame126("", 6684);

					if (p.playerEquipment[p.duelSlot] > 0) {
						p.duelSpaceReq--;
					}
					if (p2.playerEquipment[p2.duelSlot] > 0) {
						p2.duelSpaceReq--;
					}
					return;
				}
				for (int i = 11; i < 22; i++) {
					if (p.duelRule[i]) {
						int slot = 0;

						if (i < 20) {
							slot = i - 9;
						} else {
							slot = i - 8;
						}
						p.RemoveItem(p.playerEquipment[i], 0);
					}
				}
				p.RemoveAllWindows();
				p2.RemoveAllWindows();
				p.DuelStart();
				p2.DuelStart();

				if (!p.duelRule[9] && !p.duelRule[10]) {
					int l8 = Misc.random(p.noObMoveX.length - 1);
					int j10 = Misc.random(p.noObMoveX.length - 1);
					p.teleportToX = p.noObMoveX[l8];
					p.teleportToY = p.noObMoveY[l8];
					p2.teleportToX = p.noObMoveX[j10];
					p2.teleportToY = p.noObMoveY[j10];
				} else if (p.duelRule[9] && !p.duelRule[10]) {
					if (Misc.random(2) == 1) {
						p.teleportToX = 3337;
						p.teleportToY = 3253;
						p2.teleportToX = 3337;
						p2.teleportToY = 3252;
					} else if (Misc.random(2) == 1) {
						p.teleportToX = 3346;
						p.teleportToY = 3255;
						p2.teleportToX = 3347;
						p2.teleportToY = 3255;
					} else if (Misc.random(2) == 1) {
						p.teleportToX = 3345;
						p.teleportToY = 3251;
						p2.teleportToX = 3344;
						p2.teleportToY = 3251;
					} else {
						p.teleportToX = 3354;
						p.teleportToY = 3251;
						p2.teleportToX = 3354;
						p2.teleportToY = 3252;
					}
				} else if (p.duelRule[10]) {
					int i9 = Misc.random(p.obMoveX.length - 1);
					int k10 = Misc.random(p.obMoveX.length - 1);
					p.teleportToX = p.obMoveX[i9];
					p.teleportToY = p.obMoveY[i9];
					p2.teleportToX = p.obMoveX[k10];
					p2.teleportToY = p.obMoveY[k10];
					p.duelRule[9] = false;
					p2.duelRule[9] = false;
				}
				if (p.duelRule[5]) {
					for (int j9 = 0; j9 < p.playerEquipment.length; j9++) {
						if (p.playerEquipment[j9] > 0 && j9 != p.playerWeapon) {
							p.RemoveItem(p.playerEquipment[j9], j9);
						}
					}
					for (int k9 = 0; k9 < p.playerEquipment.length; k9++) {
						if (p2.playerEquipment[k9] > 0 && k9 != p.playerWeapon) {
							p2.RemoveItem(p2.playerEquipment[k9], k9);
						}
					}
				}
				p.sendFrame87(286, 256);
				p.duelOption = 0;
				p2.duelOption = 0;
				p2.sendFrame87(286, 256);

				if (p.duelRule[4]) {
					p.RemoveItem(p.playerEquipment[p.playerWeapon], p.playerWeapon);
					p2.RemoveItem(p2.playerEquipment[p.playerWeapon], p.playerWeapon);
				}
				p.drawHeadicon(10, p.duelWith, 0, 0);
				p2.drawHeadicon(10, p.playerId, 0, 0);
				p.duelStartDelay = 16;
				p2.duelStartDelay = 16;
				break;


			case 6725:
				p.selectRule(0);
				break;
			case 6726:
				p.selectRule(1);
				break;
			case 6727:
				p.selectRule(2);
				break;
			case 7816:
				p.selectRule(3);
				break;
			case 670:
				p.selectRule(4);
				break;
			case 6721:
				//p.selectRule(5);
				p.sendMessage("This rule has been disabled.");
				break;
			case 6728:
				p.selectRule(6);
				break;
			case 6729:
				p.selectRule(7);
				break;
			case 6730:
				p.selectRule(8);
				break;
			case 6722:
				p.selectRule(9);
				break;
			case 6732:
				p.selectRule(10);
				break;
			}

			switch (actionButtonId) {

			case 53245: //no helm
				p.selectRule(11);
				break;
		
			case 53246: // no cape
				p.selectRule(12);
				break;
			
			case 53247: // no ammy
				p.selectRule(13);
				break;
			
			case 53249: // no weapon.
				p.selectRule(14);
				break;
			
			case 53250: // no body
				p.selectRule(15);
				break;
		
			case 53251: // no shield
				p.selectRule(16);
				break;
			
			case 53252: // no legs
				p.selectRule(17);
				break;
			
			case 53255: // no gloves
				p.selectRule(18);
				break;
			
			case 53254: // no boots
				p.selectRule(19);
				break;
		
			case 53253: // no rings
				p.selectRule(20);
				break;
		
			case 53248: // no arrows
				p.selectRule(21);
				break;

			case 76045:
				if (!p.usingVeng) {
					if (System.currentTimeMillis() - p.vengUseDelay >= 30000) {
						if (!p.pHasItem(560, 2) || !p.pHasItem(557, 10)) {
							p.sendMessage("You need 2 death runes and 10 earth runes to cast this spell.");
							break;
						}
						p.startAnimation(3630);
						p.usingVeng = true;
						p.deleteItem(560, p.GetItemSlot(560), 2);
						p.deleteItem(557, p.GetItemSlot(557), 10);
						p.vengDelay = 150;
						p.vengUseDelay = System.currentTimeMillis();
					} else {
						p.sendMessage("You can only use vengeance every 30 seconds!");
					}
				} else {
					p.sendMessage("You already have Vengeance casted!");
				}
				break;

			case 59004:
				p.RemoveAllWindows();
				p.closeInterface();
				break;

			case 58253:
				p.showInterface(15106);
				break;

			case 4169:
				if (p.playerLevel[6] >= 80) {
					if (!p.charge) {
						p.chargeTimer = 400;
						p.charge = true;
						p.startAnimation(811);
						p.gfx100(301);
						p.sendMessage("You feel charged with power.");
					} else {
						p.sendMessage("You have already cast this spell!");
					}
				} else {
					p.sendMessage("You need a magic level of 80 to cast this spell.");
				}
				break;

case 47024:
case 7053:
case 47023:
case 7052:
case 47022:
case 7051:
case 47021:
case 7050:
case 7049:
case 7048:
case 7047:
case 7046:
case 7045:
case 7044:
case 7043:
case 7042:
case 7041:
case 7040:
case 7039:
case 7038:
case 51058:
case 51069:
case 51080:
case 1097:
p.sendMessage("Autocasting is temporarily disabled.");
break;
/*
				case 47024:
				case 7053:
					p.autoCastSet(75, 16, 0);
					break;
				case 47023:
				case 7052:
					p.autoCastSet(70, 15, 0);
					break;
				case 47022:
				case 7051:
					p.autoCastSet(65, 14, 0);
					break;
				case 47021:
				case 7050:
					p.autoCastSet(62, 13, 0);
					break;
				case 7049:
					p.autoCastSet(59, 12, 0);
					break;
				case 7048:
					p.autoCastSet(53, 11, 0);
					break;
				case 7047:
					p.autoCastSet(47, 10, 0);
					break;
				case 7046:
					p.autoCastSet(41, 9, 0);
					break;
				case 7045:
					p.autoCastSet(35, 8, 0);
					break;
				case 7044:
					p.autoCastSet(29, 7, 0);
					break;
				case 7043:
					p.autoCastSet(23, 6, 0);
					break;
				case 7042:
					p.autoCastSet(17, 5, 0);
					break;
				case 7041:
					p.autoCastSet(13, 4, 0);
					break;
				case 7040:
					p.autoCastSet(9, 3, 0);
					break;
				case 7039:
					p.autoCastSet(5, 2, 0);
					break;
				case 7038:
					p.autoCastSet(1, 1, 0);
					break;
				case 51080:
					p.autoCastSet(94, 0, 16);
					break;
				case 51058:
					p.autoCastSet(82, 0, 12);
					break;
				case 51069:
					p.autoCastSet(70, 0, 8);
					break;
*/

				case 4140:
					int k = (p.absY - 3520) / 8 + 1;
					p.restorePrayer = 0;

					if (p.duelStatus == 3 || k >= 20 && p.Wild()) {
						p.sendMessage("You cannot teleport here!");
						break;
					}
						if(!p.isJailed) {
							if (p.actionTimer <= 0) {
								p.actionTimer = 6;
								p.getMusic().playMusic(p, p.getMusic().THEME);
								p.teleportTo(2441 + Misc.random(3), 3091 + Misc.random(1), 0, 5, 714, 715, 111, 100, 2);

							} 
						} else {
							p.sendMessage("You cannot teleport while jailed!");
						}
					break;

                		case 4143:
					k = (p.absY - 3520) / 8 + 1;
					p.restorePrayer = 0;

					if (p.duelStatus == 3 || k >= 20 && p.Wild()) {
						p.sendMessage("You cannot teleport here!");
						break;
					}
				if(!p.isJailed) {
					if (p.playerLevel[6] >= 31) {
						if ((!p.pHasItem(563, 1)) || (!p.pHasItem(557, 1) || (!p.pHasItem(556, 3)))) {
							p.sendMessage("You do not have enough runes to cast this spell.");
						} else {
							if (p.actionTimer <= 0) {
								p.actionTimer = 6;
								p.teleportTo(2441 + Misc.random(3), 3091 + Misc.random(1), 0, 5, 714, 715, 111, 100, 2);
								p.getMusic().playMusic(p, p.getMusic().THEME);
								p.deleteItem(557, p.getItemSlot(554), 1); 
								p.deleteItem(556, p.getItemSlot(556), 3); 
								p.deleteItem(563, p.getItemSlot(563), 1);
							}
						}
					} else {
						p.sendMessage("You need a magic level of 31 to cast this spell.");
					}
					} else {
						p.sendMessage("You cannot teleport while jailed!");
					}
					break;

				case 4146: 
					k = (p.absY - 3520) / 8 + 1;
					p.restorePrayer = 0;

					if (p.duelStatus == 3 || k >= 20 && p.Wild()) {
						p.sendMessage("You cannot teleport here!");
						break;
					}
				if(!p.isJailed) {
					if (p.playerLevel[6] >= 37) {
						if ((!p.pHasItem(563, 1)) || (!p.pHasItem(555, 1) || (!p.pHasItem(556, 3)))) {
							p.sendMessage("You do not have enough runes to cast this spell.");
						} else {
							if (p.actionTimer <= 0) {
								p.actionTimer = 6;
								p.teleportTo(2441 + Misc.random(3), 3091 + Misc.random(1), 0, 5, 714, 715, 111, 100, 2);
								p.getMusic().playMusic(p, p.getMusic().THEME);
								p.deleteItem(555, p.getItemSlot(554), 1); 
								p.deleteItem(556, p.getItemSlot(556), 3); 
								p.deleteItem(563, p.getItemSlot(563), 1); 
							}
						}
					} else {
						p.sendMessage("You need a magic level of 37 to cast this spell.");
					}
					} else {
						p.sendMessage("You cannot teleport while jailed!");
					}
					break;

               			case 4150: 
					k = (p.absY - 3520) / 8 + 1;
					p.restorePrayer = 0;

					if (p.duelStatus == 3 || k >= 20 && p.Wild()) {
						p.sendMessage("You cannot teleport here!");
						break;
					}
				if(!p.isJailed) {
					if (p.playerLevel[6] >= 45) {
						if ((!p.pHasItem(563, 1)) || (!p.pHasItem(556, 5))) {
							p.sendMessage("You do not have enough runes to cast this spell.");
						} else {
							if (p.actionTimer <= 0) {
								p.actionTimer = 6;
								p.teleportTo(2441 + Misc.random(3), 3091 + Misc.random(1), 0, 5, 714, 715, 111, 100, 2);
								p.getMusic().playMusic(p, p.getMusic().THEME);
								p.deleteItem(556, p.getItemSlot(556), 5); 
								p.deleteItem(563, p.getItemSlot(563), 1); 
							}
						}
					} else {
						p.sendMessage("You need a magic level of 45 to cast this spell.");
					}
					} else {
						p.sendMessage("You cannot teleport while jailed!");
					}
					break;

				case 6004: 
					k = (p.absY - 3520) / 8 + 1;

					if (p.duelStatus == 3 || k >= 20 && p.Wild()) {
						p.sendMessage("You cannot teleport here!");
						break;
					}
				if(!p.isJailed) {
					if (p.playerLevel[6] >= 51) {
						if ((!p.pHasItem(563, 2)) || (!p.pHasItem(555, 2))) {
							p.sendMessage("You do not have enough runes to cast this spell.");
						} else {
							if (p.actionTimer <= 0) {
								p.actionTimer = 6;
								p.teleportTo(2441 + Misc.random(3), 3091 + Misc.random(1), 0, 5, 714, 715, 111, 100, 2);
								p.getMusic().playMusic(p, p.getMusic().THEME);
								p.deleteItem(555, p.getItemSlot(556), 2); 
								p.deleteItem(563, p.getItemSlot(563), 2);
							}
						}
					} else {
						p.sendMessage("You need a magic level of 51 to cast this spell.");
					}
					} else {
						p.sendMessage("You cannot teleport while jailed!");
					}
					break;

				case 9167://Select Option 1
					if (p.NpcDialogue == 1598) {
						p.NpcDialogue = 1601;
						p.NpcDialogueSend = false;
					}
					if (p.NpcDialogue == 1839) {//Easter Q 1 2001
						p.NpcDialogue = 1851;
						p.NpcDialogueSend = false;
					}
					if (p.NpcDialogue == 1840) {// Easter Q 2 2006
						p.NpcDialogue = 1854;
						p.NpcDialogueSend = false;
					}
					if (p.NpcDialogue == 1841) {//Easter Q 3 2003
						p.NpcDialogue = 1852;
						p.NpcDialogueSend = false;
					}
					break;
				case 9168://Select Option 2
					if (p.NpcDialogue == 1598) {
						p.NpcDialogue = 1605;
						p.NpcDialogueSend = false;
					}
					if (p.NpcDialogue == 1839) {//Easter Q 1 2003
						p.NpcDialogue = 1852;
						p.NpcDialogueSend = false;
					}
					if (p.NpcDialogue == 1840) {//Easter Q 2 2007
						p.NpcDialogue = 1855;
						p.NpcDialogueSend = false;
					}
					if (p.NpcDialogue == 1841) {//Easter Q 3 2010
						p.NpcDialogue = 1856;
						p.NpcDialogueSend = false;
					}
					break;
				case 9169://Select Option 3
					if (p.NpcDialogue == 1598) {
						p.RemoveAllWindows();
					}
					if (p.NpcDialogue == 1839) {//Easter Q 1 2005
						p.NpcDialogue = 1853;
						p.NpcDialogueSend = false;
					}
					if (p.NpcDialogue == 1840) {//Easter Q 2 2005
						p.NpcDialogue = 1853;
						p.NpcDialogueSend = false;
					}
					if (p.NpcDialogue == 1841) {//Easter Q 3 2005
						p.NpcDialogue = 1853;
						p.NpcDialogueSend = false;
					}
					break;

				case 9157://Select Option 1
					if (p.NpcDialogue == 2618) {
						p.teleportTo(2439, 5169, 0, 0, -1, -1, -1, 0, 0);
						p.getMusic().playMusic(p, p.getMusic().EYE_TIGER);
                    				p.NpcDialogue = 0;
                     				p.NpcDialogueSend = false;
                     				p.RemoveAllWindows();
					} else if (p.NpcDialogue == 1921) {
						p.NpcDialogue = 1922;
						p.NpcDialogueSend = false;
					} else if (p.NpcDialogue == 1928) {
						p.teleportTo(0000, 0000, 0, 4, 714, 715, -1, 100, 2);
						p.dtQuest = 2;
						p.savemoreinfo();
						p.NpcDialogue = 1929;
						p.NpcDialogueSend = false;
					} else if (p.NpcDialogue == 2) {
						p.NpcDialogue = 0;
						p.NpcDialogueSend = false;
						p.openUpBank();
					} else if (p.NpcDialogue == 5001) {
						p.teleportTo(3552, 9692, 0, 0, -1, -1, -1, 0, 0);
						p.NpcDialogue = 0;
                    				p.NpcDialogueSend = true;
                    				p.RemoveAllWindows();
					} else if (p.NpcDialogue == 4) { //Aubury
						p.NpcDialogue = 0;
						p.NpcDialogueSend = false;
						p.openUpShop(2);
					} else if (p.NpcDialogue == 523) { //General store
						p.NpcDialogue = 0;
						p.NpcDialogueSend = false;
						p.openUpShop(55);
					} else if (p.NpcDialogue == 582) { //Flynn
						p.NpcDialogue = 0;
						p.NpcDialogueSend = false;
						p.openUpShop(5);
					} else if (p.NpcDialogue == 579) { //Cassie
						p.NpcDialogue = 0;
						p.NpcDialogueSend = false;
						p.openUpShop(4);
					} else if (p.NpcDialogue == 651) { //Lowe
						p.NpcDialogue = 0;
						p.NpcDialogueSend = false;
						p.openUpShop(49);
					} else if (p.NpcDialogue == 549) { //Thessalia
						p.NpcDialogue = 0;
						p.NpcDialogueSend = false;
						p.openUpShop(56);
					} else if (p.NpcDialogue == 546) { //Zaff
						p.NpcDialogue = 0;
						p.NpcDialogueSend = false;
						p.openUpShop(51);
					} else if (p.NpcDialogue == 674) { //Zaff
						p.NpcDialogue = 0;
						p.NpcDialogueSend = false;
						p.openUpShop(66);
					} else if (p.NpcDialogue == 2024) { //Barrows yes teleport
						p.teleportTo(3564, 3288, 0, 0, -1, -1, -1, 0, 0);
						p.getMusic().playMusic(p, p.getMusic().RUNESCAPE_1);
						p.sendMessage("The Strange old man takes you to the barrows.");
						p.sendMessage("You turn around to ask him about it but he has disappeared.");
						p.addItem(952, 1);
						p.killCount = 0;
						p.dharokSummoned = 0;
						p.ahrimSummoned = 0;
						p.veracSummoned = 0;
						p.toragSummoned = 0;
						p.karilSummoned = 0;
						p.guthanSummoned = 0;
						p.RemoveAllWindows();
						p.NpcDialogue = 0;
						p.NpcDialogueSend = false;

					}
					if (p.NpcDialogue == 1859) {//Easter Yes
						p.NpcDialogue = 1836;
						p.NpcDialogueSend = false;
					}
					if(p.NpcDialogue == 308) {
						p.NpcDialogue = 309;
						p.NpcDialogueSend = false;
					}
					break;

				case 9158://Select Option 2
					if (p.NpcDialogue == 1921) {
						p.NpcDialogue = 2100;
						p.NpcDialogueSend = false;
					} else if (p.NpcDialogue == 1836) {//Easter No
						p.NpcDialogue = 1858;
						p.NpcDialogueSend = false;
                  			} else if (p.NpcDialogue == 2024) {//barrows no
                     				p.RemoveAllWindows();
						p.NpcDialogue = 0;
						p.NpcDialogueSend = false;
					} else if (p.NpcDialogue == 2) {
						p.NpcDialogue = 0;
						p.NpcDialogueSend = false;
						p.openUpPinSettings();
					} else if (p.NpcDialogue == 4) {
						p.NpcDialogue = 5;
						p.NpcDialogueSend = false;
					} else if (p.NpcDialogue == 41) {
                     				p.NpcDialogue = 0;
                     				p.NpcDialogueSend = false;
                     				p.RemoveAllWindows();
                  			} else if (p.NpcDialogue == 43) {
                     				p.NpcDialogue = 0;
                     				p.NpcDialogueSend = false;
                     				p.RemoveAllWindows();
                  			} else if (p.NpcDialogue == 2260) {
                     				p.NpcDialogue = 0;
                     				p.NpcDialogueSend = false;
                     				p.RemoveAllWindows();
                  			} else if (p.NpcDialogue == 1002) {
                     				p.NpcDialogue = 0;
                     				p.NpcDialogueSend = true;
                     				p.RemoveAllWindows();
                  			} else if (p.NpcDialogue == 302) {
                     				p.NpcDialogue = 300;
                     				p.NpcDialogueSend = false;
                  			} else if (p.NpcDialogue == 305) {
                    				p.NpcDialogue = 0;
                     				p.NpcDialogueSend = true;
                     				p.RemoveAllWindows();
                  			} else if (p.NpcDialogue == 14601) {
                     				p.NpcDialogue = 0;
                     				p.NpcDialogueSend = true;
                     				p.RemoveAllWindows();
                  			} else if (p.NpcDialogue == 523) {
                     				p.NpcDialogue = 524;
		     				p.NpcDialogueSend = false;
                  			} else if (p.NpcDialogue == 582) {
                     				p.NpcDialogue = 583;
		     				p.NpcDialogueSend = false;
                  			} else if (p.NpcDialogue == 579) {
                     				p.NpcDialogue = 576;
		     				p.NpcDialogueSend = false;
                  			} else if (p.NpcDialogue == 651) {
                    				p.NpcDialogue = 652;
		    				p.NpcDialogueSend = false;
                  			} else if (p.NpcDialogue == 549) {
                     				p.showInterface(3559);
		     				p.NpcDialogueSend = true;
                  			} else if (p.NpcDialogue == 546) {
		     				p.NpcDialogueSend = false;
		     				p.NpcDialogue = 1100;
                  			} else if (p.NpcDialogue == 674) {
		     				p.NpcDialogueSend = false;
		     				p.NpcDialogue = 675;
					} else if (p.NpcDialogue == 308) {
						p.NpcDialogue = 310;
						p.NpcDialogueSend = false;
					} else {
						p.NpcDialogue = 0;
                     				p.NpcDialogueSend = true;
                     				p.RemoveAllWindows();
					}
					break;

				case 29063:
					if (p.playerEquipment[3] == 1377 && p.specialAmount <= 99) {//dba
						p.sendMessage("You do not have enough special energy left.");
					}
					if (p.playerEquipment[3] == 1377 && p.specialAmount >= 100) {//dba
						p.startAnimation(1670);
						p.gfx0(246);
						p.specialAmount -= 100;
					}
					p.specs();
					break;

				case 29113: // bows
				case 33033: // halberds
				case 29163: // swords
				case 29138: // dds
				case 48023: // whip
					try {
						if (p.usingSpecial == true) {
							p.usingSpecial = false;
						} else if (p.usingSpecial == false) {
							p.usingSpecial = true;
						}
						p.specs();
					} catch (Exception popo) {

					}
					if (p.playerEquipment[3] == 4153) {
						if (p.IsAttacking && !p.IsDead) {
							if (PlayerHandler.players[p.AttackingOn] != null) {
								if (!PlayerHandler.players[p.AttackingOn].IsDead) {
									PlayerCombat.Attack(p);
								}
							}
						}
					}
					break;

				case 14067: // Char design accept button
					p.RemoveAllWindows();
					break;

				case 9118:
					p.RemoveAllWindows();
					break;

				case 153:
					//if (p.playerEnergy > 0) {
						p.isRunning2 = true;
					//}
					break;
				case 152:
					p.stoprunning = true;
					p.isRunning2 = false;
					break;

				case 130: //close interface
					if(p.playerRights >= 2) {
					p.println_debug("Closing Interface");
					}
					break;

				case 9125: //Accurate
				case 22228: //punch (unarmed)
				case 48010: //flick (whip)
				case 21200: //spike (pickaxe)
				case 1080: //bash (staff)
				case 6168: //chop (axe)
				case 6236: //accurate (long bow)
				case 17102: //accurate (darts)
				case 8234: //stab (dagger)
					p.FightType = 1;
					p.SkillID = 0;
					break;

				case 9126: //Defensive
				case 22229: //block (unarmed)
				case 21201: //block (pickaxe)
				case 1078: //focus - block (staff)
				case 6169: //block (axe)
				case 33019: //fend (hally)
				case 18078: //block (spear)
				case 8235: //block (dagger)
					p.FightType = 4;
					p.SkillID = 1;
					break;

				case 9127: // Controlled
				case 48009: //lash (whip)
				case 33018: //jab (hally)
				case 6234: //longrange (long bow)
				case 18077: //lunge (spear)
				case 18080: //swipe (spear)
				case 18079: //pound (spear)
				case 17100: //longrange (darts)
					p.FightType = 3;
					p.SkillID = 3;
					break;

				case 9128: //Aggressive
				case 22230: //kick (unarmed)
				case 21203: //impale (pickaxe)
				case 21202: //smash (pickaxe)
				case 1079: //pound (staff)
				case 6171: //hack (axe)
				case 6170: //smash (axe)
				case 33020: //swipe (hally)
				case 6235: //rapid (long bow)
				case 17101: //repid (darts)
				case 8237: //lunge (dagger)
				case 8236: //slash (dagger)
					p.FightType = 2;
					p.SkillID = 2;
					break;

			case 9154: // Log out
				if (p.teleBlock) {
					p.sendMessage("You cannot log out while teleblocked.");
					break;
				}
              	if (p.LogoutDelay > 0) {
              		p.sendMessage("You must wait 10 seconds after combat to log out!");
					break;
				}
                p.logout();
                p.savefile = true;	
				break;

				case 21011:
					p.takeAsNote = false;
					break;
				case 21010:
					p.takeAsNote = true;
					break;
				case 13092:
				if (p.playerLevel[0] >= 10 ||
				    p.playerLevel[1] >= 10 ||
				    p.playerLevel[2] >= 10 ||
				    p.playerLevel[3] >= 10 ||
				    p.playerLevel[4] >= 10 ||
				    p.playerLevel[5] >= 10 ||
				    p.playerLevel[6] >= 10 ||
				    p.playerLevel[7] >= 10 ||
				    p.playerLevel[8] >= 10 ||
				    p.playerLevel[9] >= 10 ||
				    p.playerLevel[10] >= 10 ||
				    p.playerLevel[11] >= 10 ||
				    p.playerLevel[12] >= 10 ||
				    p.playerLevel[13] >= 10 ||
				    p.playerLevel[14] >= 10 ||
				    p.playerLevel[15] >= 10 ||
				    p.playerLevel[16] >= 10 ||
				    p.playerLevel[17] >= 10 ||
				    p.playerLevel[18] >= 10 ||
				    p.playerLevel[19] >= 10 ||
				    p.playerLevel[20] >= 10 ||
				    p.playerLevel[21] >= 10
				) {
					if (p.tradeWith > 0) {
		if(p.playerLastConnect != PlayerHandler.players[p.tradeWith].playerLastConnect) {
						if (PlayerHandler.players[p.tradeWith].tradeStatus == 2) {
							p.tradeStatus = 3;
							p.sendFrame126("Waiting for other player...", 3431);
						} else if (PlayerHandler.players[p.tradeWith].tradeStatus == 3) {
							p.tradeStatus = 3;
							//TradeGoConfirm();
						}
		}
					}
				}
					break;
				case 13218:
					if (p.tradeWith > 0) {
		if(p.playerLastConnect != PlayerHandler.players[p.tradeWith].playerLastConnect) {
						if (PlayerHandler.players[p.tradeWith].tradeStatus == 3) {
							p.tradeStatus = 4;
							p.sendFrame126("Waiting for other player...", 3535);
						} else if (PlayerHandler.players[p.tradeWith].tradeStatus == 4) {
							p.tradeStatus = 4;
							//ConfirmTrade();
						}
		}
					}
					break;
/*
				case 1097:
					if (p.ancients == 0) {
						if (p.playerEquipment[3] == 1381 || p.playerEquipment[3] == 1383 || p.playerEquipment[3] == 1385 || p.playerEquipment[3] == 1387 || p.playerEquipment[3] == 3054 || p.playerEquipment[3] == 6563) {
							p.setSidebarInterface(0, 1829);
						} else {
							p.sendMessage("You cannot autocast modern magics with an Ancient staff!");
						}
					} else if (p.ancients == 1) {
						if (p.playerEquipment[3] == 4675) {
							p.setSidebarInterface(0, 1689);
						} else {
							p.sendMessage("You cannot autocast ancient magics with a regular staff!");
						}
					}
					break;
*/

				case 47069:
				case 7212:
					p.setSidebarInterface(0, 328);
					break;

				case 3162:
					p.InWildrange = true;
					break;
				case 3163:
					p.InWildrange = false;
					break;

				case 21233: // Thick Skin
					if (p.duelRule[8]) {
						p.sendMessage("Prayer has been disabled for this duel!");
						p.resetPrayer();
						break;
					}
					if (p.playerLevel[5] > 0) {
						if (p.getLevelForXP(p.playerXP[5]) < 4) {
							p.sendFrame126("You need a @blu@Prayer level of 1 to use Thick skin.", 357);
							p.sendFrame164(356);
							p.sendMessage("You need a Prayer level of 1 to use this."); 
							p.resetPrayer();
						}
					}
					if (p.playerLevel[5] <= 0) {
						p.resetPrayer();
						p.sendMessage("You need to recharge your prayer at an altar."); 
					}
					if (p.getLevelForXP(p.playerXP[5]) >= 1) {
						if (p.playerLevel[5] > 0) {
							if (!p.thickSkin) {
								p.NewDrain = 30;
								p.checkDrain();
								p.usingPrayer = true;
								p.thickSkin = true;
								p.rockSkin = false;
								p.steelSkin = false;
								p.frame36(86, 0);
								p.frame36(92, 0);
								p.updateRequired = true;
								p.appearanceUpdateRequired = true;
							} else if (p.thickSkin) {
								p.usingPrayer = false;
								p.thickSkin = false;
								p.updateRequired = true;
								p.appearanceUpdateRequired = true;
							}
						}
					}
					break;

				case 21234: // Burst Of Strength
					if (p.duelRule[8]) {
						p.sendMessage("Prayer has been disabled for this duel!");
						p.resetPrayer();
						break;
					}
					if (p.playerLevel[5] > 0) {
						if (p.getLevelForXP(p.playerXP[5]) < 4) {
							p.sendFrame126("You need a @blu@Prayer level of 4 to use Burst of strength.", 357);
							p.sendFrame164(356);
							p.sendMessage("You need a Prayer level of 4 to use this."); 
							p.resetPrayer();
						}
					}
					if (p.playerLevel[5] <= 0) {
						p.resetPrayer();
						p.sendMessage("You need to recharge your prayer at an altar."); 
					}

					if (p.getLevelForXP(p.playerXP[5]) >= 4) {
						if (p.playerLevel[5] > 0) {
							if (!p.burstOfStr) {
								p.NewDrain = 30;
								p.checkDrain();
								p.usingPrayer = true;
								p.burstOfStr = true;
								p.superHumanStr = false;
								p.ultimateStr = false;
								p.frame36(87, 0);
								p.frame36(93, 0);
								p.updateRequired = true;
								p.appearanceUpdateRequired = true;
							} else if (p.burstOfStr) {
								p.usingPrayer = false;
								p.burstOfStr = false;
								p.updateRequired = true;
								p.appearanceUpdateRequired = true;
							}
						}
					}
					break;

				case 21235: // Clarity Of Thought
					if (p.duelRule[8]) {
						p.sendMessage("Prayer has been disabled for this duel!");
						p.resetPrayer();
						break;
					}
					if (p.playerLevel[5] > 0) {
						if (p.getLevelForXP(p.playerXP[5]) < 7) {
							p.sendFrame126("You need a @blu@Prayer level of 7 to use Clarity of thought.", 357);
							p.sendFrame164(356);
							p.sendMessage("You need a Prayer level of 7 to use this."); 
							p.resetPrayer();
						}
					}
					if (p.playerLevel[5] <= 0) {
						p.resetPrayer();
						p.sendMessage("You need to recharge your prayer at an altar."); 
					}

					if (p.getLevelForXP(p.playerXP[5]) >= 7) {
						if (p.playerLevel[5] > 0) {
							if (!p.clarity) {
								p.NewDrain = 30;
								p.checkDrain();
								p.usingPrayer = true;
								p.clarity = true;
								p.improvedReflex = false;
								p.incredibleReflex = false;
								p.frame36(88, 0);
								p.frame36(94, 0);
								p.updateRequired = true;
								p.appearanceUpdateRequired = true;
							} else if (p.clarity) {
								p.usingPrayer = false;
								p.clarity = false;
								p.updateRequired = true;
								p.appearanceUpdateRequired = true;
							}
						}
					}
					break;

				case 21236: // Rock Skin
					if (p.duelRule[8]) {
						p.sendMessage("Prayer has been disabled for this duel!");
						p.resetPrayer();
						break;
					}
					if (p.playerLevel[5] > 0) {
						if (p.getLevelForXP(p.playerXP[5]) < 10) {
							p.sendFrame126("You need a @blu@Prayer level of 10 to use Rock skin.", 357);
							p.sendFrame164(356);
							p.sendMessage("You need a Prayer level of 10 to use this."); 
							p.resetPrayer();
						}
					}
					if (p.playerLevel[5] <= 0) {
						p.resetPrayer();
						p.sendMessage("You need to recharge your prayer at an altar."); 
					}

					if (p.getLevelForXP(p.playerXP[5]) >= 10) {
						if (p.playerLevel[5] > 0) {
							if (!p.rockSkin) {
								p.NewDrain = 16;
								p.checkDrain();
								p.usingPrayer = true;
								p.rockSkin = true;
								p.thickSkin = false;
								p.steelSkin = false;
								p.frame36(83, 0);
								p.frame36(92, 0);
								p.updateRequired = true;
								p.appearanceUpdateRequired = true;
							} else if (p.rockSkin) {
								p.usingPrayer = false;
								p.rockSkin = false;
								p.updateRequired = true;
								p.appearanceUpdateRequired = true;
							}
						}
					}
					break;

				case 21237: // Superhuman Strength
					if (p.duelRule[8]) {
						p.sendMessage("Prayer has been disabled for this duel!");
						p.resetPrayer();
						break;
					}
					if (p.playerLevel[5] > 0) {
						if (p.getLevelForXP(p.playerXP[5]) < 13) {
							p.sendFrame126("You need a @blu@Prayer level of 13 to use Superhuman strength.", 357);
							p.sendFrame164(356);
							p.sendMessage("You need a Prayer level of 13 to use this."); 
							p.resetPrayer();
						}
					}
					if (p.playerLevel[5] <= 0) {
						p.resetPrayer();
						p.sendMessage("You need to recharge your prayer at an altar."); 
					}

					if (p.getLevelForXP(p.playerXP[5]) >= 13) {
						if (p.playerLevel[5] > 0) {
							if (!p.superHumanStr) {
								p.NewDrain = 16;
								p.checkDrain();
								p.usingPrayer = true;
								p.superHumanStr = true;
								p.burstOfStr = false;
								p.ultimateStr = false;
								p.frame36(84, 0);
								p.frame36(93, 0);
								p.updateRequired = true;
								p.appearanceUpdateRequired = true;
							} else if (p.superHumanStr) {
								p.usingPrayer = false;
								p.superHumanStr = false;
								p.updateRequired = true;
								p.appearanceUpdateRequired = true;
							}
						}
					}
					break;

				case 21238: // Improved Reflexes
					if (p.duelRule[8]) {
						p.sendMessage("Prayer has been disabled for this duel!");
						p.resetPrayer();
						break;
					}
					if (p.playerLevel[5] > 0) {
						if (p.getLevelForXP(p.playerXP[5]) < 16) {
							p.sendFrame126("You need a @blu@Prayer level of 16 to use Improved reflexes.", 357);
							p.sendFrame164(356);
							p.sendMessage("You need a Prayer level of 16 to use this."); 
							p.resetPrayer();
						}
					}
					if (p.playerLevel[5] <= 0) {
						p.resetPrayer();
						p.sendMessage("You need to recharge your prayer at an altar."); 
					}

					if (p.getLevelForXP(p.playerXP[5]) >= 16) {
						if (p.playerLevel[5] > 0) {
							if (!p.improvedReflex) {
								p.NewDrain = 16;
								p.checkDrain();
								p.usingPrayer = true;
								p.improvedReflex = true;
								p.clarity = false;
								p.incredibleReflex = false;
								p.frame36(85, 0);
								p.frame36(94, 0);
								p.updateRequired = true;
								p.appearanceUpdateRequired = true;
							} else if (p.improvedReflex) {
								p.usingPrayer = false;
								p.improvedReflex = false;
								p.updateRequired = true;
								p.appearanceUpdateRequired = true;
							}
					   	}
					}
					break;

				case 21239: // Rapid Restore
					p.sendFrame126("This prayer isn't available.", 357);
					p.sendFrame164(356);
					p.resetPrayer();
					break;

				case 21240: // Rapid Heal
					p.sendFrame126("This prayer isn't available.", 357);
					p.sendFrame164(356);
					p.resetPrayer();
					break;

				case 21241: // Protect Item
					if (p.duelRule[8]) {
						p.sendMessage("Prayer has been disabled for this duel!");
						p.resetPrayer();
						break;
					}
					if (p.playerLevel[5] > 0) {
						if (p.getLevelForXP(p.playerXP[5]) < 25) {
							p.sendFrame126("You need a @blu@Prayer level of 25 to use Protect item.", 357);
							p.sendFrame164(356);
							p.sendMessage("You need a Prayer level of 25 to use this."); 
							p.resetPrayer();
						}
					}
					if (p.playerLevel[5] <= 0) {
						p.resetPrayer();
						p.sendMessage("You need to recharge your prayer at an altar."); 
					}

					if (p.getLevelForXP(p.playerXP[5]) >= 25) {
						if (p.playerLevel[5] > 0) {
							if (!p.protItem) {
								p.NewDrain = 40;
								p.checkDrain();
								p.usingPrayer = true;
								p.protItem = true;
								p.updateRequired = true;
								p.appearanceUpdateRequired = true;
							} else if (p.protItem) {
								p.usingPrayer = false;
								p.protItem = false;
								p.updateRequired = true;
								p.appearanceUpdateRequired = true;
							}
						}
					}
					break;

					case 21242: // Steel Skin
						if (p.duelRule[8]) {
							p.sendMessage("Prayer has been disabled for this duel!");
							p.resetPrayer();
							break;
						}
						if (p.playerLevel[5] > 0) {
						    if (p.getLevelForXP(p.playerXP[5]) < 28) {
							p.sendFrame126("You need a @blu@Prayer level of 28 to use Steel skin.", 357);
							p.sendFrame164(356);
							p.sendMessage("You need a Prayer level of 28 to use this."); 
							p.resetPrayer();
						    }
						}
						if (p.playerLevel[5] <= 0) {
							p.resetPrayer();
							p.sendMessage("You need to recharge your prayer at an altar."); 
						}

					    if (p.getLevelForXP(p.playerXP[5]) >= 28) {
					      if (p.playerLevel[5] > 0) {
						if (!p.steelSkin) {
							p.NewDrain = 10;
							p.checkDrain();
							p.usingPrayer = true;
							p.steelSkin = true;
							p.thickSkin = false;
							p.rockSkin = false;
							p.frame36(83, 0);
							p.frame36(86, 0);
							p.updateRequired = true;
							p.appearanceUpdateRequired = true;
						} else if (p.steelSkin) {
							p.usingPrayer = false;
							p.steelSkin = false;
							p.updateRequired = true;
							p.appearanceUpdateRequired = true;
						}
					      }
					    }
						break;

					case 21243: // Ultimate Strength
						if (p.duelRule[8]) {
							p.sendMessage("Prayer has been disabled for this duel!");
							p.resetPrayer();
							break;
						}
						if (p.playerLevel[5] > 0) {
						    if (p.getLevelForXP(p.playerXP[5]) < 31) {
							p.sendFrame126("You need a @blu@Prayer level of 31 to use Ultimate strength.", 357);
							p.sendFrame164(356);
							p.sendMessage("You need a Prayer level of 31 to use this."); 
							p.resetPrayer();
						    }
						}
						if (p.playerLevel[5] <= 0) {
							p.resetPrayer();
							p.sendMessage("You need to recharge your prayer at an altar."); 
						}

					    if (p.getLevelForXP(p.playerXP[5]) >= 31) {
					      if (p.playerLevel[5] > 0) {
						if (!p.ultimateStr) {
							p.NewDrain = 10;
							p.checkDrain();
							p.usingPrayer = true;
							p.ultimateStr = true;
							p.burstOfStr = false;
							p.superHumanStr = false;
							p.frame36(84, 0);
							p.frame36(87, 0);
							p.updateRequired = true;
							p.appearanceUpdateRequired = true;
						} else if (p.ultimateStr) {
							p.usingPrayer = false;
							p.ultimateStr = false;
							p.updateRequired = true;
							p.appearanceUpdateRequired = true;
						}
					      }
					    }
						break;

					case 21244: // Incredible Reflexes
						if (p.duelRule[8]) {
							p.sendMessage("Prayer has been disabled for this duel!");
							p.resetPrayer();
							break;
						}
						if (p.playerLevel[5] > 0) {
						    if (p.getLevelForXP(p.playerXP[5]) < 34) {
							p.sendFrame126("You need a @blu@Prayer level of 34 to use Incredible reflexes.", 357);
							p.sendFrame164(356);
							p.sendMessage("You need a Prayer level of 34 to use this."); 
							p.resetPrayer();
						    }
						}
						if (p.playerLevel[5] <= 0) {
							p.resetPrayer();
							p.sendMessage("You need to recharge your prayer at an altar."); 
						}

					    if (p.getLevelForXP(p.playerXP[5]) >= 34) {
					      if (p.playerLevel[5] > 0) {
						if (!p.improvedReflex) {
							p.NewDrain = 10;
							p.checkDrain();
							p.usingPrayer = true;
							p.incredibleReflex = true;
							p.clarity = false;
							p.improvedReflex = false;
							p.frame36(85, 0);
							p.frame36(88, 0);
							p.updateRequired = true;
							p.appearanceUpdateRequired = true;
						} else if (p.improvedReflex) {
							p.usingPrayer = false;
							p.improvedReflex = false;
							p.updateRequired = true;
							p.appearanceUpdateRequired = true;
						}
					      }
					    }
						break;

					case 21245: // Protect magic
						if (p.duelRule[8]) {
							p.sendMessage("Prayer has been disabled for this duel!");
							p.resetPrayer();
							break;
						}
						if (p.playerLevel[5] > 0) {
						    if (p.getLevelForXP(p.playerXP[5]) < 37) {
							p.sendFrame126("You need a @blu@Prayer level of 37 to use Protect Magic.", 357);
							p.sendFrame164(356);
							p.sendMessage("You need a Prayer level of 37 to use this."); 
							p.resetPrayer();
						    }
						}
						if (p.playerLevel[5] <= 0) {
							p.resetPrayer();
							p.sendMessage("You need to recharge your prayer at an altar."); 
						}

					    if (p.getLevelForXP(p.playerXP[5]) >= 37) {
					      if (p.playerLevel[5] > 0) {
						if (!p.magicPrayer) {
							p.NewDrain = 10;
							p.checkDrain();
							p.usingPrayer = true;
							p.magicPrayer = true;
							p.smitePrayer = false;
							p.meleePrayer = false;
							p.rangedPrayer = false;
							p.redempPrayer = false;
							p.retriPrayer = false;
							p.headIcon = 4;
							p.frame36(96, 0);
							p.frame36(97, 0);
							p.frame36(98, 0);
							p.frame36(99, 0);
							p.frame36(100, 0);
							p.updateRequired = true;
							p.appearanceUpdateRequired = true;
						} else if (p.magicPrayer) {
							p.usingPrayer = false;
							p.magicPrayer = false;
							p.headIcon = 0;
							p.updateRequired = true;
							p.appearanceUpdateRequired = true;
						}
					      }
					    }
						break;

					case 21246: // Protect range
						if (p.duelRule[8]) {
							p.sendMessage("Prayer has been disabled for this duel!");
							p.resetPrayer();
							break;
						}
						if (p.playerLevel[5] > 0) {
						    if (p.getLevelForXP(p.playerXP[5]) < 40){
							p.sendFrame126("You need a @blu@Prayer level of 40 to use Protect Range.", 357);
							p.sendFrame164(356);
							p.sendMessage("You need a Prayer level of 40 to use this."); 
							p.frame36(96, 0);
						    }
						}
						if (p.playerLevel[5] <= 0){
							p.sendMessage("You need to recharge your prayer at an altar."); 
							p.frame36(96, 0);
						}
					    if (p.getLevelForXP(p.playerXP[5]) >= 40) {
					      if (p.playerLevel[5] > 0) {
						if (!p.rangedPrayer) {
							p.NewDrain = 10;
							p.checkDrain();
							p.usingPrayer = true;
							p.rangedPrayer = true;
							p.smitePrayer = false;
							p.meleePrayer = false;
							p.magicPrayer = false;
							p.redempPrayer = false;
							p.retriPrayer = false;
							p.headIcon = 2;
							p.frame36(95, 0);
							p.frame36(97, 0);
							p.frame36(98, 0);
							p.frame36(99, 0);
							p.frame36(100, 0);
							p.updateRequired = true;
							p.appearanceUpdateRequired = true;
						} else if (p.rangedPrayer) {
							p.usingPrayer = false;
							p.rangedPrayer = false;
							p.headIcon = 0;
							p.updateRequired = true;
							p.appearanceUpdateRequired = true;
						}
					      }
					    }
						break;

					case 21247: // Protect melee
						if (p.duelRule[8]) {
							p.sendMessage("Prayer has been disabled for this duel!");
							p.resetPrayer();
							break;
						}
						if (p.playerLevel[5] > 0) {
						    if (p.getLevelForXP(p.playerXP[5]) < 43){
							p.sendFrame126("You need a @blu@Prayer level of 43 to use Protect melee.", 357);
							p.sendFrame164(356);
							p.sendMessage("You need a Prayer level of 43 to use this."); 
							p.frame36(97, 0);
						    }
						}
						if (p.playerLevel[5] <= 0){
							p.sendMessage("You need to recharge your prayer at an altar."); 
							p.frame36(97, 0);
						}
					    if (p.getLevelForXP(p.playerXP[5]) >= 43) {
					      if (p.playerLevel[5] > 0) {
						if (!p.meleePrayer) {
							p.NewDrain = 10;
							p.checkDrain();
							p.usingPrayer = true;
							p.meleePrayer = true;
							p.smitePrayer = false;
							p.rangedPrayer = false;
							p.magicPrayer = false;
							p.redempPrayer = false;
							p.retriPrayer = false;
							p.headIcon = 128;
							p.frame36(95, 0);
							p.frame36(96, 0);
							p.frame36(98, 0);
							p.frame36(99, 0);
							p.frame36(100, 0);
							p.updateRequired = true;
							p.appearanceUpdateRequired = true;
						} else if (p.meleePrayer) {
							p.usingPrayer = false;
							p.meleePrayer = false;
							p.headIcon = 0;
							p.updateRequired = true;
							p.appearanceUpdateRequired = true;
						}
					      }
					    }
						break;

					case 2171: // Retribution
						if (p.duelRule[8]) {
							p.sendMessage("Prayer has been disabled for this duel!");
							p.resetPrayer();
							break;
						}
						if (p.playerLevel[5] > 0) {
						    if (p.getLevelForXP(p.playerXP[5]) < 46){
							p.sendFrame126("You need a @blu@Prayer level of 46 to use Retribution.", 357);
							p.sendFrame164(356);
							p.sendMessage("You need a Prayer level of 46 to use this."); 
							p.frame36(98, 0);
						    }
						}
						if (p.playerLevel[5] <= 0){
							p.sendMessage("You need to recharge your prayer at an altar."); 
							p.frame36(98, 0);
						}
					    if (p.getLevelForXP(p.playerXP[5]) >= 46) {
					      if (p.playerLevel[5] > 0) {
						if (!p.retriPrayer) {
							p.NewDrain = 30;
							p.checkDrain();
							p.usingPrayer = true;
							p.retriPrayer = true;
							p.smitePrayer = false;
							p.meleePrayer = false;
							p.rangedPrayer = false;
							p.magicPrayer = false;
							p.redempPrayer = false;
							p.headIcon = 8;
							p.frame36(95, 0);
							p.frame36(96, 0);
							p.frame36(97, 0);
							p.frame36(99, 0);
							p.frame36(100, 0);
							p.updateRequired = true;
							p.appearanceUpdateRequired = true;
						} else if (p.retriPrayer) {
							p.usingPrayer = false;
							p.retriPrayer = false;
							p.headIcon = 0;
							p.updateRequired = true;
							p.appearanceUpdateRequired = true;
						}
					      }
					    }
						break;


					case 2172: // Redemption
						if (p.duelRule[8]) {
							p.sendMessage("Prayer has been disabled for this duel!");
							p.resetPrayer();
							break;
						}
						if (p.playerLevel[5] > 0) {
						    if (p.getLevelForXP(p.playerXP[5]) < 49){
							p.sendFrame126("You need a @blu@Prayer level of 49 to use Redemption.", 357);
							p.sendFrame164(356);
							p.sendMessage("You need a Prayer level of 49 to use this."); 
							p.frame36(99, 0);
						    }
						}
						if (p.playerLevel[5] <= 0){
							p.sendMessage("You need to recharge your prayer at an altar."); 
							p.frame36(99, 0);
						}
					    if (p.getLevelForXP(p.playerXP[5]) >= 49) {
					      if (p.playerLevel[5] > 0) {
						if (!p.redempPrayer) {
							p.NewDrain = 16;
							p.checkDrain();
							p.usingPrayer = true;
							p.redempPrayer = true;
							p.smitePrayer = false;
							p.meleePrayer = false;
							p.rangedPrayer = false;
							p.magicPrayer = false;
							p.retriPrayer = false;
							p.headIcon = 32;
							p.frame36(95, 0);
							p.frame36(96, 0);
							p.frame36(97, 0);
							p.frame36(98, 0);
							p.frame36(100, 0);
							p.updateRequired = true;
							p.appearanceUpdateRequired = true;
						} else if (p.redempPrayer) {
							p.usingPrayer = false;
							p.redempPrayer = false;
							p.headIcon = 0;
							p.updateRequired = true;
							p.appearanceUpdateRequired = true;
						}
					      }
					    }
						break;

			case 2173: // Smite
				if (p.duelRule[8]) {
					p.sendMessage("Prayer has been disabled for this duel!");
					p.resetPrayer();
					break;
				}
				if (p.playerLevel[5] > 0) {
					if (p.getLevelForXP(p.playerXP[5]) < 52){
						p.sendFrame126("You need a @blu@Prayer level of 52 to use Smite.", 357);
						p.sendFrame164(356);
						p.sendMessage("You need a Prayer level of 52 to use this."); 
						p.frame36(100, 0);
					}
				}
				if (p.playerLevel[5] <= 0){
					p.sendMessage("You need to recharge your prayer at an altar."); 
					p.frame36(100, 0);
				}
				if (p.getLevelForXP(p.playerXP[5]) >= 52) {
					if (p.playerLevel[5] > 0) {
						if (!p.smitePrayer) {
							p.NewDrain = 8;
							p.checkDrain();
							p.usingPrayer = true;
							p.smitePrayer = true;
							p.redempPrayer = false;
							p.meleePrayer = false;
							p.rangedPrayer = false;
							p.magicPrayer = false;
							p.retriPrayer = false;
							p.headIcon = 16;
							p.frame36(95, 0);
							p.frame36(96, 0);
							p.frame36(97, 0);
							p.frame36(98, 0);
							p.frame36(99, 0);
							p.updateRequired = true;
							p.appearanceUpdateRequired = true;
						} else if (p.smitePrayer) {
							p.usingPrayer = false;
							p.smitePrayer = false;
							p.headIcon = 0;
							p.updateRequired = true;
							p.appearanceUpdateRequired = true;
						}
					}
				}
				break;



/*Smelting
 *
 */

	case 3987: //Bronze 1
		p.getSmelting().amountToSmelt = 1;
		p.getSmelting().startSmelt(p);
		p.choiceClick = 1;
		p.RemoveAllWindows();
	break;
	case 3986: //Bronze 5
		p.getSmelting().amountToSmelt = 5;
		p.getSmelting().startSmelt(p);
		p.choiceClick = 1;
		p.RemoveAllWindows();
	break;
	case 2807: //Bronze 10
		p.getSmelting().amountToSmelt = 10;
		p.getSmelting().startSmelt(p);
		p.choiceClick = 1;
		p.RemoveAllWindows();
	break;
	case 3991: //Iron 1
		p.getSmelting().amountToSmelt = 1;
		p.getSmelting().startSmelt(p);
		p.choiceClick = 2;
		p.RemoveAllWindows();
	break;
	case 3990: //Iron 5
		p.getSmelting().amountToSmelt = 5;
		p.getSmelting().startSmelt(p);
		p.choiceClick = 2;
		p.RemoveAllWindows();
	break;
	case 3989: //Iron 10
		p.getSmelting().amountToSmelt = 10;
		p.getSmelting().startSmelt(p);
		p.choiceClick = 2;
		p.RemoveAllWindows();
	break;
	case 3995: //Silver 1
		p.getSmelting().amountToSmelt = 1;
		p.getSmelting().startSmelt(p);
		p.choiceClick = 3;
		p.RemoveAllWindows();
	break;
	case 3994: //Silver 5
		p.getSmelting().amountToSmelt = 5;
		p.getSmelting().startSmelt(p);
		p.choiceClick = 3;
		p.RemoveAllWindows();

	break;
	case 3993: //Silver 10
		p.getSmelting().amountToSmelt = 10;
		p.getSmelting().startSmelt(p);
		p.choiceClick = 3;
		p.RemoveAllWindows();
	break;
	case 3999: //Steel 1
		p.getSmelting().amountToSmelt = 1;
		p.getSmelting().startSmelt(p);
		p.choiceClick = 4;
		p.RemoveAllWindows();
	break;
	case 3998: //Steel 5
		p.getSmelting().amountToSmelt = 5;
		p.getSmelting().startSmelt(p);
		p.choiceClick = 4;
		p.RemoveAllWindows();
	break;
	case 3997: //Steel 10
		p.getSmelting().amountToSmelt = 10;
		p.getSmelting().startSmelt(p);
		p.choiceClick = 4;
		p.RemoveAllWindows();
	break;
	case 4003: //Gold 1
		p.getSmelting().amountToSmelt = 1;
		p.getSmelting().startSmelt(p);
		p.choiceClick = 5;
		p.RemoveAllWindows();
	break;
	case 4002: //Gold 5
		p.getSmelting().amountToSmelt = 5;
		p.getSmelting().startSmelt(p);
		p.choiceClick = 5;
		p.RemoveAllWindows();
	break;
	case 4001: //Gold 10
		p.getSmelting().amountToSmelt = 10;
		p.getSmelting().startSmelt(p);
		p.choiceClick = 5;
		p.RemoveAllWindows();
	break;
	case 7441: //Mithril 1
		p.getSmelting().amountToSmelt = 1;
		p.getSmelting().startSmelt(p);
		p.choiceClick = 6;
		p.RemoveAllWindows();
	break;
	case 7440: //Mithril 5
		p.getSmelting().amountToSmelt = 5;
		p.getSmelting().startSmelt(p);
		p.choiceClick = 6;
		p.RemoveAllWindows();
	break;
	case 6397: //Mithril 10
		p.getSmelting().amountToSmelt = 10;
		p.getSmelting().startSmelt(p);
		p.choiceClick = 6;
		p.RemoveAllWindows();
	break;
	case 7446: //Adamant 1
		p.getSmelting().amountToSmelt = 1;
		p.getSmelting().startSmelt(p);
		p.choiceClick = 7;
		p.RemoveAllWindows();
	break;
	case 7444: //Adamant 5
		p.getSmelting().amountToSmelt = 5;
		p.getSmelting().startSmelt(p);
		p.choiceClick = 7;
		p.RemoveAllWindows();
	break;
	case 7443: //Adamant 10
		p.getSmelting().amountToSmelt = 10;
		p.getSmelting().startSmelt(p);
		p.choiceClick = 7;
		p.RemoveAllWindows();
	break;
	case 7450: //Runite 1
		p.getSmelting().amountToSmelt = 1;
		p.getSmelting().startSmelt(p);
		p.choiceClick = 8;
		p.RemoveAllWindows();
	break;
	case 7449: //Runite 5
		p.getSmelting().amountToSmelt = 5;
		p.getSmelting().startSmelt(p);
		p.choiceClick = 8;
		p.RemoveAllWindows();
	break;
	case 7448: //Runite 10
		p.getSmelting().amountToSmelt = 10;
		p.getSmelting().startSmelt(p);
		p.choiceClick = 8;
		p.RemoveAllWindows();
	break;


/*
 *
 *emotes
*/
			case 72033:
				p.startAnimation(3543);
				p.updateRequired = true;
				p.appearanceUpdateRequired = true;
			break;
			case 72032:
				p.startAnimation(3544);
				p.updateRequired = true;
				p.appearanceUpdateRequired = true;
			break;
			case 59062:
				p.startAnimation(2836);
				p.updateRequired = true;
				p.appearanceUpdateRequired = true;

/*
 *
 *Genie Lamp
 *
 *
*/

			break;
			default:
				if(p.playerRights >= 2) {
				System.out.println("Case 185: Action Button: "+buttonId);
				}
				break;
		}
	}
}