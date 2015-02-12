package interfaces;

import java.util.*;

import excs.NoSuchGoodException;

public interface ICategory 
{
	public String getName();
	public void setName(String name);
	
	public void getOneGood(String goodName, int qty) throws NoSuchGoodException;
	public void addOneGood(IGood newGood);
	
	public List<IGood> getGoods();
	public void setGoods(List<IGood> goods);
	
	public String getInfo();
}

