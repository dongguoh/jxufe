<%@ page language="java" pageEncoding="GB2312"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
<head>
	<html:base />

	<title>更新用户</title>

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
	<logic:present scope="session" name="admin">
		<center>
			<br>
			<h1>
				更新管理员信息
			</h1>
			<br>
			<hr>
			<html:form action="/admin/account/updateAccount.xsp">
				<table width="285" border="0" height="255">
					<input type="hidden" value="update" name="method" />
					
					<tr>
						<td colspan="2">
							<html:errors />
						</td>
					</tr>
					<tr bgcolor="#9999FF">
						<td align="right">
							用户ID：
						</td>
						<td align="left">
							<html:hidden property="userId" value="${account.userId}" write="true"/>
						</td>
					</tr>
					<tr bgcolor="#9999FF">
						<td align="right">
							密&nbsp;码：
						</td>
						<td align="left">
							<html:text property="password" size="25" value="${account.password}" />
						</td>
					</tr>
					<tr bgcolor="#9999FF">
						<td align="right">
							确认密码：
						</td>
						<td align="left">
							<html:text property="repeatedPassword" size="25" value="${account.password}" />
						</td>
					</tr>
					<tr bgcolor="#9999FF">
						<td align="right">
							姓&nbsp;名：
						</td>
						<td align="left">
							<html:text property="username" size="25" value="${account.username }" />
						</td>
					</tr>
					<tr bgcolor="#9999FF">
						<td align="right">
							Email：
						</td>
						<td align="left">
							<html:text property="email" size="25" value="${account.email}"/>
						</td>
					</tr>
					<tr bgcolor="#9999FF">
						<td align="right">
							用户等级：
						</td>
						<td align="left">
							<html:select property="level" value="${account.level}">
								<html:option value="1">超级管理员</html:option>
								<html:option value="2">普通管理员</html:option>
							</html:select>							
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center" bgcolor="#9999FF">
							<html:submit>提交</html:submit>
							&nbsp;
							<html:cancel>退出</html:cancel>
						</td>
					</tr>
				</table>

			</html:form>

		</center>
	</logic:present>
	

</body>
</html:html>
