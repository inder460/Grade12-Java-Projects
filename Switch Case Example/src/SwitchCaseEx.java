import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author indersodhi
 * Date: Sept 2021
 * Description: Converts inches to cm and vice versa
 *
 */
public class SwitchCaseEx {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		double inches = 0, cm = 0;
		
		char command = 0;
		
		do {
		command = JOptionPane.showInputDialog(null,
				"Enter 'I' to convert to inches\n'C' to convert to cm\n'X' to exit.").charAt(0);
		
		switch(command) {
		case 'I':
		case 'i':{
			cm = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the value in cm"));
			inches = cm / 2.54;
			JOptionPane.showMessageDialog(null,cm + "cm equals " + inches + " in");
			break;
		}
		case 'C':
		case 'c':{
			inches = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the value in inches"));
			cm = inches * 2.54;
			JOptionPane.showMessageDialog(null,inches + "in equals " + cm + " cm");
			break;
		}
		case 'X':
		case 'x':{
			break;
			
		}
		default:{
			JOptionPane.showMessageDialog(null, "Error! Enter C, I or X");
		}
		}
		}while (command != 'X' && command != 'x');
		
		JOptionPane.showMessageDialog(null, "Thank you for using my program.\n Have  great day.");
		
	}

}
