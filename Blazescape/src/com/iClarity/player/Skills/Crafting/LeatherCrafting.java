/*
 * Class LeatherCrafting
 *
 * Version 2.0
 *
 * Thursday 18th June, 2009
 *
 * Created by Primadude
 */

package com.iClarity.player.Skills.Crafting;

import java.io.*;
import com.iClarity.npcs.*;
import com.iClarity.misc.*;
import com.iClarity.player.*;
import com.iClarity.GameEngine;

public class LeatherCrafting {

	/**
	 * Constructor
	 */
	public LeatherCrafting() {

	}

	/*
	 * Crafting chatbox interface menu.
	 */
	public static void craftMenu(clientHandler p, int i, int j) {
		if (i == 1733) {
			p.craftId = j;
		} else if (j == 1733) {
			p.craftId = i;
		}

		switch (p.craftId) {

			case 1741:
				p.showInterface(2311);
				break;

			case 1745:
				p.leatherId = 1745;
				p.dHideCraft = true;
				p.sendFrame246(8883, 250, 1099);
				p.sendFrame246(8884, 200, 1065);
				p.sendFrame246(8885, 200, 1135);
				p.sendFrame126("Dragonhide Body", 8897);
				p.sendFrame126("Dragonhide Vambs", 8893);
				p.sendFrame126("Dragonhide Chaps", 8889);
				p.sendFrame164(8880);
				p.interfaceStage = 3;
				break;

			case 2505:
				p.leatherId = 2505;
				p.dHideCraft = true;
				p.sendFrame246(8883, 250, 2493);
				p.sendFrame246(8884, 200, 2487);
				p.sendFrame246(8885, 200, 2499);
				p.sendFrame126("Dragonhide Body", 8897);
				p.sendFrame126("Dragonhide Vambs", 8893);
				p.sendFrame126("Dragonhide Chaps", 8889);
				p.sendFrame164(8880);
				p.interfaceStage = 3;
				break;

			case 2507:
				p.leatherId = 2507;
				p.dHideCraft = true;
				p.sendFrame246(8883, 250, 2495);
				p.sendFrame246(8884, 200, 2489);
				p.sendFrame246(8885, 200, 2501);
				p.sendFrame126("Dragonhide Body", 8897);
				p.sendFrame126("Dragonhide Vambs", 8893);
				p.sendFrame126("Dragonhide Chaps", 8889);
				p.sendFrame164(8880);
				p.interfaceStage = 3;
				break;

			case 2509:
				p.leatherId = 2509;
				p.dHideCraft = true;
				p.sendFrame246(8883, 250, 2497);
				p.sendFrame246(8884, 200, 2491);
				p.sendFrame246(8885, 200, 2503);
				p.sendFrame126("Dragonhide Body", 8897);
				p.sendFrame126("Dragonhide Vambs", 8893);
				p.sendFrame126("Dragonhide Chaps", 8889);
				p.sendFrame164(8880);
				p.interfaceStage = 3;
				break;
		}
	}

