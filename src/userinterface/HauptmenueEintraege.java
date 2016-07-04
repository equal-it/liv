package userinterface;

import userinterface.HauptmenueEintraege;

/**
 * Project: LIV - Lebensmittelinhaltsstoffverifizierer
 * 
 * class HauptmenueEintraege
 * 
 * @author team equal-IT 
 * @mail: team@equal-it.de
 * @version 00.00.10 2016/05/16
 */


public enum HauptmenueEintraege {
	FILTER("1", "FILTER"), EAN("2", "EAN"), IMPRESSUM("3", "IMPRESSUM"), ENDE("4", "ENDE"), ;

	private final String code;
	private final String anzeigename;

	private HauptmenueEintraege(final String code, final String anzeigename) {
		this.code = code;
		this.anzeigename = anzeigename;
	}

	/**
	 * @param code
	 * @return code
	 */
	public String code() {
		return this.code;
	}

	/**
	 * @param anzeigename
	 * @return anzeigename
	 */
	public String anzeigename() {
		return this.anzeigename;
	}
}