package livDbInteraktion;

import java.sql.SQLException;
import java.util.Arrays;

import eingaben.Konsoleneingabe;

/**
 * Project: LIV - Lebensmittelinhaltverifizierer
 * 
 * @author team equal-IT mail: team@equal-it.de
 * 
 */

public class livDbInteraktionsmenue {

	public static void livDbMenue() {
		
		ausgabe.BenutzeranlegenAusgabe.benutzeranlegenMenue();

		String eingabeMenueBenutzeranlegenDB = Konsoleneingabe
				.leseKonsoleFuer(Arrays.asList(new String[] { "1", "2" }));
		int auswahl = Integer.parseInt(eingabeMenueBenutzeranlegenDB); // String

		switch (auswahl) {
		// case 1 benutzer anlegen
		case 1:
			try {
				livDbBenutzerAnlegen.benutzerAnlegen();
			} catch (SQLException e) {
				System.out.println("Benutzer Anlegen fehlgeschlagen!");
				e.printStackTrace();
			}
			break;
			
		// case 2 neues Produkt in LIV DB schreiben
		case 2:
			try{
			livDbInteraktion.livDbneuesProduktHinzufuegen.neuesProduktHinzufuegen();
			}catch (Exception e){
				System.out.println("Produkt in LIV DB anlegen fehlegschlagen!");
			}
			break;

		default:
			System.out.println("Hier stimmt was nicht DUMMY");
			break;

		}

	}
}
