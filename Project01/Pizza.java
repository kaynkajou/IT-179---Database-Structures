/**
 * ULID: <krhurdl>
 * Class: IT 168 
 */
package edu.ilstu;

/**
 * Pizza class that stores and returns pizza's toppings, price, sauce, size and if there is extra cheese
 */
public abstract class Pizza implements PizzaInterface {
	private String[] toppings;
	private double price;
	private boolean extraCheese;
	private String sauce;
	private String size;
	
	/**
	 * Constructor for a pizza that takes in toppings, price, extra cheese, sauce, and 
	 * size of the pizza but NOT the name or specific type of crust
	 * @param array of toppings on top of pizza
	 * @param total price of pizza
	 * @param if there is extra cheese (true if yes)
	 * @param sauce on the pizza
	 * @param size of the pizza
	 * @param name of the pizza
	 */
	public Pizza(String[] toppings, double price, boolean extraCheese, String sauce, String size) {
		this.toppings = new String[toppings.length];
		for (int i = 0; i < toppings.length; i++) {
			this.toppings[i] = toppings[i];
		}
		this.price = price;
		this.extraCheese = extraCheese;
		this.sauce = sauce;
		this.size = size;
	}
	
	/**
	 * Returns an array of toppings on the pizza 
	 * @return an array of pizza toppings
	 */
	public String[] getToppings() {
		return this.toppings;
	}

	/**
	 * Sets whether or not extra cheese is added (true for adding extra)
	 * @set whether or not extra cheese is added to pizza
	 */
	public boolean extraCheese() {
		return this.extraCheese;
	}

	/**
	 * Returns the name of the type pizza sauce used
	 * @return name of the type of pizza sauce
	 */
	public String getSauce() {
		return this.sauce;
	}

	/**
	 * Returns the price the pizza costs to purchase
	 * @return price of pizza
	 */
	public double getPrice() {
		return this.price;
	}

	/**
	 * Returns the size of the pizza (L or XL)
	 * @return size of pizza
	 */
	public String getSize() {
		return this.size;
	}
	
	
	/**
	 * Sets an array of pizza toppings
	 * @sets an array of pizza toppings
	 */
	public void setTopping(String[] toppings) {
		this.toppings = toppings;
	}
	
	/**
	 * Sets the price of the pizza
	 * @set price of pizza
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * Sets whether or not extra cheese is added (true for adding extra)
	 * @set whether or not extra cheese is added to pizza
	 */
	public void setExtraCheese(boolean extraCheese) {
		this.extraCheese = extraCheese;
	}
	
	/**
	 * Sets the name of the type of sauce to be used on the pizza
	 * @set name of the type of sauce
	 */
	public void setSauce(String sauce) {
		this.sauce = sauce;
	}
	
	/**
	 * Sets the size of the pizza (L or XL)
	 * @set size of the pizza 
	 */
	public void setSize(String size) {
		this.size = size;
	}
}
