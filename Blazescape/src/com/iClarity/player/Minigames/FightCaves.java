/*
 * Class FightCaves.
 *
 * Handles the FightCaves minigame.
 *
 * @Author Primadude.
 */

package com.iClarity.player.Minigames;

import java.io.*;
import com.iClarity.*;
import com.iClarity.misc.*;
import com.iClarity.player.*;
import com.iClarity.world.items.*;

public class FightCaves {


	/*
	 * Gets the height level for tzhaar, so only you are on that specific height level.
	 */
	public static int getHeightForTzhaar() {
		int i;
		i = 4;

		for (Player p : GameEngine.playerHandler.players) {
			if (p != null) {
				clientHandler p2 = (clientHandler)p;

				if (p2.heightLevel == i) {
					i += 4;
				}
			}
		}
		return i;
	}

	public static void leaveCave(clientHandler p) {
		p.teleportTo(2438, 5168, 0, 1, -1, -1, -1, 0, 0);
		p.sendMessage("Come back to the fight caves soon!");
		p.killMyNPCs();
 		p.KilledTz = 0;
		p.NeededKills = 0;
 		p.tzWave = -1;
		p.WaveDelay = 0;
	}

	public static void enterCave(clientHandler p) {
		p.teleportTo(2413, 5117, getHeightForTzhaar(), 2, -1, -1, -1, 0, 0);
		p.sendMessage("You enter the fight cave!");
		p.sendFrame200(4883, 591);
   		p.sendFrame126(p.GetNpcName(2619), 4884);
		p.sendFrame126("You're on your own, fight for your life!", 4885);
		p.sendFrame126("Click here to continue", 4886);
		p.sendFrame75(2619, 4883);
		p.sendFrame164(4882);
		p.tzWave = 1;
		p.WaveDelay = 20;
		p.KilledTz = 0;
		p.NeededKills = 0;
	}

	/*
	 * This method is called when you have defeated Tzok-Jad.
	 */
	public static void KilledJad(clientHandler p) {
		p.updateHp(p.getLevelForXP(p.playerXP[3]), true);

		for (int i = 0; i < 21; i++) {
			p.playerLevel[i] = p.getLevelForXP(p.playerXP[i]);
			p.setSkillLevel(i, p.playerLevel[i], p.playerXP[i]);
		}
		p.sendFrame200(4883, 591);
		p.sendFrame126(p.GetNpcName(2619), 4884);
		p.sendFrame126("You defeated Jad! Please accept this gift.", 4885);
		p.sendFrame126("Click here to continue", 4886);
		p.sendFrame75(2619, 4883);
		p.sendFrame164(4882);

		if (!p.addItem(6570, 1)) {
			ItemHandler.addItem(6570, 2439, 5169, 1, p.playerId, false);
		}
		p.NeededKills = -1;
		p.tzWave = 0;
		p.teleportTo(2441 , 3091, 0, 0, -1, -1, -1, 0, 0);
	}

