import javax.swing.JOptionPane;
/**
 * 
 */

/**
 * @author indersodhi
 * Date: Sept 2021
 * Description: This program displays the song we wish you a merry Christmas using methods.
 * Method List: Main - asks user for name and displays name
 * 				sayMerryChristmas - displays we wish you a merry Christmas with user name and displays happy new year 
 * 				sayPudding - displays we want some figgy pudding and please bring it right here
 * 				sayLyrics - displays glad tidings we bring and 3 lines that come after
 */
public class Part1 {
	/*
	 * method to say we wish you a merry Christmas 
	 */
	public static void sayMerryChristmas(String name) {
		System.out.println("We wish " + name + " a merry Christmas \nWe wish " + name + " a merry Christmas \nWe wish " + name + " a merry Christmas");
		System.out.println("And a happy new Year!");
	}
	
	/*
	 * method to say we want some figgy pudding
	 */
	public static void sayPudding() {
		System.out.println("We want some figgy pudding \nWe want some figgy pudding \nWe want some figgy pudding");
		System.out.println("Please bring it right here!");
	}
	
	/*
	 * method to say 4 different lines which are repeated in the song
	 */
	public static void sayLyrics(String name) {
		System.out.println("Glad tidings we bring \nTo " + name + " and your kin; \nGlad tidings for Christmas \nAnd a happy New Year!");
	}
	
	public static void main(String[] args) {
		// variable for name
		String name;
		// Ask user for name
		name = JOptionPane.showInputDialog("What's your name?");
		// call all methods to display song and input users name where needed
		sayMerryChristmas(name);
		sayLyrics(name);
		sayPudding();
		sayLyrics(name);
		sayPudding();
		sayLyrics(name);
		sayMerryChristmas(name);
		sayLyrics(name);	
	}
}