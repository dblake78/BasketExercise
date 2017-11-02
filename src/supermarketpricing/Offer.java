package supermarketpricing;

import supermarketpricing.Constants.OfferType;
import supermarketpricing.Constants.Units;

public class Offer {

	private Units unit;
	private double price;
	private int multiplePurchaseAmount;
	private int multiplePriceAmount;
	private int bulkPurchaseAmount;
	private OfferType offerType;
	private long id;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Offer(OfferType offerType, long id) {
		super();
		
		this.offerType = offerType;
		this.id = id;
	}
	
	public Units getUnit() {
		return unit;
	}

	public void setUnit(Units unit) {
		this.unit = unit;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getMultiplePurchaseAmount() {
		return multiplePurchaseAmount;
	}

	public void setMultiplePurchaseAmount(int multiplePurchaseAmount) {
		this.multiplePurchaseAmount = multiplePurchaseAmount;
	}

	public int getMultiplePriceAmount() {
		return multiplePriceAmount;
	}

	public void setMultiplePriceAmount(int multiplePriceAmount) {
		this.multiplePriceAmount = multiplePriceAmount;
	}

	public int getBulkPurchaseAmount() {
		return bulkPurchaseAmount;
	}

	public void setBulkPurchaseAmount(int bulkPurchaseAmount) {
		this.bulkPurchaseAmount = bulkPurchaseAmount;
	}

	public OfferType getOfferType() {
		return offerType;
	}

	public void setOfferType(OfferType offerType) {
		this.offerType = offerType;
	}

	
}
