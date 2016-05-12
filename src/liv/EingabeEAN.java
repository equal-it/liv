package liv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * class EingabeEAN
 * 
 * Project: Liv - Lebensmittelinhaltverifizierer
 * 
 * @author team equal-IT, team@equal-it.de, Annes Baustelle
 * @version 00.00.02 2016/05/11
 *
 */

public class EingabeEAN {
	public static String eingabe;

	/**
	 * 
	 * @return eingabe
	 */
	public static String getEingabe() {
		return eingabe;
	}

	/**
	 * 
	 * @throws IOException
	 */

	public static void einlesen() throws IOException {
		boolean eanValue = false; // fuer Auswertung ob ean OK
		String eingabe2 = null;   // fuer Fehler Menue
		int auswahl = 0;
		do {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			System.out.println("Bitte Test/Eigene EAN eingeben");
			System.out.println(
					"Test EAN (Ritter Sport Marzipan 100 g) Laktose = no:"
					+ "\n4000417025005\nTest EAN (Milka Alpenmilch 300 g) Laktose = yes:"
					+ "\n7622200004607\nTest EAN (Ferrero Nutella) Laktose = unbekannt:\n4008400401928");
			try {
				eingabe = br.readLine();
			} catch (IOException e) {
				eanValue = false;
			}
			try {
				liv.PruefeEAN.pruefeEAN(eingabe);
			} catch (Exception e1) {
				eanValue = false;
			}
			if (liv.PruefeEAN.getEanIsOK() == false) {// start if ean fehler
				boolean eingabeOK = false;
				do {
					System.out.println("FEHLER! EAN hat den falschen wert!\n");
					System.out.println("1 neue Eingabe");
					System.out.println("2 Eingabe abbrechen");
					InputStreamReader isr2 = new InputStreamReader(System.in);
					BufferedReader br2 = new BufferedReader(isr2);
					eingabe2 = br2.readLine();
					try { // start try parseint
						auswahl = Integer.parseInt(eingabe2);// String to int
						eingabeOK = true;
					} // ende try parseInt
					catch (Exception e) { // start catch parseInt
						System.out.println("FEHLER! Falsche Menue Eingabe!");
						auswahl = 0; // if parseInt fail auswahl=0
						eingabeOK = false;
					} // ende catch parseInt
				} while (eingabeOK == false);
				switch (auswahl) {// start switch
				case 2: // Eingabe beenden
					eanValue = true;
					break;
				default:
					eanValue = false;
					break;
				}// end switch
			} // end if ean fehler
			else {
				eanValue = true;
			}

		} while (eanValue == false);

	} // Methode einlesen

} // class EingabeEAN