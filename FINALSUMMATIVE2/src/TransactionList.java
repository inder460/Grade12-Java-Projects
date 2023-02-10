import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Inder Sodhi(did everything except file read/write), Bilal Faheem(did file read/write)
 * Date: Jan 2022
 * Description: 
 * Method List: public TransactionList() - default constructor 
 * 				public TransactionRecord[] getList() - 
 * 				public int getSize() - get size 
 * 				public boolean insert(TransactionRecord record) - insert method 
 * 				public String toString() - to string method 
 * 				public boolean delete(TransactionRecord record) - delete method 
 * 				public void bubbleSort() - bubble sort method 
 * 				public static String readTextFile(String filename) throws IOException - Method to read file
 *				public static void inputTextFile(String filename, String list) throws IOException - Method to input a list into a file
 *				public static void main(String[] args) throws IOException - self testing main
 *
 */
public class TransactionList {

	/**
	 * Instance data
	 */
	private TransactionRecord list[];
	private int size; // usable size at any point

	/**
	 * Default Constructor 
	 */
	public TransactionList() {
		this.size = 0;
		this.list = new TransactionRecord[40];
	}

	/*
	 * Method 
	 */
	public TransactionRecord[] getList() {
		return list;
	}

	/*
	 * Method to get size 
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Method to insert a record in the list
	 */
	public boolean insert(TransactionRecord record) {
		size++;
		list[size-1] = record;
		return true;
	}
	
	/**
	 * create a toString method
	 */
	public String toString() {
		String theList = "";
		for(int i = 0; i < this.getSize(); i++) {
			// add a record to the output variable
			theList += "Record " + i + ": " + list[i].toString() + "\n";
		}
		return theList;
	}

	/**
	 * Method to "delete" a record from the list.
	 * Cheats by replacing the record to be deleted
	 * with the last record on the list.
	 * Then decreases the actual valid size
	 */
	public boolean delete(TransactionRecord record) {
		// loop through the valid list
		for(int i = 0; i < this.getSize(); i++) {
			// check if the record is in the list
			if(this.list[i].getTransactionAmnt() == (record.getTransactionAmnt())) {
				this.list[i] = this.list[this.getSize() - 1]; // put the last record where the deleted record was before it was deleted
				size--;  // decreases the valid size
				return true;
			}
		}
		return false; // record not found
	}

	/**
	 * Bubble sort method 
	 * Sorts the names in alpha order
	 */
	public void bubbleSort() {
		// loop through the array for as many elements as are valid
		for(int i = 0; i < size - 1; i++) {
			// loops to control the comparisons - 
			// It leaves the ones sorted without comparing them
			for(int j = 0; j < size - i - 1; j++) {
				// compare the side by side elements and swap
				if(list[j].getEndBalance() > (list[j+1].getEndBalance())) {
					// out of sequence and swap
					TransactionRecord temp; // a temporary studentRecord
					// swap
					temp = list[j];
					list[j] = list[j+1];
					list[j+1] = temp;
				}// end if

			}// end j loop
		}// ends i loop
	}
	
	/*
	 * Method to read file
	 */
	public static String readTextFile(String filename) throws IOException { 
		
		// open file for reading
		FileReader fr = new FileReader(filename); 
		BufferedReader input = new BufferedReader(fr); 
		int counter = 0; // INIT counter
		
		// loop to check until the line is not null
		while (input.readLine() != null) {
			counter ++; // add to the counter
		}
		
		// close the file 
		input.close();
		
		// open the file again for reading
		fr = new FileReader(filename);
		input = new BufferedReader(fr);
		
		// set the size to the counter 
		int size = counter;
	
		// declare variables to store contents of the text file
		String data = "";
		String dataArray [] = new String [size];
		
		// now read from the text file into the string array
		for(int i = 0; i < size-1; i++) {
			dataArray [i] = input.readLine(); // read the lines 
			data += "Transaction " + dataArray[i] + "\n";   // create the number of the transaction 
		}
		
		input.close(); // close the text file
		return data; // return the string
	}
	
	/*
	 * Method to input a list into a file 
	 */
	public static void inputTextFile(String filename, String list) throws IOException { 
		
		// write to the file 
		FileWriter fileW = new FileWriter(filename);
		PrintWriter output = new PrintWriter (fileW);
		
		// output to the list 
		output.println(list);
		
		// close the file
		fileW.close(); 
	}
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// create an object of my list
		TransactionList transaction = new TransactionList();

		// infinite loop
		while(true) {
			char command;
			command = JOptionPane.showInputDialog(null,
					"i - insert\n" +
							"d - delete\n" +
							"p - print\n" +
							"s - bubble sort\n" + 
							"f - file", "i").charAt(0);
			switch(command) {
			case 'i':{// insert
				// prompt for record
				String record = JOptionPane.showInputDialog(null, 
						"Enter <accountType,transactionType,transactionAmount,startBalance,endBalance>"
						, "s,withdrawal,5,100,95");
				TransactionRecord sInfo = new TransactionRecord();
				sInfo.processRecord(record);
				// test the insert
				if(transaction.insert(sInfo)) {
					JOptionPane.showMessageDialog(null, "record inserted");
				}
				else {
					JOptionPane.showMessageDialog(null, "insert failed");
				}
				break;
			}
			case 'd':{
				// prompt for record
				String record = JOptionPane.showInputDialog(null, 
						"Enter <accountType,transactionType,transactionAmount,startBalance,endBalance>"
						, "s,withdrawal,5,100,95");
				TransactionRecord sInfo = new TransactionRecord();
				sInfo.processRecord(record);
				// test the delete
				if(transaction.delete(sInfo)) {
					JOptionPane.showMessageDialog(null, "record deleted");
				}
				else {
					JOptionPane.showMessageDialog(null, "record not found");
				}
				break;
			}
			case 's' :{
				// sorts end balance in order
				transaction.bubbleSort();
				JOptionPane.showMessageDialog(null, "Records Sorted");
				break;
			}
			case 'p':{
				JOptionPane.showMessageDialog(null, transaction.toString());
				break;
			}
			case 'f' : { 
				String name = JOptionPane.showInputDialog(null, "Enter the file name"); 

				inputTextFile(name, transaction.toString()); 
				System.out.println(readTextFile(name));
			}
			}
		}

	}

}