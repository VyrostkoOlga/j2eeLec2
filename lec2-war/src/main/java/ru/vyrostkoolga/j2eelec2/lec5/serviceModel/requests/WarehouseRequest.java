package ru.vyrostkoolga.j2eelec2.lec5.serviceModel.requests;

import ru.vyrostkoolga.j2eelec2.lec5.serviceModel.model.WarehouseWeb;

public class WarehouseRequest extends Request
{

	private WarehouseWeb _warehouse;
	
	public void setWarehouse(WarehouseWeb warehouse) {_warehouse = warehouse;}
	public WarehouseWeb getWarehouse() {return _warehouse;}
}
