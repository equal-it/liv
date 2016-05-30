package livRefactor;

public interface Lebensmitteldatenbank {

	String frageNach(final String ean);

	Ampelindikator antwortEnthaeltInhaltsstoff(final String anfrageergebnis, final Inhaltsstoff inhaltsstoff);
}
