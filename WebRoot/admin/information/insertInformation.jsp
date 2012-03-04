<%@ page language="java" pageEncoding="gb2312"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<%@ page import="com.gjx.jxufe.factory.*,java.util.*,com.gjx.util.*;" %>
<%
	List list=Factory.getInformationTypeDaoImpl().getInformationTypeList();
	request.setAttribute(Constants.INFORMATION_TYPE_LIST,list);
 %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
<head>
	<html:base />

	<title>informationContent.jsp</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
	<style type="text/css">
<!--
body {
	background-color: #CACBE6;
}
-->
</style>
</head>

<body>
	<center>
		<br>
		<h1>
			发布信息
		</h1>
		<br>
		<hr>
		<logic:notPresent name="admin">请先
		<html:link page="/admin/account/login.jsp" target="mainFrame">登录</html:link>
		</logic:notPresent>
		<logic:present name="admin">
			<html:errors />
			<html:form action="/admin/editInformation.xsp"
				onsubmit="content.value=eWebEditor1.getHTML()">
				<table width="647" border="1" bgcolor="#B9B973" height="352">
					<input type="hidden" name="method" value="insert" />
					<tr>
						<td width="92" align="right">
							文章标题:
						</td>
						<td width="273" align="left">
							<html:text property="title" size="40" />
						</td>
					</tr>
					<tr>
						<td width="92" align="right">
							文章类型:
						</td>
						<td width="273" align="left">
							<html:select property="classify" value="1">
								<logic:iterate id="ifTypeList" name="informationTypeList">
								<html:option value="${ifTypeList.id}"><bean:write name="ifTypeList" property="name" /></html:option>
								</logic:iterate>
							</html:select>
							<font color="#800000">请注意选择文章类型</font>
						</td>
					</tr>
					<tr>
						<td align="right">
							发部部门:
						</td>
						<td align="left">
							<html:text property="issue" size="30" />
						</td>
					</tr>
					<TR>
						<TD>
							上传文件：
						</TD>
						<TD bgcolor="#B9B973">
							<INPUT type="hidden">
												
							<iframe align="left"   frameborder="0" 
								height="50" marginheight="0" marginwidth="0" 
								scrolling="No" width="100%" src="uploadFile.jsp" >
								</iframe>
						</TD>
					</TR>
					<tr>
						<td align="right">
							文章内容:
						</td>
						<td valign="top" align="left">
							<INPUT type="hidden" name="content1"
								value="${informationForm.content }">
							<iframe ID="eWebEditor1"
								src="../ewebeditor/ewebeditor.htm?id=content1&style=coolblue"
								frameborder="0" scrolling="no" width="550" HEIGHT="350"></iframe>
						</td>
					</tr>
					<tr>
						<td align="right">

						</td>
						<td align="left">
							<html:textarea property="content" style="display:none" />
						</td>
					</tr>
					<tr>
						<td align="center" colspan="2">
							<html:submit>提交</html:submit>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<html:reset>重设</html:reset>
						</td>
					</tr>
				</table>

			</html:form>
		</logic:present>
	</center>
</body>
</html:html>
