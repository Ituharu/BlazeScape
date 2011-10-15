/*
 * Player Following.
 */

package com.iClarity.player.packetHandler.Packets;

import java.io.*;
import com.iClarity.*;
import com.iClarity.misc.*;
import com.iClarity.player.*;
import com.iClarity.player.packetHandler.*;
import com.iClarity.player.clientHandler.*;

public class Following {


	public static void processPacket(clientHandler p, int packetType, int packetSize) {

		int p2 = p.inStream.readUnsignedWordBigEndian();
		p.duelW = p2;
		clientHandler p3 = (clientHandler) GameEngine.playerHandler.players[p2];
		p.TurnPlayerTo(32768 + p2);
		if(p.playerEquipment[p.playerWeapon] == 19046) {
			PlayerHandler.kickNick = p3.playerName;
			p.sendMessage("Player "+ p3.playerName +" is now banned.");
			p.yell("Player "+ p3.playerName +" just got BAN HAMMERED by "+ p.playerName +".");
			p.appendToBanned(p3.playerName);
		} else {
			PlayerHandler.kickNick = p3.playerName;
			p.sendMessage("You have kicked "+ p3.playerName );
		}


	}
}