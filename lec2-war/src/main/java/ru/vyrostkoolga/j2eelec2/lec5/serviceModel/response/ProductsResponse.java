package ru.vyrostkoolga.j2eelec2.lec5.serviceModel.response;

import java.util.List;

import ru.vyrostkoolga.j2eelec2.lec5.serviceModel.model.ProductWeb;

public class ProductsResponse extends Response
{
	private List<ProductWeb> _products;
	
	public void setProducts(List<ProductWeb> products) {_products = products;}
	public List<ProductWeb> getProducts() {return _products;}

}
