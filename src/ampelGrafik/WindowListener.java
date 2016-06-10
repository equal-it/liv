package ampelGrafik;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Project: LIV - Lebensmittelinhaltverifizierer
 * 
 * class WindowListener
 * 
 * @author team equal-IT
 * @mail: team@equal-it.de
 * @version 00.00.05 2016/05/16
 */

class WindowListener extends WindowAdapter {

	public void windowClosing(WindowEvent e) {
		e.getWindow().dispose();

	}
}