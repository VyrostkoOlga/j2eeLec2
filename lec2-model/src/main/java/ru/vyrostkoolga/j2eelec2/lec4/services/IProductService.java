package ru.vyrostkoolga.j2eelec2.lec4.services;

import java.util.List;

import javax.persistence.*;

import ru.vyrostkoolga.j2eelec2.lec4.entities.*;

public interface IProductService 
{
	public Product create(Product product);
	public Product findById(Integer id) throws Exception;
	public Product delete(Integer id) throws Exception;
	public List<Product> findAll();
	public Product update(Product product) throws Exception;
	
	// lecture 5
	public List< Product > findByName( String name );
}