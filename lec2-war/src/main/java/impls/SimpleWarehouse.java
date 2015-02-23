package impls;

import java.util.ArrayList;
import java.util.List;

import ru.vyrostkoolga.j2eelec2.lec4.entities.Product;
import excs.NoSuchGoodException;
import interfaces.*;

public class SimpleWarehouse implements IWarehouse
{
	private List<Category> _categories;
	private List<Good> _goods;
	private String _name;
	private float _capacity;
	
	public SimpleWarehouse(String name, List<Category> ctgs)
	{
		_name = name;
		_categories = ctgs;
		_goods = new ArrayList<Good>();
	}
	
	public SimpleWarehouse(List<Category> ctgs, List<Good> goods)
	{
		_categories = ctgs;
		_goods = goods;
	}
	
	public void addCategory(String name) 
	{
		for (Category ctg: _categories)
		{
			if (ctg.getName().equals(name))
				return;
		}
		_categories.add(new Category(name));
	}
	

	@Override
	public void addOneGood(String name, float quantity, float price,
			float discount, String description, int ctg) 
	{
		for (Good one: _goods)
		{
			if (one.getName().equals(name))
			{
				one.setQuantity(one.getQuantity() + quantity);
			}
		}
		
		Good added = new Good(name, quantity, price, discount, description, ctg);
		_goods.add(added);
	}

	@Override
	public void getOneGood(int goodId, float quantity) throws NoSuchGoodException 
	{
		if (goodId < _goods.size())
		{
			throw new NoSuchGoodException(Integer.toString(goodId));
		}
		Good got = _goods.get(goodId);
		if (got.getQuantity() > quantity)
		{
			throw new NoSuchGoodException(Integer.toString(goodId));
		}
		
		got.setQuantity(got.getQuantity() - quantity);
	}

	@Override
	public String getInfo() 
	{
		StringBuffer buf = new StringBuffer();
		buf.append(String.format("%s\n products:\n", _name));
		for (Good one: _goods)
		{
			buf.append(String.format("%s\n", one.toString()));
		}
		buf.append("_______________________________________\n");
		buf.append("capacity:" + Float.toString(_capacity) + "\n");
		return new String(buf);
	}

}

