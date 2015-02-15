package ru.vyrostkoolga.j2eelec2.lec3.jndi;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.RefAddr;
import javax.naming.Reference;
import javax.naming.spi.ObjectFactory;

public class MaxNumElFactory implements ObjectFactory
{
	public Object getObjectInstance( Object obj, Name name, Context nameCtx, Hashtable< ?, ? > environment ) 
		throws Exception
	{
		if ( obj instanceof Reference ) 
		{
			Reference ref = ( Reference )obj;
			
			if ( ref.getClassName( ).equals( MaxNumEl.class.getName( ) ) )  
			{
				RefAddr addrRef = ref.get( MaxNumEl.REF_ADDR_REF );
				RefAddr addrNumber = ref.get( MaxNumEl.REF_ADDR_NUM );
				
				if ( null != addrRef && null != addrNumber )
				{
					return new MaxNumEl( 
						addrRef.getContent( ).toString( ), 
						Integer.parseInt( addrNumber.getContent( ).toString( ) ) 
					);
				}
			}
		}
		
		return null;	
	}
}
