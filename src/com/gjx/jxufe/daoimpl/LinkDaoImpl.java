package com.gjx.jxufe.daoimpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gjx.jxufe.dao.LinkDao;
import com.gjx.jxufe.factory.Factory;
import com.gjx.jxufe.vo.Link;

public class LinkDaoImpl extends BaseDaoImpl implements LinkDao {
	private static final Log logger = LogFactory.getLog(LinkDaoImpl.class);

	// ����һ�����ӵ����
	public void insertLink(Link link) {
		String sql = "INSERT INTO link(id,typeid,name,url,image) values(null,?,?,?,?)";
		try {
			this.conn = Factory.getDBConnection().getConnection();
			pstmt= this.conn.prepareStatement(sql);
			logger.debug("��ִ��CallableStatement��executeUpdate()֮ǰ");
			pstmt.setInt(1, link.getTypeid());
			pstmt.setString(2, link.getName());
			pstmt.setString(3, link.getUrl());
			pstmt.setString(4, link.getImage());
			pstmt.executeUpdate();
			logger.debug("��ִ��CallableStatement��executeUpdate֮��");
			this.close();			

		} catch (SQLException e) {
			logger.error(e);
		}
	}

	// �������ӵ���������
	public void updateLink(Link link) {
		String sql = "UPDATE link SET typeid=?,name=?,url=?,image=? WHERE id=?";
		try {
			this.conn = Factory.getDBConnection().getConnection();
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setInt(5, link.getId());
			pstmt.setInt(1, link.getTypeid());
			pstmt.setString(2, link.getName());
			pstmt.setString(3, link.getUrl());
			pstmt.setString(4, link.getImage());
			pstmt.executeUpdate();

			this.conn.close();
		} catch (SQLException e) {
			logger.error(e);
		} 
	}

	// ���һ���Ѵ��ڵ�����
	public void deleteLink(int id) {

		String sql = "DELETE FROM link WHERE id=" + id;
		try {
			this.conn = Factory.getDBConnection().getConnection();
			this.stmt = this.conn.createStatement();
			this.stmt.execute(sql);

			this.close();
		} catch (SQLException e) {
			logger.error(e);
		}
	}

	// ȡ�����е���������
	public List getLinkList() {

		List<Link> list = new ArrayList<Link>();
		Link link = null;
		String sql = " SELECT id,typeid,name,url,image FROM link WHERE 1=1 order by typeid";
		try {
			this.conn = Factory.getDBConnection().getConnection();
			this.stmt = this.conn.createStatement();
			this.rs = this.stmt.executeQuery(sql);
			while (rs.next()) {
				link = new Link(rs.getInt("id"), rs.getInt("typeid"), 
						rs.getString("name"), rs.getString("url"), rs
						.getString("image"));
				list.add(link);
			}

			this.close();
		} catch (SQLException e) {
			logger.error(e);
		}

		return list;
	}

	// ����IDȡ��һ����������
	public Link getLink(int id) {
		Link link = null;
		String sql = " SELECT id,typeid,name,url,image FROM link WHERE id="+id;
		try {
			this.conn = Factory.getDBConnection().getConnection();
			this.stmt = this.conn.createStatement();
			this.rs = this.stmt.executeQuery(sql);
			if (rs.next()) {
				link = new Link(rs.getInt("id"), rs.getInt("typeid"), 
						rs.getString("name"), rs.getString("url"), rs
						.getString("image"));
				
			}

			this.close();
		} catch (SQLException e) {
			logger.error(e);
		}

		return link;
	}
}
