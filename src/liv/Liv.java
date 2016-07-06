package liv;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import userinterface.HauptmenueEintraege;
import datenbanken.GlutenDatenbankMock;
import datenbanken.LaktonautDatenbankAbfrage;
import datenbanken.Lebensmitteldatenbank;
import datenbanken.LivDatenbankAnfrage;
import eingaben.EingabeEAN;
import eingaben.Konsoleneingabe;
import filter.Ampelindikator;
import filter.Inhaltsstoff;

/**
 * Project: LIV - Lebensmittelinhaltsstoffverifizierer
 * 
 * class Liv Konsolenausgabe
 * 
 * @author team equal-IT
 * @mail: team@equal-it.de
 * @version 1.0 2016/07/08
 */

public class Liv {

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
	 * @see filter.Filter
	 * @see pruefen.PruefeEAN
	 * @see liv.Impressum
	 */
	public static void main(String[] args) throws Exception {

		Set<Inhaltsstoff> aktuellerFilter = new HashSet<>();

		List<Ampelindikator> indikatoren = new ArrayList<>();

		Set<Lebensmitteldatenbank> datenbanken = new HashSet<>();
		datenbanken.add(new LaktonautDatenbankAbfrage());
		datenbanken.add(new GlutenDatenbankMock());

		System.out.println("********************************************\n" + "\nHERZLICH WILLKOMMEN bei LIV "
				+ "\ndem LebensmittelInhaltsstoffVerifizierer" + "\nby equal-IT"
				+ "\n\n********************************************");

		System.out.println("\nFolgende Optionen stehen zur Auswahl:");

		try { // start try

			boolean verlassen = false;

			do { // start do while menue

				userinterface.HauptmenueAusgabe.LivHauptmenueAusgabe();
				String eingabeHauptmenue = Konsoleneingabe.leseKonsoleFuer(
						Arrays.asList(new String[] { HauptmenueEintraege.FILTER.code(), HauptmenueEintraege.EAN.code(),
								HauptmenueEintraege.IMPRESSUM.code(), HauptmenueEintraege.ENDE.code() }));
				// String to int
				int auswahl = Integer.parseInt(eingabeHauptmenue);

				switch (auswahl) {

				case 1: // Filter setzen
					aktuellerFilter.clear();
					Set<Inhaltsstoff> inhaltsstoffe = filter.Filter.setFilter();
					aktuellerFilter.addAll(inhaltsstoffe);
					break;

				case 2: // EAN eingeben und uswerten mit ampel
					indikatoren.clear();
					eingaben.EingabeEAN.einlesen();
					if (pruefen.PruefeEAN.eanGueltig(EingabeEAN.eingabeEanNummer)) {
						try {
							// Start if Filter ist leer
							if (!aktuellerFilter.isEmpty()) {
								System.out.println("\nLIV-Datenbank wird abgefragt...");
								LivDatenbankAnfrage livDatenbankAnfrage = new LivDatenbankAnfrage();
								String livAntwort = livDatenbankAnfrage.frageNach(EingabeEAN.eingabeEanNummer);
								// Start ean nicht in LIV DB 
								if (livAntwort == null) {
									// zeige Ampel mit UNBEKANNT
									indikatoren.add(Ampelindikator.UNBEKANNT);
									ampel.Ampel.ampelFarbe(filter.VergleichFilter.ueberprufeIndikatoren(indikatoren),
											aktuellerFilterAlsText(aktuellerFilter));
									indikatoren.remove(Ampelindikator.UNBEKANNT);
									// rufe eingabeMenueAndereDB auf
									userinterface.HauptmenueAusgabe.eingabeMenueAndereDB();
									String eingabeMenueAndereDB = Konsoleneingabe
											.leseKonsoleFuer(Arrays.asList(new String[] { "1", "2", "3" }));
									if (eingabeMenueAndereDB.equals("1")) {
										// 1 - Externe Datenbanken durchsuchen
										System.out.println("Externe Datenbanken werden abgefragt...");
										for (Lebensmitteldatenbank datenbank : datenbanken) {
											String anfrageergebnis = datenbank.frageNach(EingabeEAN.eingabeEanNummer);
											for (Inhaltsstoff inhaltsstoff : aktuellerFilter) {
												Ampelindikator indikator = datenbank
														.antwortEnthaeltInhaltsstoff(anfrageergebnis, inhaltsstoff);
												indikatoren.add(indikator);
											}
										}
									} else if (eingabeMenueAndereDB.equals("3")) {
										// 3 - Abbrechen und zurueck zum
										// Hauptmenue
										break;
									} else {
										// 2 - Produkt zur LIV-Datenbank
										// hinzuefuegen
										userinterface.livDbInteraktionsmenue.livDbMenue();
										break;
									}
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
							ampel.Ampel.ampelFarbe(filter.VergleichFilter.ueberprufeIndikatoren(indikatoren),
									aktuellerFilterAlsText(aktuellerFilter));
						} catch (Exception e1) {

							ampel.Ampel.ampelFarbe(filter.VergleichFilter.ueberprufeIndikatoren(indikatoren),
									aktuellerFilterAlsText(aktuellerFilter));
							userinterface.HauptmenueAusgabe.eingabeMenueInLivDBEintragen();
							String eingabeMenueInLivDBEintragen = Konsoleneingabe
									.leseKonsoleFuer(Arrays.asList(new String[] { "1", "2" }));
							if (eingabeMenueInLivDBEintragen.equals("1")) {
								livdatenbank.LivDbneuesProduktHinzufuegen.neuesProduktHinzufuegen();
							}
						}
					} else {
						System.err.println("\nAbbruch. Die EAN ist ungueltig. Es findet keine Datenbankabfrage statt.");
					}
					break;
				case 3: // Impessum anzeigen
					liv.Impressum.printImpressum();
					break;
				case 4: // Programm verlassen
					verlassen = true;
					try{
					filter.Filter.einstellungen.properties.clear();
					filter.Filter.einstellungen.schreibePropertiesDatei();
					}catch (Exception e){
						
					}
					break;
				default:
					System.out.println("Bitte waehle  " + userinterface.HauptmenueEintraege.FILTER.code() + " / "
							+ userinterface.HauptmenueEintraege.EAN.code() + " / "
							+ userinterface.HauptmenueEintraege.IMPRESSUM.code() + " / "
							+ userinterface.HauptmenueEintraege.ENDE.code() + "\n");
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

	// Fuer Textanzeige des gesetzten Filters in der Ampel (derzeit nur in der
	// roten):
	private static String aktuellerFilterAlsText(Set<Inhaltsstoff> aktuellerFilter) {
		Set<String> anzeigenamen = new HashSet<>();
		for (Inhaltsstoff inhaltsstoff : aktuellerFilter) {
			anzeigenamen.add(inhaltsstoff.anzeigename());
		}
		return String.join(", ", anzeigenamen);
	}

} // end class