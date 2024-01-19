package com.Tripsite.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.Tripsite.dto.QnaDTO;
import com.Tripsite.dto.CommentDTO;
import com.Tripsite.dto.FileDTO;
import com.Tripsite.dto.MemberDTO;
import com.Tripsite.service.CommentService;
import com.Tripsite.service.MemberService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import com.Tripsite.dto.ReviewDTO;
import com.Tripsite.service.QnaService;
import com.Tripsite.service.ReviewService;
import com.Tripsite.vo.PagginVO;


@Controller
public class MainController {
	private ReviewService reviewService;
	private MemberService memberService;
	private QnaService qnaService;
	private CommentService commentService;

	public MainController(ReviewService reviewService, MemberService memberService, QnaService qnaService,
			CommentService commentService) {
		this.reviewService = reviewService;
		this.memberService = memberService;
		this.qnaService = qnaService;
		this.commentService = commentService;
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
	@RequestMapping("/search")
	public ModelAndView searchpage(ModelAndView view) {
		view.setViewName("search");
		return view;
	}
	
	@GetMapping("/search/country")
	public ModelAndView searchresult(ModelAndView view) {
		view.setViewName("country_page");
		return view;
	}
	
	@RequestMapping("/main/login")
	public ModelAndView loginpage(ModelAndView view) {
		view.setViewName("login");
		return view;
	}
	@PostMapping("/main/login")
	 public String login(String mId, String mPass, HttpSession session) {
		
	    MemberDTO dto = memberService.login(mId, mPass);
	    if(dto == null) 
//	    	session.setAttribute("msg", "아이디와 비밀번호 다시 확인해주세요");
//	    	session.setAttribute("url", "/main/login");
//	    	return "alert";
	    
	    	return "redirect:/main/login";
	    session.setAttribute("member", dto);

	    return "redirect:/main";
	  }
	@RequestMapping("/main/findpass")
	public ModelAndView findpage(ModelAndView view) {
		view.setViewName("findpass");
		return view;
	}
	@PostMapping("/main/findpass1")
	 public String find(String mId, String mName, HttpSession session) {
		
	    MemberDTO Dto = memberService.find(mId, mName);
	    if(Dto == null) {
	    	return "redirect:/main/findpass";	    	
	    }
	    
	    session.setAttribute("findMember", Dto);

	    return "redirect:/main/findpass";
	  }
	@RequestMapping("/passout")
	public ModelAndView passout(HttpSession session) {
		session.invalidate();
		ModelAndView mv = new ModelAndView("redirect:/main/login");
		return mv;
	}
	@RequestMapping("/main/logout")
	public String logoutpage(HttpSession session) {
		session.removeAttribute("member");
		return "redirect:/main";
	}

	@RequestMapping("/main/register")
	public ModelAndView registerpage(ModelAndView view) {
		view.setViewName("register");
		return view;
	}
	
	@RequestMapping("/cscenter")
	public ModelAndView cscenterpage(ModelAndView view) {
		view.setViewName("cscenter");
		return view;
	}
	@RequestMapping("/cscenter/csnotice")
	public ModelAndView csnoticepage(ModelAndView view) {
		view.setViewName("cscenter_notice");
		return view;
	}
	@RequestMapping("/cscenter/csQnA")
	public ModelAndView csQnApage(ModelAndView view) {
		view.setViewName("cscenter_QnA");
		return view;
	}
	@RequestMapping("/cscenter/cschat")
	public ModelAndView cschatpage(ModelAndView view) {
		view.setViewName("cscenter_chat");
		return view;
	}
	@RequestMapping("/cscenter/csinquiry")
	public ModelAndView csinquirypage(ModelAndView view) {
		view.setViewName("cscenter_inquiry");
		return view;
	}
		
		@PostMapping("/cscenter/write")
		public String csWrite(QnaDTO qna, HttpSession session, MultipartFile[] file) {

			MemberDTO member = (MemberDTO) session.getAttribute("member");
			qna.setqId(member.getmId());
			
			// 파일 업로드할 경로 설정
			File root = new File("c:\\fileupload");
			if (!root.exists())
				root.mkdirs();
			
			try {
				ArrayList<FileDTO> list = new ArrayList<FileDTO>();
				for(int i=0;i<file.length;i++) {
					if (file[i].getSize() == 0)
						continue;
					//실제 파일 저장하는 부분
					File f = new File(root, file[i].getOriginalFilename());
					file[i].transferTo(f); 
					//list에 파일 정보 한건씩 추가
					list.add(new FileDTO(0,i,f.getAbsolutePath()));
				} 


				int qno = qnaService.selectQnaNo();
				qna.setqNo(qno);
				//	2. QnaDTO에 게시글 번호 저장 후 DB에 저장
				qnaService.insertQna(qna);
				//파일 정보를 DB에 저장
				list.forEach((e) -> e.setQno(qno));
				qnaService.insertFile(list);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "redirect:/mypage/inquiry";
		}
		//파일 다운로드 처리
		@RequestMapping("/file/down")
		public void fileDown(int qno, int fno, HttpServletResponse response) {
			//파일 정보 읽어옴
			FileDTO dto = qnaService.selectFile(qno, fno);
			File file = new File(dto.getPath());
			
			//출력 스트림 연결 데이터를 전송
			response.setHeader("Content-Disposition", "attachement;fileName=" + file.getName());
			response.setHeader("Content-Transfer-Encoding", "binary");
			response.setContentLength((int) file.length());
			
			 try (
					    BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
					    FileInputStream fis = new FileInputStream(file);
			    ){
			    	byte[] buffer = new byte[1024*1024];
			    	
			    	while(true) {
			    		int count = fis.read(buffer);
			    		if(count == -1) break;
			    		bos.write(buffer,0,count);
			    		bos.flush();
			    	
			    }
				} catch (IOException e) {
					e.printStackTrace();
				}
				    
			
		}
		@RequestMapping("/editer/upload")
		public ResponseEntity<String> editerFileUpload(MultipartFile upload){
			// 파일 업로드할 경로 설정
			File root = new File("c:\\resouce_upload");
			if (!root.exists())
				root.mkdirs();
			
			HashMap<String, Object> map = new HashMap<String, Object>();

			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
				String date = sdf.format(Calendar.getInstance().getTime());
				// 원본파일명
				String originFileName = upload.getOriginalFilename();
				// 저장할 파일명
				String fileName = date + "_" + originFileName.substring(originFileName.lastIndexOf('.'));
				
				File f = new File(root, fileName);
				upload.transferTo(f);
				
				int fno = qnaService.selectImageFileNo();
				qnaService.insertImageFile(new FileDTO(0, fno, f.getAbsolutePath()));
				
				map.put("uploaded", true);
				map.put("url", "/editer/filedown?fno="+fno);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
				map.put("uploaded", false);
				map.put("mesaage", "파일 업로드 중 에러 발생");
				return new ResponseEntity(map, HttpStatus.INTERNAL_SERVER_ERROR);
			} 
			
			return new ResponseEntity(map,HttpStatus.OK);
		}
		@RequestMapping("/editer/filedown")
		public void imageFileDownload(int fno, HttpServletResponse response) {
			//파일 정보 읽어옴
					FileDTO dto = qnaService.selectImageFile(fno);
					File file = new File(dto.getPath());
					
					//출력 스트림 연결 데이터를 전송
					response.setHeader("Content-Disposition", "attachement;fileName=" + file.getName());
					response.setHeader("Content-Transfer-Encoding", "binary");
					response.setContentLength((int) file.length());
					
					 try (
							    BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
							    FileInputStream fis = new FileInputStream(file);
					    ){
					    	byte[] buffer = new byte[1024*1024];
					    	
					    	while(true) {
					    		int count = fis.read(buffer);
					    		if(count == -1) break;
					    		bos.write(buffer,0,count);
					    		bos.flush();
					    	
					    }
						} catch (IOException e) {
							e.printStackTrace();
						}
						    
			
		}
	
	
	
	
	
	@RequestMapping("/mypage")
	public ModelAndView mypage(ModelAndView view) {
		view.setViewName("mypage");
		return view;
	}
	@RequestMapping("/review")
	public ModelAndView reviewpage(ModelAndView view,@RequestParam(name="pageNo",defaultValue = "1") int pageNo) {
		List<ReviewDTO> reviewlist=reviewService.selectAllreview(pageNo);
		int count = reviewService.countreview();
		PagginVO pagging = new PagginVO(count, pageNo, 10, 5);
		view.addObject("pagging", pagging);
		view.addObject("reviewlist", reviewlist);
		view.setViewName("review");
		return view;
	}
	
	@PostMapping("/review/comment")
	public String boardComment(CommentDTO comment, HttpSession session) {
		//댓글 db에 저장
		System.out.println(comment);
		MemberDTO member=(MemberDTO)session.getAttribute("member");
		comment.setcId(member.getmId());
		
		//db에 저장
		int result =commentService.registercomment(comment);
		return "redirect:/review/"+comment.getrNo();
	}
	
	@RequestMapping("/review/{rno}")
	public ModelAndView selectreviewpage(ModelAndView view,@PathVariable(name="rno") int rno) {
		reviewService.upcount(rno);
		ReviewDTO dto=reviewService.selectreviewcontent(rno);
		List<CommentDTO> commentlist=commentService.getcomment(rno);
		List<FileDTO> filelist=reviewService.getfilelist(rno);
		int commentcount=commentService.countcomment(rno);
 		view.addObject("filelist", filelist);
		view.addObject("commentlist", commentlist);
		view.addObject("review", dto);
		view.addObject("commentcount", commentcount);
		view.setViewName("review_click_result_page");
		return view;
	}
	
	@RequestMapping("/member/delete")
	public String deleteMember(String mId) {
	memberService.deleteMember(mId);
	return "redirect:/main";
	}
	
	@GetMapping("/member/Update")
	public ModelAndView updateMemberView(String mId, ModelAndView view) {
		MemberDTO dto = memberService.selectMember(mId);
		view.setViewName("change");
		view.addObject("dto", dto);
		return view;
	}


	@PostMapping("/member/Update")
	public String updateMember(MemberDTO dto) {
		System.out.println(dto.toString());
		memberService.updateMember(dto);
	return "redirect:/main";
	}
	@RequestMapping("/review/write")
	public ModelAndView writepage(ModelAndView view) {
		view.setViewName("write");
		return view;
	}

	@RequestMapping("/main/comment")
	public ModelAndView commentpage(ModelAndView view) {
		view.setViewName("comment");
		return view;
	}
	@RequestMapping("/mypage/inquiry")
	public ModelAndView inquirypage(ModelAndView view,@RequestParam(name="pageNo",defaultValue = "1") int pageNo,HttpSession session) {
		MemberDTO member=(MemberDTO)session.getAttribute("member");
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

	@RequestMapping("/review{rno}/like/login")
	public ModelAndView reviewlikelogin(ModelAndView view,  @PathVariable(name="rno") int rno) {
		view.addObject("rno", rno);
		view.setViewName("login");
		return view;
	}
	
	
	@PostMapping("/member/insert")
	public String insertMember(MemberDTO dto) {
	        memberService.insertMember(dto);
	        return "redirect:/main";
	}
	@RequestMapping("/mypage/myreview")
	public ModelAndView myreviewpage(ModelAndView view,@RequestParam(name="pageNo",defaultValue = "1") int pageNo, HttpSession session) {
		MemberDTO member=(MemberDTO)session.getAttribute("member");
		String mId=member.getmId();
		System.out.println(member.getmId());
		List<ReviewDTO> reviewlist=reviewService.selectmyreview(mId,pageNo);
		int count = reviewService.countmyreview(mId);
		PagginVO pagging = new PagginVO(count, pageNo, 10, 5);
		view.addObject("pagging", pagging);
		view.addObject("reviewlist", reviewlist);
		view.setViewName("mypage_myreview");
		return view;
	}
	
	
	
	@RequestMapping("/mypage/mycomment")
	public ModelAndView mycommentpage(ModelAndView view,@RequestParam(name="pageNo",defaultValue = "1") int pageNo, HttpSession session) {
		MemberDTO member=(MemberDTO)session.getAttribute("member");
		String mId=member.getmId();
		System.out.println(member.getmId());
		List<CommentDTO> commentlist=commentService.selectmycomment(mId,pageNo);
		System.out.println(commentlist.toString());
		int count = commentService.countmycomment(mId);
		PagginVO pagging = new PagginVO(count, pageNo, 10, 5);
		view.addObject("pagging", pagging);
		view.addObject("commentlist", commentlist);
		view.setViewName("mypage_mycomment");
		return view;
	}
	  @RequestMapping("/mypage/myreview/delete/{rno}")
	  public String deletereview(@PathVariable(name="rno") int rno, HttpSession session) {
		  MemberDTO dto = (MemberDTO) session.getAttribute("member");
		  String rId=dto.getmId();
		  reviewService.deleteReview(rno,rId);
		    return "redirect:/mypage/myreview";
	  }
	
	  @RequestMapping("/mypage/myreview/update/{rno}")
	  public String updatereview(@PathVariable(name="rno") int rno, HttpSession session) {
		  MemberDTO dto = (MemberDTO) session.getAttribute("member");
		  String rId=dto.getmId();
		    return "redirect:/mypage/myreview";
	  }
	  
	  @RequestMapping("/mypage/mycomment/delete/{cNo}")
	  public String deletecomment(@PathVariable(name="cNo") int cNo, HttpSession session) {
		  MemberDTO dto = (MemberDTO) session.getAttribute("member");
		  String cId=dto.getmId();
		  commentService.deleteComment(cNo,cId);
		    return "redirect:/mypage/mycomment";
	  }
	
	  @RequestMapping("/mypage/mycomment/update/{cNo}")
	  public String updatecomment(@PathVariable(name="cNo") int cNo, HttpSession session) {
		  MemberDTO dto = (MemberDTO) session.getAttribute("member");
		  String cId=dto.getmId();
		    return "redirect:/mypage/mycomment";
	  }
	
		@RequestMapping("/review/like")
		public ResponseEntity<String> boardlike(int rno, HttpSession session) {
			MemberDTO dto= (MemberDTO) session.getAttribute("member");
			HashMap<String, Object> map= new HashMap<String,Object>();
			try {
				reviewService.reviewlikeup(dto.getmId(),rno);
				map.put("msg","해당 게시글에 좋아요를 하셨습니다.");
				
			}catch(Exception e){
				//이미 좋아요 처리가 된 경우이기 때문에 해당 데이터를 삭제해서 좋아요 처리를 해제
				reviewService.reviewlikedown(dto.getmId(),rno);
				map.put("msg","해당 게시글에 좋아요를 취소 하셨습니다.");
			}
			//해당 게시글 좋아요 개수 받아옴
			int count=reviewService.reviewtotallike(rno);
			map.put("count",count);
			return new ResponseEntity(map,HttpStatusCode.valueOf(HttpStatus.OK.value()));
			
		}
		@RequestMapping("/review/hate")
		public ResponseEntity<String> boardhate(int rno, HttpSession session) {
			MemberDTO dto= (MemberDTO) session.getAttribute("member");
			HashMap<String, Object> map= new HashMap<String,Object>();
			try {
				reviewService.reviewhateup(dto.getmId(),rno);
				map.put("msg","해당 게시글에 싫어요를 하셨습니다.");
				
			}catch(Exception e){
				//이미 좋아요 처리가 된 경우이기 때문에 해당 데이터를 삭제해서 좋아요 처리를 해제
				reviewService.reviewhatedown(dto.getmId(),rno);
				map.put("msg","해당 게시글에 싫어요를 취소 하셨습니다.");
			}
			//해당 게시글 좋아요 개수 받아옴
			int count=reviewService.reviewtotalhate(rno);
			map.put("count",count);
			return new ResponseEntity(map,HttpStatusCode.valueOf(HttpStatus.OK.value()));
			
		}
		@RequestMapping("/review/comment/like")
		public ResponseEntity<String> commentlike(int cNo, HttpSession session) {
			MemberDTO dto= (MemberDTO) session.getAttribute("member");
			HashMap<String, Object> map= new HashMap<String,Object>();
			try {
				commentService.commentlikeup(dto.getmId(),cNo);
				map.put("msg","해당 댓글에 좋아요를 하셨습니다.");
				
			}catch(Exception e){
				//이미 좋아요 처리가 된 경우이기 때문에 해당 데이터를 삭제해서 좋아요 처리를 해제
				commentService.commentlikedown(dto.getmId(),cNo);
				map.put("msg","해당 댓글에 좋아요를 취소 하셨습니다.");
			}
			//해당 게시글 좋아요 개수 받아옴
			int count=commentService.commenttotallike(cNo);
			map.put("count",count);
			return new ResponseEntity(map,HttpStatusCode.valueOf(HttpStatus.OK.value()));
			
		}
		@RequestMapping("/review/comment/hate")
		public ResponseEntity<String> commenthate(int cNo, HttpSession session) {
			MemberDTO dto= (MemberDTO) session.getAttribute("member");
			HashMap<String, Object> map= new HashMap<String,Object>();
			try {
				commentService.commenthateup(dto.getmId(),cNo);
				map.put("msg","해당 댓글에 싫어요를 하셨습니다.");
				
			}catch(Exception e){
				//이미 좋아요 처리가 된 경우이기 때문에 해당 데이터를 삭제해서 좋아요 처리를 해제
				commentService.commenthatedown(dto.getmId(),cNo);
				map.put("msg","해당 댓글에 싫어요를 취소 하셨습니다.");
			}
			//해당 게시글 좋아요 개수 받아옴
			int count=commentService.commenttotalhate(cNo);
			map.put("count",count);
			return new ResponseEntity(map,HttpStatusCode.valueOf(HttpStatus.OK.value()));
			
		}
	  
	  
	  
}