package com.mastergaurav.codemirror.client;

import java.util.Map;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.TextAreaElement;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.TextArea;


public class CodeMirror
{
	@SuppressWarnings("unused")
	private JavaScriptObject codeMirrorImpl;

	private CodeMirror()
	{
	}

	public CodeMirror(Element place, CodeMirrorConfig config)
	{
		codeMirrorImpl = invokeCtorImpl(place, config.asJSOject());
	}

	public CodeMirror(Element place, Map<String, Object> options)
	{
		codeMirrorImpl = invokeCtorImpl(place, JSOUtils.fromMap(options));
	}

	public static CodeMirror forJava(TextAreaElement e)
	{
		CodeMirrorConfig config = new CodeMirrorConfig();
		config.setParserFile("contrib/java/js/tokenizejava.js", "contrib/java/js/parsejava.js");
		config.setHeight(480, Unit.PX);
		config.setStylesheet(GWT.getModuleBaseURL() + "css/javacolors.css");
		config.setTabmode(TabMode.SHIFT);

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
		rv.codeMirrorImpl = replaceImpl(e, config.asJSOject());
		return rv;
	}

	public static CodeMirror replace(String id, Map<String, Object> options)
	{
		Element e = Document.get().getElementById(id);
		CodeMirror rv = new CodeMirror();
		rv.codeMirrorImpl = replaceImpl(e, JSOUtils.fromMap(options));
		return rv;
	}

	public static CodeMirror replace(Element e, CodeMirrorConfig config)
	{
		CodeMirror rv = new CodeMirror();
		rv.codeMirrorImpl = replaceImpl(e, config.asJSOject());
		return rv;
	}

	public static CodeMirror replace(Element e, Map<String, Object> options)
	{
		CodeMirror rv = new CodeMirror();
		rv.codeMirrorImpl = replaceImpl(e, JSOUtils.fromMap(options));
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
		return fromTextAreaImpl(e, config.asJSOject());
	}

	public static CodeMirror fromTextArea(String id, JavaScriptObject options)
	{
		return fromTextAreaImpl(TextAreaElement.as(Document.get().getElementById(id)), options);
	}

	public static CodeMirror fromTextArea(TextArea ta, JavaScriptObject options)
	{
		return fromTextAreaImpl(ta.getElement().<TextAreaElement>cast(), options);
	}
	
	public static CodeMirror fromTextArea(TextAreaElement tea, JavaScriptObject options)
	{
		return fromTextAreaImpl(tea, options);
	}

	public static CodeMirror fromTextArea(String id, Map<String, Object> options)
	{
		return fromTextAreaImpl(TextAreaElement.as(Document.get().getElementById(id)), options);
	}

	public static CodeMirror fromTextArea(TextArea ta, Map<String, Object> options)
	{
		return fromTextAreaImpl(ta.getElement().<TextAreaElement>cast(), options);
	}
	
	public static CodeMirror fromTextArea(TextAreaElement tea, Map<String, Object> options)
	{
		return fromTextAreaImpl(tea, options);
	}

	private static CodeMirror fromTextAreaImpl(TextAreaElement tea, Map<String, Object> options)
	{
		return fromTextAreaImpl(tea, JSOUtils.fromMap(options));
	}

	private static CodeMirror fromTextAreaImpl(TextAreaElement tea, JavaScriptObject options)
	{
		CodeMirror rv = new CodeMirror();
		rv.codeMirrorImpl = doTextAreaImpl(tea, options);
		return rv;
	}

	private static native JavaScriptObject invokeCtorImpl(Element place, JavaScriptObject options) /*-{
		return new $wnd.CodeMirror(place, options);
	}-*/;
	
	private static native JavaScriptObject doTextAreaImpl(TextAreaElement tea, JavaScriptObject options) /*-{
		//alert('$wnd.CodeMirror.fromTextArea: ' + ($wnd.CodeMirror.fromTextArea));
		return $wnd.CodeMirror.fromTextArea(tea, options);
	}-*/;
	
	private static native boolean isProbablySupportedImpl() /*-{
		var rv = $wnd.CoreMirror.isProbablySupported();
		return !!rv;
	}-*/;
}








