/**
 * ULID: <krhurdl>
 * Class: IT 168 
 */
package edu.ilstu;

import java.text.DecimalFormat;

/**
 * An extension of pizza to make the pizza specifically pan. 
 * Stores pan pizza information and has a toString to organize the
 * information.
 * 
 * @author Kayla-Ann Hurdle
 * 
 */
public class Pan extends Pizza {
	private String name;
	
	/**
	 *  Constructor that takes in everything that may be on the hand-tossed pizza
	 * @param array of toppings on top of pizza
	 * @param total price of pizza
	 * @param if there is extra cheese (true if yes)
	 * @param sauce on the pizza
	 * @param size of the pizza
	 * @param name of the pizza
	 */
	public Pan(String[] toppings, double price, boolean extraCheese, String sauce, String size, String name) {
		super(toppings, price, extraCheese, sauce, size);
		this.name = name;
	}
	
	/**
	 * Returns all the information of the hand-tossed pizza in an organized manor
	 * @return returns all the information of the hand-tossed pizza
	 */
	public String toString() {
		DecimalFormat formatter = new DecimalFormat("$#,##0.00");
		String[] toppings = super.getToppings();
		String allToppings = "";
		String pizzaInformation = "";
		
		pizzaInformation += this.name + "/" + getSize() + "/pan/";
		
		if (extraCheese()) {
			pizzaInformation += "extra-cheese/";
		}
		pizzaInformation += getSauce() + "\t\t\t";
		
		for (int i = 0; i < toppings.length -1; i++) {
			if (toppings[i] != null) {
				allToppings += toppings[i] + ",";
			}
		}
		if (toppings.length != 0) {//checks that there are toppings
			allToppings += toppings[toppings.length-1];//adds last topping w/o comma
		}
		
		pizzaInformation += allToppings + "\n" + formatter.format(getPrice());
		
		return  pizzaInformation;
	}
}

