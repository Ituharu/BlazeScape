package com.iClarity.player.magic;

import java.io.*;
import com.iClarity.GameEngine;
import com.iClarity.player.*;
import com.iClarity.misc.*;

public class Magic {


	private static clientHandler p;

	/**
	 * Constructor
	 */
	public Magic(clientHandler p) {
		this.p = p;
	}

	public static void magicSpell(Player player) {
		if (!p.magicOnPlayer) {
			p.setMagicPlayer(true);
		}
		int spellId = p.sID;
		p.AttackingOn = p.pID;
        	clientHandler p2 = (clientHandler) GameEngine.playerHandler.players[p.AttackingOn];

		if (p == null || p2 == null || p.IsDead || p2.IsDead) {
			p.TurnPlayerTo(65535);
			p.ResetAttack();
			return;
		}
		p.usingMagic = true;
		p.TurnPlayerTo(p2.absX, p2.absY);
        	int offsetX = (p.absX - p2.absX) * -1;
        	int offsetY = (p.absY - p2.absY) * -1;
		int casterX = p.absX;
		int casterY = p.absY;
		double spellExp = 0;
		double TotalExp = 0;
		TotalExp = (double)(spellExp * magicAttack(p));
		TotalExp = (double)(TotalExp * p.CombatExpRate);

		Player pl = GameEngine.playerHandler.players[player.playerId];

		if (p.Wild() && p2.Wild() || p.duelArea() && p2.duelArea() || p.duelStatus == 3 && p2.duelStatus == 3) {
			//p.follow(p.attackingPlayerId, player.playerId);
			p.follow(p.attackingPlayerId, 1, 8);
		}
		if (p.duelRule[2]) {
			p.sendMessage("Magic has been disabled for this duel!");
			return;
		}
		if (p.duelStatus == 3 && p.duelStartDelay > 0) {
			return;
		}
		if (p.duelStatus == 3 && p.AttackingOn != p.duelWith) {
			p.sendMessage("You are not dueling this player!");
			p.ResetAttack();
			p.setMagicPlayer(false);
			return;
		}
		if (p.GoodDistance(p2.absX, p2.absY, p.absX, p.absY, 9) == false) {
			return;
		}
		if (!p.multiZone() && !p2.multiZone()) {
			if (p2.combatWith == 0) {
		    		p2.cmbResetTimer = 10;
				p2.combatWith = p.playerId;
			}
		}
		if (!p.multiZone() && !p2.multiZone()) {
			if (p.combatWith != p2.playerId && p.combatWith != 0) {
				p.TurnPlayerTo(p.enemyIndex + 32768);
				p.TurnPlayerTo(65535);
                       		p.stopMovement();
				p.ResetAttack();
				p.sendMessage("You are already in combat.");
				return;
			}
			if (p2.combatWith != p.playerId && p2.combatWith != 0) {
				p.ResetAttack();
                 		p.stopMovement();
                		p.TurnPlayerTo(p2.playerId + 32768);
				p.sendMessage("That player is already in combat.");
				return;
			}
		}
		if (p.Wild() && p2.Wild() || p.duelArea() && p2.duelArea() || p.duelStatus == 3 && p2.duelStatus == 3) {
			p.follow(p.attackingPlayerId, p.playerId);
			p.stopMovement();

			if (p.combatDelay <= 0) {
				p2.combatWith = p.playerId;
				p2.resetCmb = 11;
				p2.inCombat = 13;
				p.inCombat = 13;
				p.setMagicPlayer(false);

				if (p.lastHit != p.AttackingOn) {
					p2.lastHit = p.playerId;
					p.lastHit = p.AttackingOn;
					p.skullTimer = 1200;
					p.SetPkHeadIcon(1);
				}

				if (getRandom(magicAttack(p)) >= getRandom(magicDefence(p2))) {
					p.magicSpellHit = true;
				} else {
					p.magicSpellHit = false;
				}

            			switch (spellId) {


	    				case 12891:
						magicSpell(p, p2, 94, 560, 4, 555, 6, 565, 2, true, 30, 1979, 16, 5, 6);
						break;
                
            				case 12929: // Blood Barrage
						magicSpell(p, p2, 92, 560, 4, 566, 1, 565, 4, false, 0, 1979, 15, 4, 6);
                				break;
                
					case 15: // Shadow Barrage
						magicSpell(p, p2, 88, 560, 4, 566, 3, 565, 2, 556, 4, false, 0, 1979, 14, 4, 6);
                				break;
                
					case 13023: // Smoke Barrage
						magicSpell(p, p2, 86, 560, 4, 554, 4, 565, 2, 556, 4, false, 0, 1979, 13, 4, 6);
						break;
                
					case 12871: // Ice blitz
						magicSpell(p, p2, 82, 560, 2, 555, 3, 565, 2, true, 25, 1978, 12, 7, 7);
						p.gfx0(366);
                				break;
                
				case 12911: // Blood blitz
			p.sendMessage("Temporarily removed.");
                			break;

					case 12881: // Ice Burst
						magicSpell(p, p2, 70, 560, 2, 555, 4, 562, 4, true, 15, 1979, 8, 4, 7);
						break;
                                
					case 1152: // Wind Strike
						if (magicLvl(p) >= 1) {
							if (p.playerEquipment[p.playerWeapon] == 1381 && hasReq(558, 1)) {
								deleteItems(558, 1);
								p.magicSpell[0] = 1;
								p.magicSpell[1] = 0;
								p.combatDelay = 7;
								spellExp = 7;
								p.addSkillXP(15, 6);
								magicCast(casterX, casterY, offsetX, offsetY, 1162, 90, 100, 91, 5, p.attacknpc + 1, 5);
							} else if (hasReq(558, 1) && hasReq(556, 1)) {
								deleteItems(556, 1, 558, 1);
								p.magicSpell[0] = 1;
								p.magicSpell[1] = 0;
								p.combatDelay = 7;
								spellExp = 7;
								p.addSkillXP(15, 6);
								p.addSkillXP(7, 3);
								magicCast(casterX, casterY, offsetX, offsetY, 1162, 90, 100, 91, 5, p.attacknpc + 1, 5);
							} else {
								sendMessage(p, "You dont have the required runes for this spell.");
							}
						} else {
							sendMessage(p, "You need level 1 magic to use this spell.");
						}
						break;

					case 1154: // Water Strike
						if (magicLvl(p) >= 5) {
							if (p.playerEquipment[p.playerWeapon] == 1381 && hasReq(558, 1) && hasReq(555, 1)) {
								deleteItems(558, 1, 555, 1);
								p.magicSpell[0] = 2;
								p.magicSpell[1] = 0;
								p.combatDelay = 7;
								spellExp = 11;
								p.addSkillXP(22, 6);
								p.addSkillXP(11, 3);
								magicCast(casterX, casterY, offsetX, offsetY, 1162, 93, 100, 94, 5, p.attacknpc + 1, 5);
							} else if (p.playerEquipment[p.playerWeapon] == 1383 && hasReq(556, 1) && hasReq(558, 1)) {
								deleteItems(556, 1, 558, 1);
								p.magicSpell[0] = 2;
								p.magicSpell[1] = 0;
								p.combatDelay = 7;
								p.addSkillXP(22, 6);
								p.addSkillXP(11, 3);
								magicCast(casterX, casterY, offsetX, offsetY, 1162, 93, 100, 94, 5, p.attacknpc + 1, 5);
							} else if (p.playerEquipment[p.playerWeapon] == 6563 && hasReq(556, 1) && hasReq(558, 1)) {
								deleteItems(556, 1, 558, 1);
								p.magicSpell[0] = 2;
								p.magicSpell[1] = 0;
								p.combatDelay = 7;
								p.addSkillXP(22, 6);
								p.addSkillXP(11, 3);
								magicCast(casterX, casterY, offsetX, offsetY, 1162, 93, 100, 94, 5, p.attacknpc + 1, 5);
						} else if (hasReq(558, 1) && hasReq(556, 1) && hasReq(555, 1)) {
								deleteItems(556, 1, 558, 1, 555, 1);
								p.magicSpell[0] = 2;
								p.magicSpell[1] = 0;
								p.combatDelay = 7;
								spellExp = 11;
								p.addSkillXP(22, 6);
								p.addSkillXP(11, 3);
								magicCast(casterX, casterY, offsetX, offsetY, 1162, 93, 100, 94, 5, p.attacknpc + 1, 5);
							} else {
                            					sendMessage(p, "You dont have the required runes for this spell.");
   							}
						} else {
							sendMessage(p, "You need level 5 magic to use this spell.");
						}
						break;

					case 1156: // Earth Strike
						if (magicLvl(p) >= 6) {
							if (p.playerEquipment[p.playerWeapon] == 1381 && hasReq(558, 1) && hasReq(557, 2)) {
								deleteItems(558, 1, 557, 2);
								p.magicSpell[0] = 3;
								p.magicSpell[1] = 0;
								p.combatDelay = 7;
								spellExp = 15;
								p.addSkillXP((int)(TotalExp), 6);
								magicCast(casterX, casterY, offsetX, offsetY, 1162, 96, 100, 97, 5, -p.AttackingOn - 1, 4);
							} else if (p.playerEquipment[p.playerWeapon] == 1385 && hasReq(558, 1) && hasReq(556, 1)) {
								deleteItems(558, 1, 556, 1);
								p.magicSpell[0] = 3;
								p.magicSpell[1] = 0;
								p.combatDelay = 7;
								spellExp = 15;
								p.addSkillXP((int)(TotalExp), 6);
								magicCast(casterX, casterY, offsetX, offsetY, 1162, 96, 100, 97, 5, -p.AttackingOn - 1, 4);
							} else if (p.playerEquipment[p.playerWeapon] == 6563 && hasReq(558, 1) && hasReq(556, 1)) {
								deleteItems(558, 1, 556, 1);
								p.magicSpell[0] = 3;
								p.magicSpell[1] = 0;
								p.combatDelay = 7;
								spellExp = 15;
								p.addSkillXP((int)(TotalExp), 6);
								magicCast(casterX, casterY, offsetX, offsetY, 1162, 96, 100, 97, 5, -p.AttackingOn - 1, 4);
							} else if (hasReq(558, 1) && hasReq(556, 2) && hasReq(557, 2)) {
								deleteItems(556, 1, 558, 1, 557, 2);
								p.magicSpell[0] = 3;
								p.magicSpell[1] = 0;
								p.combatDelay = 7;
								spellExp = 15;
								p.addSkillXP((int)(TotalExp), 6);
								magicCast(casterX, casterY, offsetX, offsetY, 1162, 96, 100, 97, 5, -p.AttackingOn - 1, 4);
							} else {
								sendMessage(p, "You dont have the required runes for this spell.");
  							}
						} else {
							sendMessage(p, "You need level 6 magic to use this spell.");
						}
						break;

					case 1158: // Fire Strike
						if (magicLvl(p) >= 9) {
							if (p.playerEquipment[p.playerWeapon] == 1381 && hasReq(558, 1) && hasReq(554, 3)) {
								deleteItems(558, 1, 554, 3);
								p.magicSpell[0] = 4;
								p.magicSpell[1] = 0;
								p.combatDelay = 7;
								spellExp = 19;
								p.addSkillXP((int)(TotalExp), 6);
								magicCast(casterX, casterY, offsetX, offsetY, 1162, 99, 100, 100, 5, -p.AttackingOn - 1, 4);
							} else if (p.playerEquipment[p.playerWeapon] == 1387 && hasReq(558, 1) && hasReq(556, 2)) {
								deleteItems(556, 2, 558, 1);
								p.magicSpell[0] = 4;
								p.magicSpell[1] = 0;
								p.combatDelay = 7;
								spellExp = 19;
								p.addSkillXP((int)(TotalExp), 6);
								magicCast(casterX, casterY, offsetX, offsetY, 1162, 99, 100, 100, 5, -p.AttackingOn - 1, 4);
							} else if (p.playerEquipment[p.playerWeapon] == 3054 && hasReq(558, 1) && hasReq(556, 2)) {
								deleteItems(556, 2, 558, 1);
								p.magicSpell[0] = 4;
								p.magicSpell[1] = 0;
								p.combatDelay = 7;
								spellExp = 19;
								p.addSkillXP((int)(TotalExp), 6);
								magicCast(casterX, casterY, offsetX, offsetY, 1162, 99, 100, 100, 5, -p.AttackingOn - 1, 4);
 							} else if (hasReq(558, 1) && hasReq(556, 2) && hasReq(554, 3)) {
                            					deleteItems(556, 2, 558, 1, 554, 3);
								p.magicSpell[0] = 4;
								p.magicSpell[1] = 0;
								p.combatDelay = 7;
								spellExp = 19;
								p.addSkillXP((int)(TotalExp), 6);
								magicCast(casterX, casterY, offsetX, offsetY, 1162, 99, 100, 100, 5, -p.AttackingOn - 1, 4);
							} else {
                            					sendMessage(p, "You dont have the required runes for this spell.");
                        				}
                    				} else {
                        				sendMessage(p, "You need level 9 magic to use this spell.");
                    				}
               					break;

            				case 1160: // Wind Bolt
                    				if (magicLvl(p) >= 17) {
                        				if (p.playerEquipment[p.playerWeapon] == 1381 && hasReq(562, 1)) {
                            					deleteItems(562, 1);
								p.magicSpell[0] = 5;
								p.magicSpell[1] = 0;
								p.combatDelay = 7;
								spellExp = 22;
								p.addSkillXP((int)(TotalExp), 6);
								magicCast(casterX, casterY, offsetX, offsetY, 1162, 117, 100, 118, 5, -p.AttackingOn - 1, 4);
										} else if (hasReq(562, 1) && hasReq(556, 2)) {
                            					deleteItems(562, 1, 556, 2);
								p.magicSpell[0] = 5;
								p.magicSpell[1] = 0;
								p.combatDelay = 7;
								spellExp = 22;
								p.addSkillXP((int)(TotalExp), 6);
								magicCast(casterX, casterY, offsetX, offsetY, 1162, 117, 100, 118, 5, -p.AttackingOn - 1, 4);
                        				} else {
                            					sendMessage(p, "You dont have the required runes for this spell.");
                       					}
                    				} else {
                        				sendMessage(p, "You need level 17 magic to use this spell.");
                    				}
                				break;

            				case 1163: // Water Bolt
                    				if (magicLvl(p) >= 20) {
                       					if (p.playerEquipment[p.playerWeapon] == 1381 && hasReq(562, 1) && hasReq(555, 2)) {
                            					deleteItems(562, 1, 555, 2);
								p.magicSpell[0] = 6;
								p.magicSpell[1] = 0;
								p.combatDelay = 7;
								spellExp = 26;
								p.addSkillXP((int)(TotalExp), 6);
								magicCast(casterX, casterY, offsetX, offsetY, 1162, 120, 100, 121, 5, -p.AttackingOn - 1, 4);
										} else if (p.playerEquipment[p.playerWeapon] == 1383 && hasReq(562, 1) && hasReq(556, 2)) {
                            					deleteItems(562, 1, 556, 2);
								p.magicSpell[0] = 6;
								p.magicSpell[1] = 0;
								p.combatDelay = 7;
								spellExp = 26;
								p.addSkillXP((int)(TotalExp), 6);
								magicCast(casterX, casterY, offsetX, offsetY, 1162, 120, 100, 121, 5, -p.AttackingOn - 1, 4);
										} else if (p.playerEquipment[p.playerWeapon] == 6563 && hasReq(562, 1) && hasReq(556, 2)) {
                            					deleteItems(562, 1, 556, 2);
								p.magicSpell[0] = 6;
								p.magicSpell[1] = 0;
								p.combatDelay = 7;
								spellExp = 26;
								p.addSkillXP((int)(TotalExp), 6);
								magicCast(casterX, casterY, offsetX, offsetY, 1162, 120, 100, 121, 5, -p.AttackingOn - 1, 4);
										} else if (hasReq(562, 1) && hasReq(556, 2) && hasReq(555, 2)) {
                            					deleteItems(562, 1, 556, 2, 555, 2);
								p.magicSpell[0] = 6;
								p.magicSpell[1] = 0;
								p.combatDelay = 7;
								spellExp = 26;
								p.addSkillXP((int)(TotalExp), 6);
								magicCast(casterX, casterY, offsetX, offsetY, 1162, 120, 100, 121, 5, -p.AttackingOn - 1, 4);
                        				} else {
                            					sendMessage(p, "You dont have the required runes for this spell.");
                        				}
                    				} else {
                        				sendMessage(p, "You need level 20 magic to use this spell.");
                    				}
               					break;

            				case 1166: // Earth Bolt
                    				if (magicLvl(p) >= 29) {
                       					if (p.playerEquipment[p.playerWeapon] == 1381 && hasReq(562, 1) && hasReq(557, 3)) {
                            					deleteItems(562, 1, 557, 3);
								p.magicSpell[0] = 7;
								p.magicSpell[1] = 0;
								p.combatDelay = 7;
								spellExp = 30;
								p.addSkillXP((int)(TotalExp), 6);
								magicCast(casterX, casterY, offsetX, offsetY, 1162, 123, 100, 124, 5, -p.AttackingOn - 1, 4);
										} else if (p.playerEquipment[p.playerWeapon] == 1385 && hasReq(556, 2) && hasReq(562, 1)) {
                            					deleteItems(562, 1, 556, 2);
								p.magicSpell[0] = 7;
								p.magicSpell[1] = 0;
								p.combatDelay = 7;
								spellExp = 30;
								p.addSkillXP((int)(TotalExp), 6);
								magicCast(casterX, casterY, offsetX, offsetY, 1162, 123, 100, 124, 5, -p.AttackingOn - 1, 4);
										} else if (p.playerEquipment[p.playerWeapon] == 3054 && hasReq(556, 2) && hasReq(562, 1)) {
                            					deleteItems(562, 1, 556, 2);
								p.magicSpell[0] = 7;
								p.magicSpell[1] = 0;
								p.combatDelay = 7;
								spellExp = 30;
								p.addSkillXP((int)(TotalExp), 6);
								magicCast(casterX, casterY, offsetX, offsetY, 1162, 123, 100, 124, 5, -p.AttackingOn - 1, 4);
										} else if (p.playerEquipment[p.playerWeapon] == 6563 && hasReq(556, 2) && hasReq(562, 1)) {
                            					deleteItems(562, 1, 556, 2);
								p.magicSpell[0] = 7;
								p.magicSpell[1] = 0;
								p.combatDelay = 7;
								spellExp = 30;
								p.addSkillXP((int)(TotalExp), 6);
								magicCast(casterX, casterY, offsetX, offsetY, 1162, 123, 100, 124, 5, -p.AttackingOn - 1, 4);
										} else if (hasReq(562, 1) && hasReq(556, 2) && hasReq(557, 3)) {
                            					deleteItems(562, 1, 556, 2, 557, 3);
								p.magicSpell[0] = 7;
								p.magicSpell[1] = 0;
								p.combatDelay = 7;
								spellExp = 30;
								p.addSkillXP((int)(TotalExp), 6);
								magicCast(casterX, casterY, offsetX, offsetY, 1162, 123, 100, 124, 5, -p.AttackingOn - 1, 4);
                        				} else {
                            					sendMessage(p, "You dont have the required runes for this spell.");
                        				}
                   				} else {
                        				sendMessage(p, "You need level 29 magic to use this spell.");
                    				}
                				break;

            				case 1169: // Fire Bolt
                   				if (magicLvl(p) >= 35) {
                        				if (p.playerEquipment[p.playerWeapon] == 1381 && hasReq(554, 3) && hasReq(562, 1)) {
                            					deleteItems(562, 1, 554, 3);
								p.magicSpell[0] = 8;
								p.magicSpell[1] = 0;
								p.combatDelay = 7;
								spellExp = 34;
								p.addSkillXP((int)(TotalExp), 6);
								magicCast(casterX, casterY, offsetX, offsetY, 1162, 126, 100, 127, 5, -p.AttackingOn - 1, 4);
										} else if (p.playerEquipment[p.playerWeapon] == 1387 && hasReq(556, 2) && hasReq(562, 1)) {
                            					deleteItems(562, 1, 556, 2);
								p.magicSpell[0] = 8;
								p.magicSpell[1] = 0;
								p.combatDelay = 7;
								spellExp = 34;
								p.addSkillXP((int)(TotalExp), 6);
								magicCast(casterX, casterY, offsetX, offsetY, 1162, 126, 100, 127, 5, -p.AttackingOn - 1, 4);
										} else if (p.playerEquipment[p.playerWeapon] == 3054 && hasReq(556, 2) && hasReq(562, 1)) {
                            					deleteItems(562, 1, 556, 2);
								p.magicSpell[0] = 8;
								p.magicSpell[1] = 0;
								p.combatDelay = 7;
								spellExp = 34;
								p.addSkillXP((int)(TotalExp), 6);
								magicCast(casterX, casterY, offsetX, offsetY, 1162, 126, 100, 127, 5, -p.AttackingOn - 1, 4);
										} else if (hasReq(562, 1) && hasReq(556, 2) && hasReq(554, 3)) {
                            					deleteItems(562, 1, 556, 2, 554, 3);
								p.magicSpell[0] = 8;
								p.magicSpell[1] = 0;
								p.combatDelay = 7;
								spellExp = 34;
								p.addSkillXP((int)(TotalExp), 6);
								magicCast(casterX, casterY, offsetX, offsetY, 1162, 126, 100, 127, 5, -p.AttackingOn - 1, 4);
                        				} else {
                            					sendMessage(p, "You dont have the required runes for this spell.");
                        				}
                    				} else {
                        				sendMessage(p, "You need level 35 magic to use this spell.");
                    				}
                				break;

            				case 1172: // Wind Blast
                    				if (magicLvl(p) >= 41) {
                        				if (hasReq(560, 1) && hasReq(556, 3)) {
                            					deleteItems(560, 1, 556, 3);
								p.magicSpell[0] = 9;
								p.magicSpell[1] = 0;
								p.combatDelay = 7;
								spellExp = 38;
								p.addSkillXP((int)(TotalExp), 6);
								magicCast(casterX, casterY, offsetX, offsetY, 1162, 132, 100, 133, 5, -p.AttackingOn - 1, 4);
                        				} else {
                            					sendMessage(p, "You dont have the required runes for this spell.");
                        				}
                    				} else {
                        				sendMessage(p, "You need level 41 magic to use this spell.");
                    				}
                				break;

            				case 1175: // Water Blast
                    				if (magicLvl(p) >= 47) {
                        				if (hasReq(560, 1) && hasReq(556, 3) && hasReq(555, 3)) {
                            					deleteItems(560, 1, 556, 3, 555, 3);
								p.magicSpell[0] = 10;
								p.magicSpell[1] = 0;
								p.combatDelay = 7;
								spellExp = 42;
								p.addSkillXP((int)(TotalExp), 6);
								magicCast(casterX, casterY, offsetX, offsetY, 1162, 135, 100, 136, 5, -p.AttackingOn - 1, 4);
                        				} else {
                            					sendMessage(p, "You dont have the required runes for this spell.");
                        				}
                    				} else {
                        				sendMessage(p, "You need level 47 magic to use this spell.");
                    				}
                				break;

            				case 1177: // Earth Blast
                    				if (magicLvl(p) >= 51) {
                        				if (hasReq(560, 1) && hasReq(556, 3) && hasReq(557, 4)) {
                            					deleteItems(560, 1, 556, 3, 557, 4);
								p.magicSpell[0] = 11;
								p.magicSpell[1] = 0;
								p.combatDelay = 7;
								spellExp = 46;
								p.addSkillXP((int)(TotalExp), 6);
								magicCast(casterX, casterY, offsetX, offsetY, 1162, 138, 100, 139, 5, -p.AttackingOn - 1, 4);
                        				} else {
                            					sendMessage(p, "You dont have the required runes for this spell.");
                        				}
                    				} else {
                        				sendMessage(p, "You need level 51 magic to use this spell.");
                    				}
                				break;

            				case 1181: // Fire Blast
                    				if (magicLvl(p) >= 59) {
                        				if (hasReq(560, 1) && hasReq(556, 4) && hasReq(554, 5)) {
                            					deleteItems(560, 1, 556, 4, 554, 5);
								p.magicSpell[0] = 12;
								p.magicSpell[1] = 0;
								p.combatDelay = 7;
								spellExp = 50;
								p.addSkillXP((int)(TotalExp), 6);
								magicCast(casterX, casterY, offsetX, offsetY, 1162, 129, 100, 130, 5, -p.AttackingOn - 1, 4);
                        				} else {
                            					sendMessage(p, "You dont have the required runes for this spell.");
                        				}
                    				} else {
                        				sendMessage(p, "You need level 59 magic to use this spell.");
                    				}
                				break;

            				case 1183: // Wind Wave
                    				if (magicLvl(p) >= 62) {
                        				if (hasReq(565, 1) && hasReq(556, 5)) {
                            					deleteItems(565, 1, 556, 5);
								p.magicSpell[0] = 13;
								p.magicSpell[1] = 0;
								p.combatDelay = 7;
								spellExp = 53;
								p.addSkillXP((int)(TotalExp), 6);
								magicCast(casterX, casterY, offsetX, offsetY, 1167, 158, 100, 159, 5, -p.AttackingOn - 1, 4);
                        				} else {
                            					sendMessage(p, "You dont have the required runes for this spell.");
                        				}
                    				} else {
                       					sendMessage(p, "You need level 62 magic to use this spell.");
                    				}
                				break;

            				case 1185: // Water Wave
                    				if (magicLvl(p) >= 65) {
                        				if (hasReq(565, 1) && hasReq(556, 5) && hasReq(555, 7)) {
                            					deleteItems(565, 1, 556, 5, 555, 7);
								p.magicSpell[0] = 14;
								p.magicSpell[1] = 0;
								p.combatDelay = 7;
								spellExp = 55;
								p.addSkillXP((int)(TotalExp), 6);
								magicCast(casterX, casterY, offsetX, offsetY, 1167, 161, 100, 162, 5, -p.AttackingOn - 1, 4);
                        				} else {
                            					sendMessage(p, "You dont have the required runes for this spell.");
                       					}
                    				} else {
                        				sendMessage(p, "You need level 65 magic to use this spell.");
                    				}
                				break;

            				case 1188: // Earth Wave
                    				if (magicLvl(p) >= 70) {
                        				if (hasReq(565, 1) && hasReq(556, 5) && hasReq(557, 7)) {
                            					deleteItems(565, 1, 556, 5, 557, 7);
								p.magicSpell[0] = 15;
								p.magicSpell[1] = 0;
								p.combatDelay = 7;
								spellExp = 59;
								p.addSkillXP((int)(TotalExp), 6);
								magicCast(casterX, casterY, offsetX, offsetY, 1167, 164, 100, 165, 5, -p.AttackingOn - 1, 4);
                        				} else {
                            					sendMessage(p, "You dont have the required runes for this spell.");
                        				}
                    				} else {
                        				sendMessage(p, "You need level 70 magic to use this spell.");
                    				}
                				break;

            				case 1189: // Fire Wave
                    				if (magicLvl(p) >= 75) {
                        				if (hasReq(565, 1) && hasReq(556, 5) && hasReq(554, 7)) {
                            					deleteItems(565, 1, 556, 5, 554, 7);
								p.magicSpell[0] = 16;
								p.magicSpell[1] = 0;
								p.combatDelay = 7;
								spellExp = 62;
								p.addSkillXP((int)(TotalExp), 6);
								magicCast(casterX, casterY, offsetX, offsetY, 1167, 155, 100, 156, 5, -p.AttackingOn - 1, 4);
                        				} else {
                            					sendMessage(p, "You dont have the required runes for this spell.");
                        				}
                    				} else {
                        				sendMessage(p, "You need level 75 magic to use this spell.");
                    				}
                				break;              
                
            				case 1572: // Bind
                    				if (magicLvl(p) >= 21) {
                        				if (hasReq(561, 2) && hasReq(555, 3) && hasReq(557, 3)) {
			    					if (getRandom(magicAttack(p)) >= getRandom(magicDefence(p2))) {
									p2.stopMovement();
									p2.freezeDelay = 6;
			    					}
								p.magicSpell[0] = 18;
								p.magicSpell[1] = 0;
								p.combatDelay = 7;
								p.addSkillXP((30 * 90), 6);
								spellExp = 30;
								magicCast(casterX, casterY, offsetX, offsetY, 1161, 177, 100, 178, 5, -p.AttackingOn - 1, 4);
                        				} else {
                            					sendMessage(p, "You dont have the required runes for this spell.");
                        				}
                    				} else {			
                        				sendMessage(p, "You need level 21 magic to use this spell.");
                    				}
                				break;

            				case 1582: // Snare
                    				if (magicLvl(p) >= 50) {
                        				if (hasReq(561, 3) && hasReq(555, 4) && hasReq(557, 4)) {
			    					if (getRandom(magicAttack(p)) >= getRandom(magicDefence(p2))) {
									p2.stopMovement();
									p2.freezeDelay = 15;
			    					}
                            					deleteItems(561, 3, 555, 4, 557, 4);
								p.magicSpell[0] = 19;
								p.magicSpell[1] = 0;
								p.combatDelay = 7;
								p.addSkillXP((60 * 90), 6);
								spellExp = 60;
								magicCast(casterX, casterY, offsetX, offsetY, 1161, 177, 100, 178, 5, -p.AttackingOn - 1, 4);
                        				} else {
                            					sendMessage(p, "You dont have the required runes for this spell.");
                        				}
                    				} else {
                        				sendMessage(p, "You need level 50 magic to use this spell.");
                    				}
               					break;

            				case 1592: // Entangle
                    				if (magicLvl(p) >= 79) {
                        				if (hasReq(561, 4) && hasReq(555, 5) && hasReq(557, 5)) {
			    					if (getRandom(magicAttack(p)) >= getRandom(magicDefence(p2))) {
									p2.stopMovement();
									p2.freezeDelay = 20;
			    					}
                            					deleteItems(561, 4, 555, 5, 557, 5);
								p.magicSpell[0] = 20;
								p.magicSpell[1] = 0;
								p.combatDelay = 7;
								p.addSkillXP((89 * 90), 6);
								spellExp = 91;
								magicCast(casterX, casterY, offsetX, offsetY, 1161, 177, 100, 178, 5, -p.AttackingOn - 1, 4);
                        				} else {
                            					sendMessage(p, "You dont have the required runes for this spell.");
                        				}
                    				} else {
                        				sendMessage(p, "You need level 79 magic to use this spell.");
                    				}
                				break;

            				case 1190: // Saradomin Strike
                   				if (magicLvl(p) >= 60) {
                      					if (hasReq(554, 4) && hasReq(565, 2) && hasReq(556, 1)) {
                         					if (pl.playerEquipment[3] == 2415) {
                            						if (pl.playerEquipment[1] != 2413 && pl.playerEquipment[1] != 2414 && pl.playerEquipment[3] != 2416 && pl.playerEquipment[1] != 2417) {
                            							deleteItems(554, 4, 565, 2, 556, 1);
										p.magicSpell[0] = 21;
										p.magicSpell[1] = 0;
										p.combatDelay = 7;
										p.magicDmgDelay = 3;
										p.magicDelay = 3;
										p.startAnimation(811);
										p.updateRequired = true;
										p.appearanceUpdateRequired = true;
										spellExp = 65;
										p.addSkillXP((int)(TotalExp), 6);
                            						} else {
                            	      						sendMessage(p, "You cannot be wearing the cape or staff of another god while using this spell.");
                            						}
                         					} else {
                            	   					sendMessage(p, "You need to be wielding a Saradomin staff to cast this spell.");
                         					}
                      					} else {
                            					sendMessage(p, "You dont have the required runes for this spell.");
                      					}
                   				} else {
                        				sendMessage(p, "You need level 60 magic to use this spell.");
                   				}
                				break;

            				case 1191: // Claws of Guthix
                   				if (magicLvl(p) >= 60) {
                      					if (hasReq(554, 1) && hasReq(565, 2) && hasReq(556, 4)) {
                         					if (pl.playerEquipment[3] == 2416) {
                            						if (pl.playerEquipment[1] != 2412 && pl.playerEquipment[1] != 2414 && pl.playerEquipment[3] != 2415 && pl.playerEquipment[1] != 2417) {
                            							deleteItems(554, 1, 565, 2, 556, 4);
										p.magicSpell[0] = 22;
										p.magicSpell[1] = 0;
										p.combatDelay = 7;
										p.magicDmgDelay = 3;
										p.magicDelay = 3;
										p.startAnimation(811);
										p.updateRequired = true;
										p.appearanceUpdateRequired = true;
										spellExp = 65;
										p.addSkillXP((int)(TotalExp), 6);
                            						} else {
                            	      						sendMessage(p, "You cannot be wearing the cape or staff of another god while using this spell.");
                           						}
                        					} else {
                            	   					sendMessage(p, "You need to be wielding a Guthix staff to cast this spell.");
                         					}
                      					} else {
                            					sendMessage(p, "You dont have the required runes for this spell.");
                      					}
                   				} else {
                        				sendMessage(p, "You need level 60 magic to use this spell.");
                   				}
                				break;

            				case 1192: // Flames of Zamorak
                   				if (magicLvl(p) >= 60) {
                      					if (hasReq(554, 2) && hasReq(565, 2) && hasReq(556, 4)) {
                         					if (pl.playerEquipment[3] == 2417) {
                            						if (pl.playerEquipment[1] != 2412 && pl.playerEquipment[1] != 2413 && pl.playerEquipment[3] != 2415 && pl.playerEquipment[1] != 2416) {
                            							deleteItems(554, 2, 565, 2, 556, 4);
										p.magicSpell[0] = 23;
										p.magicSpell[1] = 0;
										p.combatDelay = 7;
										p.magicDmgDelay = 3;
										p.magicDelay = 3;
										p.startAnimation(811);
										p.updateRequired = true;
										p.appearanceUpdateRequired = true;
										spellExp = 65;
										p.addSkillXP((int)(TotalExp), 6);
                            						} else {
                            	      						sendMessage(p, "You cannot be wearing the cape or staff of another god while using this spell.");
                            						}
                         					} else {
                            	  					sendMessage(p, "You need to be wielding a Zamorak staff to cast this spell.");
                         					}
                      					} else {
                            					sendMessage(p, "You dont have the required runes for this spell.");
                      					}
                   				} else {
                        				sendMessage(p, "You need level 60 magic to use this spell.");
                   				}
                				break;

            				case 1153: // Confuse
	     					if (p2.playerLevel[0] >= p2.getLevelForXP(p2.playerXP[0])) {
                    					if (magicLvl(p) >= 3) {
                        					if (hasReq(559, 1) && hasReq(555, 1) && hasReq(557, 1)) {
                            						deleteItems(559, 1, 555, 1, 557, 1);
									p.magicSpell[0] = 24;
									p.magicSpell[1] = 0;
									p.combatDelay = 7;
									p.addSkillXP((13 * 300), 6);
									spellExp = 13;
									magicCast(casterX, casterY, offsetX, offsetY, 1163, 102, 100, 103, 7, -p.AttackingOn - 1, 4);
                        					} else {
                            						sendMessage(p, "You dont have the required runes for this spell.");
                        					}
                    					} else {
                        					sendMessage(p, "You need level 3 magic to use this spell.");
                    					}
	      					} else {
							sendMessage(p, "The opponents attack has already been lowered.");
	      					}
                				break;

					case 1157: // Weaken
	      					if (p2.playerLevel[1] >= p2.getLevelForXP(p2.playerXP[1])) {
                    					if (magicLvl(p) >= 11) {
                        					if (hasReq(559, 1) && hasReq(555, 3) && hasReq(557, 2)) {
                            						deleteItems(559, 1, 555, 3, 557, 2);
									p.magicSpell[0] = 25;
									p.magicSpell[1] = 0;
									p.combatDelay = 7;
									p.addSkillXP((13 * 300), 6);
									spellExp = 21;
									magicCast(casterX, casterY, offsetX, offsetY, 1164, 105, 100, 106, 7, -p.AttackingOn - 1, 4);
                        					} else {
                            						sendMessage(p, "You dont have the required runes for this spell.");
								}
                    					} else {
                        					sendMessage(p, "You need level 11 magic to use this spell.");
                    					}
	      					} else {
							sendMessage(p, "The opponents attack has already been lowered.");
	      					}
                				break;

            				case 1161: // Curse
	      					if (p2.playerLevel[2] >= p2.getLevelForXP(p2.playerXP[2])) {
                    					if (magicLvl(p) >= 19) {
                        					if (hasReq(559, 1) && hasReq(555, 2) && hasReq(557, 3)) {
                            						deleteItems(559, 1, 555, 2, 557, 3);
									p.magicSpell[0] = 26;
									p.magicSpell[1] = 0;
									p.combatDelay = 7;
									p.addSkillXP((21 * 300), 6);
									spellExp = 29;
									magicCast(casterX, casterY, offsetX, offsetY, 1165, 108, 100, 109, 7, -p.AttackingOn - 1, 4);
                        					} else {
                            						sendMessage(p, "You dont have the required runes for this spell.");
                        					}
                    					} else {
                        					sendMessage(p, "You need level 19 magic to use this spell.");
                    					}
	      					} else {
							sendMessage(p, "The opponents attack has already been lowered.");
	      					}
                				break;

            				case 1539: // Iban blast
                    				if (magicLvl(p) >= 50) {
                        				if (hasReq(561, 4) && hasReq(555, 5) && hasReq(557, 5)) {
                         					if (pl.playerEquipment[3] == 1409) {
                            						deleteItems(554, 5, 560, 1);
									p.magicSpell[0] = 27;
									p.magicSpell[1] = 0;
									p.combatDelay = 7;
									spellExp = 30;
									p.addSkillXP((int)(TotalExp), 6);
									magicCast(casterX, casterY, offsetX, offsetY, 708, 87, 100, 88, 5, -p.AttackingOn - 1, 4);
                         					} else {
                            	   					sendMessage(p, "You need to be wielding an Iban staff to cast this spell.");
                         					}
                        				} else {
                            					sendMessage(p, "You dont have the required runes for this spell.");
                        				}
                    				} else {
                        				sendMessage(p, "You need level 50 magic to use this spell.");
                    				}
                				break;

            				case 1542: // Vulnerability
	      					if (p2.playerLevel[1] >= p2.getLevelForXP(p2.playerXP[1])) {
                    					if (magicLvl(p) >= 66) {
                        					if (hasReq(557, 5) && hasReq(555, 5) && hasReq(566, 1)) {
                            						deleteItems(557, 5, 555, 5, 566, 1);
									p.magicSpell[0] = 28;
									p.magicSpell[1] = 0;
									p.combatDelay = 7;
									p.addSkillXP((76 * 300), 6);
									spellExp = 76;
									magicCast(casterX, casterY, offsetX, offsetY, 1166, 167, 100, 168, 7, -p.AttackingOn - 1, 4);
                        					} else {
                            						sendMessage(p, "You dont have the required runes for this spell.");
                        					}
                    					} else {
                        					sendMessage(p, "You need level 66 magic to use this spell.");
                    					}
	      					} else {
							sendMessage(p, "The opponents attack has already been lowered.");
	     					}
                				break;

            				case 1543: // Enfeeble
	      					if (p2.playerLevel[2] >= p2.getLevelForXP(p2.playerXP[2])) {
                    					if (magicLvl(p) >= 73) {
                        					if (hasReq(557, 8) && hasReq(555, 8) && hasReq(566, 1)) {
                            						deleteItems(557, 8, 555, 8, 566, 1);
									p.magicSpell[0] = 29;
									p.magicSpell[1] = 0;
									p.combatDelay = 7;
									p.addSkillXP((83 * 300), 6);
									spellExp = 83;
									magicCast(casterX, casterY, offsetX, offsetY, 1167, 170, 100, 171, 7, -p.AttackingOn - 1, 4);
                        					} else {	
					                            	sendMessage(p, "You dont have the required runes for this spell.");
                        					}
                    					} else {
                        					sendMessage(p, "You need level 73 magic to use this spell.");
                    					}
	      					} else {
							sendMessage(p, "The opponents attack has already been lowered.");
	      					}
                				break;

            				case 1562: // Stun
	      					if (p2.playerLevel[0] >= p2.getLevelForXP(p2.playerXP[0])) {
                					if (magicLvl(p) >= 80) {
                        					if (hasReq(557, 12) && hasReq(555, 12) && hasReq(566, 1)) {
                            						deleteItems(557, 12, 555, 12, 566, 1);
									p.magicSpell[0] = 30;
									p.magicSpell[1] = 0;
									p.combatDelay = 7;
									p.addSkillXP(90, 6);
									spellExp = 90;
									magicCast(casterX, casterY, offsetX, offsetY, 1167, 173, 100, 174, 7, -p.AttackingOn - 1, 4);
                       						} else {
                            						sendMessage(p, "You dont have the required runes for this spell.");
                        					}
                    					} else {
                        					sendMessage(p, "You need level 80 magic to use this spell.");
                    					}
	      					} else {
							sendMessage(p, "The opponents attack has already been lowered.");
	      					}
                				break;

            				case 12445: // Teleblock
                    				if (magicLvl(p) >= 85) {
                        				if (hasReq(563, 1) && hasReq(562, 1) && hasReq(560, 1)) {
                            					deleteItems(563, 1, 563, 1, 560, 1);
								p.magicSpell[0] = 31;
								p.magicSpell[1] = 0;
								p.combatDelay = 7;
								p.addSkillXP(80, 6);
								magicCast(casterX, casterY, offsetX, offsetY, 1819, -1, 100, 344, 7, -p.AttackingOn - 1, 4);
                       					} else {
                            					sendMessage(p, "You dont have the required runes for this spell.");
                        				}
                    				} else {
                        				sendMessage(p, "You need level 85 magic to use this spell.");
                    				}
                				break;

            				case 12037: // Slayer dart
                    				if (magicLvl(p) >= 50) {
                        				if (hasReq(558, 4) && hasReq(560, 1)) {
                         					if (p.playerEquipment[3] == 4170) {
                            						deleteItems(560, 1, 558, 4);
									p.magicSpell[0] = 32;
									p.magicSpell[1] = 0;
									p.combatDelay = 6;
									spellExp = 30;
									p.addSkillXP((int)(TotalExp), 6);
									magicCast(casterX, casterY, offsetX, offsetY, 1576, -1, -1, 328, 7, -p.AttackingOn - 1, 4);
                         					} else {
                            	   					sendMessage(p, "You need to be wielding a Slayer's staff to cast this spell.");
                         					}
                        				} else {
                            					sendMessage(p, "You dont have the required runes for this spell.");
                        				}
                    				} else {
                        				sendMessage(p, "You need level 85 magic to use this spell.");
                    				}
                				break;

					default:
						System.out.println("Magic SpellID: " + spellId + ".");
						break;
				}
			}
		}
	}

