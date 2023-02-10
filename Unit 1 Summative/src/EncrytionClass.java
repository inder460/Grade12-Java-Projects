/**
 * 
 */

/**
 * @author Inder Sodhi
 * Date: Oct. 2021
 * Description: This class used to check if inputed character is a letter, than encrypt or decrypt the 
 * 				letter or both.
 * Method list: public static boolean isALetter - checks if character is a letter
 * 				public static char encode - used to encrypt a letter
 * 				public static char decode - used to decrypt a letter
 * 				public static void main - used to test methods
 * 
 */
public class EncrytionClass {

	/*
	 * Method to check if character is a letter
	 */
	public static boolean isALetter(char character) {
		// if character is letter the proceed to code inside the if statement 
		if (Character.isLetter(character)){
			// return true if character is letter
			return true;
		}
		// else return false
		else {
			return false;
		}
	}

	/*
	 * Method to return encrypted phrase
	 */
	public static char encode (char letter, int encryptKey){
		// declare variables 
		char myChar = letter;
		// declare integer to force char to be integer
		int integer = (int)myChar;
		// variable to hold ascii value to be looped back(only looped if needed)
		int AsciiVal = 0;
		// return variable
		int NewCharInt = 0;

		// add ascii value of letter with encrypt key to get encrypted ascii value
		AsciiVal = integer + encryptKey;

		// if letter is lower case proceed to code inside
		if(Character.isLowerCase(myChar)==true) {

			// if encrypted ascii value greater than 122 proceed to code inside
			if(AsciiVal > 122) {
				// subtract value above 122 from 122 then add to 97-1 to loop back to letters
				int i = AsciiVal - 122;
				NewCharInt = 97 + i - 1;
			}

			// else if encrypted ascii value lower than 97 proceed to code inside
			else if(AsciiVal < 97) {
				// subtract 97 from ascii value, then 122 subtract new value subtract 1 to loop around
				int i = 97 - AsciiVal;
				NewCharInt = 122 - i - 1;
			}

			// else if encrypted ascii value between 97-122 proceed to code inside
			else if(AsciiVal >= 97 && AsciiVal <= 122) {
				// set return variable to equal encrypted ascii value
				NewCharInt = AsciiVal;
			}
		}
		// else if letter is upper case proceed to code inside
		else if(Character.isUpperCase(myChar)==true) {

			// if encrypted ascii value lower than 65 proceed to code inside
			if(AsciiVal < 65) {
				// subtract 65 from ascii value, then 90 subtract the new value subtract 1 to loop around
				int i = 65 - AsciiVal;
				NewCharInt = 90 - i - 1;
			}

			// else if encrypted ascii value greater than 90 proceed to code inside
			else if(AsciiVal > 90) {
				// subtract value above 90 from 90, then add to 65-1 to loop back to letters
				int i = AsciiVal - 90;
				NewCharInt = 65 + i - 1;
			}

			// else if encrypted ascii value between 65-90 proceed to code inside
			else if(AsciiVal >= 65 && AsciiVal <= 90) {
				// set return variable to equal encrypted ascii value
				NewCharInt = AsciiVal;
			}
		}

		// cast encrypted ascii value to get letter and return it 
		return (char) NewCharInt;
	}

	/*
	 * Method to return decrypted letter
	 */
	public static char decode (char letter, int decryptKey) {
		// declare variables 
		char myChar = letter;
		// declare integer to force char to be integer
		int integer = (int)myChar;
		// variable to hold ascii value to be looped back(only looped if needed)
		int AsciiVal = 0;
		// return variable
		int NewCharInt = 0;

		// subtract ascii value letter with decrypt key to get decrypted ascii code value
		AsciiVal = integer - decryptKey;

		// if letter lower case proceed to code inside
		if(Character.isLowerCase(myChar)==true) {

			// if decrypted ascii value greater than 122 proceed to code inside
			if(AsciiVal > 122) {
				// subtract ascii value by 122, add 97+1 for it to loop around back to letters
				int i = AsciiVal - 122;
				NewCharInt = 97 + i + 1;
			}

			// else if decrypted ascii value less than 97 proceed to code inside
			else if(AsciiVal < 97) {
				// subtract 97 from ascii value, subtract 122 from the value plus 1 to loop back to letters
				int i = 97 - AsciiVal;
				NewCharInt = 122 - i + 1;
			}

			// else if the decrypted values between 97 and 122 proceed to code inside
			else if(AsciiVal >= 97 && AsciiVal <= 122) {
				// set return value to equal ascii value 
				NewCharInt = AsciiVal;
			}
		}
		// else if letter upper case proceed to code inside
		else if(Character.isUpperCase(myChar)==true) {

			// if decrypted ascii value less than 65 proceed to code inside
			if(AsciiVal < 65) {
				// subtract 65 from ascii value, subtract 90 from the value plus 1 to loop around
				int i = 65 - AsciiVal;
				NewCharInt = 90 - i + 1;
			}

			// else if decrypted ascii value greater than 122 proceed to code inside
			else if(AsciiVal > 90) {
				// subtract ascii value by 90, add 65+1 for it to loop around back to letters
				int i = AsciiVal - 90;
				NewCharInt = 65 + i + 1;
			}

			// else if the decrypted values between 65 and 90 proceed to code inside
			else if(AsciiVal >= 65 && AsciiVal <= 90) {
				// set return value to equal ascii value
				NewCharInt = AsciiVal;
			}
		}

		// cast decrypted ascii value to get letter and return
		return (char) NewCharInt;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// THE CODE BELOW WAS USED FOR TESTING METHODS

		String letter = "Did Fred look well? That's it!";
		char encode;
		char decode;

		for(int i = 0; i < letter.length(); i++) {

			if(isALetter(letter.charAt(i)) == true) {
				encode = encode(letter.charAt(i), 25);
				decode = decode(encode, 25);
				System.out.print(encode);
			}

			else{
				System.out.print(letter.charAt(i));
			}
		}

		System.out.println("\n");

		for(int i = 0; i < letter.length(); i++) {

			if(isALetter(letter.charAt(i)) == true) {
				encode = encode(letter.charAt(i), 25);
				decode = decode(encode, 25);
				System.out.print(decode);
			}

			else{
				System.out.print(letter.charAt(i));
			}
		}
	}

}
