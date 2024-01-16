package com.Tripsite.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

<<<<<<< HEAD
import com.Tripsite.dto.memberDTO;
=======
import com.Tripsite.dto.MemberDTO;
>>>>>>> ee993b35fdfc7ddc73a8446e54e5638539944f2c
import com.Tripsite.mapper.MemberMapper;

@Service
public class MemberService {
	private MemberMapper mapper;

	public MemberService(MemberMapper mapper) {
		
		this.mapper = mapper;
	}

<<<<<<< HEAD
	public memberDTO login(String mId, String mPass) {
=======
	public MemberDTO login(String mId, String mPass) {
>>>>>>> ee993b35fdfc7ddc73a8446e54e5638539944f2c
	    HashMap<String, Object> map = new HashMap<String, Object>();
	    map.put("mId", mId);
	    map.put("mPass", mPass);
	    return mapper.login(map);
	}
	
	
<<<<<<< HEAD
}
=======
}
>>>>>>> ee993b35fdfc7ddc73a8446e54e5638539944f2c
