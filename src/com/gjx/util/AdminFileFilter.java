package com.gjx.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.gjx.jxufe.vo.Account;

public class AdminFileFilter implements Filter {

	//private static final Log logger=LogFactory.getLog(AdminFileFilter.class);
	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String path = req.getServletPath();
		Account admin = (Account) req.getSession().getAttribute(
				Constants.ADMIN_KEY);

		if (path.equalsIgnoreCase("/admin/login.xsp")) {
			chain.doFilter(req, resp);
			
		} else if (null == admin) {
			resp.sendRedirect("../login.jsp");			
		}else{
			//logger.info("ÓÃ»§: "+admin.getUserId()+"µÇÂ¼À²£¡");
			chain.doFilter(req, resp);
		}

	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
