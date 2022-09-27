package kr.co.page.secuaddi.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SecurityInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("인터셉터입니다.");
		//사용자가 어떤 권한을 가지고 있는지 알 수 있음 3겹으로 쌓여있음
		SecurityContext context = SecurityContextHolder.getContext();
		//권한 알아오기 권한안에 권한
		String hi = context.getAuthentication().getAuthorities().toArray()[0].toString();
		System.out.println(hi);
		System.out.println(request.getRequestURI().toString());
		return super.preHandle(request, response, handler);
	}
	
}
