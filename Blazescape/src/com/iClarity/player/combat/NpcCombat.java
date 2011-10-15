package com.iClarity.player.combat;

import com.iClarity.*;
import com.iClarity.npcs.*;
import com.iClarity.misc.*;
import com.iClarity.player.*;

public class NpcCombat {


	public static void AttackNPC(clientHandler p) {
		int EnemyHP = GameEngine.npcHandler.npcs[p.attacknpc].HP;
		NPC p2 = (NPC) GameEngine.npcHandler.npcs[p.attacknpc];
		int EnemyX = p2.absX;
		int EnemyY = p2.absY;
		int casterX = p.absX;
            	int casterY = p.absY;
            	int offsetX = (casterX - EnemyX) * -1;
            	int offsetY = (casterY - EnemyY) * -1;
            	p.faceNPC(p.attacknpc);
		p.updateRequired = true;
		p.appearanceUpdateRequired = true;

		if (p.GoodDistance(EnemyX, EnemyY, p.absX, p.absY, 1) == false && !p.usingRange() && !p.usingKnives()) {
			return;
		}
		if (p.GoodDistance(EnemyX, EnemyY, p.absX, p.absY, 8) == false && p.usingRange()) {
			return;
		}
		if(p.usingRange() && p.playerEquipmentN[p.playerArrows] == 0 && (p.playerEquipment[p.playerWeapon] != 4214 && p.playerEquipment[p.playerWeapon] != 19050 && p.playerEquipment[p.playerWeapon] != 19051 && p.playerEquipment[p.playerWeapon] != 19049 && p.playerEquipment[p.playerWeapon] != 19048)) {
			p.ResetAttack();
			p.sendMessage("You don't have the correct arrows to range with this bow!");
			return;
		}
		if(p.rangeNPCDelay > 0) {
			return;
		}
		if (p.usingRange()) {
			p.CheckArrows();

			if (!p.HasArrows) {
				p.sendMessage("You don't have the correct arrows to range with this bow!");
				p.setNPCRangeDelay(-1);
				p.ResetAttack();
				return;
			}
		}
		if (p.usingRange() && EnemyHP == 0) {
			p.setNPCRangeDelay(-1);
			return;
		}

		if (p2.npcType == 1158) {
			if((!(p.absX >= 3431 && p.absX <= 3452 && p.absY >= 3555 && p.absY <= 3579)) || (p.absX >= 3431 && p.absX <= 3433 && p.absY >= 3555 && p.absY <= 3561)) {
				p.sendMessage("You cannot attack the Kalphite queen from there!");
				return;
			}
		}

		if (p.GoodDistance(EnemyX, EnemyY, p.absX, p.absY, 5) == false && p.usingKnives()) {
			return;
		}
		if (EnemyHP == 0) {
			return;
		}
		if (p2.spawnedBy != -1 && p2.spawnedBy != p.playerId) {
			p.sendMessage("This is not your NPC!");
			return;
		}

		if (p.cmbDelay <= 1) {

			if (!p2.IsDead) {
				if (!p.usingSpecial) {
					if (!p.usingRange() && !p.usingKnives()) {
						p.setNPCDamageDelay(1);
					} else {
						p.setNPCRangeDelay(p.getRangeDelay());
					}
				}
				p.setAnimation(p.GetWepAnim());

				if (p.usingSpecial == true) {
					if (p.specialAmount >= p.specDrainAmount()) {
						switch (p.playerEquipment[3]) {

						case 11730:
							p.setNPCSpecialDelay(1);
							p.gfx100(604);
							p.startAnimation(p.getSpecAnim());
							break;
						case 11700:
							p.setNPCSpecialDelay(1);
							p.gfx100(603);
							p.startAnimation(p.getSpecAnim());
							break;
						case 11698:
							appendNPCSpecialDamage(p);
							//p.setNPCSpecialDelay(1);
							p.gfx0(602);
							p.startAnimation(p.getSpecAnim());
							break;
						case 11696:
							appendNPCSpecialDamage(p);
							//p.setNPCSpecialDelay(1);
							p.gfx100(600);
							p.startAnimation(p.getSpecAnim());
							break;
						case 11694:
							appendNPCSpecialDamage(p);
							//p.setNPCSpecialDelay(1);
							p.gfx100(601);
							p.startAnimation(p.getSpecAnim());
							break;
							case 4151:
								p.setNPCSpecialDelay(1);
								p.startAnimation(p.getSpecAnim());
								p2.gfx100(341);
								break;
							case 7158:
								p.setNPCSpecialDelay(1);
								p.gfx0(560);
								p.startAnimation(p.getSpecAnim());
								break;
						case 10887:
							p.setNPCSpecialDelay(1);
							p.startAnimation(p.getSpecAnim());
							break;

							case 1305:
								p.setNPCSpecialDelay(1);
								p.gfx100(248);
								p.startAnimation(p.getSpecAnim());
								break;
							case 3204:
								p.setNPCSpecialDelay(1);
								p.gfx100(282);
								p.startAnimation(p.getSpecAnim());
								break;
							case 4587:
								p.setNPCSpecialDelay(1);
								p.gfx100(347);
								p.startAnimation(p.getSpecAnim());
								break;
                                        		case 6541:
								p.setNPCSpecialDelay(1);
								p.gfx100(347);
								p.startAnimation(p.getSpecAnim());
								break;
							case 1434:
								p.setNPCSpecialDelay(1);
								p.gfx100(251);
								p.startAnimation(p.getSpecAnim());
								break;
							case 14484:
								appendNPCSpecialDamage(p);
								p.startAnimation(p.getSpecAnim());
								break;
							case 5698:
								appendNPCSpecialDamage(p);
								appendNPCSpecialDamage(p);
								p.gfx100(252);
								p.startAnimation(p.getSpecAnim());
								break;
							case 9005:
								p.setNPCDamageDelay(1);
								p.setNPCSpecialDelay(2);
								p.startAnimation(p.getSpecAnim());
								break;
							case 6739:
								p.setNPCSpecialDelay(1);
								p.startAnimation(p.getSpecAnim());
								break;
							case 861:
								p.setNPCSpecialDelay(1);
								p.startAnimation(p.getSpecAnim());
								break;
						}
					} else {
						p.sendMessage("You do not have enough special energy left.");
						p.usingSpecial = false;
						p.specs();
						p.combatDelay = (p.getCombatDelay() + 2);
						return;
				    	}
					p.usingSpecial = false;
					p.specialAmount -= p.specDrainAmount();
					p.specs();
					p.savemoreinfo();
				}

			if (!p2.IsDead) {//START CHECK FOR DEAD NPC
				if (!p.usingRange() && !p.usingKnives()) {
                                        p.TurnPlayerTo(EnemyX, EnemyY);
                                        p.cmbDelay = p.getCombatDelay();

				} else {
					if (p.playerEquipment[p.playerCape] == 9007) {
						if (Misc.random(100) >= 30) {
							p.DeleteArrow();
						}
					} else {
						p.DeleteArrow();
					}
					if (p.specNPCDamageDelay < 0) {
					p.cmbDelay = p.getCombatDelay();
		if (EnemyHP != 0) {
						if (p.playerEquipment[3] != 4734) {
							p.gfx100(p.getRangeGfx(p.playerEquipment[p.playerArrows], p.playerEquipment[3]));
						}
						p.setAnimation(p.GetWepAnim());
		}

						if (p.usingKnives()) {
							p.createPlayersProjectile(p.absY, p.absX, offsetY, offsetX, 50, 50, p.getRangePro(p.playerEquipment[p.playerArrows], p.playerEquipment[3]), 42, 31, p.attacknpc + 1);
						} else {
		if (EnemyHP != 0) {
							if (p.playerEquipment[3] == 15156) {
								p.createPlayersProjectile(p.absY, p.absX, offsetY, offsetX, 50, 75, p.getRangePro(p.playerEquipment[p.playerArrows], p.playerEquipment[3]), 44, 33, p.attacknpc + 1);
								p.createPlayersProjectile(p.absY, p.absX, offsetY, offsetX, 50, 75, p.getRangePro(p.playerEquipment[p.playerArrows], p.playerEquipment[3]), 40, 29, p.attacknpc + 1);
							} else {
								p.createPlayersProjectile(p.absY, p.absX, offsetY, offsetX, 50, 75, p.getRangePro(p.playerEquipment[p.playerArrows], p.playerEquipment[3]), 42, 31, p.attacknpc + 1);
							}
		}
						}
						p.updateRequired = true;
						p.appearanceUpdateRequired = true;
					}
			}//END CHECK FOR DEAD NPC

				}
			}
		}
	}

