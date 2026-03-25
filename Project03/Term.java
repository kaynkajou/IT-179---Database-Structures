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
		
		// adds coefficient to output  
		// if exponent is not 0, add an x behind coefficant(do not show coefficant if it is equal to 1)
		if (this.exponent != 0) {
			if (this.coefficient == 1) {
				output = "x";
			}
			else {
				output = this.coefficient + "x";
			}
		}
		else {
			return this.coefficient + "";
		}
		
		// adds exponent to output
		// if exponent is not 0 or 1, add ^ and exponent
		if (this.exponent != 0 && this.exponent != 1) {
			output += "^" + this.exponent;
		}
		
		return output;
	}
}
