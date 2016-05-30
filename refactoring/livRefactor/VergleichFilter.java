package livRefactor;


import java.util.List;

/**
 * Project: LIV - Lebensmittelinhaltverifizierer
 * 
 * class VergleichFilter Klasse vergleicht gesetzten Filter mit zurueckgegebenen
 * Werten aus der DB
 * 
 * @author team equal-IT /felix, anne
 * @mail: team@equal-it.de
 * @version 00.00.05 2016/05/16
 */

public class VergleichFilter {

	public static String ueberprufeIndikatoren(List<Ampelindikator> ergebnisse) {

		String isProduktOK = "green";

		if (ergebnisse.isEmpty() || ergebnisse.contains(Ampelindikator.UNBEKANNT)) {
			isProduktOK = "yellow";
		} if (ergebnisse.contains(Ampelindikator.ENTHALTEN)) {
			isProduktOK = "red";
		}
		return isProduktOK;
	}

}
