/**
 * 
 */
package com.bd17kaka.autopaper.service.parser.element;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;

/**
 * @author Administrator
 *
 */
public class Header {

	private String title ;

	private Font font;
	
	private ParagraphAlignment alignment = ParagraphAlignment.LEFT;

	public Header() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Font getFont() {
		return font;
	}

	public void setFont(Font font) {
		this.font = font;
	}

	public ParagraphAlignment getAlignment() {
		return alignment;
	}

	public void setAlignment(ParagraphAlignment alignment) {
		this.alignment = alignment;
	}

}
