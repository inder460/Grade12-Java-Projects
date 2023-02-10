import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
/**
 *
 */

/**
 * @author Jimmy Chavada, Bilal Faheem, Inder Sodhi
 * Date: November. 2021
 * Description: This class is the GUI for the Droid Racer. will create a track and race the droids.
 * 				Will use the droid class and High Scores class to calcualte the steps moved for each droid
 * 				it will dertermine winners for the race and display into a format, along with displaying 
 * 				into a text file to store the values to access later. 
 * 
 * Method List: -> public GalaxyGame() - constructor to create the GUI 
 * 				-> public void actionPerformed (ActionEvent e) - method for actions events
 * 				-> public static void main(String[] args) - Main method to call the constructor 
 *
 */
public class GalaxyGame extends JFrame implements ActionListener{

//-------------------------------------------------------------------------------------------------------------Creating private variables--------------------------------------------------	
	private JPanel drawingPanel, controlPanel;
	private JButton btnStart, btnStop, btnExit, btnPlay, btnLeave;
	private TextPicture myTitle;
	private JLabel T1, T2, F1;
	private JTextField team1, team2, filename;
	private Droid droid[]; 
	private Die d1, d2; 
	private Timer timer;   // animation timer
	private int width, height;  // height and width of frame
	private int xPos[], yPos[],stepsMoved[];  
	private ImagePicture BackgroundImage, startingImage;
	private String finalOutput; 
	private JTextArea textArea;
	private String T1Name, T2Name, FName; // declaring String variables to hold inputs of team 1 name, team 2 name and file name to save scores
	private int score[];
	private boolean winner[]; 
	
//-------------------------------------------------------------------------------------------------------------End of Creating private variables--------------------------------------------


	/**
	 *
	 */
	public GalaxyGame() {
		super();
		
		width = 800;  
		height = 500; // initialize height and width for JFrame

		
		//---------------------------------------------RGB title 
		int color1 = 0, color2 = 0, color3 = 0;
		for(int i = 0; i < 100; i++) {

			color1 = (int)(Math.random() * 255 + 1);
			color2 = (int)(Math.random() * 255 + 1);
			color3 = (int)(Math.random() * 255 + 1);
		}
		//---------------------------------------------End of RGB title 

		
		setLayout(null); // set layout to null

		controlPanel = new JPanel();  // panel for buttons

		btnPlay = new JButton("PLAY"); // create button
		btnPlay.setBackground(Color.GREEN); 
		btnLeave = new JButton("EXIT"); 
		btnLeave.setBackground(Color.RED); 

		//>>>>>>> The myTitle code
		myTitle = new TextPicture("DROID RACER", 150, 45);
		myTitle.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 60));
		myTitle.setC(new Color(color1, color2, color3));

		// set bounds for title
		myTitle.setBounds(45, 0, 800, 500);
		
		
		

