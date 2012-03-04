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
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script language="JavaScript" type="text/JavaScript">
function delpay()
{
   if(confirm("确定要删除这个链接吗?"))
     return true;
   else
     return false;
}
</script>
</head>

<body>


	<html:form action="admin/link/editLink.xsp" method="post">
		<input type="hidden" name="method" value="insert" />
  		 添加链接:<br>
		<html:errors />
		<br>
		链接名称:
		<input type="text" name="name" size="25" />
		<br>
		链接分类:<html:select property="typeid" value="1">
			<logic:present name="linkTypeList">
				<logic:iterate id="ltl" name="linkTypeList">
					<html:option value="${ltl.id}">
						<bean:write name="ltl" property="name" />
					</html:option>
				</logic:iterate>
			</logic:present>
		</html:select>
		<br>
		链接地址:
		<input type="text" name="url" size="25" />
		<br>

		<html:submit>添加</html:submit>
	</html:form>
	<hr>
	<br>
	编辑现有的链接：
	<br>
	<table bgcolor="#c0c0c0" width="800px">
		<tr>
			<td width="130" align="left">
				链接名称
			</td>
			<td width="160" align="center">
				链接地址
			</td>
			<td width="140" align="center">
				链接类别
			</td>

			<td width="60" align="center">
				编辑
			</td>
			<td width="60" align="center">
				删除
			</td>
		</tr>
		<!-- 对取得的链接进行编辑和显示 -->
		<logic:present name="linkList">
			<!-- 当没有进入编辑状态时的显示方式 -->
			<logic:notPresent name="link">
				<logic:iterate id="ll" name="linkList" scope="request">
					<tr bgcolor="#eadde8">

						<td width="130" align="left">
							<bean:write name="ll" property="name" />
						</td>
						<td width="160" align="left">
							<bean:write name="ll" property="url" />
						</td>

						<td width="140" align="center">
							<logic:iterate id="ltl" name="linkTypeList">
								<logic:equal value="${ltl.id}" name="ll" property="typeid">
									<bean:write name="ltl" property="name" />
								</logic:equal>
							</logic:iterate>
						</td>
						<td width="60" align="center">
							<a href="link.xsp?method=getLink&id=${ll.id }" >编辑</a>
						</td>
						<td width="60" align="center">
							<a href="link.xsp?method=delete&id=${ll.id }" onclick="return delpay()">删除</a>
						</td>

					</tr>
				</logic:iterate>
			</logic:notPresent>
			<!-- 当进入编辑状态时的显示方式 -->
			<logic:present name="link">

				<logic:iterate id="ll" name="linkList" scope="request">
				<!-- 当取出来的id与列表中的ID相等时显示编辑状态 -->
						<logic:equal value="${link.id}" name="ll" property="id">
					<html:form action="admin/link/editLink.xsp" method="post">
						
							<tr bgcolor="#eadde8">
								<td width="130" align="left">
									<html:text property="name" name="ll" />
								</td>
								<td width="160" align="left" >
									<html:text property="url" name="ll"  size="30" />
								</td>
								<td width="140" align="center">
									<logic:iterate id="ltl" name="linkTypeList">
										<logic:equal value="${ltl.id}" name="ll" property="typeid">
											<html:select property="typeid" name="ll" value="${ltl.id}">
												<logic:iterate id="ltl" name="linkTypeList">
													<html:option value="${ltl.id}">${ltl.name}</html:option>
												</logic:iterate>
											</html:select>
										</logic:equal>
									</logic:iterate>
								</td>
								<td width="60" align="center">
									<input type="hidden" name="method" value="update" />
									<input type="hidden" name="id" value="${ll.id}" />
									<html:submit>确定</html:submit>
								</td>
								<td width="60" align="center">
									<a href="link.xsp?method=delete&id=${ll.id }" onclick="return delpay()">删除</a>
								</td>
							</tr>
					</html:form>
					</logic:equal>
					<!-- 当取出来的id与列表中的ID不相等时显示编辑状态 -->
					<logic:notEqual value="${link.id}" name="ll" property="id">
					<tr bgcolor="#eadde8">
						<td width="130" align="left">
							<bean:write name="ll" property="name" />
						</td>
						<td width="160" align="left">
							<bean:write name="ll" property="url" />
						</td>						
						<td width="140" align="center">
							<logic:iterate id="ltl" name="linkTypeList">
								<logic:equal value="${ltl.id}" name="ll" property="typeid">
									<bean:write name="ltl" property="name" />
								</logic:equal>
							</logic:iterate>
						</td>
						<td width="60" align="center">
							<a href="link.xsp?method=getLink&id=${ll.id }">编辑</a>
						</td>
						<td width="60" align="center">
							<a href="link.xsp?method=delete&id=${ll.id }" onclick="return delpay()">删除</a>
						</td>

					</tr>
					</logic:notEqual>
				</logic:iterate>
			</logic:present>
		</logic:present>

	</table>

</body>
</html:html>
