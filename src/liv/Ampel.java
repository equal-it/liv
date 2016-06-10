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

public class Ampel {
	
	 /**
	   * Methode, um GUI zu erzeugen
	   * 
	   * @param isProductOK
	   * @throws InterruptedException
	   * @see Ampelgrafik.AmpelGreen
	   * @see Ampelgrafik.AmpelRed
	   * @see Ampelgrafik.AmpelYellow
	   */
	
	public static void ampelFarbe (String isProductOk) throws InterruptedException{
		
		switch (isProductOk) {
				case "green":	
			new Ampelgrafik.AmpelGreen();
			break;
		case "red":	
		    new Ampelgrafik.AmpelRed();
			break;
		case "yellow":							
			new Ampelgrafik.AmpelYellow();
			break;
		}	// switch (isProductOK){
		
	}	// public static void AmpelFarbe (String isProductOk){
	
}	//public class Ampel {