//-------------------------------------------------------------------------------------------------------------Setting TextField and titles---------------------------------------------------------
		
		//>>>>>>> The team1 code
		team1 = new JTextField("", 150); // text field to enter team 1 name
		team1.setFont(new Font("Monserat", Font.BOLD + Font.ITALIC, 15)); // set font for team 1 name input
		T1 = new JLabel("Enter Name For Team 1"); // label for telling user what this text field is for
		T1.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 17)); // set font for label
		T1.setForeground(Color.BLACK); // set color of label to red
		T1.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
		T1.setBackground(new Color(color1, color2, color3));
		T1.setOpaque(true);

		//>>>>>>> The team2 code
		team2 = new JTextField("", 150); // text field to enter team 2 name
		team2.setFont(new Font("Monserat", Font.BOLD + Font.ITALIC, 15)); // set font for team 2 name input
		T2 = new JLabel("Enter Name For Team 2"); // label for telling user what this text field is for
		T2.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 17)); // set font for label
		T2.setForeground(Color.BLACK); // set color of label to red
		T2.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
		T2.setBackground(new Color(color1, color2, color3));
		T2.setOpaque(true);

		//>>>>>>> The filename code
		filename = new JTextField("", 150); // text field to enter file name
		filename.setFont(new Font("Monserat", Font.BOLD + Font.ITALIC, 15)); // set font for file name input
		F1 = new JLabel("Enter File Name For Scores"); // label for telling user what this text field is for
		F1.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 17)); // set font for label
		F1.setForeground(Color.BLACK); // set color of label to red
		F1.setBackground(new Color(color1, color2, color3));
		F1.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
		F1.setOpaque(true);

		textArea = new JTextArea(); 
		textArea.setBackground(new Color(color1, color2, color3));
		textArea.setText("WELCOME TO THE DROID RACER GAME\n" + "Press PLAY to start the game \nPress EXIT to leave the game\n" + "Have fun!");
		textArea.setBounds(205, 230, 370, 110);
		textArea.setFont(new Font("serif", Font.BOLD + Font.ITALIC, 15));
		textArea.setOpaque(true);
		textArea.setBorder(BorderFactory.createTitledBorder("Welcome!"));

		BackgroundImage = new ImagePicture((new ImageIcon("ezgif-1-ee23bb0846a3.gif")),0,0); // initialize p1 to picture chosen for background

		T1.setBounds(30, 150, 220, 20);
		F1.setBounds(275, 150, 250, 20);
		T2.setBounds(550, 150, 220, 20);
		team1.setBounds(30, 170, 220, 25);
		filename.setBounds(275, 170, 250, 25);
		team2.setBounds(550, 170, 220, 25);
		controlPanel.setBounds(0, 430, width, 100); // setting bounds for all components and control panel on JFrame(inputs and texts)
		
		
		
//-------------------------------------------------------------------------------------------------------------End of Setting TextField and titles---------------------------------------------------------
		
		
		
		

		
		
		
		
		
//-------------------------------------------------------------------------------------------------------------Adding the contents and setting listeners---------------------------------------------------
		add(controlPanel); // add control panel to JFrame
		controlPanel.setBackground(Color.LIGHT_GRAY); // set colour for control panel

		controlPanel.add(btnPlay); // add button to control panel
		controlPanel.add(btnLeave); 

		add(myTitle);
		add(T1);
		add(F1);
		add(T2);
		add(team1);
		add(filename);
		add(textArea); 
		add(team2); // add all components to JFrame(inputs and texts)

		btnPlay.addActionListener(this); // add button as a listener in this frame
		btnLeave.addActionListener(this); 

		// Timer
		timer = new Timer(60, this); 
		timer.setInitialDelay(0);
		timer.addActionListener(this);

		setSize(width,height);  
		setLocation(100,100); // set size and location of frame

		BackgroundImage.setBounds(0, 0, width, height);
		add(BackgroundImage); // set bounds for picture used as background and add it to JFrame

		setVisible(true); // set visible
		setResizable(false); // set resizing to false

		setDefaultCloseOperation(EXIT_ON_CLOSE); // when x is clicked exit system
		
//-------------------------------------------------------------------------------------------------------------End of Adding the contents and setting listeners---------------------------------------------------

	
	
	
	}

	// method for actions events
	public void actionPerformed (ActionEvent e){

		
		if(e.getSource() == btnPlay) { // if btnPlay is clicked proceed to code inside
			
//-------------------------------------------------------------------------------------------------------------Setting text for files---------------------------------------------------
			T1Name = team1.getText();
			T2Name = team2.getText();
			FName = filename.getText(); // initializing String variables to corresponding JTextFeild variable to save input


			// check if the names are not created to set to default values 
			if(team1.getText().equals("")) { 
				T1Name = "Red Team"; 
			}
			if(team2.getText().equals("")) {
				T2Name = "Blue Team"; 
			}
			if(filename.getText().equals("")) {
				FName = "Score.txt"; 
			}
//-------------------------------------------------------------------------------------------------------------Setting text for files---------------------------------------------------

			
			
			
			
			
//-------------------------------------------------------------------------------------------------------------Create buttons and erase previous JPanel---------------------------------------------------
			myTitle.setTitle("RACE TIME"); // change title name
			myTitle.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 30)); // set font
			myTitle.setC(Color.ORANGE); // set color

			myTitle.setBounds(150, 0, 800, 100); // set bounds for title

			//myTitle.setVisible(false);
			T1.setVisible(false);
			F1.setVisible(false);
			T2.setVisible(false);
			team1.setVisible(false);
			filename.setVisible(false);
			team2.setVisible(false);
			btnPlay.setVisible(false);
			BackgroundImage.setVisible(false); // set all components from before to not visible to add race track
			btnLeave.setVisible(false);
			textArea.setVisible(false);
