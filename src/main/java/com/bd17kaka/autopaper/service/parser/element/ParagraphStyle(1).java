package com.bd17kaka.autopaper.service.parser.element;

import org.apache.poi.xwpf.usermodel.LineSpacingRule;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class ParagraphStyle {

	private LineSpacingRule lineSpacingRule;
	
	private Double lineSpacing;
	
	private Font font;

	public ParagraphStyle() {
		super();
	}

	public LineSpacingRule getLineSpacingRule() {
		return lineSpacingRule;
	}

	public void setLineSpacingRule(LineSpacingRule lineSpacingRule) {
		this.lineSpacingRule = lineSpacingRule;
	}

	public Double getLineSpacing() {
		return lineSpacing;
	}

	public void setLineSpacing(Double lineSpacing) {
		this.lineSpacing = lineSpacing;
	}

	public Font getFont() {
		return font;
	}

	public void setFont(Font font) {
		this.font = font;
	}
	
	public void exec(XWPFParagraph paragraph, XWPFRun run) {
		
		if (null == paragraph) return ;
		
		if (null != lineSpacing && null != lineSpacingRule) {
			paragraph.setSpacingBetween(lineSpacing, lineSpacingRule);
		}

		if (null != font) {
			font.exec(run);
		}

	}
	
}
