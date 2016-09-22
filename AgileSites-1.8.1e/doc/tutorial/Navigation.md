##### Prev:  [Edit Content](EditContent.md) - Next: [Export](Export.md)

In this section we will see how to create links and how to use them to build naviations.

## Create a Link

The general rule to create a link is using the method `Asset.getUrl`. However you generally need to load the asset to do this. 

Since you generally generate links for assets pointed by attributes, this is the typical code you write:

```java
a.getAsset("Related", "Page").getUrl()
```

Another option is to use the `Env.getUrl(id)`. To use this method, you need an id. You use this method when you navigate the siteplan.

## Dependencies

When you retrieve assets by id you need to be aware of dependencies (see the development manual about it)

By default `a.getAsset()` does not log any dependencies. This is correct if you use the asset only for creating a link.

However if you are going to extract attributes and render them in the current pagelent, then you need to log dependencies.

```
a.getAsset(c, cid, AssetDeps.EXIST)
```

The best practice is to create a separate Pagelet for each asset, but when you build navigation you may end up with too many pagelets so in such a case it is approriate to render a single pagelet with values coming from multiple assets.

Be sure to log all the dependencies in such a case.

## SitePlan

The `SitePlan` class helps you to navigate in the siteplan. 

You get a siteplan instance with `e.getSitePlan()`. The SitePlan has a concept of current node in the siteplan, and by default it is the current site.  You can then do the following:

- `sp.children()` returns the children of the current nodem as an array of Ids
- `sp.goTo(id)` lets you to change the current id
- `sp.getPath()` return the path (as an array of id) from the current asset up to the root. 

Note that in the path the current node is excluded so when you are at the root, the path is an array of zero elements.

## Top Level Menu 

Using the SitePlan this is the code to create the top level menu, that create a StringBuilder with to Pages located to the top level of the site plan:

```java
StringBuilder sb = new StringBuilder();
SitePlan sp = e.getSitePlan();
for (Id id : sp.children()) {
	String name = e.getAsset(id).getName();
	sb.append(
	  format("<a href='%s'>%s</a> |", 
			  e.getUrl(id), name));
}
```

