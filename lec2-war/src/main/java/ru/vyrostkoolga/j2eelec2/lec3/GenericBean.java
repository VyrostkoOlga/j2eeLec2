package ru.vyrostkoolga.j2eelec2.lec3;
import javax.naming.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.vyrostkoolga.j2eelec2.lec3.jndi.MaxNumEl;

public class GenericBean
{
	private static final Logger log = LoggerFactory.getLogger( GenericBean.class );
	
	private MaxNumEl _maxNumEl;
	
	// @formatter:off
	public void setMaxNumEl( MaxNumEl max_num ) { _maxNumEl = max_num; }
	public MaxNumEl getComfortableTemperature( ) { return _maxNumEl; }
	// @formatter:on
	
	public void init( )
	{
		log.info( String.format(
			"Reference %s describes comfortable temperature as %f",
			_maxNumEl.getRef( ), _maxNumEl.getNum( )
		) );
	}
}
