import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

// @author tford
//@Editor Abhishek Lal George
//Date: Oct 1 2021
//

public class UserInterface {
	// a method to display a message using JtextArea
	public static void doJTextArea(String lines) {
		JTextArea displayArea1 = new JTextArea();
		displayArea1.setEditable(false);
		displayArea1.setText(lines);
		displayArea1.setBackground(Color.GRAY);// set background colour
		displayArea1.setForeground(Color.CYAN);// set text colour
		Font font = new Font("Times New Roman", Font.BOLD, 15);// set font
		displayArea1.setFont(font);
		JOptionPane.showMessageDialog(null, displayArea1);
	}

	public static boolean checkKey(int encryptKey) {
		boolean bool; // declare boolean variable bool

		// if statement to check if the number is in range
		if (encryptKey >= -32767 && encryptKey <= 32768) {
			bool = true;
		} else {
			bool = false;
		}
		return bool; // return
	}

	public static int putKeyInRange(int encryptKey) {
		int output; // declaring output integer
		// needs if state for if the number is negative and positive to make the
		// negative number positive

		output = encryptKey % 26; // makes the number between 0 and 26

		return output;
	}

	public static void main(String[] args) throws IOException {

		// declare variable for FileName and encryptKey and line and file size
		String fileName = null;
		int encryptKey = 0;
		String line = null;
		boolean bool = false;
		String askAgain = null;

		// a do while loop to make sure the program runs atleast once before the user
		// has to enter if they want to try again
		do {
			// tries to catch errors regarding the file
			try {

				// Get the file name from the user
				fileName = JOptionPane.showInputDialog(null, " Enter your file name!!!");

				// open a file for reading
				FileReader fr = new FileReader(fileName);
				BufferedReader input = new BufferedReader(fr);

				// read the encryptKey of the File
				line = input.readLine();
				encryptKey = Integer.parseInt(line);

				// close the file
				input.close();

				// check if encrypt is in range
				bool = UserInterface.checkKey(encryptKey);
				// put key in range
				if (bool == true) {
					encryptKey = UserInterface.putKeyInRange(encryptKey);
				}

				// turn file into array
				String fileTxt[] = FileAccess.loadFile(fileName);

				// check if the user wants to encrypt or decrypt
				int zeroOrOne = Integer
						.parseInt(JOptionPane.showInputDialog(null, "Enter 0 for encryption and 1 for decryption"));
				if (zeroOrOne == 0) {
					char encode;
					String lines = "";
					// for loop to cycle through each line
					String encryptedArray[] = new String[fileTxt.length];
					for (int i = 0; i < fileTxt.length; i++) {

						// Go across the array phrases to encrypt them

						// char for encode

						// for loop to encode each character or each line
						for (int d = 0; d < fileTxt[i].length(); d++) {

							// go along file
							if (EncrytionClass.isALetter(fileTxt[i].charAt(d)) == true) {

								encode = EncrytionClass.encode(fileTxt[i].charAt(d), encryptKey);

								lines += String.valueOf(encode);
							} else {
								lines += String.valueOf(fileTxt[i].charAt(d));
							}
							// add encoded message to new array

							encryptedArray[i] = lines;

						}

						lines += "\n";

					}
					doJTextArea(lines);

					// prompt user for name of new file
					String newFileName = JOptionPane.showInputDialog(null, "What would you like to name the new file");
					lines = FileAccess.writeFile(lines, newFileName);

				}
				// decrypt message
				else if (zeroOrOne == 1) {
					char decode;
					String lines = "";
					// for loop to cycle through each line
					String decryptedArray[] = new String[fileTxt.length];
					for (int i = 0; i < fileTxt.length; i++) {

						// Go across the array phrases to encrypt them

						// char for encode

						// for loop to encode each character or each line
						for (int d = 0; d < fileTxt[i].length(); d++) {

							if (EncrytionClass.isALetter(fileTxt[i].charAt(d)) == true) {

								decode = EncrytionClass.decode(fileTxt[i].charAt(d), encryptKey);

								lines += String.valueOf(decode);
							} else {
								lines += String.valueOf(fileTxt[i].charAt(d));
							}
							// add encoded message to new array
							decryptedArray[i] = lines;

						}
						lines += "\n";

					}

					doJTextArea(lines);

					String newFileName = JOptionPane.showInputDialog(null, "What would you like to name the new file?");
					lines = FileAccess.writeFile(lines, newFileName);

				}

				else {
					// error box please enter 0 or 1 end program
					doJTextArea("Please enter 0 or 1");

				}

			}

			catch (FileNotFoundException error) {
				JOptionPane.showMessageDialog(null, fileName + " cannot be found!");// error for when the wrong file
				// name is
				// entered
			} catch (NumberFormatException error) {
				JOptionPane.showMessageDialog(null, fileName + " is corrupted!");// error for if the file is corrupted
			} catch (Exception error) {
				JOptionPane.showMessageDialog(null, "Unknown Error!");// any other error
			}
			askAgain = JOptionPane.showInputDialog(null,
					"Would you like to decrypt another message/file?\n(Type yes to continue or "
							+ "\nanything else to close the program)");
		} while (askAgain.equalsIgnoreCase("yes"));

		JOptionPane.showMessageDialog(null, "Thank you for using my program!");

	}

}