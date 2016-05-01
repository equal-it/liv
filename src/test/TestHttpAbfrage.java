/**
 * 
 */
package test;

import liv.HttpAbfrage;

/**
 * Test Klasse f�r HttpAbfrage.java
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
		HttpAbfrage datenAbfrage01 = new HttpAbfrage();
		// setzt die Barcode Nummer in der Klasse HttpAbfrage
		datenAbfrage01.setEan(ean);
		// f�hrt Testanfrage aus
		System.out.println("Testing - Send Http GET request to www.laktonaut.de/api");
		datenAbfrage01.sendGet();
	}

}
