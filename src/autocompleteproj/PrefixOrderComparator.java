package autocompleteproj;

import java.util.Comparator;

public class PrefixOrderComparator implements Comparator<Term> {

	private final int charCount;
	
	public PrefixOrderComparator(int charCount) {
		this.charCount = charCount;
	}
	
	@Override
	public int compare(Term t1, Term t2) {
		String t1SubString = getTermSubString(t1);
		String t2SubString = getTermSubString(t2);
		
		return t1SubString.compareToIgnoreCase(t2SubString);
	}
	
	private String getTermSubString(Term t) {
		String termValue = t.termValue;
		int valueLength = termValue.length();
		if (valueLength < charCount) {
			return termValue.substring(0, valueLength);
		} else {
			return termValue.substring(0, charCount);
		}
	}
	
}
