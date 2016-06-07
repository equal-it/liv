package liv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;

/**
 * Project: Liv - Lebensmittelinhaltverifizierer
 * 
 * class Konsoleneingabe
 * wirft Exception bei Fehlerhafter Eingabe
 * 
 * @author team equal-IT
 * @mail: team@equal-it.de
 * @version  00.00.02 2016/05/09
 */

public class Konsoleneingabe {
	
	/**
	 * Methode, um Eingabe der Konsole einzulesen
	 * 
	 * @param gueltigeWerte
	 * @param eingabe
	 * 			Wert per Konsoleneingabe
	 * @param br
	 * 			BufferedReader
	 * @throws IOException e 
	 * 			wenn die Eingabe nicht gelesen werden konnte
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
				}else{
					System.out.println("Eingabe Fehler! Bitte neu Eingeben! ------ (Klasse Konsoleneingabe - leseKonsoleFuer())");
				}
			}
		} catch (IOException e) {
			System.err.println("Eingabe konnte nicht gelesen werden.");
		}
		return null;
	}
}
