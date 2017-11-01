package supermarketpricing;

import java.util.ArrayList;

public class SupermarketPricing {

	private static ArrayList<Product> products = new ArrayList<>();
	
	public static void main(String[] args) {

		Order order = new Order();

		Product product1 = new Product("Beans", 0.5f, 1, Constants.Unit.ITEM);
		Product product2 = new Product("Coke", 0.7f, 2, Constants.Unit.ITEM);
		Product product3 = new Product("Oranges", 1.99f, 3, Constants.Unit.WEIGHT);

		products.add(product1);
		products.add(product2);
		products.add(product3);
		
		order.addProductToOrder(product1);
		order.addProductToOrder(product1);
		order.addProductToOrder(product2);
		order.addProductToOrder(product2);
		order.addProductToOrder(product1);
		order.addProductToOrder(product1);
		order.addProductToOrder(product2);
		order.addProductToOrder(product3);
		order.addProductToOrder(product3);
		order.addProductToOrder(product2);
		order.addProductToOrder(product1);
		order.addProductToOrder(product1);
		order.addProductToOrder(product1);
		
	}
	
}
