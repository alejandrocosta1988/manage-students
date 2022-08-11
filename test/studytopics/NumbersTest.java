package studytopics;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;

class NumbersTest {

	@Test
	void testPrintableRepresentations() {
		assertEquals("101", Integer.toBinaryString(5));
		assertEquals("32", Integer.toHexString(50));
		assertEquals("21", Integer.toOctalString(17));
	}
	
	@Test
	void testPrintTrinaryString() {
		assertEquals("1022", Integer.toString(35, 3));
	}
	
	@Test
	void testDecodeFromHexOrOctal() {
		assertEquals(253, Integer.decode("0xFD"));
	}

	@Test
	void testGeneratingRandomFromSameSeed() {
		final long seed = 100L;
		final int total = 10;
		Random random1 = new Random(seed);
		List<Boolean> flips1 = new ArrayList<>();
		for (int i = 0; i < total; i++)
			flips1.add(random1.nextBoolean());
		
		Random random2 = new Random(seed);
		List<Boolean> flips2 = new ArrayList<>();
		for (int i = 0; i < total; i++)
			flips2.add(random2.nextBoolean());
		
		assertEquals(flips1, flips2);
	}
}
