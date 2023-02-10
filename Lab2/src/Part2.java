import java.text.DecimalFormat;

import javax.swing.JOptionPane;
/**
 * 
 */

/**
 * @author indersodhi
 * Date: Sept 2021
 * Description: This program lets a user find out the total price of their car with the HST price and PDI price.
 * Method List: percent - to calculate HST and PDI
 * 		  Main - to prompt and display information ton user
 *
 */
public class Part2 {

	/*
	 * Method to calculate price with HST and PDI
	 */
	public static double percent(double price, double percent) {
		// declare variable for total
		double total = 0;
		// calculate total price
		percent = percent / 100;
		total = price * percent;
		//return total
		return total;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// declare variables for total, price, hst, pdi and carname
		double total = 0, price = 0, hst = 0, pdi = 0;
		String carname;
		// used to round the total price, hst and pdi to 2 decimal places 
		DecimalFormat r = new DecimalFormat("0.00");

		// prompt user for car name, price, hst and pdi
		carname = JOptionPane.showInputDialog(null, "What is the make and model of your car?");
		price = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter the price of your " + carname + "."));
		hst = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter the HST."));
		pdi = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter the PDI"));

		// call method to calculate the pdi and hst
		hst = percent(price, hst);
		pdi = percent(price, pdi);

		// add the price, hst and pdi to get total price
		total = price + hst + pdi;

		// display the total price, hst and pdi
		JOptionPane.showMessageDialog(null, "The total price of your " + carname + " is $" + r.format(total) + ". The HST on your " + carname 
											+ " is $" + r.format(hst) + " and the PDI on your " + carname + " is $" + r.format(pdi) + ".");

	}

}
