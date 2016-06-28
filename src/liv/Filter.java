package liv;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import eingaben.Konsoleneingabe;

/**
 * Project: LIV - Lebensmittelinhaltsstoffverifizierer
 * 
 * class Filter zeigt die moeglichen einzustellenden Filter und laesst diese
 * setzen oder entfernen
 * 
 * @author team equal-IT / Team-Abend
 * @mail team@equal-it.de
 * @version 00.00.10 2016/06/20
 *
 */

public class Filter {

	/**
	 * Methode, um die gesetzten Filter anzuzeigen
	 * 
	 * @param inhaltsstoffe
	 *            HashSet
	 * @param inhaltsstoff
	 *            zur Festlegung der jeweiligen Inhaltsstoffe
	 * @param auswahl
	 *            Menueauswahl per Konsoleneingabe
	 * @return inhaltsstoffe bla
	 */

	public static Set<Inhaltsstoff> setFilter() {

		Set<Inhaltsstoff> inhaltsstoffe = new HashSet<>();
		/*
		 * Kevins Baustelle try{ File file = new File("test.properties");
		 * FileInputStream fileInput = new FileInputStream(file); Properties
		 * properties = new Properties(); properties.load(fileInput);
		 * fileInput.close();
		 * 
		 * } catch (FileNotFoundException e) { e.printStackTrace(); } catch
		 * (IOException e) { e.printStackTrace();
		 * 
		 * }
		 */

		String auswahl = null;

		do {
			ausgabe.FiltermenueAusgabe.FilterHauptmenueAusgabe();

			auswahl = Konsoleneingabe.leseKonsoleFuer(Arrays.asList(new String[] { liv.Inhaltsstoff.LAKTOSE.code(),
					liv.Inhaltsstoff.GLUTEN.code(), liv.Inhaltsstoff.NUSS.code(),
					ausgabe.FiltermenueEintrage.FILTERANZEIGE.code(), ausgabe.FiltermenueEintrage.HAUPTMENUE.code() }));
			if (auswahl != null) {
				if (auswahl.equals(ausgabe.FiltermenueEintrage.FILTERANZEIGE.code())) {
					System.out.println("\n--------------------------------------------");
					System.out.println("\nAktiv gesetzte Filter: " + inhaltsstoffe.toString() + "");
				} else {
					Inhaltsstoff inhaltsstoff = Inhaltsstoff.inhaltstoffFuerCode(auswahl);
					switch (inhaltsstoff) {
					case LAKTOSE:
						setzeOderEntferneFilter(inhaltsstoffe, inhaltsstoff);
						break;
					case GLUTEN:
						setzeOderEntferneFilter(inhaltsstoffe, inhaltsstoff);
						break;
					case NUSS:
						setzeOderEntferneFilter(inhaltsstoffe, inhaltsstoff);
					case UNBEKANNT:
						break;
					}
				}
			}

		} while (!ausgabe.FiltermenueEintrage.HAUPTMENUE.code().equals(auswahl));

		return inhaltsstoffe;
	}

	/**
	 * Methode, um einen Filter für einen bestimmten Inhaltsstoff zu setzen oder
	 * zu entfernen
	 * 
	 * @param inhaltsstoffe
	 * @param inhaltsstoff
	 * @param eingabeSetFilter
	 */
	private static void setzeOderEntferneFilter(Set<Inhaltsstoff> inhaltsstoffe, Inhaltsstoff inhaltsstoff) {

		// Properties properties = new Properties(); Kevins Baustelle

		String eingabeSetFilter;
		System.out.println("\n--------------------------------------------");
		System.out.println("Moechtest du den Filter '" + inhaltsstoff.anzeigename() + "' setzen oder entfernen?");
		System.out.println("\n1 - zum setzen des Filters");
		System.out.println("2 - zum entfernen des Filters");
		System.out.println("\n--------------------------------------------");
		eingabeSetFilter = Konsoleneingabe.leseKonsoleFuer(Arrays.asList(new String[] { "1", "2" }));

		if (eingabeSetFilter != null) {
			switch (eingabeSetFilter) {
			case "1":
				inhaltsstoffe.add(inhaltsstoff);
				/*
				 * Kevins Baustelle try {
				 * properties.setProperty(inhaltsstoff.anzeigename(),
				 * "gesetzt");
				 * 
				 * File file = new File("test.properties"); FileOutputStream
				 * fileOut = new FileOutputStream(file);
				 * properties.store(fileOut, "livFilter"); fileOut.close(); }
				 * catch (FileNotFoundException e) { e.printStackTrace(); }
				 * catch (IOException e) { e.printStackTrace(); }
				 */
				System.out.println("\nDer Filter fuer '" + inhaltsstoff.anzeigename() + "' wurde hinzugefuegt.)");
				break;
			case "2":
				inhaltsstoffe.remove(inhaltsstoff);
				/*
				 * Kevins Baustelle try {
				 * properties.remove(inhaltsstoff.anzeigename(), "gesetzt");
				 * 
				 * File file = new File("test.properties"); FileOutputStream
				 * fileOut = new FileOutputStream(file);
				 * properties.store(fileOut, "livFilter"); fileOut.close(); }
				 * catch (FileNotFoundException e) { e.printStackTrace(); }
				 * catch (IOException e) { e.printStackTrace(); }
				 */

				System.out.println("\nDer Filter fuer '" + inhaltsstoff.anzeigename() + "' wurde entfernt.");
				break;
			default:
				System.out.println("\nFalsche Eingabe, bitte einen Filter auswaehlen.");
				break;
			}
		}
	}

}
