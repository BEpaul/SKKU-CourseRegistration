import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.Font;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;

public class RegisterGUI extends JFrame {

	private JPanel contentPane;
	private JPanel leftPanel;
	private JPanel rightPanel;
	private JPanel logoPanel;
	private JPanel userInfoPanel;
	private JLabel imgLabel;
	private JPanel panel;
	private JPanel semesterPanel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JPanel SIDpanel;
	private JLabel labelSID;
	private JPanel majorPanel;
	private JLabel lblNewLabel_4;
	private JPanel creditPanel;
	private JLabel lblNewLabel_5;
	private JLabel majorLabel;
	private JLabel nameLabel;
	private JLabel SIDLabel;
	private JLabel creditLabel;
	private JPanel panel_5;
	private JButton btnNewButton;
	private JScrollPane topScrollPane;
	private JButton addButton;
	private JButton delButton;
	private JScrollPane bottomScrollPane;
	private JPanel cPanel1;
	private JLabel lblNewLabel_2;
	private JPanel panel_3;
	private JLabel usedLabel;
	private JPanel panel_4;
	private JLabel lblNewLabel_7;
	private JPanel cPanel1_1;
	private JLabel remLabel;
	private JPanel panel_1;
	private JLabel lblNewLabel_9;
	private JPanel panel_2;
	private JButton btnNewButton_1;
	private JTable topTable;
	private JTable bottomTable;
	private JTable BottomTable;
	private ArrayList<Subject> basket;
	private DefaultTableModel model, model2;
	private int countCredit;
	private int countReit = 0;
	private int useCredit;
	private int remCredit;
	private double dGPA;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterGUI frame = new RegisterGUI();
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
	public RegisterGUI() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		leftPanel = new JPanel();
		contentPane.add(leftPanel, BorderLayout.WEST);
		leftPanel.setLayout(new BorderLayout(0, 0));

		logoPanel = new JPanel();
		logoPanel.setBackground(Color.WHITE);
		leftPanel.add(logoPanel, BorderLayout.NORTH);

		imgLabel = new JLabel("");
		imgLabel.setIcon(new ImageIcon("C:\\Users\\saals\\Desktop\\skk logo\\skkmini.png"));
		logoPanel.add(imgLabel);

