package supermarketpricing;

import java.util.ArrayList;

public class Order {
	
	private ArrayList<Product> products = new ArrayList<>();
	
	public void addProductToOrder(Product product) {
		this.products.add(product);
		
		outputReceipt();
	}
	
	private void outputReceipt() {
		//system.out the details here
	}
	
}
