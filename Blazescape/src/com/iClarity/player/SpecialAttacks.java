package com.iClarity.player;

import java.io.*;

public class SpecialAttacks {


	/**
	 * Constructor
	 */
	public SpecialAttacks(clientHandler p) {
		this.p = p;
	}

	public int getSpecialAmount(clientHandler p) {
		return p.specialAmount;
	}

	public void specialAttacks() {
	    if (p.isSpecWeapon(p.playerEquipment[3])) {
		if (p.specialAmount >= 0 && p.specialAmount <= 24 && !p.usingSpecial) {
			p.sendFrame126("S P E C I A L  A T T A C K", 12335);
			p.fsBar(0, 0, 12325);
			p.fsBar(0, 0, 12326);
			p.fsBar(0, 0, 12327);
			p.fsBar(0, 0, 12328);
			p.fsBar(0, 0, 12329);
			p.fsBar(0, 0, 12330);
			p.fsBar(0, 0, 12331);
			p.fsBar(0, 0, 12332);
			p.fsBar(0, 0, 12333);
			p.fsBar(0, 0, 12334);
		}
		if (p.specialAmount >= 0 && p.specialAmount <= 24 && p.usingSpecial) {
			p.sendFrame126("@yel@S P E C I A L  A T T A C K", 12335);
			p.fsBar(0, 0, 12325);
			p.fsBar(0, 0, 12326);
			p.fsBar(0, 0, 12327);
			p.fsBar(0, 0, 12328);
			p.fsBar(0, 0, 12329);
			p.fsBar(0, 0, 12330);
			p.fsBar(0, 0, 12331);
			p.fsBar(0, 0, 12332);
			p.fsBar(0, 0, 12333);
			p.fsBar(0, 0, 12334);
		}
		if (p.specialAmount >= 25 && p.specialAmount <= 49 && !p.usingSpecial) {
			p.sendFrame126("@bla@S P E @bla@C I A L  A T T A C K", 12335);
			p.fsBar(500, 0, 12325);
			p.fsBar(500, 0, 12326);
			p.fsBar(500, 0, 12327);
			p.fsBar(0, 0, 12328);
			p.fsBar(0, 0, 12329);
			p.fsBar(0, 0, 12330);
			p.fsBar(0, 0, 12331);
			p.fsBar(0, 0, 12332);
			p.fsBar(0, 0, 12333);
			p.fsBar(0, 0, 12334);
		}
		if (p.specialAmount >= 50 && p.specialAmount <= 74 && !p.usingSpecial) {
			p.sendFrame126("@bla@S P E C I A L@bla@  A T T A C K", 12335);
			p.fsBar(500, 0, 12325);
			p.fsBar(500, 0, 12326);
			p.fsBar(500, 0, 12327);
			p.fsBar(500, 0, 12328);
			p.fsBar(500, 0, 12329);
			p.fsBar(0, 0, 12330);
			p.fsBar(0, 0, 12331);
			p.fsBar(0, 0, 12332);
			p.fsBar(0, 0, 12333);
			p.fsBar(0, 0, 12334);
		}
		if (p.specialAmount >= 75 && p.specialAmount <= 99 && !p.usingSpecial) {
			p.sendFrame126("@bla@S P E C I A L  A T T A @bla@C K", 12335);
			p.fsBar(500, 0, 12325);
			p.fsBar(500, 0, 12326);
			p.fsBar(500, 0, 12327);
			p.fsBar(500, 0, 12328);
			p.fsBar(500, 0, 12329);
			p.fsBar(500, 0, 12330);
			p.fsBar(500, 0, 12331);
			p.fsBar(500, 0, 12332);
			p.fsBar(0, 0, 12333);
			p.fsBar(0, 0, 12334);
		}
		if (p.specialAmount >= 100 && !p.usingSpecial) {
			p.sendFrame126("@bla@S P E C I A L  A T T A C K", 12335);
			p.fsBar(500, 0, 12325);
			p.fsBar(500, 0, 12326);
			p.fsBar(500, 0, 12327);
			p.fsBar(500, 0, 12328);
			p.fsBar(500, 0, 12329);
			p.fsBar(500, 0, 12330);
			p.fsBar(500, 0, 12331);
			p.fsBar(500, 0, 12332);
			p.fsBar(500, 0, 12333);
			p.fsBar(500, 0, 12334);
		}
		if (p.specialAmount >= 25 && p.specialAmount <= 49 && p.usingSpecial) {
			p.sendFrame126("@yel@S P E @bla@C I A L  A T T A C K", 12335);
			p.fsBar(500, 0, 12325);
			p.fsBar(500, 0, 12326);
			p.fsBar(500, 0, 12327);
			p.fsBar(0, 0, 12328);
			p.fsBar(0, 0, 12329);
			p.fsBar(0, 0, 12330);
			p.fsBar(0, 0, 12331);
			p.fsBar(0, 0, 12332);
			p.fsBar(0, 0, 12333);
			p.fsBar(0, 0, 12334);
		}
		if (p.specialAmount >= 50 && p.specialAmount <= 74 && p.usingSpecial) {
			p.sendFrame126("@yel@S P E C I A L@bla@  A T T A C K", 12335);
			p.fsBar(500, 0, 12325);
			p.fsBar(500, 0, 12326);
			p.fsBar(500, 0, 12327);
			p.fsBar(500, 0, 12328);
			p.fsBar(500, 0, 12329);
			p.fsBar(0, 0, 12330);
			p.fsBar(0, 0, 12331);
			p.fsBar(0, 0, 12332);
			p.fsBar(0, 0, 12333);
			p.fsBar(0, 0, 12334);
		}
		if (p.specialAmount >= 75 && p.specialAmount <= 99 && p.usingSpecial) {
			p.sendFrame126("@yel@S P E C I A L  A T T A @bla@C K", 12335);
			p.fsBar(500, 0, 12325);
			p.fsBar(500, 0, 12326);
			p.fsBar(500, 0, 12327);
			p.fsBar(500, 0, 12328);
			p.fsBar(500, 0, 12329);
			p.fsBar(500, 0, 12330);
			p.fsBar(500, 0, 12331);
			p.fsBar(500, 0, 12332);
			p.fsBar(0, 0, 12333);
			p.fsBar(0, 0, 12334);
		}
		if (p.specialAmount >= 100 && p.usingSpecial) {
			p.sendFrame126("@yel@S P E C I A L  A T T A C K", 12335);
			p.fsBar(500, 0, 12325);
			p.fsBar(500, 0, 12326);
			p.fsBar(500, 0, 12327);
			p.fsBar(500, 0, 12328);
			p.fsBar(500, 0, 12329);
			p.fsBar(500, 0, 12330);
			p.fsBar(500, 0, 12331);
			p.fsBar(500, 0, 12332);
			p.fsBar(500, 0, 12333);
			p.fsBar(500, 0, 12334);
		}
	    }
	}

