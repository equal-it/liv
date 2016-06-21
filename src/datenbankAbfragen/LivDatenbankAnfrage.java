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

	@Override
	public String frageNach(String ean) {
		Connection connection = null;
		try {
			// DB Treiben in java laden
			treiberLaden();

			// Verbinung zur Datenbank aufbauen

			connection = DriverManager.getConnection(dbUrl, dbBenutzerName, dbBenutzerPassword);

			// SQL Abfrage erstellen und Antwort ausgeben
			Statement stmt = connection.createStatement();
			ResultSet res = null;

			res = stmt.executeQuery("select * from ean where ean = '" + ean + "'");
			try{
				res.next();
				String resString = "<name>" + res.getString("name") + "</name>" + "<laktose>" + res.getInt("laktose")
						+ "</laktose>" + "<gluten>" + res.getInt("gluten") + "</gluten>" + "<nuss>"
						+ res.getInt("nuss") + "</nuss>";
				stmt.close();
				connection.close();
				return resString;
			} catch (Exception e) {
				stmt.close();
				connection.close();
				return null;
			}

		}

		catch (Exception e) {
			System.out.println("" + e.getMessage());
		}
		return null;
	}

	@Override
	public Ampelindikator antwortEnthaeltInhaltsstoff(String anfrageergebnis, Inhaltsstoff inhaltsstoff) {
		String[] schritt1;
		String[] schritt2;
		String ergebnis;
		switch (inhaltsstoff) {
		case UNBEKANNT:
			return Ampelindikator.UNBEKANNT;
		case LAKTOSE:
			schritt1 = anfrageergebnis.split("<laktose>");
			schritt2 = schritt1[1].split("</laktose>");
			ergebnis = schritt2[0];
			if ("1".equals(ergebnis)) {
				return Ampelindikator.ENTHALTEN;
			} else if (("0".equals(ergebnis))) {
				return Ampelindikator.NICHT_ENTHALTEN;
			}
			return Ampelindikator.UNBEKANNT;
		case GLUTEN:
			schritt1 = anfrageergebnis.split("<gluten>");
			schritt2 = schritt1[1].split("</gluten>");
			ergebnis = schritt2[0];
			if ("1".equals(ergebnis)) {
				return Ampelindikator.ENTHALTEN;
			} else if (("0".equals(ergebnis))) {
				return Ampelindikator.NICHT_ENTHALTEN;
			}
			return Ampelindikator.UNBEKANNT;
		case NUSS:
			schritt1 = anfrageergebnis.split("<nuss>");
			schritt2 = schritt1[1].split("</nuss>");
			ergebnis = schritt2[0];
			if ("1".equals(ergebnis)) {
				return Ampelindikator.ENTHALTEN;
			} else if (("0".equals(ergebnis))) {
				return Ampelindikator.NICHT_ENTHALTEN;
			}
			return Ampelindikator.UNBEKANNT;
		default:
			return Ampelindikator.UNBEKANNT;
		}
	}

	private static void treiberLaden() {
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
}
