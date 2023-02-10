import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 */

/**
 * @author Jimmy Chavada
 * Description: This class is used to store the total number of steps of the 4 robots,
 * the class will inherit from SmartMinion class and will control the movement
 * of the droids
 * Method List: -> public Droid(ImageIcon img) - constructor for the Droid 
 * 				-> public int getTotalStepsToTake(Die d1, Die d2) - Method to get the total number of steps to take 
 * 				-> public int setTotalStepsToTake(int stepsToTake) - Method to set the total number of steps to take 
 * 				-> public int checkScore(Die d1, Die d2) - Method to check the score of the die 
 * 				-> public static void main(String[] args) - Main method for testing 
 *
 */
public class Droid extends SmartMinion{

	private int TotalStepsToTake; 
	private int stepsTaken;

	/**
	 * Constructor for the droid 
	 */
	public Droid(ImageIcon img) {
		super(img);
	}
	/**
	 * Get the total steps to take for the droid
	 * @param d1
	 * @param d2
	 * @return
	 */
	public int getTotalStepsToTake(Die d1, Die d2, int stepsTotal) {
		this.stepsTaken = 0; // steps taken is 0 initially 
		this.TotalStepsToTake = stepsTotal;  // total steps to take is the length of the race
		int dieValue; // declare variable for the die value
		int rollReturn; // declare variable for the return value of the roll 
		while((this.stepsTaken+1) <= this.TotalStepsToTake) {	// loop to check if steps taken is less than total steps to take 
			// roll the 2 die 
			d1.rollDie();
			d2.rollDie();
			
			dieValue = d1.getValue() + d2.getValue(); // get the die value
			rollReturn = checkScore(d1, d2); // check the score of the return value of the 2 die
			
//			System.out.println("Number " + counter + " Dice 1 values: " + d1.getValue() + " Dice 2 values: " + d2.getValue() + " dice total = " + (dieValue));
			
			// check if the steps taken is going over the total steps to take
			if( (stepsTaken + rollReturn) > this.TotalStepsToTake ) {
				this.stepsTaken += (this.TotalStepsToTake - this.stepsTaken); // steps taken is set to '1' and added on to the final value 
//				System.out.println(" total Steps: " + this.stepsTaken);
//				System.out.println("Game done");
				return this.stepsTaken; 
			}
			else if (this.stepsTaken < this.TotalStepsToTake){	// check if steps taken is less than 2240 
				this.stepsTaken += rollReturn; // add the roll return for the steps taken 
//				System.out.println("Steps taken " + this.stepsTaken);	
				return this.stepsTaken; 
			}
		}
		return this.stepsTaken;
		
	}
	
	/**
	 * Method to set the total number of steps to take
	 * @param totalNumberSteps the totalNumberSteps to set
	 */
	public int setTotalStepsToTake(int stepsToTake) {
		this.TotalStepsToTake = stepsToTake;	// total steps is set to the int 
		return this.TotalStepsToTake; // return the total steps to take 
	}

	/**
	 * Method to check the score of the 2 die values added together
	 * @param d1
	 * @param d2
	 * @return
	 */
	public int checkScore(Die d1, Die d2)  {
		
		int dieTotal = d1.getValue() + d2.getValue(); 
		// check if the die values are either 2, 3, or 12
		if(dieTotal == 2 || dieTotal == 3 || dieTotal == 12) {
			// if so then the steps to take is 0 and turn is skipped
			System.out.println("The player will not take any steps ");
			return (dieTotal = 0); 
		}
		// if the value is not either of those (3) then just take the value
		else {
			// return the final steps that the droid is going to take
			return dieTotal;
		}
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
//-----------------------------------------------------------------------------------TESTING------------------------------------------------------------------------
		JFrame f = new JFrame("Testing");

		f.setSize(400, 350);

		Droid d = new Droid(new ImageIcon("minion.png"));

		Die d1 = new Die();
		Die d2 = new Die();
		
		d.getTotalStepsToTake(d1, d2, d.setTotalStepsToTake(2240)); 
		
		f.add(d);
		f.setVisible(true);

	}

}
