/*
 * Class NPCBoundaries.
 *
 * Contains NPC Walkable Distances from their spawn.
 *
 * @Author cocoa.
 */

package com.iClarity.npcs;


import com.iClarity.misc.*;

public class NPCBoundaries {

	/*
	 * Constructor.
	 */
	public NPCBoundaries() {

	}

	/*
	 * The walkable distance of a certain NPC
	 */
	public static int getBoundary(NPC n) {
		switch(n.npcType) {
			case 2745:
				return 10;
		}
		return 7;
	}

}
