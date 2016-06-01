package livMitGui_liv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;

public class Konsoleneingabe {
	
	public static String leseKonsoleFuer(Collection<String> gueltigeWerte) {
		String eingabe = "";
		InputStreamReader inReader = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(inReader);
		try {
			while (true) {
				eingabe = br.readLine();
				if (gueltigeWerte.contains(eingabe)) {
					return eingabe;
				}
			}
		} catch (IOException e) {
			System.err.println("Eingabe konnte nicht gelesen.");
		}
		return null;
	}
}
