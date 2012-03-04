package com.gjx.jxufe.factory;

import com.gjx.jxufe.dao.AccountDao;
import com.gjx.jxufe.dao.InformationDao;
import com.gjx.jxufe.dao.InformationTypeDao;
import com.gjx.jxufe.dao.JpkcDao;
import com.gjx.jxufe.dao.LinkDao;
import com.gjx.jxufe.dao.LinkTypeDao;
import com.gjx.jxufe.daoimpl.AccountDaoImpl;
import com.gjx.jxufe.daoimpl.InformationDaoImpl;
import com.gjx.jxufe.daoimpl.InformationTypeDaoImpl;
import com.gjx.jxufe.daoimpl.JpkcDaoImpl;
import com.gjx.jxufe.daoimpl.LinkDaoImpl;
import com.gjx.jxufe.daoimpl.LinkTypeDaoImpl;
import com.gjx.util.DBConnection;

public class Factory {
	// 取得数据库的连接
	public static DBConnection getDBConnection() {
		return new DBConnection();
	}

	// 取得一个用户的实例
	public static AccountDao getAccountDaoImpl() {
		return new AccountDaoImpl();
	}

	// 取得一条信息的实例
	public static InformationDao getInfromationDaoImple() {
		return new InformationDaoImpl();
	}

	// 取得一个链接类型的实例
	public static LinkTypeDao getLinkTypeDaoImpl() {
		return new LinkTypeDaoImpl();
	}

	// 取得一个链接的实例
	public static LinkDao getLinkDaoImpl() {
		return new LinkDaoImpl();
	}

	// 取得一个信息类型的实例
	public static InformationTypeDao getInformationTypeDaoImpl() {
		return new InformationTypeDaoImpl();
	}

	// 取得一个精品课程的实例
	public static JpkcDao getJpkcDaoImpl() {
		return new JpkcDaoImpl();
	}

}
