/*
 * Using an item on an Npc.
 */

package com.iClarity.player.packetHandler.Packets;

import com.iClarity.*;
import com.iClarity.player.*;

public class ItemOnNPC {

	public static void processPacket(clientHandler p, int packetType, int packetSize) {
		int readone = p.inStream.readUnsignedWordA();
		int readtwo = p.inStream.readUnsignedWordA();
		int readthree = p.inStream.readSignedWordBigEndian();
		int readfour = p.inStream.readUnsignedWordA();
	}
}