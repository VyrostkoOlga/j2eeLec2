package ru.vyrostkoolga.j2eelec2.lec4.services;

import java.util.List;

import javax.persistence.*;

import ru.vyrostkoolga.j2eelec2.lec4.entities.*;

public interface ICustomerService 
{
	public Customer create(Customer customer);
	public Customer findById(Integer id) throws Exception;
	public Customer delete(Customer customer) throws Exception;
	public List<Customer> findAll();
	public Customer update(Customer customer) throws Exception;
	
	// lecture 5
	public List< Customer > findByName( String name );
}
