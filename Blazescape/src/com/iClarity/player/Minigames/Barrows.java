/*
 * Class Barrows.
 *
 * Handles the barrows minigame.
 *
 * @Author Primadude.
 */

package com.iClarity.player.Minigames;

import java.io.*;
import com.iClarity.*;
import com.iClarity.misc.*;
import com.iClarity.player.*;

public class Barrows {

	/*
	 *This calls the different sets of barrows
	 */
	public static int ahrims[] = {
		4708, 4710, 4712, 4714
	};
	public static int ahrims() {
		return ahrims[(int)(Math.random() * ahrims.length)];
	}

	public static int dharoks[] = {
		4716, 4718, 4720, 4722
	};
	public static int dharoks() {
		return dharoks[(int)(Math.random() * dharoks.length)];
	}

	public static int guthans[] = {
		4724, 4726, 4728, 4730
	};
	public static int guthans() {
		return guthans[(int)(Math.random() * guthans.length)];
	}

	public static int karils[] = {
		4732, 4734, 4736, 4738
	};
	public static int karils() {
		return karils[(int)(Math.random() * karils.length)];
	}

	public static int torags[] = {
		4745, 4747, 4749, 4751
	};
	public static int torags() {
		return torags[(int)(Math.random() * torags.length)];
	}

	public static int veracs[] = {
		4753, 4755, 4757, 4759
	};
	public static int veracs() {
		return veracs[(int)(Math.random() * veracs.length)];
	}

	/*
	 * Random noted fish from the barrows chest.
	 */
	public static int notedFish[] = {
		392, 386, 380, 374, 362
	};

	public static int notedFish() {
		return notedFish[(int)(Math.random() * notedFish.length)];
	}

	/*
	 * Random trimmed items from the barrows chest.
	 */
	public static int trimmed[] = {
		2583, 2585, 2587, 2589, 2591, 2593, 2595, 2597,
		2599, 2601, 2603, 2605, 2607, 2609, 2611, 2613,
		2615, 2617, 2619, 2621, 2623, 2625, 2627, 2629
	};

	public static int trimmed() {
		return trimmed[(int)(Math.random() * trimmed.length)];
	}

	/*
	 * Mind, chaos, death and blood runes.
	 */ 
	public static int runes[] = {
		558, 560, 562, 565
	};

	/*
	 * A random number from the runes array.
	 */ 
	public static int runes() {
		return runes[(int)(Math.random() * runes.length)];
	}

	/*
	 * Random items from the barrows chest.
	 */ 
	public static int randomItems[] = {
		1149, 1374, 1347, 1127, 7392, 7388, 7396, 7453,
		7454, 7455, 7456, 7457, 7458, 7459, 7460, 7461, 7462, 2579,
		544, 542, 1009, 1081, 1079, 1089,
		1097, 1105
	};

	/*
	 * A random number from the randomItems array.
	 */ 
	public static int randomItems() {
		return randomItems[(int)(Math.random() * randomItems.length)];
	}

	/*
	 * Returns the ID of the barrow brother's number.
	 * @param p - The player that the 'hiddenBarrowBro' variable is returned for.
	 */ 
	public static int getBarrowNpc(clientHandler p) {
		switch(p.hiddenBarrowBro) {

			case 0:
				return 2026;
			case 1:
				return 2025;
			case 2:
				return 2027;
			case 3:
				return 2028;
			case 4:
				return 2029;
			case 5:
				return 2030;
		}
		return -1;
	}

	/*
	 * Spawns the selected barrow brother of the parameter 'brotherID'.
	 * @param p - The player that the option is given to.
	 * @param ID - The barrow brother number.
	 */ 
	public static boolean hiddenBrother(clientHandler p, int ID) {
		if (p.hiddenBarrowBro == ID) {
			p.showDialogue("You've found a hidden tunnel, do you want to enter?");
			p.NpcDialogue = 5000;
			p.NpcDialogueSend = false;
			p.tombTalk = 1;
			p.savemoreinfo();
			if (p.tombTalk == 1) {
			p.sendFrame164(13758);
			p.sendFrame126("Enter Tunnel?", 13759);
			p.sendFrame126("Yes", 13760);
			p.sendFrame126("No", 13761);
			}
			return true;
		}
		return false;
	}

