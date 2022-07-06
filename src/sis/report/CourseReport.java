package sis.report;

import java.util.ArrayList;

import sis.courseinfo.CourseSession;

import static sis.report.Report.NEWLINE;

public class CourseReport {
	
	private ArrayList<CourseSession> sessions = new ArrayList<>();

	void add(CourseSession courseSession) {
		sessions.add(courseSession);
	}
	
	public String text() {
		StringBuilder builder = new StringBuilder();
		for (CourseSession session : sessions) {
			builder.append(session.getDepartment() + " " + session.getNumber() + NEWLINE);
		}
		return builder.toString();
	}
	
}
