/**
 * ULID: <krhurdl>
 * Class: IT 168 
 */
package edu.ilstu;

import java.util.Iterator;

/**
 * Class dedicated to testing out the multiply and add methods
 * for two lists of Terms (Polynomials). It displays the output 
 * of each test so the user can see the results and see that the 
 * methods are working as intended.
 */
public class PolyDriver {

	public static void main(String[] args) {
		MySingleLinkedList<Term> firstPoly = new MySingleLinkedList<>();
		MySingleLinkedList<Term> secondPoly = new MySingleLinkedList<>();
		MySingleLinkedList<Term> combined = new MySingleLinkedList<>();
		
		// Testing the add method -------------------------------------------------------
		System.out.println("Outputs for the add method: \n");
		//first sample output test
		//first polynomials
		firstPoly.add(new Term(3,4));
		firstPoly.add(new Term(2,2));
		firstPoly.add(new Term(3,1));
		firstPoly.add(new Term(7,0));
		
		//second polynomials
		secondPoly.add(new Term(2,3));
		secondPoly.add(new Term(-5,1));
		secondPoly.add(new Term(5,0));
		
		//combined polynomials
		combined = add(firstPoly, secondPoly);
		// displays first and second polynomials and what they look like added together
		displayAllTerms(firstPoly, "First polynomial");
		displayAllTerms(secondPoly, "Second polynomial");
		displayAllTerms(combined, "Sum");
		
		
		//second sample output test
		firstPoly = new MySingleLinkedList<>();
		secondPoly = new MySingleLinkedList<>();
		
		//first polynomials
		firstPoly.add(new Term(3,4));
		firstPoly.add(new Term(2,2));
		
		//second polynomials
		secondPoly.add(new Term(5,0));
		
		//combined polynomials
		combined = add(firstPoly, secondPoly);
		// displays first and second polynomials and what they look like added together
		displayAllTerms(firstPoly, "\nFirst polynomial");
		displayAllTerms(secondPoly, "Second polynomial");
		displayAllTerms(combined, "Sum");
		
		
		//third sample output test
		firstPoly = new MySingleLinkedList<>();
		secondPoly = new MySingleLinkedList<>();
		//first polynomials
		firstPoly.add(new Term(2,2));
		firstPoly.add(new Term(3,1));
		firstPoly.add(new Term(7,0));
		
		//second polynomials
		secondPoly.add(new Term(2,9));
		secondPoly.add(new Term(3,0));
		
		//combined polynomials
		combined = add(firstPoly, secondPoly);
		// displays first and second polynomials and what they look like added together
		displayAllTerms(firstPoly, "\nFirst polynomial");
		displayAllTerms(secondPoly, "Second polynomial");
		displayAllTerms(combined, "Sum");
		
		
		//forth sample output test
		firstPoly = new MySingleLinkedList<>();
		secondPoly = new MySingleLinkedList<>();
		//first polynomials
		firstPoly.add(new Term(2,3));
		firstPoly.add(new Term(1,2));
		
		//second polynomials
		secondPoly.add(new Term(2,3));
		secondPoly.add(new Term(1,2));
		secondPoly.add(new Term(1,1));
		secondPoly.add(new Term(1,0));
		
		//combined polynomials
		combined = add(firstPoly, secondPoly);
		// displays first and second polynomials and what they look like added together
		displayAllTerms(firstPoly, "\nFirst polynomial");
		displayAllTerms(secondPoly, "Second polynomial");
		displayAllTerms(combined, "Sum");
		
		
		//5th sample output test
		firstPoly = new MySingleLinkedList<>();
		secondPoly = new MySingleLinkedList<>();
		//first polynomials
		firstPoly.add(new Term(3,4));
		firstPoly.add(new Term(7,0));
		
		//second polynomials
		secondPoly.add(new Term(5,5));
		secondPoly.add(new Term(2,2));
		secondPoly.add(new Term(3,1));
		
		//combined polynomials
		combined = add(firstPoly, secondPoly);
		// displays first and second polynomials and what they look like added together
		displayAllTerms(firstPoly, "\nFirst polynomial");
		displayAllTerms(secondPoly, "Second polynomial");
		displayAllTerms(combined, "Sum");
		
		
		//6th sample output test
		firstPoly = new MySingleLinkedList<>();
		secondPoly = new MySingleLinkedList<>();
		//first polynomials
		firstPoly.add(new Term(9,90));
		
		//second polynomials
		secondPoly.add(new Term(1,1));
		secondPoly.add(new Term(1,0));
		
		//combined polynomials
		combined = add(firstPoly, secondPoly);
		// displays first and second polynomials and what they look like added together
		displayAllTerms(firstPoly, "\nFirst polynomial");
		displayAllTerms(secondPoly, "Second polynomial");
		displayAllTerms(combined, "Sum");
		
		
		//7th sample output test
		firstPoly = new MySingleLinkedList<>();
		secondPoly = new MySingleLinkedList<>();
		//first polynomials
		firstPoly.add(new Term(-2,-3));
		
		//second polynomials
		secondPoly.add(new Term(-2,-2));
		
		//combined polynomials
		combined = add(firstPoly, secondPoly);
		// displays first and second polynomials and what they look like added together
		displayAllTerms(firstPoly, "\nFirst polynomial");
		displayAllTerms(secondPoly, "Second polynomial");
		displayAllTerms(combined, "Sum");
		
		
		//8th sample output test
		firstPoly = new MySingleLinkedList<>();
		secondPoly = new MySingleLinkedList<>();
		//first polynomials
		firstPoly.add(new Term(3,4));
		firstPoly.add(new Term(2,3));
		firstPoly.add(new Term(-1,1));
		firstPoly.add(new Term(-8,-1));
		firstPoly.add(new Term(5,-3));
		
		//second polynomials
		secondPoly.add(new Term(2,5));
		secondPoly.add(new Term(-3,4));
		secondPoly.add(new Term(6,0));
		secondPoly.add(new Term(8,-1));
		secondPoly.add(new Term(-4,-3));
		
		//combined polynomials
		combined = add(firstPoly, secondPoly);
		// displays first and second polynomials and what they look like added together
		displayAllTerms(firstPoly, "\nFirst polynomial");
		displayAllTerms(secondPoly, "Second polynomial");
		displayAllTerms(combined, "Sum");
		
		
		//8th sample output test
		firstPoly = new MySingleLinkedList<>();
		secondPoly = new MySingleLinkedList<>();
		//first polynomials
		firstPoly.add(new Term(5,0));
		
		//second polynomials
		secondPoly.add(new Term(-5,0));
		
		//combined polynomials
		combined = add(firstPoly, secondPoly);
		// displays first and second polynomials and what they look like added together
		displayAllTerms(firstPoly, "\nFirst polynomial");
		displayAllTerms(secondPoly, "Second polynomial");
		displayAllTerms(combined, "Sum");
		
		
		//9th sample output test
		firstPoly = new MySingleLinkedList<>();
		secondPoly = new MySingleLinkedList<>();
		//first polynomials
		firstPoly.add(new Term(1,2));
		firstPoly.add(new Term(7,-2));
		
		//second polynomials
		secondPoly.add(new Term(-1,2));
		secondPoly.add(new Term(5,0));
		secondPoly.add(new Term(-7,-2));
		
		//combined polynomials
		combined = add(firstPoly, secondPoly);
		// displays first and second polynomials and what they look like added together
		displayAllTerms(firstPoly, "\nFirst polynomial");
		displayAllTerms(secondPoly, "Second polynomial");
		displayAllTerms(combined, "Sum");
		
		// Testing the multiplication method -------------------------------------------------------
		System.out.println("\nOutputs for the multiply method:");
		//10th sample output test
		firstPoly = new MySingleLinkedList<>();
		secondPoly = new MySingleLinkedList<>();
		//first polynomials
		firstPoly.add(new Term(2,3));
		firstPoly.add(new Term(2,2));
		firstPoly.add(new Term(-1,1));
		firstPoly.add(new Term(3,0));
		
		//second polynomials
		secondPoly.add(new Term(3,2));
		secondPoly.add(new Term(-2,1));
		secondPoly.add(new Term(2,0));
		
		// displays first and second polynomials and what they look like added together
		displayAllTerms(firstPoly, "\nFirst polynomial");
		displayAllTerms(secondPoly, "Second polynomial");
		//combined
		combined = multiply(firstPoly, secondPoly);
		displayAllTerms(combined, "Multiplication");
		displayAllTerms(simplify(combined), "Simplified");
		
		
		//10th sample output test
		firstPoly = new MySingleLinkedList<>();
		secondPoly = new MySingleLinkedList<>();
		//first polynomials
		firstPoly.add(new Term(1,1));
		firstPoly.add(new Term(1,0));
		
		//second polynomials
		secondPoly.add(new Term(1,1));
		secondPoly.add(new Term(1,0));
		
		// displays first and second polynomials and what they look like added together
		displayAllTerms(firstPoly, "\nFirst polynomial");
		displayAllTerms(secondPoly, "Second polynomial");
		//combined
		combined = multiply(firstPoly, secondPoly);
		displayAllTerms(combined, "Multiplication");
		displayAllTerms(simplify(combined), "Simplified");
		
		
		//11th sample output test
		firstPoly = new MySingleLinkedList<>();
		secondPoly = new MySingleLinkedList<>();
		//first polynomials
		firstPoly.add(new Term(1,1));
		firstPoly.add(new Term(1,0));
		
		//second polynomials
		secondPoly.add(new Term(1,1));
		secondPoly.add(new Term(-1,0));
		
		// displays first and second polynomials and what they look like added together
		displayAllTerms(firstPoly, "\nFirst polynomial");
		displayAllTerms(secondPoly, "Second polynomial");
		//combined
		combined = multiply(firstPoly, secondPoly);
		displayAllTerms(combined, "Multiplication");
		displayAllTerms(simplify(combined), "Simplified");
		
		
		//12th sample output test
		firstPoly = new MySingleLinkedList<>();
		secondPoly = new MySingleLinkedList<>();
		//first polynomials
		firstPoly.add(new Term(3,4));
		firstPoly.add(new Term(2,3));
		firstPoly.add(new Term(-1,1));
		firstPoly.add(new Term(-8,-1));
		firstPoly.add(new Term(5,-3));
		
		//second polynomials
		secondPoly.add(new Term(2,5));
		secondPoly.add(new Term(-3,4));
		secondPoly.add(new Term(6,0));
		secondPoly.add(new Term(8,-1));
		secondPoly.add(new Term(-4,-3));
		
		// displays first and second polynomials and what they look like added together
		displayAllTerms(firstPoly, "\nFirst polynomial");
		displayAllTerms(secondPoly, "Second polynomial");
		//combined
		combined = multiply(firstPoly, secondPoly);
		displayAllTerms(combined, "Multiplication");
		displayAllTerms(simplify(combined), "Simplified");
		
		
		//13th sample output test
		firstPoly = new MySingleLinkedList<>();
		secondPoly = new MySingleLinkedList<>();
		//first polynomials
		firstPoly.add(new Term(5,0));
		
		//second polynomials
		secondPoly.add(new Term(-5,0));
		
		// displays first and second polynomials and what they look like added together
		displayAllTerms(firstPoly, "\nFirst polynomial");
		displayAllTerms(secondPoly, "Second polynomial");
		//combined
		combined = multiply(firstPoly, secondPoly);
		displayAllTerms(combined, "Multiplication");
		displayAllTerms(simplify(combined), "Simplified");
	}
	
