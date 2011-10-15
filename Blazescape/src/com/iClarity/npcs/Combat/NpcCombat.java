package com.iClarity.npcs.Combat;

import java.io.*;
import com.iClarity.npcs.*;
import com.iClarity.misc.*;
import com.iClarity.player.*;
import com.iClarity.GameEngine;

public class NpcCombat {

	/*
	 * Constructor
	 */
	public NpcCombat() {

	}

	/*
	 * Apply melee damage to the opposing Player.
	 */
	public static void appendMeleeDamage(NPC n) {
		try {
			clientHandler p2 = (clientHandler) GameEngine.playerHandler.players[n.AttackingOn];

			if (n == null || p2 == null) {
				return;
			}
			int p2Damage = Misc.random(n.GetNpcMaxHit());
			int atk = Misc.random(n.GetNpcAttack());
			int def = Misc.random(p2.meleeDef());
				n.setDamageDelay(-1);

			if (!p2.IsDead) {
				if (atk < def) {
				    if (n.npcType != 2030) {
					p2.appendHit(0);
			 	    } else {
					if (Misc.random(3) >= 2) {
						p2.appendHit(p2Damage);
					} else {
						p2.appendHit(0);
					}
				    }
				} else {
					if (p2.playerLevel[3] <= p2Damage) {
						p2Damage = p2.playerLevel[3];
					}
					if (p2.meleePrayer) {
						if (n.npcType != 2030) {
							//p2Damage = ((100*(Misc.random(n.GetNpcMaxHit()))) / 95);
							p2Damage = (Misc.random(n.GetNpcMaxHit()) / 3);
						} else {
							if (Misc.random(3) < 2) {
								p2Damage = 0;
							}
						}
					}
					p2.appendHit(p2Damage);

					if (p2.usingVeng) {
						n.appendHit((int)((p2Damage / 4) * 3));
						p2.vengDelay = 0;
						p2.usingVeng = false;
						p2.txt4 = "Taste Vengeance!";
						p2.string4UpdateRequired = true;
					}
				}

				p2.startAnimation(p2.GetBlockAnim());
				n.setDamageDelay(-1);
				return;
			}
		} catch (Exception e) {
			return;
		}
	}

	/*
	 * Apply ranged damage to the opposing Player.
	 */
	public static void appendRangeDamage(NPC n) {
		try {
			clientHandler p2 = (clientHandler) GameEngine.playerHandler.players[n.AttackingOn];

			if (n == null || p2 == null) {
				return;
			}
			int p2Damage = Misc.random(n.GetNpcMaxHit());
			int atk = Misc.random(n.GetNpcAttack());
			int def = Misc.random(p2.rangeDef());

			if (!p2.IsDead) {
				if (atk < def) {
					p2.appendHit(0);
				} else {
					if (p2.playerLevel[3] <= p2Damage) {
						p2Damage = p2.playerLevel[3];
					}
					if (p2.rangedPrayer) {
						p2Damage = 0;
					}
					if (n.npcType == 2745) {
						p2.playerGfx(157, 0);
					}
					p2.appendHit(p2Damage);

					if (p2.usingVeng) {
						n.appendHit((int)((p2Damage / 4) * 3));
						p2.vengDelay = 0;
						p2.usingVeng = false;
						p2.txt4 = "Taste Vengeance!";
						p2.string4UpdateRequired = true;
					}
				}
				p2.startAnimation(p2.GetBlockAnim());
				n.setRangeDelay(-1);
				return;
			}
		} catch (Exception e) {
			return;
		}
	}

