package edu.ilstu;

public class PolyDriver {

	public static void main(String[] args) {
		
		
	}
	
	public static MySingleLinkedList<Term> addTerms(MySingleLinkedList<Term> firstTerms, MySingleLinkedList<Term> secondTerms) {
		MySingleLinkedList<Term> addedTerms = new MySingleLinkedList<>();
		
		// goes through each element in firstTerms list
		for (int i = 0; i < firstTerms.size(); i++) {
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
		
		// adds whatever is left from the secondTerms list
		for (int i = 0; i < secondTerms.size(); i++) {
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

}
