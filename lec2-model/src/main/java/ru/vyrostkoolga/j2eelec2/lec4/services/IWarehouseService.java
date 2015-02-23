package ru.vyrostkoolga.j2eelec2.lec4.services;

import java.util.List;

import javax.persistence.*;

import ru.vyrostkoolga.j2eelec2.lec4.entities.*;

public interface IWarehouseService 
{
	public Warehouse create(Warehouse wHouse);
	public Warehouse findById(Integer id) throws Exception;
	public Warehouse delete(Warehouse wHouse) throws Exception;
	public List<Warehouse> findAll();
	public Warehouse update(Warehouse wHouse) throws Exception;
}
