package ru.vyrostkoolga.j2eelec2.lec5.serviceModel.requests;

import ru.vyrostkoolga.j2eelec2.lec5.serviceModel.model.CustomerWeb;

public class CustomerRequest extends Request
{
	private CustomerWeb _customer;
	
	public void setCustomer( CustomerWeb customer ) { _customer = customer; }
	public CustomerWeb getCustomer( ) { return _customer; }
}
