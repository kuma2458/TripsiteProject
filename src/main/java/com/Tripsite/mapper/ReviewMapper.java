package com.Tripsite.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.Tripsite.dto.CommentDTO;
import com.Tripsite.dto.ReviewDTO;

@Mapper
public interface ReviewMapper {

	List<ReviewDTO> selectAllreview(int pageNo);

	int countreview();

	List<ReviewDTO> selectmyreview(HashMap<String, Object> map);

	int countmyreview(String mId);



}