	public void specialAttacks2() {
	    if (p.isSpecWeapon(p.playerEquipment[3])) {
		if (p.specialAmount >= 0 && p.specialAmount <= 24 && !p.usingSpecial) {
			p.sendFrame126("S P E C I A L  A T T A C K", 7586);
			p.fsBar(0, 0, 7576);
			p.fsBar(0, 0, 7577);
			p.fsBar(0, 0, 7578);
			p.fsBar(0, 0, 7579);
			p.fsBar(0, 0, 7580);
			p.fsBar(0, 0, 7581);
			p.fsBar(0, 0, 7582);
			p.fsBar(0, 0, 7583);
			p.fsBar(0, 0, 7584);
			p.fsBar(0, 0, 7585);
		}
		if (p.specialAmount >= 0 && p.specialAmount <= 24 && p.usingSpecial) {
			p.sendFrame126("@yel@S P E C I A L  A T T A C K", 7586);
			p.fsBar(0, 0, 7576);
			p.fsBar(0, 0, 7577);
			p.fsBar(0, 0, 7578);
			p.fsBar(0, 0, 7579);
			p.fsBar(0, 0, 7580);
			p.fsBar(0, 0, 7581);
			p.fsBar(0, 0, 7582);
			p.fsBar(0, 0, 7583);
			p.fsBar(0, 0, 7584);
			p.fsBar(0, 0, 7585);
		}
		if (p.specialAmount >= 25 && p.specialAmount <= 49 && !p.usingSpecial) {
			p.sendFrame126("@bla@S P E @bla@C I A L  A T T A C K", 7586);
			p.fsBar(500, 0, 7576);
			p.fsBar(500, 0, 7577);
			p.fsBar(500, 0, 7578);
			p.fsBar(0, 0, 7579);
			p.fsBar(0, 0, 7580);
			p.fsBar(0, 0, 7581);
			p.fsBar(0, 0, 7582);
			p.fsBar(0, 0, 7583);
			p.fsBar(0, 0, 7584);
			p.fsBar(0, 0, 7585);
		}
		if (p.specialAmount >= 50 && p.specialAmount <= 74 && !p.usingSpecial) {
			p.sendFrame126("@bla@S P E C I A L@bla@  A T T A C K", 7586);
			p.fsBar(500, 0, 7576);
			p.fsBar(500, 0, 7577);
			p.fsBar(500, 0, 7578);
			p.fsBar(500, 0, 7579);
			p.fsBar(500, 0, 7580);
			p.fsBar(0, 0, 7581);
			p.fsBar(0, 0, 7582);
			p.fsBar(0, 0, 7583);
			p.fsBar(0, 0, 7584);
			p.fsBar(0, 0, 7585);
		}
		if (p.specialAmount >= 75 && p.specialAmount <= 99 && !p.usingSpecial) {
			p.sendFrame126("@bla@S P E C I A L  A T T A @bla@C K", 7586);
			p.fsBar(500, 0, 7576);
			p.fsBar(500, 0, 7577);
			p.fsBar(500, 0, 7578);
			p.fsBar(500, 0, 7579);
			p.fsBar(500, 0, 7580);
			p.fsBar(500, 0, 7581);
			p.fsBar(500, 0, 7582);
			p.fsBar(500, 0, 7583);
			p.fsBar(0, 0, 7584);
			p.fsBar(0, 0, 7585);
		}
		if (p.specialAmount >= 100 && !p.usingSpecial) {
			p.sendFrame126("@bla@S P E C I A L  A T T A C K", 7586);
			p.fsBar(500, 0, 7576);
			p.fsBar(500, 0, 7577);
			p.fsBar(500, 0, 7578);
			p.fsBar(500, 0, 7579);
			p.fsBar(500, 0, 7580);
			p.fsBar(500, 0, 7581);
			p.fsBar(500, 0, 7582);
			p.fsBar(500, 0, 7583);
			p.fsBar(500, 0, 7584);
			p.fsBar(500, 0, 7585);
		}
		if (p.specialAmount >= 25 && p.specialAmount <= 49 && p.usingSpecial) {
			p.sendFrame126("@yel@S P E @bla@C I A L  A T T A C K", 7586);
			p.fsBar(500, 0, 7576);
			p.fsBar(500, 0, 7577);
			p.fsBar(500, 0, 7578);
			p.fsBar(0, 0, 7579);
			p.fsBar(0, 0, 7580);
			p.fsBar(0, 0, 7581);
			p.fsBar(0, 0, 7582);
			p.fsBar(0, 0, 7583);
			p.fsBar(0, 0, 7584);
			p.fsBar(0, 0, 7585);
		}
		if (p.specialAmount >= 50 && p.specialAmount <= 74 && p.usingSpecial) {
			p.sendFrame126("@yel@S P E C I A L@bla@  A T T A C K", 7586);
			p.fsBar(500, 0, 7576);
			p.fsBar(500, 0, 7577);
			p.fsBar(500, 0, 7578);
			p.fsBar(500, 0, 7579);
			p.fsBar(500, 0, 7580);
			p.fsBar(0, 0, 7581);
			p.fsBar(0, 0, 7582);
			p.fsBar(0, 0, 7583);
			p.fsBar(0, 0, 7584);
			p.fsBar(0, 0, 7585);
		}
		if (p.specialAmount >= 75 && p.specialAmount <= 99 && p.usingSpecial) {
			p.sendFrame126("@yel@S P E C I A L  A T T A @bla@C K", 7586);
			p.fsBar(500, 0, 7576);
			p.fsBar(500, 0, 7577);
			p.fsBar(500, 0, 7578);
			p.fsBar(500, 0, 7579);
			p.fsBar(500, 0, 7580);
			p.fsBar(500, 0, 7581);
			p.fsBar(500, 0, 7582);
			p.fsBar(500, 0, 7583);
			p.fsBar(0, 0, 7584);
			p.fsBar(0, 0, 7585);
		}
		if (p.specialAmount >= 100 && p.usingSpecial) {
			p.sendFrame126("@yel@S P E C I A L  A T T A C K", 7586);
			p.fsBar(500, 0, 7576);
			p.fsBar(500, 0, 7577);
			p.fsBar(500, 0, 7578);
			p.fsBar(500, 0, 7579);
			p.fsBar(500, 0, 7580);
			p.fsBar(500, 0, 7581);
			p.fsBar(500, 0, 7582);
			p.fsBar(500, 0, 7583);
			p.fsBar(500, 0, 7584);
			p.fsBar(500, 0, 7585);
		}
	    }
	}

