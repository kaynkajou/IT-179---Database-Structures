/**
 * ULID: <krhurdl>
 * Class: IT 168 
 */
package edu.ilstu;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

/**
 * Driver class that simulates 100 days of the Gadget Factory Store.
 * It keeps tracks of the date. Produces 2 batches a day(5 gadgets 
 * each). Takes new orders and save orders that can not be completed
 * immediately. Also simulates the 20% customers return orders. 
 */
public class GadgetFactoryStore {
	
	public static void main(String[] args) {
		Random rand = new Random();
		LocalDate currDate = LocalDate.of(2026, 4, 1);
		Queue<Order> orders = new ArrayDeque<>();
		Deque<Order> fulfilledOrders = new ArrayDeque<>();
		Deque<List<Gadget>> gadgets = new ArrayDeque<>();
		int monthlyMaterialPrice = 12;
		int gadgetsTotal = 0;
		final int TOTAL_DAYS = 100;
		final int TOTAL_BATCHES = 2;
		final int BATCH_SIZE = 5;
		boolean isFull = false;
		//monthly report variables
		double totalSales = 0;
		double prevMonthProfit = 0;
		int gadgetsSold = 0, returned = 0;
		
		System.out.println("\t\t\t\tWelcome to the Gadget Factory Store Simulation System ");
		
		// to loop through each day
		for (int o = 0; o < TOTAL_DAYS; o ++) {
			// 1. Displays today's date
			System.out.println("Date: " + currDate);
			
			// 2. produces two batches of gadgets and push them onto a Gadget stack 
			for (int i = 0; i < TOTAL_BATCHES; i++) {
				gadgets.push(makeBatch(monthlyMaterialPrice, BATCH_SIZE));
				gadgetsTotal += BATCH_SIZE;
			}
			System.out.println("gadgets in stock: " + gadgetsTotal +"\n");
			int prevTotal = gadgetsTotal;//stores gadgets at start of day
			
			// 3. Take a new order
			if (!isFull) {
				Order newOrder = createOrder(currDate);
				int gadgetsRequired = newOrder.getGadgets();
				
				// checks how many gadgets are needed and then processes the order based on if there is enough
				if (gadgetsRequired > gadgetsTotal) {
					// 5. If not, save the order to an Order queue such that it will be processed in the future when there are
					// enough gadgets.
					System.out.println("\nNot enough gadgets for the order, saving it for future deliveries.\n");
					orders.offer(newOrder);
				}
				else {
					// 4. If the order can be fulfilled now, process the order by removing the exact number of gadgets from
					// the stack required by the order and then displaying the billing information.
					System.out.println("\nProcessing the New order...");
					processOrder(newOrder, gadgets, fulfilledOrders, currDate);
					totalSales += newOrder.calcPrice();
					gadgetsTotal -= gadgetsRequired;
					gadgetsSold += gadgetsRequired;
					System.out.println("Delivering the following gadgets:\n" + newOrder + "\n");
				}
			}
			
			// 6. Checks if the first order in the queue can be fulfilled. If yes, the program should process the order 
			// and then remove it from the queue. Keeps running until the first order cannot be fulfilled,  or there are no more orders.
			while (orders.peek() != null) {
				if (orders.peek().getGadgets() <= gadgetsTotal) {
					Order currOrder = orders.poll();
					int gadgetsRequired = currOrder.getGadgets();
					
					System.out.println("\nProcessing the old order: ");
					processOrder(currOrder, gadgets, fulfilledOrders, currDate);
					totalSales += currOrder.calcPrice();
					gadgetsTotal -= gadgetsRequired;
					gadgetsSold += gadgetsRequired;
					System.out.println("Delivering the following gadgets:\n" + currOrder + "\n");
				}
				else {
					if (isFull) {
						System.out.println("Next order to process:");
						System.out.println("                    " + orders.peek().getOrder() + "\n\n");
					}
					// if can not fulfill the first order end loop
					break;
				}
				}
			

			// 9. Display the number of gadgets in stock.
			if (prevTotal != gadgetsTotal) {
				System.out.println("Gadgets in stock: " + gadgetsTotal + "\n");
			}
			
			// Checks to see if more orders should be taken the next day
			if (orders.peek() == null) {
				if (isFull) {
					System.out.println("Start taking new orders next day.\n");
				}
				isFull = false;
			}
			else if (orders.size() == 3 && !isFull) {
				isFull = true;
				System.out.println("Stop taking new orders, waiting to process the order:");
				System.out.println("                    " + orders.peek().getOrder() + "\n");
			}
			
			
			// 7. Simulates 20% of chance that a previously fulfilled order will be returned. 
			Order returnedOrder = returnOrder(currDate, fulfilledOrders);
			if (returnedOrder != null) {
				int returnedMonth = returnedOrder.getDate().getMonthValue();
				int currMonth = currDate.getMonthValue();
				
				returned += returnedOrder.getGadgets();
				gadgetsSold -= returnedOrder.getGadgets();
				if (returnedMonth == currMonth) {
					totalSales -= returnedOrder.calcPrice();
				}
				else {
					prevMonthProfit = adjustLastMonthProfit(prevMonthProfit, returnedOrder);
				}
				
			}
			
			// 8. Prints out summary of the current month’s profit information at the end of each
			// month. Resets variables for the next month.
			int currDay = currDate.getDayOfMonth();
			int lastDay = currDate.lengthOfMonth();
			if (currDay ==  lastDay) {
				prevMonthProfit = monthlyReport(totalSales, gadgetsSold, returned, monthlyMaterialPrice);
				totalSales = 0;
				gadgetsSold = 0;
				returned = 0;
				monthlyMaterialPrice = rand.nextInt(10,16);
			}
			
			// 10. proceed to the next day
			currDate = currDate.plusDays(1);
			System.out.println();
		}
	}
	
