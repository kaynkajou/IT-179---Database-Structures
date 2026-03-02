/**
 *
 * ULID: <krhurdl>
 * Class: IT 168 
 */
package edu.ilstu;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * A pizza store simulator for ISU where at most 3 pizzas can be ordered and 1 special 
 * pizza per meal. While keeping track of order, it also totals cost of each pizza 
 * and returns a summary with pizza's bought so far along with cost.
 * 
 * @author Kayla-Ann Hurdle
 * 
 */
public class StoreSimulator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//variables to keep track of order progress
		boolean isSpecialBought = false; 
		int choice1 =0, choice2 =0;
		int totalBought =0;
		
		//Special pizzas
		Pizza[] special = readDeals();
		
		//Normal pizzas
		Pizza[] bought = new Pizza[3];
		
		//Opening statement
		System.out.println("\t\t\tWelcome to the ISU Pizza Store");
		
		while (choice1 != 3 && totalBought < 3) {
			//gets choice 
			if (isSpecialBought) {
				printOptions(2);
				choice1 = getChoice(2);
				choice1 ++; // to even out choice with options
			}
			else {
				printOptions(3);
				choice1 = getChoice(3);
			}
			
			if (choice1 == 1) {
				isSpecialBought = true;
				showSpecial(special);
				// gets special choice and adds it to pizza's bought array
				choice2 = getChoice(special.length);
				bought[totalBought] = special[choice2 -1];
				totalBought ++;
			}
			else if (choice1 == 2) {
				// builds the pizza and adds it to pizza's bought array
				bought[totalBought] = buildPizza(totalBought);
				totalBought ++;
			}
			// Shows order if an additional pizza was ordered
			if (totalBought > 0 && choice1 != 3) {
				showOrder(bought, totalBought);
			}
			if (totalBought == 3){
				System.out.println("You have reached the limit in this order. Here is the total: ");
			}
		}
		showOrderSummary(bought, totalBought);
		
	}
	
	/**
	 * Organizes the array of pizzas bought to be visually appealing 
	 * and inform the user how many pizzas they have left to order
	 * and what they have ordered so far
	 * @param array of pizzas bought
	 * @param total pizzas bought so far
	 */
	public static void showOrder(Pizza[] pizzas, int totalBought) {
		System.out.println("\nYour order:");
		System.out.println("Name\t\t\t\t\tToppings\nPrice");
		
		for (int i = 0; i < totalBought; i++) {
			System.out.println(pizzas[i].toString());
		}
		System.out.println("\nTotal pizza ordered: " + totalBought);
		if (totalBought < 3) {
			System.out.println("You can order " + (3-totalBought) + " more.\n");
		}
	}
	
	/**
	 * Organizes the array of pizzas bought to be visually appealing 
	 * and inform the user how many pizzas they have left to order.
	 * Unlike showOrder, it is specific for the summary at the end
	 * and totals the cost of all the pizzas with tax.
	 * @param array of pizzas bought
	 * @param total pizzas bought so far
	 */
	public static void showOrderSummary (Pizza[] pizzas, int totalBought) {
		DecimalFormat formatter = new DecimalFormat("$#,##0.00");
		double totalPrice = 0;
		final double TAX_RATE = .1025;
		double tax;
		
		System.out.println("\nOrder summary:");
		System.out.println("Name\t\t\t\t\tToppings\nPrice");
		
		for (int i = 0; i < totalBought; i++) {
			System.out.println(pizzas[i].toString());
		}
		
		for(int i = 0; i < totalBought; i++) {
			totalPrice += pizzas[i].getPrice();
		}
		
		tax = totalPrice * TAX_RATE;
		System.out.println("Sub-total: \t" + formatter.format(totalPrice) +
								"\nTax: \t\t" + formatter.format(tax) +
								"\nOrder total: \t" + formatter.format(totalPrice + tax) +
								"\nHave a nice day! Enjoy your pizza!");
	}
	
	/**
	 * Allows user to build a personalized pizza step by step
	 * while keeping track of price
	 * @param pizzas bought so far
	 * @return the pizza built with the pizza builder
	 */
	public static Pizza buildPizza(int bought) {
		Pizza pizza;
		String name = "pizza No." + (bought + 1); 
		String crust;
		String[] toppings;
		String sauce;
		String size;
		boolean extraCheese = false;
		double price = 0;
		String tempPrice;
		int choice;
		
		// gives user options so they can add to each part of pizza
		size = buildOptions("size", "Large (14'')", "Extra Large (18'')", "L", "XL");
		crust = buildOptions("crust", "pan", "hand-tossed", "pan", "hand-tossed");
		sauce = buildOptions("sauce", "marinara", "BBQ", "marinara", "BBQ");
		
		System.out.println("Would you want extra cheese?\n1. Yes\n2. No");
		choice = getChoice(2, "Select 1 or 2: ");
		if (choice == 1) {
			extraCheese = true;
		}
		
		toppings = selectToppings();
		
		// calculates price
		if (size.equals("L")) {
			price += 10.99;
		}
		else {
			price += 12.99;
		}
		
		if (crust.equals("pan")) {
			price += 1.99;
		}
		if (extraCheese) {
			price += 1.99;
		}
		
		// breaks away topping name from price and adds price to total
		for (int i = 0; i < toppings.length; i++) {
			tempPrice = toppings[i].substring(toppings[i].indexOf(",")+1);
			toppings[i] = toppings[i].substring(0, toppings[i].indexOf(","));
			try {
				price += Double.parseDouble(tempPrice);
			}
			catch (Exception e) {
				
			}
		}
		
		//creates pizza
		if (crust == "pan") {
			pizza = new Pan(toppings, price, extraCheese, sauce, size, name);
		}
		else {
			pizza = new HandTossed(toppings, price, extraCheese, sauce, size, name);
		}
		return pizza;
	}
	
	/**
	 * formats for two options and returns the first option if the user 
	 * chooses 1 and the second option if the user chooses 2
	 * @param type of option 
	 * @param the first option
	 * @param the second option
	 * @param the first option return name
	 * @param the second option return name
	 * @return the name of the option choosen
	 */
	public static String buildOptions(String type, String option1, String option2, String option1Return, String option2Return) {
		int choice;
		System.out.println("\nPlease choose the " + type + ":\n1. " + option1 + " \n2. " + option2);
		choice = getChoice(2, "Select " + type + ": ");
		if (choice == 1) {
			return option1Return;
		}
		return option2Return;
	}
	
	/**
	 * Goes through array of special pizzas and prints options of special pizzas
	 * with a header to guide user
	 * @param array of special pizzas
	 */
	public static void showSpecial(Pizza[] pizzas) {
		System.out.println("\nTry our special pizzas:(Limited 1 special pizza per order)");
		System.out.println("Name\t\t\t\tToppings\nPrice");
		// gets each pizza and skips null Pizza in case object did not store correctly
		for (int i = 0; i < pizzas.length; i++) {
			System.out.println((i+1) + ". " + pizzas[i].toString());
		}
		
	}
	
	/**
	 * Takes input from user and makes them continue to supply an input until
	 * they give a valid choice (an integer between 0 and the options avaliable)
	 * @param max options avaliable for user to choose from
	 * @return a valid number selected by the user between 0 and options avaliable
	 */
	public static int getChoice(int optionsAvaliable) {
		Scanner scan = new Scanner(System.in);
		String input;
		int choice = 0;
		
		// gives options and takes in input
		
		System.out.print("Please select: ");
		input = scan.next();
		try {
			choice = Integer.parseInt(input);
			if (choice < 1 || choice > optionsAvaliable) {
				System.out.println("A valid input must be in [1," + optionsAvaliable + "].");
			}
		}
		catch (NumberFormatException e) {
			System.out.println("A valid input must be an integer.");
		}
		
		// checks if choice is within range and catches it if choice is not a number
		while (choice < 1 || choice > optionsAvaliable) {
			
			System.out.print("Please select a valid option: ");
			input = scan.next();
			
			try {
				choice = Integer.parseInt(input);
				if (choice < 1 || choice > optionsAvaliable) {
					System.out.println("A valid input must be in [1," + optionsAvaliable + "].");
				}
			}
			catch (NumberFormatException e) {
				System.out.println("A valid input must be an integer.");
			}
		}
		
		return choice;
		
	}
	
	/**
	 *Takes input from user and makes them continue to supply an input until
	 * they give a valid choice (an integer between 0 and the options avaliable)
	 * @param max options avaliable for user to choose from
	 * @param text of specific category user is choosing from
	 * @return a valid number selected by the user between 0 and options avaliable
	 */
	public static int getChoice(int optionsAvaliable, String text) {
		Scanner scan = new Scanner(System.in);
		String input;
		int choice = 0;
		
		// gives options and takes in input
		
		System.out.print(text);
		input = scan.next();
		try {
			choice = Integer.parseInt(input);
			if (choice < 1 || choice > optionsAvaliable) {
				System.out.println("A valid input must be in [1," + optionsAvaliable + "].");
			}
		}
		catch (NumberFormatException e) {
			System.out.println("A valid input must be an integer.");
		}
		
		// checks if choice is within range and catches it if choice is not a number
		while (choice < 1 || choice > optionsAvaliable) {
			
			System.out.print("Please select a valid option: ");
			input = scan.next();
			
			try {
				choice = Integer.parseInt(input);
				if (choice < 1 || choice > optionsAvaliable) {
					System.out.println("A valid input must be in [1," + optionsAvaliable + "].");
				}
			}
			catch (NumberFormatException e) {
				System.out.println("A valid input must be an integer.");
			}
		}
		
		return choice;
		
	}
	
	/**
	 * Shows all of the main options based on how many are avaliable
	 * @param optionsAvaliable for the user to choose from
	 */
	public static void printOptions(int optionsAvaliable) {
		if (3 == optionsAvaliable) {
			System.out.println("1. Pizza deals"
				+ "\n2. Build your own pizza"
				+ "\n3. Exit");
		}
		else if (2 == optionsAvaliable){
			System.out.println("1. Build your own pizza"
					+ "\n2. Exit");
		}
	}
	
	/**
	 * Goes through deals file and organizes the data
	 * into a pizza array. Assumes each line of file 
	 * is organized by name,crust,toppings,sauce,size,price
	 * @return array of special pizzas from deals file
	 */
	public static Pizza[] readDeals() {
		File deals = new File("deals.csv");
		Pizza[] pizzas = new Pizza[findLength(deals)];
		Scanner scan = null;
		int count =0;
		String name; 
		String crust;
		String[] toppings;
		String toppingsTemp;
		String sauce;
		String size;
		double price;
		
		try {
			// sets scanner for deals file
			scan = new Scanner(deals);
			
			scan.nextLine();// 1st time to skip example line 
			// goes through each line to create each special pizza
			while (scan.hasNextLine()) {
				
				// sets up array so we can parse through elements
				String [] read = scan.nextLine().split(",");
		
				// tries to get each part of a pizza to create a new 
				// pizza object for the pizza array.
				// IF there is not enough to make another pizza OR
				// it was unable to parse, then it catches it and 
				// moves onto next line
				try {
					// gets each part of a pizza
					name = read[0];
					crust = read[1];
					toppingsTemp = read[2];
					sauce = read[3];
					size = read[4];
					price = Double.parseDouble(read[5]);
					
					// makes the toppings fit into a String array
					toppings = toppingsTemp.split("/");
					
					// adds new pizza
					
					if (crust.equals("pan")) {
						pizzas[count] = new Pan(toppings, price, false, sauce, size, name);
						count ++;
					}
					else if (crust.equals("hand-tossed")) {
						pizzas[count] = new HandTossed(toppings, price, false, sauce, size, name);
						count ++;
					}
					
				}
				catch (Exception e) {
					
				}
			}
		}
		catch (Exception e) {
			
		}
		finally {
			scan.close();
		}
		
		scan.close();
		return pizzas;
	}
	
	/**
	 * Counts how long a file is not including first line and returns that amount
	 * @param name of file you want to find length of not including first line
	 * @return how many lines are in the file not including first line
	 */
	public static int findLength(File fileName) {
		int count = 0;
		//goes through array and counts how many lines there are
		try {
			Scanner scan = new Scanner(fileName);
			while (scan.hasNextLine()) {
				count ++;
				scan.nextLine();
			}
		}
		catch(Exception e) {
			
		}
		return count -1;// subtracts 1 to account for example line
	}
	
	/**
	 * Looks through the toppings_prices.csv file and collects it into an array
	 * @return an array of toppings found in the file
	 */
	public static String[] readToppings() {
		File toppingsPrices = new File("toppings_prices.csv");
		String[] toppings = new String[findLength(toppingsPrices)];
		Scanner scan = null;
		int count = 0;

		try {
			// sets scanner for topping_prices file
			scan = new Scanner(toppingsPrices);
			
			scan.nextLine();// 1st time to skip example line 
			// collects each line in toppings array
			while (scan.hasNextLine()) {
				toppings[count] = scan.nextLine();
				count++;
			}
		}
		catch (Exception e) {
		}
		finally {
			scan.close();
		}
		
		return toppings;
		
	}
	
	/**
	 * Show all the topping options and lets the user continue to add
	 * toppings to their pizza until they quit or run out of toppings
	 * (whichever comes first). 
	 * @return an array of toppings choosen by the user
	 */
	public static String[] selectToppings() {
		String input;
		String[] toppings = readToppings();
		String[] tempToppings;
		String[] choosen = new String[toppings.length];
		int totalChoosen = 0;
		int choice = 0;
		int count = 0;
		
		//show options
		showToppingOptions(toppings);
		//get choice
		choice = getChoice(toppings.length +1, "Topping: ") -1;
		if (choice != toppings.length) {
			choosen[totalChoosen] = toppings[choice];
			totalChoosen ++;
		}
		
		while (choice != toppings.length && toppings.length != 1) {
			//remove topping as an option by taking out of main list
			tempToppings = new String[toppings.length - 1];
			for (int i = 0; i < toppings.length; i ++) {
				if (i != (choice)) {
					tempToppings[count] = toppings[i];
					count ++;
				}
			}
			toppings = new String[tempToppings.length];
			for (int i = 0; i < toppings.length; i ++) {
				toppings[i] = tempToppings[i];
			}
			//reset variables
			count = 0;
			
			if (toppings.length != 0) {
				//show options
				showToppingOptions(toppings);
				//get choice
				choice = getChoice(toppings.length + 1, "Topping: ") -1;
				if (choice != toppings.length) {
					choosen[totalChoosen] = toppings[choice];
					totalChoosen ++;
				}
			}
		}
		if (totalChoosen == choosen.length) {
			System.out.println("\nAll toppings have been selected.");
		}
		else {
			//makes the choosen list smaller based on how many toppings were added
			tempToppings = new String[totalChoosen];
			for (int i = 0; i < totalChoosen; i++) {
				tempToppings[i] = choosen[i];
			}
			choosen = tempToppings;
		}
		return choosen;
	}
	
	/**
	 * Shows all the option of toppings to choose from in an 
	 * organized manor. 
	 * @param an array of toppings for the user to choose from
	 */
	public static void showToppingOptions(String[] toppings) {
		System.out.println("Please choose one topping:");
		for (int i = 0; i < toppings.length; i ++) {
			System.out.println("\t\t" + (i+1) + ". " + toppings[i].substring(0, toppings[i].indexOf(",")));
		}
		System.out.println("\t\t" + (toppings.length +1) + ". Done!");
	}

}
