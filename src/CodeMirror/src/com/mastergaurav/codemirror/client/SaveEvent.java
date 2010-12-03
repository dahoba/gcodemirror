package com.mastergaurav.codemirror.client;

import com.google.gwt.event.shared.GwtEvent;

public class SaveEvent extends GwtEvent<SaveHandler>
{
	private static Type<SaveHandler> TYPE;

	public static Type<SaveHandler> getType()
	{
		if(TYPE == null)
		{
			TYPE = new Type<SaveHandler>();
		}
		return TYPE;
	}

	protected SaveEvent()
	{
	}

	public static void fire(HasSaveHandlers source)
	{
		if(TYPE != null)
		{
			SaveEvent event = new SaveEvent();
			source.fireEvent(event);
		}
	}

	@Override
	protected void dispatch(SaveHandler handler)
	{
		handler.onSave(this);
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<SaveHandler> getAssociatedType()
	{
		return TYPE;
	}

}
