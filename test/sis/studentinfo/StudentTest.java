package sis.studentinfo;

public class StudentTest extends junit.framework.TestCase {

	final String firstStudentName = "Joy Algoz";
	final String secondStudentName = "Heller";
	final String thirdStudentName = "Jane Mid Goess";
	
	private static final double GRADE_TOLERANCE = 0.05;
	
	private Student firstStudent;
	private Student secondStudent;
	private Student thirdStudent;
	
	
	public void setUp() {
		firstStudent = new Student(firstStudentName);
		secondStudent = new Student(secondStudentName);
		thirdStudent = new Student(thirdStudentName);
	}
	
	public void testAStudentHoldsItsFullName() {
		assertEquals(firstStudentName, firstStudent.getName());
		assertEquals(secondStudentName, secondStudent.getName());
	}
	
	public void testGivenAStudentGetFirstNameReturnsItsFirstName() {
		assertEquals("Joy", firstStudent.getFirstName());
	}
	
	public void testGivenAStudentWithTwoNamesGetLastNameReturnsItsLastName() {
		assertEquals("Algoz", firstStudent.getLastName());
	}
	
	public void testGivenAStudentWithTwoNamesGetMiddleNameReturnsEmptyString() {
		assertEquals("", firstStudent.getMiddleName());
	}
	
	public void testGivenAStudentWithThreeNamesGetLastNameReturnsItsLastName() {
		assertEquals("Goess", thirdStudent.getLastName());
	}
	
	public void testGivenAStudentWithThreeNamesGetMiddleNameReturnsItsMiddleName() {
		assertEquals("Mid", thirdStudent.getMiddleName());
	}
	
	public void testGivenAStudentWithASingleNameGetLastNameReturnsItsName() {
		assertEquals("Heller", secondStudent.getLastName());
	}
	
	public void testGivenAStudentWithASingleNameGetFirstNameReturnsEmptyStrings() {
		assertEquals("", secondStudent.getFirstName());
	}
	
	public void testBaddlyFormattedName() {
		try {
			new Student("a b c d");
			fail("expected exception from 4-part name");
		} catch (StudentNameFormatException expectedException) {
			assertEquals(
					"Student name 'a b c d' contains more than 3 parts.",
					expectedException.getMessage());
		}
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
		student.setGradingStrategy(new HonorsGradingStrategy());
		return student;
	}
	
	private Student createHonorsStudent(Student.Grade grade) {
		Student student = createHonorsStudent();
		student.addGrade(grade);
		return student;
	}
	
	public void testCharges() {
		firstStudent.addCharge(500);
		firstStudent.addCharge(200);
		firstStudent.addCharge(399);
		assertEquals(1099, firstStudent.totalCharges());
	}
}
