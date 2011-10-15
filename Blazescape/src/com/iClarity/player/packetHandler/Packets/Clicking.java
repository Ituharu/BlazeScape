/*
 * Clicking in game.
 */

package com.iClarity.player.packetHandler.Packets;

import java.io.*;
import com.iClarity.*;
import com.iClarity.misc.*;
import com.iClarity.player.*;
import com.iClarity.player.packetHandler.*;

public class Clicking {

	public static void processPacket(clientHandler p, int packetType, int packetSize) {
		int interfaceID = p.inStream.readUnsignedWordA();

		if (p.tradeStatus >= 2) {
			PlayerHandler.players[p.tradeWith].tradeOtherDeclined = true;
			p.DeclineTrade();
		}
		if (p.duelStatus > 0) {
			p.declineDuel();
		}
		if (p.IsShopping == true) {
			p.IsShopping = false;
			p.MyShopID = 0;
			p.UpdateShop = false;
		}
		if (p.IsBanking == true) {
			p.IsBanking = false;
		}
	}
}