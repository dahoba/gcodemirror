package com.mastergaurav.tests.codemirror.client;

import java.util.HashMap;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArrayString;
import com.mastergaurav.codemirror.client.CodeMirror;
import com.mastergaurav.codemirror.client.JavaScriptObjectWrapper;

public class CodeMirrorTest implements EntryPoint
{
	@Override
	public void onModuleLoad()
	{
		GWT.log("CodeMirrorTest::onModuleLoad");
		HashMap<String, Object> options = new HashMap<String, Object>();
		options.put("path", GWT.getModuleBaseURL() + "cm/");

		JsArrayString jas = JsArrayString.createArray().cast();
		jas.push("contrib/java/js/tokenizejava.js");
		jas.push("contrib/java/js/parsejava.js");
		JavaScriptObjectWrapper parserfile = new JavaScriptObjectWrapper(jas);
		options.put("parserfile", parserfile);
		
		options.put("height", "650px");
		options.put("stylesheet", GWT.getModuleBaseURL() + "css/javacolors.css");
		options.put("tabMode", "shift");

		CodeMirror.fromTextArea("code", options);
	}
}