	public static void appendNPCDamage(clientHandler p) {
		try {
			int EnemyHP = GameEngine.npcHandler.npcs[p.attacknpc].HP;
			NPC p2 = (NPC) GameEngine.npcHandler.npcs[p.attacknpc];

			if (p == null || p2 == null) {
				return;
			}
			int p2Damage = Misc.random(p.calculateMelee());
			int atk = Misc.random(p.meleeAtk());
			int def = Misc.random(getNPCDefence(p));
			p2.AttackingOn = p.playerId;
			p2.RandomWalk = false;
			p2.IsUnderAttack = true;
			p2.faceplayer(p.playerId);
			p2.updateRequired = true;

			if (!p2.IsDead) {
				if (atk < def) {
					if (!p.fullVerac()) {
						p2.appendHit(0);
					} else {
						if (Misc.random(3) == 3) {
							p2.appendHit(p2Damage);
						}
					}
				} else {
					if ((EnemyHP - p2Damage) <= 0) {
						p2Damage = EnemyHP;
					}
					if ((EnemyHP < p2Damage)) {
						p2Damage = EnemyHP;
					}
					if (p.FullGuthanEquipped()) {
						int guthanHealAmt = 0;
						guthanHealAmt += p2Damage / 2;
						if(Misc.random(10) > 5 && p.playerLevel[3] < p.getLevelForXP(p.playerXP[p.playerHitpoints])) {
						p.updateHp(guthanHealAmt, true);
						p2.gfx100(398);
						}
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
						TotalExp = (double)(75 * p2Damage);
						TotalExp = (double)(TotalExp * p.CombatExpRate);
						p.addSkillXP((int)(TotalExp), p.playerDefence);
					}
					if (p.FightType == 3) { // Controlled
						TotalExp = (double)(35 * p2Damage);
						TotalExp = (double)(TotalExp * p.CombatExpRate);
						p.addSkillXP((int)(TotalExp), p.playerStrength);
						p.addSkillXP((int)(TotalExp), p.playerDefence);
						p.addSkillXP((int)(TotalExp), p.playerAttack);
					}
					p.addSkillXP((int)(37 * p2Damage), 3);
					p2.appendHit(p2Damage);
				}
				p2.animNumber = NPCEmotes.GetBlockAnim(p2);
                        	p2.animUpdateRequired = true;
                        	p2.updateRequired = true;
				p.setNPCDamageDelay(-1);
				return;	
			}
		} catch (Exception e) {
			return;
		}
	}

