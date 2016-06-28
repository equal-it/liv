package livDbInteraktion;

import java.sql.SQLException;
import java.util.Arrays;

import eingaben.Konsoleneingabe;

/**
 * Project: LIV - Lebensmittelinhaltsstoffverifizierer
 * 
 * class livDbInteraktionsmenue
 * 
 * @author team equal-IT 
 * @mail: team@equal-it.de
 * @version 00.00.10 2016/06/16
 */

public class livDbInteraktionsmenue {

	public static void livDbMenue() {

		System.out.println("Haben Sie einen Benutzer Namen?");
		System.out.println("1 - ja\n2 - nein");
		String habeBenutzername = Konsoleneingabe.leseKonsoleFuer(Arrays.asList(new String[] { "1", "2" }));
		if (habeBenutzername.equals("2")) {
			System.out.println("Sie muessen erst einen Benutzer anlegen");
			System.out.println("Wollen Sie einene Benutzer anlegen?");
			System.out.println("1 - ja\n2 - nein");
			String willBenutzerAnlegen = Konsoleneingabe.leseKonsoleFuer(Arrays.asList(new String[] { "1", "2" }));
			if (willBenutzerAnlegen.equals("1")) {
				try {
					livDbBenutzerAnlegen.benutzerAnlegen();
				} catch (SQLException e) {
					System.out.println("Benutzer Anlegen fehlgeschlagen!");
					e.printStackTrace();
				}
			} else {
				System.out.println("Produnkt hinzufügen Abgebrochen!");
			}
		} else {
			try {
				livDbInteraktion.livDbneuesProduktHinzufuegen.neuesProduktHinzufuegen();
			} catch (Exception e) {
				System.out.println("Produkt in LIV DB anlegen fehlegschlagen!");
			}
		}
	}
}
