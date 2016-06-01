package livMitGui_liv;

/**
 * Project: Liv - Lebensmittelinhaltverifizierer
 * 
 * @author team equal-IT // Anicas Baustelle
 * @mail: team@equal-it.de
 * @version 00.00.03 2016/04/28
 */

public final class PruefeEAN {

	public static boolean eanGueltig(String eanString) throws Exception {
		return pruefeEAN(eanString);
	}

	public static boolean eanUngueltig(String eanString) throws Exception {
		return !eanGueltig(eanString);
	}

	/**
	 * Methode prüft 13 stellige EAN code auf gueltigkeit
	 * 
	 * Zeile 45 die 11 und Zeile 64 ean[12] zeigen das hier nur 13 stellige EAN
	 * geprüft werden können ist in der PrüfeEANorginal auch so gewesen
	 * 
	 * @param eanString
	 *            muss aus 13 zahlenzeichen bestehen
	 */
	private static boolean pruefeEAN(String eanString) throws Exception {

		try {
			int[] ean = new int[eanString.length()];
			char[] eanChar = new char[eanString.length()];

			// wandelt eanString in eanChar[]
			for (int i = 0; i < eanString.length(); i++) {
				eanChar[i] = eanString.charAt(i);
			}
			// wandelt eanChar[] in int[] (ean[])
			for (int i = 0; i <= eanString.length() - 1; i++) {
				ean[i] = Character.getNumericValue(eanChar[i]);
			}
			// berechnungen zur ean gueltigkeitsprüfung
			int summe1 = 0;
			int summe2 = 0;
			int summe3 = 0;
			int summe4 = 0;

			for (int i = 0; i <= 11; i++) {
				// Abfrage ob das Array-Feld eine gerade oder ungerade Zahl ist
				if (i % 2 == 0) {
					// Array-Feld gerade fuege den Wert der Variable summe1
					// hinzu
					summe1 = summe1 + ean[i];
				} else {
					// Array-Feld ungerade fuege den Wert der Variable summe2
					// hinzu
					summe2 = summe2 + ean[i];
				}
			}
			summe4 = summe1 + (summe2 * 3);
			summe2 = summe2 * 3;
			summe3 = summe1 + summe2;
			while (summe4 % 10 != 0) {
				summe4++;
			}
			// Auswertung der ean gültigkeitsberechnung
			if (summe4 - summe3 == ean[12]) {
				// EAN korrekt
				return true;
			} else {
				// EAN nicht korrekt
				return false;
			}
		} catch (Exception e) {
			// EAN nicht korrekt oder fehler
			return false;
		}
	}

}