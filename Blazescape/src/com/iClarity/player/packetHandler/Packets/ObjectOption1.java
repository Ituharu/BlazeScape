/*
 * First object option.
 */

package com.iClarity.player.packetHandler.Packets;

import com.iClarity.*;
import com.iClarity.player.*;
import com.iClarity.player.Skills.*;
import com.iClarity.player.Minigames.*;
import com.iClarity.world.Objects.*;
import com.iClarity.player.packetHandler.*;
import com.iClarity.player.combat.*;
import com.iClarity.misc.*;


public class ObjectOption1 {

	public static void processPacket(clientHandler p, int packetType, int packetSize) {
		int objectX = p.inStream.readSignedWordBigEndianA();
		int objectID = p.inStream.readUnsignedWord();
		int objectY = p.inStream.readUnsignedWordA();
		int remainingArmadylKills = (10-p.armadylKills);
		int remainingZamorakKills = (10-p.zamorakKills);
		int remainingBandosKills = (10-p.bandosKills);
		
		switch (objectID) {

	case 9320:
		if (p.GoodDistance(p.absX, p.absY, objectX, objectY, 1)) {
			p.teleportToX = 3422;
			p.teleportToY = 3551;
			p.heightLevel = 0;
		}
	break;


case 4696:
	p.createObject(objectX, objectY, 4696, 0, 0);
break;
case 4423:
case 4424:
case 4465:
	p.createObject(objectX, objectY, 6951, 0, 0);
break;


	case 411:
	if(p.playerLevel[5] < 1 && p.restorePrayer == 0) {
		p.startAnimation(645);
		p.resetPrayer();
		p.playerLevel[5] = p.getLevelForXP(p.playerXP[5]);
		p.sendFrame126("Prayer: "+p.playerLevel[5]+"/"+p.getLevelForXP(p.playerXP[5])+"", 687);
		p.sendFrame126("" + p.getLevelForXP(p.playerXP[5]) + "", 4013);
		p.sendFrame126("" + p.playerLevel[5] + "", 4012);
		p.destinationRange = 3;
		p.restorePrayer = 1;
	} else {
		p.sendMessage("You cannot use this altar again until you finish the minigame");
	}
	
	break;


	case 4484:
		p.highScores();
	break;

	case 6725:
	case 6744:
		if(p.killCount >= 10) {
			p.getMusic().playMusic(p, p.getMusic().UNID_TECHNO);
			p.teleportToX = 3557;
			p.teleportToY = 9695;
			p.sendMessage("You teleport into the chest room.");
		} else {
			p.sendMessage("You need at least 10 kills to enter the chest room.");
		}
	break;

case 6771:
case 6773:
case 6772:
case 6821:
case 6823:
case 6822:
case 6707:
case 6706:
p.destinationRange = 3;
break;

			case 9356:
				p.destinationRange = 2;
				break;

case 0:
	if(p.playerLevel[8] >= 75 && p.absY >= 3213 || p.playerLevel[8] >= 75 && p.absY <= 3214 && p.absX == 2443) {
		p.getMusic().playMusic(p, p.getMusic().WALL);
		p.teleportToX = 2441;
		p.teleportToY = 3123;
	} else if(p.playerLevel[8] >= 75 && p.absY >= 3213 || p.playerLevel[8] >= 75 && p.absY <= 3124 && p.absX == 2441) {
		p.getMusic().playMusic(p, p.getMusic().THEME);
		p.teleportToX = 2443;
		p.teleportToY = 3123;
	} else if(p.playerLevel[8] <= 75) {
		p.sendMessage("You may not enter the Woodcutting Guild with a Woodcutting level lower than 75.");
	}
break;



	case 5126:
		p.destinationRange = 3;
		if (p.playerHasItem2(2418)) {
		p.getMusic().playMusic(p, p.getMusic().METAL);
			p.deleteItem(2418, p.getItemSlot(2418), 1);
			p.teleportTo(3445, 3555, 2, 0, -1, -1, -1, 0, 0);
			p.appearanceUpdateRequired = true;
			p.updateRequired = true;
		} else {
			p.sendMessage("You need a bronze key from the chaos elemental to go in there.");
		}
		break;
		
	case 4495:
		p.getMusic().playMusic(p, p.getMusic().THIRD_FLOOR);
		p.teleportTo(3417, 3540, 2, 0, -1, -1, -1, 0, 0);
		p.destinationRange = 7;
		p.appearanceUpdateRequired = true;
		p.updateRequired = true;
		break;
	case 409:
		p.getMusic().playMusic(p, p.getMusic().POKE_HEAL);
		p.startAnimation(645);
		p.resetPrayer();
		p.playerLevel[5] = p.getLevelForXP(p.playerXP[5]);
		p.sendFrame126("Prayer: "+p.playerLevel[5]+"/"+p.getLevelForXP(p.playerXP[5])+"", 687);
		p.sendFrame126("" + p.getLevelForXP(p.playerXP[5]) + "", 4013);
		p.sendFrame126("" + p.playerLevel[5] + "", 4012);
		p.destinationRange = 3;
		p.playingPokemonTheme = false;
		break;

		
	case 2469:
		p.getMusic().playMusic(p, p.getMusic().THEME);
		p.teleportTo(2441, 3091, 0, 0, -1, -1, -1, 0, 0);
		p.appearanceUpdateRequired = true;
		p.updateRequired = true;
		break;
	case 4408:
	if(!p.isJailed) {
		p.getMusic().playMusic(p, p.getMusic().BLUE);
		p.teleportTo(3429, 3538, 0, 0, -1, -1, -1, 0, 0);
		p.destinationRange = 5;
		p.appearanceUpdateRequired = true;
		p.updateRequired = true;
	}
		break;
	case 10251:
		p.getMusic().playMusic(p, p.getMusic().THEME);
		p.teleportTo(2441, 3091, 0, 0, -1, -1, -1, 0, 0);
		p.destinationRange = 7;
		p.appearanceUpdateRequired = true;
		p.updateRequired = true;
		break;
	case 4493:
		if(p.absX == 3438 && p.absY >= 3537 && p.absY <= 3538) {
			p.getMusic().playMusic(p, p.getMusic().SECOND_FLOOR);
			p.teleportTo(3433, 3538, 1, 0, -1, -1, -1, 0, 0);
			p.destinationRange = 6;
			p.appearanceUpdateRequired = true;
			p.updateRequired = true;
		} else {
			p.sendMessage("I can't reach that!");
		}
		break;
	case 12356: //wildy portal
		if (p.GoodDistance(p.absX, p.absY, objectX, objectY, 1)) {
			if(!p.isJailed) {
				p.getMusic().playMusic(p, p.getMusic().POKE_BATTLE_THEME);
				p.showInterface(1908);
				p.teleportTo(2605, 3154, 0, 0, -1, -1, -1, 0, 0);
				p.appearanceUpdateRequired = true;
				p.updateRequired = true;
			}
		} else {
			p.sendMessage("I can't reach that!");
		}
		break;

	case 2465://duel arena
	if(!p.isJailed) {
		p.getMusic().playMusic(p, p.getMusic().DUELING);
		p.teleportTo(3370, 3276, 0, 0, -1, -1, -1, 0, 0);
		p.appearanceUpdateRequired = true;
		p.updateRequired = true;
	}
		break;
	case 4494:
		if(p.absX == 3433 && p.absY >= 3537 && p.absY <= 3538) {
			p.getMusic().playMusic(p, p.getMusic().BLUE);
			p.teleportTo(3438, 3538, 0, 0, -1, -1, -1, 0, 0);
			p.destinationRange = 6;
			p.appearanceUpdateRequired = true;
			p.updateRequired = true;
		} else {
			p.sendMessage("I can't reach that!");
		}
		break;
	case 1516:
		p.createObject(objectX, objectY,0, 3, 0);
		p.createObject(2444, objectY, 1516, 3, 0);
		p.appearanceUpdateRequired = true;
		p.updateRequired = true;
		break;
	case 1519:
		p.createObject(objectX, objectY,0, 1, 0);
		p.createObject(2444, objectY, 1519, 1, 0);
		p.appearanceUpdateRequired = true;
		p.updateRequired = true;
		break;
	case 1512:
		p.createObject(objectX, objectY,1512, 2, 0);
		p.appearanceUpdateRequired = true;
		p.updateRequired = true;
		break;
	case 4483:
		if (p.GoodDistance(p.absX, p.absY, objectX, objectY, 1)) {
			p.openUpBank();
			p.appearanceUpdateRequired = true;
			p.updateRequired = true;
		} else {
			p.sendMessage("I can't reach that!");
		}
		break;
	case 2849://raft
		if(!p.isJailed) {
			p.sendFrame164(8207);
			p.sendFrame126("Click this first.", 8209);
			p.sendFrame126("Disclaimer", 8210);
			p.sendFrame126("Yes, I'd like to go", 8211);
			p.sendFrame126("No, nevermind", 8212);
		}
	break;
/*
 *
 *
 *Runecrafting
 *
 */
	case 2478: 
		p.craftRunesOnAltar(1, 25, 556, 30, 45, 60);
		p.appearanceUpdateRequired = true;
		p.updateRequired = true;
	break;
	case 2479:
		p.craftRunesOnAltar(2, 25, 558, 30, 45, 60);
		p.appearanceUpdateRequired = true;
		p.updateRequired = true;
	break;
	case 2480: 
		p.craftRunesOnAltar(5, 30, 555, 30, 45, 60);
		p.appearanceUpdateRequired = true;
		p.updateRequired = true;
	break;
	case 2481: 
		p.craftRunesOnAltar(9, 45, 557, 45, 55, 65);
		p.appearanceUpdateRequired = true;
		p.updateRequired = true;
	break;
	case 2482: 
		p.craftRunesOnAltar(14, 50, 554, 50, 60, 70);
		p.appearanceUpdateRequired = true;
		p.updateRequired = true; 
	break;
	case 2483: 
		p.craftRunesOnAltar(20, 75, 559, 55, 65, 75);
		p.appearanceUpdateRequired = true;
		p.updateRequired = true;
	break;
	case 2484:
		p.craftRunesOnAltar(27, 95, 564, 57, 69, 77);
		p.appearanceUpdateRequired = true;
		p.updateRequired = true;
	break;
	case 2487: 
		p.craftRunesOnAltar(35, 105, 562, 60, 70, 80);
		p.appearanceUpdateRequired = true;
		p.updateRequired = true;
	break;
	case 2486: 
		p.craftRunesOnAltar(44, 100, 561, 60, 74, 91);
		p.appearanceUpdateRequired = true;
		p.updateRequired = true;
	break;
	case 2485: 
		p.craftRunesOnAltar(54, 135, 563, 65, 79, 93);
		p.appearanceUpdateRequired = true;
		p.updateRequired = true; 
	break;
	case 2488: 
		p.craftRunesOnAltar(65, 150, 560, 72, 84, 96);
		p.appearanceUpdateRequired = true;
		p.updateRequired = true;
	break;
	case 2489:
		p.craftRunesOnAltar(89, 225, 566, 91, 94, 99);
		p.appearanceUpdateRequired = true;
		p.updateRequired = true;
	break;
	case 2490: 
		p.craftRunesOnAltar(77, 200, 565, 86, 97, 99);
		p.appearanceUpdateRequired = true;
		p.updateRequired = true;
	break;
	case 7139: //Air
		p.teleportTo(2842, 4835, 0, 0, -1, -1, -1, 0, 0);
		p.sendMessage("You teleport to the Air Temple.");
	break;
	case 7140: //Mind
		p.teleportTo(2784, 4840, 0, 0, -1, -1, -1, 0, 0);
		p.sendMessage("You teleport to the Mind Temple.");
	break;
	case 7131: //Body
		p.teleportTo(2527, 4833, 0, 0, -1, -1, -1, 0, 0);
		p.sendMessage("You teleport to the Body Temple.");
	break;
	case 7130: //Earth
		p.teleportTo(2660, 4839, 0, 0, -1, -1, -1, 0, 0);
		p.sendMessage("You teleport to the Earth Temple.");
	break;
	case 7129: //Fire
		p.teleportTo(2584, 4836, 0, 0, -1, -1, -1, 0, 0);
		p.sendMessage("You teleport to the Fire Temple.");
	break;
	case 7132: //Cosmic
		p.teleportTo(2162, 4833, 0, 0, -1, -1, -1, 0, 0);
		p.sendMessage("You teleport to the Cosmic Temple.");
	break;
	case 7133: //Nature
		p.teleportTo(2180, 3182, 0, 0, -1, -1, -1, 0, 0);
		p.sendMessage("You teleport to the Nature Temple.");
	break;
	case 7134: //Chaos
		p.teleportTo(2269, 4843, 0, 0, -1, -1, -1, 0, 0);
		p.sendMessage("You teleport to the Chaos Temple.");
	break;
	case 7135: //Law
		p.teleportTo(2464, 4834, 0, 0, -1, -1, -1, 0, 0);
		p.sendMessage("You teleport to the Law Temple.");
	break;
	case 7136: //Death
		p.teleportTo(2207, 4836, 0, 0, -1, -1, -1, 0, 0);
		p.sendMessage("You teleport to the Death Temple.");
	break;
	case 7137: //Water
		p.teleportTo(2713, 4836, 0, 0, -1, -1, -1, 0, 0);
		p.sendMessage("You teleport to the Water Temple.");
	break;
	case 7141: //Blood
		p.teleportTo(3035, 4854, 0, 0, -1, -1, -1, 0, 0);
		p.sendMessage("You teleport to the Blood Temple.");
	break;
	case 7138: //Soul
		p.teleportTo(2309, 4597, 0, 0, -1, -1, -1, 0, 0);
		p.sendMessage("You teleport to the Soul Temple.");
	break;
	case 8987: //Teleport to Rune Ess Mine
		p.teleportTo(2891, 4811, 0, 0, 827, -1, -1, 0, 0);
		p.sendMessage("You arrive at the rune essence mine.");
	break;
	case 2492: //Rune Ess Mine teleport to RC abyss
		p.teleportTo(3040, 4830, 0, 1, -1, -1, -1, 0, 0);
		p.sendMessage("You arrive at the runecrafting abyss.");
		p.sendMessage("Beware! Players can attack you here!.");
		p.sendMessage("You may not teleport within the abyss, enter a rift to escape predators.");
	break;
/*
 *
 *End
 *
 *
 */

			default:
				p.destinationRange = 1;
				if(p.playerRights > 2) {
					p.sendMessage("Object1: " +objectID);
				}
				break;
		}
		//AlKharid Shizzle
		AlKharidObjects.curtains(p, objectX, objectY, objectID);
		//End AlKharid Shizzle
		if (p.GoodDistance(p.absX, p.absY, objectX, objectY, 2)) {
		p.InitiateWc(objectID, objectX, objectY);
		}
		if(objectID != 2419) {
			if (p.GoodDistance(p.absX, p.absY, objectX, objectY, 1)) {
				p.InitiateMine(objectID, objectX, objectY);
			}
		} else {
			p.destinationRange = 3;
			p.InitiateMine(objectID, objectX, objectY);
			p.TurnPlayerTo(objectX, objectY);
		}

		if (p.GoodDistance(p.absX, p.absY, objectX, objectY, p.destinationRange)) {
			p.objectClick(objectID, objectX, objectY, 0, 0, 1);
		} else {
			p.ActionType = 1;
 			p.destinationX = objectX;
			p.destinationY = objectY;
			p.destinationID = objectID;
			p.WalkingTo = true;
		}
	}
}