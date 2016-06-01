package livAlt_2016_05_30;

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

	static String isProduktOK = null;

	public static void vergleicheFilterLaktose() {
		// fuer Filter 0 Laktose
		String a = livAlt_2016_05_30.HttpAbfrageLaktonaut.getLaktose();
		switch (a) {
		case "no": // bedeutet: kein a enthalten
				isProduktOK = "green";		
		case "yes": // bedeutet: a ist enthalten
			if (livAlt_2016_05_30.Filter.getFilter(0) == false) { 
				isProduktOK = "green"; // wenn a-Filter NICHT gesetzt, dann ist ok - also gruen
			} else {
				isProduktOK = "red";   // wenn a-Filter gesetzt und a enthalten, dann ist nicht ok - also rot
				}
			break;
			
		case "unbekannt":
			isProduktOK = "yellow";
			break;
			
		default:
			isProduktOK = "yellow";

		}
	}

	public static String getIsProduktOK() {
		return isProduktOK;
	}

	// muss aktuell gesetzten Filter aus der Klasse Filter holen (getFilter)
	// muss Daten aus HttpAbfrageLaktonaut holen ob yes oder no (isLaktose)
	// dann vergleichen, ob wenn Filter 01 = true und isLaktose = yes dann setze
	// Ampel auf rot, wenn unbekannt dann gelb, wenn no dann gruen

	// Reihenfolge: Filter muss gesetzt sein, HttpAbfrage muss aufgerufen sein,
	// Barcodeeingabe
	// muss passiert sein

	// kevin war hier und macht das schon

}