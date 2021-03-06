package pruefen;

/**
 * Project: Liv - Lebensmittelinhaltsstoffverifizierer
 * 
 * class PruefeEAN prueft 13-stellige EAN auf Gueltigkeit
 * 
 * @author team equal-IT
 * @mail: team@equal-it.de
 * @version 1.0 2016/07/08
 */

public final class PruefeEAN {

	/**
	 * @param eanString
	 * @return pruefeEAN
	 */
	public static boolean eanGueltig(String eanString) throws Exception {
		return pruefeEAN(eanString);
	}

	/**
	 * @param eanString
	 * @return eanGueltig
	 */
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
	 *            komplette EAN; muss aus 13 zahlenzeichen bestehen
	 * @param ean
	 *            Array aus eanString
	 * @param summe1
	 *            enthaelt die summe der positionen 1,3,5,7,9 und 11
	 * @param summe2
	 *            enthaelt die summe der positionen 2,4,6,8,10 und 12
	 * @param summe3
	 *            enthaelt die summe von summe1 und summe2 multipliziert mit 3
	 * @param summe4
	 *            enthaelt die summe von summe1 und summe2 multipliziert mit 3
	 * @param eanChar
	 * @throws Exception
	 *             e wenn die EAN nicht korrekt ist
	 * @return booelan true or false
	 */
	private static boolean pruefeEAN(String eanString) throws Exception {
		if (eanString.length() >= 14) {
			return false;
		} else {
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
					// Abfrage ob das Array-Feld eine gerade oder ungerade Zahl
					// ist
					if (i % 2 == 0) {
						// Array-Feld gerade fuege den Wert der Variable summe1
						// hinzu
						summe1 = summe1 + ean[i];
					} else {
						// Array-Feld ungerade fuege den Wert der Variable
						// summe2
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

}