import javax.swing.*;
import java.awt.*;
/**
 *
 */

/**
 * @author Jimmy Chavada
 * Description: This program creates a Eye picture using various setters and getters 
 * Method: public Picture() - initilize the private variables 
 * 		   public Picture(int x, int y, int w, int h) - overloaded constructor 
 * 		   public Color getC() - get the color 
 * 		   public void setC(Color c) - set the color 
 * 		   public int getxPos() - get the xPos
 * 		   public void setxPos(int xPos) - set the xPos
 * 		   public int getyPos() - get the yPos
 * 		   public void setyPos(int yPos) - set the yPos
 * 		   public int getMyWidth() - get the width 
 * 		   public void setMyWidth(int myWidth) - set the width 
 * 		   public int getMyHeight() - get the height 
 * 		   public void setMyHeight(int myHeight) - set the height 
 * 	       public void paint (Graphics g) - used to paint the Eye picture in the class 
 *		   public static void main(String[] args) - main method for testing 
 */
public class Picture extends JComponent{

	/*
	 * Private data for picture
	 */
	private Color c;
	private int xPos, yPos, myWidth, myHeight;

	/**
	 * default constructor
	 */
	public Picture() {
		// INIT variables
		this.c = Color.RED;
		this.xPos = 0;
		this.yPos = 0;
		this.myHeight = 25;
		this.myWidth = 50;
		repaint();
	}

	/**
	 * overloaded constructor
	 */
	public Picture(int x, int y, int w, int h) {
		// INIT variables
		this.c = Color.RED;
		this.xPos = x;
		this.yPos = y;
		this.myWidth = w;
		this.myHeight = h;
		repaint();
	}

	/**
	 * @return the c
	 */
	public Color getC() {
		return c;
	}

	/**
	 * @param c the c to set
	 */
	public void setC(Color c) {
		this.c = c;
		repaint();
	}
	

	/**
	 * @return the xPos
	 */
	public int getxPos() {
		return xPos;
	}

	/**
	 * @param xPos the xPos to set
	 */
	public void setxPos(int xPos) {
		this.xPos = xPos;
		repaint();
	}

	/**
	 * @return the yPos
	 */
	public int getyPos() {
		return yPos;
	}

	/**
	 * @param yPos the yPos to set
	 */
	public void setyPos(int yPos) {
		this.yPos = yPos;
		repaint();
	}

	/**
	 * @return the myWidth
	 */
	public int getMyWidth() {
		return myWidth;
	}

	/**
	 * @param myWidth the myWidth to set
	 */
	public void setMyWidth(int myWidth) {
		this.myWidth = myWidth;
		repaint();
	}

	/**
	 * @return the myHeight
	 */
	public int getMyHeight() {
		return myHeight;
	}

	/**
	 * @param myHeight the myHeight to set
	 */
	public void setMyHeight(int myHeight) {
		this.myHeight = myHeight;
		repaint();
	}

	// our paint method
	public void paint (Graphics g)  {
		// set color, draw rectangle, draw the eye oval, and fill it then repaint
		g.setColor(c);
		g.drawRect(xPos,yPos,myWidth, myHeight);
		g.drawOval(xPos,yPos,myWidth, myHeight);
		g.fillOval(xPos + myWidth/3, yPos, myWidth/3 ,myHeight);
		repaint();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// create a JFrame to draw my picture
		JFrame f = new JFrame("Frame for testing");

		// creates a picture object
		Picture p1 = new Picture();
		Picture p2 = new Picture();
		Picture p3 = new Picture(100, 10, 50, 400); 


		// use setters to set the location and shape of the eye
		p1.setC(Color.RED);
		p1.setxPos(100);
		p1.setyPos(10);

		// set height and width
		p1.setMyHeight(50);
		p1.setMyWidth(200);

		// set the size of the frame and add the picture
		f.setSize(400, 350);
		f.add(p1);  // add my object to the frame
		f.setVisible(true);	// set the visibility of the frame to true 


		// wait to see the first one
		JOptionPane.showMessageDialog(null, "wait");

		// testing it by moving the location
		p1.setC(Color.BLACK);
		p1.setxPos(100);
		p1.setyPos(150);

		// get and set the height and width of the picture
		p1.setMyHeight(p1.getMyHeight() + 50);
		p1.setMyWidth(p1.getMyWidth() + 10);

		// wait message to see the previous one 
		JOptionPane.showMessageDialog(null, "wait");

		// for loop to test p2
		for(int i = 0; i < 100; i ++)  {

			// set the color and move the images x and y position with 'i'
			p2.setC(Color.CYAN);
			p2.setxPos(i);
			p2.setyPos(i);

			// set the width and the height 
			p2.setMyWidth(200);
			p2.setMyHeight(50);

			// add p2 and set visible
			f.add(p2);
			f.setVisible(true);
		}
		
		JOptionPane.showMessageDialog(null, "wait");
		f.add(p3); 



	}

}