	public static void createMagicDamageEvent(Player player) {
		clientHandler p2 = (clientHandler) GameEngine.playerHandler.players[p.AttackingOn];

		if (p == null || p2 == null || p.IsDead || p2.IsDead) {
			resetMagic();
			return;
		}
		if (p.magicDmgDelay == 3) {
			switch (p.magicSpell[1]) {

				case 12:
			    		if (p.magicSpellHit) {
						p2.gfx0(367);
						p2.startAnimation(p2.GetBlockAnim());
					} else {
						p2.startAnimation(p2.GetBlockAnim());
						p2.gfx100(85);
					}
				break;
			}
		}
		if (p.magicDmgDelay == 1) {
			switch (p.magicSpell[1]) {
				case 8:
			    		if (p.magicSpellHit) {
						p2.gfx0(363);
						p2.startAnimation(p2.GetBlockAnim());
					} else {
						p2.startAnimation(p2.GetBlockAnim());
						p2.gfx100(85);
					}
				break;

				case 16:
			    		if (p.magicSpellHit) {
						p2.gfx0(369);
						p2.startAnimation(p2.GetBlockAnim());
					} else {
						p2.startAnimation(p2.GetBlockAnim());
						p2.gfx100(85);
					}
				break;
			}
		}
		if (p.magicDmgDelay == 0) {
			switch (p.magicSpell[0]) {

				case 1: // Wind strike
					magicHit(p2, 92, 2, true);
					break;

				case 2: // Water strike
					magicHit(p2, 95, 4, true);
					break;

				case 3: // Earth strike
					magicHit(p2, 98, 6, true);
					break;

				case 4: // Fire strike
					magicHit(p2, 101, 8, true);
					break;

				case 5: // Wind bolt
					magicHit(p2, 119, 9, true);
			    		break;

				case 6: // Water bolt
					magicHit(p2, 122, 10, true);
			    		break;

				case 7: // Earth bolt
					magicHit(p2, 125, 11, true);
			    		break;

				case 8: // Fire bolt
					magicHit(p2, 128, 12, true);
			    		break;

				case 9: // Wind blast
					magicHit(p2, 134, 13, true);
			    		break;

				case 10: // Water blast
					magicHit(p2, 137, 14, true);
			    		break;

				case 11: // Earth blast
					magicHit(p2, 140, 15, true);
			    		break;

				case 12: // Fire blast
					magicHit(p2, 131, 16, true);
			    		break;

				case 13: // Wind wave
					magicHit(p2, 160, 17, true);
			    		break;

				case 14: // Water wave
					magicHit(p2, 163, 18, true);
			    		break;

				case 15: // Earth wave
					magicHit(p2, 166, 19, true);
			    		break;

				case 16: // Fire wave
					magicHit(p2, 157, 20, true);
			    		break;

				case 18: // Bind
					magicHit(p2, 181, 2, true);
					p2.freezeDelay = 6;
					p2.stopMovement();
					break;

				case 19: // Snare
					magicHit(p2, 180, 3, true);
			    		p2.freezeDelay = 6;
					p2.stopMovement();
					break;

				case 20: // Entangle
					magicHit(p2, 179, 5, true);
			    		p2.freezeDelay = 20;
					p2.stopMovement();
					break;

				case 21: // Saradomin Strike
					magicHit(p2, 76, p.charge ? 30 : 20, true);
			    		break;

				case 22: // Claws of Guthix
					magicHit(p2, 77, p.charge ? 30 : 20, true);
			    		break;

				case 23: // Flames of Zamorak
					magicHit(p2, 78, p.charge ? 30 : 20, true);
			    		break;

				case 24: // Confuse
			    		if (p.magicSpellHit) {
						p.magicSpellHit = false;
						p2.gfx100(104);
						p2.playerLevel[0] -= (p2.playerLevel[0] * 0.05);
						p2.setSkillLevel(0, p2.playerLevel[0], p2.playerXP[0]);
						p2.startAnimation(p2.GetBlockAnim());
					} else {
						p2.startAnimation(p2.GetBlockAnim());
						p2.gfx100(85);
					}
				break;

				case 25: // Weaken
			    		if (p.magicSpellHit) {
						p.magicSpellHit = false;
						p2.gfx100(107);
						p2.playerLevel[1] -= (p2.playerLevel[1] * 0.05);
						p2.setSkillLevel(1, p2.playerLevel[1], p2.playerXP[1]);
						p2.startAnimation(p2.GetBlockAnim());
					} else {
						p2.startAnimation(p2.GetBlockAnim());
						p2.gfx100(85);
					}
				break;

				case 26: // Curse
			    		if (p.magicSpellHit) {
						p.magicSpellHit = false;
						p2.gfx100(110);
						p2.playerLevel[2] -= (p2.playerLevel[2] * 0.05);
						p2.setSkillLevel(2, p2.playerLevel[2], p2.playerXP[2]);
						p2.startAnimation(p2.GetBlockAnim());
					} else {
						p2.startAnimation(p2.GetBlockAnim());
						p2.gfx100(85);
					}
				break;

				case 27: // Iban blast
					magicHit(p2, 89, 20, true);
			    		break;

				case 28: // Vulnerability
			    		if (p.magicSpellHit) {
						p.magicSpellHit = false;
						p2.gfx100(169);
						p2.playerLevel[1] -= (p2.playerLevel[1] * 0.10);
						p2.setSkillLevel(1, p2.playerLevel[1], p2.playerXP[1]);
						p2.startAnimation(p2.GetBlockAnim());
					} else {
						p2.startAnimation(p2.GetBlockAnim());
						p2.gfx100(85);
					}
				break;

				case 29: // Enfeeble
			    		if (p.magicSpellHit) {
						p.magicSpellHit = false;
						p2.gfx100(172);
						p2.playerLevel[2] -= (p2.playerLevel[2] * 0.10);
						p2.setSkillLevel(2, p2.playerLevel[2], p2.playerXP[2]);
						p2.startAnimation(p2.GetBlockAnim());
					} else {
						p2.startAnimation(p2.GetBlockAnim());
						p2.gfx100(85);
					}
				break;

				case 30: // Stun
			    		if (p.magicSpellHit) {
						p.magicSpellHit = false;
						p2.gfx100(175);
						p2.playerLevel[0] -= (p2.playerLevel[0] * 0.10);
						p2.setSkillLevel(0, p2.playerLevel[0], p2.playerXP[0]);
						p2.startAnimation(p2.GetBlockAnim());
					} else {
						p2.startAnimation(p2.GetBlockAnim());
						p2.gfx100(85);
					}
				break;

				case 31: // Teleblock
			    		if (p.magicSpellHit) {
						p.magicSpellHit = false;
						p2.gfx0(345);
						p2.Teleblock();
						p2.startAnimation(p2.GetBlockAnim());
					} else {
						p2.startAnimation(p2.GetBlockAnim());
						p2.gfx100(85);
					}
				break;

				case 32: // Slayer's dart
					magicHit(p2, 329, 25, true);
			    		break;

			}
			switch (p.magicSpell[1]) {

				case 8:
			    		if (p.magicSpellHit) {
						p.magicSpellHit = false;
						p2.appendHit(getRandom(22));
					}
				break;

				case 11:
					magicHit(p2, 375, 24, false);
			    		break;

				case 12:
			    		if (p.magicSpellHit) {
						p.magicSpellHit = false;
						p2.appendHit(getRandom(25));
					}
				break;

				case 13: // Smoke barrage
					magicHit(p2, 391, 28, false);
			    		break;

				case 14: // Shadow Barrage
					magicHit(p2, 383, 28, false);
			    		break;

				case 15: // Blood barrage 
					magicHit(p2, 377, 29, false);
			    		break;

				case 16:
			    		if (p.magicSpellHit) {
						p.magicSpellHit = false;
						p2.appendHit(Misc.random(30));
					}
				break;
			}
			p.magicDmgDelay = -1;
		}
	}

