/**
 * 
 */

/**
 * @author indersodhi
 *
 */
public class TestQuestionClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Consider the following array
        int sample [] = new int [10];
        
        int change = 0;
        
        int sum = 0;
        
        
        // Write the code necessary for each of the following. Be sure
        // to declare any variables that are needed.
        
        
        //1. Initialize the elements of the array with the numbers from 0 to 9 (2 marks)
        
        for (int i = 0; i < sample.length; i ++) {
        	
        	sample[i] = i;
        	
        }     
        
        //2. Switches the 1st element of the array with the last
        //†† element of the array. Declare any needed variables.† (3 marks)
        
        sample [9] = change;
        
		sample [9]= sample [0];
		
		sample [0] = change;
        
        //3. Cubes (i.e. raises to the power of 3) all of the values of the array
        //††††† (hint: you may want to use a method of the Math class) (2 marks)
        
		for (int i = 0; i < sample.length; i ++) {
			
			sample [i] = (int) Math.pow(sample[i], 3);
			
		}

        
        // 4. Sets the variable sampleSum to the sum of all the values of all the elements
        //††† (hint: needs a loop) (3 marks)
		
		for (int i = 0; i < sample.length; i ++) {
			
			sum += sample[i];
			
			System.out.println(sum);
			
		}

	}

}
