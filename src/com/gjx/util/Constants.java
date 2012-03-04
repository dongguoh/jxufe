package com.gjx.util;

public class Constants {
	// 数据库登录文件所在的位置
	public static final String DATABASE_PROPERTIES_PATH = "/properties/database.properties";

	public static final String SUCCESS_KEY = "success";

	public static final String FAILURE_KEY = "failure";

	// ADMIN_KEY有两个作用，一个是用于查找后台管理的径，一个是用于保存管理页的Session
	public static final String ADMIN_KEY = "admin";

	// 用于返回主页面
	public static final String INDEX_KEY = "index";

	// 保存用户列表
	public static final String ACCOUNT_LIST = "accountList";

	// 保存一些相关的提示消息
	public static final String MESSAGE_KEY = "message";

	// 保存其它用户登录的信息
	public static final String ACCOUNT_KEY = "account";

	// 保存一条政策公告记录
	public static final String ANNONCE = "annonce";

	// 保存一条政策公告记录
	public static final String NEWS = "news";

	// 保存信息列表
	public static final String INFORMATION_LIST = "informationList";

	// 取得一条信息
	public static final String INFORMATION_KEY = "information";

	// 保存上传文件的路径
	public static final String UPLOAD_PATH = "path";

	// 分类类型列表
	public static final String LINK_TYPE_LIST = "linkTypeList";

	// 链接列表
	public static final String LINK_LIST = "linkList";

	// 链接列表
	public static final String JPKC_LIST = "jpkcList";

	// 信息类型列表
	public static final String INFORMATION_TYPE_LIST = "informationTypeList";

	// 保存一个信息的类别
	public static final String INFORMATION_TYPE = "informationType";

	// 显示更多信息列表页的最大条数
	public static final int MORE_INORMATION_PAGE_LENGTH = 20;

	// 帐户的每页的数量条数
	public static final int ACCOUNT_PAGE_LENGTH = 10;

	// 在后台管理时信息显示的每页显示的列数
	public static final int INFORMATION_PAGE_LENGTH =10;

	// 在主页面信息显示的每页显示的列数
	public static final int INDEX_INFORMATION_LIST_LENGTH = 8;
}
