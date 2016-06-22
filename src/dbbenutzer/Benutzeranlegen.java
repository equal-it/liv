package dbbenutzer;

import java.util.Arrays;

import eingaben.Konsoleneingabe;

/**
 * Project: LIV - Lebensmittelinhaltverifizierer
 * 
 * @author team equal-IT mail: team@equal-it.de
 * 
 */

public class Benutzeranlegen {

	public static void bnanlegen() {
		ausgabe.BenutzeranlegenAusgabe.benutzeranlegenMenue();

		String eingabeMenueBenutzeranlegenDB = Konsoleneingabe
				.leseKonsoleFuer(Arrays.asList(new String[] { "1", "2" }));
		int auswahl = Integer.parseInt(eingabeMenueBenutzeranlegenDB); // String

		// System.out.println("Waehlen Sie \n" + "1 - Benutzer anlegen\n"
		// + "2 - Neues Produkt in Datenbank ergaenzen");

		switch (auswahl) {
		case 1:
			System.out.println("Benutzer anlegen: DUMMY");
			break;

		case 2:
			System.out.println("Neues Produkt in DB ergaenzen: DUMMY");
			break;

		default:
			System.out.println("Hier stimmt was nicht DUMMY");
			break;

		}

	}
}
