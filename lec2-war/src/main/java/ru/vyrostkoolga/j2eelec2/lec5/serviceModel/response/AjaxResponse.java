package ru.vyrostkoolga.j2eelec2.lec5.serviceModel.response;

public class AjaxResponse extends Response
{
	private String _str;
		
	// @formatter:off
	public void setStr( String str ) { _str = str; }
	public String getStr( ) { return _str; }
	// @formatter:on
}