package ru.vyrostkoolga.j2eelec2.lec4.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ru.vyrostkoolga.j2eelec2.lec4.entities.Order;
import ru.vyrostkoolga.j2eelec2.lec4.repositories.OrderRepository;

public class OrderService implements IOrderService
{
	@Autowired
	private OrderRepository orderRepository;
	
	@Transactional(rollbackFor=Exception.class)
	public Order create(Order order)
	{
		Order created = order;
		orderRepository.save(created);
		orderRepository.flush();
		
		return created;
	}
	
	public Order findById(Integer id) throws Exception
	{
		Order found = orderRepository.findOne(id);
		if (found == null)
		{
			throw new Exception("No such order");
		}
		return found;
	}
	
	@Transactional(rollbackFor=Exception.class)
	public Order delete(Order order) throws Exception
	{
		Order deleted = orderRepository.findOne(order.getId());
		if (deleted == null)
		{
			throw new Exception("No such order");
		}
		
		orderRepository.delete(deleted);
		return deleted; 
	}
	public List<Order> findAll()
	{
		return orderRepository.findAll();
	}
	
	@Transactional(rollbackFor=Exception.class)
	public Order update(Order order) throws Exception
	{
		Order updated = orderRepository.findOne(order.getId());
		if (updated == null)
		{
			throw new Exception("No such order");
		}
		
		updated.setItems(order.getItems());
		orderRepository.save(updated);
		
		return updated;
	}
}