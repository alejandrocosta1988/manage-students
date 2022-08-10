package sis.courseinfo;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

public class testHashCodePerformance extends TestCase {

	public void testCourseHashMapPerformance() {
		final int count = 10000;
		long start = System.currentTimeMillis();
		Map<Course, String> map = new HashMap<>();
		for (int i = 0; i < count; i++) {
			Course course = new Course("C" + i, "" + i);
			map.put(course, "");
		}
		long stop = System.currentTimeMillis();
		long elapsed = stop - start;
		final long arbitraryThreshold = 200;
		assertTrue("elapsed time = " + elapsed, elapsed < arbitraryThreshold);
	}
	
}
