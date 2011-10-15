/*
 * Player talking.
 */

package com.iClarity.player.packetHandler.Packets;

import com.iClarity.*;
import com.iClarity.player.*;

public class PlayerChat {

	public static void processPacket(clientHandler p, int packetType, int packetSize) {
		p.chatTextEffects = p.inStream.readUnsignedByteS();
		p.chatTextColor = p.inStream.readUnsignedByteS();
		p.chatTextSize = (byte)(packetSize - 2);

		if (p.muted != 0) {
			p.sendMessage("You can't talk because you are muted!");
		} else {
			p.inStream.readBytes_reverseA(p.chatText, p.chatTextSize, 0);
			p.chatTextUpdateRequired = true;
		}
	}
}