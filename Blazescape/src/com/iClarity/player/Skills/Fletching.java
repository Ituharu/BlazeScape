/*
 * Fletching Class Rewritten By Corey
 * 
 * April 10, 2010
 * 
 * Version 0.8
 * 
 */

package com.iClarity.player.Skills;

import com.iClarity.event.Event;
import com.iClarity.event.EventManager;
import com.iClarity.event.EventContainer;
import com.iClarity.player.clientHandler;
import com.iClarity.misc.*;

public class Fletching {

	
	public int bow;
	public int unstrung;
	public int logs;
	public int amountToFletch;
	public int amountToFlax;
	
	
	public void startFletching(final clientHandler p, final int type, final int req, final int 
logs, final int bow, final int shaft, final int experience, final int timer) {
		if(type == 1) {
			if(p.playerHasItemAmount(logs, 1)) {
				if(p.playerLevel[9] >= req) {
					p.addItem(bow, 1);
					p.deleteItem(logs, p.getItemSlot(logs), 1);
					p.addSkillXP(experience, 9);
					p.actionTimer = timer;
					p.startAnimation(1248);
					p.sendMessage("You make a " + p.getItemName(bow) + ".");
				} else {
					p.sendMessage("You need a Fletching level of " +req+ " to make this!");
				}
			} else {
				p.sendMessage("You need some more " + p.getItemName(logs) + "!");
			}
		}
		if(type == 2) {
			if(p.playerHasItemAmount(logs, 1)) {
				if(p.playerLevel[9] >= req) {
					p.addItem(shaft, (15 + Misc.random(15)));
					p.deleteItem(logs, p.getItemSlot(logs), 1);
					p.addSkillXP(experience, 9);
					p.actionTimer = timer;
					p.startAnimation(1248);
					p.sendMessage("You make some " + p.getItemName(shaft) + "s.");
				} else {
					p.sendMessage("You need a Fletching level of " +req+ " to make this!");
				}
			}
		}
		if(type == 3) {
			if(p.playerHasItemAmount(logs, 1)) {
				if(p.playerLevel[9] >= req) {
					p.addItem(bow, 1);
					p.deleteItem(logs, p.getItemSlot(logs), 1);
					p.addSkillXP(experience, 9);
					p.actionTimer = timer;
					p.startAnimation(1248);
					p.sendMessage("You make a " + p.getItemName(bow) + ".");
				} else {
					p.sendMessage("You need a Fletching level of " +req+ " to make this!");
				}
			} else {
				p.sendMessage("You need some more " + p.getItemName(logs) + "!");
			}
		}
		EventManager.getSingleton().addEvent(new Event() {
			public void execute(EventContainer ec) {
				if(amountToFletch == 0) {
					p.isFletching = false;
					ec.stop();
					return;
				}
				if(p.playerLevel[9] < req) {
					p.sendMessage("You need a Fletching level of " +req+ " to make this!");
					ec.stop();
					return;
				}
				if(!p.playerHasItemAmount(logs, 1)) {
					p.resetFletching();
					return;
				}
				if(type == 1) {
					if(p.playerHasItemAmount(logs, 1)) {
						if(p.playerLevel[9] >= req) {
							p.addItem(bow, 1);
							p.deleteItem(logs, p.getItemSlot(logs), 1);
							p.addSkillXP(experience, 9);
							p.actionTimer = timer;
							p.startAnimation(1248);
							p.sendMessage("You make a " + p.getItemName(bow) + ".");
						} else {
							p.sendMessage("You need a Fletching level of " +req+ " to make this!");
						}
					} else {
						p.sendMessage("You need some more " + p.getItemName(logs) + "!");
					}
				}
				if(type == 2) {
					if(p.playerHasItemAmount(logs, 1)) {
						if(p.playerLevel[9] >= req) {
							p.addItem(shaft, (15 + Misc.random(15)));
							p.deleteItem(logs, p.getItemSlot(logs), 1);
							p.addSkillXP(experience, 9);
							p.actionTimer = timer;
							p.startAnimation(1248);
							p.sendMessage("You make some " + p.getItemName(shaft) + "s.");
						} else {
							p.sendMessage("You need a Fletching level of " +req+ " to make this!");
						}
					}
				}
				if(type == 3) {
					if(p.playerHasItemAmount(logs, 1)) {
						if(p.playerLevel[9] >= req) {
							p.addItem(bow, 1);
							p.deleteItem(logs, p.getItemSlot(logs), 1);
							p.addSkillXP(experience, 9);
							p.actionTimer = timer;
							p.startAnimation(1248);
							p.sendMessage("You make a " + p.getItemName(bow) + ".");
						} else {
							p.sendMessage("You need a Fletching level of " +req+ " to make this!");
						}
					} else {
						p.sendMessage("You need some more " + p.getItemName(logs) + "!");
					}
				}
				amountToFletch--;
			}
		}, 3000);
	}
	
