package ru.vyrostkoolga.j2eelec2.lec4.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="quantity")
	private float quantity;
	
	@Column(name="price")
	private float price;
	
	@Column(name="discount")
	private float discount;
	
	@Column(name="description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="warehouse_id")
	private Warehouse warehouse;
	
	@OneToMany( mappedBy = "Product", cascade = CascadeType.ALL )
	private List<OrderItem> items;
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	public Integer getId() {return id;}
	public void setId(Integer id) {this.id = id;}
	
	public float getQuantity() {return quantity;}
	public void setQuantity(float quantity) {this.quantity = quantity;}
	
	public float getPrice() {return price;}
	public void setPrice(float price) {this.price = price;}
	
	public float getDuscount() {return discount;}
	public void setDiscount(float dsc) {this.discount = dsc;}
	
	public String getDescription() {return description;}
	public void setDescription(String desc) {this.description = desc;}
	
	public void setCategory(Category ctg) {this.category = ctg;}
	public Category getCategory() {return this.category;}
	
	public void setWarehouse(Warehouse wh) {this.warehouse = wh;}
	public Warehouse getWarehouse() {return this.warehouse;}
	
	public void setItems(List<OrderItem> items) {this.items=items;}
	public List<OrderItem> getItems() {return items;}
	
	public String toString()
	{
		return name + "........................" + Float.toString(quantity);
	}
	

}
