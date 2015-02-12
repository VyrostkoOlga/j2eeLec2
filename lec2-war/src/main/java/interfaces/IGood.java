package interfaces;

public interface IGood 
{
	public void setName(String name);
	public String getName();
	
	public void setPrice(double price);
	public double getPrice();
	
	public void setQty(int qty);
	public int getQty();
	
	public String getInfo();
}

