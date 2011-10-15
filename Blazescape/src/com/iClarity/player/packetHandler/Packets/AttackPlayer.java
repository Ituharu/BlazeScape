/*
 * Player Attacking packet.
 */

package com.iClarity.player.packetHandler.Packets;

import com.iClarity.*;
import com.iClarity.player.*;

public class AttackPlayer {

	public static void processPacket(clientHandler p, int packetType, int packetSize) {
		p.AttackingOn = p.inStream.readSignedWordBigEndian();
		p.enemyIndex = p.inStream.readSignedWordBigEndian();
		clientHandler Att = (clientHandler) GameEngine.playerHandler.players[p.AttackingOn];

		if (p.usingRange() || p.castAuto || p.usingKnives()) {
			p.forceWalk(0, 0);
		}
		if(!p.Wild() && p.playerEquipment[p.playerWeapon] == 4566) {
			p.setAnimation(p.GetWepAnim());
			if (Att != null) {
                        	p.faceNPC = 32768 + p.AttackingOn;
                        	p.faceNPCupdate = true;
                    	}
		}
		if (p.castAuto) {
			p.usingAutoCast = true;
       			p.faceNPC = 32768 + p.AttackingOn;
       			p.faceNPCupdate = true;
		}
		if (p.Wild() && Att.Wild() || p.duelArea() && Att.duelArea() && Att != null && !p.castAuto) {
			p.IsAttacking = true;

			if(!Att.Wild()) {
				p.IsAttacking = false;
			}			

			if (p.GoodDistance(p.absX, p.absY, p.EnemyX, p.EnemyY, 1)) {
				p.setAnimation(p.GetWepAnim());
			}
			if (Att != null) {
                        	p.faceNPC = 32768 + p.AttackingOn;
                        	p.faceNPCupdate = true;
                    	}
                }
	}
}