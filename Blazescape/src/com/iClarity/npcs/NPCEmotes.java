/*
 * Class NPCEmotes.
 *
 * Contains NPC Animations.
 *
 * @Author Primadude.
 */

package com.iClarity.npcs;


import com.iClarity.misc.*;

public class NPCEmotes {

	/*
	 * Constructor.
	 */
	public NPCEmotes() {

	}

	/*
	 * The animations for Melee style attacks.
	 */
	public static int GetMeleeEmote(NPC n) {
		switch(n.npcType) {
			case 1975:
				return 6945;
			case 3340:
				return 3312;
			case 3808:
				return 3961;

			case 3012: case 3013: case 3014:
				return 6154;
			case 3006: case 3007: case 3008:
				return 6951;
			case 3010:
				return 7018;
			case 3011:
				return 6376;
			case 3061:
				return 2959;
			case 3060:
				return 2964;
			case 1021:
				return 1040;
			case 1329:
				return 289;
			case 3406:
				return 1582;
			case 1823:
				return 1785;
			case 47:
				return 2705;
			case 3455:
				return 6977;
			case 3000:
				return 2799;
			case 3002:
				return 2803;
			case 1913:
				return 451;
        		case 997:
            			return 147;
			case 3005:
				return 1658;
        		case 2263:
				return 2181;

        		case 1460:
        		case 1461:
				return 1402;

        		case 1465:
				return 1383;

        		case 2452:
				return 1312;

        		case 2566:
				return 423;

        		case 3070:
				return 2986;

        		case 151:
        		case 152:
        		case 153:
        		case 154:
        		case 155:
        		case 159:
        		case 160:
        		case 1974:
				return 406;

        		case 18: 
        		case 239:
        		case 241:
        		case 243:
        		case 244:
        		case 245:
        		case 246:
        		case 1977:
				return 451;

        		case 12: 
				return 1833;

        		case 17:
				return 405;

        		case 1353:
        		case 1354:
        		case 1355:
				return 1341;

        		case 81:
				return 59;

        		case 105: 
				return 41;

        		case 89:
				return 289;

        		case 100:
				return 309;

        		case 110:
        		case 111:
        		case 112:
        		case 116: 
        		case 117: 
				return 128;

        		case 2745:
				return 2655;

        		case 127: 
				return 138;

        		case 49: 
				return 158;

        		case 3741:
				return 3901;

        		case 103: 
        		case 655:
				return 123;

        		case 1:
        		case 181:
        		case 188:
				return 422;

        		case 19: 
				return 407;

        		case 3776:
				return 3897;

        		case 4: 
				return 423;

        		case 7: 
        		case 240:
        		case 242:
				return 440;

        		case 3751:
				return 3908;

			case 2743:
        		case 2744:
				return 2644;

        		case 1613:
				return 1528;

        		case 1153:
        		case 1154:
        		case 1155:
        		case 1158:
				return 1184;

        		case 1160:
				return 1178;

        		case 414:
				return 153;

        		case 2026:
				return 2067;

        		case 2027:
				return 2080;

        		case 2029:
				return 2068;

        		case 2030:
				return 2062;

        		case 2742:
				return 2637;

        		case 2631:
				return 2628;

        		case 2629:
				return 2625;

        		case 2627:
				return 2621;

        		case 2598:
				return 2609;

        		case 2607:
				return 2611;

        		case 2616:
				return 2610;

        		case 1200:
				return 440;

        		case 1610:
				return 1517;

        		case 1615:
				return 1537;

        		case 2783:
				return 2733;

        		case 1590:
        		case 1592:
				return 80;

        		case 50:
        		case 53:
        		case 54:
        		case 55:
        		case 941:
				return 80;

        		case 41: 
				return 55;

        		case 1470:
				return 64;

        		case 87: 
        		case 88: 
				return 138;

        		case 2883:
			case 2882:
			case 2881:
				return 2853;

        		case 93:
        		case 1973:
        		case 2037:
				return 260;

        		case 1264:
				return 1062;

        		case 82:
        		case 83:
        		case 84: 
        		case 677:
        		case 998:
        		case 999:
        		case 1000:
        		case 1472:
			case 1978:
			case 1979:
			case 1976:
				return 64;

        		case 158:
				return 391;
		}
		return 806;
	}

