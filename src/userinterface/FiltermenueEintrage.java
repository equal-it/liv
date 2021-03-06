package userinterface;

/**
 * Project: LIV - Lebensmittelinhaltsstoffverifizierer
 * 
 * class FiltermenueEintrage enum
 * 
 * @author team equal-IT
 * @mail: team@equal-it.de
 * @version 1.0 2016/07/08
 */

public enum FiltermenueEintrage {
	HAUPTMENUE("5", "HAUPTMENU"), FILTERANZEIGE("4","FILTERANZEIGE");
	
	private final String code;
	private final String anzeigename;

	private FiltermenueEintrage(final String code, final String anzeigename) {
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