	/**
	 * Creates an auto cast system.
	 */
	public static void createMagicEvent(Player player) {
		clientHandler p2 = (clientHandler) GameEngine.playerHandler.players[player.AttackingOn];

		if (p == null || p2 == null || p.IsDead || p2.IsDead) {
			resetMagic();
			return;
		}
		int casterX = p.absX;
		int casterY = p.absY;
		int offsetY = (p.absY - p2.absY) * -1;
		int offsetX = (p.absX - p2.absX) * -1;
		int spellExp = 0;
		p.magicSpell[0] = p.autoCast[0];
		p.magicSpell[1] = p.autoCast[1];

		if (p.Wild() && p2.Wild() || p.duelArea() && p2.duelArea()) {
			p.follow(p.attackingPlayerId, player.playerId);
		}
		if (p.GoodDistance(p2.absX, p2.absY, p.absX, p.absY, 7) == false) {
			return;
		}
		if (!p.Wild() || !p2.Wild() || p.duelArea() && p2.duelArea()) {
			p.sendMessage("You or your opponent are in a safe zone.");
			resetMagic();
			return;
		}
		if (p.duelRule[2]) {
			p.sendMessage("Magic has been disabled for this duel!");
			return;
		}
		if (p.duelStatus == 3 && p.duelStartDelay > 0) {
			return;
		}
		if (p.duelStatus == 3 && p.attackingPlayerId != p.duelWith) {
			p.sendMessage("You are not dueling this player!");
			p.ResetAttack();
			return;
		}
		if (!p.multiZone() && !p2.multiZone()) {
			if (p.combatWith != p2.playerId && p.combatWith != 0) {
				p.TurnPlayerTo(p.enemyIndex + 32768);
				p.TurnPlayerTo(65535);
				p.ResetAttack();
				p.sendMessage("You are already in combat.");
				return;
			}
			if (p2.combatWith != p.playerId && p2.combatWith != 0) {
				p.TurnPlayerTo(p.enemyIndex + 32768);
				p.TurnPlayerTo(65535);
				p.ResetAttack();
				p.sendMessage("That player is already in combat.");
				return;
			}
		}
		p.TurnPlayerTo(32768 + p.AttackingOn);

		if (p.combatDelay <= 0) {
			if (getRandom(magicAttack(p)) >= getRandom(magicDefence(p2))) {
				p.magicSpellHit = true;
			} else {
				p.magicSpellHit = false;
			}
			p.stopMovement();

			switch (p.magicSpell[0]) {

				case 16: //Fire wave Autocasting
                        		if (hasReq(565, 1) && hasReq(556, 5) && hasReq(554, 7)) {
						p.magicSpell[1] = 0;
						p.combatDelay = 7;
                            			deleteItems(565, 1, 556, 5, 554, 7);
						magicCast(casterX, casterY, offsetX, offsetY, 1167, 155, 100, 156, 6, -p.AttackingOn - 1, 4);
                        		} else {
						p.sendMessage("You dont have the required runes for this spell.");
					}
					break;

			case 15: //Earth wave Autocasting
                        if (hasReq(565, 1) && hasReq(556, 5) && hasReq(557, 7)) {
				p.magicSpell[1] = 0;
				p.combatDelay = 7;
                                p.stopMovement();
                            	deleteItems(565, 1, 556, 5, 557, 7);
				magicCast(casterX, casterY, offsetX, offsetY, 1167, 164, 100, 165, 6, -p.AttackingOn - 1, 4);
                        } else {
                            	p.sendMessage("You dont have the required runes for this spell.");
                        }
			break;

			case 14: //Water wave Autocasting
                        if (hasReq(565, 1) && hasReq(556, 5) && hasReq(555, 7)) {
				p.magicSpell[1] = 0;
				p.combatDelay = 7;
                                p.stopMovement();
                            	deleteItems(565, 1, 556, 5, 554, 7);
				magicCast(casterX, casterY, offsetX, offsetY, 1167, 161, 100, 162, 6, -p.AttackingOn - 1, 4);
                        } else {
                            	p.sendMessage("You dont have the required runes for this spell.");
                        }
			break;

			case 13: //Wind wave Autocasting
                        if (hasReq(565, 1) && hasReq(556, 5)) {
				p.magicSpell[1] = 0;
				p.combatDelay = 7;
                                p.stopMovement();
                            	deleteItems(565, 1, 556, 5);
				magicCast(casterX, casterY, offsetX, offsetY, 1167, 158, 100, 159, 6, -p.AttackingOn - 1, 4);
                        } else {
                            	p.sendMessage("You dont have the required runes for this spell.");
                        }
			break;

			case 12: //Fire blast Autocasting
                        if (hasReq(560, 1) && hasReq(556, 4) && hasReq(554, 5)) {
				p.magicSpell[1] = 0;
				p.combatDelay = 7;
                                p.stopMovement();
                            	deleteItems(560, 1, 556, 4, 554, 5);
				magicCast(casterX, casterY, offsetX, offsetY, 1162, 129, 100, 130, 6, -p.AttackingOn - 1, 4);
                        } else {
                            	p.sendMessage("You dont have the required runes for this spell.");
                        }
			break;

			case 11: //Earth blast Autocasting
                        if (hasReq(560, 1) && hasReq(556, 3) && hasReq(557, 4)) {
				p.magicSpell[1] = 0;
				p.combatDelay = 7;
                                p.stopMovement();
                            	deleteItems(560, 1, 556, 3, 557, 4);
				magicCast(casterX, casterY, offsetX, offsetY, 1162, 138, 100, 139, 6, -p.AttackingOn - 1, 4);
                        } else {
                            	p.sendMessage("You dont have the required runes for this spell.");
                        }
			break;

			case 10: //Water blast Autocasting
                        if (hasReq(560, 1) && hasReq(556, 3) && hasReq(555, 3)) {
				p.magicSpell[1] = 0;
				p.combatDelay = 7;
                                p.stopMovement();
                            	deleteItems(560, 1, 556, 3, 555, 3);
				magicCast(casterX, casterY, offsetX, offsetY, 1162, 135, 100, 136, 6, -p.AttackingOn - 1, 4);
                        } else {
                            	p.sendMessage("You dont have the required runes for this spell.");
                        }
			break;

			case 9: //Wind blast Autocasting
                        if (hasReq(560, 1) && hasReq(556, 3)) {
				p.magicSpell[1] = 0;
				p.combatDelay = 7;
                                p.stopMovement();
                            	deleteItems(560, 1, 556, 3);
				magicCast(casterX, casterY, offsetX, offsetY, 1162, 132, 100, 133, 6, -p.AttackingOn - 1, 4);
                        } else {
                            	p.sendMessage("You dont have the required runes for this spell.");
                        }
			break;

			case 8: //Fire bolt Autocasting
                        if (p.playerEquipment[p.playerWeapon] == 1381 && hasReq(562, 1) && hasReq(554, 3)) {
				p.magicSpell[1] = 0;
				p.combatDelay = 7;
                                p.stopMovement();
                            	deleteItems(562, 1, 554, 3);
				magicCast(casterX, casterY, offsetX, offsetY, 1162, 126, 100, 127, 6, -p.AttackingOn - 1, 4);
						} else if (p.playerEquipment[p.playerWeapon] == 1387 && hasReq(562, 1) && hasReq(556, 2)) {
				p.magicSpell[1] = 0;
				p.combatDelay = 7;
                                p.stopMovement();
                            	deleteItems(562, 1, 556, 2);
				magicCast(casterX, casterY, offsetX, offsetY, 1162, 126, 100, 127, 6, -p.AttackingOn - 1, 4);
						} else if (p.playerEquipment[p.playerWeapon] == 3054 && hasReq(562, 1) && hasReq(556, 2)) {
				p.magicSpell[1] = 0;
				p.combatDelay = 7;
                                p.stopMovement();
                            	deleteItems(562, 1, 556, 2);
				magicCast(casterX, casterY, offsetX, offsetY, 1162, 126, 100, 127, 6, -p.AttackingOn - 1, 4);
						} else if (hasReq(562, 1) && hasReq(556, 2) && hasReq(554, 3)) {
				p.magicSpell[1] = 0;
				p.combatDelay = 7;
                                p.stopMovement();
                            	deleteItems(562, 1, 556, 2, 554, 3);
				magicCast(casterX, casterY, offsetX, offsetY, 1162, 126, 100, 127, 6, -p.AttackingOn - 1, 4);
                        } else {
                            	p.sendMessage("You dont have the required runes for this spell.");
                        }
			break;

			case 7: //Earth bolt Autocasting
                        if (p.playerEquipment[p.playerWeapon] == 1381 && hasReq(562, 1) && hasReq(557, 3)) {
				p.magicSpell[1] = 0;
				p.combatDelay = 7;
                                p.stopMovement();
                            	deleteItems(562, 1, 557, 3);
				magicCast(casterX, casterY, offsetX, offsetY, 1162, 123, 100, 124, 6, -p.AttackingOn - 1, 4);
						} else if (p.playerEquipment[p.playerWeapon] == 1385 && hasReq(562, 1) && hasReq(556, 2)) {
				p.magicSpell[1] = 0;
				p.combatDelay = 7;
                                p.stopMovement();
                            	deleteItems(562, 1, 556, 2);
				magicCast(casterX, casterY, offsetX, offsetY, 1162, 123, 100, 124, 6, -p.AttackingOn - 1, 4);
						} else if (p.playerEquipment[p.playerWeapon] == 3054 && hasReq(562, 1) && hasReq(556, 2)) {
				p.magicSpell[1] = 0;
				p.combatDelay = 7;
                                p.stopMovement();
                            	deleteItems(562, 1, 556, 2);
				magicCast(casterX, casterY, offsetX, offsetY, 1162, 123, 100, 124, 6, -p.AttackingOn - 1, 4);
						} else if (hasReq(562, 1) && hasReq(556, 2) && hasReq(557, 3)) {
				p.magicSpell[1] = 0;
				p.combatDelay = 7;
                                p.stopMovement();
                            	deleteItems(562, 1, 556, 2, 557, 3);
				magicCast(casterX, casterY, offsetX, offsetY, 1162, 123, 100, 124, 6, -p.AttackingOn - 1, 4);
                        } else {
                            	p.sendMessage("You dont have the required runes for this spell.");
                        }
			break;

			case 6: //Water bolt Autocasting
                        if (p.playerEquipment[p.playerWeapon] == 1381 && hasReq(555, 2) && hasReq(562, 1)) {
				p.magicSpell[1] = 0;
				p.combatDelay = 7;
                                p.stopMovement();
                            	deleteItems(562, 1, 555, 2);
				magicCast(casterX, casterY, offsetX, offsetY, 1162, 120, 100, 121, 6, -p.AttackingOn - 1, 4);
						} else if (p.playerEquipment[p.playerWeapon] == 1383 && hasReq(556, 2) && hasReq(562, 1)) {
				p.magicSpell[1] = 0;
				p.combatDelay = 7;
                                p.stopMovement();
                            	deleteItems(562, 1, 556, 2);
				magicCast(casterX, casterY, offsetX, offsetY, 1162, 120, 100, 121, 6, -p.AttackingOn - 1, 4);
						} else if (hasReq(556, 2) && hasReq(555, 2) && hasReq(562, 1)) {
				p.magicSpell[1] = 0;
				p.combatDelay = 7;
                                p.stopMovement();
                            	deleteItems(562, 1, 555, 2, 556, 2);
				magicCast(casterX, casterY, offsetX, offsetY, 1162, 120, 100, 121, 6, -p.AttackingOn - 1, 4);
                        } else {
                            	p.sendMessage("You dont have the required runes for this spell.");
                        }
			break;

			case 5: //Wind bolt Autocasting
                        if (p.playerEquipment[p.playerWeapon] == 1381 && hasReq(562, 1)) {
				p.magicSpell[1] = 0;
				spellExp = 100;
				p.combatDelay = 7;
                                p.stopMovement();
                            	deleteItems(562, 1);
				magicCast(casterX, casterY, offsetX, offsetY, 1162, 117, 100, 118, 6, -p.AttackingOn - 1, 4);
						} else if (hasReq(562, 1) && hasReq(556, 2)) {
				p.magicSpell[1] = 0;
				p.combatDelay = 7;
                                p.stopMovement();
                            	deleteItems(562, 1, 556, 2);
				magicCast(casterX, casterY, offsetX, offsetY, 1162, 117, 100, 118, 6, -p.AttackingOn - 1, 4);
                        } else {
                            	p.sendMessage("You dont have the required runes for this spell.");
                        }
			break;

				case 4: //Fire strike Autocasting
                        		if (p.playerEquipment[p.playerWeapon] == 1381 && hasReq(558, 1) && hasReq(554, 3)) {
						p.magicSpell[1] = 0;
						p.combatDelay = 7;
                        		        p.stopMovement();
                        		    	deleteItems(558, 1, 554, 3);
							spellExp = 19;
							p.addSkillXP(38, 6);
							p.addSkillXP(19, 3);
						magicCast(casterX, casterY, offsetX, offsetY, 1162, 99, 100, 100, 6, p.attacknpc + 1, 4);
                        		} else if (p.playerEquipment[p.playerWeapon] == 1387 && hasReq(558, 1) && hasReq(556, 2)) {
						p.magicSpell[1] = 0;
						p.combatDelay = 7;
                        		        p.stopMovement();
                        		    	deleteItems(558, 1, 556, 2);
							spellExp = 19;
							p.addSkillXP(38, 6);
							p.addSkillXP(19, 3);
						magicCast(casterX, casterY, offsetX, offsetY, 1162, 99, 100, 100, 6, p.attacknpc + 1, 4);
                        		} else if (p.playerEquipment[p.playerWeapon] == 3054 && hasReq(558, 1) && hasReq(556, 2)) {
						p.magicSpell[1] = 0;
						p.combatDelay = 7;
                        		        p.stopMovement();
                        		    	deleteItems(558, 1, 556, 2);
							spellExp = 19;
							p.addSkillXP(38, 6);
							p.addSkillXP(19, 3);
						magicCast(casterX, casterY, offsetX, offsetY, 1162, 99, 100, 100, 6, p.attacknpc + 1, 4);
                        		} else if (hasReq(558, 1) && hasReq(556, 2) && hasReq(554, 3)) {
						p.magicSpell[1] = 0;
						p.combatDelay = 7;
                        		        p.stopMovement();
                        		    	deleteItems(556, 2, 558, 1, 554, 3);
							spellExp = 19;
							p.addSkillXP(38, 6);
							p.addSkillXP(19, 3);
						magicCast(casterX, casterY, offsetX, offsetY, 1162, 99, 100, 100, 6, p.attacknpc + 1, 4);
                        		} else {
                        		    	p.sendMessage("You dont have the required runes for this spell.");
                        		}
					break;

				case 3: //Earth strike Autocasting
                        		if (p.playerEquipment[p.playerWeapon] == 1381 && hasReq(558, 1) && hasReq(557, 2)) {
						p.magicSpell[1] = 0;
						p.combatDelay = 7;
                        		        p.stopMovement();
                        		    	deleteItems(558, 1, 557, 2);
							spellExp = 15;
							p.addSkillXP(30, 6);
							p.addSkillXP(15, 3);
						magicCast(casterX, casterY, offsetX, offsetY, 1162, 96, 100, 97, 6, p.attacknpc + 1, 4);
                        		} else if (p.playerEquipment[p.playerWeapon] == 1385 && hasReq(558, 1) && hasReq(556, 1)) {
						p.magicSpell[1] = 0;
						p.combatDelay = 7;
                        		        p.stopMovement();
                        		    	deleteItems(558, 1, 556, 1);
							spellExp = 15;
							p.addSkillXP(30, 6);
							p.addSkillXP(15, 3);
						magicCast(casterX, casterY, offsetX, offsetY, 1162, 96, 100, 97, 6, p.attacknpc + 1, 4);
                        		} else if (p.playerEquipment[p.playerWeapon] == 3054 && hasReq(558, 1) && hasReq(556, 1)) {
						p.magicSpell[1] = 0;
						p.combatDelay = 7;
                        		        p.stopMovement();
                        		    	deleteItems(558, 1, 556, 1);
							spellExp = 15;
							p.addSkillXP(30, 6);
							p.addSkillXP(15, 3);
						magicCast(casterX, casterY, offsetX, offsetY, 1162, 96, 100, 97, 6, p.attacknpc + 1, 4);
                        		} else if (hasReq(558, 1) && hasReq(556, 2) && hasReq(557, 2)) {
						p.magicSpell[1] = 0;
						p.combatDelay = 7;
                        		        p.stopMovement();
                        		    	deleteItems(556, 1, 558, 1, 557, 2);
							spellExp = 15;
							p.addSkillXP(30, 6);
							p.addSkillXP(15, 3);
						magicCast(casterX, casterY, offsetX, offsetY, 1162, 96, 100, 97, 6, p.attacknpc + 1, 4);
                        		} else {
                        		    	p.sendMessage("You dont have the required runes for this spell.");
                        		}
					break;

				case 2: //Water strike Autocasting
                       			if (p.playerEquipment[p.playerWeapon] == 1381 && hasReq(558, 1) && hasReq(555, 1)) {
						p.magicSpell[1] = 0;
						p.combatDelay = 7;
                                		p.stopMovement();
                            			deleteItems(558, 1, 555, 1);
							spellExp = 11;
							p.addSkillXP(22, 6);
							p.addSkillXP(11, 3);
						magicCast(casterX, casterY, offsetX, offsetY, 1162, 93, 100, 94, 6, p.attacknpc + 1, 4);
                       			} else if (p.playerEquipment[p.playerWeapon] == 1383 && hasReq(558, 1) && hasReq(556, 1)) {
						p.magicSpell[1] = 0;
						p.combatDelay = 7;
                                		p.stopMovement();
                            			deleteItems(558, 1, 556, 1);
							spellExp = 11;
							p.addSkillXP(22, 6);
							p.addSkillXP(11, 3);
						magicCast(casterX, casterY, offsetX, offsetY, 1162, 93, 100, 94, 6, p.attacknpc + 1, 4);
                       			} else if (hasReq(558, 1) && hasReq(556, 1) && hasReq(555, 1)) {
						p.magicSpell[1] = 0;
						p.combatDelay = 7;
                                		p.stopMovement();
                            			deleteItems(556, 1, 558, 1, 555, 1);
							spellExp = 11;
							p.addSkillXP(22, 6);
							p.addSkillXP(11, 3);
						magicCast(casterX, casterY, offsetX, offsetY, 1162, 93, 100, 94, 6, p.attacknpc + 1, 4);
                       			} else {
                        		    	p.sendMessage("You dont have the required runes for this spell.");
                        		}
					break;

				case 1: //Wind strike Autocasting
                        		if (p.playerEquipment[p.playerWeapon] == 1381 && hasReq(558, 1)) {
						p.magicSpell[1] = 0;
						p.combatDelay = 7;
                        		        p.stopMovement();
                         		   	deleteItems(558, 1);
							spellExp = 7;
							p.addSkillXP(15, 6);
							p.addSkillXP(7, 3);
						magicCast(casterX, casterY, offsetX, offsetY, 1162, 90, 100, 91, 6, p.attacknpc + 1, 4);
                        		} else if (hasReq(558, 1) && hasReq(556, 1)) {
						p.magicSpell[1] = 0;
						p.combatDelay = 7;
                        		        p.stopMovement();
                         		   	deleteItems(556, 1, 558, 1);
							spellExp = 7;
							p.addSkillXP(15, 6);
							p.addSkillXP(7, 3);
						magicCast(casterX, casterY, offsetX, offsetY, 1162, 90, 100, 91, 6, p.attacknpc + 1, 4);
                        		} else {
                        		    	p.sendMessage("You dont have the required runes for this spell.");
                        		}
					break;

		}
		switch (p.magicSpell[1]) {

			case 8: //Ice blitz Autocasting
			    if (getRandom(magicAttack(p)) >= getRandom(magicDefence(p2))) {
				if (p2.freezeDelay <= -4) {
					p2.stopMovement();
					p2.freezeDelay = 15;
				}
			    }
				p.magicDmgDelay = 5;
				p.magicDelay = 7;
				p.combatDelay = 7;
				p.startAnimation(1979);
				p.magicSpell[0] = 0;
                                p.stopMovement();
				deleteItems(560, 2, 555, 4, 562, 4);
			break;

			case 12: //Ice blitz Autocasting
			    if (getRandom(magicAttack(p)) >= getRandom(magicDefence(p2))) {
				if (p2.freezeDelay <= -4) {
					p2.stopMovement();
					p2.freezeDelay = 22;
				}
			    }
				p.magicDmgDelay = 6;
				p.magicDelay = 7;
				p.combatDelay = 7;
				p.gfx0(366);
				p.startAnimation(1978);
				p.magicSpell[0] = 0;
                                p.stopMovement();
				deleteItems(560, 2, 555, 3, 565, 2);
			break;

			case 16: //Ice barrage Autocasting
			    if (getRandom(magicAttack(p)) >= getRandom(magicDefence(p2))) {
				if (p2.freezeDelay <= -4) {
					p2.stopMovement();
					p2.freezeDelay = 30;
				}
			    }
				p.magicDmgDelay = 5;
				p.magicDelay = 7;
				p.combatDelay = 7;
				p.startAnimation(1979);
				p.magicSpell[0] = 0;
                                p.stopMovement();
				deleteItems(560, 4, 555, 6, 565, 2);
			break;
		}
	    }
	}

