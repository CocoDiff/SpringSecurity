package kr.co.page.secuaddi.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.co.page.main.UserDetailsVO;

@Service("secService")
public class SecurityServiceImpl implements UserDetailsService {
	
	@Resource(name="userMapper")
	private UserMapper mapper;

	@Autowired
	private ShaPasswordEncoder shaPasswordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		//사용자 정보 선택
		String userId = username;
		
		//user 정보가 있는 vo에서 user 정보를 user에 저장
		UserDetailsVO user = mapper.findUser(userId);
		
		if(user == null) {
			//user가 null(실패)라면 해당 값을 가지고 예외 처리
			throw new UsernameNotFoundException(userId);
		}
		return user;
	}
	public void signup(UserDetailsVO vo) {
		vo.setPassword(shaPasswordEncoder.encodePassword(vo.getPassword(), vo.getUsername()));	
 		mapper.signup(vo);
	}
}
