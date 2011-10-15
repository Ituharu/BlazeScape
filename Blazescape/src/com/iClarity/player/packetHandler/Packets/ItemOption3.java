/*
 * Third click item option.
 */

package com.iClarity.player.packetHandler.Packets;

import com.iClarity.player.*;
import com.iClarity.misc.*;
import com.iClarity.player.packetHandler.*;

public class ItemOption3 {

	public static void processPacket(clientHandler p, int packetType, int packetSize) {
		int itemID = p.inStream.readSignedWordA();

		if (p.playerRights > 2) {
			System.out.println("Item id: "+itemID);
		}
		if (p.actionTimer <= 0) {
			switch (itemID) {

			case 4566: //rubber chicken
				p.startAnimation(1835);
            		break;
			case 6866: //green marionette
				p.startAnimation(3006);
				p.gfx0(518);
            		break;
			case 6867: //red marionette
				p.startAnimation(3006);
				p.gfx0(510);
            		break;

			case 6865: //blue marionette
				p.startAnimation(3006);
				p.gfx0(514);
            		break;
				case 9000:
					teleTab(p, 3210 + Misc.random(5), 3422 + Misc.random(3), 9000);
					break;

				case 9001:
					teleTab(p, 3222 + Misc.random(3), 3218 + Misc.random(1), 9001);
					break;

				case 9002:
					teleTab(p, 2963 + Misc.random(4), 3379 + Misc.random(1), 9001);
					break;

				case 9003:
					teleTab(p, 2660 + Misc.random(4), 3303 + Misc.random(4), 9001);
					break;

				default:
					p.sendMessage("Item option 3: "+ itemID);
					break;
			}
		}
	}

	public static void teleTab(clientHandler p, int teleX, int teleY, int item) {
		if (p.actionTimer <= 0) {
			if (p.above20Wild() && p.Wild()) {
				p.sendMessage("You cannot teleport above level 20 wilderness!");
				return;
			}
			if (p.duelStatus == 3) {
				p.sendMessage("You cannot teleport while dueling!");
				return;
			}
			p.actionTimer = 6;
			p.teleportTo(teleX, teleY, 0, 4, 714, 715, 308, 100, 2);
			p.deleteItem(item, p.getItemSlot(item), 1);
		}
	}
}