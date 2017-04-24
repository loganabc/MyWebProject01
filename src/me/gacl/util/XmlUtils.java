package me.gacl.util;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;



public class XmlUtils {
	
	private static String filename = "DB.xml";
	public static Document getDocument() throws DocumentException{
		URL url = XmlUtils.class.getClassLoader().getResource(filename);
		String realpath = url.getPath();
		System.out.println(realpath);
		SAXReader reader = new SAXReader();
		
		return reader.read(new File(realpath));
		
	}
	
	public static void write2Xml(Document document) throws IOException{
		URL url = XmlUtils.class.getClassLoader().getResource(filename);
		String realpath = url.getPath();
		
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		XMLWriter writer = new XMLWriter(new FileOutputStream(realpath),format);
		System.out.println("–¥»Î1");
		writer.write(document);
		System.out.println("–¥»Î2");
		writer.close();
		System.out.println("–¥»Î3");
	}

}
