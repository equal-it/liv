package liv;

/**
 * Project: LIV - Lebensmittelinhaltsstoffverifizierer
 * 
 * class Ampel Auswertung des Abgleichs zwischen dem gesetzten Filter und der
 * HTTPAbfrage
 * 
 * @author team equal-IT
 * @mail team@equal-it.de
 * @version 00.00.02 2016/05/12
 */

public class Ampel {

	/**
	 * Methode, um GUI zu erzeugen
	 * 
	 * @param isProductOK
	 * @throws InterruptedException
	 * @see ampelGrafik.AmpelGreen
	 * @see ampelGrafik.AmpelRed
	 * @see ampelGrafik.AmpelYellow
	 */

	public static void ampelFarbe(final Ampelfarbe isProductOk,
			final String text) throws InterruptedException {

		switch (isProductOk) {
		case GRUEN:
			new ampelGrafik.AmpelGreen();
			break;
		case ROT:
			new ampelGrafik.AmpelRed(text);
			break;
		case GELB:
			new ampelGrafik.AmpelYellow();
			break;
		} // switch (isProductOK){

	} // public static void AmpelFarbe (String isProductOk){

} // public class Ampel {
