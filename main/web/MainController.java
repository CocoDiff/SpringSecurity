package kr.co.page.main.web;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.page.main.BoardVo;
import kr.co.page.main.PagingVo;
import kr.co.page.main.UserDetailsVO;
import kr.co.page.main.service.MainService;
import kr.co.page.secuaddi.service.impl.SecurityServiceImpl;

@Controller
public class MainController {
	
	@Autowired
	private ShaPasswordEncoder shaPasswordEncoder;
	
	@Resource(name="mainService")
	public MainService service;
	
	@Resource(name="secService")
	public SecurityServiceImpl serviceimpl;
	
	@RequestMapping(value="/main.do", method=RequestMethod.GET)
	public ModelAndView main() {
		ModelAndView model = new ModelAndView();
		model.addObject("list", service.list());
		System.out.println("메인페이지");
		model.setViewName("main");
		return model;
	}
	

	//게시물 
	@RequestMapping(value="/viewPost.do", method=RequestMethod.GET)
	public ModelAndView viewPost(int boardno) {
		ModelAndView model = new ModelAndView("post");
		model.addObject("post", service.getPost(boardno));
		return model;
	}
	
	//create 페이지로 이동해주는 메소드
	@RequestMapping(value="/create.do", method=RequestMethod.GET)
	public String goCreate() {
		return "create";
	}
	
	@RequestMapping(value="/create.do", method=RequestMethod.POST)
	public String create(BoardVo vo) {
		service.create(vo);
		return "redirect:/main.do";
	}
	
	//수정하는 부분
	@RequestMapping(value="/update.do")
	public ModelAndView viewUdate(int boardno) {
		ModelAndView model = new ModelAndView("update"); 
		model.addObject("update", service.getPost(boardno));
		return model;
	}
	
	@RequestMapping(value="/delete.do", method=RequestMethod.POST)
	public String postDelete(int boardno) {
		service.delete(boardno);
		return "redirect:/main.do";
	}
	
	//paging
	@RequestMapping(value="/request.do", method=RequestMethod.GET)
	public ModelAndView jsonview(int nowPage) {
		ModelAndView mv = new ModelAndView("jsonView");
		
		int count = service.totalCnt();
		
		PagingVo vo = new PagingVo(nowPage, count);
		List<BoardVo> boardVo = service.testjson(vo.getNowPage());
		
		mv.addObject("paging", vo);
		mv.addObject("list", boardVo);
		
		return mv;
	}
	
	/****************************************************/
	/* ******************* Security ******************* */
	/****************************************************/
	@RequestMapping(value="/signUp.do", method=RequestMethod.GET)
	public String singupPage() {
		return "signUp";
	}
	
	@RequestMapping(value="/signUp.do", method=RequestMethod.POST)
	public String singUpPage(UserDetailsVO vo, String username, String password) {
		serviceimpl.signup(vo);
		String newPassword = shaPasswordEncoder.encodePassword(username, password);
		vo.setPassword(newPassword);
		System.out.println(newPassword);
		return "redirect:/login.do";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginPage(String error, String logout, Model model) {
		System.out.println("로그인 페이지");
		return "login";
	}
	
	//form-login의 get방식 uri 여기가 문제니까 점심 먹고 고치장!!!!!
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(String error, String logout, Model model) {
		
		//ModelAndView model = new ModelAndView();
		if(error != null) {
			System.out.println(error);
			model.addAttribute(error, "로그인 에러");
			model.addAttribute(logout, "로그아웃 되었습니다.");
			
			return "redirect:login.do";
		}else
			return "main";
	}
	
	
	@RequestMapping(value="accessDenied")
	public String loginDeny() {
		System.out.println("권한이 없는 사용자입니다.");
		return "redirect:main";
	}
	
	@RequestMapping(value="/logout.do")
	public String customLogout(String cookie) {
		return "login";
	}
	
	
/*	@RequestMapping(value="/test.do")
	public String test() {
		System.out.println(shaPasswordEncoder.encodePassword("password", "yeji"));
		return "redirect:/main.do";
	}*/
}
