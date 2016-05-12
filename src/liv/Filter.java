/**
 * 
 */
package liv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * class Filter
 * 
 * Project: Liv - Lebensmittelinhaltverifizierer
 * 
 * @author team equal-IT, team@equal-it.de /felix, anne
 * @version 00.00.10 2016/05/10
 *
 */

public class Filter {
	/**
	 * Filterklasse Setzt den Filter fuer die Ampel-Ausgabe
	 * 
	 * @param a
	 *            = Laktose
	 * @param b
	 *            = undefine1
	 * @param c
	 *            = undefine2
	 * 
	 * @return filter - ausgewaehltes Kriterium
	 * 
	 */

	static boolean[] filter = new boolean[3]; // default value false

	
	public void setFilter(boolean a, boolean b, boolean c) {
		filter[0] = a; // Laktose
		filter[1] = b;
		filter[2] = c;

	}

	public static void setFilter() {
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			String eingabeFilter;
			String eingabeSetFilter;
			boolean verlassen = false;
			int auswahl;
			do{
				System.out.println("Welchen Filter wollen sie setzen?\n");
				System.out.println("1: Laktose   Filter ist =" + filter[0]);
				System.out.println("2: undefine1 Filter ist =" + filter[1]);
				System.out.println("3: undefine2 Filter ist =" + filter[2]);
				System.out.println("4: Filter setzten beenden.\n");
				eingabeFilter = br.readLine();
				auswahl = Integer.parseInt(eingabeFilter);
				switch (auswahl) {
				case 1:
					System.out.println("Laktose Filter setzten = s, Filter loeschen = l");
					eingabeSetFilter = br.readLine();
					switch (eingabeSetFilter) {
					case "s":
						filter[0] = true;
						System.out.println("Laktose Filter auf true gesetzt");
						break;
					case "l":
						filter[0] = false;
						System.out.println("Laktose Filter auf flase gesetzt");
						break;
					default:
						System.out.println("Falsche Eingabe, bitte Filter Auswählen.");
						break;
					}
					break;
				case 2:
					System.out.println("undefine1 Filter setzten = s, Filter loeschen = l");
					eingabeSetFilter = br.readLine();
					switch (eingabeSetFilter) {
					case "s":
						filter[1] = true;
						break;
					case "l":
						filter[1] = false;
						break;
					default:
						System.out.println("Falsche Eingabe, bitte Filter Auswählen.");
						break;
					}
					break;
				case 3:
					System.out.println("undefine2 Filter setzten = s, Filter loeschen = l");
					eingabeSetFilter = br.readLine();
					switch (eingabeSetFilter) {
					case "s":
						filter[2] = true;
						break;
					case "l":
						filter[2] = false;
						break;
					default:
						System.out.println("Falsche Eingabe, bitte Filter Auswählen.");
						break;
					}
					break;
				case 4:
					verlassen=true;
					break;
				}
			} while (verlassen==false);
		} catch (IOException ex) {
			System.out.println( ex.getMessage() );
		}

	}

	public static void printFilter(){
	System.out.println("Laktose   Filter = " + filter[0]);
	System.out.println("undifine1 Filter = " + filter[1]);
	System.out.println("undifine2 Filter = " + filter[2] +"\n");
	}
	
	public static boolean[] getFilter() {
		return filter;
	}

	/**
	 * Setzt Filter auf Laktose = true als Standard
	 */
	public static void setFilterDefault() {
		filter[0] = true; // Laktose
		filter[1] = false;
		filter[2] = false;

	}
}
