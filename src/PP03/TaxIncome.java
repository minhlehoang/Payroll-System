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


// 1- this class implements the Taxable interface
public class TaxIncome implements Taxable {

    // default constructor created per rubric
	private double payTax;
	
	public TaxIncome (double payTax) {
		this.payTax = payTax;
	}
	
	// 2- implement all the unimplemented abstract methods in the Taxable Interface, income tax is computed based on state and federal taxes   
	// an abstract method computes the state tax in its implementation by the implementer class
	public double compStateTax (double grossPay){
		return grossPay*STATE_TAX;
	} 
	
	// an abstract method computes the federal tax in its implementation by the implementer class
	public double compFederalTax(double grossPay){
		return grossPay*FEDERAL_TAX;
	}
	
	// an abstract method computes the income tax based on the state and federal taxes in its implementation by the implementer class
	public double compIncomeTax(double grossPay){
		payTax = compStateTax(grossPay)+compFederalTax(grossPay);
		return payTax;
	}

}
