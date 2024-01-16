package com.Tripsite.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.Tripsite.dto.ReviewDTO;
import com.Tripsite.mapper.ReviewMapper;

@Service
public class ReviewService {
	ReviewMapper mapper;

	public ReviewService(ReviewMapper mapper) {
		this.mapper = mapper;
	}

	public List<ReviewDTO> selectAllreview(int pageNo) {
		return mapper.selectAllreview(pageNo);
	}

	public int countreview() {
		return mapper.countreview();
	}
	
	
}
