package ru.vyrostkoolga.j2eelec2.lec4.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ru.vyrostkoolga.j2eelec2.lec4.entities.Customer;
import ru.vyrostkoolga.j2eelec2.lec4.repositories.CustomerRepository;

public class CustomerService implements ICustomerService
{
	@Autowired
	private CustomerRepository customerRepository;
	
	@Transactional(rollbackFor=Exception.class)
	public Customer create(Customer customer)
	{
		Customer created = customer;
		customerRepository.save(created);
		customerRepository.flush();
		
		return created;
	}
	
	public Customer findById(Integer id) throws Exception
	{
		Customer found = customerRepository.findOne(id);
		if (found == null)
		{
			throw new Exception("No such customer");
		}
		return found;
	}
	
	@Transactional(rollbackFor=Exception.class)
	public Customer delete(Customer customer) throws Exception
	{
		Customer deleted = customerRepository.findOne(customer.getId());
		if (deleted == null)
		{
			throw new Exception("No such customer");
		}
		
		customerRepository.delete(deleted);
		return deleted; 
	}
	public List<Customer> findAll()
	{
		return customerRepository.findAll();
	}
	
	@Transactional(rollbackFor=Exception.class)
	public Customer update(Customer customer) throws Exception
	{
		Customer updated = customerRepository.findOne(customer.getId());
		if (updated == null)
		{
			throw new Exception("No such customer");
		}
		
		updated.setName(customer.getName());
		updated.setItems(customer.getItems());
		customerRepository.save(updated);
		
		return updated;
	}

}
