package com.mastergaurav.tests.codemirror.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.TextAreaElement;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.mastergaurav.codemirror.client.CodeMirror;

public class CodeMirrorTest implements EntryPoint
{
	@Override
	public void onModuleLoad()
	{
		CodeMirror.forJava(Document.get().getElementById("code").<TextAreaElement>cast());
		RootPanel.get().add(new Button("Hello"));
	}
}
