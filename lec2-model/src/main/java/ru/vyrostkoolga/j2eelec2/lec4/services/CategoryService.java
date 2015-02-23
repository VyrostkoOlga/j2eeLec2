package ru.vyrostkoolga.j2eelec2.lec4.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ru.vyrostkoolga.j2eelec2.lec4.entities.Category;
import ru.vyrostkoolga.j2eelec2.lec4.repositories.CategoryRepository;

public class CategoryService implements ICategoryService
{
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Transactional(rollbackFor=Exception.class)
	public Category create(Category category)
	{
		Category created = category;
		categoryRepository.save(created);
		categoryRepository.flush();
		
		return created;
	}
	
	public Category findById(Integer id) throws Exception
	{
		Category found = categoryRepository.findOne(id);
		if (found == null)
		{
			throw new Exception("No such category");
		}
		return found;
	}
	
	@Transactional(rollbackFor=Exception.class)
	public Category delete(Category category) throws Exception
	{
		Category deleted = categoryRepository.findOne(category.getId());
		if (deleted == null)
		{
			throw new Exception("No such category");
		}
		
		categoryRepository.delete(deleted);
		return deleted; 
	}
	
	
	public List<Category> findAll()
	{
		return categoryRepository.findAll();
	}
	
	@Transactional(rollbackFor=Exception.class)
	public Category update(Category category) throws Exception
	{
		Category updated = categoryRepository.findOne(category.getId());
		if (updated == null)
		{
			throw new Exception("No such category");
		}
		
		updated.setName(category.getName());
		updated.setItems(category.getItems());
		categoryRepository.save(updated);
		
		return updated;
	}

}


