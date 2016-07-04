package ampel;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Project: LIV - Lebensmittelinhaltsstoffverifizierer
 * 
 * class WindowListener
 * 
 * @author team equal-IT
 * @mail: team@equal-it.de
 * @version 1.0 2016/07/08
 */

class WindowListener extends WindowAdapter {

	public void windowClosing(WindowEvent e) {
		e.getWindow().dispose();

	}
}