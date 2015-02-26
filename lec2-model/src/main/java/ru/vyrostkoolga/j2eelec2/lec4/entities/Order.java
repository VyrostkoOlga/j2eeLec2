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

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name="orders")
public class Order 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn( name = "customer_id", nullable = false )
	private Customer customer;
	
	@OneToMany( mappedBy = "order", cascade = CascadeType.ALL )
	private List<OrderItem> items;
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	
	public void setCustomer(Customer cus) {this.customer = cus;}
	public Customer getCustomer() {return this.customer;}
	
	public void setItems(List<OrderItem> items) {this.items = items;}
	public List<OrderItem> getItems() {return this.items;}
	
	public static void connect( Order order, OrderItem item )
	{
		order.getItems( ).add( item );
		item.setOrder( order );
	}
	
	public String toString()
	{
		StringBuffer buf = new StringBuffer();
		for (OrderItem ord: items)
		{
			buf.append(String.format("%s\n", ord.toString()));
		}
		return new String(buf);
		
	}

}
