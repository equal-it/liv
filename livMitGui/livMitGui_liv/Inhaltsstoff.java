package livMitGui_liv;

import livMitGui_liv.Inhaltsstoff;

public enum Inhaltsstoff {
	UNBEKANNT("0", "Unbekannter Inhaltsstoff"), LAKTOSE("1", "Laktose"), GLUTEN("2", "Gluten");

	private final String code;
	private final String anzeigename;

	private Inhaltsstoff(final String code, final String anzeigename) {
		this.code = code;
		this.anzeigename = anzeigename;
	}

	public String code() {
		return this.code;
	}

	public String anzeigename() {
		return this.anzeigename;
	}

	public static Inhaltsstoff inhaltstoffFuerCode(final String code) {
		for (Inhaltsstoff inhaltsstoff : values()) {
			if (inhaltsstoff.code.equals(code)) {
				return inhaltsstoff;
			}
		}
		return UNBEKANNT;
	}
}