	/*
	 * Apply magic damage to the opposing Player.
	 */
	public static void appendMageDamage(NPC n) {
		try {
			clientHandler p2 = (clientHandler) GameEngine.playerHandler.players[n.AttackingOn];

			if (n == null || p2 == null) {
				return;
			}
			int p2Damage = Misc.random(n.GetNpcMaxHit());
			int atk = Misc.random(n.GetNpcAttack());
			int def = Misc.random(p2.magicDefence());

			if (!p2.IsDead) {
				if (atk < def) {
					if (n.npcType == 1913) {
						p2.gfx0(369);
					}
					p2.appendHit(0);
				} else {
					if (p2.playerLevel[3] <= p2Damage) {
						p2Damage = p2.playerLevel[3];
					}
					if (p2.magicPrayer) {
						p2Damage = 0;
					}
					if (n.npcType == 2025) {
						p2.gfx100(157);
						p2.updateRequired = true;
					}
					if (n.npcType == 1913) {
						p2.gfx0(369);
						p2.appendHit(Misc.random(6));

						if (p2.freezeDelay <= -4) {
							p2.stopMovement();
							p2.freezeDelay = 25;
						}
					}
					if (p2.usingVeng) {
						n.appendHit((int)((p2Damage / 4) * 3));
						p2.vengDelay = 0;
						p2.usingVeng = false;
						p2.txt4 = "Taste Vengeance!";
						p2.string4UpdateRequired = true;
					}
					if (n.npcType != 1913) {
						p2.appendHit(p2Damage);
					}
				}

				p2.startAnimation(p2.GetBlockAnim());
				p2.updateRequired = true;
				n.setMageDelay(-1);
				return;
			}
		} catch (Exception e) {
			return;
		}
	}

	/*
	 * The distance the Npc has to be within to attack the opposing player.
	 */
	public static int getNpcDistance(NPC n) {
		switch (n.npcType) {

			case 1913:
				return 3;

			default:
				return 10;
		}
	}

