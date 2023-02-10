/**
 * 
 */

/**
 * @author indersodhi
 *
 */
public class Q {
	public static String compare(int a, int b){

		String Return = "";
		if (a < b){

	        Return = "a is smaller than b";
	        

	    }

	    else if (a > b){

	        Return = "a is larger than b";

	    }
	    return Return;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(compare(3,2));

	}

}
