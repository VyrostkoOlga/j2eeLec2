package ru.vyrostkoolga.j2eelec2.lec5.controllers;

import java.util.ArrayList;
import java.util.List;

import ru.vyrostkoolga.j2eelec2.lec4.entities.*;
import ru.vyrostkoolga.j2eelec2.lec4.repositories.*;
import ru.vyrostkoolga.j2eelec2.lec4.services.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ru.vyrostkoolga.j2eelec2.lec5.serviceModel.model.*;
import ru.vyrostkoolga.j2eelec2.lec5.serviceModel.requests.*;
import ru.vyrostkoolga.j2eelec2.lec5.serviceModel.response.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
@RequestMapping("/info")
public class RestController 
{
	@Autowired
	@Qualifier("customerService")
	private ICustomerService _customerService;
	
	@Autowired
	@Qualifier("warehouseService")
	private IWarehouseService _warehouseService;
	
	@Autowired
	@Qualifier("productService")
	private IProductService _productService;
	
	@Autowired
	@Qualifier("orderService")
	private IOrderService _orderService;
	
	@Autowired
	@Qualifier("categoryService")
	private ICategoryService _categoryService;
	
	@RequestMapping( value = "/customers/search/{name}", method = RequestMethod.GET )
	public @ResponseBody Response searchCustomerByName( @PathVariable( "name" ) String name )
	{
		try
		{
			List< Customer > customers = _customerService.findByName( name );
			List<CustomerWeb> webCustomers = new ArrayList<CustomerWeb>();
			for (Customer cus: customers)
			{
				CustomerWeb created = new CustomerWeb(cus);
				webCustomers.add(created);
			}
			
			CustomersResponse response = new CustomersResponse( );
			response.setCustomers( webCustomers );
			
			return response;
		}
		catch ( Exception exc )
		{
			ErrorResponse response = new ErrorResponse( );
			response.setStatus( "fail" );
			response.setMessage( exc.getMessage( ) );
			
			return response;
		}
	}
	
	@RequestMapping( value = "/customers/add", method = RequestMethod.POST )
	public @ResponseBody Response addNewCustomer( @RequestBody CustomerRequest request )
	{
		try
		{
			CustomerWeb customer = request.getCustomer( );
			List< OrderWeb > items = customer.getOrders( );
			Customer toUpdate = customer.toCustomer();
			
			Customer created = new Customer();
			created.setItems(new ArrayList<Order>());
			_customerService.create( created );
			toUpdate.setId(created.getId());
			
			_customerService.update( toUpdate );
			
			return new Response( );
		}
		catch ( Exception exc )
		{
			ErrorResponse response = new ErrorResponse( );
			response.setStatus( "fail" );
			response.setMessage( exc.getMessage( ) );
			
			return response;
		}
	}
	
	@RequestMapping( value = "/customers/{id}/orders", method = RequestMethod.GET )
	public @ResponseBody Response searchCustomersOrders( @PathVariable( "id" ) String cusId )
	{
		Integer id = Integer.parseInt(cusId);
		try
		{
			Customer customer = _customerService.findById( id );
			CustomerWeb webCustomer = new CustomerWeb(customer);
			List<OrderWeb> orders = webCustomer.getOrders();
			
			OrderResponse response = new OrderResponse();
			response.setOrders( orders );
			
			return response;
		}
		catch ( Exception exc )
		{
			ErrorResponse response = new ErrorResponse( );
			response.setStatus( "fail" );
			response.setMessage( exc.getMessage( ) );
			
			return response;
		}
	}
	
	@RequestMapping( value = "/customers/{id}/orders/add", method = RequestMethod.POST )
	public @ResponseBody Response addCustomersOrder( @PathVariable( "id" ) String cusId,
													 @RequestBody OrderRequest request)
	{
		Integer id = Integer.parseInt(cusId);
		try
		{
			Customer customer = _customerService.findById( id );
			OrderWeb webOrder = request.getOrder();
			Order order = webOrder.toOrder();
			Order created = _orderService.create(order);
			Customer.connect(customer, created);
			
			return new Response();
		}
		catch ( Exception exc )
		{
			ErrorResponse response = new ErrorResponse( );
			response.setStatus( "fail" );
			response.setMessage( exc.getMessage( ) );
			
			return response;
		}
	}
	
