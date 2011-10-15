package com.iClarity.npcs;

import java.io.*;
import com.iClarity.GameEngine;
import com.iClarity.player.*;
import com.iClarity.misc.*;
import com.iClarity.world.items.*;
import com.iClarity.world.*;
import com.iClarity.player.Minigames.*;

public class NPCHandler {

	public static int maxNPCs = 10000;
	public static int maxListedNPCs = 10000;
	public static int maxNPCDrops = 10000;
	public NPC npcs[] = new NPC[maxNPCs];
	public NPCList NpcList[] = new NPCList[maxListedNPCs];

	public NPCHandler() {
		for(int i = 0; i < maxNPCs; i++) {
			npcs[i] = null;
		}
		for(int i = 0; i < maxListedNPCs; i++) {
			NpcList[i] = null;
		}
		loadNPCList("Data/CFG/NpcList.cfg");
		loadAutoSpawn("Data/CFG/NpcSpawn.cfg");
	}


	public void newNPC(int npcType, int x, int y, int heightLevel, int rangex1, int rangey1, int rangex2, int rangey2, int WalkingType, int HP, boolean Respawns) {

		int slot = -1;

		for (int i = 1; i < maxNPCs; i++) {
			if (npcs[i] == null) {
				slot = i;
				break;
			}
		}

		if (slot == -1) {
			return;
		}
		if (HP <= 0) {
			HP = 3000;
		}
		NPC newNPC = new NPC(slot, npcType);
		newNPC.absX = x;
		newNPC.absY = y;
		newNPC.makeX = x;
		newNPC.makeY = y;
		newNPC.moverangeX1 = rangex1;
		newNPC.moverangeY1 = rangey1;
		newNPC.moverangeX2 = rangex2;
		newNPC.moverangeY2 = rangey2;
		newNPC.walkingType = WalkingType;
		newNPC.HP = HP;
		newNPC.MaxHP = HP;
		newNPC.heightLevel = heightLevel;
                newNPC.Respawns = Respawns;

		if (newNPC.npcType == 2617 || newNPC.npcType == 2749) {
			newNPC.TurnNPCTo(newNPC.absX + 1, newNPC.absY);
		}

		npcs[slot] = newNPC;
	}

	public void newNPC(int npcType, int x, int y, int heightLevel, int rangex1, int rangey1, int rangex2, int rangey2, int WalkingType, boolean Respawns, int summonedBy) {
		int slot = -1;
		for (int i = 1; i < maxNPCs; i++) {
			if (npcs[i] == null) {
				slot = i;
				break;
			}
		}
		int HP = GetNpcListHP(npcType);

		if(slot == -1) return;		// no free slot found
                 if(HP <= 0) { // This will cause client crashes if we don't use this :) - xero
                  HP = 3000;
                }
		NPC newNPC = new NPC(slot, npcType);
		newNPC.absX = x;
		newNPC.absY = y;
		newNPC.makeX = x;
		newNPC.makeY = y;
		newNPC.moverangeX1 = rangex1;
		newNPC.moverangeY1 = rangey1;
		newNPC.moverangeX2 = rangex2;
		newNPC.moverangeY2 = rangey2;
		newNPC.walkingType = WalkingType;
		newNPC.HP = GetNpcListHP(npcType);
		newNPC.MaxHP = GetNpcListHP(npcType);
		newNPC.heightLevel = heightLevel;
                newNPC.Respawns = Respawns;
                newNPC.followPlayer = summonedBy;
                newNPC.followingPlayer = true;
		npcs[slot] = newNPC;
		clientHandler plr = (clientHandler) GameEngine.playerHandler.players[summonedBy];
		newNPC.spawnedBy = plr.playerId;
		newNPC.AttackingOn = plr.playerId;
		newNPC.StartKilling = plr.playerId;
		newNPC.RandomWalk = false;
		newNPC.IsUnderAttack = true;
	}

	public void newSummonedNPC(int npcType, int x, int y, int heightLevel, int rangex1, int rangey1, int rangex2, int rangey2, int WalkingType, int HP, boolean Respawns, int summonedBy) {
		int slot = -1;
		for (int i = 1; i < maxNPCs; i++) {
			if (npcs[i] == null) {
				slot = i;
				break;
			}
		}

		if(slot == -1) return;		// no free slot found
                 if(HP <= 0) { // This will cause client crashes if we don't use this :) - xero
                  HP = 3000;
                }
		NPC newNPC = new NPC(slot, npcType);
		newNPC.absX = x;
		newNPC.absY = y;
		newNPC.makeX = x;
		newNPC.makeY = y;
		newNPC.moverangeX1 = rangex1;
		newNPC.moverangeY1 = rangey1;
		newNPC.moverangeX2 = rangex2;
		newNPC.moverangeY2 = rangey2;
		newNPC.walkingType = WalkingType;
		newNPC.HP = HP;
		newNPC.MaxHP = HP;
		newNPC.heightLevel = heightLevel;
                newNPC.Respawns = Respawns;
		if(npcType != 1532 && npcType != 1534) {
                	newNPC.followPlayer = summonedBy;
                	newNPC.followingPlayer = true;
		}
		npcs[slot] = newNPC;
		clientHandler plr = (clientHandler) GameEngine.playerHandler.players[summonedBy];
		if(npcType != 1532 && npcType != 1534) {
			plr.drawHeadicon(1, slot, 0, 0);
		}
		newNPC.spawnedBy = plr.playerId;
		if(npcType != 1532 && npcType != 1534) {
			newNPC.AttackingOn = plr.playerId;
			newNPC.StartKilling = plr.playerId;
		}
		newNPC.RandomWalk = false;
		if(npcType != 1532 && npcType != 1534) {
			newNPC.IsUnderAttack = true;
		}

		for (int i = 2025; i < 2031; i++) {
			if (npcType == i) {
				newNPC.requestText("You dare disturb our rest!");
			}
		}
		for (int i = 2274; i < 2281; i++) {
			if (npcType == i) {
				newNPC.requestText("I'M ALIVE!");
			}
		}
		if (npcType == 308) {
			int talk = Misc.random(15);
			if(talk == 1) {
				newNPC.requestText("Do not fish yet!");
			}
		}
	}

