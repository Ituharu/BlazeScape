/*
 * Magic casted on ground items.
 */

package com.iClarity.player.packetHandler.Packets;

import com.iClarity.*;
import com.iClarity.player.*;

public class MagicOnGround {

	public static void processPacket(clientHandler p, int packetType, int packetSize) {
		int magicOnItemY = p.inStream.readSignedWordBigEndian();
		int magicOnItemID = p.inStream.readUnsignedWord();
		int magicOnItemX= p.inStream.readSignedWordBigEndian();
		int magicOnItemSpellID = p.inStream.readUnsignedWordA();
		int offsetY3 = (magicOnItemX - p.absX);
		int offsetX3 = (magicOnItemY - p.absY);
	}
}