	/**
	 * Compares terms in both given lists till a list runs out 
	 * of terms. Each time, it checks if a term needs to iterate to the 
	 * next term. Then it sees which terms has the larger exponent (the
	 * larger exponent is then added) or if they are the same, adds the 
	 * coefficant and creates a new term with that exponent to add. 
	 * Once a list runs out of terms to use, it then check if either list 
	 * had an unused term or more terms to iterate through and then adds 
	 * remaining terms. 
	 * @param first list of terms you want to be multiplied
	 * @param second list of terms you want to be multiplied
	 * @return list of the terms added together
	 */
	private static MySingleLinkedList<Term> add(MySingleLinkedList<Term> firstTerms, MySingleLinkedList<Term> secondTerms) {
		Iterator<Term> iter1 = firstTerms.iterator();
		Iterator<Term> iter2 = secondTerms.iterator();
		MySingleLinkedList<Term> addedTerms = new MySingleLinkedList<>();
		Term term1 = null;
		Term term2 = null;
		boolean popFirst = true;
		boolean popSecond = true;
		//variables to check if there is an element that still needs to be used
		
		// goes through each element in firstTerms list
		while (((iter1.hasNext() || !popFirst) && (iter2.hasNext() || !popSecond))) {
			// Iterates through terms based on what was 
			// added to combined terms so that iteration 
			// happens at start instead of end
			if(popFirst) {
				term1 = iter1.next();
				popFirst = false;
			}
			if(popSecond) {
				term2 = iter2.next();
				popSecond = false;
			}
			// Checks which term is greater and adds that term to the list.
			// Then removes the greater term.
			// If they are equal, create a new term with the coefficants added together
			// and the exponent they share. Then removes both terms.
			if (term1.getExp() > term2.getExp()) {
				addedTerms.add(term1);
				popFirst = true;
			}
			else if (term1.getExp() < term2.getExp()) {
				addedTerms.add(term2);
				popSecond = true;
			}
			else {
				int sum = term1.getCoe() + term2.getCoe();
				Term combinedTerm = new Term(sum, term1.getExp());
				addedTerms.add(combinedTerm);
				popFirst = true;
				popSecond = true;
			}
		}
		
		// adds whatever is left from the firstTerms list
		if (!popFirst) {
			addedTerms.add(term1);
		}
		while(iter1.hasNext()) {
			term1 = iter1.next();
			addedTerms.add(term1);
		}
		
		// adds whatever is left from the secondTerms list
		if (!popSecond) {
			addedTerms.add(term2);
		}
		while(iter2.hasNext()) {
			term2 = iter2.next();
			addedTerms.add(term2);
		}
		
		return addedTerms;
	}
	
