import javax.swing.JOptionPane;
/**
 * 
 * @author Jimmy Chavada
 * Date: Jan 2022
 * Description: This is the savings class that creates a savings account for the customer with new features to the withdraw method 
 * that has specific penalties on withdrawals 
 * Method List: - public Savings() -> Default constructor 
 * 				- public Savings(Customer owner) -> Overloaded Constructor for the savings class
 * 				- public boolean withdraw (double amount) -> Withdraw method 
 * 				- public static void main(String[] args) -> Main method for testing 
 */

public class Savings extends Account{
	
	private double transactionFee; 
	
	
	/**
	 * Default constructor 
	 */
	public Savings() {
		// INIT the variables 
		this.transactionFee = 4.25; 
	}

	/**
	 * Overloaded constructor 
	 * @param owner
	 */
	public Savings(Customer owner) {
		// INIT variables and call super from the account class
		super(owner); 
		this.transactionFee = 4.25; 
	}
	
	/**
	 * Withdraw method that is used to withdraw with amount in the params 
	 */
	public boolean withdraw (double amount) { 
		// get the balance from account and set it to variables 
		double balance = super.getBalance(); 
		
		// Check if the balance is greater than 4000
		if(balance >= 4000.0) { 
			// return the amount by withdrawing normally from account 
			return super.withdraw(amount); 
		}
		// else return the amount but add a fee 
		return super.withdraw(amount + this.transactionFee); 
	}
	
	
	public static void main(String[] args) {
		
		// create a customer and savings account 
		Customer c = new Customer(); 
		Savings account = new Savings(c); 
		
		// display the information 
		System.out.println("Account number is: " + account.getAccountNumber());
		System.out.println("Owner is: " + account.getOwner());

		// prompt for a balance and deposit that amount 
		double balance = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter balance"));
		account.deposit(balance);

		// display the balance and prompt for the amount to deposit 
		JOptionPane.showMessageDialog(null, "Account has $" + account.getBalance());
		Double deposit = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter amount to deposit: ")); 
		account.deposit(deposit);

		// display the balance 
		JOptionPane.showMessageDialog(null,"Account has $" + account.getBalance());

		// prompt for amount to withdraw and then withdraw 
		Double withdraw = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter amount to withdraw")); 
		account.withdraw(withdraw); 

		// check if the withdraw amount is greater than balance then reprompt for amount and withdraw 
		while(withdraw > balance) {
			JOptionPane.showMessageDialog(null, "Cannot withdraw this amount");
			withdraw = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter amount to withdraw"));
			account.withdraw(withdraw); 
		}

		// display the balance 
		JOptionPane.showMessageDialog(null, "Accounts new Balance is $" + account.getBalance());
	}

}
