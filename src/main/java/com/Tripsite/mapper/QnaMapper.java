package com.Tripsite.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.Tripsite.dto.FileDTO;
import com.Tripsite.dto.QnaDTO;

@Mapper
public interface QnaMapper {

	int countQna();
	List<QnaDTO> selectMyQna(HashMap<String, Object> map);
	
	int selectQnaNo();

	int insertQna(QnaDTO qna);

	int insertFile(FileDTO e);

	FileDTO selectFile(HashMap<String, Object> map);

	int selectImageFileNo();

	int insertImageFile(FileDTO fileDTO);

	FileDTO selectImageFile(int fno);
	List<FileDTO> getfilelist(int qno);
	QnaDTO selectqnacontent(int qNo);
	int deleteReview(HashMap<String, Object> map);
}
