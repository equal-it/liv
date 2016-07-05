package userinterface;

import static userinterface.HauptmenueEintraege.EAN;
import static userinterface.HauptmenueEintraege.ENDE;
import static userinterface.HauptmenueEintraege.FILTER;
import static userinterface.HauptmenueEintraege.IMPRESSUM;

/**
 * Project: LIV - Lebensmittelinhaltsstoffverifizierer
 * 
 * class HauptmenueAusgabe
 * 
 * @author team equal-IT
 * @mail: team@equal-it.de
 * @version 1.0 2016/07/08
 */

public class HauptmenueAusgabe {

	public static void LivHauptmenueAusgabe() {
		System.out.println("\n--------------------------------------------");
		System.out.println("HAUPTMENUE");
		System.out.println("--------------------------------------------\n");
		System.out.println(FILTER.code() + " - Filter setzen");
		System.out.println(EAN.code() + " - EAN eingeben");
		System.out.println(IMPRESSUM.code() + " - Impressum");
		System.out.println(ENDE.code() + " - Beenden");
		System.out.println("\n--------------------------------------------");

	}

	public static void eingabeMenueAndereDB() {
		System.out
				.println("\nDas Produkt ist nicht in der LIV-Datenbank enthalten!!!\n");
		System.out.println("\n--------------------------------------------");
		System.out.println("MENUE EXT DB"); // Klasse HauptmenueAusgabe
		System.out.println("--------------------------------------------\n");
		System.out.println("--------------------------------------------");
		System.out.println("1 - Externe Datenbanken durchsuchen"
				+ "\n2 - Produkt zur LIV-Datenbank hinzuefuegen"
				+ "\n3 - Abbrechen und zurueck zum Hauptmenue");

	}

	public static void eingabeMenueInLivDBEintragen() {
		System.out.println("\n--------------------------------------------");
		System.out.println("MENUE LIV DB"); // Klasse HauptmenueAusgabe
		System.out.println("--------------------------------------------\n");
		System.out.println("\n1 - Produkt zur LIV-Datenbank hinzufuegen\n"
				+ "2 - Zurueck zum Hauptmenue");

	}
}