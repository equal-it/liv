package datenbanken;
import datenbanken.Lebensmitteldatenbank;
import liv.Ampelindikator;
import liv.Inhaltsstoff;

/**
 * Project: LIV - Lebensmittelinhaltverifizierer
 * 
 * class NussDatenbankMock Mock Up für die Datenbankabfrage für den Filter
 * "Nuss"
 * 
 * @author team equal-IT 
 * @mail team@equal-it.de
 * @version 00.00.01 2016/05/16
 */

public class NussDatenbankMock implements Lebensmitteldatenbank {

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
			antwort = "<nuss>yes</nuss>";
			break;
		case "2":
			antwort = "<nuss>no</nuss>";
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
		 * Variante fuer NussDatenbankMock antwort. Wenn Filter gesetzt return
		 * Enthalten, wenn Filter nicht gesetzt return nicht Enthalten
		 * 
		 * if (inhaltsstoff == Inhaltsstoff.NUSS) { return
		 * Ampelindikator.ENTHALTEN; } return Ampelindikator.NICHT_ENTHALTEN;
		 */
	}
}
