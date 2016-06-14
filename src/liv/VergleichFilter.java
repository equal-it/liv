package liv;

import java.util.List;
import liv.Ampelindikator;

/**
 * Project: LIV - Lebensmittelinhaltverifizierer
 * 
 * class VergleichFilter 
 * Klasse vergleicht gesetzten Filter mit zurueckgegebenen Werten aus der DB
 * 
 * @author team equal-IT /felix, anne
 * @mail: team@equal-it.de
 * @version 00.00.05 2016/05/16
 */

public class VergleichFilter {

	/**
	 * @param isProductOK
	 * @param ergebnisse
	 * @return isProductOK
	 */
	public static String ueberprufeIndikatoren(List<Ampelindikator> ergebnisse) {

		String isProductOK = "";

		if (ergebnisse.isEmpty() || ergebnisse.contains(Ampelindikator.UNBEKANNT)) {
			isProductOK = "yellow";
		} if (ergebnisse.contains(Ampelindikator.ENTHALTEN)) {
			isProductOK = "red";
		}
		if (ergebnisse.contains(Ampelindikator.NICHT_ENTHALTEN)) {
			isProductOK = "green";
		}
		return isProductOK;
	}

}
