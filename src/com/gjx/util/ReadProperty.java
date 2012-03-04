package com.gjx.util;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import org.apache.commons.logging.*;

public class ReadProperty {
	private static final Log logger=LogFactory.getLog(ReadProperty.class);
	private String driver=null;
	private String username =null;
	private String password=null;
	private String url     =null;
	Properties prop=null;
	public ReadProperty(String packageNameAndPropertyName){
		try {
			
			String pathName=this.getClass().getResource("/").getPath()+packageNameAndPropertyName;
			
			FileInputStream fis=new FileInputStream(pathName);
			prop=new Properties();			
			prop.load(fis);			
			Set set=prop.keySet();
			Iterator it=set.iterator();
			while(it.hasNext()){
				String key=(String)it.next();
				
				if(key.equalsIgnoreCase("username"))this.username=prop.getProperty(key);
				if(key.equalsIgnoreCase("password"))this.password=prop.getProperty(key);
				if(key.equalsIgnoreCase("driver"))this.driver=prop.getProperty(key);
				if(key.equalsIgnoreCase("url"))this.url=prop.getProperty(key);
			}
			fis.close();
		} catch (FileNotFoundException e) {
			logger.error("找不到指定的文件，错误原因： "+e);
		} catch (IOException e) {
			logger.error("当加载指定的文件时出错，错误原因： "+e);
		}
		
	}
	public String getDriver() {
		return driver;
	}
	public String getPassword() {
		return password;
	}
	public String getUsername() {
		return username;
	}	
	public String gerUrl(){
		return url;
	}
	

}
