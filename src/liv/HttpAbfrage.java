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

//erstmal kein https erforderlich
/*
import javax.net.ssl.HttpsURLConnection;
*/

public class HttpAbfrage {

	private final String USER_AGENT = "Mozilla/5.0";

	public String ean = null;

	public void setEan(String ean) {
		this.ean = ean;
	}

	//public static void main(String[] args) throws Exception {



		// laktonaut.de API per GET zu erreichen POST ertmal nicht relevant
		/*
		 * System.out.println("\nTesting 2 - Send Http POST request");
		 * http.sendPost();
		 */

	//}

	// HTTP GET request
	public void sendGet() throws Exception {

		/*
		 * gtin
		 * 
		 * GTIN (EAN) des gesuchten Artikels
		 * 
		 * Eine g�ltige GTIN ist ein String aus zumeist 8 oder 13, manchmal auch
		 * 12 oder 14 Ziffern. Formal akzeptiert werden allerdings Strings
		 * beliebiger L�nge. Alle nichtnumerischen Zeichen (beispielsweise
		 * Trennzeichen) werden dabei ignoriert. F�hrende Nullen sind jedoch von
		 * Bedeutung � eine GTIN ist ein String und keine Zahl, 0000012345670
		 * also etwas anderes als 12345670.
		 * 
		 * Die Angabe wird unabh�ngig von ihrer L�nge als vollst�ndige GTIN
		 * interpretiert. Eine Suche nach Teil-GTINs ist derzeit nicht m�glich.
		 * -----------------------------------------------------------------------
		 * key
		 * 
		 * Pers�nlicher Zugangsschl�ssel des Clients; wird auf Anfrage zugeteilt
		 * 
		 * Zu Testzwecken kann der Schl�ssel test verwendet werden. Dieser ist
		 * jedoch einer Begrenzung unterworfen, was die Zahl der Anfragen pro IP
		 * und Zeiteinheit angeht.
		 * -----------------------------------------------------------------------
		 * Muster   URL = http://www.laktonaut.de/api.php?action=query&gtin=gtin&key=key 
		 * Beispiel URL = http://www.laktonaut.de/api.php?action=query&gtin=4000417025005&key=test
		 * 
		 */

		String url = "http://www.laktonaut.de/api.php?action=query&gtin=" + ean + "&key=test ";

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		// add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("\nResponse Code : " + responseCode + " (wenn 200 ist alles OK)");

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		System.out.println("\n" + response.toString());

	}
	/*
	 * // HTTP POST request private void sendPost() throws Exception {
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
}