package com.Tripsite.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.Tripsite.dto.memberDTO;
import com.Tripsite.mapper.MemberMapper;

@Service
public class MemberService {
	private MemberMapper mapper;

	public MemberService(MemberMapper mapper) {
		
		this.mapper = mapper;
	}

	public memberDTO login(String mId, String mPass) {
	    HashMap<String, Object> map = new HashMap<String, Object>();
	    map.put("mId", mId);
	    map.put("mPass", mPass);
	    return mapper.login(map);
	}
	
	
}
