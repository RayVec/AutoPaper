package com.bd17kaka.autopaper.service.parser.element;

import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.util.StringUtils;

public class Font {

	private Integer fontSize;
	
	private String fontFamily;
	
	private Boolean bold;

	public Font() {
		super();
	}

	public Font(Integer fontSize) {
		this(fontSize, "宋体");
	}
	
	public Font(Integer fontSize, String fontFamily) {
		this(fontSize, fontFamily, false);
	}
	
	public Font(Integer fontSize, String fontFamily, Boolean bold) {
		super();
		this.fontSize = fontSize;
		this.fontFamily = fontFamily;
		this.bold = bold;
	}

	public Boolean getBold() {
		return bold;
	}

	public void setBold(Boolean bold) {
		this.bold = bold;
	}

	public Integer getFontSize() {
		return fontSize;
	}

	public void setFontSize(Integer fontSize) {
		this.fontSize = fontSize;
	}

	public String getFontFamily() {
		return fontFamily;
	}

	public void setFontFamily(String fontFamily) {
		this.fontFamily = fontFamily;
	}
	
	
	public void exec(XWPFRun run) {
		if (null != fontSize) run.setFontSize(fontSize);
		if (!StringUtils.isEmpty(fontFamily)) run.setFontFamily(fontFamily);
		if (null != bold) run.setBold(bold.booleanValue());
	}
	
}
