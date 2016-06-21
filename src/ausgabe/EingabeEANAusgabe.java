package ausgabe;

public class EingabeEANAusgabe {

	public static void testEANAuagabe() {
		System.out.println("--------------------------------------------");
		System.out.println("\nBitte (Test-)EAN eingeben:\n");
		System.out.println("Test EAN (Ritter Sport Marzipan 100 g) Laktose = no: 4000417025005 (in LIV DB)\n"
				+ "Test EAN (Ferrero Nutella 1000 g) Laktose = yes: 4008400401829  (in LIV DB)\n"
				+ "Test EAN (unbekanntes Produkt) Laktose = unbekannt: 4008400401928 \n"
				+ "Test EAN (Griesson Softcakes) Laktose = no: 4001518722466 (in LIV DB)\n"
				+ "Test EAN (Ferrero Giotto) Laktose = yes: 4008400121925 \n"
				+ "Test EAN (Rapunzel Gemüsebrühe) Laktose = no: 4006040271505 \n"
				+ "Test EAN (Ritter Sport Dunkle Vollnuss) Laktose = yes: 4000417224002 \n"
				+ "Test EAN (Alnatura Dinkel Doppel Keks 330g) Laktose = yes: 4104420053922 (in LIV DB)\n" + "");
		System.out.println("--------------------------------------------");
	}

	public static void ungueltigeEANAusgabe() {
		System.out.println("--------------------------------------------");
		System.out.println("\nDie EAN ist ungueltig.");
		System.out.println("Tip: Die EAN muss aus 13 Zahlen bestehen.\n");
		System.out.println("1 - neue Eingabe.");
		System.out.println("2 - Eingabe abbrechen.");

	}

}
