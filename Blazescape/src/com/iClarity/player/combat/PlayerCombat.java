package com.iClarity.player.combat;

import com.iClarity.*;
import com.iClarity.misc.*;
import com.iClarity.event.*;
import com.iClarity.player.*;
import com.iClarity.player.magic.*;

public class PlayerCombat {


	public static void Attack(clientHandler p) {
		if (p.castAuto) {
			Magic M = new Magic(p);
			M.createMagicEvent(p);
			return;
		}
                clientHandler p2 = (clientHandler) GameEngine.playerHandler.players[p.AttackingOn];
		int EnemyX = PlayerHandler.players[p.AttackingOn].absX;
		int EnemyY = PlayerHandler.players[p.AttackingOn].absY;
		int offsetX = (p.absX - EnemyX) * -1;
		int offsetY = (p.absY - EnemyY) * -1;
		int atk = Misc.random(p.meleeAtk());
		int def = Misc.random(p2.meleeDef());
		p.attackingPlayerId = p2.playerId;
                p.resetAnimation();
		p.TurnPlayerTo(EnemyX, EnemyY);
		p.setMagicPlayer(false);
		p.updateRequired = true;
		p.appearanceUpdateRequired = true;
		p2.updateRequired = true;
		p2.appearanceUpdateRequired = true;

		if (p.duelStatus == 3 && p.attackingPlayerId != p.duelWith) {
			p.sendMessage("You are not dueling this player!");
			p.ResetAttack();
			return;
		}
		if (p.Wild() && p2.Wild() || p.duelStatus == 3 && p2.duelStatus == 3) {
			//p.follow(p.attackingPlayerId, 1, 1);
			p.follow(p.attackingPlayerId, p.playerId);
		} else {
			p.faceNPC = 65535;
			p.faceNPCupdate = true;
			p.followPlayer = null;
		}
		if (p.freezeDelay > 0) {
			if (p.GoodDistance(EnemyX, EnemyY, p.absX, p.absY, 1) == false && !p.usingRange() && !p.usingKnives()) {
				return;
			}
		} else {
			if (p.GoodDistance(EnemyX, EnemyY, p.absX, p.absY, 3) == false && !p.usingRange() &&  !p.usingKnives()) {
				return;
			}
		}
		if (p.GoodDistance(EnemyX, EnemyY, p.absX, p.absY, 7) == false && p.usingRange()) {
			return;
		}
		if (p.GoodDistance(EnemyX, EnemyY, p.absX, p.absY, 5) == false && p.usingKnives()) {
			return;
		}
		if (p.duelStatus != 3) {/*
			if (!p.isInWildRange(p)) {
				p.TurnPlayerTo(p.enemyIndex + 32768);
				p.TurnPlayerTo(65535);
				p.stopMovement();
	   			p.sendMessage("Your level difference is too great!");
	   			p.sendMessage("You need to move further into the Wilderness.");
				p.ResetAttack();
	   			return;
			}*/
		}
		if (p.duelStatus == 3 && p.duelStartDelay > 0) {
			return;
		}
		if(p.rangeDelay > 0) {
			return;
		}
		if (p.duelRule[1] && !p.usingRange()) {
			p.sendMessage("Melee has been disabled for this duel!");
			p.ResetAttack();
			return;
		}
		if (p.duelRule[0] && p.usingRange()) {
			p.sendMessage("Range has been disabled for this duel!");
			p.ResetAttack();
			return;
		}
		if(p.usingRange() && p.playerEquipmentN[p.playerArrows] == 0 && (p.playerEquipment[p.playerWeapon] != 4214 && p.playerEquipment[p.playerWeapon] != 19050 && p.playerEquipment[p.playerWeapon] != 19051 && p.playerEquipment[p.playerWeapon] != 19049 && p.playerEquipment[p.playerWeapon] != 19048)) {
			p.ResetAttack();
			p.sendMessage("You don't have the correct arrows to range with this bow!");
			return;
		}
		if (p.usingRange()) {
			p.CheckArrows();

			if (!p.HasArrows) {
				p.sendMessage("You don't have the correct arrows to range with this bow!");
				p.ResetAttack();
				return;
			}
		}
	    	if ((p.duelStatus != 3 || p2.duelStatus != 3) && (!p.Wild() || !p2.Wild())) {
			p.sendMessage("You cannot attack this player.");
			p.ResetAttack();
			return;
		}
		if (p.usingRange() && !p2.Wild()) {
			p.sendMessage("You cannot attack this player.");
			p.ResetAttack();
			return;
		}

		if (p.usingSpecial && p.playerEquipment[3] == 4153) {
			if (p.specialAmount >= p.specDrainAmount()) {
				switch (p.playerEquipment[3]) {

					case 4153:
						p.gfx100(340);
						p.startAnimation(p.getSpecAnim());
						appendSpecialDamage(p);
						p.combatDelay = p.getCombatDelay();
						break;
				}
				p.usingSpecial = false;
				p.specialAmount -= p.specDrainAmount();
				p.specs();
				p.savemoreinfo();
		    	} else {
				p.sendMessage("You do not have enough special energy left.");
				p.usingSpecial = false;
				p.specs();
		    	}
		}
		if (p.combatDelay <= 1) {
			if (!p.multiZone() && p2.combatWith == 0 && p2.attackingPlayerId != p.playerId) {
				p2.ResetAttack();
			}
			if (!p.multiZone() && p2.combatWith != p.playerId && p2.combatWith > 0 && p2.attackingPlayerId != p.playerId) {
				p.sendMessage("This player is already in combat!");
				p.ResetAttack();
				return;
			}
			if (!p.multiZone() && p.combatWith != p.attackingPlayerId && p.combatWith > 0) {
				p.sendMessage("You are already in combat!");
				p.ResetAttack();
				return;
			}
			p2.combatWith = p.playerId;

			if (p.duelRule[3] && p.usingSpecial) {
				p.sendMessage("Special attacks have been disabled this duel!");
				p.combatDelay = (p.getCombatDelay() + 2);
				return;
			}
			if (p2.IsDead == false) {
				p2.resetCmb = p.getCombatDelay() + 3;
				p2.inCombat = p.getCombatDelay() + 5;

				if (p.lastHit != p.AttackingOn) {
					p2.lastHit = p.playerId;
					p.lastHit = p.AttackingOn;
					p.skullTimer = 1200;
					p.SetPkHeadIcon(1);
				}
				if (!p.usingSpecial) {
					if (!p.usingRange() && !p.usingKnives()) {
						p.setAnimation(p.GetWepAnim());
						appendDamage(p);
					} else {
						p.setAnimation(p.GetWepAnim());
						p.setRangeDelay(p.getRangeDelay());
					}
				}
				if (p.usingSpecial == true) {
				    if (p.specialAmount >= p.specDrainAmount()) {
					switch (p.playerEquipment[p.playerWeapon]) {

						case 11730:
							p.setSpecialDelay(1);
							p.gfx100(604);
							p.startAnimation(p.getSpecAnim());
							break;
						case 11700:
							p.setSpecialDelay(1);
							p.gfx100(603);
							p.startAnimation(p.getSpecAnim());
							break;
						case 11698:
							appendSpecialDamage(p);
							//p.setSpecialDelay(1);
							p.gfx0(602);
							p.startAnimation(p.getSpecAnim());
							break;
						case 11696:
							appendSpecialDamage(p);
							//p.setSpecialDelay(1);
							p.gfx100(600);
							p.startAnimation(p.getSpecAnim());
							break;
						case 11694:
							appendSpecialDamage(p);
							//p.setSpecialDelay(1);
							p.gfx100(601);
							p.startAnimation(p.getSpecAnim());
							break;
						case 5698:
							appendSpecialDamage(p);
							appendSpecialDamage(p);
							p.gfx100(252);
							p.startAnimation(p.getSpecAnim());
							break;
						case 14484:
							appendSpecialDamage(p);
							appendSpecialDamage(p);
							appendSpecialDamage(p);
							appendSpecialDamage(p);
							p.startAnimation(p.getSpecAnim());
							break;
						case 1249:
							p.setSpecialDelay(1);
							p.gfx100(253);
							p.startAnimation(p.getSpecAnim());
							break;
						case 4151:
							p.setSpecialDelay(1);
							p2.gfx100(341);
							p.startAnimation(p.getSpecAnim());
							break;
						case 7158:
							p.setSpecialDelay(1);
							p.gfx0(560);
							p.startAnimation(p.getSpecAnim());
							break;
						case 10887:
							p.setSpecialDelay(1);
							p.startAnimation(p.getSpecAnim());
							break;
						case 1305:
							p.setSpecialDelay(1);
							p.gfx100(248);
							p.startAnimation(p.getSpecAnim());
							break;
						case 3204:
							p.setSpecialDelay(1);
							p.gfx100(282);
							p.startAnimation(p.getSpecAnim());
							break;
						case 4587:
							p.setSpecialDelay(1);
							p.gfx100(347);
							p.startAnimation(p.getSpecAnim());
							break;
                                        	case 6541:
							p.setSpecialDelay(1);
							p.gfx100(347);
							p.startAnimation(p.getSpecAnim());
							break;
						case 1434:
							p.setSpecialDelay(1);
							p.gfx100(251);
							p.startAnimation(p.getSpecAnim());
							break;
						case 6739:
							p.setSpecialDelay(1);
							p.startAnimation(p.getSpecAnim());
							break;
						case 861:
							p.frame174(386, 050, 000);
							p.createPlayersProjectile(p.absY, p.absX, offsetY, offsetX, 50, 75, 249, 42, 31, -p.attackingPlayerId - 1);
							p.setSpecialDelay(3);
							p.setRangeDelay(3);
							p.nextProjectile();
							p.startAnimation(p.getSpecAnim());
							p.combatDelay = 7;
							p.gfx100(256);

							if (p.playerEquipment[p.playerCape] == 9007) {
								if (Misc.random(100) >= 30) {
									p.DeleteArrow();
								}
							} else {
								p.DeleteArrow();
							}
							break;
					}
					p.usingSpecial = false;
					p.specialAmount -= p.specDrainAmount();
					p.specs();
				    } else {
					p.sendMessage("You do not have enough special energy left.");
					p.usingSpecial = false;
					p.specs();
					p.combatDelay = (p.getCombatDelay() + 2);
					return;
				    }
				}
				if (!p.usingRange() && !p.usingKnives()) {
                                        p.TurnPlayerTo(EnemyX, EnemyY);
					p.follow(p.attackingPlayerId, 1, p.getDis( p.absX, p.absY, EnemyX, EnemyY));
                                        p2.KillerId = p.playerId;
                                        p.combatDelay = p.getCombatDelay();
				} else {
					if (p.specDamageDelay < 0) {
                                        	p.combatDelay = p.getCombatDelay();
						p.gfx100(p.getRangeGfx(p.playerEquipment[p.playerArrows], p.playerEquipment[3]));

						if (p.playerEquipment[3] == 4734) {
							p.createPlayersProjectile(p.absY, p.absX, offsetY, offsetX, 50, 75, p.getRangePro(p.playerEquipment[p.playerArrows], p.playerEquipment[3]), 37, 31, -p.attackingPlayerId - 1);
						} else if (p.usingKnives()) {
							p.createPlayersProjectile(p.absY, p.absX, offsetY, offsetX, 50, 50, p.getRangePro(p.playerEquipment[p.playerArrows], p.playerEquipment[3]), 39, 31, -p.attackingPlayerId - 1);
						} else {
							
							if (p.playerEquipment[3] == 15156) {
								p.createPlayersProjectile(p.absY, p.absX, offsetY, offsetX, 50, 75, p.getRangePro(p.playerEquipment[p.playerArrows], p.playerEquipment[3]), 40, 29,-p.attackingPlayerId - 1);
								p.createPlayersProjectile(p.absY, p.absX, offsetY, offsetX, 50, 75, p.getRangePro(p.playerEquipment[p.playerArrows], p.playerEquipment[3]), 44, 33,-p.attackingPlayerId - 1);
							} else {
								p.createPlayersProjectile(p.absY, p.absX, offsetY, offsetX, 50, 75, p.getRangePro(p.playerEquipment[p.playerArrows], p.playerEquipment[3]), 42, 31, -p.attackingPlayerId - 1);
							}
						}
					}
					if (p.playerEquipment[p.playerCape] == 9007) {
						if (Misc.random(100) >= 30) {
							p.DeleteArrow();
						}
					} else {
						p.DeleteArrow();
					}
				}
				p2.KillerId = p.playerId;
			}
		}
	}

