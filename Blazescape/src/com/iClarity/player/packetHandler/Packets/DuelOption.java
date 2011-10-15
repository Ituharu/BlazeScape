/*
 * Right click 'Challenge' option.
 */

package com.iClarity.player.packetHandler.Packets;

import com.iClarity.*;
import com.iClarity.player.*;
import com.iClarity.player.packetHandler.*;

public class DuelOption {

	public static void processPacket(clientHandler p, int packetType, int packetSize) {
		int i = p.inStream.readUnsignedWordBigEndian();
		clientHandler p2 = (clientHandler) GameEngine.playerHandler.players[i];

		if (p.duelStatus == 0) {
			if (p.duelArea()) {
				if (p2.duelStatus == 0) {
					p.duelStatus = 1;
					p.duelWith = i;
					p.resetItems(3322);
					p.refreshDuelScreen();
					p.RefreshDuelRules();
					p.sendFrame248(6575, 3321);
					p2.duelStatus = 1;
					p2.duelWith = p.playerId;
					p2.resetItems(3322);
					p2.refreshDuelScreen();
					p2.RefreshDuelRules();
					p2.sendFrame248(6575, 3321);
				}
			} else {
				p.sendMessage("You need to be at the duel arena to challenge someone.");
			}
			return;
		}
		if (p.duelStatus == -1) {
			if (p2.duelStatus == -1) {
				p.duelStatus = 0;
				p.sendMessage("Sending duel request...");
				p2.sendMessage((new StringBuilder()).append(p.playerName).append(":duelreq:").toString());
				p2.duelStatus = 0;
			}
		}
	}
}