<%@ page language="java" import="com.gjx.jxufe.factory.Factory"
	pageEncoding="gb2312"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<%@ page import="com.gjx.jxufe.factory.*,java.util.*,com.gjx.util.*;" %>
<%
	List list=Factory.getInformationTypeDaoImpl().getInformationTypeList();
	request.setAttribute(Constants.INFORMATION_TYPE_LIST,list);
 %>


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
	<script language="JavaScript" type="text/JavaScript">
function delpay()
{
   if(confirm("确定要删除此信息吗？"))
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
		<bean:write name="informationType" property="name" />管理				
		</h1>
		<br>
		<hr>
		<table align="center" border="0">
			<tr bgcolor="#738880">
				<td>
					文章标题
				</td>
				<td>
					发布人员
				</td>
				<td>
					文件位置
				</td>
				<td>
					文件类型
				</td>
				<td>
					发布日期
				</td>
				<td>
					编&nbsp;辑
				</td>
				<td>
					删&nbsp;除
				</td>
			</tr>
			<logic:iterate id="information" name="informationList">
				<tr bgcolor="#9999FF">
					<td>
						<bean:write name="information" property="title" />
					</td>
					<td>
						<bean:write name="information" property="issue" />
					</td>
					<td>
						<bean:write name="information" property="file" />
					</td>
					<td>
						<logic:iterate id="ifTypeList" name="informationTypeList">
						<logic:equal name="information" value="${ifTypeList.id}" property="classify">					
								<bean:write name="ifTypeList" property="name" />
							</logic:equal>
						</logic:iterate>
					</td>
					<td>
						<bean:write name="information" property="date" />
					</td>
					<td>
						<html:link
							href="../information.xsp?id=${information.id }&method=getInformation">编&nbsp;辑</html:link>
					</td>
					<td>
						<a
							href="../information.xsp?id=${information.id }&pageNum=<%=pageNum%>&method=delete&classify=${information.classify }"
							onclick="return delpay()">删&nbsp;除</a>
					</td>

				</tr>
			</logic:iterate>
			<tr bgcolor="#738880">
				<td colspan="7">
					[共
					<%=size%>
					页]
					<a
						href="../information.xsp?pageNum=<%=pageNum - 1%>&method=read&classify=${information.classify }">[上一页]</a>
					<%
					while (i <= size) {
					%>
					<a
						href="../information.xsp?pageNum=<%=i%>&method=read&classify=${information.classify }">[<%=i%>]</a>
					<%
						i++;
						}
					%>
					<a
						href="../information.xsp?pageNum=<%=pageNum + 1%>&method=read&classify=${information.classify }">[下一页]</a>
				</td>
			</tr>
		</table>
	</center>
</body>
</html:html>
