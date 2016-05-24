package playground;
import java.awt.*;
import java.awt.event.*;

public class TestFrame extends Frame {
	
	public TestFrame () {							// Rahmen
		
		setTitle("Ampel-Test"); 
		addWindowListener(new TestWindowListener());
	   
	    add(new DrawingPanel());
	         
	    setSize(300,600);
	    setVisible(true);                           
	}

	
	 class DrawingPanel extends Panel {			// Ampel
		 
		 public void paint(Graphics g) {
			 
			 g.setColor(Color.RED);
			 g.fillOval(50, 50, 50, 50);
			 g.setColor(Color.YELLOW);
			 g.fillOval(50, 125, 50, 50);
			 g.setColor(Color.GREEN);
			 g.fillOval(50, 200, 50, 50);
			 g.setColor(Color.RED);
			 g.drawString("Willkomen bei LIV!", 20, 20);
           
	     }	// public void paint(Graphics g) {
	  }  // class DrawingPanel extends Panel {	
	 
	  
	 class TestWindowListener extends WindowAdapter {
		  
	    public void windowClosing(WindowEvent e) {
	    	e.getWindow().dispose();  
	    	System.exit(0);                            
	    }           
	  }	//class TestWindowListener extends WindowAdapter {
	 
	 
	 public static void main (String args[]) {
	    new TestFrame ();
	 }	// public static void main (String args[]) {

	  
}	// public class TestFrame extends Frame {
