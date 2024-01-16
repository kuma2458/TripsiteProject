package com.Tripsite.mapper;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.Tripsite.dto.memberDTO;

@Mapper
public interface MemberMapper {

	memberDTO login(HashMap<String, Object> map);

}
