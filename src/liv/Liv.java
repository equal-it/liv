package liv;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import datenbankAbfragen.GlutenDatenbankMock;
import datenbankAbfragen.LaktonautDatenbankAbfrage;
import datenbankAbfragen.Lebensmitteldatenbank;
import eingaben.EingabeEAN;
import eingaben.Konsoleneingabe;

/**
 * Project: LIV - Lebensmittelinhaltverifizierer
 * 
 * class Liv Konsolenausgabe
 * 
 * @author team equal-IT // letzter Stand: Anne
 * @mail: team@equal-it.de
 * @version 00.00.10 2016/05/16
 */

public class Liv { // Console

	/**
	 * Hauptmethode
	 * 
	 * @param aktuellerFilter
	 *            HashSet aus den jeweiligen Filteroptionen
	 * @param datenbanken
	 *            HashSet aus HttpAbfrageLaktonaut und GlutenDatenbankMock
	 * @param datenbank
	 * @param eingabeEanNummer
	 *            Menueauswahl über Konsoleneingabe
	 * @param auswahl
	 * @param inhaltsstoffe
	 * @param anfrageergebnis
	 * @param indikator
	 * @param indikatoren
	 *            Array der Indikatoren
	 * @throws Exception
	 *             e1 wenn Fehler in Abfrage zu HttpAbfrageLaktonaut
	 * @throws Exception
	 *             e3 wenn Menueeingabe falsch war
	 * @throws IOException
	 *             ex wenn das Programm beendet wird
	 * @see eingaben.EingabeEAN
	 * @see datenbankAbfragen.LaktonautDatenbankAbfrage
	 * @see datenbankAbfragen.GlutenDatenbankMock
	 * @see liv.Filter
	 * @see liv.PruefeEAN
	 * @see liv.Impressum
	 */
	public static void main(String[] args) throws Exception {
		final String FILTER = "f";
		final String EAN = "e";
		final String IMPRESSUM = "i";
		final String ENDE = "q";
		Set<Inhaltsstoff> aktuellerFilter = new HashSet<>();
		List<Ampelindikator> indikatoren = new ArrayList<>();

		Set<Lebensmitteldatenbank> datenbanken = new HashSet<>();
		datenbanken.add(new LaktonautDatenbankAbfrage());
		datenbanken.add(new GlutenDatenbankMock());

		System.out
				.println("Herzlich Willkommen bei LIV - deinem Lebensmittelinhaltverifizierer. (Klasse Liv)");
		System.out
				.println("\nWas moechtest Du als naechstes tun? (Klasse Liv)");

		try { // start try

			boolean verlassen = false;

			do { // start do while menue

				System.out
						.println("\n---------------------------------------------------------------------(Klasse Liv)");
				System.out
						.println(FILTER + "  - Filter setzten");
				System.out
						.println(EAN + "  - EAN anzeigen");
				System.out.println(IMPRESSUM + "  - Impressum");
				System.out.println(ENDE + "  - Beenden");
				System.out
						.println("---------------------------------------------------------------------");

				String auswahl = Konsoleneingabe.leseKonsoleFuer(Arrays
						.asList(new String[] { FILTER, EAN, IMPRESSUM, ENDE }));
				//kommentar dinger entfernen wenn Zahlen im menue stehen
				//int auswahl = Integer.parseInt(auswahl);// String to int

				switch (auswahl) {

				case "f":
					aktuellerFilter.clear();
					Set<Inhaltsstoff> inhaltsstoffe = liv.Filter.setFilter();
					aktuellerFilter.addAll(inhaltsstoffe);
					break;

				case "e":
					indikatoren.clear();
					eingaben.EingabeEAN.einlesen();
					if (liv.PruefeEAN.eanGueltig(EingabeEAN.eingabeEanNummer)) {
						System.out
								.println("Die Datenbank wird nun aufgerufen. (Klasse Liv)");
						try {
							if (!aktuellerFilter.isEmpty()) {
								for (Lebensmitteldatenbank datenbank : datenbanken) {
									String anfrageergebnis = datenbank
											.frageNach(EingabeEAN.eingabeEanNummer);
									for (Inhaltsstoff inhaltsstoff : aktuellerFilter) {
										Ampelindikator indikator = datenbank
												.antwortEnthaeltInhaltsstoff(
														anfrageergebnis,
														inhaltsstoff);
										indikatoren.add(indikator);
									}
								}
							} else {
								System.out
										.println("Es sind keine Filter gesetzt. (Klasse Liv)");
							}
						} catch (Exception e1) {
							System.out
									.println("FEHLER bei der Datenbankabfrage ------- (Klasse Liv - main() - case 2)");
						}

						liv.Ampel.ampelFarbe(liv.VergleichFilter
								.ueberprufeIndikatoren(indikatoren));

					} else {
						System.out
								.println("Abbruch, da die EAN ungueltig ist. Es findet keine Datenbankabfrage statt. (Klasse Liv)");
					}

					break;

				case "i":
					liv.Impressum.printImpressum();
					break;

				case "b":
					verlassen = true;
					break;

				default:
					System.out.println("Bitte waehle  " + FILTER + " / " + EAN + " / " + IMPRESSUM + " / " + ENDE + "\n");
					break;
				}

			} // end do-while menue

			while (verlassen == false);

		} // end try

		catch (IOException ex) {
			System.out.println(ex.getMessage());
		} // end catch

		System.out.println("Tschuess!!");
		System.exit(0);
	} // end main

} // end class