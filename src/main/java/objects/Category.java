package objects;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Category {

	StringProperty name;

	StringProperty value;
	public Category(String string, String string2) {
		// TODO Auto-generated constructor stub
		name = new SimpleStringProperty(string);
		value = new SimpleStringProperty(string2);
	}
	
	
	public String getName() {
		return name.get();
	}
	public void setName(String value) {
		name.set(value);
	}
	
	public String getValue() {
		return name.get();
	}
	public void setValue(String value) {
		name.set(value);
	}
}
