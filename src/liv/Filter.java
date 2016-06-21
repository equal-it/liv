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
 * @author team equal-IT / Team-Abend
 * @mail team@equal-it.de
 * @version 00.00.10 2016/06/20
 *
 */

// Menue-Moeglichkeit einbauen, alle Filter anzeigen zu lassen!
// default-Filter ueberpruefen!
// um weiter Filter neben Laktose testen zu koennen, brauchen wir die Mocks!!

public class Filter {

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
			ausgabe.FiltermenueAusgabe.FilterHauptmenueAusgabe();

			auswahl = Konsoleneingabe.leseKonsoleFuer(Arrays.asList(new String[] { liv.Inhaltsstoff.LAKTOSE.code(),
					liv.Inhaltsstoff.GLUTEN.code(), liv.Inhaltsstoff.NUSS.code(),
					ausgabe.FiltermenueEintrage.FILTERANZEIGE.code(), ausgabe.FiltermenueEintrage.HAUPTMENU.code() }));
			if (auswahl != null) {
				if (auswahl.equals(ausgabe.FiltermenueEintrage.FILTERANZEIGE.code())) {
					System.out.println("\nAktiv gesetzte Filter: \n");
					System.out.println(inhaltsstoffe.toString() + "\n\n");
				} else {
					Inhaltsstoff inhaltsstoff = Inhaltsstoff.inhaltstoffFuerCode(auswahl);
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

		} while (!ausgabe.FiltermenueEintrage.HAUPTMENU.code().equals(auswahl));

		return inhaltsstoffe;
	}

	/**
	 * Methode, um einen Filter für einen bestimmten Inhaltsstoff zu setzen oder
	 * zu entfernen
	 * 
	 * @param inhaltsstoffe
	 * @param inhaltsstoff
	 * @param eingabeSetFilter
	 */
	private static void setzeOderEntferneFilter(Set<Inhaltsstoff> inhaltsstoffe, Inhaltsstoff inhaltsstoff) {

		String eingabeSetFilter;
		System.out.println("");
		System.out.println("Moechtest du den Filter '" + inhaltsstoff.anzeigename() + "' setzen oder entfernen?");
		System.out.println("\nWaehle  1  zum setzen des Filters");
		System.out.println("Waehle  2  zum entfernen des Filters");
		eingabeSetFilter = Konsoleneingabe.leseKonsoleFuer(Arrays.asList(new String[] { "1", "2" }));

		if (eingabeSetFilter != null) {
			switch (eingabeSetFilter) {
			case "1":
				inhaltsstoffe.add(inhaltsstoff);
				System.out.println("\nDer Filter fuer '" + inhaltsstoff.anzeigename() + "' wurde hinzugefuegt.)");
				break;
			case "2":
				inhaltsstoffe.remove(inhaltsstoff);
				System.out.println("\nDer Filter fuer '" + inhaltsstoff.anzeigename() + "' wurde entfernt.");
				break;
			default:
				System.out.println("\nFalsche Eingabe, bitte einen Filter auswaehlen.");
				break;
			}
		}
	}

}
