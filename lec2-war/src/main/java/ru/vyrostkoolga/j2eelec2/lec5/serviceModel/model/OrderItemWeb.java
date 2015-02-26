package ru.vyrostkoolga.j2eelec2.lec5.serviceModel.model;

import ru.vyrostkoolga.j2eelec2.lec4.entities.OrderItem;

public class OrderItemWeb 
{
	private int id;
	private float quantity;
	
	public OrderItemWeb()
	{
		//TODO
	}

	public OrderItemWeb(OrderItem item)
	{
		id = item.getId();
		quantity = item.getQuantity();
	}
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	
	public float getQuantity() {return quantity;}
	public void setQiantity(float quantity) {this.quantity = quantity;}
	
	public OrderItem toOrderItem()
	{
		OrderItem created = new OrderItem();
		created.setId(id);
		created.setQiantity(quantity);
		
		return created;
	}
}
