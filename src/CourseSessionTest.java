import junit.framework.TestCase;

public class CourseSessionTest extends TestCase {

	public void testCreate() {
		
		CourseSession session = new CourseSession("ENGL", "101");
		
		assertEquals("ENGL", session.getDepartment());
		assertEquals("101", session.getNumber());
		
	}
	
}
