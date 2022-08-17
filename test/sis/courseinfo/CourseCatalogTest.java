package sis.courseinfo;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import junit.framework.TestCase;

public class CourseCatalogTest extends TestCase {

	private CourseCatalog catalog;
	private Course course1;
	private Course course2;
	private Session session1;
	private Session session2;
	
	public void setUp() {
		catalog = new CourseCatalog();
		course1 = new Course("a", "1");
		course2 = new Course("a", "1");
		session1 = CourseSession.create(course1, LocalDate.of(2005, 1, 15));
		session2 = CourseSession.create(course2, LocalDate.of(2005, 1, 17));
		catalog.add(session1);
		catalog.add(session2);
	}
	
	public void testStoreAndLoad() throws IOException {
		final String filename = "CourseCatalogTest.testAdd.txt";
		catalog.store(filename);
		catalog.clearAll();
		assertEquals(0, catalog.getSessions().size());
		catalog.load(filename);
		List<Session> sessions = catalog.getSessions();
		assertEquals(2, sessions.size());
		assertSession(session1, sessions.get(0));
		assertSession(session2, sessions.get(1));
	}
	
	private void assertSession(Session expected, Session retrieved) {
		assertNotSame(expected, retrieved);
		assertEquals(expected.getNumberOfCredits(), retrieved.getNumberOfCredits());
		assertEquals(expected.getStartDate(), retrieved.getStartDate());
		assertEquals(expected.getDepartment(), retrieved.getDepartment());
		assertEquals(expected.getNumber(), retrieved.getNumber());
	}
}
