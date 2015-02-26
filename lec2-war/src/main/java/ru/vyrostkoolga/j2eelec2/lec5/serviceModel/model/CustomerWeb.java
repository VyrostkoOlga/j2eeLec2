package ru.vyrostkoolga.j2eelec2.lec5.serviceModel.model;

import java.util.ArrayList;
import java.util.List;

import ru.vyrostkoolga.j2eelec2.lec4.entities.Customer;
import ru.vyrostkoolga.j2eelec2.lec4.entities.Order;

public class CustomerWeb 
{
	private Integer id;
	private String name;
	private List<OrderWeb> orders;
	
	public CustomerWeb()
	{
		orders = new ArrayList<OrderWeb>();
	}
	
	public CustomerWeb(Customer customer)
	{
		id = customer.getId();
		name = customer.getName();
		orders = new ArrayList<OrderWeb>();
		
		for (Order item: customer.getItems())
		{
			orders.add(new OrderWeb(item));
		}
	}
	
	public void setId(Integer id) {this.id = id;}
	public Integer getId() {return this.id;}
	
	public void setName(String name) {this.name = name;}
	public String getName() {return this.name;}
	
	public void setOrders(List<OrderWeb> orders) {this.orders = orders;}
	public List<OrderWeb> getOrders() {return this.orders;}
	
	public Customer toCustomer()
	{
		Customer created = new Customer();
		created.setId(id);
		created.setName(name);
		
		for (OrderWeb item: orders)
		{
			Customer.connect(created, item.toOrder());
		}
		
		return created;
	}
}
