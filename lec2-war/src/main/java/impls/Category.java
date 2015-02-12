package impls;

import java.util.*;

import excs.NoSuchGoodException;
import interfaces.*;

public class Category implements ICategory
{
	private String _name;
	private List<IGood> _goods;
	
	public Category(String name)
	{
		_name = name;
		_goods = new ArrayList<IGood>();
	}

	public String getName() {return _name;}
	public void setName(String name) {_name = name;}

	public void getOneGood(String goodName, int qty) throws NoSuchGoodException 
	{
		for (IGood one: _goods)
		{
			if (one.getName().equals(goodName))
			{
				if (one.getQty() >= qty)
				{
					one.setQty(one.getQty() - qty);
					return;
				}
				else
				{
					throw new NoSuchGoodException(goodName);
				}
			}
		}
		throw new NoSuchGoodException(goodName);
	}
	public void addOneGood(IGood newGood)
	{
		String name = newGood.getName();
		for (IGood one: _goods)
		{
			if (one.getName().equals(name))
			{
				one.setQty(one.getQty() + newGood.getQty());
			}
		}
		
		_goods.add(newGood);
	}

	public String getInfo() 
	{
		StringBuffer buf = new StringBuffer(_name + ":\n");
		for (IGood one: _goods)
		{
			buf.append(one.getInfo());
		}
		return new String(buf);
	}

	public List<IGood> getGoods()
	{
		return _goods;
	}

	public void setGoods(List<IGood> goods) 
	{
		_goods = goods;
	}
}
