import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.LocalDateTime;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JPasswordField; 


/**
 * 
 */

/**
 * @author Jimmy Chavada(all functions), Inder Sodhi(looks/design, add a bit to functions), Bilal Faheem(functions) 
 * Date: January 2022
 * Description: The user interface that puts all classes together to form the bank account.
 * Method List: public void createNewTitle (TextPicture txtHeader) - Method to set font
 * 				public GUI() - Constructor 
 * 				public static void main(String[] args) - call GUI
 *				public void actionPerformed(ActionEvent e) - Code buttons 
 * 
 *
 */
public class GUI extends JFrame implements ActionListener{

	// instance variables
	private Customer customer; 
	private Savings savings; 
	private Account account; 
	private JButton exit;
	private JButton empSave;
	private JButton empRead;
	private JButton viewPersonalInfo;
	private JButton personalInfo;
	private JButton initalBalances;
	private JButton saveTrans;
	private JTextArea txtSavingsT;
	private JTextArea txtGICT;
	private JLabel lblSavingsT;
	private JLabel lblGICT;
	private JButton btnAccount;
	private JButton btnEmployee;
	private JLabel lblSavingsBal;
	private JLabel lblGICBal; 
	private JButton btnDeposit; 
	private JButton btnWithdraw; 
	private JButton viewAcnt;
	private JLabel lblViewAcnt;
	private JTextField txtViewAcnt;
	private TextPicture txtHeader; 
	private JPanel controlPanel; 
	private JLabel lblEmployeeP;
	private JPasswordField txtEmployeeP; 
	private JLabel lblEmployeeN;
	private JTextField txtEmployeeN;
	private JLabel lblAccountP;
	private JPasswordField txtAccountP; 
	private JLabel lblAccountN;
	private JTextField txtAccountN;
	private JTextArea txtViewBalanceG; 
	private JTextArea txtViewBalanceS; 
	private ImagePicture BackgroundImage;
	private Customer c = new Customer();
	private Savings savingsAccount = new Savings(c);
	private GIC gic = new GIC();
	private Customer c2 = new Customer(); 
	private Savings savingsAccount2 = new Savings(c2); 
	private GIC gic2 = new GIC();
	private TransactionRecord trans = new TransactionRecord(); 
	private double dataArrayS[]; 
	private double dataArrayG[]; 
	private double dataArrayS2[]; 
	private double dataArrayG2[];
	private int counterS;
	private int counterG;
	private double startingBalS; 
	private double StartingBalG; 
	private double amountS; 
	private double amountG; 
	private TransactionList transList = new TransactionList(); 
	private int counterLogin; 

