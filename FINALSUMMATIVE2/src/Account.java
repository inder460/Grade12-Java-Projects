import javax.swing.JOptionPane;

/**
 * @author Jimmy Chavada
 * Date: Jan 2022
 * Description: This is the account class that will hold user information like balance, account number, and create a customer 
 * Method List: - public Account() -> Constructor for the account class
 * 				- public Account (Customer theOwner) -> Overloaded constructor for the account class 
 * 				- private long accountNum() -> Class to generate the constructor 
 * 				- public void deposit (double amount) -> Class to deposit the money 
 * 				- public boolean withdraw (double amount) -> Class to withdraw the money in the account 
 * 				- public double getBalance() -> Class to get the balance 
 * 				- public long getAccountNumber() -> Class to get account number 
 * 				- public void setAccountNumber(int accountNumber) -> Set the account number 
 * 				- public Customer getOwner() -> Get the owner 
 * 				- public void setOwner(Customer owner) -> Set the owner 
 * 				- public static void main(String[] args) -> Main method for testing 
 * 
 */
public class Account {

	// Instance data 
	private double balance; 
	private long accountNumber;
	private Customer owner; 


	/**
	 * Default constructor 
	 */
	public Account() {
		// INIT the variables 
		this.balance = 0.0; 
		this.accountNumber = this.accountNum(); 
		this.owner = null; 
	}

	/**
	 * Overloaded constructor 
	 * @param theOwner
	 */
	public Account (Customer theOwner){
		// INIT the variables 
		this.balance = 0.0;
		this.owner = theOwner;
		this.accountNumber = this.accountNum();
	}

	/**
	 * Account number to generate the number
	 * @return
	 */
	private long accountNum() {
		// generate the number using math.random 
		return (long)(Math.random() * 9E11 + 1.0);
	}

	/**
	 * Method to deposit the money
	 * @param amount
	 */
	public void deposit (double amount) { 
		// set the balance by adding the amount 
		this.balance += amount; 
	}

	/**
	 * Withdraw money from the account by taking in the amount 
	 * @param amount
	 * @return
	 */
	public boolean withdraw (double amount) { 
		// check if the amount is less than the balance 
		if(amount <= balance) {
			// deduct the amount from the balance 
			this.balance -= amount; 
			// return true
			return true; 
		}
		// return false 
		return false;
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @return the accountNumber
	 */
	public long getAccountNumber() {
		return this.accountNumber;
	}

	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @return the owner
	 */
	public Customer getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(Customer owner) {
		this.owner = owner;
	}

	public static void main(String[] args) {

		// create the customer and the account 
		Customer owner = new Customer();
		Account newAccount = new Account(owner);
		
		// show the account number and who the owner is 
		System.out.println("Account number is: " + newAccount.getAccountNumber());
		System.out.println("Owner is: " + newAccount.getOwner());

		// Set the balance 
		double balance = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter balance"));
		newAccount.deposit(balance);

		// display the amount and prompt for the deposit 
		JOptionPane.showMessageDialog(null, "Account has $" + newAccount.getBalance());
		Double deposit = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter amount to deposit: ")); 
		newAccount.deposit(deposit); // deposit the amount 

		// Show how much the account now has 
		JOptionPane.showMessageDialog(null,"Account has $" + newAccount.getBalance());

		// prompt for withdrawal 
		Double withdraw = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter amount to withdraw")); 
		newAccount.withdraw(withdraw); // withdraw the amount  

		//check if the withdraw amount is greater than the balance and display a message, then prompt for new withdraw amount 
		while(withdraw > balance) {
			JOptionPane.showMessageDialog(null, "Cannot withdraw this amount");
			withdraw = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter amount to withdraw"));
			newAccount.withdraw(withdraw); 
		}
		
		// display the final amount 
		JOptionPane.showMessageDialog(null, "Accounts new Balance is $" + newAccount.getBalance());
	}

}
