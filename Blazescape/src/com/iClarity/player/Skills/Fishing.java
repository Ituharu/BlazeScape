/* Class Fishing
 * 
 * Version 1.0
 * 
 * @Author Corey
 * @Date April 10-2010
 * 
 */



package com.iClarity.player.Skills;

import com.iClarity.player.clientHandler;
import com.iClarity.event.Event;
import com.iClarity.event.EventManager;
import com.iClarity.event.EventContainer;
import com.iClarity.misc.*;

import java.util.Random;

public class Fishing {
	
	/*
	 * [0] = IsFishing = True/False
	 * [1] = Required Level to Fish
	 * [2] = Required Lure to Fish
	 * [3] = Required Bait to Fish; -1 if none
	 * [4] = Animation
	 * [5] = Experience Gained
	 * [6] = Fish
	 * [7] = Fishing Timer
	 * 
	 */
	
	public int amountToFish;
	
	public int fishing[] = {0, 0, -1, -1, -1, 0, 0, -1}; // Fishing Variables
	
	public void fish(final clientHandler p) {
		if(p.playerHasItem(fishing[2])) {
			if(p.playerHasItem(fishing[3])) {
				if(fishing[0] == 1 && p.actionTimer == 0 && p.playerLevel[10] >= fishing[1] && p.freeSlots() >= 1) {
					p.deleteItem(fishing[3], p.getItemSlot(fishing[3]), 1);
					p.addItem(fishing[6], 1);
					p.addSkillXP(fishing[5], 10);
					p.startAnimation(fishing[4]);
					p.sendMessage("You catch some "+p.getItemName(fishing[6]));
					p.actionTimer = fishing[7];
				} else if(p.playerLevel[10] < fishing[1]) {
					p.sendMessage("You need level "+fishing[1]+" Fishing to fish here.");
					resetFishing(p);
				} else if(p.freeSlots() == 0) {
					p.sendMessage("You do not have enough space in your inventory.");
					resetFishing(p);
				}
			} else if(!p.playerHasItem(fishing[3])) {
				p.sendMessage("You need some " +p.getItemName(fishing[3])+ " to fish here.");
				resetFishing(p);
			}
		} else if(!p.playerHasItem(fishing[2])) {
			p.sendMessage("You need a " +p.getItemName(fishing[2])+ " to fish here.");
			resetFishing(p);
		}
		EventManager.getSingleton().addEvent(new Event() {
			public void execute(EventContainer ec) {
				if(amountToFish == 0 || !p.playerHasItem(fishing[2]) || !p.playerHasItem(fishing[3])) {
					resetFishing(p);
					ec.stop();
					return;
				}
				if(p.playerLevel[10] < fishing[1]) {
					p.sendMessage("You need a fishing level of "+fishing[1]+" to fish here.");
					ec.stop();
				}
				if(p.playerHasItem(fishing[2])) {
					if(p.playerHasItem(fishing[3])) {
						if(fishing[0] == 1 && p.actionTimer == 0 && p.playerLevel[10] >= fishing[1] && p.freeSlots() >= 1) {
							p.deleteItem(fishing[3], p.getItemSlot(fishing[3]), 1);
							p.addItem(fishing[6], 1);
							p.addSkillXP(fishing[5], 10);
							p.startAnimation(fishing[4]);
							p.sendMessage("You catch some "+p.getItemName(fishing[6]));
							p.actionTimer = fishing[7];
						} else if(p.playerLevel[10] < fishing[1]) {
							p.sendMessage("You need level "+fishing[1]+" Fishing to fish here.");
							resetFishing(p);
						} else if(p.freeSlots() == 0) {
							p.sendMessage("You do not have enough space in your inventory.");
							resetFishing(p);
						}
					} else if(!p.playerHasItem(fishing[3])) {
						p.sendMessage("You need some " +p.getItemName(fishing[3])+ " to fish here.");
						resetFishing(p);
					}
				} else if(!p.playerHasItem(fishing[2])) {
					p.sendMessage("You need a " +p.getItemName(fishing[2])+ " to fish here.");
					resetFishing(p);
				}
				amountToFish--;
			}
		}, 3000);
	}
	
