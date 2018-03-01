package com.bd17kaka.autopaper.service.parser;

import org.apache.poi.xwpf.usermodel.LineSpacingRule;
import org.json.JSONObject;

import com.bd17kaka.autopaper.service.parser.element.Font;
import com.bd17kaka.autopaper.service.parser.element.Footer;
import com.bd17kaka.autopaper.service.parser.element.Header;
import com.bd17kaka.autopaper.service.parser.element.ParagraphStyle;

public class Config {

	private String configStr;
	
	private JSONObject configObj;

	public Config(String configStr) {
		super();
		this.configStr = configStr;
	}
	
	public Header getHeader() {
		Header header = new Header();
		header.setFont(new Font(11));
		header.setTitle("武汉大学论文-header-demo");
		return header;
	}
	
	public Footer getFooter() {
		Footer footer = new Footer();
		footer.setFont(new Font(11));
		footer.setTitle("武汉大学论文-footer-demo");
		return footer;
	}
	
	public ParagraphStyle getParagraphStyle() {
		ParagraphStyle style = new ParagraphStyle();
		style.setLineSpacingRule(LineSpacingRule.AUTO);
		style.setLineSpacing(1.5);
		
//		style.setLineSpacingRule(LineSpacingRule.EXACT);
//		style.setLineSpacing(23.0);
		
		style.setFont(new Font(12, "宋体"));
		
		return style;
	}
	
	public ParagraphStyle getHeading1Style() {
		ParagraphStyle style = new ParagraphStyle();
		style.setFont(new Font(22, "黑体"));
		style.setLineSpacingRule(LineSpacingRule.AUTO);
		style.setLineSpacing(1.5);
		return style;
	}
	
	public ParagraphStyle getHeading2Style() {
		ParagraphStyle style = new ParagraphStyle();
		style.setFont(new Font(16, "黑体"));
		style.setLineSpacingRule(LineSpacingRule.AUTO);
		style.setLineSpacing(1.5);
		return style;
	}
	
	public ParagraphStyle getHeading3Style() {
		ParagraphStyle style = new ParagraphStyle();
		style.setFont(new Font(15, "黑体"));
		style.setLineSpacingRule(LineSpacingRule.AUTO);
		style.setLineSpacing(1.5);
		return style;
	}
	
	public ParagraphStyle getTableContentStyle() {
		ParagraphStyle style = new ParagraphStyle();
		style.setFont(new Font(10, "宋体"));
		return style;
	}
	
}
