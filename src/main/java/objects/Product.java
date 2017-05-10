package objects;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Product {

	@Override
	public String toString() {
		return "Product [name=" + name + ", category=" + category + ", price=" + price + "]";
	}
	String name;
	String category;
	String price;

	StringProperty name;
	StringProperty category;
	StringProperty price;
	

	public Product(String name, String category, String price){
		this.name = new SimpleStringProperty(name);
		this.category = new SimpleStringProperty(category);
		this.price = new SimpleStringProperty(price);
	}
	
	public Product() {}
	
}
