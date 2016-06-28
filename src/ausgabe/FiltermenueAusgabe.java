package ausgabe;

import static ausgabe.FiltermenueEintrage.*;

/**
 * Project: LIV - Lebensmittelinhaltsstoffverifizierer
 * 
 * class Liv FiltermenueAusgabe
 * 
 * @author team equal-IT 
 * @mail: team@equal-it.de
 * @version 00.00.10 2016/05/16
 */

import liv.Inhaltsstoff;

public class FiltermenueAusgabe {
	/**
	 * Methode, um das Menue der Filterauswahl anzuzeigen
	 * 
	 * @param stoff
	 *            zur Auswahl des jeweiligen Inhaltsstoffs
	 */
	public static void FilterHauptmenueAusgabe() {
		System.out.println(
				"\n--------------------------------------------");

		System.out.println("Fuer welchen Inhaltsstoff moechtest du einen Filter setzen oder entfernen?\n");

		for (Inhaltsstoff stoff : Inhaltsstoff.values()) {
			if (stoff != Inhaltsstoff.UNBEKANNT)
				System.out.println(stoff.code() + " - " + stoff.anzeigename() + ".");
		}
		System.out.println("\n" + FILTERANZEIGE.code() + " - Anzeige der aktuell gesetzten Filter.");
		System.out.println(HAUPTMENUE.code() + " - Hauptmenue.");
		System.out.println("\n--------------------------------------------");
	}

}
