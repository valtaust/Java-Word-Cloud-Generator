package ie.gmit.dip;

import java.awt.Color;
import java.awt.Font;

/**
 * 
 * @author valer
 * @enum Colours stores fonts
 */

public enum Colours {
	FONT_1(new Font(Font.SANS_SERIF, Font.BOLD, 62), Color.red),
	FONT_2(new Font(Font.SERIF, Font.PLAIN, 50), Color.yellow);

	/*
	 * Arial, Arial Black, Verdana, TimesNewRoman,Tahoma, Impact,Courier,BrushScript
	 */

	private Font font;
	private Color colour;

	/**
	 * @Constructor Colour
	 * @param font
	 * @param colour
	 * @return font
	 * @return colour
	 */

	private Colours(Font font, Color colour) {
		// constructor
		this.font = font;
		this.colour = colour;
	}

	public Font getFont() {
		return font;
	}

	public Color getColour() {
		return colour;
	}

}