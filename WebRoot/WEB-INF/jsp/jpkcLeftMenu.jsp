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
	<!-- 精品课程链接 -->
	<table>
				<tr>
					<th align="center">
						 精品课程链接
					</th>
				</tr>
				<tr>
					<td>
						<ul>
								<li>
										<html:link page="/readJpkc.xsp?level=1">	国家精品课程	</html:link>
								</li>
								<li>
										<html:link page="/readJpkc.xsp?level=2">	省级精品课程	</html:link>
								</li>
								<li>
										<html:link page="/readJpkc.xsp?level=3">	校级精品课程	</html:link>
								</li>									
						</ul>
					</td>
				</tr>
			</table>
			
			<!-- 主页面的链接 -->
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
		
		
			
	</div>
</div>



