package com.gjx.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Pager {
	private static final Log logger=LogFactory.getLog(Pager.class);
	//总的行数
	private int count;
	//每页显示的数量	
	private int length;
	//偏移量
	private int offset;
	//总共有多少页
	private int  size;
	//所传进来的页码数为
	private int pageNum;
	ResultSet rs=null;
	
	
	public Pager(ResultSet rs,int pageNum,int length){
		this.rs=rs;
		this.length=length;
		this.pageNum=pageNum;
	}
	public int getRows(){
		try {
			rs.last();
			count =rs.getRow();
			rs.first();
		} catch (SQLException e) {
			logger.error("取得数据结果集行数时出错"+e);
		}
		return count;		
	}
	public int getSize(){

		size=(this.getRows()%this.length)==0?this.getRows()/this.length:this.getRows()/this.length+1;
		return size;
	}
	public int getOffset(){	
		this.getRows();
		this.getSize();		
		offset=(this.pageNum-1)*length>=0?(this.pageNum-1)*length:0;

		return offset;
	}

}
