package eingaben;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import liv.PruefeEAN;

/**
 * Project: LIV - Lebensmittelinhaltverifizierer
 * 
 * class EingabeEAN Eingabe der EAN mit Definition der Exceptions für die EAN
 * 
 * @author team equal-IT // Annes Baustelle - PFOTEN WEG!!!!! ;)
 * @mail team@equal-it.de
 * @version 00.00.04 2016/05/16
 *
 */

public class EingabeEAN {
	public static String eingabeEanNummer;

	/**
	 * @return eingabeEanNummer
	 */
	public static String getEingabe() {
		return eingabeEanNummer;
	} 

	/**
	 * Methode, um die EAN per Konsoleneingabe einzulesen
	 * 
	 * @param eanValue
	 *            Auswertung, ob EAN ok ist
	 * @param eingabeEanNummer
	 *            eingegebene EAN
	 * @param eingabe2
	 *            Eingabe bei Fehlermenue
	 * @param eingabeOK
	 *            boolean true oder false
	 * @param auswahl
	 *            zur Eingabe der Menueauswahl
	 * @throws Exception e
	 *            wenn eine falsche Menueeingabe gemacht wurde
	 * 
	 * @see PruefeEAN
	 */

	public static void einlesen() throws Exception {
		boolean eanValueOK = false; // fuer Auswertung ob ean OK
		int auswahl = 0;
		do {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			System.out.println("Bitte (Test-)EAN eingeben:");
			System.out.println("Test EAN (Ritter Sport Marzipan 100 g) Laktose = no: 4000417025005 \n"
					+ "Test EAN (Ferrero Nutella 1000 g) Laktose = yes: 4008400401829  \n"
					+ "Test EAN (unbekanntes Produkt) Laktose = unbekannt: 4008400401928 \n"
					+ "Test EAN (Griesson Softcakes) Laktose = no:4001518722466 \n"
					+ "Test EAN (Ferrero Giotto) Laktose = yes: 4008400121925 \n"
					+ "Test EAN (Rapunzel Gemüsebrühe) Laktose = no: 4006040271505 \n"
					+ "Test EAN (Ritter Sport Dunkle Vollnuss) Laktose = yes: 4000417224002 \n"
					+ "Test EAN (Alnatura Dinkel Doppel Keks 330g) Laktose = yes: 4104420053922 \n" + "");
			System.out.println("----------------------------------\n");

			try {
				eingabeEanNummer = br.readLine();
			} catch (IOException e) {
				eanValueOK = false;
			}

			if (liv.PruefeEAN.eanUngueltig(eingabeEanNummer)) {
				System.out.println("EAN ungueltig (Klasse PruefeEAN - einlesen())");
				System.out.println("Tip: EAN muss aus 13 Zahlen bestehen\n");
				System.out.println("1 neue Eingabe");
				System.out.println("2 Eingabe abbrechen");

				String eingabeFehlerMenue = Konsoleneingabe.leseKonsoleFuer(Arrays.asList(new String[] { "1", "2" }));
				auswahl = Integer.parseInt(eingabeFehlerMenue);

				switch (auswahl) {
				case 1:
					eanValueOK = false;
					break;
				case 2:
					eanValueOK = true;
					break;
				default:
					eanValueOK = false;
					break;
				}
			} 
			else {
				eanValueOK = true;
			}

		} while (eanValueOK == false);

	} // Methode einlesen

} // class EingabeEAN
