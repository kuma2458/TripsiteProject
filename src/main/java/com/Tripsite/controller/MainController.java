package com.Tripsite.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Tripsite.dto.MemberDTO;
import com.Tripsite.service.MemberService;


import jakarta.servlet.http.HttpSession;
import com.Tripsite.dto.ReviewDTO;
import com.Tripsite.service.ReviewService;
import com.Tripsite.vo.PagginVO;


@Controller
public class MainController {
	private MemberService service;
	private ReviewService reviewService;
	

	public MainController(MemberService service, ReviewService reviewService) {
		this.service = service;
		this.reviewService = reviewService;
	}


	public MainController() {
	}


	@RequestMapping("/")
	public ModelAndView index(ModelAndView view) {
		view.setViewName("main_page");
		return view;
	}
	@RequestMapping("/main")
	public ModelAndView mainpage(ModelAndView view) {
		view.setViewName("main_page");
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
	@RequestMapping("/main/mypage")
	public ModelAndView mypage(ModelAndView view) {
		view.setViewName("mypage");
		return view;
	}
	@RequestMapping("/main/review")
	public ModelAndView reviewpage(ModelAndView view,@RequestParam(name="pageNo",defaultValue = "1") int pageNo) {
		List<ReviewDTO> reviewlist=reviewService.selectAllreview(pageNo);
		int count = reviewService.countreview();
		PagginVO pagging = new PagginVO(count, pageNo, 10, 5);
		view.addObject("pagging", pagging);
		view.addObject("reviewlist", reviewlist);
		view.setViewName("review");
		System.out.println(pagging.getStartPageOfPageGroup() + " "+pagging.getEndPageOfPageGroup());
		return view;
	}
	@RequestMapping("/main/change")
	public ModelAndView chagepage(ModelAndView view) {
		view.setViewName("change");
		return view;
	}
	@RequestMapping("/main/inquiry")
	public ModelAndView inquirypage(ModelAndView view) {
		view.setViewName("inquiry");
		return view;
	}

	@PostMapping("/member/insert")
	public String insertMember(MemberDTO dto) {
		System.out.println(dto);
	        service.insertMember(dto);
	        return "redirect:/main";

	}

}