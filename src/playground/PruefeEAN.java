package playground;

public class PruefeEAN {
public static void main(String[] args) {
// Variablen deklarieren
//int[] ean enthaelt die vorgegebene EAN
int[] ean = {4,0,1,2,7,0,0,9,6,3,1,0,9};
//int summe1 enthaelt die summe der positionen 1,3,5,7,9 und 11
int summe1 = 0;
//int summe2 enthaelt die summe der positionen 2,4,6,8,10 und 12
int summe2 = 0;
//int summe3 enthaelt die summe von summe1 und summe2 multipliziert mit 3
int summe3 = 0;
//int summe4 enthaelt die summe von summe1 und summe2 multipliziert mit 3
int summe4 = 0;
//String ean2 enthaelt die EAN als Text, um die EAN ausgeben zu koennen
String ean2 = "";

//Schleifen Anfang: Schleife um die einzelnen Array-Felder ansprechen zu koennen
for (int i = 0; i<=11; i++)
{
//Abfrage ob das Array-Feld eine gerade oder ungerade Zahl ist
if (i%2==0)
{
//Ist das Array-Feld gerade fuege den Wert der Variable summe1 hinzu
summe1 = summe1 + ean[i];
}
else
{
//Ist das Array-Feld ungerade fuege den Wert der Variable summe2 hinzu
summe2 = summe2 + ean[i];
}
//Fuege den Wert von Feld[i] der Variable ean2 hinzu
ean2 = ean2 + ean[i];
}
//Schleifen Ende

//Addiere summe1 und summe2 multipliziert mit 3 und speichere den Wert in Variable summe4
summe4 = summe1 + (summe2*3);
//Multipliziere summe2 mit 3 und speichere den Wert in Variable summe2
summe2 = summe2 * 3;
//Addiere summe1 und summe2 speichere den Wert in Variable summe3
summe3 = summe1 + summe2;

//Scheifen Anfang: Hier wird geprueft ob sich summe4 ohne Rest durch 10 teilen laesst
while (summe4 % 10 != 0)
{
//laesst sich summe4 nicht durch 10 teilen wird solange 1 addiert, bis summe4 durch 10 teilbar ist
summe4++;
}
//Schleifen Ende

//Ist der Wert des Array-Feldes 12 = summe4 - summe3
if (summe4 - summe3 == ean[12])
{
//dann ist die EAN korrekt und die entsprechende Meldung wird ausgegeben
System.out.println("Ihre eingegebene EAN ist korrekt :" + ean2);
}
else
{
//dann ist die EAN nicht korrekt und die entsprechende Meldung wird ausgegeben
System.out.println("Ihre eingegebene EAN ist nicht korrekt :" + ean2);
}
}
}