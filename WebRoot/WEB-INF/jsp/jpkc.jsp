<%@ page language="java" pageEncoding="gb2312"%>
<%@ page
	import="java.util.*,com.gjx.jxufe.factory.Factory,com.gjx.util.*,com.gjx.jxufe.vo.*"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<%@include file="../common/includeHeader.jsp"%>
<%@include file="jpkcLeftMenu.jsp"%>

<!--右边内容的显示-->

<%int year = 2015;boolean flag=true;%>
<div class="rightContainer">

	<div class="rightContainerContent">
		<table width="100%"  align="center">
			<tr align="center">
			<td colspan="3">
			  <logic:equal value="1" name="level">
				<html:img  width="570px" src="../../images/level1.gif" align="left"/>				
			</logic:equal>
			 <logic:equal value="2" name="level">
				<html:img  width="570px" src="../../images/level2.gif" align="left"/>				
			</logic:equal>
			 <logic:equal value="3" name="level">
				<html:img width="570px" src="../../images/level3.gif" align="left"/>				
			</logic:equal>
			<logic:equal value="0" name="level">
				<html:img width="570px" src="../../images/level3.gif" align="left"/>				
			</logic:equal>
			</td>
			</tr>		
			<tr>
				<td align="left" width="380px">
					课程名称
				</td>

				<td align="center" width="130px">
					课程负责人
				</td>
				<td align="center" width="170px">
					学院
				</td>
			</tr>
			<logic:present name="jpkcList">
			<% while(year>=2000){ %>
				<logic:iterate id="jl" name="jpkcList">				
				  <logic:equal value="<%=year+"" %>" name="jl" property="year">
				 <%if(flag==true){ %>
				  <tr style="background-color:white">
				  	<td colspan="3"><font color="red"><bean:write  name="jl" property="year" />年度</font></td>
				  </tr>
				  <% flag=false;} %>
					<tr style="background-color:white">
						<td align="left" width="400px">
							<li >
								<html:link page="#"  onmouseover="return overlib('<table><tr><td align=left ><font size=2 color=black>${jl.info }<font></td></tr></table>', CAPTION, '<td bgcolor=#BFCAE6><font size=3 color=blue>${jl.name }(学院：${jl.fullname })</font></td>', HAUTO,VAUTO )" onmouseout="nd()">
									<bean:write property="name" name="jl" />
								</html:link>
							</li>
						</td>

						<td align="center" width="110px">
							<bean:write property="teacher" name="jl" />
						</td>
						<td align="center" width="110px">
							<bean:write property="fullname" name="jl" />
						</td>
					</tr>
					</logic:equal>
				</logic:iterate>
				<% year--;flag=true;} %>
			</logic:present>		
		</table>
	</div>

</div>




<%@include file="../common/includeFooter.jsp"%>

