/*
 * Magic casted on NPCs.
 */

package com.iClarity.player.packetHandler.Packets;

import com.iClarity.*;
import com.iClarity.player.*;
import com.iClarity.player.magic.*;

public class MagicOnNPC {

	public static void processPacket(clientHandler p, int packetType, int packetSize) {
		/*
		 * The opposing Npc's Index.
		 */
		p.pID = p.inStream.readSignedWordBigEndianA();

		/*
		 * The ID of the casted spell.
		 */
		p.sID = p.inStream.readSignedWordA();

		p.attacknpc = p.pID;
		NpcMagic M = new NpcMagic(p);
		M.magicSpell(p);	
	}
}