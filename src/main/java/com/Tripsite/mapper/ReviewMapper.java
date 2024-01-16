package com.Tripsite.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.Tripsite.dto.ReviewDTO;

@Mapper
public interface ReviewMapper {

	List<ReviewDTO> selectAllreview(int pageNo);

	int countreview();

}
