package ampelGrafik;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.awt.RenderingHints;
import java.awt.Toolkit;

/**
 * Project: LIV - Lebensmittelinhaltverifizierer
 * 
 * class AmpelYellow zeigt eine gelbe Ampel
 * 
 * @author team equal-IT
 * @mail: team@equal-it.de
 * @version 00.00.05 2016/05/28
 */

@SuppressWarnings("serial")
public class AmpelYellow extends Frame {

	/**
	 * @param windowWidth
	 *            legt die Breite des Fensters fest
	 * @param windowHeight
	 *            legt die Höhe des Fensters fest
	 * @param w
	 * @param h
	 * @param x
	 * @param y
	 * @param dim
	 * @throws InterruptedException
	 *             e
	 */
	public AmpelYellow() throws InterruptedException { // Rahmen

		int windowWidth = 700;
		int windowHeight = 425;

		setTitle("Ampel-Yellow");
		addWindowListener(new WindowListener());

		add(new DrawingPanelYellow());

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		// Determine the new location of the window
		int w = this.getSize().width;
		int h = this.getSize().height;
		int x = (dim.width - w) / 2 - windowWidth / 2;
		int y = (dim.height - h) / 2 - windowHeight / 2;

		// Move the window
		this.setLocation(x, y);

		setSize(windowWidth, windowHeight);
		setVisible(true);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		dispose();
	}

	/**
	 * @param g
	 */

	class DrawingPanelYellow extends Panel { // Ampel

		public void paint(Graphics g) {
			Graphics2D g2d = (Graphics2D) g;

			// Hintergrundbox
			g.setColor(Color.GRAY);
			g.fill3DRect(60, 40, 600, 300, true); // Ampelhintergrund Schatten

			// Ampelbox
			g.setColor(Color.black);
			g.fillRect(50, 50, 150, 300); // Ampelhintergrund

			// Antialiasing für die Kreise der Ampel
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);

			// Ampelfarben
			g2d.setColor(Color.lightGray);
			g2d.fillOval(100, 100, 50, 50);

			g2d.setColor(Color.YELLOW);
			g2d.fillOval(100, 175, 50, 50);

			g2d.setColor(Color.lightGray);
			g2d.fillOval(100, 250, 50, 50);

			// Textausgabe
			Font test = new Font("Arial",Font.BOLD,20);
			g.setFont(test);
			g.setColor(Color.YELLOW);
			g.drawString("Sorry!", 250, 130);
			g.setColor(Color.WHITE);
			g.drawString("Das Produkt ist nicht in der", 250, 180);   
			g.drawString("Datenbank enthalten", 250, 230);  
			
		}
	}
}