	/*
	 * Spawn the next wave while in the Tzhaar Fight caves.
	 */
	public static void SpawnNewWave(clientHandler p) {
		switch(p.tzWave) {
			case 1:
				GameEngine.npcHandler.newNPC(2627, 2379, 5070, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
            			p.KilledTz = 0;
				p.NeededKills = 1;
				break;
			case 2:
				GameEngine.npcHandler.newNPC(2627, 2379, 5070, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
 				GameEngine.npcHandler.newNPC(2627, 2419, 5080, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				p.KilledTz = 1;
 				p.NeededKills = 3;
				break;
			case 3:
				GameEngine.npcHandler.newNPC(2629, 2379, 5070, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
            			p.KilledTz = 3;
				p.NeededKills = 4;
				break;
			case 4:
				GameEngine.npcHandler.newNPC(2629, 2379, 5070, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2627, 2415, 5080, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
            			p.KilledTz = 4;
				p.NeededKills = 6;
				break;
			case 5:
				GameEngine.npcHandler.newNPC(2629, 2379, 5070, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2627, 2415, 5080, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2627, 2417, 5113, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
            			p.KilledTz = 6;
				p.NeededKills = 9;
				break;
			case 6:
				GameEngine.npcHandler.newNPC(2629, 2379, 5070, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2629, 2415, 5080, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
            			p.KilledTz = 9;
				p.NeededKills = 11;
				break;
			case 7:
				GameEngine.npcHandler.newNPC(2631, 2417, 5104, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
            			p.KilledTz = 11;
				p.NeededKills = 12;
				break;
			case 8:
				GameEngine.npcHandler.newNPC(2631, 2379, 5070, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2627, 2415, 5080, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
            			p.KilledTz = 12;
				p.NeededKills = 14;
				break;
			case 9:
				GameEngine.npcHandler.newNPC(2631, 2379, 5072, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2627, 2416, 5081, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2627, 2383, 5104, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
            			p.KilledTz = 14;
				p.NeededKills = 17;
				break;
			case 10:
				GameEngine.npcHandler.newNPC(2631, 2379, 5072, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2629, 2416, 5081, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
            			p.KilledTz = 17;
				p.NeededKills = 19;
				break;
			case 11:
				GameEngine.npcHandler.newNPC(2631, 2379, 5072, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2629, 2416, 5081, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2627, 2383, 5104, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
            			p.KilledTz = 19;
				p.NeededKills = 22;
				break;
			case 12:
				GameEngine.npcHandler.newNPC(2631, 2379, 5072, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2629, 2416, 5081, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2627, 2383, 5104, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2627, 2413, 5107, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
            			p.KilledTz = 22;
				p.NeededKills = 26;
				break;
			case 13:
				GameEngine.npcHandler.newNPC(2631, 2379, 5072, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2629, 2416, 5081, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2629, 2383, 5104, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
            			p.KilledTz = 26;
				p.NeededKills = 29;
				break;
			case 14:
				GameEngine.npcHandler.newNPC(2631, 2379, 5072, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2631, 2416, 5081, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
            			p.KilledTz = 29;
				p.NeededKills = 31;
				break;
			case 15:
				GameEngine.npcHandler.newNPC(2742, 2379, 5072, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
            			p.KilledTz = 31;
				p.NeededKills = 32;
				break;
			case 16:
				GameEngine.npcHandler.newNPC(2742, 2379, 5072, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2627, 2416, 5081, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
            			p.KilledTz = 32;
				p.NeededKills = 34;
				break;
			case 17:
				GameEngine.npcHandler.newNPC(2742, 2379, 5072, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2627, 2416, 5081, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2627, 2383, 5104, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
            			p.KilledTz = 34;
				p.NeededKills = 37;
				break;
			case 18:
				GameEngine.npcHandler.newNPC(2742, 2379, 5072, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2631, 2416, 5081, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
            			p.KilledTz = 37;
				p.NeededKills = 39;
				break;
			case 19:
				GameEngine.npcHandler.newNPC(2742, 2379, 5072, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2629, 2416, 5081, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2627, 2383, 5104, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
            			p.KilledTz = 39;
				p.NeededKills = 42;
				break;
			case 20:
				GameEngine.npcHandler.newNPC(2742, 2379, 5072, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2629, 2416, 5081, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2627, 2383, 5104, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2627, 2413, 5107, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
            			p.KilledTz = 42;
				p.NeededKills = 46;
				break;
			case 21:
				GameEngine.npcHandler.newNPC(2742, 2379, 5072, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2629, 2416, 5081, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2629, 2383, 5104, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
            			p.KilledTz = 46;
				p.NeededKills = 49;
				break;
			case 22:
				GameEngine.npcHandler.newNPC(2742, 2379, 5072, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2631, 2416, 5081, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
            			p.KilledTz = 49;
				p.NeededKills = 51;
				break;
			case 23:
				GameEngine.npcHandler.newNPC(2742, 2379, 5072, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2631, 2416, 5081, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2627, 2383, 5104, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
            			p.KilledTz = 51;
				p.NeededKills = 54;
				break;
			case 24:
				GameEngine.npcHandler.newNPC(2742, 2379, 5072, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2631, 2416, 5081, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2627, 2383, 5104, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2627, 2413, 5107, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
            			p.KilledTz = 54;
				p.NeededKills = 58;
				break;
			case 25:
				GameEngine.npcHandler.newNPC(2742, 2379, 5072, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2631, 2416, 5081, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2629, 2383, 5104, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
            			p.KilledTz = 58;
				p.NeededKills = 61;
				break;
			case 26:
				GameEngine.npcHandler.newNPC(2742, 2379, 5072, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2631, 2416, 5081, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2629, 2383, 5104, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2627, 2413, 5107, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
            			p.KilledTz = 61;
				p.NeededKills = 65;
				break;
			case 27:
				GameEngine.npcHandler.newNPC(2742, 2379, 5072, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2631, 2416, 5081, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2629, 2383, 5104, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2629, 2413, 5107, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
            			p.KilledTz = 65;
				p.NeededKills = 69;
				break;
			case 28:
				GameEngine.npcHandler.newNPC(2742, 2379, 5072, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2631, 2416, 5081, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2631, 2383, 5104, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
            			p.KilledTz = 69;
				p.NeededKills = 72;
				break;
			case 29:
				GameEngine.npcHandler.newNPC(2742, 2379, 5072, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2742, 2416, 5081, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
            			p.KilledTz = 72;
				p.NeededKills = 74;
				break;
			case 30:
				GameEngine.npcHandler.newNPC(2744, 2379, 5072, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
            			p.KilledTz = 74;
				p.NeededKills = 75;
				break;
			case 31:
				GameEngine.npcHandler.newNPC(2744, 2379, 5072, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2627, 2416, 5081, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
            			p.KilledTz = 75;
				p.NeededKills = 77;
				break;
			case 32:
				GameEngine.npcHandler.newNPC(2744, 2379, 5072, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2627, 2416, 5081, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2627, 2383, 5104, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
            			p.KilledTz = 77;
				p.NeededKills = 80;
				break;
			case 33:
				GameEngine.npcHandler.newNPC(2744, 2379, 5072, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2629, 2416, 5081, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
            			p.KilledTz = 80;
				p.NeededKills = 82;
				break;
			case 34:
				GameEngine.npcHandler.newNPC(2744, 2379, 5072, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2629, 2416, 5081, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2627, 2383, 5104, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
            			p.KilledTz = 82;
				p.NeededKills = 85;
				break;
			case 35:
				GameEngine.npcHandler.newNPC(2744, 2379, 5072, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2629, 2416, 5081, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2627, 2383, 5104, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2627, 2413, 5107, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
            			p.KilledTz = 85;
				p.NeededKills = 89;
				break;
			case 36:
				GameEngine.npcHandler.newNPC(2744, 2379, 5072, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2629, 2416, 5081, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2629, 2383, 5104, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
            			p.KilledTz = 89;
				p.NeededKills = 92;
				break;
			case 37:
				GameEngine.npcHandler.newNPC(2744, 2379, 5072, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2742, 2416, 5081, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
            			p.KilledTz = 92;
				p.NeededKills = 94;
				break;
			case 38:
				GameEngine.npcHandler.newNPC(2744, 2379, 5072, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2631, 2416, 5081, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2627, 2383, 5104, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
            			p.KilledTz = 94;
				p.NeededKills = 97;
				break;
			case 39:
				GameEngine.npcHandler.newNPC(2744, 2379, 5072, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2631, 2416, 5081, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2627, 2383, 5104, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2627, 2413, 5107, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
            			p.KilledTz = 97;
				p.NeededKills = 101;
				break;
			case 40:
				GameEngine.npcHandler.newNPC(2744, 2379, 5072, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2631, 2416, 5081, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2629, 2383, 5104, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
            			p.KilledTz = 101;
				p.NeededKills = 104;
				break;
			case 41:
				GameEngine.npcHandler.newNPC(2744, 2379, 5072, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2631, 2416, 5081, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2629, 2383, 5104, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2627, 2413, 5107, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
            			p.KilledTz = 104;
				p.NeededKills = 108;
				break;
			case 42:
				GameEngine.npcHandler.newNPC(2744, 2379, 5072, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2631, 2416, 5081, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2629, 2383, 5104, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2629, 2413, 5107, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
            			p.KilledTz = 108;
				p.NeededKills = 112;
				break;
			case 43:
				GameEngine.npcHandler.newNPC(2744, 2379, 5072, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2631, 2416, 5081, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2631, 2383, 5104, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
            			p.KilledTz = 112;
				p.NeededKills = 115;
				break;
			case 44:
				GameEngine.npcHandler.newNPC(2744, 2379, 5072, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2742, 2416, 5081, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
            			p.KilledTz = 115;
				p.NeededKills = 117;
				break;
			case 45:
				GameEngine.npcHandler.newNPC(2744, 2379, 5072, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2742, 2416, 5081, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2627, 2383, 5104, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
            			p.KilledTz = 117;
				p.NeededKills = 120;
				break;
			case 46:
				GameEngine.npcHandler.newNPC(2744, 2379, 5072, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2742, 2416, 5081, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2627, 2383, 5104, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2627, 2413, 5107, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
            			p.KilledTz = 120;
				p.NeededKills = 124;
				break;
			case 47:
				GameEngine.npcHandler.newNPC(2744, 2379, 5072, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2742, 2416, 5081, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2629, 2383, 5104, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
            			p.KilledTz = 124;
				p.NeededKills = 127;
				break;
			case 48:
				GameEngine.npcHandler.newNPC(2744, 2379, 5072, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2742, 2416, 5081, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2629, 2383, 5104, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2627, 2413, 5107, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
            			p.KilledTz = 127;
				p.NeededKills = 131;
				break;
			case 49:
				GameEngine.npcHandler.newNPC(2744, 2379, 5072, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2742, 2416, 5081, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2629, 2383, 5104, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2629, 2413, 5107, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
            			p.KilledTz = 131;
				p.NeededKills = 135;
				break;
			case 50:
				GameEngine.npcHandler.newNPC(2744, 2379, 5072, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2742, 2416, 5081, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2631, 2383, 5104, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
            			p.KilledTz = 135;
				p.NeededKills = 138;
				break;
			case 51:
				GameEngine.npcHandler.newNPC(2744, 2379, 5072, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2742, 2416, 5081, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2631, 2383, 5104, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2627, 2413, 5107, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
            			p.KilledTz = 138;
				p.NeededKills = 142;
				break;
			case 52:
				GameEngine.npcHandler.newNPC(2744, 2379, 5072, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2742, 2416, 5081, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2631, 2383, 5104, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2629, 2413, 5107, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
            			p.KilledTz = 142;
				p.NeededKills = 146;
				break;
			case 53:
				GameEngine.npcHandler.newNPC(2744, 2379, 5072, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2742, 2416, 5081, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2631, 2383, 5104, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2631, 2413, 5107, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
            			p.KilledTz = 146;
				p.NeededKills = 150;
				break;
			case 54:
				GameEngine.npcHandler.newNPC(2744, 2379, 5072, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2742, 2416, 5081, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2742, 2383, 5104, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
            			p.KilledTz = 150;
				p.NeededKills = 153;
				break;
			case 55:
				GameEngine.npcHandler.newNPC(2744, 2379, 5072, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
				GameEngine.npcHandler.newNPC(2743, 2416, 5081, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
            			p.KilledTz = 153;
				p.NeededKills = 155;
				break;
			case 56:
				p.sendFrame200(4883, 591);
				p.sendFrame126(p.GetNpcName(2619), 4884);
				p.sendFrame126("Look out, here comes TzTok-Jad!", 4885);
				p.sendFrame126("Click here to continue", 4886);
				p.sendFrame75(2619, 4883);
				p.sendFrame164(4882);
				GameEngine.npcHandler.newNPC(2745, 2416, 5081, p.heightLevel, 0, 0, 0, 0, 0, false, p.playerId);
            			p.KilledTz = 155;
				p.NeededKills = 156;
				break;
		}
	}
}