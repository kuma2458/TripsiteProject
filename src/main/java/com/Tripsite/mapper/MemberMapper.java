package com.Tripsite.mapper;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.Tripsite.dto.MemberDTO;

@Mapper
public interface MemberMapper {

	MemberDTO login(HashMap<String, Object> map);

	int insertMember(MemberDTO dto);

	MemberDTO find(HashMap<String, Object> map);
	
}
