package playground;
import java.io.*; 

public class LivEins {	//Console
	
	// public int filter;
	// public int impressum;
	
	//public void Anzeige (int filter, int impressum) {
	//	 this.filter = 1;
	//	 this.impressum = 2;
	//}
	
	public static void main(String[] args) { 
		
		System.out.println("Herzlich Willkommen bei LIV - deinem Lebensmittelinhaltverifizierer.\n");
		System.out.println("Was möchtest Du als nächstes tun? \n\n");
				//+ "Wähle  1  um über einen Filter Deiner Wahl ein Produkt auf diesen Inhaltsstoff zu überprüfen!\n"
				//+ "Wähle  2  um Dir das Impressum anzusehen!");
		
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
		    BufferedReader br = new BufferedReader(isr);
		    System.out.print("Wähle  1  um über einen Filter Deiner Wahl ein Produkt auf diesen Inhaltsstoff zu überprüfen!\n"
						   + "Wähle  2  um Dir das Impressum anzusehen!\n");
		    String eingabe = br.readLine();
		    int auswahl = Integer.parseInt(eingabe);
		    if (auswahl == 1) {
		      liv.Filter.setFilter();  							// println ersetzen durch Methode nächste Klasse
		    }
		    else if (auswahl == 2) {
		      System.out.println("Impressum ansehen");			// println ersetzen durch Methode nächste Klasse
		    }
		    
		    else {
		      System.out.println("Bitte wähle  1  oder  2");  	// println ersetzen durch Methode nächste Klasse
		    }													// Bricht ab, keine Möglichkeit erneut 1 oder 2 zu wählen :(
	      
		    		  
		    } // try
		
		catch( IOException ex ) {
		      System.out.println( ex.getMessage() );
		    } // catch
		
		
		
		
		
	} // Ende public static void main..

}// Ende class
