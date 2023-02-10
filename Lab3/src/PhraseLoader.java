import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author indersodhi
 * Date: Sept 2021
 * Description: This program checks how many e's there are in a file that has multiple phrases
 * 				and then stores the e's into a new file.
 * Method List: public static String[] loadPhrases - method to open a file and load info within
 * 				public static void newFile - method to put analysis into a new file
 * 				public static void main - method to test the 2 other methods created
 *
 */
public class PhraseLoader {

	/*
	 * method to open file and load the info within
	 */
	public static String[] loadPhrases(String fileName) throws IOException {
		// open text file for reading
		FileReader fr = new FileReader(fileName);
		BufferedReader input = new BufferedReader(fr);

		// read the number of items in the text file
		int size = Integer.parseInt(input.readLine());

		// Create the array to save the info in the text file
		String fileInfo[] = new String [size];

		// now read form the text file into the array
		for(int i = 0; i < size; i++) {
			fileInfo[i] = input.readLine();
		}

		// closes file stream
		input.close(); 

		// return my array
		return fileInfo;
	}

	/*
	 * method to store the analysis of each phrase into a new file
	 */
	public static void newFile(String eFile[], String phrase[]) throws IOException {
		// allows information to  be printed inside a text file
		FileWriter fileW = new FileWriter("newFile.txt");
		PrintWriter output = new PrintWriter (fileW);	
		
		// loop to display the e's of each phrase
		for (int i = 0; i < eFile.length; i++) {
			output.println(eFile[i]); 
			output.println(phrase[i] + "\n");
		}
		// closes file
		fileW.close();
	}

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws IOException {		
		// the code below is used to test the methods above
		//declare variables
		String output[];

		// call load phrase method to load the phrases
		output = PhraseLoader.loadPhrases("Phrases.txt");

		//declare variable for e's
		String eS[] = new String[output.length];

		// loop to print e's into file and test if information in file was loaded
		for (int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
			eS[i] = StringAnalyzer.eCounter(output[i]);
		}
		//call newFile method to input analysis into new file
		newFile(eS, output);

	}

}
