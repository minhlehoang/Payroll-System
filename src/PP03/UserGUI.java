package PP03;

import java.util.Date;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;


import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;


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

public class UserGUI extends JFrame implements ActionListener{
	
	//static PayRecord[] recordArray;
	
	PayRoll payroll_rec;
	
	static int k = 0; //number of user attempts
	static boolean success = false; // attempt status marker
	static int ATTEMPTS = 2; // number of allowed attempts
	
	static int n = 0;
	
	// declare all GUI components below
	  private JLabel empPanelLabel;
	  private JLabel addressPanelLabel;
	  private JLabel eidLabel;
	  private JLabel fnLabel;
	  private JLabel lnLabel;
	  private JLabel houseLabel;
	  private JLabel streetLabel;
	  private JLabel cityLabel;
	  private JLabel stateLabel;
	  private JLabel zipLabel;
	  
	  private JLabel payPeriodPanelLabel;
	  private JLabel payPeriodIDLabel;
	  private JLabel payPeriodStartLabel;
	  private JLabel payPeriodEndLabel;
	  
	  private JLabel payRecordPanelLabel;
	  private JLabel payRecordIDLabel;
	  private JLabel monthlyIncomeLabel;
	  private JLabel monthNumberLabel;
	  private JLabel hoursLabel;
	  private JLabel hoursRateLabel;
	  
	  private JLabel textAreaLabel;
	  private JLabel empStatusLabel;
	  
	  private JTextField eidField;
	  private JTextField fnField;
	  private JTextField lnField;
	  private JTextField houseField;
	  private JTextField streetField;
	  private JTextField cityField;
	  private JTextField stateField;
	  private JTextField zipField;
	  	  
	  private JTextField payPeriodIDField;
	  private JTextField payPeriodStartField;
	  private JTextField payPeriodEndField;
	  
	  private JTextField payRecordIDField;
	  private JTextField monthlyIncomeField;
	  private JTextField monthNumberField;
	  private JTextField hoursField;
	  private JTextField hoursRateField;
	  
	  
	  

	  private JButton addEmpButton;
	  private JButton addPayRecButton;
	  private JButton exitButton;
	  
	  private JTextArea textArea;
	  private JScrollPane jp;
	  
	  private JRadioButton radFull;
	  private JRadioButton radHourly;
	  
	
	  
	  // declare and initialize variables
	  int eid = 0;
	  String firstName =""; // first name
	  String lastName = ""; // last name
	  int	houseNumber = 0;
	  String street = "";
	  String city = "";
	  String state = "";
	  int zipCode = 0;
	  int payPeriodID =0;
	  Date payPeriodStart;
	  Date payPeriodEnd;
	  int payRecordID = 0;
	  double monthlyIncome= 0;
	  int numberOfMonths = 0;
	  double numberOfHours = 0;
	  double hourlyRate= 0;
	  Status status;

				// constructor
				UserGUI(int localNumberOfPersons){
					payroll_rec = new PayRoll("PayRoll.txt", localNumberOfPersons);
					
					// create person array of size nPersons
					//personArray = new Person[localNumberOfPersons];
					
					//Initialize the components
					initComponenet();

					//Organize the GUI components
					doTheLayout();
					
					//Add the action listeners GUI buttons(add, sort, and display)
					
					addEmpButton.addActionListener(this);
					addPayRecButton.addActionListener(this);
					exitButton.addActionListener(this);
					radFull.addActionListener(this);
					radHourly.addActionListener(this);
							       		
					
				}//End of constructor

