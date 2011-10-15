package com.iClarity.npcs;

import java.io.*;
import com.iClarity.misc.*;
import com.iClarity.world.*;
import com.iClarity.player.*;
import com.iClarity.GameEngine;
import com.iClarity.npcs.Combat.*;
import com.iClarity.player.clientHandler.*;

public class NPC {

public int moleTeleports = 0;

public int focusPointX, focusPointY;
public boolean turnUpdateRequired;

public void turnNpc(int i, int j) {
    focusPointX = 2 * i + 1;
    focusPointY = 2 * j + 1;
    updateRequired = true;
    turnUpdateRequired = true;
}

    public void MoveBackToOrigin()
    {
        if (RandomWalk && moverangeX1 > 0 && moverangeY1 > 0 && moverangeX2 > 0 && moverangeY2 > 0)
        {
            if (absX > moverangeX1 || absX < moverangeX2 || absY > moverangeY1 || absY < moverangeY2)
            {
                moveX = GetMove(absX, makeX);
                moveY = GetMove(absY, makeY);
                getNextNPCMovement();
            }
        }
    }

	/*
	 * Constructor
	 */
	public NPC(int _npcId, int _npcType) {
		npcId = _npcId;
		npcType = _npcType;
		direction = -1;
		IsDead = false;
		DeadApply = false;
		deathTimer = 0;
		RandomWalk = true;
		IsUnderAttack = false;

		for (int i = 0; i < Killing.length; i++) {
			Killing[i] = 0;
		}
	}
	public int[] Killing = new int[GameEngine.playerHandler.maxPlayers];

	/*public int DefPower() {
		return (DefLvl + DefLvl + (int)((double)DefLvl * 0.10000000000000001D)) - (int)statDrain;
	}*/

	
	/*
	 * The Npc's index.
	 */
	public int npcId;

	/*
	 * The ID of the Npc.
	 */
	public int npcType;

	/*
	 * The X and Y coordinates of the Npc.
	 */
	public int absX, absY;

	/*
	 * The height level of the Npc.
	 */
	public int heightLevel;

	/*
	 * The Npc's spawning point.
	 */
	public int makeX, makeY;

	/*
	 * The area in which the Npc is allowed to move within.
	 */
	public int moverangeX1, moverangeY1, moverangeX2, moverangeY2;

	/*
	 * The X and/or Y coordinates of the point the Npc is moving to.
	 */
	public int moveX, moveY;

	/*
	 * The direction in which the npc is moving in.
	 */
	public int direction;

	/*
	 * The Npc's type of walking. E.G. 2 if the Npc moves.
	 */
	public int walkingType;

	/*
	 * The boolean which decides if the NPC needs to return to it's spawn
	 */
	public boolean walkingHome = false;

	/*
	 * The index of the player that the Npc is following.
	 */
	public int followPlayer;

	/*
	 * The X and Y coordinates of the Npc's spawning point.
	 */
	public int spawnX, spawnY;

	/*
	 * The current and max hitpoints of the Npc.
	 */
	public int HP, MaxHP;

	/*
	 * The timer which is applied to the Npc when it dies.
	 */
	public int deathTimer;

	/*
	 * The index of the player the Npc is going to attack.
	 */
	public int StartKilling;
	
	/*
	 * The X and Y coordinates of the Npc's enemy index.
	 */
	public int enemyX, enemyY;

	/*
	 * The index of the object that the Npc is facing.
	 */
	public int face;

	/*
	 * The variables for the hitUpdate masks. These are what the Npc's HP is depleted by.
	 */
	public int hitDiff, hitDiff2;

	/*
	 * The animation ID that the Npc is applied to do.
	 */
	public int animNumber;

	/*
	 * The ID and height of the Npc's graphic.
	 */
	public int gfxID, gfxHeight;

	/*
	 * The focus points that the Npc is forced to face towards.
	 */
	public int FocusPointX = -1, FocusPointY = -1;

	/*
	 * The index of the player that the Npc is spawned for.
	 */
	public int spawnedBy = -1;

	/*
	 * The delay between each attack for the Npc.
	 */
	public int combatDelay;