	/*
	 * Digs with a spade to get into the barrows' crypts.
	 * @param p - The player that this method is applied to.
	 */ 
	public static boolean digMound(clientHandler p) {
		if (p.dharoksMound()) {
			p.teleportTo(3556, 9718, -1, 2, 2843, -1, -1, 0, 0);
			p.sendMessage("You've broken into a crypt!");
			return true;
		}
		if (p.guthansMound()) {
			p.teleportTo(3534, 9704, -1, 2, 2843, -1, -1, 0, 0);
			p.sendMessage("You've broken into a crypt!");
			return true;
		}
		if (p.ahrimsMound()) {
			p.teleportTo(3557, 9703, -1, 2, 2843, -1, -1, 0, 0);
			p.sendMessage("You've broken into a crypt!");
			return true;
		}
		if (p.veracsMound()) {
			p.teleportTo(3578, 9706, -1, 2, 2843, -1, -1, 0, 0);
			p.sendMessage("You've broken into a crypt!");
			return true;
		}
 		if (p.toragsMound()) {
			p.teleportTo(3568, 9683, -1, 2, 2843, -1, -1, 0, 0);
			p.sendMessage("You've broken into a crypt!");
			return true;
		}
		if (p.karilsMound()) {
			p.teleportTo(3546, 9684, -1, 2, 2843, -1, -1, 0, 0);
			p.sendMessage("You've broken into a crypt!");
			return true;
		}
		return false;
	}

	/*
	 * Shakes the screen when chest is open (Earthquake).
	 * @param p - The player that the frame is created for.
	 * @param i - The integer that the frame is set to.
	 */ 
	public static void shakeScreen(clientHandler p, int i, int j, int k, int l) {
		p.outStream.createFrame(35); // Creates frame 35.
		p.outStream.writeByte(i);
		p.outStream.writeByte(j);
		p.outStream.writeByte(k);
		p.outStream.writeByte(l);
	}

	/*
	 * Blacks/locks the player's minimap.
	 * @param p - The player that the frame is created for.
	 * @param i - The number set to lock or black the screen. 1 to lock; 2 to black; 0 to reset.
	 */ 
    	public static void mapChange(clientHandler p, int i) {
		p.outStream.createFrame(99);
		p.outStream.writeByte(i);
    	}

	/*
	 * Spawns the selected barrow brother of the parameter 'brotherID'.
	 * @param p - The player that the npc is spawned for.
	 * @param brotherID - The Npc ID of the barrow brother.
	 * @param xCoord - The X coordinate that the brother will be spawned on.
	 * @param yCoord - The Y coordinate that the brother will be spawned on.
	 */ 
	public static void spawnBrother(clientHandler p, int brotherID, int xCoord, int yCoord) {
		GameEngine.npcHandler.newSummonedNPC(brotherID, xCoord, yCoord, -1, 0, 0, 0, 0, 0, GameEngine.npcHandler.GetNpcListHP(brotherID), false, p.playerId);
	}

	/*
	 * Resets the player's barrows variables, and sets the next hidden barrow brother to a new random one.
	 * @param p - The player that the variables are reset for.
	 */ 
	public static void resetBarrows(clientHandler p) {
		p.killCount = 0;
		p.dharokSummoned = 0;
		p.ahrimSummoned = 0;
		p.guthanSummoned = 0;
		p.karilSummoned = 0;
		p.toragSummoned = 0;
		p.veracSummoned = 0;
		p.killCount = 0;
		p.hiddenBarrowBro = Misc.random(5);
		p.savemoreinfo();
	}

