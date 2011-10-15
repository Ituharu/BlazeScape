/*
 *Handles Skill Menus
 *By Cocoa
 *My first handler ;D
 */

package com.iClarity.player;

import java.io.*;

public class SkillMenus {


	public static void setSkillString(clientHandler p, String level, int levelFrame, String name, int nameFrame) {
		p.sendFrame126(level, levelFrame);
		p.sendFrame126(name, nameFrame);
	}

	public static void setSidebar(clientHandler p) {
		p.sendFrame126("",8849);// members only skill
		p.sendFrame126("Attack",8846); // first option
		p.sendFrame126("Strength",8823);
		p.sendFrame126("Defence",8824);
		p.sendFrame126("Ranging",8827);
		p.sendFrame126("Magic",8837);
		p.sendFrame126("Hitpoints",8840);
		p.sendFrame126("Mining",8843);
		p.sendFrame126("Woodcutting",8859);
		p.sendFrame126("Herblore",8862);
		p.sendFrame126("Fletching",8865);
		p.sendFrame126("",15303);
		p.sendFrame126("",15306);
		p.sendFrame126("",15309);
	}
	private static int item[] = new int[31];

	public static void hitpointInterface(clientHandler p) {
		p.sendFrame126("@dre@Hitpoints", 8716);
		for(int i = 0;i<31;i++) {
			item[i] = 0;
		}
		item[0] = 9768;
		for(int i = 8720;i<8799;i++) {
			p.sendFrame126("",i);
		}
		setSkillString(p, "99", 8720, "Hitpoints Skillcape", 8760);
		setSidebar(p);
		
		sendSkillInterface(p, item);
		p.showInterface(8714);
	}

	public static void fletchingInterface(clientHandler p) {
		p.sendFrame126("@dre@Fletching", 8716);
		for(int i = 0; i < 31; i++) {
			item[i] = 0;
		}
		item[0] = 52;
		item[1] = 841;
		item[2] = 839;
		item[3] = 843;
		item[4] = 845;
		item[5] = 849;
		item[6] = 847;
		item[7] = 853;
		item[8] = 851;
		item[9] = 857;
		item[10] = 855;
		item[11] = 861;
		item[12] = 859;

		for(int i = 8720; i < 8799; i++) {
			p.sendFrame126("", i);
		}
		setSkillString(p, "1", 8720, "Arrow shafts", 8760);
		setSkillString(p, "5", 8721, "Short Bow", 8761);
		setSkillString(p, "10", 8722, "Long Bow", 8762);
		setSkillString(p, "20", 8723, "Oak Short Bow", 8763);
		setSkillString(p, "25", 8724, "Oak Long bow", 8764);
		setSkillString(p, "35", 8725, "Willow Short Bow", 8765);
		setSkillString(p, "40", 8726, "Willow Long Bow", 8766);
		setSkillString(p, "50", 8727, "Maple Short Bow", 8767);
		setSkillString(p, "55", 8728, "Maple Long Bow", 8768);
		setSkillString(p, "65", 8729, "Yew Short Bow", 8769);
		setSkillString(p, "70", 8730, "Yew Long Bow", 8770);
		setSkillString(p, "80", 8731, "Magic Short Bow", 8771);
		setSkillString(p, "85", 8732, "Magic Long Bow", 8772);
		setSidebar(p);
		
		sendSkillInterface(p, item);
		p.showInterface(8714);
	}

