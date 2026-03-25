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
		if (this.exponent == 0) {
			return this.coefficient + "";
		}
		if (this.exponent == 1) {
			return this.coefficient + "x";
		}
		
		return this.coefficient + "^" + this.exponent;
	}
}