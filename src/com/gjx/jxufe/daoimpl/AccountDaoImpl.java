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

	// 根据用户ID删除一个用户
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
			System.err.println("当执行预编译的 SQL 语句的对象PreparedStatement删除一个用户时"
					+ "时出错,错误原因：" + e);
			e.printStackTrace();
		}
	
	}

	// 根据用户ID取得一个用户信息
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
			System.err.println("当从数据库中取出一个用户时出错，错误原因：" + e);
		}
		return account;
	}

	// 根据用户ID和password取得一个用户，用于验证
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
			System.err.println("当从数据库中取出一个用户时出错，错误原因：" + e);
		}
		return account;
	}

	// 取得所有的用户
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
			System.err.println("当执行静态的Statement 语句 时出错,错误原因：" + e);
			e.printStackTrace();
		}

		return list;
	}

	// 增加一个用户
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
				System.err.println("当执行预编译的 SQL 语句的对象PreparedStatement"
						+ "时出错,错误原因：" + e);
				e.printStackTrace();
			}
		} else {
			System.out.println("用户ID为 insertAccount(Account account):" + account.getUserId() + " 已存在 ");
		}

	}

	// 更新用户信息
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
			System.err.println("当执行预编译的 SQL 语句的对象PreparedStatement"
					+ "时出错,错误原因：" + e);
			e.printStackTrace();
		}
	}

//取得每页显示的数量条数
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
			System.err.println("当执行静态的Statement 语句 时出错,错误原因：" + e);
			e.printStackTrace();
		}

		return list;
	}

}
