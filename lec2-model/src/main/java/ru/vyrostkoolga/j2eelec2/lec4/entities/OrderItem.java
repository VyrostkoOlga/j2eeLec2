package ru.vyrostkoolga.j2eelec2.lec4.entities;

import javax.persistence.*;

@Entity
@Table(name="orderItems")
public class OrderItem 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="quantity")
	private float quantity;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="order_id")
	private Order order;
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	
	public float getQuantity() {return quantity;}
	public void setQiantity(float quantity) {this.quantity = quantity;}
	
	public void setOrder(Order ord) {this.order = ord;}
	public Order getOrder() {return this.order;}
	
	public void setProduct(Product prod) {this.product = prod;}
	public Product getProduct() {return this.product;}
	
	public String toString()
	{
		return name + " : " + Float.toString(quantity);
	}
	

}
