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
	
	public static void AmpelFarbe (String isProductOk){
		
		switch (isProductOk) {
		
		case "green":													// Produkt unbedenklich gem. gesetztem Filter
			System.out.println("\nALLES OK :-) goenn es dir!!!"); 		// light=green
			break;
			
		case "red":														// Produkt nicht empfehlenswert gem. gesetztem Filter
			System.out.println("\nFucking Danger :-( NICHT essen!!!");	// light=red
			break;
			
		case "yellow":													// Produkt nicht in der Datenbank enthalten
			System.out.println("\nHmm, I don t know. :-| YOLO!!!");		// light=yellow
			break;
			
		}	// switch (isProductOK){
		
	}	// public static void AmpelFarbe (String isProductOk){
	
}	//public class Ampel {
