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
		
		System.out.println("Herzlich Willkommen bei LIV - deinem Lebensmittelinhaltverifizierer.\n");
		System.out.println("Was moechtest Du als naechstes tun?\n");
				//+ "WÃ¤hle  1  um Ã¼ber einen Filter Deiner Wahl ein Produkt auf diesen Inhaltsstoff zu Ã¼berprÃ¼fen!\n"
				//+ "WÃ¤hle  2  um Dir das Impressum anzusehen!");
		
		try { //start try
			InputStreamReader isr = new InputStreamReader(System.in);
		    BufferedReader br = new BufferedReader(isr);
		    boolean verlassen = false;
		    do{ // start do while menue
		    System.out.println("Waehle  1  um Filter einzustellen");
		    System.out.println("Waehle  2  um den aktuell gesetzten Filter anzuzeigen!");
		    System.out.println("Waehle  3  um Dir das Impressum anzusehen!");
			System.out.println("Waehle  4  zum Beenden!");		
			String eingabe = br.readLine();	 // liest die Eingabe
			int auswahl = Integer.parseInt(eingabe); // wandelt eingabe String zu Integer
		    switch (auswahl){
		    	case 1:
		    		liv.Filter.setFilter();  
		    		break;
		    	case 2:
		    		liv.Filter.printFilter();
		    		break;
		    	case 3:
		    		liv.Impressum.printImpressum();
		    		break;
		    	case 4:
		    		verlassen=true;
		    		break;
		    	default:
		    		System.out.println("Bitte waehle  1 / 2 / 3 / 4\n");  	
		    }											   	 
		    }while (verlassen==false); // end do while menue
		} // end try
		catch( IOException ex ) {
		      System.out.println( ex.getMessage() );
		    } // end catch

	}	// end main

}	// end class