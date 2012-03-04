package com.gjx.jxufe.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gjx.jxufe.vo.Account;

public interface AccountDao {
	// ����һ���û�
	public void insertAccount(Account account);

	// �����û���Ϣ
	public void updateAccount(Account account);

	// �����û�IDȡ��һ���û���Ϣ
	public Account getAccount(String userId);

	// �����û�ID��passwordȡ��һ���û���������֤
	public Account getAccount(String userId, String password);

	// ȡ�����е��û�
	public List getAccountList();
	//����ÿҳ����ҪҪ��ʾ�ʻ�������
	public List getAccountList(HttpServletRequest request,int pageNum,int length);

	// �����û�IDɾ��һ���û�
	public void deleteAccount(String userId);

}
