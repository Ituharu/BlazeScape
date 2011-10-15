/*
 * Smelting Class
 * Author - Corey
 * Date - April 14 2010
 * 
 */
package com.iClarity.player.Skills;

import com.iClarity.player.clientHandler;
import com.iClarity.event.Event;
import com.iClarity.event.EventManager;
import com.iClarity.event.EventContainer;

public class Smelting {
	
	
	public int amountToSmelt;

	public void smelt(final clientHandler p, final int req, final int ore, final int ore2, final 

int bar, final int experience, final int amount) {
		if(p.playerHasItemAmount(ore, 1) || p.playerHasItemAmount(ore2, amount) && p.hasItem(ore2)) {
			if(p.playerLevel[13] >= req) {
				p.addItem(bar, 1);
				p.deleteItem(ore, p.getItemSlot(ore), 1);
				p.deleteItem(ore2, p.getItemSlot(ore2), amount);
				p.addSkillXP(experience, 13);
				p.startAnimation(899);
				p.sendMessage("You smelt a " + p.getItemName(bar) + ".");		

	
			} else {
				p.sendMessage("You need a Smithing level of " + req + " to make a " + p.getItemName(bar) + "!");
			}
		} else if(!p.hasItem(ore)) {
			p.sendMessage("You need some more " + p.getItemName(ore) + " to smelt here.");
		} else if(!p.hasItem(ore2)) {
			p.sendMessage("You need some more " + p.getItemName(ore2) + " to smelt here.");
		}
		EventManager.getSingleton().addEvent(new Event() {
			public void execute(EventContainer ec) {
				if(amountToSmelt == 0 || !p.hasItem(ore) || !p.hasItem(ore2)) {
					p.isSmelting = false;
					ec.stop();
					return;
				}
				if(p.playerLevel[13] < req) {
					p.isSmelting = false;
					ec.stop();
					return;
				}
				if(p.playerHasItemAmount(ore, 1) || p.playerHasItemAmount(ore2, amount) && p.hasItem(ore2)) {
					if(p.playerLevel[13] >= req) {
						p.addItem(bar, 1);
						p.deleteItem(ore, p.getItemSlot(ore), 1);
						p.deleteItem(ore2, p.getItemSlot(ore2), amount);
						p.addSkillXP(experience, 13);
						p.startAnimation(899);
						p.sendMessage("You smelt a " + p.getItemName(bar) + ".");	
					} else {
						p.sendMessage("You need a Smithing level of " + req + " to make a " + p.getItemName(bar) + "!");
					}
				} else if(!p.hasItem(ore)) {
					p.sendMessage("You need some more " + p.getItemName(ore) + " to smelt here.");
				} else if(!p.hasItem(ore2)) {
					p.sendMessage("You need some more " + p.getItemName(ore2) + " to smelt here.");
				}
				amountToSmelt--;
			}
		}, 3000);
	}
	
	public void startSmelt(clientHandler p) {
		if(p.choiceClick == 1) {
			smelt(p, 1, 436, 438, 2349, 6 * 3, 1);//Bronze
		}
		if(p.choiceClick == 2) {
			smelt(p, 15, 440, -1, 2351, 12 * 3, 0);//Iron
		}
		if(p.choiceClick == 3) {
			smelt(p, 20, 442, -1, 2353, 14 * 3, 0);//Silver
		}
		if(p.choiceClick == 4) {
			smelt(p, 30, 440, 453, 2355, 18 * 3, 2);//Steel
		}
		if(p.choiceClick == 5) {
			smelt(p, 40, 444, -1, 2357, 22 * 3, 0);//Gold
		}
		if(p.choiceClick == 6) {
			smelt(p, 50, 447, 453, 2359, 30 * 3, 4);//Mith
		}
		if(p.choiceClick == 7) {
			smelt(p, 70, 449, 453, 2361, 37 * 3, 6);//Adamant
		}
		if(p.choiceClick == 8) {
			smelt(p, 85, 451, 453, 2363, 50 * 3, 8);//Runite
		}
	}
}