	@RequestMapping( value = "/customers/{id}/orders/{ordId}", method = RequestMethod.PUT )
	public @ResponseBody Response updateCustomersOrder( @PathVariable( "id" ) String cusId,
														@PathVariable( "ordId" ) String ordId,
													    @RequestBody OrderRequest request)
	{
		Integer id = Integer.parseInt(cusId);
		try
		{
			Customer customer = _customerService.findById( id );
			OrderWeb webOrder = request.getOrder();
			Order order = webOrder.toOrder();
			Order created = _orderService.findById(Integer.parseInt(ordId));
			order.setId(created.getId());
			if (!(id.equals(created.getId())))
			{
				throw new Exception("No such order in catalog of this customer");
			}
			
			order.setCustomer(customer);
			Customer.connect(customer, order);
			
			_orderService.update(order);
			_customerService.update(customer);
			
			return new Response();
		}
		catch ( Exception exc )
		{
			ErrorResponse response = new ErrorResponse( );
			response.setStatus( "fail" );
			response.setMessage( exc.getMessage( ) );
			
			return response;
		}
	}
	
	@RequestMapping( value = "/customers/{id}/orders/{ordId}", method = RequestMethod.DELETE )
	public @ResponseBody Response deleteCustomersOrder( @PathVariable( "id" ) String cusId,
														@PathVariable( "ordId" ) String ordId)
	{
		Integer id = Integer.parseInt(cusId);
		try
		{
			Customer customer = _customerService.findById( id );
			Order deleted = _orderService.findById(Integer.parseInt(ordId));
			if (!(id.equals(deleted.getId())))
			{
				throw new Exception("No such order in catalog of this customer");
			}
			_orderService.delete(deleted);
			_customerService.update(customer);
			
			return new Response();
		}
		catch ( Exception exc )
		{
			ErrorResponse response = new ErrorResponse( );
			response.setStatus( "fail" );
			response.setMessage( exc.getMessage( ) );
			
			return response;
		}
	}
	
	@RequestMapping( value = "/warehouses", method = RequestMethod.GET )
	public @ResponseBody Response searchWarehouses()
	{
		try
		{
			List< Warehouse > warehouses = _warehouseService.findAll();
			List<WarehouseWeb> webWarehouses = new ArrayList<WarehouseWeb>();
			for (Warehouse wh: warehouses)
			{
				webWarehouses.add(new WarehouseWeb(wh));
			}
			
			WarehouseResponse response = new WarehouseResponse( );
			response.setWarehouses( webWarehouses );
			
			return response;
		}
		catch ( Exception exc )
		{
			ErrorResponse response = new ErrorResponse( );
			response.setStatus( "fail" );
			response.setMessage( exc.getMessage( ) );
			
			return response;
		}
	}
	
	@RequestMapping( value = "/categories", method = RequestMethod.GET )
	public @ResponseBody Response searchCategories()
	{
		try
		{
			List< Category > ctgs = _categoryService.findAll();
			List<CategoryWeb> webCategories = new ArrayList<CategoryWeb>();
			for (Category item: ctgs)
			{
				webCategories.add(new CategoryWeb(item));
			}
			
			CategoryResponse response = new CategoryResponse( );
			response.setCategories( webCategories );
			
			return response;
		}
		catch ( Exception exc )
		{
			ErrorResponse response = new ErrorResponse( );
			response.setStatus( "fail" );
			response.setMessage( exc.getMessage( ) );
			
			return response;
		}
	}
	
