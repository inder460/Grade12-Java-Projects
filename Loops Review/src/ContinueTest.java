import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author indersodhi
 * Example of a continue command in a loop.
 *
 */
public class ContinueTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String output = "";
		
		for (int i = 0; i <= 10; i++) {
			
			if (i == 4 || i == 5 || i == 6) {
				continue;
			}
			
			output = output + i + "\n";				
			
		}
		
		JOptionPane.showMessageDialog(null, output);


	}

}
