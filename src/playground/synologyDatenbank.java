package playground;

import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class synologyDatenbank {

	/**
	 * Main um Klasse testen zu können. Main kann weg wenn Klasse implementiert
	 * wird
	 * 
	 * @param args
	 */

	public static void main(String[] args) {

		synologyDbAbfrage();
	}

	/**
	 * Verbindung zur DB aufbauen, abfragen, antwort ausgeben
	 */
	
	public static void synologyDbAbfrage() {
		Connection connection = null;
		try {

			// Verbindung zum Server testen (eigentlich nicht notwendig)
			System.out.println("Teste Verbindung zum Server.");
			testServerConnection();

			// DB Treiben in java laden
			System.out.println("\nlade JDBC DB Treiber");
			try {
				Class.forName("org.mariadb.jdbc.Driver").newInstance();
			} catch (ClassNotFoundException e) {
				System.out.println("Die JDBC-Treiber-Klasse wurde nicht gefunden.");
				System.exit(1);
			} catch (Exception e) {
				System.out.println("Der JDBC-Treiber kann nicht geladen werden: " + e.getMessage());
				System.exit(1);
			}

			// Verbinung zur Datenbank aufbauen
			String dbUrl = "jdbc:mariadb://felixwyrwal.synology.me/liv";
			String dbBenutzerName = "liv";
			String dbBenutzerPassword = "livdb";
			
			connection = DriverManager.getConnection(dbUrl, dbBenutzerName, dbBenutzerPassword);
			System.out.println("\nVerbindung zur mariaDB aufgebaut.\n");

			// SQL Abfrage erstellen und Antwort ausgeben
			Statement stmt = connection.createStatement();
			ResultSet res;
			res = stmt.executeQuery("select * from ean");
			while (res.next()) {
				System.out.println(res.getString("name") + "\t");
				System.out.println(" Laktose: " + res.getInt("laktose") + " gluten: " + res.getInt("gluten") + " nuss: "
						+ res.getInt("nuss"));
			}
			stmt.close();

			// Verbindung zu DB beenden
			connection.close();
			System.out.println("\nVerbindung zur mariaDB abgebaut.");
		}

		catch (Exception e) {
			System.out.println("" + e.getMessage());
		}

	}

	/**
	 * Verbindung zu DB testen
	 */
	private static void testServerConnection() {
		try {

			URL obj = new URL("http://felixwyrwal.synology.me");
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			int responseCode = con.getResponseCode();
			System.out.println("\nSending test request to URL : " + "http://felixwyrwal.synology.me");
			System.out.println("\nServer Response Code : " + responseCode + " (wenn 200 ist alles OK)");
		}

		catch (Exception e) {
			System.out.println("keine Verbindung zum WebServer" + e.getMessage());
		}
	}
}
