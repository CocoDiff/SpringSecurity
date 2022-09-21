package kr.co.page.main.web;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.page.main.BoardVo;
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
		return model;
	}
	
	//게시물 view
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
	
	//form-login의 get방식 uri
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public void login(String error, String logout, Model model) {
		
		if(error != null) {
			model.addAttribute("error", "로그인 에러");
			model.addAttribute("logout", "로그아웃 되었습니다.");
		}
	}
	
	
	@RequestMapping(value="accessDenied")
	public String loginDeny() {
		System.out.println("권한이 없는 사용자입니다.");
		return "redirect:main";
	}
	
	@RequestMapping(value="/logout")
	public void customLogout() { }
	
	
/*	@RequestMapping(value="/test.do")
	public String test() {
		System.out.println(shaPasswordEncoder.encodePassword("password", "yeji"));
		return "redirect:/main.do";
	}*/
}
