package livMitGui_liv;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JTextField;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField EAN;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		
		Set<Inhaltsstoff> aktuellerFilter = new HashSet<>();
		List<Ampelindikator> indikatoren = new ArrayList<>();
		
		Set<Inhaltsstoff> inhaltsstoffe = new HashSet<>();

		Set<Lebensmitteldatenbank> datenbanken = new HashSet<>();
		datenbanken.add(new HttpAbfrageLaktonaut());
		datenbanken.add(new GlutenDatenbankMock());
		
		setTitle("LIV-Lebensmittelinhaltverifizierer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnImpressum = new JButton("Impressum");
		btnImpressum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				livMitGui_liv.Impressum.printImpressum();
			}
		});
		btnImpressum.setBounds(10, 227, 99, 23);
		contentPane.add(btnImpressum);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(335, 227, 89, 23);
		contentPane.add(btnExit);
		
		JLabel lblFilter = new JLabel("Filter");
		lblFilter.setBounds(10, 11, 46, 14);
		contentPane.add(lblFilter);
		
		JRadioButton rdbtnLaktose = new JRadioButton("Laktose");
		rdbtnLaktose.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				Set<Inhaltsstoff> inhaltsstoffe = new HashSet<>();
			}
		});
		
		rdbtnLaktose.setBounds(10, 32, 121, 24);
		contentPane.add(rdbtnLaktose);
		
		JRadioButton rdbtnGluten = new JRadioButton("Gluten");
		rdbtnGluten.setBounds(10, 59, 121, 24);
		contentPane.add(rdbtnGluten);
		
		JLabel lblEan = new JLabel("EAN");
		lblEan.setBounds(200, 10, 55, 16);
		contentPane.add(lblEan);
		
		EAN = new JTextField();
		EAN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		EAN.setBounds(200, 34, 114, 20);
		contentPane.add(EAN);
		EAN.setColumns(10);
		
		JButton btnPrfen = new JButton("Pr\u00FCfen");
		btnPrfen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				indikatoren.clear();
				livMitGui_liv.EingabeEAN.einlesen();
				if (livMitGui_liv.PruefeEAN.eanGueltig(EingabeEAN.eingabe)) {
					System.out.println("DB wird nun aufgerufen. (Klasse Liv)");
					try {
						if (!aktuellerFilter.isEmpty()) {
							for (Lebensmitteldatenbank datenbank : datenbanken) {
								String anfrageergebnis = datenbank.frageNach(EingabeEAN.eingabe);
								for (Inhaltsstoff inhaltsstoff : aktuellerFilter) {
									Ampelindikator indikator = datenbank
											.antwortEnthaeltInhaltsstoff(anfrageergebnis, inhaltsstoff);
									indikatoren.add(indikator);
								}
							}
						} else {
							System.out.println("Es sind keine Filter gesetzt. (Klasse Liv)");
						}
					} catch (Exception e1) {
						// gibt Fehlermeldung aus wenn Fehler in
						// HttpAbfrageLaktonaut
						System.out.println("FEHLER! Problem mit der Abfrage zu EAN: " + livMitGui_liv.EingabeEAN.getEingabe()
								+ " (Klasse Liv)");
					}

					livMitGui_liv.Ampel.ampelFarbe(livMitGui_liv.VergleichFilter.ueberprufeIndikatoren(indikatoren));

				} else {
					System.out.println("Abbruch - da EAN ungültig, findet keine DB-Abfrage statt. (Klasse Liv)");
				}
			}
		});
		btnPrfen.setBounds(10, 91, 98, 26);
		contentPane.add(btnPrfen);
	}
}
