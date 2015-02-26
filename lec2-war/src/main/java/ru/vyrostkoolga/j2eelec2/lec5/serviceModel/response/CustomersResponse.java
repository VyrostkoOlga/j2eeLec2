package ru.vyrostkoolga.j2eelec2.lec5.serviceModel.response;

import java.util.List;

import ru.vyrostkoolga.j2eelec2.lec5.serviceModel.model.CustomerWeb;

public class CustomersResponse extends Response
{
	private List< CustomerWeb > _customers;
	
	// @formatter:off
	public void setCustomers( List< CustomerWeb > customers ) { _customers = customers; }
	public List< CustomerWeb > getCustomers( ) { return _customers; }
	// @formatter:on
}
