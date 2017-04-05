package helpers;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class XmlReader {
	
	public XmlReader(String path) {
		this.fileName=path;
	}
	
	private String fileName;
	private NodeList statesList;
	
	public void read() throws Exception {
		try {
			File fXmlFile = new File(fileName);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			statesList = doc.getElementsByTagName("state");
		}
		catch (Exception e) {
			throw e;
		}
	}

	public NodeList getStatesList() {
		return statesList;
	}

}
