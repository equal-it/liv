package userinterface;

import java.sql.SQLException;
import java.util.Arrays;

import eingaben.Konsoleneingabe;
import livdatenbank.LivDbBenutzerAnlegen;

/**
 * Project: LIV - Lebensmittelinhaltsstoffverifizierer
 * 
 * class livDbInteraktionsmenue fuer class livdb
 * 
 * @author team equal-IT 
 * @mail: team@equal-it.de
 * @version 1.0 2016/07/08
 */

public class livDbInteraktionsmenue {

	public static void livDbMenue() {
		System.out.println("--------------------------------------------\n");
		System.out.println("Haben Sie einen Benutzernamen?");
		System.out.println("--------------------------------------------\n");
		System.out.println("1 - ja\n2 - nein");
		System.out.println("--------------------------------------------");
		String habeBenutzername = Konsoleneingabe.leseKonsoleFuer(Arrays.asList(new String[] { "1", "2" }));
		if (habeBenutzername.equals("2")) {
			System.out.println("--------------------------------------------\n");
			System.out.println("Sie muessen erst einen Benutzer anlegen");
			System.out.println("Wollen Sie einen neuen Benutzer anlegen?");
			System.out.println("--------------------------------------------\n");
			System.out.println("1 - ja\n2 - nein");
			System.out.println("--------------------------------------------");
			String willBenutzerAnlegen = Konsoleneingabe.leseKonsoleFuer(Arrays.asList(new String[] { "1", "2" }));
			if (willBenutzerAnlegen.equals("1")) {
				try {
					LivDbBenutzerAnlegen.benutzerAnlegen();
				} catch (SQLException e) {
					System.out.println("Benutzer anlegen fehlgeschlagen!");
					e.printStackTrace();
				}
			} else {
				System.out.println("Produkt hinzufügen abgebrochen!");
			}
		} else {
			try {
				livdatenbank.LivDbneuesProduktHinzufuegen.neuesProduktHinzufuegen();
			} catch (Exception e) {
				System.out.println("Produkt in LIV-Datenbank anlegen ist fehlgeschlagen!");
			}
		}
	}
}