//-------------------------------------------------------------------------------------------------------------Create buttons and erase previous JPanel---------------------------------------------------
			
			
		
			
			
			
			
//-------------------------------------------------------------------------------------------------------------Adding buttons and setting bounds for images--------------------------------------------------			
			drawingPanel = new JPanel(); // create drawing panel

			btnStart = new JButton("Start Race");
			btnStop = new JButton("Pause Race");
			btnExit = new JButton("Exit Game"); // create buttons

			btnStart.setBackground(Color.ORANGE);
			btnStop.setBackground(Color.ORANGE);
			btnExit.setBackground(Color.ORANGE); // set Color for buttons


			// set the size and position of the panels
			BackgroundImage = new ImagePicture((new ImageIcon("StarWarsCompSci.png")),0,0); // initialize p2 to picture chosen for race track background
			startingImage = new ImagePicture((new ImageIcon("unnamed.png")),0,0); // initialize p3 to picture chosen for finish line

			btnStart.addActionListener(this);
			btnStop.addActionListener(this);
			btnExit.addActionListener(this); // add buttons as a listener in this JFrame



			startingImage.setBounds(0, 50, 50, 50);
			BackgroundImage.setBounds(0, 0, width, height);
			drawingPanel.setBounds(0, 0, width, height-100);
			
//-------------------------------------------------------------------------------------------------------------Adding buttons and setting bounds for images--------------------------------------------------	
			
			
			
			
//-----------------------------------------------------ADDING THE DROID-------------------------------------------

			droid = new Droid[4]; 											
			droid[0] = new Droid(new ImageIcon("C3po red.png")); 
			droid[1] = new Droid(new ImageIcon("r2d2 red.png")); 		
			droid[2] = new Droid(new ImageIcon("blue droid.png")); 						// create 4 droids and set their images
			droid[3] = new Droid(new ImageIcon("New Project (1) (1).png")); 
			
			xPos = new int[droid.length]; 
			yPos = new int[droid.length]; 
			stepsMoved = new int[droid.length]; 
			winner = new boolean[droid.length]; 
			score = new int[droid.length]; 


			// loop through the length of the droids to initialize the variables 
			for(int i = 0; i < droid.length; i++) {
				
				// create die
				d1 = new Die(); 
				d2 = new Die(); 
				stepsMoved[i] = 0; // init the steps moved to 0 
				droid[i].setBounds(0, 50, drawingPanel.getWidth(), drawingPanel.getHeight());
				droid[i].setTotalStepsToTake(2100);												// set the bounds and total steps to take for the droids 
				winner[i] = false; // winner is set to false 

				add(droid[i]); // adding the droid images onto the panel 
			} 

