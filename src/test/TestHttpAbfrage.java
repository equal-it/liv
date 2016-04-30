/**
 * 
 */
package test;

import liv.HttpAbfrage;

/**
 * Test Klasse für HttpAbfrage
 * 
 * @author team equal-it / felix
 *
 */
public class TestHttpAbfrage {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// speichert EAN in var ean als String
		String ean = "4000417025005";
		// erzeugt Objekt http aus Klasse HttpAbfrage
		HttpAbfrage http = new HttpAbfrage();
		// setzt die Barcode Nummer in der Klasse HttpAbfrage
		http.setBarCodeNr(ean);
		// führt Testanfrage aus
		System.out.println("Testing - Send Http GET request to www.laktonaut.de/api");
		http.sendGet();
	}

}
