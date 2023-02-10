import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author indersodhi
 * Date: Sept 2021
 * Description: this program takes a phrase from the user and counts the amount of e's it has and
 * 				displays it for the user.
 * Method List:
 * 				public static int eCounter - counts the e's in the phrase given by user
 * 				public static void main - asks user for phrase and displays the #'s of e's	
 *
 */
public class StringAnalyzer {
	
	/*
	 * method to take the phrase from user and display how many e's it has.
	 */
	public static String eCounter(String phrase) {
		// make counter for keeping track of e's
		int counter = 0;
		// declare strings for output and total indexes
		String output = "", indexTotal = "";
		
		// change all e's in the phrase to lower case 
		phrase = phrase.toLowerCase();
		
		// loops through phrase
		for (int i = 0; i < phrase.length(); i++) {
			// if phrase has 'e' or 'E' than add 1 to counter
			if (phrase.charAt(i) == 'e') {
				counter++;	
				indexTotal += phrase.indexOf('e', i)+ " ";
			}
		}
		output = "There are " + counter + " e's in this phrase at the locations " + indexTotal;
		// return the counter
		return output;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// the code below is used to test method above
		// declare variables for phrase and the number of e's
		String phrase;
		String e = "";
		
		// prompt user for phrase
		phrase = JOptionPane.showInputDialog(null, "Please enter your phrase.");
	
		//call method to count e's
		e = eCounter(phrase);
		
		//display the e's for the user
		JOptionPane.showMessageDialog(null,  e );

	}

}