//-----------------------------------------------------END OF ADDING DROID----------------------------------------

			controlPanel.add(btnStart);
			controlPanel.add(btnStop);
			controlPanel.add(btnExit);
			add(myTitle); // add all buttons and title to JFrame

			controlPanel.setBackground(Color.BLACK); // set colour for control panel
			

			add(startingImage); // set bounds for p3 and add it to JFrame
			add(BackgroundImage); // set bounds for p2 and add it to JFrame
			add(drawingPanel); // set bounds for drawing panel and add it to JFrame


		}

		if(e.getSource() == btnStart) { // if btnStart is clicked proceed to code inside

			timer.start(); 
		}
		else if(e.getSource() == timer) { 
			
			
			
//-------------------------------------------------------------------------------------------------------------Movement for the droids--------------------------------------------------	
			// declare variable for amount rolled
			int amountRolled; 
			// make the images move amount of steps 
			for(int i = 0; i< droid.length; i++) { 

				amountRolled = droid[i].getTotalStepsToTake(d1, d2, 2100); 

				// method to check if the player has reached the final destination of the race track 
				if(stepsMoved[i] >= 2100) {
					// check if the droid has reached the begining of the start line image 
					if(droid[0].getyPos() <= 50 || droid[1].getyPos() <= 50) {
						// set the two droids to winners
						winner[0] = true;
						winner[1] = true; 
						// set the other droids to losers
						winner[2] = false;
						winner[3] = false;  
						JOptionPane.showMessageDialog(null, T1Name + " WINS!");
					}
					// check if the other two droids in team two have reached the finish line 
					else if(droid[2].getyPos() <= 50 || droid[3].getyPos() <= 50) {
						// set the two droids to the winners 
						winner[2] = true;
						winner[3] = true; 
						// set the other droids to losers
						winner[0] = false; 
						winner[1] = false; 
						JOptionPane.showMessageDialog(null, T2Name + " WINS!");
					}

					// calculate the points of the droids
					for(int j = 0; j < droid.length; j++) { 
						// calculate the points for all 4 droids 
						score[j] = HighScores.calcPoints(stepsMoved[j], winner[j]);	
					}

					// try for error
					try {
						HighScores.inputTextFile(FName, T1Name, T2Name, score); // test inputTextFile method
						finalOutput = HighScores.readTextFile(FName); // test readTextFile method

					}
					// catch error
					catch (IOException r) {
						// display message if error is found 
						JOptionPane.showMessageDialog(null, "File not found!");
					}
					timer.stop();
			
				}
				// if droids has not reached the max steps 
				else if(stepsMoved[i] <= 2100) { 
					
					// check if the droid has reached the end of the screen horizontally 
					if(droid[i].getxPos() <= 750 && droid[i].getyPos() == 0) {
						// set the X Position and move the droid that amount of rolls 
						xPos[i] += amountRolled; 
						// add onto the total steps moved for the final amount 
						stepsMoved[i] += amountRolled;  
						droid[i].setxPos(xPos[i]); // set the x position to the amount rolled 
					}

					// check if the droid has reached the end of the sreen horizontally and it is less than the screen vertically 
					else if(droid[i].getxPos() >= 750 && droid[i].getyPos() <= 300) {
						// set the x position so that it wont move further than the screen boundaries 
						droid[i].setxPos(750);
						// move the image down 
						yPos[i] += amountRolled;
						// store the steps moved 
						stepsMoved[i] += amountRolled;
						droid[i].setyPos(yPos[i]); // move the image 
					}

					// check if the image is greater than 0 and greater than 300 
					else if(droid[i].getxPos() >= 0 && droid[i].getyPos() >= 300) {
						xPos[i] -= amountRolled;  // move to the left 
						stepsMoved[i] += amountRolled;  // store the steps moved 
						droid[i].setxPos(xPos[i]); // move the image 
					}

					// check if the image is less than 0 on the x and greater than 0 on the y 
					else if(droid[i].getxPos() <= 0 && droid[i].getyPos() > 0) { 
						yPos[i] -= amountRolled;  // move the image upwards 
						stepsMoved[i] += amountRolled; // store the steps taken
						droid[i].setyPos(yPos[i]); // move the image
					}
				}
			}			
			// check if the timer has stopped
			if(timer.isRunning() == false) {
				// if so display the finaloutput and display a message while closing the game 
				JOptionPane.showMessageDialog(null, finalOutput);   							
				JOptionPane.showMessageDialog(null, "Thank you for playing the game!"); 	
				System.exit(0);
			}
			
//-------------------------------------------------------------------------------------------------------------Movement for the droids--------------------------------------------------

			

			
		}
		else if(e.getSource() == btnStop) { // else if btnStop is clicked proceed to code inside
			// once the button is stopped, stop all the droids 
			timer.stop();
		}
		else if(e.getSource() == btnExit){ // else if btnExit is clicked proceed to code inside
			System.exit(0); // exit game
		}
		// if the exit button is pressed
		else if(e.getSource() == btnLeave) { 
			System.exit(0); // exit the game 
		}
	}

	/**
	 * Main method to display the Panel
	 * @param args
	 */
	public static void main(String[] args) {
		// call the constructor 
		GalaxyGame animation = new GalaxyGame();
	}
}
