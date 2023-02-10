import java.text.DecimalFormat;

import javax.swing.JOptionPane;
/**
 * 
 */

/**
 * @author indersodhi
 * Date: Sept 2021
 * Description: This program lets a user find out the total price of their car for up to 3 different cars with the HST price and PDI price.
 * Method List: percent - to calculate HST and PDI
 * 		  Main - to prompt and display information ton user
 *
 */
public class Part3 {

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
		double total [] = new double [3]; 
		double price [] = new double [3]; 
		double hst [] = new double [3]; 
		double pdi [] = new double [3];
		String carname [] = new String [3];
		// used to round the total price, hst and pdi to 2 decimal places
		DecimalFormat r = new DecimalFormat("0.00");

		for(int i = 0; i < price.length; i++) {

			// prompt user for car name, price, hst and pdi
			carname[i] = JOptionPane.showInputDialog(null, "What is the make and model of your car?");
			price[i] = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter the price of your " + carname[i] + "."));
			hst[i] = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter the HST."));
			pdi[i] = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter the PDI"));

			// call method to calculate the pdi and hst
			hst[i] = percent(price[i], hst[i]);
			pdi[i] = percent(price[i], pdi[i]);

			// add the price, hst and pdi to get total price
			total[i] = price[i] + hst[i] + pdi[i];

			// display the total price, hst and pdi
			JOptionPane.showMessageDialog(null, "The total price of your " + carname[i] + " is $" + r.format(total[i]) + ". The HST on your " + carname[i] + 
												" is $" + r.format(hst[i]) + " and the PDI on your " + carname[i] + " is $" + r.format(pdi[i]) + ".");

		}
	}

}
