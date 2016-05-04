package playground;

import javax.swing.JOptionPane;

public class PopupEingabeWindow {

	  public static void main(String[] args)
	  {
	    String eingabe = JOptionPane.showInputDialog("Welches Produkt soll LIV auf Deine Filterbedingung prüfen? "
	    											+ "\nBitte gib die zugehörige EAN ein: ");

	    String ausgabe = ("Das Produkt mit der EAN : \n\n" + eingabe + "\n\n wird nun überprüft." );
	    JOptionPane.showMessageDialog(null, ausgabe , "EAN", JOptionPane.INFORMATION_MESSAGE);
	    
	    // Exception abfangen - wenn ungueltige Laenge der EAN oder keine Eingabe, oder keine Zahl, dann... 
	    // JOptionPane.showMessageDialog(null, ausgabe , "Fehlermeldung", JOptionPane.INFORMATION_MESSAGE);
	  
	}

}
