package impls;

public class Good 
{
	private String _name;
	private float _price;
	private float _quantity;
	private float _discount;
	private String _description;
	private int _ctgId;
	
	public Good (String name, float quantity, float price,
			float discount, String description, int ctg) 
	{
		_name = name;
		_quantity = quantity;
		_price = price;
		_discount = discount;
		_description = description;
		_ctgId = ctg;
	}
	
	public void setName(String name) {_name = name;}
	public String getName() {return _name;}
	
	public void setDescription(String ds) {_description = ds;}
	public String getDescription() {return _description;}
	
	public float getQuantity() {return _quantity;}
	public void setQuantity(float quantity) {_quantity = quantity;}
	
	public String toString()
	{
		return _name + "........................" + Float.toString(_quantity);
	}
}

