package com.iClarity.player;

import java.io.*;

public class InterfaceStrings {

	/*
	 * Interface text IDs for desired blank texts.
	 */
	private static int blankID[] = {
		7332, 7335, 7337, 7338, 7340, 7341, 7342, 7343, 7344, 7345, 7346, 7347, 7348
	};

	/*
	 * Set the desired text onto the desired interface.
	 */
	public static void setText(clientHandler p) {



p.sendQuest("@gre@STOP",6270);
p.sendQuest("@gre@Eye of the Tiger",11134);
p.sendQuest("@gre@BlazeScape Theme",11941);
p.sendQuest("@gre@Linkin Park - A Place for My Head",4287);
p.sendQuest("@gre@Eiffel65 - Blue",4288);
p.sendQuest("@gre@Rhapsody - Emerald Sword",4289);
p.sendQuest("@gre@Queen - Bohemian Rhapsody",4290);
p.sendQuest("@gre@Eye of the Tiger",11134);
p.sendQuest("@gre@~PAUSE MUSIC~",4292);
p.sendQuest("@gre@~RESUME MUSIC~",4294);
p.sendQuest("",4291);
p.sendQuest("",4293);
p.sendQuest("",4295);
p.sendQuest("",4296);
p.sendQuest("",4297);
p.sendQuest("",4298);
p.sendQuest("",4299);
p.sendQuest("",4300);

		for (int i = 0; i < blankID.length; i++) {
			p.sendQuest("", blankID[i]);
		}p.sendQuest("@whi@5bars",1112);
p.sendQuest("@whi@3bars",1109);
p.sendQuest("@whi@3bars",1110);
p.sendQuest("@whi@3bars",1118);
p.sendQuest("@whi@3bars",1111);
p.sendQuest("@whi@3bars",1095);
p.sendQuest("@whi@3bars",1115);
p.sendQuest("@whi@3bars",1090);
p.sendQuest("@whi@2bars",1113);
p.sendQuest("@whi@2bars",1116);
p.sendQuest("@whi@2bars",1114);
p.sendQuest("@whi@2bars",1089);
p.sendQuest("@whi@2bars",8428);
p.sendQuest("@whi@1bar",1125);
p.sendQuest("@whi@1bar",1126);
p.sendQuest("@whi@1bar",1127);
p.sendQuest("@whi@1bar",1124);
p.sendQuest("@whi@1bar",1128);
p.sendQuest("@whi@1bar",1129);
p.sendQuest("@whi@1bar",1130);
p.sendQuest("@whi@1bar",13357);
p.sendQuest("@whi@1bar",1131);
p.sendQuest("@whi@1bar",11459);
p.sendQuest("@whi@Plate body",1101);
p.sendQuest("@whi@Plate legs",1099);
p.sendQuest("@whi@Plate skirt",1100);
p.sendQuest("@whi@2 hand sword",1088);
p.sendQuest("@whi@Claws",8429);
p.sendQuest("@whi@Kite shield",1105);
p.sendQuest("@whi@Chain body",1098);
p.sendQuest("@whi@Battle axe",1092);
p.sendQuest("@whi@Warhammer",1083);
p.sendQuest("@whi@Square shield",1104);
p.sendQuest("@whi@Full helm",1103);
p.sendQuest("@whi@Throwing knives",1106);
p.sendQuest("@whi@Long sword",1086);
p.sendQuest("@whi@Scimitar",1087);
p.sendQuest("@whi@Arrowtips",1108);
p.sendQuest("@whi@Sword",1085);
p.sendQuest("@whi@Dart tips",1107);
p.sendQuest("@whi@Nails",13358);
p.sendQuest("@whi@Medium helm",1102);
p.sendQuest("@whi@Mace",1093);
p.sendQuest("@whi@Dagger",1094);
p.sendQuest("@whi@Axe",1091);
p.sendQuest("@whi@",1132);
p.sendQuest("@whi@",1096);
p.sendQuest("@whi@",11459);
p.sendQuest("@whi@",11461);
p.sendQuest("@whi@",1135);
p.sendQuest("@whi@",1134);

	if(p.playersOnlineTimer == 0) {
		p.sendQuest("@ran@Players Online: @whi@"+PlayerHandler.getPlayerCount(), 663);
	}
		p.sendQuest("", 7332);
		p.sendQuest("@whi@Recent Updates     ", 7333);
		p.sendQuest("@gre@-Run is unlimited", 7334);
		p.sendQuest("@gre@-Added Surgeon General", 7336);
		p.sendQuest("@gre@ Tafani @ the Duel Arena", 7383);
		p.sendQuest("@gre@-Added object loading @", 7339);
		p.sendQuest("@gre@ Duel arena, Varrock", 7338);
		p.sendQuest("@gre@ Mining and Barrows", 7340);
		p.sendQuest("@gre@-95% Fletching", 7341);
		p.sendQuest("@gre@-90% Herblore", 7342);
		p.sendQuest("@gre@-99% Cooking", 7343);
		p.sendQuest("@gre@-99% Fishing", 7335);
		p.sendQuest("", 7344);
		p.sendQuest("", 7345);
		p.sendQuest("", 7346);
		p.sendQuest("", 7347);
		p.sendQuest("", 7348);
		p.sendQuest("", 7337);
		p.sendQuest("@yel@Home Teleport", 1300);
		p.sendQuest("@whi@Teleports you Home", 1301);
	}
}