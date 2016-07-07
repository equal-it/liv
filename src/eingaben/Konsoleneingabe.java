package eingaben;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;

/**
 * Project: Liv - Lebensmittelinhaltsstoffverifizierer
 * 
 * class Konsoleneingabe stellt Methoden zum sicherem einlesen von Eingaben zur
 * verfügung
 * 
 * @author team equal-IT
 * @mail: team@equal-it.de
 * @version 1.0 2016/07/08
 */

public class Konsoleneingabe {

	/**
	 * Methode, um Eingabe über die Konsole einzulesen
	 * 
	 * @param gueltigeWerte
	 * @param eingabeEanNummer
	 *            Wert per Konsoleneingabe
	 * @param br
	 *            BufferedReader
	 * @throws IOException
	 *             e wenn die Eingabe nicht gelesen werden konnte
	 * @return eingabe
	 * @return null
	 */
	public static String leseKonsoleFuer(Collection<String> gueltigeWerte) {
		String eingabe = "";
		InputStreamReader inReader = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(inReader);
		try {
			while (true) {
				eingabe = br.readLine();
				if (gueltigeWerte.contains(eingabe)) {
					return eingabe;
				} else {
					System.out.println("\nUngueltige Eingabe. Bitte erneut eingeben.");
				}
			}
		} catch (IOException e) {
			System.err.println("\nEingabe konnte nicht gelesen werden.");
		}
		return null;
	}

	public static String leseKonsole() {
		String eingabe = null;
		InputStreamReader inReader = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(inReader);
		try {
			eingabe = br.readLine();
			return eingabe;
		} catch (Exception e) {
			System.err.println("\nEingabe konnte nicht gelesen werden.");
		}
		return null;
	}

	public static String leseKonsoleFuerEanEingabe() {
		String eanEingabe = null;
		InputStreamReader inReader = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(inReader);
		try {
			while (true) {
				eanEingabe = br.readLine();
				try {
					if (pruefen.PruefeEAN.eanGueltig(eanEingabe)) {
						return eanEingabe;
					} else {
						System.out.print("\nUngueltige Eingabe. Bitte erneut eingeben.\n"
								+ "EAN MUSS GENAU 13 Stellen haben!\n"
								+ "Beispiel einer gueltigen Test-EAN: 5449000096241\n\n" + "Produkt-EAN eingeben: ");
					}
				} catch (Exception e) {
					System.out.println("\nProbleme mit der EAN-Gueltigkeitspruefung!");
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			System.err.println("\nEingabe konnte nicht gelesen werden.");
		}
		return null;
	}
}
