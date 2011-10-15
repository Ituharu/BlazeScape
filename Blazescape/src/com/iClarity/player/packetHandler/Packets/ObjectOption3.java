/*
 * Third object option.
 */

package com.iClarity.player.packetHandler.Packets;

import com.iClarity.*;
import com.iClarity.player.*;

public class ObjectOption3 {

	public static void processPacket(clientHandler p, int packetType, int packetSize) {
		int objectX = p.inStream.readSignedWordBigEndian();
		int objectY = p.inStream.readUnsignedWord();
		int objectID = p.inStream.readUnsignedWordBigEndianA();

switch(objectID) {


	case 6912:
		p.destinationRange = 3;
		break;

			default:
				p.destinationRange = 1;
				if(p.playerRights > 2) {
					p.sendMessage("[ObjectClick3]: "+objectID);
				}
				break;
}

		if (p.GoodDistance(p.absX, p.absY, objectX, objectY, p.destinationRange)) {
			p.objectClick3(objectID, objectX, objectY);
		} else {
			p.ActionType = 3;
 			p.destinationX = objectX;
			p.destinationY = objectY;
			p.destinationID = objectID;
			p.WalkingTo = true;
		}
	}
}