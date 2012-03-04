<%@ page language="java" pageEncoding="gb2312"%>
<%@ page
	import="java.util.*,com.gjx.jxufe.factory.Factory,com.gjx.util.*,com.gjx.jxufe.vo.*"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<%@include file="../common/includeHeader.jsp"%>
<%@include file="indexLeftMenu.jsp"%>

<!--óò±??úèYμ???ê?-->

<div class="rightContainer">
	<!--  2￥·? í??? -->
	
<%@include file="pictureLink.jsp"%>	
	<%
		List list = Factory.getInformationTypeDaoImpl()
				.getInformationTypeList();		
		request.setAttribute(Constants.INFORMATION_TYPE_LIST, list);
		
		int classify = 0;
		Iterator it = list.iterator();
		while (it.hasNext()) {
			classify = ((InformationType) it.next()).getId();
			list = Factory.getInfromationDaoImple().getInformationList(
			request, 0, Constants.INDEX_INFORMATION_LIST_LENGTH,
			classify);
			request.setAttribute("information", list);
	%>
	<div class="index">

		<table width="100%" >
			<tr bgcolor="cccccc">

				<logic:iterate id="ifTypeList" name="informationTypeList">
					<logic:equal value="<%=classify + ""%>" name="ifTypeList" property="id">
						<th colspan="2" align="left">
							<bean:write name="ifTypeList" property="name" />
						</th>
						<th style="background-image: url(../../images/indexInformationr.gif);padding-left:10px;">
							<html:link page="/readInformation.xsp?classify=${ifTypeList.id}"><img  border="0" src="../../images/more.gif" /></html:link>
						</th>
					</logic:equal>
				</logic:iterate>

			</tr>
			
			<logic:iterate id="al" name="<%="information"%>" >
				<tr>
					<td>
					<li>
						<html:link
							page="/readInformation.xsp?classify=${al.classify}&id=${al.id}">
							<bean:write property="title" name="al" />
						</html:link>
					</li>
					</td>

					<td align="right" width="90px">						
						<bean:write property="date" name="al" />						
					</td>
					<td align="center" width="70px">
						<logic:notEmpty name="al" property="file">
							<html:link page="/${al.file}">下载文件</html:link>
						</logic:notEmpty>
						<logic:empty name="al" property="file">
								 无
					  </logic:empty>
					</td>
				</tr>
			</logic:iterate>
		</table>
	</div>
	<%
		}
	%>
	

</div>






<%@include file="../common/includeFooter.jsp"%>
