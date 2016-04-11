# Start-Up-Idee
**Liv – Lebensmittelinhaltverifizierer**

Eine Smartphone-App, die ausgewählte, unerwünschte Inhaltsstoffe von Lebensmitteln anhand eines Barcode-Scans durch Darstellung einer Ampel auf einen Blick erkennbar macht.
Dabei sollen verschiedene Filterbedingungen individuell vom Kunden eingestellt werden können.
Wenn der Barcode eines Produkts z.B. im Supermarkt (Lebensmittel) per App gescannt wird, soll auf einen Blick erkenntlich werden, ob das Produkt den eigenen Filterkriterien entspricht oder nicht.
Die Daten sind nicht im Barcode/der Produktnummer (European Article Number - EAN) enthalten.
Es gibt jedoch Projekte, die Produktzusammensetzungen in Datenbanken sammeln und mit der EAN verknüpfen. Leider gibt es keine OpenSource, aber es gibt ein Projekt (http://opengtindb.org), das nach dem Wiki-Prinzip Daten sammelt und gegen eine Spende Datenbankzugriff gewährt.
Durch Verknüpfung der Daten mit entsprechendem Filter wird das gewünschte Ergebnis erhofft.

## How to
* zieh die API
* stell den Filter ein
* scann den Barcode
* bekomm in einer Ampel dargestellt ob das Produkt den Filterbedingungen entspricht

## Muss-Kriterien
* Ampel
* Filterbedingungen
 * bio
 * laktosefrei
 * glutenfrei
 * vegan
 * vegetarisch
 * Fair Trade
 * diätisch
 * Herkunftsland

## Wunsch-Kriterien
* Produktinformationen
* Nährwertangaben
* Möglichkeit Fehler zu melden

## Abgrenzungskriterien
* soll nicht darstellen was andere darstellen ;)

## Umsetzung
* Codename One als Crosscompile IDE
* API laktonaut.de enthält nur Angaben zu Laktose
* API für Datenbank: http://opengtindb.org

