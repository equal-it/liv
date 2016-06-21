package ausgabe;

import static ausgabe.HauptmenueEintraege.*;

public class HauptmenueAusgabe {

	public static void LivHauptmenueAusgabe() {
		System.out.println("\n--------------------------------------------");
		System.out.println(FILTER.code() + " - Filter setzten");
		System.out.println(EAN.code() + " - EAN anzeigen");
		System.out.println(IMPRESSUM.code() + " - Impressum");
		System.out.println(ENDE.code() + " - Beenden");
		System.out.println("--------------------------------------------");

	}

}