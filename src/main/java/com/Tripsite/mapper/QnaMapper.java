package com.Tripsite.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.Tripsite.dto.QnaDTO;

@Mapper
public interface QnaMapper {

	int countQna();
	List<QnaDTO> selectMyQna(HashMap<String, Object> map);
	
}
