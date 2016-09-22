package mysite.element.page;
import static wcs.Api.*;
import wcs.api.Log;
import wcs.api.Index;
import wcs.api.Env;
import wcs.api.Asset; 
import wcs.java.Picker;
import wcs.java.Element;
import wcs.java.Template;
import wcs.java.AssetSetup;

@Index("mysite/elements.txt")
public class PressReleaseLayout extends Element {
	final static Log log = getLog(PressReleaseLayout.class); 
	public static AssetSetup setup() {		
		return new Template("Page", "PressReleaseLayout", 
			Template.LAYOUT, // change template type here
			"MySite_PressRelease", mysite.element.page.PressReleaseLayout.class) //
			.cache("false", "false") // change caching here
			.description("Layout for type Page MySite_PressRelease");
	}

	@Override
	public String apply(Env e) {
		// log.trace("MySite_PressReleaseLayout");
		Picker html = Picker.load("/mysite/Detail.html", "#container");	    
		Asset a = e.getAsset();
		html.replace("#headerid", "anything");
		return html.html(a);
	}
}
