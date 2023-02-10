import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * 
 */

/**
 * @author indersodhi
 * Date: Sept. 2021
 *
 */
public class PersonalInfoUi {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		String input [], output;
		String fileName = null; 

		try {
			fileName = JOptionPane.showInputDialog(null, "Enter a file name", "PersonalInfoFile.txt");

			input = Loader.loadFile(fileName); // load file input

			String text = "";
			for (int i = 0; i < input.length; i++) {
				output = PersonalInfoProcessor.processInfo(input[i]);
				text += output + "\n";
			}

			// set up a text area to display the text
			JTextArea displayArea = new JTextArea();
			displayArea.setText(text);
			displayArea.setEditable(false);
			JOptionPane.showMessageDialog(null, displayArea);
		}

		catch (FileNotFoundException error) {
			JOptionPane.showMessageDialog(null, fileName + " was not found!");
		}
		catch (NumberFormatException error) {
			JOptionPane.showMessageDialog(null, fileName + " is corrupted!");
		}
		catch (Exception error) {
			JOptionPane.showMessageDialog(null, "Unknown error!");
		}

	}

}
