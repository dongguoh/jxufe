package com.gjx.jxufe.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gjx.jxufe.vo.Information;

public interface InformationDao {
	//���뷢����Ϣ
	public void insertInformation(Information information);
	//������Ϣ
	public void updateInformation(Information information);
	//ɾ��һ����¼
	public void deleteInformation(int id);
	//������Ϣ��IDȡ��һ����Ϣ
	public Information getInformation(int id);
	//ȡ��������Ϣ
	public List getInformationList();
	//����ҳ��Ҫ��ȡ�� һ����������Ϣ�б�
	public List getInformationList(HttpServletRequest request,int pageNum,int length,int classify);

}
