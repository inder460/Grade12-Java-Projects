import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * 
 */

/**
 * Description: Movement for droids
 */
public class SmartMinion extends ImagePicture {

	public SmartMinion(ImageIcon img) {
		super(img);
		// TODO Auto-generated constructor stub
	}

	private int stepsToMove; 

	/**
	 * @return the stepsToMove
	 */
	public int getStepsToMove() {
		return stepsToMove;
	}

	/**
	 * @param stepsToMove the stepsToMove to set
	 */
	public void setStepsToMove(int stepsToMove) {
		this.stepsToMove = stepsToMove;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
	}

}
