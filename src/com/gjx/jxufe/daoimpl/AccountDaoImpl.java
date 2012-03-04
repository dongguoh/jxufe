package com.gjx.jxufe.daoimpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gjx.jxufe.dao.AccountDao;
import com.gjx.jxufe.factory.Factory;
import com.gjx.jxufe.vo.Account;
import com.gjx.util.Pager;

public class AccountDaoImpl extends BaseDaoImpl implements AccountDao {
	
	Account account = null;

	// �����û�IDɾ��һ���û�
	public void deleteAccount(String userId) {

		String sql = "delete from account where userId=?";
		try {
			// conn = dbc.getConnection();
			conn = Factory.getDBConnection().getConnection();
			conn.setAutoCommit(false);

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,userId);
			pstmt.executeUpdate();

			conn.commit();
			conn.setAutoCommit(true);
			close();

		} catch (SQLException e) {
			System.err.println("��ִ��Ԥ����� SQL ���Ķ���PreparedStatementɾ��һ���û�ʱ"
					+ "ʱ����,����ԭ��" + e);
			e.printStackTrace();
		}
	
	}

	// �����û�IDȡ��һ���û���Ϣ
	public Account getAccount(String userId) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM account WHERE userId=?";
		try {
			// conn = dbc.getConnection();
			conn = Factory.getDBConnection().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				account = new Account();
				account.setUserId(rs.getString("userId"));
				account.setUsername(rs.getString("username"));
				account.setPassword(rs.getString("password"));
				account.setLevel(rs.getInt("level"));
				account.setEmail(rs.getString("email"));
			}
			this.close();
		} catch (SQLException e) {
			System.err.println("�������ݿ���ȡ��һ���û�ʱ��������ԭ��" + e);
		}
		return account;
	}

	// �����û�ID��passwordȡ��һ���û���������֤
	public Account getAccount(String userId, String password) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM account WHERE userId=? AND password=?";
		try {
			// conn=conn = dbc.getConnection();
			conn = Factory.getDBConnection().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				account = new Account();
				account.setUserId(rs.getString("userId"));
				account.setUsername(rs.getString("username"));
				account.setPassword(rs.getString("password"));
				account.setLevel(rs.getInt("level"));
				account.setEmail(rs.getString("email"));
			}
			this.close();
		} catch (SQLException e) {
			System.err.println("�������ݿ���ȡ��һ���û�ʱ��������ԭ��" + e);
		}
		return account;
	}

	// ȡ�����е��û�
	public List getAccountList() {
		List<Account> list = new ArrayList<Account>();
		String sql = "select * from account";
		//HttpServletRequest request=null;

		try {
			// conn = dbc.getConnection();
			conn = Factory.getDBConnection().getConnection();
			stmt = conn.createStatement();			
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Account account = new Account();
				account.setUserId(rs.getString("userId"));
				account.setUsername(rs.getString("username"));
				account.setPassword(rs.getString("password"));
				account.setLevel(rs.getInt("level"));
				account.setEmail(rs.getString("email"));
				list.add(account);
			}
			this.close();
		} catch (SQLException e) {
			System.err.println("��ִ�о�̬��Statement ��� ʱ����,����ԭ��" + e);
			e.printStackTrace();
		}

		return list;
	}

	// ����һ���û�
	public void insertAccount(Account account) {
		if (this.getAccount(account.getUserId()) == null) {
			String sql = "INSERT INTO account (userId,username,password,email,level) VALUES (?,?,?,?,?)";
			try {
				// conn = dbc.getConnection();
				conn = Factory.getDBConnection().getConnection();
				conn.setAutoCommit(false);

				pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, account.getUserId());
				pstmt.setString(2, account.getUsername());
				pstmt.setString(3, account.getPassword());
				pstmt.setString(4, account.getEmail());
				pstmt.setInt(5, account.getLevel());

				pstmt.executeUpdate();

				conn.commit();
				conn.setAutoCommit(true);
				this.close();

			} catch (SQLException e) {
				System.err.println("��ִ��Ԥ����� SQL ���Ķ���PreparedStatement"
						+ "ʱ����,����ԭ��" + e);
				e.printStackTrace();
			}
		} else {
			System.out.println("�û�IDΪ insertAccount(Account account):" + account.getUserId() + " �Ѵ��� ");
		}

	}

	// �����û���Ϣ
	public void updateAccount(Account account) {
		String sql = "UPDATE  account SET password=?,username=?,level=?,email=? WHERE userId=?";
		try {
			// conn = dbc.getConnection();
			conn = Factory.getDBConnection().getConnection();
			conn.setAutoCommit(false);

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, account.getPassword());
			pstmt.setString(2, account.getUsername());
			pstmt.setInt(3, account.getLevel());
			pstmt.setString(4, account.getEmail());
			pstmt.setString(5,account.getUserId());

			pstmt.executeUpdate();

			conn.commit();
			conn.setAutoCommit(true);
			this.close();

		} catch (SQLException e) {
			System.err.println("��ִ��Ԥ����� SQL ���Ķ���PreparedStatement"
					+ "ʱ����,����ԭ��" + e);
			e.printStackTrace();
		}
	}

//ȡ��ÿҳ��ʾ����������
	public List getAccountList(HttpServletRequest request, int pageNum, int length) {
		List<Account> list = new ArrayList<Account>();
		String sql = "select * from account";
		//HttpServletRequest request=null;

		try {
			// conn = dbc.getConnection();
			conn = Factory.getDBConnection().getConnection();
			stmt = conn.createStatement();			
			rs = stmt.executeQuery(sql);
			Pager pager=new Pager(rs,pageNum,length);
			request.setAttribute("size",pager.getSize());
			sql = "select * from account limit "+pager.getOffset()+","+length;
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Account account = new Account();
				account.setUserId(rs.getString("userId"));
				account.setUsername(rs.getString("username"));
				account.setPassword(rs.getString("password"));
				account.setLevel(rs.getInt("level"));
				account.setEmail(rs.getString("email"));
				list.add(account);
			}
			this.close();
		} catch (SQLException e) {
			System.err.println("��ִ�о�̬��Statement ��� ʱ����,����ԭ��" + e);
			e.printStackTrace();
		}

		return list;
	}

}
