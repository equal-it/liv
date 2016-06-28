package liv;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: LIV - Lebensmittelinhaltsstoffverifizierer
 * 
 * class VergleichFilter Klasse vergleicht gesetzten Filter mit zurueckgegebenen
 * Werten aus der DB
 * 
 * @author team equal-IT / Team-Abend am 20.06.
 * @mail: team@equal-it.de
 * @version 00.00.05 2016/06/20
 */

public class VergleichFilter {

	/**
	 * @param isProductOK
	 * @param ergebnisse
	 * @return isProductOK
	 */
	public static String ueberprufeIndikatoren(List<Ampelindikator> ergebnisse) {

		String isProductOK = "green";

		if (ergebnisse.isEmpty()
				|| ergebnisse.contains(Ampelindikator.UNBEKANNT)) {
			isProductOK = "yellow";
		}
		if (ergebnisse.contains(Ampelindikator.ENTHALTEN)) {
			isProductOK = "red";
		}

		return isProductOK;
	}

	public static void main(String args[]) {
		List<Ampelindikator> ergebnisse = new ArrayList<>();

		String ergebnis = ueberprufeIndikatoren(ergebnisse);
		if (!ergebnis.equals("yellow")) {
			throw new RuntimeException();
		}

		ergebnisse.add(Ampelindikator.NICHT_ENTHALTEN);
		ergebnis = ueberprufeIndikatoren(ergebnisse);
		if (!ergebnis.equals("green")) {
			throw new RuntimeException();
		}

		System.out.print("Alle Tests ok");
	}
}