	/*
	 * The index of the opponent player.
	 */
	public int AttackingOn;

	/*
	 * The time that the Npc is frozen for.
	 */
	public int freezeDelay;

	/*
	 * The delays between attacking and hitting.
	 */
	public int damageDelay = -1, rangeDamageDelay = -1, mageDamageDelay = -1;

	/*
	 * An array to store the IDs of the Npc that use either magic or ranged style attacks.
	 */
    	public int[] rangeNPC = {
		2745, 2028, 2631, 2744, 2743, 2025, 1913, 2779, 50, 53, 54, 55, 3012, 3011,
		3006, 3007, 3008, 1183
	};

	/*
	 * The next direction the NPC will walk towards.
	 */
	public int getNextWalkingDirection() {
		int dir;
		dir = Misc.direction(absX, absY, (absX + moveX), (absY + moveY));

		if (dir == -1 || !WalkingHandler.getSingleton().traversable(absX + moveX, absY + moveY, dir)) {//added WalkingHandler
			return -1;
		}
		dir >>= 1;
		absX += moveX;
		absY += moveY;
		return dir;
	}

	public int GetMove(int Place1,int Place2) {
		if ((Place1 - Place2) == 0) {
			return 0;
		} else if ((Place1 - Place2) < 0) {
			return 1;
		} else if ((Place1 - Place2) > 0) {
			return -1;
		}
		return 0;
	}

	/*
	 * The delay in between each update of the NPC.
	 */
	public long updateDelay;

	/*
	 * The text that the Npc is forced to shout.
	 */
	public String textUpdate;

	/*
	 * Update Mask variables.
	 */
	public boolean graphicsUpdate;
	public boolean updateRequired;
	public boolean dirUpdateRequired;
	public boolean hitUpdateRequired;
	public boolean hitUpdateRequired2;
	public boolean faceUpdateRequired;
	public boolean animUpdateRequired;
	public boolean textUpdateRequired;
	public boolean FocusUpdateRequired;

	/*
	 * If the Npc is dead or not, and if the Npc is still dying.
	 */
	public boolean IsDead, DeadApply;

	/*
	 * If the Npc needs to be respawned.
	 */
	public boolean NeedRespawn;

	/*
	 * If the npc is under attack.
	 */
	public boolean IsUnderAttack;

	/*
	 * If the Npc is meant to respawn.
	 */
	public boolean Respawns;

	/*
	 * If the Npc is poisoned.
	 */
	public boolean poisondmg;

	/*
	 * If the Npc is following a player.
	 */
	public boolean followingPlayer;

	/*
	 * If the Npc is allowed to walk randomly.
	 */
	public boolean RandomWalk;

	/*
	 * If the ID of the Npc is stored in the 'rangeNPC' array.
	 */
	public boolean usingRM() {
		for (int i = 0; i < rangeNPC.length; i++) {
			if (npcType == rangeNPC[i]) {
				return true;
			}
		}
		return false;
	}

	public boolean GoodDistance(int objectX, int objectY, int playerX, int playerY, int distance) {
		for (int i = 0; i <= distance; i++) {
		  for (int j = 0; j <= distance; j++) {
			if ((objectX + i) == playerX && ((objectY + j) == playerY || (objectY - j) == playerY || objectY == playerY)) {
				return true;
			} else if ((objectX - i) == playerX && ((objectY + j) == playerY || (objectY - j) == playerY || objectY == playerY)) {
				return true;
			} else if (objectX == playerX && ((objectY + j) == playerY || (objectY - j) == playerY || objectY == playerY)) {
				return true;
			}
		  }
		}
		return false;
	}

