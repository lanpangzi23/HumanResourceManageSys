package com.yc.web.utils;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Repository;
@Repository
public class loginFilter implements Filter {

    public loginFilter() {
	    }

		public void destroy() {
		}

		public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
			HttpServletRequest req=(HttpServletRequest) request;
			if(req.getSession().getAttribute("uname")!=null){
				chain.doFilter(request, response);
			}else{
				req.getSession().setAttribute("errmsg", "请先登录");
				request.getRequestDispatcher("/WEB-INF/jsp/adminLogin.jsp").forward(request, response);
			}
		}

		public void init(FilterConfig fConfig) throws ServletException {
		}
}
