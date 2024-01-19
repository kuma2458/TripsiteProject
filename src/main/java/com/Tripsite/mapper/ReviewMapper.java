package com.Tripsite.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.Tripsite.dto.CommentDTO;
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



}
