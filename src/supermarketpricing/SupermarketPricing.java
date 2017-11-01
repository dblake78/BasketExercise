package supermarketpricing;

import java.util.ArrayList;

import supermarketpricing.Constants.Units;

public class SupermarketPricing {

	private static ArrayList<Product> products = new ArrayList<>();
	
	public static void main(String[] args) {

		Order order = new Order();

		Offer weightOffer = new Offer();
		weightOffer.setUnit(Units.WEIGHT);
		weightOffer.setPrice(1.99f);
		
		Offer multiplePurchaseOffer = new Offer();
		multiplePurchaseOffer.setUnit(Units.ITEM);
		multiplePurchaseOffer.setMultiplePurchaseAmount(3);
		multiplePurchaseOffer.setMultiplePriceAmount(2);
		
		Offer bulkBuyOffer = new Offer();
		bulkBuyOffer.setUnit(Units.ITEM);
		bulkBuyOffer.setBulkPurchaseAmount(2);
		bulkBuyOffer.setPrice(1.00f);
		
		Product product1 = new Product("Beans", 0.5f, 1, multiplePurchaseOffer);
		Product product2 = new Product("Coke", 0.7f, 2, bulkBuyOffer);
		Product product3 = new Product("Oranges", 1.99f, 3, weightOffer);

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
