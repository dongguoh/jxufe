<%@ page language="java" pageEncoding="gb2312"%>
<%@ page
	import="java.util.*,com.gjx.jxufe.factory.Factory,com.gjx.util.*,com.gjx.jxufe.vo.*"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%
	List linkTypeList=Factory.getLinkTypeDaoImpl().getLinkTypeList();
	List linkList=Factory.getLinkDaoImpl().getLinkList();

	request.setAttribute("linkTypeList",linkTypeList);
	request.setAttribute("linkList",linkList); 
 %>

<div class="leftMenuContaner">
	<div class="leftMenu">
		<logic:iterate id="ltl" name="linkTypeList">
		 <logic:notEqual value="1" name="ltl" property="id">
			<table>
				<tr>
					<th align="center">
						<bean:write name="ltl" property="name" />

					</th>
				</tr>
				<tr>
					<td>
						<ul>
							<logic:iterate id="ll" name="linkList">
								
									<logic:equal value="${ltl.id}" name="ll" property="typeid">
									<li>
										<html:link href="${ll.url }">
											<bean:write name="ll" property="name" />
										</html:link>
										</li>
									</logic:equal>
								
							</logic:iterate>
						</ul>
					</td>
				</tr>
			</table>
			</logic:notEqual>
		</logic:iterate>
		<!-- 精品课程链接 -->
		
			
	</div>
</div>



