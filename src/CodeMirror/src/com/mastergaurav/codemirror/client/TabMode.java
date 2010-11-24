package com.mastergaurav.codemirror.client;

public enum TabMode
{
	INDENT {
		@Override
		public String toString()
		{
			return "indent";
		}
	},
	
	SPACE {
		@Override
		public String toString()
		{
			return "spaces";
		}
	},
	
	DEFAULT {
		@Override
		public String toString()
		{
			return "default";
		}
	},
	
	SHIFT {
		@Override
		public String toString()
		{
			return "shift";
		}
	}
}
