package com.mastergaurav.codemirror.client;

import com.google.gwt.core.client.JavaScriptObject;

public class Editor
{
	private JavaScriptObject editor;

	Editor(JavaScriptObject editor)
	{
		this.editor = editor;
	}

	public void reindent()
	{
		reindentImpl(editor);
	}

	private native void reindentImpl(JavaScriptObject editor) /*-{
		editor.reindent();
	}-*/;
}