	public static void appendDamage(clientHandler p) {
		try {
			clientHandler p2 = (clientHandler) GameEngine.playerHandler.players[p.AttackingOn];

			if (p == null || p2 == null) {
				return;
			}
			int p2Damage = Misc.random(p.calculateMelee());
			int atk = Misc.random(p.meleeAtk());
			int def = Misc.random(p2.meleeDef());
			if (atk < def) {
				if (!p.fullVerac()) {
					p2.appendHit(0);
			 	} else {
					if (Misc.random(3) == 3) {
						p2.appendHit(p2Damage);
					} else {
						p2.appendHit(0);
					}
				}
			} else {
				if (p2.playerLevel[3] <= p2Damage) {
					p2Damage = p2.playerLevel[3];
				}
				if (p.FullGuthanEquipped()) {
					int guthanHealAmt = 0;
					guthanHealAmt += p2Damage / 2;
					if(Misc.random(1) == 0 && p.playerLevel[3] < p.getLevelForXP(p.playerXP[p.playerHitpoints])) {
					p.updateHp(guthanHealAmt, true);
					p2.gfx100(398);
					}
				}
				if (p2.meleePrayer) {
						p2Damage = ((100*p2Damage) / 95);
				}
				if (p.smitePrayer && p2.playerLevel[5] > 0) {
					p2.playerLevel[5] -= (int)(p2Damage / 4);
				}
				p2.appendHit(p2Damage);

				if (p2.usingVeng) {
					p.appendHit((int)((p2Damage / 4) * 3));
					p2.vengDelay = 0;
					p2.usingVeng = false;
					p2.txt4 = "Taste Vengeance!";
					p2.string4UpdateRequired = true;
				}
				double TotalExp = 0;

				if (p.FightType == 1) { // Accurate
					TotalExp = (double)(75 * p2Damage);
					TotalExp = (double)(TotalExp * p.CombatExpRate);
					p.addSkillXP((int)(TotalExp), p.playerAttack);
				}
				if (p.FightType == 2) { // Agressive
					TotalExp = (double)(75 * p2Damage);
					TotalExp = (double)(TotalExp * p.CombatExpRate);
					p.addSkillXP((int)(TotalExp), p.playerStrength);
				}
				if (p.FightType == 4) { // Defensive
					TotalExp = (double)(75* p2Damage);
					TotalExp = (double)(TotalExp * p.CombatExpRate);
					p.addSkillXP((int)(TotalExp), p.playerDefence);
				}
				if (p.FightType == 3) { // Controlled
					TotalExp = (double)(35 * p2Damage);
					TotalExp = (double)(TotalExp * p.CombatExpRate);
					p.addSkillXP((int)(TotalExp), p.playerStrength);
					p.addSkillXP((int)(TotalExp), p.playerAttack);
					p.addSkillXP((int)(TotalExp), p.playerDefence);
				}
			}
			p2.startAnimation(p2.GetBlockAnim());
			p.setDamageDelay(-1);
			return;
		} catch (Exception e) {
			return;
		}
	}

