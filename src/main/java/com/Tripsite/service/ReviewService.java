package com.Tripsite.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Tripsite.dto.CommentDTO;
import com.Tripsite.dto.ReviewDTO;
import com.Tripsite.mapper.ReviewMapper;

@Service
public class ReviewService {
	private ReviewMapper mapper;

	public ReviewService(ReviewMapper mapper) {
		this.mapper = mapper;
	}

	public List<ReviewDTO> selectAllreview(int pageNo) {
		return mapper.selectAllreview(pageNo);
	}

	public int countreview() {
		return mapper.countreview();
	}

	public List<ReviewDTO> selectmyreview(String mId, int pageNo) {
		HashMap<String, Object> map =new HashMap<String,Object>();
		map.put("mId", mId);
		map.put("pageNo", pageNo);
		
		return mapper.selectmyreview(map);
	}

	public int countmyreview(String mId) {
		return mapper.countmyreview(mId);
	}


	
	
}
