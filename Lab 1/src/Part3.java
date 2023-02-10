/**
 * 
 */

/**
 * @author indersodhi
 * Date: Sept 2021
 * Description: This program displays which team plays who in a tournament for hockey. 
 *
 */
public class Part3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		for (int i = 1; i <= 6; i++) {
			for(int k = 1; k <= 6; k++) {
				if (i == k) {
					continue;
				}
				System.out.println("Team " + i + " plays team " + k);
			
			}
			System.out.println("\n");
		
		}

	}

}