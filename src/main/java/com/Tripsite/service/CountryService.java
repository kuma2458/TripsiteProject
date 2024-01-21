package com.Tripsite.service;

import org.springframework.stereotype.Service;

import com.Tripsite.mapper.CountryMapper;

@Service
public class CountryService {
	
	CountryMapper mapper;

	public CountryService(CountryMapper mapper) {
		this.mapper = mapper;
		
	}

}
