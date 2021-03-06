package objects;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Product {
	StringProperty name;
	StringProperty category;
	StringProperty price;
	
	public Product(String name, String category, String price){
		this.name = new SimpleStringProperty(name);
		this.category = new SimpleStringProperty(category);
		this.price = new SimpleStringProperty(price);
	}
	
	public Product() {
		this.name = new SimpleStringProperty();
		this.category = new SimpleStringProperty();
		this.price = new SimpleStringProperty();
		
	}
	
	public String getName() {
		return name.get();
	}
	public void setName(String arg0) {
		name.set(arg0);
	}
	
	public String getCategory() {
		return category.get();
	}
	public void setCategory(String arg0) {
		category.set(arg0);
	}
	
	public String getPrice() {
		return price.get();
	}
	public void setPrice(String arg0) {
		price.set(arg0);
	}

}