	/**
	 * Takes two list of terms. Iterates through the first terms and for
	 * each term in the first terms list, it is multiplied with each term 
	 * in the second list. Each time two terms are multiplied, the coefficants
	 * of each term are multiplied and the exponents are added together. 
	 * @param first list of terms you want to be multiplied
	 * @param second list of terms you want to be multiplied
	 * @return list of the terms multiplied together
	 */
	private static MySingleLinkedList<Term> multiply(MySingleLinkedList<Term> firstTerms, MySingleLinkedList<Term> secondTerms) {
		Iterator<Term> iter1 = firstTerms.iterator();
		MySingleLinkedList<Term> addedTerms = new MySingleLinkedList<>();
		
		// For each term in the firstTerms, it will be multiplied with
		// each term in the secondTerms list.
		while(iter1.hasNext()) {
			Term term1 = iter1.next();
			Iterator<Term> iter2 = secondTerms.iterator();
			while (iter2.hasNext()) {
				Term term2 = iter2.next();
				// Multiplies two terms by multipling the coefficant
				// and adding the exponents to create a new term to addedTerms.
				int coefficant = term1.getCoe() * term2.getCoe();
				int exponent = term1.getExp() + term2.getExp();
				Term multipliedTerms = new Term(coefficant, exponent);
				addedTerms.add(multipliedTerms);
			}
			
		}
		
		return addedTerms;
	}
	
