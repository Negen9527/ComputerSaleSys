package com.scs.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet Filter implementation class HtmlFilter
 */
@WebFilter("/HtmlFilter")
public class HtmlFilter implements Filter {

    /**
     * Default constructor. 
     */
    public HtmlFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// place your code here
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		String reqUri = req.getRequestURL().toString();
		if(reqUri.contains(".html") && !reqUri.contains("login.html")) {
			List<String> sessionIds = (List<String>)req.getSession().getAttribute("sessionIds");
//			for (String string : sessionIds) {
//				System.out.println(string);
//			}
			if(null == sessionIds) {
				
				resp.sendRedirect("login.html");
			}else {
				//已登陆
				String cSessionId = req.getSession().getId();
				if(!sessionIds.contains(cSessionId)) {
					resp.sendRedirect("login.html");
				}
			}
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
