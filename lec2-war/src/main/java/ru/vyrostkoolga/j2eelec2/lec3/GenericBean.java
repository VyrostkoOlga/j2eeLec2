package ru.vyrostkoolga.j2eelec2.lec3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.vyrostkoolga.j2eelec2.lec3.jndi.*;

public class GenericBean 
{
	private static final Logger mLog = LoggerFactory.getLogger(GenericBean.class.getName());
	
	private MaxNumEl _maxNumEl;
	private Frequency _frequency;
	private CtgMax _ctgMax;
	private WName _warName;
	
	public void setMaxNumEl(MaxNumEl num) { _maxNumEl = num; }
	public MaxNumEl getMaxNumEl() { return _maxNumEl;}
	
	public void setFrequency(Frequency freq) { _frequency = freq; }
	public Frequency getFrequency() { return _frequency;}
	
	public void setWarName(WName wName) { _warName = wName; }
	public WName getWarName(){return _warName;}
	
	public void setCtgMax(CtgMax ctgMax) { _ctgMax = ctgMax; }
	public CtgMax getCtgMax() {return _ctgMax;}
	
	public void init ( )
	{
		mLog.info("MaxNumEl is created");
		mLog.info("Frequency is created");
		mLog.info("WName is created");
		mLog.info("CtgMax is created");
	}

}
