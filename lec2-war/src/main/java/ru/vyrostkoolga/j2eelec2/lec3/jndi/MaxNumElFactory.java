package ru.vyrostkoolga.j2eelec2.lec3.jndi;

import java.util.Hashtable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.naming.*;
import javax.naming.spi.ObjectFactory;

public class MaxNumElFactory implements ObjectFactory
{
	public static final Logger mLog = LoggerFactory.getLogger(MaxNumElFactory.class.getName());
	
	@Override
	public Object getObjectInstance(Object obj, Name name, Context ctx,
			Hashtable<?, ?> env) throws Exception 
	{
		if (obj instanceof Reference)
		{
			Reference ref = (Reference) obj;
			mLog.info("Factory ref is" + ref.toString());
			if (ref.getClassName().equals(MaxNumEl.class.getName()))
			{
				RefAddr addrRef = ref.get( MaxNumEl.REF_ADDR_REF);
				RefAddr addrNum = ref.get( MaxNumEl.REF_ADDR_NUM);
				mLog.info(addrRef.toString() + addrNum.toString());
				
				if ( null != addrRef && null != addrNum )
				{
					return new MaxNumEl( 
						addrRef.getContent( ).toString( ), 
						Integer.parseInt( addrNum.getContent( ).toString( ) ) 
					);
				}
			}
			else if (ref.getClassName().equals(Frequency.class.getName()))
			{
				RefAddr addrRef = ref.get( MaxNumEl.REF_ADDR_REF);
				RefAddr addrNum = ref.get( MaxNumEl.REF_ADDR_NUM);
				mLog.info(addrRef.toString() + addrNum.toString());
				
				if ( null != addrRef && null != addrNum )
				{
					return new Frequency( 
						addrRef.getContent( ).toString( ), 
						Integer.parseInt( addrNum.getContent( ).toString( ) ) 
					);
				}
			}
			else if (ref.getClassName().equals(WName.class.getName()))
			{
				RefAddr addrRef = ref.get( WName.REF_ADDR_REF);
				RefAddr addrName = ref.get( WName.REF_ADDR_NAME);
				mLog.info(addrRef.toString() + addrName.toString());
				
				if ( null != addrRef && null != addrName )
				{
					return new WName( 
						addrRef.getContent( ).toString( ), 
						addrName.getContent( ).toString( ) 
					);
				}
			}
			else if (ref.getClassName().equals(CtgMax.class.getName()))
			{
				RefAddr addrRef = ref.get( CtgMax.REF_ADDR_REF);
				RefAddr addrName = ref.get( CtgMax.REF_ADDR_NUM);
				mLog.info(addrRef.toString() + addrName.toString());
				
				if ( null != addrRef && null != addrName )
				{
					return new CtgMax( 
						addrRef.getContent( ).toString( ), 
						Integer.parseInt(addrName.getContent( ).toString( ))
					);
				}
			}
		}
		return null;
	}

}
