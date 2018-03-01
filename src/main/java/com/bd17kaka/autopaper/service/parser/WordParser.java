package com.bd17kaka.autopaper.service.parser;

import java.io.IOException;

public abstract class WordParser {

	abstract public void parse() throws IOException; 

	abstract public void parseHeader() ;
	
	abstract public void parseFooter() ;
	
	abstract public void parseParagraph();
	
	abstract public void parseTable();
	
	abstract public void createMenu();
	
	abstract public void parseHeading1Style();
	
	abstract public void parseHeading2Style();
	
	abstract public void parseHeading3Style();
	
	abstract public void parseNormalParagraphStyle();
	
	abstract public void parseParagraphContent();
}
