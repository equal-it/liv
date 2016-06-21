package liv;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ausgabe.HauptmenueEintraege;
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

		Set<Inhaltsstoff> aktuellerFilter = new HashSet<>();
		List<Ampelindikator> indikatoren = new ArrayList<>();

		Set<Lebensmitteldatenbank> datenbanken = new HashSet<>();
		datenbanken.add(new LaktonautDatenbankAbfrage());
		datenbanken.add(new GlutenDatenbankMock());

		System.out
				.println("Herzlich Willkommen bei LIV - deinem Lebensmittelinhaltverifizierer.");
		System.out.println("\nWas moechtest Du als naechstes tun?");

		try { // start try

			boolean verlassen = false;

			do { // start do while menue

				ausgabe.HauptmenueAusgabe.LivHauptmenueAusgabe();
				String eingabeHauptmenue = Konsoleneingabe
						.leseKonsoleFuer(Arrays.asList(new String[] {
								HauptmenueEintraege.FILTER.code(),
								HauptmenueEintraege.EAN.code(),
								HauptmenueEintraege.IMPRESSUM.code(),
								HauptmenueEintraege.ENDE.code() }));
				int auswahl = Integer.parseInt(eingabeHauptmenue);// String to
																	// int

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
						try {

							if (!aktuellerFilter.isEmpty()) { // start if fuer
																// filter ist
																// leer
								System.out.println("LIV DB wird Abgefragt!!!");
								LivDatenbankAnfrage livDatenbankAnfrage = new LivDatenbankAnfrage();
								String livAntwort = livDatenbankAnfrage
										.frageNach(EingabeEAN.eingabeEanNummer);

								if (livAntwort == null) {// start wenn keine
															// werte in LIV DB
															// zufinden sind
									ausgabe.HauptmenueAusgabe
											.eingabeMenueAndereDB();
									String eingabeMenueAndereDB = Konsoleneingabe
											.leseKonsoleFuer(Arrays
													.asList(new String[] { "1",
															"2" }));
									if (eingabeMenueAndereDB.equals("1")) {// start
																			// nicht
																			// LIV
																			// DB
																			// werden
																			// Abgefragt

										System.out
												.println("nicht LIV DB werden Abgefragt!!!");
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
									} // ende nicht LIV DB werden Abgefragt
									else { // start Benutzeranlegen und Produkt
											// in DB schreiben
										dbbenutzer.Benutzeranlegen.bnanlegen();
										break;
									}// ende Benutzeranlegen und Produkt in DB
										// schreiben

								} // ende if fuer filter ist leer
								else {
									for (Inhaltsstoff inhaltsstoff : aktuellerFilter) {
										Ampelindikator indikator = livDatenbankAnfrage
												.antwortEnthaeltInhaltsstoff(
														livAntwort,
														inhaltsstoff);
										indikatoren.add(indikator);
									}
								}

							}// ende if fuer filter ist leer
							else {
								System.out
										.println("Es sind keine Filter gesetzt. (Klasse Liv)");
								break;
							}
						} catch (Exception e1) {
							System.out
									.println("FEHLER bei der Datenbankabfrage \n"
											+ "Wahrscheilich ist EAN in keiner DB zu finden\n"
											+ "(Klasse Liv - main() - case 2)");

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
					System.out.println("Bitte waehle  "
							+ ausgabe.HauptmenueEintraege.FILTER.code() + " / "
							+ ausgabe.HauptmenueEintraege.EAN.code() + " / "
							+ ausgabe.HauptmenueEintraege.IMPRESSUM.code()
							+ " / " + ausgabe.HauptmenueEintraege.ENDE.code()
							+ "\n");
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