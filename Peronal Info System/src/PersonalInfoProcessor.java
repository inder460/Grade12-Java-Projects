/**
 * 
 */

/**
 * @author indersodhi
 * Date: Sept 2021
 * Description: Processes a String into another String that can be displayed
 * 
 * Mehtod List:
 * 		void main(String[] args) - main method
 *
 */
public class PersonalInfoProcessor {

	/**
	 * Method ton convert a String to another that can be displayed
	 * @param myString
	 * @return formatted string with Last name, First name, Age and Gender
	 */
	public static String processInfo (String myString) {
		String fName = null; // declare first name, last name, age and gender
		String lName = null;
		int age = 0;
		char gender = 0;

		// split the input String into its parts
		String words[]	= myString.split(" ");

		for(int i = 0; i < words.length; i++) {
			// switch based on the value of i
			switch(i) {
			case 0:{
				fName = words[0];
				break;
			}
			case 1:{
				lName = words[1];
				break;
			}
			case 2:{
				age = Integer.parseInt(words[2]);
				break;
			}
			case 3:{
				gender = words[3].charAt(0);
				break;
			}
			}
		}

		String formattedInfo = "Name:\t" + lName.concat(", ").concat(fName).concat("\n") 
				+ "Age:\t" + age + "\n" + "Gender:\t" + ConvertGender(gender) + "\n";

		return formattedInfo;

	}

	public static String ConvertGender(char gender) {
		String genderStr = ""; // String for output

		// convert the String
		switch(gender) {
		case 'f': {
			genderStr = "Female";
			break;
		}
		case 'm': {
			genderStr = "Male";
			break;
		}
		default: {
			genderStr = "Other";
		}
		}

		// return the gender String
		return genderStr;   
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String input [] = new String [3];
		String output [] = new String [3];

		// specify different records
		input [0] = "Inder Sodhi 16 m";
		input [1] = "Tony Campos 25 m";
		input [2] = "Jimmy Chavada 17 x";

		// loop through records
		for (int i = 0; i < input.length; i++) {
			output [i] = PersonalInfoProcessor.processInfo(input[i]);
			System.out.println(output[i]);
		}

	}

}
