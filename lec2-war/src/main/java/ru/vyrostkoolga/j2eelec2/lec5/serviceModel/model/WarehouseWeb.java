package ru.vyrostkoolga.j2eelec2.lec5.serviceModel.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import ru.vyrostkoolga.j2eelec2.lec4.entities.Category;
import ru.vyrostkoolga.j2eelec2.lec4.entities.Product;
import ru.vyrostkoolga.j2eelec2.lec4.entities.Warehouse;

public class WarehouseWeb
{
	private Integer id;
	private String name;
	private float capacity;
	private List<ProductWeb> products;
	//private List<CategoryWeb> categories;
	
	public WarehouseWeb()
	{
		products = new ArrayList<ProductWeb>();
		//categories = new ArrayList<CategoryWeb>();
	}
	
	public WarehouseWeb(Warehouse wh)
	{
		id = wh.getId();
		name = wh.getName();
		capacity = wh.getCapacity();
		
		products = new ArrayList<ProductWeb>();
		for (Product one: wh.getItems())
		{
			products.add(new ProductWeb(one));
		}
		
		/*
		categories = new ArrayList<CategoryWeb>();
		for (Category item: wh.getCategories())
		{
			categories.add(new CategoryWeb(item));
		}
		*/
	}
	
	public Integer getId() {return id;}
	public void setId(Integer id) {this.id = id;}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	public float getCapacity() {return this.capacity;}
	public void setCapacity(float capacity) {this.capacity = capacity;}
	
	public void setProducts(List<ProductWeb> items) {this.products = items;}
	public List<ProductWeb> getProducts() {return this.products;}
	
	//public void setCategories(List<CategoryWeb> items) {this.categories = items;}
	//public List<CategoryWeb> getCategories() {return this.categories;}
	
	public Warehouse toWarehouse()
	{
		Warehouse warehouse = new Warehouse();
		warehouse.setCapacity(capacity);
		warehouse.setId(id);
		warehouse.setName(name);
		
		for (ProductWeb item: products)
		{
			Warehouse.connect(warehouse, item.toProduct());
		}
		
		/*
		for (CategoryWeb category: categories)
		{
			Warehouse.connectCategory(warehouse, category.toCategory());
			Category.connectWarehouse(category.toCategory(), warehouse);
		}
		*/
		
		return warehouse;
	}
}