/*
 * Handle Dialogues.
 */

package com.iClarity.player.packetHandler.Packets;

import com.iClarity.player.*;
import com.iClarity.event.*;
import com.iClarity.misc.*;
import com.iClarity.player.packetHandler.*;

public class NPCDialogue {

	public static void processPacket(clientHandler p, int packetType, int packetSize) {
		int i = p.NpcDialogue;

		switch(i) {

			case 2617:
			case 2100:
			case 1918:
			case 1919:
			case 1920:
			case 1922:
			case 1923: 
			case 1924: 
			case 1925: 
			case 1926: 
			case 1927: 
			case 5000: 
			case 673: 
			case 1: 
			case 3: 
			case 5 : 
			case 40: 
			case 42: 
			case 1001: 
			case 1002: 
			case 2259: 
			case 2260: 
			case 301: 
			case 305: 
			case 308: 
			case 309: 
			case 313: 
			case 314: 
			case 317: 
			case 318: 
			case 319: 
			case 322: 
			case 323: 
			case 14600: 
			case 14602: 
			case 650: 
			case 1694: 
			case 2244: 
			case 802: 
			case 803:
			case 804: 
			case 805: 
			case 806: 
			case 807: 
			case 809: 
			case 810: 
			case 522: 
			case 547: 
			case 548: 
			case 544: 
			case 545: 
			case 583: 
			case 577: 
			case 578: 
			case 1597: 
			case 1601: 
			case 1602: 
			case 1605:
			case 3000:
			case 57:
				p.NpcDialogue += 1;
				p.NpcDialogueSend = false;
			break;
			case 1606:
				p.openUpShop(72);
				p.NpcDialogue = 0;
				break;
			case 580:
				p.NpcDialogue += 2;
				break;
			case 1835:
				p.NpcDialogue = 1859;
				p.NpcDialogueSend = false;
			break;
			case 1836:
				p.NpcDialogue = 1839;
				p.NpcDialogueSend = false;
			break;
			case 1837:
				p.NpcDialogue = 1840;
				p.NpcDialogueSend = false;
			break;
			case 1838:
				p.NpcDialogue = 1841;
				p.NpcDialogueSend = false;
			case 1849://Easter
			case 1850:
				if(p.easterStage == 4) {
					if(p.easterCorrect >= 2) {
						p.NpcDialogue = 1842;
						p.NpcDialogueSend = false;
						p.easterStage = 5;
						p.sendMessage("Happy Easter from the BlazeScape Staff!");
						p.sendMessage("The rabbit hands you an item.");								int easterRandom = Misc.random(3);
						if(easterRandom == 0) {
							p.addItem(1037, 1);
						}
						if(easterRandom == 1) {
							p.addItem(1961, 1);
						}
						if(easterRandom == 2) {
							p.addItem(4565, 1);
						}
						if(easterRandom == 3) {
							p.addItem(4566, 1);
						}
					} else if(p.easterCorrect <= 1) {
						p.NpcDialogue = 1843;
						p.NpcDialogueSend = false;
						p.easterCorrect = 0;
						p.easterStage = 0;
					}
				}
			break;
			case 1851:
				if(p.easterStage == 1) {
					p.NpcDialogue = 1845;
					p.NpcDialogueSend = false;
				}
			case 1852:
				if(p.easterStage == 1) {
					p.NpcDialogue = 1846;
					p.NpcDialogueSend = false;
				}
				if(p.easterStage == 3) {
					p.NpcDialogue = 1849;
					p.NpcDialogueSend = false;
				}
			break;
			case 1853:
				if(p.easterStage == 1) {
					p.NpcDialogue = 1845;
					p.NpcDialogueSend = false;
				}
				if(p.easterStage == 2) {
					p.NpcDialogue = 1847;
					p.NpcDialogueSend = false;
				}
				if(p.easterStage == 3) {
					p.NpcDialogue = 1850;
					p.NpcDialogueSend = false;
				}
			break;
			case 1854:
				if(p.easterStage == 2) {
					p.NpcDialogue = 1848;
					p.NpcDialogueSend = false;
				}
			break;
			case 1855:
				if(p.easterStage == 2) {
					p.NpcDialogue = 1847;
					p.NpcDialogueSend = false;
				}
			break;
			case 1856:
				if(p.easterStage == 3) {
					p.NpcDialogue = 1849;
					p.NpcDialogueSend = false;
				}
			break;
			case 1845:
			case 1846:
				p.NpcDialogue = 1837;
				p.NpcDialogueSend = false;
			break;
			case 1847:
			case 1848:
				p.NpcDialogue = 1838;
				p.NpcDialogueSend = false;
			break;
				
			default:
				p.NpcDialogue = 0;
				p.RemoveAllWindows();
				break;
		}
		p.NpcDialogueSend = false;
	}
}