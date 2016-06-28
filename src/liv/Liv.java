package liv;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ausgabe.HauptmenueEintraege;
import datenbanken.GlutenDatenbankMock;
import datenbanken.LaktonautDatenbankAbfrage;
import datenbanken.Lebensmitteldatenbank;
import datenbanken.LivDatenbankAnfrage;
import eingaben.EingabeEAN;
import eingaben.Konsoleneingabe;

/**
 * Project: LIV - Lebensmittelinhaltsstoffverifizierer
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
	 * @see datenbanken.LaktonautDatenbankAbfrage
	 * @see datenbanken.GlutenDatenbankMock
	 * @see liv.Filter
	 * @see liv.PruefeEAN
	 * @see liv.Impressum bla
	 */
	public static void main(String[] args) throws Exception {

		Set<Inhaltsstoff> aktuellerFilter = new HashSet<>();
		
		List<Ampelindikator> indikatoren = new ArrayList<>();

		Set<Lebensmitteldatenbank> datenbanken = new HashSet<>();
		datenbanken.add(new LaktonautDatenbankAbfrage());
		datenbanken.add(new GlutenDatenbankMock());

		System.out.println("HERZLICH WILLKOMMEN bei LIV "
						+ "\ndem LebensmittelInhaltsstoffVerifizierer"
						+ "\nby equal-IT");
		
		System.out.println("\nWas moechtest Du als naechstes tun?");

		try { // start try

			boolean verlassen = false;

			do { // start do while menue

				ausgabe.HauptmenueAusgabe.LivHauptmenueAusgabe();
				String eingabeHauptmenue = Konsoleneingabe.leseKonsoleFuer(
						Arrays.asList(new String[] { HauptmenueEintraege.FILTER.code(), HauptmenueEintraege.EAN.code(),
								HauptmenueEintraege.IMPRESSUM.code(), HauptmenueEintraege.ENDE.code() }));
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
							// Start if Filter ist leer
							if (!aktuellerFilter.isEmpty()) {
								System.out.println("\nLIV-Datenbank wird abgefragt!!!");
								LivDatenbankAnfrage livDatenbankAnfrage = new LivDatenbankAnfrage();
								String livAntwort = livDatenbankAnfrage.frageNach(EingabeEAN.eingabeEanNummer);
								// Start wenn keine Werte in LIV DB zu finden sind
								if (livAntwort == null) {
									indikatoren.add(Ampelindikator.UNBEKANNT);
									liv.Ampel.ampelFarbe(liv.VergleichFilter.ueberprufeIndikatoren(indikatoren));
									ausgabe.HauptmenueAusgabe.eingabeMenueAndereDB();
									String eingabeMenueAndereDB = Konsoleneingabe
											.leseKonsoleFuer(Arrays.asList(new String[] { "1", "2", "3" }));
									// Start Externe Datenbank wird abgefragt
									if (eingabeMenueAndereDB.equals("1")) {
										System.out.println("Externe Datenbanken werden abgefragt!!!");
										for (Lebensmitteldatenbank datenbank : datenbanken) {
											String anfrageergebnis = datenbank.frageNach(EingabeEAN.eingabeEanNummer);
											for (Inhaltsstoff inhaltsstoff : aktuellerFilter) {
												Ampelindikator indikator = datenbank
														.antwortEnthaeltInhaltsstoff(anfrageergebnis, inhaltsstoff);
												indikatoren.add(indikator);
											}
										}
									} else if(eingabeMenueAndereDB.equals("3")){// ende nicht LIV DB werden Abgefragt
										break;
									}
									else { // start Benutzeranlegen und Produkt in DB schreiben
										livDbInteraktion.livDbInteraktionsmenue.livDbMenue();
										break;
									} // ende Benutzeranlegen und Produkt in DB schreiben
								} // ende if fuer filter ist leer
								else {
									for (Inhaltsstoff inhaltsstoff : aktuellerFilter) {
										Ampelindikator indikator = livDatenbankAnfrage
												.antwortEnthaeltInhaltsstoff(livAntwort, inhaltsstoff);
										indikatoren.add(indikator);
									}
								}
							} // ende if fuer filter ist leer
							else {
								System.out.println("\nEs sind keine Filter gesetzt.");
								break;
							}
							
						} catch (Exception e1) {
							liv.Ampel.ampelFarbe(liv.VergleichFilter.ueberprufeIndikatoren(indikatoren));
							ausgabe.HauptmenueAusgabe.eingabeMenueInLivDBEintragen();
							String eingabeMenueInLivDBEintragen = Konsoleneingabe
									.leseKonsoleFuer(Arrays.asList(new String[] { "1", "2"}));
							if(eingabeMenueInLivDBEintragen.equals("1")){
								livDbInteraktion.livDbneuesProduktHinzufuegen.neuesProduktHinzufuegen();
							}
						}
						liv.Ampel.ampelFarbe(liv.VergleichFilter.ueberprufeIndikatoren(indikatoren));
					} else {
						System.err.println(
								"\nAbbruch. Die EAN ist ungueltig. Es findet keine Datenbankabfrage statt.");
					}
					break;
					
				case 3:
					liv.Impressum.printImpressum();
					break;

				case 4:
					verlassen = true;
					break;

				default:
					System.out.println("Bitte waehle  " + ausgabe.HauptmenueEintraege.FILTER.code() + " / "
							+ ausgabe.HauptmenueEintraege.EAN.code() + " / "
							+ ausgabe.HauptmenueEintraege.IMPRESSUM.code() + " / "
							+ ausgabe.HauptmenueEintraege.ENDE.code() + "\n");
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