	public void specialAttacks3() {
	    if (p.isSpecWeapon(p.playerEquipment[3])) {
		if (p.specialAmount >= 0 && p.specialAmount <= 24 && !p.usingSpecial) {
			p.sendFrame126("S P E C I A L  A T T A C K", 7611);
			p.fsBar(0, 0, 7601);
			p.fsBar(0, 0, 7602);
			p.fsBar(0, 0, 7603);
			p.fsBar(0, 0, 7604);
			p.fsBar(0, 0, 7605);
			p.fsBar(0, 0, 7606);
			p.fsBar(0, 0, 7607);
			p.fsBar(0, 0, 7608);
			p.fsBar(0, 0, 7609);
			p.fsBar(0, 0, 7610);
		}
		if (p.specialAmount >= 0 && p.specialAmount <= 24 && p.usingSpecial) {
			p.sendFrame126("@yel@S P E C I A L  A T T A C K", 7611);
			p.fsBar(0, 0, 7601);
			p.fsBar(0, 0, 7602);
			p.fsBar(0, 0, 7603);
			p.fsBar(0, 0, 7604);
			p.fsBar(0, 0, 7605);
			p.fsBar(0, 0, 7606);
			p.fsBar(0, 0, 7607);
			p.fsBar(0, 0, 7608);
			p.fsBar(0, 0, 7609);
			p.fsBar(0, 0, 7610);
		}
		if (p.specialAmount >= 25 && p.specialAmount <= 49 && !p.usingSpecial) {
			p.sendFrame126("@bla@S P E @bla@C I A L  A T T A C K", 7611);
			p.fsBar(500, 0, 7601);
			p.fsBar(500, 0, 7602);
			p.fsBar(500, 0, 7603);
			p.fsBar(0, 0, 7604);
			p.fsBar(0, 0, 7605);
			p.fsBar(0, 0, 7606);
			p.fsBar(0, 0, 7607);
			p.fsBar(0, 0, 7608);
			p.fsBar(0, 0, 7609);
			p.fsBar(0, 0, 7610);
		}
		if (p.specialAmount >= 50 && p.specialAmount <= 74 && !p.usingSpecial) {
			p.sendFrame126("@bla@S P E C I A L@bla@  A T T A C K", 7611);
			p.fsBar(500, 0, 7601);
			p.fsBar(500, 0, 7602);
			p.fsBar(500, 0, 7603);
			p.fsBar(500, 0, 7604);
			p.fsBar(500, 0, 7605);
			p.fsBar(0, 0, 7606);
			p.fsBar(0, 0, 7607);
			p.fsBar(0, 0, 7608);
			p.fsBar(0, 0, 7609);
			p.fsBar(0, 0, 7610);
		}
		if (p.specialAmount >= 75 && p.specialAmount <= 99 && !p.usingSpecial) {
			p.sendFrame126("@bla@S P E C I A L  A T T A @bla@C K", 7611);
			p.fsBar(500, 0, 7601);
			p.fsBar(500, 0, 7602);
			p.fsBar(500, 0, 7603);
			p.fsBar(500, 0, 7604);
			p.fsBar(500, 0, 7605);
			p.fsBar(500, 0, 7606);
			p.fsBar(500, 0, 7607);
			p.fsBar(500, 0, 7608);
			p.fsBar(0, 0, 7609);
			p.fsBar(0, 0, 7610);
		}
		if (p.specialAmount >= 100 && !p.usingSpecial) {
			p.sendFrame126("@bla@S P E C I A L  A T T A C K", 7611);
			p.fsBar(500, 0, 7601);
			p.fsBar(500, 0, 7602);
			p.fsBar(500, 0, 7603);
			p.fsBar(500, 0, 7604);
			p.fsBar(500, 0, 7605);
			p.fsBar(500, 0, 7606);
			p.fsBar(500, 0, 7607);
			p.fsBar(500, 0, 7608);
			p.fsBar(500, 0, 7609);
			p.fsBar(500, 0, 7610);
		}
		if (p.specialAmount >= 25 && p.specialAmount <= 49 && p.usingSpecial) {
			p.sendFrame126("@yel@S P E @bla@C I A L  A T T A C K", 7611);
			p.fsBar(500, 0, 7601);
			p.fsBar(500, 0, 7602);
			p.fsBar(500, 0, 7603);
			p.fsBar(0, 0, 7604);
			p.fsBar(0, 0, 7605);
			p.fsBar(0, 0, 7606);
			p.fsBar(0, 0, 7607);
			p.fsBar(0, 0, 7608);
			p.fsBar(0, 0, 7609);
			p.fsBar(0, 0, 7610);
		}
		if (p.specialAmount >= 50 && p.specialAmount <= 74 && p.usingSpecial) {
			p.sendFrame126("@yel@S P E C I A L@bla@  A T T A C K", 7611);
			p.fsBar(500, 0, 7601);
			p.fsBar(500, 0, 7602);
			p.fsBar(500, 0, 7603);
			p.fsBar(500, 0, 7604);
			p.fsBar(500, 0, 7605);
			p.fsBar(0, 0, 7606);
			p.fsBar(0, 0, 7607);
			p.fsBar(0, 0, 7608);
			p.fsBar(0, 0, 7609);
			p.fsBar(0, 0, 7610);
		}
		if (p.specialAmount >= 75 && p.specialAmount <= 99 && p.usingSpecial) {
			p.sendFrame126("@yel@S P E C I A L  A T T A @bla@C K", 7611);
			p.fsBar(500, 0, 7601);
			p.fsBar(500, 0, 7602);
			p.fsBar(500, 0, 7603);
			p.fsBar(500, 0, 7604);
			p.fsBar(500, 0, 7605);
			p.fsBar(500, 0, 7606);
			p.fsBar(500, 0, 7607);
			p.fsBar(500, 0, 7608);
			p.fsBar(0, 0, 7609);
			p.fsBar(0, 0, 7610);
		}
		if (p.specialAmount >= 100 && p.usingSpecial) {
			p.sendFrame126("@yel@S P E C I A L  A T T A C K", 7611);
			p.fsBar(500, 0, 7601);
			p.fsBar(500, 0, 7602);
			p.fsBar(500, 0, 7603);
			p.fsBar(500, 0, 7604);
			p.fsBar(500, 0, 7605);
			p.fsBar(500, 0, 7606);
			p.fsBar(500, 0, 7607);
			p.fsBar(500, 0, 7608);
			p.fsBar(500, 0, 7609);
			p.fsBar(500, 0, 7610);
		}
	    }
	}

