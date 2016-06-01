package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.Toolkit;

/**
 * @author felix
 *
 */
public class AmpelGreen extends Frame {

	public AmpelGreen() throws InterruptedException{ // Rahmen
		
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

	class DrawingPanelGreen extends Panel { // Ampel

		public void paint(Graphics g) {

			g.setColor(Color.GRAY);
			g.fillOval(50, 50, 50, 50);
			g.setColor(Color.GRAY);
			g.fillOval(50, 125, 50, 50);
			g.setColor(Color.GREEN);
			g.fillOval(50, 200, 50, 50);
			g.setColor(Color.GRAY);
			g.drawString("green!", 50, 20);

		}
	}
}