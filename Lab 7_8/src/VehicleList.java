import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author indersodhi
 * Date: Jan. 2022
 * Description: This program inherits from VehicleRecord class and creates a list of vehicle
 * 				records and the list size can be determined by user. Methods have been added
 * 				to this program to allow it to search for a vehicle record and sort the vehicle
 * 				record list in alphabetical order.
 * Method List: public VehicleList() - default constructor
 * 				public int getSize() - get size
 * 				public boolean insert(VehicleRecord record) - inserts records
 * 				public boolean delete(VehicleRecord record) - deletes records
 * 				public boolean change (VehicleRecord oldR, VehicleRecord newR) - changes records
 * 				public String toString() - creates toString method
 * 				public boolean increaseList(int increase) - increases list size
 * 				public int linearSearch (String searchKey) - linear search method
 * 				public void insertion () - insertion sort method
 * 				public int binarySearch (String searchKey) - binary search method
 * 				public int binarySearch(String searchKey, String searchModel, int low, int high) - overloaded binary search method using recursion
 * 				public void selectionSort() - selection sort method
 * 				public static void main(String[] args) - self testing main
 * 
 */
public class VehicleList {

	/**
	 * Tnstance data
	 */
	private VehicleRecord list[];
	private int maxSize; // maximum number of records that can exist in the list
	private int size; // actual usable size at any point

	/**
	 *  default constructor
	 */
	public VehicleList() {
		// initialize the data
		this.maxSize = 10;
		this.list = new VehicleRecord[maxSize];
		this.size = 0;
	}

