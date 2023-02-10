/**
 * 
 */

/**
 * @author Bilal Faheem
 * Date: December 2021
 * Description: this class lets you make VehicleRecord objects and have a make, model, year, and type for each VehicleRecord. 
 * Method List:
 * 				public VehicleRecord () - Default constructor
 * 				public VehicleRecord (String input) - overloaded constructor that processes the information inputed
 * 				public String getMake () - gets make
 * 				public void setMake () - sets make
 *				public String getModel () - gets model
 *				public void setModel () - sets model
 *				public int getYear () - gets year
 *				public void setYear () - sets year
 *				public char getType () - gets type
 *				public void setType () - sets type
 *				public void processRecord (String record) - splits up the inputed record into different parts (make, model, year, type)
 *				public String toString () - formats information into a string
 *				public static void main(String[] args) - self testing main method
 *				
 *				
 */
public class VehicleRecord {
	// instance variables
	private String make, model;
	private int year;
	private char type;

	/**
	 * Default Constructor
	 */
	public VehicleRecord() {
		// Initialize all variables
		make = "";
		model = "";
		year = 0;
		type = ' ';
	}
	/**
	 * Overloaded Constructor
	 */
	public VehicleRecord(String input) {
		processRecord(input);
	}

	/**
	 * @return the make
	 */
	public String getMake() {
		return make;
	}
	/**
	 * @param make the make to set
	 */
	public void setMake(String make) {
		this.make = make;
	}
	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}
	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}
	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}
	/**
	 * @return the type
	 */
	public char getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(char type) {
		this.type = type;
	}
	
	/*
	 * Convert an input String into the different parts of the record
	 */
	public void processRecord(String record) {
		// declare an array to place the string
		String word [];
		word = record.split("/"); // splits the record into each part of the word array
		// place each of the words into the right instance variable data
		this.make = word [0]; 
		this.model = word [1];
		this.year = Integer.parseInt(word [2]);
		this.type = word [3].charAt(0);
	}

	/* 
	 * create toString method that will format information into a string
	 */
	public String toString() {
		// variables
		String word;
		char letter;

		letter = this.getType(); // get the type of vehicle

		// switch case to turn the letters into corresponding words
		switch(letter) {
		case 'p' :{ // passenger
			word = "Passenger";
			break;
		}
		case 'v' :{ // van
			word = "Van";
			break;
		}
		case 's' :{ // suv
			word = "SUV";
			break;
		}
		case 't' :{ // truck
			word = "Truck";
			break;
		}
		default:{ // set default to undefined
			word = "Undefined";
			break;
		}
		}

		// return the information in a formated String
		return "VehicleRecord [make=" + this.getMake() + ", model=" + this.getModel() + ", year=" 
		+ this.getYear() + ", type=" + word + "]";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// test ALL the methods in your class

		String input = "toyota/camry/2021/p";

		// create VehicleRecord object
		VehicleRecord sInfo = new VehicleRecord(); // tests the constructor

		System.out.println(sInfo.toString()); // test the toString method

		// test setters
		sInfo.setMake("Dodge");
		sInfo.setModel("Journey");
		sInfo.setYear(2012);
		sInfo.setType('s');

		System.out.println(sInfo.toString());

		// test all types
		sInfo.setType('p');
		System.out.println(sInfo.toString());

		sInfo.setType('v');
		System.out.println(sInfo.toString());

		sInfo.setType('t');
		System.out.println(sInfo.toString());

		// test processRecord
		sInfo.processRecord(input);
		System.out.println(sInfo.toString());
		
		// create another VehicleRecord object
		// test overloaded constructor
		VehicleRecord tInfo = new VehicleRecord (input);

		System.out.println(tInfo);

	}

}
