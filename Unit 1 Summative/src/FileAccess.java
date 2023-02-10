import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Abhishek Lal George \ Date: Sept: 2021 Description: A class to load a
 *         file. Looks for "EOF" to count the size of the file and then reads
 *         it. Also writes to file. 
 *         Method List: public static String[] loadFile(String fileName) 
 *         public static String[] writeFile(String info[], String fileName) 
 *         public static void main(String[] args)
 */
public class FileAccess {

	/**
	 * @param args
	 */

	public static String[] loadFile(String fileName) throws IOException {
		// open a file for reading
		FileReader fr = new FileReader(fileName);
		BufferedReader input = new BufferedReader(fr);

		// read the number of items in the file

		String lastE = "EOF";
		int counter = 0;
		while (!input.readLine().equals(lastE)) {

			counter++;
		}

		fr.close();

		// create the array to save the information in the file

		fr = new FileReader(fileName);
		input = new BufferedReader(fr);

		String fileInfo[] = new String[counter];

		// now reads from the file into the array
		for (int i = 0; i < counter; i++) {

			fileInfo[i] = input.readLine();
		}
		// closes the file
		fr.close();
		// return my array
		return fileInfo;
	}

	public static String writeFile(String info, String fileName) throws IOException {

		PrintWriter fw = new PrintWriter(new FileWriter(fileName));

		// use a for loop to write each phrase from info into the file using printwriter
		fw.println(info);

		fw.println("EOF");
		fw.close();
		return info;
	}

	// self testing main method
	public static void main(String[] args) throws IOException {
		String output[];

		// load the file into the array
		output = FileAccess.loadFile("text.txt");

		String text = " ";
		// displays the array
		for (int i = 0; i < output.length; i++) {
			// System.out.println(output[i]);
			text += output[i] + "\n";
		}
		JOptionPane.showMessageDialog(null, text);
		// prompt user for name of new file
		String fileName = JOptionPane.showInputDialog(null, "What would you like to name the new file");
		text = FileAccess.writeFile(text, fileName);

	}
}