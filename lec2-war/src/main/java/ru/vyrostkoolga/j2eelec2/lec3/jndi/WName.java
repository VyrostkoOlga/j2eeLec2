package ru.vyrostkoolga.j2eelec2.lec3.jndi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.naming.*;

public class WName implements Referenceable
{
	public static final String REF_ADDR_REF = "ref";
	public static final String REF_ADDR_NAME = "name";
	public static final Logger mLog = LoggerFactory.getLogger(WName.class.getName());
	
	private String _ref;
	private String _name;
	
	public WName(String ref, String name)
	{
		_ref = ref;
		_name = name;
	}
	
	public String getRef()
	{
		return _ref;
	}
	public void setRef(String ref)
	{
		_ref = ref;
	}
	
	public String getName()
	{
		return _name;
	}
	public void setName(String name)
	{
		_name = name;
	}
	
	@Override
	public Reference getReference() throws NamingException 
	{
		Reference ref = new Reference(
				WName.class.getName( ),
				new StringRefAddr( "ref", _ref ),
				MaxNumElFactory.class.getName( ),
				null
			);
		
		mLog.info("Ref WName is created" + ref.toString());	
		ref.add( new StringRefAddr( "name", _name ) ); 
			
		return ref;
	}

}
