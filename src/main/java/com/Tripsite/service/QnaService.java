package com.Tripsite.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Tripsite.dto.QnaDTO;
import com.Tripsite.mapper.QnaMapper;

@Service
public class QnaService {

	private QnaMapper mapper;

	public QnaService(QnaMapper mapper) {
		this.mapper = mapper;
	}

	public int countQna() {
		return mapper.countQna();
	}

	public List<QnaDTO> selectMyQna(String mId, int pageNo) {
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("mId", mId);
		map.put("pageNo", pageNo);
		return mapper.selectMyQna(map);
	}
	
	
	
}
