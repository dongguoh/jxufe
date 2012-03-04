<%@ page language="java" pageEncoding="GB2312"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
<head>
	<html:base />

	<title>test.jsp</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<style type="text/css">
<!--
body {
	background-color: #336633;
}
-->
</style>
</head>

<body>
<logic:notPresent scope="session" name="admin">
	<center>
		<br>
		<h1>
			管理员登录
		</h1>
		<br>
		<hr>
		<html:form action="/admin/login.xsp">
			<table width="272" border="0" height="149">
				<tr>
					<td colspan="2">
						<html:errors />
					</td>
				</tr>
				<tr bgcolor="#9999FF">
					<td align="right">
						用户名：
					</td>
					<td align="left">
						<html:text property="userId" size="25" value="dongguoh"/>
					</td>
				</tr>
				<tr bgcolor="#9999FF">
					<td align="right">
						密&nbsp;码：
					</td>
					<td align="left">
						<html:text property="password" size="25"  value="8231810"/>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center" bgcolor="#9999FF">
						<html:submit>登录</html:submit>
					</td>
				</tr>
			</table>

		</html:form>

	</center>
	</logic:notPresent>
	<logic:present scope="session" name="admin">
	 <h1>欢迎管理员${admin.username }   登录</h1>
	</logic:present>
	
</body>
</html:html>
