package livAnne;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Project: LIV - Lebensmittelinhaltverifizierer
 * 
 * @author team equal-IT // letzter Stand: Anne
 * @mail: team@equal-it.de
 * @version 00.00.10 2016/05/16
 */

public class Liv { // Console

	public static void main(String[] args) {
		Set<Inhaltsstoff> aktuellerFilter = new HashSet<>();
		List<Ampelindikator> indikatoren = new ArrayList<>();

		Set<Lebensmitteldatenbank> datenbanken = new HashSet<>();
		datenbanken.add(new HttpAbfrageLaktonaut());
		datenbanken.add(new HttpAbfrageMock1());

		int auswahl = 0;

		System.out.println("Herzlich Willkommen bei LIV - deinem Lebensmittelinhaltverifizierer. (Klasse Liv)");
		System.out.println("\nWas moechtest Du als naechstes tun? (Klasse Liv)");

		try { // start try

			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
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

				String eingabe = br.readLine(); // liest die Eingabe

				try {
					auswahl = Integer.parseInt(eingabe);// String to int
				} catch (Exception e3) {
					System.out.println("FEHLER! Falsche Menue Eingabe! (Klasse Liv)");
					auswahl = 0; // setzt bei Fehler auswahl = 0
				}

				switch (auswahl) {

				case 1:
					aktuellerFilter.clear();
					Set<Inhaltsstoff> inhaltsstoffe = Filter.setFilter();
					aktuellerFilter.addAll(inhaltsstoffe);
					break;

				case 2:
					liv.EingabeEAN.einlesen();

					if (PruefeEAN.eanGueltig(EingabeEAN.eingabe)) {
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
							System.out.println("FEHLER! Problem mit der Abfrage zu EAN: " + liv.EingabeEAN.getEingabe()
									+ " (Klasse Liv)");
						}

						Ampel.ampelFarbe(VergleichFilter.ueberprufeIndikatoren(indikatoren));

					} else {
						System.out.println("Abbruch - da EAN ungültig, findet keine DB-Abfrage statt. (Klasse Liv)");
					}

					break;

				case 8:
					liv.Impressum.printImpressum();
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

		System.exit(0);
	} // end main

} // end class