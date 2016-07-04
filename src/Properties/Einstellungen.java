package Properties;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import liv.Inhaltsstoff;

public class Einstellungen {

	private static final String EINSTELLUNGEN = "einstellungen.properties";
	private static final String AKTUELLER_FILTER = "aktueller_Filter";

	public Properties properties = null;
	public String dateipfad = EINSTELLUNGEN;

	public void schreibeAktuellenFilter(Set<Inhaltsstoff> inhaltsstoffe) {
		Set<String> anzeigenamen = new HashSet<>();
		for (Inhaltsstoff inhaltsstoff : inhaltsstoffe) {
			anzeigenamen.add(inhaltsstoff.anzeigename());
		}
		String filterwert = String.join(",", anzeigenamen);
		schreibeEinstellung(AKTUELLER_FILTER, filterwert);
	}

	public Set<Inhaltsstoff> leseAktuellenFilter() {
		Set<Inhaltsstoff> aktuellerFilter = new HashSet<>();
		String filterAlsText = leseEinstellung(AKTUELLER_FILTER);
		if (filterAlsText != null && !filterAlsText.isEmpty()) {
			String[] anzeigenamen = filterAlsText.split(",");
			for (String name : anzeigenamen) {
				aktuellerFilter.add(Inhaltsstoff
						.inhaltstoffFuerAnzeigenamen(name));
			}
		}
		return aktuellerFilter;
	}

	String leseEinstellung(final String einstellung) {
		if (properties == null) {
			ladePropertiesDatei();
		}
		return this.properties.getProperty(einstellung);
	}

	void schreibeEinstellung(final String einstellung, final String wert) {
		if (properties == null) {
			ladePropertiesDatei();
		}
		this.properties.put(einstellung, wert);
		schreibePropertiesDatei();
	}

	private void ladePropertiesDatei() {
		Properties properties = new Properties();
		try (FileInputStream inStream = new FileInputStream(dateipfad)) {
			properties.load(inStream);
		} catch (IOException e) {
			System.err.println("Fehler beim Laden der Datei: " + EINSTELLUNGEN);
		}
		this.properties = properties;
	}

	public void schreibePropertiesDatei() {
		String comment = "Properties aktualisiert am:";
		try (FileOutputStream out = new FileOutputStream(dateipfad)) {
			this.properties.store(out, comment);
		} catch (IOException e) {
			System.err.println("Fehler beim Schreiben der Datei: " + dateipfad);
		}
	}

	public static void main(String[] args) {
		// Test
		Einstellungen einstellungen = new Einstellungen();
		einstellungen.dateipfad = "test.properties"; // nur fuer Test umstellen

		einstellungen.ladePropertiesDatei();
		System.out.println(einstellungen.dateipfad + " gefunden.");

		einstellungen.schreibeEinstellung("test", "erfolgreich");
		einstellungen.schreibePropertiesDatei();
		System.out.println(einstellungen.dateipfad + " geschrieben.");

		// aktuellen Filter schreiben
		Set<Inhaltsstoff> inhaltsstoffe = new HashSet<>();
		inhaltsstoffe.add(Inhaltsstoff.NUSS);
		inhaltsstoffe.add(Inhaltsstoff.UNBEKANNT);
		einstellungen.schreibeAktuellenFilter(inhaltsstoffe);

		// aktuellen Filter lesen
		Set<Inhaltsstoff> aktuellerFilter = einstellungen.leseAktuellenFilter();
		aktuellerFilter.contains(Inhaltsstoff.UNBEKANNT);
		aktuellerFilter.contains(Inhaltsstoff.NUSS);

		// aufraeumen
		einstellungen.properties.clear();
		einstellungen.schreibePropertiesDatei();
	}
}
