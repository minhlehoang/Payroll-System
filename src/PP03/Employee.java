package PP03;

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


//1- The Employee class extends superclass Person
public class Employee extends Person{
	
	private int eID;
    private Status empStatus;
    private Employee[] employees;
   
    
    // 2- add the subclass Employee constructor that calls the super Person class constructor, you should provide input data for all parent class data fields
	public Employee(String fName, String lName, Address address, Status empStatus, int eID) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.empStatus = empStatus;
		this.eID = eID;
	}
    
	// 3- add setters/getters methods
	public int geteID() {
		return eID;
	}

	public void seteID(int eID) {
		this.eID = eID;
	}

	public Status getEmpStatus() {
		return empStatus;
	}

	public void setEmpStatus(Status empStatus) {
		this.empStatus = empStatus;
	}

	
	
	// 4- add override toString() method that overrides toString() in the superclass Person
	@Override
	public String toString() {
		return "Employee [eID=" + eID + ", empStatus=" + empStatus + "]";
	}
	

	
}
