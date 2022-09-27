package kr.co.page.main.service;

import java.util.List;

import kr.co.page.main.BoardVo;
import kr.co.page.main.PagingVo;
import kr.co.page.main.UserDetailsVO;

public interface MainService {

	public List<BoardVo> list();
	
	public BoardVo getPost(int boardno);

	public void create(BoardVo vo);

	public void updatePost(BoardVo vo);

	public void delete(int boardno);
	
	public int getPostCnt();

	public List<BoardVo> testjson(int nowPage);
	
	public int totalCnt();



}
