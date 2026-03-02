/**
 * ULID: <krhurdl>
 * Class: IT 168 
 */
package edu.ilstu;

/**
 * An interface for a pizza including all the methods a pizza would need
 * 
 * @author Kayla-Ann Hurdle
 */
public interface PizzaInterface {
	
	/**
	 * Returns an array of toppings on the pizza 
	 * @return an array of pizza toppings
	 */
	String[] getToppings();
	
	/**
	 * Sets whether or not extra cheese is added (true for adding extra)
	 * @set whether or not extra cheese is added to pizza
	 */
	boolean extraCheese();
	
	/**
	 * Returns the name of the type pizza sauce used
	 * @return name of the type of pizza sauce
	 */
	String getSauce();
	
	/**
	 * Returns the price the pizza costs to purchase
	 * @return price of pizza
	 */
	double getPrice();
	
	/**
	 * Returns the size of the pizza (L or XL)
	 * @return size of pizza
	 */
	String getSize();
}
