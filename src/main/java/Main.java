import org.w3c.dom.NodeList;

import helpers.XmlReader;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

/**
 * Created by Maciek on 05.04.2017.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Aplikacja v.1.0");
        XmlReader xml = new XmlReader("./src/main/resources/data/data.xml");
        xml.read();
        NodeList states = xml.getStatesList();
        
        for (int i = 0; i<states.getLength();i++) {
        	System.out.println(states.item(i).getTextContent());
        }
    }
}
