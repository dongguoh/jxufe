package com.gjx.jxufe.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gjx.jxufe.vo.Jpkc;

public interface JpkcDao {
	// ����
	public void insertJpkc(Jpkc jpkc);

	// ����
	public void updateJpkc(Jpkc jpkc);

	// �����û�IDȡ��
	public Jpkc getJpkc(int id);

	// ȡ������
	public List getJpkcList();
	
	//���ݼ���ȡ���б�
	public List getJpkcList(int level);

	// ����ÿҳ����ҪҪ��ʾ�ʻ�������
	public List getJpkcList(HttpServletRequest request, int pageNum, int length);

	// ����IDɾ��
	public void deleteJpkc(int id);

}
