package sis.courseinfo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class CourseCatalog {
	
	private List<Session> sessions = new ArrayList<>();

	public void add(Session session) {
		sessions.add(session);
	}
	
	public void clearAll() {
		sessions.clear();
	}

	public List<Session> getSessions() {
		return sessions;
	}

	public void store(String filename) throws IOException {
		ObjectOutputStream output = null;
		try {
			output = new ObjectOutputStream(new FileOutputStream(filename));
			output.writeObject(sessions);
		}
		finally {
			output.close();
		}
	}

	public void load(String filename) throws IOException, ClassNotFoundException {
		ObjectInputStream input = null;
		try {
			input = new ObjectInputStream(new FileInputStream(filename));
			sessions = (List<Session>)input.readObject();
		}
		finally {
			input.close();
		}
	}
	
}
