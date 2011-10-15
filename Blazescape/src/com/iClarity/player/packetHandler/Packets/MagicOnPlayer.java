/*
 * Cast magic on another player.
 */

package com.iClarity.player.packetHandler.Packets;

import com.iClarity.*;
import com.iClarity.player.*;
import com.iClarity.player.magic.*;

public class MagicOnPlayer {

	public static void processPacket(clientHandler p, int packetType, int packetSize) {
		/*
		 * The opposing player's Index.
		 */
		p.pID = p.inStream.readSignedWordA();

		/*
		 * The ID of the casted spell.
		 */
		p.sID = p.inStream.readSignedWordBigEndian();

		p.AttackingOn = p.pID;
		Magic M = new Magic(p);
		M.magicSpell(p);
	}
}