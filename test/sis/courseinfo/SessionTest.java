package sis.courseinfo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;
import sis.studentinfo.Student;

public abstract class SessionTest extends TestCase {

	private Session session;
	private LocalDate startDate;
	private static final int CREDITS = 3;
	
	@Override
	public void setUp() {
		startDate = LocalDate.of(2003, 1, 6);
		session = createSession("ENGL", "101", startDate);
		session.setNumberOfCredits(CREDITS);
	}

	protected abstract Session createSession(String department, String number, LocalDate startDate);
	
	@Test
	public void testSessionsAreInitializedWithDepartmentDataStartDateOfCourseAndNoStudents() {
		assertEquals("ENGL", session.getDepartment());
		assertEquals("101", session.getNumber());
		assertEquals(0, session.getNumberOfStudents());
		assertEquals(startDate, session.getStartDate());
	}
	
	@Test
	public void testEnrolledStudentsEarnCreditsAndAreAvailableInAColelction() {
		Student student1 = new Student("Cal DiVoe");
		session.enroll(student1);
		assertEquals(CREDITS, student1.getCredits());
		assertEquals(1, session.getNumberOfStudents());
		assertEquals(student1, session.get(0));
		
		Student student2 = new Student("Coralee DeVaughn");
		session.enroll(student2);
		assertEquals(CREDITS, student2.getCredits());
		assertEquals(2, session.getNumberOfStudents());
		assertEquals(student1, session.get(0));
		assertEquals(student2, session.get(1));
	}
	
	@Test
	public void testSessionsAreComparedByDepartmentNameAndThenByDepartmentNumber() {
		final LocalDate date = LocalDate.now();
		Session sessionA = createSession("CMSC", "101", date);
		Session sessionB = createSession("ENGL", "101", date);
		assertTrue(sessionA.compareTo(sessionB) < 0);
		assertTrue(sessionB.compareTo(sessionA) > 0);
		
		Session sessionC = createSession("CMSC", "101", date);
		assertEquals(0, sessionA.compareTo(sessionC));
		
		Session sessionD = createSession("CMSC", "210", date);
		assertTrue(sessionC.compareTo(sessionD) < 0);
		assertTrue(sessionD.compareTo(sessionC) > 0);
	}
	
	@Test
	public void testSessionsLastAtLeastOneWeek() {
		Session session = createSession("DEPT", "101", LocalDate.now());
		assertTrue(session.getSessionLength() > 0);
	}
	
	@Test
	public void testAverageGpaForPartTimeStudents() {
		session.enroll(createFullTimeStudent());
		
		Student partTimer1 = new Student("1");
		partTimer1.addGrade(Student.Grade.A);
		session.enroll(partTimer1);
		
		session.enroll(createFullTimeStudent());
		
		Student partTimer2 = new Student("2");
		partTimer2.addGrade(Student.Grade.B);
		session.enroll(partTimer2);
		
		assertEquals(3.5, session.averageGpaForPartTimeStudents(), 0.05);
		
	}
	
	private Student createFullTimeStudent() {
		Student student = new Student("Agar Uri");
		student.addCredits(Student.CREDITS_REQUIRED_FOR_FULL_TIME);
		return student;
	}
	
	@Test
	public void testGivenASessionWithEnrolledStudentsItIsPossibleToIterateThroughTheStudents() {
		enrollStudents(session);
		List<Student> results = new ArrayList<>();
		for (Student student : session) {
			results.add(student);
		}
		assertEquals(session.getAllStudents(), results);
	}
	
	private void enrollStudents(Session session) {
		session.enroll(new Student("1"));
		session.enroll(new Student("2"));
		session.enroll(new Student("3"));
	}
}
