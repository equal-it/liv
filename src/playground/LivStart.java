package playground;
import java.io.*;

import livAlt_2016_05_30.Filter;
import livAlt_2016_05_30.Impressum;

public class LivStart {
	

	/**
	 * Project: LIV - Lebensmittelinhaltverifizierer
	 * Erster Start-Screen
	 * 
	 * @author team equal-IT
	 * @mail: team@equal-it.de
	 * @version 00.00.03 2016/04/28 - 19:33
	 */


		public static void main(String[] args) {
			int auswahl = 0;
			System.out.println("Herzlich Willkommen bei LIV - deinem Lebensmittelinhaltverifizierer.");
			System.out.println("\nWas moechtest Du als naechstes tun?");

			try { // start try
				InputStreamReader isr = new InputStreamReader(System.in);
				BufferedReader br = new BufferedReader(isr);
				boolean verlassen = false;
				// liv.Filter.setFilter(); // wenn nicht als erstes gewuenscht, dann auskommentieren - dann kommt Menue als erstes
				do { // start do while menue
					System.out.println("\n---------------------------------------------------------------------");
					System.out.println("Waehle  '1'  um Filter einzustellen");
					// System.out.println("Waehle  '2'  um eine EAN einzugeben!");
					System.out.println("Waehle  '8'  um Dir das Impressum anzusehen!");
					System.out.println("Waehle  '9'  zum Beenden!");
					System.out.println("---------------------------------------------------------------------");
					String eingabe = br.readLine(); // liest die Eingabe
					try {
						auswahl = Integer.parseInt(eingabe);// String to int
					} catch (Exception e3) {
						System.out.println("FEHLER! Falsche Menue Eingabe!");
						auswahl=0; // setzt bei Fehler auswahl = 0
					}
					switch (auswahl) {
					case 1:
						livAlt_2016_05_30.Filter.setFilter();
						break;
					
					case 8:
						livAlt_2016_05_30.Impressum.printImpressum();
						break;
					case 9:
						verlassen = true;
						break;
					default:
						System.out.println("Bitte waehle  1 / 8 / 9\n");
					}
				} while (verlassen == false); // end do while menue
			} // end try
			
			catch (IOException ex) {
				System.out.println(ex.getMessage());
			} // end catch

		} // end main

	} // end class


