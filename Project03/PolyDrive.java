package edu.ilstu;

public class PolyDriver {

	public static void main(String[] args) {
		MySingleLinkedList<Term> firstPoly = new MySingleLinkedList<>();
		MySingleLinkedList<Term> secondPoly = new MySingleLinkedList<>();
		
		// Testing the add method on several tests
		System.out.println("Sample output for the method add: \n");
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
		
		// displays first and second polynomials and what they look like added together
		displayAllTerms(firstPoly, "First polynomial");
		displayAllTerms(secondPoly, "Second polynomial");
		displayAllTerms(add(firstPoly, secondPoly), "Sum");
		
		
		//second sample output test
		//first polynomials
		firstPoly.add(new Term(3,4));
		firstPoly.add(new Term(2,2));
		
		//second polynomials
		secondPoly.add(new Term(5,0));
		
		// displays first and second polynomials and what they look like added together
		displayAllTerms(firstPoly, "\nFirst polynomial");
		displayAllTerms(secondPoly, "Second polynomial");
		displayAllTerms(add(firstPoly, secondPoly), "Sum");
		
		
		//third sample output test
		//first polynomials
		firstPoly.add(new Term(2,2));
		firstPoly.add(new Term(3,1));
		firstPoly.add(new Term(7,0));
		
		//second polynomials
		secondPoly.add(new Term(2,9));
		secondPoly.add(new Term(3,0));
		
		// displays first and second polynomials and what they look like added together
		displayAllTerms(firstPoly, "\nFirst polynomial");
		displayAllTerms(secondPoly, "Second polynomial");
		displayAllTerms(add(firstPoly, secondPoly), "Sum");
		
		
		//forth sample output test
		//first polynomials
		firstPoly.add(new Term(2,3));
		firstPoly.add(new Term(1,2));
		
		//second polynomials
		secondPoly.add(new Term(2,3));
		secondPoly.add(new Term(1,2));
		secondPoly.add(new Term(1,1));
		secondPoly.add(new Term(1,0));
		
		// displays first and second polynomials and what they look like added together
		displayAllTerms(firstPoly, "\nFirst polynomial");
		displayAllTerms(secondPoly, "Second polynomial");
		displayAllTerms(add(firstPoly, secondPoly), "Sum");
		
		
		//5th sample output test
		//first polynomials
		firstPoly.add(new Term(3,4));
		firstPoly.add(new Term(7,0));
		
		//second polynomials
		secondPoly.add(new Term(5,5));
		secondPoly.add(new Term(2,2));
		secondPoly.add(new Term(3,1));
		
		// displays first and second polynomials and what they look like added together
		displayAllTerms(firstPoly, "\nFirst polynomial");
		displayAllTerms(secondPoly, "Second polynomial");
		displayAllTerms(add(firstPoly, secondPoly), "Sum");
		
		
		//6th sample output test
		//first polynomials
		firstPoly.add(new Term(9,90));
		
		//second polynomials
		secondPoly.add(new Term(1,1));
		secondPoly.add(new Term(1,0));
		
		// displays first and second polynomials and what they look like added together
		displayAllTerms(firstPoly, "\nFirst polynomial");
		displayAllTerms(secondPoly, "Second polynomial");
		displayAllTerms(add(firstPoly, secondPoly), "Sum");
		
		
		//7th sample output test
		//first polynomials
		firstPoly.add(new Term(-2,-3));
		
		//second polynomials
		secondPoly.add(new Term(-2,-2));
		
		// displays first and second polynomials and what they look like added together
		displayAllTerms(firstPoly, "\nFirst polynomial");
		displayAllTerms(secondPoly, "Second polynomial");
		displayAllTerms(add(firstPoly, secondPoly), "Sum");
		
	}
	
	public static MySingleLinkedList<Term> add(MySingleLinkedList<Term> firstTerms, MySingleLinkedList<Term> secondTerms) {
		MySingleLinkedList<Term> addedTerms = new MySingleLinkedList<>();
		
		// goes through each element in firstTerms list
		while (firstTerms.size() > 0 && secondTerms.size() > 0) {
			// Checks which term is greater and adds that term to the list.
			// Then removes the greater term.
			// If they are equal, create a new term with the coefficants added together
			// and the exponent they share. Then removes both terms.
			if (firstTerms.get(0).getExp() > secondTerms.get(0).getExp()) {
				addedTerms.add(firstTerms.get(0));
				firstTerms.remove(0);
			}
			else if (firstTerms.get(0).getExp() < secondTerms.get(0).getExp()) {
				addedTerms.add(secondTerms.get(0));
				secondTerms.remove(0);
			}
			else {
				int sum = firstTerms.get(0).getCoe() + secondTerms.get(0).getCoe();
				Term combinedTerm = new Term(sum, firstTerms.get(0).getExp());
				addedTerms.add(combinedTerm);
				firstTerms.remove(0);
				secondTerms.remove(0);
			}
		}
		
		// adds whatever is left from the firstTerms list
		while(firstTerms.size() > 0) {
			addedTerms.add(firstTerms.get(0));
			firstTerms.remove(0);
		}
		
		// adds whatever is left from the secondTerms list
		while(secondTerms.size() > 0) {
			addedTerms.add(secondTerms.get(0));
			secondTerms.remove(0);
		}
		
		return addedTerms;
	}
	
	public static MySingleLinkedList<Term> multiplyTerms(MySingleLinkedList<Term> firstTerms, MySingleLinkedList<Term> secondTerms) {
		MySingleLinkedList<Term> addedTerms = new MySingleLinkedList<>();
		
		// For each term in the firstTerms, it will be multiplied with
		// each term in the secondTerms list. 
		for (int i = 0; i < firstTerms.size(); i ++) {
			for (int j = 0; j < secondTerms.size(); j ++) {
				// Multiplies two terms by multipling the coefficant
				// and adding the exponents to create a new term to 
				// add to addedTerms.
				int coefficant = firstTerms.get(i).getCoe() * secondTerms.get(j).getCoe();
				int exponent = firstTerms.get(i).getExp() + secondTerms.get(j).getExp();
				Term multipliedTerms = new Term(coefficant, exponent);
				addedTerms.add(multipliedTerms);
			}
		}
		
		
		return addedTerms;
	}
	
	public static void displayAllTerms(MySingleLinkedList<Term> terms, String text) {
		System.out.print(text + " = ");
		// prints first term
		System.out.print(terms.get(0));
		//prints every term after with addition sign in front if coefficant is positive
        for (int i = 1; i < terms.size(); i++) {
        	if(terms.get(i).getCoe() < 0) {
        		System.out.print(terms.get(i));
        	}
        	else {
        		System.out.print("+" + terms.get(i));
        	}
        		
        }
        
        System.out.println();
	}

}
