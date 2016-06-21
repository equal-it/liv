package ausgabe;

import ausgabe.HauptmenueEintraege;

public enum HauptmenueEintraege {
	FILTER("1", "Filter"), EAN("2", "EAN"), IMPRESSUM("3", "IMPRESSUM"), ENDE("4", "ENDE"), ;

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