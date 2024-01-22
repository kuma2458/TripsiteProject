package com.Tripsite.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.Tripsite.dto.FileDTO;
import com.Tripsite.dto.ReviewDTO;

@Mapper
public interface ReviewMapper {

	List<ReviewDTO> selectAllreview(int pageNo);

	int countreview();

	List<ReviewDTO> selectmyreview(HashMap<String, Object> map);

	int countmyreview(String mId);

	int deleteReview(HashMap<String, Object> map);
	ReviewDTO selectreviewcontent(int rno);

	List<FileDTO> getfilelist(int rno);

	int upcount(int rno);

	int reviewlikeup(HashMap<String, Object> map);

	int reviewlikedown(HashMap<String, Object> map);

	int reviewtotallike(int rno);

	int reviewhateup(HashMap<String, Object> map);

	int reviewhatedown(HashMap<String, Object> map);

	int reviewtotalhate(int rno);

	int selectReviewNo();

	int insertReview(ReviewDTO review);



}
