package com.mastergaurav.codemirror.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class CodeEditorToolbar extends Composite
{
	private CodeEditor editor;

	public CodeEditorToolbar(CodeEditor editor)
	{
		this.editor = editor;

		HorizontalPanel panel = new HorizontalPanel();
		//panel.setWidth("100%");
		initWidget(panel);

		Button reindentBtn = new Button("Reindent");
		reindentBtn.addClickHandler(new ClickHandler()
		{
			@Override
			public void onClick(ClickEvent event)
			{
				CodeEditorToolbar.this.editor.getCodeMirror().reindent();
			}
		});
		panel.add(reindentBtn);

		Button undoBtn = new Button("Undo");
		undoBtn.addClickHandler(new ClickHandler()
		{
			@Override
			public void onClick(ClickEvent event)
			{
				CodeEditorToolbar.this.editor.getCodeMirror().undo();
			}
		});

		panel.add(undoBtn);
		//setWidth(editor.getConfig().getWidth());
	}
}
