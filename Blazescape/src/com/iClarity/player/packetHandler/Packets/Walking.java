/*
 * Player Walking.
 */

package com.iClarity.player.packetHandler.Packets;

import com.iClarity.*;
import com.iClarity.misc.*;
import com.iClarity.player.*;

public class Walking {

	public static void processPacket(clientHandler p, int packetType, int packetSize) {

			if (p.Woodcutting) {
				p.resetWC();
			}

			if (p.Mining) {
				p.resetMine();
			}
		
		if (p.followPlayer != null) {
			p.followPlayer = null;
			p.updateRequired = true;
			p.appearanceUpdateRequired = true;
		}
		

		if (p.duelRule[9]) {
			p.stopMovement();
			p.sendMessage("Movement has been turned off for p duel!");
			return;
		}
		if (p.duelStatus == 1) {
			p.declineDuel();
		}
		if (p.isFletching || p.isFlaxing) {
			p.resetFletching();
		}
		if (p.getFishing().fishing[0] > 0) {
			p.getFishing().resetFishing(p);
		}
		if (p.faceNPC > 0) {
                	p.ResetAttack();
                	p.ResetAttackNPC();
		}
		p.usingAutoCast = false;
		p.setMagicPlayer(false);
		p.IsAttackingNPC = false;
		p.faceNPC = 65535;
                p.faceNPCupdate = true;
		p.closeInterface();
		p.resetAnimation();

		if (System.currentTimeMillis() - p.stunDelay < 5000) {
			p.forceWalk(0, 0);
			p.sendMessage("You are stunned!");
			return;
		}
		if (p.freezeDelay > 0) {
			p.forceWalk(0, 0);
			p.sendMessage("A magical force stops you from moving!");
			return;
		}
		if (p.IsDead == false) {
			p.newWalkCmdSteps = packetSize - 5;

			if (p.newWalkCmdSteps % 2 != 0)
				p.println_debug("Warning: walkTo("+packetType+") command malformed: "+Misc.Hex(p.inStream.buffer, 0, packetSize));
				p.newWalkCmdSteps /= 2;
			if (++p.newWalkCmdSteps > p.walkingQueueSize) {
				p.println_debug("Warning: walkTo("+packetType+") command contains too many steps ("+p.newWalkCmdSteps+").");
				p.newWalkCmdSteps = 0;
				return;
			}
			int firstStepX = p.inStream.readSignedWordBigEndianA();
			int tmpFSX = firstStepX;
			firstStepX -= p.mapRegionX * 8;

			for (int i = 1; i < p.newWalkCmdSteps; i++) {
				p.newWalkCmdX[i] = p.inStream.readSignedByte();
				p.newWalkCmdY[i] = p.inStream.readSignedByte();
				p.tmpNWCX[i] = p.newWalkCmdX[i];
				p.tmpNWCY[i] = p.newWalkCmdY[i];
			}
			p.newWalkCmdX[0] = p.newWalkCmdY[0] = p.tmpNWCX[0] = p.tmpNWCY[0] = 0;
			int firstStepY = p.inStream.readSignedWordBigEndian();
			int tmpFSY = firstStepY;
			firstStepY -= p.mapRegionY * 8;
			p.newWalkCmdIsRunning = p.inStream.readSignedByteC() == 1;

			for (int i = 0; i < p.newWalkCmdSteps; i++) {
				p.newWalkCmdX[i] += firstStepX;
				p.newWalkCmdY[i] += firstStepY;
			}
			p.poimiY = firstStepY;
			p.poimiX = firstStepX;

			if (p.NpcDialogue > 0) {
				p.NpcDialogue = 0;
				p.NpcTalkTo = 0;
				p.NpcDialogueSend = false;
				p.RemoveAllWindows();
			}
			if (p.IsBanking == true) {
				p.RemoveAllWindows();
			}
			if (p.IsShopping == true) {
				p.IsShopping = false;
				p.MyShopID = 0;
				p.UpdateShop = false;
				p.RemoveAllWindows();
			}
			if (p.tradeStatus >= 2) {
				PlayerHandler.players[p.tradeWith].tradeOtherDeclined = true;
				p.DeclineTrade();
				p.sendMessage("You decline the trade.");
				p.RemoveAllWindows();
			}
		}
	}
}