	/**
	 * 
	 * @param terms - list of polynomials(terms) you want to be simplified
	 * @return the list of polynomials(terms) now simplified
	 */
	public static MySingleLinkedList<Term> simplify(MySingleLinkedList<Term> terms) {
		MySingleLinkedList<Term> simplified = new MySingleLinkedList<>();
		Iterator<Term> iter = terms.iterator();
		
		//adds first term to so there is something to compare to in simplified
		Term term = iter.next();
		simplified.add(term);
		
		while(iter.hasNext()) {
			term = iter.next();
			boolean matchFound = false;
			for (int i = 0; i < simplified.size(); i++) {
				if (term.getExp() == simplified.get(i).getExp()) {
					int newCoe = term.getCoe() + simplified.get(i).getCoe();
					simplified.get(i).setCoe(newCoe);
					matchFound = true;
				}
			}
			if (!matchFound) {
				simplified.add(term);
			}
		}
		
		return simplified;
	}
	
	/**
	 * Displays all the terms of a single linked list, separating each term
	 * with a plus sign (or minus sign if number is negative) and starting with
	 * given text.
	 * @param terms - the list of polynomials(terms) you want to display
	 * @param text you want to start with 
	 */
	public static void displayAllTerms(MySingleLinkedList<Term> terms, String text) {
		System.out.print(text + " = ");
		boolean isFirst = true;//keeps track if a term is the first non-zero number
		
		//first checks to account for when all the terms had added up to zero
        if (terms.size() == 1 && terms.get(0).getCoe() == 0) {
        	System.out.println(0);
        }
        else {
        	Iterator<Term> iter = terms.iterator();
        	//prints every term after with addition sign in front if coefficant is positive
	        while (iter.hasNext()) {
	        	Term term = iter.next();
	        	if(term.getCoe() < 0 || (isFirst && term.getCoe() != 0)) {
	        		System.out.print(term);
	        		isFirst = false;
	        	}
	        	else if (term.getCoe() > 0){
	        		System.out.print("+" + term);
	        	}
	        }
	        System.out.println();
	        
        }
		
	}

}