	public void sendFletch(clientHandler p, int item, int item2) {
			if(item == 1511 && item2 == 946 || item == 946 && item2 == 1511) {
				p.sendFrame164(8880);
				p.sendFrame246(8883, 250, 50);
				p.sendFrame246(8884, 200, 52);
				p.sendFrame246(8885, 200, 48);
				p.sendFrame126("Longbow (u)", 8897);
				p.sendFrame126("Arrow Shaft", 8893);
				p.sendFrame126("Shortbow (u)", 8889);
				p.isFletching = true;
				p.isFlaxing = false;
			}
			if(item == 1521 && item2 == 946 || item == 946 && item2 == 1521) {
				p.sendFrame164(8866);
				p.sendFrame246(8869, 250, 54);
				p.sendFrame246(8870, 200, 56);
				p.sendFrame126("Oak Longbow (u)", 8875);
				p.sendFrame126("Oak Shortbow (u)", 8874);
				p.isFletching = true;
				p.isFlaxing = false;
			}
			if(item == 1519 && item2 == 946 || item == 946 && item2 == 1519) {
				p.sendFrame164(8866);
				p.sendFrame246(8869, 250, 60);
				p.sendFrame246(8870, 200, 58);
				p.sendFrame126("Willow Longbow (u)", 8875);
				p.sendFrame126("Willow Shortbow (u)", 8874);
				p.isFletching = true;
				p.isFlaxing = false;
			}
			if(item == 1517 && item2 == 946 || item == 946 && item2 == 1519) {
				p.sendFrame164(8866);
				p.sendFrame246(8869, 250, 64);
				p.sendFrame246(8870, 200, 62);
				p.sendFrame126("Maple Longbow (u)", 8875);
				p.sendFrame126("Maple Shortbow (u)", 8874);
				p.isFletching = true;
				p.isFlaxing = false;
			}
			if(item == 1515 && item2 == 946 || item == 946 && item2 == 1515) {
				p.sendFrame164(8866);
				p.sendFrame246(8869, 250, 68);
				p.sendFrame246(8870, 200, 66);
				p.sendFrame126("Yew Longbow (u)", 8875);
				p.sendFrame126("Yew Shortbow (u)", 8874);
				p.isFletching = true;
				p.isFlaxing = false;
			}
			if(item == 1513 && item2 == 946 || item == 946 && item2 == 1513) {
				p.sendFrame164(8866);
				p.sendFrame246(8869, 250, 72);
				p.sendFrame246(8870, 200, 70);
				p.sendFrame126("Magic Longbow (u)", 8875);
				p.sendFrame126("Magic Shortbow (u)", 8874);
				p.isFletching = true;
				p.isFlaxing = false;
			}
	}
	/*
	 * p, type, req, log, bow, shaft, exp, timer
	 */
	
