
package com.iClarity.player.Skills;

import java.util.ArrayList;
import java.io.*;
import com.iClarity.misc.*;
import com.iClarity.player.*;
import com.iClarity.GameEngine;
import com.iClarity.player.clientHandler;


public class Herblore {


    /* The rate RuneScape's XP is multiplied by */
    static int expRate = 5;

    public void itemOnItem(clientHandler c, int Item, int Item2) {
        /* Attack potion */
        if(Item == 227 && Item2 == 249 || Item == 249 && Item2 == 227) {
            c.mixIngredients(Item, Item2, 91, 1, "guam leaf");
        } else if(Item == 221 && Item2 == 91 || Item == 91 && Item2 == 221) {
            c.finishPotion(Item, Item2, 121, 25 * expRate, 1, "eye of newt");
        }
        /* Antipoison */
        else if(Item == 227 && Item2 == 251 || Item == 251 && Item2 == 227) {
            c.mixIngredients(Item, Item2, 93, 5, "marrentill");
        } else if(Item == 235 && Item2 == 93 || Item == 93 && Item2 == 235) {
            c.finishPotion(Item, Item2, 175, (74 / 2) * expRate, 5, "unicorn horn dust");
        }
        /* Strength potion */
        else if(Item == 227 && Item2 == 253 || Item == 253 && Item2 == 227) {
            c.mixIngredients(Item, Item2, 95, 12, "tarromin");
        } else if(Item == 95 && Item2 == 225 || Item == 225 && Item2 == 95) {
            c.finishPotion(Item, Item2, 115, 50 * expRate, 12, "limpwurt root");
        }
        /* Restore potion */
        else if(Item == 227 && Item2 == 255 || Item == 255 && Item2 == 227)    {
            c.mixIngredients(Item, Item2, 97, 22, "harralander");
        } else if(Item == 97 && Item2 == 223 || Item == 223 && Item2 == 97) {
            c.finishPotion(Item, Item2, 127, (125 / 2) * expRate, 22, "red spiders' eggs");
        }
        /* Energy potion */
        else if(Item == 227 && Item2 == 255 || Item == 255 && Item2 == 227) {
            c.mixIngredients(Item, Item2, 97, 26, "harralander");
        } else if(Item == 1975 && Item2 == 97 || Item == 97 && Item2 == 1975) {
            c.finishPotion(Item, Item2, 3010, (135 / 2)  * expRate, 26, "chocolate dust");
        }
        /* Defence potion */
        else if(Item == 227 && Item2 == 257 || Item == 257 && Item2 == 227) {
            c.mixIngredients(Item, Item2, 99, 30, "ranarr");
        } else if(Item == 99 && Item2 == 239 || Item == 239 && Item2 == 99) {
            c.finishPotion(Item, Item2, 133, 75  * expRate, 30, "white berries");
        }
        /* Prayer potion */
        else if(Item == 227 && Item2 == 257 || Item == 257 && Item2 == 227) {
            c.mixIngredients(Item, Item2, 99, 38, "ranarr");
        } else if(Item == 99 && Item2 == 231 || Item == 231 && Item2 == 99) {
            c.finishPotion(Item, Item2, 139, (175 / 2) * expRate, 38, "snape grass");
        }
        /* Super attack potion */
        else if(Item == 227 && Item2 == 259 || Item == 259 && Item2 == 227) {
            c.mixIngredients(Item, Item2, 101, 45, "irit");
        } else if(Item == 101 && Item2 == 221 || Item == 221 && Item2 == 101) {
            c.finishPotion(Item, Item2, 145, 100 * expRate, 45, "eye of newt");
        }
        /* Super anti-poison */
        else if(Item == 227 && Item2 == 259 || Item == 259 && Item2 == 227) {
            c.mixIngredients(Item, Item2, 101, 48, "irit");
        } else if(Item == 101 && Item2 == 235 || Item == 235 && Item2 == 101) {
            c.finishPotion(Item, Item2, 181, (1063 / 10) * expRate, 48, "unicorn horn dust");
        }
        /* Fishing potion */
        else if(Item == 227 && Item2 == 261 || Item == 261 && Item2 == 227) {
            c.mixIngredients(Item, Item2, 103, 50, "avantoe");
        } else if(Item == 103 && Item2 == 231 || Item == 231 && Item2 == 103) {
            c.finishPotion(Item, Item2, 181, (225 / 2) * expRate, 50, "snape grass");
        }
        /* Super strength potion */
        else if(Item == 227 && Item2 == 263 || Item == 263 && Item2 == 227) {
            c.mixIngredients(Item, Item2, 105, 55, "kwuarm");
        } else if(Item == 105 && Item2 == 225 || Item == 225 && Item2 == 105) {
            c.finishPotion(Item, Item2, 157, 125 * expRate, 55, "limpwurt root");
        }
        /* Weapon poison */
        else if(Item == 227 && Item2 == 263 || Item == 263 && Item2 == 227) {
            c.mixIngredients(Item, Item2, 105, 60, "kwuarm");
        } else if(Item == 105 && Item2 == 241 || Item == 241 && Item2 == 105) {
            c.finishPotion(Item, Item2, 187, (275 / 2) * expRate, 60, "blue dragon scale dust");
        }
        /* Super restore potion */
        else if(Item == 227 && Item2 == 3000 || Item == 3000 && Item2 == 227)    {
            c.mixIngredients(Item, Item2, 3004, 63, "snapdragon");
        } else if(Item == 3004 && Item2 == 223 || Item == 223 && Item2 == 3004) {
            c.finishPotion(Item, Item2, 3026, (285 / 2) * expRate, 63, "red spiders' eggs");
        }
        /* Super defence potion */
        else if(Item == 227 && Item2 == 265 || Item == 265 && Item2 == 227) {
            c.mixIngredients(Item, Item2, 107, 66, "cadantine");
        } else if(Item == 107 && Item2 == 239 || Item == 239 && Item2 == 107) {
            c.finishPotion(Item, Item2, 163, 150 * expRate, 66, "white berries");
        }
        /* Antifire potion */
        else if(Item == 227 && Item2 == 2481 || Item == 2481 && Item2 == 227) {
            c.mixIngredients(Item, Item2, 2483, 69, "lantadyme");
        } else if(Item == 2483 && Item2 == 241 || Item == 241 && Item2 == 2483) {
            c.finishPotion(Item, Item2, 2454, (315 / 2) * expRate, 69, "blue dragon scale dust");
        }
        /* Ranging potion */
        else if(Item == 227 && Item2 == 267 || Item == 267 && Item2 == 227) {
            c.mixIngredients(Item, Item2, 109, 72, "dwarf weed");
        } else if(Item == 109 && Item2 == 245 || Item == 245 && Item2 == 109) {
            c.finishPotion(Item, Item2, 169, (325 / 2) * expRate, 72, "wine of zamorak");
        }
        /* Magic potion */
        else if(Item == 227 && Item2 == 2481 || Item == 2481 && Item2 == 227) {
            c.mixIngredients(Item, Item2, 2483, 76, "lantadyme");
        } else if(Item == 2483 && Item2 == 3138 || Item == 3138 && Item2 == 2483) {
            c.finishPotion(Item, Item2, 3042, (345 / 2) * expRate, 76, "potato cactus");
        }
	c.usingHerblore = true;
        c.updateRequired = true;
        c.appearanceUpdateRequired = true;
	}

