package liv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * class EingabeEAN
 * 
 * Project: Liv - Lebensmittelinhaltverifizierer
 * 
 * @author team equal-IT, team@equal-it.de, Annes Baustelle
 * @version 00.00.02 2016/05/11
 *
 */

public class EingabeEAN {
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
		boolean eanValue = false;
		String eingabe2=null;
		int auswahl=0;
		do {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			System.out.println("Test EAN: \n4000417025005  Bitte Test/Eigene EAN eingeben");
			try {
				eingabe = br.readLine();
			} catch (IOException e) {
				eanValue=false;
			}
			try {
				liv.PruefeEAN.pruefeEAN(eingabe);
			} catch (Exception e1) {
				eanValue = false;
			}
			if (liv.PruefeEAN.getEanIsOK() == false) {
			boolean eingabeOK=false;
				do{
				System.out.println("FEHLER! EAN hat den falschen wert!\n");
				System.out.println("1 neue Eingabe");
				System.out.println("2 Eingabe abbrechen");
				InputStreamReader isr2 = new InputStreamReader(System.in);
				BufferedReader br2 = new BufferedReader(isr2);
				eingabe2 = br2.readLine();
				try {
					auswahl = Integer.parseInt(eingabe2);// String to int
					eingabeOK=true;
				} catch (Exception e) {
					System.out.println("FEHLER! Falsche Menue Eingabe!");
					auswahl=0;
					eingabeOK=false;
				}
				}while(eingabeOK == false );
				switch (auswahl){
				case 2:
					eanValue=true;
					break;
				default:
					eanValue=false;
					break;
				}
				}else{
					eanValue=true;
				}

		} while (eanValue == false);
			
	} // Methode einlesen

} // class EingabeEAN
