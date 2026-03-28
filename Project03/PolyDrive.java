package edu.ilstu;

import java.util.Iterator;

public class PolyDriver {

	public static void main(String[] args) {
		MySingleLinkedList<Term> firstPoly = new MySingleLinkedList<>();
		MySingleLinkedList<Term> secondPoly = new MySingleLinkedList<>();
		MySingleLinkedList<Term> combined = new MySingleLinkedList<>();
		Iterator<Term> firstIter = null;
		Iterator<Term> secondIter = null;
		
		// Testing the add method -------------------------------------------------------
		System.out.println("Output for the method add: \n");
		//first sample output test
		//first polynomials
		firstPoly.add(new Term(3,4));
		firstPoly.add(new Term(2,2));
		firstPoly.add(new Term(3,1));
		firstPoly.add(new Term(7,0));
		firstIter = firstPoly.iterator();
		
		//second polynomials
		secondPoly.add(new Term(2,3));
		secondPoly.add(new Term(-5,1));
		secondPoly.add(new Term(5,0));
		secondIter = secondPoly.iterator();
		
		// displays first and second polynomials and what they look like added together
		displayAllTerms(firstPoly, "First polynomial");
		displayAllTerms(secondPoly, "Second polynomial");
		displayAllTerms(add(firstPoly, secondPoly, firstIter, secondIter), "Sum");
		
		
		//second sample output test
		//first polynomials
		firstPoly.add(new Term(3,4));
		firstPoly.add(new Term(2,2));
		firstIter = firstPoly.iterator();
		
		//second polynomials
		secondPoly.add(new Term(5,0));
		secondIter = secondPoly.iterator();
		
		// displays first and second polynomials and what they look like added together
		displayAllTerms(firstPoly, "\nFirst polynomial");
		displayAllTerms(secondPoly, "Second polynomial");
		displayAllTerms(add(firstPoly, secondPoly, firstIter, secondIter), "Sum");
		
		
		//third sample output test
		//first polynomials
		firstPoly.add(new Term(2,2));
		firstPoly.add(new Term(3,1));
		firstPoly.add(new Term(7,0));
		firstIter = firstPoly.iterator();
		
		//second polynomials
		secondPoly.add(new Term(2,9));
		secondPoly.add(new Term(3,0));
		secondIter = secondPoly.iterator();
		
		// displays first and second polynomials and what they look like added together
		displayAllTerms(firstPoly, "\nFirst polynomial");
		displayAllTerms(secondPoly, "Second polynomial");
		displayAllTerms(add(firstPoly, secondPoly, firstIter, secondIter), "Sum");
		
		
		//forth sample output test
		//first polynomials
		firstPoly.add(new Term(2,3));
		firstPoly.add(new Term(1,2));
		firstIter = firstPoly.iterator();
		
		//second polynomials
		secondPoly.add(new Term(2,3));
		secondPoly.add(new Term(1,2));
		secondPoly.add(new Term(1,1));
		secondPoly.add(new Term(1,0));
		secondIter = secondPoly.iterator();
		
		// displays first and second polynomials and what they look like added together
		displayAllTerms(firstPoly, "\nFirst polynomial");
		displayAllTerms(secondPoly, "Second polynomial");
		displayAllTerms(add(firstPoly, secondPoly, firstIter, secondIter), "Sum");
		
		
		//5th sample output test
		//first polynomials
		firstPoly.add(new Term(3,4));
		firstPoly.add(new Term(7,0));
		firstIter = firstPoly.iterator();
		
		//second polynomials
		secondPoly.add(new Term(5,5));
		secondPoly.add(new Term(2,2));
		secondPoly.add(new Term(3,1));
		secondIter = secondPoly.iterator();
		
		// displays first and second polynomials and what they look like added together
		displayAllTerms(firstPoly, "\nFirst polynomial");
		displayAllTerms(secondPoly, "Second polynomial");
		displayAllTerms(add(firstPoly, secondPoly, firstIter, secondIter), "Sum");
		
		
		//6th sample output test
		//first polynomials
		firstPoly.add(new Term(9,90));
		firstIter = firstPoly.iterator();
		
		//second polynomials
		secondPoly.add(new Term(1,1));
		secondPoly.add(new Term(1,0));
		secondIter = secondPoly.iterator();
		
		// displays first and second polynomials and what they look like added together
		displayAllTerms(firstPoly, "\nFirst polynomial");
		displayAllTerms(secondPoly, "Second polynomial");
		displayAllTerms(add(firstPoly, secondPoly, firstIter, secondIter), "Sum");
		
		
		//7th sample output test
		//first polynomials
		firstPoly.add(new Term(-2,-3));
		firstIter = firstPoly.iterator();
		
		//second polynomials
		secondPoly.add(new Term(-2,-2));
		secondIter = secondPoly.iterator();
		
		// displays first and second polynomials and what they look like added together
		displayAllTerms(firstPoly, "\nFirst polynomial");
		displayAllTerms(secondPoly, "Second polynomial");
		displayAllTerms(add(firstPoly, secondPoly, firstIter, secondIter), "Sum");
		
		//8th sample output test
		//first polynomials
		firstPoly.add(new Term(3,4));
		firstPoly.add(new Term(2,3));
		firstPoly.add(new Term(-1,1));
		firstPoly.add(new Term(-8,-1));
		firstPoly.add(new Term(5,-3));
		firstIter = firstPoly.iterator();
		
		//second polynomials
		secondPoly.add(new Term(2,5));
		secondPoly.add(new Term(-3,4));
		secondPoly.add(new Term(6,0));
		secondPoly.add(new Term(8,-1));
		secondPoly.add(new Term(-4,-3));
		secondIter = secondPoly.iterator();
		
		// displays first and second polynomials and what they look like added together
		displayAllTerms(firstPoly, "\nFirst polynomial");
		displayAllTerms(secondPoly, "Second polynomial");
		displayAllTerms(add(firstPoly, secondPoly, firstIter, secondIter), "Sum");
		
		
		//8th sample output test
		//first polynomials
		firstPoly.add(new Term(5,0));
		firstIter = firstPoly.iterator();
		
		//second polynomials
		secondPoly.add(new Term(-5,0));
		secondIter = secondPoly.iterator();
		
		// displays first and second polynomials and what they look like added together
		displayAllTerms(firstPoly, "\nFirst polynomial");
		displayAllTerms(secondPoly, "Second polynomial");
		displayAllTerms(add(firstPoly, secondPoly, firstIter, secondIter), "Sum");
		
		
		//9th sample output test
		//first polynomials
		firstPoly.add(new Term(1,2));
		firstPoly.add(new Term(7,-2));
		firstIter = firstPoly.iterator();
		
		//second polynomials
		secondPoly.add(new Term(-1,2));
		secondPoly.add(new Term(5,0));
		secondPoly.add(new Term(-7,-2));
		secondIter = secondPoly.iterator();
		
		// displays first and second polynomials and what they look like added together
		displayAllTerms(firstPoly, "\nFirst polynomial");
		displayAllTerms(secondPoly, "Second polynomial");
		displayAllTerms(add(firstPoly, secondPoly, firstIter, secondIter), "Sum");
		
		// Testing the multiplication method -------------------------------------------------------
		System.out.println("\nOutput for the multiply method.");
		//10th sample output test
		//first polynomials
		firstPoly.add(new Term(2,3));
		firstPoly.add(new Term(2,2));
		firstPoly.add(new Term(-1,1));
		firstPoly.add(new Term(3,0));
		firstIter = firstPoly.iterator();
		
		//second polynomials
		secondPoly.add(new Term(3,2));
		secondPoly.add(new Term(-2,1));
		secondPoly.add(new Term(2,0));
		secondIter = secondPoly.iterator();
		
		// displays first and second polynomials and what they look like added together
		displayAllTerms(firstPoly, "\nFirst polynomial");
		displayAllTerms(secondPoly, "Second polynomial");
		//combined
		combined = multiply(firstPoly, secondPoly, firstIter, secondIter);
		displayAllTerms(combined, "Multiplication");
		displayAllTerms(simplify(combined), "Simplified");
		
		
		//10th sample output test
		//first polynomials
		firstPoly.add(new Term(1,1));
		firstPoly.add(new Term(1,0));
		firstIter = firstPoly.iterator();
		
		//second polynomials
		secondPoly.add(new Term(1,1));
		secondPoly.add(new Term(1,0));
		secondIter = secondPoly.iterator();
		
		// displays first and second polynomials and what they look like added together
		displayAllTerms(firstPoly, "\nFirst polynomial");
		displayAllTerms(secondPoly, "Second polynomial");
		//combined
		combined = multiply(firstPoly, secondPoly, firstIter, secondIter);
		displayAllTerms(combined, "Multiplication");
		displayAllTerms(simplify(combined), "Simplified");
		
		
		
	}
	
