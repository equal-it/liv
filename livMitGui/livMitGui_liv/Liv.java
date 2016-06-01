package livMitGui_liv;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import livMitGui_liv.Ampelindikator;
import livMitGui_liv.EingabeEAN;
import livMitGui_liv.GlutenDatenbankMock;
import livMitGui_liv.HttpAbfrageLaktonaut;
import livMitGui_liv.Inhaltsstoff;
import livMitGui_liv.Konsoleneingabe;
import livMitGui_liv.Lebensmitteldatenbank;

/**
 * Project: LIV - Lebensmittelinhaltverifizierer
 * 
 * @author team equal-IT // letzter Stand: Anne
 * @mail: team@equal-it.de
 * @version 00.00.10 2016/05/16
 */

public class Liv { // Console

	public static void main(String[] args) throws Exception {
		Set<Inhaltsstoff> aktuellerFilter = new HashSet<>();
		List<Ampelindikator> indikatoren = new ArrayList<>();

		Set<Lebensmitteldatenbank> datenbanken = new HashSet<>();
		datenbanken.add(new HttpAbfrageLaktonaut());
		datenbanken.add(new GlutenDatenbankMock());

		int auswahl = 0;

		System.out.println("Herzlich Willkommen bei LIV - deinem Lebensmittelinhaltverifizierer. (Klasse Liv)");
		System.out.println("\nWas moechtest Du als naechstes tun? (Klasse Liv)");

		try { // start try

			boolean verlassen = false;

			// liv.Filter.setFilter(); // wenn nicht als erstes gewuenscht, dann
			// auskommentieren - dann kommt Menue als erstes

			// HIER MUSS NOCH IRGENDWO REIN:
			// Wenn KEIN Filter gesetzt ist, dieses zurueckgeben, BEVOR
			// DB-Abfrage stattfindet!!
			// z.B.: "Wenn Du keinen Filter setzt, sind natuerlich alle Produkte
			// ok ;)
			// Bitte Filter mit '2' setzen :)"

			do { // start do while menue

				System.out
						.println("\n---------------------------------------------------------------------(Klasse Liv)");
				System.out.println("Waehle  '1'  um Filter einzustellen");
				System.out.println("Waehle  '2'  um eine EAN einzugeben!");
				System.out.println("Waehle  '8'  um Dir das Impressum anzusehen!");
				System.out.println("Waehle  '9'  zum Beenden!");
				System.out.println("---------------------------------------------------------------------");

				String eingabe = Konsoleneingabe.leseKonsoleFuer(Arrays.asList(new String[] { "1", "2", "8", "9" }));

				try {
					auswahl = Integer.parseInt(eingabe);// String to int
				} catch (Exception e3) {
					System.out.println("FEHLER! Falsche Menue Eingabe! (Klasse Liv)");
					auswahl = 0; // setzt bei Fehler auswahl = 0
				}

				switch (auswahl) {

				case 1:
					aktuellerFilter.clear();
					Set<Inhaltsstoff> inhaltsstoffe = livMitGui_liv.Filter.setFilter();
					aktuellerFilter.addAll(inhaltsstoffe);
					break;

				case 2:
					indikatoren.clear();
					livMitGui_liv.EingabeEAN.einlesen();
					if (livMitGui_liv.PruefeEAN.eanGueltig(EingabeEAN.eingabe)) {
						System.out.println("DB wird nun aufgerufen. (Klasse Liv)");
						try {
							if (!aktuellerFilter.isEmpty()) {
								for (Lebensmitteldatenbank datenbank : datenbanken) {
									String anfrageergebnis = datenbank.frageNach(EingabeEAN.eingabe);
									for (Inhaltsstoff inhaltsstoff : aktuellerFilter) {
										Ampelindikator indikator = datenbank
												.antwortEnthaeltInhaltsstoff(anfrageergebnis, inhaltsstoff);
										indikatoren.add(indikator);
									}
								}
							} else {
								System.out.println("Es sind keine Filter gesetzt. (Klasse Liv)");
							}
						} catch (Exception e1) {
							// gibt Fehlermeldung aus wenn Fehler in
							// HttpAbfrageLaktonaut
							System.out.println("FEHLER! Problem mit der Abfrage zu EAN: " + livMitGui_liv.EingabeEAN.getEingabe()
									+ " (Klasse Liv)");
						}

						livMitGui_liv.Ampel.ampelFarbe(livMitGui_liv.VergleichFilter.ueberprufeIndikatoren(indikatoren));

					} else {
						System.out.println("Abbruch - da EAN ungültig, findet keine DB-Abfrage statt. (Klasse Liv)");
					}

					break;

				case 8:
					livMitGui_liv.Impressum.printImpressum();
					break;

				case 9:
					verlassen = true;
					break;

				default:
					System.out.println("Bitte waehle  1 / 2 / 8 / 9\n");
				}

			} // end do-while menue

			while (verlassen == false);

		} // end try

		catch (IOException ex) {
			System.out.println(ex.getMessage());
		} // end catch

		System.out.println("Tschüss!!");
		System.exit(0);
	} // end main

} // end class