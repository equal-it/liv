package liv;

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

public class HttpAbfrageLaktonaut {
	
	// Testabfrage - allerdings fehlt noch der tatsaechliche Abbruch, aber der Parameter wird geprueft.
	{
	if (liv.PruefeEAN.eanIsOK = false){
			System.out.println("Abbruch - da EAN ungültig, findet keine DB-Abfrage statt. (Klasse HttpAbfrageLaktonaut)");
	}
	else{
		System.out.println("DB wird nun aufgerufen. (Klasse HttpAbfrageLaktonaut)");
	}
	}

	private final static String USER_AGENT = "Mozilla/5.0";

	public String ean = null;

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
	public static void sendGet(String ean) throws Exception {
			
		String url = "http://www.laktonaut.de/api.php?action=query&gtin=" + ean + "&key=test ";

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		// add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		//Bei Problemen mit der Connection die naechsten drei Zeilen wieder aktivieren
		//int responseCode = con.getResponseCode();
		//System.out.println("\nSending 'GET' request to URL : " + url);
		//System.out.println("\nResponse Code : " + responseCode + " (wenn 200 ist alles OK)");

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer xmlResponse = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			xmlResponse.append(inputLine);
		}

		in.close();
		// hier werden die beiden Zeichen hinter <lactose>XX abgefragt (die XX)
		int laktoseIndex = xmlResponse.lastIndexOf("<lactose>");
		String laktoseValue = xmlResponse.substring(laktoseIndex + 9, laktoseIndex + 11);

		switch (laktoseValue) {
		case "no":
			laktose = "no";
			break;
		case "ye":
			laktose = "yes";
			break;
		default:
			laktose = "unbekannt";
			break;
		}
		//System.out.println("\nLaktose enhalten : " + laktose);
	}// sendGet

	// --- Ab hier erstmal nicht wichtig: ---//

	// erstmal kein https erforderlich - ggf. spaeter einbinden

	// import javax.net.ssl.HttpsURLConnection;

	// public static void main(String[] args) throws Exception {

	// laktonaut.de API per GET zu erreichen POST ertmal nicht relevant
	//
	// System.out.println("\nTesting 2 - Send Http POST request");
	// http.sendPost();

	// }

	/*
	 * HTTP POST request private void sendPost() throws Exception {
	 * 
	 * String url = "https://selfsolve.apple.com/wcResults.do"; URL obj = new
	 * URL(url); HttpsURLConnection con = (HttpsURLConnection)
	 * obj.openConnection();
	 * 
	 * //add reuqest header con.setRequestMethod("POST");
	 * con.setRequestProperty("User-Agent", USER_AGENT);
	 * con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
	 * 
	 * String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";
	 * 
	 * // Send post request con.setDoOutput(true); DataOutputStream wr = new
	 * DataOutputStream(con.getOutputStream()); wr.writeBytes(urlParameters);
	 * wr.flush(); wr.close();
	 * 
	 * int responseCode = con.getResponseCode(); System.out.println(
	 * "\nSending 'POST' request to URL : " + url); System.out.println(
	 * "Post parameters : " + urlParameters); System.out.println(
	 * "Response Code : " + responseCode);
	 * 
	 * BufferedReader in = new BufferedReader( new
	 * InputStreamReader(con.getInputStream())); String inputLine; StringBuffer
	 * response = new StringBuffer();
	 * 
	 * while ((inputLine = in.readLine()) != null) { response.append(inputLine);
	 * } in.close();
	 * 
	 * //print result System.out.println(response.toString());
	 * 
	 * }
	 */

} // end class