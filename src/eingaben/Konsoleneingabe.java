package eingaben;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;

/**
 * Project: Liv - Lebensmittelinhaltverifizierer
 * 
 * class Konsoleneingabe wirft Exception bei Fehlerhafter Eingabe
 * 
 * @author team equal-IT
 * @mail: team@equal-it.de
 * @version 00.00.02 2016/05/09
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
					System.out.println(
							"Die Eingabe war ungueltig. Bitte erneut eingeben. ------ (Klasse Konsoleneingabe - leseKonsoleFuer())");
				}
			}
		} catch (IOException e) {
			System.err.println("Die Eingabe konnte nicht gelesen werden.");
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
			System.err.println("Die Eingabe konnte nicht gelesen werden.");
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
					if (liv.PruefeEAN.eanGueltig(eanEingabe)) {
						return eanEingabe;
					} else {
						System.out.print("Die Eingabe war ungueltig. Bitte erneut eingeben.\n"
								+ "ean MUSS GENAU 13 stellen haben\n"
								+ "Bsp.: gueltige test ean: 5449000096241\n"
								+ "Produkt ean eingeben: ");
					}
				} catch (Exception e) {
					System.out.println("Probleme mit der EAN Gueltigkeitspruefung!");
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			System.err.println("Die Eingabe konnte nicht gelesen werden.");
		}
		return null;
	}
}
