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
public class HomeLayout extends Element {
	final static Log log = getLog(HomeLayout.class); 
	public static AssetSetup setup() {		
		return new Template("Page", "HomeLayout", 
			Template.LAYOUT, // change template type here
			"MySite_Home", mysite.element.page.HomeLayout.class) //
			.cache("false", "false") // change caching here
			.description("Layout for type Page MySite_Home");
	}

	@Override
	public String apply(Env e) {
		// log.trace("MySite_HomeLayout");
		Picker html = Picker.load("/mysite/simple.html" , "#content");	    
		Asset a = e.getAsset();
		html.replace("#header",a.getDescription());
		String fi="PageTitle";
		String te=(a.getString("PageTitle"));
		html.replace("#detail", a.getString("Title"));
		String image = a.getBlobUrl("Blob");
		int aid=a.getSize("Related");
		String strid=String.valueOf(aid);
		html.replace("#temp", strid);
		if (image == null)
			html.remove("#image-main");
		else
			html.attr("#image-main", "src", image);
			
			for(int j=1;j<=aid;j++)
			{
		html.append("#footer", a.getAsset("Related", "Page", j).call("DetailLayout"));
		}
		return html.html(a);
	}
}
