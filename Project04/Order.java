/**
 * ULID: <krhurdl>
 * Class: IT 168 
 */
package edu.ilstu;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.List;

/**
 * The Order class keeps track of gadgets, order number,
 * the list of gadgets for said order, and date the order
 * was completed. 
 * It also displays part or all of the order and allows the
 * order to get updated as it is processed. 
 */
public class Order {
	private int gadgets;
	private int orderNumber;
	private List<Gadget> theOrder;
	private LocalDate orderDate;//when the order can be fulfilled
	private static int uniqueId;
	
	/**
	 * Constructor for Order class that takes in gadgets 
	 * and current date. 
	 * Sets the order number to a unique ID and the list
	 * of gadgets called theOrder to null.
	 * 
	 * @param gadgets amount that the order requires
	 * @param date that the order was created
	 */
	public Order(int gadgets, LocalDate date) {
		uniqueId ++;
		this.orderDate = date;
		this.gadgets = gadgets;
		this.orderNumber = uniqueId;
		this.theOrder = null;
	}
	
	/**
	 * Returns the amount of gadgets required for order.
	 * 
	 * @return the amount of gadgets required for order
	 */
	public int getGadgets() {
		return this.gadgets;
	}
	
	/**
	 * Returns the date the order was fulfilled.
	 * 
	 * @return the date the order was fulfilled
	 */
	public LocalDate getDate() {
		return this.orderDate;
	}
	
	/**
	 * Allows for the date to be set to a new date
	 * if order was completed on a day other than 
	 * when it was made. 
	 * 
	 * @param date the order was fulfilled
	 */
	public void setDate(LocalDate date) {
		this.orderDate = date;
	}
	
	/**
	 * Fulfills the order by taking in the list of gadgets given to 
	 * fulfill the order and setting theOrder to that. 
	 * 
	 * @param theOrder list of gadgets that were given to fulfill the order
	 */
	public void fulfillOrder(List<Gadget> theOrder) {
		this.theOrder = theOrder;
	}
	
	/**
	 * Returns a string of the order number and gadgets ordered labeled.
	 * @return a string of the order number and gadgets ordered labeled.
	 */
	public String getOrder() {
		return "Order number:  " + orderNumber + "    gadgets ordered:  " + gadgets;
	}
	
	/**
	 * Returns a string with information about the order including all gadgets and order 
	 * total cost. 
	 * 
	 * @return Information about the order including all gadgets and order total cost.
	 */
	public String toString() {
		DecimalFormat format = new DecimalFormat("$####0.00");
		
		String output = "";
		
		// adds all gadgets info
		for (int i = 0; i < theOrder.size(); i++) {
			output += "                    " + theOrder.get(i) + "\n";
		}
		//adds order info
		output += "                    Order number:" + orderNumber;
		if (orderNumber < 10) {
			output += "      ";
		} 
		else if (orderNumber < 100){
			output += "     ";
		}
		else {
			output += "    ";
		}
		output += "Order total:   " +  format.format(calcPrice());
		
		return output;
	}
	
	/**
	 * Calculates the total price of this order by adding up the price of each
	 * gadget in the order. 
	 * 
	 * @return total price of this order
	 */
	public double calcPrice() { 
		final double TAXES = .08;
		double costTotal = 0;
		
		for (int i = 0; i < theOrder.size(); i++) {
			costTotal += theOrder.get(i).getPrice();
		}
		
		costTotal += costTotal*TAXES;
		
		return costTotal;
	}
}