	public static void appendNPCSpecialDamage(clientHandler p) {
		try {
			int EnemyHP = GameEngine.npcHandler.npcs[p.attacknpc].HP;
			NPC p2 = (NPC) GameEngine.npcHandler.npcs[p.attacknpc];

			if (p == null || p2 == null) {
				return;
			}
			int p2Damage = Misc.random(p.calculateMelee());
			int atk = Misc.random(p.meleeAtk());
			int def = Misc.random(getNPCDefence(p));
			int clawDamage1 = (p2Damage/2);
			int clawDamage2 = Misc.random(p.calculateMelee());
			int clawDamage3 = (clawDamage2/2);
			int strBonus = Misc.random(p.playerLevel[1]/6);

			p2.AttackingOn = p.playerId;
			p2.RandomWalk = false;
			p2.IsUnderAttack = true;
			p2.faceplayer(p.playerId);
			p2.updateRequired = true;
			
			if (!p2.IsDead) {
				if (atk < def) {
					if (!p.fullVerac()) {
						p2.appendHit(0);
			 		} else {
						if (Misc.random(3) == 3) {
							p2.appendHit(p2Damage);
						}
					}
				} else {
					if ((EnemyHP - p2Damage) <= 0) {
						p2Damage = EnemyHP;
					}
					if ((EnemyHP < p2Damage)) {
						p2Damage = EnemyHP;
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
					p2.appendHit(clawDamage1);
					p2.appendHit(clawDamage2);
					p2.appendHit(clawDamage3);
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
						TotalExp = (double)(75 * p2Damage);
						TotalExp = (double)(TotalExp * p.CombatExpRate);
						p.addSkillXP((int)(TotalExp), p.playerDefence);
					}
					if (p.FightType == 3) { // Controlled
						TotalExp = (double)(35 * p2Damage);
						TotalExp = (double)(TotalExp * p.CombatExpRate);
						p.addSkillXP((int)(TotalExp), p.playerStrength);
						p.addSkillXP((int)(TotalExp), p.playerDefence);
						p.addSkillXP((int)(TotalExp), p.playerAttack);
					}
					p.addSkillXP((int)(37 * p2Damage), 3);
					p2.appendHit(p2Damage);
				}
				p2.animNumber = NPCEmotes.GetBlockAnim(p2);
                        	p2.animUpdateRequired = true;
                        	p2.updateRequired = true;
				p.setNPCSpecialDelay(-1);
				return;
			}
		} catch (Exception e) {
			return;
		}
	}

