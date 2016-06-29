package datenbanken;

import datenbanken.Lebensmitteldatenbank;
import liv.Ampelindikator;
import liv.Inhaltsstoff;

/**
 * Project: LIV - Lebensmittelinhaltsstoffverifizierer
 * 
 * class HttpAbfrageMock1 Mock Up fuer die Datenbankabfrage 
 * Filter "Gluten"
 * 
 * @author team equal-IT 
 * @mail team@equal-it.de
 * @version 00.00.01 2016/05/16
 */

public class GlutenDatenbankMock implements Lebensmitteldatenbank {

	/**
	 * @param ean
	 *            abzufragende EAN
	 * @param antwort
	 *            Rückgabe der Abfrage
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
		return Ampelindikator.UNBEKANNT;
		/**
		 * Variante fuer GlutenDatenbankMock Antwort. Wenn Filter gesetzt return
		 * Enthalten, wenn Filter nicht gesetzt return nicht Enthalten
		 * 
		 * if (inhaltsstoff == Inhaltsstoff.GLUTEN) { return
		 * Ampelindikator.ENTHALTEN; } return Ampelindikator.NICHT_ENTHALTEN;
		 */
	}
}
