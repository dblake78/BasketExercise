package supermarketpricing;

import supermarketpricing.Constants.OfferType;
import supermarketpricing.Constants.Units;

public class SupermarketPricing {
	
	public static void main(String[] args) {

		Order order = new Order();
		

		/**
		 * In a working application the offer and product records would be stored
		 * in a database. I'm mocking up some records here and populating them
		 * as if they had been read in and formatted into objects
		 */
		
		/**
		 * Set up the offer objects
		 * 
		 * An offer can be one of three types, mapped to the Unit enum.
		 * 
		 * WEIGHT:
		 * The price for a product associated with this offer will be calculated based upon
		 * offer price / product price
		 * 
		 * MULTIPLE:
		 * The price for a product associated with this offer will be calculated based upon
		 * product price x multiple price amount
		 * Any left over products will be charged at standard product price
		 * 
		 * BULK:
		 * The price for a product associated with this offer will be calculated based upon
		 * 'Bulk purchase amount' of products = price
		 * Any left over products will be charged at standard product price
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
		 * Set up the product objects
		 * 
		 * The product object consists of an id, a name, a standard unit price/weight and an offer (if applicable)
		 * If an offer is associated then it will be passed into the final price calculation, otherwise
		 * the standard product price will apply
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
		
		order.outputReceipt();
	}
	
}
