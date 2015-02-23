package impls;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import excs.NoSuchGoodException;
import interfaces.*;

public class Category
{
	private String _name;
	private List<Good> _goods;
	
	public Category(String name)
	{
		_name = name;
		_goods = new ArrayList<Good>();
	}
	
	public Category(String name, List<Good> goods)
	{
		_name = name;
		_goods = goods;
	}
	
	public String getName() {return _name;}
	public void setName(String name) {_name = name;}
	
	public void connectGood(Good connected)
	{
		_goods.add(connected);
	}

}
