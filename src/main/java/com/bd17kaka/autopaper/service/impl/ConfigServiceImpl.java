package com.bd17kaka.autopaper.service.impl;

import org.apache.poi.xwpf.usermodel.LineSpacingRule;

import com.bd17kaka.autopaper.service.ConfigService;
import com.bd17kaka.autopaper.service.parser.element.Font;
import com.bd17kaka.autopaper.service.parser.element.Footer;
import com.bd17kaka.autopaper.service.parser.element.Header;
import com.bd17kaka.autopaper.service.parser.element.ParagraphStyle;

public class ConfigServiceImpl implements ConfigService {

	@Override
	public Header getHeader(Long id) {
		Header header = new Header();
		header.setFont(new Font(11));
		header.setTitle("武汉大学论文-header-demo");
		return header;
	}

	@Override
	public Footer getFooter(Long id) {
		Footer footer = new Footer();
		footer.setFont(new Font(11));
		footer.setTitle("武汉大学论文-footer-demo");
		return footer;
	}

	@Override
	public ParagraphStyle getParagraphStyle(Long id) {
		ParagraphStyle style = new ParagraphStyle();
		style.setLineSpacingRule(LineSpacingRule.AUTO);
		style.setLineSpacing(1.5);
		
//		style.setLineSpacingRule(LineSpacingRule.EXACT);
//		style.setLineSpacing(23.0);
		
		style.setFont(new Font(14, "宋体"));
		
		return style;
	}

	@Override
	public ParagraphStyle getHeading1Style(Long id) {
		ParagraphStyle style = new ParagraphStyle();
		style.setFont(new Font(22, "SimHei"));
		style.setLineSpacingRule(LineSpacingRule.AUTO);
		style.setLineSpacing(1.5);
		return style;
	}

	@Override
	public ParagraphStyle getHeading2Style(Long id) {
		ParagraphStyle style = new ParagraphStyle();
		style.setFont(new Font(16, "SimHei"));
		style.setLineSpacingRule(LineSpacingRule.AUTO);
		style.setLineSpacing(1.5);
		return style;
	}

	@Override
	public ParagraphStyle getHeading3Style(Long id) {
		ParagraphStyle style = new ParagraphStyle();
		style.setFont(new Font(15, "SimHei"));
		style.setLineSpacingRule(LineSpacingRule.AUTO);
		style.setLineSpacing(1.5);
		return style;
	}

}
