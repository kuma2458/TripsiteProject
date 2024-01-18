package com.Tripsite.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.Tripsite.dto.CommentDTO;

@Mapper
public interface CommentMapper {
	List<CommentDTO> selectmycomment(HashMap<String, Object> map);

	int countmycomment(String mId);
<<<<<<< Updated upstream
=======

	List<CommentDTO> getcomment(int rno);

	int countcomment(int rno);

	int registercomment(CommentDTO comment);
>>>>>>> Stashed changes
}
