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
	// ȡ�����ݿ������
	public static DBConnection getDBConnection() {
		return new DBConnection();
	}

	// ȡ��һ���û���ʵ��
	public static AccountDao getAccountDaoImpl() {
		return new AccountDaoImpl();
	}

	// ȡ��һ����Ϣ��ʵ��
	public static InformationDao getInfromationDaoImple() {
		return new InformationDaoImpl();
	}

	// ȡ��һ���������͵�ʵ��
	public static LinkTypeDao getLinkTypeDaoImpl() {
		return new LinkTypeDaoImpl();
	}

	// ȡ��һ�����ӵ�ʵ��
	public static LinkDao getLinkDaoImpl() {
		return new LinkDaoImpl();
	}

	// ȡ��һ����Ϣ���͵�ʵ��
	public static InformationTypeDao getInformationTypeDaoImpl() {
		return new InformationTypeDaoImpl();
	}

	// ȡ��һ����Ʒ�γ̵�ʵ��
	public static JpkcDao getJpkcDaoImpl() {
		return new JpkcDaoImpl();
	}

}
