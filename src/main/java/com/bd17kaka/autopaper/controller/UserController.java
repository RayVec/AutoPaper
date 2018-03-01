package com.bd17kaka.autopaper.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.wp.usermodel.HeaderFooterType;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.IBody;
import org.apache.poi.xwpf.usermodel.IBodyElement;
import org.apache.poi.xwpf.usermodel.LineSpacingRule;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFFooter;
import org.apache.poi.xwpf.usermodel.XWPFHeader;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFPicture;
import org.apache.poi.xwpf.usermodel.XWPFPictureData;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFStyle;
import org.apache.poi.xwpf.usermodel.XWPFStyles;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.xmlbeans.XmlException;
import org.json.JSONObject;
import org.openxmlformats.schemas.drawingml.x2006.picture.CTPicture;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bd17kaka.autopaper.service.UserService;
import com.bd17kaka.autopaper.service.parser.Word2007Parser;
import com.bd17kaka.autopaper.vo.Response;


/**
 * @author root
 * @ClassName: DemoController
 * @Description: TODO
 * @date Feb 28, 2017 1:02:41 AM
 */
@RestController
@RequestMapping(value = "/user")
public class UserController extends BaseController {

    @Resource
    UserService userService;

    @RequestMapping(value = "/file/upload")
    public ResponseEntity<Response<JSONObject>> singleFileUpload(HttpServletRequest request, MultipartFile file) throws IOException {
        Response<JSONObject> response = new Response<JSONObject>();
        if (file == null || file.isEmpty()) {
            response.fail("File if empty.");
            return new ResponseEntity<Response<JSONObject>>(response, HttpStatus.OK);
        }
        
        
        /**
         * doc: https://poi.apache.org/apidocs/
         * tika使用poi示例：http://svn.apache.org/repos/asf/tika/trunk/tika-parsers/src/main/java/org/apache/tika/parser/microsoft/WordExtractor.java
         */
        
        String fileName = file.getOriginalFilename();
        
        InputStream is = file.getInputStream();
        XWPFDocument source = new XWPFDocument(is);
        
//        List<XWPFParagraph> paragraphs = source.getParagraphs();
//        for (XWPFParagraph xwpfParagraph : paragraphs) {
//        	
//        	
//			System.out.println(xwpfParagraph.getText());
//		}
        
        
        XWPFWordExtractor extractor = new XWPFWordExtractor(source);
        
        List<IBodyElement> bodyElements = source.getBodyElements();
        for (IBodyElement iBodyElement : bodyElements) {

        	System.out.println(iBodyElement.getElementType().toString());
        	
        	System.out.println(iBodyElement.getPartType().toString());
        	
        	System.out.println(iBodyElement.getPart().toString());
        	
        	System.out.println("************");
        	
//        	List<XWPFParagraph> list = iBodyElement.getBody().getParagraphs();
//        	for (XWPFParagraph xwpfParagraph : list) {
//				System.out.println(xwpfParagraph.getText());
//				System.out.println("==================");
//			}
//        	System.out.println("&&&&&&&&&&&&&&&");
		}
        
        
//        XWPFDocument doc = new XWPFDocument();
//        XWPFParagraph p = doc.createParagraph();
//        XWPFRun r = p.createRun();
//        r.setText("Some Text");
//        r.setBold(true);
//        
//        r = p.createRun();
//        r.setText("Goodbye");
//        
//        XWPFHeader head = doc.createHeader(HeaderFooterType.DEFAULT);
//        head.createParagraph().createRun().setText("header");
//        
//        XWPFFooter foot = doc.createFooter(HeaderFooterType.DEFAULT);
//        foot.createParagraph().createRun().setText("footer");
//        
//        OutputStream os = new FileOutputStream(new File("header2.docx"));
//        doc.write(os);
//        os.close();
//        doc.close();
        
        response.success(String.format("Upload %s success", fileName));
        return new ResponseEntity<Response<JSONObject>>(response, HttpStatus.OK);
    }
    
