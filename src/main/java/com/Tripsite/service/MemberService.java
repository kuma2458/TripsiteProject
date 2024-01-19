package com.Tripsite.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.Tripsite.dto.MemberDTO;
import com.Tripsite.mapper.MemberMapper;

@Service
public class MemberService {
	private MemberMapper mapper;
	
	public MemberService(MemberMapper mapper) {
		this.mapper = mapper;
	}



	public MemberDTO login(String mId, String mPass) {
	    HashMap<String, Object> map = new HashMap<String, Object>();
	    map.put("mId", mId);
	    map.put("mPass", mPass);
	    return mapper.login(map);
	}

	public int deleteMember(String mId) {
		
		return mapper.deleteMember(mId);
	}

	public MemberDTO selectMember(String mId) {
		return mapper.selectMember(mId);
	}

	public int updateMember(MemberDTO dto) {
		return mapper.updateMember(dto);
	}
	
	public void insertMember(MemberDTO dto) {
		mapper.insertMember(dto);
	}

	public MemberDTO find(String mId, String mName) {
		HashMap<String, Object> map = new HashMap<String, Object>();
	    map.put("mId", mId);
	    map.put("mName", mName);
	    return mapper.find(map);
	}
	
	
}