	/*
	 * Craft an Item.
	 */
	public static void craftItem(clientHandler p) {
		p.RemoveAllWindows();

		if (p.InvItemAmt(p.leatherId) < p.craftDelAmt) {
			p.craftDelAmt = p.InvItemAmt(p.leatherId);
		}
		if (p.craftDelAmt <= 0 || p.InvItemAmt(p.leatherId) <= 0 || !p.isCrafting) {
			p.isCrafting = false;
			p.craftDelAmt = 0;
			return;
		}
		p.craftDelay = 5;
		p.craftDelAmt--;

		switch (p.craftId) {

			case 1059:
				if (p.getLevelForXP(p.playerXP[12]) >= 1) {
					if (p.playerHasItemAmount(1734, 1)) {
						p.startAnimation(1249);
						p.deleteItem(1741, p.GetItemSlot(1741), 1);
						p.deleteItem(1734, p.GetItemSlot(1734), 1);
						p.addItem(1059, 1);
						p.addSkillXP(55, 12);
					} else {
						p.sendMessage("You need thread to make this!");
						p.isCrafting = false;
						p.craftDelAmt = 0;
					}
				} else {
					p.showDialogue("You need at least 1 Crafting to make this!");
					p.isCrafting = false;
					p.craftDelAmt = 0;
				}
				break;

			case 1061:
				if (p.getLevelForXP(p.playerXP[12]) >= 7) {
					if (p.playerHasItemAmount(1734, 1)) {
						p.startAnimation(1249);
						p.deleteItem(1741, p.GetItemSlot(1741), 1);
						p.deleteItem(1734, p.GetItemSlot(1734), 1);
						p.addItem(1061, 1);
						p.addSkillXP(65, 12);
					} else {
						p.sendMessage("You need thread to make this!");
						p.isCrafting = false;
						p.craftDelAmt = 0;
					}
				} else {
					p.showDialogue("You need at least 7 Crafting to make this!");
					p.isCrafting = false;
					p.craftDelAmt = 0;
				}
				break;

			case 1167:
				if (p.getLevelForXP(p.playerXP[12]) >= 9) {
					if (p.playerHasItemAmount(1734, 1)) {
						p.startAnimation(1249);
						p.deleteItem(1741, p.GetItemSlot(1741), 1);
						p.deleteItem(1734, p.GetItemSlot(1734), 1);
						p.addItem(1167, 1);
						p.addSkillXP(74, 12);
					} else {
						p.sendMessage("You need thread to make this!");
						p.isCrafting = false;
						p.craftDelAmt = 0;
					}
				} else {
					p.showDialogue("You need at least 9 Crafting to make this!");
					p.isCrafting = false;
					p.craftDelAmt = 0;
				}
				break;

			case 1063:
				if (p.getLevelForXP(p.playerXP[12]) >= 11) {
					if (p.playerHasItemAmount(1734, 1)) {
						p.startAnimation(1249);
						p.deleteItem(1741, p.GetItemSlot(1741), 1);
   						p.deleteItem(1734, p.GetItemSlot(1734), 1);
						p.addItem(1063, 1);
						p.addSkillXP(88, 12);
					} else {
						p.sendMessage("You need thread to make this!");
						p.isCrafting = false;
						p.craftDelAmt = 0;
					}
				} else {
					p.showDialogue("You need at least 11 Crafting to make this!");
					p.isCrafting = false;
					p.craftDelAmt = 0;
				}
				break;

			case 1129:
				if (p.getLevelForXP(p.playerXP[12]) >= 14) {
					if (p.playerHasItemAmount(1734, 1)) {
						p.startAnimation(1249);
						p.deleteItem(1741, p.GetItemSlot(1741), 1);
						p.deleteItem(1734, p.GetItemSlot(1734), 1);
						p.addItem(1129, 1);
						p.addSkillXP(100, 12);
					} else {
						p.sendMessage("You need thread to make this!");
						p.isCrafting = false;
						p.craftDelAmt = 0;
					}
				} else {
					p.showDialogue("You need at least 14 Crafting to make this!");
					p.isCrafting = false;
					p.craftDelAmt = 0;
				}
				break;

        case 1095:
            if(p.getLevelForXP(p.playerXP[12]) >= 18)
            {
                if (p.playerHasItemAmount(1734, 1))
                {
                    p.startAnimation(1249);
                    p.deleteItem(1741, p.GetItemSlot(1741), 1);
                    p.deleteItem(1734, p.GetItemSlot(1734), 1);
                    p.addItem(1095, 1);
                    p.addSkillXP(108, 12);
                } else
                {
                    p.sendMessage("You need thread to make this!");
                    p.isCrafting = false;
                    p.craftDelAmt = 0;
                }
            } else
            {
                p.showDialogue("You need at least 18 Crafting to make this!");
                p.isCrafting = false;
                p.craftDelAmt = 0;
            }
            break;

        case 1131:
            if(p.getLevelForXP(p.playerXP[12]) >= 28)
            {
                if (p.playerHasItemAmount(1734, 1))
                {
                    p.startAnimation(1249);
                    p.deleteItem(1743, p.GetItemSlot(1743), 1);
                    p.deleteItem(1734, p.GetItemSlot(1734), 1);
                    p.addItem(1131, 1);
                    p.addSkillXP(140, 12);
                } else
                {
                    p.sendMessage("You need thread to make this!");
                    p.isCrafting = false;
                    p.craftDelAmt = 0;
                }
            } else
            {
                p.showDialogue("You need at least 18 Crafting to make this!");
                p.isCrafting = false;
                p.craftDelAmt = 0;
            }
            break;

        case 1169:
            if(p.getLevelForXP(p.playerXP[12]) >= 38)
            {
                if (p.playerHasItemAmount(1734, 1))
                {
                    p.startAnimation(1249);
                    p.deleteItem(1741, p.GetItemSlot(1741), 1);
                    p.deleteItem(1734, p.GetItemSlot(1734), 1);
                    p.addItem(1169, 1);
                    p.addSkillXP(148, 12);
                } else
                {
                    p.sendMessage("You need thread to make this!");
                    p.isCrafting = false;
                    p.craftDelAmt = 0;
                }
            } else
            {
                p.showDialogue("You need at least 38 Crafting to make this!");
                p.isCrafting = false;
                p.craftDelAmt = 0;
            }
            break;

        case 1099:
            if(p.getLevelForXP(p.playerXP[12]) >= 60)
            {
                if(p.InvItemAmt(1734) > 0 || p.InvItemAmt(1745) > 1)
                {
                    p.startAnimation(1249);
                    p.deleteItem(1745, p.GetItemSlot(1745), 2);
                    p.deleteItem(1734, p.GetItemSlot(1734), 1);
                    p.addItem(1099, 1);
                    p.addSkillXP(496, 12);
                } else
                {
                    p.sendMessage("You need two or more green dragonhides to make this!");
                    p.isCrafting = false;
                    p.craftDelAmt = 0;
                }
            } else
            {
                p.showDialogue("You need at least 60 Crafting to make this!");
                p.isCrafting = false;
                p.craftDelAmt = 0;
            }
            break;

        case 1135:
            if(p.getLevelForXP(p.playerXP[12]) >= 63)
            {
                if(p.InvItemAmt(1734) > 0 || p.InvItemAmt(1745) > 2)
                {
                    p.startAnimation(1249);
                    p.deleteItem(1745, p.GetItemSlot(1745), 3);
                    p.deleteItem(1734, p.GetItemSlot(1734), 1);
                    p.addItem(1135, 1);
                    p.addSkillXP(744, 12);
                } else
                {
                    p.sendMessage("You need three or more green dragonhides to make this!");
                    p.isCrafting = false;
                    p.craftDelAmt = 0;
                }
            } else
            {
                p.showDialogue("You need at least 63 Crafting to make this!");
                p.isCrafting = false;
                p.craftDelAmt = 0;
            }
            break;

        case 1065:
            if(p.getLevelForXP(p.playerXP[12]) >= 57)
            {
                if(p.InvItemAmt(1734) > 0 || p.InvItemAmt(1745) > 0)
                {
                    p.startAnimation(1249);
                    p.deleteItem(1745, p.GetItemSlot(1745), 1);
                    p.deleteItem(1734, p.GetItemSlot(1734), 1);
                    p.addItem(1065, 1);
                    p.addSkillXP(248, 12);
                } else
                {
                    p.sendMessage("You need one or more green dragonhides to make this!");
                    p.isCrafting = false;
                    p.craftDelAmt = 0;
                }
            } else
            {
                p.showDialogue("You need at least 57 Crafting to make this!");
                p.isCrafting = false;
                p.craftDelAmt = 0;
            }
            break;

        case 2493:
            if(p.getLevelForXP(p.playerXP[12]) >= 68)
            {
                if(p.InvItemAmt(1734) > 0 || p.InvItemAmt(2505) > 1)
                {
                    p.startAnimation(1249);
                    p.deleteItem(2505, p.GetItemSlot(2505), 2);
                    p.deleteItem(1734, p.GetItemSlot(1734), 1);
                    p.addItem(2493, 1);
                    p.addSkillXP(560, 12);
                } else
                {
                    p.sendMessage("You need more two or more blue dragonhides to make this!");
                    p.isCrafting = false;
                    p.craftDelAmt = 0;
                }
            } else
            {
                p.showDialogue("You need at least 68 Crafting to make this!");
                p.isCrafting = false;
                p.craftDelAmt = 0;
            }
            break;

        case 2499:
            if(p.getLevelForXP(p.playerXP[12]) >= 71)
            {
                if(p.InvItemAmt(1734) > 0 || p.InvItemAmt(2505) > 2)
                {
                    p.startAnimation(1249);
                    p.deleteItem(2505, p.GetItemSlot(2505), 3);
                    p.deleteItem(1734, p.GetItemSlot(1734), 1);
                    p.addItem(2499, 1);
                    p.addSkillXP(840, 12);
                } else
                {
                    p.sendMessage("You need three or more blue dragonhides to make this!");
                    p.isCrafting = false;
                    p.craftDelAmt = 0;
                }
            } else
            {
                p.showDialogue("You need at least 71 Crafting to make this!");
                p.isCrafting = false;
                p.craftDelAmt = 0;
            }
            break;

        case 2487:
            if(p.getLevelForXP(p.playerXP[12]) >= 66)
            {
                if(p.InvItemAmt(1734) > 0 || p.InvItemAmt(2505) > 0)
                {
                    p.startAnimation(1249);
                    p.deleteItem(2505, p.GetItemSlot(2505), 1);
                    p.deleteItem(1734, p.GetItemSlot(1734), 1);
                    p.addItem(2487, 1);
                    p.addSkillXP(280, 12);
                } else
                {
                    p.sendMessage("You need one or more blue dragonhides to make this!");
                    p.isCrafting = false;
                    p.craftDelAmt = 0;
                }
            } else
            {
                p.showDialogue("You need at least 66 Crafting to make this!");
                p.isCrafting = false;
                p.craftDelAmt = 0;
            }
            break;

        case 2495:
            if(p.getLevelForXP(p.playerXP[12]) >= 75)
            {
                if(p.InvItemAmt(1734) > 0 || p.InvItemAmt(2507) > 1)
                {
                    p.startAnimation(1249);
                    p.deleteItem(2507, p.GetItemSlot(2507), 2);
                    p.deleteItem(1734, p.GetItemSlot(1734), 1);
                    p.addItem(2495, 1);
                    p.addSkillXP(624, 12);
                } else
                {
                    p.sendMessage("You need two or more red dragonhides to make this!");
                    p.isCrafting = false;
                    p.craftDelAmt = 0;
                }
            } else
            {
                p.showDialogue("You need at least 75 Crafting to make this!");
                p.isCrafting = false;
                p.craftDelAmt = 0;
            }
            break;

        case 2501:
            if(p.getLevelForXP(p.playerXP[12]) >= 77)
            {
                if(p.InvItemAmt(1734) > 0 || p.InvItemAmt(2507) > 2)
                {
                    p.startAnimation(1249);
                    p.deleteItem(2507, p.GetItemSlot(2507), 3);
                    p.deleteItem(1734, p.GetItemSlot(1734), 1);
                    p.addItem(2501, 1);
                    p.addSkillXP(936, 12);
                } else
                {
                    p.sendMessage("You need two or more red dragonhides to make this!");
                    p.isCrafting = false;
                    p.craftDelAmt = 0;
                }
            } else
            {
                p.showDialogue("You need at least 77 Crafting to make this!");
                p.isCrafting = false;
                p.craftDelAmt = 0;
            }
            break;

        case 2489:
            if(p.getLevelForXP(p.playerXP[12]) >= 73)
            {
                if(p.InvItemAmt(1734) > 0 || p.InvItemAmt(2507) > 0)
                {
                    p.startAnimation(1249);
                    p.deleteItem(2507, p.GetItemSlot(2507), 1);
                    p.deleteItem(1734, p.GetItemSlot(1734), 1);
                    p.addItem(2489, 1);
                    p.addSkillXP(312, 12);
                } else
                {
                    p.sendMessage("You need one or more red dragonhides to make this!");
                    p.isCrafting = false;
                    p.craftDelAmt = 0;
                }
            } else
            {
                p.showDialogue("You need at least 73 Crafting to make this!");
                p.isCrafting = false;
                p.craftDelAmt = 0;
            }
            break;

			case 2497:
				if (p.getLevelForXP(p.playerXP[12]) >= 82) {
					if (p.playerHasItemAmount(1734, 2)) {
						if (p.playerHasItemAmount(2509, 2)) {
							p.startAnimation(1249);
							p.deleteItem(2509, p.GetItemSlot(2509), 1);
							p.deleteItem(2509, p.GetItemSlot(2509), 1);
							p.deleteItem(1734, p.GetItemSlot(1734), 1);
							p.addItem(2497, 1);
							p.addSkillXP(688, 12);
						} else {
							p.sendMessage("You need two or more black dragonhides to make this!");
							p.isCrafting = false;
							p.craftDelAmt = 0;
						}
					} else {
						p.sendMessage("You thread to craft these hides!");
						p.isCrafting = false;
						p.craftDelAmt = 0;
					}
				} else {
					p.showDialogue("You need at least 82 Crafting to make this!");
					p.isCrafting = false;
					p.craftDelAmt = 0;
				}
				break;

			case 2503:
				if (p.getLevelForXP(p.playerXP[12]) >= 84) {
					if (p.playerHasItemAmount(1734, 2)) {
						if (p.InvItemAmt(1734) > 2) {
							p.startAnimation(1249);
							p.delItem(2509, p.GetItemSlot(2509), 3);
							p.deleteItem(1734, p.GetItemSlot(1734), 1);
							p.addItem(2503, 1);
							p.addSkillXP(1072, 12);
						} else {
							p.sendMessage("You need three or more black dragonhides to make this!");
							p.isCrafting = false;
							p.craftDelAmt = 0;
						}
					} else {
						p.sendMessage("You thread to craft these hides!");
						p.isCrafting = false;
						p.craftDelAmt = 0;
					}
				} else {
					p.showDialogue("You need at least 84 Crafting to make this!");
					p.isCrafting = false;
					p.craftDelAmt = 0;
				}
				break;

			case 2491:
				if (p.getLevelForXP(p.playerXP[12]) >= 79) {
					if (p.playerHasItemAmount(1734, 2)) {
						if (p.playerHasItemAmount(2509, 1)) {
							p.startAnimation(1249);
							p.deleteItem(2509, p.GetItemSlot(2509), 1);
							p.deleteItem(1734, p.GetItemSlot(1734), 1);
							p.addItem(2491, 1);
							p.addSkillXP(344, 12);
						} else {
							p.sendMessage("You need one or more black dragonhides to make this!");
							p.isCrafting = false;
							p.craftDelAmt = 0;
						}
					} else {
						p.sendMessage("You thread to craft these hides!");
						p.isCrafting = false;
						p.craftDelAmt = 0;
					}
				} else {
					p.showDialogue("You need at least 79 Crafting to make this!");
					p.isCrafting = false;
					p.craftDelAmt = 0;
				}
				break;
		}
	}
	
}