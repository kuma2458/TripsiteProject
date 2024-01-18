package com.Tripsite.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Tripsite.dto.CommentDTO;
import com.Tripsite.mapper.CommentMapper;

@Service
public class CommentService {

	CommentMapper mapper;

	public CommentService(CommentMapper mapper) {
		this.mapper = mapper;
	}

	public List<CommentDTO> selectmycomment(String mId, int pageNo) {
		HashMap<String, Object> map =new HashMap<String,Object>();
		map.put("mId", mId);
		map.put("pageNo", pageNo);
		return mapper.selectmycomment(map);
	}

	public int countmycomment(String mId) {
		return mapper.countmycomment(mId);
	}
<<<<<<< Updated upstream
=======

	public List<CommentDTO> getcomment(int rno) {
		return mapper.getcomment(rno);
	}

	public int countcomment(int rno) {
		return mapper.countcomment(rno);
	}

	public int registercomment(CommentDTO comment) {
		return mapper.registercomment(comment);
	}
>>>>>>> Stashed changes
	
	
}
