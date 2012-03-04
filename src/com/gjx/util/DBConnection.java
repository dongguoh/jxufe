package com.gjx.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;

public class DBConnection {
	private static final Log logger=LogFactory.getLog(DBConnection.class);
	private Connection conn=null;
	private ReadProperty rp=null;

	public DBConnection() {
		
		rp=new ReadProperty(Constants.DATABASE_PROPERTIES_PATH);
		
		try {
			Class.forName(rp.getDriver());
			conn=DriverManager.getConnection(rp.gerUrl(),rp.getUsername(),rp.getPassword());
		} catch (ClassNotFoundException e) {
			logger.error("找不到连接数据为驱动的类，错误原因: "+e);
		} catch (SQLException e) {
			logger.error("连接数据库的URL地址有误，错误原因： "+e);
		}
	}
	public Connection getConnection(){
		return this.conn;
	}
	public void colse(){
		if(conn!=null){
			try {
				conn.close();
				conn=null;
			} catch (SQLException e) {
				logger.error("当关闭数据库连接时出错，错误原因： "+e);
			}
		}
	}
	

}
