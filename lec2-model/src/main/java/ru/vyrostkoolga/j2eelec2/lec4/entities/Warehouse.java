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

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name="warehouses")
public class Warehouse 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="capacity")
	private float capacity;
	
	@ManyToMany(targetEntity=Category.class)
	private List<Category> categories;
	 
	@OneToMany(mappedBy="warehouse", cascade=CascadeType.ALL)
	private List<Product> items;
	
	public Integer getId() {return id;}
	public void setId(Integer id) {this.id = id;}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	public float getCapacity() {return this.capacity;}
	public void setCapacity(float capacity) {this.capacity = capacity;}
	
	public void setItems(List<Product> items) {this.items = items;}
	public List<Product> getItems() {return this.items;}
	
	public void setCategories(List<Category> items) {this.categories = items;}
	public List<Category> getCategories() {return this.categories;}
	
	public static void connect( Warehouse ctg, Product item )
	{
		ctg.getItems( ).add( item );
		item.setWarehouse( ctg );
	}
	
	public static void connectCategory( Warehouse ctg, Category item )
	{
		ctg.getCategories( ).add( item );
		item.getWarehouses().add(ctg);
	}
	
	public String toString()
	{
		StringBuffer buf = new StringBuffer();
		buf.append(String.format("%s\n products:\n", name));
		for (Product one: items)
		{
			buf.append(String.format("%s\n", one.toString()));
		}
		buf.append("_______________________________________\n");
		buf.append("capacity:" + Float.toString(capacity) + "\n");
		return new String(buf);
	}
}