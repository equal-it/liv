package liv;

import liv.Ampelindikator;
import liv.Inhaltsstoff;

public interface Lebensmitteldatenbank {

	String frageNach(final String ean);

	Ampelindikator antwortEnthaeltInhaltsstoff(final String anfrageergebnis, final Inhaltsstoff inhaltsstoff);
}