	/*
	 * The animations for Magic style attacks.
	 */
	public static int GetMageEmote(NPC n) {
		switch(n.npcType) {


			case 3808:
				return 3955;
			case 3006: case 3007: case 3008:
				return 6952;
			case 3011:
				return 6375;
        		case 2457:
				return 2365;

        		case 2566:
				return 811;

        		case 1643:
				return 1162;

        		case 3070:
				return 2985;

        		case 2892:
				return 2868;

        		case 677:
        		case 911:
				return 69;

        		case 1607:
				return 1507;

        		case 908:
				return 132;

        		case 909:
				return 147;

        		case 1914:
				return 724;

			case 2743:
        		case 2744:
				return 2647;

        		case 2745:
				return 2656;

        		case 3761:
				return 3882;

        		case 1158:
				return 1185;

        		case 1160:
				return 1170;

        		case 2025:
				return 1167;

        		case 912:
        		case 913:
        		case 1264:
				return 811;

        		case 914:
				return 197;

        		case 1913:
				return 1979;

        		case 2595:
				return 2613;

        		case 50: 
        		case 53: 
        		case 54:
        		case 55: 
        		case 941:
        		case 1590:
        		case 1592:
				return 81;

        		case 2882:
				return 2854;

        		case 1353:
				return 1343;

        		case 1354:
				return 1343;

        		case 1355:
				return 1343;
		}
		return 811;
	}

	/*
	 * The animations for Ranged style attacks.
	 */
	public static int GetRangeEmote(NPC n) {
		switch(n.npcType) {

			case 1183:
				return 426;
			case 3808:
				return 3954;
			case 3012:
				return 6154;
        		case 479:
				return 190;

        		case 50:
				return 81;
        		case 2779:
				return 426;

        		case 2566:
				return 811;

        		case 1915:
				return 724;

        		case 1353:
        		case 1354:
        		case 1355:
				return 1343;

        		case 2631:
				return 2633;

        		case 1158:
				return 1184;

        		case 3771:
				return 3920;

        		case 1160:
				return 1177;

        		case 2028:
				return 2075;

        		case 2745:
				return 2652;

        		case 1342:
				return 1343;

        		case 2881:
				return 2855;
		}
		return 426;
	}

	/*
	 * The animations for NPC deaths.
	 */
	public static int GetDeathAnim(NPC n) {
		switch(n.npcType) {

			case 3340:
				return 3310;
			case 1975:
				return 6946;
			case 3012: case 3013: case 3014:
				return 6156;
			case 3006: case 3007: case 3008:
				return 6952;
			case 3808:
				return 3962;
			case 3010:
				return 7016;
			case 3011:
				return 6377;
			case 3061:
				return 166;
			case 3060:
				return 313;
			case 1021:
				return 1041;
			case 1329:
				return 292;
			case 3406:
				return 1580;
			case 1823:
				return 1787;
			case 47:
				return 2707;
			case 3455:
				return 6975;
			case 3000:
				return 2801;
			case 3002:
				return 2805;
			case 1200:
				return 2304;
			case 1353:
				return 1342;
			case 2263:
				return 2183;
			case 1465:
				return 1384;
			case 3070:
				return 2987;
			case 2452:
				return 1314;
			case 909:
				return 146;
			case 997:
				return 146;
			case 1460: case 1461:
				return 1404;
			case 105:
				return 44;
			case 1607:
				return 1508;
			case 914:
				return 196;
			case 479:
				return 196;
			case 81:
				return 62;
			case 100:
				return 313;
			case 1354:
				return 1342;
			case 89:
				return 292;
			case 1355:
				return 1342;
			case 103:
				return 126;
			case 655:
				return 126;
			case 41:
				return 57;
			case 117:
				return 131;
			case 110:
				return 131;
			case 111:
				return 131;
			case 112:
				return 131;
			case 116:
				return 131;
			case 908:
				return 131;
			case 49:
				return 161;
			case 127:
				return 141;
			case 3761:
				return 3881;
			case 3741:
				return 3903;
			case 3776:
				return 3894;
			case 3751:
				return 3910;
			case 3771:
				return 3922;
			case 1183:
				return 2304;
			case 1613:
				return 1529;
			case 1610:
				return 1520;
			case 1611:
				return 1520;
			case 1158:
				return 1187;
			case 1153:
				return 1187;
			case 1154:
				return 1187;
			case 1155:
				return 1187;
			case 414:
				return 156;
			case 1160:
				return 1182;
			case 2598:
			case 2607:
			case 2595:
			case 2616:
				return 2607;
			case 2627:
				return 2620;
			case 2629:
				return 2627;
			case 2631:
				return 2630;
			case 2742:
				return 2638;
			case 2744:
			case 2743:
				return 2646;
			case 2745:
				return 2654;
			case 1615:
				return 1538;
			case 2783:
				return 2732;
			case 1590:
			case 1592:
				return 92;
			case 55:
				return 92;
			case 54:
				return 92;
			case 53:
				return 92;
			case 941:
				return 92;
			case 50:
				return 92;
			case 87:
			case 88:
				return 141;
			case 1470:
				return 67;
			case 1342:
				return 1342;
			case 2881:
			case 2882:
			case 2883:
				return 2856;
			case 93:
				return 263;
			case 1973:
				return 263;
			case 2037:
				return 263;
			case 1472:
				return 67;
			case 84:
				return 67;
			case 83:
			case 1978:
			case 1979:
			case 1976:
				return 67;
			case 82:
				return 67;
			case 998:
				return 67;
			case 999:
				return 67;
			case 1000:
				return 67;
			case 677:
				return 67;
			case 911:
				return 67;
			case 2892:
				return 2866;
		}
		return n.npcType != 2457 ? 2304 : 2367;
	}

