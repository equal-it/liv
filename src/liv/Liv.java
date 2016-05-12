package liv;

import java.io.*;

/**
 * Project: Liv - Lebensmittelinhaltverifizierer
 * 
 * @author team equal-IT
 * @mail: team@equal-it.de
 * @version 00.00.03 2016/04/28 - 19:33
 */

public class Liv { // Console

	public static void main(String[] args) {
		int auswahl = 0;
		System.out.println("Herzlich Willkommen bei LIV - deinem Lebensmittelinhaltverifizierer.");
		System.out.println("\nWas moechtest Du als naechstes tun?");

		try { // start try
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			boolean verlassen = false;
			do { // start do while menue
				System.out.println("\n---------------------------------------------------------------------");
				System.out.println("Waehle  1  um Filter einzustellen");
				System.out.println("Waehle  2  um eine EAN einzugeben!");
				System.out.println("Waehle  8  um Dir das Impressum anzusehen!");
				System.out.println("Waehle  9  zum Beenden!");
				String eingabe = br.readLine(); // liest die Eingabe
				try {
					auswahl = Integer.parseInt(eingabe);// String to int
				} catch (Exception e3) {
					System.out.println("FEHLER! Falsche Menue Eingabe!");
					auswahl=0; // setzt bei Fehler auswahl = 0
				}
				switch (auswahl) {
				case 1:
					liv.Filter.setFilter();
					break;
				case 2:
					liv.EingabeEAN.einlesen();
					if(liv.PruefeEAN.getEanIsOK()==true){
					try {
						liv.HttpAbfrageLaktonaut.sendGet(liv.EingabeEAN.getEingabe());
					} catch (Exception e1) {
						//giibt Fehlermeldung aus wenn Fehler in HttpAbfrageLaktonaut
						System.out.println("FEHLER! Problem mit der Abfrage zu EAN: " + liv.EingabeEAN.getEingabe());
					}
					/**
					 *  Das folgende system.out.printline durch Methodenaufruf Verleiche Filter ersetzen
					 */
					System.out.println("\nLaktose in Barcode " + liv.EingabeEAN.getEingabe() + " enthalten : "
							+ liv.HttpAbfrageLaktonaut.getLaktose());}
					/**
					 * hier sollte die Ampel aufgerufen werden
					 */
					break;
				case 8:
					liv.Impressum.printImpressum();
					break;
				case 9:
					verlassen = true;
					break;
				default:
					System.out.println("Bitte waehle  1 / 2 / 8 / 9\n");
				}
			} while (verlassen == false); // end do while menue
		} // end try
		catch (IOException ex) {
			System.out.println(ex.getMessage());
		} // end catch

	} // end main

} // end class