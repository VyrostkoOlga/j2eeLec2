package ru.vyrostkoolga.j2eelec2.lec5.serviceModel.model;

import java.util.ArrayList;
import java.util.List;

import ru.vyrostkoolga.j2eelec2.lec4.entities.Order;
import ru.vyrostkoolga.j2eelec2.lec4.entities.OrderItem;

public class OrderWeb
{
	private Integer id;
	private List<OrderItemWeb> items;
	
	public OrderWeb()
	{
		items = new ArrayList<OrderItemWeb>();
	}
	
	public OrderWeb(Order order)
	{
		id = order.getId();
		items = new ArrayList<OrderItemWeb>();
		for (OrderItem item: order.getItems())
		{
			items.add(new OrderItemWeb(item));
		}
	}
	
	public void setId(Integer id) {this.id = id;}
	public Integer getId() {return this.id;}
	
	public void setItems(List<OrderItemWeb> items) {this.items = items;}
	public List<OrderItemWeb> getItems() {return this.items;}
	
	public Order toOrder()
	{
		Order created = new Order();
		created.setId(id);
		
		for (OrderItemWeb item: items)
		{
			Order.connect(created, item.toOrderItem());
		}
		
		return created;
	}
}