	public static void appendSpecialDamage(clientHandler p) {
		try {
			clientHandler p2 = (clientHandler) GameEngine.playerHandler.players[p.AttackingOn];

			if (p == null || p2 == null) {
				return;
			}
			int p2Damage = Misc.random(p.calculateMelee());
			int atk = Misc.random(p.meleeAtk());
			int def = Misc.random(p2.meleeDef());
			int clawDamage1 = (p2Damage/2);
			int clawDamage2 = Misc.random(p.calculateMelee());
			int clawDamage3 = (clawDamage2/2);
			int strBonus = Misc.random(p.playerLevel[1]/6);

			if (!p.usingRange()) {
				if (atk < def) {
					if (!p.fullVerac()) {
						if (Misc.random(3) != 2) {
							p2.appendHit(p2Damage);
						} else {
						p2.appendHit(0);
						}
			 		} else {
						if (Misc.random(3) != 2) {
							p2.appendHit(p2Damage);
						}
					}
				} else {
					if (p2.playerLevel[3] <= p2Damage) {
						p2Damage = p2.playerLevel[3];
					}
					if (p.playerEquipment[3] == 11694) {
						p2Damage = 20+Misc.random(20)+strBonus;
					}
					if (p.playerEquipment[3] == 11696) {
						p2Damage = 27+Misc.random(15)+strBonus+4;
					}
					if (p.playerEquipment[3] == 11698) {
						p2Damage = 24+Misc.random(10);
						p.updateHp((p2Damage/2), true);
					}
				if (p.playerEquipment[3] == 14484) {
					p2.appendHit(p2Damage);
					//p2.appendHit(clawDamage1);
				} else {
					p2.appendHit(p2Damage);
				}
					if (p2.meleePrayer) {
						p2Damage = ((100*p2Damage) / 80);
					}
					if (p.smitePrayer && p2.playerLevel[5] > 0) {
						p2.playerLevel[5] -= (int)(p2Damage / 4);
					}

					if (p2.usingVeng) {
						p.appendHit((int)((p2Damage / 4) * 3));
						p2.vengDelay = 0;
						p2.usingVeng = false;
						p2.txt4 = "Taste Vengeance!";
						p2.string4UpdateRequired = true;
					}
					if (p.playerEquipment[3] == 1249) {
						p2.gfx100(254);
					}
					double TotalExp = 0;

					if (p.FightType == 1) { // Accurate
						TotalExp = (double)(75 * p2Damage);
						p.addSkillXP((int)(TotalExp), p.playerAttack);
					}
					if (p.FightType == 2) { // Agressive
						TotalExp = (double)(75 * p2Damage);
						p.addSkillXP((int)(TotalExp), p.playerStrength);
					}
					if (p.FightType == 4) { // Defensive
						TotalExp = (double)(75 * p2Damage);
						p.addSkillXP((int)(TotalExp), p.playerDefence);
					}
					if (p.FightType == 3) { // Controlled
						TotalExp = (double)(35 * p2Damage);
						p.addSkillXP((int)(TotalExp), p.playerStrength);
						p.addSkillXP((int)(TotalExp), p.playerDefence);
						p.addSkillXP((int)(TotalExp), p.playerAttack);
					}
					double HPExp = 0;
					HPExp = (double)(37 * p2Damage);
					p.addSkillXP((int)(HPExp), 3);
				}
			} else {
				int rangeDamage = Misc.random(p.getRangeMaxHit());
				int range = Misc.random(p.rangeAtk());
				int rDef = Misc.random(p2.rangeDef());

				if (Misc.random(100) >= 30) {
					if (p.playerEquipment[p.playerCape] != 9007) {
						p.DropArrows();
					}
				}

				if (range < def) {
					p2.appendHit(p2Damage);
					//A DOUBLE CHECK
				} else {
					if (p2.playerLevel[3] <= p2Damage) {
						p2Damage = p2.playerLevel[3];
					}
					if (p2.rangedPrayer) {
						p2Damage = p2Damage / 2;
					}
					if (p.smitePrayer && p2.playerLevel[5] > 0) {
						p2.playerLevel[5] -= (int)(p2Damage / 4);
					}
					
					p2.appendHit(p2Damage);

					if (p2.usingVeng) {
						p.appendHit((int)((p2Damage / 4) * 3));
						p2.vengDelay = 0;
						p2.usingVeng = false;
						p2.txt4 = "Taste Vengeance!";
						p2.string4UpdateRequired = true;
					}
					double TotalExp = 0;

					if (p.FightType == 1) { // Accurate
						TotalExp = (double)(75 * p2Damage);
						p.addSkillXP((int)(TotalExp), 4);
					}
					if (p.FightType == 2) { // Rapid
						TotalExp = (double)(75 * p2Damage);
						p.addSkillXP((int)(TotalExp), 4);
					}
					if (p.FightType == 3) { // Longrange
						TotalExp = (double)(35 * p2Damage);
						p.addSkillXP((int)(TotalExp), 4);
						p.addSkillXP((int)(TotalExp), 1);
					}
					double HPExp = 0;
					HPExp = (double)(37 * p2Damage);
					p.addSkillXP((int)(HPExp), 3);
				}
			}
			p2.startAnimation(p2.GetBlockAnim());
			p.setDamageDelay(-1);
			return;
		} catch (Exception e) {
			return;
		}
	}

