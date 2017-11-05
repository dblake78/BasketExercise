package supermarketpricing;

import supermarketpricing.Constants.OfferType;
import supermarketpricing.Constants.Units;

public class SupermarketPricing {
	
	public static void main(String[] args) {

		Order order = new Order();
		
		/**
		 * Offer object set up
		 */
		Offer weightOffer = new Offer(OfferType.WEIGHT, 1);
		weightOffer.setUnit(Units.WEIGHT);
		weightOffer.setPrice(1.99f);
		
		Offer multiplePurchaseOffer = new Offer(OfferType.MULTIPLE, 2);
		multiplePurchaseOffer.setUnit(Units.ITEM);
		multiplePurchaseOffer.setMultiplePurchaseAmount(3);
		multiplePurchaseOffer.setMultiplePriceAmount(2);
		
		Offer bulkBuyOffer = new Offer(OfferType.BULK, 3);
		bulkBuyOffer.setUnit(Units.ITEM);
		bulkBuyOffer.setBulkPurchaseAmount(2);
		bulkBuyOffer.setPrice(1.00f);
		
		/**
		 * Product object set up
		 */
		Product beans = new Product("Beans", 0.5f, 1, multiplePurchaseOffer);
		Product coke = new Product("Coke", 0.7f, 2, bulkBuyOffer);
		Product bread = new Product("Bread", 2.50f, 4, null);
		
		/**
		 * Add each product to the order
		 * Effectively scanning the product bar code at the checkout
		 * As we scan we build a unique list of offers that are on this receipt so that we can iterate
		 * over them in order and build the output as we scan
		 */
		order.addProductToOrder(beans);
		order.addProductToOrder(beans);
		order.addProductToOrder(coke);
		order.addProductToOrder(coke);
		order.addProductToOrder(beans);
		order.addProductToOrder(bread);
		order.addProductToOrder(beans);
		order.addProductToOrder(coke);
		order.addProductToOrder(new Product("Oranges", 0.4f, 3, weightOffer));
		order.addProductToOrder(new Product("Oranges", 2.4f, 3, weightOffer));
		order.addProductToOrder(coke);
		order.addProductToOrder(beans);
		order.addProductToOrder(beans);
		order.addProductToOrder(beans);
	}
	
}
