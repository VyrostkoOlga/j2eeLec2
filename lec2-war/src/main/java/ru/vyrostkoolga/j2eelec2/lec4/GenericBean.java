package ru.vyrostkoolga.j2eelec2.lec4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.vyrostkoolga.j2eelec2.lec4.entities.Category;
import ru.vyrostkoolga.j2eelec2.lec4.entities.Customer;
import ru.vyrostkoolga.j2eelec2.lec4.entities.Order;
import ru.vyrostkoolga.j2eelec2.lec4.entities.Product;
import ru.vyrostkoolga.j2eelec2.lec4.entities.Warehouse;
import ru.vyrostkoolga.j2eelec2.lec4.repositories.CustomerRepository;
import ru.vyrostkoolga.j2eelec2.lec4.services.ICategoryService;
import ru.vyrostkoolga.j2eelec2.lec4.services.ICustomerService;
import ru.vyrostkoolga.j2eelec2.lec4.services.IProductService;
import ru.vyrostkoolga.j2eelec2.lec4.services.IWarehouseService;

public class GenericBean
{
	private static final Logger log = LoggerFactory.getLogger( GenericBean.class );
	
	private ICustomerService _customerService;
	private IWarehouseService _warehouseService;
	private IProductService _productService;
	private ICategoryService _categoryService;
	
	// @formatter:off
	public void setCustomerService( ICustomerService customerService ) { _customerService = customerService; }
	public ICustomerService getCustomerService( ) { return _customerService; }
	
	public void setWarehouseService( IWarehouseService warehouseService ) { _warehouseService = warehouseService;}
	public IWarehouseService getWarehouseService() {return _warehouseService;}
	
	public void setCategoryService(ICategoryService categoryService) {_categoryService = categoryService;}
	public ICategoryService getCategoryService() {return _categoryService;}
	
	public void setProductService(IProductService productService) {_productService = productService;}
	public IProductService getProductService() {return _productService;}
	// @formatter:on
	
	public void init( )
	{
		try
		{
			Warehouse wHouse = _warehouseService.findById(1);
			log.info(wHouse.toString());
		}
		catch ( Exception exc )
		{
			log.error( "Error", exc );
		}
	}
}
