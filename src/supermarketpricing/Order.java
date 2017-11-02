package supermarketpricing;

import java.util.ArrayList;

public class Order {
	
	private ArrayList<Product> products = new ArrayList<>();
	private ArrayList<Offer> uniqueOffers = new ArrayList<>();
	private ArrayList<Saving> savings = new ArrayList<>();
	private double runningTotal = 0;
	private double savingsTotal = 0;
	
	public void addProductToOrder(Product product) {
		if (product.getOffer() != null && !this.uniqueOffers.contains(product.getOffer())) {
			//if we've not got this offer in the list already then 
			//add it to the unique list
			uniqueOffers.add(product.getOffer());
		}
		this.products.add(product);
		
		for (Offer uniqueOffer : uniqueOffers) {
			if (product.getOffer() != null && uniqueOffer.getId() == product.getOffer().getId()) {
				int qualifyingOffers = 0;
				ArrayList<Product> offerProducts = getProductsByOffer(uniqueOffer.getId());
				
				switch (uniqueOffer.getOfferType()) {
				case BULK :
					qualifyingOffers = (offerProducts.size() - (offerProducts.size() % uniqueOffer.getBulkPurchaseAmount())) / uniqueOffer.getBulkPurchaseAmount();
					if (qualifyingOffers > 0) {
						Saving saving = savingsForOffer(product.getOffer().getId());
						if (saving == null) {
							saving = new Saving();
							savings.add(saving);
						}
						saving.setOffer(uniqueOffer);
						saving.setProduct(product);
						saving.setValue(-((product.getPrice() * uniqueOffer.getBulkPurchaseAmount()) - uniqueOffer.getPrice()) * qualifyingOffers);
					}
					break;
				case MULTIPLE :
					qualifyingOffers = (offerProducts.size() - (offerProducts.size() % uniqueOffer.getMultiplePurchaseAmount())) / uniqueOffer.getMultiplePurchaseAmount();
					if (qualifyingOffers > 0) {
						Saving saving = savingsForOffer(product.getOffer().getId());
						if (saving == null) {
							saving = new Saving();
							savings.add(saving);
						}
						saving.setOffer(uniqueOffer);
						saving.setProduct(product);
						saving.setValue((-product.getPrice() * (uniqueOffer.getMultiplePurchaseAmount() - uniqueOffer.getMultiplePriceAmount())) * qualifyingOffers);						
					}
					break;
				default:
					break;
				}
			}
		}
				
	}
	
	public void outputReceipt() {
		for (Product product : products) {
			if (product.getOffer() != null && product.getOffer().getOfferType() == Constants.OfferType.WEIGHT) {
				runningTotal += product.getOffer().getPrice() * product.getPrice();
				System.out.println(String.format("%s\n%.2f kg @ %.2f/kg\t%.2f", product.getName(), product.getPrice(), product.getOffer().getPrice(), product.getOffer().getPrice() * product.getPrice()));
			} else {
				runningTotal += product.getPrice();
				System.out.println(String.format("%s\t\t\t%.2f", product.getName(), product.getPrice()));
			}
		}
		
		System.out.println("\t\t\t-----");
		System.out.println(String.format("Sub-total\t\t%.2f", runningTotal));
		System.out.println("\nSavings");
		
		for (Saving saving : savings) {
			savingsTotal += saving.getValue();
			switch (saving.getOffer().getOfferType()) {
			case MULTIPLE :
				System.out.println(String.format("%s %d for %d\t\t%.2f", saving.getProduct().getName(), saving.getOffer().getMultiplePurchaseAmount(), saving.getOffer().getMultiplePriceAmount(), saving.getValue()));
				break;
			case BULK :
				System.out.println(String.format("%s %d for £%.2f\t\t%.2f", saving.getProduct().getName(), saving.getOffer().getBulkPurchaseAmount(), saving.getOffer().getPrice(), saving.getValue()));
				break;
			default :
				break;
			}
		}
		
		System.out.println("\t\t\t-----");
		System.out.println(String.format("Total savings\t\t%.2f", savingsTotal));
		System.out.println("-----------------------------");
		System.out.println(String.format("Total to Pay\t\t%.2f", runningTotal + savingsTotal));

	}
	
	private ArrayList<Product> getProductsByOffer(long offerId) {	
		ArrayList<Product> returnList = new ArrayList<>();
		
		for (Product product : products) {
			if (product.getOffer() != null) {
				if (product.getOffer().getId() == offerId) {
					returnList.add(product);
				}
			}
		}
		
		return returnList;
	}
	
	private Saving savingsForOffer(long offerId) {
		for (Saving saving : savings) {
			if (saving.getOffer().getId() == offerId) {
				return saving; 
			}
		}
		return null;
	}
}
