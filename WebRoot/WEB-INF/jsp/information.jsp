<%@ page language="java" pageEncoding="gb2312"%>
<%@include file="../common/includeHeader.jsp"%>
<%@include file="informationLeftMenu.jsp"%>

<div class="rightContainer">

	<div class="rightContainerContent">
		<table width="100%" align="center" style="table-layout:fixed">
			<logic:present name="information">

				<tr align="center">
					<td colspan="2" align="center" style="font-size:26px">
						<bean:write name="information" property="title" />
					</td>					
				</tr>
				<tr>				
					<td colspan="2" style="overflow:auto">	<hr>				
					<!--��start��-->				
					<font color="blue" size=2>
						�������ţ�<bean:write name="information" property="issue" filter="false" />
					
						�������ڣ�<bean:write name="information" property="date" filter="false" />
					
						�ļ����أ�					
						<logic:notEmpty name="information" property="file">
							<html:link page="/${information.file}">�����ļ�</html:link>
						</logic:notEmpty>
						<logic:empty name="information" property="file">
								 ��
					  </logic:empty>
					  </font>
					  <br>	
					<!--��end��-->
					
					
					
					
					
						<bean:write name="information" property="content" filter="false" />
					</td>
				</tr>
				
				<tr>
					<td colspan="2" align="left">
					<font color="blue" size=2>
						�������ţ�<bean:write name="information" property="issue" filter="false" />
					</font>
					</td>	
				</tr>
				<tr>
					<td colspan="2" align="left">
					<font color="blue" size=2>
						�������ڣ�<bean:write name="information" property="date" filter="false" />
						</font>
					</td>					
				</tr>
				<tr>
					<td colspan="2" align="left">
					<font color="blue" size=2>
						�ļ����أ�					
						<logic:notEmpty name="information" property="file">
							<html:link page="/${information.file}">�����ļ�</html:link>
						</logic:notEmpty>
						<logic:empty name="information" property="file">
								 ��
					  </logic:empty>
					  </font>
					</td>
				</tr>
			</logic:present>
			<!-- ��ҳ -->

		</table>
	</div>
</div>




<%@include file="../common/includeFooter.jsp"%>
