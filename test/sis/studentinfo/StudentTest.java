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
	
	public void testFullTime() {
		
		Student student = new Student("Alba");
		assertFalse(student.isFullTime());
		
	}
	
	public void testCredits() {
		
		Student student = new Student("Alba");
		assertEquals(0, student.getCredits());
		student.addCredits(3);
		assertEquals(3, student.getCredits());
		student.addCredits(7);
		assertEquals(10, student.getCredits());
		
	}
}
