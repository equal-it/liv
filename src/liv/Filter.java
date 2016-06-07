package liv;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import liv.Inhaltsstoff;
import liv.Konsoleneingabe;

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

	private static final String HAUPTMENU = "9";
	private static final String FILTERANZEIGE = "8";

	/**
	 * Methode, um den Filter für den ausgewählten Inhaltsstoff zu setzen
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

			auswahl = Konsoleneingabe
					.leseKonsoleFuer(Arrays.asList(new String[] { "1", "2", FILTERANZEIGE, HAUPTMENU }));
			if (auswahl != null) {
				if (auswahl.equals(FILTERANZEIGE)) {
					System.out.println("\nAktuell gesetzte Filter sind: ");
					System.out.println(inhaltsstoffe.toString());
				} else {
					Inhaltsstoff inhaltsstoff = Inhaltsstoff.inhaltstoffFuerCode(auswahl);
					switch (inhaltsstoff) {
					case LAKTOSE:
						setzeOderEntferneFilter(inhaltsstoffe, inhaltsstoff);
						break;

					case GLUTEN:
						setzeOderEntferneFilter(inhaltsstoffe, inhaltsstoff);
						break;

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
		System.out.println("\n---------------------------------------(Klasse Filter - menueAusgabe())");
		for (Inhaltsstoff stoff : Inhaltsstoff.values()) {
			if (stoff != Inhaltsstoff.UNBEKANNT)
				System.out.println("Waehle " + stoff.code() + " fuer " + stoff.anzeigename() + ".");
		}
		System.out.println("\nWaehle 8 fuer die Anzeige der aktuell gesetzten Filter.");
		System.out.println("\nOder mit " + HAUPTMENU + " zum Hauptmenue. \n");

	}

	/**
	 * Methode, um einen Filter zu für einen bestimmten Inhaltsstoff zu setzen
	 * oder zu entfernen
	 * 
	 * @param inhaltsstoffe
	 * @param inhaltsstoff
	 * @param eingabeSetFilter
	 */
	private static void setzeOderEntferneFilter(Set<Inhaltsstoff> inhaltsstoffe, Inhaltsstoff inhaltsstoff) {

		String eingabeSetFilter;
		System.out.println("Filter '" + inhaltsstoff.anzeigename()
				+ "' setzen? \nBitte mit 'j' bestaetigen oder mit 'n' zurueck zur Auswahl:");

		eingabeSetFilter = Konsoleneingabe.leseKonsoleFuer(Arrays.asList(new String[] { "j", "n" }));

		if (eingabeSetFilter != null) {
			switch (eingabeSetFilter) {
			case "j":
				inhaltsstoffe.add(inhaltsstoff);
				System.out.println("Filter '" + inhaltsstoff.anzeigename()
						+ "' wurde hinzugefuegt. (Klasse Filter - setzeOderEntferneFilter())");
				break;
			case "n":
				inhaltsstoffe.remove(inhaltsstoff);
				System.out.println("Filter '" + inhaltsstoff.anzeigename()
						+ "' wurde entfernt. (Klasse Filter- setzeOderEntferneFilter())");
				break;
			default:
				System.out.println("Falsche Eingabe, bitte einen Filter auswaehlen. (Klasse Filter)");
				break;
			}
		}
	}

}
