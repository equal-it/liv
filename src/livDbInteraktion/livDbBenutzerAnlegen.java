package livDbInteraktion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author felix
 *
 */
public class livDbBenutzerAnlegen {

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
		System.out.print("\nNeuen Benutzer anlegen! (Name und Password)\n" + "\nBenutzer Name eingeben: ");
		try {
			benutzerName = br.readLine();
		} catch (IOException e) {
			System.out.println("Problem beim Benutz Namen einlesen!");
		}
		System.out.print("Password eingeben: ");
		try {
			benutzerPassword = br.readLine();
		} catch (IOException e) {
			System.out.println("Problem beim Benutzer Password einlesen!");
			e.printStackTrace();
		}

		// verbindung zur DB wird aufgebaut
		datenbanken.LivDatenbank.livDbTreiberLaden();
		Connection connection = datenbanken.LivDatenbank.openLivDbConnection();

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
				System.out.println("Benutzer anlegt!");
			} catch (Exception e) {
				System.out.println("Benutzer anlegen geht nicht");
				System.out.println(e.getMessage());
			}
			try {
				stmt.executeUpdate(sqlBenutzerRechtVergeben);
				System.out.println("Benutzer Rechte erteilt!");
			} catch (Exception e) {
				System.out.println("Rechte vergeben geht nicht");
				System.out.println(e.getMessage());
			}
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("Probleme beim User in Liv DB erstellen");
			e.printStackTrace();
		}
		livDbInteraktion.livDbneuesProduktHinzufuegen.neuesProduktHinzufuegen();
	}

}
