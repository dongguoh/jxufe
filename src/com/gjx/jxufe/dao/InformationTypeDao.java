package com.gjx.jxufe.dao;

import java.util.List;

import com.gjx.jxufe.vo.InformationType;

public interface InformationTypeDao {
//	新增一个信息的类别
	public void insertInformationType(InformationType informationType);
	//更新信息的类别的名称
	public void updateInformationType(InformationType informationType);
	//册除一个已存在的信息
	public void deleteInformationType(int id);
	//取得所有的信息类型
	public List getInformationTypeList();
	//根据ID取得一个信息类型
	public InformationType getInformationType(int id);

}
