package ausgabe;

import static ausgabe.MenueEintraege.*;

public class AusgabeMenue {

	public static void ausgabeHauptmenue() {
		System.out.println("\n---------------------------------------------------------------------(Klasse Liv)");
		System.out.println(FILTER.code() + "  - Filter setzten");
		System.out.println(EAN.code() + "  - EAN anzeigen");
		System.out.println(IMPRESSUM.code() + "  - Impressum");
		System.out.println(ENDE.code() + "  - Beenden");
		System.out.println("---------------------------------------------------------------------");

	}
}