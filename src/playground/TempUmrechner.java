package playground;

// import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class TempUmrechner extends JFrame {

	private JPanel contentPane;
	private JTextField tfFahrenheit;
	private JTextField tfCelsius;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TempUmrechner frame = new TempUmrechner();
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
	public TempUmrechner() {
		setTitle("Temperatur Umrechner");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblFahrenheit = new JLabel("Grad Fahrenheit");
		lblFahrenheit.setBounds(50, 35, 100, 14);
		contentPane.add(lblFahrenheit);

		tfFahrenheit = new JTextField();
		tfFahrenheit.setBounds(50, 60, 86, 20);
		contentPane.add(tfFahrenheit);
		tfFahrenheit.setColumns(10);

		JLabel lblCelsius = new JLabel("Grad Celsius");
		lblCelsius.setBounds(50, 125, 83, 14);
		contentPane.add(lblCelsius);

		tfCelsius = new JTextField();
		tfCelsius.setEditable(false);
		tfCelsius.setBounds(50, 150, 86, 20);
		contentPane.add(tfCelsius);
		tfCelsius.setColumns(10);

		JButton btnUmrechnen = new JButton("Umrechnen");
		btnUmrechnen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double fahrenheit, celsius;
				fahrenheit = Double.parseDouble(tfFahrenheit.getText());
				celsius = (fahrenheit - 32) * 5 / 9;
				DecimalFormat f = new DecimalFormat("#0.00");
				tfCelsius.setText(f.format(celsius));
			}
		});
		btnUmrechnen.setBounds(200, 59, 100, 23);
		contentPane.add(btnUmrechnen);

		JButton btnEnde = new JButton("Ende");
		btnEnde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnEnde.setBounds(200, 149, 100, 23);
		contentPane.add(btnEnde);
	}

}
