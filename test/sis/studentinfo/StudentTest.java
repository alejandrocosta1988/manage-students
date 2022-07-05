package sis.studentinfo;

public class StudentTest extends junit.framework.TestCase {

	public void testCreate() {
		
		final String firstStudentName = "Alejandro Costa";
		final String secondStudentName = "Martin Fowler";
		
		Student firstStudent = new Student(firstStudentName);
		Student secondStudent = new Student(secondStudentName);
		
		assertEquals(firstStudentName, firstStudent.getName());
		assertEquals(secondStudentName, secondStudent.getName());
		
	}
	
	public void testStudentStatus() {
		
		Student student = new Student("Alba");
		assertEquals(0, student.getCredits());
		assertFalse(student.isFullTime());
		
		student.addCredits(3);
		assertEquals(3, student.getCredits());
		assertFalse(student.isFullTime());

		student.addCredits(4);
		assertEquals(7, student.getCredits());
		assertFalse(student.isFullTime());

		student.addCredits(5);
		assertEquals(Student.CREDITS_REQUIRED_FOR_FULL_TIME, student.getCredits());
		assertTrue("not enough credits for fulltime status", student.isFullTime());
		
	}
	
	public void testInState() {
		
		Student student = new Student("Ada Niels");
		assertFalse(student.isInState());
		student.setState(Student.IN_STATE);
		assertTrue(student.isInState());
		student.setState("MD");
		assertFalse(student.isInState());
		student.setState(Student.IN_STATE.toLowerCase());
		assertTrue(student.isInState());
		
	}
	
}
