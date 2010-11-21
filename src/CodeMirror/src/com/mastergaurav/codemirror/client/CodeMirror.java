package com.mastergaurav.codemirror.client;

import java.util.Map;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.TextAreaElement;
import com.google.gwt.user.client.ui.TextArea;


public class CodeMirror
{
	public static void fromTextArea(String id, JavaScriptObject options)
	{
		fromTextAreaImpl(TextAreaElement.as(Document.get().getElementById(id)), options);
	}

	public static void fromTextArea(TextArea ta, JavaScriptObject options)
	{
		fromTextAreaImpl(ta.getElement().<TextAreaElement>cast(), options);
	}
	
	public static void fromTextArea(TextAreaElement tea, JavaScriptObject options)
	{
		fromTextAreaImpl(tea, options);
	}

	public static void fromTextArea(String id, Map<String, Object> options)
	{
		fromTextAreaImpl(TextAreaElement.as(Document.get().getElementById(id)), options);
	}

	public static void fromTextArea(TextArea ta, Map<String, Object> options)
	{
		fromTextAreaImpl(ta.getElement().<TextAreaElement>cast(), options);
	}
	
	public static void fromTextArea(TextAreaElement tea, Map<String, Object> options)
	{
		fromTextAreaImpl(tea, options);
	}

	private static void fromTextAreaImpl(TextAreaElement tea, Map<String, Object> options)
	{
		fromTextAreaImpl(tea, fromMap(options));
	}

	private static JavaScriptObject fromMap(Map<String, Object> input)
	{
		JavaScriptObject obj = JavaScriptObject.createObject();
		
		for(String k: input.keySet())
		{
			Object v = input.get(k);
			if(v == null)
			{
				setValueNull(obj, k);
			} else if(v instanceof Integer)
			{
				setValue(obj, k, (Integer) v);
			} else if(v instanceof Short)
			{
				setValue(obj, k, (Short) v);
			} else if(v instanceof Double)
			{
				setValue(obj, k, (Double) v);
			} else if(v instanceof String)
			{
				setValue(obj, k, (String) v);
			} else if(v instanceof JavaScriptObjectWrapper)
			{
				setValue(obj, k, ((JavaScriptObjectWrapper) v).getValue());
			}
		}

		return obj;
	}

	private static native void setValueNull(JavaScriptObject object, String name) /*-{
		object[name] = null;
	}-*/;

	private static native void setValue(JavaScriptObject object, String name, String value) /*-{
		object[name] = value;
	}-*/;

	private static native void setValue(JavaScriptObject object, String name, int value) /*-{
		object[name] = value;
	}-*/;

	private static native void setValue(JavaScriptObject object, String name, short value) /*-{
		object[name] = value;
	}-*/;

	private static native void setValue(JavaScriptObject object, String name, double value) /*-{
		object[name] = value;
	}-*/;

	private static native void setValue(JavaScriptObject object, String name, JavaScriptObject value) /*-{
		object[name] = value;
	}-*/;

	private static native void fromTextAreaImpl(TextAreaElement tea, JavaScriptObject options) /*-{
		//alert('$wnd.CodeMirror.fromTextArea: ' + ($wnd.CodeMirror.fromTextArea));
		$wnd.CodeMirror.fromTextArea(tea, options);
	}-*/;
}

