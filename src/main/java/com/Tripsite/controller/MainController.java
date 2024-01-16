package com.Tripsite.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

<<<<<<< HEAD
import com.Tripsite.dto.QnaDTO;
=======
import com.Tripsite.dto.MemberDTO;
import com.Tripsite.service.MemberService;


import jakarta.servlet.http.HttpSession;
>>>>>>> ee993b35fdfc7ddc73a8446e54e5638539944f2c
import com.Tripsite.dto.ReviewDTO;
import com.Tripsite.dto.memberDTO;
import com.Tripsite.service.MemberService;
import com.Tripsite.service.QnaService;
import com.Tripsite.service.ReviewService;
import com.Tripsite.vo.PagginVO;

<<<<<<< HEAD
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.server.PathParam;
=======
>>>>>>> ee993b35fdfc7ddc73a8446e54e5638539944f2c

@Controller
public class MainController {
	private MemberService service;
	private ReviewService reviewService;
<<<<<<< HEAD
	private MemberService memberService;
	private QnaService qnaService;

	public MainController(ReviewService reviewService, MemberService memberService, QnaService qnaService) {
=======
	
	public MainController(MemberService service, ReviewService reviewService) {
		this.service = service;
>>>>>>> ee993b35fdfc7ddc73a8446e54e5638539944f2c
		this.reviewService = reviewService;
		this.memberService = memberService;
		this.qnaService = qnaService;
	}
<<<<<<< HEAD
=======


	public MainController() {
	}


>>>>>>> ee993b35fdfc7ddc73a8446e54e5638539944f2c
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
	@PostMapping("/main/login")
	 public String login(String mId, String mPass, HttpSession session) {
		
	    memberDTO dto = memberService.login(mId, mPass);
	    if(dto == null) 
//	    	session.setAttribute("msg", "아이디와 비밀번호 다시 확인해주세요");
//	    	session.setAttribute("url", "/main/login");
//	    	return "alert";
	    
	    	return "redirect:/main/login";
	    session.setAttribute("member", dto);

	    return "redirect:/main";
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
		return view;
	}
	@RequestMapping("/main/change")
	public ModelAndView chagepage(ModelAndView view) {
		view.setViewName("change");
		return view;
	}
	@RequestMapping("/main/inquiry")
	public ModelAndView inquirypage(ModelAndView view,@RequestParam(name="pageNo",defaultValue = "1") int pageNo,HttpSession session) {
		memberDTO member=(memberDTO)session.getAttribute("member");
		String mId=member.getmId();
		System.out.println(member.getmId());
		List<QnaDTO> qnalist=qnaService.selectMyQna(mId,pageNo);
		int count = qnaService.countQna();
		PagginVO pagging = new PagginVO(count, pageNo, 10, 5);
		view.addObject("pagging", pagging);
		view.addObject("qnalist", qnalist);
		view.setViewName("inquiry");
		return view;
	}
	

}