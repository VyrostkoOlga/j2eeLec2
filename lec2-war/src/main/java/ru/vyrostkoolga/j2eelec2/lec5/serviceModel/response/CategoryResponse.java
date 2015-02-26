package ru.vyrostkoolga.j2eelec2.lec5.serviceModel.response;

import java.util.List;

import ru.vyrostkoolga.j2eelec2.lec5.serviceModel.model.CategoryWeb;

public class CategoryResponse extends Response
{
	private List< CategoryWeb > _categories;
	
	// @formatter:off
	public void setCategories( List< CategoryWeb > categories ) { _categories = categories; }
	public List< CategoryWeb > getCategories( ) { return _categories; }
	// @formatter:on
}