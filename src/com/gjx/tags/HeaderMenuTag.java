package com.gjx.tags;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gjx.jxufe.factory.Factory;
import com.gjx.jxufe.vo.Link;

public class HeaderMenuTag extends BodyTagSupport {

	private static final Log logger=LogFactory.getLog(HeaderMenuTag.class);
	public int doEndTag() throws JspException {
		JspWriter out=this.pageContext.getOut();
		List list=Factory.getLinkDaoImpl().getLinkList();
		Link link=null;
		try {
			out.print("<ul>");
			Iterator it=list.iterator();
			while(it.hasNext()){
				link=(Link)it.next();
				if(link.getTypeid()==1){
				out.print("<li>");
				out.print("<a  "+"href='"+link.getUrl()+"' >");
				out.print(link.getName());
				out.print("</a>");
				out.print("</li>");
				}
			}			
			out.print("</ul>");
		} catch (IOException e) {
			logger.error(e);
		}
		return super.doEndTag();
	}
	

}
