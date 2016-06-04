package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.Toolkit;

/**
 * Project: LIV - Lebensmittelinhaltverifizierer
 * 
 * class AmpelGreen zeigt eine gruene Ampel
 * 
 * @author team equal-IT
 * @mail: team@equal-it.de
 * @version 00.00.05 2016/05/16
 */

public class AmpelGreen extends Frame {

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

	public AmpelGreen() throws InterruptedException { // Rahmen

		int windowWidth = 150;
		int windowHeight = 325;

		setTitle("Ampel-Green");
		addWindowListener(new WindowListener());

		add(new DrawingPanelGreen());

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

	class DrawingPanelGreen extends Panel { // Ampel

		public void paint(Graphics g) {

			g.setColor(Color.GRAY);
			g.fillOval(50, 50, 50, 50);
			g.setColor(Color.GRAY);
			g.fillOval(50, 125, 50, 50);
			g.setColor(Color.GREEN);
			g.fillOval(50, 200, 50, 50);
		}
	}
}