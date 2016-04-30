/**
 * Link Vorlage für http anfrage 
 * http://www.mkyong.com/java/how-to-send-http-request-getpost-in-java/
 */

package liv;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
//import javax.net.ssl.HttpsURLConnection;

public class HttpAbfrage {
	private final String USER_AGENT = "Mozilla/5.0";
	public static void main (String[] args) throws Exception {
		HttpAbfrage http = new HttpAbfrage();
		System.out.println("test - send http get request");
		http.sendGet();
	}
		//http get request
		private void sendGet() throws Exception {
		String url = "http://www.laktonaut.de/";
		URL obj = new URL (url);
		HttpAbfrage con=(HttpAbfrage) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRquestProperty("User-Agent", USER_AGENT);
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
		BufferedReader in = new StringBuffer();
		while ((inputLine = in.readline()) !=null) {
			response.append(inputLine);			
			}
		in.close();
		
	}
}