	/*
	 * Attacking method.
	 */
	public static void Attack(NPC n) {
                clientHandler p2 = (clientHandler) GameEngine.playerHandler.players[n.AttackingOn];
		int EnemyX = p2.absX;
		int EnemyY = p2.absY;
                int offsetX = ((n.absX + n.getSize() / 2) - p2.absX) * -1;
                int offsetY = ((n.absY + n.getSize() / 2) - p2.absY) * -1;
		p2.updateRequired = true;
		p2.appearanceUpdateRequired = true;

		if (p2 == null) {
			n.ResetAttack();
			return;
		}
		n.FollowPlayerCB(n.npcType, p2.playerId);


		if (((p2.absY - n.absY > 10  || n.absY - p2.absY > 10 || p2.absX - n.absX > 10  || n.absX - p2.absX > 10) && !(n.npcType >= 2734 && n.npcType <= 2745))) {
			return;
		}
		if(p2.IsDead || n.IsDead) {
			return;
		}
		if (n.GoodDistance(EnemyX, EnemyY, n.absX, n.absY, 1) == false && !n.usingRM()) {
			return;
		}
		if (n.npcType >= 1532 && n.npcType <= 1535) {
			return;
		}

		if(p2.heightLevel != n.heightLevel) {
			n.ResetAttack();
			return;
		}
		if (n.GoodDistance(EnemyX, EnemyY, n.absX, n.absY, getNpcDistance(n)) == false && n.usingRM() && n.npcType != 1183  && !(n.npcType >= 2734 && n.npcType <= 2745)) {
			return;
		}
			
		if (n.combatDelay <= 0) {
			n.faceplayer(n.AttackingOn);

			if (!n.usingRM()) {
				n.setDamageDelay(1);
				n.appendAnim(NPCEmotes.GetMeleeEmote(n));
				n.combatDelay = n.getCombatDelay();

				switch (n.npcType) {

					case 2627:
                        			p2.changeStat(5, 1, 0, false);
						break;

case 3340://giant mole
int changeArea = Misc.random(50);
	if(changeArea == 37 || changeArea == 42) {
		if(GameEngine.moleTeleports < 4) {

		    p2.ResetAttack();
		    n.ResetAttack();
		    GameEngine.moleTeleports++;

		    int moleArea = Misc.random(100);
			if(moleArea >= 0 && moleArea <= 25) {
				n.absX = 1776;
				n.absY = 5235;
				p2.sendMessage("The Giant Mole has traveled North-East.");
			}
			if(moleArea >= 26 && moleArea <= 50) {
				n.absX = 1737;
				n.absY = 5222;
				p2.sendMessage("The Giant Mole has appeared to the North-West.");
			}
			if(moleArea >= 51 && moleArea <= 75) {
				n.absX = 1760;
				n.absY = 5183;
				p2.sendMessage("The Giant Mole has surfaced in the center.");
			}
			if(moleArea >= 76 && moleArea <= 100) {
				n.absX = 1759;
				n.absY = 5161;
				p2.sendMessage("The Giant Mole has gone to the South.");
			}
		}
	}
break;
				}
			} else {
				n.combatDelay = n.getCombatDelay();

				switch (n.npcType) {


					case 1913:
						int k = Misc.random(2);

						if (k == 0 || k == 1) {
							n.setMageDelay(3);
							n.appendAnim(NPCEmotes.GetMageEmote(n));
							//n.requestText("Sallamakar Ro!");
						} else {
							if (n.GoodDistance(EnemyX, EnemyY, n.absX, n.absY, 1)) {
								n.setDamageDelay(1);
								n.appendAnim(NPCEmotes.GetMeleeEmote(n));
							}
						}
						break;


					case 83:
						n.appendAnim(NPCEmotes.GetMageEmote(n));
						n.setMageDelay(4);
						p2.createPlayersProjectile(n.absY, n.absX, offsetY, offsetX, 50, 100, 156, 37, 31, -n.AttackingOn - 1);
						break;

					case 2025:
						n.appendAnim(NPCEmotes.GetMageEmote(n));
						n.setMageDelay(4);
						p2.createPlayersProjectile(n.absY, n.absX, offsetY, offsetX, 50, 100, 156, 37, 31, -n.AttackingOn - 1);
						break;

					case 1183://Elf Warrior
						n.setRangeDelay(3);
						n.appendAnim(NPCEmotes.GetRangeEmote(n));
						break;

					case 2028:
						n.setRangeDelay(3);
						n.appendAnim(NPCEmotes.GetRangeEmote(n));
						p2.createProjectile2(n.absY + 1, n.absX + 1, offsetY, offsetX, 28, 43, 37, 31, -n.AttackingOn - 1);
						break;

					case 3012://GrimSpike
						n.setRangeDelay(3);
						n.appendAnim(NPCEmotes.GetMeleeEmote(n));
						p2.createProjectile2(n.absY + 2, n.absX + 2, offsetY, offsetX, 41, 100, 37, 31, -n.AttackingOn - 1);
					break;

					case 3011:
						n.appendAnim(NPCEmotes.GetMageEmote(n));
						n.setMageDelay(4);
						p2.gfx100(76);
						break;

					case 3006: case 3007: case 3008://Avians
						int i3 = Misc.random(1);									if(n.GoodDistance(EnemyX, EnemyY, n.absX, n.absY, 3)) {
							if (i3 == 0) {
								n.setMageDelay(1);
								appendMageDamage(n);
								p2.createPlayersProjectile(n.absY, n.absX, offsetY, offsetX, 50, 100, 159, 37, 31, -n.AttackingOn - 1);
n.appendAnim(NPCEmotes.GetMageEmote(n));
							} else {
								appendMeleeDamage(n);
n.appendAnim(NPCEmotes.GetMeleeEmote(n));
							}
						}
					break;


					case 50:
					case 53:
					case 54:
					case 55://Dragons
						int i2 = Misc.random(3);
						if(n.GoodDistance(EnemyX, EnemyY, n.absX, n.absY, 3)) {
							if (i2 == 0) {
								n.setMageDelay(1);
								appendMageDamage(n);
								n.gfx100(1);
								p2.createPlayersProjectile(n.absY, n.absX, offsetY, offsetX, 50, 1, 156, 37, 31, -n.AttackingOn - 1);
								n.appendAnim(NPCEmotes.GetMageEmote(n));
							} else {
								appendMeleeDamage(n);
								n.appendAnim(NPCEmotes.GetMeleeEmote(n));
							}
						} else {
							if (i2 == 1 || i2 == 0) {
n.appendAnim(NPCEmotes.GetMageEmote(n));
								i2 = 1;
						} else {
n.appendAnim(NPCEmotes.GetMeleeEmote(n));
						}
					}
					break;


					case 2745:
						int i1 = Misc.random(2);

						if (n.GoodDistance(EnemyX, EnemyY, n.absX, n.absY, 2)) {

							if (i1 == 1) {
								n.appendAnim(NPCEmotes.GetRangeEmote(n));
 							} else if (i1 == 2) {
								n.appendAnim(NPCEmotes.GetMageEmote(n));
							} else {
								appendMeleeDamage(n);
 								n.appendAnim(NPCEmotes.GetMeleeEmote(n));
							}
						} else {
							if (i1 == 1 || i1 == 0) {
								n.appendAnim(NPCEmotes.GetRangeEmote(n));
								i1 = 1;
							} else {
								 n.appendAnim(NPCEmotes.GetMageEmote(n));
							}
						}
						if (i1 == 1) {
							n.setRangeDelay(7);
							p2.gfx100(454);
							p2.playerGfx(454, 100);
							break;
						}
						if (i1 == 2) {
							p2.createProjectile2(n.absY + 2, n.absX + 2, offsetY, offsetX, 451, 150, 31, 100, -n.AttackingOn - 1);
							p2.createProjectile2(n.absY + 2, n.absX + 2, offsetY, offsetX, 452, 150, 31, 105, -n.AttackingOn - 1);
							p2.createProjectile2(n.absY + 2, n.absX + 2, offsetY, offsetX, 453, 150, 31, 110, -n.AttackingOn - 1);
							p2.playerGfx(157, 101);
							n.setMageDelay(5);
							break;
						}
						break;


				case 2743:
				case 2744:
					int l = Misc.random(2);

  					if (n.GoodDistance(EnemyX, EnemyY, n.absX, n.absY, 2)) {
						if (l == 1) {
							n.appendAnim(NPCEmotes.GetMageEmote(n));
                            				p2.createProjectile2(n.absY + 2, n.absX + 2, offsetY, offsetX, 447, 100, 31, 80, -n.AttackingOn - 1);
							n.setMageDelay(5);
						} else {
							n.appendAnim(NPCEmotes.GetMeleeEmote(n));
							appendMeleeDamage(n);
						}
					} else {
						n.appendAnim(NPCEmotes.GetMageEmote(n));
						p2.createProjectile2(n.absY + 2, n.absX + 2, offsetY, offsetX, 447, 100, 31, 80, -n.AttackingOn - 1);
						n.setMageDelay(3);
						p2.playerGfx(448, 80);
					}
					break;
					case 2631:
						p2.createProjectile2(n.absY + 1, n.absX + 1, offsetY, offsetX, 443, 43, 31, 85, -n.AttackingOn - 1);
						n.setRangeDelay(4);
						n.appendAnim(NPCEmotes.GetRangeEmote(n));
						break;

				case 2779:
						p2.createProjectile2(n.absY + 1, n.absX + 1, offsetY, offsetX, 443, 43, 26, 85, -n.AttackingOn - 1);
						n.setRangeDelay(4);
						n.appendAnim(NPCEmotes.GetRangeEmote(n));
					break;


				    default:
					p2.createPlayersProjectile(n.absY, n.absX, offsetY, offsetX, 50, 75, 27, 42, 31, -n.AttackingOn - 1);
					break;
				}
			}
		}
	}
}