package com.mastergaurav.tests.codemirror.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.dom.client.Text;
import com.google.gwt.dom.client.TextAreaElement;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.Window.Location;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.mastergaurav.codemirror.client.CodeMirror;
import com.mastergaurav.codemirror.client.IKeyFilter;
import com.mastergaurav.codemirror.client.IKeyHandler;
import com.mastergaurav.codemirror.client.SearchCursor;

public class CodeMirrorTest implements EntryPoint
{
	private CodeMirror cm;
	private SearchCursor sc;

	private DivElement logDiv;

	private void log(String message)
	{
		DivElement child = Document.get().createDivElement();
		Text text = Document.get().createTextNode(message);
		child.appendChild(text);
		logDiv.appendChild(child);
		child.scrollIntoView();
	}

	@Override
	public void onModuleLoad()
	{
		logDiv = DivElement.as(Document.get().getElementById("log"));
		
		cm = CodeMirror.forJava(Document.get().getElementById("code").<TextAreaElement> cast());

		String href = Location.getHref();
		if(href.indexOf("CodeMirrorTest.html") > 0)
		{
			initializeMainTests();
		} else if(href.indexOf("SearchCursorTest.html") > 0)
		{
			initializeSearchCursor();
		}

		cm.setWidth(800, Unit.PX);
	}

	private void initializeSearchCursor()
	{
		HorizontalPanel hp = new HorizontalPanel();
		hp.getElement().setAttribute("cellpadding", "3");

		Button gsc = new Button("Search");
		hp.add(gsc);

		Button fn = new Button("Find Next");
		hp.add(fn);

		Button fp = new Button("Find Previous");
		hp.add(fp);

		RootPanel.get().add(hp);

		gsc.addClickHandler(new ClickHandler()
		{
			@Override
			public void onClick(ClickEvent event)
			{
				String what = Window.prompt("Search", "");
				if(what != null)
				{
					sc = cm.getSearchCursor(what);
				}
			}
		});

		fn.addClickHandler(new ClickHandler()
		{
			@Override
			public void onClick(ClickEvent event)
			{
				doFindNext();
			}
		});
		fp.addClickHandler(new ClickHandler()
		{
			@Override
			public void onClick(ClickEvent event)
			{
				doFindPrevious();
			}
		});
	}

	private void doFindPrevious()
	{
		if(sc == null)
		{
			Window.alert("Click on the 'Search' button first");
		} else
		{
			boolean found = sc.findPrevious();
			if(!found)
			{
				Window.alert("No more results found. Click 'Search' button restart...");
			} else
			{
				sc.select();
				if(Window.confirm("Found and selected. Find previous?"))
				{
					doFindPrevious();
				}
			}
		}
	}

	private void doFindNext()
	{
		if(sc == null)
		{
			Window.alert("Click on the 'Search' button first");
		} else
		{
			boolean found = sc.findNext();
			log(found ? "The word has been selected" : "No results found");
			if(!found)
			{
				Window.alert("No more results found. Click 'Search' button restart...");
			} else
			{
				log("The word has been selected");
				sc.select();
				if(Window.confirm("Found and selected. Find next?"))
				{
					doFindNext();
				}
			}
		}
	}

	private void initializeMainTests()
	{
		HorizontalPanel hp = new HorizontalPanel();
		hp.getElement().setAttribute("cellpadding", "3");

		Button button = new Button("Search");
		button.addClickHandler(new ClickHandler()
		{
			@Override
			public void onClick(ClickEvent event)
			{
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
				log("First \"This\" has been replaced with \"'Twas\"");
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
				log("All \"This\" have been replaced with \"'Twas\"");
			}
		});
		hp.add(button);

		button = new Button("Get Line No");
		button.addClickHandler(new ClickHandler()
		{
			@Override
			public void onClick(ClickEvent event)
			{
				log("Current Line: " + cm.getCurrentLine());
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
				log("Reindentation done");
			}
		});
		hp.add(button);

		button = new Button("Grab");
		button.addClickHandler(new ClickHandler()
		{
			@Override
			public void onClick(ClickEvent event)
			{
				cm.grabKeys(new IKeyHandler()
				{
					@Override
					public void onKeyEvent(NativeEvent event)
					{
					}
				}, new IKeyFilter()
				{
					@Override
					public boolean filter(int code, NativeEvent event)
					{
						log("Filter in action for code=" + code + ", event: " + event.getType());
						return true;
					}
				});
				log("Grabbed. Focus the editor and type in a key");
			}
		});
		hp.add(button);

		button = new Button("Ungrab");
		button.addClickHandler(new ClickHandler()
		{
			@Override
			public void onClick(ClickEvent event)
			{
				cm.ungrabKeys();
				log("Ungrabbed");
			}
		});
		hp.add(button);

		RootPanel.get().add(hp);
	}
}
