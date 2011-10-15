/*
 * Load packets via an array.
 */

package com.iClarity.player.packetHandler;

import com.iClarity.*;
import com.iClarity.player.*;
import com.iClarity.player.Skills.*;
import com.iClarity.misc.*;
import com.iClarity.player.DataFiles.*;
import com.iClarity.player.packetHandler.Packets.*;

public class PacketHandler {


	public static void loadPackets(clientHandler p, int packetType, int packetSize) {
		switch (packetType) {

			case 39:
				DuelOption.processPacket(p, packetType, packetSize);
				break;

			case 40:
				NPCDialogue.processPacket(p, packetType, packetSize);
				break;

			case 75:
				ItemOption2.processPacket(p, packetType, packetSize);
				break;

			case 16:
				ItemOption3.processPacket(p, packetType, packetSize);						
				break;

			case 192:
				ItemOnObject.processPacket(p, packetType, packetSize);
				break;

			case 130:
				Clicking.processPacket(p, packetType, packetSize);
				break;

			case 155:
				FirstNpcClick.processPacket(p, packetType, packetSize);
				break;

			case 17:
				SecondNpcClick.processPacket(p, packetType, packetSize);
				break;

			case 72:
				AttackNPC.processPacket(p, packetType, packetSize);
				break;

			case 122:
				ItemClicking.processPacket(p, packetType, packetSize);
				break;

			  case 101:
				CharacterDesign.processPacket(p, packetType, packetSize);
                                break;

			case 181:
				MagicOnGround.processPacket(p, packetType, packetSize);
				break;

			case 57: 
				ItemOnNPC.processPacket(p, packetType, packetSize);
				break;

			case 53: 
				ItemOnItem.processPacket(p, packetType, packetSize);
				break;

			case 4:	
				PlayerChat.processPacket(p, packetType, packetSize);
				break;

			case 132:
				ObjectOption1.processPacket(p, packetType, packetSize);
				break;

			case 252:
				ObjectOption2.processPacket(p, packetType, packetSize);
                                break;

			case 70:
				ObjectOption3.processPacket(p, packetType, packetSize);
				break;
/*
			case 234:
				ObjectOption4.processPacket(p, packetType, packetSize);
				break;
*/
         		case 73: 
				Following.processPacket(p, packetType, packetSize);
            			break;

			case 139: 
				Trading.processPacket(p, packetType, packetSize);
				break;

			case 237: 
				MagicOnItem.processPacket(p, packetType, packetSize);
				break;

			case 249:
				MagicOnPlayer.processPacket(p, packetType, packetSize);
				break;

			case 131: 
				MagicOnNPC.processPacket(p, packetType, packetSize);
				break;

			case 153:
				AttackPlayer.processPacket(p, packetType, packetSize);
            			break;

			case 128: //Trade Request
				DuelWithPlayer.processPacket(p, packetType, packetSize);
				break;

			case 214:
				MoveInvItems.processPacket(p, packetType, packetSize);
				break;

			case 41:
				Equipment.processPacket(p, packetType, packetSize);
				break;

			case 185:
				ActionButtons.processPacket(p, packetType, packetSize);
				break;

			case 248:
				packetSize -= 14;
				p.closeInterface();
				p.resetAnimation();
			case 164:
			case 98:
			if(p.IsDead == false) {
				Walking.processPacket(p, packetType, packetSize);
			}
				break;

			case 103:
				p.playerCommand = p.inStream.readString();

				if (p.inCombat > 0) {
					p.sendMessage("You cannot use commands while in combat!");
					break;
				}
				Commands.processPacket(p, packetType, packetSize);
				break;

			case 121:
                //p.writePlayers();
				p.callObjects();
				p.SpawnStumps();
                p.hasntLoggedin = true;
				p.updateRequired = true;
				p.appearanceUpdateRequired = true;
				break;

			case 218:
				String receivedPlayerName = Misc.longToPlayerName(p.inStream.readQWord());
				int rule = p.inStream.readUnsignedByte();
				int mute = p.inStream.readUnsignedByte();
				break;


			case 95: // update chat
				p.Tradecompete = p.inStream.readUnsignedByte();
				p.Privatechat = p.inStream.readUnsignedByte();
				p.Publicchat = p.inStream.readUnsignedByte();
				for(int i1 = 1; i1 < p.handler.maxPlayers; i1++) {
		 			if(p.handler.players[i1] != null && p.handler.players[i1].isActive == true) {
	 			 		p.handler.players[i1].pmupdate(p.playerId, p.GetWorld(p.playerId));
					}
				}
				break;
			case 188: // add friend
				long friendtoadd = p.inStream.readQWord();
				boolean CanAdd = true;
				for(int i1 = 0; i1 < p.friends.length; i1++) {
					if (p.friends[i1] != 0 && p.friends[i1] == friendtoadd) {
						CanAdd = false;
						p.sendMessage(friendtoadd+" is already in your friendlist.");
					}
				}
				if (CanAdd == true) {
					for(int i1 = 0; i1 < p.friends.length; i1++) {
						if(p.friends[i1] == 0) {
							p.friends[i1] = friendtoadd;
		 					for(int i2 = 1; i2 < p.handler.maxPlayers; i2++) {
	 			 				if(p.handler.players[i2] != null && p.handler.players[i2].isActive && Misc.playerNameToInt64(p.handler.players[i2].playerName) == friendtoadd) {
		 			 				if(p.playerRights >= 2 || p.handler.players[i2].Privatechat == 0 || (p.handler.players[i2].Privatechat == 1 && p.handler.players[i2].isinpm(Misc.playerNameToInt64(p.playerName)))) {
		 			 					p.loadpm(friendtoadd, p.GetWorld(i2));
		 			 					break;
	 			 					}
								}
							}
							break;
						}
					}
				}
				break;
			case 215: // remove friend
				long friendtorem = p.inStream.readQWord();
				for(int i1 = 0; i1 < p.friends.length; i1++) {
					if(p.friends[i1] == friendtorem) {
    		    				p.friends[i1] = 0;
						break;
					}
				}
				break;
			case 133: // add ignore
				long igtoadd = p.inStream.readQWord();
				for (int i10 = 0; i10 < p.ignores.length; i10++) {
					if (p.ignores[i10] == 0) {
    		    				p.ignores[i10] = igtoadd;
						break;
					}
				}
				break;
			case 74: // remove ignore
				long igtorem = p.inStream.readQWord();
				for(int i11 = 0; i11 < p.ignores.length; i11++) {
					if(p.ignores[i11] == igtorem) {
    		    				p.ignores[i11] = 0;
						break;
					}
				}
				break;
			case 126: //pm message
				long friendtosend = p.inStream.readQWord();
				byte pmchatText[] = new byte[100];
				int pmchatTextSize = (byte)(packetSize-8);
				p.inStream.readBytes(pmchatText, pmchatTextSize, 0);

				for (int i1 = 0; i1 < p.friends.length; i1++) {
					if (p.friends[i1] == friendtosend) {
    		    				boolean pmsent = false;

		 				for (int i2 = 1; i2 < p.handler.maxPlayers; i2++) {
							if (p.handler.players[i2] != null && p.handler.players[i2].isActive && Misc.playerNameToInt64(p.handler.players[i2].playerName) == friendtosend) {
								if (p.playerRights >= 2 || p.handler.players[i2].Privatechat == 0 || (p.handler.players[i2].Privatechat == 1 && p.handler.players[i2].isinpm(Misc.playerNameToInt64(p.playerName)))) {
					 				p.handler.players[i2].sendpm(Misc.playerNameToInt64(p.playerName), p.playerRights, pmchatText, pmchatTextSize);
		 		 					pmsent = true;
		 		 				}
	 		 					break;
							}
						}
		 				if (!pmsent) {
							p.sendMessage("Player currently not available");
							break;
						}
					}
				}
				break;

			case 236: //pickup item
				int itemY = p.inStream.readSignedWordBigEndian();
				int itemID = p.inStream.readUnsignedWord();
				int itemX = p.inStream.readSignedWordBigEndian();
				p.apickupid = itemID;
				p.apickupx = itemX;
				p.apickupy = itemY;
				break;

			case 241:
                                int mouseclick = p.inStream.readDWord();

                                if (p.oldclick == mouseclick) {
                                	p.sameclick += 1;
                                } else {
                                	p.sameclick = 0;
				}
                                p.oldclick = mouseclick;
				break;

			case 924:
				p.outStream.createFrame(999999); 
				break;

			case 145:	//remove item (opposite for wearing) - bank 1 item - value of item
				int interfaceID = p.inStream.readUnsignedWordA();
				int removeSlot = p.inStream.readUnsignedWordA();
				int removeID = p.inStream.readUnsignedWordA();

				if (interfaceID == 1688) {
					if (p.playerEquipment[removeSlot] == removeID) {
						if(p.playerEquipment[removeSlot] != 4513
						&& p.playerEquipment[removeSlot] != 4515
						&& p.playerEquipment[removeSlot] != 4041
						&& p.playerEquipment[removeSlot] != 4042
						&& p.playerEquipment[removeSlot] != 4041) {
							p.remove(removeID, removeSlot);
						} else {
							p.sendMessage("You cannot remove that item!");
						}
					}
				} else if (interfaceID == 5064) { //remove from bag to bank
					p.bankItem(removeID , removeSlot, 1);
				} else if (interfaceID == 5382) { //remove from bank
					p.fromBank(removeID , removeSlot, 1);
				} else if (interfaceID == 3322) { //remove from bag to trade window
					if (p.duelStatus == -1) {
                        if (p.isUntradable(removeID)) {
							p.sendMessage("You cannot trade this item.");
                                        	} else {
							p.tradeItem(removeID , removeSlot, 1);
						}
					} else if (p.duelStatus == 1) {
 						if (p.isUntradable(removeID)) {
							p.sendMessage("You cannot stake this item.");
						} else {
							p.stakeItem(removeID, removeSlot, 1);
						}
					}
				} else if (interfaceID == 6669) {
					if (p.duelStatus == 1) {
						p.fromDuel(removeID, removeSlot, 1);
					}
				} else if (interfaceID == 3415) { //remove from trade window
					if (PlayerHandler.players[p.tradeWith].tradeStatus == 2) {
						p.fromTrade(removeID, removeSlot, 1);
					}
				} else if (interfaceID == 3823) { //Show value to sell items
					if (DataFiles.itemSellable[removeID] == false) {
						p.sendMessage("You cannot sell "+ p.GetItemName(removeID)+".");
					} else {
						boolean IsIn = false;
						if (GameEngine.shopHandler.ShopSModifier[p.MyShopID] > 1) {
							for (int j = 0; j <= GameEngine.shopHandler.ShopItemsStandard[p.MyShopID]; j++) {
								if (removeID == (GameEngine.shopHandler.ShopItems[p.MyShopID][j] - 1)) {
									IsIn = true;
									break;
								}
							}
						} else {
							IsIn = true;
						}
						if (IsIn == false && p.WanneShop != 11) {
							p.sendMessage("You cannot sell "+ p.GetItemName(removeID)+" in this store.");
						} else {
							int ShopValue = (int)Math.floor(p.GetItemShopValue(removeID, 1, removeSlot));
							String ShopAdd = "";
                                        if (ShopValue <= 1)
                                        {
					ShopValue = (int)Math.floor(p.GetItemShopValue(removeID, 0, removeSlot));
                                        }
							if (ShopValue >= 1000 && ShopValue < 1000000) {
								ShopAdd = " (" + (ShopValue / 1000) + "K)";
							} else if (ShopValue >= 1000000) {
								ShopAdd = " (" + (ShopValue / 1000000) + " million)";
							}
							p.sendMessage(p.GetItemName(removeID)+": shop will buy for "+ShopValue+" BlazeScape Tickets.");
					    }
					}
				} else if (interfaceID == 3900) { //Show value to buy items
					int ShopValue = (int)Math.floor(p.GetItemShopValue(removeID, 0, removeSlot));
					String ShopAdd = "";
                                        if (ShopValue <= 1)
                                        {
					ShopValue = (int)Math.floor(p.GetItemShopValue(removeID, 0, removeSlot));
                                        }
					if (ShopValue >= 1000 && ShopValue < 1000000) {
						ShopAdd = " (" + (ShopValue / 1000) + "K)";
					} else if (ShopValue >= 1000000) {
						ShopAdd = " (" + (ShopValue / 1000000) + " million)";
					}
					p.sendMessage(p.GetItemName(removeID)+": currently costs "+ShopValue+" BlazeScape Tickets."+ShopAdd);
				}



				break;

			case 117:	//bank 5 items - sell 1 item
				//p.sendMessage("Packet 117.");
				interfaceID = p.inStream.readSignedWordBigEndianA();
				removeID = p.inStream.readSignedWordBigEndianA();
				removeSlot = p.inStream.readSignedWordBigEndian();



				if (interfaceID == 5064) { //remove from bag to bank
					p.bankItem(removeID , removeSlot, 5);
				} else if (interfaceID == 5382) { //remove from bank
					p.fromBank(removeID , removeSlot, 5);
				} else if (interfaceID == 3322) { //remove from bag to trade window
					if (p.duelStatus == -1) {
						if (p.isUntradable(removeID)) {
							p.sendMessage("You cannot trade this item.");
						} else {
							p.tradeItem(removeID , removeSlot, 5);
						}
					} else if (p.duelStatus == 1) {
 						if (p.isUntradable(removeID)) {
							p.sendMessage("You cannot stake this item.");
						} else {
							p.stakeItem(removeID, removeSlot, 5);
						}
					}
				} else if (interfaceID == 6669) {
					if (p.duelStatus == 1) {
						p.fromDuel(removeID, removeSlot, 5);
					}
				} else if (interfaceID == 3415) { //remove from trade window
					if (PlayerHandler.players[p.tradeWith].tradeStatus == 2) {
						p.fromTrade(removeID, removeSlot, 5);
					}
				} else if (interfaceID == 3823) { //Show value to sell items
					p.sellItem(removeID, removeSlot, 1);
				} else if (interfaceID == 3900) { //Show value to buy items
					p.buyItem(removeID, removeSlot, 1);
				}
				break;

			case 43:	//bank 10 items - sell 5 items
				//p.sendMessage("Packet 43.");
				interfaceID = p.inStream.readUnsignedWordBigEndian();
				removeID = p.inStream.readUnsignedWordA();
				removeSlot = p.inStream.readUnsignedWordA();


				if (interfaceID == 5064) { //remove from bag to bank
					p.bankItem(removeID , removeSlot, 10);
				} else if (interfaceID == 5382) { //remove from bank
					p.fromBank(removeID , removeSlot, 10);
				} else if (interfaceID == 3322) { //remove from bag to trade window
					if (p.duelStatus == -1) {
                                        	if (p.isUntradable(removeID)) {
							p.sendMessage("You cannot trade this item.");
                                        	} else {
							p.tradeItem(removeID , removeSlot, 10);
						}
					} else if (p.duelStatus == 1) {
 						if (p.isUntradable(removeID)) {
							p.sendMessage("You cannot stake this item.");
						} else {
							p.stakeItem(removeID, removeSlot, 10);
						}
					}
				} else if (interfaceID == 6669) {
					if (p.duelStatus == 1) {
						p.fromDuel(removeID, removeSlot, 10);
					}
				} else if (interfaceID == 3415) { //remove from trade window
					if (PlayerHandler.players[p.tradeWith].tradeStatus == 2) {
						p.fromTrade(removeID, removeSlot, 10);
					}
				} else if (interfaceID == 3823) { //Show value to sell items
					p.sellItem(removeID, removeSlot, 5);
				} else if (interfaceID == 3900) { //Show value to buy items
					p.buyItem(removeID, removeSlot, 5);
				}
				break;

			case 129:	//bank all items - sell 10 items
				//p.sendMessage("Packet 129.");
				removeSlot = p.inStream.readUnsignedWordA();
				interfaceID = p.inStream.readUnsignedWord();
				removeID = p.inStream.readUnsignedWordA();

				//println_debug("RemoveItem all: "+removeID +" InterID: "+interfaceID +" slot: "+removeSlot );

				if (interfaceID == 5064) { //remove from bag to bank
					if (DataFiles.itemStackable[removeID] == true) {
						p.bankItem(p.playerItems[removeSlot] , removeSlot, p.playerItemsN[removeSlot]);
					} else {
						p.bankItem(p.playerItems[removeSlot] , removeSlot, p.itemAmount(p.playerItems[removeSlot]));
					}
				} else if (interfaceID == 5382) { //remove from bank
					p.fromBank(p.bankItems[removeSlot] , removeSlot, p.bankItemsN[removeSlot]);
				} else if (interfaceID == 3322) { //remove from bag to trade window
					if (p.duelStatus == -1) {
                                        	if (p.isUntradable(removeID)) {
                                        		p.sendMessage("You cannot trade this item");
                                        	} else {
							p.tradeItem(removeID, removeSlot, p.playerItemsN[removeSlot]);
						}
					} else if (p.duelStatus == 1) {
						if (p.isUntradable(removeID)) {
							p.sendMessage("You cannot stake this item.");
						} else {
							if (!DataFiles.itemStackable[removeID] && !DataFiles.itemIsNote[removeID]) {
								p.stakeItem(removeID, removeSlot, p.InvItemAmt(p.playerItems[removeSlot] - 1));
							} else {
								p.stakeItem(removeID, removeSlot, p.playerItemsN[removeSlot]);
							}
						}
					}
				} else if (interfaceID == 6669) {
					if (p.duelStatus == 1) {
						p.fromDuel(removeID, removeSlot, -924);
					}
				} else if (interfaceID == 3415) { //remove from trade window
					if (PlayerHandler.players[p.tradeWith].tradeStatus == 2) {
						p.fromTrade(removeID, removeSlot, p.playerTItemsN[removeSlot]);
					}
				} else if (interfaceID == 3823) { //Show value to sell items
					p.sellItem(removeID, removeSlot, 10);
				} else if (interfaceID == 3900) { //Show value to buy items
					p.buyItem(removeID, removeSlot, 10);
				}
				break;


			case 135:	//bank X items
				p.outStream.createFrame(27);
				p.XremoveSlot = p.inStream.readSignedWordBigEndian();
				p.XinterfaceID = p.inStream.readUnsignedWordA();
				interfaceID = p.inStream.readUnsignedWord();
				p.XremoveID = p.inStream.readSignedWordBigEndian();
				break;

			case 208:	//Enter Amount Part 2
				//p.sendMessage("Packet 208.");
				int EnteredAmount = p.inStream.readDWord();

            			if (p.XinterfaceID == 5064) { //remove from bag to bank
					p.bankItem(p.playerItems[p.XremoveSlot], p.XremoveSlot, EnteredAmount);
				} else if (p.XinterfaceID == 5382) { //remove from bank
					p.fromBank(p.bankItems[p.XremoveSlot], p.XremoveSlot, EnteredAmount);
				} else if (p.XinterfaceID == 3322) { //remove from bag to trade window
					if (p.duelStatus == -1) {
						if (p.isUntradable(p.XremoveID)) {
							p.sendMessage("You cannot trade this item.");
						} else {
							p.tradeItem(p.XremoveID, p.XremoveSlot, EnteredAmount);
						}
						break;
					}
					if (p.duelStatus != 1) {
						break;
					}
					if (p.isUntradable(p.XremoveID)) {
						p.sendMessage("You cannot stake this item.");
					} else {
						p.stakeItem(p.XremoveID, p.XremoveSlot, EnteredAmount);
					}
				} else if (p.XinterfaceID == 6669) {
					if (p.duelStatus == 1) {
						p.fromDuel(p.XremoveID, p.XremoveSlot, EnteredAmount);
					}
				} else if (p.XinterfaceID == 3900) { //Shop
					if (EnteredAmount <= 100) {
						p.buyItem(p.XremoveID, p.XremoveSlot, EnteredAmount);
					} else {
						p.sendMessage("You cannot buy more than 100 items at a time.");
					}
				} else if (p.XinterfaceID == 3415) { //remove from trade window
					if (PlayerHandler.players[p.tradeWith].tradeStatus == 2) {
						p.fromTrade(p.XremoveID, p.XremoveSlot, EnteredAmount);
					}
				}
				break;

			case 87:		// drop item
				int droppedItem = p.inStream.readUnsignedWordA();
				int somejunk = p.inStream.readUnsignedByte() + p.inStream.readUnsignedByte();
				int slot = p.inStream.readUnsignedWordA();

                                if (p.wearing == false && p.playerItems[slot] == droppedItem + 1) {
					if(!p.isUntradable(droppedItem)) {
						p.dropItem(droppedItem, slot);
					} else {
						//p.deleteItem(droppedItem, p.GetItemSlot(slot), p.playerItemsN[slot]);
						p.sendMessage("You can't drop untradeable items!");
					}
					//GameEngine.itemHandler.PlayerDropItem(droppedItem, playerItemsN[slot], absX, absY, slot, playerId);
                                }
				break;

                        case 120: // sends sidebar id when clicked while it's flashing - found by xerozcheez
                        int sidebarID = p.inStream.readUnsignedByte();
			if(p.playerRights >= 2) {
                        System.out.println("Packet 120: Sidebar Id: "+sidebarID);
			}
                        break;

			case 189:
			case 230:
			case 226:
			case 78:
			case 148:
			case 183:
			case 136:
			case 152:
			case 200:
			case 85:
			case 165:
			case 238:
			case 150:
			case 36:
			case 246:
			case 77:

				break;
			default:
				//interfaceID = inStream.readUnsignedWordA();
				//int actionButtonId1 = Misc.HexToInt(inStream.buffer, 0, packetSize);
				//p.println_debug("Unhandled packet ["+packetType+", InterFaceId: " +interfaceID+", size="+packetSize+"]: ]"+Misc.Hex(inStream.buffer, 1, packetSize)+"[");
				//p.println_debug("Action Button: "+actionButtonId1);
			break;
		}
	}

