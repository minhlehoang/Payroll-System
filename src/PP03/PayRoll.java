package PP03;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

//****************************************
//
//			CIS 611	
//			Spring 2018		
//			
//			Minh Le and Andy Carlson
//
//			PP03
//
//			GUIs
//			
//			April 2, 2018
//	
//			Saved in LeCarlsonPP03.zip
//
//****************************************



public class PayRoll {
	
	private String fileName;
	private PayRecord[] payRecords;
	private static int numberOfRecords = 0;
	
	private  double totalNetPay;
	private  double avgNetPay;
	
	public PayRoll(String fileName, int n){
		
		this.fileName = fileName;
        this.payRecords = new PayRecord[n];
        
		numberOfRecords++;
		
	}
	
	
   public void readFromFile(){
		
		// read the initial data from PayRoll file to create the full 
	   // pay records with gross pay, taxes, and net pay, and then store it in PayRecord.txt file
		
	} 
   
   
   public void writeToFile(){
		
		// write employees' pay records to the PayRecord.txt file, it should add employee pay record to the current file data
		
	} 
   
	public void createEmployee(String street, int houseNumber, String city, String state, int zipCode, Status status, String firstName, String lastName, int eID){
		// creates a new Employee object and add it to the employees array, you need to pass parameters to this method

		Employee employee1 = new Employee(firstName, lastName, new Address(street, houseNumber, city, state, zipCode), status, eID);

		

		
	}
	
 
	public void createPayRecord(){
		
		// creates a new PayRecord for an Employee object and add it to  the payRecords array, you need to pass parameters to this method
		
	}
	
	
    public  void displayPayRecord(){
		
		// it shows all payroll records for all currently added employee and the total net pay and average net pay in the GUI text area
    	// at should append data to text area, it must not overwrite data in the GUI text area
		
	}

    
   public double avgNetPay(){
		
		  	// returns the average of the total net pay of all added employees
	   
	   return 0;
		
	}


public static int getNumberofrecords() {
	return numberOfRecords;
}


public PayRecord[] getPayRecords() {
	return payRecords;
}
    	

}