	public static void herbloreInterface(clientHandler p) {
		p.sendFrame126("@dre@Herblore", 8716);
		for (int i = 0; i < 31; i++) {
			item[i] = 0;
		}
		item[0] = 221;
		item[1] = 235;
		item[2] = 225;
		item[3] = 239;
		item[4] = 231;
		item[5] = 221;
		item[6] = 235;
		item[7] = 225;
		item[8] = 239;

		for(int i = 8720; i < 8799; i++) {
			p.sendFrame126("", i);
		}
		setSkillString(p, "1", 8720, "Attack - Gaum + Eye of Newt", 8760);
		setSkillString(p, "5", 8721, "Antipoison -Marrentill + Ground Unicorn Horn", 8761);
		setSkillString(p, "12", 8722, "Strength - Tarromin + Limpwurt Root", 8762);
		setSkillString(p, "30", 8723, "Defence - Ranarr + White Berries", 8763);
		setSkillString(p, "38", 8724, "Prayer - Snape Grass + Ranarr", 8764);
		setSkillString(p, "45", 8725, "Super Attack - Irit + Eye of Newt", 8765);
		setSkillString(p, "48", 8726, "Super Antipoison - Irit + G.Unicorn Horn", 8766);
		setSkillString(p, "55", 8727, "Super Strength - Kwuarm + Limpwurt Root", 8767);
		setSkillString(p, "66", 8728, "Super Defence - Cadantine + White Berries", 8768);

		setSidebar(p);
		
		sendSkillInterface(p, item);
		p.showInterface(8714);
	}

