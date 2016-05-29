package liv;

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

	@Override
	public Ampelindikator antwortEnthaeltInhaltsstoff(String anfrageergebnis, Inhaltsstoff inhaltsstoff) {
		return Ampelindikator.UNBEKANNT;
	}

	// Hier fehlt die Moeglichkeit, eine weitere "Datenbank" abzufragen

}