	public static void resetMagic() {
		p.combatDelay = 0;
		p.magicSpell[0] = p.magicSpell[1] = 0;
		p.castAuto = false;
		p.usingAutoCast = false;
		p.magicDelay = 0;
	}

	public static void deleteItems(int itemId, int amt) {
		p.deleteItem(itemId, p.getItemSlot(itemId), amt);
   	}

    	public static void deleteItems(int item1id, int item1amt, int item2id, int item2amt) {
		p.deleteItem(item1id, p.getItemSlot(item1id), item1amt);
		p.deleteItem(item2id, p.getItemSlot(item2id), item2amt);
    	}

    	public static void deleteItems(int item1id, int item1amt, int item2id, int item2amt, int item3id, int item3amt) {
		p.deleteItem(item1id, p.getItemSlot(item1id), item1amt);
		p.deleteItem(item2id, p.getItemSlot(item2id), item2amt);
		p.deleteItem(item3id, p.getItemSlot(item3id), item3amt);
    	}

   	public static void deleteItems(int item1id, int item1amt, int item2id, int item2amt, int item3id, int item3amt, int item4id, int item4amt) {
		p.deleteItem(item1id, p.getItemSlot(item1id), item1amt);
		p.deleteItem(item2id, p.getItemSlot(item2id), item2amt);
		p.deleteItem(item3id, p.getItemSlot(item3id), item3amt);
		p.deleteItem(item4id, p.getItemSlot(item4id), item4amt);
    	}

