/**
 * 
 */
package edu.ilstu;

import java.util.Random;

/**
 * 
 */
public class Gadget {
	private int price;
	private int id;
	private static int uniqueId;
	
	public Gadget(int materialPrice) {
		Random rand = new Random();
		this.uniqueId ++;
		this.price = materialPrice + (rand.nextInt(5) + 1);
		this.id = this.uniqueId;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	public String toString() {
		String output = "Gadget ID:" + id;
		if(id < 10) {
			output += "         Price:$";
		}
		else if (id < 100) {
			output += "        Price:$";
		}
		else if (id < 1000) {
			output += "       Price:$";
		}
		else {
			output += "      Price:$";
		}
		output += price;
		
		return output;
	}

}
