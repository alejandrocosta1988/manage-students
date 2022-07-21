package sis.studentinfo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class testJavaLoops {

	private final String SEQUENCE = "1,2,3,4,5";
	
	@Test
	void testPrintsSequenceOfIntegersSeparatedByCommasWithDoLoop() {
		assertEquals(SEQUENCE, sequenceUsingDo(1, 5));
	}
	
	@Test
	void testPrintsSequenceOfIntegersSeparatedByCommasWithForLoop() {
		assertEquals(SEQUENCE, sequenceUsingFor(1, 5));
	}
	
	@Test
	void testPrintsSequenceOfIntegersSeparatedByCommasWithWhileLoop() {
		assertEquals(SEQUENCE, sequenceUsingWhile(1, 5));
	}
	
	@Test
	void testPrintsSameNumberOfInputWhenItIsUnique() {
		assertEquals("8", sequenceUsingWhile(8, 8));
		assertEquals("8", sequenceUsingDo(8, 8));
		assertEquals("8", sequenceUsingFor(8, 8));
	}
	
	String sequenceUsingDo(int start, int stop) {
		StringBuilder builder = new StringBuilder();
		int i = start;
		do {
			if (i > start)
				builder.append(',');
			builder.append(i);
		} while (++i <= stop);
		return builder.toString();
	}
	
	String sequenceUsingFor(int start, int stop) {
		StringBuilder builder = new StringBuilder();
		for (int i = start; i <= stop; i++) {
			if (i > start)
				builder.append(',');
			builder.append(i);
		}
		return builder.toString();
	}
	
	String sequenceUsingWhile(int start, int stop) {
		StringBuilder builder = new StringBuilder();
		int i = start;
		while (i <= stop) {
			if (i > start)
				builder.append(",");
			builder.append(i);
			i++;
		}
		return builder.toString();
	}

}
