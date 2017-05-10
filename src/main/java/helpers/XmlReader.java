package helpers;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class XmlReader {
	
	public XmlReader(String path) {
		this.fileName=path;
	}
	private Document doc;
	
	private String fileName;
	private NodeList statesList;
	
	public void read(String tagName) throws Exception {
		try {
			File fXmlFile = new File(fileName);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			statesList = doc.getElementsByTagName(tagName);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	

	public NodeList getNodesList() {
		return statesList;
	}
	
	public int getValue(String state, String category, String product) {
		
		
		return 0;
	}

}
