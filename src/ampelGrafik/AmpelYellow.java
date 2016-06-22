package ampelGrafik;

import java.awt.Color;
import java.awt.Dimension;
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
 * @version 00.00.05 2016/05/16
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

		int windowWidth = 250;
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

			g.setColor(Color.GRAY);
			g.fill3DRect(60, 40, 150, 300, true); // Ampelhintergrund Schatten

			g.setColor(Color.black);
			g.fillRect(50, 50, 150, 300); // Ampelhintergrund

			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);

			g2d.setColor(Color.lightGray);
			g2d.fillOval(100, 100, 50, 50);

			g2d.setColor(Color.YELLOW);
			g2d.fillOval(100, 175, 50, 50);

			g2d.setColor(Color.lightGray);
			g2d.fillOval(100, 250, 50, 50);

		}
	}
}