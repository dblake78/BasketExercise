package supermarketpricing;

import supermarketpricing.Constants.Unit;

public class Product {

	private String name;
	private double price;
	private long id;
	private Unit unit;
	
	public Product(String name, double price, long id, Unit unit) {
		super();
		
		this.name = name;
		this.price = price;
		this.id = id;
		this.unit = unit;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Unit getUnit() {
		return unit;
	}
	public void setUnit(Unit unit) {
		this.unit = unit;
	}
	
}
