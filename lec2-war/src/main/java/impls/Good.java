package impls;

import interfaces.IGood;

public class Good implements IGood
{
	private String _name;
	private double _price;
	private int _qty;
	
	public Good(String name, double price, int qty)
	{
		_name = name;
		_price = price;
		_qty = qty;
	}

	public void setName(String name) {_name = name;}
	public String getName() {return _name;}

	public void setPrice(double price) {_price = price;}
	public double getPrice() {return _price;}

	public void setQty(int qty) {_qty = qty;}
	public int getQty() {return _qty;}

	public String getInfo() 
	{
		return _name + " " + _price + " " + _qty + "\n"; 
	}
	
}

