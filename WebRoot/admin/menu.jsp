<%@ page language="java" pageEncoding="GB2312"%>

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

	<title>test.jsp</title>

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
	background-color: #999966;
	margin: 20px 0px 0px;
}
.style1 {
	color: #660000;
	font-size: 14px;
	font-weight: bold;
}
.style2 {font-size: 12px}
.style3 {
	font-size: 14px;
	font-weight: bold;
}
.style4 {color: #660000; font-size: 12px; }
-->
  </style>
</head>

<body>
	<table width="170">
		<tr align="center" bgcolor="#CCCCCC">
			<td colspan="2">
				<span class="style1">��̨����ϵͳ</span>
			</td>
		</tr>
		<tr align="center" bgcolor="#CCCCCC">
			<td colspan="2">
				<span class="style4"> </span>
			</td>
		</tr>
		<tr align="center" bgcolor="#CCCCFF">
			<td width="85">
				<span class="style2"><html:link forward="index" target="_blank"> ������ҳ</html:link> </span>
			</td>
			<td width="102">
				<span class="style2"> <logic:notPresent scope="session"
						name="admin">
						<html:link page="/admin/account/login.jsp" target="mainFrame">��¼</html:link>
					</logic:notPresent> <logic:present scope="session" name="admin">

						<a href="account/account.xsp?method=logoff" target="_blank">�˳�</a>
					</logic:present> </span>
			</td>
		</tr>
		<tr align="center">
			<td colspan="2" bgcolor="#CCCCCC">
				<span class="style3">�û���Ϣ����</span>
			</td>
		</tr>
		<tr align="center">
			<td colspan="2" bgcolor="#CCCCFF">
				<span class="style2">&gt;&gt; <a
					href="account/account.xsp?method=read" target="mainFrame">�����û�</a>
				</span>
			</td>
		</tr>
		<tr align="center">
			<td colspan="2" bgcolor="#CCCCFF">
				<span class="style2">&gt;&gt; <html:link
						href="account/insertAccount.jsp" target="mainFrame">�����û�</html:link>
				</span>
			</td>
		</tr>
		<tr align="center">
			<td colspan="2" bgcolor="#CCCCCC">
				<span class="style3">������Ϣ����</span>
			</td>
		</tr>
		<tr align="center">
			<td colspan="2" bgcolor="#CCCCFF">
				<span class="style2">&gt;&gt; <html:link
						href="information/insertInformation.jsp" target="mainFrame">��&nbsp;��&nbsp;��&nbsp;Ϣ</html:link>

				</span>
			</td>
		</tr>
		<tr align="center">
			<td colspan="2" bgcolor="#CCCCFF">
				<span class="style2">&gt;&gt; <html:link
						href="information/informationType.xsp?method=read" target="mainFrame">�༭��Ϣ����</html:link>

				</span>
			</td>
		</tr>
		<logic:iterate id="ifTypeList" name="informationTypeList">
		<tr align="center">
			<td colspan="2" bgcolor="#CCCCFF">
				<span class="style2">&gt;&gt; <html:link
						href="information.xsp?method=read&classify=${ifTypeList.id}" target="mainFrame">						
						<bean:write name="ifTypeList" property="name"/></html:link>

				</span>
			</td>
		</tr>
		</logic:iterate>

		<tr align="center">
			<td colspan="2" bgcolor="#CCCCCC">
				<span class="style3">������ӹ���</span>
			</td>
		</tr>
		<tr align="center">
			<td colspan="2" bgcolor="#CCCCFF">
				<span class="style2">&gt;&gt; <a
					href="link/linkType.xsp?method=read" target="mainFrame">�༭��������</a>
				</span>
			</td>
		</tr>
		
		<tr align="center">
			<td colspan="2" bgcolor="#CCCCFF">
				<span class="style2">&gt;&gt; 
				<a	href="link/link.xsp?method=read" target="mainFrame">�༭�������</a>
				</span>
			</td>
		</tr>		
		<tr align="center">
			<td colspan="2" bgcolor="#CCCCCC">
				<span class="style3">��Ʒ�γ̹���</span>
			</td>
		</tr>
		<tr align="center">
			<td colspan="2" bgcolor="#CCCCFF">
				<span class="style2">&gt;&gt;
				<a	href="jpkc/jpkc.xsp?method=read" target="mainFrame">
				��ӿγ�
				</a></span>
			</td>
		</tr>
		
		<tr align="center">
			<td colspan="2" bgcolor="#CCCCCC">
				<span class="style3">ϵͳ�����Ϣ</span>
			</td>
		</tr>
		<tr align="center" bgcolor="#CECFFF">
			<td colspan="2">
				<span class="style2">&gt;&gt;�ƽ黷��</span>
			</td>
		</tr>
		<tr align="center" bgcolor="#CECFFF">
			<td colspan="2">
				<span class="style2">&gt;&gt;���л���</span>
			</td>
		</tr>
		<tr align="center">
			<td colspan="2">
				<table width="100%" border="0">
					<tr>
						<td width="40%" align="right">
							<span class="style2">��Ȩ����:</span>
						</td>
						<td width="60%">
							<span class="style2">�����ƾ���ѧ</span>
						</td>
					</tr>
					<tr>
						<td align="right">
							<span class="style2">����֧��:</span>
						</td>
						<td>
							<span class="style2">�˾���</span>
						</td>
					</tr>
					<tr>
						<td align="right">
							<span class="style2">Q &nbsp;Q:</span>
						</td>
						<td>
							<span class="style2">191183440</span>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>

</body>
</html:html>
