package com.gjx.jxufe.dao;

import java.util.List;

import com.gjx.jxufe.vo.LinkType;

public interface LinkTypeDao {
	//新增一个链接的类别
	public void insertLinkType(LinkType linkType);
	//更新链接的类别的名称
	public void updateLinkType(LinkType linkType);
	//册除一个已存在的链接
	public void deleteLinkType(int id);
	//取得所有的链接类型
	public List getLinkTypeList();
	//根据ID取得一个链接类型
	public LinkType getLinkType(int id);

}
