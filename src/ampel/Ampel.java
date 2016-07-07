package ampel;


/**
 * Project: LIV - Lebensmittelinhaltsstoffverifizierer
 * 
 * class Ampel Auswertung des Abgleichs zwischen dem gesetzten Filter und der
 * HTTPAbfrage
 * 
 * @author team equal-IT
 * @mail team@equal-it.de
 * @version 1.0 2016/07/08
 */

public class Ampel {

	/**
	 * Methode, um grafische Ampel zu erzeugen
	 * 
	 * @param isProductOK
	 * @throws InterruptedException
	 * @see ampel.AmpelGreen
	 * @see ampel.AmpelRed
	 * @see ampel.AmpelYellow
	 */

	public static void ampelFarbe(final Ampelfarbe isProductOk,
			final String text) throws InterruptedException {

		switch (isProductOk) {
		case GRUEN:
			new ampel.AmpelGreen();
			break;
		case ROT:
			new ampel.AmpelRed(text);
			break;
		case GELB:
			new ampel.AmpelYellow();
			break;
		} // switch

	} // AmpelFarbe 
} // Ampel
