package kr.co.page.secuaddi.service.impl;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.web.filter.GenericFilterBean;

public class SecurityContextPersistanceFilter extends GenericFilterBean{
	
	static final String FILTER_APPLIED = "__spring_security_scpf_applied";
	
	private SecurityContextRepository repo;
	
	private SecurityContextHolderStrategy SecurityContextHolderStrategy = SecurityContextHolder.getContextHolderStrategy();
	
	private boolean forceEagerSessionCreation = false;
	
	public  SecurityContextPersistanceFilter() {
		// TODO Auto-generated constructor stub
		this(new HttpSessionSecurityContextRepository());
	}
	
	public SecurityContextPersistanceFilter(SecurityContextRepository repo) {
		this.repo = repo;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		doFilter((HttpServletRequest) request, (HttpServletResponse) response, chain);
		
	}
	
	private void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if(request.getAttribute(FILTER_APPLIED) != null) {
			chain.doFilter(request, response);
			return;
		}
		request.setAttribute(FILTER_APPLIED, Boolean.TRUE);
		
		if(this.forceEagerSessionCreation) {
			HttpSession session = request.getSession();
			
			if(this.logger.isDebugEnabled() && session.isNew()) {
				/*this.logger.debug(LogMessage.format);*/
			}
		}
	}

}
