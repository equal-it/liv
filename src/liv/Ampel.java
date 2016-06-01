package liv;

import playground.TestFrame;

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
		
		case "green":	
			new gui.AmpelGreen();
			// Produkt unbedenklich gem. gesetztem Filter
			//System.out.println("\n :-) Ampel gruen (Klasse Ampel)"); 		// light=green
			break;
			//    new AmpelGruen ();
		case "red":	
		    new gui.AmpelRed();
		    // Produkt nicht empfehlenswert gem. gesetztem Filter
			//System.out.println("\n :-( Ampel rot (Klasse Ampel)");	// light=red
			break;

		case "yellow":													// Produkt nicht in der Datenbank enthalten
			new gui.AmpelYellow();
			//System.out.println("\n :-| Ampel gelb (Klasse Ampel)");		// light=yellow
			break;
			//new AmpelGeld();
		}	// switch (isProductOK){
		
	}	// public static void AmpelFarbe (String isProductOk){
	
}	//public class Ampel {
