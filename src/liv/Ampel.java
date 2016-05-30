package liv;

/**
 * Project: LIV - Lebensmittelinhaltverifizierer
 * 
 * Ampel
 * Auswertung des Abgleichs zwischen
 * dem gesetzten Filter und der HTTPAbfrage
 * 
 * @author	team equal-IT
 * @mail	team@equal-it.de
 * @version	00.00.02 2016/05/12
 */
// !!! Sollten wir keine grafische Ampel realisieren können, sind die Ausgabetexte ggf. noch anzupassen ;)
public class Ampel {
	
	public static void ampelFarbe (String isProductOk){
		
		switch (isProductOk) {
		
		case "green":													// Produkt unbedenklich gem. gesetztem Filter
			System.out.println("\n :-) Das Lebensmittel enthält kein Laktose. (Klasse Ampel)"); 		// light=green
			break;
			
		case "red":														// Produkt nicht empfehlenswert gem. gesetztem Filter
			System.out.println("\n :-( Das Lebensmittel enthält Laktose (Klasse Ampel)");	// light=red
			break;
			
		case "yellow":													// Produkt nicht in der Datenbank enthalten
			System.out.println("\n :-| Dieses Lebensmittel ist leider nicht in der Datenbank enthalten. (Klasse Ampel)");		// light=yellow
			break;
			
		}	// switch (isProductOK){
		
	}	// public static void AmpelFarbe (String isProductOk){
	
}	//public class Ampel {