    	public static boolean hasReq(int ItemId, int amt) {
    	    return p.playerHasItemAmount(ItemId, amt);
    	}

    	public static void sendMessage(clientHandler p, String Message) {
    	    p.sendMessage(Message);
    	}
    
   	public static int magicLvl(clientHandler p) {
    	    return p.playerLevel[6];
    	}

    	public static void magicCast(int casterX, int casterY, int offsetX, int offsetY, int animRequested, int graphicRequested, int graphicHeight,
			int projectileRequested, int delayRequested, int enemyIndex, int damageDelay) {

		if (graphicHeight == 100) {
			p.gfx100(graphicRequested);
		} else {
			p.gfx0(graphicRequested);
		}
		p.magicDmgDelay = damageDelay;
		p.startAnimation(animRequested);
		p.magicDelay = delayRequested;
		p.createPlayersProjectile(casterY, casterX, offsetY, offsetX, 50, 100, projectileRequested, 46, 31, enemyIndex);
   	}

    	public static int magicAttack(clientHandler p) {
		int i = (p.playerLevel[6] + p.playerBonus[3] + p.playerBonus[3]);
		int m = p.playerLevel[6];

		if (p == null) {
			return 0;
		}
		if (p.fullRaVoidEquipped()) {
			i += (double)m * 0.1000000000000001D;
		}
		return (int)Math.floor(i);
    	}

