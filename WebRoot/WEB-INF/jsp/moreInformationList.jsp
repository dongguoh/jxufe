<%@ page language="java" pageEncoding="gb2312"%>
<%@ page import="com.gjx.jxufe.factory.*,java.util.*,com.gjx.util.*" %>
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

<%@include file="../common/includeHeader.jsp"%>
<%@include file="informationLeftMenu.jsp"%>

<div class="rightContainer">

	<div class="rightContainerContent">
		<table width="100%" align="center"  >
			
			<logic:present name="informationType">
				<tr align="center">
					<th colspan="3" align="center" style="font-size:26px">
						<bean:write name="informationType" property="name" />
					</th>
				</tr>
			</logic:present>
			
			<logic:present name="informationList">
				<logic:iterate id="al" name="informationList" length="20">
					<tr>
						<td align="left" width="500px">
						<li>
							<html:link
								page="/readInformation.xsp?classify=${al.classify}&id=${al.id}">
								<bean:write property="title" name="al" />
							</html:link>
						</li>
						</td>

						<td align="center" width="110px">
							<bean:write property="date" name="al" />
						</td>
						<td align="center" width="100px">
							<logic:notEmpty name="al" property="file">
								<html:link page="/${al.file}">下载文件</html:link>
							</logic:notEmpty>
							<logic:empty name="al" property="file">
								 无
					  </logic:empty>
						</td>
					</tr>
				</logic:iterate>
			</logic:present>
			<tr bgcolor="#738880" class="normal">
				<td class="normal" style="background-color:#CCFFCC;" colspan="3">					
					<a 
						href="../../readInformation.xsp?pageNum=<%=pageNum - 1%>&classify=${informationType.id }">[<<<]</a>
					<%
					while (i <= size) {
					%>
					<a 
						href="../../readInformation.xsp?pageNum=<%=i%>&classify=${informationType.id}">[<%=i%>]</a>
					<%
						i++;
						}
					%>
					<a 
						href="../../readInformation.xsp?pageNum=<%=pageNum + 1%>&classify=${informationType.id}">[>>>]</a>
				</td>
			</tr>
		</table>
	</div>

</div>




<%@include file="../common/includeFooter.jsp"%>

