package com.gjx.jxufe.daoimpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gjx.jxufe.dao.LinkTypeDao;
import com.gjx.jxufe.factory.Factory;
import com.gjx.jxufe.vo.LinkType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
public class LinkTypeDaoImpl extends BaseDaoImpl implements LinkTypeDao {
	private static final Log logger=LogFactory.getLog(LinkTypeDaoImpl.class);
	// 新增一个链接的类别
	
	public void insertLinkType(LinkType linkType) {
		// TODO Auto-generated method stub
		String sql= "INSERT INTO  linktype(id,name) VALUES(NULL,'"+linkType.getName()+"')";
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

	// 更新链接的类别的名称
	public void updateLinkType(LinkType linkType) {
		// TODO Auto-generated method stub
		String sql= "UPDATE linktype SET name='"+linkType.getName()+"' WHERE id="+linkType.getId();
		try {
			this.conn=Factory.getDBConnection().getConnection();
			
			this.conn.setAutoCommit(false);
			this.stmt=this.conn.createStatement();
			this.stmt.executeUpdate(sql);
						
			this.conn.commit();
			this.conn.setAutoCommit(true);			
			this.close();
		} catch (SQLException e) {
			logger.error("***在插入信息时出错，"+this.getClass()+">"+"insertInformation()中"+e);
		}
		

	}

	// 册除一个已存在的链接
	public void deleteLinkType(int id) {
		// TODO Auto-generated method stub
		String sqlFirst=" DELETE FROM link WHERE typeid="+id;
		String sqlSecond=" DELETE FROM linkType WHERE  id="+id;
		try {	
			if(id!=1 && id!=2 && id!=3 ){
			this.conn=Factory.getDBConnection().getConnection();
			this.stmt=conn.createStatement();
			stmt.addBatch(sqlFirst);
			stmt.addBatch(sqlSecond);
			stmt.executeBatch();
			this.close();
			}
		} catch (SQLException e) {
			logger.error(e);
		}

	}

	// 取得所有的链接类型
	public List getLinkTypeList() {
		String sql="Select id,name FROM linktype WHERE 1=1";
		LinkType lt=null;
		List<LinkType> list=new ArrayList<LinkType>();
		try {			
			this.conn=Factory.getDBConnection().getConnection();
			this.stmt=conn.createStatement();
			this.rs=stmt.executeQuery(sql);
			while(rs.next()){
				lt=new LinkType();
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

	// 根据ID取得一个链接类型
	public LinkType getLinkType(int id) {
		String sql="Select id,name FROM linktype WHERE id="+id;
		LinkType lt=null;
		try {			
			this.conn=Factory.getDBConnection().getConnection();
			this.stmt=conn.createStatement();
			this.rs=stmt.executeQuery(sql);
			if(rs.next()){
				lt=new LinkType();
				lt.setId(rs.getInt("id"));
				lt.setName(rs.getString("name"));
			}
			this.close();
		} catch (SQLException e) {
			logger.error(e);
			
		}
		return lt;
	}
}
