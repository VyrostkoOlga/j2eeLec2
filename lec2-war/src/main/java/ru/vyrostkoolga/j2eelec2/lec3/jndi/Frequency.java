package ru.vyrostkoolga.j2eelec2.lec3.jndi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.naming.*;

public class Frequency implements Referenceable
{
	public static final String REF_ADDR_REF = "ref";
	public static final String REF_ADDR_NUM = "num";
	public static final Logger mLog = LoggerFactory.getLogger(MaxNumEl.class.getName());
	
	private String _ref;
	private int _num;
	
	public Frequency(String ref, int num)
	{
		_ref = ref;
		_num = num;
	}
	
	public String getRef()
	{
		return _ref;
	}
	public void setRef(String ref)
	{
		_ref = ref;
	}
	
	public int getNum()
	{
		return _num;
	}
	public void setNum(int num)
	{
		_num = num;
	}
	
	@Override
	public Reference getReference() throws NamingException 
	{
		Reference ref = new Reference(
				Frequency.class.getName( ),
				new StringRefAddr( "ref", _ref ),
				MaxNumElFactory.class.getName( ),
				null
			);
		
		mLog.info("Ref Freq is created" + ref.toString());	
		ref.add( new StringRefAddr( "num", Integer.toString( _num ) ) ); 
			
		return ref;
	}
}
