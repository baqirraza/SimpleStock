package com.baqir.gbce.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class SimpleStockUtils {
	
	public static Date get15MinuteEarlierDate(){
		
		Calendar cl = new GregorianCalendar();
		cl.add(Calendar.MINUTE, -15);
		return cl.getTime();
	}
	
}
