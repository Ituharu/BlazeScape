/*
 * Trade with another player.
 */

package com.iClarity.player.packetHandler.Packets;

import com.iClarity.*;
import com.iClarity.player.*;

public class Trading {

	public static void processPacket(clientHandler p, int packetType, int packetSize) {
		/*
		 * If the player isn't in a duel, request a trade with the other player.
		 */
		if (p.duelStatus != 3) {
			p.WanneTradeWith = p.inStream.readSignedWordBigEndian();
			p.TurnPlayerTo(32768 + p.WanneTradeWith);
			p.WanneTrade = 2;
			return;
		}
		p.sendMessage("You cannot trade while dueling!");
	}
}