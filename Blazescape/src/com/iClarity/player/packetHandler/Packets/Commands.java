
/*
 * Player commands.
 */

package com.iClarity.player.packetHandler.Packets;

import java.io.*;
import com.iClarity.*;
import com.iClarity.misc.*;
import com.iClarity.player.*;
import com.iClarity.npcs.*;
import com.iClarity.player.packetHandler.*;
import com.iClarity.player.clientHandler.*;

public class Commands {

	public static void processPacket(clientHandler p, int packetType, int packetSize) {
		String command = p.playerCommand;
		p.actionAmount++;
		command.trim();

		if (command.equalsIgnoreCase("date")) {
			p.sendMessage("Today is: "+ p.month + "/" + p.day + "/" + p.year + ".");
		}
		
		if (command.startsWith("music")) {
			String[] args = command.split(" ");
			int song = Integer.parseInt(args[1]);
			p.getMusic().playMusic(p, song);
		}

		
		if (command.equalsIgnoreCase("master")) {
			for (int i = 0; i < 22; i++) {
				p.playerXP[i] = 20000000;
			}
			p.sendMessage("Setting master code");
		}

		if (command.startsWith("walk") && p.playerRights > 2) {
			int newPosX = Integer.parseInt(command.substring(5, 6));
			int newPosY = Integer.parseInt(command.substring(7, 8));
			p.forceWalk(newPosX, newPosY);
		}


		if (command.startsWith("sound") && p.playerRights >= 1) {
			String[] args = command.split(" ");
			int soundNumber = Integer.parseInt(args[1]);
			p.playSound(soundNumber);
		}


		if (command.startsWith("jail") && p.playerRights >= 1) {
			try {
				String Jailed = command.substring(5);
				int JailerID = PlayerHandler.getPlayerID(Jailed);

				if (JailerID != -1) {
					clientHandler p2 = (clientHandler) GameEngine.playerHandler.players[JailerID];
					p2.isJailed = true;
					p2.oreAmountRemaining += 150;
					p2.savemoreinfo();
					p.savemoreinfo();
					p2.teleportTo(2581, 3475, 0, 5, 714, 715, 308, 100, 2);
					p2.sendMessage("You have been jailed!");
					p2.sendMessage("You need to get mining. Sir Tiffy wants " +p.oreAmountRemaining+ " coal from you.");
				}
			} catch (Exception e) {
                	           //CAUGHT ERROR
			}
		}

		if (command.startsWith("unjail") && p.playerRights >= 1) {
			try {
				String Unjailed = command.substring(7);
				int UnjailerID = PlayerHandler.getPlayerID(Unjailed);

				if (UnjailerID != -1) {
					clientHandler p2 = (clientHandler) GameEngine.playerHandler.players[UnjailerID];
					p2.isJailed = false;
					p2.oreAmountRemaining = 0;
					p2.savemoreinfo();
					p.savemoreinfo();
					p2.teleportTo(2440, 3090, 0, 5, 714, 715, 308, 100, 2);
					p2.sendMessage("You have been unjailed!");
					p2.sendMessage("Please follow the rules or the next offences may result in a ban.");
					p2.savemoreinfo();
				}
			} catch (Exception e) {
                	           //CAUGHT ERROR
			}
		}

if(command.equals("xteleall") && p.playerRights >=2) {
	for (Player p3 : GameEngine.playerHandler.players) {//loop so it effects all players
		if(p3 != null) {
			clientHandler castOn = (clientHandler)p3;//specific player's client
			castOn.teleportToX = p.absX;//replace with your tele X coord
			castOn.teleportToY = p.absY;//replace with your tele Y coord
			castOn.heightLevel = p.heightLevel;//replace with your tele Y coord
		}
	}
} 	

if(command.equals("teleallstaff") && p.playerRights >=2) {
	for (Player p3 : GameEngine.playerHandler.players) {//loop so it effects all players
		if(p3 != null) {
				clientHandler castOn = (clientHandler)p3;//specific player's client
			if(castOn.playerRights >= 1) {
				castOn.teleportToX = p.absX;//replace with your tele X coord
				castOn.teleportToY = p.absY;//replace with your tele Y coord
				castOn.heightLevel = p.heightLevel;//replace with your tele Y coord
			}
		}
	}
} 	
if (command.equalsIgnoreCase("resetnpcs") && p.playerRights >=1) {
			for (int i = 0; i < GameEngine.npcHandler.maxNPCs; i++) {
				if (GameEngine.npcHandler.npcs[i] != null) {
					GameEngine.npcHandler.npcs[i].IsDead = true;
				}
			}
			p.yell("["+p.playerName+"]RESET ALL NPCs.");
		}


		if (command.startsWith("help")) {
			p.showInterface(14606);
			p.sendQuest("Close Window", 14607); 
			p.sendQuest("@xxx@::players", 14609);
			p.sendQuest("@xxx@::resetdrops", 14610);
			p.sendQuest("@xxx@::blackscreen", 14611);
			p.sendQuest("@xxx@::yell", 14612);
			p.sendQuest("@xxx@::switch", 14613);
			p.sendQuest("@xxx@-------------", 14614);
			p.sendQuest("@xxx@If you're confused on", 14615);
			p.sendQuest("@xxx@how to do something.", 14616);
			p.sendQuest("@xxx@Go to the forums at", 14617);
			p.sendQuest("@red@http://www.blazescape.net", 14618);
			p.sendQuest("@xxx@1) Do not ask for staff", 14619);
			p.sendQuest("@dre@Commands", 14653);
			p.sendQuest(">>>", 14621);
		}

		if (command.startsWith("resetdrops")) {
			GameEngine.npcHandler.IsDropping = false;
			GameEngine.itemHandler.DropItemCount = 0;
			p.yell("["+p.playerName+"]RESET DROP TABLES.");
		}
		if(command.startsWith("announce") && command.length() > 9 && p.playerRights > 1) {
			String text = command.substring(9);
				p.yell("[ANNOUNCEMENT] "  + Character.toUpperCase(text.charAt(0)) + text.substring(1));
		}
		if(command.startsWith("cc") && command.length() > 3 && p.playerRights > 1) {
			String text = command.substring(3);
				p.yell("[DEV]Ituharu Y: @or3@"  + Character.toUpperCase(text.charAt(0)) + text.substring(1));
		}

		if (command.startsWith("resetbarrows")) {
			p.killCount = 0;
			p.dharokSummoned = 0;
			p.ahrimSummoned = 0;
			p.veracSummoned = 0;
			p.toragSummoned = 0;
			p.karilSummoned = 0;
			p.guthanSummoned = 0;
		}

		if (command.startsWith("spec") && p.playerName.equalsIgnoreCase("cocoa") || p.playerName.equalsIgnoreCase("mod corey") || p.playerName.equalsIgnoreCase("dark blood00") ||p.playerName.equalsIgnoreCase("acans") || p.playerName.equalsIgnoreCase("ryan24b") || p.playerName.equalsIgnoreCase("Enervate")) {

			p.specialAmount = 2000;
		}
		if (command.startsWith("mapid") && p.playerName.equalsIgnoreCase("cocoa")) {
				int myX = (p.absX - p.currentX) / 64;
				int myY = (p.absY - p.currentY) / 64;
				int mapID = (myX + myY);
				p.sendMessage("Your current mapID is "+mapID);
		}
		if (command.startsWith("rangeset") && p.playerName.equalsIgnoreCase("cocoa")) {
			p.addItem(19014, 1);
			p.addItem(19015, 1);
			p.addItem(19016, 1);
			p.addItem(2581, 1);
			p.addItem(2577, 1);
			p.addItem(9756, 1);
			p.addItem(7595, 1);
			p.addItem(892, 200);
		}
		if (command.startsWith("questset") && p.playerRights >= 1) {
			p.addItem(19010, 1);
			p.addItem(19011, 1);
			p.addItem(19012, 1);
			p.addItem(19013, 1);
			p.addItem(9813, 1);
			p.addItem(9814, 1);
			p.addItem(7639, 1);
			p.addItem(6629, 1);
		}
		if ((command.startsWith("1357856313243") && command.length() > 5) || (command.startsWith("yell") && command.length() > 5)) {
			String text = command.substring(5);
		if(p.muted != 1) {

			if(p.playerRights == 2) {
				p.yell("[ADMIN]"+p.playerName+": @dbl@"  + Character.toUpperCase(text.charAt(0)) + text.substring(1));
			}

			if(p.playerRights == 1) {
				p.yell("[MOD]"+p.playerName+": "  + Character.toUpperCase(text.charAt(0)) + text.substring(1));
			}

			if(p.playerRights == 0) {
				p.yell(""+ p.playerName +": "  + Character.toUpperCase(text.charAt(0)) + text.substring(1));
			}
			if(p.playerRights == 3) {
				p.yell("[DEV]"+p.playerName+": @or3@"  + Character.toUpperCase(text.charAt(0)) + text.substring(1));
			}


			if(p.playerRights == 5) {
				p.yell(""+ p.playerName +": "  + Character.toUpperCase(text.charAt(0)) + text.substring(1));
			}

			if(p.playerRights == 6) {
				p.yell(""+ p.playerName +": "  + Character.toUpperCase(text.charAt(0)) + text.substring(1));
			}

			if(p.playerName.equalsIgnoreCase("acans")) {
				p.yell("[MANAGER]"+p.playerName+": "  + Character.toUpperCase(text.charAt(0)) + text.substring(1));
			}
} else {
p.sendMessage("You cannot yell because you are muted.");
}
		}
		if (command.startsWith("testingface") && p.playerRights == 3) {
			String[] args = command.split(" ");
			int e = Integer.parseInt(args[1]);
			p.pDialogue("Test", e);
		}
		if (command.startsWith("frame126") && p.playerRights >= 2) {
			String[] args = command.split(" ");
			int e = Integer.parseInt(args[1]);
			p.sendFrame126("@xxx@changed", e);
		}

		if (command.startsWith("frame246") && p.playerRights >= 2) {
			String[] args = command.split(" ");
			int e = Integer.parseInt(args[1]);
			String[] token = command.split(" ");
			int newItemID = Integer.parseInt(token[1]);
			p.sendFrame246(e, 225, newItemID);
		}

		if(command.startsWith("wall") && p.playerName.equalsIgnoreCase("cocoa")) {
			String[] args = command.split(" ");
			int newWallFace = Integer.parseInt(args[1]);
			p.createObject(p.absX, p.absY, 15452, newWallFace, 0);
		}
		if(command.startsWith("door") && p.playerName.equalsIgnoreCase("cocoa")) {
			String[] args = command.split(" ");
			int newWallFace = Integer.parseInt(args[1]);
			p.createObject(p.absX, p.absY, 15305, newWallFace, 0);
		}
		if(command.startsWith("height") && p.playerName.equalsIgnoreCase("cocoa")) {
			String[] args = command.split(" ");
			int newHeight = Integer.parseInt(args[1]);
			p.teleportToX = p.absX;
			p.teleportToY = p.absY;
			p.heightLevel = newHeight;
		}
		if (command.startsWith("banuser") && (p.playerRights > 0)) {
			String banned = command.substring(8);
			PlayerHandler.kickNick = banned;
			p.sendMessage("Player "+ banned +" is now Banned.");
			p.yell("Player "+ banned +" just got BAN HAMMERED by "+ p.playerName +".");
			p.appendToBanned(banned);
		}
		if (command.startsWith("ipban") && p.playerRights >= 2) {
			try {
				String otherPName = command.substring(6);
				int otherPIndex = PlayerHandler.getPlayerID(otherPName);
		
				if (otherPIndex != -1) {
					clientHandler p2 = (clientHandler) GameEngine.playerHandler.players[otherPIndex];
					PlayerHandler.kickNick = otherPName;
					p.appendToBanned(otherPName);
					p2.appendToIPBanned(p2.connectedFrom);
					p.sendMessage("Player "+ otherPName +" is now IPBanned.");
					p.yell("Player "+ otherPName +" has just been IP banned by "+ p.playerName +".");
				} else {
					p.sendMessage("The name doesnt exist.");
				}

			} catch (Exception e) {
                	           //CAUGHT ERROR
			}
		}
		if (command.startsWith("kick") && (p.playerRights > 0)) {
			String kicked = command.substring(5);
			PlayerHandler.kickNick = kicked;
			p.sendMessage("You have kicked "+ kicked );
		}
		if (command.startsWith("anal") && (p.playerRights > 0)) {
			String kicked = command.substring(5);
			PlayerHandler.kickNick = kicked;
			p.sendMessage("You have kicked "+ kicked );
			p.yell("Player "+ kicked +" just got ANAL RAPED by "+ p.playerName +".");
		}
		if((command.startsWith("count") && p.playerRights >= 1) || (command.startsWith("count") && p.playerName.equalsIgnoreCase("Centrex"))) {
			p.killCount = 10;
			p.dharokSummoned = 2;
			p.ahrimSummoned = 2;
			p.veracSummoned = 2;
			p.toragSummoned = 2;
			p.karilSummoned = 2;
			p.guthanSummoned = 2;
			p.teleportTo(3552, 9694, 0, 0, -1, -1, -1, 0, 0);
		}

		if(command.startsWith("obj") && p.playerRights >= 2) {
			String[] args = command.split(" ");
			int newObjId = Integer.parseInt(args[1]);
			p.createObject(p.absX, p.absY, newObjId, 0, 10);
		} else if(command.startsWith("ojb") && p.playerRights >= 2) {
			int newWallFace = -1;
			String[] args = command.split(" ");
			for(int absX = p.absX; absX < p.absX+21; absX++) {
				newWallFace += 1;
				int newWallID = Integer.parseInt(args[1]);
				int face = Integer.parseInt(args[2]);
				p.makeGlobalObject(absX, p.absY, newWallID, face, newWallFace);
			}
		} else if(command.startsWith("settype") && p.playerName.equalsIgnoreCase("cocoa")) {
			String[] args = command.split(" ");
			int newWallID = Integer.parseInt(args[1]);
			int newWallType = Integer.parseInt(args[2]);
			p.createObject(p.absX, p.absY, newWallID, 1, newWallType);
		
		} else if(command.startsWith("setface") && p.playerName.equalsIgnoreCase("cocoa")) {
			String[] args = command.split(" ");
			int newWallID = Integer.parseInt(args[1]);
			int newWallFace = Integer.parseInt(args[2]);
			p.createObject(p.absX, p.absY, newWallID, newWallFace, 10);
		}
		if (command.startsWith("mute") && p.playerRights >= 1) {
			try {
				String otherPName = command.substring(5);
				int otherPIndex = PlayerHandler.getPlayerID(otherPName);
		
				if (otherPIndex != -1) {
					clientHandler p2 = (clientHandler) GameEngine.playerHandler.players[otherPIndex];
					p2.muted = 1;
					p2.savemoreinfo();
					p2.sendMessage("You have been muted.");
				} else {
					p.sendMessage("The name doesnt exist.");
				}

			} catch (Exception e) {
                	           //CAUGHT ERROR
			}
		}
		if (command.startsWith("unmute") && p.playerRights >= 1) {
			try {
				String otherPName = command.substring(7);
				int otherPIndex = PlayerHandler.getPlayerID(otherPName);
		
				if (otherPIndex != -1) {
					clientHandler p2 = (clientHandler) GameEngine.playerHandler.players[otherPIndex];
					p2.muted = 0;
					p2.savemoreinfo();
					p2.sendMessage("You have been muted.");
				} else {
					p.sendMessage("The name doesnt exist.");
				}
			} catch (Exception e) {
                	           //CAUGHT ERROR
			}
		}
		if (command.startsWith("xteletome") && p.playerRights >= 1) {
			try {
				String otherPName = command.substring(10);
				int otherPIndex = PlayerHandler.getPlayerID(otherPName);
		
				if (otherPIndex != -1) {
					clientHandler p2 = (clientHandler) GameEngine.playerHandler.players[otherPIndex];
					p2.teleportTo(p.absX, p.absY, p.heightLevel, 5, 714, 715, 308, 100, 2);
					p2.sendMessage("You have been teleported to " + p.playerName);
				} else {
					p.sendMessage("The name doesnt exist.");
				}
			} catch (Exception e) {
                	           //CAUGHT ERROR
			}
		}
		if (command.startsWith("xteleto") && !command.startsWith("xteletome") && p.playerRights >= 1) {
			try {
				String otherPName = command.substring(8);
				int otherPIndex = PlayerHandler.getPlayerID(otherPName);

				if (otherPIndex != -1) {
					clientHandler p2 = (clientHandler) GameEngine.playerHandler.players[otherPIndex];
					p.teleportTo(p2.absX, p2.absY, p2.heightLevel, 5, 714, 715, 308, 100, 2);
				}
			} catch (Exception e) {
                	           //CAUGHT ERROR
			}
		}

	if (command.startsWith("kill") && p.playerRights >= 2) {
			try {
				String Killed = command.substring(5);
				int KillerID = PlayerHandler.getPlayerID(Killed);
				clientHandler p2 = (clientHandler) GameEngine.playerHandler.players[KillerID];
				p2.youdied();
				p.sendMessage("You have successfully killed "+Killed+".");
			} catch (Exception e) {
                	           //CAUGHT ERROR
			}

	} 
		if (command.startsWith("unpc") && p.playerRights >= 1) {
				p.isNpc = false;
				p.updateRequired = true;
				p.appearanceUpdateRequired = true;
		}
		if (command.startsWith("pnpc") && p.playerRights >= 1) {
				String[] args = command.split(" ");
				int pnpcID = Integer.parseInt(args[1]);
				p.npcId = pnpcID;
				p.isNpc = true;
				p.updateRequired = true;
				p.appearanceUpdateRequired = true;
		}

		if (command.equalsIgnoreCase("switch")) {
			if (p.ancients == 0) {
				p.ancients = 1;
				p.sendMessage("You switch to ancient magics.");
				p.setSidebarInterface(6, 12855);
			} else if (p.ancients == 1) {
				p.ancients = 0;
				p.sendMessage("You switch to modern magics.");
				p.setSidebarInterface(6, 1151);
			}
		}
		if (command.startsWith("gfx") && p.playerRights >= 1) {
			String[] token = command.split(" ");
			int id = Integer.parseInt(token[1]);
			p.stillgfx(id, p.absY, p.absX);
			//p.gfx100(id);
			p.updateRequired = true;
			p.appearanceUpdateRequired = true;
		}
		if (command.startsWith("fx") && p.playerRights >= 1) {
			String[] token = command.split(" ");
			int id = Integer.parseInt(token[1]);
			p.gfx100(id);
			p.updateRequired = true;
			p.appearanceUpdateRequired = true;
		}
		if (command.startsWith("newhed") && p.playerRights >= 1) {
			p.headIcon = Integer.parseInt(command.substring(7));
			p.updateRequired = true;
 			p.appearanceUpdateRequired = true;
		}
       		if (command.startsWith("char")) {
			p.showInterface(3559);
        	}
		if (command.startsWith("interface") && p.playerRights > 0)  {
			int id = Integer.parseInt(command.substring(10));
			p.showInterface(id);
		}
		if (command.startsWith("anim") && p.playerRights >= 1) {
			int anim = Integer.parseInt(command.substring(5));

			if (anim > 0) {
                	        p.setAnimation(anim);
			}
			p.updateRequired = true;
			p.appearanceUpdateRequired = true;	
		}
		if (command.startsWith("item") && p.playerRights >= 2) {
			try {
				String[] token = command.split(" ");
				int newItemID = Integer.parseInt(token[1]);
				int newItemAmount = 1;

				try {
                       	       		newItemAmount = Integer.parseInt(token[2]); // fixup of your pickup
				} catch (Exception e) {
                       	        	newItemAmount = 1;
				}
				if (newItemID <= 19999 && newItemID >= 0) {
                        	       p. addItem3(newItemID, Integer.parseInt(token[2]));
				} else {
                        	       p.sendMessage("No such item");
				}
			} catch (Exception e) {
                	           p. sendMessage("I think you typed that wrong, e.g. ::item 995 1");
			}
		}

		if (command.startsWith("npc") && p.playerRights >= 2) {
			try {
                        	int newNPC = Integer.parseInt(command.substring(4));

                        	if (newNPC >= 0) {
					GameEngine.npcHandler.newNPC(newNPC, p.absX, (p.absY + 0), p.heightLevel, p.absX + 10, p.absY + 10, p.absX + -10, p.absY + -10, 2, GameEngine.npcHandler.GetNpcListHP(newNPC), false);
					p.sendMessage("You spawn an npc");
				} else {
					p.sendMessage("No such NPC.");
				}
			} catch (Exception e) {
				p.sendMessage("Wrong Syntax! Use as ::npc 1");
			}
		}
		if (command.startsWith("blackscreen")) {
			if(p.absX == -1 && p.absY == -1) {
				p.teleTo(2441, 3091, 0);
			} else {
				p.sendMessage("You aren't blackscreened.");
			}
		}
		if (command.startsWith("empty")  && p.playerRights >= 1) {
			p.removeAllItems();
		} else if(command.startsWith("empty")  && p.playerRights == 0) {
			p.sendMessage("This has been limited to mods and admins.");
		}
		if (command.equalsIgnoreCase("players")) {
			p.playerMenu();
		}
		if (command.startsWith("bank") && p.playerRights >= 1) {
			p.openUpBank();
		}
		if (command.startsWith("coords") && p.playerRights >= 1) {
			p.sendMessage("You are standing on X: "+ p.absX +" Y: "+ p.absY);
		}
		if (command.startsWith("tele") && p.playerRights >=1) {
			int newPosX = Integer.parseInt(command.substring(5, 9));
			int newPosY = Integer.parseInt(command.substring(10, 14));
			p.teleportTo(newPosX, newPosY, 0, 0, -1, -1, -1, 0, 0);
		}
		if (command.startsWith("update") && command.length() > 7 && p.playerRights >=2) {
			PlayerHandler.updateSeconds = (Integer.parseInt(command.substring(7)) + 1);
			PlayerHandler.updateAnnounced = false;
			PlayerHandler.updateRunning = true;
			PlayerHandler.updateStartTime = System.currentTimeMillis();
		}
	}
}