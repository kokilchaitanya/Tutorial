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
public class DetailLayout extends Element {
	final static Log log = getLog(DetailLayout.class); 
	public static AssetSetup setup() {		
		return new Template("Page", "DetailLayout", 
			Template.LAYOUT, // change template type here
			"MySite_Detail", mysite.element.page.DetailLayout.class) //
			.cache("false", "false") // change caching here
			.description("Layout for type Page MySite_Detail");
	}

	@Override
	public String apply(Env e) {
		// log.trace("MySite_DetailLayout");
		Picker html = Picker.load("/mysite/simple.html" , "#content");	    
		Asset a = e.getAsset();
	    html.replace("#detail", a.getString("PageTitle"));
		String image = a.getBlobUrl("Blob");
		if (image == null)
			html.remove("#image-main");
		else
			html.attr("#image-main", "src", image);
		return html.html(a);
	}
}
