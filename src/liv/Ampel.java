package liv;

/**
 * Project: Liv - Lebensmittelinhaltverifizierer
 * 
 * class Ampel
 * Stellt den Filter in Abgleich mit der Abfrage
 * in Ampelform dar.
 * 
 * @author team equal-IT
 * @mail: team@equal-it.de
 * @version 00.00.01 2016/05/10
 */

public class Ampel {
	public static void AmpelFarbe(String isProduktOK){
		switch (isProduktOK){
		case "green":
			System.out.println("\nALLES OK :-) goenn dir!!!  light=green");
			break;
		case "red":
			System.out.println("\nFucking Danger :-( NICHT essen!!!   light=red");
			break;
		case "orange":
			System.out.println("\nHmm, I don t know. :-| YOLO!!!   light=orange");
			break;
		}
	}
	

}
