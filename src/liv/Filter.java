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
	
	// Fuer die zentrale Aenderung der Filterwerte
	static String a = "Laktose";
	static String b = "b";
	static String c = "c";
	

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
				System.out.println("\n---------------------------------------------------------------------(Klasse Filter)");
				System.out.println("\nWelchen Filter wollen Sie setzen?\n");
				System.out.println("Waehle '1' fuer " + a + ".");  // + filter[0]
				System.out.println("Waehle '2' fuer " + b + ".");
				System.out.println("Waehle '3' fuer " + c + ".");
				System.out.println("\nOder mit '4' zum Hauptmenue. \n");
				System.out.println("---------------------------------------------------------------------");
				
				eingabeFilter = br.readLine();
				auswahl = Integer.parseInt(eingabeFilter);
				
				switch (auswahl) {
				case 1:
					System.out.println("\n---------------------------------------------------------------------(Klasse Filter)");
					System.out.println("Filter '" + a + "' setzen? \nBitte mit 'j' bestaetigen oder mit 'n' zurueck zur Auswahl: \n");
					eingabeSetFilter = br.readLine();
					switch (eingabeSetFilter) {
					case "j":
						filter[0] = true;
						System.out.println("Filter '" + a + "' wurde gesetzt. (Klasse Filter)");
						System.out.println("Weitere Filter setzen oder mit '4' zum Hauptmenue.\n");
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
					System.out.println(b + " als Filter setzten, bitte mit 'j' bestaetigen oder mit 'n' zurueck zur Auswahl: (Klasse Filter)\n");
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
					System.out.println(c +" als Filter setzten, bitte mit 'j' bestaetigen oder mit 'n' zurueck zur Auswahl: (Klasse Filter) \n");
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
					verlassen=true;
					break;
				}
				
			} while (verlassen==false);
		} catch (IOException ex) {
			System.out.println( ex.getMessage() );
		}

	}

	public static void printFilter(){
	System.out.println(a + "Filter = " + filter[0]);
	System.out.println(b + "undifine1 Filter = " + filter[1]);
	System.out.println(c + "undifine2 Filter = " + filter[2] + "\n");
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
