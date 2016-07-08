package userinterface;

/**
 * Project: LIV - Lebensmittelinhaltsstoffverifizierer
 * 
 * class EingabeEANAusgabe Test EANs und Fehlerausgabe
 * 
 * @author team equal-IT
 * @mail: team@equal-it.de
 * @version 1.0 2016/07/08
 */

public class EingabeEANAusgabe {

	public static void testEANAuagabe() {
		System.out.println("\n--------------------------------------------");
		System.out.println("EINGABE EAN");
		System.out.println("--------------------------------------------");
		System.out.println("Bitte Produkt-EAN eingeben:\n");
		System.out.println(
				"Test EAN\n" 
				+ "Ritter Sport  (in LIV DB) : 4000417025005 \n"
				+ "Nutella       (in LIV DB) : 4008400401829 \n" 
				+ "Softcakes     (in LIV DB) : 4001518722466 \n"
				+ "unb. Produkt  Lakt. = unb.: 4008400401928 \n"
				+ "Giotto        Lakt. = yes : 4008400121925 \n"
				+ "User LIV-DB Testprodukt   : 5449000096241");
		
		System.out.println("\n--------------------------------------------");
	}

	public static void ungueltigeEANAusgabe() {
		System.out.println("--------------------------------------------");
		System.out.println("\nDie EAN ist ungueltig.");
		System.out.println("Tip: Die EAN muss aus 13 Zahlen bestehen.\n");
		System.out.println("1 - Neue Eingabe");
		System.out.println("2 - Eingabe abbrechen");

	}

}
