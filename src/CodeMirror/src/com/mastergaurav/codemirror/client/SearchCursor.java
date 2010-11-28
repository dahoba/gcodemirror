package com.mastergaurav.codemirror.client;

import com.google.gwt.core.client.JavaScriptObject;

public class SearchCursor
{
	private JavaScriptObject sc;

	SearchCursor(JavaScriptObject sc)
	{
		this.sc = sc;
	}

	public boolean findNext()
	{
		return findNextImpl(sc);
	}

	public boolean findPrevious()
	{
		return findPreviousImpl(sc);
	}

	public void select()
	{
		selectImpl(sc);
	}

	public void replace(String with)
	{
		replaceImpl(sc, with);
	}
	
	private native void replaceImpl(JavaScriptObject sc, String value) /*-{
		sc.replace(value);
	}-*/;

	private native void selectImpl(JavaScriptObject sc) /*-{
		sc.select();
	}-*/;

	private native boolean findPreviousImpl(JavaScriptObject sc) /*-{
		return sc.findPrevious();
	}-*/;

	private native boolean findNextImpl(JavaScriptObject sc) /*-{
		return sc.findNext();
	}-*/;
}






