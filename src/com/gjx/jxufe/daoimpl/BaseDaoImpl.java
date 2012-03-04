package com.gjx.jxufe.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class BaseDaoImpl {
	protected PreparedStatement pstmt = null;

	protected Statement stmt = null;

	protected ResultSet rs = null;


	protected Connection conn = null;
	//关闭数据库连接
	protected  void close() {
		if (rs != null) {
			try {
				rs.close();
				rs = null;
			} catch (SQLException e) {
				System.err.println("关闭数据结果结ResultSet时出错,错误原因：" + e);
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
				pstmt = null;
			} catch (SQLException e) {
				System.err.println("关闭预编译的 SQL 语句的对象PreparedStatement"
						+ "时出错,错误原因：" + e);
				e.printStackTrace();
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				System.err.println("关闭静态的Statement 语句 时出错,错误原因：" + e);
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				System.err.println("关闭数据库连接" + "时出错,错误原因：" + e);
				e.printStackTrace();
			}
		}

	}

}
