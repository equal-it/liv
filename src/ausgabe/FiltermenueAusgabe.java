package ausgabe;

import static ausgabe.FiltermenueEintrage.*;

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
				"--------------------------------------------");

		System.out.println("\nFuer welchen Inhaltsstoff moechtest du einen Filter setzen oder entfernen?\n");

		for (Inhaltsstoff stoff : Inhaltsstoff.values()) {
			if (stoff != Inhaltsstoff.UNBEKANNT)
				System.out.println(stoff.code() + " - " + stoff.anzeigename() + ".");
		}
		System.out.println("\n" + FILTERANZEIGE.code() + " - Anzeige der aktuell gesetzten Filter.");
		System.out.println(HAUPTMENU.code() + " - Hauptmenue. \n");
	}

}
