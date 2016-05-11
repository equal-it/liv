package liv;
import java.util.Scanner;

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
	
// HEAD
	// Hier muessen Methoden hin, die einen per Konsole eingegebenen EAN einlesen
	
	public static Scanner einlesen(){
	
	 Scanner ean = new Scanner(System.in);

     System.out.println("Eingabe: ");
     String eingabe = ean.nextLine();
     
     System.out.println("Ausgabe: " + eingabe);
	
     return ean;
	} // Methode Scanner
	
} //class EingabeEAN
	
	// oder
	
	
	//public Scanner einlesen2(){
		
		//Scanner ean2 = new Scanner(System.in);
		//System.out.print("Bitte EAN eingeben: " + ean2);
		//String eingabe = ean2.nextLine();
		//System.out.println("Eingegebene EAN: " + eingabe);
		
		//return ean2;
		
	// } // Methode einlesen2
	
	
//	funzt nicht
	// String ean;
//
//		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
//		System.out.println("Eingabe :");
//		ean = input.readLine();
//		System.out.println("Ausgabe: "+text);

	
	// Hier muessen Methoden hin, die einen per Konsole eingegebenen EAN (als String)einlesen 
// branch 'master' of https://github.com/equal-it/liv.git
