/**
 * 
 */

/**
 * @author Inder Sodhi
 * Date: Jan. 2022
 * Description: Class to represent object containing Transaction Records
 * Method: 
 * 		- public TransactionRecord() -> Constructor for the class
 * 		- public TransactionRecord(char accountType, String transactionType, double transactionAmnt, double startBalance, double endBalance) -> overloaded constructor 
 * 		- public char getAccountType() -> get account type 
 * 		- public void setAccountType(char accountType) -> set account type 
 * 		- public String getTransactionType() -> get transaction type 
 * 		- public void setTransactionType(String transactionType) -> set transaction type 
 * 		- public double getTransactionAmnt() -> get transaction amount 
 * 		- public void setTransactionAmnt(double transactionAmnt) -> set transaction amount
 * 		- public double getStartBalance() -> get the start balance
 * 		- public void setStartBalance(double startBalance) -> set start balance
 * 		- public double getEndBalance() ->  get the end balance
 * 		- public void setEndBalance(double endBalance) -> set the end balance
 * 		- public void processRecord(String record) -> process the record 
 * 		- public static void main(String[] args) -> main method for testing 
 * 
 *
 */
public class TransactionRecord {

	/**
	 * Instance data
	 */
	private char accountType;
	private String transactionType;
	private double transactionAmnt;
	private double startBalance;
	private double endBalance;

	/**
	 * Default constructor 
	 */
	public TransactionRecord() {
		// Initialize instance variables
		this.accountType = ' ';
		this.transactionType = "";
		this.transactionAmnt = 0.0;
		this.startBalance = 0.0;
		this.endBalance = 0.0;
	}
	/**
	 * Overloaded constructor 
	 * @param accountType
	 * @param transactionType
	 * @param transactionAmnt
	 * @param startBalance
	 * @param endBalance
	 */
	public TransactionRecord(char accountType, String transactionType, double transactionAmnt, double startBalance, double endBalance) {
		this.accountType = accountType; 
		this.transactionType = transactionType; 
		this.transactionAmnt = transactionAmnt; 
		this.startBalance = startBalance; 
		this.endBalance = endBalance; 
	}

	/**
	 * 
	 * @return
	 */
	public char getAccountType() {
		return accountType;
	}

	/**
	 * 
	 * @param accountType
	 */
	public void setAccountType(char accountType) {
		this.accountType = accountType;
	}

	/**
	 * 
	 * @return
	 */
	public String getTransactionType() {
		return transactionType;
	}

	/**
	 * 
	 * @param transactionType
	 */
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	/**
	 * 
	 * @return
	 */
	public double getTransactionAmnt() {
		return transactionAmnt;
	}

	/**
	 * 
	 * @param transactionAmnt
	 */
	public void setTransactionAmnt(double transactionAmnt) {
		this.transactionAmnt = transactionAmnt;
	}

	/**
	 * 
	 * @return
	 */
	public double getStartBalance() {
		return startBalance;
	}

	/**
	 * 
	 * @param startBalance
	 */
	public void setStartBalance(double startBalance) {
		this.startBalance = startBalance;
	}
	/**
	 * 
	 * @return
	 */
	public double getEndBalance() {
		return endBalance;
	}

	/**
	 * 
	 * @param endBalance
	 */
	public void setEndBalance(double endBalance) {
		this.endBalance = endBalance;
	}

	/**
	 * Convert an input String into the different parts of this record
	 */
	public void processRecord(String record) {
		// declare an array to place the String
		String word[] = record.split(","); // splits the record into each part of the word array
		this.accountType = word[0].charAt(0);
		this.transactionType= word[1]; 	
		this.transactionAmnt = Double.parseDouble(word[2]);   // place each word into the right instance data
		this.startBalance = Double.parseDouble(word[3]);
		this.endBalance = Double.parseDouble(word[4]);
	}

	/**
	 * To string method to convert the variables into string that is easy to read and understand 
	 */
	@Override
	public String toString() {
		// return the modified string into this format 
		return "TransactionRecord [accountType=" + this.getAccountType() + ", transactionType=" + this.getTransactionType()
		+ ", transactionAmount=" + this.getTransactionAmnt() + ", startBalance=" + this.getStartBalance() + ", endBalance=" + this.getEndBalance() + "]";
	}

	/**
	 * Main method for testing 
	 * @param args
	 */
	public static void main(String[] args) {
		// Test all methods in your class
		String input = "s,withdrawal,5,100,95";

		// create object based on this class
		TransactionRecord sInfo = new TransactionRecord();

		System.out.println(sInfo.toString());

		// test setters
		sInfo.setAccountType('g');
		sInfo.setTransactionType("deposit");
		sInfo.setTransactionAmnt(100.99);
		sInfo.setStartBalance(3000.99);
		sInfo.setEndBalance(2900);

		System.out.println(sInfo.toString());

		// test the processRecord method
		sInfo.processRecord(input);

		System.out.println(sInfo.toString());

	}

}