	/**
	 * @return the list
	 */
	public VehicleRecord[] getList() {
		return list;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Method to insert a record in the list
	 * Checks if the size is below the maximum size
	 * if it is, increases the size by 1 and adds it
	 * the record to the location just below the size
	 * returns true if successful
	 */
	public boolean insert(VehicleRecord record) {
		if(size < maxSize) { // if size of list is less than max size proceed to code inside
			size++; // increase size by 1
			list[size-1] = record; // placing record of vehicle
			return true; // return true
		}
		return false; // no space
	}

	/**
	 * Method to "delete" a record from the list.
	 * Cheats by replacing the record to be deleted
	 * with the last record on the list.
	 * Then decreases the actual valid size
	 */
	public boolean delete(VehicleRecord record) {
		// loop through the valid list
		for(int i = 0; i < this.getSize(); i++) {
			// check if the record is in the list
			while (binarySearch(record.getMake()) == i) {
                this.list [i] = this.list[size-1]; // place last record where the deleted reacord is
                size --; // decrease valid size
                return true; // deleted
            }
        }
		return false; // record not found
	}

	/**
	 * Method to change an existing record to some other record
	 * Delete old record
	 * Add new record
	 */
	public boolean change (VehicleRecord oldR, VehicleRecord newR) {
		// delete old record
		if(delete(oldR)) { // checks if i can delete
			insert(newR); // inserts new record
			return true;
		}
		return false; // could not delete file
	}

	/**
	 * create a toString method
	 */
	public String toString() {
		String theList = "";
		for(int i = 0; i < this.getSize(); i++) {
			// add a record to the output variable
			theList = theList + "Record " + i + ": " + list[i].toString() + "\n";
		}
		return theList; // return list
	}

	/**
	 * Method to increase list size
	 */
	public boolean increaseList(int increase) {
		// create list
		VehicleRecord newList[] = new VehicleRecord[increase];

		if(increase > size) { // if increase greater than size proceed to code inside
			for(int i = 0; i < this.size; i++) { // for loop to transfer data from original list to new list
				newList[i] = list[i];
			}
			this.list = newList; // making original list equal to new list
			this.maxSize = this.list.length; // change the max size value to new list length
			return true; // return true
		}
		return false; // return flase
	}

	/**
	 * The linear search method
	 * Search for the student name
	 */
	public int linearSearch (String searchKey) {
		// loop through the list from 0 to usable size
		for (int i = 0; i < size; i++) {
			if (searchKey.equalsIgnoreCase(list[i].getModel())) {
				return i; // student name was found at i
			}
		}
		return -1; // return an invalid (negative) index
	}

	/**
	 * The insertion sort method 
	 * Sorts vehicle list in alpha order
	 */
	public void insertion () {

		String temp;
		int j;
		for (int i = 0; i < size; i++) {
			temp = list[i].getMake();
			for (j = i; j > 0 && list[j-1].getMake().compareToIgnoreCase(temp) > 0; j--) {
				list[j].setMake(list[j-1].getMake());
			}
			list[j].setMake(temp);
		}
	}

	/**
	 * The binary search algorithm
	 * Searches for the make of a car
	 * Assumes that the makes are sorted in alpha
	 */
	public int binarySearch (String searchKey) {
		int low = 0;
		int high = size - 1;
		int middle; 

		// while the low end of the array is below the high end
		while(low <= high) {
			middle = (high + low) / 2; // finds middle of the array by dividing the array in 2
			if (searchKey.equalsIgnoreCase(list[middle].getMake())) {
				return middle; // found it
			}
			else if (searchKey.compareToIgnoreCase(list[middle].getMake()) < 0) {
				high = middle - 1; // high is at the middle less 1
			}
			else {
				low = middle + 1; // low is now at middle plus 1
			}
		}// end while
		// not found
		return -1;
	}
	
	/**
	 * The binary search algorithm using recursion
	 */
	public int binarySearch(String searchKey, String searchModel, int low, int high) {
		// create variable for middle 
		int mid = (low + high)/2 ;
		
		// check if low is less than or equal to the high
		if(low <= high) { 
			
			// check if search keys are equal to middle 
			if(searchKey.equalsIgnoreCase(list[mid].getMake() ) &&
					searchModel.equalsIgnoreCase(list[mid].getModel()) ) {
				return mid; // found it
				
				// else for other cases 
			} else {
				// check if less than 0 
				if ((searchKey.compareToIgnoreCase(list[mid].getMake()) < 0)) {
				high = mid - 1; // change the high into new value 
				return binarySearch(searchKey, searchModel, low, high); // return the recursive 
				// check if key greater than 0 
			} else if ((searchKey.compareToIgnoreCase(list[mid].getMake()) > 0)) {
				low = mid + 1; // change the low into new value 
				return binarySearch(searchKey, searchModel, low, high); // return the recursive 
			} else {
				// create variables for middles 
				int mid1 = binarySearch(searchKey, searchModel, low+1, high); 
				int mid2 = binarySearch(searchKey, searchModel, low, high-1); 

				// check if middle is not -1 
				if(mid1 != -1) {
					return mid1; // return the value 
				} else {
					return mid2; // else return middle 2 
				}
			} 
			}
			// if value not found
		} else { 
			return -1; // return a negative number
		}
	} 
	
	
	/**
	 * Selection sort
	 * Used to set cars from oldest to newest 
	 */
	public void selectionSort() {
		int topOfList;
		int minIdx;
		int i;
		int j;
		
		for(i = 0; i < size; i++) {
			minIdx = i;
			for(j = i; j < size; j++) {
				if(list[j].getYear() < list[minIdx].getYear()) {
					minIdx = j;
				}
			}
			topOfList = list[i].getYear();
			list[i].setYear(list[minIdx].getYear());
			list[minIdx].setYear(topOfList);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// create an object of my list
		VehicleList vehicle = new VehicleList();

		// infinite loop
		while(true) {
			char command;
			command = JOptionPane.showInputDialog(null,
					"i - insert\n" +
							"d - delete\n" +
							"c - change\n" +
							"s - search model\n" +
							"b - binary search \n" +
							"B - binary recursive search \n" +
							"I - insertion sort \n" +
							"y - sort vehicle old to new \n" +
							"v - set list size\n" +				// setting title page for code 
							"q - quit\n" +
							"p - print\n", "i").charAt(0);
			if(command == 'q') { // if 'q' is entered end code
				break; // breaks out of the while loop
			}
			switch(command) { // switch case for commands
			case 'i':{// if 'i' is entered proceed to code inside
				// prompt for record
				String record = JOptionPane.showInputDialog(null, 
						"Enter <make, model, year, type>", "Ford/Mustang GT Premium/2021/p"); // input for vehicle record
				VehicleRecord sInfo = new VehicleRecord(record); // using overloaded constructor to create a VehicleReocrd object
				// test the insert
				if(vehicle.insert(sInfo)) { // if vehicle records entered are not at max list size display user friendly message
					JOptionPane.showMessageDialog(null, "record inserted");
				}
				else { // else vehicle records entered are at max list size display user friendly message
					JOptionPane.showMessageDialog(null, "insert failed");
				}
				break;
			}
			case 'd':{ // if 'd' is entered proceed to code insided
				// prompt for record
				String record = JOptionPane.showInputDialog(null, 
						"Enter <make, model, year, type>", "Ford/Mustang GT Premium/2021/p"); // input for deleting record
				VehicleRecord sInfo = new VehicleRecord();
				sInfo.processRecord(record);
				// test the delete
				if(vehicle.delete(sInfo)) { // if record is found, display user friendly message
					JOptionPane.showMessageDialog(null, "record deleted");
				}
				else { // if record is not found, display user friendly message
					JOptionPane.showMessageDialog(null, "record not found");
				}
				vehicle.insertion();
				break;
			}
			case 'c':{ // if 'c' is entered proceed to code inside
				// prompt for old record
				String oldRecord = JOptionPane.showInputDialog(null, 
						"Enter <make, model, year, type>", "Ford/Mustang GT Premium/2021/p"); // ask user what file to change
				VehicleRecord oldInfo = new VehicleRecord();
				oldInfo.processRecord(oldRecord);

				//prompt for new record
				String newRecord = JOptionPane.showInputDialog(null, 
						"Enter <make, model, year, type>", "Ford/Mustang GT Premium/2021/p"); // let user change the file
				VehicleRecord newInfo = new VehicleRecord();
				newInfo.processRecord(newRecord);

				// test the change
				if(vehicle.change(oldInfo, newInfo)) { // if old record is found and changed display user friendly message
					JOptionPane.showMessageDialog(null, "record changed");
				}
				else { // if old record is not found and changed display user friendly message
					JOptionPane.showMessageDialog(null, "record not found");
				}
				vehicle.insertion();
				break;
			}
			case 'v':{ // if 'v' is entered proceed to code inside
				// variable for increase
				int listSize;
				// ask user for list size
				listSize = Integer.parseInt(JOptionPane.showInputDialog(null, "What would you like the list size to be"));

				vehicle.increaseList(listSize); // set list size
				break;
			}
			case 's' :{
				// prompt for the name to find
				String modelToFind = JOptionPane.showInputDialog(null, "Enter model to find");
				int location = vehicle.linearSearch(modelToFind); // calls the search method
				// check if it was found
				if (location >= 0) {
					JOptionPane.showMessageDialog(null, vehicle.getList()[location].toString());
				}
				else {
					JOptionPane.showMessageDialog(null, "Name not found");
				}
				break;
			}
			case 'b' :{
				// prompt for the name to find
				String makeToFind = JOptionPane.showInputDialog(null, "Enter make to find");
				int location = vehicle.linearSearch(makeToFind); // calls the search method
				// check if it was found
				if (location >= 0) {
					JOptionPane.showMessageDialog(null, vehicle.getList()[location].toString());
				}
				else {
					JOptionPane.showMessageDialog(null, "Make not found");
				}
				break;
			}
			case 'B' :{
				// prompt for the name and model to find
				String makeToFind = JOptionPane.showInputDialog(null, "Enter make to find");
				String modelToFind = JOptionPane.showInputDialog(null, "Enter model to find");
				int location = vehicle.binarySearch(makeToFind, modelToFind, 0, vehicle.size-1); // calls the search method
				// check if it was found
				if (location >= 0) {
					JOptionPane.showMessageDialog(null, vehicle.getList()[location].toString());
				}
				else {
					JOptionPane.showMessageDialog(null, "Make not found");
				}
				break;
			}
			case 'I' :{
				vehicle.insertion();
				break;
			}
			case 'y' :{
				vehicle.selectionSort();
				break;
			}
			case 'p':{ // if 'p' is entered proceed to code inside
				JOptionPane.showMessageDialog(null, vehicle.toString()); // print list
				break;
			}
			}
		}

	}

}