    public static void main(String[] args) throws IOException, OpenXML4JException, XmlException {
		
//    	XWPFDocument template = new XWPFDocument(new FileInputStream("template.docx"));
//    	System.out.println(template.getStyles().getNumberOfStyles());
//    	
//    	XWPFDocument dest = new XWPFDocument(new FileInputStream("header2.docx"));
//    	XWPFStyles newStyles = dest.createStyles();
//    	newStyles.setStyles(template.getStyle());
//    			
//    	
//    	XWPFParagraph paragraph = dest.createParagraph();
//    	paragraph.setStyle("1");
//    	XWPFRun run = paragraph.createRun();
//    	run.setText("闪达科技和分割代课老师规范化");
//    	run.setFontSize(12);
//
//    	
//    	OutputStream os = new FileOutputStream("header2.docx");
//    	
//    	dest.write(os);
//    	dest.close();
//    	os.close();
    	
//    	List<XWPFParagraph> list = source.getParagraphs();
//    	for (XWPFParagraph xwpfParagraph : list) {
//			System.out.println(xwpfParagraph.getElementType().toString());
//			System.out.println(xwpfParagraph.getText());
//			System.out.println("----------PAUSE----------");
//		}
//    	System.out.println("----------Finished----------");
    	
    	
//    	List<IBodyElement> bodyElements = source.getBodyElements();
//    	
//    	for (IBodyElement iBodyElement : bodyElements) {
//    		IBody iBody = iBodyElement.getBody();
//    		
//    		List<XWPFParagraph> list1 = iBody.getParagraphs();
//    		System.out.println(list1==null? 0 : list1.size());
//    		
//    		List<XWPFTable> list2 = iBody.getTables();
//    		System.out.println(list2==null? 0 : list2.size());
//    		
//    		System.out.println("----------PAUSE----------");
//    		
//    	}
//    	System.out.println("----------Finished----------");
    	
//    	List<XWPFParagraph> list1 = source.getParagraphs();
//    	
//    	
//    	XWPFStyles styles = source.getStyles();
//    	
//    	for (XWPFParagraph xwpfParagraph : list1) {
//    		
//			System.out.println(xwpfParagraph.getText());
//			System.out.println(xwpfParagraph.getParagraphText());
//			System.out.println(source.getPosOfParagraph(xwpfParagraph));
//			
//			System.out.println(xwpfParagraph.getStyle());
//			System.out.println(xwpfParagraph.getStyleID());
//			
//			if (!StringUtils.isEmpty(xwpfParagraph.getStyleID())) {
//				System.out.println(styles.getStyle(xwpfParagraph.getStyleID()).getName());
//			} else {
//				System.out.println("no style");
//			}
//
//			
//			System.out.println("----------PAUSE----------");
//		}
//    	System.out.println("----------Finished----------");
//    	
//
//    	List<XWPFTable> list2 = source.getTables();
//    	for (XWPFTable xwpfTable : list2) {
//			System.out.println(xwpfTable.getText());
//			System.out.println(source.getPosOfTable(xwpfTable));
//			System.out.println("----------PAUSE----------");
//		}
//    	System.out.println("----------Finished----------");
//    	
//    	
//    	List<XWPFPictureData> list3 = source.getAllPictures();
//    	for (XWPFPictureData xwpfPictureData : list3) {
//			System.out.println(xwpfPictureData.getFileName());
//			System.out.println(xwpfPictureData.getPictureType());
//			
//			System.out.println("----------PAUSE----------");
//		}
//
//    	
//    	List<PackagePart> list4 = source.getAllEmbedds();
//    	
//    	for (PackagePart packagePart : list4) {
//			System.out.println(packagePart.getContentType());
//		}
    	
//        List<IBodyElement> bodyElements = source.getBodyElements();
//        for (IBodyElement iBodyElement : bodyElements) {
//        	System.out.println(iBodyElement.getElementType().toString());
//        	System.out.println(iBodyElement.getPartType().toString());
//        	System.out.println("********************");
//		}
//        System.out.println("----------Finish----------");
        
    	
//        Iterator<IBodyElement> iterable = source.getBodyElementsIterator();
//        
//        while (iterable.hasNext()) {
//			System.out.println(iterable.next().getElementType().toString());
//			System.out.println(iterable.next().getPartType().toString());
//			System.out.println("********************");
//		}

	}
    
}
