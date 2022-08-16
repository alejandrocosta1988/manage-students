package sis;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ sis.courseinfo.AllTests.class, sis.report.AllTests.class, sis.studentinfo.AllTests.class, sis.util.AllTests.class, sis.ui.AllTests.class })
public class AllTests {

}
