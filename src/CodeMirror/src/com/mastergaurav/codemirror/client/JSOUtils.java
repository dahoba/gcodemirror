package com.mastergaurav.codemirror.client;

import java.util.Map;

import com.google.gwt.core.client.JavaScriptObject;

public class JSOUtils
{
	private JSOUtils()
	{
	}

	public static native JavaScriptObject createFunction(IFunction executor) /*-{
		var fn = function() {
			executor.@com.mastergaurav.codemirror.client.IFunction::execute(Lcom/google/gwt/core/client/JsArrayMixed;)(arguments);
		}

		return fn;
	}-*/;

	@SuppressWarnings("unchecked")
	public static JavaScriptObject fromMap(Map<String, Object> input)
	{
		JavaScriptObject obj = JavaScriptObject.createObject();

		for(String k : input.keySet())
		{
			Object v = input.get(k);
			if(v == null)
			{
				setValueNull(obj, k);
			} else if(v instanceof Integer)
			{
				setValue(obj, k, (Integer) v);
			} else if(v instanceof Boolean)
			{
				setValue(obj, k, (Boolean) v);
			} else if(v instanceof Short)
			{
				setValue(obj, k, (Short) v);
			} else if(v instanceof Double)
			{
				setValue(obj, k, (Double) v);
			} else if(v instanceof Float)
			{
				setValue(obj, k, (Float) v);
			} else if(v instanceof String)
			{
				setValue(obj, k, (String) v);
			} else if(v instanceof JavaScriptObjectWrapper)
			{
				setValue(obj, k, ((JavaScriptObjectWrapper) v).getValue());
			} else if(v instanceof Enum)
			{
				Enum e = (Enum) v;
				setValue(obj, k, e.toString());
			}
		}

		return obj;
	}

	public static native void setValueNull(JavaScriptObject object, String name) /*-{
		object[name] = null;
	}-*/;

	public static native void setValue(JavaScriptObject object, String name, boolean value) /*-{
		object[name] = value;
	}-*/;

	public static native void setValue(JavaScriptObject object, String name, String value) /*-{
		object[name] = value;
	}-*/;

	public static native void setValue(JavaScriptObject object, String name, int value) /*-{
		object[name] = value;
	}-*/;

	public static native void setValue(JavaScriptObject object, String name, short value) /*-{
		object[name] = value;
	}-*/;

	public static native void setValue(JavaScriptObject object, String name, double value) /*-{
		object[name] = value;
	}-*/;

	public static native void setValue(JavaScriptObject object, String name, float value) /*-{
		object[name] = value;
	}-*/;

	public static native void setValue(JavaScriptObject object, String name, JavaScriptObject value) /*-{
		object[name] = value;
	}-*/;

	public static native <T extends JavaScriptObject> T getJSO(JavaScriptObject object, String name) /*-{
		var rv = object[name];
		if(typeof rv == 'undefined')
		{
			rv = null;
		}
		return rv;
	}-*/;

	public static native int getInt(JavaScriptObject object, String name) /*-{
		return Number(object[name]) || 0;
	}-*/;

	public static native String getString(JavaScriptObject object, String name) /*-{
		return String(object[name] || '');
	}-*/;

	public static native String invokeAndGetString(JavaScriptObject object, String fnName) /*-{
		var fn = object[fnName];
		if(typeof fn == 'function')
		{
			var msg = fn.apply(object);
			return msg;
		}
		return "";
	}-*/;
}
