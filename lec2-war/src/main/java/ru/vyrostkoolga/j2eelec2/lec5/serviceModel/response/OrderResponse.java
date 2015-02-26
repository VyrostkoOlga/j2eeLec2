package ru.vyrostkoolga.j2eelec2.lec5.serviceModel.response;

import java.util.List;

import ru.vyrostkoolga.j2eelec2.lec5.serviceModel.model.OrderWeb;

public class OrderResponse extends Response
{
	private List< OrderWeb > _orders;
	
	// @formatter:off
	public void setOrders( List< OrderWeb > orders ) { _orders = orders; }
	public List< OrderWeb > getOrders( ) { return _orders; }
	// @formatter:on
}
