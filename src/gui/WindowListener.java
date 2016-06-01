package gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 * 
 * @author felix
 *
 */
class WindowListener extends WindowAdapter {

	public void windowClosing(WindowEvent e) {
		e.getWindow().dispose();

	}
}