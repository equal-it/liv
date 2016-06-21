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
	 * @throws Exception
	 *             e wenn eine falsche Menueeingabe gemacht wurde
	 * 
	 * @see PruefeEAN
	 */

	public static void einlesen() throws Exception {
		boolean eanValueOK = false; // fuer Auswertung ob ean OK
		int auswahl = 0;
		do {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			
			//Menue Ausgabe
			ausgabe.EingabeEANAusgabe.testEANAuagabe();
			
			try {
				eingabeEanNummer = br.readLine();
			} catch (IOException e) {
				eanValueOK = false;
			}

			if (liv.PruefeEAN.eanUngueltig(eingabeEanNummer)) {
				
				//Menue Ausgabe
				ausgabe.EingabeEANAusgabe.ungueltigeEANAusgabe();
				
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
			} else {
				eanValueOK = true;
			}

		} while (eanValueOK == false);

	} // Methode einlesen

} // class EingabeEAN
