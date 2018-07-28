package org.lotte.dotcom.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginCheckInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("***********핸들러 인터셉터 실행************"+request.getRequestURI());
		HttpSession session=request.getSession(false);
		if(session != null && session.getAttribute("memberVO")!=null){
			return true;
		}else{
			response.sendRedirect(request.getContextPath()+"/sessionInvalidate.do");
			return false;
		}
	}
}
