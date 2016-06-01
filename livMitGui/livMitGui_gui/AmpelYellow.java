package livMitGui_gui;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author felix
 *
 */
public class AmpelYellow extends Frame {

	public AmpelYellow() { // Rahmen

		setTitle("Ampel-Test");
		addWindowListener(new TestWindowListener());

		add(new DrawingPanel());

		setSize(150, 300);
		setVisible(true);
	} // public TestFrame () {

class DrawingPanel extends Panel { // Ampel

		public void paint(Graphics g) {

			g.setColor(Color.GRAY);
			g.fillOval(50, 50, 50, 50);
			g.setColor(Color.YELLOW);
			g.fillOval(50, 125, 50, 50);
			g.setColor(Color.GRAY);
			g.fillOval(50, 200, 50, 50);
			g.setColor(Color.GRAY);
			g.drawString("Willkomen bei LIV!", 20, 20);

		} // public void paint(Graphics g) {
	} // class DrawingPanel extends Panel {

class TestWindowListener extends WindowAdapter {
		  
	    public void windowClosing(WindowEvent e) {
	    	e.getWindow().dispose();  
	    	//System.exit(0);                            
	    }           
	  } // class TestWindowListener extends WindowAdapter {
}