	public void newNPCList(int npcType, String npcName, int combat, int HP) {
		int slot = -1;
		for (int i = 0; i < maxListedNPCs; i++) {
			if (NpcList[i] == null) {
				slot = i;
				break;
			}
		}

		if(slot == -1) return;		// no free slot found

		NPCList newNPCList = new NPCList(npcType);
		newNPCList.npcName = npcName;
		newNPCList.npcCombat = combat;
		newNPCList.npcHealth = HP;
		NpcList[slot] = newNPCList;
	}

	public int GetMove(int Place1,int Place2){ // Thanks to diablo for this! Fixed my npc follow code <3
			if ((Place1 - Place2) == 0) {
				return 0;
			} else if ((Place1 - Place2) < 0) {
				return 1;
			} else if ((Place1 - Place2) > 0) {
				return -1;
			}
			return 0;
	}

	public boolean WithinDistance(int i, int j, int k, int l, int i1) {
		for (int j1 = 0; j1 <= i1; j1++) {
			for (int k1 = 0; k1 <= i1; k1++) {
				if (i + j1 == k && (j + k1 == l || j - k1 == l || j == l)) {
					return true;
				}
				if (i - j1 == k && (j + k1 == l || j - k1 == l || j == l)) {
					return true;
				}
				if (i == k && (j + k1 == l || j - k1 == l || j == l)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean IsInRange(int NPCID, int MoveX, int MoveY) {
		int NewMoveX = (npcs[NPCID].absX + MoveX);
		int NewMoveY = (npcs[NPCID].absY + MoveY);

		if (NewMoveX <= npcs[NPCID].moverangeX1 && NewMoveX >= npcs[NPCID].moverangeX2 && NewMoveY <= npcs[NPCID].moverangeY1 && NewMoveY >= npcs[NPCID].moverangeY2) {
			if (npcs[NPCID].walkingType == 2) {
				if (MoveX == MoveY) {
					return false;
				}
				return true;
			}
		}
		return false;
	}

	public void process() {
		for (int i = 0; i < maxNPCs; i++) {

			if (npcs[i] == null) continue;
			npcs[i].clearUpdateFlags();

        /** 
         * this turns the npc 
         * +1 to absX makes the npc face east, 
         * -1 to absX makes it face west. 
         * +1 to absY makes it face north and 
         * -1 to absY makes it face south.
         **/
/*if (npcs[i].npcType == 3000) {
npcs[i].turnNpc(npcs[i].absX+1, npcs[i].absY);
}
if (npcs[i].npcType == 3002) {
npcs[i].turnNpc(npcs[i].absX, npcs[i].absY+1);
}
*/
		}

		

		for(int i = 0; i < maxNPCs; i++) {                        
			if (npcs[i] != null) {
				if (npcs[i].deathTimer > 0) {
					npcs[i].deathTimer--;
				}
				npcs[i].process();

				if (!npcs[i].IsDead) {
/*
					if (npcs[i].RandomWalk) {
						if((npcs[i].absX > (npcs[i].makeX + NPCBoundaries.getBoundary(npcs[i])))
						|| (npcs[i].absY > (npcs[i].makeY + NPCBoundaries.getBoundary(npcs[i])))
						|| (npcs[i].absX < (npcs[i].makeX = NPCBoundaries.getBoundary(npcs[i])))
						|| (npcs[i].absY < (npcs[i].makeY - NPCBoundaries.getBoundary(npcs[i]))) ) {
								npcs[i].MoveBackToOrigin();
								npcs[i].getNextNPCMovement();
						}
					}
			else */

if (npcs[i].RandomWalk == true && Misc.random2(10) >= 8 && npcs[i].moverangeX1 > 0 && npcs[i].moverangeY1 > 0 && npcs[i].moverangeX2 > 0 && npcs[i].moverangeY2 > 0) { //Move NPC
						int MoveX = Misc.random(1);
						int MoveY = Misc.random(1);
						int Rnd = Misc.random2(4);
						if (Rnd == 1) {
							MoveX = -(MoveX);
							MoveY = -(MoveY);
						} else if (Rnd == 2) {
							MoveX = -(MoveX);
						} else if (Rnd == 3) {
							MoveY = -(MoveY);
						}
						if (IsInRange(i, MoveX, MoveY)) {
							npcs[i].moveX = MoveX;
							npcs[i].moveY = MoveY;
						}
						npcs[i].getNextNPCMovement();
						npcs[i].updateRequired = true;                                                                                                                                    
					}
				} else if (npcs[i].IsDead == true) {
					if (npcs[i].deathTimer == 0 && npcs[i].DeadApply == false && npcs[i].NeedRespawn == false) {
						npcs[i].ResetAttack();
                            			npcs[i].animNumber = NPCEmotes.GetDeathAnim(npcs[i]); 
						npcs[i].updateRequired = true;
						npcs[i].animUpdateRequired = true;
						npcs[i].DeadApply = true;
						npcs[i].faceplayer(0);
						npcs[i].deathTimer = 6;
					} else if (npcs[i].deathTimer == 0 && npcs[i].DeadApply == true && npcs[i].NeedRespawn == false && npcs[i] != null) {
  						MonsterDropItem(i);
						npcs[i].NeedRespawn = true;
						npcs[i].deathTimer = 60;
						npcs[i].absX = npcs[i].makeX;
						npcs[i].absY = npcs[i].makeY;
						npcs[i].animNumber = 0x328;
						npcs[i].HP = npcs[i].MaxHP;
						npcs[i].updateRequired = true;
						npcs[i].animUpdateRequired = true;

					} else if (npcs[i].deathTimer == 0 && npcs[i].NeedRespawn == true) {/*
						for (int j = 1; j < GameEngine.playerHandler.maxPlayers; j++) {
							if (GameEngine.playerHandler.players[j] != null) {
								GameEngine.playerHandler.players[j].RebuildNPCList = true;
							}
						}*/
                                                if (npcs[i].Respawns) {
							int old1 = npcs[i].npcType;

							if (old1 == 1267 ||old1 == 1265) {
								old1 += 1;
							}
							int old2 = npcs[i].makeX;
							int old3 = npcs[i].makeY;
							int old4 = npcs[i].heightLevel;
							int old5 = npcs[i].moverangeX1;
							int old6 = npcs[i].moverangeY1;
							int old7 = npcs[i].moverangeX2;
							int old8 = npcs[i].moverangeY2;
							int old9 = npcs[i].walkingType;
							int old10 = npcs[i].MaxHP;
							npcs[i] = null;
							newNPC(old1, old2, old3, old4, old5, old6, old7, old8, old9, old10, true);
						}
					}
				}
			}
		}
	}

	public static boolean IsDropping = false;

	public void MonsterDropItem(int NPCID) {
	    	if (IsDropping == false) {
			IsDropping = true;
			int Maxi = GameEngine.itemHandler.DropItemCount;
			clientHandler c = (clientHandler) GameEngine.playerHandler.players[npcs[NPCID].AttackingOn];

			if (c == null) {
				return;
			}
			for (int i = 0; i <= Maxi; i++) {
		   		if (GameEngine.itemHandler.DroppedItemsID[i] > 0) {

		    		} else {
					int NPCID2 = NPCID+34;

		if(c.slayerNPC == npcs[NPCID].npcType) {
			if(c.slayAmount >= 1) {
				c.slayAmount--;
				c.sendMessage("You now need "+(c.slayAmount+1)+" more kills.");
			} else {
				c.sendMessage("You've killed all of the monsters for your task!");
			}
		}

					switch (npcs[NPCID].npcType) {



						case 1:
						case 2:
						case 3:
						case 4:
 							ItemHandler.addItem(526, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
							ItemHandler.addItem(995, npcs[NPCID].absX, npcs[NPCID].absY, Misc.random(5), npcs[NPCID].AttackingOn, false);
							break;
						case 9:
						case 32:
							ItemHandler.addItem(526, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
							ItemHandler.addItem(995, npcs[NPCID].absX, npcs[NPCID].absY, Misc.random(20), npcs[NPCID].AttackingOn, false);
							break;
						case 1677:
						case 1678:
							ItemHandler.addItem(526, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
							break;
			case 1158://kalphite queen
				int kalphiteDrop = Misc.random(29);
					ItemHandler.addItem(532, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					if(kalphiteDrop == 0) {
						ItemHandler.addItem(1149, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					} else if(kalphiteDrop == 1) {
						ItemHandler.addItem(6733, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					} else if(kalphiteDrop == 2) {
						ItemHandler.addItem(6737, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					} else if(kalphiteDrop == 3) {
						ItemHandler.addItem(6731, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					} else if(kalphiteDrop == 4) {
						ItemHandler.addItem(3140, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					} else if(kalphiteDrop == 5) {
						ItemHandler.addItem(6735, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
			break;

			case 3340://Giant Mole
				int moleDrop = Misc.random(15);
				GameEngine.moleTeleports = 0;
						ItemHandler.addItem(532, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					if(moleDrop == 0) {
						ItemHandler.addItem(4278, npcs[NPCID].absX, npcs[NPCID].absY, 3000, npcs[NPCID].AttackingOn, false);
					} else if(moleDrop == 1) {
						ItemHandler.addItem(1516, npcs[NPCID].absX, npcs[NPCID].absY, 100, npcs[NPCID].AttackingOn, false);
					} else if(moleDrop == 2) {
						ItemHandler.addItem(386, npcs[NPCID].absX, npcs[NPCID].absY, 4, npcs[NPCID].AttackingOn, false);
					} else if(moleDrop == 3) {
						ItemHandler.addItem(1301, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					} else if(moleDrop == 4) {
						ItemHandler.addItem(556, npcs[NPCID].absX, npcs[NPCID].absY, 105, npcs[NPCID].AttackingOn, false);
					} else if(moleDrop == 5) {
						ItemHandler.addItem(1704, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					} else if(moleDrop == 6) {
						ItemHandler.addItem(1725, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					} else if(moleDrop == 7) {
						ItemHandler.addItem(565, npcs[NPCID].absX, npcs[NPCID].absY, 15, npcs[NPCID].AttackingOn, false);
					} else if(moleDrop == 8) {
						ItemHandler.addItem(453, npcs[NPCID].absX, npcs[NPCID].absY, 5, npcs[NPCID].AttackingOn, false);
					} else if(moleDrop == 9) {
						ItemHandler.addItem(560, npcs[NPCID].absX, npcs[NPCID].absY, 6, npcs[NPCID].AttackingOn, false);
					} else if(moleDrop == 10) {
						ItemHandler.addItem(5698, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					} else if(moleDrop == 11) {
						ItemHandler.addItem(11335, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					} else if(moleDrop == 12) {
						ItemHandler.addItem(1249, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					} else if(moleDrop == 13) {
						ItemHandler.addItem(554, npcs[NPCID].absX, npcs[NPCID].absY, 105, npcs[NPCID].AttackingOn, false);
					} else if(moleDrop == 14) {
						ItemHandler.addItem(985, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					} else if(moleDrop == 15) {
						ItemHandler.addItem(1319, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
			break;

			case 3200://chaos elemental
				int chaosDrop = Misc.random(100);
					ItemHandler.addItem(532, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					if(chaosDrop >= 0 && chaosDrop <= 99) {
						ItemHandler.addItem(2418, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(chaosDrop == 100) {
						ItemHandler.addItem(7158, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
			break;

			case 1823://cave goblins
				int goblinDrop = Misc.random(11);
				int goblinDrop2 = Misc.random(5);
					ItemHandler.addItem(526, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					if(goblinDrop == 0) {
						ItemHandler.addItem(1117, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(goblinDrop == 1) {
						ItemHandler.addItem(1075, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(goblinDrop == 2) {
						ItemHandler.addItem(1155, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(goblinDrop == 3) {
						ItemHandler.addItem(1189, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(goblinDrop == 4) {
						ItemHandler.addItem(1087, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(goblinDrop == 5) {
						ItemHandler.addItem(1173, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(goblinDrop == 8) {
						ItemHandler.addItem(1696, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(goblinDrop == 10) {
						ItemHandler.addItem(199, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(goblinDrop == 11) {
						ItemHandler.addItem(221, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(goblinDrop == 6 && goblinDrop2 == 3) {
						ItemHandler.addItem(985, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(goblinDrop == 7 && goblinDrop2 == 3) {
						ItemHandler.addItem(987, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(goblinDrop == 9) {
						ItemHandler.addItem(1437, npcs[NPCID].absX, npcs[NPCID].absY, Misc.random(10), npcs[NPCID].AttackingOn, false);
					}
			break;
			case 3406://icefiends
				int icefiendDrop = Misc.random(9);
					ItemHandler.addItem(592, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);

					if(icefiendDrop == 0) {
						ItemHandler.addItem(4121, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(icefiendDrop == 1) {
						ItemHandler.addItem(1115, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(icefiendDrop == 2) {
						ItemHandler.addItem(1067, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(icefiendDrop == 3) {
						ItemHandler.addItem(1153, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(icefiendDrop == 4) {
						ItemHandler.addItem(1191, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(icefiendDrop == 5) {
						ItemHandler.addItem(1698, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(icefiendDrop == 6) {
						ItemHandler.addItem(380, npcs[NPCID].absX, npcs[NPCID].absY, Misc.random(10), npcs[NPCID].AttackingOn, false);
					}
					if(icefiendDrop == 7) {
						ItemHandler.addItem(4278, npcs[NPCID].absX, npcs[NPCID].absY, Misc.random(1000), npcs[NPCID].AttackingOn, false);
					}
					if(icefiendDrop == 8) {
						ItemHandler.addItem(1437,  npcs[NPCID].absX, npcs[NPCID].absY, Misc.random(15), npcs[NPCID].AttackingOn, false);
					}
					if(icefiendDrop == 9) {
						ItemHandler.addItem(227, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
			break;
			case 1329://unicorn foal
				int unicornDrop = Misc.random(12);
				int unicornRareDrop = Misc.random(45);
					ItemHandler.addItem(526, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					if(unicornDrop == 0) {
						ItemHandler.addItem(884, npcs[NPCID].absX, npcs[NPCID].absY, Misc.random(30), npcs[NPCID].AttackingOn, false);
					}
					if(unicornRareDrop == 14) {
						ItemHandler.addItem(553, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(unicornRareDrop == 37) {
						ItemHandler.addItem(964, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(unicornDrop == 1) {
						ItemHandler.addItem(886, npcs[NPCID].absX, npcs[NPCID].absY, Misc.random(30), npcs[NPCID].AttackingOn, false);
					}
					if(unicornDrop == 2) {
						ItemHandler.addItem(888, npcs[NPCID].absX, npcs[NPCID].absY, Misc.random(30), npcs[NPCID].AttackingOn, false);
					}
					if(unicornDrop == 3) {
						ItemHandler.addItem(890, npcs[NPCID].absX, npcs[NPCID].absY, Misc.random(30), npcs[NPCID].AttackingOn, false);
					}
					if(unicornDrop == 4) {
						ItemHandler.addItem(857, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(unicornDrop == 6) {
						ItemHandler.addItem(1063, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(unicornDrop == 7) {
						ItemHandler.addItem(1095, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(unicornDrop == 8) {
						ItemHandler.addItem(1129, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(unicornDrop == 5) {
						ItemHandler.addItem(4278, npcs[NPCID].absX, npcs[NPCID].absY, Misc.random(1000), npcs[NPCID].AttackingOn, false);
					}
					if(unicornDrop == 9) {
						ItemHandler.addItem(380, npcs[NPCID].absX, npcs[NPCID].absY, Misc.random(10), npcs[NPCID].AttackingOn, false);
					}
					if(unicornDrop == 10) {
						ItemHandler.addItem(1437, npcs[NPCID].absX, npcs[NPCID].absY, Misc.random(20), npcs[NPCID].AttackingOn, false);
					}
					if(unicornDrop == 11) {
						ItemHandler.addItem(235, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(unicornDrop == 12) {
						ItemHandler.addItem(201, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
			break;
			case 1021://air elemental
				int airDrop = Misc.random(10);
				int airDrop2 = Misc.random(2);
					ItemHandler.addItem(592, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					if(airDrop == 0) {
						ItemHandler.addItem(562, npcs[NPCID].absX, npcs[NPCID].absY, Misc.random(20), npcs[NPCID].AttackingOn, false);
					}
					if(airDrop == 1) {
						ItemHandler.addItem(556, npcs[NPCID].absX, npcs[NPCID].absY, Misc.random(40), npcs[NPCID].AttackingOn, false);
					}
					if(airDrop == 2) {
						ItemHandler.addItem(554, npcs[NPCID].absX, npcs[NPCID].absY, Misc.random(30), npcs[NPCID].AttackingOn, false);
					}
					if(airDrop == 3) {
						ItemHandler.addItem(555, npcs[NPCID].absX, npcs[NPCID].absY, Misc.random(30), npcs[NPCID].AttackingOn, false);
					}
					if(airDrop == 4) {
						ItemHandler.addItem(557, npcs[NPCID].absX, npcs[NPCID].absY, Misc.random(30), npcs[NPCID].AttackingOn, false);
					}
					if(airDrop == 5) {
						ItemHandler.addItem(577, npcs[NPCID].absX, npcs[NPCID].absY, Misc.random(30), npcs[NPCID].AttackingOn, false);
					}
					if(airDrop == 6) {
						ItemHandler.addItem(579, npcs[NPCID].absX, npcs[NPCID].absY, Misc.random(30), npcs[NPCID].AttackingOn, false);
					}
					if(airDrop == 7) {
						ItemHandler.addItem(1011, npcs[NPCID].absX, npcs[NPCID].absY, Misc.random(30), npcs[NPCID].AttackingOn, false);
					}					
					if(airDrop == 10 && airDrop2 == 0) {
						ItemHandler.addItem(7390, npcs[NPCID].absX, npcs[NPCID].absY, Misc.random(30), npcs[NPCID].AttackingOn, false);
					}
					if(airDrop == 11 && airDrop2 == 1) {
						ItemHandler.addItem(7394, npcs[NPCID].absX, npcs[NPCID].absY, Misc.random(30), npcs[NPCID].AttackingOn, false);
					}
					if(airDrop == 12 && airDrop2 == 2) {
						ItemHandler.addItem(7386, npcs[NPCID].absX, npcs[NPCID].absY, Misc.random(30), npcs[NPCID].AttackingOn, false);
					}
					if(airDrop == 8) {
						ItemHandler.addItem(380, npcs[NPCID].absX, npcs[NPCID].absY, Misc.random(10), npcs[NPCID].AttackingOn, false);
					}
					if(airDrop == 9) {
						ItemHandler.addItem(4278, npcs[NPCID].absX, npcs[NPCID].absY, Misc.random(1000), npcs[NPCID].AttackingOn, false);
					}
					if(airDrop == 10) {
						ItemHandler.addItem(1437, npcs[NPCID].absX, npcs[NPCID].absY, Misc.random(100), npcs[NPCID].AttackingOn, false);
					}
			break;
			case 112://moss giant
				int mossDrop = Misc.random(9);
					ItemHandler.addItem(532, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					if(mossDrop == 0) {
						ItemHandler.addItem(1071, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(mossDrop == 1) {
						ItemHandler.addItem(1121, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(mossDrop == 2) {
						ItemHandler.addItem(1159, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(mossDrop == 3) {
						ItemHandler.addItem(1197, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(mossDrop == 4) {
						ItemHandler.addItem(4127, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(mossDrop == 5) {
						ItemHandler.addItem(1329, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(mossDrop == 6) {
						ItemHandler.addItem(380, npcs[NPCID].absX, npcs[NPCID].absY, Misc.random(10), npcs[NPCID].AttackingOn, false);
					}
					if(mossDrop == 7) {
						ItemHandler.addItem(4278, npcs[NPCID].absX, npcs[NPCID].absY, Misc.random(1000), npcs[NPCID].AttackingOn, false);
					}
					if(mossDrop == 8) {
						ItemHandler.addItem(207, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(mossDrop == 9) {
						ItemHandler.addItem(231, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
			break;
			case 126://otherworldly being
				int otherworldlyDrop = Misc.random(12);
				int otherworldlyDrop2 = Misc.random(4);
					ItemHandler.addItem(526, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					if(otherworldlyDrop == 0) {
						ItemHandler.addItem(560, npcs[NPCID].absX, npcs[NPCID].absY, Misc.random(20), npcs[NPCID].AttackingOn, false);
					}
					if(otherworldlyDrop == 1) {
						ItemHandler.addItem(565, npcs[NPCID].absX, npcs[NPCID].absY, Misc.random(10), npcs[NPCID].AttackingOn, false);
					}
					if(otherworldlyDrop == 2) {
						ItemHandler.addItem(562, npcs[NPCID].absX, npcs[NPCID].absY, Misc.random(30), npcs[NPCID].AttackingOn, false);
					}
					if(otherworldlyDrop == 3) {
						ItemHandler.addItem(6106, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(otherworldlyDrop == 4) {
						ItemHandler.addItem(6107, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(otherworldlyDrop == 5) {
						ItemHandler.addItem(6108, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(otherworldlyDrop == 6) {
						ItemHandler.addItem(6109, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(otherworldlyDrop == 7) {
						ItemHandler.addItem(6110, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(otherworldlyDrop == 8) {
						ItemHandler.addItem(6111, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(otherworldlyDrop == 9) {
						ItemHandler.addItem(3054, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(otherworldlyDrop == 9 && otherworldlyDrop2 == 2) {
						ItemHandler.addItem(4675, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(otherworldlyDrop == 10) {
						ItemHandler.addItem(380, npcs[NPCID].absX, npcs[NPCID].absY, Misc.random(10), npcs[NPCID].AttackingOn, false);
					}
					if(otherworldlyDrop == 11) {
						ItemHandler.addItem(4278, npcs[NPCID].absX, npcs[NPCID].absY, Misc.random(1000), npcs[NPCID].AttackingOn, false);
					}
					if(otherworldlyDrop == 12) {
						ItemHandler.addItem(1695, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
			break;
			case 3027://white golem
				int whiteDrop = Misc.random(8);
					ItemHandler.addItem(532, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					if(whiteDrop == 0) {
						ItemHandler.addItem(1073, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(whiteDrop == 1) {
						ItemHandler.addItem(1123, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(whiteDrop == 2) {
						ItemHandler.addItem(1161, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(whiteDrop == 3) {
						ItemHandler.addItem(1199, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(whiteDrop == 4) {
						ItemHandler.addItem(4129, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(whiteDrop == 5) {
						ItemHandler.addItem(1331, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(whiteDrop == 6) {
						ItemHandler.addItem(380, npcs[NPCID].absX, npcs[NPCID].absY, Misc.random(10), npcs[NPCID].AttackingOn, false);
					}
					if(whiteDrop == 7) {
						ItemHandler.addItem(4278, npcs[NPCID].absX, npcs[NPCID].absY, Misc.random(1000), npcs[NPCID].AttackingOn, false);
					}
					if(whiteDrop == 8) {
						ItemHandler.addItem(239, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
			break;
			case 110://fire giant
				int fireDrop = Misc.random(24);
					ItemHandler.addItem(532, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					if(fireDrop == 0) {
						ItemHandler.addItem(1079, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(fireDrop == 11) {
						ItemHandler.addItem(1127, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(fireDrop == 2) {
						ItemHandler.addItem(1163, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(fireDrop == 12) {
						ItemHandler.addItem(1201, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(fireDrop == 20) {
						ItemHandler.addItem(1319, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(fireDrop == 16) {
						ItemHandler.addItem(4131, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
			break;
			case 1644://inferno mages
				int infernoDrop = Misc.random(10);
				int infernoDrop2 = Misc.random(85);
				int infernoDrop3 = Misc.random(85);
				int infernoDrop4 = Misc.random(85);
					ItemHandler.addItem(592, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					if(infernoDrop == 1) {
						ItemHandler.addItem(565, npcs[NPCID].absX, npcs[NPCID].absY, Misc.random(100), npcs[NPCID].AttackingOn, false);
					}
					if(infernoDrop == 4) {
						ItemHandler.addItem(561, npcs[NPCID].absX, npcs[NPCID].absY, Misc.random(100), npcs[NPCID].AttackingOn, false);
					}
					if(infernoDrop == 7) {
						ItemHandler.addItem(560, npcs[NPCID].absX, npcs[NPCID].absY, Misc.random(100), npcs[NPCID].AttackingOn, false);
					}
					if(infernoDrop == 10) {
						ItemHandler.addItem(6563, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(infernoDrop2 == 3) {
						ItemHandler.addItem(4089, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(infernoDrop2 == 6) {
						ItemHandler.addItem(4091, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(infernoDrop2 == 9) {
						ItemHandler.addItem(4093, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(infernoDrop2 == 12) {
						ItemHandler.addItem(4095, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(infernoDrop2 == 15) {
						ItemHandler.addItem(4097, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(infernoDrop3 == 3) {
						ItemHandler.addItem(4099, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(infernoDrop3 == 6) {
						ItemHandler.addItem(4101, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(infernoDrop3 == 9) {
						ItemHandler.addItem(4103, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(infernoDrop3 == 12) {
						ItemHandler.addItem(4105, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(infernoDrop3 == 15) {
						ItemHandler.addItem(4107, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(infernoDrop4 == 3) {
						ItemHandler.addItem(4109, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(infernoDrop4 == 6) {
						ItemHandler.addItem(4111, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(infernoDrop4 == 9) {
						ItemHandler.addItem(4113, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(infernoDrop4 == 12) {
						ItemHandler.addItem(4115, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(infernoDrop4 == 15) {
						ItemHandler.addItem(4117, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
			break;
			case 1183://elf warrior
				int elfDrop = Misc.random(5);
				int elfDrop2 = Misc.random(20);
					ItemHandler.addItem(526, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					if(elfDrop == 0) {
						ItemHandler.addItem(888, npcs[NPCID].absX, npcs[NPCID].absY, Misc.random(30), npcs[NPCID].AttackingOn, false);
					}
					if(elfDrop == 1) {
						ItemHandler.addItem(890, npcs[NPCID].absX, npcs[NPCID].absY, Misc.random(30), npcs[NPCID].AttackingOn, false);
					}
					if(elfDrop == 2) {
						ItemHandler.addItem(892, npcs[NPCID].absX, npcs[NPCID].absY, Misc.random(30), npcs[NPCID].AttackingOn, false);
					}
					if(elfDrop == 3) {
						ItemHandler.addItem(859, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(elfDrop == 4 && elfDrop2 == 5) {
						ItemHandler.addItem(4214, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(elfDrop == 5) {
						ItemHandler.addItem(209, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(elfDrop == 4 && elfDrop2 == 3) {
						ItemHandler.addItem(4225, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
			break;
			case 3070://skeletal wyvern
				int skeletalDrop = Misc.random(7);
				int skeletalDrop2 = Misc.random(25);
					ItemHandler.addItem(536, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					if(skeletalDrop == 2 || skeletalDrop == 5) {
						ItemHandler.addItem(1702, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(skeletalDrop2 == 5) {
						ItemHandler.addItem(1305, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(skeletalDrop == 1) {
						ItemHandler.addItem(209, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}					
			break;
			case 1592://Steel Dragon
				int steelDrop = Misc.random(10);
				int steelDrop2 = Misc.random(10);
					ItemHandler.addItem(536, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					ItemHandler.addItem(2354, npcs[NPCID].absX, npcs[NPCID].absY, Misc.random(10), npcs[NPCID].AttackingOn, false);
					if(steelDrop == 5) {
						ItemHandler.addItem(6524, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(steelDrop2 == 5) {
						ItemHandler.addItem(6523, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
			break;
			case 941://Green Dragon
				int greenDrop = Misc.random(4);
				int greenDrop2 = Misc.random(2);
				int greenDrop3 = Misc.random(25);
					ItemHandler.addItem(536, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					ItemHandler.addItem(1753, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					if(greenDrop == 0) {
						ItemHandler.addItem(1065, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(greenDrop == 1) {
						ItemHandler.addItem(1135, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(greenDrop == 2) {
						ItemHandler.addItem(1099, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(greenDrop == 3 && greenDrop2 ==1) {
						ItemHandler.addItem(7370, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(greenDrop == 4 && greenDrop2 ==1) {
						ItemHandler.addItem(7378, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(greenDrop3 == 10) {
						ItemHandler.addItem(7370, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
						ItemHandler.addItem(7378, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
			break;
			case 55://Blue dragon
				int blueDrop = Misc.random(5);
				int blueDrop2 = Misc.random(2);
				int blueDrop3 = Misc.random(25);
					ItemHandler.addItem(536, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					ItemHandler.addItem(1751, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					if(blueDrop == 0) {
						ItemHandler.addItem(2487, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(blueDrop == 1) {
						ItemHandler.addItem(2493, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(blueDrop == 2) {
						ItemHandler.addItem(2499, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(blueDrop == 3 && blueDrop2 == 1) {
						ItemHandler.addItem(7374, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(blueDrop == 4 && blueDrop2 == 1) {
						ItemHandler.addItem(7382, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(blueDrop3 == 10) {
						ItemHandler.addItem(7374, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
						ItemHandler.addItem(7382, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(blueDrop == 5) {
						ItemHandler.addItem(213, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
			break;
			case 53:// Red Dragon
				int redDrop = Misc.random(4);
				int redDrop2 = Misc.random(1);
				int redDrop3 = Misc.random(5);
					ItemHandler.addItem(536, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					ItemHandler.addItem(1749, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					if(redDrop == 0) {
						ItemHandler.addItem(2489, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(redDrop == 1) {
						ItemHandler.addItem(2495, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(redDrop == 2) {
						ItemHandler.addItem(2501, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(redDrop == 3 && redDrop2 == 1) {
						ItemHandler.addItem(6568, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(redDrop3 == 2) {
						ItemHandler.addItem(6568, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(redDrop == 4) {
						ItemHandler.addItem(215, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
			break;
			case 54:// Black Dragon
				int blackDrop = Misc.random(3);
				int blackDrop2 = Misc.random(4);
					ItemHandler.addItem(536, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					ItemHandler.addItem(1747, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
				if(blackDrop == 0) {
					ItemHandler.addItem(2491, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
				}
				if(blackDrop == 1) {
					ItemHandler.addItem(2503, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
				}
				if(blackDrop == 2) {
					ItemHandler.addItem(2497, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
				}
				if(blackDrop == 3) {
					ItemHandler.addItem(4131, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
				}
				if(blackDrop == 3 && blackDrop2 == 2) {
					ItemHandler.addItem(11728, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
				}
			break;
			case 50://KBD
				int kbdDrop = Misc.random(25);
					ItemHandler.addItem(536, npcs[NPCID].absX, npcs[NPCID].absY, Misc.random(2), npcs[NPCID].AttackingOn, false);
					ItemHandler.addItem(1747, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					if(kbdDrop == 1) {
						ItemHandler.addItem(1846, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(kbdDrop == 2) {
						ItemHandler.addItem(1025, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(kbdDrop == 3) {
						ItemHandler.addItem(2599, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(kbdDrop == 4) {
						ItemHandler.addItem(4158, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(kbdDrop == 5) {
						ItemHandler.addItem(4170, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(kbdDrop == 6) {
						ItemHandler.addItem(5013, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(kbdDrop == 10) {
						ItemHandler.addItem(3099, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(kbdDrop == 15) {
						ItemHandler.addItem(2476, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
			break;
			case 1610:
				int gargDrop = Misc.random(7);
				int gargDrop2 = Misc.random(2);
					ItemHandler.addItem(536, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					if(gargDrop == 0 && gargDrop2 == 0) {
						ItemHandler.addItem(3122, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(gargDrop == 1) {
						ItemHandler.addItem(4278, npcs[NPCID].absX, npcs[NPCID].absY, Misc.random(2000), npcs[NPCID].AttackingOn, false);
					}
					if(gargDrop == 2) {
						ItemHandler.addItem(6581, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(gargDrop == 3 && gargDrop2 == 1) {
						ItemHandler.addItem(6583, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(gargDrop == 4) {
						ItemHandler.addItem(1147, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(gargDrop == 5) {
						ItemHandler.addItem(3202, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(gargDrop == 6 && gargDrop2 == 2) {
						ItemHandler.addItem(3105, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
			break;
			case 1615: //Abyssal Demon
				int abyDrop = Misc.random(7);
				int abyDrop2 = Misc.random(9);
					ItemHandler.addItem(592, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					if(abyDrop == 0 && abyDrop2 == 1) {
						ItemHandler.addItem(4151, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(abyDrop == 1 && abyDrop2 == 2) {
						ItemHandler.addItem(1187, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(abyDrop == 2) {
						ItemHandler.addItem(4278, npcs[NPCID].absX, npcs[NPCID].absY, Misc.random(3500), npcs[NPCID].AttackingOn, false);
					}
			break;
			case 49: //HellHound
				int hellDrop = Misc.random(10);
				int hellDrop2 = Misc.random(5);
					ItemHandler.addItem(4812, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					if(hellDrop == 0 && hellDrop2 == 2) {
						ItemHandler.addItem(5698, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(hellDrop == 1) {
						ItemHandler.addItem(4278, npcs[NPCID].absX, npcs[NPCID].absY, Misc.random(4000), npcs[NPCID].AttackingOn, false);
					}
			break;
			case 83: //Greater Demon
				int greatDrop = Misc.random(9);
				int greatDrop2 = Misc.random(4);
					ItemHandler.addItem(592, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					if(greatDrop == 0 && greatDrop2 == 1) {
						ItemHandler.addItem(5730, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(greatDrop == 2 && greatDrop2 == 2) {
						ItemHandler.addItem(1305, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(greatDrop == 3) {
						ItemHandler.addItem(1289, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(greatDrop == 4) {
						ItemHandler.addItem(4278, npcs[NPCID].absX, npcs[NPCID].absY, Misc.random(2500), npcs[NPCID].AttackingOn, false);
					}
					if(greatDrop == 5) {
						ItemHandler.addItem(125, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
			break;
			case 2881: //Dag Supreme
				int supremeDrop = Misc.random(10);
					ItemHandler.addItem(4812, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					if(supremeDrop == 1) {
						ItemHandler.addItem(6739, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(supremeDrop == 2) {
						ItemHandler.addItem(4587, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(supremeDrop == 3) {
						ItemHandler.addItem(4278, npcs[NPCID].absX, npcs[NPCID].absY, Misc.random(7500), npcs[NPCID].AttackingOn, false);
					}
			break;
			case 2882: //Dag Prime
				int primeDrop = Misc.random(19);
					ItemHandler.addItem(4812, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					if(primeDrop == 1) {
						ItemHandler.addItem(1377, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(primeDrop == 2 ) {
						ItemHandler.addItem(1434, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(primeDrop == 3) {
						ItemHandler.addItem(4278, npcs[NPCID].absX, npcs[NPCID].absY, Misc.random(7500), npcs[NPCID].AttackingOn, false);
					}
					if(primeDrop == 4) {
						ItemHandler.addItem(4585, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
			break;
			case 2883: //Dag Rex
				int rexDrop = Misc.random(19);
					ItemHandler.addItem(4812, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					if(rexDrop == 1) {
						ItemHandler.addItem(3204, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(rexDrop == 2) {
						ItemHandler.addItem(15156, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
					if(rexDrop == 3) {
						ItemHandler.addItem(4278, npcs[NPCID].absX, npcs[NPCID].absY, Misc.random(7500), npcs[NPCID].AttackingOn, false);
					}
					if(rexDrop == 4) {
						ItemHandler.addItem(4087, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					}
			break;
			case 41: //Chicken
					ItemHandler.addItem(526, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
					ItemHandler.addItem(314, npcs[NPCID].absX, npcs[NPCID].absY, 10 + Misc.random(30), npcs[NPCID].AttackingOn, false);
					ItemHandler.addItem(2138, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
			break;
						case 2031:
						case 2036:
						if(c.killCount < 10) {
							c.killCount +=1;
							c.savemoreinfo();
						} else {
							c.teleportToX = 3557;
							c.teleportToY = 9694;
							c.sendMessage("You are teleported into the chest room!");
						}
							break;

						case 2025:
							c.killCount += 1;
							c.ahrimSummoned = 2;
							c.savemoreinfo();
							break;
						case 2026:
							c.killCount += 1;
							c.dharokSummoned = 2;
							c.savemoreinfo();
							break;
						case 2027:
							c.killCount += 1;
							c.guthanSummoned = 2;
							c.savemoreinfo();
							break;
						case 2028:
							c.killCount += 1;
							c.karilSummoned = 2;
							c.savemoreinfo();
							break;
						case 2029:
							c.killCount += 1;
							c.toragSummoned = 2;
							c.savemoreinfo();
							break;
						case 2030:
							c.killCount += 1;
							c.veracSummoned = 2;
							c.savemoreinfo();
							break;
						case 2745:
							FightCaves.KilledJad(c);
							if (c.IsInFightCave()) {
								FightCaves.KilledJad(c);
							}
							break;
						case 2627:
						case 2629:
						case 2631:
 						case 2742:
						case 2743:
						case 2744:
							if (c.IsInFightCave()) {
								c.KilledTz++;

								if (c.KilledTz == c.NeededKills) {
									c.tzWave++;
									c.WaveDelay = 20;
								}
							}
							break;
						case 1913:
							ItemHandler.addItem(4671, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
							break;
						case 81:
							ItemHandler.addItem(526, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
							ItemHandler.addItem(1739, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
						break;
					    default:
						ItemHandler.addItem(526, npcs[NPCID].absX, npcs[NPCID].absY, 1, npcs[NPCID].AttackingOn, false);
						break;
					}

					if (i == Maxi) {
						if (GameEngine.itemHandler.DropItemCount >= (GameEngine.itemHandler.MaxDropItems + 1)) {
							GameEngine.itemHandler.DropItemCount = 0;
						}
					}
					break;
				}
			}
			IsDropping = false;
		}
	}

	public int GetNpcKiller(int NPCID) {
		int Killer = 0;
		int Count = 0;
		for (int i = 1; i < GameEngine.playerHandler.maxPlayers; i++) {
			if (Killer == 0) {
				Killer = i;
				Count = 1;
			} else {
				if (npcs[NPCID].Killing[i] > npcs[NPCID].Killing[Killer]) {
					Killer = i;
					Count = 1;
				} else if (npcs[NPCID].Killing[i] == npcs[NPCID].Killing[Killer]) {
					Count++;
				}
			}
		}
		if (Count > 1 && npcs[NPCID].Killing[npcs[NPCID].StartKilling] == npcs[NPCID].Killing[Killer]) {
			Killer = npcs[NPCID].StartKilling;
		}
		return Killer;
	}

	public int getLevelForXP(int exp) {
		int points = 0;
		int output = 0;

		for (int lvl = 1; lvl <= 135; lvl++) {
			points += Math.floor((double)lvl + 300.0 * Math.pow(2.0, (double)lvl / 7.0));
			output = (int)Math.floor(points / 4);
			if (output >= exp)
				return lvl;
		}
		return 0;
	}
	public boolean GoodDistance(int objectX, int objectY, int playerX, int playerY, int distance) {
		for (int i = 0; i <= distance; i++) {
		  for (int j = 0; j <= distance; j++) {
			if ((objectX + i) == playerX && ((objectY + j) == playerY || (objectY - j) == playerY || objectY == playerY)) {
				return true;
			} else if ((objectX - i) == playerX && ((objectY + j) == playerY || (objectY - j) == playerY || objectY == playerY)) {
				return true;
			} else if (objectX == playerX && ((objectY + j) == playerY || (objectY - j) == playerY || objectY == playerY)) {
				return true;
			}
		  }
		}
		return false;
	}

	public boolean loadAutoSpawn(String FileName) {
		String line = "";
		String token = "";
		String token2 = "";
		String token2_2 = "";
		String[] token3 = new String[10];
		boolean EndOfFile = false;
		int ReadMode = 0;
		BufferedReader characterfile = null;
		try {
			characterfile = new BufferedReader(new FileReader("./"+FileName));
		} catch(FileNotFoundException fileex) {
			Misc.println(FileName+": file not found.");
			return false;
		}
		try {
			line = characterfile.readLine();
		} catch(IOException ioexception) {
			Misc.println(FileName+": error loading file.");
			return false;
		}
		while(EndOfFile == false && line != null) {
			line = line.trim();
			int spot = line.indexOf("=");
			if (spot > -1) {
				token = line.substring(0, spot);
				token = token.trim();
				token2 = line.substring(spot + 1);
				token2 = token2.trim();
				token2_2 = token2.replaceAll("\t\t", "\t");
				token2_2 = token2_2.replaceAll("\t\t", "\t");
				token2_2 = token2_2.replaceAll("\t\t", "\t");
				token2_2 = token2_2.replaceAll("\t\t", "\t");
				token2_2 = token2_2.replaceAll("\t\t", "\t");
				token3 = token2_2.split("\t");
				if (token.equals("spawn")) {
					newNPC(Integer.parseInt(token3[0]), Integer.parseInt(token3[1]), Integer.parseInt(token3[2]), Integer.parseInt(token3[3]), Integer.parseInt(token3[4]), Integer.parseInt(token3[5]), Integer.parseInt(token3[6]), Integer.parseInt(token3[7]), Integer.parseInt(token3[8]), GetNpcListHP(Integer.parseInt(token3[0])), true);
				}
			} else {
				if (line.equals("[ENDOFSPAWNLIST]")) {
					try { characterfile.close(); } catch(IOException ioexception) { }
					return true;
				}
			}
			try {
				line = characterfile.readLine();
			} catch(IOException ioexception1) { EndOfFile = true; }
		}
		try { characterfile.close(); } catch(IOException ioexception) { }
		return false;
	}

	public int GetNpcListHP(int NpcID) {
		for (int i = 0; i < maxListedNPCs; i++) {
			if (NpcList[i] != null) {
				if (NpcList[i].npcId == NpcID) {
					return NpcList[i].npcHealth;
				}
			}
		}
		return 0;
	}

	public boolean loadNPCList(String FileName) {
		String line = "";
		String token = "";
		String token2 = "";
		String token2_2 = "";
		String[] token3 = new String[10];
		boolean EndOfFile = false;
		int ReadMode = 0;
		BufferedReader characterfile = null;
		try {
			characterfile = new BufferedReader(new FileReader("./"+FileName));
		} catch(FileNotFoundException fileex) {
			Misc.println(FileName+": file not found.");
			return false;
		}
		try {
			line = characterfile.readLine();
		} catch(IOException ioexception) {
			Misc.println(FileName+": error loading file.");
			return false;
		}
		while(EndOfFile == false && line != null) {
			line = line.trim();
			int spot = line.indexOf("=");
			if (spot > -1) {
				token = line.substring(0, spot);
				token = token.trim();
				token2 = line.substring(spot + 1);
				token2 = token2.trim();
				token2_2 = token2.replaceAll("\t\t", "\t");
				token2_2 = token2_2.replaceAll("\t\t", "\t");
				token2_2 = token2_2.replaceAll("\t\t", "\t");
				token2_2 = token2_2.replaceAll("\t\t", "\t");
				token2_2 = token2_2.replaceAll("\t\t", "\t");
				token3 = token2_2.split("\t");
				if (token.equals("npc")) {
					newNPCList(Integer.parseInt(token3[0]), token3[1], Integer.parseInt(token3[2]), Integer.parseInt(token3[3]));
				}
			} else {
				if (line.equals("[ENDOFNPCLIST]")) {
					try { characterfile.close(); } catch(IOException ioexception) { }
					return true;
				}
			}
			try {
				line = characterfile.readLine();
			} catch(IOException ioexception1) { EndOfFile = true; }
		}
		try { characterfile.close(); } catch(IOException ioexception) { }
		return false;
	}

	public void println(String str) {
		System.out.println(str);
	}
}