import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Bilal Faheem
 * Date: December 2021
 * Description: this class uses VehicleRecord class and makes a list of different vehicle records.
 * Method List: 
 * 				public VehicleList() - default constructor
 * 				public int getSize() - gets size
 * 				public boolean insert(VehivelRecord record) - method for inserting a record into the list
 * 				public boolean delete(VehicleRecord record) - method for deleting a record from a list
 * 				public boolean change(VehicleRecord oldR, VehicleRecord newR) - changes an existing record 
 * 				public String toString () - puts all the records into a string
 * 				public boolean listIncrease (int increase) - method for increasing the size of a list
 * 				public static void main (String[] args) - self testing main
 *
 */
public class VehicleList {

	/*
	 * instance data
	 */
	private VehicleRecord list[]; // list
	private int maxSize; // max number of records that can exist in the list
	private int size; // actual usable size at any point

	/**
	 * default constructor
	 */
	public VehicleList() {
		// initialize the data
		this.maxSize = 10;
		this.list = new VehicleRecord [maxSize];
		this.size = 0;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/*
	 * Method to insert a record in the list
	 */
	public boolean insert(VehicleRecord record) {
		if (size < maxSize) { // if there is space
			size++; // increase size
			list[size-1] = record; // place record at size -1
			return true; // return successful
		}
		return false; // no space
	}

	/*
	 * Method to "delete" a record from the list.
	 */
	public boolean delete (VehicleRecord record) {
		// loop through the valid list
		for (int i = 0; i < this.getSize(); i++) {
			
			// check if the record is in the list
			if (this.list[i].getModel().equalsIgnoreCase(record.getModel())) {
				this.list [i] = this.list[size-1]; // put the last record where the record to be deleted is found
				size --; // decrease the valid size
				return true; // record was deleted
			}
		}
		return false; // record was not found
	}
	/*
	 * method to change existing record
	 */
	public boolean change (VehicleRecord oldR, VehicleRecord newR) {
		// delete old record
		if (delete(oldR)) {
			insert(newR); // insert new record
			return true; // record was changed
		}
		return false; // record was not changed
	}
	/**
	 * Create a toString method
	 */
	public String toString() {
		String theList = ""; // output variable which is empty 

		// loop through the valid elements of the list 
		for (int i = 0; i < this.getSize(); i++) {
			// add a record to the output variable 
			theList = theList + "Vehicle Record " + i + ": " + list[i].toString() + "\n"; 
		}
		return theList; // return theList
	}
	
	/**
	 * @param increase
	 * @return
	 * Method to increase the size of the list
	 */
	public boolean listIncrease (int increase) {
		// create a new VehicleRecord list object
		VehicleRecord newList [];
		newList = new VehicleRecord [increase]; // set the size of the array to inputed value

		// if the inputed value is greater than the amount of things in the array
		if (increase > size) {
		
			// copy the information from the original list into the new list
			for (int i = 0; i < this.size; i ++) { 
				newList[i] = list[i];
			}
			
			this.list = newList; // set list equal to the newList
			this.maxSize = this.list.length; // change the maxSize to the updated list length
			
			return true; // list was increased
		}
		return false; // list was not increased
	}

	/**
	 * @param args
	 * self testing main
	 */
	public static void main(String[] args) {
		// create an object of my list
		VehicleList vehicles = new VehicleList();

		// infinite loop
		while (true) {
			char command; // declare char variable
			
			// ask user what they would like to do
			command = JOptionPane.showInputDialog("i - insert\nc - change\na - change list size\nd - delete\np - print\nq - quit\n", "i").
					charAt(0);
			
			// if user would like to quit the program
			if (command == 'q') {
				break; // breaks out while loop
			}
			
			// switch case using user's input
			switch(command) {
			
			case 'i' :{ //insert
				//prompt for record
				String record = JOptionPane.showInputDialog("Enter <make/model/year/type>", "Dodge/Journey/2012/s");
				
				// use overloaded constructor to create a VehicleRecord with the information user inputed
				VehicleRecord sInfo = new VehicleRecord(record); 

				// test the insert
				if (vehicles.insert(sInfo)) { // if sInfo is inserted
					JOptionPane.showMessageDialog(null, "Record inserted");
				}
				else { // if sInfo is not inserted
					JOptionPane.showMessageDialog(null, "Insert failed");
				}
				break;
			}
			case 'p' :{ // print
				JOptionPane.showMessageDialog(null, vehicles.toString());
				break;
			}
			case 'd' :{ // delete
				//prompt for record
				String record = JOptionPane.showInputDialog("Enter <make/model/year/type>", "Dodge/Journey/2012/s");
				VehicleRecord sInfo = new VehicleRecord();
				sInfo.processRecord(record);
				// test the delete
				if (vehicles.delete(sInfo)) {
					JOptionPane.showMessageDialog(null, "Record deleted");
				}
				else {
					JOptionPane.showMessageDialog(null, "Record not found");
				}
				break;
			}
			case 'c' : { // change
				// prompt for old record
				String oldR = JOptionPane.showInputDialog("Enter old record", "Dodge/Journey/2012/s");
				VehicleRecord oldInfo = new VehicleRecord();
				oldInfo.processRecord(oldR);

				// prompt for new record
				String newR = JOptionPane.showInputDialog("Enter new record", "Dodge/Journey/2012/s");
				VehicleRecord newInfo = new VehicleRecord();
				newInfo.processRecord(newR);

				if (vehicles.change(oldInfo, newInfo)) {
					JOptionPane.showMessageDialog(null, "Record changed");
				}
				break;
			}
			case 'a' :{ // change list size
				int sizeNew;
				// prompt user for new size of list
				sizeNew = Integer.parseInt(JOptionPane.showInputDialog("what would you like to change the max list size to?: "));
				
				if (vehicles.listIncrease(sizeNew)) {
					JOptionPane.showMessageDialog (null, "List size increased"); // list was increased
				}
				else {
					JOptionPane.showMessageDialog (null, "Failed to increase list size"); // list was not increased
				}
				break;
			}
			}
		}
	}

}
