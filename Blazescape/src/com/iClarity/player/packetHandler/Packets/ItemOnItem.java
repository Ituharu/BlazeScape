/*
 * Using an item on another item.
 */

package com.iClarity.player.packetHandler.Packets;

import com.iClarity.*;
import com.iClarity.player.*;
import com.iClarity.player.Skills.Crafting.*;
import com.iClarity.player.Skills.*;

public class ItemOnItem {

	public static void processPacket(clientHandler p, int packetType, int packetSize) {
		int usedWithSlot = p.inStream.readUnsignedWord();
		int itemUsedSlot = p.inStream.readUnsignedWordA();
		int interface1284 = p.inStream.readUnsignedWord();
		int interfacek = p.inStream.readUnsignedWord();
		int useWith = p.playerItems[usedWithSlot] - 1;
		int itemUsed = p.playerItems[itemUsedSlot] - 1;


		p.getHerblore().itemOnItem(p, itemUsed, useWith);
		p.getFletching().sendFletch(p, itemUsed, useWith);
		p.getFletching().string(p, itemUsed, useWith);
		p.getFletching().startArrow(p, itemUsed, useWith);


		if (itemUsed == 590 && (useWith == 1511 || useWith == 1521 || useWith == 1519 || useWith == 1517 || useWith == 1515 || useWith == 1513)) {
				Firemaking.addFire(p, useWith);
		} else if (useWith == 590
		 && (itemUsed == 1511 || itemUsed == 1521 || itemUsed == 1519 || itemUsed == 1517 || itemUsed == 1515 || itemUsed == 1513)) {
				Firemaking.addFire(p, itemUsed);
		}

		if (itemUsed == 1733 || useWith == 1733) {
			LeatherCrafting.craftMenu(p, useWith, itemUsed);
		}
		if ((itemUsed == 985 && useWith == 987) || (useWith == 985 && itemUsed == 987)) {//crystal key
			p.deleteItem(985, p.getItemSlot(985), 1);
			p.deleteItem(987, p.getItemSlot(987), 1);
			p.addItem(989, 1);
		}

		if ((itemUsed == 964 && useWith == 553) || (itemUsed == 553 && useWith == 964)) {//skull piece
			p.deleteItem(964, p.getItemSlot(964), 1);
			p.deleteItem(553, p.getItemSlot(553), 1);
			p.addItem(6163, 1);
		}

	}
}