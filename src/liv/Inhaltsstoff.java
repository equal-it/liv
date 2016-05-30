package liv;

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

	public static void main(String[] args) {
		System.out.println("\nWelchen Filter wollen Sie setzen?\n");
		for (Inhaltsstoff stoff : Inhaltsstoff.values()) {
			if (stoff != UNBEKANNT)
				System.out.println("Waehle " + stoff.code + " fuer " + stoff.anzeigename + ".");
		}
		System.out.println("\nOder mit 'H' zum Hauptmenue. \n");

		String antwort = "dfkfgsdl gjfkdlgfk xml jfio <lactose>no</lactose>  fhuiw 7879 hjfejk";
		String[] schritt1 = antwort.split("<lactose>");
		String[] schritt2 = schritt1[1].split("</lactose>");
		String ergebnis = schritt2[0];
		System.out.println("Antwort enthaelt Laktose: " + ergebnis);
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
