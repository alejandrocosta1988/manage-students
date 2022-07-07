package sis.studentinfo;

public class StudentTest extends junit.framework.TestCase {

	final String firstStudentName = "Joy Algoz";
	final String secondStudentName = "Ada Heller";
	
	private static final double GRADE_TOLERANCE = 0.05;
	
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
	
	public void testCalculateGpa() {
		assertGpa(firstStudent, 0.0);
		firstStudent.addGrade(Student.Grade.A);
		assertGpa(firstStudent, 4.0);
		firstStudent.addGrade(Student.Grade.B);
		assertGpa(firstStudent, 3.5);
		firstStudent.addGrade(Student.Grade.C);
		assertGpa(firstStudent, 3.0);
		firstStudent.addGrade(Student.Grade.D);
		assertGpa(firstStudent, 2.5);
		firstStudent.addGrade(Student.Grade.F);
		assertGpa(firstStudent, 2.0);
	}
	
	private void assertGpa(Student student, double expectedGpa) {
		assertEquals(expectedGpa, student.getGpa(), GRADE_TOLERANCE);
	}
	
	public void testCalculateHonorsStudentGpa() {
		assertGpa(createHonorsStudent(), 0.0);
		assertGpa(createHonorsStudent(Student.Grade.A), 5d);
	}
	
	private Student createHonorsStudent() {
		Student student = new Student("a");
		student.setHonors();
		return student;
	}
	
	private Student createHonorsStudent(Student.Grade grade) {
		Student student = createHonorsStudent();
		student.addGrade(grade);
		return student;
	}
}
