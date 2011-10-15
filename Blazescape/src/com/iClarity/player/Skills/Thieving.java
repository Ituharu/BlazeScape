/*
 * Class Thieving
 *
 * Version 2.0
 *
 * Sunday 25th April, 2009
 *
 * Created by Primadude
 */

package com.iClarity.player.Skills;

import java.io.*;
import com.iClarity.npcs.*;
import com.iClarity.misc.*;
import com.iClarity.player.*;
import com.iClarity.GameEngine;

public class Thieving {

	/**
	 * Constructor
	 */
	public Thieving(clientHandler p) {
		this.p = p;
	}

	/*
	 * Begin pickpocketing.
	 */
	public void ThiefStart(clientHandler p) {
		p.thiefNPC = false;

		switch (p.thievingType) {

			case 1:
			case 2:
			case 3:
				startPP(1, "Man");
				break;

			case 4:
			case 5:
			case 6:
				startPP(1, "Woman");
				break;

			case 7:
				startPP(10, "Farmer");
				break;

			case 15:
			case 18:
				startPP(25, "Warrior");
				break;

			case 9:
				startPP(40, "Guard");
				break;

		}
	}

	/*
	 * Finish pickpocketing.
	 */
	public void ThiefFinish(clientHandler p) {
		switch (p.thievingType) {

			case 1:
			case 2:
			case 3:
				finishPP(1, 30, 250, 1, "Man");
				break;

			case 4:
			case 5:
			case 6:
				finishPP(1, 30, 250, 1, "Woman");
				break;

			case 7:
				finishPP(7, 80, 500, 3, "Farmer");
				break;

			case 15:
			case 18:
				finishPP(25, 320, 1200, 4, "Warrior");
				break;

			case 9:
				finishPP(40, 900, 2000, 5, "Guard");
				break;


		}
	}

	/**
	 * Start PickPocketing
	 */
	public void startPP(int lvlReq, String npcName) {
		if (System.currentTimeMillis() - p.stunDelay >= 5000) {
			if (System.currentTimeMillis() - p.thiefTimer >= 2000) {
				if (p.playerLevel[17] >= lvlReq) {
					p.thiefTimer = System.currentTimeMillis();
					p.thiefDelay = 3;
					p.startAnimation(881);
					p.sendMessage("You attempt to pickpocket the "+ npcName +"...");
				} else {
					p.sendMessage("You need to have level "+ lvlReq +" thieving to pickpocket this Npc.");
				}
			}
		} else {
			p.sendMessage("You are stunned!");
		}
	}

	/**
	 * Finish PickPocketing
	 */
	public void finishPP(int lvlReq, int exp, int cashAmt, int npcHit, String name) {
	    	NPC n = GameEngine.npcHandler.npcs[p.ThiefNPC];
		int chance = 3 + (p.playerLevel[17] - lvlReq);

		if (Misc.random(chance) >= 3) {
			p.addItem(995, cashAmt);
			p.sendMessage("You pickpocket the "+ name +".");
			p.addSkillXP(exp, 17);
		} else {
			p.sendMessage("You fail to pickpocket the "+ name +".");
			p.stunDelay = System.currentTimeMillis();
			p.appendHit(Misc.random(npcHit));
			p.gfx100(245);
			p.startAnimation(p.GetBlockAnim());
			//n.requestAnim(GameEngine.npcHandler.npcs[n.npcType].GetMeleeEmote());
			n.requestText("What do you think you're doing?!");
			n.TurnNPCTo(p.absX, p.absY);
                        n.updateRequired = true;
		}
	}

	clientHandler p;
	public long thiefTimer;
	
}