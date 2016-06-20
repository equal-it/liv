package datenbankAbfragen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import liv.Ampelindikator;
import liv.Inhaltsstoff;

/**
 * Project: LIV - Lebensmittelinhaltverifizierer
 * 
 * @author team equal-IT mail: team@equal-it.de
 * @version 00.00.02 2016/06/20 - 23:25
 * 
 */

public class LivDatenbankAnfrage implements Lebensmitteldatenbank {
	private static final String dbUrl = "jdbc:mariadb://felixwyrwal.synology.me/liv";
	private static final String dbBenutzerName = "liv";
	private static final String dbBenutzerPassword = "livdb";

	public static void synologyDbAbfrage() {
		Connection connection = null;
		try {
			// DB Treiben in java laden
			treiberLaden();

			// Verbinung zur Datenbank aufbauen

			connection = DriverManager.getConnection(dbUrl, dbBenutzerName,
					dbBenutzerPassword);

			// SQL Abfrage erstellen und Antwort ausgeben
			Statement stmt = connection.createStatement();
			ResultSet res;
			res = stmt.executeQuery("select * from ean");
			while (res.next()) {
				System.out.println(res.getString("name") + "\t");
				System.out.println(" Laktose: " + res.getInt("laktose")
						+ " gluten: " + res.getInt("gluten") + " nuss: "
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

	private static void treiberLaden() {
		try {
			Class.forName("org.mariadb.jdbc.Driver").newInstance();
		} catch (ClassNotFoundException e) {
			System.out.println("Die JDBC-Treiber-Klasse wurde nicht gefunden.");
			System.exit(1);
		} catch (Exception e) {
			System.out.println("Der JDBC-Treiber kann nicht geladen werden: "
					+ e.getMessage());
			System.exit(1);
		}
	}

	@Override
	public String frageNach(String ean) {
		Connection connection = null;
		try {
			// DB Treiben in java laden
			treiberLaden();

			// Verbinung zur Datenbank aufbauen

			connection = DriverManager.getConnection(dbUrl, dbBenutzerName,
					dbBenutzerPassword);

			// SQL Abfrage erstellen und Antwort ausgeben
			Statement stmt = connection.createStatement();
			ResultSet res;
			res = stmt.executeQuery("select * from ean where ean = '" + ean
					+ "'");

			if (res != null) {
				// gefunden
				res.next();
				// name|0|0|1
				return "name: " + res.getString("name")
						+ ", laktose: ja, gluten: 1, nuss: ";
			} else {
				// nicht gefunden
				//
			}

			stmt.close();

			// Verbindung zu DB beenden
			connection.close();
			System.out.println("\nVerbindung zur mariaDB abgebaut.");
		}

		catch (Exception e) {
			System.out.println("" + e.getMessage());
		}
		return null;
	}

	@Override
	public Ampelindikator antwortEnthaeltInhaltsstoff(String anfrageergebnis,
			Inhaltsstoff inhaltsstoff) {
		// name: nnnnn, laktose: ,
		if (inhaltsstoff == Inhaltsstoff.LAKTOSE) {
			String[] schritt1 = anfrageergebnis.split("laktose:");
			String[] schritt2 = schritt1[1].split(",");
			String ergebnis = schritt2[0];
			if ("ja".equals(ergebnis))
				return Ampelindikator.ENTHALTEN;
			else
				return Ampelindikator.NICHT_ENTHALTEN;
		} else if (inhaltsstoff == Inhaltsstoff.GLUTEN) {
			return null;
		}
		return null;
	}

}
