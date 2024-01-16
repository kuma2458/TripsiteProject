package com.Tripsite.service;

import org.springframework.stereotype.Service;

import com.Tripsite.mapper.ReviewMapper;

@Service
public class ReviewService {
	ReviewMapper mapper;

	public ReviewService(ReviewMapper mapper) {
		this.mapper = mapper;
	}
	
	
}
