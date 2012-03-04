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
	//�ر����ݿ�����
	protected  void close() {
		if (rs != null) {
			try {
				rs.close();
				rs = null;
			} catch (SQLException e) {
				System.err.println("�ر����ݽ����ResultSetʱ����,����ԭ��" + e);
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
				pstmt = null;
			} catch (SQLException e) {
				System.err.println("�ر�Ԥ����� SQL ���Ķ���PreparedStatement"
						+ "ʱ����,����ԭ��" + e);
				e.printStackTrace();
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				System.err.println("�رվ�̬��Statement ��� ʱ����,����ԭ��" + e);
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				System.err.println("�ر����ݿ�����" + "ʱ����,����ԭ��" + e);
				e.printStackTrace();
			}
		}

	}

}
