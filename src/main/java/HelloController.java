import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import objects.Product;
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
    
    List<Product> productArrayList;


    @FXML
    public void initialize() throws Exception {

    	
    	productArrayList = fillProductList();

    	
        initializeCategoryList();
        initializeProductList(productArrayList);
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
    
    private List<Product> fillProductList() throws Exception {
    	
        XmlReader productXml = new XmlReader("src/main/resources/data/products.xml");
        productXml.read("product");
        NodeList products = productXml.getNodesList();
        ArrayList productList = new ArrayList<Product>();
        for (int i = 0; i<products.getLength();i++) {
        	Product temp = new Product();
        	temp.setName(products.item(i).getChildNodes().item(1).getTextContent());
        	temp.setCategory(products.item(i).getChildNodes().item(3).getTextContent());
        	temp.setPrice(products.item(i).getChildNodes().item(5).getTextContent());
        	System.out.println(temp.getName());
        	productList.add(temp);

        }
		return productList;
    	
    	
    }
    
    
    
    
    
    private void initializeCategoryList() {

        final ObservableList observableList = FXCollections.observableArrayList();
        ArrayList<String> listWithCategories = new ArrayList<>();
        listWithCategories.add("groceries");
        listWithCategories.add("prepared food");
        listWithCategories.add("prescription drug");
        listWithCategories.add("non-prescription drug");
        listWithCategories.add("clothing");

        listWithCategories.forEach(item -> observableList.add(item));

        categoryList.setItems(observableList);
        categoryList.getSelectionModel().selectedIndexProperty().addListener( new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				buildProductdependOnCategory(newValue);
			}

			private void buildProductdependOnCategory(Number newValue) {
				// TODO Auto-generated method stub
				System.out.println(observableList.get((int) newValue));
				
				List<Product>filteredList = new ArrayList();
				
				//filteredList.forEach();
				
				 initializeProductList(filteredList);
				
			}
        	
		});
    }
    private void initializeProductList(List<Product> collection) {

        final ObservableList observableList = FXCollections.observableArrayList();

        collection.forEach(item -> observableList.add(item.getName()));

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