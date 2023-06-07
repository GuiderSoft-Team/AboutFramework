package junit.testsuite;

import junit.Example1;
import junit.Example2;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        Example1.class,
        Example2.class
})
class JunitTestSuite {
}
