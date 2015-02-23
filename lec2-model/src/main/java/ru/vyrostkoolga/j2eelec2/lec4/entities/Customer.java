package ru.vyrostkoolga.j2eelec2.lec4.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="customers")
public class Customer 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@OneToMany( mappedBy = "Customer", cascade = CascadeType.ALL )
	private List< Order > items = new ArrayList< Order >( );
	
	public Integer getId() {return id;}
	public void setId(Integer id) {this.id = id;}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	public List<Order> getItems() {return items;}
	public void setItems(List<Order> items) {this.items = items;}
	
	public static void connect( Customer customer, Order item )
	{
		customer.getItems( ).add( item );
		item.setCustomer( customer );
	}
	
	@Override
	public String toString()
	{
		StringBuffer buf = new StringBuffer();
		buf.append(name + ":\n");
		for (Order one: items)
		{
			buf.append(String.format("%s,\n", one.toString()));
		}
		return new String(buf);
	}

}