	public void specialAttacks4() {
	    if (p.isSpecWeapon(p.playerEquipment[3])) {
		if (p.specialAmount >= 0 && p.specialAmount <= 24 && !p.usingSpecial) {
			p.sendFrame126("S P E C I A L  A T T A C K", 7561);
			p.fsBar(0, 0, 7551);
			p.fsBar(0, 0, 7552);
			p.fsBar(0, 0, 7553);
			p.fsBar(0, 0, 7554);
			p.fsBar(0, 0, 7555);
			p.fsBar(0, 0, 7556);
			p.fsBar(0, 0, 7557);
			p.fsBar(0, 0, 7558);
			p.fsBar(0, 0, 7559);
			p.fsBar(0, 0, 7560);
		}
		if (p.specialAmount >= 0 && p.specialAmount <= 24 && p.usingSpecial) {
			p.sendFrame126("@yel@S P E C I A L  A T T A C K", 7561);
			p.fsBar(0, 0, 7551);
			p.fsBar(0, 0, 7552);
			p.fsBar(0, 0, 7553);
			p.fsBar(0, 0, 7554);
			p.fsBar(0, 0, 7555);
			p.fsBar(0, 0, 7556);
			p.fsBar(0, 0, 7557);
			p.fsBar(0, 0, 7558);
			p.fsBar(0, 0, 7559);
			p.fsBar(0, 0, 7560);
		}
		if (p.specialAmount >= 25 && p.specialAmount <= 49 && !p.usingSpecial) {
			p.sendFrame126("@bla@S P E @bla@C I A L  A T T A C K", 7561);
			p.fsBar(500, 0, 7551);
			p.fsBar(500, 0, 7552);
			p.fsBar(500, 0, 7553);
			p.fsBar(0, 0, 7554);
			p.fsBar(0, 0, 7555);
			p.fsBar(0, 0, 7556);
			p.fsBar(0, 0, 7557);
			p.fsBar(0, 0, 7558);
			p.fsBar(0, 0, 7559);
			p.fsBar(0, 0, 7560);
		}
		if (p.specialAmount >= 50 && p.specialAmount <= 74 && !p.usingSpecial) {
			p.sendFrame126("@bla@S P E C I A L@bla@  A T T A C K", 7561);
			p.fsBar(500, 0, 7551);
			p.fsBar(500, 0, 7552);
			p.fsBar(500, 0, 7553);
			p.fsBar(500, 0, 7554);
			p.fsBar(500, 0, 7555);
			p.fsBar(0, 0, 7556);
			p.fsBar(0, 0, 7557);
			p.fsBar(0, 0, 7558);
			p.fsBar(0, 0, 7559);
			p.fsBar(0, 0, 7560);
		}
		if (p.specialAmount >= 75 && p.specialAmount <= 99 && !p.usingSpecial) {
			p.sendFrame126("@bla@S P E C I A L  A T T A @bla@C K", 7561);
			p.fsBar(500, 0, 7551);
			p.fsBar(500, 0, 7552);
			p.fsBar(500, 0, 7553);
			p.fsBar(500, 0, 7554);
			p.fsBar(500, 0, 7555);
			p.fsBar(500, 0, 7556);
			p.fsBar(500, 0, 7557);
			p.fsBar(500, 0, 7558);
			p.fsBar(0, 0, 7559);
			p.fsBar(0, 0, 7560);
		}
		if (p.specialAmount >= 100 && !p.usingSpecial) {
			p.sendFrame126("@bla@S P E C I A L  A T T A C K", 7561);
			p.fsBar(500, 0, 7551);
			p.fsBar(500, 0, 7552);
			p.fsBar(500, 0, 7553);
			p.fsBar(500, 0, 7554);
			p.fsBar(500, 0, 7555);
			p.fsBar(500, 0, 7556);
			p.fsBar(500, 0, 7557);
			p.fsBar(500, 0, 7558);
			p.fsBar(500, 0, 7559);
			p.fsBar(500, 0, 7560);
		}
		if (p.specialAmount >= 25 && p.specialAmount <= 49 && p.usingSpecial) {
			p.sendFrame126("@yel@S P E @bla@C I A L  A T T A C K", 7561);
			p.fsBar(500, 0, 7551);
			p.fsBar(500, 0, 7552);
			p.fsBar(500, 0, 7553);
			p.fsBar(0, 0, 7554);
			p.fsBar(0, 0, 7555);
			p.fsBar(0, 0, 7556);
			p.fsBar(0, 0, 7557);
			p.fsBar(0, 0, 7558);
			p.fsBar(0, 0, 7559);
			p.fsBar(0, 0, 7560);
		}
		if (p.specialAmount >= 50 && p.specialAmount <= 74 && p.usingSpecial) {
			p.sendFrame126("@yel@S P E C I A L@bla@  A T T A C K", 7561);
			p.fsBar(500, 0, 7551);
			p.fsBar(500, 0, 7552);
			p.fsBar(500, 0, 7553);
			p.fsBar(500, 0, 7554);
			p.fsBar(500, 0, 7555);
			p.fsBar(0, 0, 7556);
			p.fsBar(0, 0, 7557);
			p.fsBar(0, 0, 7558);
			p.fsBar(0, 0, 7559);
			p.fsBar(0, 0, 7560);
		}
		if (p.specialAmount >= 75 && p.specialAmount <= 99 && p.usingSpecial) {
			p.sendFrame126("@yel@S P E C I A L  A T T A @bla@C K", 7561);
			p.fsBar(500, 0, 7551);
			p.fsBar(500, 0, 7552);
			p.fsBar(500, 0, 7553);
			p.fsBar(500, 0, 7554);
			p.fsBar(500, 0, 7555);
			p.fsBar(500, 0, 7556);
			p.fsBar(500, 0, 7557);
			p.fsBar(500, 0, 7558);
			p.fsBar(0, 0, 7559);
			p.fsBar(0, 0, 7560);
		}
		if (p.specialAmount >= 100 && p.usingSpecial) {
			p.sendFrame126("@yel@S P E C I A L  A T T A C K", 7561);
			p.fsBar(500, 0, 7551);
			p.fsBar(500, 0, 7552);
			p.fsBar(500, 0, 7553);
			p.fsBar(500, 0, 7554);
			p.fsBar(500, 0, 7555);
			p.fsBar(500, 0, 7556);
			p.fsBar(500, 0, 7557);
			p.fsBar(500, 0, 7558);
			p.fsBar(500, 0, 7559);
			p.fsBar(500, 0, 7560);
		}
	    }
	}

