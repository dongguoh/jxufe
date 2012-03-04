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
   if(confirm("确定要删除这个精品课程吗?"))
     return true;
   else
     return false;
}
</script>
</head>

<body>
<!-- 插入精品课程 -->
<%	int year = 2000; %>
<logic:notPresent name="jpkc">
	<html:form action="admin/jpkc/editJpkc.xsp" method="post">
		<input type="hidden" name="method" value="insert" />
  		 添加精品课程:<br>
		<html:errors />
		<logic:present name="success">
			<font color="blue">添加成功</font>
		</logic:present>
		<br>
		课程名称:
		<html:text property="name" />
		<br>
		负责人 ： 
		<html:text property="teacher" />
		<br>
		申报等级：
		<html:select property="level" value="2">
			<html:option value="1">国家级</html:option>
			<html:option value="2">省级</html:option>
			<html:option value="3">校级</html:option>
		</html:select>
		<br>
		学院名称 ：
		<html:text property="fullname" />
		<br>
		申报时间 ：
		<html:select property="year" value="2007">
			<%
			while (year <= 2015) {
			%>
			<html:option value="<%=year + ""%>">
				<%=year++ + ""%>
			</html:option>
			<%
			}
			%>
		</html:select>
		<br>描述信息：<br>
		<html:textarea property="info" rows="5" cols="30" />

		<br>
		<html:submit>添加</html:submit>
	</html:form>

</logic:notPresent>
<!-- 更新精品课程 -->
<logic:present name="jpkc">
<html:form action="admin/jpkc/editJpkc.xsp" method="post">
<input type="hidden" name="id" value="${jpkc.id }" />
		<input type="hidden" name="method" value="update" />
  		 添加精品课程:<br>
		<html:errors />
		<logic:present name="success">
			<font color="blue">更新成功</font>
		</logic:present>
		<br>
		课程名称:
		<html:text property="name"  value="${jpkc.name}"/>
		<br>
		负责人 ： 
		<html:text property="teacher" value="${jpkc.teacher}"/>
		<br>
		申报等级：
		<html:select property="level" value="${jpkc.level}">
			<html:option value="1">国家级</html:option>
			<html:option value="2">省级</html:option>
			<html:option value="3">校级</html:option>
		</html:select>
		<br>
		学院名称 ：
		<html:text property="fullname" value="${jpkc.fullname}" />
		<br>
		申报时间 ：
		<html:select property="year" value="${jpkc.year}">
			<%
			while (year <= 2015) {
			%>
			<html:option value="<%=year + ""%>">
				<%=year++ + ""%>
			</html:option>
			<%
			}
			%>
		</html:select>
		<br>描述信息：<br>
		<html:textarea property="info" rows="5" cols="30" value="${jpkc.info}"/>

		<br>
		<html:submit>更新</html:submit>
	</html:form>
</logic:present>
<!-- 结束 -->
	<hr>
	<br>
	编辑现有的链接：
	<br>
	<table bgcolor="#c0c0c0" width="800px">
		<tr>
			<td width="130" align="left">
				课程名称
			</td>
			<td width="100" align="center">
				负责人
			</td>
			<td width="100" align="center">
				申报等级
			</td>
			<td width="140" align="center">
				学院名称
			</td>
			<td width="100" align="center">
				申报时间
			</td>
			<td width="60" align="center">
				编辑
			</td>
			<td width="60" align="center">
				删除
			</td>
		</tr>
		<!-- 对取得的链接进行编辑和显示 -->
		<logic:present name="jpkcList">
			<logic:iterate id="jl" name="jpkcList">
				<tr bgcolor="#eadde8">
					<td width="130" align="left">
						<bean:write name="jl" property="name" />
					</td>
					<td width="100" align="center">
						<bean:write name="jl" property="teacher" />
					</td>
					<td width="100" align="center">
						<logic:equal value="1" name="jl" property="level">
								国家级
							</logic:equal>
						<logic:equal value="2" name="jl" property="level">
								省级
							</logic:equal>
						<logic:equal value="3" name="jl" property="level">
								校级
							</logic:equal>
					</td>
					<td width="140" align="center">
						<bean:write name="jl" property="fullname" />
					</td>
					<td width="100" align="center">
						<bean:write name="jl" property="year" />
					</td>
					<td width="60" align="center">
						<a href="jpkc.xsp?method=getJpkc&id=${jl.id }">编辑</a>
					</td>
					<td width="60" align="center">
						<a href="jpkc.xsp?method=delete&id=${jl.id }"
							onclick="return delpay()">删除</a>
					</td>
				</tr>
			</logic:iterate>
		</logic:present>

	</table>

</body>
</html:html>
