package filter;

import java.util.ArrayList;
import java.util.List;

import ampel.Ampelfarbe;

/**
 * Project: LIV - Lebensmittelinhaltsstoffverifizierer
 * 
 * class VergleichFilter Klasse vergleicht gesetzten Filter mit zurueckgegebenen
 * Werten aus der DB
 * 
 * @author team equal-IT 
 * @mail: team@equal-it.de
 * @version 1.0 2016/07/08
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