		userInfoPanel = new JPanel();
		userInfoPanel.setBackground(Color.WHITE);
		leftPanel.add(userInfoPanel, BorderLayout.CENTER);
		userInfoPanel.setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(154, 205, 50));
		panel.setBounds(5, 70, 77, 42);
		userInfoPanel.add(panel);
		panel.setLayout(null);

		lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 0, 77, 42);
		panel.add(lblNewLabel_1);

		semesterPanel = new JPanel();
		semesterPanel.setBackground(new Color(154, 205, 50));
		semesterPanel.setBounds(0, 0, 196, 51);
		userInfoPanel.add(semesterPanel);
		semesterPanel.setLayout(null);

		lblNewLabel = new JLabel("22 - 1");
		lblNewLabel.setFont(new Font("나눔고딕", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 10, 196, 31);
		semesterPanel.add(lblNewLabel);

		SIDpanel = new JPanel();
		SIDpanel.setLayout(null);
		SIDpanel.setBackground(new Color(154, 205, 50));
		SIDpanel.setBounds(5, 140, 77, 42);
		userInfoPanel.add(SIDpanel);

		labelSID = new JLabel("S-ID");
		labelSID.setBounds(0, 0, 77, 42);
		SIDpanel.add(labelSID);
		labelSID.setHorizontalAlignment(SwingConstants.CENTER);
		labelSID.setFont(new Font("굴림", Font.PLAIN, 12));

		majorPanel = new JPanel();
		majorPanel.setLayout(null);
		majorPanel.setBackground(new Color(154, 205, 50));
		majorPanel.setBounds(5, 210, 77, 42);
		userInfoPanel.add(majorPanel);

		lblNewLabel_4 = new JLabel("Major");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(0, 0, 77, 42);
		majorPanel.add(lblNewLabel_4);

		creditPanel = new JPanel();
		creditPanel.setLayout(null);
		creditPanel.setBackground(new Color(154, 205, 50));
		creditPanel.setBounds(5, 280, 77, 42);
		userInfoPanel.add(creditPanel);

		lblNewLabel_5 = new JLabel("<html>Available<br>  Credit</html>");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(0, 0, 77, 42);
		creditPanel.add(lblNewLabel_5);

		majorLabel = new JLabel("space");
		majorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		majorLabel.setBounds(85, 210, 108, 42);
		userInfoPanel.add(majorLabel);

		nameLabel = new JLabel("space");
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setBounds(85, 70, 108, 42);
		userInfoPanel.add(nameLabel);

		SIDLabel = new JLabel("space");
		SIDLabel.setHorizontalAlignment(SwingConstants.CENTER);
		SIDLabel.setBounds(85, 140, 108, 42);
		userInfoPanel.add(SIDLabel);

		creditLabel = new JLabel("space");
		creditLabel.setHorizontalAlignment(SwingConstants.CENTER);
		creditLabel.setBounds(85, 280, 108, 42);
		userInfoPanel.add(creditLabel);

		panel_5 = new JPanel();
		panel_5.setBackground(new Color(154, 205, 50));
		panel_5.setBounds(50, 431, 106, 38);
		userInfoPanel.add(panel_5);
		panel_5.setLayout(null);

		// if the user enter the LOGOUT button, move to login window
		btnNewButton = new JButton("LOGOUT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginGUI lg = new LoginGUI();
				lg.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				lg.setVisible(true);
			}
		});
		btnNewButton.setBounds(0, 0, 106, 38);
		panel_5.add(btnNewButton);
		btnNewButton.setBackground(new Color(154, 205, 50));

		rightPanel = new JPanel();
		rightPanel.setBackground(UIManager.getColor("Button.background"));
		contentPane.add(rightPanel, BorderLayout.CENTER);
		rightPanel.setLayout(null);

		topScrollPane = new JScrollPane();
		topScrollPane.setBounds(17, 30, 949, 251);
		rightPanel.add(topScrollPane);

		bottomScrollPane = new JScrollPane();
		bottomScrollPane.setBounds(17, 324, 949, 251);
		rightPanel.add(bottomScrollPane);

		// read the file retaining user information
		try {
			FileInputStream fileObject = new FileInputStream("userInfo.txt");
			Scanner x = new Scanner(fileObject);

			// for declaring the variable to count credit
			countCredit = 0;

			boolean checkMajor = true;
			while (x.hasNext()) {
				String line[] = x.nextLine().split(":");
				if (line[0].equals("Name")) {
					nameLabel.setText(line[1]);
				}
				if (line[0].equals("Student ID")) {
					SIDLabel.setText(line[1]);
				}
				if (line[0].equals("Major")) {
					if (line[1].equals("CS")) {
						majorLabel.setText("<html>Computer Science <br>and Engineering</html>");

					} else if (line[1].equals("BA")) {
						majorLabel.setText("<html>Business <br>Administration</html>");
						checkMajor = false;
					}
				}
				// give credit according to GPA and credit
				if (line[0].equals("GPA") && checkMajor == true) {
					dGPA = Double.parseDouble(line[1]);
					if (dGPA < 1.75) {
						creditLabel.setText("15");
						countCredit = 1;
					} else if (dGPA < 4) {
						creditLabel.setText("18");
						countCredit = 2;
					} else {
						creditLabel.setText("21");
						countCredit = 3;
					}
				} else if (line[0].equals("GPA") && checkMajor == false) {
					dGPA = Double.parseDouble(line[1]);
					if (dGPA < 1.75) {
						creditLabel.setText("12");
						countCredit = 4;
					} else if (dGPA < 4) {
						creditLabel.setText("15");
						countCredit = 5;
					} else {
						creditLabel.setText("18");
						countCredit = 6;
					}
				}

			}
			// init value in the Credit used and remained
//          remLabel.setText("" + dGPA);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// declaring arraylist to store value for deduplicating
		basket = new ArrayList<Subject>();
		BottomTable = new JTable();
		BottomTable.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "No.", "Lecture", "Professor", "Week of days", "Mode" }));
		BottomTable.setBackground(Color.WHITE);
		bottomScrollPane.setViewportView(BottomTable);

		// Add headline and contents into upper table
		String header[] = { "No.", "Lecture", "Professor", "Week of days", "Mode" };
		String topContents[][] = { { "10310", "JAVA Programming", "Tamer", "Tue", "Hybrid" },
				{ "23121", "Database", "Kim", "Thu", "Online" }, { "40518", "C Programming", "Tang", "Mon", "Offline" },
				{ "21605", "Network", "Choi", "Wed", "Offline" },
				{ "71201", "Operating System", "Shin", "Fri", "Online" },
				{ "21101", "Data Structure", "Lee", "Tue", "Offline" },
				{ "23403", "Logic Circuit", "Lee", "Wed", "Offline" },
				{ "19310", "Machine Learning", "Kim", "Mon", "Online" },
				{ "74809", "Application Prcatice", "Lee", "Tue", "Offline" },
				{ "04951", "Computer Architecture", "Woo", "Fri", "Hybrid" },
				{ "40401", "System Programming", "Mah", "Wed", "Online" },
				{ "80206", "Artificial Intelligence", "Koo", "Thu", "Online" },
				{ "31204", "Computer Science", "Kim", "Mon", "Offline" },
				{ "59104", "Python Programming", "Daniel", "Fri", "Online" },
				{ "13110", "SoftwareI", "Ahn", "Tue", "Offline" },
				{ "30151", "Programming Language", "Tamer", "Thu", "Offline" },
				{ "49132", "Business", "Ken", "Mon", "Offline" },
				{ "49132", "American cultuer", "James", "Fri", "Online" }};

		topTable = new JTable();
		model = new DefaultTableModel(topContents, header);
		topTable.setModel(model);
		topTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		topTable.setBounds(50, 30, 150, 100);
		topScrollPane.setViewportView(topTable);

		// if the user enter add button, add my list selected
		addButton = new JButton("ADD");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Student stu = null;
				try {
					countReit++;
					// different Credit according to GPA and Major
					// using polymorphism and inheritance
					if (countCredit == 1) {
						stu = new CS(15, 3 * countReit, remCredit);
						usedLabel.setText("" + 3 * countReit);
						remLabel.setText("" + stu.calculateCredit());
					} else if (countCredit == 2) {
						stu = new CS(18, 3 * countReit, remCredit);
						usedLabel.setText("" + 3 * countReit);
						remLabel.setText("" + stu.calculateCredit());
					} else if (countCredit == 3) {
						stu = new CS(21, 3 * countReit, remCredit);
						usedLabel.setText("" + 3 * countReit);
						remLabel.setText("" + stu.calculateCredit());
					} else if (countCredit == 4) {
						stu = new BA(12, 3 * countReit, remCredit);
						usedLabel.setText("" + 3 * countReit);
						remLabel.setText("" + stu.calculateCredit());
					} else if (countCredit == 5) {
						stu = new BA(15, 3 * countReit, remCredit);
						usedLabel.setText("" + 3 * countReit);
						remLabel.setText("" + stu.calculateCredit());
					} else if (countCredit == 6) {
						stu = new BA(18, 3 * countReit, remCredit);
						usedLabel.setText("" + 3 * countReit);
						remLabel.setText("" + stu.calculateCredit());
					}

					// exception handling about maximum course registration
					if (stu.calculateCredit() == 0) {
						throw new MyException("er");
					}
				} catch (MyException err) {
					JOptionPane.showMessageDialog(null, "It's maximal", "Max", JOptionPane.ERROR_MESSAGE);
				}

				try {
					int n = topTable.getSelectedRow();

					if (n < 0) {
						throw new MyException("Error occurs");
					}

					model2 = (DefaultTableModel) BottomTable.getModel();
					// for deduplication
					int isbasket = 0;
					for (int i = 0; i < basket.size(); i++) {
						if (basket.get(i).getNum().equals(topContents[n][0])) {
							isbasket = 1;
						}
					}
					if (isbasket == 1) {
						JOptionPane.showMessageDialog(null, "duplicate!", "Warning", JOptionPane.ERROR_MESSAGE);
						countReit--;
					} else {
						model2.addRow(new Object[] { topContents[n][0], topContents[n][1], topContents[n][2],
								topContents[n][3], topContents[n][4] });
						basket.add(new Subject(topContents[n][0], topContents[n][1], topContents[n][2],
								topContents[n][3], topContents[n][4]));
					}
				} catch (MyException er) {
					JOptionPane.showMessageDialog(null, "Please Select which one!", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		addButton.setBounds(348, 291, 97, 23);
		rightPanel.add(addButton);

		// if user enter the delete button, remove elements from my list
		delButton = new JButton("DELETE");
		delButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Student stu = null;
				try {
					countReit--;
					// different Credit according to GPA and Major
					// using polymorphism and inheritance
					if (countCredit == 1) {
						stu = new CS(15, 3 * countReit, remCredit);
						usedLabel.setText("" + 3 * countReit);
						remLabel.setText("" + stu.calculateCredit());
						System.out.println(stu.calculateCredit());
					} else if (countCredit == 2) {
						stu = new CS(18, 3 * countReit, remCredit);
						usedLabel.setText("" + 3 * countReit);
						remLabel.setText("" + stu.calculateCredit());
						System.out.println(stu.calculateCredit());
					} else if (countCredit == 3) {
						stu = new CS(21, 3 * countReit, remCredit);
						usedLabel.setText("" + 3 * countReit);
						remLabel.setText("" + stu.calculateCredit());
						System.out.println(stu.calculateCredit());
					} else if (countCredit == 4) {
						stu = new BA(12, 3 * countReit, remCredit);
						usedLabel.setText("" + 3 * countReit);
						remLabel.setText("" + stu.calculateCredit());
					} else if (countCredit == 5) {
						stu = new BA(15, 3 * countReit, remCredit);
						usedLabel.setText("" + 3 * countReit);
						remLabel.setText("" + stu.calculateCredit());
					} else if (countCredit == 6) {
						stu = new BA(18, 3 * countReit, remCredit);
						usedLabel.setText("" + 3 * countReit);
						remLabel.setText("" + stu.calculateCredit());
					}
					// exception handling about minimum course registration
					if (countCredit == 1 || countCredit == 5) {
						if (stu.calculateCredit() == 15) {
							throw new MyException("er");
						}
					} else if (countCredit == 2 || countCredit == 6) {
						if (stu.calculateCredit() == 18) {
							throw new MyException("er");
						}
					} else if (countCredit == 3) {
						if (stu.calculateCredit() == 21) {
							throw new MyException("er");
						}
					} else if (countCredit == 4) {
						if (stu.calculateCredit() == 12) {
							throw new MyException("er");
						}
					}
				} catch (MyException err) {
					JOptionPane.showMessageDialog(null, "It's minimal", "Min", JOptionPane.INFORMATION_MESSAGE);
				}
				try {
					int n = BottomTable.getSelectedRow();
					if (n < 0) {
						throw new MyException("Error occurs");
					}
					model2 = (DefaultTableModel) BottomTable.getModel();

					// basket에서도 삭제하기 위해 index 찾기
					int rebasket = 0;
					for (int i = 0; i < basket.size(); i++) {
						if ((basket.get(i).getNum()).equals(topContents[n][0])) {
							rebasket = i;

						}
					}
					model2.removeRow(n);
					basket.remove(rebasket);

				} catch (MyException er) {
					JOptionPane.showMessageDialog(null, "Please Select which one!", "ERROR", JOptionPane.INFORMATION_MESSAGE);
				}
			}

		});
		delButton.setBounds(507, 291, 97, 23);
		rightPanel.add(delButton);

		cPanel1 = new JPanel();
		cPanel1.setLayout(null);
		cPanel1.setBackground(new Color(154, 205, 50));
		cPanel1.setBounds(17, 584, 97, 57);
		rightPanel.add(cPanel1);

		lblNewLabel_2 = new JLabel("Credit Status");
		lblNewLabel_2.setBounds(0, 0, 97, 57);
		cPanel1.add(lblNewLabel_2);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 12));

		panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(235, 585, 97, 57);
		rightPanel.add(panel_3);

		usedLabel = new JLabel("0");
		usedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		usedLabel.setFont(new Font("굴림", Font.PLAIN, 12));
		usedLabel.setBounds(0, 0, 97, 57);
		panel_3.add(usedLabel);

		panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(154, 205, 50));
		panel_4.setBounds(344, 585, 97, 57);
		rightPanel.add(panel_4);

		lblNewLabel_7 = new JLabel("Remained");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(0, 0, 97, 57);
		panel_4.add(lblNewLabel_7);

		cPanel1_1 = new JPanel();
		cPanel1_1.setLayout(null);
		cPanel1_1.setBackground(Color.WHITE);
		cPanel1_1.setBounds(453, 584, 97, 57);
		rightPanel.add(cPanel1_1);

		remLabel = new JLabel("Available Credit");
		remLabel.setHorizontalAlignment(SwingConstants.CENTER);
		remLabel.setFont(new Font("굴림", Font.PLAIN, 12));
		remLabel.setBounds(0, 0, 97, 57);
		cPanel1_1.add(remLabel);

		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(154, 205, 50));
		panel_1.setBounds(126, 585, 97, 57);
		rightPanel.add(panel_1);

		lblNewLabel_9 = new JLabel("Used");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_9.setBounds(0, 0, 97, 57);
		panel_1.add(lblNewLabel_9);

		panel_2 = new JPanel();
		panel_2.setBackground(new Color(107, 142, 35));
		panel_2.setBounds(562, 585, 404, 56);
		rightPanel.add(panel_2);
		panel_2.setLayout(null);

		btnNewButton_1 = new JButton("REGISTRATION");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckDialog cd = new CheckDialog();
				cd.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				cd.setVisible(true);
			}
		});
		btnNewButton_1.setBackground(new Color(107, 142, 35));
		btnNewButton_1.setFont(new Font("굴림", Font.PLAIN, 18));
		btnNewButton_1.setBounds(0, 0, 404, 56);
		panel_2.add(btnNewButton_1);

	}
}