	public static void appendRangeDamage(clientHandler p) {
		try {
			clientHandler p2 = (clientHandler) GameEngine.playerHandler.players[p.AttackingOn];

			if (p == null || p2 == null) {
				return;
			}
			int p2Damage = Misc.random(p.getRangeMaxHit());
			int p2DamageOther = Misc.random(p.getRangeMaxHit());
			int range = Misc.random(p.rangeAtk());
			int def = Misc.random(p2.rangeDef());
		if (p.rangeDelay == 0 && p2.Wild()) {

			if (Misc.random(100) >= 30) {
				if (p.playerEquipment[p.playerCape] != 9007) {
					if (!p.usingKnives()) {
						p.DropArrows();
					} else {
						p.DropOther();
					}
				}
			}

			if (range < def) {
				p2.appendHit(p2Damage);
				//DOUBLE CHECK
			} else {
				if (p2.playerLevel[3] <= p2Damage) {
					p2Damage = p2.playerLevel[3];
				}
				if (p2.rangedPrayer) {
					p2Damage = p2Damage / 2;
				}
				if (p.smitePrayer && p2.playerLevel[5] > 0) {
					p2.playerLevel[5] -= (int)(p2Damage / 4);
				}
				if (p.playerEquipment[3] == 15156) {
					p2.appendHit(p2DamageOther);
					p2.appendHit(p2Damage);
				} else {
					p2.appendHit(p2Damage);
				}

				if (p2.usingVeng) {
					p.appendHit((int)((p2Damage / 4) * 3));
					p2.vengDelay = 0;
					p2.usingVeng = false;
					p2.txt4 = "Taste Vengeance!";
					p2.string4UpdateRequired = true;
				}
				double TotalExp = 0;

				if (p.FightType == 1) { // Accurate
					TotalExp = (double)(75 * p2Damage);
					p.addSkillXP((int)(TotalExp), 4);
				}
				if (p.FightType == 2) { // Rapid
					TotalExp = (double)(75 * p2Damage);
					p.addSkillXP((int)(TotalExp), 4);
				}
				if (p.FightType == 3) { // Longrange
					TotalExp = (double)(35 * p2Damage);
					p.addSkillXP((int)(TotalExp), 4);
					p.addSkillXP((int)(TotalExp), 1);
				}
				double HPExp = 0;
				HPExp = (double)(37 * p2Damage);
				p.addSkillXP((int)(HPExp), 3);
			}
			p2.startAnimation(p2.GetBlockAnim());
			p.setRangeDelay(-1);
			return;
		}//CHECKS FOR RANGE DELAY

		} catch (Exception e) {
			return;
		}
	}