	/*
	 * Gives the barrows rewards if the player has a killcount > 5. There is 1/5 chance of earning a barrows item.
	 * @param p - The player that the method is called for.
	 */ 
	public static void openChest(clientHandler p) {
		int chance = Misc.random(19); // A random chance containing 20 possible outcomes.
		for (int i = 0; i < 5; i++) {
			if (chance == i) {
				p.addItem(runes(), Misc.random(500));
				p.addItem(runes(), Misc.random(500)); 
				p.addItem(4740, Misc.random(200));
				p.addItem(4278, Misc.random(5000));
			}
		}
		if (chance == 6) {
			p.addItem(runes(), Misc.random(250));
			p.addItem(runes(), Misc.random(250));
			p.addItem(randomItems(), 1);
		} else if (chance == 7) {
			p.addItem(runes(), Misc.random(300));
			p.addItem(runes(), Misc.random(300));
			p.addItem(randomItems(), 1);
			p.addItem(randomItems(), 1);
		} else if (chance == 8) {
			p.addItem(runes(), Misc.random(350));
			p.addItem(runes(), Misc.random(350));
			p.addItem(randomItems(), 1);
			p.addItem(notedFish(), Misc.random(20));
			p.addItem(trimmed(), 1);
		} else if (chance == 9) {
			p.addItem(runes(), Misc.random(400));
			p.addItem(runes(), Misc.random(400));
			p.addItem(trimmed(), 1);
			p.addItem(randomItems(), 1);
		} else if (chance == 10) {
			p.addItem(runes(), Misc.random(450));
			p.addItem(runes(), Misc.random(450));
			p.addItem(randomItems(), 1);
			p.addItem(notedFish(), Misc.random(20));
		} else if (chance == 11) {
			p.addItem(4740, Misc.random(100));
			p.addItem(randomItems(), 1);
			p.addItem(randomItems(), 1);
		} else if (chance == 12) {
			p.addItem(4740, Misc.random(150));
			p.addItem(4278, Misc.random(4500));
			p.addItem(trimmed(), 1);
		} else if (chance == 13) {
			p.addItem(4740, Misc.random(175));
			p.addItem(4278, Misc.random(4750));
			p.addItem(randomItems(), 1);
		} else if (chance == 14) {
			p.addItem(ahrims(), 1);
			p.addItem(4728, Misc.random(5000));
			p.addItem(runes(), Misc.random(750));
			p.addItem(runes(), Misc.random(500));
		} else if (chance == 15) {
			p.addItem(dharoks(), 1);
			p.addItem(runes(), Misc.random(700));
			p.addItem(runes(), Misc.random(700));
		} else if (chance == 16) {
			p.addItem(guthans(), 1);
			p.addItem(runes(), Misc.random(500));
			p.addItem(randomItems(), 1);
		} else if (chance == 17) {
			p.addItem(karils(), 1);
			p.addItem(runes(), Misc.random(500));
			p.addItem(4740, Misc.random(500));
		} else if (chance == 18) {
			p.addItem(torags(), 1);
			p.addItem(runes(), Misc.random(500));
			p.addItem(randomItems(), 1);
		} else if (chance == 19) {
			p.addItem(veracs(), 1);
			p.addItem(runes(), Misc.random(500));
		}
		p.teleportTo(3565, 3307, 0, 0, -1, -1, -1, 0, 0);
		p.sendMessage("You gain your reward, and get teleported to the surface.");
		p.restorePrayer = 0;
		resetBarrows(p);
	}

