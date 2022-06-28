import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class SignupDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField signupNameTextField;
	private JTextField signupSIDTextField;
	private JTextField signupGPATextField;
	private JTextField signupIDTextField;
	private JRadioButton signupMRadioButton;
	private JRadioButton signupWRadioButton;
	private JPasswordField signupPasswordField;
	private JPasswordField comfirmPasswordField;
	private boolean checkException;
	private String txtName;
	private String txtSID;
	private String txtGPA;
	private String txtID;
	private String txtPW;
	private String txtConPW;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SignupDialog dialog = new SignupDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void fileWrite() {

		txtName = signupNameTextField.getText();
		txtSID = signupSIDTextField.getText();
		txtGPA = signupGPATextField.getText();
		txtID = signupIDTextField.getText();
		txtPW = signupPasswordField.getText();
		txtConPW = comfirmPasswordField.getText();

		// declaring Arraylist to store error message contents
		ArrayList<String> problemList = new ArrayList<>();
		checkException = true;
		try {
			// to output into the text file
			FileOutputStream fileObject = new FileOutputStream("userInfo.txt", false);
			PrintWriter x = new PrintWriter(fileObject);

			// exception handling and printing about name
			if (txtName.length() > 0 && txtName.length() <= 20) {
				x.println("Name:" + txtName);
			} else {
				problemList.add("Please enter name more than 0 and less than 20\n");
				checkException = false;
			}
			// exception handling and printing about Student ID
			if (txtSID.matches("\\d{10}")) {
				x.println("Student ID:" + txtSID);
			} else {
				problemList.add("Please enter 10 digits\n");
				checkException = false;
			}
			// printing about Major
			if (comboBox.getSelectedIndex() == 0) {
				x.println("Major:CS");
			} else if (comboBox.getSelectedIndex() == 1) {
				x.println("Major:BA");
			}

			// printing about Sex
			if (signupMRadioButton.isSelected()) {
				x.println("Sex:M");
			} else if (signupWRadioButton.isSelected()) {
				x.println("Sex:W");
			}
			// exception handling and printing about GPA
			// Exception handling in case of double type having value of NULL
			if (txtGPA.equals("")) {
				problemList.add("Please enter the GPA more than 0 and less than 4.5\n");
				checkException = false;
			} else {
				Double doubleGPA = Double.parseDouble(txtGPA);
				if (doubleGPA > 0 && doubleGPA <= 4.5) {
					x.println("GPA:" + doubleGPA);
				} else {
					problemList.add("Please enter value more than 0 and less than 4.5\n");
					checkException = false;
				}
			}
			// exception handling and printing about ID
			if (txtID.length() > 0 && txtID.length() <= 15) {
				x.println("ID:" + txtID);
			} else {
				problemList.add("Please enter ID more than 0 and less than 15\n");
				checkException = false;
			}
			// exception handling and printing about PW
			if (txtPW.equals(txtConPW)) {
				if (txtPW.length() > 0 && txtPW.length() <= 15) {
					x.println("PW:" + txtPW);
				} else {
					problemList.add("Please enter password more than 0 and less than 15\n");
					checkException = false;
				}
			} else {
				problemList.add("Passwords do not match!");
				checkException = false;
			}
			// close the file
			x.close();

			if (checkException == false) {
				throw new MyException("Exception execute");
			}
			// if an errors occurs, pop up the error message window
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (MyException error) {
			String txtProblem = "";
			for (int i = 0; i < problemList.size(); i++) {
				txtProblem += (i + 1) + ". " + problemList.get(i);
			}
			// error occurs then pop up the message
			JOptionPane.showMessageDialog(null, txtProblem, "You have following problems:", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Create the dialog.
	 */
	public SignupDialog() {
		setBounds(100, 100, 465, 420);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel signupNameLabel = new JLabel("Name :");
			signupNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			signupNameLabel.setBounds(45, 20, 95, 15);
			contentPanel.add(signupNameLabel);
		}
		{
			JLabel signupSIDLabel = new JLabel("Student-ID :");
			signupSIDLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			signupSIDLabel.setBounds(45, 60, 95, 15);
			contentPanel.add(signupSIDLabel);
		}
		{
			JLabel signupSexLabel = new JLabel("Sex :");
			signupSexLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			signupSexLabel.setBounds(45, 140, 95, 15);
			contentPanel.add(signupSexLabel);
		}
		{
			JLabel signupGPALabel = new JLabel("GPA :");
			signupGPALabel.setHorizontalAlignment(SwingConstants.RIGHT);
			signupGPALabel.setBounds(45, 180, 95, 15);
			contentPanel.add(signupGPALabel);
		}
		{
			JLabel signupIDLabel = new JLabel("ID :");
			signupIDLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			signupIDLabel.setBounds(45, 220, 95, 15);
			contentPanel.add(signupIDLabel);
		}
		{
			JLabel signupPWLabel = new JLabel("PW :");
			signupPWLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			signupPWLabel.setBounds(45, 260, 95, 15);
			contentPanel.add(signupPWLabel);
		}
		{
			JLabel ConfirmPWLabel = new JLabel("Confirm PW :");
			ConfirmPWLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			ConfirmPWLabel.setBounds(45, 300, 95, 15);
			contentPanel.add(ConfirmPWLabel);
		}
		{
			signupNameTextField = new JTextField();
			signupNameTextField.setBounds(149, 17, 202, 21);
			contentPanel.add(signupNameTextField);
			signupNameTextField.setColumns(10);
		}
		{
			signupSIDTextField = new JTextField();
			signupSIDTextField.setColumns(10);
			signupSIDTextField.setBounds(149, 57, 202, 21);
			contentPanel.add(signupSIDTextField);
		}
		{
			signupGPATextField = new JTextField();
			signupGPATextField.setColumns(10);
			signupGPATextField.setBounds(149, 177, 202, 21);
			contentPanel.add(signupGPATextField);
		}
		{
			signupIDTextField = new JTextField();
			signupIDTextField.setColumns(10);
			signupIDTextField.setBounds(149, 217, 202, 21);
			contentPanel.add(signupIDTextField);
		}

		signupMRadioButton = new JRadioButton("M");
		signupMRadioButton.setSelected(true);
		signupMRadioButton.setBackground(Color.WHITE);
		signupMRadioButton.setBounds(149, 136, 37, 23);
		contentPanel.add(signupMRadioButton);

		signupWRadioButton = new JRadioButton("W");
		signupWRadioButton.setBackground(Color.WHITE);
		signupWRadioButton.setBounds(190, 136, 37, 23);
		contentPanel.add(signupWRadioButton);

		// only one radio button of the two is activated
		ButtonGroup G = new ButtonGroup();
		G.add(signupMRadioButton);
		G.add(signupWRadioButton);

		signupPasswordField = new JPasswordField();
		signupPasswordField.setBounds(149, 257, 202, 21);
		contentPanel.add(signupPasswordField);

		comfirmPasswordField = new JPasswordField();
		comfirmPasswordField.setBounds(149, 297, 202, 21);
		contentPanel.add(comfirmPasswordField);
		{
			JLabel signupMajorLabel = new JLabel("Major :");
			signupMajorLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			signupMajorLabel.setBounds(45, 100, 95, 15);
			contentPanel.add(signupMajorLabel);
		}

		// declaring array to store major information
		String major[] = { "Computer Science and Engineering", "Business Administration" };
		comboBox = new JComboBox();
		comboBox.addItem(major[0]);
		comboBox.addItem(major[1]);
		comboBox.setBounds(149, 96, 202, 23);
		contentPanel.add(comboBox);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton registerButton = new JButton("Register");
				registerButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// call the fileWrite method
						fileWrite();
						// If an error occurs, it does not go to the login window
						if (checkException == true) {
							dispose();
							LoginGUI logingui = new LoginGUI();
							logingui.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
							logingui.setVisible(true);
						}

					}
				});
				registerButton.setActionCommand("OK");
				buttonPane.add(registerButton);
				getRootPane().setDefaultButton(registerButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
