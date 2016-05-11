package liv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * class EingabeEAN
 * 
 * Project: Liv - Lebensmittelinhaltverifizierer
 * 
 * @author team equal-IT, team@equal-it.de, Annes Baustelle
 * @version 00.00.02 2016/05/11
 *
 */

public class EingabeEAN
{
	public static String eingabe;
/**
 * 
 * @return 
 */
	public static String getEingabe() {
		return eingabe;
	}
/**
 * 
 * @throws IOException
 */

	public static void einlesen() throws IOException {

		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.println("Test EAN: 4000417025005");
		System.out.println("Eingabe: ");
		System.out.println("Test EAN: \n4000417025005");
		try {
			eingabe = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Ausgabe: " + eingabe);

	} // Methode einlesen

} // class EingabeEAN

