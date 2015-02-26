package ru.vyrostkoolga.j2eelec2.lec4.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ru.vyrostkoolga.j2eelec2.lec4.entities.Customer;
import ru.vyrostkoolga.j2eelec2.lec4.entities.Product;
import ru.vyrostkoolga.j2eelec2.lec4.repositories.ProductRepository;

public class ProductService implements IProductService
{
	@Autowired
	private ProductRepository productRepository;
	
	@Transactional(rollbackFor=Exception.class)
	public Product create(Product product)
	{
		Product created = product;
		productRepository.save(created);
		productRepository.flush();
		
		return created;
	}
	
	public Product findById(Integer id) throws Exception
	{
		Product found = productRepository.findOne(id);
		if (found == null)
		{
			throw new Exception("No such product");
		}
		return found;
	}
	
	public List<Product> findAll()
	{
		return productRepository.findAll();
	}
	
	@Transactional(rollbackFor=Exception.class)
	public Product update(Product product) throws Exception
	{
		Product updated = productRepository.findOne(product.getId());
		if (updated == null)
		{
			throw new Exception("No such product");
		}
		
		updated.setCategory(product.getCategory());
		updated.setDescription(product.getDescription());
		updated.setDiscount(product.getDiscount());
		updated.setItems(product.getItems());
		updated.setPrice(product.getPrice());
		updated.setQuantity(product.getQuantity());
		updated.setName(product.getName());
		updated.setWarehouse(product.getWarehouse());
		productRepository.save(updated);
		
		return updated;
	}

	@Transactional(rollbackFor=Exception.class)
	public Product delete(Integer id) throws Exception
		{
			Product deleted = productRepository.findOne(id);
			if (deleted == null)
			{
				throw new Exception("No such product");
			}
			
			productRepository.delete(deleted);
			return deleted; 
		}
	
	// lecture 5
	public List< Product > findByName( String name )
	{
		return productRepository.getProductByName(name);
	}
}