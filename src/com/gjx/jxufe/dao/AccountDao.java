package com.gjx.jxufe.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gjx.jxufe.vo.Account;

public interface AccountDao {
	// 增加一个用户
	public void insertAccount(Account account);

	// 更新用户信息
	public void updateAccount(Account account);

	// 根据用户ID取得一个用户信息
	public Account getAccount(String userId);

	// 根据用户ID和password取得一个用户，用于验证
	public Account getAccount(String userId, String password);

	// 取得所有的用户
	public List getAccountList();
	//根据每页所需要要显示帐户的数量
	public List getAccountList(HttpServletRequest request,int pageNum,int length);

	// 根据用户ID删除一个用户
	public void deleteAccount(String userId);

}
