package objects;

import javafx.beans.property.StringProperty;

public class Product {
	StringProperty name;
	StringProperty category;
	StringProperty price;
	
	public Product(String name, String category, String price){
		this.name.set(name);
		this.category.set(category);
		this.price.set(price);
	}
	
	public Product() {}
	
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
