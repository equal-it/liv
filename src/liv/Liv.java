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

	// public int filter;
	// public int impressum;

	// public void Anzeige (int filter, int impressum) {
	// this.filter = 1;
	// this.impressum = 2;
	// }

	public static void main(String[] args) { 
		
		System.out.println("Herzlich Willkommen bei LIV - deinem Lebensmittelinhaltverifizierer.\n");
		System.out.println("Was möchtest Du als nächstes tun? \n\n");
				//+ "Wähle  1  um über einen Filter Deiner Wahl ein Produkt auf diesen Inhaltsstoff zu überprüfen!\n"
				//+ "Wähle  2  um Dir das Impressum anzusehen!");
		
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
		    BufferedReader br = new BufferedReader(isr);
		    boolean verlassen = false;
		    do{
		    System.out.println("Wähle  1  um über einen Filter Deiner Wahl ein Produkt auf diesen Inhaltsstoff zu überprüfen!");
		    System.out.println("Wähle  2  aktuel gesetzte Filter anzeigen!");
		    System.out.println("Wähle  3  um Dir das Impressum anzusehen!");
			System.out.println("Wähle  4  zum Beenden!");		
			String eingabe = br.readLine();
			int auswahl = Integer.parseInt(eingabe);
		    switch (auswahl){
		    	case 1:
		    		liv.Filter.setFilter();  
		    		break;
		    	case 2:
		    		liv.Filter.toStringFilter();
		    		break;
		    	case 3:
		    		System.out.println("Impressum ansehen");			
		    		// println ersetzen durch Methode nächste Klasse
		    		break;
		    	case 4:
		    		verlassen=true;
		    		break;
		    	default:
		    		System.out.println("Bitte wähle  1 / 2 / 3");  	
		    		// println ersetzen durch Methode nächste Klasse
		    }											   	 
		    }while (verlassen==false); 
		} // try
		catch( IOException ex ) {
		      System.out.println( ex.getMessage() );
		    } // catch

	} // Ende public static void main..

}// Ende class