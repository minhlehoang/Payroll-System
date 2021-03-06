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



public class PayRecord {
	
	private int rID;
    private Employee employee;
    private PayPeriod payPeriod;
    private TaxIncome payTax;
    
    private double payHours;
    private double payRate;
    
    private double montlyIncome;
    private int numMonths;
    
       
    
    public static final int REG_HOURS = 40;
    public static final double OT_RATE = 1.25;
    
    public static int numberOfPayRecord=0;
    
    // pay record constructor for hourly employee
    public PayRecord(int id, Employee e, PayPeriod period, double hours, double rate){
    	
    	this.rID = id;
    	this.employee = e;
    	this.payPeriod = period;
    	this.payHours = hours;
    	this.payRate = rate;
    	this.montlyIncome = 0;
    	this.numMonths = 0;
    	this.payTax = new TaxIncome(grossPay());
    	numberOfPayRecord++;
  
    }
    
    // pay record constructor for full time employee
    public PayRecord(int id, Employee e, PayPeriod period, double mIncome, int mNum){
 	
    	this.rID = id;
    	this.employee = e;
    	this.payPeriod = period;
    	this.payHours = 0;
    	this.payRate = 0;
    	this.montlyIncome = mIncome;
    	this.numMonths = mNum;
    	this.payTax = new TaxIncome(grossPay());
    	numberOfPayRecord++;

    }

  // 3- complete the code in the following methods: grossPay() and netPay()
    
    // complete the code to compute the gross pay for the employee based on the employee status
	public double grossPay(){
		Double wage;
		if (payHours<40) {
			wage = payHours * payRate;
		} 
		else{ 
			wage = (REG_HOURS*payRate) + (payHours-REG_HOURS)*(payRate*OT_RATE);
		}
		return (montlyIncome*numMonths)+wage;
	}
    
  // complete the code in this method to compute the net pay of the employee after taxes (state and federal)
     public double netPay(){
    	 return grossPay() - payTax.compIncomeTax(grossPay());
  }
     
     
     // 1- add setters and getters methods

	public int getrID() {
		return rID;
	}

	public void setrID(int rID) {
		this.rID = rID;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public PayPeriod getPayPeriod() {
		return payPeriod;
	}

	public void setPayPeriod(PayPeriod payPeriod) {
		this.payPeriod = payPeriod;
	}

	public TaxIncome getPayTax() {
		return payTax;
	}

	public void setPayTax(TaxIncome payTax) {
		this.payTax = payTax;
	}

	public double getPayHours() {
		return payHours;
	}

	public void setPayHours(double payHours) {
		this.payHours = payHours;
	}

	public double getPayRate() {
		return payRate;
	}

	public void setPayRate(double payRate) {
		this.payRate = payRate;
	}

	public double getMontlyIncome() {
		return montlyIncome;
	}

	public void setMontlyIncome(double montlyIncome) {
		this.montlyIncome = montlyIncome;
	}

	public int getNumMonths() {
		return numMonths;
	}

	public void setNumMonths(int numMonths) {
		this.numMonths = numMonths;
	}

	public static int getRegHours() {
		return REG_HOURS;
	}

	public static double getOtRate() {
		return OT_RATE;
	}
	
	  public static int getNumberOfPayRecord() {
		return numberOfPayRecord;
	}

	// 2- add override method toString()
	@Override
	public String toString() {
		return "PayRecord [rID= " + rID + ", " + payPeriod + ", Hours Worked= " + payHours + ", Hourly Rate= " + payRate + ", Monthly Income= " + montlyIncome + ", Number of Months= "
				+ numMonths + ", Gross Pay= "+ grossPay() + ", Net Pay= " + netPay() +"]";
	}
}