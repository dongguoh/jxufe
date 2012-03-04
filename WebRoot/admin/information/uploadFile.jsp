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
					<font color="blue">上传成功</font>
			</td>
			<td>
				文件路径：<bean:write name="path" scope="session" />
				大小：<bean:write name="uploadForm" property="fsize" />
				<html:link page="/admin/information/deleteFile.xsp?id=-1">删除文件</html:link>
			</td>
		</tr>
		</logic:present>
		<logic:notPresent name="path" scope="session">
		<logic:empty name="uploadForm" property="fname">
			<tr>
				<td>
					<html:file property="file" size="59" />
					<html:submit>上传</html:submit>
				</td>
			</tr>
			<tr>
				<td>
					<html:errors />
					<font size="2"> (<font color="red">非</font>exe , com, dll,
						bat &nbsp;格式 且 小于 100M) </font>
				</td>
			</tr>
		</logic:empty>
		</logic:notPresent>
	</table>
</html:form>
