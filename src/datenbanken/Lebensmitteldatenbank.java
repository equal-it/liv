package datenbanken;

import filter.Inhaltsstoff;
import ampel.Ampelindikator;

/**
 * Project: Liv - Lebensmittelinhaltsstoffverifizierer
 * 
 * class Lebensmitteldatenbank
 * 
 * @author team equal-IT
 * @mail: team@equal-it.de
 * @version  1.0 2016/07/08
 */

public interface Lebensmitteldatenbank {

	String frageNach(final String ean);

	Ampelindikator antwortEnthaeltInhaltsstoff(final String anfrageergebnis, final Inhaltsstoff inhaltsstoff);
}
