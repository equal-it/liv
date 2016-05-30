package livRefactor;

import java.io.BufferedReader;

/**
 * Project: LIV - Lebensmittelinhaltverifizierer

 * 
 * @author team equal-IT
 * mail: team@equal-it.de
 * @version  00.00.02 2016/05/01 - 13:45
 * 
 * Link Vorlage fuer http-Anfrage:
 * http://www.mkyong.com/java/how-to-send-http-request-getpost-in-java/
 * 
 * Laktonaut API Doku:
 * http://www.laktonaut.de/api-doku.html
 */

//erstmal nicht erforderlich
/*
import java.io.DataOutputStream;
*/
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

// To Do: Ergebnis von class PruefeEAN einbauen: muss bei ean=false abfangen!

/**
 * Project: LIV - Lebensmittelinhaltverifizierer
 * 
 * class HttpAbfrage
 * 
 * @author team equal-IT
 * @mail: team@equal-it.de
 * @version 00.00.04 2016/05/02
 */

public class HttpAbfrageLaktonaut implements Lebensmitteldatenbank {

	private final static String USER_AGENT = "Mozilla/5.0";

	public static String laktose;

	public static String getLaktose() {
		return laktose;
	}

	/*
	 * HTTP GET request gtin
	 * 
	 * GTIN (EAN) des gesuchten Artikels
	 * 
	 * Eine gueltige GTIN ist ein String aus zumeist 8 oder 13, manchmal auch 12
	 * oder 14 Ziffern. Formal akzeptiert werden allerdings Strings beliebiger
	 * Laenge. Alle nichtnumerischen Zeichen (beispielsweise Trennzeichen)
	 * werden dabei ignoriert. Fuehrende Nullen sind jedoch von Bedeutung - eine
	 * GTIN ist ein String und keine Zahl, 0000012345670 also etwas anderes als
	 * 12345670.
	 * 
	 * Die Angabe wird unabhaengig von ihrer Laenge als vollstaendige GTIN
	 * interpretiert. Eine Suche nach Teil-GTINs ist derzeit nicht moeglich.
	 * -----------------------------------------------------------------------
	 * key
	 * 
	 * Persoenlicher Zugangsschluessel des Clients; wird auf Anfrage zugeteilt
	 * 
	 * Zu Testzwecken kann der Schluessel test verwendet werden. Dieser ist
	 * jedoch einer Begrenzung unterworfen, was die Zahl der Anfragen pro IP und
	 * Zeiteinheit angeht.
	 * -----------------------------------------------------------------------
	 * Muster URL =
	 * http://www.laktonaut.de/api.php?action=query&gtin=gtin&key=key Beispiel
	 * URL =
	 * http://www.laktonaut.de/api.php?action=query&gtin=4000417025005&key=test
	 * 
	 */
	public static String sendGet(String ean) throws Exception {

		String url = "http://www.laktonaut.de/api.php?action=query&gtin=" + ean + "&key=test ";

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		// add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		// Bei Problemen mit der Connection die naechsten drei Zeilen wieder
		// aktivieren
		// int responseCode = con.getResponseCode();
		// System.out.println("\nSending 'GET' request to URL : " + url);
		// System.out.println("\nResponse Code : " + responseCode + " (wenn 200
		// ist alles OK)");

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer xmlResponse = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			xmlResponse.append(inputLine);
		}

		in.close();

		return xmlResponse.toString();

	}// sendGet

	@Override
	public String frageNach(String ean) {
		try {
			return sendGet(ean);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Ampelindikator antwortEnthaeltInhaltsstoff(String anfrageergebnis, Inhaltsstoff inhaltsstoff) {
		if (inhaltsstoff == Inhaltsstoff.LAKTOSE) {
			String[] schritt1 = anfrageergebnis.split("<lactose>");
			String[] schritt2 = schritt1[1].split("</lactose>");
			String ergebnis = schritt2[0];
			return "yes".equals(ergebnis) ? Ampelindikator.ENTHALTEN : Ampelindikator.NICHT_ENTHALTEN;
		}
		return Ampelindikator.UNBEKANNT;
	}

} // end class