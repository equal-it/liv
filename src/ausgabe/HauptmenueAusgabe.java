package ausgabe;

import static ausgabe.HauptmenueEintraege.*;

public class HauptmenueAusgabe {

	public static void LivHauptmenueAusgabe() {
		System.out.println("\n--------------------------------------------");
		System.out.println(FILTER.code() + " - Filter setzten");
		System.out.println(EAN.code() + " - EAN eingeben");
		System.out.println(IMPRESSUM.code() + " - Impressum");
		System.out.println(ENDE.code() + " - Beenden");
		System.out.println("--------------------------------------------");

	}

	public static void eingabeMenueAndereDB() {
		System.out.println("\nProdukt ist nicht in LIV DB!!!\n\n1 - in nicht LIV DB suchen\n" + "2 - Produkt zur LIV DB hinzuefuegen");
	}
}