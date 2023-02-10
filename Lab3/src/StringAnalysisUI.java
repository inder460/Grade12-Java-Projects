import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 * 
 */

/**
 * @author indersodhi
 * Date: Sept 2021
 * Description: This program takes a file name from user, passes it to the PhraseLoader class to load phrases
 * 				then passes the phrases to StringAnalyzer to count e's and displays and saves into a file.
 *
 */
public class StringAnalysisUI {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// declare variables
		String input[];
		String filename = null;
		String text = "";

		// try for errors
		try {
			// prompt user for file name
			filename = JOptionPane.showInputDialog(null, "Please enter the file name:", "Phrases.txt");

			// load file by calling method from PhraseLoader
			input = PhraseLoader.loadPhrases(filename);
			
			// declare output variable 
			String output[] = new String[input.length];

			// for loop to count and displays the number for e's for each phrase
			for (int i = 0; i < input.length; i ++) {
				output[i] = StringAnalyzer.eCounter(input[i]);
				text += input[i] + "\n" + output[i] + "\n\n";
			}
			
			// puts the e's into a new file
			PhraseLoader.newFile(output, input);

			// set up a text area to display the text
			JTextArea displayArea = new JTextArea();
			displayArea.setText(text);
			displayArea.setEditable(false);
			JOptionPane.showMessageDialog(null, displayArea);
			

		}
		// catch for errors
		catch (FileNotFoundException error) {
			JOptionPane.showMessageDialog(null, filename + " was not found!");
		}
		catch (NumberFormatException error) {
			JOptionPane.showMessageDialog(null, filename + " is corrupted!");
		}
		catch (Exception error) {
			JOptionPane.showMessageDialog(null, "Unknown error!");
		}



	}

}
