/**
 * 
 */

/**
 * @author indersodhi
 * Date: Sept 2021
 * Description: This program displays the sum of numbers divisible by 7 between 3-47 by using the while(true) command.
 *
 */
public class Part2B {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// declare variable 
		int number = 0;
		int i = 3;
		
		while (true) {
			if (i % 7 == 0) {
				System.out.println(i);
				number = number + i;
			}
			else if (i % 7 != 0) {
				i++;
			}
			if (i < 48) {
				i++;
			}
			else {
				break;
			}
					
		}
		System.out.println("\n" + number);
	}
			
}