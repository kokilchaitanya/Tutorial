package mysite;
import wcs.java.util.Util;

public class Setup extends wcs.java.Setup {
	@Override
	public Class<?>[] getAssets() {
		return Util.classesFromResource("MySite", "elements.txt");
	}
}
