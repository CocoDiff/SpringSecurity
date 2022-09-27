package kr.co.page.main.service.impl;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.co.page.main.BoardVo;
import kr.co.page.main.UserDetailsVO;

@Mapper("mainMapper")
public interface MainMapper {
	public List<BoardVo> list();

	public BoardVo getPost(int boardno);
	
	public void create(BoardVo vo);
	
	public void delete(int boardno);
	
	public int getPostCnt();

	public List<BoardVo> testjson(int nowPage);

	public int totalCnt();

	

}
