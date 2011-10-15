/*
 * Second object option.
 */

package com.iClarity.player.packetHandler.Packets;

import com.iClarity.*;
import com.iClarity.player.*;
import com.iClarity.player.Skills.*;
import com.iClarity.misc.*;

public class ObjectOption2 {

	public static void processPacket(clientHandler p, int packetType, int packetSize) {
		int objectID = p.inStream.readUnsignedWordBigEndianA();
		int objectY = p.inStream.readSignedWordBigEndian();
		int objectX = p.inStream.readUnsignedWordA();

switch(objectID) {


	case 2644:
	p.destinationRange = 1;
	if (p.GoodDistance(p.absX, p.absY, objectX, objectY, 2)) {
		if(p.actionTimer == 0) {
			p.TurnPlayerTo(objectX, objectY);
			p.isFlaxing = true;
			p.sendFrame164(8866);
			p.sendFrame246(8869, 200, 1759);
			p.sendFrame246(8870, 200, 1779);
			p.sendFrame126("Ball of wool", 8874);
			p.sendFrame126("Flax", 8875);
		}
	} else {
		p.sendMessage("You must be next to the wheel to use it!");
		p.isFlaxing = false;
	}
	break;

	case 2646:
	p.destinationRange = 1;
		if(p.actionTimer == 0) {
			p.actionTimer += 4;
			p.TurnPlayerTo(objectX, objectY);
			if(p.freeSlots() > 0) {
				p.sendMessage("You pick some flax");
				p.addItem(1779, 1);
				p.startAnimation(827);
				p.replaceFlax = 20;
				p.deleteObjects(objectX, objectY);
				p.interfaceStage = 2;
			} else {
				p.sendMessage("You don't have enough inventory space to do that!");
			}
		}
	break;



case 4706://vegetable stall
case 4708:
	p.destinationRange = 2;
	if (p.GoodDistance(p.absX, p.absY, objectX, objectY, 2)) {
		if(p.actionTimer == 0) {
			p.actionTimer += 10;
			p.TurnPlayerTo(objectX, objectY);
			if (p.freeSlots() > 0) {
				if(objectX == 2517 && objectY == 3862) {
					p.replaceVegetableStall = 15;
					p.ReplaceObject3(2517, 3862, 4276, 0, 10);
				} else if(objectX == 2600 && objectY == 3867) {
					p.replaceVegetableStall2 = 15;
					p.ReplaceObject3(2600, 3867, 4276, 1, 10);
				}
				p.addSkillXP((37+Misc.random(10)), p.playerThieving);
				p.startAnimation(881);
				p.addItem(1965, 1);
				p.sendMessage("You steal from the vegetable stall.");
			} else {
				p.sendMessage("You don't have enough inventory space to do that!");
			}
		}
	}
	break;

case 4705://Fish stall
case 4707:
	p.destinationRange = 2;
	if (p.GoodDistance(p.absX, p.absY, objectX, objectY, 2)) {
			if(p.actionTimer == 0) {
		p.actionTimer += 10;
		if(p.playerLevel[p.playerThieving] >= 40) {
				p.TurnPlayerTo(objectX, objectY);
			if (p.freeSlots() > 0) {
				if(objectX == 2513 && objectY == 3862) {
					p.ReplaceObject3(2513, 3862, 4276, 0, 10);
					p.replaceFishStall1 = 45;
				} else if(objectX == 2519 && objectY == 3866) {
					p.ReplaceObject3(2519, 3866, 4276, 3, 10);
					p.replaceFishStall2 = 45;
				} else if(objectX == 2606 && objectY == 3876) {
					p.ReplaceObject3(2606, 3876, 4276, 3, 10);
					p.replaceFishStall3 = 45;
				}
				p.addSkillXP((123+Misc.random(20)), p.playerThieving);
				p.startAnimation(881);
				int randomFish = Misc.random(2);
				if(randomFish == 0) {
					p.addItem(341, 1);
				} else if(randomFish == 1) {
					p.addItem(331, 1);
				} else if(randomFish == 2) {
					p.addItem(335, 1);
				}
				p.sendMessage("You steal from the fish stall.");
			} else {
				p.sendMessage("You don't have enough inventory space to do that!");
			}
		} else {
			p.sendMessage("You need 40 thieving to steal from that stall.");
		}
			}
	}	
	break;
case 2562://Gem stall
	p.destinationRange = 2;
	if (p.GoodDistance(p.absX, p.absY, objectX, objectY, 2)) {
			if(p.actionTimer == 0) {
		p.actionTimer += 10;
		if(p.playerLevel[p.playerThieving] >= 80) {
			p.TurnPlayerTo(objectX, objectY);
			if (p.freeSlots() > 0) {
				p.replaceGemStall = 75;
				p.ReplaceObject3(2511, 3866, 4276, 1, 10);
				p.addSkillXP((235+Misc.random(36)), p.playerThieving);
				p.startAnimation(881);
				int randomGem = Misc.random(3);
				if(randomGem == 0) {
					p.addItem(1623, 1);
				} else if(randomGem == 1) {
					p.addItem(1621, 1);
				} else if(randomGem == 2) {
					p.addItem(1619, 1);
				} else if(randomGem == 3) {
					p.addItem(1617, 1);
				}				
				p.sendMessage("You steal from the gem stall.");
			} else {
				p.sendMessage("You don't have enough inventory space to do that!");
			}
		} else {
			p.sendMessage("You need at least 80 thieving to do that.");
		}
			}
	}
	break;
case 2561://Baker's stall
	p.destinationRange = 2;
	if (p.GoodDistance(p.absX, p.absY, objectX, objectY, 2)) {
			if(p.actionTimer == 0) {
				p.actionTimer += 10;
		if(p.playerLevel[p.playerThieving] >= 20) {
			p.TurnPlayerTo(objectX, objectY);
			if (p.freeSlots() > 0) {
				p.replaceBakerStall = 55;
				p.ReplaceObject3(2517, 3869, 4276, 2, 10);
				p.addSkillXP((68+Misc.random(13)), p.playerThieving);
				p.startAnimation(881);
				int randomBakedGood = Misc.random(2);
				if(randomBakedGood == 1) {
					p.addItem(1891, 1);
				} else if(randomBakedGood == 2) {
					p.addItem(1901, 1);
				} else if(randomBakedGood == 0) {
					p.addItem(2309, 1);
				}				
				p.sendMessage("You steal from the baker's stall.");
			} else {
				p.sendMessage("You don't have enough inventory space to do that!");
			}
		} else {
			p.sendMessage("You need at least 20 thieving to do that.");
		}
			}
	}
	break;


	case 6912:
		p.destinationRange = 3;
		break;

	case 11666:
		p.sendFrame164(2400);
		p.sendFrame246(2405, 150, 2349);//Bronze
		p.sendFrame246(2406, 150, 2351);//Iron
		p.sendFrame246(2407, 150, 2355);//Silver
		p.sendFrame246(2409, 150, 2353);//Steel
		p.sendFrame246(2410, 150, 2357);//Gold
		p.sendFrame246(2411, 150, 2359);//Mith
		p.sendFrame246(2412, 150, 2361);//Addy
		p.sendFrame246(2413, 150, 2363);//Rune
		p.isSmelting = true;
	break;

			default:
				if(p.playerRights >= 2) {
					p.sendMessage("[ObjectOption2]Object ID:" +objectID);
				}
				p.destinationRange = 1;
				break;
}



 		if (p.GoodDistance(p.absX, p.absY, objectX, objectY, p.destinationRange)) {
			p.objectClick2(objectID, objectX, objectY);
		} else {
			p.ActionType = 2;
			p.destinationX = objectX;
			p.destinationY = objectY;
			p.destinationID = objectID;
			p.WalkingTo = true;
		}
	}
}