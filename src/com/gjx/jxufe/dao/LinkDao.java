package com.gjx.jxufe.dao;

import java.util.List;

import com.gjx.jxufe.vo.Link;

public interface LinkDao {
	// ����һ�����ӵ����
	public void insertLink(Link link);

	// �������ӵ���������
	public void updateLink(Link link);

	// ���һ���Ѵ��ڵ�����
	public void deleteLink(int id);

	// ȡ�����е���������
	public List getLinkList();

	// ����IDȡ��һ����������
	public Link getLink(int id);
}
