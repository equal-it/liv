package liv;

import liv.Inhaltsstoff;

/**
 * Project: Liv - Lebensmittelinhaltverifizierer
 * 
 * class Inhaltsstoff
 * 
 * @author team equal-IT
 * @mail: team@equal-it.de
 * @version  00.00.02 2016/05/09
 */

public enum Inhaltsstoff {
	UNBEKANNT("0", "Unbekannter Inhaltsstoff"), LAKTOSE("1", "Laktose"), GLUTEN("2", "Gluten");

	
	/**
	 * @param code
	 * @param anzeigename
	 */
	
	private final String code;
	private final String anzeigename;

	private Inhaltsstoff(final String code, final String anzeigename) {
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

	/**
	 * Methode, welche den Inhaltsstoff zurück gibt
	 * 
	 * @param inhaltsstoff
	 * @param code
	 * @return inhaltsstoff
	 * @return UNBEKANNT
	 */
	public static Inhaltsstoff inhaltstoffFuerCode(final String code) {
		for (Inhaltsstoff inhaltsstoff : values()) {
			if (inhaltsstoff.code.equals(code)) {
				return inhaltsstoff;
			}
		}
		return UNBEKANNT;
	}
}
