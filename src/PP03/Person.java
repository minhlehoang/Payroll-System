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

public class Person {
	
	protected String fName ;
    protected String lName ;
    protected Address address;
    
    public static int numberOfPersons=0;
    
    public Person(){
    	
    }
    
	public Person(String fName, String lName, Address address) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		numberOfPersons++;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAdsress(Address address) {
		this.address = address;
	}

	public static int getNumberOfPersons() {
		return numberOfPersons;
	}

	public static void setNumberOfPersons(int numberOfPersons) {
		Person.numberOfPersons = numberOfPersons;
	}

	@Override
	public String toString() {
		return "Person [fName=" + fName + ", lName=" + lName + ", address=" + address + "]";
	}
}
