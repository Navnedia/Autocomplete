package autocompleteproj;

import java.util.Arrays;

public class Autocomplete {

	private Term[] terms;
	
	
    /**
     * Constructor: 
     * Initializes the data structure from the given array of terms.
     * @param array of Term's (not null or any null elements).
     */
    public Autocomplete(Term[] terms) {
    	if (terms == null || checkForNull(terms)) {throw new IllegalArgumentException();}
    	this.terms = terms;
    	Arrays.sort(terms);
    }
    
    /**
     * Used to see if any element in a Term array is null.
     * @param array of Term's
     * @return true if any element is null, false otherwise.
     */
    private boolean checkForNull(Term[] terms) {
    	for (Term currentTerm : terms) {
    		if (currentTerm == null) {
    			return true;
    		}
    	}
    	return false;
    }

    
    
    /**
     * This is used to get a list of all the relevant suggestions.
     * @param prefix String to search for (not null).
     * @return all Term's that start with the given prefix, in descending order of weight.
     */
    public Term[] allMatches(String prefix) {
    	if (prefix == null) {throw new IllegalArgumentException();}
    	
    	int firstIndex = BinarySearchDeluxe.firstIndexOf(terms, new Term(prefix, 0), Term.byPrefixOrder(prefix.length()));
    	int lastIndex = BinarySearchDeluxe.lastIndexOf(terms, new Term(prefix, 0), Term.byPrefixOrder(prefix.length()));
    	if (firstIndex == -1 || lastIndex == -1) {return new Term[0];} // If nothing found return empty Term array.
    	
    	Term[] suggestedMatches = Arrays.copyOfRange(terms, firstIndex, lastIndex + 1); // Get prefix section.
    	Arrays.sort(suggestedMatches, Term.byReverseWeightOrder()); // Sort prefix section by weight.
    	
    	return suggestedMatches;
    }

    
    
    /**
     * Returns the number of terms that start with the given prefix.
     * @param prefix String to search for (not null).
     * @return int representing the number of Terms with matching start prefix.
     */
    public int numberOfMatches(String prefix) {
    	if (prefix == null) {throw new IllegalArgumentException();}
    	
    	int firstIndex = BinarySearchDeluxe.firstIndexOf(terms, new Term(prefix, 0), Term.byPrefixOrder(prefix.length()));
    	int lastIndex = BinarySearchDeluxe.lastIndexOf(terms, new Term(prefix, 0), Term.byPrefixOrder(prefix.length()));
    	
    	return lastIndex - firstIndex + 1;
    }

    
    public static void main(String[] args) {
    	Term t1 = new Term("Zack", 6);
    	Term t2 = new Term("Apple", 60);
    	Term t3 = new Term("ape", 89);
    	Term t4 = new Term("read", 300);
    	Term t5 = new Term("Abs", 1000);
    	Term[] tArray = {t1, t2, t3, t4, t5};
    	System.out.println(Arrays.toString(tArray));
    	Autocomplete ac = new Autocomplete(tArray);
    	System.out.println(Arrays.toString(ac.allMatches("rea")));
    }

}
