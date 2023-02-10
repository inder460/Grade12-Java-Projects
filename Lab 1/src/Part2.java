/**
 * 
 */

/**
 * @author indersodhi
 * Date: Sept 2021
 * Description: This program displays the sum of numbers divisible by 7 between 3-47.
 *
 */
public class Part2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// declaring variable 
		int number = 0;
		
		// loop through 3 and 47
		for(int i = 47; i >= 3; i--) {
			// checking if numbers between 3-47 are divisible by 7
			if (i % 7 == 0) {
				// display numbers divisible by 7
				System.out.println(i);
				number = number + i;
			}
		}
		
		// display sum of numbers
		System.out.println(number);
	}
}
