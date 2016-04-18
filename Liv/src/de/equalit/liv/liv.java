package de.equalit.liv;

import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.io.Log;
import com.codename1.ui.Toolbar;
import java.io.IOException;

/**
 * This file was generated by <a href="https://www.codenameone.com/">Codename
 * One</a> for the purpose of building native mobile applications using Java.
 */
public class liv {

	private Form current;
	private Resources theme;

	public void init(Object context) {
		theme = UIManager.initFirstTheme("/theme");

		// Enable Toolbar on all Forms by default
		Toolbar.setGlobalToolbar(true);

		// Pro only feature, uncomment if you have a pro subscription
		// Log.bindCrashProtection(true);
	}

	public void start() {
		if (current != null) {
			current.show();
			return;
		}
		Form home = new Form("LIV");
		Button b = new Button("About LIV");
		home.add(b);
		b.addActionListener((e) -> Dialog.show("Lebensmittelinhaltverifizierer",
				"Eine Smartphone-App, die Menschen mit Lebensmittelunverträglichkeiten unerwünschte Inhaltsstoffe von Lebensmitteln auf einen Blick erfassen lässt.",
				"OK", null));
		Button c = new Button("Impressum");
		home.add(c);
		c.addActionListener((e) -> Dialog.show("Impressum", "equal-IT email: team@equal-it.de", "OK", null));
		home.show();
	}

	public void stop() {
		current = Display.getInstance().getCurrent();
		if (current instanceof Dialog) {
			((Dialog) current).dispose();
			current = Display.getInstance().getCurrent();
		}
	}

	public void destroy() {
	}

}
