/**
* Music constants and method
*
*/
package com.iClarity.player;

public class Music {
	
	public int THEME = 0, 
	A_PLACE_FOR_MY_HEAD = 1,
	BLUE = 2,
	EMERALD_SWORD = 3,
	BOHEMIAN_RHAPSODY = 4,
	GOT_RICE = 5,
	BLUE_REMIX = 6,
	MK_MIX = 7,
	EYE_TIGER = 8,
	GOLDENEYE = 9,
	POKE_HEAL = 10,
	CASTLE_WARS = 11,
	ELITE_FOUR_RS = 12,
	EVIL_BOB = 13, //Evil Bob RuneScape Theme
	SHORT_TUNE = 14, //Extremely Short
	SEA_SHANTY_TUNE = 15, //Sounds like Sea Shanty or something piratey!
	RE_MOVE = 16,
	UNID_1 = 17,
	SSMB = 18, //Super Smash Bro Melee Fountain Music
	ULTRA_MIX = 19,
	CHRONO_BELL = 20, //Sounds like Chrono Trigger bells
	BOSS_INTRO = 21,
	UNID_TECHNO = 22,
	UNID_ORIENTAL = 23,
	METAL = 24, //Sounds like Metallica?
	BEEP_MIX = 25,
	BOB_MIX = 26,
	RUNESCAPE_1 = 27, //Sounds Runescapey
	THIRD_FLOOR = 28, //BlazeFire wanted this as the music for the third floor?
	OUTRO = 29, //Sounds like an outro to a NES game!
	ISLAND = 30, //Sounds like beach music. Reminds me of Hawaii
	DESERT = 31, //Desert Theme!
	THEME_33 = 32, //Same as 33!
	SECOND_FLOOR = 33, //BlazeFire wanted this to be the second floor training music?
	UNID_2 = 34, 
	SPEED_MIX = 35,
	PIANO_1 = 36,
	WALL = 37,
	PIANO_2 = 38,
	FOREST = 39, //Sounds like Final Fantasy??
	POKE_BATTLE_THEME = 40, //Blazefire may have wanted this for the wild? 
	DUELING = 41, //Blazefire may have wanted this as the dueling music as soon as you initiated the fight.
	DUEL_BOX = 42, //Possible multi-pvp music?
	CREDIT = 44,
	
	

	RESUME = 497,
	PAUSE = 498;
	
	public void playMusic(clientHandler p, int song) {
		p.playSound(song+500);
	}
}