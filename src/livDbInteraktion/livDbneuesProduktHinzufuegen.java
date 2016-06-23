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

		String ean = null;
		String name = null;
		String laktose = null;
		String gluten = null;
		String nuss = null;

		try {
			System.out.println("\n---------------------------------------\n"
					+ "ACHTUNG FUNKTIONIERT SCHON UND AENDERT DIE LV DB!!!\n"
					+ "---------------------------------------");
			System.out.print("\nNeues Produkt anlegen! \n" + "Produkt ean eingeben: ");
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
		Connection connection = datenbanken.LivDatenbank.openLivDbConnection();
		// SQL Statement wird erstellt
		Statement stmt;
		try {
			stmt = connection.createStatement();
			stmt.executeUpdate("INSERT INTO `ean` (`ean`, `name`, `laktose`, `gluten`, `nuss`) VALUES ('" + ean + "', '"
					+ name + "', '" + laktose + "', '" + gluten + "', '" + nuss + "') ");
			System.out.println("Fuege : ean " + ean + " name " + name + " laktose " + laktose + " gluten " + gluten
					+ " nuss " + nuss + "\nZur LIV DB hinzu.");
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("Probleme beim Produkt hinzufügen in Liv DB!");
			e.printStackTrace();
		}

	}
}