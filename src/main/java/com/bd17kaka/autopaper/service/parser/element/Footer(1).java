package com.bd17kaka.autopaper.service.parser.element;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;

public class Footer {
	private String title;

	private Font font;
	
	private ParagraphAlignment alignment = ParagraphAlignment.LEFT;

	public Footer() {
		super();
	}

	public Footer(String title, Font font) {
		super();
		this.title = title;
		this.font = font;
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
