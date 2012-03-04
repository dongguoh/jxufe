package com.gjx.jxufe.daoimpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gjx.jxufe.dao.InformationDao;
import com.gjx.jxufe.factory.Factory;
import com.gjx.jxufe.vo.Information;
import com.gjx.util.Pager;

public class InformationDaoImpl extends BaseDaoImpl implements InformationDao {
	private static final Log logger=LogFactory.getLog(InformationDaoImpl.class);
	//ɾ��һ����¼������ID
	public void deleteInformation(int id) {
		// TODO Auto-generated method stub
		String sql=" DELETE FROM information WHERE id="+id;
		try {			
			this.conn=Factory.getDBConnection().getConnection();
			this.stmt=conn.createStatement();
			stmt.executeUpdate(sql);
			this.close();
		} catch (SQLException e) {
			logger.error("****��ɾ��һ���û���Ϣʱ����:"+this.getClass()+">"+"deleteInformation(int id)"+e);
		}

	}
	//������Ϣ��IDȡ��һ����Ϣ
	public Information getInformation(int id) {
		String sql="Select id,title,content,date,file,issue,classify FROM information WHERE id="+id;
		Information ifm=null;
		try {			
			this.conn=Factory.getDBConnection().getConnection();
			this.stmt=conn.createStatement();
			this.rs=stmt.executeQuery(sql);
			if(rs.next()){
				ifm=new Information();
				ifm.setId(id);
				ifm.setTitle(rs.getString("title"));
				ifm.setContent(rs.getString("content"));
				ifm.setDate(rs.getDate("date"));
				ifm.setFile(rs.getString("file"));
				ifm.setIssue(rs.getString("issue"));
				ifm.setClassify(rs.getInt("classify"));
			}
			this.close();
		} catch (SQLException e) {
			logger.error("****��ȡ��һ���û���Ϣʱ����:"+this.getClass()+">"+"getInformation(int id):\n"+e);
			e.printStackTrace();
		}
		return ifm;
	}
	//ȡ��������Ϣ
	public List getInformationList() {
		String sql="Select id,title,content,date,file,issue,classify FROM information WHERE 1=1";
		Information ifm=null;
		List<Information> list=new ArrayList<Information>();
		try {			
			this.conn=Factory.getDBConnection().getConnection();
			this.stmt=conn.createStatement();
			this.rs=stmt.executeQuery(sql);
			while(rs.next()){
				ifm=new Information();
				ifm.setId(rs.getInt("id"));
				ifm.setTitle(rs.getString("title"));
				ifm.setContent(rs.getString("content"));
				ifm.setDate(rs.getDate("date"));
				ifm.setFile(rs.getString("file"));
				ifm.setIssue(rs.getString("issue"));
				ifm.setClassify(rs.getInt("classify"));
				list.add(ifm);
			}
			this.close();
		} catch (SQLException e) {
			logger.error("****��ȡ��һ���û���Ϣʱ����:"+this.getClass()+">"+"getInformation(int id):\n"+e);
		}
		return list;
	}
	//����ҳ��Ҫ��ȡ�� һ����������Ϣ�б� classify����Ϣ����
	public List getInformationList(HttpServletRequest request, int pageNum,int length,int classify) {
		List<Information> list = new ArrayList<Information>();
		Information inf=null;
		String sql = " SELECT * FROM information WHERE classify="+classify;
		try {
			conn = Factory.getDBConnection().getConnection();
			stmt = conn.createStatement();			
			rs = stmt.executeQuery(sql);
			Pager pager=new Pager(rs,pageNum,length);
			request.setAttribute("size",pager.getSize());
			sql = " SELECT * FROM information WHERE classify="+classify+" order by date desc limit "+pager.getOffset()+","+length;
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				inf = new Information();
				inf.setId(rs.getInt("id"));
				inf.setTitle(rs.getString("title"));
				inf.setContent(rs.getString("content"));
				inf.setDate(rs.getDate("date"));
				inf.setClassify(rs.getInt("classify"));
				inf.setFile(rs.getString("file"));
				inf.setIssue(rs.getString("issue"));
				list.add(inf);
			}
			this.close();
		} catch (SQLException e) {
			logger.error("��ִ�о�̬��Statement ��� ʱ����,����ԭ��"+this.getClass() + 
					           ">>getInformationList(HttpServletRequest request, int pageNum,int length,int classify):\n"+e);
		}

		return list;
	}
	//���뷢����Ϣ
	public void insertInformation(Information information) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO information(id,title,content,date,file,issue,classify)" +
				                           " VALUES(null,?,?,now(),?,?,?)";		
		try {
			this.conn=Factory.getDBConnection().getConnection();
			
			this.conn.setAutoCommit(false);
			this.pstmt=this.conn.prepareStatement(sql);
			pstmt.setString(1,information.getTitle());
			pstmt.setString(2,information.getContent());
			pstmt.setString(3,information.getFile());
			pstmt.setString(4,information.getIssue());
			pstmt.setInt(5,information.getClassify());
			pstmt.executeUpdate();
			this.conn.commit();
			this.conn.setAutoCommit(true);			
			this.close();
		} catch (SQLException e) {
			logger.error("***�ڲ�����Ϣʱ����"+this.getClass()+">"+"insertInformation()��:\n"+e);
		}
		

	}
	//������Ϣ
	public void updateInformation(Information information) {
		// TODO Auto-generated method stub
		String sql="UPDATE information SET title=?,content=?,date=now()," +
				    "file=?,issue=?,classify=? WHERE id=?";		
		try {
			this.conn=Factory.getDBConnection().getConnection();
			
			this.conn.setAutoCommit(false);
			this.pstmt=this.conn.prepareStatement(sql);
			pstmt.setString(1,information.getTitle());
			pstmt.setString(2,information.getContent());
			pstmt.setString(3,information.getFile());
			pstmt.setString(4,information.getIssue());
			pstmt.setInt(5,information.getClassify());
			pstmt.setInt(6,information.getId());
			pstmt.executeUpdate();
			this.conn.commit();
			this.conn.setAutoCommit(true);			
			this.close();
		} catch (SQLException e) {
			logger.error("***�ڸ�����Ϣʱ����"+this.getClass()+">"+"updateInformation()��:\n"+e);
		}
		

	}

}
