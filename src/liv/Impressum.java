package liv;

/**
 * Project: Liv - Lebensmittelinhaltsstoffverifizierer
 * 
 * class Impressum zeigt das Impressum
 * 
 * @author team equal-IT
 * @mail: team@equal-it.de
 * @version 1.0 2016/07/08
 */

public class Impressum {
	// Methode definieren, auf die zugegriffen werden kann
	// Texte erweitern!

	/**
	 * Methode, um das Impressum anzuzeigen
	 */
	public static void printImpressum() {
		System.out.println("\n--------------------------------------------");
		System.out.println("LIV - Die Smartphone-App,\n"
				+ "die Menschen mit Lebensmittelunvertraeglichkeiten\n"
				+ "unerwuenschte Inhaltsstoffe von Lebensmitteln\n"
				+ "auf einen Blick erfassen laesst.\n");

		System.out.println("LIV by equal-IT");
		System.out.println("www.equal-it.de");
		System.out.println("Version 1.0 - Juli 2016");

	}
}
