package mysite.test.page;
//import static wcs.Api.*;
import wcs.api.Log;
import wcs.api.Index;
import wcs.java.util.TestElement;
import org.junit.Before;
import org.junit.Test;
import mysite.element.page.DetailLayout;

// this test must be run by AgileSites TestRunnerElement
@Index("mysite/tests.txt")
public class DetailLayoutTest extends TestElement {
	final static Log log = Log.getLog(DetailLayoutTest.class); 
	DetailLayout it;
	
	@Before
	public void setUp() {
		it = new DetailLayout();
	}

	@Test
	public void test() {
		parse(it.apply(env("/Home")));
		// dump(log);
		assertText("#header h1", "Home Page Title");
	}
}
