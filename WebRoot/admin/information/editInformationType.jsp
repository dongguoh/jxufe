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
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script language="JavaScript" type="text/JavaScript">
function delpay()
{
   if(confirm("ȷ��Ҫɾ�������Ϣ������?\n���ɾ��������ͽ�������е�������������µ�ȫ�����ݶ�ɾ����"))
     return true;
   else
     return false;
}
</script>
</head>

<body>


	<html:form action="/editInformationType.xsp" method="post">
		<input type="hidden" name="method" value="insert" />
   ��ӷ�����Ϣ����:<br>
		<html:errors />
		<br>
		<input type="text" name="name" size="25" />
		<br>
		<html:submit>���</html:submit>
	</html:form>
	<hr>
	<br>
	�༭���е����ӷ��ࣺ
	<br>
	<table bgcolor="#c0c0c0">
		<tr>
			<td width="330" align="left">
				��������
			</td>
			<td width="60" align="center">
				������
			</td>
			<td width="40" align="center">
				ɾ��
			</td>
		</tr>
		<!-- �޸��������͵�ֵ����ʾ�ķ�ʽ -->
		<logic:present name="informationTypeList">
			<logic:iterate id="ltl" name="informationTypeList">
				<tr bgcolor="#eadde8">
					<logic:notPresent name="informationType">
						<td width="330" align="left">
							<bean:write name="ltl" property="name" />
						</td>
						<td width="60" align="center">
							<a href="informationType.xsp?method=getInformationType&id=${ltl.id}">������</a>
						</td>
					</logic:notPresent>
					<logic:present name="informationType">

						<logic:notEqual value="${ltl.id}" name="informationType" property="id">

							<td width="330" align="left">
								<bean:write name="ltl" property="name" />
							</td>
							<td width="60" align="center">
								<a href="informationType.xsp?method=getInformationType&id=${ltl.id}">������</a>
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
									<html:submit>ȷ��</html:submit>
								</td>
							</html:form>
						</logic:equal>
					</logic:present>
					<td width="40" align="center">
						<a href="informationType.xsp?method=delete&id=${ltl.id}"
							onclick="return delpay()">ɾ��</a>
					</td>

				</tr>
			</logic:iterate>
		</logic:present>

	</table>

</body>
</html:html>
