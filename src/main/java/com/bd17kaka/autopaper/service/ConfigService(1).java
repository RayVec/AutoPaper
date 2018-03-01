package com.bd17kaka.autopaper.service;

import com.bd17kaka.autopaper.service.parser.element.Footer;
import com.bd17kaka.autopaper.service.parser.element.Header;
import com.bd17kaka.autopaper.service.parser.element.ParagraphStyle;

public interface ConfigService {

	public Header getHeader(Long id);
	
	public Footer getFooter(Long id);
	
	public ParagraphStyle getParagraphStyle(Long id);
	
	public ParagraphStyle getHeading1Style(Long id);
	
	public ParagraphStyle getHeading2Style(Long id);
	
	public ParagraphStyle getHeading3Style(Long id);
}
