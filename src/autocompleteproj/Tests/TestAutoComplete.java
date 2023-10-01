package autocompleteproj.Tests;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import autocompleteproj.Autocomplete;
import autocompleteproj.Term;
import edu.princeton.cs.algs4.In;

class TestAutoComplete {

	private static Autocomplete uut;
	private static final String testFileName = "testfile.txt";
	@SuppressWarnings("unused")
	private static Map<String, Term[]> expected;
	
	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	void testExceptions() {
		// Test Term constructor with invalid arguments:
		assertThrows(IllegalArgumentException.class, () -> new Autocomplete(null), "Wrong or no exception thrown");
		
		Term t1 = new Term("test", 0);
		Term[] testTerms = {t1, null};
		assertThrows(IllegalArgumentException.class, () -> new Autocomplete(testTerms), "Wrong or no exception thrown");
		
		
		assertThrows(IllegalArgumentException.class, () -> uut.allMatches(null), "Wrong or no exception thrown");
		assertThrows(IllegalArgumentException.class, () -> uut.numberOfMatches(null), "Wrong or no exception thrown");
	}
	
	@BeforeAll
	static void generateExpected() {
		expected = new HashMap<>();
//		Term t1 = new Term("", 0);
//		Term t1 = new Term("", 0);
//		Term t1 = new Term("", 0);
//		Term t1 = new Term("", 0);
//		Term t1 = new Term("", 0);
//		String[] words = {"apple", "car", ""}; 
	}
	
	@Before
	void readfile() {
		// Read in the data
        Term[] terms = null;
        try {
            In in = new In(testFileName);
            String line0 = in.readLine();
            if (line0 == null) {
                System.err.println("Could not read line 0 of " + testFileName);
                System.exit(1);
            }
            int n = Integer.parseInt(line0);
            terms = new Term[n];
            for (int i = 0; i < n; i++) {
                String line = in.readLine();
                if (line == null) {
                    System.err.println("Could not read line " + (i+1) + " of " + testFileName);
                    System.exit(1);
                }
                int tab = line.indexOf('\t');
                if (tab == -1) {
                    System.err.println("No tab character in line " + (i+1) + " of " + testFileName);
                    System.exit(1);
                }
                long weight = Long.parseLong(line.substring(0, tab).trim());
                String query = line.substring(tab + 1);
                terms[i] = new Term(query, weight);
            }
        }
        catch (Exception e) {
            System.err.println("Could not read or parse input file " + testFileName);
            e.printStackTrace();
            System.exit(1);
        }

        // Create the autocomplete object
        uut = new Autocomplete(terms);
	}

}
