import javax.swing.JOptionPane;
/**
 * 
 */

/**
 * @author indersodhi
 * Date: Sept 2021
 * Description: Calculate speed based on input of distance and time
 *
 */
public class SppedCalculations {
	
	/*
	 *  Method to calculate the speed
	 */
	public static double speedCalc (double d, double t) {
		double speed = 0;
		speed = d/t;
		return speed;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// declare variables for distance, speed and time
		double speed [] = new double [3];
		double time [] = new double [3];
		double distance [] = new double [3];
		
		for (int i = 0; i < distance.length; i++) {
		
		// prompt user for distance and time
		distance[i] = Double.parseDouble(JOptionPane.showInputDialog(null, "What is the distance in meters?"));
		time[i] = Double.parseDouble(JOptionPane.showInputDialog(null, "What is the time in seconds?"));
		
		// call seedCalc method to calculate speed
		speed[i] = speedCalc(distance[i], time[i]);
		// display speed
		JOptionPane.showMessageDialog(null, "The speed is " + speed[i] + "m/s.");
		
		}

	}

}
