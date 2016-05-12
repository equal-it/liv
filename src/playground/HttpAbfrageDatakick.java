package playground;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * class HttpAbfrageDatakick
 * 
 * Project: Liv - Lebensmittelinhaltverifizierer
 * 
 * @author Anne/Felix, anne@equal-it.de
 * @version 00.00.01 2016/05/10
 *
 */


public class HttpAbfrageDatakick {
	
	// https://www.datakick.org/api/items/000000000000
	// ean für test Ferrero Nutella 	4008400401928
	// ean für test Ferrero Kuesschen 	4008400154121

	private final static String USER_AGENT = "Mozilla/5.0";

	public String ean = null;

	public static void sendGet(String ean) throws Exception {
			
		String url = "https://www.datakick.org/api/items/" + ean;

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		// add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}

		in.close();
		
		System.out.println("datakick response: " + response.toString());

	}// sendGet


} // end class