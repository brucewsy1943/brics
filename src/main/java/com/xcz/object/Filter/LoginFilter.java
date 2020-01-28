package com.xcz.object.Filter;

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

@WebFilter(urlPatterns = {"/fun/*","/menuinfo/getObjectListByRole"}, filterName = "loginFilter")
public class LoginFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		//System.out.println("进拦截器了吗？");
		if(req.getSession().getAttribute("user")==null){
			//System.out.println("1111111111111");
			// 未登录，给出错误信息，
			req.getSession().setAttribute("msg","无权限请先登录");
		
            // 获取request返回页面到登录页
			//req.getRequestDispatcher("/brics/login.jsp").forward(req, resp);
			resp.sendRedirect("/brics/login.jsp");
			//return;
			
		}else{
			//System.out.println("2222222222222");
			chain.doFilter(req, resp);
		}
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
