import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import java.util.HashSet;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;

/**
 * @author Paddy
 *
 */
public class LottoGenerator extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private boolean is49 = true;

	void Generate49() {
		this.is49 = false;
		HashSet zahlen49 = new HashSet();
		while (zahlen49.size() < 6) {
			int num = (int) (Math.random() * 49) + 1;
			if (zahlen49.add(new Integer(num))) {
				textField.setText("" + zahlen49);
				System.out.println("Die Gewinnzahlen Lauten:" + zahlen49);
			}
		}
	}

	void Generate45() {
		HashSet zahlen45 = new HashSet();
		while (zahlen45.size() < 6) {
			int num = (int) (Math.random() * 45) + 1;
			if (zahlen45.add(new Integer(num))) {
				textField.setText("" + zahlen45);
				System.out.println("Die Gewinnzahlen Lauten:" + zahlen45);
			}
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LottoGenerator frame = new LottoGenerator();
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
	public LottoGenerator() {
		setTitle("LottoMat");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		textField.setForeground(Color.BLUE);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setEditable(false);
		textField.setBounds(135, 117, 160, 25);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblLottomat = new JLabel("LottoMat");
		lblLottomat.setBounds(186, 88, 56, 16);
		contentPane.add(lblLottomat);

		JRadioButton rdbtnLottoAus = new JRadioButton("Lotto aus 49");
		rdbtnLottoAus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// if(rdbtnLottoAus.isSelected()==true) {
			}

		});
		buttonGroup.add(rdbtnLottoAus);
		rdbtnLottoAus.setBounds(87, 54, 127, 25);
		contentPane.add(rdbtnLottoAus);

		JRadioButton rdbtnLottoAus_1 = new JRadioButton("Lotto aus 45");
		rdbtnLottoAus_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// if(rdbtnLottoAus_1.isSelected()==true) {

			}
		});
		buttonGroup.add(rdbtnLottoAus_1);
		rdbtnLottoAus_1.setBounds(218, 54, 127, 25);
		contentPane.add(rdbtnLottoAus_1);

		JButton btnGeneriere = new JButton("Generiere ");
		btnGeneriere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnLottoAus.isSelected() == true) {
					Generate49();
				}
				if (rdbtnLottoAus_1.isSelected() == true) {
					Generate45();
				}
			}
		});
		btnGeneriere.setBounds(165, 159, 97, 25);
		contentPane.add(btnGeneriere);

		JButton btnRest = new JButton("reset ");
		btnRest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
			}
		});
		btnRest.setBounds(165, 197, 97, 25);
		contentPane.add(btnRest);
	}
}