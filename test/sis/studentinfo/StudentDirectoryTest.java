package sis.studentinfo;

import java.io.IOException;

import junit.framework.TestCase;

public class StudentDirectoryTest extends TestCase {

	private StudentDirectory directory;
	
	public void setUp() {
		directory = new StudentDirectory();
	}
	
	public void testStoreAndRetrieve() throws IOException {
		final int numberOfStudents = 10;
		
		for (int i = 0; i < numberOfStudents; i++) {
			addStudent(directory, i);
		}
		
		for (int i = 0; i < numberOfStudents; i++) {
			verifyStudentLookup(directory, i);
		}
	}
	
	public void addStudent(StudentDirectory directory, int i) throws IOException {
		String id = "" + i;
		Student student = new Student(id);
		student.setId(id);
		student.addCharge(i);
		directory.add(student);
	}
	
	public void verifyStudentLookup(StudentDirectory directory, int i) throws IOException {
		String id = "" + i;
		Student student = directory.findById(id);
		assertEquals(id, student.getLastName());
		assertEquals(id, student.getId());
		assertEquals(i, student.getCredits());
	}
}
