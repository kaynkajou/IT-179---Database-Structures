package edu.ilstu;

public class Term {
	private int coefficient;
	private int exponent;
	
	public Term(int coe, int exp) {
		this.coefficient = coe;
		this.exponent = exp;
	}
	
	public int getCoe() {
		return this.coefficient;
	}
	
	public int getExp() {
		return this.exponent;
	}
	
	public String toString() {
		String output = "";
		
		if (this.coefficient != 0) {//if coefficient is zero, skip and return an empty string
			// adds coefficient to output  
			// if exponent is not 0, add an x behind coefficant(do not show coefficant if it is equal to 1 OR -1)
			if (this.exponent != 0) {
				if (this.coefficient == 1) {
					output += "x";
				}
				else if (this.coefficient == -1) {
					output += "-x";
				}
				else {
					output += this.coefficient + "x";
				}
				
				// adds exponent to output
				// if exponent is not 0 or 1, add ^ and exponent
				if (this.exponent != 1) {
					output += "^" + this.exponent;
				}
			}
			else {
				output += this.coefficient + "";
			}
			
			
		}
		
		return output;
	}

	public void setCoe(int coe) {
		this.coefficient = coe;
	}
}
