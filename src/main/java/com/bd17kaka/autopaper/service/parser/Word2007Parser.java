package com.bd17kaka.autopaper.service.parser;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.wp.usermodel.HeaderFooterType;
import org.apache.poi.xwpf.usermodel.BodyElementType;
import org.apache.poi.xwpf.usermodel.IBodyElement;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFPicture;
import org.apache.poi.xwpf.usermodel.XWPFPictureData;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFStyles;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTable.XWPFBorderType;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableCell.XWPFVertAlign;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHeight;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVerticalJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STVerticalJc;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.alibaba.druid.sql.dialect.oracle.ast.clause.CycleClause;
import com.bd17kaka.autopaper.service.parser.element.DefaultHeadingStyleID;
import com.bd17kaka.autopaper.service.parser.element.Footer;
import com.bd17kaka.autopaper.service.parser.element.Header;
import com.bd17kaka.autopaper.service.parser.element.ParagraphStyle;
import com.bd17kaka.autopaper.utils.StringUtil;

// http://stackoverflow.com/questions/2643822/how-can-i-use-predefined-formats-in-docx-with-poi/27864752#27864752
/**
 * @author Administrator
 * 依赖 Apache POI的解析器. 看有没有必要迁移到OpenOffice
 */
public class Word2007Parser extends WordParser {

	private InputStream inputStream;
	
	private Config config;
	
	private XWPFDocument dest = new XWPFDocument();
	
	private XWPFParagraph curNewPara;
	
	private XWPFParagraph curOldPara;
	
	private XWPFTable curOldTable;
	
	private XWPFRun curRun;
	
	private XWPFStyles oldStyles;
	
	private String outputFilename = String.format("%s.docx", Calendar.getInstance().getTimeInMillis());
	
	private XWPFDocument template = null;
	
	private XWPFDocument source = null;
	
	public Word2007Parser(InputStream inputStream, Config config) throws FileNotFoundException, IOException, XmlException {
		super();
		this.inputStream = inputStream;
		this.config = config;
		this.template = new XWPFDocument(new FileInputStream("template.docx"));
		this.source = new XWPFDocument(inputStream);
		this.oldStyles = source.getStyles();
		
		/** 加载word默认样式 */
    	XWPFStyles styles = this.dest.createStyles();
    	styles.setStyles(template.getStyle());

	}

	@Override
	public void parseHeading2Style() {
		curNewPara.setStyle(DefaultHeadingStyleID.HEADING2.getId());
		ParagraphStyle heading2Style = config.getHeading2Style();
		heading2Style.exec(curNewPara, curRun);
	}

	@Override
	public void parseHeading3Style() {
		curNewPara.setStyle(DefaultHeadingStyleID.HEADING3.getId());
		ParagraphStyle heading3Style = config.getHeading3Style();
		heading3Style.exec(curNewPara, curRun);
	}

	@Override
	public void parseNormalParagraphStyle() {
		curNewPara.setFirstLineIndent(500);
		ParagraphStyle normalParagraphStyle = config.getParagraphStyle();
		normalParagraphStyle.exec(curNewPara, curRun);
	}	
	

	@Override
	public void parseParagraphContent() {

		/** 遍历oldPara所有文字 */
		List<XWPFRun> list = curOldPara.getRuns();
		int i = 0;
		for (XWPFRun xwpfRun : list) {

			String curText = xwpfRun.text();
			
			/** 行首去掉空格 */
			if (i == 0) {
				curText = StringUtil.trim(curText);
			}
			
			if (!StringUtils.isEmpty(curText)) {
				curRun.setText(curText);
			}
			
			List<XWPFPicture> pictures = xwpfRun.getEmbeddedPictures();
			if (!CollectionUtils.isEmpty(pictures)) {
				
				/** 有图片，居中显示 */
				curNewPara.setAlignment(ParagraphAlignment.CENTER);
				
				for (XWPFPicture xwpfPicture : pictures) {
					
					XWPFPictureData pictureData = xwpfPicture.getPictureData();
					String filename = pictureData.getFileName();
					int pictureType = pictureData.getPictureType();
					
					InputStream is = new ByteArrayInputStream(pictureData.getData());
					try {
						curRun.addPicture(is, pictureType, filename, Units.toEMU(200), Units.toEMU(200));
					} catch (InvalidFormatException e) {
						System.err.println(e.toString());
					} catch (IOException e) {
						System.err.println(e.toString());
					}

				}
			}
			i++;
		}
		
	}
	
