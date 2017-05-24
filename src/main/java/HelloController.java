import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import objects.State;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.w3c.dom.NodeList;

import helpers.XmlReader;

public class HelloController
{

    @FXML ChoiceBox categoryList;
    @FXML ChoiceBox productList;
    @FXML ChoiceBox stateList;
    @FXML Button button;


    @FXML
    public void initialize() {

        ArrayList<String> listWithCategories = new ArrayList<>();
        listWithCategories.add("test1");
        initializeCategoryList(listWithCategories);
        System.out.println("second");
        button.setOnMouseClicked(event -> buttonClickedFunciton());
    }

    public List<State> fillStateList() throws Exception{
    	ArrayList<State> stateList = new ArrayList<State>();
    	XmlReader xml = new XmlReader("./src/main/resources/data/data.xml");
        xml.read("state");
        NodeList states = xml.getNodesList();
        for (int i = 0; i<states.getLength();i++) {
        	String name = states.item(i).getChildNodes().item(1).getTextContent();
        	String basetax = states.item(i).getChildNodes().item(3).getTextContent();
        	String maxsurtax = states.item(i).getChildNodes().item(5).getTextContent();
        	String[] taxes = new String[5];
        	int index = 0;
        	for(int j = 7; j <= 15; j+=2){
        		String cat = states.item(i).getChildNodes().item(j).getTextContent();
        		if(cat.equals("no")) taxes[index] = "0";
        		else if(cat.equals("exempt")) taxes[index] = "0";
        		else if(cat.equals("general")) taxes[index] = basetax;
        		else taxes[index] = cat.split("%")[0];
        		i++;
        	}
        	stateList.add(new State(name, basetax, maxsurtax, taxes));
        }
        return stateList;
    }
    
    
    private void initializeCategoryList(Collection collection) {

        final ObservableList observableList = FXCollections.observableArrayList();

        collection.forEach(item -> observableList.add(item));

        categoryList.setItems(observableList);
    }

    private void initializeProductList(Collection collection) {

        final ObservableList observableList = FXCollections.observableArrayList();

        collection.forEach(item -> observableList.add(item));

        productList.setItems(observableList);
    }

    private void initializeStateList(Collection collection) {

        final ObservableList observableList = FXCollections.observableArrayList();

        collection.forEach(item -> observableList.add(item));

        stateList.setItems(observableList);
    }

    private void buttonClickedFunciton() {
        categoryList.getSelectionModel().getSelectedItem().toString();
    }
}