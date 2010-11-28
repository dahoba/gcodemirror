package com.mastergaurav.codemirror.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.TextAreaElement;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.TextArea;

/**
 * Online editor for your code.
 * 
 * <p>
 * This code would serve as the starting point to transform any
 * <code>textarea</code> element to a rich editor for your code.
 * </p>
 * 
 * @author Gaurav Vaish
 */
public class CodeMirror
{
	@SuppressWarnings("unused")
	private CodeMirrorConfig config;
	private JavaScriptObject codeMirrorImpl;
	private Element wrapping;

	private CodeMirror()
	{
		config = new CodeMirrorConfig();
	}

	public CodeMirror(Element place, CodeMirrorConfig config)
	{
		JavaScriptObject options = config.asJSOject();
		codeMirrorImpl = invokeCtorImpl(place, options);
		this.config = config;
		initialize(options);
	}

	/**
	 * Easy method for rendering Java code.
	 * 
	 * @param e
	 *            {@linkplain TextAreaElement} element to be tranformed.
	 * @return A {@linkplain CodeMirror} instance
	 */
	public static CodeMirror forJava(TextAreaElement e)
	{
		CodeMirrorConfig config = new CodeMirrorConfig();
		config.setParserFile("contrib/java/js/tokenizejava.js", "contrib/java/js/parsejava.js");
		config.setHeight(480, Unit.PX);
		config.setWidth(640, Unit.PX);
		config.setStylesheet(GWT.getModuleBaseURL() + "cm/contrib/java/css/javacolors.css");
		config.setTabmode(TabMode.SHIFT);
		config.setShowLineNumbers(true);

		return fromTextArea(e, config);
	}

	public static boolean isProbablySupported()
	{
		return isProbablySupportedImpl();
	}

	public static CodeMirror replace(String id, CodeMirrorConfig config)
	{
		Element e = Document.get().getElementById(id);
		CodeMirror rv = new CodeMirror();
		JavaScriptObject options = config.asJSOject();
		rv.codeMirrorImpl = replaceImpl(e, options);
		rv.initialize(options);
		return rv;
	}

	public static CodeMirror replace(Element e, CodeMirrorConfig config)
	{
		CodeMirror rv = new CodeMirror();
		JavaScriptObject options = config.asJSOject();
		rv.codeMirrorImpl = replaceImpl(e, options);
		rv.initialize(options);
		return rv;
	}

	private static native JavaScriptObject replaceImpl(Element e, JavaScriptObject obj) /*-{
		return $wnd.CodeMirror.replace(e, obj);
	}-*/;

	public static CodeMirror fromTextArea(String id, CodeMirrorConfig config)
	{
		return fromTextAreaImpl(TextAreaElement.as(Document.get().getElementById(id)), config.asJSOject());
	}

	public static CodeMirror fromTextArea(TextAreaElement e, CodeMirrorConfig config)
	{
		return fromTextAreaImpl(e, config);
	}

	public static CodeMirror fromTextArea(String id, JavaScriptObject options)
	{
		return fromTextAreaImpl(TextAreaElement.as(Document.get().getElementById(id)), options);
	}

	public static CodeMirror fromTextArea(TextArea ta, JavaScriptObject options)
	{
		return fromTextAreaImpl(ta.getElement().<TextAreaElement> cast(), options);
	}

	public static CodeMirror fromTextArea(TextAreaElement tea, JavaScriptObject options)
	{
		return fromTextAreaImpl(tea, options);
	}

	private static CodeMirror fromTextAreaImpl(TextAreaElement tea, CodeMirrorConfig config)
	{
		CodeMirror cm = fromTextAreaImpl(tea, config.asJSOject());
		cm.config = config;
		return cm;
	}

	private static CodeMirror fromTextAreaImpl(TextAreaElement tea, JavaScriptObject options)
	{
		CodeMirror rv = new CodeMirror();
		rv.codeMirrorImpl = doTextAreaImpl(tea, options);
		rv.initialize(options);
		return rv;
	}

	private static native JavaScriptObject invokeCtorImpl(Element place, JavaScriptObject options) /*-{
		return new $wnd.CodeMirror(place, options);
	}-*/;

	private static native JavaScriptObject doTextAreaImpl(TextAreaElement tea, JavaScriptObject options) /*-{
		return $wnd.CodeMirror.fromTextArea(tea, options);
	}-*/;

	private static native boolean isProbablySupportedImpl() /*-{
		var rv = $wnd.CoreMirror.isProbablySupported();
		return !!rv;
	}-*/;

	public void setHeight(int height, Unit unit)
	{
		DOM.setStyleAttribute(wrapping.<com.google.gwt.user.client.Element> cast(), "height", height + unit.getType());
	}

	public void setWidth(int width, Unit unit)
	{
		DOM.setStyleAttribute(wrapping.<com.google.gwt.user.client.Element> cast(), "width", width + unit.getType());
	}

	public String getContent()
	{
		return JSOUtils.invokeAndGetString(codeMirrorImpl, "getCode");
	}

	public void setContent(String content)
	{
		setContentImpl(codeMirrorImpl, content);
	}

	private native void setContentImpl(JavaScriptObject cm, String content) /*-{
		cm.setCode(content);
	}-*/;

