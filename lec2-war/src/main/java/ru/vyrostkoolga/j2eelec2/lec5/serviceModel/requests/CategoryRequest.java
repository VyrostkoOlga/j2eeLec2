package ru.vyrostkoolga.j2eelec2.lec5.serviceModel.requests;

import ru.vyrostkoolga.j2eelec2.lec5.serviceModel.model.CategoryWeb;

public class CategoryRequest extends Request
{
	private CategoryWeb _category;
	
	public void setCategory( CategoryWeb category ) { _category = category; }
	public CategoryWeb getCategory( ) { return _category; }
}
