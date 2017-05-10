package objects;

import javafx.beans.property.ListProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class State {
	StringProperty name;
	StringProperty basetax;
	StringProperty maxsurtax;
	public ObservableList<Category> cattax;
	
	public State(String name, String basetax, String maxsurtax){
		this.name.set(name);
		this.basetax.set(basetax);
		this.maxsurtax.set(maxsurtax);
		cattax = FXCollections.observableArrayList();
		cattax.add(new Category("groceries", ""));
		cattax.add(new Category("preparedfood", ""));
		cattax.add(new Category("prescriptiondrug", ""));
		cattax.add(new Category("nonprescriptiondrug", ""));
		cattax.add(new Category("clothing", ""));
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
