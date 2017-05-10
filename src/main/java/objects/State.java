package objects;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class State {
	StringProperty name;
	StringProperty basetax;
	StringProperty maxsurtax;
	public ObservableList<Category> cattax;
	
	public State(String name, String basetax, String maxsurtax, String[] catvals){
		this.name = new SimpleStringProperty(name);
		this.basetax = new SimpleStringProperty(basetax);
		this.maxsurtax = new SimpleStringProperty(maxsurtax);
		cattax = FXCollections.observableArrayList();
		cattax.add(new Category("groceries", catvals[0]));
		cattax.add(new Category("preparedfood", catvals[1]));
		cattax.add(new Category("prescriptiondrug", catvals[2]));
		cattax.add(new Category("nonprescriptiondrug", catvals[3]));
		cattax.add(new Category("clothing", catvals[4]));
	}

	public String getName() {
		return name.get();
	}

	public void setName(String value) {
		name.set(value);
	}
	
	public String getBasetax() {
		return basetax.get();
	}

	public void setBasetax(String value) {
		basetax.set(value);
	}
	
	public String getMaxsurtax() {
		return maxsurtax.get();
	}

	public void setMaxsurtax(String value) {
		maxsurtax.set(value);
	}
	
	public ObservableList<Category> getCattax() {
		return cattax;
	}
	
}