	public static MySingleLinkedList<Term> add(MySingleLinkedList<Term> firstTerms, MySingleLinkedList<Term> secondTerms, Iterator<Term> iter1, Iterator<Term> iter2) {
		MySingleLinkedList<Term> addedTerms = new MySingleLinkedList<>();
		
		// goes through each element in firstTerms list
		while (iter1.hasNext() && iter2.hasNext()) {
			// Checks which term is greater and adds that term to the list.
			// Then removes the greater term.
			// If they are equal, create a new term with the coefficants added together
			// and the exponent they share. Then removes both terms.
			if (firstTerms.get(0).getExp() > secondTerms.get(0).getExp()) {
				addedTerms.add(firstTerms.get(0));
				iter1.next();
				iter1.remove();
			}
			else if (firstTerms.get(0).getExp() < secondTerms.get(0).getExp()) {
				addedTerms.add(secondTerms.get(0));
				iter2.next();
				iter2.remove();
			}
			else {
				int sum = firstTerms.get(0).getCoe() + secondTerms.get(0).getCoe();
				Term combinedTerm = new Term(sum, firstTerms.get(0).getExp());
				addedTerms.add(combinedTerm);
				iter1.next();
				iter2.next();
				iter1.remove();
				iter2.remove();
			}
		}
		
		// adds whatever is left from the firstTerms list
		while(iter1.hasNext()) {
			addedTerms.add(firstTerms.get(0));
			iter1.next();
			iter1.remove();
		}
		
		// adds whatever is left from the secondTerms list
		while(iter2.hasNext()) {
			addedTerms.add(secondTerms.get(0));
			iter2.next();
			iter2.remove();
		}
		
		return addedTerms;
	}
	
