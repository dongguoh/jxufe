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
			logger.error("�Ҳ�����������Ϊ�������࣬����ԭ��: "+e);
		} catch (SQLException e) {
			logger.error("�������ݿ��URL��ַ���󣬴���ԭ�� "+e);
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
				logger.error("���ر����ݿ�����ʱ��������ԭ�� "+e);
			}
		}
	}
	

}