	public static void magicSpell(clientHandler p, clientHandler p2, int req, int item1, int item1A, int item2, int item2A, boolean fr, int frDelay, int anim, int anc, int mDmgD, int mD) {
		if (magicLvl(p) >= req) {
			if (hasReq(item1, item1A) && hasReq(item2, item2A)) {
				if (fr) {
					if (getRandom(magicAttack(p)) >= getRandom(magicDefence(p2))) {
						if (p2.freezeDelay <= -4) {
							p2.stopMovement();
							p2.freezeDelay = frDelay;
						}
					}
				}
				p.magicDmgDelay = mDmgD;
				p.magicDelay = mD;
				p.magicSpell[1] = anc;
				p.magicSpell[0] = 0;
				p.combatDelay = 6;
	 			deleteItems(item1, item1A, item2, item2A);
				p.startAnimation(anim);
				p.followPlayer = null;
			} else {
               			sendMessage(p, "You dont have the required runes for this spell.");
			}
	    	} else {
		    	sendMessage(p, "You need level "+ req +" magic to use this spell.");
	    	}
	}

	public static void magicSpell(clientHandler p, clientHandler p2, int req, int item1, int item1A, int item2, int item2A, int item3, int item3A, boolean fr, int frDelay, int anim, int anc, int mDmgD, int mD) {
		if (magicLvl(p) >= req) {
			if (hasReq(item1, item1A) && hasReq(item2, item2A) && hasReq(item3, item3A)) {
				if (fr) {
		        		if (getRandom(magicAttack(p)) >= getRandom(magicDefence(p2))) {
					if (p.magicSpellHit) {
						if (p2.freezeDelay <= -4) {
							p2.stopMovement();
							p2.freezeDelay = frDelay;
						}
					}
					}
				}
		    		p.magicDmgDelay = mDmgD;
		    		p.magicDelay = mD;
		    		p.magicSpell[1] = anc;
		    		p.magicSpell[0] = 0;
		   		p.combatDelay = 6;
		    		deleteItems(item1, item1A, item2, item2A, item3, item3A);
		    		p.startAnimation(anim);
		    		p.followPlayer = null;
			} else {
               			sendMessage(p, "You dont have the required runes for this spell.");
			}
	    	} else {
		   	sendMessage(p, "You need level "+ req +" magic to use this spell.");
	    	}
    	}