	@Override
	public void parseHeading1Style() {
		curNewPara.setStyle(DefaultHeadingStyleID.HEADING1.getId());
		curNewPara.setPageBreak(true);
		ParagraphStyle heading1Style = config.getHeading1Style();
		heading1Style.exec(curNewPara, curRun);
	}
	
	@Override
	public void parseHeader() {
		
		XWPFParagraph paragraph = dest.createHeader(HeaderFooterType.DEFAULT).createParagraph();
		XWPFRun headerRun = paragraph.createRun();
		
		Header configheader = config.getHeader();
		
		/** alignment */
		paragraph.setAlignment(configheader.getAlignment());

		/** header 标题 */
		if (!StringUtils.isEmpty(configheader.getTitle()))  {
			headerRun.setText(configheader.getTitle());
		}
		
		/** header 字体 */
		if (null != configheader.getFont()) {
			configheader.getFont().exec(headerRun);
		}
	}
	
	@Override
	public void parseFooter() {

		XWPFParagraph paragraph = dest.createFooter(HeaderFooterType.DEFAULT).createParagraph();
		XWPFRun footerRun = paragraph.createRun();
		
		Footer configfooter = config.getFooter();
		
		/** alignment */
		paragraph.setAlignment(configfooter.getAlignment());

		/** footer 标题 */
		if (!StringUtils.isEmpty(configfooter.getTitle()))  {
			footerRun.setText(configfooter.getTitle());
		}
		
		/** footer 字体 */
		if (null != configfooter.getFont()) {
			configfooter.getFont().exec(footerRun);
		}
		
	}
	
	@Override
	public void parseParagraph() {
		
		curNewPara = dest.createParagraph();
		curRun = curNewPara.createRun();
		
		/** 处理原始段落: 去掉原始段落行首tab */
		curOldPara.createRun().removeTab();

		/** 根据段落样式，和word默认样式进行比对 */
		if (!StringUtils.isEmpty(curOldPara.getStyleID())
				&& null != oldStyles.getStyle(curOldPara.getStyleID())) {

			String styleName = oldStyles.getStyle(curOldPara.getStyleID()).getName();
			
			switch (styleName) {
			case "Normal (Web)":
				parseNormalParagraphStyle();
				break;
			case "heading 1":
				parseHeading1Style();
				break;
			case "heading 2":
				parseHeading2Style();
				break;
			case "heading 3":
				parseHeading3Style();
				break;
			default:
				parseNormalParagraphStyle();
				break;
			}
		} else {
			parseNormalParagraphStyle();
		}
		
		parseParagraphContent();
	}
	
