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
	public static Ampelfarbe ueberprufeIndikatoren(
			List<Ampelindikator> ergebnisse) {

		Ampelfarbe isProductOK = Ampelfarbe.GRUEN;

		if (ergebnisse.isEmpty()
				|| ergebnisse.contains(Ampelindikator.UNBEKANNT)) {
			isProductOK = Ampelfarbe.GELB;
		}
		if (ergebnisse.contains(Ampelindikator.ENTHALTEN)) {
			isProductOK = Ampelfarbe.ROT;
		}

		return isProductOK;
	}

	public static void main(String args[]) {
		List<Ampelindikator> ergebnisse = new ArrayList<>();

		Ampelfarbe ergebnis = ueberprufeIndikatoren(ergebnisse);
		if (ergebnis != Ampelfarbe.GELB) {
			throw new RuntimeException();
		}

		ergebnisse.add(Ampelindikator.NICHT_ENTHALTEN);
		ergebnis = ueberprufeIndikatoren(ergebnisse);
		if (ergebnis != Ampelfarbe.GRUEN) {
			throw new RuntimeException();
		}

		System.out.print("Alle Tests ok");
	}
}
