package liv;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import eingaben.Konsoleneingabe;

/**
 * Project: LIV - Lebensmittelinhaltverifizierer
 * 
 * class Filter zeigt die möglichen einzustellenden Filter und lässt diese
 * setzen oder entfernen
 * 
 * @author team equal-IT / felix, anne, mel
 * @mail team@equal-it.de
 * @version 00.00.10 2016/05/10
 *
 */

// Menue-Moeglichkeit einbauen, alle Filter anzeigen zu lassen!
// default-Filter ueberpruefen!
// um weiter Filter neben Laktose testen zu koennen, brauchen wir die Mocks!!

public class Filter {

	private static final String HAUPTMENU = "h";
	private static final String FILTERANZEIGE = "f";

	/**
	 * Methode, um die gesetzten Filter anzuzeigen
	 * 
	 * @param inhaltsstoffe
	 *            HashSet
	 * @param inhaltsstoff
	 *            zur Festlegung der jeweiligen Inhaltsstoffe
	 * @param auswahl
	 *            Menueauswahl per Konsoleneingabe
	 * @return inhaltsstoffe
	 */

	public static Set<Inhaltsstoff> setFilter() {

		Set<Inhaltsstoff> inhaltsstoffe = new HashSet<>();
		String auswahl = null;

		do {
			menuAusgeben();

			auswahl = Konsoleneingabe.leseKonsoleFuer(Arrays
					.asList(new String[] { "1", "2", "3", FILTERANZEIGE,
							HAUPTMENU }));
			if (auswahl != null) {
				if (auswahl.equals(FILTERANZEIGE)) {
					System.out.println("\nAktiv gesetzte Filter: \n");
					System.out.println(inhaltsstoffe.toString() + "\n\n");
				} else {
					Inhaltsstoff inhaltsstoff = Inhaltsstoff
							.inhaltstoffFuerCode(auswahl);
					switch (inhaltsstoff) {
					case LAKTOSE:
						setzeOderEntferneFilter(inhaltsstoffe, inhaltsstoff);
						break;
					case GLUTEN:
						setzeOderEntferneFilter(inhaltsstoffe, inhaltsstoff);
						break;
					case NUSS:
						setzeOderEntferneFilter(inhaltsstoffe, inhaltsstoff);
					case UNBEKANNT:
						break;
					}
				}
			}

		} while (!HAUPTMENU.equals(auswahl));

		return inhaltsstoffe;
	}

	/**
	 * Methode, um das Menue der Filterauswahl anzuzeigen
	 * 
	 * @param stoff
	 *            zur Auswahl des jeweiligen Inhaltsstoffs
	 */
	private static void menuAusgeben() {
		System.out
				.println("---------------------------------------------------------------------(Klasse Filter - menueAusgabe())");
		System.out.println("");
		System.out
				.println("Fuer welchen Inhaltsstoff moechtest du einen Filter setzen oder entfernen?");
		System.out.println("");
		System.out.println("Waehle...");
		for (Inhaltsstoff stoff : Inhaltsstoff.values()) {
			if (stoff != Inhaltsstoff.UNBEKANNT)
				System.out.println("... " + stoff.code() + " fuer "
						+ stoff.anzeigename() + ".");
		}
		System.out.println("\nWaehle  " + FILTERANZEIGE
				+ "  fuer die Anzeige der aktuell gesetzten Filter.");
		System.out.println("Waehle  " + HAUPTMENU
				+ "  um zum Hauptmenue zu gelangen. \n");
		System.out
				.println("---------------------------------------------------------------------");

	}

	/**
	 * Methode, um einen Filter für einen bestimmten Inhaltsstoff zu setzen oder
	 * zu entfernen
	 * 
	 * @param inhaltsstoffe
	 * @param inhaltsstoff
	 * @param eingabeSetFilter
	 */
	private static void setzeOderEntferneFilter(
			Set<Inhaltsstoff> inhaltsstoffe, Inhaltsstoff inhaltsstoff) {

		String eingabeSetFilter;
		System.out
				.println("---------------------------------------------------------------------");
		System.out.println("");
		System.out.println("Moechtest du den Filter '"
				+ inhaltsstoff.anzeigename() + "' setzen oder entfernen?");
		System.out.println("\nWaehle  1  zum setzen des Filters");
		System.out.println("Waehle  2  zum entfernen des Filters");
		System.out
				.println("\n---------------------------------------------------------------------");

		eingabeSetFilter = Konsoleneingabe.leseKonsoleFuer(Arrays
				.asList(new String[] { "1", "2" }));

		if (eingabeSetFilter != null) {
			switch (eingabeSetFilter) {
			case "1":
				inhaltsstoffe.add(inhaltsstoff);
				System.out
						.println("---------------------------------------------------------------------");
				System.out.println("");
				System.out
						.println("Der Filter fuer '"
								+ inhaltsstoff.anzeigename()
								+ "' wurde hinzugefuegt. (Klasse Filter - setzeOderEntferneFilter())");
				System.out.println("");
				break;
			case "2":
				inhaltsstoffe.remove(inhaltsstoff);
				System.out
						.println("---------------------------------------------------------------------");
				System.out.println("");
				System.out
						.println("Der Filter fuer '"
								+ inhaltsstoff.anzeigename()
								+ "' wurde entfernt. (Klasse Filter- setzeOderEntferneFilter())");
				System.out.println("");
				break;
			default:
				System.out
						.println("---------------------------------------------------------------------");
				System.out.println("");
				System.out
						.println("Falsche Eingabe, bitte einen Filter auswaehlen. (Klasse Filter)");
				System.out.println("");
				break;
			}
		}
	}

}
