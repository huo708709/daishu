package com.shop.manager.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.data.mapper.daishu.Customer;
import com.shop.manager.util.ConfigUtil;

@WebFilter(filterName = "aclFilter", urlPatterns = "/*")
public class AclFilter implements Filter {
	
	public final static String loginCustomer = "loginCustomer";

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		HttpSession session = request.getSession();
		String path = request.getServletPath();
		String url = null;
		
//		String uri = request.getRequestURI();
		if (path.length() >= 1) {
			url = path.substring(1);
		}
		
		if (null != url && !url.startsWith("auth")) {
			Customer customer = (Customer) session.getAttribute(loginCustomer);
			if (null == customer) {
				response.sendRedirect(ConfigUtil.AUTH_LOGIN);
				return;
			}
		}
		
		chain.doFilter(req, resp);
	}

	@Override
	public void destroy() {
		
	}

}
