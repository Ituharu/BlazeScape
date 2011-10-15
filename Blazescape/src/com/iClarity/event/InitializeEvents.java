package com.iClarity.event;

import com.iClarity.player.*;
import com.iClarity.player.combat.*;

public class InitializeEvents {


	public static void initializeEvents(clientHandler player) {
		EventProcess(player);
		CombatEvents(player);

		EventManager.getSingleton().addEvent(new Event() {
				public void execute(EventContainer c) {
					PlayerHandler.messageToAll = "Join the forums at http://iClarity.ulmb.com/forums";
				}
		}, 60000);
	}

	public static void EventProcess(clientHandler player) {
		p = player;

		EventManager.getSingleton().addEvent(new Event() {
			public void execute(EventContainer c) {
				p.freezeDelay--;

				if (p.multiZone()) {
					p.frame61(1);
				} else {
					p.frame61(0);
				}
				if (p.Wild() || (p.duelArena() && p.duelStatus == 3)) {
					p.ShowOption(2, "Attack");
					p.ShowOption(3, "Follow");
					p.ShowOption(4, "Trade With");
				} else {
					p.ShowOption(2, "null");
					p.ShowOption(3, "Follow");
					p.ShowOption(4, "Trade With");
				}
				if (p.duelArena() && p.duelStatus != 3) {
					p.ShowOption(5, "Challenge");
				} else {
					p.ShowOption(5, "null");
				}
				if (p.isRunning2) {
					p.isRunning = true;
				}
				if (!p.isRunning2) {
					p.isRunning = false;
				}
				if (p.drainDelay > 0) {
	    				p.drainDelay--;
				}
				if (p.drainDelay == 0 && p.usingPrayer) {
	    				p.drainPrayer();
				}
				if (p.vengDelay > 0) {
	    				p.vengDelay--;
				}
				if (p.vengUseDelay > 0) {
	    				p.vengUseDelay--;
				}
				if (p.vengDelay <= 0 && p.usingVeng) {
	    				p.usingVeng = false;
	    				p.sendMessage("Vengeance has faded away.");
				}
				if (p.skullTimer > 0) {
					p.skullTimer--;
				}
				if (p.deathTimer > 0) {
					p.deathTimer--;
				}
				if (p.thiefDelay > 0) {
					p.thiefDelay--;
				}
				if (p.duelStartDelay > 0) {
					p.duelStartDelay--;
				}
				if (p.craftDelay > 0) {
					p.craftDelay--;
				}
				if (p.msbDelay > 0) {
					p.msbDelay--;
				}
				if (p.restoreTimer > 0) {
					p.restoreTimer--;
				}
				if (p.teleDelay > 0) {
					p.teleDelay--;
				}
				if (p.leverDelay > 0) {
					p.leverDelay--;
				}
				if (p.walkDelay > 0) {
					p.walkDelay--;
				}
				if (p.actionTimer > 0) {
					p.actionTimer--;
				}
				if (p.magicDmgDelay > 0) {
					p.magicDmgDelay--;
				}
				if (p.magicDelay > 0) {
					p.magicDelay--;
				}
				if (p.LogoutDelay > 0) {
					p.LogoutDelay--;
				}
				if (p.skullTimer <= 0) {
					p.SetPkHeadIcon(0);
					p.skullTimer = -1;
				}
				if (p.WaveDelay > 0) {
					p.WaveDelay--;
				}
				if (p.killNpcTimer > 0) {
					p.killNpcTimer--;
				}
			}
		}, 500);
	}

	public static void CombatEvents(clientHandler player) {
		p = player;

		EventManager.getSingleton().addEvent(new Event() {
			public void execute(EventContainer c) {
				if (p.resetCmb > 0) {
					p.resetCmb--;
				}
				if (p.inCombat > 0) {
					p.inCombat--;
				}
				if (p.cmbDelay > 0) {
					p.cmbDelay--;
				}
				if (p.combatDelay > 0) {
					p.combatDelay--;
				}
				if (p.specNPCDamageDelay > 0) {
					p.specNPCDamageDelay--;
				}	
				if (p.specNPCDamageDelay == 0) {
					NpcCombat.appendNPCSpecialDamage(p);
					p.setNPCSpecialDelay(-1);
				}
				if (p.rangeDelay > 0) {
					p.rangeDelay--;
				}
				if (p.rangeDelay == 0) {
					PlayerCombat.appendRangeDamage(p);
					p.setRangeDelay(-1);
				}
				if (p.damageNPCDelay > 0) {
					p.damageNPCDelay--;
				}		
				if (p.damageNPCDelay == 0) {
					NpcCombat.appendNPCDamage(p);
					p.setNPCDamageDelay(-1);
				}
				if (p.specDamageDelay > 0) {
					p.specDamageDelay--;
				}		
				if (p.specDamageDelay == 0) {
					PlayerCombat.appendSpecialDamage(p);
					p.setSpecialDelay(-1);
				}
				if (p.damageDelay > 0) {
					p.damageDelay--;
				}		
				if (p.damageDelay == 0) {
					PlayerCombat.appendDamage(p);
					p.setDamageDelay(-1);
				}		
				if (p.rangeNPCDelay > 0) {
					p.rangeNPCDelay--;
				}		
				if (p.rangeNPCDelay == 0) {
					NpcCombat.appendNPCRangeDamage(p);
					p.setNPCRangeDelay(-1);
				}
			}
		}, 500);
	}

	private static clientHandler p;
}