import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ courseinfo.CourseSessionTest.class, studentinfo.StudentTest.class, courseinfo.RosterReporterTest.class })
public class AllTests {

}
