package sis.courseinfo;

import junit.framework.TestCase;

public class CourseTest extends TestCase {
	
	private Course courseA;
	private Course courseB;
	private Course courseC;
	private Course courseBPrime;
	
	@Override
	public void setUp() {
		courseA = new Course("NURS", "201");
		courseB = new Course("ARTH", "330");
		courseC = new Course("ARTH", "330");
		courseBPrime = new Course("ARTH", "330");
	}

	public void testCreate() {
		Course course = new Course("CMSC", "120");
		assertEquals("CMSC", course.getDepartment());
		assertEquals("120", course.getNumber());
	}
	
	public void testEquality() {
		assertEquals(courseB, courseC);
	}
	
	public void testDifference() {
		assertFalse(courseA.equals(courseB));
	}
	
	//equality contract
	public void testReflexivity() {
		assertEquals(courseA, courseA);
	}
	
	public void testTransitivity() {
		assertEquals(courseB, courseBPrime);
		assertEquals(courseC, courseB);
	}
	
	public void testSimetry() {
		assertEquals(courseB, courseC);
		assertEquals(courseC, courseB);
	}
	
	public void testConsistency() {
		assertEquals(courseC, courseBPrime);
	}
	
	public void testComparisonToNull() {
		assertFalse(courseC.equals(null));
	}
}
