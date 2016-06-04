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
	   * @see gui.AmpelGreen
	   * @see gui.AmpelRed
	   * @see gui.AmpelYellow
	   */
	
	public static void ampelFarbe (String isProductOk) throws InterruptedException{
		
		switch (isProductOk) {
				case "green":	
			new gui.AmpelGreen();
			break;
		case "red":	
		    new gui.AmpelRed();
			break;
		case "yellow":							
			new gui.AmpelYellow();
			break;
		}	// switch (isProductOK){
		
	}	// public static void AmpelFarbe (String isProductOk){
	
}	//public class Ampel {