	public void process() {

		if (combatDelay > 0) {
			combatDelay--;
		}
		if (freezeDelay > 0) {
			freezeDelay--;
		}
		if (damageDelay > 0) {
			damageDelay--;
		}
		if (rangeDamageDelay > 0) {
			rangeDamageDelay--;
		}
		if (rangeDamageDelay == 0) {
			NpcCombat.appendRangeDamage(this);
		}
		if (mageDamageDelay > 0) {
			mageDamageDelay--;
		}
		if (mageDamageDelay == 0) {
			NpcCombat.appendMageDamage(this);
		}
		if (damageDelay == 0) {
			NpcCombat.appendMeleeDamage(this);
		}
		if (IsUnderAttack && !RandomWalk) {
			if (GameEngine.playerHandler.players[AttackingOn] != null) {
				if (!GameEngine.playerHandler.players[AttackingOn].IsDead) {
					NpcCombat.Attack(this);
				}
			}
		}
	}

	/*
	 * Sets the damage delay for melee attacks.
	 */
	public void setDamageDelay(int delay) {
		damageDelay = delay;
	}

	/*
	 * Sets the damage delay for ranged attacks.
	 */
	public void setRangeDelay(int delay) {
		rangeDamageDelay = delay;
	}

	/*
	 * Sets the damage delay for magic attacks.
	 */
	public void setMageDelay(int delay) {
		mageDamageDelay = delay;
	}

	public void appendAnim(int anim) {
		animNumber = anim;
		animUpdateRequired = true;
		updateRequired = true;
	}

	public void ResetAttack() {
			IsUnderAttack = false;
			RandomWalk = true;
			animUpdateRequired = true;
			updateRequired = true;
	}

	public void TurnNPCTo(int pointX, int pointY) {
		FocusUpdateRequired = true;
		FocusPointX = 2 * pointX + 1;
		FocusPointY = 2 * pointY + 1;
	}

	public void requestText(String s) {
		updateRequired = true;
		textUpdateRequired = true;
		textUpdate = s;
	}

	public void faceplayer(int i) {
		face = i + 32768;
		faceUpdateRequired = true;

		if (System.currentTimeMillis() - updateDelay >= 5000) {
			updateRequired = true;
			updateDelay = System.currentTimeMillis();
		}
	}
    	private void appendSetFocusDestination(Stream str) {
        	str.writeWordBigEndian(FocusPointX);
        	str.writeWordBigEndian(FocusPointY);
    	}

	public void appendHit(int hit) {
		if (hitUpdateRequired) {
			hitDiff2 = hit;
			hitUpdateRequired2 = true;
			updateRequired = true;
		} else {
			hitDiff = hit;
			hitUpdateRequired = true;
			updateRequired = true;
		}
	}
	
	public void updateNPCMovement(Stream str) {
		if (direction == -1) {
			if (updateRequired) {
				str.writeBits(1, 1);
				str.writeBits(2, 0);
			} else {
				str.writeBits(1, 0);
			}
		} else {
			str.writeBits(1, 1);
			str.writeBits(2, 1);	
			str.writeBits(3, Misc.xlateDirectionToClient[direction]);
			if (updateRequired) {
				str.writeBits(1, 1);
			} else {
				str.writeBits(1, 0);
			}
		}
	}

	public void appendNPCUpdateBlock(Stream str) {
		boolean faceUp = false;

		if (!updateRequired) {
			return;
		}
		int updateMask = 0;

		if (textUpdateRequired) {
			updateMask |= 1;
		}
		if (animUpdateRequired) {
			updateMask |= 0x10;
		}
		if (graphicsUpdate) {
			updateMask |= 0x80;
		}
		if (hitUpdateRequired2) {
			updateMask |= 0x8;
		}
		if (hitUpdateRequired) {
			updateMask |= 0x40;
		}
		if (dirUpdateRequired) {
			updateMask |= 0x20;
		}
        	if (FocusUpdateRequired) {
            		updateMask |= 0x4;
        	}
		if (faceUpdateRequired && updateMask == 0) {
			updateMask |= 0x20;
			faceUp = true;
		}
		if(turnUpdateRequired) updateMask |= 4;	

		str.writeByte(updateMask);

		if (textUpdateRequired) {
			str.writeString(textUpdate);
		}
		if (animUpdateRequired) {
			appendAnimUpdate(str);
		}
		if (graphicsUpdate) {
			appendGraphicsUpdate(str);
		}
		if (hitUpdateRequired2) {
			appendHitUpdate2(str);
		}
		if (hitUpdateRequired) {
			appendHitUpdate(str);
		}
		if (dirUpdateRequired) {
			appendDirUpdate(str);
		}
        	if (FocusUpdateRequired) {
            		appendSetFocusDestination(str);
        	}
		if (faceUpdateRequired && faceUp) {
			updateface(str);
		}
		if(turnUpdateRequired) appendSetFocusDestination(str);	
	}

