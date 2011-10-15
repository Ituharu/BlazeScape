/*
 * Moving items in the player's inventory.
 */

package com.iClarity.player.packetHandler.Packets;

import com.iClarity.*;
import com.iClarity.player.*;
import com.iClarity.player.magic.*;

public class MoveInvItems {

	public static void processPacket(clientHandler p, int packetType, int packetSize) {
		/*
		 * A junk variable.
		 */
		int junk = p.inStream.readUnsignedWordA();

		/*
		 * The ID of the item you are moving.
		 */
		int itemFrom = p.inStream.readUnsignedWordA();

		/*
		 * The ID of the item that is already in the slot, that the item is moved to.
		 */
		int itemTo = (p.inStream.readUnsignedWordA() - 128);

		/*
		 * Calling the method to move the items.
		 */
		p.moveItems(itemFrom, itemTo, junk);
	}
}