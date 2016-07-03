package datenbanken;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import liv.Ampelindikator;
import liv.Inhaltsstoff;

/**
 * Project: LIV - Lebensmittelinhaltsstoffverifizierer
 * 
 * class LivDatenbankAnfrage
 * 
 * @author team equal-IT 
 * @mail: team@equal-it.de
 * @version 00.00.10 2016/05/16
 */

public class LivDatenbankAnfrage implements Lebensmitteldatenbank {

	@Override
	public String frageNach(String ean) {
		Connection connection = null;
		try {
			// DB Treiben in java laden
			
			datenbanken.LivDatenbankConnectionService.livDbTreiberLaden();

			// Verbinung zur Datenbank aufbauen

			connection = datenbanken.LivDatenbankConnectionService.openLivDbConnection();

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


}
