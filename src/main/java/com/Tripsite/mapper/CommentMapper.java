package com.Tripsite.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.Tripsite.dto.CommentDTO;

@Mapper
public interface CommentMapper {
	List<CommentDTO> selectmycomment(HashMap<String, Object> map);

	int countmycomment(String mId);

	List<CommentDTO> getcomment(int rno);

	int countcomment(int rno);

	int registercomment(CommentDTO comment);

	int deleteComment(HashMap<String, Object> map);

	int commentlikeup(HashMap<String, Object> map);

	int commentlikedown(HashMap<String, Object> map);

	int commenttotallike(int cNo);

	int commenthateup(HashMap<String, Object> map);

	int commenthatedown(HashMap<String, Object> map);

	int commenttotalhate(int cNo);

}
