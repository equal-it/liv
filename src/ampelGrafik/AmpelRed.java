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
 * class AmpelRed zeigt eine rote Ampel
 * 
 * @author team equal-IT
 * @mail: team@equal-it.de
 * @version 00.00.05 2016/05/16
 */

@SuppressWarnings("serial")
public class AmpelRed extends Frame {

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
	public AmpelRed() throws InterruptedException { // Rahmen

		int windowWidth = 700;				// Box zu Testzwecken Text erweitert. Orginalwert 250!!
		int windowHeight = 425;

		setTitle("Ampel-Red");
		addWindowListener(new WindowListener());

		add(new DrawingPanelRed());

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
			Thread.sleep(5000);						// zum Testen hochgesetzt
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		dispose();
	}

	/**
	 * @param g
	 */

	class DrawingPanelRed extends Panel { // Ampel

		public void paint(Graphics g) {
			Graphics2D g2d = (Graphics2D) g;

			g.setColor(Color.GRAY);		// Box zu Testzwecken Text erweitert. Orginalwert 60, 40 150, 300, true!!
			g.fill3DRect(60, 40, 600, 300, true); // Ampelhintergrund Schatten

			g.setColor(Color.black);
			g.fillRect(50, 50, 150, 300); // Ampelhintergrund

			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);

			g2d.setColor(Color.RED);
			g2d.fillOval(100, 100, 50, 50);

			g2d.setColor(Color.lightGray);
			g2d.fillOval(100, 175, 50, 50);

			g2d.setColor(Color.lightGray);
			g2d.fillOval(100, 250, 50, 50);
			
			
			// zusätzlicher Text in der Grafik - dient nur als Beispiel, ginge auch in schön ;)
			Font test = new Font("Arial",Font.BOLD,20);
			g.setFont(test);
			g.setColor(Color.RED);
			g.drawString("Vorsicht!", 250, 130);
			g.setColor(Color.WHITE);
			g.drawString("unerwünschte Inhaltsstoffe", 250, 180);   
			
		}
	}
}