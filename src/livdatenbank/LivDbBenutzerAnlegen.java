package livdatenbank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Project: LIV - Lebensmittelinhaltsstoffverifizierer
 * 
 * class livDbBenutzerAnlegen
 * 
 * @author team equal-IT 
 * @mail: team@equal-it.de
 * @version 1.0 2016/07/08
 */

public class LivDbBenutzerAnlegen {

	/**
	 * @throws SQLException
	 * 
	 */

	public static void benutzerAnlegen() throws SQLException {

		// benutzername und benutzerpassword für neuen DB Benutzer
		String benutzerName = null;
		String benutzerPassword = null;

		InputStreamReader inReader = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(inReader);

		System.out.println("\n---------------------------------------\n"
				+ "ACHTUNG FUNKTIONIERT SCHON UND AENDERT DIE LV DB!!!\n" + "---------------------------------------");

		// Menueausgabe, benutzernamen und password einlesen
		System.out.print("\nNeuen Benutzer anlegen! (Name und Passwort)\n" + "\nBenutzername eingeben: ");
		try {
			benutzerName = br.readLine();
		} catch (IOException e) {
			System.out.println("Problem beim Einlesen des Benutzernamen!");
		}
		System.out.print("Passwort eingeben: ");
		try {
			benutzerPassword = br.readLine();
		} catch (IOException e) {
			System.out.println("Problem beim Einlesen des Passwortes!");
			e.printStackTrace();
		}

		// verbindung zur DB wird aufgebaut
		livdatenbank.LivDatenbankConnectionService.livDbTreiberLaden();
		Connection connection = livdatenbank.LivDatenbankConnectionService.openLivDbConnection();

		// SQL Statement wird erstellt
		Statement stmt;
		try {
			/*
			 * hilfe links mariaDB doc
			 * 
			 * https://mariadb.com/kb/en/mariadb/create-user/#examples
			 * https://mariadb.com/kb/en/mariadb/grant/#examples
			 * https://mariadb.com/kb/en/mariadb/account-management-sql-
			 * commands/
			 */

			stmt = connection.createStatement();

			String sqlBenutzerAnlegen = "CREATE USER '" + benutzerName + "'@'%' IDENTIFIED BY '" + benutzerPassword
					+ "';";
			String sqlBenutzerRechtVergeben = "GRANT SELECT, INSERT, UPDATE, DELETE ON  liv.ean to '" + benutzerName
					+ "'@'%' WITH GRANT OPTION;";
			try {
				stmt.executeUpdate(sqlBenutzerAnlegen);
			} catch (Exception e) {
				System.out.println("Benutzer anlegen fehlgeschlagen. Der Benutzer ist bereits vorhanden");
				//System.out.println(e.getMessage());
			}
			try {
				stmt.executeUpdate(sqlBenutzerRechtVergeben);
			} catch (Exception e) {
				System.out.println("Rechte vergeben geht nicht");
				//System.out.println(e.getMessage());
			}
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("Probleme beim Erstellen des Users in der Liv-Datenbank.");
			e.printStackTrace();
		}
		livdatenbank.LivDbneuesProduktHinzufuegen.neuesProduktHinzufuegen();
	}

}
