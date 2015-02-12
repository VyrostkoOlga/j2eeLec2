package interfaces;

import java.util.ArrayList;
import java.util.List;

import excs.NoSuchGoodException;

public interface IWarehouse 
{
	public void getOneGood(String goodName, int qty) throws NoSuchGoodException;
	public void addOneGood(IGood newGood, String ctgName);
	
	public List<ICategory> getCtgs();
	public void setCtgs(List<ICategory> ctgs);
	
	public void addCategory(ICategory ctg);
	
	public String getInfo();
}

