import helpers.XmlReader;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.w3c.dom.NodeList;

public class HelloJavaFxAndMavenApp extends Application {


    public static void main(String[] args) throws Exception {

        System.out.println("Aplikacja v.1.0");
        XmlReader xml = new XmlReader("C:\\ZPI\\src\\main\\resources\\data\\data.xml");
        xml.read();
        NodeList states = xml.getStatesList();

        for (int i = 0; i<states.getLength();i++) {
            System.out.println(states.item(i).getTextContent());
        }

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