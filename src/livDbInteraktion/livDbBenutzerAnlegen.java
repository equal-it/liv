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

		// Menueausgabe, benutzernamen und password einlesen
		System.out.println("\nNeuen Benutzer anlegen! (Name und Password)\n" + "Benutzer Name eingeben: ");
		try {
			benutzerName = br.readLine();
		} catch (IOException e) {
			System.out.println("Problem beim Benutz Namen einlesen!");
		}
		System.out.println("Password eingeben: ");
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
			stmt = connection.createStatement();
			// Dummy fuer Benutzer erstellen
			System.out.println("DUMMY Benutzer wird in DB erstellt!!!\n"
					+ "hier fehlen die SQL Statments um einen Benutzer zu erstellen");
			System.out.println(
					"DUMMY Benutzer: " + benutzerName + " mit Password: " + benutzerPassword + " wird ersetellt");
			/*
			 * Hier muss ein SQL Statement rein um einen Benutzer zu erzeugen
			 * 
			 */
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("Probleme beim User in Liv DB erstellen");
			e.printStackTrace();
		}

	}

}
