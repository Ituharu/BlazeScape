/*
 * Second click item option.
 */

package com.iClarity.player.packetHandler.Packets;

import com.iClarity.player.*;
import com.iClarity.player.packetHandler.*;

public class ItemOption2 {

	public static void processPacket(clientHandler p, int packetType, int packetSize) {
		int junk = p.inStream.readSignedWordA();
		int junk2 = p.inStream.readSignedWordBigEndian();
		int clickID = p.inStream.readSignedWordA();

		switch (clickID) {

			case 1712:
				p.delID = 1712;
				p.newID = 1710;
				p.useGlory();
				break;
			case 1710:
				p.delID = 1710;
				p.newID = 1708;
				p.useGlory();
				break;
			case 1708:
				p.delID = 1708;
				p.newID = 1706;
				p.useGlory();
				break;
			case 1706:
				p.delID = 1706;
				p.newID = 1704;
				p.useGlory();
				break;
			case 6866: //green marionette
				p.startAnimation(3004);
				p.gfx0(516);
            		break;
			case 6867: //red marionette
				p.startAnimation(3004);
				p.gfx0(508);
            		break;

			case 6865: //blue marionette
				p.startAnimation(3004);
				p.gfx0(512);
            		break;
		}
	}
}