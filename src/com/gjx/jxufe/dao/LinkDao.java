package com.gjx.jxufe.dao;

import java.util.List;

import com.gjx.jxufe.vo.Link;

public interface LinkDao {
	// 新增一个链接的类别
	public void insertLink(Link link);

	// 更新链接的类别的名称
	public void updateLink(Link link);

	// 册除一个已存在的链接
	public void deleteLink(int id);

	// 取得所有的链接类型
	public List getLinkList();

	// 根据ID取得一个链接类型
	public Link getLink(int id);
}
