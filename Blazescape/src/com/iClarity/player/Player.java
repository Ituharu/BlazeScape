package com.iClarity.player;

import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import com.iClarity.misc.*;
import com.iClarity.npcs.*;
import com.iClarity.GameEngine;
import com.iClarity.world.items.*;
import com.iClarity.player.magic.*;
import com.iClarity.world.*;
public abstract class Player {	

	public boolean isSmelting = false;
	public int choiceClick;
	public int fishingTimer = 0;

	public int interfaceStage;
	public int flaxAmount = -1;
	public int flaxTimer = 0;
	public int herbQuest;
	public int specialAmount;
	public int stage;
	public long timer;
	public long cannonDelay;
	public int fletchAmount = -1;
	public int fletchingTimer = 0;
	public int easterStage;
        public int LogoutDelay = 0;

	public int getDis(int coordX1, int coordY1, int coordX2, int coordY2)
	{
		int deltaX = coordX2 - coordX1;
		int deltaY = coordY2 - coordY1;
		return ((int)Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
	}

	public int tombTalk;
	public int starter;
	public int dtQuest;

	public boolean above20Wild() {
		if (absY >= 3672) {
			return true;
		}
		return false;
	}

	public void checkDrain() {
		if (NewDrain > CurrentDrain && DrainDelay > 0) {
			return;
		}
		int j = highestDrainRate();
		double d = (double)playerBonus[11] * 0.40000000000000002D;
		d = Math.round(d + 0.5D);

		if (CurrentDrain != j) {
			CurrentDrain = j;
		}
		if (CurrentDrain < 0) {
			CurrentDrain = 1;
		}
		if (DrainDelay > 0) {
			DrainDelay = NewDrain - (DrainDelay - (int)d);
		} else {
			DrainDelay = CurrentDrain + (int)d;
		}
	}

	public int highestDrainRate() {
		if (smitePrayer) {
			return 8;
		}
		if (meleePrayer) {
			return 10;
		}
		if (rangedPrayer) {
			return 10;
		}
		if (magicPrayer) {
			return 10;
		}
		if (incredibleReflex) {
			return 10;
		}
		if (ultimateStr) {
			return 10;
		}
		if (steelSkin) {
			return 10;
		}
		if (redempPrayer) {
			return 16;
		}
		if (improvedReflex) {
			return 16;
		}
		if (superHumanStr) {
			return 16;
		}
		if (rockSkin) {
			return 16;
		}
		if (retriPrayer) {
			return 30;
		}
		if (clarity) {
			return 30;
		}
		if (burstOfStr) {
			return 30;
		}
		if (thickSkin) {
			return 30;
		}
		return !protItem ? 0 : 40;
	}

	public boolean CheckIfPray() {
		if (!thickSkin && !rockSkin && !steelSkin && !clarity && !improvedReflex && !incredibleReflex && !burstOfStr && !superHumanStr && !ultimateStr && !meleePrayer && !rangedPrayer && !magicPrayer && !retriPrayer && !redempPrayer && !smitePrayer && !protItem) {
			CurrentDrain = 0;
			NewDrain = 0;
			DrainDelay = 0;
			return false;
		} else {
			return true;
		}
	}

	public int NewDrain;
	public int CurrentDrain;
	public int DrainDelay;

	public boolean IsInFightCave() {
		return absX >= 2360 && absX <= 2445 && absY >= 5045 && absY <= 5125;
	}

	public int tzWave;
	public int WaveDelay;
	public int KilledTz;


	public boolean inGodWars() {
		return (absX >= 2434 && absY >= 3905 && absX <= 2494 && absY <= 3966)
		|| (absX <= 3000 && absX <= 2800 && absY >= 5200 && absY <= 5500 && heightLevel == 2);
	}

	public int bandosKills;
	public int saradominKills;
	public int armadylKills;
	public int zamorakKills;

	public void resetGodWars() {
		zamorakKills = 0;
		bandosKills = 0;
		saradominKills = 0;
		armadylKills = 0;
	}

	public boolean inBarrows() {
		return (absX >= 3522 && absX <= 3583 && absY >= 9675 && absY <= 9720) || (absX >= 3546 && absX <= 3583 && absY >= 3269 && absY <= 3308);
	}

	public int dharokSummoned;
	public int ahrimSummoned;
	public int guthanSummoned;
	public int karilSummoned;
	public int toragSummoned;
	public int veracSummoned;
	public int hiddenBarrowBro;
	public int killCount;

	public void resetBarrows() {
		dharokSummoned = 0;
		ahrimSummoned = 0;
		guthanSummoned = 0;
		karilSummoned = 0;
		toragSummoned = 0;
		veracSummoned = 0;
		hiddenBarrowBro = Misc.random(6);
	}


	public boolean dharoksMound() {
		return absX >= 3570 && absX <= 3576 && absY >= 3293 && absY <= 3299;
	}

	public boolean veracsMound() {
		return absX >= 3554 && absX <= 3559 && absY >= 3294 && absY <= 3300;
	}

	public boolean ahrimsMound() {
		return absX >= 3561 && absX <= 3567 && absY >= 3286 && absY <= 3292;
	}

	public boolean toragsMound() {
		return absX >= 3550 && absX <= 3555 && absY >= 3280 && absY <= 3285;
	}

	public boolean karilsMound() {
		return absX >= 3563 && absX <= 3568 && absY >= 3273 && absY <= 3279;
	}

	public boolean guthansMound() {
		return absX >= 3574 && absX <= 3579 && absY >= 3279 && absY <= 3284;
	}

	public int combatWith;

	public boolean duelArea() {
		return absX >= 3318 && absX <= 3381 && absY >= 3201 && absY <= 3288 || duelStatus == 3;
	}
	public boolean isInDuel() {
		return absX >= 3332 && absX <= 3389 && absY >= 3205 && absY <= 3259;
	}
	public boolean duelArena() {
		return absX >= 3318 && absX <= 3381 && absY >= 3201 && absY <= 3288;
	}

	public int dSpotX[] = {
		3356, 3362, 3372, 3377
	};
	public int dSpotY[] = {
		3277, 3275, 3275, 3269
	};

	public int duelSlot = -1;
	public int duelSpaceReq;
	public int duelOption;
	public int duelW;
	public int duelWith;
	public boolean runStream;
	public boolean duelRule[];
	public int duelItems[];
	public int duelItemsN[];
	public int otherDuelItems[];
	public int otherDuelItemsN[];
	public int duelStatus;

	public int skullTimer;
	public int lastHit;
	public boolean HasArrows;
	public boolean ArrowSlot;
	public int slayAmount;
	public int slayerNPC;
	public boolean isFlaxing;
	public boolean isFletching;
	public boolean isFishing;
	public int timeToFish;
	public int amountToFish;
	public boolean isCooking;
	public boolean usingHerblore;
	public int cookAnim;
	public int craftDelay;
	public int craftId;
	public int craftDelAmt;
	public int craftXpInc;
	public boolean isCrafting;
	public boolean dHideCraft;
	public int leatherId;

	public int msbDelay = -1;

	public void TurnPlayerTo(int face) {
		faceNPC = face;
		updateRequired = true;
		faceNPCupdate = false;
	}

	public long potTimer;
	public boolean goOn;

	public int chargeTimer;
	public boolean charge;

	public int restoreTimer = 70;
	public boolean castAuto;

	public void stopMovement() {
		if (teleportToX <= 0 && teleportToY <= 0) {
			teleportToX = absX;
			teleportToY = absY;
		}
		newWalkCmdSteps = 0;
		newWalkCmdX[0] = newWalkCmdY[0] = tmpNWCX[0] = tmpNWCY[0] = 0;
		getNextPlayerMovement();
	}

	public long lastTeleblock;
	public int hitID;
	public boolean isSkulled;
	public long lastSkull;
	public long offTimer;
	public boolean isSpellNPC;
	public int lastCombat = 0;
	public int lastAttack = 0;
	public int fletchTime;

	public boolean castSpell, isStillSpell;
	public boolean SaradominStrike, GuthixClaws, ZamorakFlames;
	public int rune1, rune1Am, rune2, rune2Am, rune3, rune3Am, rune4, rune4Am, spellXP;
	public int spellHit;
	public int spellHitTimer;
	public int spellNpcIndex = -1;
	public int spellPlayerIndex = -1;
	public boolean spellSet = false;

	public int GfxId;
	public int GfxDelay;
	public int GfxHeight;
	public boolean GraphicsUpdateRequired;
	public int soundDump;
	public int itemSlot = -1;
	public int objectTimer;

	public void setCoords(int X, int Y, int Height) {
		teleportToX = X;
		teleportToY = Y;
		heightLevel = Height;
		appearanceUpdateRequired = true;
		updateRequired = true;
	}

	public int leverDelay = -1;
	public int leverX;
	public int leverY;
	public boolean leverTele;
	public int teleDelay = -1;
	public int teleHeight;
	public int teleGFXHeight;
	public int teleGFX;
	public int teleFinishAnim;
	public int teleGFXReq;

	public int walkDelay = -1;
	public int walkFinishAnim;
	public int walkX;
	public int walkY;

	public boolean usingKnives() {
		for (int i = 863; i < 870; i++) {
			if (playerEquipment[3] == i) {
				return true;
			}
		}
		return false;
	}

	public boolean usingRange() {
		for (int i = 0; i < Bows.length; i++) {
			if (playerEquipment[3] == Bows[i]) {
				return true;
			}
		}
		return false;
	}

    	public int[] Bows = {841, 843, 845, 847, 849, 851, 853, 855, 857, 859, 861, 4212, 4214, 4734};

	public boolean multiZone() {
		return absX >= 2583 && absX <= 2604 && absY >= 3142 && absY <= 317
		|| absX >= 3287 && absX <= 3298 && absY >= 3167 && absY <= 3178
		|| absX >= 3070 && absX <= 3095 && absY >= 3405 && absY <= 3448
		|| absX >= 2961 && absX <= 2981 && absY >= 3330 && absY <= 3354
		|| absX >= 2510 && absX <= 2537 && absY >= 4632 && absY <= 4660
		|| absX >= 3012 && absX <= 3066 && absY >= 4805 && absY <= 4858
		|| absX >= 2794 && absX <= 2813 && absY >= 9281 && absY <= 9305
		|| absX >= 3546 && absX <= 3557 && absY >= 9689 && absY <= 9700
		|| absX >= 2708 && absX <= 2729 && absY >= 9801 && absY <= 9829
		|| absX >= 3450 && absX <= 3525 && absY >= 9470 && absY <= 9535
		|| absX >= 3207 && absX <= 3395 && absY >= 3904 && absY <= 3903
		|| absX >= 3006 && absX <= 3072 && absY >= 3611 && absY <= 3712
		|| absX >= 3149 && absX <= 3395 && absY >= 3520 && absY <= 4000
		|| absX >= 2365 && absX <= 2420 && absY >= 5065 && absY <= 5120
		|| absX >= 2890 && absX <= 2935 && absY >= 4425 && absY <= 4470
		|| absX >= 2250 && absX <= 2290 && absY >= 4675 && absY <= 4715
		|| absX >= 3035 && absX <= 3040 && absY >= 2954 && absY <= 2959
		|| absX >= 2583 && absX <= 2604 && absY >= 3142 && absY <= 3172
		|| absX >= 2690 && absX <= 2825 && absY >= 2680 && absY <= 2810;
	}

	public int freezeDelay;
	//public int followId;
	public int followId = 0;
	public int followId2 = 0;
	public int drainDelay;
	public boolean usingPrayer;
	public boolean magicPrayer;
	public boolean rangedPrayer;
	public boolean meleePrayer;
	public boolean retriPrayer;
	public boolean redempPrayer;
	public boolean smitePrayer;
	public boolean thickSkin;
	public boolean rockSkin;
	public boolean steelSkin;
	public boolean clarity;
	public boolean improvedReflex;
	public boolean incredibleReflex;
	public boolean burstOfStr;
	public boolean superHumanStr;
	public boolean ultimateStr;
	public boolean protItem;


	public boolean abyssalRift() {
		return absX >= 3028 && absX <= 3054 && absY >= 4818 && absY <= 4843;//abyssal
	}
	public boolean castleWars() {
		return absX >= 2359 && absX <= 2432 && absY >= 3069 && absY <= 3134;
	}
	public boolean Wild() {
		return absX >= 2583 && absX <= 2604 && absY >= 3142 && absY <= 3172
		|| absX >= 3035 && absX <= 3040 && absY >= 2954 && absY <= 2959 || absX >= 3028 && absX <= 3054 && absY >= 4818 && absY <= 4843;
	}

	public boolean fullDharokEquipped() {
		return playerEquipment[playerHat] == 4716 && playerEquipment[playerChest] == 4720 && playerEquipment[playerLegs] == 4722 && playerEquipment[playerWeapon] == 4718;
	}
	public boolean FullGuthanEquipped() {
		return playerEquipment[playerHat] == 4724 && playerEquipment[playerChest] == 4728 && playerEquipment[playerLegs] == 4730 && playerEquipment[playerWeapon] == 4726;
	}
	public boolean FullVeracEquipped() {
		return playerEquipment[playerHat] == 4753 && playerEquipment[playerChest] == 4757 && playerEquipment[playerLegs] == 4759 && playerEquipment[playerWeapon] == 4755;
	}
	public boolean fullRaVoidEquipped() {
		return playerEquipment[playerHat] == 8023 && playerEquipment[playerChest] == 8019 && playerEquipment[playerLegs] == 8020 && playerEquipment[playerHands] == 8021;
	}
	public boolean fullMeVoidEquipped() {
		return playerEquipment[playerHat] == 8024 && playerEquipment[playerChest] == 8019 && playerEquipment[playerLegs] == 8020 && playerEquipment[playerHands] == 8021;
	}
	public boolean fullMaVoidEquipped() {
		return playerEquipment[playerHat] == 8022 && playerEquipment[playerChest] == 8019 && playerEquipment[playerLegs] == 8020 && playerEquipment[playerHands] == 8021;
	}
	
	public Player followPlayer = null;
	public boolean followPlayerIdle;



	public boolean withinDistance(int distance, Player otherPlr) {
		if(otherPlr == null) return false;
		if(heightLevel != otherPlr.heightLevel) return false;
		int deltaX = otherPlr.absX-absX, deltaY = otherPlr.absY-absY;
		return deltaX <= distance && deltaX >= ((distance + 0) * -1) && deltaY <= distance && deltaY >= ((distance + 0) * -1);
	}

	public boolean WithinDistance(int j, int k, int l, int i1, int j1) {
		for (int k1 = 0; k1 <= j1; k1++) {
			for (int l1 = 0; l1 <= j1; l1++) {
				if (j + k1 == l && (k + l1 == i1 || k - l1 == i1 || k == i1)) {
					return true;
				}
				if (j - k1 == l && (k + l1 == i1 || k - l1 == i1 || k == i1)) {
					return true;
				}
				if (j == l && (k + l1 == i1 || k - l1 == i1 || k == i1)) {
					return true;
				}
			}

        	}
        	return false;
	}

	public int getNextFollowingDirection(Player player) {	// Phates: My awsome follow
		int dir = -1;
		boolean goNorth = false, goSouth = false, goEast = false, goWestWhereTheCowboysRoam = false;
		
		if(absX < player.absX)
			goEast = true;
		else if(absX > player.absX)
			goWestWhereTheCowboysRoam = true;
		if(absY < player.absY)
			goNorth = true;
		else if(absY > player.absY)
			goSouth = true;

		if(!goSouth && !goNorth && !goEast && !goWestWhereTheCowboysRoam)	// Phate: if on the player
			return -1;

		if (!usingRange() && !castAuto && !usingKnives() && freezeDelay <= 0) {
			if (withinDistance(1, player)) {
				return -1;
			}
		} else {
			if (usingRange()) {
				if (withinDistance(6, player)) {
					return -1;
				}
			}
			if (castAuto) {
				if (withinDistance(7, player)) {
					return -1;
				}
			}
			if (usingKnives()) {
				if (withinDistance(3, player)) {
					return -1;
				}
			}
		}

		if(goNorth && goEast)
			dir = 2;
		else if(goNorth && goWestWhereTheCowboysRoam)
			dir = 14;
		else if(goSouth && goEast)
			dir = 6;
		else if(goSouth && goWestWhereTheCowboysRoam)
			dir = 10;
		else if(goNorth)
			dir = 0;
		else if(goEast)
			dir = 4;
		else if(goWestWhereTheCowboysRoam)
			dir = 12;
		else if(goSouth)
			dir = 8;

		dir >>= 1;

		if (WorldMap.isWalkAble(heightLevel, absX, absY, currentX + Misc.directionDeltaX[dir], currentY + Misc.directionDeltaY[dir])) {
			return -1;
		}
		currentX += Misc.directionDeltaX[dir];
		currentY += Misc.directionDeltaY[dir];
		absX += Misc.directionDeltaX[dir];
		absY += Misc.directionDeltaY[dir];
		return dir;
	}

	public void gfx100(int gfx) {
		mask100var1 = gfx;
		mask100var2 = 6553600;
		mask100update = true;
		updateRequired = true;
	}

	public void playerGfx(int gfx, int delay) {
		mask100var1 = gfx;
		mask100var2 = delay;
		mask100update = true;
		updateRequired = true;
	}

    	public String forceChat = "";
   	public boolean forceChatUpdateReq = false;
    	public void requestForceChat(String s) {
       		forceChat = s;
        	forceChatUpdateReq = true;
        	updateRequired = true;
   	 }

	public void gfx0(int gfx) {
		mask100var1 = gfx;
		mask100var2 = 0;
		mask100update = true;
		updateRequired = true;
	}

	public void println_debug(String str) {
		System.out.println("[player-"+playerId+"]: "+str);
	}
	public void println(String str) {
		System.out.println("[player-"+playerId+"]: "+str);
	}

	public boolean newhptype = false;
	public int hptype = 0;
	public boolean poisondmg = false;
	public int combat = 0;

	public Player(int _playerId) {
		duelWith = 0;
		runStream = true;
		duelRule = new boolean[22];
		duelItems = new int[28];
		duelItemsN = new int[28];
		otherDuelItems = new int[28];
		otherDuelItemsN = new int[28];
		duelStatus = -1;

		tzWave = -1;
		WaveDelay = 40;
 		KilledTz = 0;

		dharokSummoned = 0;
		ahrimSummoned = 0;
		guthanSummoned = 0;
		karilSummoned = 0;
		toragSummoned = 0;
		veracSummoned = 0;
		hiddenBarrowBro = Misc.random(5);
		dtQuest = 0;
		playerId = _playerId;
		playerRights = 0; //player rights
		for (int i = 0; i < playerItems.length; i++) { //Setting player items
			playerItems[i] = 0;
		}
		for (int i = 0; i<playerItemsN.length; i++) { //Setting Item amounts
			playerItemsN[i] = 0;
		}

		for (int i=0; i<playerLevel.length; i++) { //Setting Levels
			if (i == 3) {
				playerLevel[i] = 10;
				playerXP[i] = 1155;
			} else {
				playerLevel[i] = 1;
				playerXP[i] = 0;
			}
		}

		for (int i = 0; i< playerBankSize; i++) { //Setting bank items
			bankItems[i] = 0;
		}

		for (int i = 0; i < playerBankSize; i++) { //Setting bank item amounts
			bankItemsN[i] = 0;
		}

		for (int i = 0; i < playerEquipment.length; i++) {
			playerEquipment[i] = -1;
			playerEquipmentN[i] = 0;
		}
                 
		Calendar cal = new GregorianCalendar();
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		int calc = ((year * 10000) + (month * 100) + day);
		playerLastLogin = calc;
		playerLastConnect = "";
		playerIsMember = 0;
		playerMessages = 0;

		playerLook[0] = 0;
		playerLook[1] = 0;
		playerLook[2] = 0;
		playerLook[3] = 0;
		playerLook[4] = 0;
		playerLook[5] = 0;

		playerEquipment[playerHat] = -1;
		playerEquipment[playerCape] = -1;
		playerEquipment[playerAmulet] = -1;
		playerEquipment[playerChest] = -1;
		playerEquipment[playerShield] = -1;
		playerEquipment[playerLegs] = -1;
		playerEquipment[playerHands] = -1;
		playerEquipment[playerFeet ]= -1;
		playerEquipment[playerRing] = -1;
		playerEquipment[playerArrows] = -1;
		playerEquipment[playerWeapon] = -1;

        	pHead = 0;
        	pTorso = 18;
        	pArms = 26;
        	pHands = 33;
        	pLegs = 36;
        	pFeet = 42;
        	pBeard = 10;

		heightLevel = 0;
		teleportToX = 2441;
		teleportToY = 3091;
		absX = absY = -1;
		mapRegionX = mapRegionY = -1;
		currentX = currentY = 0;

if(absX == -1 && absY == -1) {
	heightLevel = 0;
	teleportToX = 2441;
	teleportToY = 3091;
}
if(absX == 0 && absY == 0) {
	heightLevel = 0;
	teleportToX = 2441;
	teleportToY = 3091;
}
		resetWalkingQueue();
	}

	void destruct() {
		playerListSize = 0;
		for(int i = 0; i < maxPlayerListSize; i++) playerList[i] = null;
		npcListSize = 0;
		for(int i = 0; i < maxNPCListSize; i++) npcList[i] = null;

		absX = absY = -1;
		mapRegionX = mapRegionY = -1;
		currentX = currentY = 0;
		resetWalkingQueue();
	}

        public int FocusPointX = -1, FocusPointY = -1;

        private void appendSetFocusDestination(Stream str) {
        	str.writeWordBigEndianA(FocusPointX);
        	str.writeWordBigEndian(FocusPointY);
    	}	
	public void TurnPlayerTo(int pointX, int pointY) {
        	FocusPointX = 2*pointX+1;
        	FocusPointY = 2*pointY+1;
    	}

	public void appendGraphicsUpdate(Stream str) {
		if (str != null) {
			str.writeWordBigEndian(GfxId);
			str.writeDWord(GfxDelay);
			str.writeDWord(GfxHeight);
		}
	}

	public int pkilledinpit;
	public boolean inwildy = false;
	public boolean inwildy2 = false;
	public int weedTimer = 0;
	public int weedAmount = 0;
	public int oak1Timer = 0;
	public int oak1Amount = 0;
	public int oak2Timer = 0;
	public int oak2Amount = 0;
	public int oak3Timer = 0;
	public int oak3Amount = 0;
	public int oak4Timer = 0;
	public int oak4Amount = 0;
	public int oak5Timer = 0;
	public int oak5Amount = 0;
	public int oakHarvestTimer = 0;
	public int oakHarvestAmount = 0;
	public int emoteTimer = 0;
	public int emoteAmount = 0;
	public int emote2Timer = 0;
	public int emote2Amount = 0;
	public int emote3Timer = 0;
	public int emote3Amount = 0;
	public int emote4Timer = 0;
	public int emote4Amount = 0;
	public static int brocount;
	public boolean isNpc;
	public int npcId;
	public boolean initialized = false, disconnected = false, savefile = true;
	public boolean isActive = false;
	public boolean isKicked = false;
	public boolean CrackerMsg = false;
	public boolean CrackerForMe = false;
        public boolean IsGhost = false;

	public int actionTimer = 0;
	public int actionAmount = 0;
	public String actionName = "";

        public int theifTimer = 0;
        public int TakeMiscTimer = 0;

	public String connectedFrom = "";
	public String globalMessage = "";
  
        public int deathcount = 0;
        public int pkpoints = 0;
        public String lastKill = "";

	public int AttackingOn = 0;

        public int OptionObject = -1;

        public boolean Climbing = false;
        public int ClimbStage = -1;

        public int hiddenPoints; // number of places found ;)
        public int foundz[] = new int[100]; // used for secret places being found ;)

        public int[] clueItems = new int[28];
        public int[] clueItemsN = new int[28];

        public int ActionType = -1;
        public int destinationX = -1;
        public int destinationY = -1;
        public int destinationID = -1;
        public int destinationRange = 1;
        public boolean WalkingTo = false;

        public int TreeHP = 20;
        public int TreeX = 0;
        public int TreeY = 0;
        public int TreeTimer = 0;
        public int WCTimer = 0;
        public int logID = 0;
        public int logAmount = 0;
        public int WCxp = 0;
        public int playerAxe = -1;
        public boolean IsWcing = false;
	public int duelChatStage = -1;
	public int duelChatTimer = -1;
	public boolean winDuel = false;
	public boolean startDuel = false;

	public int tradeRequest = 0;
	public int tradeDecline = 0;
	public int tradeWith = 0;
	public int tradeWaitingTime = 0;
	public int tradeStatus = 0;
	public boolean tradeUpdateOther = false;
	public boolean tradeOtherDeclined = false;
	public int[] playerTItems = new int[28]; //player Trade Items
	public int[] playerTItemsN = new int[28];
	public int[] playerOTItems = new int[28]; //player Other Trade Items
	public int[] playerOTItemsN = new int[28];
	public boolean takeAsNote = false;
	
	public abstract void initialize();

	public abstract void update();

	public int playerId = -1;		// -1 denotes world is full, otherwise this is the playerId
									// corresponds to the index in Player players[]

	public String playerName = null;			// name of the connecting client
	public String playerPass = null;			// name of the connecting client
	public boolean isRunning2 = false;
        public boolean stoprunning = false;


	public int playerRights;		// 0=normal player, 1=player mod, 2=real mod, 3=admin?

	public PlayerHandler handler = null;

	public int maxItemAmount = 2147000000;

	public int[] playerItems = new int[28];
	public int[] playerItemsN = new int[28];

	public int playerBankSize = 350;
	public int[] bankItems = new int[800];
	public int[] bankItemsN = new int[800];
	public boolean bankNotes = false;

	public int pHead;
	public int pTorso;
	public int pArms;
	public int pHands;
	public int pLegs;
	public int pFeet;
	public int pBeard;
	public int pEmote = 0x328; // this being the original standing state
	public int pWalk = 0x333; // original walking animation
        public boolean apset = false;

        public int headIcon, headIconHint, headIconPk;

	public int[] playerEquipment = new int[14];
	public int[] playerEquipmentN = new int[14];
	
	public int playerHat = 0;
	public int playerCape = 1;
	public int playerAmulet = 2;
	public int playerWeapon = 3;
	public int playerChest = 4;
	public int playerShield = 5;
	public int playerLegs = 7;
	public int playerHands = 9;
	public int playerFeet = 10;
	public int playerRing = 12;
	public int playerArrows = 13;

	public int playerAttack = 0;
	public int playerDefence = 1;
	public int playerStrength = 2;
	public int playerHitpoints = 3;
	public int playerRanged = 4;
	public int playerPrayer = 5;
	public int playerMagic = 6;
	public int playerCooking = 7;
	public int playerWoodcutting = 8;
	public int playerFletching = 9;
	public int playerFishing = 10;
	public int playerFiremaking = 11;
	public int playerCrafting = 12;
	public int playerSmithing = 13;
	public int playerMining = 14;
	public int playerHerblore = 15;
	public int playerAgility = 16;
	public int playerThieving = 17;
	public int playerSlayer = 18;
	public int playerFarming = 19;
	public int playerRunecrafting = 20;

	public int i = 0;
	public int[] playerLevel = new int[25];
	public int[] playerXP = new int[25];
	public int currentHealth = playerLevel[playerHitpoints];
	public int maxHealth = playerLevel[playerHitpoints];
        public int summonLevel = 1;
        public int summonXP = 0;
        public int summonedNPCS = 0;
	public final static int maxPlayerListSize = PlayerHandler.maxPlayers;
	public Player playerList[] = new Player[maxPlayerListSize];
	public int playerListSize = 0;
	public byte playerInListBitmap[] = new byte[(PlayerHandler.maxPlayers+7) >> 3];
	public final static int maxNPCListSize = NPCHandler.maxNPCs;
	public NPC npcList[] = new NPC[maxNPCListSize];
	public int npcListSize = 0;
	public byte npcInListBitmap[] = new byte[(NPCHandler.maxNPCs+7) >> 3];

    public boolean withinDistance(Player otherPlr)
    {
        if (otherPlr != null)
        {
            if (heightLevel != otherPlr.heightLevel || otherPlr.disconnected || disconnected)
                return false;
            int deltaX = otherPlr.absX-absX, deltaY = otherPlr.absY-absY;
            int deltaX2 = otherPlr.teleportToX-absX, deltaY2 = otherPlr.teleportToY-absY;
            return (deltaX <= 15 && deltaX >= -16 && deltaY <= 15 && deltaY >= -16);
        }
        return false;
    }
/*
	public boolean withinDistance(Player otherPlr) {
		if (heightLevel != otherPlr.heightLevel)
		return false;
		int deltaX = otherPlr.absX - absX, deltaY = otherPlr.absY - absY;
		return (deltaX <= 15) && (deltaX >= -16) && (deltaY <= 15)
		&& (deltaY >= -16);
	}*/

	public boolean withinDistance(NPC npc) {
		if (heightLevel != npc.heightLevel) return false;
		if (npc.NeedRespawn == true) return false;
		int deltaX = npc.absX-absX, deltaY = npc.absY-absY;
		return deltaX <= 15 && deltaX >= -16 && deltaY <= 15 && deltaY >= -16;
	}


	public int mapRegionX, mapRegionY;
	public int absX, absY;	
	public int currentX, currentY;	
	public int heightLevel;
	public boolean updateRequired = true;
	public static final int walkingQueueSize = 50;
	public int walkingQueueX[] = new int[walkingQueueSize], walkingQueueY[] = new int[walkingQueueSize];
	public int wQueueReadPtr = 0;
	public int wQueueWritePtr = 0;
	public boolean isRunning = false;
	public int teleportToX = -1, teleportToY = -1;



	public void resetWalkingQueue() {
		wQueueReadPtr = wQueueWritePtr = 0;

		for(int i = 0; i < walkingQueueSize; i++) {
			walkingQueueX[i] = currentX;
			walkingQueueY[i] = currentY;
		}
	}

	public void addToWalkingQueue(int x, int y) {
		int next = (wQueueWritePtr+1) % walkingQueueSize;
		if(next == wQueueWritePtr) return;		// walking queue full, silently discard the data
		walkingQueueX[wQueueWritePtr] = x;
		walkingQueueY[wQueueWritePtr] = y;
		wQueueWritePtr = next; 
	}

	// returns 0-7 for next walking direction or -1, if we're not moving
	public int getNextWalkingDirection() {
		if(wQueueReadPtr == wQueueWritePtr) return -1;		// walking queue empty
		int dir;
		do {
			dir = Misc.direction(currentX, currentY, walkingQueueX[wQueueReadPtr], walkingQueueY[wQueueReadPtr]);
			if(dir == -1) wQueueReadPtr = (wQueueReadPtr+1) % walkingQueueSize;
			else if((dir&1) != 0) {
				println_debug("Invalid waypoint in walking queue!");
				resetWalkingQueue();
				return -1;
			}
		} while(dir == -1 && wQueueReadPtr != wQueueWritePtr);
		if(dir == -1) return -1;
		dir >>= 1;
		currentX += Misc.directionDeltaX[dir];
		currentY += Misc.directionDeltaY[dir];
		absX += Misc.directionDeltaX[dir];
		absY += Misc.directionDeltaY[dir];
		return dir;
	}

	// calculates directions of player movement, or the new coordinates when teleporting
	public boolean didTeleport = false;		// set to true if char did teleport in this cycle
	public boolean mapRegionDidChange = false;
	public int dir1 = -1, dir2 = -1;		// direction char is going in this cycle
        public int poimiX = 0, poimiY = 0;

	public void getNextPlayerMovement() {
		mapRegionDidChange = false;
		didTeleport = false;
		dir1 = dir2 = -1;

		if(teleportToX != -1 && teleportToY != -1) {
			followPlayer = null;
			mapRegionDidChange = true;
			if(mapRegionX != -1 && mapRegionY != -1) {
				int relX = teleportToX-mapRegionX*8, relY = teleportToY-mapRegionY*8;
				if(relX >= 2*8 && relX < 11*8 && relY >= 2*8 && relY < 11*8)
					mapRegionDidChange = false;
			}

			if(mapRegionDidChange) {
				mapRegionX = (teleportToX>>3)-6;
				mapRegionY = (teleportToY>>3)-6;

				playerListSize = 0;
			}

			currentX = teleportToX - 8*mapRegionX;
			currentY = teleportToY - 8*mapRegionY;
			absX = teleportToX;
			absY = teleportToY;

			resetWalkingQueue();

			teleportToX = teleportToY = -1;
			didTeleport = true;
		} else {
			if(followPlayer != null) {
				if(followPlayerIdle) {
					followPlayerIdle = false;
					return;
				}
				dir1 = getNextFollowingDirection(followPlayer);
				if(dir1 == -1) followPlayerIdle = true;
			} else
				dir1 = getNextWalkingDirection();
			if(dir1 == -1) return;

			if(isRunning && followPlayer != null)
				dir2 = getNextFollowingDirection(followPlayer);
			else if(isRunning)
				dir2 = getNextWalkingDirection();

			int deltaX = 0, deltaY = 0;
			if(currentX < 2*8) {
				deltaX = 4*8;
				mapRegionX -= 4;
				mapRegionDidChange = true;
			} else if(currentX >= 11*8) {
				deltaX = -4*8;
				mapRegionX += 4;
				mapRegionDidChange = true;
			}

			if(currentY < 2*8) {
				deltaY = 4*8;
				mapRegionY -= 4;
				mapRegionDidChange = true;
			} else if(currentY >= 11*8) {
				deltaY = -4*8;
				mapRegionY += 4;
				mapRegionDidChange = true;
			}

			if(mapRegionDidChange) {
				currentX += deltaX;
				currentY += deltaY;
				for(int i = 0; i < walkingQueueSize; i++) {
					walkingQueueX[i] += deltaX;
					walkingQueueY[i] += deltaY;
				}
			}

		}
	}

	public void updateThisPlayerMovement(Stream str) {
		if(mapRegionDidChange) {
			str.createFrame(73);
			str.writeWordA(mapRegionX+6);	// for some reason the client substracts 6 from those values
			str.writeWord(mapRegionY+6);
		}

		if(didTeleport == true) {
			str.createFrameVarSizeWord(81);
			str.initBitAccess();
			str.writeBits(1, 1);
			str.writeBits(2, 3);			// updateType
			str.writeBits(2, heightLevel);
			str.writeBits(1, 1);			// set to true, if discarding (clientside) walking queue
			str.writeBits(1, (updateRequired) ? 1 : 0);
			str.writeBits(7, currentY);
			str.writeBits(7, currentX);
			if (IsDead == true && IsDeadTimer == true && IsDeadTeleporting == true) {
				IsDead = false;
				IsDeadTimer = false;
				IsUsingSkill = false;
			}
			return ;
		}

		if(dir1 == -1) {
			// don't have to update the character position, because we're just standing
			str.createFrameVarSizeWord(81);
			str.initBitAccess();
			if(updateRequired) {
				// tell client there's an update block appended at the end
				str.writeBits(1, 1);
				str.writeBits(2, 0);
			} else {
				str.writeBits(1, 0);
			}
			if (DirectionCount < 50) {
				DirectionCount++;
			}
		} else {
			DirectionCount = 0;
			str.createFrameVarSizeWord(81);
			str.initBitAccess();
			str.writeBits(1, 1);

			if(dir2 == -1) {
				isRunning2 = true;
				// send "walking packet"
				str.writeBits(2, 1);		// updateType
				str.writeBits(3, Misc.xlateDirectionToClient[dir1]);
				if(updateRequired) str.writeBits(1, 1);		// tell client there's an update block appended at the end
				else str.writeBits(1, 0);
			} else {
				// send "running packet"
				str.writeBits(2, 2);		// updateType
				str.writeBits(3, Misc.xlateDirectionToClient[dir1]);
				str.writeBits(3, Misc.xlateDirectionToClient[dir2]);
				if(updateRequired) str.writeBits(1, 1);		// tell client there's an update block appended at the end
				else str.writeBits(1, 0);
				if (playerEnergy > 0) {
					playerEnergy -= 1;
				} else {
					isRunning2 = false;
                                        stoprunning = true;
				}
			} 
		}

	}

	public void updatePlayerMovement(Stream str) {
		if(dir1 == -1) {
			// don't have to update the character position, because the char is just standing
			if(updateRequired || chatTextUpdateRequired) {
				// tell client there's an update block appended at the end
				str.writeBits(1, 1);
				str.writeBits(2, 0);
			}
			else str.writeBits(1, 0);
		} else if(dir2 == -1) {
			// send "walking packet"
			str.writeBits(1, 1);
			str.writeBits(2, 1);
			str.writeBits(3, Misc.xlateDirectionToClient[dir1]);
			str.writeBits(1, (updateRequired || chatTextUpdateRequired) ? 1: 0);
		} else {
			// send "running packet"
			str.writeBits(1, 1);
			str.writeBits(2, 2);
			str.writeBits(3, Misc.xlateDirectionToClient[dir1]);
			str.writeBits(3, Misc.xlateDirectionToClient[dir2]);
			str.writeBits(1, (updateRequired || chatTextUpdateRequired) ? 1: 0);
		}
	}


	public static clientHandler client = null;
	public boolean dropsitem = false;

	public void removeequipped() {
		dropsitem = true;
	}

	public byte cachedPropertiesBitmap[] = new byte[(PlayerHandler.maxPlayers+7) >> 3];

	public void addNewNPC(NPC npc, Stream str, Stream updateBlock)
	{
		int id = npc.npcId;
		npcInListBitmap[id >> 3] |= 1 << (id&7);	// set the flag
		npcList[npcListSize++] = npc;

		str.writeBits(14, id);	// client doesn't seem to like id=0
		
		int z = npc.absY-absY;
		if(z < 0) z += 32;
		str.writeBits(5, z);	// y coordinate relative to thisPlayer
		z = npc.absX-absX;
		if(z < 0) z += 32;
		str.writeBits(5, z);	// x coordinate relative to thisPlayer

		str.writeBits(1, 0); //something??
		str.writeBits(12, npc.npcType);
		
		boolean savedUpdateRequired = npc.updateRequired;
		npc.updateRequired = true;
		npc.appendNPCUpdateBlock(updateBlock);
		npc.updateRequired = savedUpdateRequired;	
		str.writeBits(1, 1); // update required
	}
		
	public void addNewPlayer(Player plr, Stream str, Stream updateBlock) {
		int id = plr.playerId;
		playerInListBitmap[id >> 3] |= 1 << (id&7);	// set the flag
		playerList[playerListSize++] = plr;

		str.writeBits(11, id);	// client doesn't seem to like id=0
		str.writeBits(1, 1);	// set to true, if player definitions follow below
		boolean savedFlag = plr.appearanceUpdateRequired;
		boolean savedUpdateRequired = plr.updateRequired;
		plr.appearanceUpdateRequired = true;
		plr.updateRequired = true;
		plr.appendPlayerUpdateBlock(updateBlock);
		plr.appearanceUpdateRequired = savedFlag;
		plr.updateRequired = savedUpdateRequired;


		str.writeBits(1, 1);	// set to true, if we want to discard the (clientside) walking queue
								// no idea what this might be useful for yet
		int z = plr.absY-absY;
		if(z < 0) z += 32;
		str.writeBits(5, z);	// y coordinate relative to thisPlayer
		z = plr.absX-absX;
		if(z < 0) z += 32;
		str.writeBits(5, z);	// x coordinate relative to thisPlayer
	}

	public boolean appearanceUpdateRequired = true;	// set to true if the player appearance wasn't synchronized
	protected static Stream playerProps;

	static {
		playerProps = new Stream(new byte[100]);
	}

	protected void appendPlayerAppearance(Stream str) {
		playerProps.currentOffset = 0;
		playerProps.writeByte(playerLook[0]); // player sex. 0=Male and 1=Female
        playerProps.writeByte(headIcon);

		if (isNpc == false) {
  			if (playerEquipment[playerHat] > 1) {
   				playerProps.writeWord(0x200 + playerEquipment[playerHat]);
  			} else {
   				playerProps.writeByte(0);
  			}
  			if (playerEquipment[playerCape] > 1) {
   				playerProps.writeWord(0x200 + playerEquipment[playerCape]);
  			} else {
   				playerProps.writeByte(0);
  			}
  			if (playerEquipment[playerAmulet] > 1) {
   				playerProps.writeWord(0x200 + playerEquipment[playerAmulet]);
  			} else {
   				playerProps.writeByte(0);
  			}
  			if (playerEquipment[playerWeapon] > 1) {
   				playerProps.writeWord(0x200 + playerEquipment[playerWeapon]);
  			} else {
   				playerProps.writeByte(0);
  			}
  			if (playerEquipment[playerChest] > 1) {
   				playerProps.writeWord(0x200 + playerEquipment[playerChest]);
  			} else {
   				playerProps.writeWord(0x100+pTorso);
  			}
  			if (playerEquipment[playerShield] > 1) {
   				playerProps.writeWord(0x200 + playerEquipment[playerShield]);
  			} else {
   				playerProps.writeByte(0);
  			}
  			if (!Item.isPlate(playerEquipment[playerChest])) {
   				playerProps.writeWord(0x100+pArms);
  			} else {
   				playerProps.writeByte(0);
  			}
  			if (playerEquipment[playerLegs] > 1) {
   				playerProps.writeWord(0x200 + playerEquipment[playerLegs]);
  			} else {
    				playerProps.writeWord(0x100+pLegs);
  			}
  			if (!Item.isHelm(playerEquipment[playerHat]) && !Item.isFullMask(playerEquipment[playerHat])) {
   				playerProps.writeWord(0x100 + pHead);  // head
  			} else {
   				playerProps.writeByte(0);
  			}
  			if (playerEquipment[playerHands] > 1) {
   				playerProps.writeWord(0x200 + playerEquipment[playerHands]);
  			} else {
   				playerProps.writeWord(0x100+pHands);
  			}
  			if (playerEquipment[playerFeet] > 1) {
   				playerProps.writeWord(0x200 + playerEquipment[playerFeet]);
  			} else {
   				playerProps.writeWord(0x100+pFeet);
  			}
  			if (!Item.isFullMask(playerEquipment[playerHat]) && (playerLook[0] != 1)) {
        			playerProps.writeWord(0x100 + pBeard);      // Beard
			} else {
				playerProps.writeByte(0);
			}
		} else {
			playerProps.writeWord(-1);
			playerProps.writeWord(npcId);

		}
		playerProps.writeByte(playerLook[1]);	// hair color
		playerProps.writeByte(playerLook[2]);	// torso color.
		playerProps.writeByte(playerLook[3]);	// leg color
		playerProps.writeByte(playerLook[4]);	// feet color
		playerProps.writeByte(playerLook[5]);	// skin color (0-6)
		playerProps.writeWord(pEmote);		// standAnimIndex
		playerProps.writeWord(playerST);		// standTurnAnimIndex
		playerProps.writeWord(playerSEW);	// walkAnimIndex
		playerProps.writeWord(playerT180);		// turn180AnimIndex
		playerProps.writeWord(playerT90CW);		// turn90CWAnimIndex
		playerProps.writeWord(playerT90CCW);		// turn90CCWAnimIndex
		playerProps.writeWord(playerSER);	// runAnimIndex
		playerProps.writeQWord(Misc.playerNameToInt64(playerName));
		int mag = (int)((double)(getLevelForXP(playerXP[4])) * 1.5);
		int ran = (int)((double)(getLevelForXP(playerXP[6])) * 1.5);
		int attstr = (int)((double)(getLevelForXP(playerXP[0])) + (double)(getLevelForXP(playerXP[2])));
		int combatLevel = 0;

		if (ran > attstr) {
			combatLevel = (int)(((double)(getLevelForXP(playerXP[1])) * 0.25) + ((double)(getLevelForXP(playerXP[3])) * 0.25) + ((double)(getLevelForXP(playerXP[5])) * 0.125) + ((double)(getLevelForXP(playerXP[6])) * 0.4875));
		} else if (mag > attstr) {
			combatLevel = (int)(((double)(getLevelForXP(playerXP[1])) * 0.25) + ((double)(getLevelForXP(playerXP[3])) * 0.25) + ((double)(getLevelForXP(playerXP[5])) * 0.125) + ((double)(getLevelForXP(playerXP[4])) * 0.4875));
		} else {
			combatLevel = (int)(((double)(getLevelForXP(playerXP[1])) * 0.25) + ((double)(getLevelForXP(playerXP[3])) * 0.25) + ((double)(getLevelForXP(playerXP[5])) * 0.125) + ((double)(getLevelForXP(playerXP[0])) * 0.325) + ((double)(getLevelForXP(playerXP[2])) * 0.325));
		}
                combat = combatLevel;
		playerProps.writeByte(combatLevel); // combat level
		playerProps.writeWord(0); // incase != 0, writes skill-%d
		str.writeByteC(playerProps.currentOffset); // size of player appearance block
		str.writeBytes(playerProps.buffer, playerProps.currentOffset, 0);
	}

	public boolean chatTextUpdateRequired = false;
	public byte chatText[] = new byte[4096], chatTextSize = 0;
	public int chatTextEffects = 0, chatTextColor = 0;

	protected void appendPlayerChatText(Stream str) {
		str.writeWordBigEndian(((chatTextColor&0xFF) << 8) + (chatTextEffects&0xFF));
		str.writeByte(playerRights);
		str.writeByteC(chatTextSize);
		str.writeBytes_reverse(chatText, chatTextSize, 0);
	}

        public boolean update1Required = false;
        public int update1_1 = 0;
        public int update1_2 = 0;

        protected void appendUpdate1(Stream str) {
		str.writeWordBigEndian(update1_1);
		str.writeByteC(update1_2);
	}

	public void appendPlayerUpdateBlock(Stream str) {
		if (!updateRequired && !chatTextUpdateRequired) {
			return;
		}
		int updateMask = 0;
                if (mask400update) {
			updateMask |= 0x400; 
		}
                if (mask100update) {
			updateMask |= 0x100;
		}
		if (GraphicsUpdateRequired) {
			updateMask |= 0x100;
		}
                if (animationRequest != -1) {
			updateMask |= 8;
		}
                if (string4UpdateRequired) {
			updateMask |= 4;
		}
		if (chatTextUpdateRequired) {
			updateMask |= 0x80;
		}
                if (faceNPCupdate) {
			updateMask |= 1;
		}
		if (appearanceUpdateRequired) {
			updateMask |= 0x10;
		}
                if (FocusPointX != -1) {
			updateMask |= 2;
		}
		if (hitUpdateRequired) {
			updateMask |= 0x20;
		}
		if (hitUpdateRequired2) {
			updateMask |= 0x200;
		}
		if (dirUpdateRequired) {
			updateMask |= 0x40;
		}
		if (dirUpdate2Required) {
			updateMask |= 2;
		}
                if (animationRequest != -1) {
			updateMask |= 8;
		}
		if (updateMask >= 0x100) {
			updateMask |= 0x40; // indication for the client that updateMask is stored in a word
			str.writeByte(updateMask & 0xFF);
			str.writeByte(updateMask >> 8);
		}
		else str.writeByte(updateMask);

                if (mask400update) {
			appendMask400Update(str);
		}
                if (mask100update) {
			appendMask100Update(str); 
		}
		if (GraphicsUpdateRequired) {
			appendGraphicsUpdate(str);
		}
                if (animationRequest != -1) {
			appendAnimationRequest(str);
		}
		if (string4UpdateRequired) {
			appendString4(str);
		}
		if (chatTextUpdateRequired) {
			appendPlayerChatText(str);
		}
                if (faceNPCupdate) {
			appendFaceNPCUpdate(str);
		}
		if (appearanceUpdateRequired) {
			appendPlayerAppearance(str);
		}
                if (FocusPointX != -1) {
			appendSetFocusDestination(str);
		}
		if (hitUpdateRequired) {
			appendHitUpdate(str);
		}
		if (hitUpdateRequired2) {
			appendHitUpdate2(str);
		}
		if (dirUpdateRequired) {
			appendDirUpdate(str);
		}
		if (dirUpdate2Required) {
			appendDirUpdate2(str);
		}
	}

	public void clearUpdateFlags() {
                FocusPointX = FocusPointY = -1;
		updateRequired = false;
                string4UpdateRequired = false;
		chatTextUpdateRequired = false;
		appearanceUpdateRequired = false;
		hitUpdateRequired = false;
		hitUpdateRequired2 = false;
		dirUpdateRequired = false;
                animationRequest = -1;
		dirUpdate2Required = false;
                faceNPCupdate = false;
                faceNPC = 65535;
                mask100update = false;
		update1Required = false;
		IsStair = false;
	}



	public static int newWalkCmdX[] = new int[walkingQueueSize];
	public static int newWalkCmdY[] = new int[walkingQueueSize];
	public static int tmpNWCX[] = new int[walkingQueueSize];
	public static int tmpNWCY[] = new int[walkingQueueSize];
	public static int newWalkCmdSteps = 0;
	public static boolean newWalkCmdIsRunning = false;
	public static int travelBackX[] = new int[walkingQueueSize];
	public static int travelBackY[] = new int[walkingQueueSize];
	public static int numTravelBackSteps = 0;
   	/*Highscores*/
    	/*For more highscores to be recorded, change the #s in [] to the number you want kept, 	+1*/
    	/*For example, if you want the top 20, put 21 in the [] ([21])*/
    	public static int[] ranks = new int[11];
    	public static String[] rankPpl = new String[11];
	public void preProcessing() {
		newWalkCmdSteps = 0;
	}

	// is being called regularily every 500ms - do any automatic player actions herein
	public abstract void process();
	public abstract boolean packetSending();
	public boolean following = false;

	public void postProcessing() {
		if (newWalkCmdSteps > 0) {
			int OldcurrentX = currentX;
         		int OldcurrentY = currentY;

         		for (i = 0; i < playerFollow.length; i++) {
            			if (playerFollow[i] != -1 && following == true) {
               				PlayerHandler.players[playerFollow[i]].newWalkCmdSteps = (newWalkCmdSteps + 1);

               				for (int j = 0; j < newWalkCmdSteps; j++) {
                  				PlayerHandler.players[playerFollow[i]].newWalkCmdX[(j + 1)] = newWalkCmdX[j];
                  				PlayerHandler.players[playerFollow[i]].newWalkCmdY[(j + 1)] = newWalkCmdY[j];
               				}
               				PlayerHandler.players[playerFollow[i]].newWalkCmdX[0] = OldcurrentX;
               				PlayerHandler.players[playerFollow[i]].newWalkCmdY[0] = OldcurrentY;
               				PlayerHandler.players[playerFollow[i]].poimiX = OldcurrentX;
               				PlayerHandler.players[playerFollow[i]].poimiY = OldcurrentY;
            			}
				int firstX = newWalkCmdX[0], firstY = newWalkCmdY[0];
				int lastDir = 0;
				boolean found = false;
				numTravelBackSteps = 0;
				int ptr = wQueueReadPtr;
				int dir = Misc.direction(currentX, currentY, firstX, firstY);

				if (dir != -1 && (dir&1) != 0) {
					do {
						lastDir = dir;

						if (--ptr < 0) {
							ptr = walkingQueueSize-1;
						}
						travelBackX[numTravelBackSteps] = walkingQueueX[ptr];
						travelBackY[numTravelBackSteps++] = walkingQueueY[ptr];
						dir = Misc.direction(walkingQueueX[ptr], walkingQueueY[ptr], firstX, firstY);

						if(lastDir != dir) {
							found = true;
							break;
						}

					} while(ptr != wQueueWritePtr);
				} else {
					found = true;
				}
				if (!found) {
					println_debug("Fatal: couldn't find connection vertex! Dropping packet.");
					disconnected = true;
				} else {
					wQueueWritePtr = wQueueReadPtr;
					addToWalkingQueue(currentX, currentY);

					if (dir != -1 && (dir&1) != 0) {
						for (int i = 0; i < numTravelBackSteps-1; i++) {
							addToWalkingQueue(travelBackX[i], travelBackY[i]);
						}
						int wayPointX2 = travelBackX[numTravelBackSteps-1], wayPointY2 = travelBackY[numTravelBackSteps-1];
						int wayPointX1, wayPointY1;

						if (numTravelBackSteps == 1) {
							wayPointX1 = currentX;
							wayPointY1 = currentY;
						} else {
							wayPointX1 = travelBackX[numTravelBackSteps-2];
							wayPointY1 = travelBackY[numTravelBackSteps-2];
						}
						dir = Misc.direction(wayPointX1, wayPointY1, wayPointX2, wayPointY2);

						if (dir == -1 || (dir&1) != 0) {
							println_debug("Fatal: The walking queue is corrupt! wp1=("+wayPointX1+", "+wayPointY1+"), "+
								"wp2=("+wayPointX2+", "+wayPointY2+")");
						} else {
							dir >>= 1;
							found = false;
							int x = wayPointX1, y = wayPointY1;

							while(x != wayPointX2 || y != wayPointY2) {
								x += Misc.directionDeltaX[dir];
								y += Misc.directionDeltaY[dir];

								if((Misc.direction(x, y, firstX, firstY)&1) == 0) {
									found = true;
									break;
								}
							}
							if (!found) {
								println_debug("Fatal: Internal error: unable to determine connection vertex!"+
									"  wp1=("+wayPointX1+", "+wayPointY1+"), wp2=("+wayPointX2+", "+wayPointY2+"), "+
									"first=("+firstX+", "+firstY+")");
							} else addToWalkingQueue(wayPointX1, wayPointY1);
						}
					} else {
						for (int i = 0; i < numTravelBackSteps; i++) {
							addToWalkingQueue(travelBackX[i], travelBackY[i]);
						}
					}
					for (int i = 0; i < newWalkCmdSteps; i++) {
						addToWalkingQueue(newWalkCmdX[i], newWalkCmdY[i]);
					}

				}
				isRunning = newWalkCmdIsRunning || isRunning2;

				for (i = 0; i < playerFollow.length; i++) {
					if (playerFollow[i] != -1 && PlayerHandler.players[playerFollow[i]] != null) {
						PlayerHandler.players[playerFollow[i]].postProcessing();
					}
				}
			}
		}
        }

	public void kick() {
		isKicked = true;
	}

	public int hitDiff = 0;
	public int hitDiff2 = 0;
	protected boolean hitUpdateRequired = false;
	protected boolean hitUpdateRequired2 = false;
	public boolean IsDead = false;
	protected int NewHP = 10;
	protected boolean SafeMyLife = false;
	protected boolean IsStair = false;
	public boolean IsDeadTeleporting = false;
	protected boolean IsDeadTimer = false;

	protected void appendHitUpdate(Stream str) {		
		try {
			str.writeByte(hitDiff); // What the perseon got 'hit' for

			if (!poisondmg) {
				if (hitDiff > 0) {
					str.writeByteA(1);
				} else {
					str.writeByteA(0);
				}
			} else {
				str.writeByteA(2);
			}
			//NewHP = (playerLevel[playerHitpoints] - hitDiff);

			if (NewHP <= 0) {
				NewHP = 0;
				IsDead = true;
			}
			str.writeByteC(NewHP); // Their current hp, for HP bar
			str.writeByte(getLevelForXP(playerXP[playerHitpoints])); // Their max hp, for HP bar
                        poisondmg = false;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	protected void appendHitUpdate2(Stream str) {		
		try {
			str.writeByte(hitDiff2); // What the perseon got 'hit' for

			if (!poisondmg) {
				if (hitDiff2 > 0) {
					str.writeByteS(1);
				} else {
					str.writeByteS(0);
				}
			} else {
				str.writeByteS(2);
			}
			//NewHP = (playerLevel[playerHitpoints] - hitDiff2);

			if (NewHP <= 0) {
				NewHP = 0;
				IsDead = true;
			}
			str.writeByte(NewHP); // Their current hp, for HP bar
			str.writeByteC(getLevelForXP(playerXP[playerHitpoints])); // Their max hp, for HP bar
                        poisondmg = false;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public int getLevelForXP(int exp) {
		int points = 0;
		int output = 0;

		for (int lvl = 1; lvl <= 150; lvl++) {
			points += Math.floor((double)lvl + 300.0 * Math.pow(2.0, (double)lvl / 7.0));
			output = (int)Math.floor(points / 4);
			if (output >= exp)
				return lvl;
		}
		return 0;
	}
	public int animationRequest = -1, animationWaitCycles = 0;
        protected boolean animationUpdateRequired = false;
	public void startAnimation(int animIdx)
	{
		animationRequest = animIdx;
		animationWaitCycles = 0;
	}
	public void appendAnimationRequest(Stream str)
	{
		str.writeWordBigEndian((animationRequest==-1) ? 65535 : animationRequest);
		str.writeByteC(animationWaitCycles);
	}
        public int playerEmotionReq = -1;
        public int playerEmotionDelay = 0;
	public void appendEmotionUpdate(Stream str) {
		str.writeWordBigEndian((playerEmotionReq==-1) ? 65535 : playerEmotionReq);
		str.writeByteC(playerEmotionDelay);
	}
        public int mask1var = 0;
        protected boolean mask1update = false;
        public void appendMask1Update(Stream str) {
                str.writeWordBigEndian(mask1var);
        }
        public void faceNPC(int index) {
                faceNPC = index;
                faceNPCupdate = true;
                updateRequired = true;
        }
        public boolean faceNPCupdate = false;
        public int faceNPC = -1;
        public void appendFaceNPCUpdate(Stream str) {
                str.writeWordBigEndian(faceNPC);
        }
        public int mask100var1 = 0;
        public int mask100var2 = 0;
        protected boolean mask100update = false;
        public void appendMask100Update(Stream str) {
                str.writeWordBigEndian(mask100var1);
                str.writeDWord(mask100var2);
        }
        public int m4001 = 0;
        public int m4002 = 0;
        public int m4003 = 0;
        public int m4004 = 0;
        public int m4005 = 0;
        public int m4006 = 0;
        public int m4007 = 0;
        protected boolean mask400update = false;
        public void appendMask400Update(Stream str) { // Xerozcheez: Something to do with direction
                str.writeByteA(m4001);
                str.writeByteA(m4002);
                str.writeByteA(m4003);
                str.writeByteA(m4004);
                str.writeWordA(m4005);
                str.writeWordBigEndianA(m4006);
                str.writeByteA(m4007); // direction
        }
	public void displayText(String s) {
		txt4 = s;
		updateRequired = true;
		string4UpdateRequired = true;
	}
        public String txt4 = "testing update mask string";
        public boolean string4UpdateRequired = false;
        public void appendString4(Stream str) { // Xerozcheez: Interesting mask, looks like to do with chat
		str.writeString(txt4);
        }
	public void appendDirUpdate2(Stream str) {
		str.writeWordBigEndianA(viewToX);
		str.writeWordBigEndian(viewToY);
	}          
	public void appendDirUpdate(Stream str) {
		if (playerMD != -1) {
			str.writeWord(playerMD);
			playerMD = -1;
		}
	}
	public boolean[] IsDropped = new boolean[GameEngine.itemHandler.MaxDropItems];
	public boolean[] MustDelete = new boolean[GameEngine.itemHandler.MaxDropItems];
	public boolean IsDropping = false;

	//PM Stuff
	public abstract boolean isinpm(long l);
	public abstract void loadpm(long l, int world);
	public abstract void pmupdate(int pmid, int world);
	public int Privatechat = 0;
	public abstract void sendpm(long name,int rights,byte[] chatmessage, int messagesize);
	public long friends[] = new long[200];
	public long ignores[] = new long[100];
	public boolean IsPMLoaded = false;

	public int playerIsMember;
	public int playerMessages;
	public String playerLastConnect;
	public int playerLastLogin;
	public int playerEnergy = 100;
	public int playerEnergyGian;
	public int playerLook[] = new int[6];
	public boolean IsUsingSkill = false;
	public int playerBonus[] = new int[12];
	public int StrPotion = 0;
	public int StrPrayer = 0;
	public int FightType = 1;
	public int playerMaxHit = 0;

	public int playerST = 0x337; // turn180AnimIndex
	public int playerT180 = 0x334; // turn180AnimIndex
	public int playerT90CW = 0x335; // turn90CWAnimIndex
	public int playerT90CCW = 0x336; // turn90CCWAnimIndex
	public int playerSE = 0x328; //SE = Standard Emotion
	public int playerSEW = 0x333; //SEW = Standard Emotion Walking
	public int playerSER = 0x338; //SER = Standard Emotion Run
	public int playerSEA = 0x326; //SEA = Standard Emotion Attack
	public int playerMD = -1;
        public int viewToX = -1; 
        public int viewToY = -1;
	protected boolean dirUpdateRequired = false;
	protected boolean dirUpdate2Required = false;
	public boolean IsCutting = false;
	public boolean WannePickUp = false;
	public boolean IsInWilderness = false;
	public boolean IsAttacking = false;
	public boolean IsMining = false;
	public boolean IsAttackingNPC = false;
	public int attacknpc = -1;
	public int Essence;
	public boolean IsShopping = false;
	public int MyShopID = 0;
	public boolean UpdateShop = false;
	public boolean RebuildNPCList = false;
	public int IsSnowing = 0;
	public int NpcDialogue = 0;
	public int NpcTalkTo = 0;
	public boolean NpcDialogueSend = false;
	public int NpcWanneTalk = 0;
	public boolean IsBanking = false;
	public int WanneTrade = 0;
	public int WanneTradeWith = 0;
	public boolean TradeConfirmed = false;
	public boolean AntiTradeScam = false;
	public int playerFollow[] = new int[PlayerHandler.maxPlayers];
        public int playerFollowID = -1; 
	public int DirectionCount = 0;
	public boolean playerAncientMagics = false;
	public String playerServer;
	public int playerGameTime;
	public int playerGameCount;
}