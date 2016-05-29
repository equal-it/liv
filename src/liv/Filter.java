package liv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * class Filter
 * 
 * Project: LIV - Lebensmittelinhaltverifizierer
 * 
 * @author team equal-IT, team@equal-it.de / felix, anne, mel
 * @version 00.00.10 2016/05/10
 *
 */

// Menue-Moeglichkeit einbauen, alle Filter anzeigen zu lassen!
// default-Filter ueberpruefen!
// um weiter Filter neben Laktose testen zu koennen, brauchen wir die Mocks!!

public class Filter {
	/**
	 * Filterklasse Setzt den Filter fuer die Ampel-Ausgabe
	 * 
	 * @param a
	 *            = Laktose
	 * @param b
	 *            = Gluten
	 * @param c
	 *            = Soya
	 * 
	 * @return filter - ausgewaehltes Kriterium
	 * 
	 */

	static boolean filterWurdeGesetzt = false;

	// Fuer die zentrale Aenderung der Filterwerte
	static String a = "Laktose";
	static String b = "Gluten";
	static String c = "Glutamat";
	static String d = "Hefextrakt";
	static String e = "Nuss";

	static boolean[] filter = new boolean[5]; // default value false

	public void setFilter(boolean a, boolean b, boolean c, boolean d, boolean e) {
		filter[0] = a; // Laktose
		filter[1] = b;
		filter[2] = c;
		filter[3] = d;
		filter[4] = e;
	}

	public static void setFilter() {
		filterWurdeGesetzt = true;
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			String eingabeFilter;
			String eingabeSetFilter;

			boolean verlassen = false;
			int auswahl;

			do {
				System.out.println(
						"\n---------------------------------------------------------------------(Klasse Filter)");
				System.out.println("\nWelchen Filter wollen Sie setzen?\n");
				System.out.println("Waehle '1' fuer " + a + "."); // + filter[0]
				System.out.println("Waehle '2' fuer " + b + ".");
				System.out.println("Waehle '3' fuer " + c + ".");
				System.out.println("Waehle '4' fuer " + d + ".");
				System.out.println("Waehle '5' fuer " + e + ".");
				System.out.println("\nWaehle '8' fuer Filter Anzeige");
				System.out.println("Oder mit '9' zum Hauptmenue. \n");
				System.out.println("---------------------------------------------------------------------");

				eingabeFilter = br.readLine();
				auswahl = Integer.parseInt(eingabeFilter);

				// überprüfen ob alle 3 cases nötig sind oder die Definition
				// "filter []" ausreicht!!!
				// Wenn Aenderungen, dann auch in "VergleichFilter"
				switch (auswahl) {
				case 1:
					System.out.println(
							"\n---------------------------------------------------------------------(Klasse Filter)");
					System.out.println("Filter '" + a
							+ "' setzen? \nBitte mit 'j' bestaetigen oder mit 'n' zurueck zur Auswahl: \n");
					eingabeSetFilter = br.readLine();
					switch (eingabeSetFilter) {
					case "j":
						filter[0] = true;
						System.out.println("Filter '" + a + "' wurde gesetzt. (Klasse Filter)");
						System.out.println("Weitere Filter setzen oder mit '9' zum Hauptmenue.\n");
						System.out.println("---------------------------------------------------------------------");
						break;
					case "n":
						filter[0] = false;
						System.out.println("Filter '" + a + "' wurde nicht gesetzt. (Klasse Filter)");
						break;
					default:
						System.out.println("Falsche Eingabe, bitte einen Filter auswaehlen. (Klasse Filter)");
						break;
					}
					break;

				case 2:
					System.out.println(b
							+ " als Filter setzten, bitte mit 'j' bestaetigen oder mit 'n' zurueck zur Auswahl: (Klasse Filter)\n");
					eingabeSetFilter = br.readLine();
					switch (eingabeSetFilter) {
					case "j":
						filter[1] = true;
						break;
					case "n":
						filter[1] = false;
						break;
					default:
						System.out.println("Falsche Eingabe, bitte einen Filter auswaehlen. (Klasse Filter)");
						break;
					}
					break;

				case 3:
					System.out.println(c
							+ " als Filter setzten, bitte mit 'j' bestaetigen oder mit 'n' zurueck zur Auswahl: (Klasse Filter) \n");
					eingabeSetFilter = br.readLine();
					switch (eingabeSetFilter) {
					case "j":
						filter[2] = true;
						break;
					case "n":
						filter[2] = false;
						break;
					default:
						System.out.println("Falsche Eingabe, bitte einen Filter auswaehlen. (Klasse Filter)");
						break;
					}
					break;
				case 4:
					System.out.println(d
							+ " als Filter setzten, bitte mit 'j' bestaetigen oder mit 'n' zurueck zur Auswahl: (Klasse Filter) \n");
					eingabeSetFilter = br.readLine();
					switch (eingabeSetFilter) {
					case "j":
						filter[3] = true;
						break;
					case "n":
						filter[3] = false;
						break;
					default:
						System.out.println("Falsche Eingabe, bitte einen Filter auswaehlen. (Klasse Filter)");
						break;
					}
					break;
				case 5:
					System.out.println(e
							+ " als Filter setzten, bitte mit 'j' bestaetigen oder mit 'n' zurueck zur Auswahl: (Klasse Filter) \n");
					eingabeSetFilter = br.readLine();
					switch (eingabeSetFilter) {
					case "j":
						filter[4] = true;
						break;
					case "n":
						filter[4] = false;
						break;
					default:
						System.out.println("Falsche Eingabe, bitte einen Filter auswaehlen. (Klasse Filter)");
						break;
					}
					break;
				case 8:
					System.out.println("Filter : " + a + " ist " + filter[0]);
					System.out.println("Filter : " + b + " ist " + filter[1]);
					System.out.println("Filter : " + c + " ist " + filter[2]);
					System.out.println("Filter : " + d + " ist " + filter[3]);
					System.out.println("Filter : " + e + " ist " + filter[4]);
					break;
				case 9:
					verlassen = true;
					break;
				}

			} while (verlassen == false);
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}

	}

	public static boolean[] getFilter() {
		return filter;
	}

	public static boolean getFilter(int filternummer) {
		return filter[filternummer];
	}

}