	public void fletchItem(clientHandler p) {
		if(p.playerHasItemAmount(1511, 1)) { //Logs
			if(p.choiceClick == 2) {
				startFletching(p, 2, 1, 1511, -1, 52, 5 * 3, 5);//Arrow Shafts
			}
			if(p.choiceClick == 3) {
				startFletching(p, 1, 5, 1511, 48, -1, 5 * 3, 5);//Short bow
			}
			if(p.choiceClick == 1) {
				startFletching(p, 3, 10, 1511, 50, -1, 10 * 3, 5);//Long bow
			}
		} else if(p.playerHasItemAmount(1521, 1)) { //Oak
			if(p.choiceClick == 1) {
				startFletching(p, 1, 20, 1521, 54, -1, 16 * 3, 5); //Short
			}
			if(p.choiceClick == 3) {
				startFletching(p, 3, 25, 1521, 56, -1, 25 * 3, 5); //Long
			}
		} else if(p.playerHasItemAmount(1519, 1)) { //Willow
			if(p.choiceClick == 1) {
				startFletching(p, 1, 35, 1519, 60, -1, 33 * 3, 5); //Short
			}
			if(p.choiceClick == 3) {
				startFletching(p, 3, 40, 1519, 58, -1, 41 * 3, 5); //Long
			}
		} else if(p.playerHasItemAmount(1517, 1)) { //Maple
			if(p.choiceClick == 1) {
				startFletching(p, 1, 50, 1517, 64, -1, 50 * 3, 5); //Short
			}
			if(p.choiceClick == 3) {
				startFletching(p, 3, 55, 1517, 62, -1, 58 * 3, 5); //Long
			}
		} else if(p.playerHasItemAmount(1515, 1)) { // Yew
			if(p.choiceClick == 1) {
				startFletching(p, 1, 65, 1515, 68, -1, 66 * 3, 5); //Short
			}
			if(p.choiceClick == 3) {
				startFletching(p, 3, 70, 1515, 66, -1, 75 * 3, 5); //Long
			}
		} else if(p.playerHasItemAmount(1513, 1)) {
			if(p.choiceClick == 1) {
				startFletching(p, 1, 80, 1513, 72, -1, 83 * 3, 5); //Short
			}
			if(p.choiceClick == 3) {
				startFletching(p, 3, 85, 1513, 70, -1, 91 * 3, 5); //Long
			}
		}
	}
	
	public void stringItem(clientHandler p, int req, int unstrung, int bow, int experience) {
			if(p.playerLevel[9] >= req) {
				p.deleteItem(unstrung, p.getItemSlot(unstrung), 1);
				p.deleteItem(1777, p.getItemSlot(1777), 1);
				p.addItem(bow, 1);
				p.addSkillXP(experience, 9);
				p.sendMessage("You make a " + p.getItemName(bow) + ".");
				p.actionTimer = 5;
			} else {
				p.sendMessage("You need a Fletching level of " + req + " to make a " + p.getItemName(bow) + ".");
			}
	}
	
	public void string(clientHandler p, int item, int item2) {
			if(item == 1777 && item2 == 48 || item == 48 && item2 == 1777) {
				stringItem(p, 5, 48, 841, 10 * 3);
			} else if(item == 1777 && item2 == 50 || item == 48 && item2 == 1777) {
				stringItem(p, 10, 50, 839, 10 * 3);
			} else if (item == 1777 && item2 == 54 || item == 48 && item2 == 1777) {
				stringItem(p, 20, 54, 843, 16 * 3);
			} else if (item == 1777 && item2 == 56 || item == 48 && item2 == 1777) {
				stringItem(p, 25, 56, 845, 25 * 3);
			} else if (item == 1777 && item2 == 60 || item == 48 && item2 == 1777) {
				stringItem(p, 35, 60, 849, 33 * 3);
			} else if (item == 1777 && item2 == 58 || item == 48 && item2 == 1777) {
				stringItem(p, 40, 58, 847, 41 * 3);
			} else if (item == 1777 && item2 == 64 || item == 48 && item2 == 1777) {
				stringItem(p, 50, 64, 853, 50 * 3);
			} else if (item == 1777 && item2 == 62 || item == 48 && item2 == 1777) {
				stringItem(p, 55, 62, 851, 58 * 3); 
			} else if (item == 1777 && item2 == 68 || item == 48 && item2 == 1777) {
				stringItem(p, 65, 68, 857, 66 * 3);
			} else if (item == 1777 && item2 == 66 || item == 48 && item2 == 1777) {
				stringItem(p, 70, 66, 855, 75 * 3);
			} else if (item == 1777 && item2 == 72 || item == 48 && item2 == 1777) {
				stringItem(p, 80, 72, 861, 83 * 3);
			} else if (item == 1777 && item2 == 70 || item == 48 && item2 == 1777) {
				stringItem(p, 85, 70, 859, 91 * 3);
			}
	}
	
