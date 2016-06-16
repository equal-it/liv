package datenbankAbfragen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LivDatenbankAnfrage {
	
	public static void synologyDbAbfrage() {
		Connection connection = null;
		try {
			// DB Treiben in java laden
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

}
