package com.mastergaurav.tests.codemirror.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.TextAreaElement;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.mastergaurav.codemirror.client.CodeMirror;

public class CodeMirrorTest implements EntryPoint
{
	@Override
	public void onModuleLoad()
	{
		final CodeMirror cm = CodeMirror.forJava(Document.get().getElementById("code").<TextAreaElement> cast());

		HorizontalPanel hp = new HorizontalPanel();

		Button button = new Button("Search");
		button.addClickHandler(new ClickHandler()
		{
			@Override
			public void onClick(ClickEvent event)
			{
				// Window.alert("Code: " + cm.getContent());
				String what = Window.prompt("Search", "");
				cm.search(what);
			}
		});
		hp.add(button);

		button = new Button("Replace First");
		button.addClickHandler(new ClickHandler()
		{
			@Override
			public void onClick(ClickEvent event)
			{
				cm.replaceFirst("This", "'Twas");
			}
		});
		hp.add(button);

		button = new Button("Replace All");
		button.addClickHandler(new ClickHandler()
		{
			@Override
			public void onClick(ClickEvent event)
			{
				cm.replaceAll("This", "'Twas");
			}
		});
		hp.add(button);

		button = new Button("Get Line No");
		button.addClickHandler(new ClickHandler()
		{
			@Override
			public void onClick(ClickEvent event)
			{
				Window.alert("Current Line: " + cm.getCurrentLine());
			}
		});
		hp.add(button);

		button = new Button("Reindent");
		button.addClickHandler(new ClickHandler()
		{
			@Override
			public void onClick(ClickEvent event)
			{
				cm.reindent();
			}
		});
		hp.add(button);

		RootPanel.get().add(hp);

		cm.setWidth(800, Unit.PX);
	}
}