	private void initialize(JavaScriptObject options)
	{
		wrapping = JSOUtils.getJSO(codeMirrorImpl, "wrapping").cast();
	}

	@SuppressWarnings("unused")
	private com.google.gwt.user.client.Element getLineNumbersElement()
	{
		JavaScriptObject obj = JSOUtils.getJSO(codeMirrorImpl, "lineNumbers");
		if(obj != null)
		{
			return obj.cast();
		}

		return null;
	}

	public void search(String what)
	{
		searchImpl(codeMirrorImpl, what);
	}

	public void replaceFirst(String from, String to)
	{
		replaceFirstImpl(codeMirrorImpl, from, to);
	}

	public void replaceAll(String from, String to)
	{
		replaceAllImpl(codeMirrorImpl, from, to);
	}

	public void gotoLine(int lineNo)
	{
		gotoLineImpl(codeMirrorImpl, lineNo);
	}

	public int getCurrentLine()
	{
		return getCurrentLineImpl(codeMirrorImpl);
	}

	public String getSelectedText()
	{
		return getSelectedTextImpl(codeMirrorImpl);
	}

	public void replaceSelection(String text)
	{
		replaceSelectionImpl(codeMirrorImpl, text);
	}

	public void reindent()
	{
		reindentImpl(codeMirrorImpl);
	}

	// TODO: Create "SearchCursor" getSearchCursor

	public void undo()
	{
		undoImpl(codeMirrorImpl);
	}

	public void redo()
	{
		redoImpl(codeMirrorImpl);
	}

	public void clearHistory()
	{
		clearHistoryImpl(codeMirrorImpl);
	}

	public int getHistorySize()
	{
		return getHistorySizeImpl(codeMirrorImpl);
	}

	public Editor getEditor()
	{
		JavaScriptObject editor = editorImpl(codeMirrorImpl);
		return new Editor(editor);
	}
	
	private native JavaScriptObject editorImpl(JavaScriptObject cm) /*-{
		var rv = cm.editor;
		return rv;
	}-*/;

	public SearchCursor getSearchCursor(String search)
	{
		JavaScriptObject obj = getSearchCursorImpl(codeMirrorImpl, search);
		return new SearchCursor(obj);
	}

	public SearchCursor getSearchCursor(String search, boolean currentPos)
	{
		JavaScriptObject obj = getSearchCursorImpl(codeMirrorImpl, search, currentPos);
		return new SearchCursor(obj);
	}

	public SearchCursor getSearchCursor(String search, boolean currentPos, boolean caseSensitive)
	{
		JavaScriptObject obj = getSearchCursorImpl(codeMirrorImpl, search, currentPos, caseSensitive);
		return new SearchCursor(obj);
	}

	private native JavaScriptObject getSearchCursorImpl(JavaScriptObject cm, String search, boolean currentPos, boolean caseSensitive) /*-{
		return cm.getSearchCursor(search, currentPos, caseSensitive);
	}-*/;

	private native JavaScriptObject getSearchCursorImpl(JavaScriptObject cm, String search, boolean currentPos) /*-{
		return cm.getSearchCursor(search, currentPos);
	}-*/;

	private native JavaScriptObject getSearchCursorImpl(JavaScriptObject cm, String search) /*-{
		return cm.getSearchCursor(search);
	}-*/;

	private native int getHistorySizeImpl(JavaScriptObject cm) /*-{
		return cm.historySize();
	}-*/;

	private native void clearHistoryImpl(JavaScriptObject cm) /*-{
		cm.clearHistory();
	}-*/;

	private native void redoImpl(JavaScriptObject cm) /*-{
		cm.redo();
	}-*/;

	private native void undoImpl(JavaScriptObject cm) /*-{
		cm.undo();
	}-*/;

	private native void reindentImpl(JavaScriptObject cm) /*-{
		cm.reindent();
	}-*/;

	private native void replaceSelectionImpl(JavaScriptObject cm, String text) /*-{
		cm.replaceSelection(text);
	}-*/;

	private native String getSelectedTextImpl(JavaScriptObject cm) /*-{
		return cm.selection();
	}-*/;

	private native int getCurrentLineImpl(JavaScriptObject cm) /*-{
		return cm.currentLine();
	}-*/;

	private native void gotoLineImpl(JavaScriptObject cm, int lineNo) /*-{
		cm.jumpToLine(lineNo);
	}-*/;

	private native void replaceFirstImpl(JavaScriptObject cm, String from, String to) /*-{
		var cursor = cm.getSearchCursor(from, false);
		if(cursor.findNext())
		{
			cursor.replace(to);
		}
	}-*/;

	private native void replaceAllImpl(JavaScriptObject cm, String from, String to) /*-{
		var cursor = cm.getSearchCursor(from, false);
		while(cursor.findNext())
		{
			cursor.replace(to);
		}
	}-*/;

	private native void searchImpl(JavaScriptObject cm, String what) /*-{
		if(!what)
		{
			return;
		}

		var first = true;
		do {
			var cursor = cm.getSearchCursor(what, first);
			first = false;
			while(cursor.findNext())
			{
				cursor.select();
				if(!$wnd.confirm("Search Next?"))
				{
					return;
				}
			}
		} while(confirm("End of document reach. Start over?"));
	}-*/;
}
