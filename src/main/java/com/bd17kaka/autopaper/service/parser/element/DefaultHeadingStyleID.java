package com.bd17kaka.autopaper.service.parser.element;

public enum DefaultHeadingStyleID {

	HEADING1("1"),
	HEADING2("2"),
	HEADING3("3"),
	;
	
	private String id;

	private DefaultHeadingStyleID(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	
}
