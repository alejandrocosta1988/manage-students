package sis;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ sis.courseinfo.CourseSessionTest.class, sis.studentinfo.StudentTest.class, sis.report.RosterReporterTest.class })
public class AllTests {

}
