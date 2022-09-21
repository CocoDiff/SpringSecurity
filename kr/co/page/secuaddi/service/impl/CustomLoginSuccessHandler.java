package kr.co.page.secuaddi.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

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
		
		//아직 admin 권한은 안 만듦. user 페이지로 redirect하는 기능 만들기 #하지만 지금은 main으로
		if(roleNames.contains("ROLE_USER")) {
			response.sendRedirect("/main.do");
			return;
		}
		
	}
}