	/*
	 * Method to set font 
	 */
	public void createNewTitle (TextPicture txtHeader) { 
		txtHeader.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 50));
	}
	/**
	 * Constructor
	 */
	public GUI() {
		super();
		this.customer  = new Customer(); // create a customer object
		this.savings = new Savings(this.customer); // create a savings object
		this.account = new Account(this.customer); // create a account object


		setLayout(null); // set layout to null

		dataArrayS = new double[20]; // data array for savings
		dataArrayG = new double[20]; // data array for GIC
		dataArrayS2 = new double[20]; // data array for savings
		dataArrayG2 = new double[20]; // data array for GIC
		counterS = 0; // counter for savings
		counterG = 0; // counter for GIC
		counterLogin = 0; // counter for number of logins

		// set labels on buttons
		viewAcnt = new JButton("View Account");
		empSave = new JButton("Save File Of User");
		empRead = new JButton("Read File of User");
		viewPersonalInfo = new JButton("Click Here To View Personal Information");
		saveTrans = new JButton("View Transactions");
		btnDeposit = new JButton("Deposit");
		btnWithdraw = new JButton("Withdraw");
		btnAccount = new JButton("Login");
		btnEmployee = new JButton("Employee Login");
		personalInfo = new JButton("Click Here To Enter Personal Information");
		initalBalances = new JButton("Click Here To Set Savings And GIC Balances");
		exit = new JButton("Logout");

		controlPanel = new JPanel(); // control panel

		// setting header texts
		txtHeader = new TextPicture("Royal Bank Of Campos", Font.PLAIN, 50); 
		txtHeader.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 40));
		txtHeader.setC(Color.RED);
		txtHeader.setBounds(300,0,800,70);

		txtAccountP = new JPasswordField("", 150); // password for login
		lblAccountP = new JLabel("Enter Account Password"); // label

		JPasswordField password = new JPasswordField(); // make password field display asterisk using https://docs.oracle.com/javase/7/docs/api/javax/swing/JPasswordField.html#:~:text=JPasswordField%20is%20a%20lightweight%20component,section%20in%20The%20Java%20Tutorial
		password.setEchoChar('#');

		lblSavingsBal = new JLabel("Savings Balance");
		lblSavingsBal.setForeground(Color.red);
		lblGICBal = new JLabel("GIC Balance");
		lblGICBal.setForeground(Color.red);
		lblSavingsT = new JLabel("Saving Transactions");
		lblSavingsT.setForeground(Color.red);
		lblGICT = new JLabel("GIC Transactions");
		lblGICT.setForeground(Color.red); // set JLabels and their colours to show where things are displayed

		txtAccountN = new JTextField("", 150); // user name for login
		lblAccountN = new JLabel("Enter Account ID"); // label

		// set label boundaries
		lblAccountP.setBounds(515, 75, 250, 20);
		lblAccountN.setBounds(255, 75, 250, 20);

		// set textfield boundaries
		txtAccountP.setBounds(515, 95, 250, 20);
		txtAccountN.setBounds(255, 95, 250, 20);

		// password for employee and label
		txtEmployeeP = new JPasswordField("", 150);
		lblEmployeeP = new JLabel("Enter Employee Password");

		// user name for employee and label
		txtEmployeeN = new JTextField("", 150);
		lblEmployeeN = new JLabel("Enter Employee ID");

		// set bounds for labels
		lblEmployeeP.setBounds(515, 295, 250, 20);
		lblEmployeeN.setBounds(255, 295, 250, 20);

		// set bounds for textfields
		txtEmployeeP.setBounds(515, 315, 250, 20);
		txtEmployeeN.setBounds(255, 315, 250, 20);

		// text field and label for entering account to view
		txtViewAcnt = new JTextField("", 150);
		lblViewAcnt = new JLabel("Enter Account Name To View");

		// set bounds for text field and label
		lblViewAcnt.setBounds(415, 195, 250, 20);
		txtViewAcnt.setBounds(375, 215, 250, 20);
		viewAcnt.setBounds(445, 235, 120, 30);

		// text areas for viewing balances for GIC and savings accounts
		txtViewBalanceG = new JTextArea();
		txtViewBalanceS= new JTextArea();
		txtViewBalanceG.setEditable(false); // set both to not editable
		txtViewBalanceS.setEditable(false);


		txtSavingsT = new JTextArea();
		txtGICT = new JTextArea();
		txtSavingsT.setEditable(false);
		txtGICT.setEditable(false);

		// set bounds for the  text areas
		txtSavingsT.setBounds(10, 330, 200, 300);
		txtGICT.setBounds(780, 330, 200, 300);
		lblSavingsT.setBounds(60, 290, 200, 30);
		lblGICT.setBounds(830, 290, 200, 30);

		// set bounds for viewing balance for each account type
		txtViewBalanceS.setBounds(10, 250, 200, 30);
		txtViewBalanceG.setBounds(780, 250, 200, 30);

		// set bounds for buttons
		btnWithdraw.setBounds(340, 280, 90, 30);
		btnDeposit.setBounds(590, 280, 90, 30);

		empSave.setBounds(40, 280, 130, 30);
		empRead.setBounds(820, 280, 130, 30);

		personalInfo.setBounds(315,150,400,40);
		initalBalances.setBounds(315,192,400,40);
		viewPersonalInfo.setBounds(315,234,400,40);
		saveTrans.setBounds(415,434,200,30);

		btnEmployee.setBounds(430, 335, 175, 30);
		btnAccount.setBounds(475, 115, 75, 30);
		lblSavingsBal.setBounds(65, 220, 200, 30);
		lblGICBal.setBounds(840, 220, 200, 30);

		exit.setBounds(450, 605, 100, 32);

		// set background image
		BackgroundImage = new ImagePicture((new ImageIcon("Background.png")),-120,0);

		// add components
		add(btnWithdraw);
		add(btnDeposit);
		add(empRead);
		add(empSave);

		add(lblViewAcnt);
		add(txtViewAcnt);
		add(viewAcnt);

		add(personalInfo);
		add(initalBalances);
		add(viewPersonalInfo);
		add(saveTrans);
		add(exit);

		add(lblSavingsT);
		add(lblGICT);
		add(txtSavingsT);
		add(txtGICT);

		add(txtViewBalanceG);
		add(txtViewBalanceS);

		add(btnEmployee);
		add(btnAccount);
		add(lblSavingsBal);
		add(lblGICBal);

		add(txtHeader); 
		add(lblAccountN);
		add(lblAccountP);
		add(txtAccountN);
		add(txtAccountP);
		add(lblEmployeeN);
		add(lblEmployeeP);
		add(txtEmployeeN);
		add(txtEmployeeP);

		// set most things to invisible
		btnWithdraw.setVisible(false);
		btnDeposit.setVisible(false);
		personalInfo.setVisible(false);
		initalBalances.setVisible(false);
		viewPersonalInfo.setVisible(false);
		saveTrans.setVisible(false);
		exit.setVisible(false);
		lblSavingsT.setVisible(false);
		lblGICT.setVisible(false);
		txtSavingsT.setVisible(false);
		txtGICT.setVisible(false);
		txtViewBalanceG.setVisible(false);
		txtViewBalanceS.setVisible(false);
		lblSavingsBal.setVisible(false);
		lblGICBal.setVisible(false);
		empRead.setVisible(false);
		empSave.setVisible(false);
		lblViewAcnt.setVisible(false);
		txtViewAcnt.setVisible(false);
		viewAcnt.setVisible(false);

		// add action listeners for buttons
		viewAcnt.addActionListener(this);
		empRead.addActionListener(this);
		empSave.addActionListener(this);
		btnEmployee.addActionListener(this); 
		btnWithdraw.addActionListener(this); 
		btnDeposit.addActionListener(this);
		personalInfo.addActionListener(this);
		initalBalances.addActionListener(this);
		viewPersonalInfo.addActionListener(this);
		saveTrans.addActionListener(this);
		btnAccount.addActionListener(this);
		exit.addActionListener(this);

		// set size of the window and location on users screen
		setSize(1000,700); 
		setLocation(100,100); 

		// set the bounds of the background image
		BackgroundImage.setBounds(0, 0, 1000, 700);
		add(BackgroundImage); // use as background and add it to JFrame

		setVisible(true); // set window to visible
		setResizable(false); // make the window not resizable
		setDefaultCloseOperation(EXIT_ON_CLOSE); // exit when the x button is pressed

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new GUI(); // call the GUI
	}

	@Override
	public void actionPerformed(ActionEvent e) {    

		// final output strings
		String finalOutputS = " "; 
		String finalOutputG = " ";

		// if the viewPersonalInfo button is pressed
		if(e.getSource() == viewPersonalInfo) {
			if(txtAccountN.getText().equalsIgnoreCase("Bilal") && txtAccountP.getText().equalsIgnoreCase("Pro gamer")) { // if it is the user "Bilal" with password
				JOptionPane.showMessageDialog(null, "User data: " + c.toString()); // display personal info
			}
			else if(txtAccountN.getText().equalsIgnoreCase("User") && txtAccountP.getText().equalsIgnoreCase("Password")) { // if it is the user "user" with password
				JOptionPane.showMessageDialog(null, "User data: " + c2.toString()); // display personal info
			}
		}
		// if the empSave button is pressed
		if(e.getSource() == empSave) { 
			if(txtViewAcnt.getText().equalsIgnoreCase("Bilal")) { // if the text entered is equal to Bilal

				transList.bubbleSort(); // bubble sort the list
				String fileName = JOptionPane.showInputDialog(null,"Enter the file you would like to save this data to: "); // ask the user to enter file name

				try { // try to use inputTextFile using file name and transaction list
					TransactionList.inputTextFile(fileName, transList.toString());
					JOptionPane.showMessageDialog(null, "File saved!"); // tell user file was saved
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 

				JOptionPane.showMessageDialog(null, "User Transactions: \n" + transList.toString()); // display the user transactions
			}
			else if(txtViewAcnt.getText().equalsIgnoreCase("User")) { // if the text entered is equal to User
				transList.bubbleSort(); // bubble sort the list
				String fileName = JOptionPane.showInputDialog(null,"Enter the file you would like to save this data to: "); // ask the user to enter file name

				try { // try to use inputTextFile using file name and transaction list
					TransactionList.inputTextFile(fileName, transList.toString());
					JOptionPane.showMessageDialog(null, "File saved!"); // tell user file was saved
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 

				JOptionPane.showMessageDialog(null, "User Transactions: \n" + transList.toString()); // display the user transactions
			}
		}

		if(e.getSource() == empRead) {
			String file = JOptionPane.showInputDialog(null, "Enter the file you would like to read from: ", "ReadFileTest.txt"); 
			try {
				JOptionPane.showMessageDialog(null, TransactionList.readTextFile(file));
			} catch (HeadlessException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		// if btnAccount button is pressed
		if(e.getSource() == btnAccount) {
			// add 1 to login counter
			counterLogin++; 
			if(txtAccountN.getText().equalsIgnoreCase("Bilal") && txtAccountP.getText().equalsIgnoreCase("Pro gamer")
					||txtAccountN.getText().equalsIgnoreCase("User") && txtAccountP.getText().equalsIgnoreCase("Password")) {				

				if(counterLogin == 1) {
					// set items that need to be set to false and true for visibility 
					lblEmployeeN.setVisible(false);
					lblEmployeeP.setVisible(false);
					txtEmployeeN.setVisible(false);
					txtEmployeeP.setVisible(false);
					btnEmployee.setVisible(false);
					lblAccountN.setVisible(false);
					lblAccountP.setVisible(false);
					txtAccountN.setVisible(false);
					txtAccountP.setVisible(false);
					btnAccount.setVisible(false);	
					btnWithdraw.setVisible(true);
					btnDeposit.setVisible(true);
					personalInfo.setVisible(true);
					initalBalances.setVisible(true);
					viewPersonalInfo.setVisible(true);
					saveTrans.setVisible(true);
					exit.setVisible(true);
					lblSavingsT.setVisible(true);
					lblGICT.setVisible(true);
					txtSavingsT.setVisible(true);
					txtGICT.setVisible(true);
					txtViewBalanceG.setVisible(true);
					txtViewBalanceS.setVisible(true);
					lblSavingsBal.setVisible(true);
					lblGICBal.setVisible(true);
					empRead.setVisible(false);
					empSave.setVisible(false);
					lblViewAcnt.setVisible(false);
					txtViewAcnt.setVisible(false);
					viewAcnt.setVisible(false);
					// display login counter for testing
					//System.out.println(counterLogin);
				}
				else{
					// set items that need to be set to false and true for visibility 
					lblEmployeeN.setVisible(false);
					lblEmployeeP.setVisible(false);
					txtEmployeeN.setVisible(false);
					txtEmployeeP.setVisible(false);
					btnEmployee.setVisible(false);
					lblAccountN.setVisible(false);
					lblAccountP.setVisible(false);
					txtAccountN.setVisible(false);
					txtAccountP.setVisible(false);
					btnAccount.setVisible(false);	
					btnWithdraw.setVisible(true);
					btnDeposit.setVisible(true);
					personalInfo.setVisible(true);
					initalBalances.setVisible(true);
					viewPersonalInfo.setVisible(true);
					saveTrans.setVisible(true);
					exit.setVisible(true);
					lblSavingsT.setVisible(true);
					lblGICT.setVisible(true);
					txtSavingsT.setVisible(true);
					txtGICT.setVisible(true);
					txtViewBalanceG.setVisible(true);
					txtViewBalanceS.setVisible(true);
					lblSavingsBal.setVisible(true);
					lblGICBal.setVisible(true);
					empRead.setVisible(false);
					empSave.setVisible(false);
					lblViewAcnt.setVisible(false);
					txtViewAcnt.setVisible(false);
					viewAcnt.setVisible(false);

					// if correct user name and password is entered proceed to code inside 
					if(txtAccountN.getText().equalsIgnoreCase("Bilal") && txtAccountP.getText().equalsIgnoreCase("Pro gamer")) {
						txtViewBalanceS.setText("$" + savingsAccount.getBalance());
						txtViewBalanceG.setText("$" + gic.getBalance());
						
					}
					// else if the other user name and password is entered correctly proceed to code inside
					else if(txtAccountN.getText().equalsIgnoreCase("User") && txtAccountP.getText().equalsIgnoreCase("Password")) { 
						txtViewBalanceS.setText("$" + savingsAccount2.getBalance());
						txtViewBalanceG.setText("$" + gic2.getBalance());
						
					}

					// print counter login for testing
					//System.out.println(counterLogin);
				}
			}
			// else if anything else is entered display error message
			else { 
				JOptionPane.showMessageDialog(null, "Wrong ID or Password");
			}
		}
		// if btnEmployee button is pressed
		if(e.getSource() == btnEmployee) { 

			if(txtEmployeeN.getText().equals("Campos") && txtEmployeeP.getText().equals("Tony")) {
				// set items that need to be set to false and true for visibility 
				lblEmployeeN.setVisible(false);
				lblEmployeeP.setVisible(false);
				txtEmployeeN.setVisible(false);
				txtEmployeeP.setVisible(false);
				btnEmployee.setVisible(false);				
				lblAccountN.setVisible(false);
				lblAccountP.setVisible(false);
				txtAccountN.setVisible(false);
				txtAccountP.setVisible(false);
				btnAccount.setVisible(false);				
				btnWithdraw.setVisible(false);
				btnDeposit.setVisible(false);
				personalInfo.setVisible(false);
				initalBalances.setVisible(false);
				viewPersonalInfo.setVisible(false);
				saveTrans.setVisible(false);
				exit.setVisible(true);
				lblSavingsT.setVisible(false);
				lblGICT.setVisible(false);
				txtSavingsT.setVisible(true);
				txtGICT.setVisible(true);
				txtViewBalanceG.setVisible(false);
				txtViewBalanceS.setVisible(false);
				lblSavingsBal.setVisible(false);
				lblGICBal.setVisible(false);
				empRead.setVisible(true);
				empSave.setVisible(true);
				lblViewAcnt.setVisible(true);
				txtViewAcnt.setVisible(true);
				viewAcnt.setVisible(true);
			}
			// else if employee login entered is not correct display error message
			else { 
				JOptionPane.showMessageDialog(null, "Wrong employee ID or Password");
			}
		}

		// if exit button is clicked 
		if(e.getSource() == exit) {
			// set items that need to be set to false and true for visibility 
			lblEmployeeN.setVisible(true);
			lblEmployeeP.setVisible(true);
			txtEmployeeN.setVisible(true);
			txtEmployeeP.setVisible(true);
			btnEmployee.setVisible(true);
			lblAccountN.setVisible(true);
			lblAccountP.setVisible(true);
			txtAccountN.setVisible(true);
			txtAccountP.setVisible(true);
			btnAccount.setVisible(true);
			
			btnWithdraw.setVisible(false);
			btnDeposit.setVisible(false);
			personalInfo.setVisible(false);
			initalBalances.setVisible(false);
			viewPersonalInfo.setVisible(false);
			saveTrans.setVisible(false);
			exit.setVisible(false);
			lblSavingsT.setVisible(false);
			lblGICT.setVisible(false);
			txtSavingsT.setVisible(false);
			txtGICT.setVisible(false);
			txtViewBalanceG.setVisible(false);
			txtViewBalanceS.setVisible(false);
			lblSavingsBal.setVisible(false);
			lblGICBal.setVisible(false);
			empRead.setVisible(false);
			empSave.setVisible(false);
			lblViewAcnt.setVisible(false);
			txtViewAcnt.setVisible(false);
			viewAcnt.setVisible(false);

			// set all inputs to empty
			txtAccountN.setText("");
			txtAccountP.setText(""); 
			txtEmployeeN.setText("");
			txtEmployeeP.setText(""); 
			txtViewAcnt.setText("");
			
			// RE-INIT counter
			counterS = 0;
			counterG = 0; 
			
			
			// clear the savings and GIC accounts and set the texts to empty strings 
			savingsAccount.deposit(savingsAccount.getBalance() - savingsAccount.getBalance());
			savingsAccount2.deposit(savingsAccount2.getBalance() - savingsAccount2.getBalance());
			txtSavingsT.setText("");

			gic.deposit(gic.getBalance() - gic.getBalance());
			gic2.deposit(gic2.getBalance() - gic2.getBalance());
			txtGICT.setText("");
		}
		// if personalInfo button is clicked 
		if(e.getSource() == personalInfo) {
			// if bilal account is opened 
			if(txtAccountN.getText().equalsIgnoreCase("Bilal") && txtAccountP.getText().equalsIgnoreCase("Pro gamer")) {
				String name = JOptionPane.showInputDialog(null, "Enter your information: name:"); 
				String address = JOptionPane.showInputDialog(null, "Enter your information: Address:"); 
				String phoneNumber = JOptionPane.showInputDialog(null, "Enter your information: Phone Number:"); // prompt user for name, address and phone number 
				c.setCustomerName(name); // call setCustomerName to set customer name
				c.setCustomerAddress(address); // call setCustomerAddress to set customer address
				c.setCustomerPhoneNumber(phoneNumber); // call setCustomerPhoneNumber to set customer phone number
			}
			// else if user account is opened
			else if(txtAccountN.getText().equalsIgnoreCase("User") && txtAccountP.getText().equalsIgnoreCase("Password")) {
				String name = JOptionPane.showInputDialog(null, "Enter your information: name:"); 
				String address = JOptionPane.showInputDialog(null, "Enter your information: Address:"); 
				String phoneNumber = JOptionPane.showInputDialog(null, "Enter your information: Phone Number:"); // prompt user for name, address and phone number
				c2.setCustomerName(name); // call setCustomerName to set customer name
				c2.setCustomerAddress(address); // call setCustomerAddress to set customer address
				c2.setCustomerPhoneNumber(phoneNumber); // call setCustomerPhoneNumber to set customer phone number
			}

		}
		// if initalBalances button is clicked
		if(e.getSource() == initalBalances) {
			// if bilal account is opened
			if(txtAccountN.getText().equalsIgnoreCase("Bilal") && txtAccountP.getText().equalsIgnoreCase("Pro gamer")) {
				char answer = JOptionPane.showInputDialog(null, "Which account would you like to set initial balance for: " + 
						"\nS - savings" + "\nG - GIC").charAt(0); // ask user which account to set initial balance for 

				switch(answer) { 
				case 'S': { // user enters 'S' for savings 
					double savingBalance = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the initial balance for SAVINGS ACCOUNT")); // prompt for balance 
					if(savingBalance == 0 ) { // if 0 is entered 
						txtViewBalanceS.setText("0"); // display 0 for balance
						savingsAccount.deposit(0.0); //  sets deposit to 0 as well
					}
					else if(savingBalance < 0 ) { // if user enters a double less than 0 display error message 
						savingBalance = Double.parseDouble(JOptionPane.showInputDialog(null, "Invalid input enter number above 0"));

					}
					else { // else whatever number is entered by user set that as their balance 
						savingsAccount.deposit(savingBalance);
						this.startingBalS = savingBalance; 
					}
					// puts a '$' before the value when its displayed 
					txtViewBalanceS.setText("$" + savingsAccount.getBalance());
					break;
				}
				case 'G': { // user enters 'G' for GIC
					double invAmount = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the initial balance for GIC ACCOUNT")); // prompt for balance
					int daysMat = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the amount of days you would like to invest for: ")); // prompt user for number of days the account is open
					if(invAmount >= 0 && daysMat >= 0) { 

						gic.deposit(invAmount); // deposit amount entered 

						this.StartingBalG = invAmount; // set starting balance to value entered 

						gic.setDaysMat(daysMat); // call setDaysMat to set number of days for GIC

						gic.setMaturity(gic.getDaysMat()); // sets maturity day for amount of days entered 

						txtViewBalanceG.setText("$"+ gic.getBalance()); // puts a '$' before the value when its displayed
					}
					else { 
						JOptionPane.showMessageDialog(null, "Invalid amount for days or amount");
					}
					break;
				}
				default: { // user enters anything else then display error message 
					JOptionPane.showMessageDialog(null, "Invalid type");
				}
				}
			}
			// else if user account is opened 
			else if (txtAccountN.getText().equalsIgnoreCase("User") && txtAccountP.getText().equalsIgnoreCase("Password")) {
				char answer = JOptionPane.showInputDialog(null, "Which account would you like to set initial balance for: " + 
						"\nS - savings" + "\nG - GIC").charAt(0); // ask user which account to set initial balance for

				switch(answer) { 
				case 'S': { // user enters 'S' for savings
					double savingBalance = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the initial balance for SAVINGS ACCOUNT")); // prompt for balance 
					if(savingBalance == 0 ) { // if 0 is entered 
						txtViewBalanceS.setText("0"); // display 0 for balance
						savingsAccount2.deposit(0.0); //  sets deposit to 0 as well
					}
					else if(savingBalance < 0 ) { // if user enters a double less than 0 display error message 
						savingBalance = Double.parseDouble(JOptionPane.showInputDialog(null, "Invalid input enter number above 0"));

					}
					else { // else whatever number is entered by user set that as their balance 
						savingsAccount2.deposit(savingBalance);
						this.startingBalS = savingBalance; 
					}
					// puts a '$' before the value when its displayed 
					txtViewBalanceS.setText("$" + savingsAccount2.getBalance());
					break;
				}
				case 'G': { // user enters 'G' for GIC
					double invAmount = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the initial balance for GIC ACCOUNT")); // prompt for balance
					int daysMat = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the amount of days you would like to invest for: ")); // prompt user for number of days the account is open
					if(invAmount >= 0 && daysMat >= 0) {

						gic2.deposit(invAmount); // deposit amount entered 

						this.StartingBalG = invAmount; // set starting balance to value entered 

						gic2.setDaysMat(daysMat); // call setDaysMat to set number of days for GIC

						gic2.setMaturity(gic2.getDaysMat()); // sets maturity day for amount of days entered 

						txtViewBalanceG.setText("$"+ gic2.getBalance()); // puts a '$' before the value when its displayed
					}
					else {
						JOptionPane.showMessageDialog(null, "Invalid amount or date");
					}
					break;
				}
				default: { // user enters anything else then display error message 
					JOptionPane.showMessageDialog(null, "Invalid type");
				}
				}
			}
		}
		// if btnDeposit is clicked
		if(e.getSource() == btnDeposit) {
			// if bilal account is opened
			if(txtAccountN.getText().equalsIgnoreCase("Bilal") && txtAccountP.getText().equalsIgnoreCase("Pro gamer")) {
				char Answer = JOptionPane.showInputDialog(null, "Which account would you like to deposit to:" + 
						"\nS - Savings Account" + "\nG - GIC Account").charAt(0); // prompt user for which account to deposit to
				//System.out.println(savingsAccount.getBalance()); // display for testing
				switch(Answer) {
				case 'S': { // user enters 'S' for savings
					amountS = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the amount to deposit:")); // prompt for amount to deposit 
					if(amountS > 0) { // if amount entered is greater than 0
						savingsAccount.deposit(amountS); // deposit amount 
						//System.out.println(savingsAccount.getBalance()); // print for testing 

						dataArrayS[counterS] =  amountS; // array at counter is the amount inputed by user  
						counterS++; // add 1 to counter

						for (int i = 0; i < dataArrayS.length; i++) { // loops through array length to display output
							finalOutputS += "$" + dataArrayS[i] + "\n"; 
						}

						txtViewBalanceS.setText("$" + savingsAccount.getBalance()); // puts a '$' before the value when its displayed
						txtSavingsT.setText(finalOutputS + "(Deposited)"); // display message for deposit 

						trans = new TransactionRecord('s', "deposit", this.amountS, this.startingBalS, savingsAccount.getBalance()); // set display message for transactions list
						//System.out.println(trans.toString()); // print for testing

						transList.insert(trans); 
					}
					else { // else display error message 
						JOptionPane.showMessageDialog(null, "Invalid Number Entered");
					}

					break;
				}

				case 'G': { // user enters 'G' for GIC
					amountG = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the amount to deposit: ")); // prompt for amount to deposit
					if(amountG > 0) { // amount entered is greater than 0
						gic.deposit(amountG); // deposit amount

						dataArrayG[counterG] = amountG; // array at counter is the amount inputed by user 
						counterG++; // add 1 to counter 

						for (int i = 0; i < dataArrayG.length; i++) { // loops through array length to display output
							finalOutputG += "$" + dataArrayG[i] + "\n"; 
						}

						txtGICT.setText(finalOutputG); // display message for deposit 
						txtViewBalanceG.setText("$" + gic.getBalance()); // puts a '$' before the value when its displayed
						trans = new TransactionRecord('g', "deposit", this.amountG, this.StartingBalG, gic.getBalance()); // set display message for transactions list
						//System.out.println(trans.toString()); // print for testing
						transList.insert(trans); 
					}
					else { // else display error message 
						JOptionPane.showMessageDialog(null, "Invalid Number Entered");
					}
					break;

				}
				default: { // anything else is entered by user display error message 
					JOptionPane.showMessageDialog(null, "Invalid type");
				}
				}
			}
			// else if user account is open
			else if (txtAccountN.getText().equalsIgnoreCase("User") && txtAccountP.getText().equalsIgnoreCase("Password")) { 
				char Answer = JOptionPane.showInputDialog(null, "Which account would you like to deposit to:" + 
						"\nS - Savings Account" + "\nG - GIC Account").charAt(0); 
				//System.out.println(savingsAccount2.getBalance()); // print for testing
				switch(Answer) {
				case 'S': { // user enters 'S' for savings
					amountS = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the amount to deposit:")); // prompt for amount to deposit 
					if(amountS > 0) { // if amount entered is greater than 0
						savingsAccount2.deposit(amountS); // deposit amount 
						//System.out.println(savingsAccount.getBalance()); // print for testing 

						dataArrayS2[counterS] =  amountS; // array at counter is the amount inputed by user  
						counterS++; // add 1 to counter

						for (int i = 0; i < dataArrayS2.length; i++) { // loops through array length to display output
							finalOutputS += "$" + dataArrayS2[i] + "\n"; 
						}
						
						
						txtViewBalanceS.setText("$" + savingsAccount2.getBalance()); //puts a '$' before the value when its displayed
						txtSavingsT.setText(finalOutputS); // display message for deposit 

						trans = new TransactionRecord('s', "deposit", this.amountS, this.startingBalS, savingsAccount2.getBalance()); // set display message for transactions list
						//System.out.println(trans.toString()); // print for testing

						transList.insert(trans); 
					}
					else { // else display error message 
						JOptionPane.showMessageDialog(null, "Invalid Number Entered");
					}

					break;
				}

				case 'G': { // user enters 'G' for GIC
					amountG = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the amount to deposit: ")); // prompt for amount to deposit
					if(amountG > 0) { // amount entered is greater than 0
						gic2.deposit(amountG); // deposit amount

						dataArrayG2[counterG] = amountG; // array at counter is the amount inputed by user 
						counterG++; // add 1 to counter 

						for (int i = 0; i < dataArrayG2.length; i++) { // loops through array length to display output
							finalOutputG += "$" + dataArrayG2[i] + "\n"; 
						}

						txtGICT.setText(finalOutputG); // display message for deposit 
						txtViewBalanceG.setText("$" + gic2.getBalance()); // puts a '$' before the value when its displayed
						trans = new TransactionRecord('g', "deposit", this.amountG, this.StartingBalG, gic2.getBalance()); // set display message for transactions list
						//System.out.println(trans.toString()); // print for testing
						transList.insert(trans); 
					}
					else { // else display error message 
						JOptionPane.showMessageDialog(null, "Invalid Number Entered");
					}
					break;

				}
				default: { // anything else is entered by user display error message
					JOptionPane.showMessageDialog(null, "Invalid type");
				}

				}
			}

		}
		// if btnWithdraw button is clicked 
		if(e.getSource() == btnWithdraw) {
			// else if bilal account is open
			if(txtAccountN.getText().equalsIgnoreCase("Bilal") && txtAccountP.getText().equalsIgnoreCase("Pro gamer")) {

				char Answer = JOptionPane.showInputDialog(null, "Which account would you like to withdraw from:" + 
						"\nS - Savings Account" + "\nG - GIC Account").charAt(0); // prompt for which account to withdraw from
				switch(Answer) {
				case 'S': { // user enters 'S' for savings
					amountS = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the amount to withdraw:")); // prompt for amount to withdraw

					if(amountS > savingsAccount.getBalance()) { // if amount to withdraw is greater than total savings display error message
						JOptionPane.showMessageDialog(null, "Cannot withdraw more than you have.");
					}
					else if(amountS <= savingsAccount.getBalance()) { // else if amount to withdraw is less than total savings 
						if (amountS < 0) { // if amount to withdraw is less than 0 display error message 
							JOptionPane.showMessageDialog(null, "Invalid Amount Entered");
						}
						else { // else is it is greater than 0
							savingsAccount.withdraw(amountS); // withdraw amount 

							dataArrayS[counterS] = amountS; // array at counter is the amount inputed by user 
							counterS++; // add 1 to counter 

							for (int i = 0; i < dataArrayS.length; i++) { // loop through array length to display output
								finalOutputS += "$" + dataArrayS[i] + "\n"; 
							}

							String withDrawn = finalOutputS; // set a variable to finalOutputS

							trans = new TransactionRecord('s', "withdraw", this.amountS, this.startingBalS, savingsAccount.getBalance()); // set display message for transactions list
							//System.out.println(trans.toString()); // print for testing
							transList.insert(trans); 

							txtSavingsT.setText(withDrawn); // display message for withdraw	
							txtViewBalanceS.setText("$" + savingsAccount.getBalance()); // puts a '$' before the value when its displayed
						}
					}
					break; 
				}
				case 'G': { // user enters 'G' for GIC
					amountG = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the amount to withdraw: "));  // prompt for amount to withdraw
					if(amountG > gic.getBalance()) { // if amount to withdraw is greater than total GIC display error message
						JOptionPane.showMessageDialog(null, "Cannot withdraw more than you have.");
					}
					else if(amountG <= gic.getBalance()) { // else if amount to withdraw is less than total GIC
						if (amountG < 0) { // if amount to withdraw is less than 0 display error message 
							JOptionPane.showMessageDialog(null, "Invalid Amount Entered");
						}
						else { // else is it is greater than 0
							gic.withdraw(amountG); // withdraw amount 


							dataArrayG[counterG] = amountG; // array at counter is the amount inputed by user 
							counterG++; // add 1 to counter

							for (int i = 0; i < dataArrayG.length; i++) { // loop through array length to display output
								finalOutputG += "$" + dataArrayG[i] + "\n"; 
							}

							trans = new TransactionRecord('g', "withdraw", this.amountG, this.StartingBalG, gic.getBalance()); // set display message for transactions list
							//System.out.println(trans.toString()); // print for testing
							transList.insert(trans); 


							String withDrawn = finalOutputG; // set a variable to finalOutputG
							txtGICT.setText(withDrawn); // skip line
							txtViewBalanceG.setText("$" + gic.getBalance()); // puts a '$' before the value when its displayed
						}
					}
					break; 
				}
				default: { // anything else is entered by user display error message
					JOptionPane.showMessageDialog(null, "Invalid type");
				}
				}
			}
			// else if user account is open
			else if(txtAccountN.getText().equalsIgnoreCase("User") && txtAccountP.getText().equalsIgnoreCase("Password")) { 
				char Answer = JOptionPane.showInputDialog(null, "Which account would you like to withdraw from:" + 
						"\nS - Savings Account" + "\nG - GIC Account").charAt(0); // prompt for which account to withdraw from

				switch(Answer) {
				case 'S': { // user enters 'S' for savings 
					amountS = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the amount to withdraw:")); // enter amount to withdraw 

					if(amountS > savingsAccount2.getBalance()) { // if amount to withdraw is greater than total savings display error message 
						JOptionPane.showMessageDialog(null, "Cannot withdraw more than you have.");
					}
					else if(amountS <= savingsAccount2.getBalance()) { // else if amount to withdraw is less than total savings
						if (amountS < 0) { // if amount to withdraw is less than 0 display error message 
							JOptionPane.showMessageDialog(null, "Invalid Amount Entered");
						}
						else {
							savingsAccount2.withdraw(amountS); // withdraw amount 

							dataArrayS2[counterS] = amountS; // array at counter is the amount inputed by user 
							counterS++; // add 1 to counter 

							for (int i = 0; i < dataArrayS2.length; i++) { // loop through array length to display output
								finalOutputS += "$" + dataArrayS2[i] + "\n"; 
							}

							trans = new TransactionRecord('s', "withdraw", this.amountS, this.startingBalS, savingsAccount2.getBalance()); // set display message for transactions list
							//System.out.println(trans.toString()); // print for testing
							String withDrawn = finalOutputS; // set a variable to finalOutputS
							transList.insert(trans); 

							txtSavingsT.setText(withDrawn); // display message for withdraw
							txtViewBalanceS.setText("$" + savingsAccount2.getBalance()); // puts a '$' before the value when its displayed
						}
					}
					break; 
				}

				case 'G': { // user enters 'G' for GIC
					amountG = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the amount to withdraw: ")); // enter amount to withdraw 

					if(amountG > gic2.getBalance()) { // if amount to withdraw is greater than total GIC display error message
						JOptionPane.showMessageDialog(null, "Cannot withdraw more than you have.");
					}
					else if(amountG <= gic2.getBalance()) { // else if amount to withdraw is less than total GIC

						gic2.withdraw(amountG); 


						dataArrayG2[counterG] = amountG; // array at counter is the amount inputed by user
						counterG++; // add 1 to counter

						for (int i = 0; i < dataArrayG2.length; i++) { // loop through array length to display output
							finalOutputG += "$" + dataArrayG2[i] + "\n"; 
						}

						trans = new TransactionRecord('g', "withdraw", this.amountG, this.StartingBalG, gic2.getBalance()); // set display message for transactions list 
						//System.out.println(trans.toString()); // print for testing
						transList.insert(trans); 

						String withDrawn = finalOutputG; // set a variable to finalOutputG
						txtGICT.setText(withDrawn); // skip a line
						txtViewBalanceG.setText("$" + gic2.getBalance()); // puts a '$' before the value when its displayed

					}
					break;
				}
				default: { // anything else is entered by user display error message
					JOptionPane.showMessageDialog(null, "Invalid type");
				}
				}
			}
		}
		// if saveTrans button is clicked
		if(e.getSource() == saveTrans) { 
			if(txtAccountN.getText().equalsIgnoreCase("Bilal") && txtAccountP.getText().equalsIgnoreCase("Pro Gamer")) { // if the text entered is equal to Bilal

				transList.bubbleSort(); // bubble sort the list
				String fileName = JOptionPane.showInputDialog(null,"Enter the file you would like to save this data to: "); // ask the user to enter file name

				try { // try to use inputTextFile using file name and transaction list
					TransactionList.inputTextFile(fileName, transList.toString());
					JOptionPane.showMessageDialog(null, "File saved!"); // tell user file was saved
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 

				JOptionPane.showMessageDialog(null, "User Transactions: \n" + transList.toString()); // display the user transactions
			}
			else if(txtAccountN.getText().equalsIgnoreCase("User") && txtAccountP.getText().equalsIgnoreCase("Password")) { // if the text entered is equal to User
				transList.bubbleSort(); // bubble sort the list
				String fileName = JOptionPane.showInputDialog(null,"Enter the file you would like to save this data to: "); // ask the user to enter file name

				try { // try to use inputTextFile using file name and transaction list
					TransactionList.inputTextFile(fileName, transList.toString());
					JOptionPane.showMessageDialog(null, "File saved!"); // tell user file was saved
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 

				JOptionPane.showMessageDialog(null, "User Transactions: \n" + transList.toString()); // display the user transactions
			}
			
			
		}
		// if viewAcnt is clicked 
		if(e.getSource() == viewAcnt) { 
			// if user account is open
			if(txtViewAcnt.getText().equalsIgnoreCase("User")) {
				JOptionPane.showMessageDialog(null, "User data: " + "\n Name: " + c2.getCustomerName() + "\n Address: " + c2.getCustomerAddress() + "\n Phone number: " + c2.getCustomerPhoneNumber()
				+ "\nSavings Balance: " + savingsAccount2.getBalance() + "\nGIC balance: " + gic2.getBalance() + "\nSavings Account number: " + savingsAccount2.getAccountNumber() + "\nGIC Account number: " + gic2.getAccountNumber() 
						); // display name, address, phone number, account balances and account numbers 
			}
			// else if bilal account is open
			else if(txtViewAcnt.getText().equalsIgnoreCase("Bilal")) {
				JOptionPane.showMessageDialog(null, "User data: " + "\n Name: " + c.getCustomerName() + "\n Address: " + c.getCustomerAddress() + "\n Phone number: " + c.getCustomerPhoneNumber()
				+ "\nSavings Balance: " + savingsAccount.getBalance() + "\nGIC balance: " + gic.getBalance() + "\nSavings Account number: " + savingsAccount.getAccountNumber() + "\nGIC Account number: " + gic.getAccountNumber() 
						); // display name, address, phone number, account balances and account numbers
			}
		}
	}

}