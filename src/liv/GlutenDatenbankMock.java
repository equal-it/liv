package liv;

import liv.Ampelindikator;
import liv.Inhaltsstoff;
import liv.Lebensmitteldatenbank;

/**
 * Project: LIV - Lebensmittelinhaltverifizierer
 * 
 * class HttpAbfrageMock1
 * Mock Up für die Datenbankabfrage für den Filter "Gluten"
 * 
 * @author	team equal-IT  // Kevin?
 * @mail	team@equal-it.de
 * @version 00.00.01 2016/05/16
 */

public class GlutenDatenbankMock implements Lebensmitteldatenbank {

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
	 * @param anfrageergebnis
	 * @param inhaltsstoff
	 * @return Ampelindikator
	 */
	@Override
	public Ampelindikator antwortEnthaeltInhaltsstoff(String anfrageergebnis, Inhaltsstoff inhaltsstoff) {
		if (inhaltsstoff == Inhaltsstoff.GLUTEN) {
			return Ampelindikator.ENTHALTEN;
		}
		return Ampelindikator.NICHT_ENTHALTEN;
	}

	// Hier fehlt die Moeglichkeit, eine weitere "Datenbank" abzufragen

}
