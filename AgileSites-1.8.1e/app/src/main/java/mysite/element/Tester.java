package mysite.element;
import wcs.api.Index;
import wcs.java.AssetSetup;
import wcs.java.CSElement;
import wcs.java.SiteEntry;
import wcs.java.util.Util;
import wcs.java.util.TestRunnerElement;

@Index("mysite/elements.txt")
public class Tester extends TestRunnerElement {
	public static AssetSetup setup() {
		return new CSElement("Tester", mysite.element.Tester.class, //
				new SiteEntry("Tester", false));
	}

	@Override
	public Class<?>[] tests() {
		// all the tests of the suite
		return Util.classesFromResource("MySite", "tests.txt");
	}
}
