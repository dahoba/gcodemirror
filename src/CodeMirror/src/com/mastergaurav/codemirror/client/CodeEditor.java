package com.mastergaurav.codemirror.client;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.VerticalPanel;

public class CodeEditor extends Composite implements HasValue<String>, HasSaveHandlers
{
	private CodeMirror cm;
	private CodeMirrorConfig config;
	private HTMLPanel cmPanel;
	private CodeEditorToolbar toolbar;

	public CodeEditor()
	{
		this(CodeMirrorConfig.getDefault());
	}

	public CodeEditor(CodeMirrorConfig config)
	{
		this.config = config;

		VerticalPanel vp = new VerticalPanel();
		vp.setWidth(config.getWidth());

		cmPanel = new HTMLPanel("");
		toolbar = new CodeEditorToolbar(this);

		vp.add(toolbar);
		
		HTMLPanel spacer = new HTMLPanel("&nbsp");
		spacer.setHeight("4px");
		vp.add(spacer);
		
		vp.add(cmPanel);

		initWidget(vp);
	}
	
	@Override
	protected void onLoad()
	{
		super.onLoad();
		cm = new CodeMirror(cmPanel.getElement(), config);
		cm.setChangeCallback(new ICallback()
		{
			@Override
			public void execute()
			{
				fireChangeEvent(cm.getContent());
			}
		});
	}

	public CodeMirror getCodeMirror()
	{
		return cm;
	}

	@Override
	public String getValue()
	{
		return cm.getContent();
	}

	@Override
	public void setValue(String value)
	{
		setValue(value, false);
	}

	@Override
	public void setValue(String value, boolean fireEvents)
	{
		cm.setContent(value);
		fireChangeEvent(value);
	}

	@Override
	public HandlerRegistration addValueChangeHandler(ValueChangeHandler<String> handler)
	{
		return addHandler(handler, ValueChangeEvent.getType());
	}
	
	private void fireChangeEvent(String value)
	{
		ValueChangeEvent.fire(this, value);
	}

	public CodeMirrorConfig getConfig()
	{
		return config;
	}

	public void setConfig(CodeMirrorConfig config)
	{
		this.config = config;
	}

	public CodeEditorToolbar getToolbar()
	{
		return toolbar;
	}

	@Override
	public HandlerRegistration addSaveHandler(SaveHandler handler)
	{
		return addHandler(handler, SaveEvent.getType());
	}
}
