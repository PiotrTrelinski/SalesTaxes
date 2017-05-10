package objects;

public class Product {
	@Override
	public String toString() {
		return "Product [name=" + name + ", category=" + category + ", price=" + price + "]";
	}
	String name;
	String category;
	String price;
	public Product(String name, String category, String price){
		this.name = name;
		this.category = category;
		this.price = price;
	}
	public Product() {}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
}
