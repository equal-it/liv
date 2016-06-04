package liv;
// import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/** 
 * Project: LIV - Lebensmittelinhaltverifizierer
 * 
 * class EingabeEAN
 * Eingabe der EAN mit Definition der Exceptions für die EAN
 * 
 * @author	team equal-IT  // Annes Baustelle - PFOTEN WEG!!!!! ;)
 * @mail	team@equal-it.de
 * @version 00.00.04 2016/05/16
 *
 */


// ggf. boolean einfuegen, das rausgibt, ob Filter gesetzt wurde... 

public class EingabeEAN {
	public static String eingabe;

	/**
	 * @return eingabe
	 */
	public static String getEingabe() {
		return eingabe;
	} // Eingabe

	
	
	//---- ab hier Felix Version ---//
	/**
	 * Methode, um die EAN per Konsoleneingabe einzulesen
	 * 
	 * @param eanValue 
	 * 			Auswertung, ob EAN ok ist
	 * @param eingabe
	 * 			eingegebene EAN
	 * @param eingabe2 
	 *			Eingabe bei Fehlermenue		
	 * @param eingabeOK
	 * 			boolean true oder false
	 * @param auswahl
	 * 			zur Eingabe der Menueauswahl
	 * @throws Exception e
	 * 			wenn eine falsche Menueeingabe gemacht wurde
	 * 
	 * @see PruefeEAN
	 */

	public static void einlesen() throws Exception {
		boolean eanValue = false; // fuer Auswertung ob ean OK
		String eingabe2 = null;   // fuer Fehler Menue
		int auswahl = 0;
		do {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			System.out.println("Bitte (Test-)EAN eingeben:");
			System.out.println(
					  "Test EAN (Ritter Sport Marzipan 100 g) Laktose = no: 4000417025005 \n"
					+ "Test EAN (Ferrero Nutella 1000 g) Laktose = yes: 4008400401829  \n"
					+ "Test EAN (unbekanntes Produkt) Laktose = unbekannt: 4008400401928 \n"); 
			System.out.println("----------------------------------\n");
			
			try {
				eingabe = br.readLine();
			} catch (IOException e) {
				eanValue = false;
			}
			
			if (liv.PruefeEAN.eanUngueltig(eingabe)) {
				boolean eingabeOK = false;
				do {
					System.out.println("EAN Eingabe war nicht korrekt (EingabeEAN.java)");
					System.out.println("EAN muss aus 13 Zahlen bestehen!!!\n");
					System.out.println("1 neue Eingabe");
					System.out.println("2 Eingabe abbrechen");
					InputStreamReader isr2 = new InputStreamReader(System.in);
					BufferedReader br2 = new BufferedReader(isr2);
					eingabe2 = br2.readLine();
					try { // start try parseint
						auswahl = Integer.parseInt(eingabe2);// String to int
						eingabeOK = true;
					} // ende try parseInt
					catch (Exception e) { // start catch parseInt
						System.out.println("FEHLER! Falsche Menue Eingabe!");
						auswahl = 0; // if parseInt fail auswahl=0
						eingabeOK = false;
					} // ende catch parseInt
				} while (eingabeOK == false);
				switch (auswahl) {// start switch
				case 2: // Eingabe beenden
					eanValue = true;
					break;
				default:
					eanValue = false;
					break;
				}// end switch
			} // end if ean fehler
			else {
				eanValue = true;
			}

		} while (eanValue == false);

	} // Methode einlesen

} // class EingabeEAN
