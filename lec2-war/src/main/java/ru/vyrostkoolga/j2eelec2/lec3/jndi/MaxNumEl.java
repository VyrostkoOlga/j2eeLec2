package ru.vyrostkoolga.j2eelec2.lec3.jndi;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.naming.Referenceable;
import javax.naming.StringRefAddr;

public class MaxNumEl implements Referenceable
{
	public static final String REF_ADDR_REF = "ref";
	public static final String REF_ADDR_NUM = "number";
	
	private String _ref;
	private int _num;
	
	public MaxNumEl( String ref, int num )
	{
		_ref = ref;
		_num = num;
	}

	public Reference getReference( ) throws NamingException 
	{
		Reference ref = new Reference(
				MaxNumEl.class.getName( ),
				new StringRefAddr( "ref", _ref ),
				MaxNumElFactory.class.getName( ),
				null
				);

		ref.add( new StringRefAddr( "number", Integer.toString( _num ) ) ); 
		return ref;
	}

	public String toString( )
	{
		return _ref;
	}
	
	public String getRef( )
	{
		return _ref;
	}
	
	public int getNum( )
	{
		return _num;
	}
	
	public void setNum( int num )
	{
		_num = num;
	}
}