	/**
	 * Creates a batch of gadgets the size of the batch size 
	 * in a list using the material price to create each
	 * gadget.
	 * 
	 * @param materialPrice for the current month
	 * @param batchSize - amount of gadgets per batch
	 * @return batch of gadgets stored in a list
	 */
	public static List<Gadget> makeBatch(int materialPrice, int batchSize) {
		List<Gadget> batch = new LinkedList<>();
		
		// creates 5 gadgets to add to the batch
		for (int i = 0; i < batchSize; i++) {
			Gadget newGadget = new Gadget(materialPrice);
			batch.add(newGadget);
		}
		
		return batch;
	}
	
	/**
	 * Generates a new order by generating a random
	 * number 1 to 30 to assign the gadgets required 
	 * for this order. Then displays the new order.
	 * 
	 * @param currentDate the order was made
	 * @return the new order created
	 */
	public static Order createOrder(LocalDate currDate) {
		Random rand = new Random();
		
		int amount = rand.nextInt(30) + 1;
		Order newOrder = new Order(amount, currDate);
		System.out.println("New order: \n                    " + newOrder.getOrder());
		
		return newOrder;
	}
	
	/**
	 * Takes out first gadget batch. Removes gadgets from batch
	 * till batch is empty. Then grabs next batch is needed. 
	 * Repeats until order has enough gadgets. If a batch was
	 * not entirely empty, it pushes it back onto gadgets.
	 * Finally, order is fulfilled and added to fulfilled
	 * orders.
	 * 
	 * @param order that is to be processed
	 * @param gadgets that are available to be given to order
	 * @param fulfilledOrders stack to add the order to when finished being processed
	 * @param currentDate the order is being processed
	 */
	public static void processOrder(Order order, Deque<List<Gadget>> gadgets, Deque<Order> fulfilledOrders, LocalDate currDate) {
		List<Gadget> batch = gadgets.pop();
		List<Gadget> orderedGadgets = new LinkedList<>();
		
		//adds each individual gadget from a batch to list till reached gadget amount ordered
		for(int i =0; i < order.getGadgets(); i++) {
			orderedGadgets.add(batch.remove(0));
			
			if (batch.size() == 0 && gadgets.size() != 0) {
					batch = gadgets.pop();
			}
		}
		
		//returns batch to stack if not all gadgets were used
		if(batch.size() != 0) {
			gadgets.push(batch);
		}
		
		order.fulfillOrder(orderedGadgets);
		order.setDate(currDate);
		fulfilledOrders.push(order);
	}
	
	/**
	 * Calculates profit using (total_sales_this_month – total_return_this_month)/1.08 –
	 * (total_number_of_gadgets_sold_this_month – total_number_of_gadgets_returned_this_month) *
     * material_price_this_month. 
     * Then displays the monthly report showing total sales, gadgets sold, gadgets returned,
     * and profit made. 
     * Returns the profit made that month.
	 * 
	 * @param totalSales made throughout the month
	 * @param gadgetsSold throughout the month
	 * @param returned gadgets through the month
	 * @param materialPrice for the month
	 * @return the profit made that month
	 */
	public static double monthlyReport(double totalSales, int gadgetsSold, int returned, int materialPrice) {
		//
		double profit = (totalSales - returned)/1.08 - (gadgetsSold - returned)*materialPrice;
		DecimalFormat format = new DecimalFormat("$####0.00");
		
		System.out.println("Monthly Profit Report:\n"
				          + "                     Total sales:" + format.format(totalSales)
				          + "       gadgets sold:" + gadgetsSold 
				          + "           Returned:" + returned 
				          + "             Profit:" + format.format(profit) + "\n");
		
		return profit;
	}
	
	/**
	 * Returns an previously completed order from the fulfilled orders stack.
	 * It compares the current date with date old order was completed to make sure
	 * returning order is not older than 3 days to comply with companies policy.
	 * If order can not be returned because it goes against policy or there are no orders 
	 * to be returned, it returns null.
	 * Otherwise, it displays returning order and returns the order that was returned.
	 * 
	 * @param the current date 
	 * @param fulfilledOrders stack to take old orders from
	 * @return order that was returned, if order could not be return, returns null
	 */
	public static Order returnOrder(LocalDate date, Deque<Order> fulfilledOrders) {
		Random rand = new Random();
		final int returnNumber = 3;
		int currDay = date.getDayOfYear();
		int chance = rand.nextInt(5) + 1;
		
		if (fulfilledOrders.size() != 0 && returnNumber == chance) {
			Order returned = fulfilledOrders.pop();
			int returnDay = returned.getDate().getDayOfYear();
			int ageByDays = currDay - returnDay;
			
			
			if (ageByDays < 4 ) {
				System.out.println("Returning order:\nOrder Date: " + returned.getDate()
					+ "\n                    " + returned.getOrder() + "\n");//TODO change date to order date originally completed
				return returned;
			}
		}
		//if no order could be returned, return null
		return null;
	}
	
	/**
	 * Calculations the adjusted profit by taking the original
	 * previous month's profits and subtracting the money made
	 * from the returned order. 
	 * Displays the profit before and after.
	 * Returns adjusted profit. 
	 * 
	 * @param previous profit from the month before
	 * @param returned order from the month before
	 * @return the adjusted profit as a result of the returning order
	 */
	public static double adjustLastMonthProfit(double prevProfit, Order returnedOrder) {
		DecimalFormat format = new DecimalFormat("$####0.00");
		double adjustedProfit = prevProfit - returnedOrder.calcPrice();
		
		System.out.println("             Last month's profit:" + format.format(prevProfit) + "    Adjusted profit:" + format.format(adjustedProfit));
		
		return adjustedProfit;
	}
	 
}
