

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * class Filter
 * 
 * Project: LIV - Lebensmittelinhaltverifizierer
 * 
 * @author team equal-IT, team@equal-it.de / felix, anne, mel
 * @version 00.00.10 2016/05/10
 *
 */

// Menue-Moeglichkeit einbauen, alle Filter anzeigen zu lassen!
// default-Filter ueberpruefen!
// um weiter Filter neben Laktose testen zu koennen, brauchen wir die Mocks!!

public class Filter {

	private static final String HAUPTMENU = "4";

	public static Set<Inhaltsstoff> setFilter() {
		// Scanner scanner = new Scanner(System.in);
		// String eingabe = "";
		// do {
		// eingabe = scanner.next();
		// System.out.println(eingabe);
		// } while (!"q".equals(eingabe));
		// scanner.close();

		Set<Inhaltsstoff> inhaltsstoffe = new HashSet<>();

		String auswahl = null;
		do {
			auswahl = null;
			menuAusgeben();

			Scanner scanner = new Scanner(System.in);
			if (scanner.hasNext()) {
				auswahl = scanner.next();
			}

			if (auswahl != null) {
				Inhaltsstoff inhaltsstoff = Inhaltsstoff.inhaltstoffFuerCode(auswahl);

				System.out.println(
						"\n---------------------------------------------------------------------(Klasse Filter)");
				switch (inhaltsstoff) {
				case LAKTOSE:
					setzeOderEntferneFilter(inhaltsstoffe, inhaltsstoff);
					break;

				case GLUTEN:
					setzeOderEntferneFilter(inhaltsstoffe, inhaltsstoff);
					break;

				case UNBEKANNT:
					break;
				}
			}
			scanner.close();
		} while (!HAUPTMENU.equals(auswahl));

		return inhaltsstoffe;
	}

	private static void menuAusgeben() {
		System.out.println("\n---------------------------------------------------------------------(Klasse Filter)");
		for (Inhaltsstoff stoff : Inhaltsstoff.values()) {
			if (stoff != Inhaltsstoff.UNBEKANNT)
				System.out.println("Waehle " + stoff.code() + " fuer " + stoff.anzeigename() + ".");
		}
		System.out.println("\nOder mit " + HAUPTMENU + " zum Hauptmenue. \n");
		System.out.println("---------------------------------------------------------------------");
	}

	private static void setzeOderEntferneFilter(Set<Inhaltsstoff> inhaltsstoffe, Inhaltsstoff inhaltsstoff) {

		try (InputStreamReader isr = new InputStreamReader(System.in); BufferedReader br = new BufferedReader(isr)) {

			String eingabeSetFilter;
			System.out.println("Filter '" + inhaltsstoff.anzeigename()
					+ "' setzen? \nBitte mit 'j' bestaetigen oder mit 'n' zurueck zur Auswahl: \n");

			eingabeSetFilter = br.readLine();

			switch (eingabeSetFilter) {
			case "j":
				inhaltsstoffe.add(inhaltsstoff);
				System.out.println("Filter '" + inhaltsstoff.anzeigename() + "' wurde hinzugefuegt. (Klasse Filter)");
				System.out.println("Weitere Filter setzen oder mit '4' zum Hauptmenue.\n");
				System.out.println("---------------------------------------------------------------------");
				break;
			case "n":
				inhaltsstoffe.remove(inhaltsstoff);
				System.out.println("Filter '" + inhaltsstoff.anzeigename() + "' wurde entfernt. (Klasse Filter)");
				break;
			default:
				System.out.println("Falsche Eingabe, bitte einen Filter auswaehlen. (Klasse Filter)");
				break;
			}
		} catch (IOException e) {
			System.out.println("Konnte Eingabe nicht lesen. Bitte erneut eingeben.");
		}

	}

}