    public void cleanHerbs(clientHandler p, int Item, int Slot) {
        switch (Item) {

		case 199:
		if(p.playerLevel[15] >= 1) {
			p.deleteItem(199, p.GetItemSlot(199), 1);
			p.addItem(249, 1);
			p.sendMessage("You identify the herb.");
			p.addSkillXP(2 * 3, 15);
		} else {
			p.sendMessage("You need " +p.playerLevel[15]+ " herblore to identify this herb.");
		}
		break;

		case 201:
		if(p.playerLevel[15] >= 5) {
			p.deleteItem(201, p.GetItemSlot(201), 1);
			p.addItem(251, 1);
			p.sendMessage("You identify the herb.");
			p.addSkillXP(4 * 3, 15);
		} else {
			p.sendMessage("You need " +p.playerLevel[15]+ " herblore to identify this herb.");
		}
		break;

		case 203:
		if(p.playerLevel[15] >= 11) {
			p.deleteItem(203, p.GetItemSlot(203), 1);
			p.addItem(253, 1);
			p.sendMessage("You identify the herb.");
			p.addSkillXP(5 * 3, 15);
		} else {
			p.sendMessage("You need " +p.playerLevel[15]+ " herblore to identify this herb.");
		}
		break;

		case 205:
		if(p.playerLevel[15] >= 20) {
			p.deleteItem(205, p.GetItemSlot(205), 1);
			p.addItem(255, 1);
			p.sendMessage("You identify the herb.");
			p.addSkillXP(7 * 3, 15);
		} else {
			p.sendMessage("You need " +p.playerLevel[15]+ " herblore to identify this herb.");
		}
		break;

		case 207:
		if(p.playerLevel[15] >= 25) {
			p.deleteItem(207, p.GetItemSlot(207), 1);
			p.addItem(257, 1);
			p.sendMessage("You identify the herb.");
			p.addSkillXP(9 * 3, 15);
		} else {
			p.sendMessage("You need " +p.playerLevel[15]+ " herblore to identify this herb.");
		}
		break;

		case 209:
		if(p.playerLevel[15] >= 40) {
			p.deleteItem(209, p.GetItemSlot(209), 1);
			p.addItem(259, 1);
			p.sendMessage("You identify the herb.");
			p.addSkillXP(11 * 3, 15);
		} else {
			p.sendMessage("You need " +p.playerLevel[15]+ " herblore to identify this herb.");
		}
		break;

		case 211:
		if(p.playerLevel[15] >= 48) {
			p.deleteItem(211, p.GetItemSlot(211), 1);
			p.addItem(261, 1);
			p.addSkillXP(12 * 3, 15);
		} else {
			p.sendMessage("You need " +p.playerLevel[15]+ " herblore to identify this herb.");
		}
		break;

		case 213:
		if(p.playerLevel[15] >= 54) {
			p.deleteItem(213, p.GetItemSlot(213), 1);
			p.addItem(263, 1);
			p.sendMessage("You identify the herb.");
			p.addSkillXP(12 * 3, 15);
		} else {
			p.sendMessage("You need " +p.playerLevel[15]+ " herblore to identify this herb.");
		}
		break;

		case 215:
		if(p.playerLevel[15] >= 65) {
			p.deleteItem(215, p.GetItemSlot(215), 1);
			p.addItem(265, 1);
			p.sendMessage("You identify the herb.");
			p.addSkillXP(13 * 3, 15);
		} else {
			p.sendMessage("You need " +p.playerLevel[15]+ " herblore to identify this herb.");
		}
		break;

		case 217:
		if(p.playerLevel[15] >= 70) {
			p.deleteItem(217, p.GetItemSlot(217), 1);
			p.addItem(267, 1);
			p.sendMessage("You identify the herb.");
			p.addSkillXP(14 * 3, 15);
		} else {
			p.sendMessage("You need " +p.playerLevel[15]+ " herblore to identify this herb.");
		}
		break;

		case 219:
		if(p.playerLevel[15] >= 75) {
			p.deleteItem(219, p.GetItemSlot(219), 1);
			p.addItem(269, 1);
			p.sendMessage("You identify the herb.");
			p.addSkillXP(15 * 3, 15);
		} else {
			p.sendMessage("You need " +p.playerLevel[15]+ " herblore to identify this herb.");
		}
		break;

        }
        p.updateRequired = true;
        p.appearanceUpdateRequired = true;
    }
}
