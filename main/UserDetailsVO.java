package kr.co.page.main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.resource.spi.work.SecurityContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


public class UserDetailsVO implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	
	//회원의 ID, PW, 권한, email 정도만 DB에 생성
	private String username;
	private String password;
	private String authorities;
	private String email;

	//권한, GrantedAuthority 인터페이스를 구현한 SimpleGrantedAuthority에 권한 담기
	//한 계정이 복수의 권한을 가질 수 있음, 메소드 getAuthorities / 계정이 갖고 있는 권한 목록을 리턴
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		ArrayList<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
		auth.add(new SimpleGrantedAuthority(authorities));
		return auth;
	}
	
	
	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}
	
	//계정 만료, true = 만료되지 않음, false인 경우 모든 계정이 생성되자마자 만료
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	//계정 잠김, true = 계정이 잠겨있지 않음
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	//계정 패스워드 만료, true = 패스워드가 만료되지 않음
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	//사용 가능한 계정인지, true = 사용가능한 계정
	@Override
	public boolean isEnabled() {
		return true;
	}

	//getter, setter
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}
}
