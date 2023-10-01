package autocompleteproj;

import java.util.Arrays;
import java.util.Comparator;

public class Term implements Comparable<Term> {

	public final String termValue; // The word.
	public final long termWeight; // The associated weight.

	
    // Initializes a term with the given query string and weight.
    public Term(String query, long weight) {
    	if ((query == null) || (weight < 0)) {throw new IllegalArgumentException();}
    	
    	this.termValue = query;
    	this.termWeight = weight;
    }
    

    
    /**
     * Compares the two terms in descending order by weight. 
     * Terms with a higher weight will be moved up when passed into a sorting algorithm.
     * @return Instance of ReverseWeightOrderComparator class
     */
    public static Comparator<Term> byReverseWeightOrder(){
    	return new ReverseWeightOrderComparator();
    }
   
   
    /**
     *  Compares the two terms in lexicographic order, but using only the
     *  first r characters of each query.
     * @param charCount - The number of characters at the start of the Term you want to compare them by.
     * @return Instance of PrefixOrderComparator class.
     */
    public static Comparator<Term> byPrefixOrder(int charCount){
    	if (charCount < 0) {throw new IllegalArgumentException("Negative character count");}
    	return new PrefixOrderComparator(charCount);
    }
    
    
    
    /**
     * Compares the two terms in lexicographic order by the Term words. Compares while ignoring casing.
     * @param Other Term to compare to.
     * @return Returns int based on which Term word is larger when comparing the term words by ignore case.
     */
    @Override
    public int compareTo(Term that) {
    	return this.termValue.compareToIgnoreCase(that.termValue);
    }

    
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((termValue == null) ? 0 : termValue.hashCode());
		return result;
	}

    // Checks for equality only taking into account the word and ignoring the weight.
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Term other = (Term) obj;
		if (termValue == null) {
			if (other.termValue != null)
				return false;
		} else if (!termValue.equals(other.termValue))
			return false;
		return true;
	}

	
	
	/**
	 *  @return a string representation of this term in the following format:
	 *  the weight, followed by a tab, followed by the query.
	 */
	@Override
    public String toString() {
    	return termWeight + "\t" + termValue;
    }

    
	
    public static void main(String[] args) {
    	Term term1 = new Term("Apple", 1);
    	Term term2 = new Term("Add", 60);
    	Term term3 = new Term("Aiden", 10000);
    	Term term4 = new Term("Aid", 100);
    	Term[] terms = {term1, term2,term3, term4};
    	
    	System.out.println("Before Sort: " + Arrays.toString(terms));
    	Arrays.sort(terms, Term.byPrefixOrder(3));
    	System.out.println("After sorting by the first 3 charecters: " + Arrays.toString(terms));
    	
    	
    	Arrays.sort(terms, byReverseWeightOrder());
    	System.out.println("After sorting by weight (descending): " + Arrays.toString(terms));
    }
}