	public void appendGraphicsUpdate(Stream str) {
		str.writeWord(gfxID);
		str.writeDWord(gfxHeight);
	}
	
	public void gfx100(int gfx){
		gfxID = gfx;
        	gfxHeight = 6553600;
        	graphicsUpdate = true;
		updateRequired = true;
	}
	
	public void gfx0(int gfx){
		gfxID = gfx;
        	gfxHeight = 65536;
        	graphicsUpdate = true;
		updateRequired = true;
	}

	public void updateface(Stream Stream1) {
		Stream1.writeWord(face);
	}

	public void clearUpdateFlags() {
		focusPointX = -1; 
		focusPointY = -1; 
		turnUpdateRequired = false;
		updateRequired = false;
		graphicsUpdate = false;
		textUpdateRequired = false;
		hitUpdateRequired2 = false;
		hitUpdateRequired = false;
		animUpdateRequired = false;
		dirUpdateRequired = false;
		textUpdate = null;
		moveX = 0;
		moveY = 0;
		direction = -1;
	}

	public void moveBackToSpawn() {
			RandomWalk = false;
			moveX = GetMove(absX, spawnX);
			moveY = GetMove(absY, spawnY);
			getNextNPCMovement();
			updateRequired = true;
			RandomWalk = true;
	}

	private void playerPos() {
		for (Player p : GameEngine.playerHandler.players) {
			if (p != null) {
				clientHandler client1 = (clientHandler)p;

					if (absX + moveX == client1.absX) {
						if (absY + moveY == client1.absY) {
							moveX = 0;
							moveY = 0;
						}
					}
			}
		}
	}

	public void getNextNPCMovement() {
		playerPos();
		if ((moveX != 0 || moveY != 0) && freezeDelay <= 0) {
			direction = getNextWalkingDirection();
		}
	}

