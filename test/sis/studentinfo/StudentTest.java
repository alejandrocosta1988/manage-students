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

		student.addCredits(7);
		assertEquals(10, student.getCredits());
		assertFalse(student.isFullTime());
		
	}
	
}