	public void makeFlax(final clientHandler p, final int amount) {
		if(p.playerHasItemAmount(1779, 1)) {
		p.deleteItem(1779, p.getItemSlot(1779), 1);
		p.addItem(1777, 1);
		p.startAnimation(894);
		p.addSkillXP(50 * 3, 12);
		p.sendMessage("You spin a " +p.getItemName(1777) + ".");
		p.RemoveAllWindows();
		p.isFlaxing = true;
		p.isFletching = false;
		} else {
			p.sendMessage("You do not have any flax!");
		}
		amountToFlax = amount - 1;
		EventManager.getSingleton().addEvent(new Event() {
			public void execute(EventContainer ec) {
				if (amountToFlax == 0 || !p.playerHasItemAmount(1777, 1)) {
					p.isFlaxing = false;
					ec.stop();
					return;
				}
				if(p.playerHasItemAmount(1779, 1)) {
				p.deleteItem(1779, p.getItemSlot(1779), 1);
				p.addItem(1777, 1);
				p.startAnimation(894);
				p.addSkillXP(50 * 3, 12);
				p.sendMessage("You spin a " +p.getItemName(1777) + ".");
				amountToFlax--;
				} else {
					p.sendMessage("You've run out of flax!");
					p.resetFletching();
				}
			}
		}, 3000);
	}

	public void makeArrow(clientHandler p, int req, int shaft, int item, int arrow, int experience) {
		if(p.playerLevel[9] >= req) {
			p.deleteItem(shaft, p.getItemSlot(shaft), 15);
			p.deleteItem(item, p.getItemSlot(item), 15);
			p.addItem(arrow, 15);
			p.addSkillXP(experience, 9);
			p.sendMessage("You make some " + p.getItemName(arrow) + "s.");
			p.actionTimer = 5;
		} else {
			p.sendMessage("You need a Fletching level of " + req + " to make a " + p.getItemName(arrow) + "s.");
		}
	}

	public void startArrow(clientHandler p, int item, int item2) {
		if (item == 52 && item2 == 314 || item == 314 && item2 == 52) {
		makeArrow(p, 1, 52, 314, 53, 15 * 3);
		} else if (item == 53 && item2 == 39 || item == 39 && item2 == 53) {
		makeArrow(p, 5, 53, 39, 882, 39 * 3);
		} else if (item == 53 && item2 == 40 || item == 40 && item2 == 53) {
		makeArrow(p, 5, 53, 40, 884, 57 * 3);
		} else if (item == 53 && item2 == 41 || item == 41 && item2 == 53) {
		makeArrow(p, 5, 53, 41, 886, 95 * 3);
		} else if (item == 53 && item2 == 42 || item == 42 && item2 == 53) {
		makeArrow(p, 5, 53, 42, 888, 135 * 3);
		} else if (item == 53 && item2 == 43 || item == 43 && item2 == 53) {
		makeArrow(p, 5, 53, 43, 890, 207 * 3);
		} else if (item == 53 && item2 == 44 || item == 44 && item2 == 53) {
		makeArrow(p, 5, 53, 44, 892, 225 * 3);
		}
	}
}
