<%@ page language="java" pageEncoding="GB18030"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<html:form action="/admin/upload.xsp" method="post"
	enctype="multipart/form-data">
	<table background="#B9B973" bgcolor="#B9B973" width="100%" height="100%">
		<logic:present name="path" scope="session">
		<tr bgcolor="#B9B973" >
			<td>				
					<font color="blue">�ϴ��ɹ�</font>
			</td>
			<td>
				�ļ�·����<bean:write name="path" scope="session" />
				��С��<bean:write name="uploadForm" property="fsize" />
				<html:link page="/admin/information/deleteFile.xsp?id=-1">ɾ���ļ�</html:link>
			</td>
		</tr>
		</logic:present>
		<logic:notPresent name="path" scope="session">
		<logic:empty name="uploadForm" property="fname">
			<tr>
				<td>
					<html:file property="file" size="59" />
					<html:submit>�ϴ�</html:submit>
				</td>
			</tr>
			<tr>
				<td>
					<html:errors />
					<font size="2"> (<font color="red">��</font>exe , com, dll,
						bat &nbsp;��ʽ �� С�� 100M) </font>
				</td>
			</tr>
		</logic:empty>
		</logic:notPresent>
	</table>
</html:form>
