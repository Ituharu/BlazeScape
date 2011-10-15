/*
 * Fourth object option.
 *
 * Mostly only used for construction
 */

package com.iClarity.player.packetHandler.Packets;

import com.iClarity.*;
import com.iClarity.player.*;

public class ObjectOption4 {

	public static void processPacket(clientHandler p, int packetType, int packetSize) {
		int objectID = p.inStream.readSignedWordBigEndianA();
		int objectX = p.inStream.readUnsignedWordA();//readSignedWordBigEndianA();
		int objectY = p.inStream.readUnsignedWordA();//readSignedWordBigEndianA();


switch(objectID) {

	case 15305:
		p.sendMessage("YOU CLICKED BUILD DOOR");
		break;

			default:
				p.destinationRange = 1;
				if(p.playerRights > 2) {
					p.sendMessage("[ObjectClick4]: "+objectID);
				}
				break;
}

		if (p.GoodDistance(p.absX, p.absY, objectX, objectY, p.destinationRange)) {
			p.objectClick4(objectID, objectX, objectY);
		} else {
			p.ActionType = 3;
 			p.destinationX = objectX;
			p.destinationY = objectY;
			p.destinationID = objectID;
			p.WalkingTo = true;
		}
	}
}