	public void fishSpots(clientHandler p, int npcId, int packet) {
			switch (npcId) {
		
			case 316://Shrimp [Spot 1]
				if(packet == 1) {
					fishing[0] = 1;
					fishing[1] = 1;
					fishing[2] = 303;
					fishing[3] = -1;
					fishing[4] = 621;
					fishing[5] = 10 * 3;
					fishing[6] = 317;
					fishing[7] = 5 + (Misc.random(22) - (p.playerLevel[10] / 6));
					fishingTimeOut(p);
					p.startAnimation(fishing[4]);
					p.sendMessage("You attempt to catch some fish.");
					fish(p);
				}
				break;
			case 318://Herring [Spot 2]
				if(packet == 1) {
					fishing[0] = 1;
					fishing[1] = 10;
					fishing[2] = 307;
					fishing[3] = 313;
					fishing[4] = 622;
					fishing[5] = 30 * 3;
					fishing[6] = 345;
					fishing[7] = 5 + (Misc.random(25) - (p.playerLevel[10] / 6));
					fishingTimeOut(p);
					p.startAnimation(fishing[4]);
					p.sendMessage("You attempt to catch some fish.");
					fish(p);
				}
				break;
				
			case 1237://Trout [Spot 3]
				if(packet == 1) {
					fishing[0] = 1;
					fishing[1] = 20;
					fishing[2] = 309;
					fishing[3] = 314;
					fishing[4] = 622;
					fishing[5] = 50 * 3;
					fishing[6] = 335;
					fishing[7] = 5 + (Misc.random(28) - (p.playerLevel[10] / 6));
					fishingTimeOut(p);
					p.startAnimation(fishing[4]);
					p.sendMessage("You attempt to catch some fish.");
					fish(p);
				}
				break;
				
			case 1238://Salmon [Spot 4]
				if(packet == 1) {
					fishing[0] = 1;
					fishing[1] = 30;
					fishing[2] = 309;
					fishing[3] = 314;
					fishing[4] = 622;
					fishing[5] = 70 * 3;
					fishing[6] = 331;
					fishing[7] = 5 + (Misc.random(32) - (p.playerLevel[10] / 6));
					fishingTimeOut(p);
					p.startAnimation(fishing[4]);
					p.sendMessage("You attempt to catch some fish.");
					fish(p);
				}
				break;
				
			case 1177://Tuna [Spot 5]
				if(packet == 1) {
					fishing[0] = 1;
					fishing[1] = 35;
					fishing[2] = 311;
					fishing[3] = -1;
					fishing[4] = 618;
					fishing[5] = 80 * 3;
					fishing[6] = 359;
					fishing[7] = 5 + (Misc.random(34) - (p.playerLevel[10] / 6));
					fishingTimeOut(p);
					p.startAnimation(fishing[4]);
					p.sendMessage("You attempt to catch some fish.");
					fish(p);
				}
				break;
				
			case 321://Lobster [Spot 6]
				if(packet == 1) {
					fishing[0] = 1;
					fishing[1] = 40;
					fishing[2] = 301;
					fishing[3] = -1;
					fishing[4] = 619;
					fishing[5] = 90 * 3;
					fishing[6] = 377;
					fishing[7] = 5 + (Misc.random(39) - (p.playerLevel[10] / 6));
					fishingTimeOut(p);
					p.startAnimation(fishing[4]);
					p.sendMessage("You attempt to catch some fish.");
					fish(p);
				}
				break;
				
			case 3848://Swordfish [Spot 7]
				if(packet == 1) {
					fishing[0] = 1;
					fishing[1] = 50;
					fishing[2] = 311;
					fishing[3] = -1;
					fishing[4] = 618;
					fishing[5] = 100 * 3;
					fishing[6] = 371;
					fishing[7] = 5 + (Misc.random(41) - (p.playerLevel[10] / 6));
					fishingTimeOut(p);
					p.startAnimation(fishing[4]);
					p.sendMessage("You attempt to catch some fish.");
					fish(p);
				}
				break;
				
			case 1176://Monkfish [Spot 8]
				if(packet == 1) {
					fishing[0] = 1;
					fishing[1] = 62;
					fishing[2] = 303;
					fishing[3] = -1;
					fishing[4] = 621;
					fishing[5] = 120 * 3;
					fishing[6] = 7944;
					fishing[7] = 5 + (Misc.random(42) - (p.playerLevel[10] / 6));
					fishingTimeOut(p);
					p.startAnimation(fishing[4]);
					p.sendMessage("You attempt to catch some fish.");
					fish(p);
				}
				break;
				
			case 1333://Shark [Spot 9]
				if(packet == 1) {
					fishing[0] = 1;
					fishing[1] = 76;
					fishing[2] = 311;
					fishing[3] = -1;
					fishing[4] = 618;
					fishing[5] = 110 * 3;
					fishing[6] = 383;
					fishing[7] = 5 + (Misc.random(43) - (p.playerLevel[10] / 6));
					fishingTimeOut(p);
					p.startAnimation(fishing[4]);
					p.sendMessage("You attempt to catch some fish.");
					fish(p);
				}
				break;
				
			case 1178://Manta [Spot 10]
				if(packet == 1) {
					fishing[0] = 1;
					fishing[1] = 79;
					fishing[2] = 303;
					fishing[3] = -1;
					fishing[4] = 620;
					fishing[5] = 46 * 3;
					fishing[6] = 389;
					fishing[7] = 5 + (Misc.random(44) - (p.playerLevel[10] / 6));
					p.startAnimation(fishing[4]);
					p.sendMessage("You attempt to catch some fish.");
					fishingTimeOut(p);
					fish(p);
				}
				break;		
			}
	}
	
	public void fishingTimeOut(clientHandler p) {
		if(p.fishingTimer == 0) {
			p.fishingTimer = 500;
		}
		if(p.fishingTimer == 1) {
			p.disconnected = true;
			p.fishingTimer = 0;
			resetFishing(p);
		}
		if(p.fishingTimer < 500 && p.playerRights > 2) {
			p.sendMessage("Fishing Timeout left: " +p.fishingTimer+".");
		}
	}
	
	public boolean resetFishing(clientHandler p) {
		fishing[0] = 0;
		fishing[1] = 0;
		fishing[2] = -1;
		fishing[3] = -1;
		fishing[4] = -1;
		fishing[5] = 0;
		fishing[6] = 0;
		fishing[7] = -1;
		p.fishingTimer = 0;
		return true;
		}

}
