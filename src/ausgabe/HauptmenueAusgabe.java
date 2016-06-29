package ausgabe;

import static ausgabe.HauptmenueEintraege.*;

/**
 * Project: LIV - Lebensmittelinhaltsstoffverifizierer
 * 
 * class HauptmenueAusgabe
 * 
 * @author team equal-IT 
 * @mail: team@equal-it.de
 * @version 00.00.10 2016/05/16
 */

public class HauptmenueAusgabe {

	public static void LivHauptmenueAusgabe() {
		System.out.println("\n--------------------------------------------");
		System.out.println ("HAUPTMENUE");
		System.out.println("--------------------------------------------\n");
		System.out.println(FILTER.code() + " - Filter setzten");
		System.out.println(EAN.code() + " - EAN eingeben");
		System.out.println(IMPRESSUM.code() + " - Impressum");
		System.out.println(ENDE.code() + " - Beenden");
		System.out.println("\n--------------------------------------------");

	}

	public static void eingabeMenueAndereDB() {
		System.out.println ("\nDas Produkt ist nicht in der LIV-Datenbank enthalten!!!\n");
		System.out.println("\n--------------------------------------------");
		System.out.println ("xxxMENUE"); //Klasse HauptmenueAusgabe
		System.out.println("--------------------------------------------\n");
		System.out.println ("\n1 - Externe Datenbanken durchsuchen" + 
							"\n2 - Produkt zur LIV-Datenbank hinzuefuegen" + 
							"\n3 - Abbrechen und zurueck zum Hauptmenue");
	
	
	}
	public static void eingabeMenueInLivDBEintragen(){
		System.out.println("\n--------------------------------------------");
		System.out.println ("xxxMENUE"); //Klasse HauptmenueAusgabe
		System.out.println("--------------------------------------------\n");
		System.out.println("\n1 - Produkt zur LIV-Datenbank hinzufuegen\n" + "2 - Zurueck zum Hauptmenue");
		
	}
}