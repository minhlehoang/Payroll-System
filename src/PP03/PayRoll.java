package PP03;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;



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
	static PayRecord[] payRecords;
	
	private static double totalNetPay;
	private static double avgNetPay;
	
	
	
	public PayRoll(String fileName, int n){
		
		this.fileName = fileName;
        this.payRecords = new PayRecord[n];
        
		//numberOfRecords++; as we run the program and take the user input for the number of record at the beginning, this variable is always 1
		
	}
	
	
   public void readFromFile() throws ParseException{	
	   int emp_id;
	   String firstname;
	   String lastname;
	   String status_str;	   
	   int housenumber;
	   String street;
	   String city;
	   String state;
	   int zipcode;
	   
	   int payid;
	   int recid;
	   Date startday;
	   Date endday;
	   double payHours = 0;
	   double payRate = 0;
	   double monthlyIncome = 0;
	   int numMonths = 0;
	   
	   Status status = null;
	   
	   
		// read the initial data from PayRoll file to create the full
	   // pay records with gross pay, taxes, and net pay, and then store it in PayRecord.txt file
	  	String output = "";
		JFileChooser fileChooser = new JFileChooser();
		if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			// Get the selected file
			java.io.File file = fileChooser.getSelectedFile();
			// Create a Scanner for the file
			Scanner input = null;
			try {
				input = new Scanner(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int i = 0;
			
			// Read text from the file
			while (input.hasNext()) {
				String line = input.nextLine();
				String[] data = line.split(",");
				if(data[0].trim().equals("employee")) {
					emp_id = Integer.parseInt(data[1].trim());
					firstname = data[2].trim();
					lastname = data[3].trim();
					status_str = data[4].trim();
					if(status_str.equals("FULLTIME")) {
						status = Status.FullTime;
					}
					else {
						status = Status.Hourly;
					}
					street = data[5].trim();
					housenumber = Integer.parseInt(data[6].trim());
					city = data[7].trim();
					state = data[8].trim();
					zipcode = Integer.parseInt(data[9].trim());
					createEmployee(street, housenumber, city, state, zipcode, status, firstname, lastname, emp_id);
					//JOptionPane.showMessageDialog(null, emp_id + firstname +lastname + status + street + housenumber + city + state + zipcode);
				}
				else if(data[0].trim().equals("payRecord")){						
					payid = Integer.parseInt(data[1].trim());
					emp_id = Integer.parseInt(data[2].trim());
					if(data[3].trim().contains("<m>")) {						
						monthlyIncome = Double.parseDouble(data[3].trim().substring(0, data[3].trim().indexOf("<")));
						status = Status.FullTime;
						payHours = 0;						
					}
					if(data[3].trim().contains("<h>")) {
						payHours = Double.parseDouble(data[3].trim().substring(0, data[3].trim().indexOf("<")));
						status = Status.Hourly;
						monthlyIncome = 0;
					}
					
					if(data[4].trim().contains("<n>")) {
						numMonths = Integer.parseInt(data[4].trim().substring(0, data[4].trim().indexOf("<")));
						status = Status.FullTime;
						payRate = 0;
					}
					if(data[4].trim().contains("<r>")) {
						payRate = Double.parseDouble(data[4].trim().substring(0, data[4].trim().indexOf("<")));
						status = Status.Hourly;
						numMonths = 0;
					}
					
					recid = Integer.parseInt(data[5].trim());
					
					startday = new SimpleDateFormat("MM/dd/yyyy").parse(data[6].trim());
					endday = new SimpleDateFormat("MM/dd/yyyy").parse(data[7].trim());
					for(int z = 0; z < Employee.numberOfEmployees; z++) {
						if(Integer.parseInt(data[2].trim()) == Employee.employees[z].geteID()) {
							createPayRecord(payid, startday, endday, recid, payHours, payRate, monthlyIncome, numMonths, Employee.employees[z], status);
							
							output += Employee.employees[z].toString() + "\n" + payRecords[z].toString() + "\n" + "Total Net Pay: " + String.format("%.2f", totalNetPay()) + "\n" + "Average Net Pay: " + String.format("%.2f", avgNetPay()) + "\n" + "\n";
							try {
								File file_output = new File("outputfile.txt");
								FileWriter fileWriter = new FileWriter(file_output);
								fileWriter.write(output);
								fileWriter.flush();
								fileWriter.close();
								
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
			input.close(); // Close the file
			JOptionPane.showMessageDialog(null, PayRecord.numberOfPayRecord + " employee pay records have been created.");
	    }
	    else {
	        JOptionPane.showMessageDialog(null,"No file selected");
	    }
	} 
   
   
   public void writeToFile(){
		
		// write employees' pay records to the PayRecord.txt file, it should add employee pay record to the current file data


		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			File file = new File("outputfile.txt");

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			// true = append file
			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);
			bw.write(Employee.employees[Employee.numberOfEmployees-1].toString());
			bw.write("\n");
			bw.write(payRecords[PayRecord.numberOfPayRecord - 1].toString() + "\n" + "Total Net Pay: " + String.format("%.2f", totalNetPay()) + "\n" + "Average Net Pay: " + String.format("%.2f", avgNetPay()) + "\n");
			bw.write("\n");

			//System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}

	
	} 
   
	public void createEmployee(String street, int houseNumber, String city, String state, int zipCode, Status status, String firstName, String lastName, int eID){
		// creates a new Employee object and add it to the employees array, you need to pass parameters to this method
		Employee employee1 = new Employee(firstName, lastName, new Address(street, houseNumber, city, state, zipCode), status, eID);
		Employee.employees [Employee.getNumberOfEmployees()-1] = employee1;
	}
	
 
	public void createPayRecord(int pID, Date pStartDate, Date pEndDate, int rid, double payHours, double payRate, double monthlyIncome, int numMonths, Employee employee, Status status){
		
		// creates a new PayRecord for an Employee object and add it to  the payRecords array, you need to pass parameters to this method
		
			if(status == Status.FullTime) {
				payRecords[PayRecord.numberOfPayRecord] = new PayRecord(rid, employee, new PayPeriod(pID, pStartDate, pEndDate), monthlyIncome, numMonths);
			}
			
			
			if(status == Status.Hourly)  {
				payRecords[PayRecord.numberOfPayRecord] = new PayRecord(rid, employee, new PayPeriod(pID, pStartDate, pEndDate), payHours, payRate);
			}
			
	}
	
	
    public void displayPayRecord(JTextArea textAreaStats){
		// it shows all payroll records for all currently added employee and the total net pay and average net pay in the GUI text area
    	// at should append data to text area, it must not overwrite data in the GUI text area
    	
    	
    	String result = payRecords[PayRecord.numberOfPayRecord - 1].toString() + "\n" + "Total Net Pay: " + String.format("%.2f", totalNetPay()) + "\n" + "Average Net Pay: " + String.format("%.2f", avgNetPay()) + "\n";
    	
		//String stats = "Number of Employees: " + Employee.numberOfEmployees + "\r\nNumber of Pay Records: "+ PayRecord.numberOfPayRecord +"\r\nAverage Net Pay: " + avgNetPay() +"\r\nTotal Net Pay: " + totalNetPay();
     	//textAreaStats.setText(stats);
    	textAreaStats.append(result);
	
	}

    
   public double avgNetPay(){
	   double sum = 0;
	   for(int i=0; i < PayRecord.getNumberOfPayRecord(); i++) {
		   sum += payRecords[i].netPay();
	   }
	   avgNetPay = sum/PayRecord.getNumberOfPayRecord();
	   return avgNetPay;
	}
   
   
   public double totalNetPay() {
	   double total = 0;
	   for(int i=0; i < PayRecord.getNumberOfPayRecord(); i++) {
		   total += payRecords[i].netPay();
	   }
	   totalNetPay = total;
	   return totalNetPay;
   }

   
public PayRecord[] getPayRecords() {
	return payRecords;
}


public static double getAvgNetPay() {
	return avgNetPay;
}


public static double getTotalNetPay() {
	return totalNetPay;
}


}
