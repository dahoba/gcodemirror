package com.mastergaurav.codemirror.client;

import com.google.gwt.core.client.JavaScriptObject;

public class JavaScriptObjectWrapper
{
	private JavaScriptObject value;

	public JavaScriptObjectWrapper()
	{
	}

	public JavaScriptObjectWrapper(JavaScriptObject value)
	{
		this.value = value;
	}

	public JavaScriptObject getValue()
	{
		return value;
	}

	public void setValue(JavaScriptObject value)
	{
		this.value = value;
	}

}