	public int getRangeMaxHit(clientHandler p) {
		double d = 0.0D;
		double d1 = p.playerLevel[p.playerRanged];
		int i = p.getLevelForXP(p.playerXP[p.playerRanged]);
		int j = p.playerEquipment[p.playerWeapon];
		int k = p.playerEquipment[p.playerArrows];

		if (p.fullRaVoidEquipped()) {
			d1 += (double)i * 0.10000000000000001D;
		}
		d += 1.05D + d1 * 0.00125D;
		d += d1 * 0.11D;

		if (j == 800 || j == 806 || j == 825 || j == 864) {
			d *= 0.69999999999999996D;
		} else if (j == 801 || j == 807 || j == 820 || j == 863) {
			d *= 0.71999999999999997D;
		} else if (j == 802 || j == 808 || j == 827 || j == 865) {
			d *= 0.79000000000000004D;
		} else if (j == 803 || j == 809 || j == 828 || j == 866) {
			d *= 0.83999999999999997D;
 		} else if (j == 804 || j == 810 || j == 829 || j == 867) {
			d *= 0.98999999999999999D;
		} else if (j == 805 || j == 811 || j == 830 || j == 868) {
			d *= 1.24D;
		} else if (j == 6522) {
			d *= 1.6399999999999999D;
		} else if (j == 4212 || j == 4214) {
			d *= 2.25D;
		} else if (k == 882 || k == 883) {
			d *= 1.042D;
		} else if (k == 884 || k == 885) {
			d *= 1.044D;
		} else if (k == 886 || k == 887) {
			d *= 1.1339999999999999D;
		} else if (k == 888 || k == 889) {
			d *= 1.2D;
		} else if (k == 890 || k == 891) {
			d *= 1.3500000000000001D;
		} else if (k == 892 || k == 893) {
			d *= 1.6000000000000001D;
		} else if (k == 4740) {
			d *= 1.95D;
		} else if (k == 8065) {
			d *= 1.5D;
		} else if (k == 7988) {
			d *= 2.1000000000000001D;
		} else if (k == 7990) {
			d *= 2.6000000000000001D;
		}

		if (p.usingSpecial) {
			if (p.playerEquipment[p.playerWeapon] == 861) {
				d *= 1.05D;
			} else if (p.playerEquipment[p.playerWeapon] == 7958) {
				d *= 1.6399999999999999D;
			}
		}
		return (int)Math.floor(d);
	}
}