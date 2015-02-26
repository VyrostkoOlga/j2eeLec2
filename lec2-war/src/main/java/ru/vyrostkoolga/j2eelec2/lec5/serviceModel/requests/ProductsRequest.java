package ru.vyrostkoolga.j2eelec2.lec5.serviceModel.requests;

import ru.vyrostkoolga.j2eelec2.lec5.serviceModel.model.ProductWeb;

public class ProductsRequest extends Request
{
	private ProductWeb _product;
	
	public void setProduct(ProductWeb product) {_product = product;}
	public ProductWeb getProduct() {return _product;}

}
