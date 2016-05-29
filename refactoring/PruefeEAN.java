

/**
 * Project: Liv - Lebensmittelinhaltverifizierer
 * 
 * @author team equal-IT // Anicas Baustelle
 * @mail: team@equal-it.de
 * @version 00.00.03 2016/04/28
 */

public final class PruefeEAN {

	public static boolean eanGueltig(String eanString) {
		return pruefeEAN(eanString);
	}

	public static boolean eanUngueltig(String eanString) {
		return !eanGueltig(eanString);
	}

	/**
	 * 
	 * @param eanString
	 */
	private static boolean pruefeEAN(String eanString) {

		// Variablen deklarieren
		// int[] ean enthaelt die vorgegebene EAN
		int[] ean = new int[eanString.length()];
		char[] eanChar = new char[eanString.length()];

		for (int i = 0; i < eanString.length(); i++) {
			eanChar[i] = eanString.charAt(i);
		}
		for (int i = 0; i <= eanString.length() - 1; i++) {
			ean[i] = Character.getNumericValue(eanChar[i]);
		}
		// int summe1 enthaelt die summe der positionen 1,3,5,7,9 und 11
		int summe1 = 0;
		// int summe2 enthaelt die summe der positionen 2,4,6,8,10 und 12
		int summe2 = 0;
		// int summe3 enthaelt die summe von summe1 und summe2 multipliziert mit
		// 3
		int summe3 = 0;
		// int summe4 enthaelt die summe von summe1 und summe2 multipliziert mit
		// 3
		int summe4 = 0;
		// String ean2 enthaelt die EAN als Text, um die EAN ausgeben zu koennen
		String ean2 = "";

		// Schleifen Anfang: Schleife um die einzelnen Array-Felder ansprechen
		// zu koennen
		for (int i = 0; i <= 11; i++) {
			// Abfrage ob das Array-Feld eine gerade oder ungerade Zahl ist
			if (i % 2 == 0) {
				// Ist das Array-Feld gerade fuege den Wert der Variable summe1
				// hinzu
				summe1 = summe1 + ean[i];
			} else {
				// Ist das Array-Feld ungerade fuege den Wert der Variable
				// summe2 hinzu
				summe2 = summe2 + ean[i];
			}
			// Fuege den Wert von Feld[i] der Variable ean2 hinzu
			ean2 = ean2 + ean[i];
		}
		// Schleifen Ende

		// Addiere summe1 und summe2 multipliziert mit 3 und speichere den Wert
		// in Variable summe4
		summe4 = summe1 + (summe2 * 3);
		// Multipliziere summe2 mit 3 und speichere den Wert in Variable summe2
		summe2 = summe2 * 3;
		// Addiere summe1 und summe2 speichere den Wert in Variable summe3
		summe3 = summe1 + summe2;

		// Scheifen Anfang: Hier wird geprueft ob sich summe4 ohne Rest durch 10
		// teilen laesst
		while (summe4 % 10 != 0) {
			// laesst sich summe4 nicht durch 10 teilen wird solange 1 addiert,
			// bis summe4 durch 10 teilbar ist
			summe4++;
		}
		// Schleifen Ende

		// Ist der Wert des Array-Feldes 12 = summe4 - summe3
		if (summe4 - summe3 == ean[12]) {
			// dann ist die EAN korrekt und die entsprechende Meldung wird
			return true;
		} else {
			// dann ist die EAN nicht korrekt und die entsprechende Meldung wird
			// ausgegeben
			return false;
		}

	}

}