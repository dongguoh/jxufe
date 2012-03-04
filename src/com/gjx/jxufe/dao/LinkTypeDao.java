package com.gjx.jxufe.dao;

import java.util.List;

import com.gjx.jxufe.vo.LinkType;

public interface LinkTypeDao {
	//����һ�����ӵ����
	public void insertLinkType(LinkType linkType);
	//�������ӵ���������
	public void updateLinkType(LinkType linkType);
	//���һ���Ѵ��ڵ�����
	public void deleteLinkType(int id);
	//ȡ�����е���������
	public List getLinkTypeList();
	//����IDȡ��һ����������
	public LinkType getLinkType(int id);

}
