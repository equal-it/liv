package liv;

import liv.Ampelindikator;
import liv.Inhaltsstoff;
import liv.Lebensmitteldatenbank;

/**
 * Project: LIV - Lebensmittelinhaltverifizierer
 * 
 * class HttpAbfrageMock1
 * 
 * @author team equal-IT // Kevin?
 * @mail: team@equal-it.de
 * @version 00.00.01 2016/05/16
 */

public class HttpAbfrageMock1 implements Lebensmitteldatenbank {

	/**
	 * @param ean
	 * 			abzufragende EAN
	 * @param antwort
	 * 			Rückgabe der Abfrage
	 * @return antwort
	 */
	@Override
	public String frageNach(String ean) {
		String antwort = "";
		switch (ean) {
		case "1":
			antwort = "<gluten>yes</gluten>";
			break;
		case "2":
			antwort = "<gluten>no</gluten>";
			break;
		default:
			break;
		}
		return antwort;
	}

	/**
	 * @return Ampelindikator
	 */
	@Override
	public Ampelindikator antwortEnthaeltInhaltsstoff(String anfrageergebnis, Inhaltsstoff inhaltsstoff) {
		return Ampelindikator.UNBEKANNT;
	}

	// Hier fehlt die Moeglichkeit, eine weitere "Datenbank" abzufragen

}
