package livMitGui_liv;

import livMitGui_liv.Ampelindikator;
import livMitGui_liv.Inhaltsstoff;

public interface Lebensmitteldatenbank {

	String frageNach(final String ean);

	Ampelindikator antwortEnthaeltInhaltsstoff(final String anfrageergebnis, final Inhaltsstoff inhaltsstoff);
}
