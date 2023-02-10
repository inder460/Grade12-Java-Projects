import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author indersodhi
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//declare and create the studentN array for the student numbers [2 marks]
		int studentNumber [] = new int [8];
		int number = 12345;



		//declare and simultaneously (i.e. at the same time) initialize the
		//average array with the given marks.
		//Use the double a [] = {...} format [2 marks]
		double average [] = {67.7, 95.3, 78, 87.0, 89, 77, 79,80};



		//loop to initialize the studentN array with the student#ís above [4 marks]

		for(int i = 0; 1 < average.length; i++) {
			studentNumber[i] = number;
			number++;
		}

		// use System.outÖ to display the content of both arrays side by side [2 marks]
		for (int i = 0; i < average.length; i++) {
			System.out.println("Student number: "+studentNumber[i]+ " has an average mark of "+average[i] + "\n");
		}

		// call the method highestAvg below to display the year with highest average
		// [2 marks]
		JOptionPane.showMessageDialog(null, highestAvg(studentNumber, average));


	} // main method

	// Write the code for a method that returns a string containing
	// the student number with the highest average mark. NOTE: The method
	// definition and the return string are given. Declare any needed variables
	// [6 marks]
	public static String highestAvg (int stN [], double avg []){
		String topStudent = "";
		String highestAvg = "";

		topStudent = ""+stN[1];
		
		highestAvg = ""+avg[1];

		return "Student #: " + topStudent +"\tAvg: " + highestAvg;   
	}// highestAvg method
	// ClassMarks class
}


