package impls;

import java.util.ArrayList;
import java.util.List;

import excs.NoSuchGoodException;
import interfaces.*;

public class SimpleWarehouse implements IWarehouse
{
	private List<ICategory> _ctgs; //Without specifying type of a category Category is used
	private String _name;
	
	public SimpleWarehouse(String name)
	{
		_name = name;
		_ctgs = new ArrayList<ICategory>();
	}

	public void getOneGood(String goodName, int qty) throws NoSuchGoodException 
	{
		for (ICategory ctg: _ctgs)
		{
			try
			{
				ctg.getOneGood(goodName, qty);
				return;
			}
			catch (NoSuchGoodException ex)
			{
				continue;
			}
		}
		throw new NoSuchGoodException(goodName);
	}

	public void addOneGood(IGood newGood, String ctgName) 
	{
		for (ICategory ctg: _ctgs)
		{
			if (ctg.getName().equals(ctgName))
			{
				ctg.addOneGood(newGood);
				return;
			}
		}
		ICategory ctg = new Category(ctgName);
		ctg.addOneGood(newGood);
		_ctgs.add(ctg);
	}

	public List<ICategory> getCtgs() {return _ctgs;}
	public void setCtgs(List<ICategory> ctgs) {_ctgs = ctgs;}

	public String getInfo() 
	{
		StringBuffer buf = new StringBuffer("Warehouse " + _name + ":\n");
		for (ICategory one: _ctgs)
		{
			buf.append(one.getInfo());
		}
		return new String(buf);
	}

	public void addCategory(ICategory ctg) 
	{
		_ctgs.add(ctg);
	}

}

