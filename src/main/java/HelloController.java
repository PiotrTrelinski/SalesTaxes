import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

import java.util.ArrayList;
import java.util.Collection;

public class HelloController
{

    @FXML ChoiceBox categoryList;
    @FXML ChoiceBox productList;
    @FXML ChoiceBox stateList;


    @FXML
    public void initialize() {

        ArrayList<String> listWithCategories = new ArrayList<>();
        listWithCategories.add("test1");
        initializeCategoryList(listWithCategories);
        System.out.println("second");
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
}