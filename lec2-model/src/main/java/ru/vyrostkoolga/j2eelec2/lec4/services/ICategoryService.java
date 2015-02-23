package ru.vyrostkoolga.j2eelec2.lec4.services;

import java.util.List;

import javax.persistence.*;

import ru.vyrostkoolga.j2eelec2.lec4.entities.*;

public interface ICategoryService 
{
	public Category create(Category category);
	public Category findById(Integer id) throws Exception;
	public Category delete(Category category) throws Exception;
	public List<Category> findAll();
	public Category update(Category category) throws Exception;
}
