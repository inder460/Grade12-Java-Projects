import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Bilal Faheem
 * Date: November 2021
 * Description: This program will calculate the high scores for the droids and input the values into
 *				Files
 * Method List: -> public static int calcPoints (int steps, boolean winner) - calculate the points of the droids 
 * 				-> public static void inputTextFile (String fileName, String teamname1, String teamname2, int points[]) throws IOException - Output score into a file 
 * 				-> public static String readTextFile (String fileName) throws IOException - Reads the text file 
 * 				-> public static void main(String[] args) - main method for testing 
 *
 */
public class HighScores {
	
	/**
	 * @param steps
	 * @param winner
	 * @return
	 * Method to calculate the points
	 */
	public static int calcPoints (int steps, boolean winner) {
		int points = 0; // create a points variable
		// if the droid's team has won
		if (winner == true) {
			points += steps + 100; // give the droid 100 extra points
		}
		else if (winner == false) { // if the droid's team is not a winner
			points += steps;// give them only the amount of points that is their steps taken
		}
		return points;
	}
	/**
	 * @param fileName
	 * @param teamname1
	 * @param teamname2
	 * @param points
	 * @throws IOException
	 * 
	 */
	public static void inputTextFile (String fileName, String teamname1, String teamname2, int points[]) throws IOException {
		
		// create text file for writing to
		FileWriter write = new FileWriter(fileName);
		PrintWriter output = new PrintWriter (write);
		
		// write to the text file
		output.println(teamname1 + " has a score of: " + (points[0] + points[1]) + "\nDroid 1 has score of: "+ points[0]+ "\nDroid 2 has score of: " + points[1] +
				"\n"+ teamname2 + " has a score of: " + (points[2] + points[3])+  "\nDroid 3 has score of: " + points [2] + "\nDroid 4 has score of: " + points[3]);
		
		output.close();// close the text file
	}
	/**
	 * @param fileName
	 * @return
	 * @throws IOException
	 * This method reads a text file and formats the data within the text file which is then outputed as a string
	 */
	public static String readTextFile (String fileName) throws IOException {
		// open text file for reading
		FileReader fr = new FileReader(fileName);
		BufferedReader input = new BufferedReader(fr);
	
		// declare variables to store contents of the text file
		String data = "";
		String dataArray [] = new String [6];
		
		// now read from the text file into the string array
		for(int i = 0; i < 6; i++) {
			dataArray [i] = input.readLine();
		}
		
		// place the text file information into a string with the proper format for the data
		data = dataArray[0] + "\n" +dataArray[1]+ "\n"+dataArray[2]+"\n\n" +
				dataArray[3]+  
				"\n"+ dataArray[4] + "\n"+dataArray[5];
		
		input.close(); // close the text file
		return data; // return the string
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// self testing main
		
		// string variables for testing
		String name = "Untitled 1";
		String teamName = "Team 1";
		String teamName1 = "Team 2";
		
		int steps1 = 111, steps2 = 1, steps3 = 2, steps4 = 3; // droid points
		int point[] = {steps1, steps2, steps3, steps4}; // array with all droids points
		
		// boolean variables for winner/loser
		boolean winner = true;
		boolean loser = false;
		
		// call the calcPoints method to calculate the points of the first and second droid (they are winners)
		point[0] = calcPoints(steps1, winner);
		point[1] = calcPoints(steps2, winner);
		
		// call the calcPoints method to calculate the points of the third and fourth droid (they are losers)
		point[2] = calcPoints(steps3, loser);
		point[3] = calcPoints(steps4, loser);

		try {
			inputTextFile(name, teamName, teamName1, point); // test inputTextFile method
			System.out.println(readTextFile(name)); // test readTextFile method
		}
		catch (IOException e) {
			System.out.println("File not found!");
		}

	}

}