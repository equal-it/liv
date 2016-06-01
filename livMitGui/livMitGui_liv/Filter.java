package livMitGui_liv;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import livMitGui_liv.Inhaltsstoff;
import livMitGui_liv.Konsoleneingabe;

/**
 * class Filter
 * 
 * Project: LIV - Lebensmittelinhaltverifizierer
 * 
 * @author team equal-IT, team@equal-it.de / felix, anne, mel
 * @version 00.00.10 2016/05/10
 *
 */

// Menue-Moeglichkeit einbauen, alle Filter anzeigen zu lassen!
// default-Filter ueberpruefen!
// um weiter Filter neben Laktose testen zu koennen, brauchen wir die Mocks!!

public class Filter {

	private static final String HAUPTMENU = "4";

	public static Set<Inhaltsstoff> setFilter() {

		Set<Inhaltsstoff> inhaltsstoffe = new HashSet<>();

		String auswahl = null;
		do {
			menuAusgeben();

			auswahl = Konsoleneingabe.leseKonsoleFuer(Arrays.asList(new String[] { "1", "2", HAUPTMENU }));

			if (auswahl != null) {
				Inhaltsstoff inhaltsstoff = Inhaltsstoff.inhaltstoffFuerCode(auswahl);

				System.out.println(
						"\n---------------------------------------------------------------------(Klasse Filter)");
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

		} while (!HAUPTMENU.equals(auswahl));

		return inhaltsstoffe;
	}

	private static void menuAusgeben() {
		System.out.println("\n---------------------------------------------------------------------(Klasse Filter)");
		for (Inhaltsstoff stoff : Inhaltsstoff.values()) {
			if (stoff != Inhaltsstoff.UNBEKANNT)
				System.out.println("Waehle " + stoff.code() + " fuer " + stoff.anzeigename() + ".");
		}
		System.out.println("\nOder mit " + HAUPTMENU + " zum Hauptmenue. \n");
		System.out.println("---------------------------------------------------------------------");
	}

	private static void setzeOderEntferneFilter(Set<Inhaltsstoff> inhaltsstoffe, Inhaltsstoff inhaltsstoff) {

		String eingabeSetFilter;
		System.out.println("Filter '" + inhaltsstoff.anzeigename()
				+ "' setzen? \nBitte mit 'j' bestaetigen oder mit 'n' zurueck zur Auswahl: \n");

		eingabeSetFilter = Konsoleneingabe.leseKonsoleFuer(Arrays.asList(new String[] { "j", "n" }));

		if (eingabeSetFilter != null) {
			switch (eingabeSetFilter) {
			case "j":
				inhaltsstoffe.add(inhaltsstoff);
				System.out.println("Filter '" + inhaltsstoff.anzeigename() + "' wurde hinzugefuegt. (Klasse Filter)");
				System.out.println("Weitere Filter setzen oder mit '4' zum Hauptmenue.\n");
				System.out.println("---------------------------------------------------------------------");
				break;
			case "n":
				inhaltsstoffe.remove(inhaltsstoff);
				System.out.println("Filter '" + inhaltsstoff.anzeigename() + "' wurde entfernt. (Klasse Filter)");
				break;
			default:
				System.out.println("Falsche Eingabe, bitte einen Filter auswaehlen. (Klasse Filter)");
				break;
			}
		}
	}

}
