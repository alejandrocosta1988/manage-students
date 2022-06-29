
public class StudentTest extends junit.framework.TestCase {

	public void testCreate() {
		
		final String firstStudentName = "Alejandro Costa";
		final String secondStudentName = "Martin Fowler";
		
		Student firstStudent = new Student(firstStudentName);
		Student secondStudent = new Student(secondStudentName);
		
		assertEquals(firstStudentName, firstStudent.getName());
		assertEquals(secondStudentName, secondStudent.getName());
		
	}
}
