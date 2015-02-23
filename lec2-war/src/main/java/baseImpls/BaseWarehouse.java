package baseImpls;

import java.util.ArrayList;

import excs.NoSuchGoodException;
import interfaces.*;
import ru.vyrostkoolga.j2eelec2.lec4.services.*;
import ru.vyrostkoolga.j2eelec2.lec4.entities.*;

public class BaseWarehouse implements IWarehouse
{
	private IProductService _productService;
	private IWarehouseService _warehouseService;
	private ICategoryService _categoryService;
	private Integer ind;
	
	public BaseWarehouse(IWarehouseService warService, ICategoryService catService,
						IProductService prodService, int id) throws Exception
	{
		_warehouseService = warService;
		_categoryService = catService;
		_productService = prodService;
		
		ind = id;
	}

	@Override
	public void addOneGood(String name, float quantity, float price,
			float discount, String description, int ctg)
	{
		Product product = new Product();
		product.setDescription(description);
		product.setName(name);
		product.setQuantity(quantity);
		product.setId(1);
		product.setItems(new ArrayList<OrderItem>());
		product.setPrice(price);
		try
		{
			product.setWarehouse(_warehouseService.findById(ind));
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		
		try
		{
			Category category = _categoryService.findById(ctg);
			product.setCategory(category);
		}
		catch (Exception ex)
		{
			Category category = new Category();
			category.setId(1);
			category.setItems(new ArrayList<Product>());
			category.setName("Unknown");
			category.setWarehouses(new ArrayList<Warehouse>());
			Warehouse.connectCategory(product.getWarehouse(), category);
			Category.connect(category, product);
			_categoryService.create(category);
		}
		
		_productService.create(product);
		Warehouse.connect(product.getWarehouse(), product);
	}

	@Override
	public void getOneGood(int goodId, float quantity)
			throws NoSuchGoodException 
	{
		try
		{
			Product good = _productService.findById(goodId);
			float qnt = good.getQuantity();
			if (qnt < quantity)
			{
				throw new Exception();
			}
			
			good.setQuantity(qnt - quantity);
			_productService.update(good);
		}
		catch (Exception ex)
		{
			throw new NoSuchGoodException("No good with id " + Integer.toString(goodId));
		}
		
	}

	@Override
	public String getInfo() 
	{
		return _warehouseService.toString();
	}

}
