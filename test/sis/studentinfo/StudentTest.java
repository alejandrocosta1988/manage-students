package sis.studentinfo;

public class StudentTest extends junit.framework.TestCase {

	final String firstStudentName = "Joy Algoz";
	final String secondStudentName = "Ada Heller";
	
	private Student firstStudent;
	private Student secondStudent;
	
	
	public void setUp() {
		firstStudent = new Student(firstStudentName);
		secondStudent = new Student(secondStudentName);
	}
	
	public void testCreate() {
		
		assertEquals(firstStudentName, firstStudent.getName());
		assertEquals(secondStudentName, secondStudent.getName());
		
	}
	
	public void testStudentStatus() {
		
		assertEquals(0, firstStudent.getCredits());
		assertFalse(firstStudent.isFullTime());
		
		firstStudent.addCredits(3);
		assertEquals(3, firstStudent.getCredits());
		assertFalse(firstStudent.isFullTime());

		firstStudent.addCredits(4);
		assertEquals(7, firstStudent.getCredits());
		assertFalse(firstStudent.isFullTime());

		firstStudent.addCredits(5);
		assertEquals(Student.CREDITS_REQUIRED_FOR_FULL_TIME, firstStudent.getCredits());
		assertTrue("not enough credits for fulltime status", firstStudent.isFullTime());
		
	}
	
	public void testInState() {
		
		assertFalse(secondStudent.isInState());
		secondStudent.setState(Student.IN_STATE);
		assertTrue(secondStudent.isInState());
		secondStudent.setState("MD");
		assertFalse(secondStudent.isInState());
		secondStudent.setState(Student.IN_STATE.toLowerCase());
		assertTrue(secondStudent.isInState());
		
	}
	
}
