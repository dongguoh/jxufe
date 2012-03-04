package com.gjx.jxufe.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gjx.jxufe.vo.Jpkc;

public interface JpkcDao {
	// 增加
	public void insertJpkc(Jpkc jpkc);

	// 更新
	public void updateJpkc(Jpkc jpkc);

	// 根据用户ID取得
	public Jpkc getJpkc(int id);

	// 取得所有
	public List getJpkcList();
	
	//根据级别取得列表
	public List getJpkcList(int level);

	// 根据每页所需要要显示帐户的数量
	public List getJpkcList(HttpServletRequest request, int pageNum, int length);

	// 根据ID删除
	public void deleteJpkc(int id);

}
