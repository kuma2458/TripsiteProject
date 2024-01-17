package com.Tripsite.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import org.apache.ibatis.annotations.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.Tripsite.dto.MemberDTO;
import com.Tripsite.dto.QnaDTO;
import com.Tripsite.service.MemberService;
import com.Tripsite.service.QnaService;

import com.Tripsite.dto.FileDTO;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	private MemberService service;
	private QnaService QnaService;
	
	
	
	public MainController(MemberService service, QnaService qnaService) {
		this.QnaService = qnaService;
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
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		ModelAndView mv = new ModelAndView("redirect:/main");
		return mv;
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

	    return "redirect:/main";
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
	@RequestMapping("/main/csinquiry/view")
	public ModelAndView csinquirypage(ModelAndView view) {
		view.setViewName("cscenter_inquiry");
		return view;
	}
	@RequestMapping("/main/cscenter_inquiry")
	public ModelAndView csinquiry(ModelAndView view) {
		view.setViewName("cscenter_inquiry");
		return view;
	}
		@RequestMapping("/main/csinquiry")
		public String csInquiry(HttpSession session) {

			MemberDTO member = (MemberDTO) session.getAttribute("member");
			
//			if(member == null) 
//				return "redirect:/main/cscenter";
					
			return "redirect:/main/cscenter_inquiry";
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


	int qno = QnaService.selectQnaNo();
				qna.setqNo(qno);
				//	2. QnaDTO에 게시글 번호 저장 후 DB에 저장
				QnaService.insertQna(qna);
				//파일 정보를 DB에 저장
				list.forEach((e) -> e.setBno(qno));
				QnaService.insertFile(list);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "redirect:/main/inquiry";
		}
		//파일 다운로드 처리
		@RequestMapping("/file/down")
		public void fileDown(int qno, int fno, HttpServletResponse response) {
			//파일 정보 읽어옴
			FileDTO dto = QnaService.selectFile(qno, fno);
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
				
				int fno = QnaService.selectImageFileNo();
				QnaService.insertImageFile(new FileDTO(0, fno, f.getAbsolutePath()));
				
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
					FileDTO dto = QnaService.selectImageFile(fno);
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