	protected void appendHitUpdate(Stream str) {		
		try {
			if ((HP - hitDiff) < 0) {
				hitDiff = HP;
			}
			if (HP <= 0) {
				hitDiff = 0;
			}
			HP -= hitDiff;

			if (HP <= 0) {
				IsDead = true;
			}
			if (HP < 0) {
				HP = 0;
			}
			str.writeByteC(hitDiff); // What the perseon got 'hit' for

			if (hitDiff > 0 && !poisondmg) {
				str.writeByteS(1); // 0: red hitting - 1: blue hitting
			} else if (hitDiff > 0 && poisondmg) {
				str.writeByteS(2); // 0: red hitting - 1: blue hitting
			} else {
				str.writeByteS(0); // 0: red hitting - 1: blue hitting
			}
			str.writeByteS(Misc.getInt(HP, MaxHP, 100)); // Their current hp, for HP bar
			str.writeByteC(100); // Their max hp, for HP bar
                        poisondmg = false;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	protected void appendHitUpdate2(Stream str) {		
		try {
			if ((HP - hitDiff2) < 0) {
				hitDiff2 = HP;
			}
			if (HP <= 0) {
				hitDiff2 = 0;
			}
			HP -= hitDiff2;

			if (HP <= 0) {
				IsDead = true;
			}
			if (HP < 0) {
				HP = 0;
			}
			str.writeByteA(hitDiff2); // What the perseon got 'hit' for

			if (hitDiff2 > 0 && !poisondmg) {
				str.writeByteC(1); // 0: red hitting - 1: blue hitting
			} else if (hitDiff2 > 0 && poisondmg) {
				str.writeByteC(2); // 0: red hitting - 1: blue hitting
			} else {
				str.writeByteC(0); // 0: red hitting - 1: blue hitting
			}
			str.writeByteA(HP); // Their current hp, for HP bar
			str.writeByte(MaxHP); // Their max hp, for HP bar
                        poisondmg = false;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void appendAnimUpdate(Stream str) {
		str.writeWordBigEndian(animNumber);
		str.writeByte(1);
	}

	public void appendDirUpdate(Stream str){
		str.writeWord(direction);
	}

public void FollowPlayerCB(int NPCID, int playerID) {
		int playerX = GameEngine.playerHandler.players[playerID].absX;
		int playerY = GameEngine.playerHandler.players[playerID].absY;
		RandomWalk = false;
		boolean canwalk = true;
		if (GameEngine.playerHandler.players[playerID] != null) {
			if (playerY < absY) {
				moveX = GetMove(absX, playerX);
				moveY = GetMove(absY, playerY + 1);
				//if(WorldMap.isWalkAble(heightLevel, absX, absY, absX, absY+moveY) == false)
				//canwalk = false;
			} else if (playerY > absY) {
				moveX = GetMove(absX, playerX);
				moveY = GetMove(absY, playerY - 1);
				//if(WorldMap.isWalkAble(heightLevel, absX, absY, absX, absY-moveY) == false)
				//canwalk = false;
			} else if (playerX < absX) {
				moveX = GetMove(absX, playerX + 1);
				moveY = GetMove(absY, playerY);
				//if(WorldMap.isWalkAble(heightLevel, absX, absY, absX+moveX, absY) == false)
				//canwalk = false;
			} else if (playerX > absX) {
				moveX = GetMove(absX, playerX - 1);
				moveY = GetMove(absY, playerY);
				//if(WorldMap.isWalkAble(heightLevel, absX, absY, absX-moveX, absY) == false)
				//canwalk = false;
			}
			if(canwalk == true)
			getNextNPCMovement();
			updateRequired = true;
		}
	}


		public void checkBoundaries() {
			if((npcType == 116 && (absX >= 2837 && absX <= 2846 && absY >= 3535 && absY <= 3542))
			|| (npcType == 3000 && !(absX >= 2470 && absX <= 2487 && absY >= 3916 && absY <= 3922))
			|| (npcType == 3000 && !(absX >= 2449 && absX <= 2455 && absY >= 3919 && absY <= 3933))
			|| (npcType == 3455 && !(absX >= 2455 && absX <= 2468 && absY >= 3950 && absY <= 3957))) {
				absX = makeX;
				absY = makeY;
				ResetAttack();
			}
		}
	public int getSize() {
		switch (npcType) {

			case 2743:
			case 2744:
			case 2745:
				return 2;
			case 116:
				return 1;
		    default:
			return 0;
		}
	}

	public int getCombatDelay() {
		switch (npcType) {
			
			case 2745:
				return 10;
			/**/

			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
				return 6;

			case 2028:
				return 6;
			case 1913:
				return 6;
			
			default:
				return 8;
		}
	}

	public int getDamageDelay() {
		switch (npcType) {
			
			/**/
			
			default:
				return 3;
		}
	}

	public int GetDeathTimer() {
		switch (npcType) {

			case 1677:
				return 3;
			case 1678:
				return 3;
			case 941:
			case 53:
			case 54:
			case 55:
				return 7;
			case 2274:
			case 2275:
			case 2276:
			case 2277:
			case 2278:
			case 2279:
			case 2280:
				return 6;

		    default:
			return 6;
		}
	}
	public int GetNpcMaxHit() {
		switch (npcType) {

			case 430:
				return 900;
			case 3808:
				return 13+Misc.random(4);
			case 3006: case 3007: case 3008:
				return ((14) + Misc.random(5));
			case 3010: case 3011:
				return ((15) + Misc.random(7));
			case 3012: case 3013: case 3014:
				return ((14) + Misc.random(9));
			case 3061:
				return 13;
			case 3060:
				return 10;
			case 1007:
				return 12;
			case 2779:
				return 24;
			case 9:
				return 4;
			case 32:
				return 5;
			case 941:
				return 12;
			case 1644:
				return 13;
			case 1183:
				return 18;
			case 52:
				return 12;
			case 53:
				return 17;
			case 3070:
				return 14;
			case 54:
				return 20;
			case 1158:
				return 31;
			case 55:
				return 14;
			case 2274:
				return 2;
			case 2275:
				return 3;
			case 2276:
				return 4;
			case 2277:
				return 6;
			case 2278:
				return 10;
			case 2279:
				return 14;
			case 2280:
				return 16;
			case 2025:
				return 20;
			case 3200:
				return 28;
			case 3406:
				return 3;
			case 1329:
				return 4;
			case 1549:
				return 5;
			case 112:
				return 6;
			case 3027:
				return 7;
			case 110:
				return 11;
			case 126:
				return 7;
			case 2026:
				return (Misc.random(30) + ((MaxHP - HP) / 2));
			case 2027:
				return 24;
			case 2028:
				return 20;
			case 2029:
				return 23;
			case 50:
				return 45;
			case 2031:
				return ((10) + Misc.random(9));
			case 2036:
				return((15) + Misc.random(19));
			case 2030:
				return 23;
			case 2745://jad
				return ((60) + Misc.random(27));
			case 1975://k'ril
				return ((20) + Misc.random(27));
			case 2629:
				return 6;
			case 2631:
				return 15;
			case 2742:
				return 29;
			case 3000:
				return 50;
			case 1976:
			case 1978:
			case 1979:
				return 14;
			case 3002:
				return 40;
			case 3455:
				return 65;
			case 2743:
			case 2744:
				return 55;
			case 1913:
				return 22;
			case 3005:
				return 32;
			case 1592:
				return 25;
			case 1618:
				return 19;
			case 2881:
			case 2882:
			case 2883:
				return ((20) + Misc.random(20));
			case 1610:
				return 20;
			case 1615:
				return ((20) + Misc.random(10));
			case 83:
				return ((10) + Misc.random(10));
			case 3340:
				return 21;
			case 49:
				return ((15) + Misc.random(10));
		    default:
			return 1;
		}
	}
	public int GetNpcAttack() {
		switch (npcType) {

			case 3006: case 3007: case 3008:
			case 3010: case 3011: case 3012:
			case 3013: case 3014: case 3808:
				return 175;
			case 430:
				return 9000;
			case 3061:
				return 240;
			case 3060:
			case 1007:
				return 150;
			case 2779:
			case 3005:
			case 3340:
				return 250;
			case 3002:
			case 1975:
			case 3000:
				return 350;
			case 1976:
			case 1978:
			case 1979:
				return 230;
			case 3455:
				return 400;
			case 3200:
				return 450;
			case 1158:
				return 500;
			case 3406:
				return 60;
			case 3070:
			case 1549:
			case 112:
			case 110:
			case 9:
				return 120;
			case 1183:
			case 50:
			case 32:
				return 200;
			case 1329:
			case 3027:
				return 150;
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
				return 2;
			case 1677:
			case 1678:
			case 126:
			case 2274:
				return 100;
			case 941:
				return 200;
			case 52:
				return 150;
			case 53:
				return 300;
			case 54:
			case 1592:
			case 1618:
				return 350;
			case 55:
				return 250;
			case 2275:
				return 130;
			case 2276:
				return 180;
			case 2277:
				return 230;
			case 2278:
				return 260;
			case 2279:
				return 310;
			case 2280:
				return 390;
			case 2031:
			case 2036:
				return 200;
			case 2025:
				return 450;
			case 2026:
				return 450;
			case 2027:
				return 400;
			case 2028:
				return 300;
			case 2029:
				return 350;
			case 2030:
				return 400;
			case 2745:
				return 600;
			case 2627:
				return 200;
			case 1644:
				return 100;
			case 2629:
				return 300;
			case 2631:
				return 300;
			case 2742:
				return 300;
			case 2743:
			case 2744:
				return 450;
			case 1913:
				return 450;
			case 2881:
			case 2882:
			case 2883:
				return 350;
			case 1610:
			case 1615:
				return 300;
			case 83:
				return 250;
			case 49:
				return 250;
		    default:
			return 1;
		}
	}
}
