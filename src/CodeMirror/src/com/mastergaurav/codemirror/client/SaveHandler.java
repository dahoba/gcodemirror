package com.mastergaurav.codemirror.client;

import com.google.gwt.event.shared.EventHandler;

public interface SaveHandler extends EventHandler
{
	void onSave(SaveEvent event);
}
