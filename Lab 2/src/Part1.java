import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author indersodhi
 * Date: Sept 2021
 * Description: This program calculates the final velocity in m/s and km/h after the user enters the height of where the object
 * 				was dropped from and the initial velocity.
 * Method List: calculations - used to calculate final velocity
 * 				kilometer - used to convert m/s to km/h
 * 				main - used to ask user for all inputs and display answer
 *
 */
public class Part1 {

	/**
	 * @param args
	 */

	/*
	 * method to calculate final velocity
	 */
	public static double calculations(double vI, double height){
		double vF = 0;
		vF = Math.sqrt((vI*vI) + (2 * 9.8 * height));
		return vF;
	}

	/*
	 * method  to convert meters to kilometers
	 */
	public static double kilometer(double meters) {
		double km;
		km = meters * 3.6;
		return km;
	}

	public static void main(String[] args) {
		// declare variables 
		double vI = 0, height = 0, vF = 0, KM = 0;
		// used to round final velocity and kilometers
		DecimalFormat r = new DecimalFormat("0.00");
		// use boolean to create do while loop
		boolean user = false;
		// variable for user answer to continue program
		String aws;

		do {
			// ask user for initial velocity and height
			vI = Double.parseDouble(JOptionPane.showInputDialog(null, "Please eneter the initial velocity."));
			height = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter the height"));

			// call calculations method
			vF = calculations(vI, height);
			// call kilometer method to convert
			KM = kilometer(vF);

			// display final velocity
			JOptionPane.showMessageDialog(null, "The final velocity is " + r.format(vF) + "m/s. \n and " + r.format(KM) + " km/h.");

			// ask user if they would like to continue
			aws = JOptionPane.showInputDialog("Would you like to calculate again? \n Enter Yes or No to continue.");

			// if user types yes then continue
			if(aws.equalsIgnoreCase("yes")) {
				continue;
			}
			// if user types no then stop
			else if(aws.equalsIgnoreCase("no")) {
				JOptionPane.showMessageDialog(null, "Thank you for using this program.");
				break;
			}
			// if user doesn't type either yes or no then stop
			else {
				JOptionPane.showMessageDialog(null, "Thank you for using this program.");
				break;
			}
		}
		while(user == false);
	}
}