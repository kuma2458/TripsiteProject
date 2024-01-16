package com.Tripsite.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Tripsite.dto.MemberDTO;
import com.Tripsite.service.MemberService;


import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	private MemberService service;
	
	
	
	
	public MainController(MemberService service) {
		
		this.service = service;
	}
	@RequestMapping("/")
	public ModelAndView index(ModelAndView view) {
		view.setViewName("main-page");
		return view;
	}
	@RequestMapping("/main")
	public ModelAndView mainpage(ModelAndView view) {
		view.setViewName("main-page");
		return view;
	}
	@RequestMapping("/main/search")
	public ModelAndView searchpage(ModelAndView view) {
		view.setViewName("main_page");
		return view;
	}
	
	@GetMapping("/main/searchresult")
	public ModelAndView searchresult(ModelAndView view) {
		view.setViewName("search_result_page");
		return view;
	}
	
	@RequestMapping("/main/login")
	public ModelAndView loginpage(ModelAndView view) {
		view.setViewName("login");
		return view;
	}
	
	@RequestMapping("/main/logout")
	public ModelAndView logoutpage(ModelAndView view) {
		view.setViewName("main-page logout");
		return view;
	}
	
	@PostMapping("/main/login")
	 public String login(String mId, String mPass, HttpSession session) {
		
	    MemberDTO dto = service.login(mId, mPass);
	    if(dto == null) 
//	    	session.setAttribute("msg", "아이디와 비밀번호 다시 확인해주세요");
//	    	session.setAttribute("url", "/main/login");
//	    	return "alert";
	    
	    	return "redirect:/main/login";
	    session.setAttribute("member", dto);

	    return "redirect:/main/logout";
	  }
	
	@RequestMapping("/main/register")
	public ModelAndView registerpage(ModelAndView view) {
		view.setViewName("register");
		return view;
	}
	
	@RequestMapping("/main/notice")
	public ModelAndView noticerpage(ModelAndView view) {
		view.setViewName("notice");
		return view;
	}
	@RequestMapping("/main/cscenter")
	public ModelAndView cscenterpage(ModelAndView view) {
		view.setViewName("cscenter");
		return view;
	}
	@RequestMapping("/main/csnotice")
	public ModelAndView csnoticepage(ModelAndView view) {
		view.setViewName("cscenter_notice");
		return view;
	}
	@RequestMapping("/main/csQnA")
	public ModelAndView csQnApage(ModelAndView view) {
		view.setViewName("cscenter_QnA");
		return view;
	}
	@RequestMapping("/main/cschat")
	public ModelAndView cschatpage(ModelAndView view) {
		view.setViewName("cscenter_chat");
		return view;
	}
	@RequestMapping("/main/csinquiry")
	public ModelAndView csinquirypage(ModelAndView view) {
		view.setViewName("cscenter_inquiry");
		return view;
	}
	@RequestMapping("/main/mypage")
	public ModelAndView mypage(ModelAndView view) {
		view.setViewName("mypage");
		return view;
	}
	@RequestMapping("/main/review")
	public ModelAndView reviewpage(ModelAndView view) {
		view.setViewName("review");
		return view;
	}
	@RequestMapping("/main/change")
	public ModelAndView chagepage(ModelAndView view) {
		view.setViewName("change");
		return view;
	}
	@RequestMapping("/main/write")
	public ModelAndView writepage(ModelAndView view) {
		view.setViewName("write");
		return view;
	}
	
	@RequestMapping("/main/comment")
	public ModelAndView commentpage(ModelAndView view) {
		view.setViewName("comment");
		return view;
	}
	@RequestMapping("/main/inquiry")
	public ModelAndView inquirypage(ModelAndView view) {
		view.setViewName("inquiry");
		return view;
	}
	

}
