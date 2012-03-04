package com.gjx.jxufe.daoimpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gjx.jxufe.dao.InformationTypeDao;
import com.gjx.jxufe.factory.Factory;
import com.gjx.jxufe.vo.InformationType;

public class InformationTypeDaoImpl extends BaseDaoImpl implements
		InformationTypeDao {
	private static final Log logger=LogFactory.getLog(InformationTypeDaoImpl.class);
	// 册除一个已存在的信息
	public void deleteInformationType(int id) {
		// TODO Auto-generated method stub
		String sqlFirst=" DELETE FROM information WHERE classify="+id;
		String sqlSecond=" DELETE FROM informationType WHERE  id="+id;
		try {	
			
			this.conn=Factory.getDBConnection().getConnection();
			this.stmt=conn.createStatement();
			stmt.addBatch(sqlFirst);
			stmt.addBatch(sqlSecond);
			stmt.executeBatch();
			this.close();
			
		} catch (SQLException e) {
			logger.error(e);
		}

	}

	// 根据ID取得一个信息类型
	public InformationType getInformationType(int id) {
		String sql="Select id,name FROM informationType WHERE id="+id;
		InformationType lt=null;
		try {			
			this.conn=Factory.getDBConnection().getConnection();
			this.stmt=conn.createStatement();
			this.rs=stmt.executeQuery(sql);
			if(rs.next()){
				lt=new InformationType();
				lt.setId(rs.getInt("id"));
				lt.setName(rs.getString("name"));
			}
			this.close();
		} catch (SQLException e) {
			logger.error(e);
			
		}
		return lt;
	}

	// 取得所有的信息类型
	public List getInformationTypeList() {
		String sql="Select id,name FROM informationType WHERE 1=1";
		InformationType lt=null;
		List<InformationType> list=new ArrayList<InformationType>();
		try {			
			this.conn=Factory.getDBConnection().getConnection();
			this.stmt=conn.createStatement();
			this.rs=stmt.executeQuery(sql);
			while(rs.next()){
				lt=new InformationType();
				lt.setId(rs.getInt("id"));
				lt.setName(rs.getString("name"));
				list.add(lt);
			}
			this.close();
		} catch (SQLException e) {
			logger.error(e);
			
		}
		return list;
	}

	// 新增一个信息的类别
	public void insertInformationType(InformationType informationType) {
		// TODO Auto-generated method stub
		String sql= "INSERT INTO  informationType(id,name) VALUES(NULL,'"+informationType.getName()+"')";
		try {
			this.conn=Factory.getDBConnection().getConnection();
			
			this.conn.setAutoCommit(false);
			this.stmt=this.conn.createStatement();
			this.stmt.executeUpdate(sql);
						
			this.conn.commit();
			this.conn.setAutoCommit(true);			
			this.close();
		} catch (SQLException e) {
			logger.error(e);
			
		}
		

	}

	// 更新信息的类别的名称
	public void updateInformationType(InformationType informationType) {
		// TODO Auto-generated method stub
		String sql= "UPDATE informationType SET name='"+informationType.getName()+"' WHERE id="+informationType.getId();
		try {
			this.conn=Factory.getDBConnection().getConnection();
			
			this.conn.setAutoCommit(false);
			this.stmt=this.conn.createStatement();
			this.stmt.executeUpdate(sql);
						
			this.conn.commit();
			this.conn.setAutoCommit(true);			
			this.close();
		} catch (SQLException e) {
			logger.error("***在插入信息时出错，"+this.getClass()+">"+"insertInformationType()中"+e);
		}
		

	}

}
