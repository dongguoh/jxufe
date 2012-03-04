<%@ page language="java" pageEncoding="gb2312"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
<head>
	<html:base />

	<title>编辑链接分类</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script language="JavaScript" type="text/JavaScript">
function delpay()
{
   if(confirm("确定要删除这个信息类型吗?\n如果删除这个类型将会把所有的属于这个类型下的全部内容都删除？"))
     return true;
   else
     return false;
}
</script>
</head>

<body>


	<html:form action="/editInformationType.xsp" method="post">
		<input type="hidden" name="method" value="insert" />
   添加发布信息分类:<br>
		<html:errors />
		<br>
		<input type="text" name="name" size="25" />
		<br>
		<html:submit>添加</html:submit>
	</html:form>
	<hr>
	<br>
	编辑现有的链接分类：
	<br>
	<table bgcolor="#c0c0c0">
		<tr>
			<td width="330" align="left">
				分类名称
			</td>
			<td width="60" align="center">
				重命名
			</td>
			<td width="40" align="center">
				删除
			</td>
		</tr>
		<!-- 修改链接类型的值和显示的方式 -->
		<logic:present name="informationTypeList">
			<logic:iterate id="ltl" name="informationTypeList">
				<tr bgcolor="#eadde8">
					<logic:notPresent name="informationType">
						<td width="330" align="left">
							<bean:write name="ltl" property="name" />
						</td>
						<td width="60" align="center">
							<a href="informationType.xsp?method=getInformationType&id=${ltl.id}">重命名</a>
						</td>
					</logic:notPresent>
					<logic:present name="informationType">

						<logic:notEqual value="${ltl.id}" name="informationType" property="id">

							<td width="330" align="left">
								<bean:write name="ltl" property="name" />
							</td>
							<td width="60" align="center">
								<a href="informationType.xsp?method=getInformationType&id=${ltl.id}">重命名</a>
							</td>

						</logic:notEqual>

						<logic:equal value="${ltl.id}" name="informationType" property="id">
							<html:form action="/editInformationType.xsp" method="post">
								<input type="hidden" name="method" value="update" />
								<input type="hidden" name="id" value="${ltl.id }" />
								<td width="330" align="left">
									<input type="text" name="name" size="25" value="${ltl.name }" />
								</td>
								<td width="60" align="center">
									<html:submit>确定</html:submit>
								</td>
							</html:form>
						</logic:equal>
					</logic:present>
					<td width="40" align="center">
						<a href="informationType.xsp?method=delete&id=${ltl.id}"
							onclick="return delpay()">删除</a>
					</td>

				</tr>
			</logic:iterate>
		</logic:present>

	</table>

</body>
</html:html>