				private void initComponenet(){
				
					  // labels
					  empPanelLabel = new JLabel ("Employee:",JLabel.LEADING);
					  eidLabel = new JLabel ("Employee ID:",JLabel.RIGHT);
					  fnLabel = new JLabel ("First Name:",JLabel.RIGHT);
					  lnLabel = new JLabel ("Last Name:",JLabel.RIGHT);
					  
					  addressPanelLabel = new JLabel ("Employee Address:",JLabel.LEADING);
					  houseLabel = new JLabel ("House Number:",JLabel.RIGHT);
					  streetLabel = new JLabel ("Street:",JLabel.RIGHT);
					  cityLabel = new JLabel ("City:",JLabel.RIGHT);
					  stateLabel = new JLabel ("State:",JLabel.RIGHT);
					  zipLabel = new JLabel ("Zip Code:",JLabel.RIGHT);
					  
					  payPeriodPanelLabel= new JLabel ("Pay Period:",JLabel.LEFT);
					  payPeriodIDLabel = new JLabel ("Pay Period ID:",JLabel.RIGHT);
					  payPeriodStartLabel = new JLabel ("Start Date (MM/dd/yyyy):",JLabel.RIGHT);
					  payPeriodEndLabel = new JLabel ("End Date (MM/dd/yyyy):",JLabel.RIGHT);
					  					  
					  payRecordPanelLabel= new JLabel ("Pay Record:",JLabel.LEFT);
					  payRecordIDLabel = new JLabel ("Pay Record ID:",JLabel.RIGHT);
					  monthlyIncomeLabel = new JLabel ("Monthly Income:",JLabel.RIGHT);
					  monthNumberLabel = new JLabel ("Number of Months:",JLabel.RIGHT);
					  hoursLabel = new JLabel ("Hours Worked:",JLabel.RIGHT);
					  hoursRateLabel = new JLabel ("Pay Rate:",JLabel.RIGHT);
					  					  
					  empStatusLabel = new JLabel ("Employee Status:",JLabel.RIGHT);
					  textAreaLabel = new JLabel ("Current Employee Record:", JLabel.LEFT);
					  
					  
					  
					  // text fields
					  eidField = new JTextField ("");
					  fnField = new JTextField ("");
					  lnField = new JTextField ("");
					  houseField = new JTextField ("");
					  streetField = new JTextField ("");
					  cityField = new JTextField ("");
					  stateField = new JTextField ("");
					  zipField = new JTextField ("");
					  					  
					  payPeriodIDField = new JTextField("");
					  payPeriodStartField = new JTextField("");
					  payPeriodEndField = new JTextField("");
					  
					  payRecordIDField = new JTextField("");
					  monthlyIncomeField = new JTextField("");
					  monthNumberField = new JTextField("");
					  hoursField = new JTextField("");
					  hoursField.setVisible(false);
					  hoursRateField = new JTextField("");
					  hoursRateField.setVisible(false);
					  
					  
					  // radio buttons
					  radFull = new JRadioButton("FULLTIME", true);
					  radHourly= new JRadioButton("HOURLY");
				      ButtonGroup group = new ButtonGroup();
				      group.add(radFull);
				      group.add(radHourly);
				      
				      
				      
				      
		
					  // text area and scroll pane
				      textArea = new JTextArea(5, 40);
				      textArea.setEditable(false);
				      textArea.setLineWrap(false);
				      textArea.setWrapStyleWord(false);
				      jp = new JScrollPane(textArea);
				      jp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				      jp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
				      
					  
				      
				      
				      // buttons
				      addEmpButton = new JButton("Add Employee");
				      addPayRecButton = new JButton("Add Pay Record");
				      exitButton = new JButton("Exit Program");
			      			  
				}