	public static boolean packetProcess(clientHandler p) {
		if (p.disconnected) {
			return false;
		}
		try {
			if (p.timeOutCounter++ > 20) {
				p.actionReset();
				p.disconnected = true;
				return false;
			}
			if (p.in == null) {
				return false;
			}
			int avail = p.in.available();

			if (avail == 0) {
				return false;
			}
			if (p.packetType == -1) {
				p.packetType = p.in.read() & 0xff;

				if (p.inStreamDecryption != null) {
					p.packetType = p.packetType - p.inStreamDecryption.getNextKey() & 0xff;
				}
				p.packetSize = p.packetSizes[p.packetType];
				avail--;
			}
			if (p.packetSize == -1) {
				if (avail > 0) {
					p.packetSize = p.in.read() & 0xff;
					avail--;
				} else {
					return false;
				}
			}
			if (avail < p.packetSize) {
				return false;
			}
			p.fillInStream(p.packetSize);
            		p.timeOutCounter = 0;
			loadPackets(p, p.packetType, p.packetSize);
			p.packetType = -1;
		} catch(java.lang.Exception __ex) {
			__ex.printStackTrace();
			p.disconnected = true;
			if(p.playerRights >= 2) {
                  	System.out.println("Server - exception.");
			}
		}
		return true;
	}
}