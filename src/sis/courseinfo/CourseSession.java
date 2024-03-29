package sis.courseinfo;
import java.time.LocalDate;

/**
 * Represents a course session offered in a single-semester by an university.
 * 
 * @author Alejandro Costa 
 *
 */
public class CourseSession extends Session {
	
	private static int count;
	
	/**
	 * Constructs a CourseSession holding information on the department identification, course number, and a specific initial date for the course
	 * 
	 * @param department the identification of the department responsible for the CourseSession
	 * @param number the number identification of the course
	 * @param startDate the date on which the course begins
	 */
	private CourseSession(Course course, LocalDate startDate) {
		super(course, startDate);
	}
	
	public static CourseSession create(Course course, LocalDate startDate) {
		incrementCount();
		return new CourseSession(course, startDate);
	}

	private static void incrementCount() {
		++count;
	}

	public static int getCount() {
		return count;
	}
	
	public static void resetCount() {
		count = 0;
	}

	protected long getSessionLength() {
		return 16L;
	}

}
