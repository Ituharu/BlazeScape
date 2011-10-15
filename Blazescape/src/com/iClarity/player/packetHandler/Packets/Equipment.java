/*
 * Wearing/wielding equipment.
 */

package com.iClarity.player.packetHandler.Packets;

import com.iClarity.*;
import com.iClarity.player.*;

public class Equipment {

	public static void processPacket(clientHandler p, int packetType, int packetSize) {
		int wearID = p.inStream.readUnsignedWord();
		int wearSlot = p.inStream.readUnsignedWordA();

		if(wearID == 6866 || wearID == 6865 || wearID == 6867) {
			p.startAnimation(3005);
			if(wearID == 6866) {
				p.gfx0(517);
			}
			if(wearID == 6867) {
				p.gfx0(509);
			}
			if(wearID == 6865) {
				p.gfx0(513);
			}
		} else {
			p.wear(wearID, wearSlot);
			p.flushOutStream();
		}
	}
}