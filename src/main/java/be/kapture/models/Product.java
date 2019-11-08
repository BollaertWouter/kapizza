package be.kapture.models;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "price")
	private double price;

	@Enumerated(EnumType.STRING)
	@Column(name = "size")
	private Sizing size;

	public Product() {

	}

	public Product(String name, double price, Sizing size) {
		this.name = name;
		this.price = price;
		this.size = size;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public void setSize(Sizing size) {
		this.size = size;
	}

	public Sizing getSize() {
		return size;
	}

	public String priceToStringWithEuro() {
		return "€" + price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product{" + "name='" + name + '\'' + "size='"+ '\'' + ", price=" + price + '}';
	}
}
