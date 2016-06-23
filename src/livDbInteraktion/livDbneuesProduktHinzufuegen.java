package livDbInteraktion;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import eingaben.Konsoleneingabe;

/**
 * 
 * @author felix
 *
 */
public class livDbneuesProduktHinzufuegen {

	public static void neuesProduktHinzufuegen() {
		System.out.println(
				"\n---------------------------------------\n" + "ACHTUNG FUNKTIONIERT SCHON UND AENDERT DIE LV DB!!!\n"
						+ "---------------------------------------\n");
		System.out.println("Authentifizieren Sie sich bitte!");
		System.out.print("Benutzer Namen eingeben (test benutzer 'test'):");
		String benutzerName = Konsoleneingabe.leseKonsole();
		System.out.print("Password eingeben (test password 'testdb'):");
		String benutzerPassword = Konsoleneingabe.leseKonsole();

		String ean = null;
		String name = null;
		String laktose = null;
		String gluten = null;
		String nuss = null;

		try {

			System.out.print(
					"\nNeues Produkt anlegen!" + "\nBsp.: gueltige test ean: 5449000096241\nProdukt ean eingeben: \n");
			ean = Konsoleneingabe.leseKonsoleFuerEanEingabe();
			System.out.print("Produkt Namen eingeben: ");
			name = Konsoleneingabe.leseKonsole();
			System.out.print("Produkt enhält laktose (0=nein 1=ja): ");
			laktose = Konsoleneingabe.leseKonsoleFuer(Arrays.asList("0", "1"));
			System.out.print("Produkt enhält gluten (0=nein 1=ja): ");
			gluten = Konsoleneingabe.leseKonsoleFuer(Arrays.asList("0", "1"));
			System.out.print("Produkt enhält nuss (0=nein 1=ja): ");
			nuss = Konsoleneingabe.leseKonsoleFuer(Arrays.asList("0", "1"));
		} catch (Exception e) {
			System.out.print("Problem beim Produkt einlesen!");
			e.printStackTrace();
		}
		// verbindung zur DB wird aufgebaut
		datenbanken.LivDatenbank.livDbTreiberLaden();
		Connection connection = datenbanken.LivDatenbank.openLivDbConnectionForUser(benutzerName, benutzerPassword);
		// SQL Statement wird erstellt
		Statement stmt;
		try {
			stmt = connection.createStatement();
			// löscht die test ean wenn test ean für insert benutzt wird
			if (ean.equals("5449000096241")) {
				String sqlTestProduktloeschen = "DELETE FROM `ean` WHERE `ean`.`ean` = '5449000096241';";
				stmt.executeUpdate(sqlTestProduktloeschen);
			}
			String sql = "INSERT INTO `ean` (`ean`, `name`, `laktose`, `gluten`, `nuss`) VALUES ('" + ean + "', '"
					+ name + "', '" + laktose + "', '" + gluten + "', '" + nuss + "') ";
			stmt.executeUpdate(sql);
			System.out.println("\nFuege, ean: " + ean + " name: " + name + " laktose " + laktose + " gluten " + gluten
					+ " nuss " + nuss + ", zur LIV DB hinzu.");
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("Probleme beim Produkt hinzufügen in Liv DB!");
			e.printStackTrace();
		}

	}
}