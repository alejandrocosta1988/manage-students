import java.util.ArrayList;

import junit.framework.TestCase;

public class CourseSessionTest extends TestCase {

	public void testCreate() {
		
		CourseSession session = new CourseSession("ENGL", "101");
		
		assertEquals("ENGL", session.getDepartment());
		assertEquals("101", session.getNumber());
		assertEquals(0, session.getNumberOfStudents());
		
	}
	
	public void testEnrollStudents() {
		
		CourseSession session = new CourseSession("ENGL", "101");
		
		Student student1 = new Student("Alg Mei");
		Student student2 = new Student("Kim Jones");
		
		session.enroll(student1);
		assertEquals(1, session.getNumberOfStudents());
		ArrayList<Student> allStudents = session.getAllStudents();
		assertEquals(1, allStudents.size());
		assertEquals(student1, allStudents.get(0));

		session.enroll(student2);
		assertEquals(2, session.getNumberOfStudents());
		assertEquals(2, allStudents.size());
		assertEquals(student1, allStudents.get(0));
		assertEquals(student2, allStudents.get(1));
		
	}
	
}