			   private void doTheLayout(){
				   
				   // make panels
				   JPanel top = new JPanel();
				   JPanel center = new JPanel();
				   JPanel bottom = new JPanel();
				   setLayout( new BorderLayout());
				   add(top, "North");
				   add(center, "Center");
				   add(bottom, "South");
	
				   JPanel empPanel = new JPanel();
				   JPanel addressPanel = new JPanel();
				   JPanel payPeriodPanel = new JPanel();
				   JPanel payRecordPanel = new JPanel();
				   JPanel empStatusPanel = new JPanel();
				   
				   
				   
				   		   
				   
				   // top panel (employee)
				   top.setLayout(new FlowLayout());
				   top.add(empPanel);
				   top.add(addressPanel);
				   top.add(empStatusPanel);
				   top.add(addEmpButton);
				   
				   // employee panel
				   empPanel.setLayout(new GridLayout(0,2,5,5));
				   empPanel.add(eidLabel);
				   empPanel.add(eidField);
				   empPanel.add(fnLabel);
				   empPanel.add(fnField);
				   empPanel.add(lnLabel);
				   empPanel.add(lnField);
				   
				   
				   // address panel
				   addressPanel.setLayout(new GridLayout(0,2,5,5));
				   addressPanel.add(houseLabel);
				   addressPanel.add(houseField);
				   addressPanel.add(streetLabel);
				   addressPanel.add(streetField);
				   addressPanel.add(cityLabel);
				   addressPanel.add(cityField);
				   addressPanel.add(stateLabel);
				   addressPanel.add(stateField);
				   addressPanel.add(zipLabel);
				   addressPanel.add(zipField);	 
				   
				   // employee status panel
				   empStatusPanel.setLayout(new GridLayout(3,1));
				   empStatusPanel.add(empStatusLabel);
				   empStatusPanel.add(radFull);
				   empStatusPanel.add(radHourly);

	   				   
				   			   

				   // center panel (pay)
				   center.setLayout(new FlowLayout());
				   center.add(payPeriodPanel);
				   center.add(payRecordPanel);
				   center.add(addPayRecButton);
				   
				   // pay period panel
				   payPeriodPanel.setLayout(new GridLayout(0,2,5,5));
				   payPeriodPanel.add(payPeriodIDLabel);
				   payPeriodPanel.add(payPeriodIDField);
				   payPeriodPanel.add(payPeriodStartLabel);
				   payPeriodPanel.add(payPeriodStartField);
				   payPeriodPanel.add(payPeriodEndLabel);
				   payPeriodPanel.add(payPeriodEndField);
  
				   // pay record panel
				   payRecordPanel.setLayout(new GridLayout(0,2,5,5));
				   payRecordPanel.add(payRecordIDLabel);
				   payRecordPanel.add(payRecordIDField);
				   payRecordPanel.add(monthlyIncomeLabel);
				   payRecordPanel.add(monthlyIncomeField);
				   payRecordPanel.add(monthNumberLabel);
				   payRecordPanel.add(monthNumberField);
				   payRecordPanel.add(hoursLabel);
				   payRecordPanel.add(hoursField);
				   payRecordPanel.add(hoursRateLabel);
				   payRecordPanel.add(hoursRateField);

				   
				   
				   
				   // bottom panel (output with text area)
				   bottom.setLayout( new FlowLayout());
				   bottom.add(textAreaLabel);
				   bottom.add(jp);
				   bottom.add(exitButton);
				   
				}

				
				@Override
				public void actionPerformed(ActionEvent e) {
					// Call the required button action method according to the action event
					if (e.getSource()==addEmpButton)
						addEmpButtonClicked();
					else if (e.getSource()==addPayRecButton)
						addPayRecButtonClicked();
					else if (e.getSource()==exitButton)
						exitButtonClicked();
				
				
				if (radFull.isSelected()) {
					status = Status.FullTime;
					monthlyIncomeField.setVisible(true);
					monthNumberField.setVisible(true);
					hoursField.setVisible(false);
					hoursRateField.setVisible(false);
				}

				
				else if (radHourly.isSelected()) {
					status = Status.Hourly;
					monthlyIncomeField.setVisible(false);
					monthNumberField.setVisible(false);
					hoursField.setVisible(true);
					hoursRateField.setVisible(true);
				}
					
				}

				
								
