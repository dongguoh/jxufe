<%@ page language="java" pageEncoding="gb2312"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
<head>
	<html:base />

	<title>�༭���ӷ���</title>

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
   if(confirm("ȷ��Ҫɾ�������Ʒ�γ���?"))
     return true;
   else
     return false;
}
</script>
</head>

<body>
<!-- ���뾫Ʒ�γ� -->
<%	int year = 2000; %>
<logic:notPresent name="jpkc">
	<html:form action="admin/jpkc/editJpkc.xsp" method="post">
		<input type="hidden" name="method" value="insert" />
  		 ��Ӿ�Ʒ�γ�:<br>
		<html:errors />
		<logic:present name="success">
			<font color="blue">��ӳɹ�</font>
		</logic:present>
		<br>
		�γ�����:
		<html:text property="name" />
		<br>
		������ �� 
		<html:text property="teacher" />
		<br>
		�걨�ȼ���
		<html:select property="level" value="2">
			<html:option value="1">���Ҽ�</html:option>
			<html:option value="2">ʡ��</html:option>
			<html:option value="3">У��</html:option>
		</html:select>
		<br>
		ѧԺ���� ��
		<html:text property="fullname" />
		<br>
		�걨ʱ�� ��
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
		<br>������Ϣ��<br>
		<html:textarea property="info" rows="5" cols="30" />

		<br>
		<html:submit>���</html:submit>
	</html:form>

</logic:notPresent>
<!-- ���¾�Ʒ�γ� -->
<logic:present name="jpkc">
<html:form action="admin/jpkc/editJpkc.xsp" method="post">
<input type="hidden" name="id" value="${jpkc.id }" />
		<input type="hidden" name="method" value="update" />
  		 ��Ӿ�Ʒ�γ�:<br>
		<html:errors />
		<logic:present name="success">
			<font color="blue">���³ɹ�</font>
		</logic:present>
		<br>
		�γ�����:
		<html:text property="name"  value="${jpkc.name}"/>
		<br>
		������ �� 
		<html:text property="teacher" value="${jpkc.teacher}"/>
		<br>
		�걨�ȼ���
		<html:select property="level" value="${jpkc.level}">
			<html:option value="1">���Ҽ�</html:option>
			<html:option value="2">ʡ��</html:option>
			<html:option value="3">У��</html:option>
		</html:select>
		<br>
		ѧԺ���� ��
		<html:text property="fullname" value="${jpkc.fullname}" />
		<br>
		�걨ʱ�� ��
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
		<br>������Ϣ��<br>
		<html:textarea property="info" rows="5" cols="30" value="${jpkc.info}"/>

		<br>
		<html:submit>����</html:submit>
	</html:form>
</logic:present>
<!-- ���� -->
	<hr>
	<br>
	�༭���е����ӣ�
	<br>
	<table bgcolor="#c0c0c0" width="800px">
		<tr>
			<td width="130" align="left">
				�γ�����
			</td>
			<td width="100" align="center">
				������
			</td>
			<td width="100" align="center">
				�걨�ȼ�
			</td>
			<td width="140" align="center">
				ѧԺ����
			</td>
			<td width="100" align="center">
				�걨ʱ��
			</td>
			<td width="60" align="center">
				�༭
			</td>
			<td width="60" align="center">
				ɾ��
			</td>
		</tr>
		<!-- ��ȡ�õ����ӽ��б༭����ʾ -->
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
								���Ҽ�
							</logic:equal>
						<logic:equal value="2" name="jl" property="level">
								ʡ��
							</logic:equal>
						<logic:equal value="3" name="jl" property="level">
								У��
							</logic:equal>
					</td>
					<td width="140" align="center">
						<bean:write name="jl" property="fullname" />
					</td>
					<td width="100" align="center">
						<bean:write name="jl" property="year" />
					</td>
					<td width="60" align="center">
						<a href="jpkc.xsp?method=getJpkc&id=${jl.id }">�༭</a>
					</td>
					<td width="60" align="center">
						<a href="jpkc.xsp?method=delete&id=${jl.id }"
							onclick="return delpay()">ɾ��</a>
					</td>
				</tr>
			</logic:iterate>
		</logic:present>

	</table>

</body>
</html:html>
