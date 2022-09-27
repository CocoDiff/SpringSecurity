package kr.co.page.secuaddi.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
			
		List<String> roleNames = new ArrayList<String>();
		
		//Authentication 객체는 인증된 대상의 정보를 담고 있다.
		//그 객체의 authority(권한)을 추출해 roleNames 리스트에 담기
		authentication.getAuthorities().forEach(authority -> {
			roleNames.add(authority.getAuthority());
		});
		
		RequestCache requestCache = new HttpSessionRequestCache();
		SavedRequest savedRequst = requestCache.getRequest(request, response);
		
		if(savedRequst != null) {
			String uri = savedRequst.getRedirectUrl();
			requestCache.removeRequest(request, response);
			System.out.println(uri);
		}
		
		Enumeration<String> list = request.getSession().getAttributeNames();
		while(list.hasMoreElements()) {
			System.out.println(list.nextElement());
		}
		
		
		//  권한이 ROLE_USER인 사용자가 로그인시 main.do로 이동
		if(roleNames.contains("ROLE_USER")) {
			response.sendRedirect("/main.do");
			return;
		}
		
		
		
		//ip, session
		WebAuthenticationDetails web = (WebAuthenticationDetails) authentication.getDetails();
		System.out.println("IP : " + web.getRemoteAddress());
		System.out.println("Session ID : " + web.getSessionId());
	}
}