	public static void magicSpell(clientHandler p, clientHandler p2, int req, int item1, int item1A, int item2, int item2A, int item3, int item4, int item4A, int item3A, boolean fr, int frDelay, int anim, int anc, int mDmgD, int mD) {
	    	if (magicLvl(p) >= req) {
			if (hasReq(item1, item1A) && hasReq(item2, item2A) && hasReq(item3, item3A) && hasReq(item4, item4A)) {
		   		if (fr) {
		        		if (getRandom(magicAttack(p)) >= getRandom(magicDefence(p2))) {
					if (p.magicSpellHit) {
						if (p2.freezeDelay <= -4) {
							p2.stopMovement();
							p2.freezeDelay = frDelay;
						}
					}
					}
		   		}
		    		p.magicDmgDelay = mDmgD;
		    		p.magicDelay = mD;
		    		p.magicSpell[1] = anc;
		    		p.magicSpell[0] = 0;
		    		p.combatDelay = 6;
		    		deleteItems(item1, item1A, item2, item2A, item3, item3A, item4, item4A);
		    		p.startAnimation(anim);
		    		p.followPlayer = null;
			} else {
               			sendMessage(p, "You dont have the required runes for this spell.");
			}
	    	} else {
		   	sendMessage(p, "You need level "+ req +" magic to use this spell.");
	    	}
    	}

	public static void magicHit(clientHandler p2, int gfx, int hit, boolean flag) {
		if (p.magicSpellHit) {
			p.magicSpellHit = false;
			p2.appendHit(getRandom(hit));
			p2.startAnimation(p2.GetBlockAnim());
			
			if (flag) {
				p2.gfx100(gfx);
			} else {
				p2.gfx0(gfx);
			}
		} else {
			p2.startAnimation(p2.GetBlockAnim());
			p2.gfx100(85);
		}
	}

    	public static int magicDefence(clientHandler p) {
		if (p == null) {
			return 0;
		}
		if (!p.magicPrayer) {
			return (int)((p.playerLevel[1] / 4) + (p.playerLevel[6] / 2) + p.playerBonus[8]);
		} else if (p.magicPrayer) {
			return (int)((p.playerLevel[1] / 4) + (p.playerLevel[6] / 2) + p.playerBonus[8] + 50);
		} else {
			return 0;
		}
    	}

    	public static int getRandom(int range) {
		return (int)(Math.random() * (range + 1));
    	}    
}