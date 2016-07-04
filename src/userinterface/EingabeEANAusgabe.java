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
						  "Test EAN (Ritter Sport Marzipan 100 g) Laktose = no / Gluten = no / Nuss = no: 4000417025005 (in LIV DB)\n"
						+ "Test EAN (Ferrero Nutella 1000 g) Laktose = yes / Gluten = no / Nuss = yes: 4008400401829  (in LIV DB)\n"
						+ "Test EAN (Griesson Softcakes) Laktose = no / Gluten = no / Nuss = no: 4001518722466 (in LIV DB)\n"
						+ "Test EAN (Alnatura Dinkel Doppel Keks 330g) Laktose = yes / Gluten = no / Nuss = no: 4104420053922 (in LIV DB)\n"
						+ "Test EAN (unbekanntes Produkt) Laktose = unbekannt: 4008400401928 \n"
						+ "Test EAN (Ferrero Giotto) Laktose = yes: 4008400121925 \n"
						+ "Test EAN (Rapunzel Gemüsebrühe) Laktose = no: 4006040271505 \n"
						+ "Test EAN (Ritter Sport Dunkle Vollnuss) Laktose = yes: 4000417224002 \n"
						+ "Test EAN von 'Produkt hinzufuegen': 5449000096241");
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
