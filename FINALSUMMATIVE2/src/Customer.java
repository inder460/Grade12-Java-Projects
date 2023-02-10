
/**
 * @author Jimmy Chavada
 * Date: Jan 2022
 * Description: This class is the customer class that is used for creating customer objects that can store the name address and number
 * of the customer 
 * Method: - public Customer() -> Default constructor 
 * 		   - public Customer(String name, String address, String number) -> Overloaded constructor 
 * 		   - public String getCustomerName() -> Get the customer name 
 * 		   - public void setCustomerName(String customerName) -> set the customer name 
 * 		   - public String getCustomerAddress() -> get the customer address 
 * 		   - public void setCustomerAddress(String customerAddress) -> set the customer address 
 * 		   - public String getCustomerPhoneNumber() -> get the customer phone number 
 *         - public void setCustomerPhoneNumber(String customerPhoneNumber) -> set the customer number 
 *         - public String toString() -> To string method to make phrase into string 
 *         - public static void main(String[] args) -> Main method for testing 
 *         
 */
public class Customer {

	// declare the variables for this class
	private String customerName; 
	private String customerAddress; 
	private String customerPhoneNumber; 

	/**
	 * Customer object class
	 */
	public Customer() {
		// instance variables 
		this.customerAddress = ""; 
		this.customerName = ""; 
		this.customerPhoneNumber = ""; 
	}

	/**
	 * Overloaded constructor for customer object
	 * @param name
	 * @param address
	 * @param number
	 */
	public Customer(String name, String address, String number) {
		//INIT the variables to the params 
		this.customerAddress = address; 
		this.customerName = name; 
		this.customerPhoneNumber = number; 
	}

	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * @return the customerAddress
	 */
	public String getCustomerAddress() {
		return customerAddress;
	}

	/**
	 * @param customerAddress the customerAddress to set
	 */
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	/**
	 * @return the customerPhoneNumber
	 */
	public String getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}

	/**
	 * @param customerPhoneNumber the customerPhoneNumber to set
	 */
	public void setCustomerPhoneNumber(String customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}

	/**
	 * To String method to return a string for overloaded constructor 
	 * 
	 */
	public String toString() {
		// returns the customer name address and number in this manner 
		return this.customerName + ", " + this.customerAddress + ", " + this.customerPhoneNumber; 
	}

	public static void main(String[] args) {

		// create a new customer 
		Customer c = new Customer(); 

		// set the values of the name address and number 
		c.setCustomerName("Tony Campos");
		c.setCustomerAddress("123 Campos Lane");
		c.setCustomerPhoneNumber("123-312-412");

		// create new customer with the overloaded constructor 
		Customer S = new Customer("Tony campos", "CAMPOS HOUSE", "38921321"); 

		// display the values 
		System.out.println(c.getCustomerName() + " " + c.getCustomerName() + " " + c.getCustomerPhoneNumber() + " ");

		// display the other values 
		System.out.println(S);


	}

}
