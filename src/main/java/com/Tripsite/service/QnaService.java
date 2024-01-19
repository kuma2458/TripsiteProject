package com.Tripsite.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Tripsite.dto.FileDTO;
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
	
	public  int selectQnaNo() {
		return mapper.selectQnaNo();
	}

	public List<FileDTO> getfilelist(int qno) {
		return mapper.getfilelist(qno);
	}
	
	public int insertQna(QnaDTO qna) {
		return mapper.insertQna(qna);
		
	}

	public  void insertFile(ArrayList<FileDTO> list) {
		list.forEach(e -> mapper.insertFile(e));
		
	}

	public FileDTO selectFile(int qno, int fno) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("qno", qno);
		map.put("fno", fno);
		return mapper.selectFile(map);
	}

	public int selectImageFileNo() {
		return mapper.selectImageFileNo();
	}

	public int insertImageFile(FileDTO fileDTO) {
		return mapper.insertImageFile(fileDTO);
		
	}

	public FileDTO selectImageFile(int fno) {
		return mapper.selectImageFile(fno);
	}
	
	
}
