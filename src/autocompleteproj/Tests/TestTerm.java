package autocompleteproj.Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Random;

import org.junit.jupiter.api.Test;

import autocompleteproj.Term;

class TestTerm {

	private Random rand = new Random();
	
	// Test compare stuff
	
	@Test
	void testCreateTerm() {
		// Generate random query and weight:
		String expectedQuery = ((char)('a' + rand.nextInt())) + "";
		long expectedWeight = rand.nextInt(1000);
		
		// Construct Term:
		Term uut = new Term(expectedQuery, expectedWeight);
		
		// Test Term for correct query and weight:
		assertEquals("Term query value was incorrect", expectedQuery, uut.termValue); // Test for correct query.
		assertEquals("Term weight was incorrect", expectedWeight, uut.termWeight); // Test for correct weight.
	}
	
	@Test
	void testALot() {
		for (int i = 0; i < 1000; i++) {
			testCreateTerm();
		}
	}
	
	@Test
	void testExceptions() {
		// Test Term constructor with invalid arguments:
		assertThrows(IllegalArgumentException.class, () -> new Term(null, 1), "Wrong or no exception thrown"); // Test null query string.
		assertThrows(IllegalArgumentException.class, () -> new Term("test", -1), "Wrong or no exception thrown"); // Test negative weight.
		assertThrows(IllegalArgumentException.class, () -> new Term(null, -1), "Wrong or no exception thrown"); // Test null query and negative weight.
		
		// Test byPrefixOrder invalid argument:
		assertThrows(IllegalArgumentException.class, () -> Term.byPrefixOrder(-1), "Wrong or no exception thrown"); // Test negative character count.
	}

}
