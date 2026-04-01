/**
 * ULID: <krhurdl>
 * Class: IT 168 
 */
package edu.ilstu;

/**
 * A class to keep track of a term that 
 * has both a coefficient and exponent 
 * and display the term.
 */
public class Term {
	private int coefficient;
	private int exponent;
	
	/**
	 * Constructor for term needing both the
	 * terms coefficient and exponent
	 * @param coefficient of the term
	 * @param exponent of the term
	 */
	public Term(int coe, int exp) {
		this.coefficient = coe;
		this.exponent = exp;
	}
	
	/**
	 * Returns the coefficient of the term
	 * @return coefficient of the term
	 */
	public int getCoe() {
		return this.coefficient;
	}
	
	/**
	 * Returns the exponent of the term
	 * @return exponent of the term
	 */
	public int getExp() {
		return this.exponent;
	}
	
	/**
	 * Returns a string of what the term visually looks like.
	 * If the coefficient is 0, an empty string is returned. If
	 * the exponent is 0, just the coefficient is returned. If 
	 * the coefficient is equal to 1 or -1, the 1 is not shown as
	 * part of term. Otherwise, the term is build to be coefficient + 
	 * "x^" + exponent. 
	 * @return string of what term should look like
	 */
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
	
	/**
	 * Sets the coefficant to a new given value
	 * @param coefficant you want to replace old coefficant with
	 */
	public void setCoe(int coe) {
		this.coefficient = coe;
	}
}
