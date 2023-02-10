import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author indersodhi
 * An example of a for loop using break.
 *
 */
public class BreakTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String output = "";
		
		for (int i = 0; i <= 10; i++) {
			
			if (i == 5) {
				break;
			}
			
			output = output + i + "\n";
			
		}
		
		JOptionPane.showMessageDialog(null, output);

	}

}
