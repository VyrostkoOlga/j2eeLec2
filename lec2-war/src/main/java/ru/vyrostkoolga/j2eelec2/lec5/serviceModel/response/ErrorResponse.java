package ru.vyrostkoolga.j2eelec2.lec5.serviceModel.response;

public class ErrorResponse extends Response
{
	private String _message;
	
	// @formatter:off
	public void setMessage( String message ) { _message = message; }
	public String getMessage( ) { return _message; }
	// @formatter:on
}
