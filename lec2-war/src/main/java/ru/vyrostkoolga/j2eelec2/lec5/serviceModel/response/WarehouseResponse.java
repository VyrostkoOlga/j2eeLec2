package ru.vyrostkoolga.j2eelec2.lec5.serviceModel.response;

import java.util.List;

import ru.vyrostkoolga.j2eelec2.lec5.serviceModel.model.WarehouseWeb;

public class WarehouseResponse extends Response
{
	private List<WarehouseWeb> _warehouses;
	
	public List<WarehouseWeb> getWarehouses() {return _warehouses;}
	public void setWarehouses(List<WarehouseWeb> warehouses) {_warehouses = warehouses;} 

}
