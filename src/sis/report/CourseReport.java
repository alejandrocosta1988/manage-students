package sis.report;

import static sis.report.Report.NEWLINE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import sis.courseinfo.Session;

public class CourseReport {
	
	private List<Session> sessions = new ArrayList<>();

	void add(Session courseSession) {
		sessions.add(courseSession);
	}
	
	public String text() {
		Collections.sort(sessions);
		StringBuilder builder = new StringBuilder();
		for (Session session : sessions) {
			builder.append(session.getDepartment() + " " + session.getNumber() + NEWLINE);
		}
		return builder.toString();
	}
	
}
