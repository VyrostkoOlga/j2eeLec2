package ru.vyrostkoolga.j2eelec2.lec4.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="categories")
public class Category 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@ManyToMany(targetEntity=Warehouse.class)
	private List<Warehouse> warehouses;
	 
	@OneToMany(mappedBy="Category", cascade=CascadeType.ALL)
	private List<Product> items;
	
	public Integer getId() {return id;}
	public void setId(Integer id) {this.id = id;}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	public void setItems(List<Product> items) {this.items = items;}
	public List<Product> getItems() {return this.items;}
	
	public void setWarehouses(List<Warehouse> items) {this.warehouses = items;}
	public List<Warehouse> getWarehouses() {return this.warehouses;}
	
	public static void connect( Category ctg, Product item )
	{
		ctg.getItems( ).add( item );
		item.setCategory( ctg );
	}
	
	public static void connectWarehouse( Category ctg, Warehouse item )
	{
		ctg.getWarehouses( ).add( item );
		item.getCategories().add(ctg);
	}
	
	public String toString()
	{
		return name;
	}
}
