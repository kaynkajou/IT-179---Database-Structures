/**
 * 
 */
package edu.ilstu;

import java.time.LocalDate;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

/**
 * 
 */
public class GadgetFactoryStore {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Random rand = new Random();
		LocalDate currDate = LocalDate.of(2026, 4, 1);
		Queue<Order> orders = new ArrayDeque<>();
		Deque<List<Gadget>> gadgets = new ArrayDeque<>();
		int monthlyMaterialPrice = rand.nextInt(5) + 11;
		int gadgetsTotal = 0;
		final int returnNumber = 3;
		boolean isFull = false;
		
		System.out.println("\t\t\t\tWelcome to the Gadget Factory Store Simulation System ");
		
		// to loop through each day
		for (int o = 0; o < 10; o ++) {
			// 1. Displays today's date
			System.out.println("Date: " + currDate);
			
			// 2. produces two batches of gadgets and push them onto a Gadget stack 
			gadgets.push(makeBatch(monthlyMaterialPrice));
			gadgets.push(makeBatch(monthlyMaterialPrice));
			gadgetsTotal += 10;
			System.out.println("gadgets in stock: " + gadgetsTotal);
			
			// 3. Take a new order
			//if (!isFull) {
				Order newOrder = createOrder(currDate);
				int gadgetsRequired = newOrder.getGadgets();
				// checks how many gadgets are needed and then processes the order based on if there is enough
				if (gadgetsRequired > gadgetsTotal) {
					// 5. If not, save the order to an Order queue such that it will be processed in the future when there are
					// enough gadgets.
					System.out.println("\nNot enough gadgets for the order, saving it for furture deliveries.\n");
					orders.offer(newOrder);
				}
				else {
					// 4. If the order can be fulfilled now, process the order by removing the exact number of gadgets from
					// the stack required by the order and then displaying the billing information.
					System.out.println("Processing the New order...");
					processOrder(newOrder, gadgets);
					gadgetsTotal -= gadgetsRequired;
					System.out.println("Delivering the following gadgets:\n" + newOrder);
					
				}
			//}
			
			// 6. After step 4 or 5, the program should also check if the first order in the queue can be fulfilled. If
			// yes, the program should process the order and then remove it from the queue. This process should
			// keep running until the first order in the queue cannot be fulfilled, or there are no more orders in the
			// queue.
			while (orders.peek() != null) {
				if (orders.peek().getGadgets() <= gadgetsTotal) {
					Order currOrder = orders.poll();
					gadgetsRequired = currOrder.getGadgets();
					
					System.out.println("Processing the old order...");
					processOrder(currOrder, gadgets);
					gadgetsTotal -= gadgetsRequired;
					System.out.println("Delivering the following gadgets:\n" + currOrder);
				}
				else {
					// if can not fulfill the first order end loop
					break;
				}
			}
			
			if (orders.peek() == null) {
				isFull = false;
			}
			else if (orders.size() == 3) {
				isFull = true;
			}
			
			// 7. Each day, there is 20% of chance that a previously fulfilled order will be returned. See the detailed
			// information about the store’s return policy below. To simulate the 20% of chance, you may use a
			// Random object to generate a random integer in between [1,5] and check to see if it matches a
			// predetermined lucky number
			int chance = rand.nextInt(5) + 1;
			if (returnNumber == chance) {
				
			}
			
			// 8. The program prints out a summary of the current month’s profit information at the end of each
			// month. Notice that this part requires the display of the number of gadgets sold and returned. The
			// first number includes the second number. For instance, if the number of gadgets sold is 293 and the
			// number of gadgets returned is 69, the real number of gadgets sold is: 293 – 69 = 224.
			//monthlyMaterialPrice = rand.nextInt(5) + 11;//TODO: make this monthly NOT daily
			
			// 9. Display the number of gadgets in stock.
			System.out.println("Gadgets in stock: " + gadgetsTotal);//TODO: should only appear if gadgets decrease
			
			// 10. proceed to the next day
			currDate = currDate.plusDays(1);
			System.out.println();
		}
	}
	
	public static List<Gadget> makeBatch(int materialPrice) {
		List<Gadget> batch = new LinkedList<>();
		
		// creates 5 gadgets to add to the batch
		for (int i = 0; i < 5; i++) {
			Gadget newGadget = new Gadget(materialPrice);
			batch.add(newGadget);
		}
		
		return batch;
	}
	
	public static Order createOrder(LocalDate currDate) {
		Random rand = new Random();
		
		int amount = rand.nextInt(30) + 1;
		Order newOrder = new Order(amount, currDate);
		System.out.println("\nNew order: \n                    " + newOrder.getOrder());
		
		return newOrder;
	}
	
	public static void processOrder(Order order, Deque<List<Gadget>> gadgets) {
		List<Gadget> batch = gadgets.pop();
		List<Gadget> orderedGadgets = new LinkedList<>();
		
		//adds each individual gadget from a batch to list till reached gadget amount ordered
		for(int i =0; i < order.getGadgets(); i++) {
			orderedGadgets.add(batch.remove(0));
			
			if (batch.size() == 0) {
				if (gadgets.size() != 0) {
					batch = gadgets.pop();
				}
			}
		}
		
		//returns batch to stack if not all gadgets were used
		if(batch.size() != 0) {
			gadgets.push(batch);
		}
		
		order.fulfillOrder(orderedGadgets);
	}
	
}
