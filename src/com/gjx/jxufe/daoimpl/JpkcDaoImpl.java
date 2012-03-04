package com.gjx.jxufe.daoimpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gjx.jxufe.dao.JpkcDao;
import com.gjx.jxufe.factory.Factory;
import com.gjx.jxufe.vo.Jpkc;

public class JpkcDaoImpl extends BaseDaoImpl implements JpkcDao {

	private static final Log logger = LogFactory.getLog(JpkcDaoImpl.class);
	Jpkc jpkc =null;
	public void deleteJpkc(int id) {

		String sql = "delete from jpkc where id=?";
		try {
			conn = Factory.getDBConnection().getConnection();
			conn.setAutoCommit(false);

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();

			conn.commit();
			conn.setAutoCommit(true);
			close();

		} catch (SQLException e) {
			logger.error("当执行预编译的 SQL 语句的对象PreparedStatement删除一个用户时"
					+ "时出错,错误原因：" + e);
		}

	}

	public Jpkc getJpkc(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM jpkc WHERE id=?";
		try {
			// conn = dbc.getConnection();
			conn = Factory.getDBConnection().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				jpkc = new Jpkc();
				jpkc.setId(rs.getInt("id"));
				jpkc.setName(rs.getString("name"));
				jpkc.setTeacher(rs.getString("teacher"));
				jpkc.setLevel(rs.getInt("level"));
				jpkc.setYear(rs.getInt("year"));
				jpkc.setInfo(rs.getString("info"));
				jpkc.setFullname(rs.getString("fullname"));

			}
			this.close();
		} catch (SQLException e) {
			logger.error("当从数据库中取出一个用户时出错，错误原因：" + e);
		}
		return jpkc;
	}

	public List getJpkcList() {
		List<Jpkc> list = new ArrayList<Jpkc>();
		String sql = "select * from jpkc order by year desc ;";

		try {
			conn = Factory.getDBConnection().getConnection();
			stmt = conn.createStatement();			
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Jpkc jpkc = new Jpkc();
				
				jpkc.setId(rs.getInt("id"));
				jpkc.setName(rs.getString("name"));
				jpkc.setTeacher(rs.getString("teacher"));
				jpkc.setLevel(rs.getInt("level"));
				jpkc.setYear(rs.getInt("year"));
				jpkc.setInfo(rs.getString("info"));
				jpkc.setFullname(rs.getString("fullname"));
				
				list.add(jpkc);
			}
			this.close();
		} catch (SQLException e) {
			logger.error("当执行静态的Statement 语句 时出错,错误原因：" + e);
		}

		return list;
	}

	public List getJpkcList(HttpServletRequest request, int pageNum, int length) {
		// TODO Auto-generated method stub
		return null;
	}

	public void insertJpkc(Jpkc jpkc) {
			String sql = "INSERT INTO jpkc(id,name,teacher,fullname,level,year,info) VALUES(null,?,?,?,?,?,?)";
			try {
				conn = Factory.getDBConnection().getConnection();
				conn.setAutoCommit(false);

				pstmt = conn.prepareStatement(sql);				
				pstmt.setString(1, jpkc.getName());
				pstmt.setString(2, jpkc.getTeacher());
				pstmt.setString(3, jpkc.getFullname());
				pstmt.setInt(4, jpkc.getLevel());
				pstmt.setInt(5,jpkc.getYear());
				pstmt.setString(6,jpkc.getInfo());

				pstmt.executeUpdate();

				conn.commit();
				conn.setAutoCommit(true);
				this.close();

			} catch (SQLException e) {
				logger.error("当执行预编译的 SQL 语句的对象PreparedStatement"
						+ "时出错,错误原因：" + e);
			}
		

	}

	public void updateJpkc(Jpkc jpkc) {
		String sql = "UPDATE jpkc SET name=?,teacher=?,fullname=?,level=?,year=?,info=? WHERE id=?";
		try {
			// conn = dbc.getConnection();
			conn = Factory.getDBConnection().getConnection();
			conn.setAutoCommit(false);

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, jpkc.getName());
			pstmt.setString(2, jpkc.getTeacher());
			pstmt.setString(3, jpkc.getFullname());
			pstmt.setInt(4, jpkc.getLevel());
			pstmt.setInt(5,jpkc.getYear());
			pstmt.setString(6,jpkc.getInfo());
			
			pstmt.setInt(7,jpkc.getId());

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

	public List getJpkcList(int level) {
		List<Jpkc> list = new ArrayList<Jpkc>();
		String sql = "select * from  jpkc where level="+level+" order by year desc ;";

		try {
			conn = Factory.getDBConnection().getConnection();
			stmt = conn.createStatement();			
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Jpkc jpkc = new Jpkc();
				
				jpkc.setId(rs.getInt("id"));
				jpkc.setName(rs.getString("name"));
				jpkc.setTeacher(rs.getString("teacher"));
				jpkc.setLevel(rs.getInt("level"));
				jpkc.setYear(rs.getInt("year"));
				jpkc.setInfo(rs.getString("info"));
				jpkc.setFullname(rs.getString("fullname"));
				
				list.add(jpkc);
			}
			this.close();
		} catch (SQLException e) {
			logger.error("当执行静态的Statement 语句 时出错,错误原因：" + e);
		}

		return list;
	}

}
