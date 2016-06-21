package ausgabe;

public enum FiltermenueEintrage {
	HAUPTMENU("5", "HAUPTMENU"), FILTERANZEIGE("4","FILTERANZEIGE");
	
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