	/*
	 * Spawns the required barrow brother for the tomb you open. If the tomb is empty, you are teleported to the tunnel.
	 * @param p - The player that the tomb is opened for.
	 * @param objectID - The object ID of the tomb that is opened.
	 */ 
	public static void openTomb(clientHandler p, int objectID) {
		switch(objectID) {

			case 6771:
				if (hiddenBrother(p, 0)) {
					break;
				}
				if (p.dharokSummoned == 0) {
					p.dharokSummoned = 1;
					spawnBrother(p, 2026, 3551, 9713);
				} else if (p.dharokSummoned == 1) {
					p.sendMessage("You are already fighting Dharok!");
				} else {
					p.sendMessage("You have already slain Dharok!");
				}
				break;

			case 6773:
				if (hiddenBrother(p, 2)) {
					break;
				}
				if (p.guthanSummoned == 0) {
					p.guthanSummoned = 1;
					spawnBrother(p, 2027, 3541, 9706);
				} else if (p.guthanSummoned == 1) {
					p.sendMessage("You are already fighting Guthan!");
				} else {
					p.sendMessage("You have already slain Guthan!");
				}
				break;

			case 6821:
				if (hiddenBrother(p, 1)) {
					break;
				}
				if (p.ahrimSummoned == 0) {
					p.ahrimSummoned = 1;
					spawnBrother(p, 2025, 3552, 9701);
				} else if (p.ahrimSummoned == 1) {
					p.sendMessage("You are already fighting Ahrim!");
				} else {
					p.sendMessage("You have already slain Ahrim!");
				}
				break;

			case 6823:
				if (hiddenBrother(p, 5)) {
					break;
				}
 				if (p.veracSummoned == 0) {
					p.veracSummoned = 1;
					spawnBrother(p, 2030, 3576, 9708);
				} else if (p.veracSummoned == 1) {
					p.sendMessage("You are already fighting Verac!");
				} else {
					p.sendMessage("You have already slain Verac!");
				}
				break;

			case 6772:
				if (hiddenBrother(p, 4)) {
					break;
				}
				if (p.toragSummoned == 0) {
					p.toragSummoned = 1;
					spawnBrother(p, 2029, 3567, 9686);
				} else if (p.toragSummoned == 1) {
					p.sendMessage("You are already fighting Torag!");
				} else {
					p.sendMessage("You have already slain Torag!");
				}
				break;

			case 6822:
				if (hiddenBrother(p, 3)) {
					break;
				}
				if (p.karilSummoned == 0) {
					p.karilSummoned = 1;
					spawnBrother(p, 2028, 3547, 9681);
				} else if (p.karilSummoned == 1) {
					p.sendMessage("You are already fighting Karil!");
				} else {
					p.sendMessage("You have already slain Karil!");
				}
				break;
		}
	}

	/*
	 * The player climbs the stairs from the crypt back up to the hills, and kills their barrow brother's.
	 * @param p - The player that climbs the stairs.
	 * @param objectID - The object ID of stairs that are climbed.
	 */ 
	public static void goUpStairs(clientHandler p, int objectID) {
		switch(objectID) {

			case 6703:
				p.teleportTo(3574, 3297, 0, 2, -1, -1, -1, 0, 0);

 				if (p.dharokSummoned != 2 && p.dharokSummoned != 0) {
					p.killMyNPCs();
					p.dharokSummoned = 0;
				}
				break;

			case 6704:
				p.teleportTo(3576, 3281, 0, 2, -1, -1, -1, 0, 0);

				if (p.guthanSummoned != 2 && p.guthanSummoned != 0) {
					p.killMyNPCs();
					p.guthanSummoned = 0;
				}
				break;

			case 6702:
				p.teleportTo(3564, 3289, 0, 2, -1, -1, -1, 0, 0);

				if (p.ahrimSummoned != 2 && p.ahrimSummoned != 0) {
					p.killMyNPCs();
					p.ahrimSummoned = 0;
				}
				break;

			case 6707:
				p.destinationRange = 3;
				p.teleportTo(3556, 3297, 0, 2, -1, -1, -1, 0, 0);

				if (p.veracSummoned != 2 && p.veracSummoned != 0) {
					p.killMyNPCs();
					p.veracSummoned = 0;
				}
				break;

			case 6706:
				p.destinationRange = 3;
				p.teleportTo(3553, 3283, 0, 2, -1, -1, -1, 0, 0);

				if (p.toragSummoned != 2 && p.toragSummoned != 0) {
					p.killMyNPCs();
					p.toragSummoned = 0;
				}
				break;

			case 6705:
				p.teleportTo(3565, 3276, 0, 2, -1, -1, -1, 0, 0);

				if (p.karilSummoned != 2 && p.karilSummoned != 0) {
					p.killMyNPCs();
					p.karilSummoned = 0;
				}
				break;
		}
	}
}