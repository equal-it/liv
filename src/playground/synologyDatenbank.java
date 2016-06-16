package playground;

import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class synologyDatenbank {

	public static void main(String[] args) {

		testConnection();
	}

	public static void testConnection() {
		Connection connection = null;

		try {
			Class.forName("org.mariadb.jdbc.Driver"); 
			System.out.println("Teste Verbindung zum Server.");
			testServerConnection();
			System.out.println("\nlade DB Treiber");
			try {
				Class.forName("org.mariadb.jdbc.Driver").newInstance();
			} catch (ClassNotFoundException e) {
				System.out.println("Die Treiber-Klasse wurde nicht gefunden.");
				System.exit(1);
			} catch (Exception e) {
				System.out.println("Der JDBC-Treiber kann nicht geladen werden: " + e.getMessage());
				System.exit(1);
			}
			connection = DriverManager.getConnection("jdbc:mariadb://felixwyrwal.synology.me/liv","liv","livdb");
			System.out.println("\nVerbindung zur mariaDB aufgebaut.\n");
			
			Statement stmt = connection.createStatement();
			ResultSet res;
			res = stmt.executeQuery("select * from ean");
			while (res.next()){
				System.out.println(res.getString("name") + "\t");
				System.out.println(" Laktose: " + res.getInt("laktose") + 
				 " gluten: " + res.getInt("gluten") +
				" nuss: " + res.getInt("nuss"));
			}
			stmt.close();
			connection.close();
			System.out.println("\nVerbindung zur mariaDB abgebaut.");
		}

		catch (Exception e) {
			System.out.println("" + e.getMessage());
		}

	}

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
