/*
 * Clicking items inventory.
 */

package com.iClarity.player.packetHandler.Packets;

import java.io.*;
import com.iClarity.*;
import com.iClarity.misc.*;
import com.iClarity.player.*;
import com.iClarity.player.packetHandler.*;

public class ItemClicking {

	public static void processPacket(clientHandler p, int packetType, int packetSize) {
		int interfaace = p.inStream.readSignedWordBigEndianA();
		int ItemSlot = p.inStream.readUnsignedWordA();
		int ItemID = p.inStream.readUnsignedWordBigEndian();

                if (p.playerItems[ItemSlot] == ItemID + 1) {
                       	p.CheckForSkillUse3(ItemID, ItemSlot);
                }
	}
}