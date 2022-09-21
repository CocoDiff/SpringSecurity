package kr.co.page.secuaddi.service.impl;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.co.page.main.UserDetailsVO;

@Mapper("userMapper")
public interface UserMapper {
	public UserDetailsVO findUser(String username);

	public void signup(UserDetailsVO vo);
	
}