	public void specialAttacks5() {
	    if (p.isSpecWeapon(p.playerEquipment[3])) {
		if (p.specialAmount >= 0 && p.specialAmount <= 24 && !p.usingSpecial) {
			p.sendFrame126("S P E C I A L  A T T A C K", 8505);
			p.fsBar(0, 0, 8495);
			p.fsBar(0, 0, 8496);
			p.fsBar(0, 0, 8497);
			p.fsBar(0, 0, 8498);
			p.fsBar(0, 0, 8499);
			p.fsBar(0, 0, 8500);
			p.fsBar(0, 0, 8501);
			p.fsBar(0, 0, 8502);
			p.fsBar(0, 0, 8503);
			p.fsBar(0, 0, 8504);
		}
		if (p.specialAmount >= 0 && p.specialAmount <= 24 && p.usingSpecial) {
			p.sendFrame126("@yel@S P E C I A L  A T T A C K", 8505);
			p.fsBar(0, 0, 8495);
			p.fsBar(0, 0, 8496);
			p.fsBar(0, 0, 8497);
			p.fsBar(0, 0, 8498);
			p.fsBar(0, 0, 8499);
			p.fsBar(0, 0, 8500);
			p.fsBar(0, 0, 8501);
			p.fsBar(0, 0, 8502);
			p.fsBar(0, 0, 8503);
			p.fsBar(0, 0, 8504);
		}
		if (p.specialAmount >= 25 && p.specialAmount <= 49 && !p.usingSpecial) {
			p.sendFrame126("@bla@S P E @bla@C I A L  A T T A C K", 8505);
			p.fsBar(500, 0, 8495);
			p.fsBar(500, 0, 8496);
			p.fsBar(500, 0, 8497);
			p.fsBar(0, 0, 8498);
			p.fsBar(0, 0, 8499);
			p.fsBar(0, 0, 8500);
			p.fsBar(0, 0, 8501);
			p.fsBar(0, 0, 8502);
			p.fsBar(0, 0, 8503);
			p.fsBar(0, 0, 8504);
		}
		if (p.specialAmount >= 50 && p.specialAmount <= 74 && !p.usingSpecial) {
			p.sendFrame126("@bla@S P E C I A L@bla@  A T T A C K", 8505);
			p.fsBar(500, 0, 8495);
			p.fsBar(500, 0, 8496);
			p.fsBar(500, 0, 8497);
			p.fsBar(500, 0, 8498);
			p.fsBar(500, 0, 8499);
			p.fsBar(0, 0, 8500);
			p.fsBar(0, 0, 8501);
			p.fsBar(0, 0, 8502);
			p.fsBar(0, 0, 8503);
			p.fsBar(0, 0, 8504);
		}
		if (p.specialAmount >= 75 && p.specialAmount <= 99 && !p.usingSpecial) {
			p.sendFrame126("@bla@S P E C I A L  A T T A @bla@C K", 8505);
			p.fsBar(500, 0, 8495);
			p.fsBar(500, 0, 8496);
			p.fsBar(500, 0, 8497);
			p.fsBar(500, 0, 8498);
			p.fsBar(500, 0, 8499);
			p.fsBar(500, 0, 8500);
			p.fsBar(500, 0, 8501);
			p.fsBar(500, 0, 8502);
			p.fsBar(0, 0, 8503);
			p.fsBar(0, 0, 8504);
		}
		if (p.specialAmount >= 100 && !p.usingSpecial) {
			p.sendFrame126("@bla@S P E C I A L  A T T A C K", 8505);
			p.fsBar(500, 0, 8495);
			p.fsBar(500, 0, 8496);
			p.fsBar(500, 0, 8497);
			p.fsBar(500, 0, 8498);
			p.fsBar(500, 0, 8499);
			p.fsBar(500, 0, 8500);
			p.fsBar(500, 0, 8501);
			p.fsBar(500, 0, 8502);
			p.fsBar(500, 0, 8503);
			p.fsBar(500, 0, 8504);
		}
		if (p.specialAmount >= 25 && p.specialAmount <= 49 && p.usingSpecial) {
			p.sendFrame126("@yel@S P E @bla@C I A L  A T T A C K", 8505);
			p.fsBar(500, 0, 8495);
			p.fsBar(500, 0, 8496);
			p.fsBar(500, 0, 8497);
			p.fsBar(0, 0, 8498);
			p.fsBar(0, 0, 8499);
			p.fsBar(0, 0, 8500);
			p.fsBar(0, 0, 8501);
			p.fsBar(0, 0, 8502);
			p.fsBar(0, 0, 8503);
			p.fsBar(0, 0, 8504);
		}
		if (p.specialAmount >= 50 && p.specialAmount <= 74 && p.usingSpecial) {
			p.sendFrame126("@yel@S P E C I A L@bla@  A T T A C K", 8505);
			p.fsBar(500, 0, 8495);
			p.fsBar(500, 0, 8496);
			p.fsBar(500, 0, 8497);
			p.fsBar(500, 0, 8498);
			p.fsBar(500, 0, 8499);
			p.fsBar(0, 0, 8500);
			p.fsBar(0, 0, 8501);
			p.fsBar(0, 0, 8502);
			p.fsBar(0, 0, 8503);
			p.fsBar(0, 0, 8504);
		}
		if (p.specialAmount >= 75 && p.specialAmount <= 99 && p.usingSpecial) {
			p.sendFrame126("@yel@S P E C I A L  A T T A @bla@C K", 8505);
			p.fsBar(500, 0, 8495);
			p.fsBar(500, 0, 8496);
			p.fsBar(500, 0, 8497);
			p.fsBar(500, 0, 8498);
			p.fsBar(500, 0, 8499);
			p.fsBar(500, 0, 8500);
			p.fsBar(500, 0, 8501);
			p.fsBar(500, 0, 8502);
			p.fsBar(0, 0, 8503);
			p.fsBar(0, 0, 8504);
		}
		if (p.specialAmount >= 100 && p.usingSpecial) {
			p.sendFrame126("@yel@S P E C I A L  A T T A C K", 8505);
			p.fsBar(500, 0, 8495);
			p.fsBar(500, 0, 8496);
			p.fsBar(500, 0, 8497);
			p.fsBar(500, 0, 8498);
			p.fsBar(500, 0, 8499);
			p.fsBar(500, 0, 8500);
			p.fsBar(500, 0, 8501);
			p.fsBar(500, 0, 8502);
			p.fsBar(500, 0, 8503);
			p.fsBar(500, 0, 8504);
		}
	    }
	}

