package com.hybrid.Automation;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.hybrid.Framework.ProjectProperties;

public class Utilities {

	private static boolean filefound = false;

	public static String getWorkSpace() {
		if (System.getenv("WORKSPACE") == null || System.getenv("WORKSPACE").isEmpty())
			return System.getProperty("user.dir");
		else if (!System.getenv("WORKSPACE").contains("Gcom_Automation"))
			return System.getenv("WORKSPACE") + "//Selenium_Gcom//Gcom_Automation";
		else
			return System.getenv("WORKSPACE");
	}

	public static Document stringToDom(String xmlSource)
			throws SAXException, ParserConfigurationException, IOException {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = dbFactory.newDocumentBuilder();
		InputSource is = new InputSource();
		is.setCharacterStream(new StringReader(xmlSource));
		return builder.parse(is);

	}
	
	public  static NodeList readTestCase(String tcFileName) {
		NodeList nList = null;
		try{
			File folder = new File(Utilities.getWorkSpace()+ "//XML");			
			File [] listOfFiles = folder.listFiles();	
			//System.out.println(listOfFiles);
			File fXmlFile = getFile(tcFileName,listOfFiles);
			System.out.println(fXmlFile);
			if(fXmlFile==null) return nList;
			try{
			if(!validateXML(fXmlFile)) return nList;
			}catch(Exception e){
				e.getMessage();
				
			}
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			nList = doc.getElementsByTagName("KeyWord");
			int totalSteps = doc.getElementsByTagName("KeyWord").getLength();
			System.out.println(totalSteps);
		
		}catch(Exception e){
			e.getMessage();
			return null;
		}

		return nList;

	}
	
	
	public static boolean validateXML(File xml) throws SAXException, IOException{
		SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema= factory.newSchema(new File(ProjectProperties.getFilePath(ProjectProperties.XSD)));
		Validator validator= schema.newValidator();
		validator.validate(new StreamSource(xml));
		return true;
		
	}
	
	
	public static File getFile(String tcName , File[] files){
		//filefound=false;
		File file = null;
		//if(file!=null){
			for(File fileOrDirectory : files){
				if(fileOrDirectory.isDirectory()){
					file = getFile(tcName,fileOrDirectory.listFiles());
					if(filefound) break;
				}else{
					if(fileOrDirectory.getName().equalsIgnoreCase(tcName)){
					file = fileOrDirectory;
					break;
					}
				}
			}
			
		//}
		return file;
		
		
	}

	
}
