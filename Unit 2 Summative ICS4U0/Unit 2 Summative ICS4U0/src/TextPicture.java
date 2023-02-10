import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 */

/**
 * @author Text picture
 * Description: this is the textPicture class which takes titles and changes the font and position in a JFrame 
 * Method List: public TextPicture() - Constructor to set the private variables 
 * 				public TextPicture(String t, Font F, int x, int y) - overloaded Constructor 
 * 				public void setTitle(String title) - setter for title
 * 				public void setFont(Font font) - setter for font 
 * 				public void setxPos(int xPos) - setter for xPos
 * 				public void setyPos(int yPos) - setter yPos
 * 				public void paint (Graphics g) - method to paint the TextPicture 
 * 				public static void main(String[] args) - Main method for testing 
 *
 */
public class TextPicture extends Picture{

	private String title;  
	private Font font;
	private int xPos;				// create the private variables 
	private int yPos; 


	/**
	 * Default constructor
	 * used to set the private variables 
	 */
	public TextPicture() { 
		super(); 
		title = "Hello World"; 
		xPos = 100; 
		yPos = 50; 
		font = new Font("Serif",Font.PLAIN,40);
		repaint(); 
	}
	public TextPicture(String title, int x, int y) {
		super();
		setxPos(x);
		setyPos(y);
		this.font = new Font("Monospaced", Font.PLAIN, 12);
		this.title = title;
		repaint();
	}

	/**
	 * Overloaded constructor
	 * @param title
	 * @param xPos
	 * @param yPos
	 */
	public TextPicture(String t, Font F, int x, int y) {
		super();
		this.title = t; 
		this.font = F;
		this.xPos = x; 
		this.yPos = y; 
		repaint(); 
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
		repaint();
	}

	/**
	 * @param largeSerifFont the largeSerifFont to set
	 */
	public void setFont(Font font) {
		this.font = font;
		repaint();
	}

	/**
	 * @param xPos the xPos to set
	 */
	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	/**
	 * @param yPos the yPos to set
	 */
	public void setyPos(int yPos) {
		this.yPos = yPos;
	}


	public void paint (Graphics g) {
		g.setColor(this.getC());
		g.setFont(this.font);
		g.drawString(this.title, xPos, yPos);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame f = new JFrame();	// creates a JFrame

		// creates a textpicture object
		TextPicture p1 = new TextPicture();

		// set the title for p1 
		p1.setTitle("Hello world");

		// set the size, add p1, and set the visibility 
		f.setSize(750,300);
		f.add(p1);
		f.setVisible(true);
		// wait to show the previous one 
		JOptionPane.showMessageDialog(null, "wait");

		// change the title and font of p1 
		p1.setTitle("Hello, this is new");
		p1.setFont(new Font("Monospaced",Font.BOLD,40));

		// wait to show previous message 
		JOptionPane.showMessageDialog(null, "wait");

		// set the title and change font 
		p1.setTitle("This one will move");
		p1.setFont(new Font("Arial", Font.ITALIC, 40));

		// set the x and y position 
		p1.setxPos(150);
		p1.setyPos(250);

		// wait 
		JOptionPane.showMessageDialog(null, "wait");

		// test overloaded construcotr 
		TextPicture p2 = new TextPicture("Hello, this is a overloaded constructor",new Font("Monospaced",Font.BOLD,30),20,200);
		f.add(p2); 
		f.setVisible(true);

	}
	

}
