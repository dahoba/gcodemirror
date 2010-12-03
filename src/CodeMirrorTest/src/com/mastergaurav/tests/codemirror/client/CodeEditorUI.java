package com.mastergaurav.tests.codemirror.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.mastergaurav.codemirror.client.CodeEditor;
import com.mastergaurav.codemirror.client.CodeMirrorConfig;

public class CodeEditorUI extends Composite
{
	private static CodeEditorUIUiBinder uiBinder = GWT.create(CodeEditorUIUiBinder.class);

	interface CodeEditorUIUiBinder extends UiBinder<Widget, CodeEditorUI>
	{
	}

	@UiField(provided = true)
	CodeMirrorConfig config = CodeMirrorConfig.forJava();

	@UiField
	CodeEditor ce;

	public CodeEditorUI()
	{
		config.setWidth(200, Unit.PX);
		initWidget(uiBinder.createAndBindUi(this));
	}
}
