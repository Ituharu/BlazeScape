/*
 * Cooking Class
 * Author ?
 * Modified Corey
 * Date April 14 2010
 */

package com.iClarity.player.Skills;

import java.util.Random;

import com.iClarity.event.Event;
import com.iClarity.event.EventManager;
import com.iClarity.event.EventContainer;
import com.iClarity.player.clientHandler;
import com.iClarity.misc.*;

public class Cooking {

	/*
	 * The random instance.
	 */
	public final Random r = new Random();

	/*
	 * An array of items which can be cooked.
	 */
	private final int[] COOKING_ITEMS = new int[] {
		317, 327, 321, 345, 353, 335, 341, 349, 331, 359, 377, 363, 371, 383, 395, 389, 7944
	};

	/**
	 * Checks whether or not an item is cookable.
	 * 
	 * @param item
	 *                The item which you are checking for.
	 */
	public boolean isCookable(int item) {
		for (int cookable : COOKING_ITEMS) {
			if (item == cookable) {
				return true;
			}
		}
		return false;
	}

	/*
	 * Level required, stop burning, experience, raw, cooked, burnt
	 */
	private final int[][] COOKING_DATA = new int[][] {
		{ 1, 31, 20 * 3, 317, 315, 323 },// shrimp
		{ 1, 36, 40 * 3, 327, 325, 369 },// sardine
		{ 1, 34, 30 * 3, 321, 319, 323 },// anchovies
		{ 5, 39, 50 * 3, 345, 347, 357 },// herring
		{ 10, 45, 60 * 3, 353, 355, 357 },// mackerel
		{ 15, 50, 70 * 3, 335, 333, 343 },// trout
		{ 8, 39, 75 * 3, 341, 343, 343 },// cod
		{ 20, 52, 80 * 3, 349, 351, 343 },// pike
		{ 25, 58, 90 * 3, 331, 329, 343 },// salmon
		{ 30, 63, 100 * 3, 359, 361, 367 },// tuna
		{ 40, 74, 120 * 3, 377, 379, 381 },// lobster
		{ 43, 80, 130 * 3, 363, 365, 367 },// bass
		{ 45, 86, 140 * 3, 371, 373, 375 },// swordfish
		{ 62, 90, 150 * 3, 7944, 7946, 7948 }, // monkfish
		{ 80, 99, 210 * 3, 383, 385, 387 },// shark
		{ 82, 99, 212 * 3, 395, 397, 393 },// sea turtle
		{ 91, 99, 216 * 3, 389, 391, 400 } // manta ray
	};

	private int level;
	private int noBurn;
	private int experience;
	private int raw;
	private int cooked;
	private int burnt;

	public int cookingItem;

	public boolean cooking = false;

	public int getData(int id, String type) {
		for (int[] data : COOKING_DATA) {
			if (id == data[3]) {
				level = data[0];
				noBurn = data[1];
				experience = data[2];
				raw = data[3];
				cooked = data[4];
				burnt = data[5];
			}
		}
		if (type.equals("EXPERIENCE")) {
			return experience;
		} else if (type.equals("LEVEL")) {
			return level;
		} else if (type.equals("STOP_BURNING")) {
			return noBurn;
		} else if (type.equals("RAW")) {
			return raw;
		} else if (type.equals("COOKED")) {
			return cooked;
		} else if (type.equals("BURNT")) {
			return burnt;
		} else {
			return 0;
		}
	}

	public void cookItem(final clientHandler p, final int item, final int amount) {
		setCooking(true);
		p.deleteItem(getData(item, "RAW"), p.getItemSlot(getData(item, "RAW")), 1);
		if ((p.playerLevel[7] >= getData(item, "LEVEL") ? true : ((p.playerLevel[7] - getData(item, "LEVEL") - Misc.random(30) < 10)))) {
			if(p.cookAnim == 1) {
				p.startAnimation(897);
			} else if(p.cookAnim == 2) {
				p.startAnimation(883);
			}
			p.addItem(getData(item, "COOKED"), 1);
			p.addSkillXP(getData(item, "EXPERIENCE"), 7);
			p.sendMessage("You cook a " + p.getItemName(getData(item, "COOKED")) + ".");
		} else {
			p.addItem(getData(item, "BURNT"), 1);
			p.sendMessage("You accidently burn a " + p.getItemName(getData(item, 

"COOKED")) + ".");
		}
		p.RemoveAllWindows();
		EventManager.getSingleton().addEvent(new Event() {
			int amountToCook = amount - 1;
			public void execute(EventContainer ec) {
				if (amountToCook == 0 || !p.playerHasItemAmount(getData(item, "RAW"), 

1)) {
					setCooking(false);
					ec.stop();
					return;
				}
				if (p.playerLevel[7] < getData(item, "LEVEL")) {
					p.sendMessage("You need a Cooking level of " + getData(item, 

"LEVEL") + " to cook this.");
					ec.stop();
					return;
				}
				p.deleteItem(getData(item, "RAW"), p.getItemSlot(getData(item, 

"RAW")), 1);
				if ((p.playerLevel[7] >= getData(item, "LEVEL") ? true : ((p.playerLevel[7] - getData(item, "LEVEL") + Misc.random(15) < 10)))) {
					if(p.cookAnim == 1) {
						p.startAnimation(897);
					} else if(p.cookAnim == 2) {
						p.startAnimation(883);
					}
					p.addItem(getData(item, "COOKED"), 1);
					p.addSkillXP(getData(item, "EXPERIENCE"), 7);
					p.sendMessage("You cook a " + p.getItemName(getData(item, 

"COOKED")) + ".");
				} else {
					p.addItem(getData(item, "BURNT"), 1);
					p.sendMessage("You accidently burn a " + 

p.getItemName(getData(item, "COOKED")) + ".");
				}
				setCooking(true);
				amountToCook--;
			}
		}, 3000);
	}

	/**
	 * @param level
	 *                the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * @param noBurn
	 *                the noBurn to set
	 */
	public void setNoBurn(int noBurn) {
		this.noBurn = noBurn;
	}

	/**
	 * @return the noBurn
	 */
	public int getNoBurn() {
		return noBurn;
	}

	/**
	 * @param experience
	 *                the experience to set
	 */
	public void setExperience(int experience) {
		this.experience = experience;
	}

	/**
	 * @return the experience
	 */
	public int getExperience() {
		return experience;
	}

	/**
	 * @param raw
	 *                the raw to set
	 */
	public void setRaw(int raw) {
		this.raw = raw;
	}

	/**
	 * @return the raw
	 */
	public int getRaw() {
		return raw;
	}

	/**
	 * @param cooked
	 *                the cooked to set
	 */
	public void setCooked(int cooked) {
		this.cooked = cooked;
	}

	/**
	 * @return the cooked
	 */
	public int getCooked() {
		return cooked;
	}

	/**
	 * @param burnt
	 *                the burnt to set
	 */
	public void setBurnt(int burnt) {
		this.burnt = burnt;
	}

	/**
	 * @return the burnt
	 */
	public int getBurnt() {
		return burnt;
	}

	public void setCooking(boolean cooking) {
		this.cooking = cooking;
	}

}
