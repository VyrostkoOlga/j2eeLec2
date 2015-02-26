package ru.vyrostkoolga.j2eelec2.lec4.services;

import java.util.List;

import javax.persistence.*;

import ru.vyrostkoolga.j2eelec2.lec4.entities.*;

public interface IOrderService 
{
	public Order create(Order order);
	public Order findById(Integer id) throws Exception;
	public Order delete(Order order) throws Exception;
	public List<Order> findAll();
	public Order update(Order order) throws Exception;
	
}