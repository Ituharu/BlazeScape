/*
 * Character designing interface
 */

package com.iClarity.player.packetHandler.Packets;

import java.io.*;
import com.iClarity.*;
import com.iClarity.misc.*;
import com.iClarity.player.*;
import com.iClarity.player.packetHandler.*;

public class CharacterDesign {

	public static void processPacket(clientHandler p, int packetType, int packetSize) {
		int gender = p.inStream.readSignedByte();
		int head = p.inStream.readSignedByte();
		int jaw = p.inStream.readSignedByte();
		int torso = p.inStream.readSignedByte();
		int arms = p.inStream.readSignedByte();
		int hands = p.inStream.readSignedByte();
		int legs = p.inStream.readSignedByte();
		int feet = p.inStream.readSignedByte();
		int hairC = p.inStream.readSignedByte();
		int torsoC = p.inStream.readSignedByte();
		int legsC = p.inStream.readSignedByte();
		int feetC = p.inStream.readSignedByte();
		int skinC = p.inStream.readSignedByte();

		p.playerLook[0] = gender;
		p.pHead = head;
		p.pBeard = jaw;
		p.pTorso = torso;
		p.pArms = arms;
		p.pHands = hands;
		p.pLegs = legs;
		p.pFeet = feet;
		p.playerLook[1] = hairC;
		p.playerLook[2] = torsoC;
		p.playerLook[3] = legsC;
		p.playerLook[4] = feetC;
		p.playerLook[5] = skinC;
		p.apset = true;
		p.appearanceUpdateRequired = true;
	}
}