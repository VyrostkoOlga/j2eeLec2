package ru.vyrostkoolga.j2eelec2.lec4.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ru.vyrostkoolga.j2eelec2.lec4.entities.Customer;
import ru.vyrostkoolga.j2eelec2.lec4.entities.Warehouse;
import ru.vyrostkoolga.j2eelec2.lec4.repositories.WarehouseRepository;

public class WarehouseService implements IWarehouseService
{
	@Autowired
	private WarehouseRepository warehouseRepository;
	
	@Transactional(rollbackFor=Exception.class)
	public Warehouse create(Warehouse warehouse)
	{
		Warehouse created = warehouse;
		warehouseRepository.save(created);
		warehouseRepository.flush();
		
		return created;
	}
	
	public Warehouse findById(Integer id) throws Exception
	{
		Warehouse found = warehouseRepository.findOne(id);
		if (found == null)
		{
			throw new Exception("No such warehouse");
		}
		return found;
	}
	
	public List<Warehouse> findAll()
	{
		return warehouseRepository.findAll();
	}
	
	@Transactional(rollbackFor=Exception.class)
	public Warehouse update(Warehouse warehouse) throws Exception
	{
		Warehouse updated = warehouseRepository.findOne(warehouse.getId());
		if (updated == null)
		{
			throw new Exception("No such warehouse");
		}
		
		updated.setName(warehouse.getName());
		updated.setItems(warehouse.getItems());
		warehouseRepository.save(updated);
		
		return updated;
	}

	@Transactional(rollbackFor=Exception.class)
	public Warehouse delete(Warehouse wHouse) throws Exception 
	{
			Warehouse deleted = warehouseRepository.findOne(wHouse.getId());
			if (deleted == null)
			{
				throw new Exception("No such warehouse");
			}
			
			warehouseRepository.delete(deleted);
			return deleted; 
	}

}
