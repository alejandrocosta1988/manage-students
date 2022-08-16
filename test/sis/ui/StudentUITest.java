package sis.ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

import junit.framework.TestCase;
import sis.studentinfo.Student;

public class StudentUITest extends TestCase {
	
	static private final String name = "Leo Xerces Schmoo";
	
	public void testCreateStudent() throws IOException {
		StringBuffer expectedOutput = new StringBuffer();
		StringBuffer input = new StringBuffer();
		setUp(expectedOutput, input);
		byte[] buffer = input.toString().getBytes();
		
		InputStream inputStream = new ByteArrayInputStream(buffer);
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		
		OutputStream outputStream = new ByteArrayOutputStream();
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
		
		StudentUI ui = new StudentUI(reader, writer);
		ui.run();
		
		assertEquals(expectedOutput.toString(), outputStream.toString());
		assertStudents(ui.getAddedStudents());
	}
	
	private void setUp(StringBuffer expectedOutput, StringBuffer input) {
		expectedOutput.append(StudentUI.MENU);
		input.append(line(StudentUI.ADD_OPTION));
		expectedOutput.append(StudentUI.NAME_PROMPT);
		input.append(line(name));
		expectedOutput.append(line(StudentUI.ADDED_MESSAGE));
		expectedOutput.append(StudentUI.MENU);
		input.append(line(StudentUI.QUIT_OPTION));
	}
	
	private String line(String input) {
		return String.format("%s%n", input);
	}
	
	private void assertStudents(List<Student> students) {
		assertEquals(1, students.size());
		Student student = students.get(0);
		assertEquals(name, student.getName());
	}

}