	public static void miningInterface(clientHandler p) {
		p.sendFrame126("@dre@Mining", 8716);
		for(int i = 0;i<31;i++) {
			item[i] = 0;
		}
		item[0] = 1265;
		item[1] = 1267;
		item[2] = 1269;
		item[3] = 1271;
		item[4] = 1273;
		item[5] = 1275;
		item[6] = 15259;
		item[7] = 9792;
		item[8] = 0;
		item[9] = 0;
		item[10] = 436;
		item[11] = 438;
		item[12] = 440;
		item[13] = 442;
		item[14] = 453;
		item[15] = 444;
		item[16] = 447;
		item[17] = 449;
		item[18] = 451;
		for(int i = 8720;i<8799;i++) {
			p.sendFrame126("",i);
		}
		setSkillString(p, "1", 8720, "Bronze pickaxe", 8760);
		setSkillString(p, "1", 8721, "Iron pickaxe", 8761);
		setSkillString(p, "6", 8722, "Steel pickaxe", 8762);
		setSkillString(p, "21", 8723, "Mithril pickaxe", 8763);
		setSkillString(p, "31", 8724, "Adamant pickaxe", 8764);
		setSkillString(p, "41", 8725, "Rune pickaxe", 8765);
		setSkillString(p, "61", 8726, "Dragon pickaxe", 8766);
		setSkillString(p, "99", 8727, "Mining Skillcape", 8767);
		setSkillString(p, "", 8728, "", 8768);
		setSkillString(p, "", 8729, "", 8769);
		setSkillString(p, "1", 8730, "Copper Ore", 8770);
		setSkillString(p, "1", 8731, "Tin Ore", 8771);
		setSkillString(p, "15", 8732, "Iron Ore", 8772);
		setSkillString(p, "20", 8733, "Silver Ore", 8773);
		setSkillString(p, "30", 8734, "Coal", 8774);
		setSkillString(p, "40", 8735, "Gold Ore", 8775);
		setSkillString(p, "55", 8736, "Mithril Ore", 8776);
		setSkillString(p, "70", 8737, "Adamantite Ore", 8777);
		setSkillString(p, "85", 8738, "Runite Ore", 8778);
		setSidebar(p);
		
		sendSkillInterface(p, item);
		p.showInterface(8714);
	}
	public static void woodcuttingInterface(clientHandler p) {
		p.sendFrame126("@dre@Woodcutting", 8716);
		for(int i = 0;i<31;i++) {
			item[i] = 0;
		}
		item[0] = 1351;
		item[1] = 1349;
		item[2] = 1353;
		item[3] = 1361;
		item[4] = 1355;
		item[5] = 1357;
		item[6] = 1359;
		item[7] = 6739;
		item[8] = 9807;
		item[9] = 0;
		item[10] = 1511;
		item[11] = 1521;
		item[12] = 1519;
		item[13] = 1517;
		item[14] = 1515;
		item[15] = 1513;
		for(int i = 8720;i<8799;i++) {
			p.sendFrame126("",i);
		}
		setSkillString(p, "1", 8720, "Bronze axe", 8760);
		setSkillString(p, "1", 8721, "Iron axe", 8761);
		setSkillString(p, "6", 8722, "Steel axe", 8762);
		setSkillString(p, "11", 8723, "Black axe", 8763);
		setSkillString(p, "21", 8724, "Mithril axe", 8764);
		setSkillString(p, "31", 8725, "Adamant axe", 8765);
		setSkillString(p, "41", 8726, "Rune axe", 8766);
		setSkillString(p, "61", 8727, "Dragon axe", 8767);
		setSkillString(p, "99", 8728, "Woodcutting Skillcape", 8768);
		setSkillString(p, "", 8729, "", 8769);
		setSkillString(p, "1", 8730, "Logs", 8770);
		setSkillString(p, "15", 8731, "Oak Logs", 8771);
		setSkillString(p, "30", 8732, "Willow Logs", 8772);
		setSkillString(p, "45", 8733, "Maple Logs", 8773);
		setSkillString(p, "60", 8734, "Yew Logs", 8774);
		setSkillString(p, "75", 8735, "Magic Logs", 8775);
		setSidebar(p);
		
		sendSkillInterface(p, item);
		p.showInterface(8714);
	}
	public static void attackInterface(clientHandler p) {
		p.sendFrame126("@dre@Attack", 8716);
		for(int i = 0;i<31;i++) {
			item[i] = 0;
		}
		item[0] = 1291;
		item[1] = 1293;
		item[2] = 1295;
		item[3] = 1297;
		item[4] = 1299;
		item[5] = 1301;
		item[6] = 1303;
		item[7] = 1305;
		item[8] = 4151;
		item[9] = 4718;
		item[10] = 11694;
		item[11] = 18012;
		item[12] = 9747;
		for(int i = 8720;i<8799;i++) {
			p.sendFrame126("",i);
		}
		setSkillString(p, "1", 8720, "Bronze", 8760);
		setSkillString(p, "1", 8721, "Iron", 8761);
		setSkillString(p, "5", 8722, "Steel", 8762);
		setSkillString(p, "10", 8723, "Black", 8763);
		setSkillString(p, "20", 8724, "Mithril", 8764);
		setSkillString(p, "30", 8725, "Adamant", 8765);
		setSkillString(p, "40", 8726, "Rune", 8766);
		setSkillString(p, "60", 8727, "Dragon", 8767);
		setSkillString(p, "70", 8728, "Abyssal Whip", 8768);
		setSkillString(p, "70", 8729, "Barrows", 8769);
		setSkillString(p, "75", 8730, "Godswords", 8770);
		setSkillString(p, "80", 8731, "Greatswords", 8771);
		setSkillString(p, "99", 8732, "Attack Armour", 8772);
		setSidebar(p);
		
		sendSkillInterface(p, item);
		p.showInterface(8714);
	}
	public static void strengthInterface(clientHandler p) {
		p.sendFrame126("@dre@Strength", 8716);
		for(int i = 0;i<31;i++) {
			item[i] = 0;
		}
		item[0] = 4718;
		item[1] = 4747;
		item[2] = 19032;
		item[3] = 19047;
		item[4] = 9750;
		for(int i = 8720;i<8799;i++) {
			p.sendFrame126("",i);
		}
		setSkillString(p, "70", 8720, "Dharok's Greataxe(with 70 attack)", 8760);
		setSkillString(p, "70", 8721, "Torag's Hammers(with 70 attack)", 8761);
		setSkillString(p, "99", 8722, "Strength Armour", 8762);
		setSkillString(p, "99", 8723, "Strength Godsword", 8763);
		setSkillString(p, "99", 8724, "Strength Skillcape", 8764);
		setSidebar(p);
		sendSkillInterface(p, item);
		p.showInterface(8714);
	}
	public static void defenceInterface(clientHandler p) {
		p.sendFrame126("@dre@Defence", 8716);
		for(int i = 0;i<31;i++) {
			item[i] = 0;
		}
		item[0] = 1117;
		item[1] = 1115;
		item[2] = 1119;
		item[3] = 1125;
		item[4] = 1121;
		item[5] = 1123;
		item[6] = 1127;
		item[7] = 1099;
		item[8] = 6809;
		item[9] = 14479;
		item[10] = 4720;
		item[11] = 11720;
		item[12] = 11724;
		item[13] = 9753;
		for(int i = 8720;i<8799;i++) {
			p.sendFrame126("",i);
		}
		setSkillString(p, "1", 8720, "Bronze", 8760);
		setSkillString(p, "1", 8721, "Iron", 8761);
		setSkillString(p, "5", 8722, "Steel", 8762);
		setSkillString(p, "10", 8723, "Black", 8763);
		setSkillString(p, "20", 8724, "Mithril", 8764);
		setSkillString(p, "30", 8725, "Adamant", 8765);
		setSkillString(p, "40", 8726, "Rune", 8766);
		setSkillString(p, "40", 8727, "Dragon hides", 8767);
		setSkillString(p, "50", 8728, "Granite", 8768);
		setSkillString(p, "60", 8729, "Dragon", 8769);
		setSkillString(p, "70", 8730, "Barrows", 8770);
		setSkillString(p, "70", 8731, "Armadyl", 8771);
		setSkillString(p, "80", 8732, "Bandos", 8772);
		setSkillString(p, "99", 8733, "Defence Skillcape", 8773);
		setSidebar(p);
		
		sendSkillInterface(p, item);
		p.showInterface(8714);
	}
	public static void rangeInterface(clientHandler p) {
		p.sendFrame126("@dre@Ranged", 8716);
		for(int i = 0;i<31;i++) {
			item[i] = 0;
		}
		item[0] = 841;
		item[1] = 843;
		item[2] = 849;
		item[3] = 853;
		item[4] = 857;
		item[5] = 861;
		item[6] = 15156;
		item[7] = 4214;
		item[8] = 19051;
		item[9] = 0;
		item[10] = 1099;
		item[11] = 2493;
		item[12] = 2495;
		item[13] = 2497;
		item[14] = 11718;
		item[15] = 19015;
		item[16] = 9756;
		for(int i = 8720;i<8799;i++) {
			p.sendFrame126("",i);
		}
		setSkillString(p, "1", 8720, "Shortbow", 8760);
		setSkillString(p, "5", 8721, "Oak bows", 8761);
		setSkillString(p, "20", 8722, "Willow bows", 8762);
		setSkillString(p, "30", 8723, "Maple bows", 8763);
		setSkillString(p, "40", 8724, "Yew bows", 8764);
		setSkillString(p, "50", 8725, "Magic bows", 8765);
		setSkillString(p, "60", 8726, "Dark bow", 8766);
		setSkillString(p, "70", 8727, "Crystal bow", 8767);
		setSkillString(p, "80", 8728, "God bows", 8768);
		setSkillString(p, "", 8729, "", 8769);
		setSkillString(p, "40", 8730, "Green D'hide", 8770);
		setSkillString(p, "50", 8731, "Blue D'hide", 8771);
		setSkillString(p, "60", 8732, "Red D'hide", 8772);
		setSkillString(p, "70", 8733, "Black D'hide", 8773);
		setSkillString(p, "70", 8734, "Armadyl Armour(with 70 defence)", 8774);
		setSkillString(p, "99", 8735, "Ranged Armour", 8775);
		setSkillString(p, "99", 8736, "Ranged Skillcape", 8776);
		setSidebar(p);
		
		sendSkillInterface(p, item);
		p.showInterface(8714);
	}
	public static void sendSkillInterface(clientHandler p, int id[]) {
		p.outStream.createFrameVarSizeWord(53);
		p.outStream.writeWord(8847); // 8847
		p.outStream.writeWord(id.length);
		for (int i = 0; i < id.length; i++) {
			p.outStream.writeByte(1);
			if(id[i] > 0) {
				p.outStream.writeWordBigEndianA(id[i]+1);
			} else {
				p.outStream.writeWordBigEndianA(0);
			}
		}
		p.outStream.endFrameVarSizeWord();   
		p.flushOutStream();
	}
}