package livdatenbank;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Arrays;

import eingaben.Konsoleneingabe;

/**
 * Project: LIV - Lebensmittelinhaltsstoffverifizierer
 * 
 * class livDbneuesProduktHinzufuegen
 * 
 * @author team equal-IT 
 * @mail: team@equal-it.de
 * @version 1.0 2016/07/08
 */

public class LivDbneuesProduktHinzufuegen {

	public static void neuesProduktHinzufuegen() {
		System.out.println("--------------------------------------------");
		System.out.println("DATENBANK-LOGIN");
		System.out.println("--------------------------------------------");
		
		System.out.print("Benutzername: ");
		String benutzerName = Konsoleneingabe.leseKonsole();
		System.out.print("Passwort: ");
		String benutzerPassword = Konsoleneingabe.leseKonsole();

		String ean = null;
		String name = null;
		String laktose = null;
		String gluten = null;
		String nuss = null;

		try {
			System.out.println	("\n--------------------------------------------" +
								 "\nNEUES PRODUKT ANLEGEN" + 
								 "\n--------------------------------------------");
			
			System.out.println ("Bsp.: gueltige Test_EAN: 5449000096241\n");			
			
			System.out.print("Produkt-Name eingeben: \t");
			name = Konsoleneingabe.leseKonsole();
			System.out.print("Produkt-EAN eingeben: \t");
			ean = Konsoleneingabe.leseKonsoleFuerEanEingabe();			
			System.out.print("Produkt enhält Laktose \t(0 = nein | 1 = ja): ");
			laktose = Konsoleneingabe.leseKonsoleFuer(Arrays.asList("0", "1"));
			System.out.print("Produkt enhält Gluten \t(0 = nein | 1 = ja): ");
			gluten = Konsoleneingabe.leseKonsoleFuer(Arrays.asList("0", "1"));
			System.out.print("Produkt enhält Nuss \t(0 = nein | 1 = ja): ");
			nuss = Konsoleneingabe.leseKonsoleFuer(Arrays.asList("0", "1"));
			System.out.println	("\n--------------------------------------------");
			
		} catch (Exception e) {
			System.err.print("Beim Anlegen des Produktes in der Datenbank ist ein Problem aufgetreten!");
			}
		try {
		// Verbindung zur DB wird aufgebaut
		livdatenbank.LivDatenbankConnectionService.livDbTreiberLaden();
		Connection connection = livdatenbank.LivDatenbankConnectionService.openLivDbConnectionForUser(benutzerName, benutzerPassword);
		// SQL Statement wird erstellt
		Statement stmt;

			stmt = connection.createStatement();
			// löscht die test ean wenn test ean für insert benutzt wird
			if (ean.equals("5449000096241")) {
				String sqlTestProduktloeschen = "DELETE FROM `ean` WHERE `ean`.`ean` = '5449000096241';";
				stmt.executeUpdate(sqlTestProduktloeschen);
			}
			String sql = "INSERT INTO `ean` (`ean`, `name`, `laktose`, `gluten`, `nuss`) VALUES ('" + ean + "', '"
					+ name + "', '" + laktose + "', '" + gluten + "', '" + nuss + "') ";
			stmt.executeUpdate(sql);
			System.out.println("\nDas folgende Produkt wurde zur Datenbank hinzugefügt:\n " +
					"\nProdukt-Name:\t" + name +  
					"\nProdukt-EAN:\t" 	+ ean + 
					"\nLaktose:\t" 		+ laktose + 
					"\nGluten:\t\t" 	+ gluten +
					"\nNuss:\t\t" 		+ nuss +
					"\n\nVielen Dank fuer Deine Unterstützung!");
			
			stmt.close();
			connection.close();
		} catch (Exception e) {
			System.err.println("Beim Anlegen des Produktes in der Datenbank ist ein Problem aufgetreten!");
		}

	}
}