package datenbanken;

import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 * Project: LIV - Lebensmittelinhaltverifizierer
 * 
 * @author team equal-IT
 * mail: team@equal-it.de
 * @version  00.00.10 2016/06/20 - 23:25
 * 
 * Link Vorlage fuer http-Anfrage:
 * http://www.mkyong.com/java/how-to-send-http-request-getpost-in-java/
 * 
 * Laktonaut API Doku:
 * http://www.laktonaut.de/api-doku.html
 */
import java.io.InputStreamReader;

import filter.Inhaltsstoff;
import ampel.Ampelindikator;

/**
 * Project: LIV - Lebensmittelinhaltsstoffverifizierer
 * 
 * class LaktonautDatenbankAbfrage
 * 
 * @author team equal-IT
 * @mail team@equal-it.de
 * @version 00.00.04 2016/05/02
 */

public class LaktonautDatenbankAbfrage implements Lebensmitteldatenbank {

	private final static String USER_AGENT = "Mozilla/5.0";

	public static String laktose;

	/**
	 * @return laktose
	 */

	public static String getLaktose() {
		return laktose;
	}

	/*
	 * Muster URL =
	 * http://www.laktonaut.de/api.php?action=query&gtin=gtin&key=key Beispiel
	 * URL =
	 * http://www.laktonaut.de/api.php?action=query&gtin=4000417025005&key=test
	 */

	/**
	 * Methode für die Datenbankabfrabe bei Laktonaut
	 * 
	 * @param url
	 * @param con
	 * @param inputLine
	 * @param in
	 * @param xmlResponse
	 * @throws Exception
	 * @return xmlResponse
	 */
	public static String sendGet(String ean) throws Exception {
		String url = "http://www.laktonaut.de/api.php?action=query&gtin=" + ean
				+ "&key=test ";

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("GET");

		con.setRequestProperty("User-Agent", USER_AGENT);

		// Bei Connection Problemen auskommentierte Zeilen aktivieren
		//
		// int responseCode = con.getResponseCode();
		// System.out.println("\nSending 'GET' request to URL : " + url);
		// System.out.println("\nServer Response Code : " + responseCode + "
		// (wenn 200
		// ist alles OK)");

		BufferedReader in = new BufferedReader(new InputStreamReader(
				con.getInputStream()));
		String inputLine;
		StringBuffer xmlResponse = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			xmlResponse.append(inputLine);
		}

		in.close();

		return xmlResponse.toString();

	}// sendGet

	/**
	 * @param ean
	 *            abzufragende EAN
	 * @throws Exception
	 *             e
	 * 
	 * @return null
	 */
	@Override
	public String frageNach(String ean) {
		try {
			return sendGet(ean);
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("Fehler bei der Laktonaut-Serverabfrage.\n"
					+ "Tip: Internet ist notwendig fuer Serverabfrage.");
			return null;
		}
	}

	/**
	 * Methode welche ausgeführt wird, wenn der Inhaltsstoff enthalten ist
	 * 
	 * @param anfrageergebnis
	 * @param inhaltsstoff
	 *            abgefragter Inhaltsstoff
	 * @param schritt1
	 *            Array
	 * @param schritt2
	 *            Array
	 * @param ergebnis
	 * @return Ampelindikator
	 */
	@Override
	public Ampelindikator antwortEnthaeltInhaltsstoff(String anfrageergebnis,
			Inhaltsstoff inhaltsstoff) {
		if (inhaltsstoff == Inhaltsstoff.LAKTOSE) {
			String[] schritt1 = anfrageergebnis.split("<lactose>");
			String[] schritt2 = schritt1[1].split("</lactose>");
			String ergebnis = schritt2[0];
			if ("yes".equals(ergebnis))
				return Ampelindikator.ENTHALTEN;
			else
				return Ampelindikator.NICHT_ENTHALTEN;
		}
		return Ampelindikator.UNBEKANNT;
	}

} // end class