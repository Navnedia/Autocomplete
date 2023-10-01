package autocompleteproj;

import java.util.Arrays;
import java.util.Comparator;

// Adapted from: https://www.geeksforgeeks.org/binary-search/?ref=lbp to look for the first occurrence and to work for Terms. 
public class BinarySearchDeluxe {
	
	/**
     *  Returns the index of the first key in the sorted array a[]
     *  that is equal to the search key, or -1 if no such key.
     * @param array of all Terms (not null).
     * @param searchPrefix Term to search for (not null).
     * @param comparator for comparing the Terms to the searchPrefix Term (not null).
     * @return the first index of the given start prefix in the array of Terms. Returns the index of the first key in the sorted array a[]
     * that is equal to the search key, or -1 if no such key.
     */
    public static int firstIndexOf(Term[] terms, Term searchPrefix, Comparator<Term> comparator) {
    	if ((terms == null) || (searchPrefix == null) || (comparator == null)) {throw new IllegalArgumentException();}
    	
    	int leftBound = 0;
    	int rightBound = terms.length - 1;
    	
    	while (leftBound <= rightBound) {
    		int middleIndex = leftBound + (rightBound - leftBound) / 2;
    		int compare = comparator.compare(searchPrefix, terms[middleIndex]);
    		
    		if (compare == 0) {
    			int tempIndex = middleIndex;
    			
    			while (true) {
    				if(tempIndex - 1 < 0)
    				{
    					return tempIndex;
    				}
    				if (comparator.compare(searchPrefix, terms[tempIndex - 1]) == 0) {
    					tempIndex--;
    				} else {
    					return tempIndex;
    				}
    			}
    		}
    		if (compare >= 1) {
				leftBound = middleIndex + 1;
			} else {
				rightBound = middleIndex - 1;
			}
    	}
    	return -1;
    }

    /**
     *  Returns the index of the last key in the sorted array a[]
     *  that is equal to the search key, or -1 if no such key.
     * @param array of all Terms (not null).
     * @param searchPrefix Term to search for (not null).
     * @param comparator for comparing the Terms to the searchPrefix Term (not null).
     * @return the last index of the given start prefix in the array of Terms. Returns the index of the last key in the sorted array a[]
     * that is equal to the search key, or -1 if no such key.
     */
    public static int lastIndexOf(Term[] terms, Term searchPrefix, Comparator<Term> comparator) {
    	if ((terms == null) || (searchPrefix == null) || (comparator == null)) {throw new IllegalArgumentException();}

    	int leftBound = 0;
    	int rightBound = terms.length - 1;
    	
    	while (leftBound <= rightBound) {
    		int middleIndex = leftBound + (rightBound - leftBound) / 2;
    		int compare = comparator.compare(searchPrefix, terms[middleIndex]);
    		
    		if (compare == 0) {
    			int tempIndex = middleIndex;
    			while (true) {
    				if(tempIndex + 1 >= terms.length)
    				{
    					return tempIndex;
    				}
    				if (comparator.compare(searchPrefix, terms[tempIndex + 1]) == 0) {
    					tempIndex++;
    				} else {
    					return tempIndex;
    				}
    			}
    		}
    		if (compare >= 1) {
				leftBound = middleIndex + 1;
			} else {
				rightBound = middleIndex - 1;
			}
    	}
    	return -1;
    	
    }

    
   
    public static void main(String[] args) {
    	Term t0 = new Term("Apple", 0);
    	Term t1 = new Term("Art", 0);
    	Term t2 = new Term("Argument", 0);
    	Term t3 = new Term("Cart", 0);
    	Term t4 = new Term("Check", 0);
    	Term t5 = new Term("See", 0);
    	Term t6 = new Term("Seek", 0);
    	Term t7 = new Term("Secratary", 0);
    	Term t8 = new Term("Sleep", 0);
    	Term t9 = new Term("Walk", 0);
    	Term t10 = new Term("Zack", 0);
    	Term[] terms = {t0, t1, t2, t3, t4, t5, t6 ,t7, t8, t9, t10};
    	
    	Term queryTerm = new Term("Se", 0);
    	
    	System.out.println("Search List: " + Arrays.toString(terms));
    	System.out.println("Search Query: " + queryTerm.termValue);
    	System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------\n");
    	
    	int first = firstIndexOf(terms, queryTerm, Term.byPrefixOrder(2));
    	int last = lastIndexOf(terms, queryTerm, Term.byPrefixOrder(2));
    	
    	System.out.println("Frist Index: " + first + ", Value: " + terms[first].termValue);
    	System.out.println("Last Index: " + last + ", Value: " + terms[last].termValue);
    }
}
