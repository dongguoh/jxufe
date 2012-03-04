package com.gjx.jxufe.dao;

import java.util.List;

import com.gjx.jxufe.vo.InformationType;

public interface InformationTypeDao {
//	����һ����Ϣ�����
	public void insertInformationType(InformationType informationType);
	//������Ϣ����������
	public void updateInformationType(InformationType informationType);
	//���һ���Ѵ��ڵ���Ϣ
	public void deleteInformationType(int id);
	//ȡ�����е���Ϣ����
	public List getInformationTypeList();
	//����IDȡ��һ����Ϣ����
	public InformationType getInformationType(int id);

}