	@RequestMapping( value = "/customers", method = RequestMethod.GET )
	public @ResponseBody Response searchCustomers()
	{
		try
		{
			List< Customer > customers = _customerService.findAll();
			List<CustomerWeb> webCustomers = new ArrayList<CustomerWeb>();
			for (Customer item: customers)
			{
				webCustomers.add(new CustomerWeb(item));
			}
			
			CustomersResponse response = new CustomersResponse( );
			response.setCustomers( webCustomers );
			
			return response;
		}
		catch ( Exception exc )
		{
			ErrorResponse response = new ErrorResponse( );
			response.setStatus( "fail" );
			response.setMessage( exc.getMessage( ) );
			
			return response;
		}
	}
	
	@RequestMapping( value = "/warehouses/{id}/products", method = RequestMethod.GET )
	public @ResponseBody Response searchProductsOnWarehouse(@PathVariable( "id" ) String nameId)
	{
		Integer id = Integer.parseInt(nameId);
		try
		{
			Warehouse wh = _warehouseService.findById(id);
			List<Product> products = wh.getItems();
			List<ProductWeb> productsWeb = new ArrayList<ProductWeb>();
			for (Product item: products)
			{
				productsWeb.add(new ProductWeb(item));
			}
			
			ProductsResponse response = new ProductsResponse();
			response.setProducts(productsWeb);
			
			return response;
		}
		catch ( Exception exc )
		{
			ErrorResponse response = new ErrorResponse( );
			response.setStatus( "fail" );
			response.setMessage( exc.getMessage( ) );
			
			return response;
		}
	}
	
	@RequestMapping( value = "/warehouses/{id}/products/add", method = RequestMethod.POST )
	public @ResponseBody Response addNewProduct( @PathVariable( "id" ) String nameId, @RequestBody ProductsRequest request )
	{
		Integer id = Integer.parseInt(nameId);
		try
		{
			ProductWeb product = request.getProduct();
			Product created = _productService.create(product.toProduct());
			return new Response( );
		}
		catch ( Exception exc )
		{
			ErrorResponse response = new ErrorResponse( );
			response.setStatus( "fail" );
			response.setMessage( exc.getMessage( ) );
			
			return response;
		}
	}
	
	@RequestMapping( value = "/warehouses/{id_war}/products/{id_prod}", method = RequestMethod.DELETE )
	public @ResponseBody Response deleteProductFromWarehouse(@PathVariable( "id_war") String nameId,
															@PathVariable("id_prod") String prodId)
	{
		Integer id = Integer.parseInt(nameId);
		Integer productId = Integer.parseInt(prodId);
		try
		{
			Product product = _productService.findById(productId);
			Warehouse warehouse = product.getWarehouse();
			if (!(id.equals(warehouse.getId())))
			{
				throw new Exception("Wrong warehouse id");
			}
			
			_productService.delete(productId);
			return new Response();
		}
		catch ( Exception exc )
		{
			ErrorResponse response = new ErrorResponse( );
			response.setStatus( "fail" );
			response.setMessage( exc.getMessage( ) );
			
			return response;
		}
	}
	
	@RequestMapping( value = "/warehouses/{id_war}/products/{id_prod}", method = RequestMethod.PUT )
	public @ResponseBody Response changeProductFromWarehouse(@PathVariable( "id_war") String nameId,
															@PathVariable("id_prod") String prodId,
															@RequestBody ProductsRequest request)
	{
		Integer id = Integer.parseInt(nameId);
		Integer productId = Integer.parseInt(prodId);
		try
		{
			Product changed = request.getProduct().toProduct();
			Product product = _productService.findById(productId);
			Warehouse warehouse = product.getWarehouse();
			if (!(id.equals(warehouse.getId())))
			{
				throw new Exception("Wrong warehouse id");
			}
			
			product.setDescription(changed.getDescription());
			product.setDiscount(changed.getDiscount());
			product.setItems(changed.getItems());
			product.setName(changed.getName());
			product.setPrice(changed.getPrice());
			product.setQuantity(changed.getQuantity());
			_productService.update(product);
			return new Response();
		}
		catch ( Exception exc )
		{
			ErrorResponse response = new ErrorResponse( );
			response.setStatus( "fail" );
			response.setMessage( exc.getMessage( ) );
			
			return response;
		}
	}
}
