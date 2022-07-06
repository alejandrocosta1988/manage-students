package sis.report;

import static sis.report.Report.NEWLINE;

import java.util.ArrayList;
import java.util.Collections;

import sis.courseinfo.CourseSession;

public class CourseReport {
	
	private ArrayList<CourseSession> sessions = new ArrayList<>();

	void add(CourseSession courseSession) {
		sessions.add(courseSession);
	}
	
	public String text() {
		Collections.sort(sessions);
		StringBuilder builder = new StringBuilder();
		for (CourseSession session : sessions) {
			builder.append(session.getDepartment() + " " + session.getNumber() + NEWLINE);
		}
		return builder.toString();
	}
	
}
