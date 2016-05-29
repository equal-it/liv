package liv;
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
				
				liv.StartMenue.printStartMenue();
				
				String eingabe = br.readLine(); // liest die Eingabe
				
				try {
					auswahl = Integer.parseInt(eingabe);// String to int
				} catch (Exception e3) {
					System.out.println("FEHLER! Falsche Menue Eingabe! (Klasse Liv)");
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
							//gibt Fehlermeldung aus wenn Fehler in HttpAbfrageLaktonaut
							System.out.println("FEHLER! Problem mit der Abfrage zu EAN: " + liv.EingabeEAN.getEingabe() + " (Klasse Liv)");
							}
					
					liv.VergleichFilter.vergleicheFilterLaktose(liv.Filter.getFilter(), 
					liv.HttpAbfrageLaktonaut.getLaktose());
					liv.Ampel.AmpelFarbe(liv.VergleichFilter.getIsProduktOK());
					
					} // if
					
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
				
			} // end do-while menue 
			
			while (verlassen == false); 
			
		} // end try
		
		catch (IOException ex) {
			System.out.println(ex.getMessage());
		} // end catch

	} // end main

} // end class