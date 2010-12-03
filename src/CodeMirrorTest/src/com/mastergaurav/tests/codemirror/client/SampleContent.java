package com.mastergaurav.tests.codemirror.client;

public class SampleContent
{
	public static final String JAVA_CODE = "package example;\n" + "\n" + "import java.awt.*;\n" + "\n" + "/**\n"
			+ " * This class subclasses DrawableRect and adds colors to the rectangle it draws\n" + " **/\n"
			+ "public class ColoredRect extends DrawableRect {\n"
			+ "  // These are new fields defined by this class.\n"
			+ "  // x1, y1, x2, and y2 are inherited from our super-superclass, Rect.\n" + "  @AnnotationTest\n"
			+ "  protected Color border, fill;\n" + "  private String name;\n" + "\n" + "  /**\n"
			+ "   * This constructor uses super() to invoke the superclass constructor, and\n"
			+ "   * also does some initialization of its own.\n" + "   **/\n"
			+ "  public ColoredRect(int x1, int y1, int x2, int y2, Color border, Color fill){\n"
			+ "    super(x1, y1, x2, y2);\n" + "    /* This\n" + "    is a block comment */\n"
			+ "    this.border = border;\n" + "    this.fill = fill;\n" + "    this.name = \"This is a string\";\n"
			+ "  }\n" + "\n" + "  /**\n"
			+ "   * This method overrides the draw() method of our superclass so that it\n"
			+ "   * can make use of the colors that have been specified.\n" + "   **/\n"
			+ "  public void draw(Graphics g) {\n" + "    g.setColor(fill);\n" + "    g.fillRect(x1, y1, x2, y2);\n"
			+ "    g.setColor(border);\n" + "    g.drawRect(x1, y1, x2, y2);\n" + "  }\n" + "}\n" + "\n";
}
