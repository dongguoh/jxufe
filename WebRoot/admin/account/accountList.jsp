<%@ page language="java" pageEncoding="GB2312"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
<head>
	<html:base />

	<title>��ʾ�����û�</title>

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
	<script language="JavaScript" type="text/JavaScript">
function delpay()
{
   if(confirm("ȷ��Ҫɾ�����û���"))
     return true;
   else
     return false;
}
</script>
</head>

<body>
	<center>
		<br>
		<h1>
			����Ա�б�
		</h1>
		<br>
		<hr>
		<logic:notPresent name="admin">����
		<html:link page="/admin/account/login.jsp" target="mainFrame">��¼</html:link>
		</logic:notPresent>
		<logic:present name="admin">
			<logic:equal name="admin" property="level" value="1">
				<table align="center" border="0">
					<tr bgcolor="#cccccc">
						<td>
							�û�ID
						</td>
						<td>
							�û�����
						</td>
						<td>
							�û�����
						</td>
						<td>
							��������
						</td>
						<td>
							�û��ȼ�
						</td>
						<td>
							��&nbsp;��
						</td>
						<td>
							ɾ&nbsp;��
						</td>
					</tr>
					<logic:iterate id="account" name="accountList">
						<tr bgcolor="#9999FF">
							<td>
								<bean:write name="account" property="userId" />
							</td>
							<td>
								<bean:write name="account" property="password" />
							</td>
							<td>
								<bean:write name="account" property="username" />
							</td>
							<td>
								<bean:write name="account" property="email" />
							</td>
							<td>
								<bean:write name="account" property="level" />
							</td>
							<td>
								<html:link
									href="account.xsp?userId=${account.userId }&method=getAccount">��&nbsp;��</html:link>
							</td>
							<td>
								<a href="account.xsp?userId=${account.userId}&method=delete"
									onclick="return delpay()">ɾ&nbsp;��</a>
							</td>

						</tr>
					</logic:iterate>
					<tr bgcolor="#ccccFF">
						<td colspan="7">
							<%
								int size = (Integer) request.getAttribute("size");
								int pageNum = 0;
								try {
									pageNum = Integer.parseInt(request.getParameter("pageNum"));
								} catch (NumberFormatException nfe) {
									pageNum = 0;
								}
								int i = 1;
							%>
							[��
							<%=size%>
							ҳ]
							<a href="account.xsp?pageNum=<%=pageNum - 1%>&method=read">[��һҳ]</a>
							<%
							while (i <= size) {
							%>
							<a href="account.xsp?pageNum=<%=i%>&method=read">[<%=i%>]</a>
							<%
								i++;
								}
							%>
							<a href="account.xsp?pageNum=<%=pageNum + 1%>&method=read">[��һҳ]</a>
						</td>
					</tr>
				</table>
			</logic:equal>
		</logic:present>
	</center>
</body>
</html:html>