	public void specialAttacks6() {
	    if (p.isSpecWeapon(p.playerEquipment[3])) {
		if (p.specialAmount >= 0 && p.specialAmount <= 24 && !p.usingSpecial) {
			p.sendFrame126("S P E C I A L  A T T A C K", 7511);
			p.fsBar(0, 0, 7501);
			p.fsBar(0, 0, 7502);
			p.fsBar(0, 0, 7503);
			p.fsBar(0, 0, 7504);
			p.fsBar(0, 0, 7505);
			p.fsBar(0, 0, 7506);
			p.fsBar(0, 0, 7507);
			p.fsBar(0, 0, 7508);
			p.fsBar(0, 0, 7509);
			p.fsBar(0, 0, 7510);
		}
		if (p.specialAmount >= 0 && p.specialAmount <= 24 && p.usingSpecial) {
			p.sendFrame126("@yel@S P E C I A L  A T T A C K", 7511);
			p.fsBar(0, 0, 7501);
			p.fsBar(0, 0, 7502);
			p.fsBar(0, 0, 7503);
			p.fsBar(0, 0, 7504);
			p.fsBar(0, 0, 7505);
			p.fsBar(0, 0, 7506);
			p.fsBar(0, 0, 7507);
			p.fsBar(0, 0, 7508);
			p.fsBar(0, 0, 7509);
			p.fsBar(0, 0, 7510);
		}
		if (p.specialAmount >= 25 && p.specialAmount <= 49 && !p.usingSpecial) {
			p.sendFrame126("@bla@S P E @bla@C I A L  A T T A C K", 7511);
			p.fsBar(500, 0, 7501);
			p.fsBar(500, 0, 7502);
			p.fsBar(500, 0, 7503);
			p.fsBar(0, 0, 7504);
			p.fsBar(0, 0, 7505);
			p.fsBar(0, 0, 7506);
			p.fsBar(0, 0, 7507);
			p.fsBar(0, 0, 7508);
			p.fsBar(0, 0, 7509);
			p.fsBar(0, 0, 7510);
		}
		if (p.specialAmount >= 50 && p.specialAmount <= 74 && !p.usingSpecial) {
			p.sendFrame126("@bla@S P E C I A L@bla@  A T T A C K", 7511);
			p.fsBar(500, 0, 7501);
			p.fsBar(500, 0, 7502);
			p.fsBar(500, 0, 7503);
			p.fsBar(500, 0, 7504);
			p.fsBar(500, 0, 7505);
			p.fsBar(0, 0, 7506);
			p.fsBar(0, 0, 7507);
			p.fsBar(0, 0, 7508);
			p.fsBar(0, 0, 7509);
			p.fsBar(0, 0, 7510);
		}
		if (p.specialAmount >= 75 && p.specialAmount <= 99 && !p.usingSpecial) {
			p.sendFrame126("@bla@S P E C I A L  A T T A @bla@C K", 7511);
			p.fsBar(500, 0, 7501);
			p.fsBar(500, 0, 7502);
			p.fsBar(500, 0, 7503);
			p.fsBar(500, 0, 7504);
			p.fsBar(500, 0, 7505);
			p.fsBar(500, 0, 7506);
			p.fsBar(500, 0, 7507);
			p.fsBar(500, 0, 7508);
			p.fsBar(0, 0, 7509);
			p.fsBar(0, 0, 7510);
		}
		if (p.specialAmount >= 100 && !p.usingSpecial) {
			p.sendFrame126("@bla@S P E C I A L  A T T A C K", 7511);
			p.fsBar(500, 0, 7501);
			p.fsBar(500, 0, 7502);
			p.fsBar(500, 0, 7503);
			p.fsBar(500, 0, 7504);
			p.fsBar(500, 0, 7505);
			p.fsBar(500, 0, 7506);
			p.fsBar(500, 0, 7507);
			p.fsBar(500, 0, 7508);
			p.fsBar(500, 0, 7509);
			p.fsBar(500, 0, 7510);
		}
		if (p.specialAmount >= 25 && p.specialAmount <= 49 && p.usingSpecial) {
			p.sendFrame126("@yel@S P E @bla@C I A L  A T T A C K", 7511);
			p.fsBar(500, 0, 7501);
			p.fsBar(500, 0, 7502);
			p.fsBar(500, 0, 7503);
			p.fsBar(0, 0, 7504);
			p.fsBar(0, 0, 7505);
			p.fsBar(0, 0, 7506);
			p.fsBar(0, 0, 7507);
			p.fsBar(0, 0, 7508);
			p.fsBar(0, 0, 7509);
			p.fsBar(0, 0, 7510);
		}
		if (p.specialAmount >= 50 && p.specialAmount <= 74 && p.usingSpecial) {
			p.sendFrame126("@yel@S P E C I A L@bla@  A T T A C K", 7511);
			p.fsBar(500, 0, 7501);
			p.fsBar(500, 0, 7502);
			p.fsBar(500, 0, 7503);
			p.fsBar(500, 0, 7504);
			p.fsBar(500, 0, 7505);
			p.fsBar(0, 0, 7506);
			p.fsBar(0, 0, 7507);
			p.fsBar(0, 0, 7508);
			p.fsBar(0, 0, 7509);
			p.fsBar(0, 0, 7510);
		}
		if (p.specialAmount >= 75 && p.specialAmount <= 99 && p.usingSpecial) {
			p.sendFrame126("@yel@S P E C I A L  A T T A @bla@C K", 7511);
			p.fsBar(500, 0, 7501);
			p.fsBar(500, 0, 7502);
			p.fsBar(500, 0, 7503);
			p.fsBar(500, 0, 7504);
			p.fsBar(500, 0, 7505);
			p.fsBar(500, 0, 7506);
			p.fsBar(500, 0, 7507);
			p.fsBar(500, 0, 7508);
			p.fsBar(0, 0, 7509);
			p.fsBar(0, 0, 7510);
		}
		if (p.specialAmount >= 100 && p.usingSpecial) {
			p.sendFrame126("@yel@S P E C I A L  A T T A C K", 7511);
			p.fsBar(500, 0, 7501);
			p.fsBar(500, 0, 7502);
			p.fsBar(500, 0, 7503);
			p.fsBar(500, 0, 7504);
			p.fsBar(500, 0, 7505);
			p.fsBar(500, 0, 7506);
			p.fsBar(500, 0, 7507);
			p.fsBar(500, 0, 7508);
			p.fsBar(500, 0, 7509);
			p.fsBar(500, 0, 7510);
		}
	    }
	}
	clientHandler p;
}