	public static MySingleLinkedList<Term> multiply(MySingleLinkedList<Term> firstTerms, MySingleLinkedList<Term> secondTerms, Iterator<Term> iter1, Iterator<Term> iter2) {
		MySingleLinkedList<Term> addedTerms = new MySingleLinkedList<>();
		
		// For each term in the firstTerms, it will be multiplied with
		// each term in the secondTerms list. 
		for (int i = 0; i < firstTerms.size(); i++) {
			for (int j = 0; j < secondTerms.size(); j ++) {
				// Multiplies two terms by multipling the coefficant
				// and adding the exponents to create a new term to 
				// add to addedTerms.
				int coefficant = firstTerms.get(i).getCoe() * secondTerms.get(j).getCoe();
				int exponent = firstTerms.get(i).getExp() + secondTerms.get(j).getExp();
				Term multipliedTerms = new Term(coefficant, exponent);
				addedTerms.add(multipliedTerms);
				// empties second list on last run
//				if (j == secondTerms.size() -1) {
//					iter2.next();
//					iter2.remove();
//				}
			}
//			iter1.next();
//			iter1.remove();
		}
		
		
		return addedTerms;
	}
	
	public static MySingleLinkedList<Term> simplify(MySingleLinkedList<Term> terms) {
		MySingleLinkedList<Term> simplified = new MySingleLinkedList<>();
		Iterator iter = terms.iterator();
		
		//adds first term to simplified since it will 
		//have the largest exponent and is the first 
		//one in so there is nothing to compare to 
		simplified.add(terms.get(0));
		iter.next();
		iter.remove();
		
		while(iter.hasNext()) {
			boolean matchFound = false;
			for (int i = 0; i < simplified.size(); i++) {
				if (terms.get(0).getExp() == simplified.get(i).getExp()) {
					int newCoe = terms.get(0).getCoe() + simplified.get(i).getCoe();
					simplified.get(i).setCoe(newCoe);
					matchFound = true;
				}
			}
			if (!matchFound) {
				simplified.add(terms.get(0));
			}
			iter.next();
			iter.remove();
		}
		
		return simplified;
	}
	
	public static void displayAllTerms(MySingleLinkedList<Term> terms, String text) {
		System.out.print(text + " = ");
		boolean isFirst = true;//keeps track if a term is the first non-zero number
		
		//first checks to account for when all the terms had added up to zero
        if (terms.size() == 1 && terms.get(0).getCoe() == 0) {
        	System.out.println(0);
        }
        else {
        	//prints every term after with addition sign in front if coefficant is positive
	        for (int i = 0; i < terms.size()-1; i ++) {
	        	if(terms.get(i).getCoe() < 0 || (isFirst && terms.get(i).getCoe() != 0)) {
	        		System.out.print(terms.get(i));
	        		isFirst = false;
	        	}
	        	else if (terms.get(i).getCoe() > 0){
	        		System.out.print("+" + terms.get(i));
	        	}
	        }
	        //prints last term
	        if (isFirst && terms.get(terms.size()-1).getCoe() != 0) {
	        	System.out.println(terms.get(terms.size()-1));
	        }
	        else if (terms.get(terms.size()-1).getCoe() != 0){
	        	System.out.println("+" + terms.get(terms.size()-1));
	        }
	        else {
	        	System.out.println();
	        }
        }
		
	}

}
