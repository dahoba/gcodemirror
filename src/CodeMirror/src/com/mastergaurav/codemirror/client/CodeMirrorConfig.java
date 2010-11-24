package com.mastergaurav.codemirror.client;

import java.util.HashMap;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.dom.client.Style.Unit;

public class CodeMirrorConfig implements CodeMirrorOptions
{
	private HashMap<String, Object> options = new HashMap<String, Object>();

	public CodeMirrorConfig()
	{
		setPath(GWT.getModuleBaseURL() + "cm/");
	}

	public void setParserFile(String file)
	{
		set(PARSER_FILE, file);
	}

	public void setParserFile(String... files)
	{
		JavaScriptObjectWrapper obj = wrap(files);
		set(PARSER_FILE, obj);
	}

	public Object getParserFile()
	{
		return get(PARSER_FILE);
	}

	public void setPath(String path)
	{
		set(PATH, path);
	}

	public String getPath()
	{
		return (String) get(PATH);
	}

	public Object getStylesheet()
	{
		return get(STYLESHEET);
	}

	public void setStylesheet(String file)
	{
		set(STYLESHEET, file);
	}

	public void setStylesheet(String... files)
	{
		set(STYLESHEET, wrap(files));
	}

	public void setContent(String content)
	{
		set(CONTENT, content);
	}

	public String getContent()
	{
		return (String) get(CONTENT);
	}

	public void setBaseFiles(String... files)
	{
		set(BASE_FILES, wrap(files));
	}

	public JsArrayString getBaseFiles()
	{
		JavaScriptObjectWrapper wrapper = (JavaScriptObjectWrapper) get(BASE_FILES);
		return wrapper.getValue().cast();
	}

	public void setIframeClass(String className)
	{
		set(IFRAME_CLASS, className);
	}

	public String getIFrameClass()
	{
		return (String) get(IFRAME_CLASS);
	}

	public void setPassDelay(int millis)
	{
		set(PASS_DELAY, millis);
	}

	public int getPassDelay()
	{
		return (Integer) get(PASS_DELAY);
	}

	public void setPassTime(int millis)
	{
		set(PASS_TIME, millis);
	}

	public int getPassTime()
	{
		return (Integer) get(PASS_TIME);
	}

	public void setHeight(int height, Unit unit)
	{
		set(HEIGHT, height + unit.getType());
	}

	public String getHeight()
	{
		return (String) get(HEIGHT);
	}

	public void setTabmode(TabMode mode)
	{
		set(TAB_MODE, mode);
	}

	public TabMode getTabmode()
	{
		return (TabMode) get(TAB_MODE);
	}
	
	public Object get(String key)
	{
		return options.get(key);
	}

	public void set(String key, Object value)
	{
		options.put(key, value);
	}

	private JavaScriptObjectWrapper wrap(String... files)
	{
		JsArrayString jas = JsArrayString.createArray().cast();
		for(String f : files)
		{
			jas.push(f);
		}
		JavaScriptObjectWrapper obj = new JavaScriptObjectWrapper(jas);
		return obj;
	}

	public JavaScriptObject asJSOject()
	{
		return JSOUtils.fromMap(options);
	}
}
