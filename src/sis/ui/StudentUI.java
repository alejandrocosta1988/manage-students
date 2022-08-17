package sis.ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import sis.studentinfo.Student;

public class StudentUI {
	
	static final String MENU = "(A)dd or (Q)uit?";
	static final String ADD_OPTION = "A";
	static final String NAME_PROMPT = "Name: ";
	static final String ADDED_MESSAGE = "Added";
	static final String QUIT_OPTION = "Q";
	
	private BufferedWriter writer;
	private BufferedReader reader;
	
	private List<Student> students = new ArrayList<>();
	
	public StudentUI() {
		reader = new BufferedReader(new InputStreamReader(System.in));
		writer = new BufferedWriter(new OutputStreamWriter(System.out));
	}
	
	public StudentUI(BufferedReader reader, BufferedWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	public void run() throws IOException {
		String line;
		do {
			write(MENU);
			line = reader.readLine();
			if (line.equals(ADD_OPTION))
				addStudent();
		} while (!line.equals(QUIT_OPTION));
	}
	
	private void addStudent() throws IOException {
		write(NAME_PROMPT);
		String name = reader.readLine();
		students.add(new Student(name));
		writeln(ADDED_MESSAGE);
	}
	
	private void write(String line) throws IOException {
		writer.write(line, 0, line.length());
		writer.flush();
	}
	
	private void writeln(String line) throws IOException {
		write(line);
		writer.newLine();
		writer.flush();
	}
	
	public List<Student> getAddedStudents() {
		return students;
	}

}
