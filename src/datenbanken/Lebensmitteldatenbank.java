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
 * @version  00.00.02 2016/05/09
 */

public interface Lebensmitteldatenbank {

	String frageNach(final String ean);

	Ampelindikator antwortEnthaeltInhaltsstoff(final String anfrageergebnis, final Inhaltsstoff inhaltsstoff);
}
