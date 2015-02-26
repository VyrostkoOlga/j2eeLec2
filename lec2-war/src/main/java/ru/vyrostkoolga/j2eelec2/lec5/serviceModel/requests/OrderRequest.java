package ru.vyrostkoolga.j2eelec2.lec5.serviceModel.requests;

import ru.vyrostkoolga.j2eelec2.lec5.serviceModel.model.OrderWeb;

public class OrderRequest extends Request
{
	private OrderWeb _order;
	
	public void setOrder( OrderWeb order ) { _order = order; }
	public OrderWeb getOrder( ) { return _order; }
}
