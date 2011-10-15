package com.iClarity.world.Objects;

import java.io.*;
import com.iClarity.*;
import com.iClarity.misc.*;
import com.iClarity.player.*;

public class AlKharidObjects {
	public static void curtains(clientHandler p, int objectX, int objectY, int objectID) {
		if(p.GoodDistance(objectX, objectY, p.absX, p.absY, 1)) {
			switch(objectID) {
				//Directions: 1 = Pointing north(Longside) || 0 = Longside West
				//3 = Longside South || 2 = Longside East
				case 1529://Curtain Open
					int m = 1528;
					if(objectX == 3300 && objectY == 3187) {
						p.ReplaceObject3(objectX, objectY, m, 1, 9);
					} else if(objectX == 3313 && objectY == 3175) {
						p.ReplaceObject3(objectX, objectY, m, 2, 0);
					} else if(objectX == 3317 && objectY == 3193) {
						p.ReplaceObject3(objectX, objectY, m, 2, 0);
					} else if(objectX == 3315 && objectY == 3166) {
						p.ReplaceObject3(objectX, objectY, m, 3, 0);
					} else if(objectX == 3292 && objectY == 3206) {
						p.ReplaceObject3(objectX, objectY, m, 1, 0);
					} else if(objectX == 3291 && objectY == 3189) {
						p.ReplaceObject3(objectX, objectY, m, 0, 0);
					} else if(objectX == 3287 && objectY == 3186) {
						p.ReplaceObject3(objectX, objectY, m, 1, 0);
					}
					break;
				case 1528://Curtain Closed
					int n = 1529;
					if(objectX == 3300 && objectY == 3187) {
						p.ReplaceObject3(objectX, objectY, n, 1, 9);
					} else if(objectX == 3313 && objectY == 3175) {
						p.ReplaceObject3(objectX, objectY, n, 2, 0);
					} else if(objectX == 3317 && objectY == 3193) {
						p.ReplaceObject3(objectX, objectY, n, 2, 0);
					} else if(objectX == 3315 && objectY == 3166) {
						p.ReplaceObject3(objectX, objectY, n, 3, 0);
					} else if(objectX == 3292 && objectY == 3206) {
						p.ReplaceObject3(objectX, objectY, n, 1, 0);
					} else if(objectX == 3291 && objectY == 3189) {
						p.ReplaceObject3(objectX, objectY, n, 0, 0);
					} else if(objectX == 3287 && objectY == 3186) {
						p.ReplaceObject3(objectX, objectY, n, 1, 0);
					}
					break;
				//Diagonal Directions: 3 = Northeast || 1 = Southeast
				case 2882: //Gate
					if(objectX == 3268 && objectY == 3228) {
						p.ReplaceObject3(objectX, objectY, 2883, 0, 0);
					} else if(objectX == 3268 && objectY == 3227) {
						p.ReplaceObject3(objectX, objectY, 2883, 3, 0);
					}
					break;
				case 2883://Gate
					if(objectX == 3268 && objectY == 3228) {
						p.ReplaceObject3(objectX, objectY, 2882, 1, 0);
					} else if(objectX == 3268 && objectY == 3227) {
						p.ReplaceObject3(objectX, objectY, 2882, 0, 0);
					}
					break;
				case 3198://Duel arena gate
				case 3197://Duel Arena Gate
					if(objectX == 3312 && (objectY == 3235 || objectY == 3234)) {
						p.stillgfx(288, 3235, 3311);
						p.stillgfx(288, 3234, 3311);
						p.stillgfx(288, 3235, 3312);
						p.stillgfx(288, 3234, 3312);
						p.ReplaceObject3(3312, 3235, 0, 1, 0);
						p.ReplaceObject3(3312, 3234, 0, 1, 0);
						p.sendMessage("The gate explodes");
					}
					break;
				/**
				*These are the mother freaking doors in the castle
				*They took goddam forever
				*Be happy they were very difficult to make
				*Grrrrrr
				**/
				case 1506://Castle doors
					if(objectX == 3298 && objectY == 3171) {//RightDoor East Side closed
						p.ReplaceObject3(objectX, objectY, 6953, -1, 0);
						p.createObject(3299, 3171, 1506, 3, 0);
					} else if(objectX == 3299 && objectY == 3171) {//RightDoor East Side Open
						p.ReplaceObject3(objectX, objectY, 6953, -1, 0);
						p.createObject(3298, 3171, 1506, 2, 0);
					} else if(objectX == 3287 && objectY == 3172) {//Left Door West side
						p.ReplaceObject3(objectX, objectY, 6953, -1, 0);
						p.createObject(3286, 3172, 1506, 1, 0);
					} else if(objectX == 3286 && objectY == 3172) {
						p.ReplaceObject3(objectX, objectY, 6953, -1, 0);
						p.createObject(3287, 3172, 1506, 0, 0);
					} else if(objectX == 3292 && objectY == 3167) {//Right door South Side closed
						p.ReplaceObject3(objectX, objectY, 6953, -1, 0);
						p.createObject(3292, 3166, 1506, 0, 0);
					} else if(objectX == 3292 && objectY == 3166) {//Right door South Side Open
						p.ReplaceObject3(objectX, objectY, 6953, -1, 0);
						p.createObject(3292, 3167, 1506, 3, 0);
					}
					break;
				case 1508://Castle Doors
					if(objectX == 3298 && objectY == 3172) {//Left door East side closed
						p.ReplaceObject3(objectX, objectY, 6953, -1, 0);
						p.createObject(3299, 3172, 1508, 1, 0);
					} else if(objectX == 3299 && objectY == 3172) {//Left door East Side open
						p.ReplaceObject3(objectX, objectY, 6953, -1, 0);
						p.createObject(3298, 3172, 1508, 2, 0);
					} else if(objectX == 3287 && objectY == 3171) {//Right door West side Closed
						p.ReplaceObject3(objectX, objectY, 6953, -1, 0);
						p.createObject(3286, 3171, 1508, 3, 0);
					} else if(objectX == 3286 && objectY == 3171) {//Right door West side Open
						p.ReplaceObject3(objectX, objectY, 6953, -1, 0);
						p.createObject(3287, 3171, 1508, 0, 0);
					} else if(objectX == 3293 && objectY == 3167) {//Left door South Side closed
						p.ReplaceObject3(objectX, objectY, 6953, -1, 0);
						p.createObject(3293, 3166, 1508, 2, 0);
					} else if(objectX == 3293 && objectY == 3166) {//Left door South Side Open
						p.ReplaceObject3(objectX, objectY, 6953, -1, 0);
						p.createObject(3293, 3167, 1508, 3, 0);
					}
					break;
				case 1531://Brown Doors
					if(objectX == 3276 && objectY == 3180) {
						p.ReplaceObject3(objectX, objectY, 6953, -1, 0);
						p.createObject(3275, 3180, 1530, 2, 0);
					} else if(objectX == 3278 && objectY == 3191) {
						p.ReplaceObject3(objectX, objectY, 6953, -1, 0);
						p.createObject(3277, 3191, 1530, 2, 0);
					} else if(objectX == 3279 && objectY == 3185) {
						p.ReplaceObject3(objectX, objectY, 6953, -1, 0);
						p.createObject(3280, 3185, 1530, 0, 0);
					} else if(objectX == 3311 && objectY == 3183) {
						p.ReplaceObject3(objectX, objectY, 6953, -1, 0);
						p.createObject(3312, 3183, 1530, 0, 0);
					}
					break;
				case 1530://Brown Doors
					if(objectX == 3275 && objectY == 3180) {
						p.ReplaceObject3(objectX, objectY, 6953, -1, 0);
						p.createObject(3276, 3180, 1531, 3, 0);
					} else if(objectX == 3277 && objectY == 3191) {
						p.ReplaceObject3(objectX, objectY, 6953, -1, 0);
						p.createObject(3278, 3191, 1531, 3, 0);
					} else if(objectX == 3280 && objectY == 3185) {
						p.ReplaceObject3(objectX, objectY, 6953, -1, 0);
						p.createObject(3279, 3185, 1531, 1, 0);
					} else if(objectX == 3312 && objectY == 3183) {
						p.ReplaceObject3(objectX, objectY, 6953, -1, 0);
						p.createObject(3311, 3183, 1531, 1, 0);
					}
					break;
				/**
				*Things in the magic guild
				*/
				case 10721://Doorway
					if(p.absX == 3363 && p.absY == 3298) {
						p.teleportToX = 3363;
						p.teleportToY = 3300;
					} else {
						p.teleportToX = 3363;
						p.teleportToY = 3298;
					}
					break;
				case 1534:
					if(objectX == 3321 && objectY == 3142) {
						p.ReplaceObject3(objectX, objectY, 6953, -1, 0);
						p.createObject(3321, 3141, 1534, 1, 0);
					} else if(objectX == 3321 && objectY == 3141) {
						p.ReplaceObject3(objectX, objectY, 6953, -1, 0);
						p.createObject(3321, 3142, 1534, 2, 0);
					}
					break;
				case 388://Wardrobe
					if((objectX == 3319 || objectX == 3324) && objectY == 3137) {
						p.ReplaceObject3(objectX, objectY, 389, 3, 10);
					}
					break;
				default:
					p.destinationRange = 1;
					break;
			}
		}
	}
}