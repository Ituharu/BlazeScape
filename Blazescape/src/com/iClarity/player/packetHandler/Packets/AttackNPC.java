/*
 * Npc Attacking packet.
 */

package com.iClarity.player.packetHandler.Packets;

import com.iClarity.*;
import com.iClarity.npcs.*;
import com.iClarity.player.*;
import com.iClarity.player.packetHandler.*;

public class AttackNPC {

	public static void processPacket(clientHandler p, int packetType, int packetSize) {
		p.attacknpc = p.inStream.readUnsignedWordA();
		NPC p2 = GameEngine.npcHandler.npcs[p.attacknpc];

		if (p.usingRange() || p.usingKnives()) {
			p.forceWalk(0, 0);
		}
		if (p.attacknpc >= 0 && p.attacknpc < GameEngine.npcHandler.maxNPCs && p2 != null) {
			p.IsAttackingNPC = true;

			if (p2.absX != p.absX && p2.absY != p.absY) {
				p.faceNPC(p.attacknpc);
			}
		}
	}
}