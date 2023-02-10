import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 * 
 */

/**
 * @author indersodhi
 * Date: Sept 2021
 * Description: opens a text file with a number of lines and loads it into a String array.
 *
 *Method List:
 *		String[] loadFile(String fileName)throws IOException - loads a file
 *		void main(String[] args) - main method
 */
public class Loader {
	
	/*
	 * Method to open a file and load the info within 
	 * Returns a String array
	 */
	public static String[] loadFile(String fileName)throws IOException{
		// open a file for reading
		FileReader fr = new FileReader(fileName);
		BufferedReader input = new BufferedReader(fr);
		
		// read the number of items in the file
		int size = Integer.parseInt(input.readLine());
		
		// Create the array to save the info in the file
		String fileInfo[] = new String [size];
		
		// now read form the file into the array
		for(int i = 0; i < size; i++) {
			fileInfo[i] = input.readLine();
		}
		
		input.close(); // closes file stream
		
		// return my array
		return fileInfo;
	}

	/**
	 * @param args
	 * Self testing main method
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// declare the output array 
		String output[];
		
		// load the file into the array
		output = Loader.loadFile("PersonalInfoFile.txt"); 
		
		for (int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}

	}

}
