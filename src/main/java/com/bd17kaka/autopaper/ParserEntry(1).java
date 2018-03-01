/**
 * 
 */
package com.bd17kaka.autopaper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.xmlbeans.XmlException;

import com.bd17kaka.autopaper.service.parser.Config;
import com.bd17kaka.autopaper.service.parser.Word2007Parser;

/**
 * @author Administrator
 *
 */
public class ParserEntry {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			new Word2007Parser(new FileInputStream("2.docx"), new Config(null)).parse();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		} catch (XmlException e) {
		}
		
	}

}