	/*
	 * The animations for NPC blocks.
	 */
	public static int GetBlockAnim(NPC n) {
		switch(n.npcType) {

			case 3340:
				return 3311;
			case 1975:
				return 6944;
			case 3012:
			case 3013:
			case 3014:
				return 6155;
			case 3006:
			case 3007:
			case 3008:
				return 6952;
			case 3808:
				return 3960;
			case 3010:
				return 7017;
			case 3011:
				return 6375;
			case 3061:
				return 165;
			case 3060:
				return 312;

			case 1021:
				return 1042;
			case 1329:
				return 290;
			case 1823:
				return 1786;
			case 47:
				return 2706;
			case 3406:
				return 1581;
			case 3455:
				return 6974;
			case 3000:
				return 2800;
			case 3002:
				return 2804;
			case 1200:
				return 403;
			case 2263:
				return 2182;
			case 89:
				return 290;
			case 1460:
			case 1461:
				return 1403;
			case 2457:
				return 2366;
			case 105:
				return 42;
			case 1465:
				return 1393;
			case 2452:
				return 1313;
			case 909:
				return 144;
			case 997:
				return 144;
			case 2892:
				return 2869;
			case 1353:
				return 1340;
			case 81:
				return 60;
			case 914:
				return 193;
			case 479:
				return 193;
			case 3070:
				return 2983;
			case 100:
				return 312;
			case 1607:
				return 1509;
			case 1354:
				return 1340;
			case 1355:
				return 1340;
			case 41:
				return 56;
			case 117:
				return 129;
			case 110:
				return 129;
			case 111:
				return 129;
			case 112:
				return 129;
			case 116:
				return 129;
			case 908:
				return 129;
			case 127:
				return 139;
			case 49:
				return 159;
			case 103:
				return 124;
			case 655:
				return 124;
			case 19:
				return 410;
			case 3776:
				return 3895;
			case 1:
				return 404;
			case 4:
				return 404;
			case 3761:
				return 3880;
			case 3771:
				return 3921;
			case 1613:
				return 1531;
			case 3751:
				return 3909;
			case 3741:
				return 3902;
			case 1183:
				return 404;
			case 158:
				return 399;
			case 414:
				return 154;
			case 1158:
				return 1186;
			case 1153:
				return 1186;
			case 1154:
				return 1186;
			case 1155:
				return 1186;
			case 1160:
				return 1179;
			case 1610:
				return 1519;
			case 2598:
			case 2607:
			case 2595:
			case 2616:
				return 2606;
			case 2627:
				return 2622;
			case 2629:
				return 2626;
			case 2631:
				return 2629;
			case 2742:
				return 2635;
			case 2744:
			case 2743:
				return 2645;
			case 2745:
				return 2653;
			case 1615:
				return 1536;
			case 2783:
				return 2730;
			case 1590:
			case 1592:
				return 89;
			case 55:
				return 89;
			case 54:
				return 89;
			case 53:
				return 89;
			case 941:
				return 89;
			case 50:
				return 89;
			case 1470:
				return 65;
			case 87:
			case 88:
				return 139;
			case 1342:
				return 1340;
			case 2881:
			case 2882:
			case 2883:
				return 2852;
			case 93:
				return 261;
			case 1973:
				return 261;
			case 2037:
				return 261;
			case 1472:
				return 65;
			case 84:
				return 65;
			case 83:
			case 1978:
			case 1979:
			case 1976:
				return 65;
			case 82:
				return 65;
			case 998:
				return 65;
			case 999:
				return 65;
			case 1000:
				return 65;
			case 677:
				return 65;
		}
		return n.npcType != 911 ? 404 : 65;
	}
}
