package livAlt_2016_05_30;
import java.io.*;

/**
 * Project: LIV - Lebensmittelinhaltverifizierer
 * 
 * @author team equal-IT // letzter Stand: Anne
 * @mail: team@equal-it.de 
 * @version 00.00.10 2016/05/16
 */


public class Liv { // Console

	public static void main(String[] args) {
		
		int auswahl = 0;
		
		System.out.println("Herzlich Willkommen bei LIV - deinem Lebensmittelinhaltverifizierer. (Klasse Liv)");
		System.out.println("\nWas moechtest Du als naechstes tun? (Klasse Liv)");

		try { // start try
			
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			boolean verlassen = false;
			
			// liv.Filter.setFilter(); // wenn nicht als erstes gewuenscht, dann auskommentieren - dann kommt Menue als erstes
			
			// HIER MUSS NOCH IRGENDWO REIN:
			// Wenn KEIN Filter gesetzt ist, dieses zurueckgeben, BEVOR DB-Abfrage stattfindet!!
			// z.B.: "Wenn Du keinen Filter setzt, sind natuerlich alle Produkte ok ;)
			// Bitte Filter mit '2' setzen :)"
			
			do { // start do while menue
				
				livAlt_2016_05_30.StartMenue.printStartMenue();
				
				String eingabe = br.readLine(); // liest die Eingabe
				
				try {
					auswahl = Integer.parseInt(eingabe);// String to int
				} catch (Exception e3) {
					System.out.println("FEHLER! Falsche Menue Eingabe! (Klasse Liv)");
					auswahl=0; // setzt bei Fehler auswahl = 0
					}
				
				switch (auswahl) {
				
				case 1:
					livAlt_2016_05_30.Filter.setFilter();
					break;
					
				case 2: 
					if (livAlt_2016_05_30.Filter.filterWurdeGesetzt==false){
						System.out.println("\nAchtung, du hast noch keine Filter gesetzt.\nAlle Filter sind deaktiviert!\n");
						System.out.println("Abbruch !!! Bitte erst Filter setzten");
						break;
					}
					livAlt_2016_05_30.EingabeEAN.einlesen();
					
					if(livAlt_2016_05_30.PruefeEAN.getEanIsOK()==true){
					
						try {
							livAlt_2016_05_30.HttpAbfrageLaktonaut.sendGet(livAlt_2016_05_30.EingabeEAN.getEingabe());
						} catch (Exception e1) {
							//gibt Fehlermeldung aus wenn Fehler in HttpAbfrageLaktonaut
							System.out.println("FEHLER! Problem mit der Abfrage zu EAN: " + livAlt_2016_05_30.EingabeEAN.getEingabe() + " (Klasse Liv)");
							}
					
					livAlt_2016_05_30.VergleichFilter.vergleicheFilterLaktose();
					
					livAlt_2016_05_30.Ampel.AmpelFarbe(livAlt_2016_05_30.VergleichFilter.getIsProduktOK());
					
					} // if
					
					break;
					
				case 8:
					livAlt_2016_05_30.Impressum.printImpressum();
					break;
				
				case 9:
					verlassen = true;
					break;
				
				default:
					System.out.println("Bitte waehle  1 / 2 / 8 / 9\n");
				}
				
			} // end do-while menue 
			
			while (verlassen == false); 
			
		} // end try
		
		catch (IOException ex) {
			System.out.println(ex.getMessage());
		} // end catch

	} // end main

} // end class