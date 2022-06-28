import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginGUI extends JFrame {

	private JPanel contentPane;
	private JPanel ImgPanel;
	private JPanel TextPanel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JPanel inTextPanel;
	private JLabel headTextLabel;
	private JLabel inputIDLabel;
	private JTextField inputIDTextField;
	private JLabel inputPWLabel;
	private JButton LoginButton;
	private JButton SignUpButton;
	private JPasswordField inputPasswordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
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
	public LoginGUI() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1025, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		ImgPanel = new JPanel();
		ImgPanel.setBackground(Color.WHITE);
		contentPane.add(ImgPanel, BorderLayout.WEST);
		ImgPanel.setLayout(new BorderLayout(0, 0));

		lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\saals\\Desktop\\skku logo eng sujung.png"));
		ImgPanel.add(lblNewLabel, BorderLayout.SOUTH);

		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\saals\\Desktop\\skku col2.png"));
		ImgPanel.add(lblNewLabel_2, BorderLayout.NORTH);

		TextPanel = new JPanel();
		TextPanel.setBackground(Color.WHITE);
		contentPane.add(TextPanel, BorderLayout.CENTER);
		TextPanel.setLayout(new BorderLayout(0, 0));

		inTextPanel = new JPanel();
		inTextPanel.setBackground(new Color(245, 255, 250));
		TextPanel.add(inTextPanel, BorderLayout.CENTER);
		inTextPanel.setLayout(null);

		headTextLabel = new JLabel("Course Registration");
		headTextLabel.setBackground(new Color(0, 153, 0));
		headTextLabel.setForeground(Color.BLACK);
		headTextLabel.setFont(new Font("나눔고딕", Font.BOLD, 20));
		headTextLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headTextLabel.setBounds(0, 0, 231, 77);
		inTextPanel.add(headTextLabel);

		inputIDLabel = new JLabel("ID :");
		inputIDLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		inputIDLabel.setBounds(12, 118, 35, 15);
		inTextPanel.add(inputIDLabel);

		inputIDTextField = new JTextField();
		inputIDTextField.setBounds(59, 115, 147, 21);
		inTextPanel.add(inputIDTextField);
		inputIDTextField.setColumns(10);

		inputPWLabel = new JLabel("PW :");
		inputPWLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		inputPWLabel.setBounds(12, 162, 35, 15);
		inTextPanel.add(inputPWLabel);

		LoginButton = new JButton("LOGIN");
		LoginButton.setBackground(new Color(0, 153, 0));
		LoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (fileRead().size() == 2) { // read file
					// and check ID and password
					// RegisterGUI run
					RegisterGUI register = new RegisterGUI();
					register.setVisible(true);
					dispose();
				}
				else {
					// if ID and PW were incorrect, pop up the message
					JOptionPane.showMessageDialog(LoginGUI.this, "Incorrect ID and password");
				}
			}
		});
		LoginButton.setBounds(57, 235, 125, 40);
		inTextPanel.add(LoginButton);

		SignUpButton = new JButton("SIGN UP");
		SignUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose(); // close the loginGUI window

				// open the signup dialog
				SignupDialog signupDialog = new SignupDialog();
				signupDialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				signupDialog.setVisible(true);

			}
		});
		SignUpButton.setBackground(new Color(51, 153, 0));
		SignUpButton.setBounds(57, 300, 125, 40);
		inTextPanel.add(SignUpButton);

		inputPasswordField = new JPasswordField();
		inputPasswordField.setBounds(59, 159, 147, 21);
		inTextPanel.add(inputPasswordField);
	}

	// declaring Arraylist to check ID and PW are correct
	public ArrayList<Boolean> fileRead() {
		ArrayList<Boolean> checkContent = new ArrayList<>();

		try {
			FileInputStream fileObject = new FileInputStream("userInfo.txt");
			Scanner x = new Scanner(fileObject);

			while (x.hasNext()) {
				String line[] = x.nextLine().split(":");
				if (line[0].equals("ID")) {
					if (line[1].equals(inputIDTextField.getText())) {
						checkContent.add(true);
					}
				}
				if (line[0].equals("PW")) {
					if (line[1].equals(inputPasswordField.getText())) {
						checkContent.add(true);
					}
				}
			}
		}

		catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		return checkContent;

	}

}
