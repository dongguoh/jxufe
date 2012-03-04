package com.gjx.jxufe.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gjx.jxufe.vo.Information;

public interface InformationDao {
	//插入发布消息
	public void insertInformation(Information information);
	//更新消息
	public void updateInformation(Information information);
	//删除一条记录
	public void deleteInformation(int id);
	//根据信息的ID取得一条信息
	public Information getInformation(int id);
	//取得所有信息
	public List getInformationList();
	//按分页的要求取得 一定数量的信息列表
	public List getInformationList(HttpServletRequest request,int pageNum,int length,int classify);

}
