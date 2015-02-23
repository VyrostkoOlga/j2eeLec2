package interfaces;

import java.util.ArrayList;
import java.util.List;

import excs.NoSuchGoodException;

public interface IWarehouse 
{
	public void addOneGood(String name, float quantity, float price, 
							float discount, String description, int ctg);
	public void getOneGood(int goodId, float quantity) throws NoSuchGoodException;
	
	public String getInfo();
}

