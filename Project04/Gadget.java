/**
 * ULID: <krhurdl>
 * Class: IT 168 
 */
package edu.ilstu;

import java.util.Random;

/**
 * The Gadget class is responsible for keeping track of the price
 * and ID. It also can return information about gadget formated.
 */
public class Gadget {
	private int price;
	private int id;
	private static int uniqueId;
	
	/**
	 * Constructor for Gadget. Takes in material price and sets the
	 * price to equal material price plus a random number 1 to 5 inclusive.
	 * Assigns the gadget a unique ID. 
	 * 
	 * @param materialPrice for the month
	 */
	public Gadget(int materialPrice) {
		Random rand = new Random();
		this.uniqueId ++;
		this.price = materialPrice + (rand.nextInt(5,11));
		this.id = uniqueId;
	}
	
	/**
	 * Returns the price of the gadget.
	 * 
	 * @return the price of the gadget
	 */
	public int getPrice() {
		return this.price;
	}
	
	/**
	 * Returns a string of information about the gadget including it's ID and price
	 * while making sure spacing is consistent between all gadgets. 
	 * 
	 * @returns information about the gadget including it's ID and price
	 */
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
