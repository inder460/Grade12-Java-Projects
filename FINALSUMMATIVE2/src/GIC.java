import java.time.LocalDateTime;
/**
 * 
 */

/**
 * @author Bilal Faheem
 * Date: Jan. 2022
 * Description: Class to create GIC account
 * Method List: public GIC() - constructor 
 * 				public void setMaturity(LocalDateTime maturity) - set Maturity 
 * 				public double getInvAmount() - get InvAmount
 * 				public void setInvAmount(double invAmount) - set InvAmount
 * 				public int getDaysMat() - get DaysMat
 * 				public void setDaysMat(int daysMat) - set DaysMat
 * 				public boolean withdraw (double amount) - method to withdraw
 * 				public static void main(String[] args) - self testing main
 * 
 *
 */

public class GIC extends Account{
    // instance variables
    private LocalDateTime current, investment, maturity; 
    private double intRate;
    private double invAmount; 
    private int daysMat; 
   
    /*
     * Constructor 
     */
    public GIC() {
    	this.current = LocalDateTime.now(); // set the current date to the local date now
        this.investment = LocalDateTime.now(); // set the investment date to the local date now
        this.intRate = 0.03; 
        
    }


    /**
	 * @param maturity the maturity to set
	 */
	public void setMaturity(int days) {
		this.maturity = this.current.plusDays(days);
	}


	/**
	 * @return the invAmount
	 */
	public double getInvAmount() {
		return invAmount;
	}


	/**
	 * @param invAmount the invAmount to set
	 */
	public void setInvAmount(double invAmount) {
		this.invAmount = invAmount;
	}


	/**
	 * @return the daysMat
	 */
	public int getDaysMat() {
		return daysMat;
	}


	/**
	 * @param daysMat the daysMat to set
	 */
	public void setDaysMat(int daysMat) {
		this.daysMat = daysMat;
	}

	/*
	 * Method to withdraw
	 */
	public boolean withdraw (double amount) {
        if (amount <= this.getBalance()) { // if user has enough balance to withdraw the amount specified
            current = LocalDateTime.now(); // set the current time to local date and time
            if (current.compareTo(maturity) >= 0) { // if the current date is the same of after the maturity date
                deposit(getBalance() * this.intRate); // add the interest to the balance
                
                deposit(-1 * (amount)); // deposit the money
                return true; 
            }
            else { // if the current date is before the maturity date
            	double interestBal = this.getBalance() * this.intRate; 
                deposit(-1 * (interestBal * 0.2)); // add 20% penalty
                deposit(-1 * (amount));  // withdraw amount

            }
        }
        return false;

    }

  
    public static void main(String[] args) {
        // self testing main
        GIC account = new GIC ();
        // set maturity days and deposit and withdraw an amount to test if the interest and penality is being applied 
        account.setDaysMat(20);
        account.setMaturity(account.getDaysMat());
        account.deposit(1000);
        account.withdraw(200); 
        
        System.out.println(account.getBalance());
        
        // test for 0 days to test if the interest rate is being applied 
        GIC account2 = new GIC(); 
        account2.setDaysMat(0);
        account2.setMaturity(account2.getDaysMat());
        account2.deposit(1000);
        account2.withdraw(200); 
        
        System.out.println(account2.getBalance());
    }

}