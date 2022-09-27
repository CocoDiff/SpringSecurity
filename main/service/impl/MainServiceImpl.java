package kr.co.page.main.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.page.main.BoardVo;
import kr.co.page.main.UserDetailsVO;
import kr.co.page.main.service.MainService;

@Service("mainService")
public class MainServiceImpl implements MainService{
	
	@Resource(name="mainMapper")
	public MainMapper mapper;

	@Override
	public List<BoardVo> list() {
		return mapper.list();
	}

	@Override
	public void create(BoardVo vo) {
		mapper.create(vo);
	}

	@Override
	public BoardVo getPost(int boardno) {
		return mapper.getPost(boardno);
	}

	@Override
	public void updatePost(BoardVo vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int boardno) {
		mapper.delete(boardno);
		
	}
	
	@Override
	public int getPostCnt() {
		return mapper.getPostCnt();
	}

	@Override
	public List<BoardVo> testjson(int nowPage) {
		// TODO Auto-generated method stub
		return mapper.testjson(nowPage);
	}

	@Override
	public int totalCnt() {
		// TODO Auto-generated method stub
		return mapper.totalCnt();
	}

	
	

}
