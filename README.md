# Start-Up-Idee
**Liv – Lebensmittelinhaltverifizierer**

Eine Smartphone-App, die ausgewählte, unerwünschte Inhaltsstoffe von Lebensmitteln anhand eines Barcode-Scans durch Darstellung einer Ampel auf einen Blick erkennbar macht.
Dabei sollen verschiedene Filterbedingungen individuell vom Kunden eingestellt werden können.
Wenn der Barcode eines Produkts z.B. im Supermarkt (Lebensmittel) per App gescannt wird, soll auf einen Blick erkenntlich werden, ob das Produkt den eigenen Filterkriterien entspricht oder nicht.
Die Daten sind nicht im Barcode/der Produktnummer (European Article Number - EAN) enthalten.
Es gibt jedoch Projekte, die Produktzusammensetzungen in Datenbanken sammeln und mit der EAN verknüpfen. Leider gibt es keine OpenSource, aber es gibt ein Projekt (http://opengtindb.org), das nach dem Wiki-Prinzip Daten sammelt und gegen eine Spende Datenbankzugriff gewährt.
Durch Verknüpfung der Daten mit entsprechendem Filter wird das gewünschte Ergebnis erhofft.



Weitere Version der Beschreibung... :P (AMA)

**LIV - Lebensmittelinhaltverifizierer**

Kurzbeschreibung:
Eine Smartphone-App, die ausgewählte, unerwünschte Inhaltsstoffe von Lebensmitteln anhand eines Barcode-Scans durch Darstellung einer Ampel auf einen Blick erkennbar macht.
Dabei sollen verschiedene Filterbedingungen individuell vom Kunden eingestellt werden können.
Wenn der Barcode eines Produkts z.B. im Supermarkt (Lebensmittel) per App gescannt wird, soll auf einen Blick erkenntlich werden, ob das Produkt den eigenen Filterkriterien entspricht oder nicht.

Ausführliche Beschreibung:
Menschen, die aus verschiedenen Gründen bestimmte Inhaltsstoffe in Lebensmitteln nicht zu sich nehmen können oder möchten, müssen beim Einkauf im Supermarkt oft viel Zeit investieren, um die gewünschte Information aus der Liste der Inhaltsstoffe herauszusuchen.
Hierbei soll "LIV" helfen - der Lebensmittelinhaltsstoffverifizierer von equal-it.

Produkte, die mit einem (europäischen) Barcode (EAN) versehen sind, können mit einem mobilen Endgerät gescannt werden. Über eine klare Ampel-Anzeige können Nutzerinnen  und Nutzer auf einen Blick erkennen, ob das Produkt einen der zuvor angegebenen Inhaltsstoffe enthält. Lästiges Durchlesen der Inhaltsstoffliste entfällt.
Bedingung ist, dass das Produkt in der mit der App verknüpften Datenbank mit den entsprechenden Daten hinterlegt ist. Sollte das Produkt nicht vorhanden sein, steht die Ampel auf "gelb". Nun hat der Nutzer/die Nutzerin die Möglichkeit, das Produkt in der OpenSource-Datenbank auf Wiki-Prinzip zu ergänzen (Link...), verpflichtend ist dies jedoch nicht.

Bei der erstmaligen Verwendung von "LIV" wird der Anwender oder die Anwenderin direkt in die Einstellungen geführt, wo xx Kriterien für die künftige Filterung ausgewählt werden können. Die App ist damit eingerichtet und startklar.
Über die Kamera kann der Barcode des Produktes gescannt werden. Ein Abgleich der zuvor gewählten Filterkriterien ergibt das Ergebnis für die darauffolgende Anzeige:

- "rot": Das Produkt enthält einen der zuvor ausgewählten Inhaltsstoffe
- "gelb": Das Produkt ist noch nicht in der Datenbank enthalten bzw. die Angaben sind unvollständig
- "grün": Das Produkt enthält keinen der zuvor ausgewählten Inhaltsstoffe


In der Ansicht der Ampelanzeige gibt es folgende Optionen:
- Produkt scannen
- Einstellungen (Inhaltsstoffe einstellen)
- Datenbank ergänzen
- Impressum




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
* keine Diät-App, wie so viele andere
* Zielgruppe: Menschen, die z.B. aus gesundheitlichen Gründen auf bestimmte Inhaltsstoffe achten müssen

## Umsetzung
* Codename One als Crosscompile IDE
* API laktonaut.de enthält nur Angaben zu Laktose
* API für Datenbank: http://opengtindb.org

