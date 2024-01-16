package com.Tripsite.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Tripsite.dto.ReviewDTO;
import com.Tripsite.service.ReviewService;
import com.Tripsite.vo.PagginVO;

import jakarta.websocket.server.PathParam;

@Controller
public class MainController {
	
	private ReviewService reviewService;

	public MainController(ReviewService reviewService) {
		this.reviewService = reviewService;
	}
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/main";
	}
	@RequestMapping("/main")
	public ModelAndView mainpage(ModelAndView view) {
		view.setViewName("main_page");
		return view;
	}
	@RequestMapping("/main/search")
	public ModelAndView searchpage(ModelAndView view) {
		view.setViewName("search");
		return view;
	}
	
	@GetMapping("/main/country")
	public ModelAndView country_page(ModelAndView view) {
		view.setViewName("country_page");
		return view;
	}
	
	@RequestMapping("/main/login")
	public ModelAndView loginpage(ModelAndView view) {
		view.setViewName("login");
		return view;
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
	@RequestMapping("/main/cscenter/request")
	public ModelAndView cscenterrequestpage(ModelAndView view) {
		view.setViewName("customer_center_request");
		return view;
	}
	

}