	public static void appendNPCRangeDamage(clientHandler p) {
		try {
			int EnemyHP = GameEngine.npcHandler.npcs[p.attacknpc].HP;
			NPC p2 = (NPC) GameEngine.npcHandler.npcs[p.attacknpc];

			if (p == null || p2 == null) {
				return;
			}

			int p2Damage = Misc.random(p.getRangeMaxHit());
			int p2DamageOther = Misc.random(p.getRangeMaxHit());
			int range = Misc.random(p.rangeAtk());
			int def = Misc.random(getNPCDefence(p));
		if (p.rangeNPCDelay == 0 && EnemyHP != 0) {
			p2.AttackingOn = p.playerId;
			p2.RandomWalk = false;
			p2.IsUnderAttack = true;
			p2.faceplayer(p.playerId);
			p2.updateRequired = true;

			if (range < def) {
				if (!p.fullVerac()) {
					p2.appendHit(0);
				} else {
					if (Misc.random(3) == 3) {
						p2.appendHit(p2Damage);
					}
				}

			} else {
				if ((EnemyHP - p2Damage) <= 0) {
					p2Damage = EnemyHP;
				}
				if ((EnemyHP < p2Damage)) {
					p2Damage = EnemyHP;
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

				if (p.playerEquipment[3] == 15156) {
					p2.appendHit(p2Damage);
					p2.appendHit(p2DamageOther);
				} else {
					p2.appendHit(p2Damage);
				}
			}

			if (Misc.random(100) >= 50) {
				if (!p.usingKnives()) {
					p.DropArrowsNPC();
				} else {
					p.DropOtherNPC();
				}
			}
			p2.animNumber = NPCEmotes.GetBlockAnim(p2);
                        p2.animUpdateRequired = true;
                        p2.updateRequired = true;
			p.setNPCRangeDelay(-1);
			return;
		}//CHECKS FOR RANGE DELAY

		} catch (Exception e) {
			return;
		}
	}
	public static int getNPCDefence(clientHandler p) {
		switch (GameEngine.npcHandler.npcs[p.attacknpc].npcType) {

			case 430:
				return 9000;
			case 3006:
				return 150;
			case 3007: case 3008:
				return 200;
			case 3010: case 3011:
				return 200;
			case 3012: case 3013: case 3014:
				return 250;
			case 3061:
			case 3340:
				return 200;
			case 3060:
				return 150;
			case 3002:
			case 3000:
			case 1975:
				return 325;
			case 3455:
				return 300;
			case 1:
				return 1;
			case 9:
				return 5;
			case 32:
				return 10;
			case 1677:
				return 5;
			case 1678:
				return 5;
			case 1644:
				return 100;
			case 110:
				return 150;
			case 941:
				return 190;
			case 54:
				return 250;
			case 55:
				return 290;
			case 53:
				return 320;
			case 52:
				return 190;
			case 2280:
				return 140;
			case 2279:
				return 120;
			case 2278:
				return 100;
			case 2277:
				return 80;
			case 2276:
				return 40;
			case 2275:
				return 30;
			case 2274:
				return 20;
			case 2031:
				return 100;
			case 2036:
				return 150;
			case 2025:
				return 150;
			case 2026:
				return 100;
			case 2027:
				return 150;
			case 2028:
				return 100;
			case 2029:
				return 150;
			case 2030:
				return 100;
			case 2745:
				return 280;
			case 2627:
				return 50;
			case 2629:
				return 90;
			case 2631:
				return 150;
			case 2742:
				return 150;
			case 2743:
			case 2744:
				return 300;
			case 1913:
				return 350;
			case 2881:
			case 2882:
			case 2883:
				return 100;
			case 1610:
			case 1615:
				return 90;
			case 83:
				return 80;
			case 1976:
			case 1978:
			case 1979:
				return 150;
			case 49:
				return 75;
		    default:
			return 1;
		}
	}
}