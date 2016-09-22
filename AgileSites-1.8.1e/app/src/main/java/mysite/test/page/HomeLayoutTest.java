package mysite.test.page;
//import static wcs.Api.*;
import wcs.api.Log;
import wcs.api.Index;
import wcs.java.util.TestElement;
import org.junit.Before;
import org.junit.Test;
import mysite.element.page.HomeLayout;

// this test must be run by AgileSites TestRunnerElement
@Index("mysite/tests.txt")
public class HomeLayoutTest extends TestElement {
	final static Log log = Log.getLog(HomeLayoutTest.class); 
	HomeLayout it;
	
	@Before
	public void setUp() {
		it = new HomeLayout();
	}

	@Test
	public void test() {
		parse(it.apply(env("/Home")));
		// dump(log);
		assertText("#header h1", "Home Page Title");
	}
}
