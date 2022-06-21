package com.crm.vtigerTY.genericUtilities;

import java.util.Date;
import java.util.Random;

/**
 * 
 * @author Hemanth
 *
 */
public class JavaUtility {
	/**
	 * it is used to generate random number
	 * @return
	 */
	public int getRandomNumber()
	{
		Random random = new Random();
		int randomNumber = random.nextInt(1000);
		return randomNumber;
	}
	/**
	 * It is used to get system date and time in IST format
	 * @return
	 */
	public String getSystemdateAndTypeInISTFormat()
	{
		Date date = new Date();
		String value = date.toString();
		String dateAndTime = value.replaceAll(":", "-");
		return dateAndTime;
	}
	/**
	 * it is used get date and time in required format yyyy-mm-dd
	 * @return
	 */
	public String getSystemDateAndTimeInFormat()
	{
		Date date = new Date();
		String dateandtime = date.toString();
		String yyyy = dateandtime.split(" ")[5];
		String dd = dateandtime.split(" ")[2];
		int mm = date.getMonth()+1;
		String format = yyyy+"-"+mm+"-"+dd;
		return format;		
	}
}
