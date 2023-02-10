/**
 * 
 */

/**
 * @author indersodhi
 * Date: Dec. 2021
 * Description: Class to represent object containing Vehicle Records
 * Method List: public VehicleRecord() - default constructor
 * 				public String getMake() - get make of vehicle
 * 				public void setMake(String make) - set make of vehicle
 * 				public String getModel() - get model of vehicle
 * 				public void setModel(String model) - set model of vehicle
 * 				public int getYear() - get year of vehicle
 *				public void setYear(int year) - set year of vehicle
 *				public char getType() - get type of vehicle
 *				public void setType(char type) - set type of vehicle
 *				public void processRecord(String record) - convert an input String into the different parts of this record
 *				public VehicleRecord(String input) - Overloaded constructor that uses processRecord class
 *				public String toString() - method to set single letter variables to corresponding Strings
 *				public static void main(String[] args) - self testing main method
 *
 */
public class VehicleRecord {

	/**
	 * Instance data
	 */
	private String make, model;
	private int year;
	private char type;

	/**
	 * default constructor
	 */
	public VehicleRecord() {
		this.make = "";
		this.model = "";
		this.year = 0;
		this.type = 0;
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

	/**
	 * Convert an input String into the different parts of this record
	 */
	public void processRecord(String record) {
		// declare an array to place the String
		String word[] = record.split("/"); // splits the record into each part of the word array
		this.make = word[0];
		this.model = word[1]; 			// place each word into the right instance data
		this.year = Integer.parseInt(word[2]);
		this.type = word[3].charAt(0);
	}
	
	/**
	 * Overloaded constructor
	 */
	public VehicleRecord(String input) {
		processRecord(input);
	}

	@Override
	public String toString() {
		String vehicleType;
		char word = this.getType();
		switch(word) {
		case 'p':{
			vehicleType = "Passanger";
			break;
		}
		case 'v':{
			vehicleType = "Van";
			break;
		}
		case 't':{
			vehicleType = "Truck";
			break;
		}
		case 's':{
			vehicleType = "SUV";
			break;
		}
		default:{
			vehicleType = "Unknown Vehicle Type";
			break;
		}
		}

		return "VehicleRecord [Make=" + this.getMake() + ", Model=" + this.getModel()
		+ ", Year=" + this.getYear() + ", Type=" + vehicleType + "]";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Test all methods in your class
		String input = "Ford/Mustang GT Premium/2021/a";

		// create object based on this class
		VehicleRecord sInfo = new VehicleRecord();

		System.out.println(sInfo.toString());

		// test setters
		sInfo.setMake("GMC");
		sInfo.setModel("Sierra 1500 AT4");
		sInfo.setYear(2021);
		sInfo.setType('t');

		System.out.println(sInfo.toString());
		
		// test setters
		sInfo.setMake("Honda");
		sInfo.setModel("Civic");
		sInfo.setYear(2021);
		sInfo.setType('p');

		System.out.println(sInfo.toString());
		
		// test setters
		sInfo.setMake("Dodge");
		sInfo.setModel("Caravan");
		sInfo.setYear(2021);
		sInfo.setType('v');

		System.out.println(sInfo.toString());
		
		// test setters
		sInfo.setMake("GMC");
		sInfo.setModel("Youkon");
		sInfo.setYear(2021);
		sInfo.setType('s');

		System.out.println(sInfo.toString());

		// test the processRecord method
		sInfo.processRecord(input);

		System.out.println(sInfo.toString());
		
		// test overloaded constructor 
		VehicleRecord kInfo = new VehicleRecord(input);
		
		System.out.println(kInfo.toString());

	}

}
