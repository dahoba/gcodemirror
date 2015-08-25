## Introduction ##

gCodeMirror (with g standing for both gwt as well as Gaurav ;) ) is a GWT port of CodeMirror.

Here's a quick document to get started with using the library.


## Prerequisites ##

Download the latest version of gCodeMirror from [the downloads page](http://code.google.com/p/gcodemirror/downloads/list). I would assume that you are already familiar with GWT and have it installed on your machine.


## Hello gCodeMirror ##

Writing your first online Java code editor is just a few lines of code away.

  1. Create a GWT project, let's call it helloGCM
  1. Add the gcodemirror jar file to the build-path
  1. In the HTML page, have a `textarea` with some java code
```
<html>
  <head>
    <title>gCodeMirror Java</title>
    <script language='javascript' type='text/javascript'
       src='helloGCM/helloGCM.nocache.js'></script>
  </head>
  <body>
     <textarea id='code'>
package com.mastergaurav.gcm;

import java.util.List;

/**
 * This is javadoc
 */
public class SomeClass implements List
{
   //One line comment
   private int size = 0;

   public void addItem(Object o)
   {
       System.out.println("This is a string");
   }
}
     </textarea>
  </body>
</html>
```
  1. Now edit the module entry point class and write the following code in `onModuleLoad`
```
public void onModuleLoad()
{
   TextAreaElement e = Document.get().getElementById("code").cast();
   CodeMirror cm = CodeMirror.forJava(e);
}
```
> > And you are done!

## Playing around ##

Once comfortable with the basic stuff, play around with some API like:

  * Dynamically changing the content - `setContent`
  * Get the unformatted, raw code written - `getContent`
  * Change the dimensions - `setHeight`, `setWidth`
  * Search for a word - `search`
  * Find / replace - `replaceFirst`, `replaceAll`
  * Go to a specific line number - `gotoLine`
  * Get the highlighted / selected text - `getSelectedText`
  * Replace the currently selected text with something else - `replaceSelection`
  * After doing all the playaround in the editor, just reindent all - `reindent`

