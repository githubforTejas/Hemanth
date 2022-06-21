package com.crm.vtigerTY.genericUtilities;
/**
 * 
 * @author Hemanth
 *
 */
import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility 
{
	/**
	 * it is used to fetch common data from property file based on  key you have specified as arguments
	 * @return
	 * @throws Throwable
	 */
	public String getPropertyKeyValue(String key) throws Throwable
	{
		FileInputStream fileInputStream = new FileInputStream(IPathConstant.filepath);
		Properties properties = new Properties();
		properties.load(fileInputStream);
		String value=	properties.getProperty(key);
		return value;		
	}
}
