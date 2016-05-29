package livAnne;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;

public class Konsoleneingabe {

	public static void main(String[] args) {

		Collection<String> gueltigeWerte = new ArrayList<>();
		gueltigeWerte.add("a");
		gueltigeWerte.add("2");
		gueltigeWerte.add("Q");
		String ergebnis = Konsoleneingabe.leseKonsoleFuer(gueltigeWerte);
		System.out.println(ergebnis);
	}

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
