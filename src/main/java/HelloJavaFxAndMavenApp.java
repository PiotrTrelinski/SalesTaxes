import helpers.XmlReader;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import objects.Product;

import java.util.ArrayList;

import org.w3c.dom.NodeList;

public class HelloJavaFxAndMavenApp extends Application {


    public static void main(String[] args) throws Exception {

        System.out.println("Aplikacja v.1.0");
        XmlReader stateXml = new XmlReader("src/main/resources/data/data.xml");
        stateXml.read("state");
        NodeList states = stateXml.getNodesList();

        for (int i = 0; i<states.getLength();i++) {
            System.out.println(states.item(i).getTextContent());
        }
        
        /*XmlReader productXml = new XmlReader("src/main/resources/data/products.xml");
        productXml.read("product");
        NodeList products = productXml.getNodesList();
        ArrayList productList = new ArrayList<Product>();
        for (int i = 0; i<products.getLength();i++) {
        	Product temp = new Product();
        	temp.setName(products.item(i).getChildNodes().item(1).getTextContent());
        	temp.setCategory(products.item(i).getChildNodes().item(3).getTextContent());
        	temp.setPrice(products.item(i).getChildNodes().item(5).getTextContent());
        	System.out.println(temp.toString());
        	productList.add(temp);

        }*/


        launch(args);
    }

    public void start(Stage stage) throws Exception {


        String fxmlFile = "/fxml/hello2.fxml";
        FXMLLoader loader = new FXMLLoader();
        Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));

        Scene scene = new Scene(rootNode, 600, 400);
        scene.getStylesheets().add("/styles/styles.css");

        stage.setTitle("Hello JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
    }
}