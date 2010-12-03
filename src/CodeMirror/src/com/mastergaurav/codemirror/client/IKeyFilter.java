package com.mastergaurav.codemirror.client;

import com.google.gwt.dom.client.NativeEvent;

public interface IKeyFilter
{
	boolean filter(int code, NativeEvent event);
}
