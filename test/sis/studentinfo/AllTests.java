package sis.studentinfo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ StudentTest.class, BasicGradingStrategyTest.class, HonorsGradingStrategyTest.class,
				PerformanceTest.class})
public class AllTests {

}