	@Override
	public void parseTable() {

		/**
         * 设置表中元素样式
         * http://stackoverflow.com/questions/30733603/reading-from-a-word-document-using-java/30733676#30733676
         */
        List<XWPFTableRow> rows = curOldTable.getRows();
        for (XWPFTableRow row : rows) {
        	CTTrPr trPr = row.getCtRow().addNewTrPr();
        	CTHeight ht = trPr.addNewTrHeight();
            ht.setVal(BigInteger.valueOf(1024));
            
            List<XWPFTableCell> cells = row.getTableCells();
            for (XWPFTableCell cell : cells) {
            	 CTTcPr tcpr = cell.getCTTc().addNewTcPr();
                 CTVerticalJc va = tcpr.addNewVAlign();
                 va.setVal(STVerticalJc.CENTER);
                 
                 List<XWPFParagraph> paragraphs = cell.getParagraphs();
                 if (!CollectionUtils.isEmpty(paragraphs)) {
                	 for (XWPFParagraph paragraph : paragraphs) {
                		 
                		 List<XWPFRun> oldRuns = paragraph.getRuns();
                		 String text = "";
                		 for (XWPFRun oldRun : oldRuns) {
                			 text += oldRun.text();
                		 }
                		 for (int i = 0; i < paragraph.getRuns().size(); i++) {
                			 paragraph.removeRun(i);
                		 }
                		 
                		 XWPFRun run = paragraph.createRun();
                		 ParagraphStyle style = config.getTableContentStyle();
                		 style.exec(paragraph, run);

                		 run.setText(text);
                	 }
                 }
            }
		}
        
		
        XWPFTable curNewTable = dest.createTable();
        
        // http://stackoverflow.com/questions/10208097/how-to-copy-a-paragraph-of-docx-to-another-docx-withjava-and-retain-the-style/25375809#25375809
		/** 直接把表copy过来 */
		int pos = dest.getTables().size() - 1;
        dest.setTable(pos, curOldTable);
        
        /** 设置border 
         *  http://stackoverflow.com/questions/34092933/set-outer-border-of-apache-poi-xwpftable-table 
         * */
        CTTblPr tblpro = curNewTable.getCTTbl().getTblPr();
        CTTblBorders borders = tblpro.addNewTblBorders();
        borders.addNewBottom().setVal(STBorder.SINGLE); 
        borders.addNewLeft().setVal(STBorder.SINGLE);
        borders.addNewRight().setVal(STBorder.SINGLE);
        borders.addNewTop().setVal(STBorder.SINGLE);
        //also inner borders
        borders.addNewInsideH().setVal(STBorder.SINGLE);
        borders.addNewInsideV().setVal(STBorder.SINGLE);
        // curNewTable.setInsideHBorder(XWPFBorderType.SINGLE, 1, 1, "000000");
        // curNewTable.setInsideVBorder(XWPFBorderType.SINGLE, 1, 1, "000000");
        
	}

	@Override
	public void parse() throws IOException {
		
    	OutputStream os = new FileOutputStream(this.outputFilename);
    	
    	createMenu();
    	
    	/** 设置 header */
    	parseHeader();
    	
    	/** 设置 footer */
    	parseFooter();
    	
    	List<IBodyElement> bodyElements = source.getBodyElements();
    	if (!CollectionUtils.isEmpty(bodyElements)) {
    		for (IBodyElement iBodyElement : bodyElements) {
    			BodyElementType elementType = iBodyElement.getElementType();
    			if (elementType.name().equals("PARAGRAPH")) {
    				/** 解析paragraph */
    				curOldPara = (XWPFParagraph) iBodyElement;
    				parseParagraph();
    			} else if (elementType.name().equals("TABLE")) {
    				/** 解析table */
    				curOldTable = (XWPFTable) iBodyElement;
    				parseTable();
    				
    			}
			}
    	}
    	
    	
    	dest.write(os);
    	dest.close();
    	os.close();
    	source.close();
    	template.close();
		
	}

	@Override
	public void createMenu() {

		// http://stackoverflow.com/questions/40235909/creating-a-table-of-contents-for-a-xwpfdocument-with-page-numbers-indication
		
		XWPFParagraph newPara = dest.createParagraph();
		XWPFRun run = newPara.createRun();
		newPara.setAlignment(ParagraphAlignment.CENTER);
		newPara.setStyle(DefaultHeadingStyleID.HEADING1.getId());
		ParagraphStyle heading1Style = config.getHeading1Style();
		heading1Style.exec(newPara, run);
		run.setText("目录");
		
		
		newPara = dest.createParagraph();
		run = newPara.createRun();
		CTP ctp = newPara.getCTP();
		CTSimpleField toc = ctp.addNewFldSimple();
		toc.setInstr("TOC \\h");
		toc.setDirty(STOnOff.TRUE);
		
		/** TODO: 目录格式 */
	}

}
