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
import datenbankAbfragen.LivDatenbankAnfrage;
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
		final String FILTER = "1";
		final String EAN = "2";
		final String IMPRESSUM = "3";
		final String ENDE = "4";

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

				ausgabe.AusgabeMenue.ausgabeHauptmenue();
				String eingabe = Konsoleneingabe.leseKonsoleFuer(Arrays
						.asList(new String[] { FILTER, EAN, IMPRESSUM, ENDE }));
				int auswahl = Integer.parseInt(eingabe);// String to int

				switch (auswahl) {

				case 1:
					aktuellerFilter.clear();
					Set<Inhaltsstoff> inhaltsstoffe = liv.Filter.setFilter();
					aktuellerFilter.addAll(inhaltsstoffe);
					break;

				case 2:
					indikatoren.clear();
					eingaben.EingabeEAN.einlesen();
					if (liv.PruefeEAN.eanGueltig(EingabeEAN.eingabeEanNummer)) {
						System.out
								.println("Die Datenbank wird nun aufgerufen. (Klasse Liv)");
						try {
							if (!aktuellerFilter.isEmpty()) {

								LivDatenbankAnfrage livDatenbankAnfrage = new LivDatenbankAnfrage();
								String livAntwort = livDatenbankAnfrage
										.frageNach(EingabeEAN.eingabeEanNummer);

								if (livAntwort == null) {
									// Menu: andere DB befragen oder neuer
									// Eintrag in Liv
									boolean eintragen = true;
									if (eintragen) {
										// werte eingeben
										// indikatoren.add(indikator);
									} else {
										// andere DB abfragen
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
									}

								} else {
									for (Inhaltsstoff inhaltsstoff : aktuellerFilter) {
										Ampelindikator indikator = livDatenbankAnfrage
												.antwortEnthaeltInhaltsstoff(
														livAntwort,
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

				case 3:
					liv.Impressum.printImpressum();
					break;

				case 4:
					verlassen = true;
					break;

				default:
					System.out.println("Bitte waehle  " + FILTER + " / " + EAN
							+ " / " + IMPRESSUM + " / " + ENDE + "\n");
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