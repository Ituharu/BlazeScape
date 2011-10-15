/*
 * Dueling option.
 */

package com.iClarity.player.packetHandler.Packets;

import com.iClarity.*;
import com.iClarity.player.*;

public class DuelWithPlayer {

	public static void processPacket(clientHandler p, int packetType, int packetSize) {
		int j3 = p.inStream.readUnsignedWord();
		p.duelW = j3;
		clientHandler d2 = (clientHandler) GameEngine.playerHandler.players[j3];
		p.TurnPlayerTo(32768 + j3);

		if (p.duelStatus == 0) {
			if (p.duelArea()) {
				if (d2.duelStatus == 0 && d2.tradeStatus == -1 && p.tradeStatus == -1) {
					p.duelStatus = 1;
					d2.duelStatus = 1;
					p.duelWith = j3;
					d2.duelWith = p.playerId;
					p.resetItems(3322);
					d2.resetItems(3322);
					p.refreshDuelScreen();
					p.RefreshDuelRules();
					d2.refreshDuelScreen();
					d2.RefreshDuelRules();
					p.sendFrame248(6575, 3321);
					d2.sendFrame248(6575, 3321);
				}
			} else {
				p.sendMessage("You need to be at the duel arena to challenge someone.");
			}
			return;
		}
		if (p.duelStatus == -1) {
                	if (d2.duelStatus == -1 && d2.tradeStatus == -1 && p.tradeStatus == -1) {
                    		p.sendMessage("Sending duel request...");
                    		d2.sendMessage((new StringBuilder()).append(p.playerName).append(":duelreq:").toString());
                    		p.duelStatus = 0;
                    		d2.duelStatus = 0;
                	}
                	return;
		}
	}
}