package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class JFrame extends javax.swing.JFrame {

	private JPanel contentPane;
	private JTextField txtEanNummer;
	private JTextField txtErgebnis;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame frame = new JFrame();
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
	public JFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnFilter = new JButton("Filter");
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(btnFilter, popupMenu);
		
		JRadioButton rdbtnLaktose = new JRadioButton("Laktose");
		popupMenu.add(rdbtnLaktose);
		
		JRadioButton rdbtnGluten = new JRadioButton("Gluten");
		popupMenu.add(rdbtnGluten);
		
		JRadioButton rdbtnKonservierungsstoffe = new JRadioButton("Konservierungsstoffe");
		popupMenu.add(rdbtnKonservierungsstoffe);
		
		JRadioButton rdbtnZucker = new JRadioButton("Zucker");
		popupMenu.add(rdbtnZucker);
		
		txtEanNummer = new JTextField();
		txtEanNummer.setText("EAN Nummer");
		txtEanNummer.setColumns(10);
		
		JButton btnPrfe = new JButton("Pr\u00FCfe");
		
		JButton btnExit = new JButton("Exit");
		
		JButton btnMainmenue = new JButton("MainMenu");
		
		txtErgebnis = new JTextField();
		txtErgebnis.setEditable(false);
		txtErgebnis.setText("Ergebnis");
		txtErgebnis.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnFilter, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtErgebnis, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExit)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(txtEanNummer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnPrfe))
						.addComponent(btnMainmenue))
					.addContainerGap(61, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(36)
					.addComponent(btnMainmenue)
					.addGap(18)
					.addComponent(btnFilter, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtEanNummer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPrfe))
					.addGap(18)
					.addComponent(txtErgebnis, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnExit)
					.addContainerGap(19, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
