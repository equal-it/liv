package datenbanken;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LivDatenbank {

	private static final String dbUrl = "jdbc:mariadb://felixwyrwal.synology.me/liv";
	private static final String dbBenutzerName = "liv";
	private static final String dbBenutzerPassword = "livdb";

	public static void livDbTreiberLaden() {
		try {
			Class.forName("org.mariadb.jdbc.Driver").newInstance();
		} catch (ClassNotFoundException e) {
			System.out.println("Die JDBC-Treiber-Klasse wurde nicht gefunden.");
			System.exit(1);
		} catch (Exception e) {
			System.out.println("Der JDBC-Treiber kann nicht geladen werden: " + e.getMessage());
			System.exit(1);
		}
	}

	public static Connection openLivDbConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(dbUrl, dbBenutzerName, dbBenutzerPassword);
		} catch (SQLException e) {
			System.out.println("Liv DB Connection Problem");
			e.printStackTrace();
		}
		return connection;

	}
	
	
	
}