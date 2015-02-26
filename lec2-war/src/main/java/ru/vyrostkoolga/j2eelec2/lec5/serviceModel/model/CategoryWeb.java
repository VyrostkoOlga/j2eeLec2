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

public class CategoryWeb
{
	private Integer id;
	private String name;
	private List<ProductWeb> products;
	
	public CategoryWeb()
	{
		products = new ArrayList<ProductWeb>();
	}
	
	public CategoryWeb(Category ctg)
	{
		id = ctg.getId();
		name = ctg.getName();
		
		products = new ArrayList<ProductWeb>();
		for (Product item: ctg.getItems())
		{
			products.add(new ProductWeb(item));
		}
	}
	
	public Integer getId() {return id;}
	public void setId(Integer id) {this.id = id;}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	public void setProducts(List<ProductWeb> items) {this.products = items;}
	public List<ProductWeb> getItems() {return this.products;}
	
	public Category toCategory()
	{
		Category ctg = new Category();
		ctg.setId(id);
		ctg.setName(name);
		
		return ctg;
	}
	
	public String toString()
	{
		return name;
	}
}