				private void addEmpButtonClicked(){
					
					//Method to implement add button action
					if(Employee.getNumberOfEmployees()<n){
						try {
							eid = Integer.parseInt((eidField.getText().trim()));
						}
						catch(Exception ex) {
							JOptionPane.showMessageDialog(fnField, "Invalid entry for employee ID.");
							eidField.setText("");
							eidField.requestFocus();
							return;
						}
						
						try {
						firstName = fnField.getText().trim();
						if (firstName.length()==0) throw new Exception();

						} catch (Exception e) {
							JOptionPane.showMessageDialog(fnField, "Invalid entry for first name.");
							fnField.setText("");
							fnField.requestFocus();
							return;
						}
						
						
						
						
						try {
						lastName = lnField.getText().trim();
						if (lastName.length()==0) throw new Exception();

						} catch (Exception e) {
							JOptionPane.showMessageDialog(lnField, "Invalid entry for last name.");
							lnField.setText("");
							lnField.requestFocus();
							return;
						}
						
						
						
						
						
						try {
						String houseNumberS = houseField.getText().trim();
						houseNumber = Integer.parseInt(houseNumberS);
						if (houseNumber<=0) throw new Exception();

						} catch (Exception e) {
							JOptionPane.showMessageDialog(fnField, "Invalid entry for house number.");
							houseField.setText("");
							houseField.requestFocus();
							return;
						}
						
						
						try {
						street = streetField.getText().trim();
						if (street.length()==0) throw new Exception();

						} catch (Exception e) {
							JOptionPane.showMessageDialog(fnField, "Invalid entry for street.");
							streetField.setText("");
							streetField.requestFocus();
							return;
						}
						
						try {
						city = cityField.getText().trim();
						if (city.length()==0) throw new Exception();
						
						} catch (Exception e) {
							JOptionPane.showMessageDialog(fnField, "Invalid entry for city.");
							cityField.setText("");
							cityField.requestFocus();
							return;
						}
						
						
						try {
						state = stateField.getText().trim();
						if (state.length()==0) throw new Exception();

						} catch (Exception e) {
							JOptionPane.showMessageDialog(fnField, "Invalid entry for state.");
							stateField.setText("");
							stateField.requestFocus();
							return;
						}
						
						try {
						String zipS = zipField.getText().trim();
						zipCode = Integer.parseInt(zipS);
						if (zipCode<0) throw new Exception();

						} catch (Exception e) {
							JOptionPane.showMessageDialog(fnField, "Invalid entry for zip code.\r\nZip code must be five digits.");
							zipField.setText("");
							zipField.requestFocus();
							return;
						}
						
						if (radFull.isSelected()) {
							status = Status.FullTime;
						}
						else {
							status = Status.Hourly;
						}
						
				     	// add employee object
				     	//Address address1 = new Address(street, houseNumber, city, state, zipCode); // address object
						//Employee employee1 = new Employee(firstName, lastName, address1, status, eid);
				     	payroll_rec.createEmployee(street, houseNumber, city, state, zipCode, status, firstName, lastName, eid);
						// show added person
						String message = "The following employee was added:\r\n";
						textArea.setText(message);
				     	textArea.append(Employee.employees[Employee.numberOfEmployees-1].toString());

				     	
				     	// freeze employee fields
				     	eidField.setEditable(false);
				     	fnField.setEditable(false);
						lnField.setEditable(false);
						houseField.setEditable(false);
						streetField.setEditable(false);
						cityField.setEditable(false);
						stateField.setEditable(false);
						zipField.setEditable(false);
				     	radFull.setEnabled(false);
				     	radHourly.setEnabled(false);
				     	addEmpButton.setEnabled(false);
				     	
				     	
						}
					
					else {JOptionPane.showMessageDialog(null, "Array limit.\r\nNo more employees can be entered.");}
				
					
				
				} //end employee add method
				
				

						
				private void addPayRecButtonClicked() {
					
					
					//Method to implement add button action
					
					
					if(PayRecord.getNumberOfPayRecord() <Employee.getNumberOfEmployees()){
						
						try {
						String payPeriodIDs = payPeriodIDField.getText().trim();
						payPeriodID = Integer.parseInt(payPeriodIDs);
						if (payPeriodID<=0) throw new Exception();

						} catch (Exception e) {
							JOptionPane.showMessageDialog(payPeriodIDField, "Invalid entry for pay period ID.");
							payPeriodIDField.setText("");
							payPeriodIDField.requestFocus();
							return;
						}
						
						

						try {
						payPeriodStart = new SimpleDateFormat("MM/dd/yyyy").parse(payPeriodStartField.getText());
						
						

						} catch (Exception e) {
							JOptionPane.showMessageDialog(payPeriodStartField, "Invalid entry for start date.");
							payPeriodStartField.setText("");
							payPeriodStartField.requestFocus();
							return;
						}
						
						
						
						
						try {
							payPeriodEnd = new SimpleDateFormat("MM/dd/yyyy").parse(payPeriodEndField.getText());
						

						} catch (Exception e) {
							JOptionPane.showMessageDialog(payPeriodEndField, "Invalid entry for end date.");
							payPeriodEndField.setText("");
							payPeriodEndField.requestFocus();
							return;
						}
						
						

					
						try {
						String payRecordIDs = payRecordIDField.getText().trim();
						payRecordID = Integer.parseInt(payRecordIDs);
						if (payRecordID<=0) throw new Exception();

						} catch (Exception e) {
							JOptionPane.showMessageDialog(payRecordIDField, "Invalid entry for pay record ID.");
							payRecordIDField.setText("");
							payRecordIDField.requestFocus();
							return;
						}
						
						
						
						if (radFull.isSelected()) {
						try {
							if (radHourly.isSelected()==true) {
								monthlyIncome =0;
							}
						String monthlyIncomeS = monthlyIncomeField.getText().trim();
						monthlyIncome = Integer.parseInt(monthlyIncomeS);
						
						if (monthlyIncome<0) throw new Exception();

						} catch (Exception e) {
							JOptionPane.showMessageDialog(monthlyIncomeField, "Invalid entry for monthly income.");
							monthlyIncomeField.setText("");
							monthlyIncomeField.requestFocus();
							return;
						}
						} else {monthlyIncome=0;}
						
						
						if (radFull.isSelected()) {
						try {
							if (radHourly.isSelected()==true) {
								numberOfMonths =0;
							}
						String numberOfMonthsS = monthNumberField.getText().trim();
						numberOfMonths = Integer.parseInt(numberOfMonthsS);
						
						if (numberOfMonths<0) throw new Exception();

						} catch (Exception e) {
							JOptionPane.showMessageDialog(monthNumberField, "Invalid entry for number of months.");
							monthNumberField.setText("");
							monthNumberField.requestFocus();
							return;
						}} else {numberOfMonths=0;}
						
						
						
						if (radHourly.isSelected()) {
						try {
						String numberOfHoursS = hoursField.getText().trim();
						numberOfHours = Integer.parseInt(numberOfHoursS);
						
						if (numberOfHours<0) throw new Exception();

						} catch (Exception e) {
							JOptionPane.showMessageDialog(hoursField, "Invalid entry for hours worked.");
							hoursField.setText("");
							hoursField.requestFocus();
							return;
						} 
						} else {numberOfHours = 0;}
						
						
						
						if (radHourly.isSelected()) {
						try {							
						String hourlyRateS = hoursRateField.getText().trim();
						hourlyRate = Integer.parseInt(hourlyRateS);
						
						if (hourlyRate<0) throw new Exception();

						} catch (Exception e) {
							JOptionPane.showMessageDialog(hoursRateField, "Invalid entry for hourly rate.");
							hoursRateField.setText("");
							hoursRateField.requestFocus();
							return;
						}
						} else {hourlyRate = 0;}
						
						
						
				     	if (radFull.isSelected()==true){
				     		String monthlyIncomeS = monthlyIncomeField.getText().trim();
				     		monthlyIncome = Double.parseDouble(monthlyIncomeS);
							String numberOfMonthsS = monthNumberField.getText().trim();
							numberOfMonths = Integer.parseInt(numberOfMonthsS);
				
				     	}

						if (radHourly.isSelected()==true){
							String hoursFieldS = hoursField.getText().trim();
							numberOfHours = Double.parseDouble(hoursFieldS);
							String hoursRateFieldS = hoursRateField.getText().trim();
							hourlyRate= Double.parseDouble(hoursRateFieldS);

						}
						

						
						

						
						// add pay record
						payroll_rec.createPayRecord(payPeriodID, payPeriodStart, payPeriodEnd, payRecordID, numberOfHours, hourlyRate, monthlyIncome, numberOfMonths, Employee.employees[Employee.numberOfEmployees-1], status);
							
								
								
						String message = "The following pay record has been added to Employee ID "+this.eid+":\r\n";
				     	textArea.setText(message);
				     	textArea.append(PayRoll.payRecords[PayRecord.numberOfPayRecord-1].toString());

	
				     	// reset employee fields
						eidField.setText("");
				     	fnField.setText("");
						lnField.setText("");
						houseField.setText("");
						streetField.setText("");
						cityField.setText("");
						stateField.setText("");
						zipField.setText("");
						
						// reset pay record fields
						payPeriodIDField.setText("");
						payPeriodStartField.setText("");
						payPeriodEndField.setText("");
						payRecordIDField.setText("");
						monthlyIncomeField.setText("");
						monthNumberField.setText("");
						hoursField.setText("");
						hoursRateField.setText("");
						
						// reset employee fields
				     	eidField.setEditable(true);
				     	fnField.setEditable(true);
						lnField.setEditable(true);
						houseField.setEditable(true);
						streetField.setEditable(true);
						cityField.setEditable(true);
						stateField.setEditable(true);
						zipField.setEditable(true);
				     	radFull.setEnabled(true);
				     	radHourly.setEnabled(true);
				     	addEmpButton.setEnabled(true);
						
					} else { JOptionPane.showMessageDialog(null, "Please enter new employee first.");
						
					}
  	
				} // end pay record add method
				
				
				
				
				private void exitButtonClicked() {
					// Method to implement system exit upon click
					String happy ="";

			     	for (int w = 0; w <PayRecord.getNumberOfPayRecord(); w++) 
			     	happy += Employee.employees[w] +""+ PayRoll.payRecords[w]+"\r\n"; 
			     	JOptionPane.showMessageDialog(null, happy);
					System.exit(0);
					
				} // end exit button
				
				

				
						
			public static void main(String[] args) throws FileNotFoundException {
						
				// input number of records
				k = 0;
				success = false;
				while (success != true^k==ATTEMPTS) 
				
				
					
				try {
				String nS = JOptionPane.showInputDialog(null,"How many records?  Please enter a whole number.");
				n = Integer.parseInt(nS);
				if (n<=0) throw new Exception();
				success = true;
				
				} catch (Exception q1) {
					k++;
					JOptionPane.showMessageDialog(null, "Invalid entry.\r\nPlease enter a whole number.\r\nYou have "+(ATTEMPTS-k)+" attempt(s) left.");
					if (k==ATTEMPTS) {System.exit(0);}
				}

				// create a new GUI
				UserGUI frame = new UserGUI(n);
				// Initialize employee array
				Employee.employees = new Employee[n];
				
				//personArray = new Person[localNumberOfPersons];
				
				// set GUI frame settings
				frame.pack();
			    frame.setLocationRelativeTo(null); 
			    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    frame.setVisible(true);
			    
			    
			 
			
			}// end main
			
	
	} // end main class
