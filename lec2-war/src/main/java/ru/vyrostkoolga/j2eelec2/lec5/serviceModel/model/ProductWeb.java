package ru.vyrostkoolga.j2eelec2.lec5.serviceModel.model;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;

import ru.vyrostkoolga.j2eelec2.lec4.entities.Category;
import ru.vyrostkoolga.j2eelec2.lec4.entities.OrderItem;
import ru.vyrostkoolga.j2eelec2.lec4.entities.Product;
import ru.vyrostkoolga.j2eelec2.lec4.entities.Warehouse;

public class ProductWeb 
{
	private Integer id;
	private String name;
	private Float price;
	private Float discount;
	private Float quantity;
	private String description;
	private List<OrderItemWeb> orders;
	
	public ProductWeb()
	{
		orders = new ArrayList<OrderItemWeb>();
	}
	
	public ProductWeb(Product product)
	{
		id = product.getId();
		name = product.getName();
		price = product.getPrice();
		discount = product.getDiscount();
		quantity = product.getQuantity();
		description = product.getDescription();
		
		orders = new ArrayList<OrderItemWeb>();
		for (OrderItem item: product.getItems() )
		{
			orders.add(new OrderItemWeb(item));
		}
	}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	public Integer getId() {return id;}
	public void setId(Integer id) {this.id = id;}
	
	public float getQuantity() {return quantity;}
	public void setQuantity(float quantity) {this.quantity = quantity;}
	
	public float getPrice() {return price;}
	public void setPrice(float price) {this.price = price;}
	
	public float getDiscount() {return discount;}
	public void setDiscount(float dsc) {this.discount = dsc;}
	
	public String getDescription() {return description;}
	public void setDescription(String desc) {this.description = desc;}
	
	public void setItems(List<OrderItemWeb> items) {this.orders=items;}
	public List<OrderItemWeb> getItems() {return orders;}
	
	public Product toProduct()
	{
		Product product = new Product();
		product.setDescription(description);
		product.setDiscount(discount);
		product.setQuantity(quantity);
		product.setId(id);
		product.setName(name);
		product.setPrice(price);
		
		for (OrderItemWeb item: orders)
		{
			Product.connect(product, item.toOrderItem());
		}
		
		return product;
	}
}
