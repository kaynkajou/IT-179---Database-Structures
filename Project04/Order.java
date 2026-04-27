/**
 * 
 */
package edu.ilstu;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.List;

/**
 * 
 */
public class Order {
	private int gadgets;
	private int orderNumber;
	private List<Gadget> theOrder;
	private LocalDate orderDate;//when the order can be fulfilled
	private static int uniqueId;
	
	public Order(int gadgets, LocalDate date) {
		uniqueId ++;
		this.orderDate = date;
		this.gadgets = gadgets;
		this.orderNumber = uniqueId;
		this.theOrder = null;
	}
	
	public int getGadgets() {
		return this.gadgets;
	}
	
	public LocalDate getDate() {
		return this.orderDate;
	}
	
	public void setDate(LocalDate date) {
		this.orderDate = date;
	}
	
	public void fulfillOrder(List<Gadget> theOrder) {
		this.theOrder = theOrder;
	}
	
	public String getOrder() {
		return "Order number: " + orderNumber + "    gadgets ordered: " + gadgets;
	}
	
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
