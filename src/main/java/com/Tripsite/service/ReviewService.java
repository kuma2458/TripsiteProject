package com.Tripsite.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Tripsite.dto.FileDTO;
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

	public int deleteReview(int rno, String rId) {
		HashMap<String, Object> map =new HashMap<String,Object>();
		map.put("rId", rId);
		map.put("rno", rno);
		
		return mapper.deleteReview(map);
	}

	public ReviewDTO selectreviewcontent(int rno) {
		return mapper.selectreviewcontent(rno);
	}

	public List<FileDTO> getfilelist(int rno) {
		// TODO Auto-generated method stub
		return mapper.getfilelist(rno);
	}

	public int upcount(int rno) {
		return mapper.upcount(rno);
	}

	public int reviewlikeup(String getmId, int rno) {
		HashMap<String, Object> map =new HashMap<String,Object>();
		map.put("rId", getmId);
		map.put("rno", rno);
		return mapper.reviewlikeup(map);
	}

	public int reviewlikedown(String getmId, int rno) {
		HashMap<String, Object> map =new HashMap<String,Object>();
		map.put("rId", getmId);
		map.put("rno", rno);
		return mapper.reviewlikedown(map);
	}

	public int reviewtotallike(int rno) {
		return mapper.reviewtotallike(rno);
	}

	public int reviewhateup(String getmId, int rno) {
		HashMap<String, Object> map =new HashMap<String,Object>();
		map.put("rId", getmId);
		map.put("rno", rno);
		return mapper.reviewhateup(map);
	}

	public int reviewhatedown(String getmId, int rno) {
		HashMap<String, Object> map =new HashMap<String,Object>();
		map.put("rId", getmId);
		map.put("rno", rno);
		return mapper.reviewhatedown(map);
	}

	public int reviewtotalhate(int rno) {
		return mapper.reviewtotalhate(rno);
	}


	
	
}
