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
   if(confirm("ȷ��Ҫɾ�����������?"))
     return true;
   else
     return false;
}
</script>
</head>

<body>


	<html:form action="admin/link/editLink.xsp" method="post">
		<input type="hidden" name="method" value="insert" />
  		 �������:<br>
		<html:errors />
		<br>
		��������:
		<input type="text" name="name" size="25" />
		<br>
		���ӷ���:<html:select property="typeid" value="1">
			<logic:present name="linkTypeList">
				<logic:iterate id="ltl" name="linkTypeList">
					<html:option value="${ltl.id}">
						<bean:write name="ltl" property="name" />
					</html:option>
				</logic:iterate>
			</logic:present>
		</html:select>
		<br>
		���ӵ�ַ:
		<input type="text" name="url" size="25" />
		<br>

		<html:submit>���</html:submit>
	</html:form>
	<hr>
	<br>
	�༭���е����ӣ�
	<br>
	<table bgcolor="#c0c0c0" width="800px">
		<tr>
			<td width="130" align="left">
				��������
			</td>
			<td width="160" align="center">
				���ӵ�ַ
			</td>
			<td width="140" align="center">
				�������
			</td>

			<td width="60" align="center">
				�༭
			</td>
			<td width="60" align="center">
				ɾ��
			</td>
		</tr>
		<!-- ��ȡ�õ����ӽ��б༭����ʾ -->
		<logic:present name="linkList">
			<!-- ��û�н���༭״̬ʱ����ʾ��ʽ -->
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
							<a href="link.xsp?method=getLink&id=${ll.id }" >�༭</a>
						</td>
						<td width="60" align="center">
							<a href="link.xsp?method=delete&id=${ll.id }" onclick="return delpay()">ɾ��</a>
						</td>

					</tr>
				</logic:iterate>
			</logic:notPresent>
			<!-- ������༭״̬ʱ����ʾ��ʽ -->
			<logic:present name="link">

				<logic:iterate id="ll" name="linkList" scope="request">
				<!-- ��ȡ������id���б��е�ID���ʱ��ʾ�༭״̬ -->
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
									<html:submit>ȷ��</html:submit>
								</td>
								<td width="60" align="center">
									<a href="link.xsp?method=delete&id=${ll.id }" onclick="return delpay()">ɾ��</a>
								</td>
							</tr>
					</html:form>
					</logic:equal>
					<!-- ��ȡ������id���б��е�ID�����ʱ��ʾ�༭״̬ -->
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
							<a href="link.xsp?method=getLink&id=${ll.id }">�༭</a>
						</td>
						<td width="60" align="center">
							<a href="link.xsp?method=delete&id=${ll.id }" onclick="return delpay()">ɾ��</a>
						</td>

					</tr>
					</logic:notEqual>
				</logic:iterate>
			</logic:present>
		</logic:present>

	</table>

</body>
</html:html>
