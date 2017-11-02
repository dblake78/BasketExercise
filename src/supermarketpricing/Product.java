package supermarketpricing;

public class Product {

	private String name;
	private double price;
	private long id;
	private Offer offer;
	
	public Product(String name, double price, long id, Offer offer) {
		super();
		
		this.name = name;
		this.price = price;
		this.id = id;
		this.offer = offer;
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
	public Offer getOffer() {
		return offer;
	}
	public void setOffer(Offer offer) {
		this.offer = offer;
	}
	
}
